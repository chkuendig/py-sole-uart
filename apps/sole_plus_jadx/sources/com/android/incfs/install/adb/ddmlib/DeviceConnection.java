package com.android.incfs.install.adb.ddmlib;

import com.android.ddmlib.AdbCommandRejectedException;
import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;
import com.android.ddmlib.TimeoutException;
import com.android.incfs.install.IDeviceConnection;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* loaded from: classes3.dex */
public class DeviceConnection implements IDeviceConnection {
    private final SocketChannel mChannel;
    private final Selector mReadSelector;
    private final Selector mWriteSelector;

    public static Factory getFactory(String deviceSerialNumber) throws IOException {
        AndroidDebugBridge bridge = AndroidDebugBridge.getBridge();
        if (bridge == null) {
            throw new IOException("Unable to connect to adb");
        }
        for (IDevice iDevice : bridge.getDevices()) {
            if (deviceSerialNumber.equals(iDevice.getSerialNumber())) {
                return new Factory(iDevice);
            }
        }
        throw new IOException("Failed to find device with serial \"" + deviceSerialNumber + "\"");
    }

    public static class Factory implements IDeviceConnection.Factory {
        private final IDevice mDevice;

        private Factory(IDevice device) {
            this.mDevice = device;
        }

        @Override // com.android.incfs.install.IDeviceConnection.Factory
        public IDeviceConnection connectToService(String service, String[] parameters) throws IOException {
            try {
                SocketChannel socketChannelRawBinder = this.mDevice.rawBinder(service, parameters);
                socketChannelRawBinder.configureBlocking(false);
                return new DeviceConnection(socketChannelRawBinder);
            } catch (AdbCommandRejectedException | TimeoutException e) {
                throw new IOException(String.format("Failed invoking binder command \"%s %s\"", service, String.join(" ", parameters)), e);
            }
        }
    }

    private DeviceConnection(SocketChannel channel) throws IOException {
        this.mChannel = channel;
        channel.configureBlocking(false);
        Selector selectorOpen = Selector.open();
        this.mReadSelector = selectorOpen;
        channel.register(selectorOpen, 1);
        Selector selectorOpen2 = Selector.open();
        this.mWriteSelector = selectorOpen2;
        channel.register(selectorOpen2, 4);
    }

    @Override // com.android.incfs.install.IDeviceConnection
    public int read(ByteBuffer dst, long timeoutMs) throws IOException {
        this.mReadSelector.select(timeoutMs);
        return this.mChannel.read(dst);
    }

    @Override // com.android.incfs.install.IDeviceConnection
    public int write(ByteBuffer src, long timeoutMs) throws IOException {
        this.mWriteSelector.select(timeoutMs);
        return this.mChannel.write(src);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        SocketChannel socketChannel = this.mChannel;
        try {
            Selector selector = this.mReadSelector;
            try {
                Selector selector2 = this.mWriteSelector;
                if (selector2 != null) {
                    selector2.close();
                }
                if (selector != null) {
                    selector.close();
                }
                if (socketChannel != null) {
                    socketChannel.close();
                }
            } finally {
            }
        } catch (Throwable th) {
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
