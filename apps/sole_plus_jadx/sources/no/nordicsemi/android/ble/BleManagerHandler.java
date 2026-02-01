package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingDeque;
import no.nordicsemi.android.ble.BleManagerHandler;
import no.nordicsemi.android.ble.Request;
import no.nordicsemi.android.ble.callback.ConnectionParametersUpdatedCallback;
import no.nordicsemi.android.ble.callback.DataReceivedCallback;
import no.nordicsemi.android.ble.data.Data;
import no.nordicsemi.android.ble.data.DataProvider;
import no.nordicsemi.android.ble.error.GattError;
import no.nordicsemi.android.ble.observer.BondingObserver;
import no.nordicsemi.android.ble.observer.ConnectionObserver;
import no.nordicsemi.android.ble.utils.ParserUtils;

/* loaded from: classes6.dex */
abstract class BleManagerHandler extends RequestHandler {
    private static final long CONNECTION_TIMEOUT_THRESHOLD = 20000;
    private static final String ERROR_AUTH_ERROR_WHILE_BONDED = "Phone has lost bonding information";
    private static final String ERROR_CONNECTION_PRIORITY_REQUEST = "Error on connection priority request";
    private static final String ERROR_CONNECTION_STATE_CHANGE = "Error on connection state change";
    private static final String ERROR_DISCOVERY_SERVICE = "Error on discovering services";
    private static final String ERROR_MTU_REQUEST = "Error on mtu request";
    private static final String ERROR_NOTIFY = "Error on sending notification/indication";
    private static final String ERROR_PHY_UPDATE = "Error on PHY update";
    private static final String ERROR_READ_CHARACTERISTIC = "Error on reading characteristic";
    private static final String ERROR_READ_DESCRIPTOR = "Error on reading descriptor";
    private static final String ERROR_READ_PHY = "Error on PHY read";
    private static final String ERROR_READ_RSSI = "Error on RSSI read";
    private static final String ERROR_RELIABLE_WRITE = "Error on Execute Reliable Write";
    private static final String ERROR_WRITE_CHARACTERISTIC = "Error on writing characteristic";
    private static final String ERROR_WRITE_DESCRIPTOR = "Error on writing descriptor";
    private static final String TAG = "BleManager";
    private AwaitingRequest<?> awaitingRequest;

    @Deprecated
    private ValueChangedCallback batteryLevelNotificationCallback;
    private BluetoothDevice bluetoothDevice;
    BluetoothGatt bluetoothGatt;
    private Map<BluetoothGattCharacteristic, byte[]> characteristicValues;
    private ConnectRequest connectRequest;
    private boolean connected;
    private ConnectionParametersUpdatedCallback connectionParametersUpdatedCallback;
    private long connectionTime;
    private Map<BluetoothGattDescriptor, byte[]> descriptorValues;
    private boolean deviceNotSupported;
    private Handler handler;
    private Deque<Request> initQueue;
    private boolean initialConnection;
    private boolean initialization;
    private int interval;
    private int latency;
    private BleManager manager;
    private boolean operationInProgress;
    private int prepareError;
    private Deque<Pair<Object, byte[]>> preparedValues;
    private boolean ready;
    private boolean reliableWriteInProgress;
    private Request request;
    private RequestQueue requestQueue;
    private BleServerManager serverManager;
    private boolean serviceDiscoveryRequested;
    private boolean servicesDiscovered;
    private int timeout;
    private boolean userDisconnected;
    private final Object LOCK = new Object();
    private final Deque<Request> taskQueue = new LinkedBlockingDeque();
    private int connectionCount = 0;
    private int connectionState = 0;
    private boolean connectionPriorityOperationInProgress = false;
    private int mtu = 23;

    @Deprecated
    private int batteryValue = -1;
    private final HashMap<Object, ValueChangedCallback> valueChangedCallbacks = new HashMap<>();
    private final HashMap<Object, DataProvider> dataProviders = new HashMap<>();
    private final BroadcastReceiver bluetoothStateBroadcastReceiver = new AnonymousClass1();
    private final BroadcastReceiver mBondingBroadcastReceiver = new AnonymousClass2();
    private final BluetoothGattCallback gattCallback = new AnonymousClass4();

