package com.android.ddmlib.internal;

import com.android.ddmlib.Client;
import com.android.ddmlib.ClientData;
import com.android.ddmlib.DdmConstants;
import com.android.ddmlib.DdmPreferences;
import com.android.ddmlib.DebugViewDumpHandler;
import com.android.ddmlib.IDevice;
import com.android.ddmlib.JdwpHandshake;
import com.android.ddmlib.Log;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleExit;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleHeap;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleHello;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleNativeHeap;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleProfiling;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleThread;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleViewDebug;
import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;
import com.android.ddmlib.jdwp.JdwpPipe;
import com.android.ddmlib.jdwp.JdwpProtocol;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ClientImpl extends JdwpPipe implements Client {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INITIAL_BUF_SIZE = 2048;
    private static final int ST_AWAIT_SHAKE = 10;
    private static final int ST_DISCONNECTED = 21;
    private static final int ST_ERROR = 20;
    private static final int ST_INIT = 1;
    private static final int ST_NEED_DDM_PKT = 11;
    private static final int ST_NOT_DDM = 12;
    private static final int ST_NOT_JDWP = 2;
    private static final int ST_READY = 13;
    private volatile SocketChannel mChan;
    private ClientData mClientData;
    private int mConnState;
    private Debugger mDebugger;
    private DeviceImpl mDevice;
    private boolean mHeapInfoUpdateEnabled;
    private boolean mHeapSegmentUpdateEnabled;
    private final int mMaxPacketSize;
    private ByteBuffer mReadBuffer;
    private boolean mThreadUpdateEnabled;

    public ClientImpl(DeviceImpl device, SocketChannel chan, int pid) {
        super(new JdwpProtocol());
        this.mMaxPacketSize = DdmPreferences.getJdwpMaxPacketSize();
        this.mDevice = device;
        this.mChan = chan;
        this.mReadBuffer = ByteBuffer.allocate(2048);
        this.mConnState = 1;
        this.mClientData = new ClientData(this, pid);
        this.mThreadUpdateEnabled = DdmPreferences.getInitialThreadUpdate();
        this.mHeapInfoUpdateEnabled = DdmPreferences.getInitialHeapUpdate();
        this.mHeapSegmentUpdateEnabled = DdmPreferences.getInitialHeapUpdate();
    }

    public String toString() {
        return "[Client pid: " + this.mClientData.getPid() + "]";
    }

    @Override // com.android.ddmlib.Client
    public IDevice getDevice() {
        return this.mDevice;
    }

    public DeviceImpl getDeviceImpl() {
        return this.mDevice;
    }

    @Override // com.android.ddmlib.Client
    public int getDebuggerListenPort() {
        if (getDebugger() == null) {
            return -1;
        }
        return getDebugger().getListenPort();
    }

    @Override // com.android.ddmlib.Client
    public boolean isDdmAware() {
        int i = this.mConnState;
        if (i != 1 && i != 2 && i != 20 && i != 21) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                    break;
                case 13:
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    @Override // com.android.ddmlib.Client
    public boolean isDebuggerAttached() {
        Debugger debugger = this.mDebugger;
        return debugger != null && debugger.isDebuggerAttached();
    }

    Debugger getDebugger() {
        return this.mDebugger;
    }

    @Override // com.android.ddmlib.Client
    public ClientData getClientData() {
        return this.mClientData;
    }

    @Override // com.android.ddmlib.Client
    public void executeGarbageCollector() {
        try {
            HandleHeap.sendHPGC(this);
        } catch (IOException unused) {
            Log.w("ddms", "Send of HPGC message failed");
        }
    }

    /* renamed from: com.android.ddmlib.internal.ClientImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$ddmlib$ClientData$MethodProfilingStatus;

        static {
            int[] iArr = new int[ClientData.MethodProfilingStatus.values().length];
            $SwitchMap$com$android$ddmlib$ClientData$MethodProfilingStatus = iArr;
            try {
                iArr[ClientData.MethodProfilingStatus.TRACER_ON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$ddmlib$ClientData$MethodProfilingStatus[ClientData.MethodProfilingStatus.SAMPLER_ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$android$ddmlib$ClientData$MethodProfilingStatus[ClientData.MethodProfilingStatus.OFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Deprecated
    public void toggleMethodProfiling() {
        try {
            int i = AnonymousClass1.$SwitchMap$com$android$ddmlib$ClientData$MethodProfilingStatus[this.mClientData.getMethodProfilingStatus().ordinal()];
            if (i == 1) {
                stopMethodTracer();
            } else if (i == 2) {
                stopSamplingProfiler();
            } else if (i == 3) {
                startMethodTracer();
            }
        } catch (IOException unused) {
            Log.w("ddms", "Toggle method profiling failed");
        }
    }

    private static int getProfileBufferSize() {
        return DdmPreferences.getProfilerBufferSizeMb() * 1048576;
    }

    @Override // com.android.ddmlib.Client
    public void startMethodTracer() throws IOException {
        boolean zHasFeature = this.mClientData.hasFeature(ClientData.FEATURE_PROFILING_STREAMING);
        int profileBufferSize = getProfileBufferSize();
        if (zHasFeature) {
            HandleProfiling.sendMPSS(this, profileBufferSize, 0);
        } else {
            HandleProfiling.sendMPRS(this, "/sdcard/" + this.mClientData.getClientDescription().replaceAll("\\:.*", "") + DdmConstants.DOT_TRACE, profileBufferSize, 0);
        }
    }

    @Override // com.android.ddmlib.Client
    public void stopMethodTracer() throws IOException {
        if (this.mClientData.hasFeature(ClientData.FEATURE_PROFILING_STREAMING)) {
            HandleProfiling.sendMPSE(this);
        } else {
            HandleProfiling.sendMPRE(this);
        }
    }

    @Override // com.android.ddmlib.Client
    public void startSamplingProfiler(int samplingInterval, TimeUnit timeUnit) throws IOException {
        HandleProfiling.sendSPSS(this, getProfileBufferSize(), samplingInterval, timeUnit);
    }

    @Override // com.android.ddmlib.Client
    public void stopSamplingProfiler() throws IOException {
        HandleProfiling.sendSPSE(this);
    }

    public boolean startOpenGlTracing() {
        if (!this.mClientData.hasFeature(ClientData.FEATURE_OPENGL_TRACING)) {
            return false;
        }
        try {
            HandleViewDebug.sendStartGlTracing(this);
            return true;
        } catch (IOException unused) {
            Log.w("ddms", "Start OpenGL Tracing failed");
            return false;
        }
    }

    public boolean stopOpenGlTracing() {
        if (!this.mClientData.hasFeature(ClientData.FEATURE_OPENGL_TRACING)) {
            return false;
        }
        try {
            HandleViewDebug.sendStopGlTracing(this);
            return true;
        } catch (IOException unused) {
            Log.w("ddms", "Stop OpenGL Tracing failed");
            return false;
        }
    }

    public void requestMethodProfilingStatus() {
        try {
            HandleHeap.sendREAQ(this);
        } catch (IOException e) {
            Log.e("ddmlib", e);
        }
    }

    public void setThreadUpdateEnabled(boolean enabled) {
        this.mThreadUpdateEnabled = enabled;
        if (!enabled) {
            this.mClientData.clearThreads();
        }
        try {
            HandleThread.sendTHEN(this, enabled);
        } catch (IOException e) {
            e.printStackTrace();
        }
        update(8);
    }

    public boolean isThreadUpdateEnabled() {
        return this.mThreadUpdateEnabled;
    }

    public void requestThreadUpdate() {
        HandleThread.requestThreadUpdate(this);
    }

    public void requestThreadStackTrace(int threadId) {
        HandleThread.requestThreadStackCallRefresh(this, threadId);
    }

    public void setHeapUpdateEnabled(boolean enabled) {
        setHeapInfoUpdateEnabled(enabled);
        setHeapSegmentUpdateEnabled(enabled);
    }

    public void setHeapInfoUpdateEnabled(boolean enabled) {
        this.mHeapInfoUpdateEnabled = enabled;
        try {
            HandleHeap.sendHPIF(this, enabled ? 3 : 0);
        } catch (IOException unused) {
        }
        update(32);
    }

    public void setHeapSegmentUpdateEnabled(boolean z) {
        this.mHeapSegmentUpdateEnabled = z;
        try {
            HandleHeap.sendHPSG(this, z ? 1 : 0, 0);
        } catch (IOException unused) {
        }
        update(32);
    }

    public void initializeHeapUpdateStatus() {
        setHeapInfoUpdateEnabled(this.mHeapInfoUpdateEnabled);
    }

    public void updateHeapInfo() {
        try {
            HandleHeap.sendHPIF(this, 1);
        } catch (IOException unused) {
        }
    }

    public boolean isHeapUpdateEnabled() {
        return this.mHeapInfoUpdateEnabled || this.mHeapSegmentUpdateEnabled;
    }

    public boolean requestNativeHeapInformation() {
        try {
            HandleNativeHeap.sendNHGT(this);
            return true;
        } catch (IOException e) {
            Log.e("ddmlib", e);
            return false;
        }
    }

    @Override // com.android.ddmlib.Client
    public void enableAllocationTracker(boolean enable) {
        try {
            HandleHeap.sendREAE(this, enable);
        } catch (IOException e) {
            Log.e("ddmlib", e);
        }
    }

    public void requestAllocationStatus() {
        try {
            HandleHeap.sendREAQ(this);
        } catch (IOException unused) {
            Log.w("ddmlib", "IO Error while obtaining allocation status");
        }
    }

    @Override // com.android.ddmlib.Client
    public void requestAllocationDetails() {
        try {
            HandleHeap.sendREAL(this);
        } catch (IOException e) {
            Log.e("ddmlib", e);
        }
    }

    @Override // com.android.ddmlib.Client
    public void kill() {
        try {
            HandleExit.sendEXIT(this, 1);
        } catch (IOException unused) {
            Log.w("ddms", "Send of EXIT message failed");
        }
    }

    public void register(Selector sel) throws IOException {
        SocketChannel socketChannel = this.mChan;
        if (socketChannel != null) {
            socketChannel.register(sel, 1, this);
        }
    }

    void listenForDebugger() throws IOException {
        this.mDebugger = new Debugger(this);
    }

    boolean sendHandshake() throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(JdwpHandshake.HANDSHAKE_LEN);
        try {
            JdwpHandshake.putHandshake(byteBufferAllocate);
            int iPosition = byteBufferAllocate.position();
            byteBufferAllocate.flip();
            if (this.mChan.write(byteBufferAllocate) != iPosition) {
                throw new IOException("partial handshake write");
            }
            this.mConnState = 10;
            return true;
        } catch (IOException e) {
            Log.e("ddms-client", "IO error during handshake: " + e.getMessage());
            this.mConnState = 20;
            close(true);
            return false;
        }
    }

    @Override // com.android.ddmlib.jdwp.JdwpPipe
    protected void send(JdwpPacket packet) throws IOException {
        SocketChannel socketChannel = this.mChan;
        if (socketChannel == null) {
            Log.v("ddms", "Not sending packet -- client is closed");
            return;
        }
        packet.log("Client: sending jdwp packet to Android Device");
        synchronized (socketChannel) {
            try {
                try {
                    packet.write(socketChannel);
                } catch (IOException e) {
                    removeReplyInterceptor(packet.getId());
                    throw e;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void read() throws BufferOverflowException, IOException {
        SocketChannel socketChannel = this.mChan;
        if (socketChannel == null) {
            throw new IOException("Can't read from a closed channel.");
        }
        if (this.mReadBuffer.position() == this.mReadBuffer.capacity()) {
            if (this.mReadBuffer.capacity() * 2 > this.mMaxPacketSize) {
                Log.e("ddms", "Exceeded MAX_BUF_SIZE!");
                throw new BufferOverflowException();
            }
            Log.d("ddms", "Expanding read buffer to " + (this.mReadBuffer.capacity() * 2));
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.mReadBuffer.capacity() * 2);
            this.mReadBuffer.position(0);
            byteBufferAllocate.put(this.mReadBuffer);
            this.mReadBuffer = byteBufferAllocate;
        }
        int i = socketChannel.read(this.mReadBuffer);
        if (i < 0) {
            throw new IOException("read failed");
        }
        Log.v("ddms", "Read " + i + " bytes from " + this);
    }

    public JdwpPacket getJdwpPacket() throws IOException {
        int i = this.mConnState;
        if (i != 10) {
            if (i == 11 || i == 12 || i == 13) {
                if (this.mReadBuffer.position() != 0) {
                    Log.v("ddms", "Checking " + this.mReadBuffer.position() + " bytes");
                }
                return JdwpPacket.findPacket(this.mReadBuffer);
            }
            Log.e("ddms", "Receiving data in state = " + this.mConnState);
            return null;
        }
        consumeInvalidPackets();
        int iFindHandshake = JdwpHandshake.findHandshake(this.mReadBuffer);
        if (iFindHandshake == 1) {
            Log.d("ddms", "Good handshake from client, sending HELO to " + this.mClientData.getPid());
            JdwpHandshake.consumeHandshake(this.mReadBuffer);
            this.mConnState = 11;
            HandleHello.sendHelloCommands(this, 1);
            return getJdwpPacket();
        }
        if (iFindHandshake == 2) {
            Log.d("ddms", "No handshake from client yet.");
        } else if (iFindHandshake == 3) {
            Log.d("ddms", "Bad handshake from client");
            if (MonitorThread.getInstance().getRetryOnBadHandshake()) {
                this.mDevice.getClientTracker().trackClientToDropAndReopen(this);
            } else {
                this.mConnState = 2;
                close(true);
            }
        } else {
            Log.e("ddms", "Unknown packet while waiting for client handshake");
        }
        return null;
    }

    void consumeInvalidPackets() {
        while (true) {
            this.mReadBuffer.mark();
            try {
                JdwpPacket jdwpPacketFindPacket = JdwpPacket.findPacket(this.mReadBuffer);
                if (jdwpPacketFindPacket == null || jdwpPacketFindPacket.isError() || jdwpPacketFindPacket.isEmpty()) {
                    break;
                } else {
                    jdwpPacketFindPacket.consume();
                }
            } catch (IndexOutOfBoundsException unused) {
                this.mReadBuffer.reset();
                return;
            }
        }
        this.mReadBuffer.reset();
    }

    public void packetFailed(JdwpPacket reply) {
        int i = this.mConnState;
        if (i == 11) {
            Log.d("ddms", "Marking " + this + " as non-DDM client");
            this.mConnState = 12;
        } else if (i != 12) {
            Log.w("ddms", "WEIRD: got JDWP failure packet on DDM req");
        }
    }

    public synchronized boolean ddmSeen() {
        int i = this.mConnState;
        if (i == 11) {
            this.mConnState = 13;
            return false;
        }
        if (i != 13) {
            Log.w("ddms", "WEIRD: in ddmSeen with state=" + this.mConnState);
        }
        return true;
    }

    public void close(boolean notify) {
        Log.d("ddms", "Closing " + toString());
        clear();
        try {
            SocketChannel socketChannel = this.mChan;
            this.mChan = null;
            if (socketChannel != null) {
                socketChannel.close();
            }
            Debugger debugger = this.mDebugger;
            if (debugger != null) {
                debugger.close();
                this.mDebugger = null;
            }
        } catch (IOException unused) {
            Log.w("ddms", "failed to close " + this);
        }
        this.mDevice.removeClient(this, notify);
    }

    @Override // com.android.ddmlib.Client
    public boolean isValid() {
        return this.mChan != null;
    }

    public void update(int changeMask) {
        this.mDevice.update(this, changeMask);
    }

    @Override // com.android.ddmlib.Client
    public void notifyVmMirrorExited() {
        this.mDevice.getClientTracker().trackClientToDropAndReopen(this);
    }

    @Override // com.android.ddmlib.Client
    public void listViewRoots(DebugViewDumpHandler replyHandler) throws IOException {
        HandleViewDebug.listViewRoots(this, replyHandler);
    }

    @Override // com.android.ddmlib.Client
    public void captureView(String viewRoot, String view, DebugViewDumpHandler handler) throws IOException {
        HandleViewDebug.captureView(this, viewRoot, view, handler);
    }

    @Override // com.android.ddmlib.Client
    public void dumpViewHierarchy(String viewRoot, boolean skipChildren, boolean includeProperties, boolean useV2, DebugViewDumpHandler handler) throws IOException {
        HandleViewDebug.dumpViewHierarchy(this, viewRoot, skipChildren, includeProperties, useV2, handler);
    }

    @Override // com.android.ddmlib.Client
    public void dumpDisplayList(String viewRoot, String view) throws IOException {
        HandleViewDebug.dumpDisplayList(this, viewRoot, view);
    }
}
