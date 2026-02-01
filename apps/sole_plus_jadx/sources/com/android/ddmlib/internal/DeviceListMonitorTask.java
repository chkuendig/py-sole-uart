package com.android.ddmlib.internal;

import com.android.ddmlib.AdbHelper;
import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;
import com.android.ddmlib.Log;
import com.android.ddmlib.TimeoutException;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Uninterruptibles;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbBase;
import java.io.IOException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.SocketChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/* loaded from: classes3.dex */
public class DeviceListMonitorTask implements Runnable {
    private static final String ADB_TRACK_DEVICES_COMMAND = "host:track-devices";
    private Stopwatch mAdbDisconnectionStopwatch;
    private final AndroidDebugBridge mBridge;
    private final UpdateListener mListener;
    private volatile boolean mQuit;
    private final byte[] mLengthBuffer = new byte[4];
    private SocketChannel mAdbConnection = null;
    private boolean mMonitoring = false;
    private int mConnectionAttempt = 0;
    private int mRestartAttemptCount = 0;
    private boolean mInitialDeviceListDone = false;

    interface UpdateListener {
        void deviceListUpdate(Map<String, IDevice.DeviceState> devices);

        void initializationError(Exception e);

        void listFetchError(Exception e);
    }

    DeviceListMonitorTask(AndroidDebugBridge bridge, UpdateListener listener) {
        this.mBridge = bridge;
        this.mListener = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        int length;
        do {
            if (this.mAdbConnection == null) {
                Log.d("DeviceMonitor", "Opening adb connection");
                try {
                    this.mAdbConnection = AndroidDebugBridge.openConnection();
                } catch (IOException e) {
                    Log.d("DeviceMonitor", "Unable to open connection to ADB server: " + e);
                }
                if (this.mAdbConnection == null) {
                    int i = this.mConnectionAttempt + 1;
                    this.mConnectionAttempt = i;
                    if (i == 1) {
                        Log.e("DeviceMonitor", "Cannot reach ADB server, attempting to reconnect.");
                        this.mAdbDisconnectionStopwatch = Stopwatch.createStarted();
                        if (AndroidDebugBridge.isUserManagedAdbMode()) {
                            Log.i("DeviceMonitor", "Will not automatically restart the ADB server because ddmlib is in user managed mode");
                        }
                    }
                    if (!AndroidDebugBridge.isUserManagedAdbMode() && this.mConnectionAttempt > 10) {
                        if (!this.mBridge.startAdb(20000L, TimeUnit.MILLISECONDS)) {
                            this.mRestartAttemptCount++;
                        } else {
                            Log.i("DeviceMonitor", "adb restarted");
                            this.mRestartAttemptCount = 0;
                        }
                    }
                    Uninterruptibles.sleepUninterruptibly(1L, TimeUnit.SECONDS);
                } else {
                    if (this.mConnectionAttempt > 0) {
                        Log.i("DeviceMonitor", "ADB connection re-established after " + this.mAdbDisconnectionStopwatch.elapsed(TimeUnit.SECONDS) + " seconds.");
                        this.mAdbDisconnectionStopwatch.reset();
                    } else {
                        Log.i("DeviceMonitor", "Connected to adb for device monitoring");
                    }
                    this.mConnectionAttempt = 0;
                }
            }
            try {
                if (this.mAdbConnection != null && !this.mMonitoring) {
                    this.mMonitoring = sendDeviceListMonitoringRequest();
                }
            } catch (TimeoutException e2) {
                e = e2;
                final UpdateListener updateListener = this.mListener;
                Objects.requireNonNull(updateListener);
                handleExceptionInInitialDeviceListBuilding(e, new Consumer() { // from class: com.android.ddmlib.internal.DeviceListMonitorTask$$ExternalSyntheticLambda0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        updateListener.initializationError((Exception) obj);
                    }
                });
            } catch (AsynchronousCloseException unused) {
            } catch (IOException e3) {
                e = e3;
                final UpdateListener updateListener2 = this.mListener;
                Objects.requireNonNull(updateListener2);
                handleExceptionInInitialDeviceListBuilding(e, new Consumer() { // from class: com.android.ddmlib.internal.DeviceListMonitorTask$$ExternalSyntheticLambda0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        updateListener2.initializationError((Exception) obj);
                    }
                });
            }
            try {
                SocketChannel socketChannel = this.mAdbConnection;
                if (socketChannel != null && this.mMonitoring && (length = AdbSocketUtils.readLength(socketChannel, this.mLengthBuffer)) >= 0) {
                    processIncomingDeviceData(length);
                    this.mInitialDeviceListDone = true;
                }
            } catch (AsynchronousCloseException unused2) {
            } catch (IOException e4) {
                final UpdateListener updateListener3 = this.mListener;
                Objects.requireNonNull(updateListener3);
                handleExceptionInInitialDeviceListBuilding(e4, new Consumer() { // from class: com.android.ddmlib.internal.DeviceListMonitorTask$$ExternalSyntheticLambda1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        updateListener3.listFetchError((Exception) obj);
                    }
                });
            }
        } while (!this.mQuit);
    }

    private boolean sendDeviceListMonitoringRequest() throws IOException, TimeoutException {
        try {
            AdbHelper.write(this.mAdbConnection, AdbHelper.formAdbRequest(ADB_TRACK_DEVICES_COMMAND));
            AdbHelper.AdbResponse adbResponse = AdbHelper.readAdbResponse(this.mAdbConnection, false);
            if (!adbResponse.okay) {
                Log.e("DeviceMonitor", "adb refused request: " + adbResponse.message);
            }
            return adbResponse.okay;
        } catch (IOException e) {
            Log.e("DeviceMonitor", "Sending Tracking request failed!");
            this.mAdbConnection.close();
            throw e;
        }
    }

    private void handleExceptionInInitialDeviceListBuilding(Exception e, Consumer<Exception> errorHandler) {
        if (this.mQuit) {
            return;
        }
        if (e instanceof TimeoutException) {
            Log.e("DeviceMonitor", "Adb connection Error: timeout");
        } else {
            Log.e("DeviceMonitor", "Adb connection Error:" + e.getMessage());
        }
        this.mMonitoring = false;
        SocketChannel socketChannel = this.mAdbConnection;
        if (socketChannel != null) {
            try {
                socketChannel.close();
            } catch (IOException unused) {
            }
            this.mAdbConnection = null;
            errorHandler.accept(e);
        }
    }

    private void processIncomingDeviceData(int length) throws IOException {
        Map<String, IDevice.DeviceState> deviceListResponse;
        if (length <= 0) {
            deviceListResponse = Collections.emptyMap();
        } else {
            deviceListResponse = parseDeviceListResponse(AdbSocketUtils.read(this.mAdbConnection, new byte[length]));
        }
        this.mListener.deviceListUpdate(deviceListResponse);
    }

    public static Map<String, IDevice.DeviceState> parseDeviceListResponse(String result) {
        HashMap mapNewHashMap = Maps.newHashMap();
        for (String str : result == null ? new String[0] : result.split("\n")) {
            String[] strArrSplit = str.split(TlbBase.TAB);
            if (strArrSplit.length == 2) {
                mapNewHashMap.put(strArrSplit[0], IDevice.DeviceState.getState(strArrSplit[1]));
            }
        }
        return mapNewHashMap;
    }

    boolean isMonitoring() {
        return this.mMonitoring;
    }

    boolean hasInitialDeviceList() {
        return this.mInitialDeviceListDone;
    }

    int getConnectionAttemptCount() {
        return this.mConnectionAttempt;
    }

    int getRestartAttemptCount() {
        return this.mRestartAttemptCount;
    }

    public void stop() {
        this.mQuit = true;
        SocketChannel socketChannel = this.mAdbConnection;
        if (socketChannel != null) {
            try {
                socketChannel.close();
            } catch (IOException unused) {
            }
        }
    }
}