    /* JADX INFO: Access modifiers changed from: private */
    interface BondingObserverRunnable {
        void run(BondingObserver bondingObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    interface CallbackRunnable {
        void run(BleManagerCallbacks bleManagerCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface ConnectionObserverRunnable {
        void run(ConnectionObserver connectionObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @FunctionalInterface
    interface Loggable {
        String log();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mapDisconnectStatusToReason(int i) {
        if (i == 0 || i == 8) {
            return 10;
        }
        if (i != 19) {
            return i != 22 ? -1 : 1;
        }
        return 2;
    }

    @Deprecated
    protected Deque<Request> initGatt(BluetoothGatt bluetoothGatt) {
        return null;
    }

    @Deprecated
    protected void initialize() {
    }

    @Deprecated
    protected boolean isOptionalServiceSupported(BluetoothGatt bluetoothGatt) {
        return false;
    }

    @Deprecated
    protected abstract boolean isRequiredServiceSupported(BluetoothGatt bluetoothGatt);

    @Deprecated
    protected void onBatteryValueReceived(BluetoothGatt bluetoothGatt, int i) {
    }

    @Deprecated
    protected void onCharacteristicIndicated(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    @Deprecated
    protected void onCharacteristicNotified(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    @Deprecated
    protected void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    @Deprecated
    protected void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    @Deprecated
    protected void onConnectionUpdated(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
    }

    @Deprecated
    protected void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor) {
    }

    @Deprecated
    protected void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor) {
    }

    @Deprecated
    protected void onDeviceDisconnected() {
    }

    @Deprecated
    protected void onDeviceReady() {
    }

    @Deprecated
    protected void onManagerReady() {
    }

    @Deprecated
    protected void onMtuChanged(BluetoothGatt bluetoothGatt, int i) {
    }

    @Deprecated
    protected void onServerReady(BluetoothGattServer bluetoothGattServer) {
    }

    @Deprecated
    protected abstract void onServicesInvalidated();

    BleManagerHandler() {
    }

    /* renamed from: no.nordicsemi.android.ble.BleManagerHandler$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            final int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
            int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
            BleManagerHandler.this.log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$1$$ExternalSyntheticLambda0
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return this.f$0.lambda$onReceive$0(intExtra);
                }
            });
            if (intExtra == 10 || intExtra == 13) {
                if (intExtra2 != 13 && intExtra2 != 10) {
                    BleManagerHandler.this.operationInProgress = true;
                    BleManagerHandler.this.taskQueue.clear();
                    BleManagerHandler.this.initQueue = null;
                    BleManagerHandler.this.ready = false;
                    BluetoothDevice bluetoothDevice = BleManagerHandler.this.bluetoothDevice;
                    if (bluetoothDevice != null) {
                        if (BleManagerHandler.this.request != null && BleManagerHandler.this.request.type != Request.Type.DISCONNECT) {
                            BleManagerHandler.this.request.notifyFail(bluetoothDevice, -100);
                            BleManagerHandler.this.request = null;
                        }
                        if (BleManagerHandler.this.awaitingRequest != null) {
                            BleManagerHandler.this.awaitingRequest.notifyFail(bluetoothDevice, -100);
                            BleManagerHandler.this.awaitingRequest = null;
                        }
                        if (BleManagerHandler.this.connectRequest != null) {
                            BleManagerHandler.this.connectRequest.notifyFail(bluetoothDevice, -100);
                            BleManagerHandler.this.connectRequest = null;
                        }
                    }
                    BleManagerHandler.this.userDisconnected = true;
                    BleManagerHandler.this.operationInProgress = false;
                    if (bluetoothDevice != null) {
                        BleManagerHandler.this.notifyDeviceDisconnected(bluetoothDevice, 1);
                    }
                    BleManagerHandler.this.connected = false;
                    BleManagerHandler.this.connectionState = 0;
                    return;
                }
                BleManagerHandler.this.close();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String lambda$onReceive$0(int i) {
            return "[Broadcast] Action received: android.bluetooth.adapter.action.STATE_CHANGED, state changed to " + state2String(i);
        }

        private String state2String(int i) {
            switch (i) {
                case 10:
                    return "OFF";
                case 11:
                    return "TURNING ON";
                case 12:
                    return "ON";
                case 13:
                    return "TURNING OFF";
                default:
                    return "UNKNOWN (" + i + ")";
            }
        }
    }

    /* renamed from: no.nordicsemi.android.ble.BleManagerHandler$2, reason: invalid class name */
    class AnonymousClass2 extends BroadcastReceiver {
        AnonymousClass2() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BluetoothGatt bluetoothGatt;
            final BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            final int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
            int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", -1);
            if (BleManagerHandler.this.bluetoothDevice == null || bluetoothDevice == null || !bluetoothDevice.getAddress().equals(BleManagerHandler.this.bluetoothDevice.getAddress())) {
                return;
            }
            BleManagerHandler.this.log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda0
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.AnonymousClass2.lambda$onReceive$0(intExtra);
                }
            });
            switch (intExtra) {
                case 10:
                    if (intExtra2 != 11) {
                        if (intExtra2 == 12) {
                            BleManagerHandler.this.userDisconnected = true;
                            if (BleManagerHandler.this.request != null && BleManagerHandler.this.request.type == Request.Type.REMOVE_BOND) {
                                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda1
                                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                                    public final String log() {
                                        return BleManagerHandler.AnonymousClass2.lambda$onReceive$6();
                                    }
                                });
                                BleManagerHandler.this.request.notifySuccess(bluetoothDevice);
                                BleManagerHandler.this.request = null;
                            }
                            if (!BleManagerHandler.this.isConnected()) {
                                BleManagerHandler.this.close();
                                break;
                            }
                        }
                    } else {
                        BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda9
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                            public final void run(BleManagerCallbacks bleManagerCallbacks) {
                                bleManagerCallbacks.onBondingFailed(bluetoothDevice);
                            }
                        });
                        BleManagerHandler.this.postBondingStateChange(new BondingObserverRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda10
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.BondingObserverRunnable
                            public final void run(BondingObserver bondingObserver) {
                                bondingObserver.onBondingFailed(bluetoothDevice);
                            }
                        });
                        BleManagerHandler.this.log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda11
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                            public final String log() {
                                return BleManagerHandler.AnonymousClass2.lambda$onReceive$3();
                            }
                        });
                        if (BleManagerHandler.this.request != null && BleManagerHandler.this.request.type == Request.Type.CREATE_BOND) {
                            BleManagerHandler.this.request.notifyFail(bluetoothDevice, -4);
                            BleManagerHandler.this.request = null;
                        }
                        if (!BleManagerHandler.this.servicesDiscovered && !BleManagerHandler.this.serviceDiscoveryRequested) {
                            BluetoothGatt bluetoothGatt2 = BleManagerHandler.this.bluetoothGatt;
                            if (bluetoothGatt2 != null) {
                                BleManagerHandler.this.serviceDiscoveryRequested = true;
                                BleManagerHandler.this.log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda12
                                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                                    public final String log() {
                                        return BleManagerHandler.AnonymousClass2.lambda$onReceive$4();
                                    }
                                });
                                BleManagerHandler.this.log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda13
                                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                                    public final String log() {
                                        return BleManagerHandler.AnonymousClass2.lambda$onReceive$5();
                                    }
                                });
                                bluetoothGatt2.discoverServices();
                                return;
                            }
                            return;
                        }
                    }
                    break;
                case 11:
                    BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda2
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                        public final void run(BleManagerCallbacks bleManagerCallbacks) {
                            bleManagerCallbacks.onBondingRequired(bluetoothDevice);
                        }
                    });
                    BleManagerHandler.this.postBondingStateChange(new BondingObserverRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda3
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.BondingObserverRunnable
                        public final void run(BondingObserver bondingObserver) {
                            bondingObserver.onBondingRequired(bluetoothDevice);
                        }
                    });
                    return;
                case 12:
                    BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda4
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.AnonymousClass2.lambda$onReceive$9();
                        }
                    });
                    BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda5
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                        public final void run(BleManagerCallbacks bleManagerCallbacks) {
                            bleManagerCallbacks.onBonded(bluetoothDevice);
                        }
                    });
                    BleManagerHandler.this.postBondingStateChange(new BondingObserverRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda6
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.BondingObserverRunnable
                        public final void run(BondingObserver bondingObserver) {
                            bondingObserver.onBonded(bluetoothDevice);
                        }
                    });
                    if (BleManagerHandler.this.request != null && BleManagerHandler.this.request.type == Request.Type.CREATE_BOND) {
                        BleManagerHandler.this.request.notifySuccess(bluetoothDevice);
                        BleManagerHandler.this.request = null;
                        break;
                    } else {
                        if (BleManagerHandler.this.servicesDiscovered || BleManagerHandler.this.serviceDiscoveryRequested || (bluetoothGatt = BleManagerHandler.this.bluetoothGatt) == null) {
                            return;
                        }
                        BleManagerHandler.this.serviceDiscoveryRequested = true;
                        BleManagerHandler.this.log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda7
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                            public final String log() {
                                return BleManagerHandler.AnonymousClass2.lambda$onReceive$12();
                            }
                        });
                        BleManagerHandler.this.log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$2$$ExternalSyntheticLambda8
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                            public final String log() {
                                return BleManagerHandler.AnonymousClass2.lambda$onReceive$13();
                            }
                        });
                        bluetoothGatt.discoverServices();
                        return;
                    }
                    break;
            }
            BleManagerHandler.this.nextRequest(true);
        }

        static /* synthetic */ String lambda$onReceive$0(int i) {
            return "[Broadcast] Action received: android.bluetooth.device.action.BOND_STATE_CHANGED, bond state changed to: " + ParserUtils.bondStateToString(i) + " (" + i + ")";
        }

        static /* synthetic */ String lambda$onReceive$3() {
            return "Bonding failed";
        }

        static /* synthetic */ String lambda$onReceive$4() {
            return "Discovering services...";
        }

        static /* synthetic */ String lambda$onReceive$5() {
            return "gatt.discoverServices()";
        }

        static /* synthetic */ String lambda$onReceive$6() {
            return "Bond information removed";
        }

        static /* synthetic */ String lambda$onReceive$9() {
            return "Device bonded";
        }

        static /* synthetic */ String lambda$onReceive$12() {
            return "Discovering services...";
        }

        static /* synthetic */ String lambda$onReceive$13() {
            return "gatt.discoverServices()";
        }
    }

    void init(BleManager bleManager, Handler handler) {
        this.manager = bleManager;
        this.handler = handler;
    }

    void useServer(BleServerManager bleServerManager) {
        this.serverManager = bleServerManager;
    }

    void attachClientConnection(BluetoothDevice bluetoothDevice) {
        BleServerManager bleServerManager = this.serverManager;
        if (bleServerManager == null) {
            log(6, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda99
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$attachClientConnection$0();
                }
            });
            return;
        }
        if (this.bluetoothDevice != null) {
            log(6, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda100
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$attachClientConnection$1();
                }
            });
            return;
        }
        this.bluetoothDevice = bluetoothDevice;
        this.connectionState = 2;
        this.connected = true;
        initializeServerAttributes();
        bleServerManager.useConnection(bluetoothDevice, false);
        this.manager.initialize();
    }

    static /* synthetic */ String lambda$attachClientConnection$0() {
        return "Server not bound to the manager";
    }

    static /* synthetic */ String lambda$attachClientConnection$1() {
        return "attachClientConnection called on existing connection, call ignored";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeServerAttributes() {
        BluetoothGattServer server;
        BleServerManager bleServerManager = this.serverManager;
        if (bleServerManager == null || (server = bleServerManager.getServer()) == null) {
            return;
        }
        Iterator<BluetoothGattService> it = server.getServices().iterator();
        while (it.hasNext()) {
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : it.next().getCharacteristics()) {
                if (!bleServerManager.isShared(bluetoothGattCharacteristic)) {
                    if (this.characteristicValues == null) {
                        this.characteristicValues = new HashMap();
                    }
                    this.characteristicValues.put(bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
                }
                for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                    if (!bleServerManager.isShared(bluetoothGattDescriptor)) {
                        if (this.descriptorValues == null) {
                            this.descriptorValues = new HashMap();
                        }
                        this.descriptorValues.put(bluetoothGattDescriptor, bluetoothGattDescriptor.getValue());
                    }
                }
            }
        }
        this.manager.onServerReady(server);
    }

    void close() {
        try {
            Context context = this.manager.getContext();
            context.unregisterReceiver(this.bluetoothStateBroadcastReceiver);
            context.unregisterReceiver(this.mBondingBroadcastReceiver);
        } catch (Exception unused) {
        }
        synchronized (this.LOCK) {
            boolean z = this.connected;
            final BluetoothDevice bluetoothDevice = this.bluetoothDevice;
            if (this.bluetoothGatt != null) {
                if (this.manager.shouldClearCacheWhenDisconnected()) {
                    if (internalRefreshDeviceCache()) {
                        log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda114
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                            public final String log() {
                                return BleManagerHandler.lambda$close$2();
                            }
                        });
                    } else {
                        log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda115
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                            public final String log() {
                                return BleManagerHandler.lambda$close$3();
                            }
                        });
                    }
                }
                log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda117
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.lambda$close$4();
                    }
                });
                try {
                    this.bluetoothGatt.close();
                } catch (Throwable unused2) {
                }
                this.bluetoothGatt = null;
            }
            this.reliableWriteInProgress = false;
            this.initialConnection = false;
            this.taskQueue.clear();
            this.initQueue = null;
            this.initialization = false;
            this.bluetoothDevice = null;
            this.connected = false;
            this.connectionState = 0;
            this.mtu = 23;
            this.timeout = 0;
            this.latency = 0;
            this.interval = 0;
            if (z && bluetoothDevice != null) {
                postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda118
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                    public final void run(BleManagerCallbacks bleManagerCallbacks) {
                        bleManagerCallbacks.onDeviceDisconnected(bluetoothDevice);
                    }
                });
                postConnectionStateChange(new ConnectionObserverRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda119
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.ConnectionObserverRunnable
                    public final void run(ConnectionObserver connectionObserver) {
                        connectionObserver.onDeviceDisconnected(bluetoothDevice, 0);
                    }
                });
            }
        }
    }

    static /* synthetic */ String lambda$close$2() {
        return "Cache refreshed";
    }

    static /* synthetic */ String lambda$close$3() {
        return "Refreshing failed";
    }

    static /* synthetic */ String lambda$close$4() {
        return "gatt.close()";
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.bluetoothDevice;
    }

    public final byte[] getCharacteristicValue(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Map<BluetoothGattCharacteristic, byte[]> map = this.characteristicValues;
        if (map != null && map.containsKey(bluetoothGattCharacteristic)) {
            return this.characteristicValues.get(bluetoothGattCharacteristic);
        }
        return bluetoothGattCharacteristic.getValue();
    }

    public final byte[] getDescriptorValue(BluetoothGattDescriptor bluetoothGattDescriptor) {
        Map<BluetoothGattDescriptor, byte[]> map = this.descriptorValues;
        if (map != null && map.containsKey(bluetoothGattDescriptor)) {
            return this.descriptorValues.get(bluetoothGattDescriptor);
        }
        return bluetoothGattDescriptor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if (r13.finished != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean internalConnect(final android.bluetooth.BluetoothDevice r12, final no.nordicsemi.android.ble.ConnectRequest r13) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.ble.BleManagerHandler.internalConnect(android.bluetooth.BluetoothDevice, no.nordicsemi.android.ble.ConnectRequest):boolean");
    }

    static /* synthetic */ String lambda$internalConnect$7() {
        return "gatt.close()";
    }

    static /* synthetic */ String lambda$internalConnect$8() {
        return "wait(200)";
    }

    static /* synthetic */ String lambda$internalConnect$9() {
        return "Connecting...";
    }

    static /* synthetic */ String lambda$internalConnect$12(int i) {
        return "gatt = device.connectGatt(autoConnect = true, TRANSPORT_LE, " + ParserUtils.phyMaskToString(i) + ")";
    }

    static /* synthetic */ String lambda$internalConnect$13() {
        return "gatt.connect()";
    }

    static /* synthetic */ String lambda$internalConnect$14(ConnectRequest connectRequest) {
        return connectRequest.isFirstAttempt() ? "Connecting..." : "Retrying...";
    }

    static /* synthetic */ String lambda$internalConnect$17(int i) {
        return "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE, " + ParserUtils.phyMaskToString(i) + ")";
    }

    static /* synthetic */ String lambda$internalConnect$18(int i) {
        return "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE, " + ParserUtils.phyMaskToString(i) + ")";
    }

    static /* synthetic */ String lambda$internalConnect$19() {
        return "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE)";
    }

    static /* synthetic */ String lambda$internalConnect$20() {
        return "gatt = device.connectGatt(autoConnect = false)";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean internalDisconnect(final int i) {
        this.userDisconnected = true;
        this.initialConnection = false;
        this.ready = false;
        BleServerManager bleServerManager = this.serverManager;
        BluetoothDevice device = this.bluetoothDevice;
        if (bleServerManager != null && device != null) {
            log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda73
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalDisconnect$21();
                }
            });
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda74
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalDisconnect$22();
                }
            });
            bleServerManager.cancelConnection(device);
        }
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt != null) {
            final boolean z = this.connected;
            this.connectionState = 3;
            log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda75
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalDisconnect$23(z);
                }
            });
            final BluetoothDevice device2 = bluetoothGatt.getDevice();
            if (z) {
                postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda76
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                    public final void run(BleManagerCallbacks bleManagerCallbacks) {
                        bleManagerCallbacks.onDeviceDisconnecting(device2);
                    }
                });
                postConnectionStateChange(new ConnectionObserverRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda77
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.ConnectionObserverRunnable
                    public final void run(ConnectionObserver connectionObserver) {
                        connectionObserver.onDeviceDisconnecting(device2);
                    }
                });
            }
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda78
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalDisconnect$26();
                }
            });
            bluetoothGatt.disconnect();
            if (z) {
                return true;
            }
            this.connectionState = 0;
            log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda79
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalDisconnect$27();
                }
            });
            close();
            postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda80
                @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                public final void run(BleManagerCallbacks bleManagerCallbacks) {
                    bleManagerCallbacks.onDeviceDisconnected(device2);
                }
            });
            postConnectionStateChange(new ConnectionObserverRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda81
                @Override // no.nordicsemi.android.ble.BleManagerHandler.ConnectionObserverRunnable
                public final void run(ConnectionObserver connectionObserver) {
                    connectionObserver.onDeviceDisconnected(device2, i);
                }
            });
        }
        Request request = this.request;
        if (request != null && request.type == Request.Type.DISCONNECT) {
            if (device == null && bluetoothGatt == null) {
                request.notifyInvalidRequest();
            } else {
                if (device == null) {
                    device = bluetoothGatt.getDevice();
                }
                request.notifySuccess(device);
            }
        }
        nextRequest(true);
        return true;
    }

    static /* synthetic */ String lambda$internalDisconnect$21() {
        return "Cancelling server connection...";
    }

    static /* synthetic */ String lambda$internalDisconnect$22() {
        return "server.cancelConnection(device)";
    }

    static /* synthetic */ String lambda$internalDisconnect$23(boolean z) {
        return z ? "Disconnecting..." : "Cancelling connection...";
    }

    static /* synthetic */ String lambda$internalDisconnect$26() {
        return "gatt.disconnect()";
    }

    static /* synthetic */ String lambda$internalDisconnect$27() {
        return "Disconnected";
    }

    private boolean internalCreateBond(boolean z) {
        BluetoothDevice bluetoothDevice = this.bluetoothDevice;
        if (bluetoothDevice == null) {
            return false;
        }
        if (z) {
            log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda147
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalCreateBond$30();
                }
            });
        } else {
            log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda148
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalCreateBond$31();
                }
            });
        }
        if (!z && bluetoothDevice.getBondState() == 12) {
            log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda1
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalCreateBond$32();
                }
            });
            this.request.notifySuccess(bluetoothDevice);
            nextRequest(true);
            return true;
        }
        boolean zCreateBond = createBond(bluetoothDevice);
        if (!z || zCreateBond) {
            return zCreateBond;
        }
        Request requestHandler = Request.createBond().setRequestHandler(this);
        requestHandler.successCallback = this.request.successCallback;
        requestHandler.invalidRequestCallback = this.request.invalidRequestCallback;
        requestHandler.failCallback = this.request.failCallback;
        requestHandler.internalSuccessCallback = this.request.internalSuccessCallback;
        requestHandler.internalFailCallback = this.request.internalFailCallback;
        this.request.successCallback = null;
        this.request.invalidRequestCallback = null;
        this.request.failCallback = null;
        this.request.internalSuccessCallback = null;
        this.request.internalFailCallback = null;
        enqueueFirst(requestHandler);
        enqueueFirst(Request.removeBond().setRequestHandler(this));
        nextRequest(true);
        return true;
    }

    static /* synthetic */ String lambda$internalCreateBond$30() {
        return "Ensuring bonding...";
    }

    static /* synthetic */ String lambda$internalCreateBond$31() {
        return "Starting bonding...";
    }

    static /* synthetic */ String lambda$internalCreateBond$32() {
        return "Bond information present on client, skipping bonding";
    }

    private boolean createBond(BluetoothDevice bluetoothDevice) {
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda37
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$createBond$33();
            }
        });
        return bluetoothDevice.createBond();
    }

    static /* synthetic */ String lambda$createBond$33() {
        return "device.createBond()";
    }

    static /* synthetic */ String lambda$createBond$34() {
        return "device.createBond() (hidden)";
    }

    private boolean internalRemoveBond() throws NoSuchMethodException, SecurityException {
        BluetoothDevice bluetoothDevice = this.bluetoothDevice;
        if (bluetoothDevice == null) {
            return false;
        }
        log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda105
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalRemoveBond$35();
            }
        });
        if (bluetoothDevice.getBondState() == 10) {
            log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda116
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalRemoveBond$36();
                }
            });
            this.request.notifySuccess(bluetoothDevice);
            nextRequest(true);
            return true;
        }
        try {
            Method method = bluetoothDevice.getClass().getMethod("removeBond", new Class[0]);
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda127
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalRemoveBond$37();
                }
            });
            this.userDisconnected = true;
            return method.invoke(bluetoothDevice, new Object[0]) == Boolean.TRUE;
        } catch (Exception e) {
            Log.w(TAG, "An exception occurred while removing bond", e);
            return false;
        }
    }

    static /* synthetic */ String lambda$internalRemoveBond$35() {
        return "Removing bond information...";
    }

    static /* synthetic */ String lambda$internalRemoveBond$36() {
        return "Device is not bonded";
    }

    static /* synthetic */ String lambda$internalRemoveBond$37() {
        return "device.removeBond() (hidden)";
    }

    private boolean ensureServiceChangedEnabled() {
        BluetoothGattService service;
        BluetoothGattCharacteristic characteristic;
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null || !this.connected || bluetoothGatt.getDevice().getBondState() != 12 || (service = bluetoothGatt.getService(BleManager.GENERIC_ATTRIBUTE_SERVICE)) == null || (characteristic = service.getCharacteristic(BleManager.SERVICE_CHANGED_CHARACTERISTIC)) == null) {
            return false;
        }
        log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda106
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$ensureServiceChangedEnabled$38();
            }
        });
        return internalEnableIndications(characteristic);
    }

    static /* synthetic */ String lambda$ensureServiceChangedEnabled$38() {
        return "Service Changed characteristic found on a bonded device";
    }

    private boolean internalEnableNotifications(final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattDescriptor cccd;
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt != null && bluetoothGattCharacteristic != null && this.connected && (cccd = getCccd(bluetoothGattCharacteristic, 16)) != null) {
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda15
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalEnableNotifications$39(bluetoothGattCharacteristic);
                }
            });
            try {
                bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda16
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.lambda$internalEnableNotifications$40(bluetoothGattCharacteristic);
                    }
                });
                try {
                    if (Build.VERSION.SDK_INT >= 33) {
                        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda17
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                            public final String log() {
                                return BleManagerHandler.lambda$internalEnableNotifications$41();
                            }
                        });
                        return bluetoothGatt.writeDescriptor(cccd, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) == 0;
                    }
                    log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda18
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.lambda$internalEnableNotifications$42();
                        }
                    });
                    cccd.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                    log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda19
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.lambda$internalEnableNotifications$43();
                        }
                    });
                    return bluetoothGatt.writeDescriptor(cccd);
                } catch (SecurityException e) {
                    Objects.requireNonNull(e);
                    log(6, new BleManagerHandler$$ExternalSyntheticLambda72(e));
                    return false;
                }
            } catch (SecurityException e2) {
                Objects.requireNonNull(e2);
                log(6, new BleManagerHandler$$ExternalSyntheticLambda72(e2));
            }
        }
        return false;
    }

    static /* synthetic */ String lambda$internalEnableNotifications$39(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return "gatt.setCharacteristicNotification(" + bluetoothGattCharacteristic.getUuid() + ", true)";
    }

    static /* synthetic */ String lambda$internalEnableNotifications$40(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return "Enabling notifications for " + bluetoothGattCharacteristic.getUuid();
    }

    static /* synthetic */ String lambda$internalEnableNotifications$41() {
        return "gatt.writeDescriptor(00002902-0000-1000-8000-00805f9b34fb, value=0x01-00)";
    }

    static /* synthetic */ String lambda$internalEnableNotifications$42() {
        return "descriptor.setValue(0x01-00)";
    }

    static /* synthetic */ String lambda$internalEnableNotifications$43() {
        return "gatt.writeDescriptor(00002902-0000-1000-8000-00805f9b34fb)";
    }

    private boolean internalDisableNotifications(final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattDescriptor cccd;
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt != null && bluetoothGattCharacteristic != null && this.connected && (cccd = getCccd(bluetoothGattCharacteristic, 48)) != null) {
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda24
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalDisableNotifications$44(bluetoothGattCharacteristic);
                }
            });
            try {
                bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, false);
                log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda25
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.lambda$internalDisableNotifications$45(bluetoothGattCharacteristic);
                    }
                });
                try {
                    if (Build.VERSION.SDK_INT >= 33) {
                        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda26
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                            public final String log() {
                                return BleManagerHandler.lambda$internalDisableNotifications$46();
                            }
                        });
                        return bluetoothGatt.writeDescriptor(cccd, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE) == 0;
                    }
                    log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda27
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.lambda$internalDisableNotifications$47();
                        }
                    });
                    cccd.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                    log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda28
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.lambda$internalDisableNotifications$48();
                        }
                    });
                    return bluetoothGatt.writeDescriptor(cccd);
                } catch (SecurityException e) {
                    Objects.requireNonNull(e);
                    log(6, new BleManagerHandler$$ExternalSyntheticLambda72(e));
                    return false;
                }
            } catch (SecurityException e2) {
                Objects.requireNonNull(e2);
                log(6, new BleManagerHandler$$ExternalSyntheticLambda72(e2));
            }
        }
        return false;
    }

    static /* synthetic */ String lambda$internalDisableNotifications$44(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return "gatt.setCharacteristicNotification(" + bluetoothGattCharacteristic.getUuid() + ", false)";
    }

    static /* synthetic */ String lambda$internalDisableNotifications$45(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return "Disabling notifications and indications for " + bluetoothGattCharacteristic.getUuid();
    }

    static /* synthetic */ String lambda$internalDisableNotifications$46() {
        return "gatt.writeDescriptor(00002902-0000-1000-8000-00805f9b34fb, value=0x00-00)";
    }

    static /* synthetic */ String lambda$internalDisableNotifications$47() {
        return "descriptor.setValue(0x00-00)";
    }

    static /* synthetic */ String lambda$internalDisableNotifications$48() {
        return "gatt.writeDescriptor(00002902-0000-1000-8000-00805f9b34fb)";
    }

    private boolean internalEnableIndications(final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattDescriptor cccd;
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt != null && bluetoothGattCharacteristic != null && this.connected && (cccd = getCccd(bluetoothGattCharacteristic, 32)) != null) {
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda64
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalEnableIndications$49(bluetoothGattCharacteristic);
                }
            });
            try {
                bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda65
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.lambda$internalEnableIndications$50(bluetoothGattCharacteristic);
                    }
                });
                try {
                    if (Build.VERSION.SDK_INT >= 33) {
                        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda66
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                            public final String log() {
                                return BleManagerHandler.lambda$internalEnableIndications$51();
                            }
                        });
                        return bluetoothGatt.writeDescriptor(cccd, BluetoothGattDescriptor.ENABLE_INDICATION_VALUE) == 0;
                    }
                    log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda67
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.lambda$internalEnableIndications$52();
                        }
                    });
                    cccd.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
                    log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda68
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.lambda$internalEnableIndications$53();
                        }
                    });
                    return bluetoothGatt.writeDescriptor(cccd);
                } catch (SecurityException e) {
                    Objects.requireNonNull(e);
                    log(6, new BleManagerHandler$$ExternalSyntheticLambda72(e));
                    return false;
                }
            } catch (SecurityException e2) {
                Objects.requireNonNull(e2);
                log(6, new BleManagerHandler$$ExternalSyntheticLambda72(e2));
            }
        }
        return false;
    }

    static /* synthetic */ String lambda$internalEnableIndications$49(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return "gatt.setCharacteristicNotification(" + bluetoothGattCharacteristic.getUuid() + ", true)";
    }

    static /* synthetic */ String lambda$internalEnableIndications$50(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return "Enabling indications for " + bluetoothGattCharacteristic.getUuid();
    }

    static /* synthetic */ String lambda$internalEnableIndications$51() {
        return "gatt.writeDescriptor(00002902-0000-1000-8000-00805f9b34fb, value=0x02-00)";
    }

    static /* synthetic */ String lambda$internalEnableIndications$52() {
        return "descriptor.setValue(0x02-00)";
    }

    static /* synthetic */ String lambda$internalEnableIndications$53() {
        return "gatt.writeDescriptor(00002902-0000-1000-8000-00805f9b34fb)";
    }

    private boolean internalDisableIndications(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return internalDisableNotifications(bluetoothGattCharacteristic);
    }

    private boolean internalSendNotification(final BluetoothGattCharacteristic bluetoothGattCharacteristic, final boolean z, final byte[] bArr) {
        BluetoothGattDescriptor descriptor;
        BleServerManager bleServerManager = this.serverManager;
        if (bleServerManager == null || bleServerManager.getServer() == null || bluetoothGattCharacteristic == null) {
            return false;
        }
        if (((z ? 32 : 16) & bluetoothGattCharacteristic.getProperties()) == 0 || (descriptor = bluetoothGattCharacteristic.getDescriptor(BleManager.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID)) == null) {
            return false;
        }
        Map<BluetoothGattDescriptor, byte[]> map = this.descriptorValues;
        byte[] value = (map == null || !map.containsKey(descriptor)) ? descriptor.getValue() : this.descriptorValues.get(descriptor);
        if (value != null && value.length == 2 && value[0] != 0) {
            log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda10
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalSendNotification$54(z, bluetoothGattCharacteristic);
                }
            });
            if (Build.VERSION.SDK_INT >= 33) {
                log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda12
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.lambda$internalSendNotification$55(bluetoothGattCharacteristic, z, bArr);
                    }
                });
                BluetoothGattServer server = this.serverManager.getServer();
                BluetoothDevice bluetoothDevice = this.bluetoothDevice;
                if (bArr == null) {
                    bArr = new byte[0];
                }
                return server.notifyCharacteristicChanged(bluetoothDevice, bluetoothGattCharacteristic, z, bArr) == 0;
            }
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda13
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalSendNotification$56(bArr);
                }
            });
            bluetoothGattCharacteristic.setValue(bArr);
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda14
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalSendNotification$57(bluetoothGattCharacteristic, z);
                }
            });
            return this.serverManager.getServer().notifyCharacteristicChanged(this.bluetoothDevice, bluetoothGattCharacteristic, z);
        }
        notifyNotificationsDisabled(this.bluetoothDevice);
        nextRequest(true);
        return true;
    }

    static /* synthetic */ String lambda$internalSendNotification$54(boolean z, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return "[Server] Sending " + (z ? "indication" : "notification") + " to " + bluetoothGattCharacteristic.getUuid();
    }

    static /* synthetic */ String lambda$internalSendNotification$55(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, byte[] bArr) {
        return "[Server] gattServer.notifyCharacteristicChanged(" + bluetoothGattCharacteristic.getUuid() + ", confirm=" + z + ", value=" + ParserUtils.parseDebug(bArr) + ")";
    }

    static /* synthetic */ String lambda$internalSendNotification$56(byte[] bArr) {
        return "[Server] characteristic.setValue(" + ParserUtils.parseDebug(bArr) + ")";
    }

    static /* synthetic */ String lambda$internalSendNotification$57(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        return "[Server] gattServer.notifyCharacteristicChanged(" + bluetoothGattCharacteristic.getUuid() + ", confirm=" + z + ")";
    }

    private static BluetoothGattDescriptor getCccd(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (bluetoothGattCharacteristic == null || (i & bluetoothGattCharacteristic.getProperties()) == 0) {
            return null;
        }
        return bluetoothGattCharacteristic.getDescriptor(BleManager.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID);
    }

    private boolean internalReadCharacteristic(final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null || !this.connected || (bluetoothGattCharacteristic.getProperties() & 2) == 0) {
            return false;
        }
        try {
            log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda135
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalReadCharacteristic$58(bluetoothGattCharacteristic);
                }
            });
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda136
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalReadCharacteristic$59(bluetoothGattCharacteristic);
                }
            });
            return bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
        } catch (SecurityException e) {
            Objects.requireNonNull(e);
            log(6, new BleManagerHandler$$ExternalSyntheticLambda72(e));
            return false;
        }
    }

    static /* synthetic */ String lambda$internalReadCharacteristic$58(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return "Reading characteristic " + bluetoothGattCharacteristic.getUuid();
    }

    static /* synthetic */ String lambda$internalReadCharacteristic$59(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return "gatt.readCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")";
    }

    private boolean internalWriteCharacteristic(final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr, final int i) {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null || !this.connected || (bluetoothGattCharacteristic.getProperties() & 12) == 0) {
            return false;
        }
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (SecurityException e) {
                Objects.requireNonNull(e);
                log(6, new BleManagerHandler$$ExternalSyntheticLambda72(e));
                return false;
            }
        }
        if (Build.VERSION.SDK_INT >= 33) {
            log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda120
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalWriteCharacteristic$60(bluetoothGattCharacteristic, i);
                }
            });
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda121
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalWriteCharacteristic$61(bluetoothGattCharacteristic, bArr, i);
                }
            });
            return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, i) == 0;
        }
        log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda122
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalWriteCharacteristic$62(bluetoothGattCharacteristic, i);
            }
        });
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda123
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalWriteCharacteristic$63(bArr);
            }
        });
        bluetoothGattCharacteristic.setValue(bArr);
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda124
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalWriteCharacteristic$64(i);
            }
        });
        bluetoothGattCharacteristic.setWriteType(i);
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda125
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalWriteCharacteristic$65(bluetoothGattCharacteristic);
            }
        });
        return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    static /* synthetic */ String lambda$internalWriteCharacteristic$60(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        return "Writing characteristic " + bluetoothGattCharacteristic.getUuid() + " (" + ParserUtils.writeTypeToString(i) + ")";
    }

    static /* synthetic */ String lambda$internalWriteCharacteristic$61(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        return "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ", value=" + ParserUtils.parseDebug(bArr) + ", " + ParserUtils.writeTypeToString(i) + ")";
    }

    static /* synthetic */ String lambda$internalWriteCharacteristic$62(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        return "Writing characteristic " + bluetoothGattCharacteristic.getUuid() + " (" + ParserUtils.writeTypeToString(i) + ")";
    }

    static /* synthetic */ String lambda$internalWriteCharacteristic$63(byte[] bArr) {
        return "characteristic.setValue(" + ParserUtils.parseDebug(bArr) + ")";
    }

    static /* synthetic */ String lambda$internalWriteCharacteristic$64(int i) {
        return "characteristic.setWriteType(" + ParserUtils.writeTypeToString(i) + ")";
    }

    static /* synthetic */ String lambda$internalWriteCharacteristic$65(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")";
    }

    private boolean internalReadDescriptor(final BluetoothGattDescriptor bluetoothGattDescriptor) {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt != null && bluetoothGattDescriptor != null && this.connected) {
            try {
                log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda0
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.lambda$internalReadDescriptor$66(bluetoothGattDescriptor);
                    }
                });
                log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda61
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.lambda$internalReadDescriptor$67(bluetoothGattDescriptor);
                    }
                });
                return bluetoothGatt.readDescriptor(bluetoothGattDescriptor);
            } catch (SecurityException e) {
                Objects.requireNonNull(e);
                log(6, new BleManagerHandler$$ExternalSyntheticLambda72(e));
            }
        }
        return false;
    }

    static /* synthetic */ String lambda$internalReadDescriptor$66(BluetoothGattDescriptor bluetoothGattDescriptor) {
        return "Reading descriptor " + bluetoothGattDescriptor.getUuid();
    }

    static /* synthetic */ String lambda$internalReadDescriptor$67(BluetoothGattDescriptor bluetoothGattDescriptor) {
        return "gatt.readDescriptor(" + bluetoothGattDescriptor.getUuid() + ")";
    }

    private boolean internalWriteDescriptor(final BluetoothGattDescriptor bluetoothGattDescriptor, final byte[] bArr) {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt != null && bluetoothGattDescriptor != null && this.connected) {
            if (bArr == null) {
                try {
                    bArr = new byte[0];
                } catch (SecurityException e) {
                    Objects.requireNonNull(e);
                    log(6, new BleManagerHandler$$ExternalSyntheticLambda72(e));
                }
            }
            log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda11
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalWriteDescriptor$68(bluetoothGattDescriptor);
                }
            });
            if (Build.VERSION.SDK_INT >= 33) {
                log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda22
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.lambda$internalWriteDescriptor$69(bluetoothGattDescriptor, bArr);
                    }
                });
                return bluetoothGatt.writeDescriptor(bluetoothGattDescriptor, bArr) == 0;
            }
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda33
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalWriteDescriptor$70(bluetoothGattDescriptor);
                }
            });
            bluetoothGattDescriptor.setValue(bArr);
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda44
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalWriteDescriptor$71(bluetoothGattDescriptor);
                }
            });
            return internalWriteDescriptorWorkaround(bluetoothGattDescriptor);
        }
        return false;
    }

    static /* synthetic */ String lambda$internalWriteDescriptor$68(BluetoothGattDescriptor bluetoothGattDescriptor) {
        return "Writing descriptor " + bluetoothGattDescriptor.getUuid();
    }

    static /* synthetic */ String lambda$internalWriteDescriptor$69(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        return "gatt.writeDescriptor(" + bluetoothGattDescriptor.getUuid() + ", value=" + ParserUtils.parseDebug(bArr) + ")";
    }

    static /* synthetic */ String lambda$internalWriteDescriptor$70(BluetoothGattDescriptor bluetoothGattDescriptor) {
        return "descriptor.setValue(" + bluetoothGattDescriptor.getUuid() + ")";
    }

    static /* synthetic */ String lambda$internalWriteDescriptor$71(BluetoothGattDescriptor bluetoothGattDescriptor) {
        return "gatt.writeDescriptor(" + bluetoothGattDescriptor.getUuid() + ")";
    }

    private boolean internalWriteDescriptorWorkaround(BluetoothGattDescriptor bluetoothGattDescriptor) {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null || bluetoothGattDescriptor == null || !this.connected) {
            return false;
        }
        BluetoothGattCharacteristic characteristic = bluetoothGattDescriptor.getCharacteristic();
        int writeType = characteristic.getWriteType();
        characteristic.setWriteType(2);
        boolean zWriteDescriptor = bluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
        characteristic.setWriteType(writeType);
        return zWriteDescriptor;
    }

    private boolean internalBeginReliableWrite() {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt != null && this.connected) {
            if (this.reliableWriteInProgress) {
                return true;
            }
            log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda56
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalBeginReliableWrite$72();
                }
            });
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda57
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalBeginReliableWrite$73();
                }
            });
            try {
                boolean zBeginReliableWrite = bluetoothGatt.beginReliableWrite();
                this.reliableWriteInProgress = zBeginReliableWrite;
                return zBeginReliableWrite;
            } catch (SecurityException e) {
                Objects.requireNonNull(e);
                log(6, new BleManagerHandler$$ExternalSyntheticLambda72(e));
            }
        }
        return false;
    }

    static /* synthetic */ String lambda$internalBeginReliableWrite$72() {
        return "Beginning reliable write...";
    }

    static /* synthetic */ String lambda$internalBeginReliableWrite$73() {
        return "gatt.beginReliableWrite()";
    }

    private boolean internalExecuteReliableWrite() {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null || !this.connected || !this.reliableWriteInProgress) {
            return false;
        }
        log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda103
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalExecuteReliableWrite$74();
            }
        });
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda104
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalExecuteReliableWrite$75();
            }
        });
        try {
            return bluetoothGatt.executeReliableWrite();
        } catch (SecurityException e) {
            Objects.requireNonNull(e);
            log(6, new BleManagerHandler$$ExternalSyntheticLambda72(e));
            return false;
        }
    }

    static /* synthetic */ String lambda$internalExecuteReliableWrite$74() {
        return "Executing reliable write...";
    }

    static /* synthetic */ String lambda$internalExecuteReliableWrite$75() {
        return "gatt.executeReliableWrite()";
    }

    private boolean internalAbortReliableWrite() {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null || !this.connected || !this.reliableWriteInProgress) {
            return false;
        }
        try {
            log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda2
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalAbortReliableWrite$76();
                }
            });
            log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda3
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalAbortReliableWrite$77();
                }
            });
            bluetoothGatt.abortReliableWrite();
            return true;
        } catch (SecurityException e) {
            Objects.requireNonNull(e);
            log(6, new BleManagerHandler$$ExternalSyntheticLambda72(e));
            return false;
        }
    }

    static /* synthetic */ String lambda$internalAbortReliableWrite$76() {
        return "Aborting reliable write...";
    }

    static /* synthetic */ String lambda$internalAbortReliableWrite$77() {
        return "gatt.abortReliableWrite()";
    }

    static /* synthetic */ String lambda$internalAbortReliableWrite$78() {
        return "gatt.abortReliableWrite(device)";
    }

    @Deprecated
    private boolean internalReadBatteryLevel() {
        BluetoothGattService service;
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null || !this.connected || (service = bluetoothGatt.getService(BleManager.BATTERY_SERVICE)) == null) {
            return false;
        }
        return internalReadCharacteristic(service.getCharacteristic(BleManager.BATTERY_LEVEL_CHARACTERISTIC));
    }

    @Deprecated
    private boolean internalSetBatteryNotifications(boolean z) {
        BluetoothGattService service;
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null || !this.connected || (service = bluetoothGatt.getService(BleManager.BATTERY_SERVICE)) == null) {
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(BleManager.BATTERY_LEVEL_CHARACTERISTIC);
        if (z) {
            return internalEnableNotifications(characteristic);
        }
        return internalDisableNotifications(characteristic);
    }

    private boolean internalRequestMtu(final int i) {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null || !this.connected) {
            return false;
        }
        log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda29
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalRequestMtu$79();
            }
        });
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda30
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalRequestMtu$80(i);
            }
        });
        return bluetoothGatt.requestMtu(i);
    }

    static /* synthetic */ String lambda$internalRequestMtu$79() {
        return "Requesting new MTU...";
    }

    static /* synthetic */ String lambda$internalRequestMtu$80(int i) {
        return "gatt.requestMtu(" + i + ")";
    }

    private boolean internalRequestConnectionPriority(final int i) {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null || !this.connected) {
            return false;
        }
        final int i2 = 5;
        log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda83
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalRequestConnectionPriority$81(i, i2);
            }
        });
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda94
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalRequestConnectionPriority$82(i);
            }
        });
        return bluetoothGatt.requestConnectionPriority(i);
    }

    static /* synthetic */ String lambda$internalRequestConnectionPriority$81(int i, int i2) {
        String str;
        if (i == 0) {
            str = "BALANCED (30–50ms, 0, " + i2 + "s)";
        } else if (i == 1) {
            str = "HIGH (11.25–15ms, 0, " + i2 + "s)";
        } else if (i == 2) {
            str = "LOW POWER (100–125ms, 2, " + i2 + "s)";
        } else {
            throw new IllegalStateException("Unexpected value: " + i);
        }
        return "Requesting connection priority: " + str + "...";
    }

    static /* synthetic */ String lambda$internalRequestConnectionPriority$82(int i) {
        String str;
        if (i == 0) {
            str = "BALANCED";
        } else if (i == 1) {
            str = "HIGH";
        } else if (i == 2) {
            str = "LOW POWER";
        } else {
            throw new IllegalStateException("Unexpected value: " + i);
        }
        return "gatt.requestConnectionPriority(" + str + ")";
    }

    private boolean internalSetPreferredPhy(final int i, final int i2, final int i3) {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null || !this.connected) {
            return false;
        }
        log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda34
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalSetPreferredPhy$83();
            }
        });
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda35
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalSetPreferredPhy$84(i, i2, i3);
            }
        });
        bluetoothGatt.setPreferredPhy(i, i2, i3);
        return true;
    }

    static /* synthetic */ String lambda$internalSetPreferredPhy$83() {
        return "Requesting preferred PHYs...";
    }

    static /* synthetic */ String lambda$internalSetPreferredPhy$84(int i, int i2, int i3) {
        return "gatt.setPreferredPhy(" + ParserUtils.phyMaskToString(i) + ", " + ParserUtils.phyMaskToString(i2) + ", coding option = " + ParserUtils.phyCodedOptionToString(i3) + ")";
    }

    private boolean internalReadPhy() {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null || !this.connected) {
            return false;
        }
        log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda69
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalReadPhy$85();
            }
        });
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda70
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalReadPhy$86();
            }
        });
        bluetoothGatt.readPhy();
        return true;
    }

    static /* synthetic */ String lambda$internalReadPhy$85() {
        return "Reading PHY...";
    }

    static /* synthetic */ String lambda$internalReadPhy$86() {
        return "gatt.readPhy()";
    }

    private boolean internalReadRssi() {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null || !this.connected) {
            return false;
        }
        log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda5
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalReadRssi$87();
            }
        });
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda6
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalReadRssi$88();
            }
        });
        return bluetoothGatt.readRemoteRssi();
    }

    static /* synthetic */ String lambda$internalReadRssi$87() {
        return "Reading remote RSSI...";
    }

    static /* synthetic */ String lambda$internalReadRssi$88() {
        return "gatt.readRemoteRssi()";
    }

    ValueChangedCallback getValueChangedCallback(Object obj) {
        ValueChangedCallback valueChangedCallback = this.valueChangedCallbacks.get(obj);
        if (valueChangedCallback == null) {
            valueChangedCallback = new ValueChangedCallback(this);
            if (obj != null) {
                this.valueChangedCallbacks.put(obj, valueChangedCallback);
            }
        } else if (this.bluetoothDevice != null) {
            valueChangedCallback.notifyClosed();
        }
        return valueChangedCallback;
    }

    void removeValueChangedCallback(Object obj) {
        ValueChangedCallback valueChangedCallbackRemove = this.valueChangedCallbacks.remove(obj);
        if (valueChangedCallbackRemove != null) {
            valueChangedCallbackRemove.notifyClosed();
        }
    }

    void setCharacteristicValue(BluetoothGattCharacteristic bluetoothGattCharacteristic, DataProvider dataProvider) {
        if (bluetoothGattCharacteristic == null) {
            return;
        }
        if (dataProvider == null) {
            this.dataProviders.remove(bluetoothGattCharacteristic);
        } else {
            this.dataProviders.put(bluetoothGattCharacteristic, dataProvider);
        }
    }

    void setDescriptorValue(BluetoothGattDescriptor bluetoothGattDescriptor, DataProvider dataProvider) {
        if (bluetoothGattDescriptor == null) {
            return;
        }
        if (dataProvider == null) {
            this.dataProviders.remove(bluetoothGattDescriptor);
        } else {
            this.dataProviders.put(bluetoothGattDescriptor, dataProvider);
        }
    }

    void setConnectionParametersListener(ConnectionParametersUpdatedCallback connectionParametersUpdatedCallback) {
        BluetoothDevice bluetoothDevice;
        int i;
        this.connectionParametersUpdatedCallback = connectionParametersUpdatedCallback;
        if (connectionParametersUpdatedCallback == null || (bluetoothDevice = this.bluetoothDevice) == null || (i = this.interval) <= 0) {
            return;
        }
        connectionParametersUpdatedCallback.onConnectionUpdated(bluetoothDevice, i, this.latency, this.timeout);
    }

    @Deprecated
    DataReceivedCallback getBatteryLevelCallback() {
        return new DataReceivedCallback() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda58
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public final void onDataReceived(BluetoothDevice bluetoothDevice, Data data) {
                this.f$0.lambda$getBatteryLevelCallback$91(bluetoothDevice, data);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBatteryLevelCallback$91(final BluetoothDevice bluetoothDevice, Data data) {
        if (data.size() == 1) {
            final int iIntValue = data.getIntValue(17, 0).intValue();
            log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda107
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$getBatteryLevelCallback$89(iIntValue);
                }
            });
            this.batteryValue = iIntValue;
            onBatteryValueReceived(this.bluetoothGatt, iIntValue);
            postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda108
                @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                public final void run(BleManagerCallbacks bleManagerCallbacks) {
                    bleManagerCallbacks.onBatteryValueReceived(bluetoothDevice, iIntValue);
                }
            });
        }
    }

    static /* synthetic */ String lambda$getBatteryLevelCallback$89(int i) {
        return "Battery Level received: " + i + "%";
    }

    @Deprecated
    void setBatteryLevelNotificationCallback() {
        if (this.batteryLevelNotificationCallback == null) {
            this.batteryLevelNotificationCallback = new ValueChangedCallback(this).with(new DataReceivedCallback() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda113
                @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
                public final void onDataReceived(BluetoothDevice bluetoothDevice, Data data) {
                    this.f$0.lambda$setBatteryLevelNotificationCallback$93(bluetoothDevice, data);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBatteryLevelNotificationCallback$93(final BluetoothDevice bluetoothDevice, Data data) {
        if (data.size() == 1) {
            final int iIntValue = data.getIntValue(17, 0).intValue();
            this.batteryValue = iIntValue;
            onBatteryValueReceived(this.bluetoothGatt, iIntValue);
            postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda55
                @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                public final void run(BleManagerCallbacks bleManagerCallbacks) {
                    bleManagerCallbacks.onBatteryValueReceived(bluetoothDevice, iIntValue);
                }
            });
        }
    }

    private boolean internalRefreshDeviceCache() {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt == null) {
            return false;
        }
        log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda131
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalRefreshDeviceCache$94();
            }
        });
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda132
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$internalRefreshDeviceCache$95();
            }
        });
        try {
            return bluetoothGatt.getClass().getMethod("refresh", new Class[0]).invoke(bluetoothGatt, new Object[0]) == Boolean.TRUE;
        } catch (Exception e) {
            Log.w(TAG, "An exception occurred while refreshing device", e);
            log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda133
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$internalRefreshDeviceCache$96();
                }
            });
            return false;
        }
    }

    static /* synthetic */ String lambda$internalRefreshDeviceCache$94() {
        return "Refreshing device cache...";
    }

    static /* synthetic */ String lambda$internalRefreshDeviceCache$95() {
        return "gatt.refresh() (hidden)";
    }

    static /* synthetic */ String lambda$internalRefreshDeviceCache$96() {
        return "gatt.refresh() method not found";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enqueueFirst(Request request) {
        Deque<Request> deque;
        RequestQueue requestQueue = this.requestQueue;
        if (requestQueue == null) {
            if (!this.initialization || (deque = this.initQueue) == null) {
                deque = this.taskQueue;
            }
            deque.addFirst(request);
        } else {
            requestQueue.addFirst(request);
        }
        request.enqueued = true;
        this.operationInProgress = false;
    }

    @Override // no.nordicsemi.android.ble.RequestHandler
    final void enqueue(Request request) {
        Deque<Request> deque;
        if (!request.enqueued) {
            if (!this.initialization || (deque = this.initQueue) == null) {
                deque = this.taskQueue;
            }
            deque.add(request);
            request.enqueued = true;
        }
        nextRequest(false);
    }

    @Override // no.nordicsemi.android.ble.RequestHandler
    final void cancelQueue() {
        this.taskQueue.clear();
        this.initQueue = null;
        this.initialization = false;
        BluetoothDevice bluetoothDevice = this.bluetoothDevice;
        if (bluetoothDevice == null) {
            return;
        }
        if (this.operationInProgress) {
            cancelCurrent();
        }
        ConnectRequest connectRequest = this.connectRequest;
        if (connectRequest != null) {
            connectRequest.notifyFail(bluetoothDevice, -7);
            this.connectRequest = null;
            internalDisconnect(5);
        }
    }

    @Override // no.nordicsemi.android.ble.RequestHandler
    final void cancelCurrent() {
        BluetoothDevice bluetoothDevice = this.bluetoothDevice;
        if (bluetoothDevice == null) {
            return;
        }
        log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda126
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$cancelCurrent$97();
            }
        });
        Request request = this.request;
        if (request instanceof TimeoutableRequest) {
            request.notifyFail(bluetoothDevice, -7);
        }
        AwaitingRequest<?> awaitingRequest = this.awaitingRequest;
        if (awaitingRequest != null) {
            awaitingRequest.notifyFail(bluetoothDevice, -7);
            this.awaitingRequest = null;
        }
        RequestQueue requestQueue = this.requestQueue;
        if (requestQueue instanceof ReliableWriteRequest) {
            requestQueue.cancelQueue();
        } else if (requestQueue != null) {
            requestQueue.notifyFail(bluetoothDevice, -7);
            this.requestQueue = null;
        }
        Request request2 = this.request;
        nextRequest(request2 == null || request2.finished);
    }

    static /* synthetic */ String lambda$cancelCurrent$97() {
        return "Request cancelled";
    }

    @Override // no.nordicsemi.android.ble.RequestHandler
    final void onRequestTimeout(BluetoothDevice bluetoothDevice, TimeoutableRequest timeoutableRequest) {
        if (timeoutableRequest instanceof SleepRequest) {
            timeoutableRequest.notifySuccess(bluetoothDevice);
        } else {
            log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda36
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$onRequestTimeout$98();
                }
            });
        }
        Request request = this.request;
        if (request instanceof TimeoutableRequest) {
            request.notifyFail(bluetoothDevice, -5);
        }
        AwaitingRequest<?> awaitingRequest = this.awaitingRequest;
        if (awaitingRequest != null) {
            awaitingRequest.notifyFail(bluetoothDevice, -5);
            this.awaitingRequest = null;
        }
        timeoutableRequest.notifyFail(bluetoothDevice, -5);
        if (timeoutableRequest.type == Request.Type.CONNECT) {
            this.connectRequest = null;
            internalDisconnect(10);
        } else if (timeoutableRequest.type == Request.Type.DISCONNECT) {
            close();
        } else {
            Request request2 = this.request;
            nextRequest(request2 == null || request2.finished);
        }
    }

    static /* synthetic */ String lambda$onRequestTimeout$98() {
        return "Request timed out";
    }

    @Override // no.nordicsemi.android.ble.CallbackHandler
    public void post(Runnable runnable) {
        this.handler.post(runnable);
    }

    @Override // no.nordicsemi.android.ble.CallbackHandler
    public void postDelayed(final Runnable runnable, long j) {
        new Timer().schedule(new TimerTask() { // from class: no.nordicsemi.android.ble.BleManagerHandler.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                runnable.run();
            }
        }, j);
    }

    @Override // no.nordicsemi.android.ble.CallbackHandler
    public void removeCallbacks(Runnable runnable) {
        this.handler.removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public void postCallback(final CallbackRunnable callbackRunnable) {
        final BleManagerCallbacks bleManagerCallbacks = this.manager.callbacks;
        if (bleManagerCallbacks != null) {
            post(new Runnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda59
                @Override // java.lang.Runnable
                public final void run() {
                    callbackRunnable.run(bleManagerCallbacks);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postBondingStateChange(final BondingObserverRunnable bondingObserverRunnable) {
        final BondingObserver bondingObserver = this.manager.bondingObserver;
        if (bondingObserver != null) {
            post(new Runnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda98
                @Override // java.lang.Runnable
                public final void run() {
                    bondingObserverRunnable.run(bondingObserver);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postConnectionStateChange(final ConnectionObserverRunnable connectionObserverRunnable) {
        final ConnectionObserver connectionObserver = this.manager.connectionObserver;
        if (connectionObserver != null) {
            post(new Runnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda134
                @Override // java.lang.Runnable
                public final void run() {
                    connectionObserverRunnable.run(connectionObserver);
                }
            });
        }
    }

    final int getConnectionState() {
        return this.connectionState;
    }

    final boolean isConnected() {
        return this.connected;
    }

    @Deprecated
    final int getBatteryValue() {
        return this.batteryValue;
    }

    final boolean isReady() {
        return this.ready;
    }

    final boolean isReliableWriteInProgress() {
        return this.reliableWriteInProgress;
    }

    final int getMtu() {
        return this.mtu;
    }

    final void overrideMtu(int i) {
        this.mtu = Math.min(515, i);
    }

    void notifyDeviceDisconnected(final BluetoothDevice bluetoothDevice, final int i) {
        if (this.connectionState == 0) {
            return;
        }
        boolean z = this.connected;
        boolean z2 = this.servicesDiscovered;
        this.connected = false;
        this.ready = false;
        this.servicesDiscovered = false;
        this.serviceDiscoveryRequested = false;
        this.deviceNotSupported = false;
        this.mtu = 23;
        this.timeout = 0;
        this.latency = 0;
        this.interval = 0;
        this.connectionState = 0;
        checkCondition();
        if (!z) {
            log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda137
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$notifyDeviceDisconnected$102();
                }
            });
            close();
            postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda139
                @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                public final void run(BleManagerCallbacks bleManagerCallbacks) {
                    bleManagerCallbacks.onDeviceDisconnected(bluetoothDevice);
                }
            });
            postConnectionStateChange(new ConnectionObserverRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda140
                @Override // no.nordicsemi.android.ble.BleManagerHandler.ConnectionObserverRunnable
                public final void run(ConnectionObserver connectionObserver) {
                    connectionObserver.onDeviceFailedToConnect(bluetoothDevice, i);
                }
            });
        } else if (this.userDisconnected) {
            log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda141
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$notifyDeviceDisconnected$105();
                }
            });
            Request request = this.request;
            if (request == null || request.type != Request.Type.REMOVE_BOND) {
                close();
            }
            postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda142
                @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                public final void run(BleManagerCallbacks bleManagerCallbacks) {
                    bleManagerCallbacks.onDeviceDisconnected(bluetoothDevice);
                }
            });
            postConnectionStateChange(new ConnectionObserverRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda143
                @Override // no.nordicsemi.android.ble.BleManagerHandler.ConnectionObserverRunnable
                public final void run(ConnectionObserver connectionObserver) {
                    connectionObserver.onDeviceDisconnected(bluetoothDevice, i);
                }
            });
            if (request != null && request.type == Request.Type.DISCONNECT) {
                request.notifySuccess(bluetoothDevice);
                this.request = null;
            }
        } else {
            log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda144
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$notifyDeviceDisconnected$108();
                }
            });
            postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda145
                @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                public final void run(BleManagerCallbacks bleManagerCallbacks) {
                    bleManagerCallbacks.onLinkLossOccurred(bluetoothDevice);
                }
            });
            final int i2 = i != 2 ? 3 : 2;
            postConnectionStateChange(new ConnectionObserverRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda146
                @Override // no.nordicsemi.android.ble.BleManagerHandler.ConnectionObserverRunnable
                public final void run(ConnectionObserver connectionObserver) {
                    connectionObserver.onDeviceDisconnected(bluetoothDevice, i2);
                }
            });
        }
        Iterator<ValueChangedCallback> it = this.valueChangedCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().notifyClosed();
        }
        this.valueChangedCallbacks.clear();
        this.dataProviders.clear();
        this.batteryLevelNotificationCallback = null;
        this.batteryValue = -1;
        if (z2) {
            this.manager.onServicesInvalidated();
        }
        onDeviceDisconnected();
    }

    static /* synthetic */ String lambda$notifyDeviceDisconnected$102() {
        return "Connection attempt timed out";
    }

    static /* synthetic */ String lambda$notifyDeviceDisconnected$105() {
        return "Disconnected";
    }

    static /* synthetic */ String lambda$notifyDeviceDisconnected$108() {
        return "Connection lost";
    }

    static /* synthetic */ String lambda$onError$111(int i) {
        return "Error (0x" + Integer.toHexString(i) + "): " + GattError.parse(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(final BluetoothDevice bluetoothDevice, final String str, final int i) {
        log(6, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda109
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$onError$111(i);
            }
        });
        postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda110
            @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
            public final void run(BleManagerCallbacks bleManagerCallbacks) {
                bleManagerCallbacks.onError(bluetoothDevice, str, i);
            }
        });
    }

    /* renamed from: no.nordicsemi.android.ble.BleManagerHandler$4, reason: invalid class name */
    class AnonymousClass4 extends BluetoothGattCallback {
        AnonymousClass4() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(final BluetoothGatt bluetoothGatt, final int i, final int i2) {
            BleManagerHandler.this.log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda62
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.AnonymousClass4.lambda$onConnectionStateChange$0(i, i2);
                }
            });
            if (i == 0 && i2 == 2) {
                if (BleManagerHandler.this.bluetoothDevice == null) {
                    Log.e(BleManagerHandler.TAG, "Device received notification after disconnection.");
                    BleManagerHandler.this.log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda2
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.AnonymousClass4.lambda$onConnectionStateChange$1();
                        }
                    });
                    try {
                        bluetoothGatt.close();
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda3
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onConnectionStateChange$2(bluetoothGatt);
                    }
                });
                BleManagerHandler.this.connected = true;
                BleManagerHandler.this.connectionTime = 0L;
                BleManagerHandler.this.connectionState = 2;
                BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda4
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                    public final void run(BleManagerCallbacks bleManagerCallbacks) {
                        bleManagerCallbacks.onDeviceConnected(bluetoothGatt.getDevice());
                    }
                });
                BleManagerHandler.this.postConnectionStateChange(new ConnectionObserverRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda5
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.ConnectionObserverRunnable
                    public final void run(ConnectionObserver connectionObserver) {
                        connectionObserver.onDeviceConnected(bluetoothGatt.getDevice());
                    }
                });
                if (BleManagerHandler.this.serviceDiscoveryRequested) {
                    return;
                }
                final int serviceDiscoveryDelay = BleManagerHandler.this.manager.getServiceDiscoveryDelay(bluetoothGatt.getDevice().getBondState() == 12);
                if (serviceDiscoveryDelay > 0) {
                    BleManagerHandler.this.log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda6
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.AnonymousClass4.lambda$onConnectionStateChange$5(serviceDiscoveryDelay);
                        }
                    });
                }
                BleManagerHandler bleManagerHandler = BleManagerHandler.this;
                final int i3 = bleManagerHandler.connectionCount + 1;
                bleManagerHandler.connectionCount = i3;
                BleManagerHandler.this.postDelayed(new Runnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onConnectionStateChange$8(i3, bluetoothGatt);
                    }
                }, serviceDiscoveryDelay);
                return;
            }
            if (i2 == 0) {
                Request request = BleManagerHandler.this.request;
                final ConnectRequest connectRequest = BleManagerHandler.this.connectRequest;
                AwaitingRequest awaitingRequest = BleManagerHandler.this.awaitingRequest;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                boolean z = BleManagerHandler.this.connectionTime > 0;
                boolean z2 = z && jElapsedRealtime > BleManagerHandler.this.connectionTime + 20000;
                if (i != 0) {
                    BleManagerHandler.this.log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda8
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.AnonymousClass4.lambda$onConnectionStateChange$9(i);
                        }
                    });
                }
                if (i != 0 && z && !z2 && connectRequest != null && connectRequest.canRetry()) {
                    final int retryDelay = connectRequest.getRetryDelay();
                    if (retryDelay > 0) {
                        BleManagerHandler.this.log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda9
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                            public final String log() {
                                return BleManagerHandler.AnonymousClass4.lambda$onConnectionStateChange$10(retryDelay);
                            }
                        });
                    }
                    BleManagerHandler.this.postDelayed(new Runnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda10
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onConnectionStateChange$14(bluetoothGatt, connectRequest);
                        }
                    }, retryDelay);
                    return;
                }
                if (connectRequest != null && connectRequest.shouldAutoConnect() && BleManagerHandler.this.initialConnection && bluetoothGatt.getDevice().getBondState() == 12) {
                    BleManagerHandler.this.log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda63
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.AnonymousClass4.lambda$onConnectionStateChange$15();
                        }
                    });
                    BleManagerHandler.this.post(new Runnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda64
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onConnectionStateChange$16(bluetoothGatt, connectRequest);
                        }
                    });
                    return;
                }
                BleManagerHandler.this.operationInProgress = true;
                BleManagerHandler.this.taskQueue.clear();
                BleManagerHandler.this.initQueue = null;
                BleManagerHandler.this.ready = false;
                boolean z3 = BleManagerHandler.this.connected;
                boolean z4 = BleManagerHandler.this.deviceNotSupported;
                if (z2) {
                    BleManagerHandler.this.notifyDeviceDisconnected(bluetoothGatt.getDevice(), 10);
                } else if (z4) {
                    BleManagerHandler.this.notifyDeviceDisconnected(bluetoothGatt.getDevice(), 4);
                } else if (request != null && request.type == Request.Type.DISCONNECT) {
                    BleManagerHandler.this.notifyDeviceDisconnected(bluetoothGatt.getDevice(), 0);
                } else {
                    BleManagerHandler.this.notifyDeviceDisconnected(bluetoothGatt.getDevice(), BleManagerHandler.this.mapDisconnectStatusToReason(i));
                }
                int i4 = -1;
                if (request != null && request.type != Request.Type.DISCONNECT && request.type != Request.Type.REMOVE_BOND) {
                    request.notifyFail(bluetoothGatt.getDevice(), i == 0 ? -1 : i);
                    BleManagerHandler.this.request = null;
                }
                if (awaitingRequest != null) {
                    awaitingRequest.notifyFail(bluetoothGatt.getDevice(), -1);
                    BleManagerHandler.this.awaitingRequest = null;
                }
                if (connectRequest != null) {
                    if (z4) {
                        i4 = -2;
                    } else if (i != 0) {
                        i4 = (i == 133 && z2) ? -5 : i;
                    }
                    connectRequest.notifyFail(bluetoothGatt.getDevice(), i4);
                    BleManagerHandler.this.connectRequest = null;
                }
                BleManagerHandler.this.operationInProgress = false;
                if (z3 && BleManagerHandler.this.initialConnection) {
                    BleManagerHandler.this.internalConnect(bluetoothGatt.getDevice(), null);
                } else {
                    BleManagerHandler.this.initialConnection = false;
                    BleManagerHandler.this.nextRequest(false);
                }
                if (z3 || i == 0) {
                    return;
                }
            } else if (i != 0) {
                BleManagerHandler.this.log(6, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda65
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onConnectionStateChange$17(i);
                    }
                });
            }
            BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda1
                @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                public final void run(BleManagerCallbacks bleManagerCallbacks) {
                    bleManagerCallbacks.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_CONNECTION_STATE_CHANGE, i);
                }
            });
        }

        static /* synthetic */ String lambda$onConnectionStateChange$0(int i, int i2) {
            return "[Callback] Connection state changed with status: " + i + " and new state: " + i2 + " (" + ParserUtils.stateToString(i2) + ")";
        }

        static /* synthetic */ String lambda$onConnectionStateChange$1() {
            return "gatt.close()";
        }

        static /* synthetic */ String lambda$onConnectionStateChange$2(BluetoothGatt bluetoothGatt) {
            return "Connected to " + bluetoothGatt.getDevice().getAddress();
        }

        static /* synthetic */ String lambda$onConnectionStateChange$5(int i) {
            return "wait(" + i + ")";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onConnectionStateChange$8(int i, BluetoothGatt bluetoothGatt) {
            if (i != BleManagerHandler.this.connectionCount || !BleManagerHandler.this.connected || BleManagerHandler.this.servicesDiscovered || BleManagerHandler.this.serviceDiscoveryRequested || bluetoothGatt.getDevice().getBondState() == 11) {
                return;
            }
            BleManagerHandler.this.serviceDiscoveryRequested = true;
            BleManagerHandler.this.log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda29
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.AnonymousClass4.lambda$onConnectionStateChange$6();
                }
            });
            BleManagerHandler.this.log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda30
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.AnonymousClass4.lambda$onConnectionStateChange$7();
                }
            });
            bluetoothGatt.discoverServices();
        }

        static /* synthetic */ String lambda$onConnectionStateChange$6() {
            return "Discovering services...";
        }

        static /* synthetic */ String lambda$onConnectionStateChange$7() {
            return "gatt.discoverServices()";
        }

        static /* synthetic */ String lambda$onConnectionStateChange$9(int i) {
            return "Error: (0x" + Integer.toHexString(i) + "): " + GattError.parseConnectionError(i);
        }

        static /* synthetic */ String lambda$onConnectionStateChange$10(int i) {
            return "wait(" + i + ")";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onConnectionStateChange$14(final BluetoothGatt bluetoothGatt, ConnectRequest connectRequest) {
            BleManagerHandler.this.internalConnect(bluetoothGatt.getDevice(), connectRequest);
            if (BleManagerHandler.this.bluetoothGatt == null) {
                BleManagerHandler.this.connectionState = 0;
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda31
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onConnectionStateChange$11();
                    }
                });
                BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda32
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                    public final void run(BleManagerCallbacks bleManagerCallbacks) {
                        bleManagerCallbacks.onDeviceDisconnected(bluetoothGatt.getDevice());
                    }
                });
                BleManagerHandler.this.postConnectionStateChange(new ConnectionObserverRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda34
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.ConnectionObserverRunnable
                    public final void run(ConnectionObserver connectionObserver) {
                        connectionObserver.onDeviceFailedToConnect(bluetoothGatt.getDevice(), 5);
                    }
                });
                BleManagerHandler.this.onDeviceDisconnected();
            }
        }

        static /* synthetic */ String lambda$onConnectionStateChange$11() {
            return "Disconnected";
        }

        static /* synthetic */ String lambda$onConnectionStateChange$15() {
            return "autoConnect = false called failed; retrying with autoConnect = true";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onConnectionStateChange$16(BluetoothGatt bluetoothGatt, ConnectRequest connectRequest) {
            BleManagerHandler.this.internalConnect(bluetoothGatt.getDevice(), connectRequest);
        }

        static /* synthetic */ String lambda$onConnectionStateChange$17(int i) {
            return "Error (0x" + Integer.toHexString(i) + "): " + GattError.parseConnectionError(i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(final BluetoothGatt bluetoothGatt, int i) {
            if (BleManagerHandler.this.serviceDiscoveryRequested) {
                BleManagerHandler.this.serviceDiscoveryRequested = false;
                if (i == 0) {
                    BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda0
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.AnonymousClass4.lambda$onServicesDiscovered$19();
                        }
                    });
                    BleManagerHandler.this.servicesDiscovered = true;
                    if (BleManagerHandler.this.manager.isRequiredServiceSupported(bluetoothGatt)) {
                        BleManagerHandler.this.log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda11
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                            public final String log() {
                                return BleManagerHandler.AnonymousClass4.lambda$onServicesDiscovered$20();
                            }
                        });
                        BleManagerHandler.this.deviceNotSupported = false;
                        final boolean zIsOptionalServiceSupported = BleManagerHandler.this.manager.isOptionalServiceSupported(bluetoothGatt);
                        if (zIsOptionalServiceSupported) {
                            BleManagerHandler.this.log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda22
                                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                                public final String log() {
                                    return BleManagerHandler.AnonymousClass4.lambda$onServicesDiscovered$21();
                                }
                            });
                        }
                        BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda33
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                            public final void run(BleManagerCallbacks bleManagerCallbacks) {
                                bleManagerCallbacks.onServicesDiscovered(bluetoothGatt.getDevice(), zIsOptionalServiceSupported);
                            }
                        });
                        BleManagerHandler.this.initializeServerAttributes();
                        BleManagerHandler.this.operationInProgress = true;
                        BleManagerHandler.this.initialization = true;
                        BleManagerHandler bleManagerHandler = BleManagerHandler.this;
                        bleManagerHandler.initQueue = bleManagerHandler.initGatt(bluetoothGatt);
                        boolean z = BleManagerHandler.this.initQueue != null;
                        if (z) {
                            for (Request request : BleManagerHandler.this.initQueue) {
                                request.setRequestHandler(BleManagerHandler.this);
                                request.enqueued = true;
                            }
                        }
                        if (BleManagerHandler.this.initQueue == null) {
                            BleManagerHandler.this.initQueue = new LinkedBlockingDeque();
                        }
                        if (Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27 || Build.VERSION.SDK_INT == 28) {
                            BleManagerHandler.this.enqueueFirst(Request.newEnableServiceChangedIndicationsRequest().setRequestHandler((RequestHandler) BleManagerHandler.this));
                            BleManagerHandler.this.operationInProgress = true;
                        }
                        if (z) {
                            BleManagerHandler.this.manager.readBatteryLevel();
                            if (BleManagerHandler.this.manager.callbacks != null && BleManagerHandler.this.manager.callbacks.shouldEnableBatteryLevelNotifications(bluetoothGatt.getDevice())) {
                                BleManagerHandler.this.manager.enableBatteryLevelNotifications();
                            }
                        }
                        BleManagerHandler.this.manager.initialize();
                        BleManagerHandler.this.initialization = false;
                        BleManagerHandler.this.nextRequest(true);
                        return;
                    }
                    BleManagerHandler.this.log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda44
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.AnonymousClass4.lambda$onServicesDiscovered$23();
                        }
                    });
                    BleManagerHandler.this.deviceNotSupported = true;
                    BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda55
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                        public final void run(BleManagerCallbacks bleManagerCallbacks) {
                            bleManagerCallbacks.onDeviceNotSupported(bluetoothGatt.getDevice());
                        }
                    });
                    BleManagerHandler.this.internalDisconnect(4);
                    return;
                }
                Log.e(BleManagerHandler.TAG, "onServicesDiscovered error " + i);
                BleManagerHandler.this.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_DISCOVERY_SERVICE, i);
                if (BleManagerHandler.this.connectRequest != null) {
                    BleManagerHandler.this.connectRequest.notifyFail(bluetoothGatt.getDevice(), -4);
                    BleManagerHandler.this.connectRequest = null;
                }
                BleManagerHandler.this.internalDisconnect(-1);
            }
        }

        static /* synthetic */ String lambda$onServicesDiscovered$19() {
            return "Services discovered";
        }

        static /* synthetic */ String lambda$onServicesDiscovered$20() {
            return "Primary service found";
        }

        static /* synthetic */ String lambda$onServicesDiscovered$21() {
            return "Secondary service found";
        }

        static /* synthetic */ String lambda$onServicesDiscovered$23() {
            return "Device is not supported";
        }

        static /* synthetic */ String lambda$onServiceChanged$25() {
            return "Service changed, invalidating services";
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServiceChanged(BluetoothGatt bluetoothGatt) {
            BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda26
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.AnonymousClass4.lambda$onServiceChanged$25();
                }
            });
            BleManagerHandler.this.operationInProgress = true;
            BleManagerHandler.this.manager.onServicesInvalidated();
            BleManagerHandler.this.onDeviceDisconnected();
            BleManagerHandler.this.taskQueue.clear();
            BleManagerHandler.this.initQueue = null;
            BleManagerHandler.this.serviceDiscoveryRequested = true;
            BleManagerHandler.this.servicesDiscovered = false;
            BleManagerHandler.this.log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda27
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.AnonymousClass4.lambda$onServiceChanged$26();
                }
            });
            BleManagerHandler.this.log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda28
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.AnonymousClass4.lambda$onServiceChanged$27();
                }
            });
            bluetoothGatt.discoverServices();
        }

        static /* synthetic */ String lambda$onServiceChanged$26() {
            return "Discovering Services...";
        }

        static /* synthetic */ String lambda$onServiceChanged$27() {
            return "gatt.discoverServices()";
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue(), i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr, final int i) {
            if (i == 0) {
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda47
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onCharacteristicRead$28(bluetoothGattCharacteristic, bArr);
                    }
                });
                BleManagerHandler.this.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic);
                Request request = BleManagerHandler.this.request;
                if (request instanceof ReadRequest) {
                    ReadRequest readRequest = (ReadRequest) request;
                    boolean zMatches = readRequest.matches(bArr);
                    if (zMatches) {
                        readRequest.notifyValueChanged(bluetoothGatt.getDevice(), bArr);
                    }
                    if (!zMatches || readRequest.hasMore()) {
                        BleManagerHandler.this.enqueueFirst(readRequest);
                    } else {
                        readRequest.notifySuccess(bluetoothGatt.getDevice());
                    }
                }
            } else if (i != 5 && i != 8 && i != 137) {
                Log.e(BleManagerHandler.TAG, "onCharacteristicRead error " + i);
                if (BleManagerHandler.this.request instanceof ReadRequest) {
                    BleManagerHandler.this.request.notifyFail(bluetoothGatt.getDevice(), i);
                }
                BleManagerHandler.this.awaitingRequest = null;
                BleManagerHandler.this.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_READ_CHARACTERISTIC, i);
            } else {
                BleManagerHandler.this.log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda48
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onCharacteristicRead$29(i);
                    }
                });
                if (bluetoothGatt.getDevice().getBondState() != 10) {
                    Log.w(BleManagerHandler.TAG, BleManagerHandler.ERROR_AUTH_ERROR_WHILE_BONDED);
                    BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda49
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                        public final void run(BleManagerCallbacks bleManagerCallbacks) {
                            bleManagerCallbacks.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_AUTH_ERROR_WHILE_BONDED, i);
                        }
                    });
                    return;
                }
                return;
            }
            BleManagerHandler.this.checkCondition();
            BleManagerHandler.this.nextRequest(true);
        }

        static /* synthetic */ String lambda$onCharacteristicRead$28(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            return "Read Response received from " + bluetoothGattCharacteristic.getUuid() + ", value: " + ParserUtils.parse(bArr);
        }

        static /* synthetic */ String lambda$onCharacteristicRead$29(int i) {
            return "Authentication required (" + i + ")";
        }

        static /* synthetic */ String lambda$onCharacteristicWrite$31(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            return "Data written to " + bluetoothGattCharacteristic.getUuid();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final int i) {
            if (i == 0) {
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda43
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onCharacteristicWrite$31(bluetoothGattCharacteristic);
                    }
                });
                BleManagerHandler.this.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic);
                Request request = BleManagerHandler.this.request;
                if (request instanceof WriteRequest) {
                    WriteRequest writeRequest = (WriteRequest) request;
                    if (!writeRequest.notifyPacketSent(bluetoothGatt.getDevice(), bluetoothGattCharacteristic.getValue()) && (BleManagerHandler.this.requestQueue instanceof ReliableWriteRequest)) {
                        writeRequest.notifyFail(bluetoothGatt.getDevice(), -6);
                        BleManagerHandler.this.requestQueue.cancelQueue();
                    } else if (writeRequest.hasMore()) {
                        BleManagerHandler.this.enqueueFirst(writeRequest);
                    } else {
                        writeRequest.notifySuccess(bluetoothGatt.getDevice());
                    }
                }
            } else if (i != 5 && i != 8 && i != 137) {
                Log.e(BleManagerHandler.TAG, "onCharacteristicWrite error " + i);
                if (BleManagerHandler.this.request instanceof WriteRequest) {
                    BleManagerHandler.this.request.notifyFail(bluetoothGatt.getDevice(), i);
                    if (BleManagerHandler.this.requestQueue instanceof ReliableWriteRequest) {
                        BleManagerHandler.this.requestQueue.cancelQueue();
                    }
                }
                BleManagerHandler.this.awaitingRequest = null;
                BleManagerHandler.this.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_WRITE_CHARACTERISTIC, i);
            } else {
                BleManagerHandler.this.log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda45
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onCharacteristicWrite$32(i);
                    }
                });
                if (bluetoothGatt.getDevice().getBondState() != 10) {
                    Log.w(BleManagerHandler.TAG, BleManagerHandler.ERROR_AUTH_ERROR_WHILE_BONDED);
                    BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda46
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                        public final void run(BleManagerCallbacks bleManagerCallbacks) {
                            bleManagerCallbacks.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_AUTH_ERROR_WHILE_BONDED, i);
                        }
                    });
                    return;
                }
                return;
            }
            BleManagerHandler.this.checkCondition();
            BleManagerHandler.this.nextRequest(true);
        }

        static /* synthetic */ String lambda$onCharacteristicWrite$32(int i) {
            return "Authentication required (" + i + ")";
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
            boolean z = BleManagerHandler.this.request.type == Request.Type.EXECUTE_RELIABLE_WRITE;
            BleManagerHandler.this.reliableWriteInProgress = false;
            if (i != 0) {
                Log.e(BleManagerHandler.TAG, "onReliableWriteCompleted execute " + z + ", error " + i);
                BleManagerHandler.this.request.notifyFail(bluetoothGatt.getDevice(), i);
                BleManagerHandler.this.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_RELIABLE_WRITE, i);
            } else if (z) {
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda50
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onReliableWriteCompleted$34();
                    }
                });
                BleManagerHandler.this.request.notifySuccess(bluetoothGatt.getDevice());
            } else {
                BleManagerHandler.this.log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda51
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onReliableWriteCompleted$35();
                    }
                });
                BleManagerHandler.this.request.notifySuccess(bluetoothGatt.getDevice());
                BleManagerHandler.this.requestQueue.notifyFail(bluetoothGatt.getDevice(), -4);
            }
            BleManagerHandler.this.checkCondition();
            BleManagerHandler.this.nextRequest(true);
        }

        static /* synthetic */ String lambda$onReliableWriteCompleted$34() {
            return "Reliable Write executed";
        }

        static /* synthetic */ String lambda$onReliableWriteCompleted$35() {
            return "Reliable Write aborted";
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(final BluetoothGatt bluetoothGatt, final BluetoothGattDescriptor bluetoothGattDescriptor, final int i) {
            final byte[] value = bluetoothGattDescriptor.getValue();
            if (i == 0) {
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda35
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onDescriptorRead$36(bluetoothGattDescriptor, value);
                    }
                });
                BleManagerHandler.this.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor);
                if (BleManagerHandler.this.request instanceof ReadRequest) {
                    ReadRequest readRequest = (ReadRequest) BleManagerHandler.this.request;
                    readRequest.notifyValueChanged(bluetoothGatt.getDevice(), value);
                    if (readRequest.hasMore()) {
                        BleManagerHandler.this.enqueueFirst(readRequest);
                    } else {
                        readRequest.notifySuccess(bluetoothGatt.getDevice());
                    }
                }
            } else if (i != 5 && i != 8 && i != 137) {
                Log.e(BleManagerHandler.TAG, "onDescriptorRead error " + i);
                if (BleManagerHandler.this.request instanceof ReadRequest) {
                    BleManagerHandler.this.request.notifyFail(bluetoothGatt.getDevice(), i);
                }
                BleManagerHandler.this.awaitingRequest = null;
                BleManagerHandler.this.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_READ_DESCRIPTOR, i);
            } else {
                BleManagerHandler.this.log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda36
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onDescriptorRead$37(i);
                    }
                });
                if (bluetoothGatt.getDevice().getBondState() != 10) {
                    Log.w(BleManagerHandler.TAG, BleManagerHandler.ERROR_AUTH_ERROR_WHILE_BONDED);
                    BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda37
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                        public final void run(BleManagerCallbacks bleManagerCallbacks) {
                            bleManagerCallbacks.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_AUTH_ERROR_WHILE_BONDED, i);
                        }
                    });
                    return;
                }
                return;
            }
            BleManagerHandler.this.checkCondition();
            BleManagerHandler.this.nextRequest(true);
        }

        static /* synthetic */ String lambda$onDescriptorRead$36(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
            return "Read Response received from descr. " + bluetoothGattDescriptor.getUuid() + ", value: " + ParserUtils.parse(bArr);
        }

        static /* synthetic */ String lambda$onDescriptorRead$37(int i) {
            return "Authentication required (" + i + ")";
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(final BluetoothGatt bluetoothGatt, final BluetoothGattDescriptor bluetoothGattDescriptor, final int i) {
            byte[] value = bluetoothGattDescriptor.getValue();
            if (i == 0) {
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda12
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onDescriptorWrite$39(bluetoothGattDescriptor);
                    }
                });
                if (BleManagerHandler.this.isServiceChangedCCCD(bluetoothGattDescriptor)) {
                    BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda13
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.AnonymousClass4.lambda$onDescriptorWrite$40();
                        }
                    });
                } else if (BleManagerHandler.this.isCCCD(bluetoothGattDescriptor)) {
                    if (value != null && value.length == 2 && value[1] == 0) {
                        byte b = value[0];
                        if (b == 0) {
                            BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda14
                                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                                public final String log() {
                                    return BleManagerHandler.AnonymousClass4.lambda$onDescriptorWrite$41();
                                }
                            });
                        } else if (b == 1) {
                            BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda15
                                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                                public final String log() {
                                    return BleManagerHandler.AnonymousClass4.lambda$onDescriptorWrite$42();
                                }
                            });
                        } else if (b == 2) {
                            BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda16
                                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                                public final String log() {
                                    return BleManagerHandler.AnonymousClass4.lambda$onDescriptorWrite$43();
                                }
                            });
                        }
                        BleManagerHandler.this.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor);
                    }
                } else {
                    BleManagerHandler.this.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor);
                }
                Request request = BleManagerHandler.this.request;
                if (request instanceof WriteRequest) {
                    WriteRequest writeRequest = (WriteRequest) request;
                    if (!writeRequest.notifyPacketSent(bluetoothGatt.getDevice(), value) && (BleManagerHandler.this.requestQueue instanceof ReliableWriteRequest)) {
                        writeRequest.notifyFail(bluetoothGatt.getDevice(), -6);
                        BleManagerHandler.this.requestQueue.cancelQueue();
                    } else if (writeRequest.hasMore()) {
                        BleManagerHandler.this.enqueueFirst(writeRequest);
                    } else {
                        writeRequest.notifySuccess(bluetoothGatt.getDevice());
                    }
                }
            } else if (i != 5 && i != 8 && i != 137) {
                Log.e(BleManagerHandler.TAG, "onDescriptorWrite error " + i);
                if (BleManagerHandler.this.request instanceof WriteRequest) {
                    BleManagerHandler.this.request.notifyFail(bluetoothGatt.getDevice(), i);
                    if (BleManagerHandler.this.requestQueue instanceof ReliableWriteRequest) {
                        BleManagerHandler.this.requestQueue.cancelQueue();
                    }
                }
                BleManagerHandler.this.awaitingRequest = null;
                BleManagerHandler.this.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_WRITE_DESCRIPTOR, i);
            } else {
                BleManagerHandler.this.log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda17
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onDescriptorWrite$44(i);
                    }
                });
                if (bluetoothGatt.getDevice().getBondState() != 10) {
                    Log.w(BleManagerHandler.TAG, BleManagerHandler.ERROR_AUTH_ERROR_WHILE_BONDED);
                    BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda18
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                        public final void run(BleManagerCallbacks bleManagerCallbacks) {
                            bleManagerCallbacks.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_AUTH_ERROR_WHILE_BONDED, i);
                        }
                    });
                    return;
                }
                return;
            }
            BleManagerHandler.this.checkCondition();
            BleManagerHandler.this.nextRequest(true);
        }

        static /* synthetic */ String lambda$onDescriptorWrite$39(BluetoothGattDescriptor bluetoothGattDescriptor) {
            return "Data written to descr. " + bluetoothGattDescriptor.getUuid();
        }

        static /* synthetic */ String lambda$onDescriptorWrite$40() {
            return "Service Changed notifications enabled";
        }

        static /* synthetic */ String lambda$onDescriptorWrite$41() {
            return "Notifications and indications disabled";
        }

        static /* synthetic */ String lambda$onDescriptorWrite$42() {
            return "Notifications enabled";
        }

        static /* synthetic */ String lambda$onDescriptorWrite$43() {
            return "Indications enabled";
        }

        static /* synthetic */ String lambda$onDescriptorWrite$44(int i) {
            return "Authentication required (" + i + ")";
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr) {
            if (BleManagerHandler.this.isServiceChangedCharacteristic(bluetoothGattCharacteristic)) {
                if (Build.VERSION.SDK_INT <= 30) {
                    BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda52
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.AnonymousClass4.lambda$onCharacteristicChanged$46();
                        }
                    });
                    BleManagerHandler.this.operationInProgress = true;
                    BleManagerHandler.this.manager.onServicesInvalidated();
                    BleManagerHandler.this.onDeviceDisconnected();
                    BleManagerHandler.this.taskQueue.clear();
                    BleManagerHandler.this.initQueue = null;
                    BleManagerHandler.this.serviceDiscoveryRequested = true;
                    BleManagerHandler.this.log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda53
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.AnonymousClass4.lambda$onCharacteristicChanged$47();
                        }
                    });
                    BleManagerHandler.this.log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda54
                        @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                        public final String log() {
                            return BleManagerHandler.AnonymousClass4.lambda$onCharacteristicChanged$48();
                        }
                    });
                    bluetoothGatt.discoverServices();
                    return;
                }
                return;
            }
            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(BleManager.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID);
            if (descriptor == null || descriptor.getValue() == null || descriptor.getValue().length != 2 || descriptor.getValue()[0] == 1) {
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda56
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onCharacteristicChanged$49(bluetoothGattCharacteristic, bArr);
                    }
                });
                BleManagerHandler.this.onCharacteristicNotified(bluetoothGatt, bluetoothGattCharacteristic);
            } else {
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda57
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onCharacteristicChanged$50(bluetoothGattCharacteristic, bArr);
                    }
                });
                BleManagerHandler.this.onCharacteristicIndicated(bluetoothGatt, bluetoothGattCharacteristic);
            }
            if (BleManagerHandler.this.batteryLevelNotificationCallback != null && BleManagerHandler.this.isBatteryLevelCharacteristic(bluetoothGattCharacteristic)) {
                BleManagerHandler.this.batteryLevelNotificationCallback.notifyValueChanged(bluetoothGatt.getDevice(), bArr);
            }
            ValueChangedCallback valueChangedCallback = (ValueChangedCallback) BleManagerHandler.this.valueChangedCallbacks.get(bluetoothGattCharacteristic);
            if (valueChangedCallback != null && valueChangedCallback.matches(bArr)) {
                valueChangedCallback.notifyValueChanged(bluetoothGatt.getDevice(), bArr);
            }
            AwaitingRequest awaitingRequest = BleManagerHandler.this.awaitingRequest;
            if (awaitingRequest instanceof WaitForValueChangedRequest) {
                WaitForValueChangedRequest waitForValueChangedRequest = (WaitForValueChangedRequest) awaitingRequest;
                if (BleManagerHandler.this.awaitingRequest.characteristic == bluetoothGattCharacteristic && !BleManagerHandler.this.awaitingRequest.isTriggerPending() && waitForValueChangedRequest.matches(bArr)) {
                    waitForValueChangedRequest.notifyValueChanged(bluetoothGatt.getDevice(), bArr);
                    if (waitForValueChangedRequest.isComplete()) {
                        BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda58
                            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                            public final String log() {
                                return BleManagerHandler.AnonymousClass4.lambda$onCharacteristicChanged$51();
                            }
                        });
                        waitForValueChangedRequest.notifySuccess(bluetoothGatt.getDevice());
                        BleManagerHandler.this.awaitingRequest = null;
                        if (waitForValueChangedRequest.isTriggerCompleteOrNull()) {
                            BleManagerHandler.this.nextRequest(true);
                        }
                    }
                }
            }
            if (BleManagerHandler.this.checkCondition()) {
                BleManagerHandler.this.nextRequest(true);
            }
        }

        static /* synthetic */ String lambda$onCharacteristicChanged$46() {
            return "Service Changed indication received";
        }

        static /* synthetic */ String lambda$onCharacteristicChanged$47() {
            return "Discovering Services...";
        }

        static /* synthetic */ String lambda$onCharacteristicChanged$48() {
            return "gatt.discoverServices()";
        }

        static /* synthetic */ String lambda$onCharacteristicChanged$49(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            return "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value: " + ParserUtils.parse(bArr);
        }

        static /* synthetic */ String lambda$onCharacteristicChanged$50(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            return "Indication received from " + bluetoothGattCharacteristic.getUuid() + ", value: " + ParserUtils.parse(bArr);
        }

        static /* synthetic */ String lambda$onCharacteristicChanged$51() {
            return "Wait for value changed complete";
        }

        static /* synthetic */ String lambda$onMtuChanged$52(int i) {
            return "MTU changed to: " + i;
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, final int i, int i2) {
            if (i2 == 0) {
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda42
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onMtuChanged$52(i);
                    }
                });
                BleManagerHandler.this.mtu = Math.min(515, i);
                BleManagerHandler bleManagerHandler = BleManagerHandler.this;
                bleManagerHandler.onMtuChanged(bluetoothGatt, bleManagerHandler.mtu);
                if (BleManagerHandler.this.request instanceof MtuRequest) {
                    ((MtuRequest) BleManagerHandler.this.request).notifyMtuChanged(bluetoothGatt.getDevice(), BleManagerHandler.this.mtu);
                    BleManagerHandler.this.request.notifySuccess(bluetoothGatt.getDevice());
                }
            } else {
                Log.e(BleManagerHandler.TAG, "onMtuChanged error: " + i2 + ", mtu: " + i);
                if (BleManagerHandler.this.request instanceof MtuRequest) {
                    BleManagerHandler.this.request.notifyFail(bluetoothGatt.getDevice(), i2);
                    BleManagerHandler.this.awaitingRequest = null;
                }
                BleManagerHandler.this.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_MTU_REQUEST, i2);
            }
            BleManagerHandler.this.checkCondition();
            if (BleManagerHandler.this.servicesDiscovered) {
                BleManagerHandler.this.nextRequest(true);
            }
        }

        public void onConnectionUpdated(final BluetoothGatt bluetoothGatt, final int i, final int i2, final int i3, final int i4) {
            if (i4 == 0) {
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda38
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onConnectionUpdated$53(i, i2, i3);
                    }
                });
                BleManagerHandler.this.interval = i;
                BleManagerHandler.this.latency = i2;
                BleManagerHandler.this.timeout = i3;
                BleManagerHandler.this.onConnectionUpdated(bluetoothGatt, i, i2, i3);
                ConnectionParametersUpdatedCallback connectionParametersUpdatedCallback = BleManagerHandler.this.connectionParametersUpdatedCallback;
                if (connectionParametersUpdatedCallback != null) {
                    connectionParametersUpdatedCallback.onConnectionUpdated(bluetoothGatt.getDevice(), i, i2, i3);
                }
                if (BleManagerHandler.this.request instanceof ConnectionPriorityRequest) {
                    ((ConnectionPriorityRequest) BleManagerHandler.this.request).notifyConnectionPriorityChanged(bluetoothGatt.getDevice(), i, i2, i3);
                    BleManagerHandler.this.request.notifySuccess(bluetoothGatt.getDevice());
                }
            } else if (i4 == 59) {
                Log.e(BleManagerHandler.TAG, "onConnectionUpdated received status: Unacceptable connection interval, interval: " + i + ", latency: " + i2 + ", timeout: " + i3);
                BleManagerHandler.this.log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda39
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onConnectionUpdated$54(i, i2, i3);
                    }
                });
                if (BleManagerHandler.this.request instanceof ConnectionPriorityRequest) {
                    BleManagerHandler.this.request.notifyFail(bluetoothGatt.getDevice(), i4);
                    BleManagerHandler.this.awaitingRequest = null;
                }
            } else {
                Log.e(BleManagerHandler.TAG, "onConnectionUpdated received status: " + i4 + ", interval: " + i + ", latency: " + i2 + ", timeout: " + i3);
                BleManagerHandler.this.log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda40
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onConnectionUpdated$55(i4, i, i2, i3);
                    }
                });
                if (BleManagerHandler.this.request instanceof ConnectionPriorityRequest) {
                    BleManagerHandler.this.request.notifyFail(bluetoothGatt.getDevice(), i4);
                    BleManagerHandler.this.awaitingRequest = null;
                }
                BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda41
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                    public final void run(BleManagerCallbacks bleManagerCallbacks) {
                        bleManagerCallbacks.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_CONNECTION_PRIORITY_REQUEST, i4);
                    }
                });
            }
            if (BleManagerHandler.this.connectionPriorityOperationInProgress) {
                BleManagerHandler.this.connectionPriorityOperationInProgress = false;
                BleManagerHandler.this.checkCondition();
                BleManagerHandler.this.nextRequest(true);
            }
        }

        static /* synthetic */ String lambda$onConnectionUpdated$53(int i, int i2, int i3) {
            return "Connection parameters updated (interval: " + (i * 1.25d) + "ms, latency: " + i2 + ", timeout: " + (i3 * 10) + "ms)";
        }

        static /* synthetic */ String lambda$onConnectionUpdated$54(int i, int i2, int i3) {
            return "Connection parameters update failed with status: UNACCEPT CONN INTERVAL (0x3b) (interval: " + (i * 1.25d) + "ms, latency: " + i2 + ", timeout: " + (i3 * 10) + "ms)";
        }

        static /* synthetic */ String lambda$onConnectionUpdated$55(int i, int i2, int i3, int i4) {
            return "Connection parameters update failed with status " + i + " (interval: " + (i2 * 1.25d) + "ms, latency: " + i3 + ", timeout: " + (i4 * 10) + "ms)";
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(final BluetoothGatt bluetoothGatt, final int i, final int i2, final int i3) {
            if (i3 == 0) {
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda59
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onPhyUpdate$57(i, i2);
                    }
                });
                if (BleManagerHandler.this.request instanceof PhyRequest) {
                    ((PhyRequest) BleManagerHandler.this.request).notifyPhyChanged(bluetoothGatt.getDevice(), i, i2);
                    BleManagerHandler.this.request.notifySuccess(bluetoothGatt.getDevice());
                }
            } else {
                BleManagerHandler.this.log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda60
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onPhyUpdate$58(i3);
                    }
                });
                if (BleManagerHandler.this.request instanceof PhyRequest) {
                    BleManagerHandler.this.request.notifyFail(bluetoothGatt.getDevice(), i3);
                    BleManagerHandler.this.awaitingRequest = null;
                }
                BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda61
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                    public final void run(BleManagerCallbacks bleManagerCallbacks) {
                        bleManagerCallbacks.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_PHY_UPDATE, i3);
                    }
                });
            }
            if (BleManagerHandler.this.checkCondition() || (BleManagerHandler.this.request instanceof PhyRequest)) {
                BleManagerHandler.this.nextRequest(true);
            }
        }

        static /* synthetic */ String lambda$onPhyUpdate$57(int i, int i2) {
            return "PHY updated (TX: " + ParserUtils.phyToString(i) + ", RX: " + ParserUtils.phyToString(i2) + ")";
        }

        static /* synthetic */ String lambda$onPhyUpdate$58(int i) {
            return "PHY updated failed with status " + i;
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyRead(final BluetoothGatt bluetoothGatt, final int i, final int i2, final int i3) {
            if (i3 == 0) {
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda23
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onPhyRead$60(i, i2);
                    }
                });
                if (BleManagerHandler.this.request instanceof PhyRequest) {
                    ((PhyRequest) BleManagerHandler.this.request).notifyPhyChanged(bluetoothGatt.getDevice(), i, i2);
                    BleManagerHandler.this.request.notifySuccess(bluetoothGatt.getDevice());
                }
            } else {
                BleManagerHandler.this.log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda24
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onPhyRead$61(i3);
                    }
                });
                if (BleManagerHandler.this.request instanceof PhyRequest) {
                    BleManagerHandler.this.request.notifyFail(bluetoothGatt.getDevice(), i3);
                }
                BleManagerHandler.this.awaitingRequest = null;
                BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda25
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                    public final void run(BleManagerCallbacks bleManagerCallbacks) {
                        bleManagerCallbacks.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_READ_PHY, i3);
                    }
                });
            }
            BleManagerHandler.this.checkCondition();
            BleManagerHandler.this.nextRequest(true);
        }

        static /* synthetic */ String lambda$onPhyRead$60(int i, int i2) {
            return "PHY read (TX: " + ParserUtils.phyToString(i) + ", RX: " + ParserUtils.phyToString(i2) + ")";
        }

        static /* synthetic */ String lambda$onPhyRead$61(int i) {
            return "PHY read failed with status " + i;
        }

        static /* synthetic */ String lambda$onReadRemoteRssi$63(int i) {
            return "Remote RSSI received: " + i + " dBm";
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(final BluetoothGatt bluetoothGatt, final int i, final int i2) {
            if (i2 == 0) {
                BleManagerHandler.this.log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda19
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onReadRemoteRssi$63(i);
                    }
                });
                if (BleManagerHandler.this.request instanceof ReadRssiRequest) {
                    ((ReadRssiRequest) BleManagerHandler.this.request).notifyRssiRead(bluetoothGatt.getDevice(), i);
                    BleManagerHandler.this.request.notifySuccess(bluetoothGatt.getDevice());
                }
            } else {
                BleManagerHandler.this.log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda20
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.AnonymousClass4.lambda$onReadRemoteRssi$64(i2);
                    }
                });
                if (BleManagerHandler.this.request instanceof ReadRssiRequest) {
                    BleManagerHandler.this.request.notifyFail(bluetoothGatt.getDevice(), i2);
                }
                BleManagerHandler.this.awaitingRequest = null;
                BleManagerHandler.this.postCallback(new CallbackRunnable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$4$$ExternalSyntheticLambda21
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.CallbackRunnable
                    public final void run(BleManagerCallbacks bleManagerCallbacks) {
                        bleManagerCallbacks.onError(bluetoothGatt.getDevice(), BleManagerHandler.ERROR_READ_RSSI, i2);
                    }
                });
            }
            BleManagerHandler.this.checkCondition();
            BleManagerHandler.this.nextRequest(true);
        }

        static /* synthetic */ String lambda$onReadRemoteRssi$64(int i) {
            return "Reading remote RSSI failed with status " + i;
        }
    }

    static /* synthetic */ String lambda$onCharacteristicReadRequest$113(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, int i2) {
        return "[Server callback] Read request for characteristic " + bluetoothGattCharacteristic.getUuid() + " (requestId=" + i + ", offset: " + i2 + ")";
    }

    final void onCharacteristicReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, final int i, final int i2, final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        WaitForReadRequest waitForReadRequest;
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda51
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$onCharacteristicReadRequest$113(bluetoothGattCharacteristic, i, i2);
            }
        });
        if (i2 == 0) {
            log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda52
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$onCharacteristicReadRequest$114(bluetoothGattCharacteristic);
                }
            });
        }
        DataProvider dataProvider = this.dataProviders.get(bluetoothGattCharacteristic);
        byte[] data = (i2 != 0 || dataProvider == null) ? null : dataProvider.getData(bluetoothDevice);
        if (data != null) {
            assign(bluetoothGattCharacteristic, data);
        } else {
            Map<BluetoothGattCharacteristic, byte[]> map = this.characteristicValues;
            if (map == null || !map.containsKey(bluetoothGattCharacteristic)) {
                data = bluetoothGattCharacteristic.getValue();
            } else {
                data = this.characteristicValues.get(bluetoothGattCharacteristic);
            }
        }
        AwaitingRequest<?> awaitingRequest = this.awaitingRequest;
        if ((awaitingRequest instanceof WaitForReadRequest) && awaitingRequest.characteristic == bluetoothGattCharacteristic && !this.awaitingRequest.isTriggerPending()) {
            WaitForReadRequest waitForReadRequest2 = (WaitForReadRequest) this.awaitingRequest;
            waitForReadRequest2.setDataIfNull(data);
            data = waitForReadRequest2.getData(this.mtu);
            waitForReadRequest = waitForReadRequest2;
        } else {
            waitForReadRequest = null;
        }
        if (data != null) {
            int length = data.length;
            int i3 = this.mtu;
            if (length > i3 - 1) {
                data = Bytes.copy(data, i2, i3 - 1);
            }
        }
        byte[] bArr = data;
        sendResponse(bluetoothGattServer, bluetoothDevice, 0, i, i2, bArr);
        if (waitForReadRequest != null) {
            waitForReadRequest.notifyPacketRead(bluetoothDevice, bArr);
            if (waitForReadRequest.hasMore()) {
                return;
            }
            if (bArr == null || bArr.length < this.mtu - 1) {
                log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda53
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.lambda$onCharacteristicReadRequest$115();
                    }
                });
                waitForReadRequest.notifySuccess(bluetoothDevice);
                this.awaitingRequest = null;
                nextRequest(true);
                return;
            }
            return;
        }
        if (checkCondition()) {
            nextRequest(true);
        }
    }

    static /* synthetic */ String lambda$onCharacteristicReadRequest$114(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return "[Server] READ request for characteristic " + bluetoothGattCharacteristic.getUuid() + " received";
    }

    static /* synthetic */ String lambda$onCharacteristicReadRequest$115() {
        return "Wait for read complete";
    }

    final void onCharacteristicWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, final int i, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final boolean z, final boolean z2, final int i2, final byte[] bArr) {
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda101
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$onCharacteristicWriteRequest$116(z2, bluetoothGattCharacteristic, i, z, i2, bArr);
            }
        });
        if (i2 == 0) {
            log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda102
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$onCharacteristicWriteRequest$117(z2, z, bluetoothGattCharacteristic, bArr);
                }
            });
        }
        if (z2) {
            sendResponse(bluetoothGattServer, bluetoothDevice, 0, i, i2, bArr);
        }
        if (z) {
            if (this.preparedValues == null) {
                this.preparedValues = new LinkedList();
            }
            if (i2 == 0) {
                this.preparedValues.offer(new Pair<>(bluetoothGattCharacteristic, bArr));
                return;
            }
            Pair<Object, byte[]> pairPeekLast = this.preparedValues.peekLast();
            if (pairPeekLast != null && bluetoothGattCharacteristic.equals(pairPeekLast.first)) {
                this.preparedValues.pollLast();
                this.preparedValues.offer(new Pair<>(bluetoothGattCharacteristic, Bytes.concat((byte[]) pairPeekLast.second, bArr, i2)));
                return;
            } else {
                this.prepareError = 7;
                return;
            }
        }
        if (assignAndNotify(bluetoothDevice, bluetoothGattCharacteristic, bArr) || checkCondition()) {
            nextRequest(true);
        }
    }

    static /* synthetic */ String lambda$onCharacteristicWriteRequest$116(boolean z, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, boolean z2, int i2, byte[] bArr) {
        return "[Server callback] Write " + (z ? "request" : "command") + " to characteristic " + bluetoothGattCharacteristic.getUuid() + " (requestId=" + i + ", prepareWrite=" + z2 + ", responseNeeded=" + z + ", offset: " + i2 + ", value=" + ParserUtils.parseDebug(bArr) + ")";
    }

    static /* synthetic */ String lambda$onCharacteristicWriteRequest$117(boolean z, boolean z2, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        return "[Server] " + (z2 ? "Prepare " : "") + (z ? "WRITE REQUEST" : "WRITE COMMAND") + " for characteristic " + bluetoothGattCharacteristic.getUuid() + " received, value: " + ParserUtils.parse(bArr);
    }

    final void onDescriptorReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, final int i, final int i2, final BluetoothGattDescriptor bluetoothGattDescriptor) {
        WaitForReadRequest waitForReadRequest;
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda8
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$onDescriptorReadRequest$118(bluetoothGattDescriptor, i, i2);
            }
        });
        if (i2 == 0) {
            log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda9
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$onDescriptorReadRequest$119(bluetoothGattDescriptor);
                }
            });
        }
        DataProvider dataProvider = this.dataProviders.get(bluetoothGattDescriptor);
        byte[] data = (i2 != 0 || dataProvider == null) ? null : dataProvider.getData(bluetoothDevice);
        if (data != null) {
            assign(bluetoothGattDescriptor, data);
        } else {
            Map<BluetoothGattDescriptor, byte[]> map = this.descriptorValues;
            if (map == null || !map.containsKey(bluetoothGattDescriptor)) {
                data = bluetoothGattDescriptor.getValue();
            } else {
                data = this.descriptorValues.get(bluetoothGattDescriptor);
            }
        }
        AwaitingRequest<?> awaitingRequest = this.awaitingRequest;
        if ((awaitingRequest instanceof WaitForReadRequest) && awaitingRequest.descriptor == bluetoothGattDescriptor && !this.awaitingRequest.isTriggerPending()) {
            waitForReadRequest = (WaitForReadRequest) this.awaitingRequest;
            waitForReadRequest.setDataIfNull(data);
            data = waitForReadRequest.getData(this.mtu);
        } else {
            waitForReadRequest = null;
        }
        if (data != null) {
            int length = data.length;
            int i3 = this.mtu;
            if (length > i3 - 1) {
                data = Bytes.copy(data, i2, i3 - 1);
            }
        }
        sendResponse(bluetoothGattServer, bluetoothDevice, 0, i, i2, data);
        if (waitForReadRequest != null) {
            waitForReadRequest.notifyPacketRead(bluetoothDevice, data);
            if (waitForReadRequest.hasMore()) {
                return;
            }
            if (data == null || data.length < this.mtu - 1) {
                waitForReadRequest.notifySuccess(bluetoothDevice);
                this.awaitingRequest = null;
                nextRequest(true);
                return;
            }
            return;
        }
        if (checkCondition()) {
            nextRequest(true);
        }
    }

    static /* synthetic */ String lambda$onDescriptorReadRequest$118(BluetoothGattDescriptor bluetoothGattDescriptor, int i, int i2) {
        return "[Server callback] Read request for descriptor " + bluetoothGattDescriptor.getUuid() + " (requestId=" + i + ", offset: " + i2 + ")";
    }

    static /* synthetic */ String lambda$onDescriptorReadRequest$119(BluetoothGattDescriptor bluetoothGattDescriptor) {
        return "[Server] READ request for descriptor " + bluetoothGattDescriptor.getUuid() + " received";
    }

    final void onDescriptorWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, final int i, final BluetoothGattDescriptor bluetoothGattDescriptor, final boolean z, final boolean z2, final int i2, final byte[] bArr) {
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda31
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$onDescriptorWriteRequest$120(z2, bluetoothGattDescriptor, i, z, i2, bArr);
            }
        });
        if (i2 == 0) {
            log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda32
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$onDescriptorWriteRequest$121(z2, z, bluetoothGattDescriptor, bArr);
                }
            });
        }
        if (z2) {
            sendResponse(bluetoothGattServer, bluetoothDevice, 0, i, i2, bArr);
        }
        if (z) {
            if (this.preparedValues == null) {
                this.preparedValues = new LinkedList();
            }
            if (i2 == 0) {
                this.preparedValues.offer(new Pair<>(bluetoothGattDescriptor, bArr));
                return;
            }
            Pair<Object, byte[]> pairPeekLast = this.preparedValues.peekLast();
            if (pairPeekLast != null && bluetoothGattDescriptor.equals(pairPeekLast.first)) {
                this.preparedValues.pollLast();
                this.preparedValues.offer(new Pair<>(bluetoothGattDescriptor, Bytes.concat((byte[]) pairPeekLast.second, bArr, i2)));
                return;
            } else {
                this.prepareError = 7;
                return;
            }
        }
        if (assignAndNotify(bluetoothDevice, bluetoothGattDescriptor, bArr) || checkCondition()) {
            nextRequest(true);
        }
    }

    static /* synthetic */ String lambda$onDescriptorWriteRequest$120(boolean z, BluetoothGattDescriptor bluetoothGattDescriptor, int i, boolean z2, int i2, byte[] bArr) {
        return "[Server callback] Write " + (z ? "request" : "command") + " to descriptor " + bluetoothGattDescriptor.getUuid() + " (requestId=" + i + ", prepareWrite=" + z2 + ", responseNeeded=" + z + ", offset: " + i2 + ", value=" + ParserUtils.parseDebug(bArr) + ")";
    }

    static /* synthetic */ String lambda$onDescriptorWriteRequest$121(boolean z, boolean z2, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        return "[Server] " + (z2 ? "Prepare " : "") + (z ? "WRITE REQUEST" : "WRITE COMMAND") + " request for descriptor " + bluetoothGattDescriptor.getUuid() + " received, value: " + ParserUtils.parse(bArr);
    }

    final void onExecuteWrite(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, final int i, final boolean z) {
        boolean z2;
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda20
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$onExecuteWrite$122(i, z);
            }
        });
        if (z) {
            Deque<Pair<Object, byte[]>> deque = this.preparedValues;
            log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda21
                @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                public final String log() {
                    return BleManagerHandler.lambda$onExecuteWrite$123();
                }
            });
            this.preparedValues = null;
            int i2 = this.prepareError;
            if (i2 != 0) {
                sendResponse(bluetoothGattServer, bluetoothDevice, i2, i, 0, null);
                this.prepareError = 0;
                return;
            }
            sendResponse(bluetoothGattServer, bluetoothDevice, 0, i, 0, null);
            if (deque == null || deque.isEmpty()) {
                return;
            }
            loop0: while (true) {
                z2 = false;
                for (Pair<Object, byte[]> pair : deque) {
                    Object obj = pair.first;
                    if (obj instanceof BluetoothGattCharacteristic) {
                        if (!assignAndNotify(bluetoothDevice, (BluetoothGattCharacteristic) obj, (byte[]) pair.second) && !z2) {
                            break;
                        }
                        z2 = true;
                    } else {
                        Object obj2 = pair.first;
                        if (obj2 instanceof BluetoothGattDescriptor) {
                            if (!assignAndNotify(bluetoothDevice, (BluetoothGattDescriptor) obj2, (byte[]) pair.second) && !z2) {
                                break;
                            }
                            z2 = true;
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (checkCondition() || z2) {
                nextRequest(true);
                return;
            }
            return;
        }
        log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda23
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$onExecuteWrite$124();
            }
        });
        this.preparedValues = null;
        sendResponse(bluetoothGattServer, bluetoothDevice, 0, i, 0, null);
    }

    static /* synthetic */ String lambda$onExecuteWrite$122(int i, boolean z) {
        return "[Server callback] Execute write request (requestId=" + i + ", execute=" + z + ")";
    }

    static /* synthetic */ String lambda$onExecuteWrite$123() {
        return "[Server] Execute write request received";
    }

    static /* synthetic */ String lambda$onExecuteWrite$124() {
        return "[Server] Cancel write request received";
    }

    static /* synthetic */ String lambda$onNotificationSent$125(int i) {
        return "[Server callback] Notification sent (status=" + i + ")";
    }

    final void onNotificationSent(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, final int i) {
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda54
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$onNotificationSent$125(i);
            }
        });
        if (i == 0) {
            notifyNotificationSent(bluetoothDevice);
        } else {
            Log.e(TAG, "onNotificationSent error " + i);
            Request request = this.request;
            if (request instanceof WriteRequest) {
                request.notifyFail(bluetoothDevice, i);
            }
            this.awaitingRequest = null;
            onError(bluetoothDevice, ERROR_NOTIFY, i);
        }
        checkCondition();
        nextRequest(true);
    }

    static /* synthetic */ String lambda$onMtuChanged$126(int i) {
        return "[Server] MTU changed to: " + i;
    }

    final void onMtuChanged(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, final int i) {
        log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda71
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$onMtuChanged$126(i);
            }
        });
        this.mtu = Math.min(515, i);
        nextRequest(checkCondition());
    }

    /* renamed from: no.nordicsemi.android.ble.BleManagerHandler$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$no$nordicsemi$android$ble$Request$Type;

        static {
            int[] iArr = new int[Request.Type.values().length];
            $SwitchMap$no$nordicsemi$android$ble$Request$Type = iArr;
            try {
                iArr[Request.Type.NOTIFY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.INDICATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.WAIT_FOR_NOTIFICATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.WAIT_FOR_INDICATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.WAIT_FOR_READ.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.WAIT_FOR_WRITE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.CONNECT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.DISCONNECT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.ENSURE_BOND.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.CREATE_BOND.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.REMOVE_BOND.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.SET.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.READ.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.WRITE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.READ_DESCRIPTOR.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.WRITE_DESCRIPTOR.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.SET_VALUE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.SET_DESCRIPTOR_VALUE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.BEGIN_RELIABLE_WRITE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.EXECUTE_RELIABLE_WRITE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.ABORT_RELIABLE_WRITE.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.ENABLE_NOTIFICATIONS.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.ENABLE_INDICATIONS.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.DISABLE_NOTIFICATIONS.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.DISABLE_INDICATIONS.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.READ_BATTERY_LEVEL.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.ENABLE_BATTERY_LEVEL_NOTIFICATIONS.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.DISABLE_BATTERY_LEVEL_NOTIFICATIONS.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.ENABLE_SERVICE_CHANGED_INDICATIONS.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.REQUEST_MTU.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.REQUEST_CONNECTION_PRIORITY.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.SET_PREFERRED_PHY.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.READ_PHY.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.READ_RSSI.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.REFRESH_CACHE.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$no$nordicsemi$android$ble$Request$Type[Request.Type.SLEEP.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
        }
    }

    private void notifyNotificationSent(BluetoothDevice bluetoothDevice) {
        Request request = this.request;
        if (request instanceof WriteRequest) {
            WriteRequest writeRequest = (WriteRequest) request;
            int i = AnonymousClass5.$SwitchMap$no$nordicsemi$android$ble$Request$Type[writeRequest.type.ordinal()];
            if (i == 1) {
                log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda111
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.lambda$notifyNotificationSent$127();
                    }
                });
            } else if (i == 2) {
                log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda112
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.lambda$notifyNotificationSent$128();
                    }
                });
            }
            writeRequest.notifyPacketSent(bluetoothDevice, writeRequest.characteristic.getValue());
            if (writeRequest.hasMore()) {
                enqueueFirst(writeRequest);
            } else {
                writeRequest.notifySuccess(bluetoothDevice);
            }
        }
    }

    static /* synthetic */ String lambda$notifyNotificationSent$127() {
        return "[Server] Notification sent";
    }

    static /* synthetic */ String lambda$notifyNotificationSent$128() {
        return "[Server] Indication sent";
    }

    private void notifyNotificationsDisabled(BluetoothDevice bluetoothDevice) {
        Request request = this.request;
        if (request instanceof WriteRequest) {
            WriteRequest writeRequest = (WriteRequest) request;
            int i = AnonymousClass5.$SwitchMap$no$nordicsemi$android$ble$Request$Type[writeRequest.type.ordinal()];
            if (i == 1) {
                log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda138
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.lambda$notifyNotificationsDisabled$129();
                    }
                });
            } else if (i == 2) {
                log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda149
                    @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
                    public final String log() {
                        return BleManagerHandler.lambda$notifyNotificationsDisabled$130();
                    }
                });
            }
            writeRequest.notifyFail(bluetoothDevice, -8);
        }
    }

    static /* synthetic */ String lambda$notifyNotificationsDisabled$129() {
        return "[Server] Notifications disabled";
    }

    static /* synthetic */ String lambda$notifyNotificationsDisabled$130() {
        return "[Server] Indications disabled";
    }

    private void assign(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        Map<BluetoothGattCharacteristic, byte[]> map = this.characteristicValues;
        if (map == null || !map.containsKey(bluetoothGattCharacteristic)) {
            bluetoothGattCharacteristic.setValue(bArr);
        } else {
            this.characteristicValues.put(bluetoothGattCharacteristic, bArr);
        }
    }

    private boolean assignAndNotify(BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        assign(bluetoothGattCharacteristic, bArr);
        ValueChangedCallback valueChangedCallback = this.valueChangedCallbacks.get(bluetoothGattCharacteristic);
        if (valueChangedCallback != null) {
            valueChangedCallback.notifyValueChanged(bluetoothDevice, bArr);
        }
        AwaitingRequest<?> awaitingRequest = this.awaitingRequest;
        if (!(awaitingRequest instanceof WaitForValueChangedRequest)) {
            return false;
        }
        WaitForValueChangedRequest waitForValueChangedRequest = (WaitForValueChangedRequest) awaitingRequest;
        if (awaitingRequest.characteristic != bluetoothGattCharacteristic || this.awaitingRequest.isTriggerPending() || !waitForValueChangedRequest.matches(bArr)) {
            return false;
        }
        waitForValueChangedRequest.notifyValueChanged(bluetoothDevice, bArr);
        if (!waitForValueChangedRequest.isComplete()) {
            return false;
        }
        waitForValueChangedRequest.notifySuccess(bluetoothDevice);
        this.awaitingRequest = null;
        return waitForValueChangedRequest.isTriggerCompleteOrNull();
    }

    private void assign(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        Map<BluetoothGattDescriptor, byte[]> map = this.descriptorValues;
        if (map == null || !map.containsKey(bluetoothGattDescriptor)) {
            bluetoothGattDescriptor.setValue(bArr);
        } else {
            this.descriptorValues.put(bluetoothGattDescriptor, bArr);
        }
    }

    private boolean assignAndNotify(BluetoothDevice bluetoothDevice, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        assign(bluetoothGattDescriptor, bArr);
        ValueChangedCallback valueChangedCallback = this.valueChangedCallbacks.get(bluetoothGattDescriptor);
        if (valueChangedCallback != null) {
            valueChangedCallback.notifyValueChanged(bluetoothDevice, bArr);
        }
        AwaitingRequest<?> awaitingRequest = this.awaitingRequest;
        if (!(awaitingRequest instanceof WaitForValueChangedRequest)) {
            return false;
        }
        WaitForValueChangedRequest waitForValueChangedRequest = (WaitForValueChangedRequest) awaitingRequest;
        if (awaitingRequest.descriptor != bluetoothGattDescriptor || this.awaitingRequest.isTriggerPending() || !waitForValueChangedRequest.matches(bArr)) {
            return false;
        }
        waitForValueChangedRequest.notifyValueChanged(bluetoothDevice, bArr);
        if (!waitForValueChangedRequest.isComplete()) {
            return false;
        }
        waitForValueChangedRequest.notifySuccess(bluetoothDevice);
        this.awaitingRequest = null;
        return waitForValueChangedRequest.isTriggerCompleteOrNull();
    }

    private void sendResponse(BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, int i, int i2, final int i3, final byte[] bArr) {
        final String str;
        if (i == 0) {
            str = "GATT_SUCCESS";
        } else if (i == 6) {
            str = "GATT_REQUEST_NOT_SUPPORTED";
        } else if (i == 7) {
            str = "GATT_INVALID_OFFSET";
        } else {
            throw new InvalidParameterException();
        }
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda62
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$sendResponse$131(str, i3, bArr);
            }
        });
        bluetoothGattServer.sendResponse(bluetoothDevice, i2, i, i3, bArr);
        log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda63
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$sendResponse$132();
            }
        });
    }

    static /* synthetic */ String lambda$sendResponse$131(String str, int i, byte[] bArr) {
        return "server.sendResponse(" + str + ", offset=" + i + ", value=" + ParserUtils.parseDebug(bArr) + ")";
    }

    static /* synthetic */ String lambda$sendResponse$132() {
        return "[Server] Response sent";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkCondition() {
        AwaitingRequest<?> awaitingRequest = this.awaitingRequest;
        if (!(awaitingRequest instanceof ConditionalWaitRequest)) {
            return false;
        }
        ConditionalWaitRequest conditionalWaitRequest = (ConditionalWaitRequest) awaitingRequest;
        if (!conditionalWaitRequest.isFulfilled()) {
            return false;
        }
        log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda60
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$checkCondition$133();
            }
        });
        conditionalWaitRequest.notifySuccess(this.bluetoothDevice);
        this.awaitingRequest = null;
        return true;
    }

    static /* synthetic */ String lambda$checkCondition$133() {
        return "Condition fulfilled";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0016 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0018 A[Catch: all -> 0x038b, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:5:0x0005, B:7:0x0009, B:11:0x0010, B:12:0x0012, B:16:0x0018, B:18:0x001b, B:20:0x001f, B:22:0x0025, B:31:0x004e, B:33:0x0052, B:37:0x005d, B:39:0x0061, B:41:0x006e, B:42:0x007e, B:44:0x0082, B:45:0x008b, B:47:0x0094, B:50:0x009f, B:52:0x00a3, B:55:0x00a8, B:57:0x00b2, B:69:0x00d6, B:72:0x00dc, B:74:0x00e0, B:79:0x00ee, B:81:0x00f2, B:83:0x0103, B:86:0x0116, B:88:0x011a, B:89:0x0122, B:91:0x0126, B:92:0x012e, B:94:0x0136, B:96:0x0141, B:98:0x0145, B:101:0x0155, B:105:0x0167, B:190:0x0361, B:197:0x0375, B:193:0x0367, B:107:0x016c, B:109:0x017a, B:111:0x0180, B:112:0x018a, B:114:0x0190, B:115:0x019a, B:116:0x01a3, B:118:0x01bc, B:119:0x01c8, B:121:0x01d7, B:122:0x01e1, B:123:0x01e5, B:125:0x01f0, B:126:0x01fa, B:128:0x01fe, B:131:0x020b, B:132:0x0211, B:133:0x0217, B:134:0x021d, B:135:0x0223, B:136:0x022b, B:137:0x0233, B:138:0x023b, B:139:0x0243, B:140:0x0249, B:141:0x024f, B:143:0x0255, B:146:0x025f, B:148:0x0266, B:150:0x026a, B:152:0x0272, B:154:0x028b, B:153:0x0280, B:155:0x0293, B:157:0x029a, B:159:0x029e, B:161:0x02a6, B:163:0x02bf, B:162:0x02b4, B:164:0x02c7, B:165:0x02d8, B:166:0x02e0, B:167:0x02f5, B:168:0x02fc, B:171:0x0305, B:172:0x030a, B:173:0x030f, B:174:0x0314, B:175:0x0319, B:176:0x0329, B:178:0x0336, B:180:0x033f, B:182:0x0347, B:183:0x034e, B:187:0x0359, B:100:0x0152, B:200:0x0381, B:23:0x0030, B:25:0x0036, B:27:0x003e, B:28:0x0044), top: B:211:0x0005, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005d A[Catch: all -> 0x038b, TRY_ENTER, TryCatch #2 {, blocks: (B:5:0x0005, B:7:0x0009, B:11:0x0010, B:12:0x0012, B:16:0x0018, B:18:0x001b, B:20:0x001f, B:22:0x0025, B:31:0x004e, B:33:0x0052, B:37:0x005d, B:39:0x0061, B:41:0x006e, B:42:0x007e, B:44:0x0082, B:45:0x008b, B:47:0x0094, B:50:0x009f, B:52:0x00a3, B:55:0x00a8, B:57:0x00b2, B:69:0x00d6, B:72:0x00dc, B:74:0x00e0, B:79:0x00ee, B:81:0x00f2, B:83:0x0103, B:86:0x0116, B:88:0x011a, B:89:0x0122, B:91:0x0126, B:92:0x012e, B:94:0x0136, B:96:0x0141, B:98:0x0145, B:101:0x0155, B:105:0x0167, B:190:0x0361, B:197:0x0375, B:193:0x0367, B:107:0x016c, B:109:0x017a, B:111:0x0180, B:112:0x018a, B:114:0x0190, B:115:0x019a, B:116:0x01a3, B:118:0x01bc, B:119:0x01c8, B:121:0x01d7, B:122:0x01e1, B:123:0x01e5, B:125:0x01f0, B:126:0x01fa, B:128:0x01fe, B:131:0x020b, B:132:0x0211, B:133:0x0217, B:134:0x021d, B:135:0x0223, B:136:0x022b, B:137:0x0233, B:138:0x023b, B:139:0x0243, B:140:0x0249, B:141:0x024f, B:143:0x0255, B:146:0x025f, B:148:0x0266, B:150:0x026a, B:152:0x0272, B:154:0x028b, B:153:0x0280, B:155:0x0293, B:157:0x029a, B:159:0x029e, B:161:0x02a6, B:163:0x02bf, B:162:0x02b4, B:164:0x02c7, B:165:0x02d8, B:166:0x02e0, B:167:0x02f5, B:168:0x02fc, B:171:0x0305, B:172:0x030a, B:173:0x030f, B:174:0x0314, B:175:0x0319, B:176:0x0329, B:178:0x0336, B:180:0x033f, B:182:0x0347, B:183:0x034e, B:187:0x0359, B:100:0x0152, B:200:0x0381, B:23:0x0030, B:25:0x0036, B:27:0x003e, B:28:0x0044), top: B:211:0x0005, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a3 A[Catch: all -> 0x038b, TRY_LEAVE, TryCatch #2 {, blocks: (B:5:0x0005, B:7:0x0009, B:11:0x0010, B:12:0x0012, B:16:0x0018, B:18:0x001b, B:20:0x001f, B:22:0x0025, B:31:0x004e, B:33:0x0052, B:37:0x005d, B:39:0x0061, B:41:0x006e, B:42:0x007e, B:44:0x0082, B:45:0x008b, B:47:0x0094, B:50:0x009f, B:52:0x00a3, B:55:0x00a8, B:57:0x00b2, B:69:0x00d6, B:72:0x00dc, B:74:0x00e0, B:79:0x00ee, B:81:0x00f2, B:83:0x0103, B:86:0x0116, B:88:0x011a, B:89:0x0122, B:91:0x0126, B:92:0x012e, B:94:0x0136, B:96:0x0141, B:98:0x0145, B:101:0x0155, B:105:0x0167, B:190:0x0361, B:197:0x0375, B:193:0x0367, B:107:0x016c, B:109:0x017a, B:111:0x0180, B:112:0x018a, B:114:0x0190, B:115:0x019a, B:116:0x01a3, B:118:0x01bc, B:119:0x01c8, B:121:0x01d7, B:122:0x01e1, B:123:0x01e5, B:125:0x01f0, B:126:0x01fa, B:128:0x01fe, B:131:0x020b, B:132:0x0211, B:133:0x0217, B:134:0x021d, B:135:0x0223, B:136:0x022b, B:137:0x0233, B:138:0x023b, B:139:0x0243, B:140:0x0249, B:141:0x024f, B:143:0x0255, B:146:0x025f, B:148:0x0266, B:150:0x026a, B:152:0x0272, B:154:0x028b, B:153:0x0280, B:155:0x0293, B:157:0x029a, B:159:0x029e, B:161:0x02a6, B:163:0x02bf, B:162:0x02b4, B:164:0x02c7, B:165:0x02d8, B:166:0x02e0, B:167:0x02f5, B:168:0x02fc, B:171:0x0305, B:172:0x030a, B:173:0x030f, B:174:0x0314, B:175:0x0319, B:176:0x0329, B:178:0x0336, B:180:0x033f, B:182:0x0347, B:183:0x034e, B:187:0x0359, B:100:0x0152, B:200:0x0381, B:23:0x0030, B:25:0x0036, B:27:0x003e, B:28:0x0044), top: B:211:0x0005, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a8 A[Catch: all -> 0x038b, TRY_ENTER, TryCatch #2 {, blocks: (B:5:0x0005, B:7:0x0009, B:11:0x0010, B:12:0x0012, B:16:0x0018, B:18:0x001b, B:20:0x001f, B:22:0x0025, B:31:0x004e, B:33:0x0052, B:37:0x005d, B:39:0x0061, B:41:0x006e, B:42:0x007e, B:44:0x0082, B:45:0x008b, B:47:0x0094, B:50:0x009f, B:52:0x00a3, B:55:0x00a8, B:57:0x00b2, B:69:0x00d6, B:72:0x00dc, B:74:0x00e0, B:79:0x00ee, B:81:0x00f2, B:83:0x0103, B:86:0x0116, B:88:0x011a, B:89:0x0122, B:91:0x0126, B:92:0x012e, B:94:0x0136, B:96:0x0141, B:98:0x0145, B:101:0x0155, B:105:0x0167, B:190:0x0361, B:197:0x0375, B:193:0x0367, B:107:0x016c, B:109:0x017a, B:111:0x0180, B:112:0x018a, B:114:0x0190, B:115:0x019a, B:116:0x01a3, B:118:0x01bc, B:119:0x01c8, B:121:0x01d7, B:122:0x01e1, B:123:0x01e5, B:125:0x01f0, B:126:0x01fa, B:128:0x01fe, B:131:0x020b, B:132:0x0211, B:133:0x0217, B:134:0x021d, B:135:0x0223, B:136:0x022b, B:137:0x0233, B:138:0x023b, B:139:0x0243, B:140:0x0249, B:141:0x024f, B:143:0x0255, B:146:0x025f, B:148:0x0266, B:150:0x026a, B:152:0x0272, B:154:0x028b, B:153:0x0280, B:155:0x0293, B:157:0x029a, B:159:0x029e, B:161:0x02a6, B:163:0x02bf, B:162:0x02b4, B:164:0x02c7, B:165:0x02d8, B:166:0x02e0, B:167:0x02f5, B:168:0x02fc, B:171:0x0305, B:172:0x030a, B:173:0x030f, B:174:0x0314, B:175:0x0319, B:176:0x0329, B:178:0x0336, B:180:0x033f, B:182:0x0347, B:183:0x034e, B:187:0x0359, B:100:0x0152, B:200:0x0381, B:23:0x0030, B:25:0x0036, B:27:0x003e, B:28:0x0044), top: B:211:0x0005, inners: #3 }] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [no.nordicsemi.android.ble.Request] */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v3, types: [no.nordicsemi.android.ble.Request] */
    /* JADX WARN: Type inference failed for: r3v5, types: [no.nordicsemi.android.ble.Request] */
    /* JADX WARN: Type inference failed for: r3v9, types: [no.nordicsemi.android.ble.Request] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void nextRequest(boolean r13) {
        /*
            Method dump skipped, instructions count: 974
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.ble.BleManagerHandler.nextRequest(boolean):void");
    }

    static /* synthetic */ String lambda$nextRequest$136() {
        return "Waiting for fulfillment of condition...";
    }

    static /* synthetic */ String lambda$nextRequest$137() {
        return "Condition fulfilled";
    }

    static /* synthetic */ String lambda$nextRequest$138() {
        return "Waiting for read request...";
    }

    static /* synthetic */ String lambda$nextRequest$139() {
        return "Waiting for value change...";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$nextRequest$140(ConnectionPriorityRequest connectionPriorityRequest, BluetoothDevice bluetoothDevice) {
        if (connectionPriorityRequest.notifySuccess(bluetoothDevice)) {
            this.connectionPriorityOperationInProgress = false;
            nextRequest(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$nextRequest$142(PhyRequest phyRequest) {
        if (phyRequest.finished) {
            return;
        }
        log(5, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda7
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$nextRequest$141();
            }
        });
        internalReadPhy();
    }

    static /* synthetic */ String lambda$nextRequest$141() {
        return "Callback not received in 1000 ms";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$nextRequest$143(Request request, BluetoothDevice bluetoothDevice) {
        if (this.request == request) {
            request.notifyFail(bluetoothDevice, -5);
            nextRequest(true);
        }
    }

    static /* synthetic */ String lambda$nextRequest$144() {
        return "Cache refreshed";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$nextRequest$147(Request request, BluetoothDevice bluetoothDevice) {
        log(4, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda128
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$nextRequest$144();
            }
        });
        request.notifySuccess(bluetoothDevice);
        this.request = null;
        AwaitingRequest<?> awaitingRequest = this.awaitingRequest;
        if (awaitingRequest != null) {
            awaitingRequest.notifyFail(bluetoothDevice, -3);
            this.awaitingRequest = null;
        }
        this.taskQueue.clear();
        this.initQueue = null;
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (!this.connected || bluetoothGatt == null) {
            return;
        }
        this.manager.onServicesInvalidated();
        onDeviceDisconnected();
        this.serviceDiscoveryRequested = true;
        this.servicesDiscovered = false;
        log(2, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda129
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$nextRequest$145();
            }
        });
        log(3, new Loggable() { // from class: no.nordicsemi.android.ble.BleManagerHandler$$ExternalSyntheticLambda130
            @Override // no.nordicsemi.android.ble.BleManagerHandler.Loggable
            public final String log() {
                return BleManagerHandler.lambda$nextRequest$146();
            }
        });
        bluetoothGatt.discoverServices();
    }

    static /* synthetic */ String lambda$nextRequest$145() {
        return "Discovering Services...";
    }

    static /* synthetic */ String lambda$nextRequest$146() {
        return "gatt.discoverServices()";
    }

    static /* synthetic */ String lambda$nextRequest$148(SleepRequest sleepRequest) {
        return "sleep(" + sleepRequest.timeout + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isServiceChangedCCCD(BluetoothGattDescriptor bluetoothGattDescriptor) {
        return bluetoothGattDescriptor != null && BleManager.SERVICE_CHANGED_CHARACTERISTIC.equals(bluetoothGattDescriptor.getCharacteristic().getUuid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isServiceChangedCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return bluetoothGattCharacteristic != null && BleManager.SERVICE_CHANGED_CHARACTERISTIC.equals(bluetoothGattCharacteristic.getUuid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public boolean isBatteryLevelCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return bluetoothGattCharacteristic != null && BleManager.BATTERY_LEVEL_CHARACTERISTIC.equals(bluetoothGattCharacteristic.getUuid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCCCD(BluetoothGattDescriptor bluetoothGattDescriptor) {
        return bluetoothGattDescriptor != null && BleManager.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID.equals(bluetoothGattDescriptor.getUuid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(int i, Loggable loggable) {
        if (i >= this.manager.getMinLogPriority()) {
            this.manager.log(i, loggable.log());
        }
    }
}
