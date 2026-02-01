package com.android.ddmlib.internal.jdwp;

import com.android.ddmlib.AdbCommandRejectedException;
import com.android.ddmlib.AdbHelper;
import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.DdmPreferences;
import com.android.ddmlib.JdwpHandshake;
import com.android.ddmlib.TimeoutException;
import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;
import com.android.ddmlib.internal.jdwp.interceptor.ClientInitializationInterceptor;
import com.android.ddmlib.internal.jdwp.interceptor.DebuggerInterceptor;
import com.android.ddmlib.internal.jdwp.interceptor.Interceptor;
import com.android.ddmlib.internal.jdwp.interceptor.NoReplyPacketInterceptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class JdwpClientManager implements JdwpSocketHandler {
    private boolean isHandshakeComplete;
    private SocketChannel mAdbSocket;
    private final Set<JdwpProxyClient> mClients;
    private final List<Interceptor> mInterceptors;
    private JdwpConnectionReader mReader;
    private final List<ShutdownListener> mShutdownListeners;

    interface ShutdownListener {
        void shutdown();
    }

    public JdwpClientManager(JdwpClientManagerId id2, Selector selector) throws IOException, TimeoutException, AdbCommandRejectedException {
        this(AdbHelper.createPassThroughConnection(AndroidDebugBridge.getSocketAddress(), id2.deviceSerial, id2.pid));
        this.mAdbSocket.configureBlocking(false);
        this.mAdbSocket.register(selector, 1, this);
    }

    JdwpClientManager(SocketChannel socket) throws IOException, TimeoutException, AdbCommandRejectedException {
        this.mClients = new HashSet();
        ArrayList arrayList = new ArrayList();
        this.mInterceptors = arrayList;
        this.mShutdownListeners = new ArrayList();
        this.isHandshakeComplete = false;
        this.mReader = new JdwpConnectionReader(socket, 1024);
        this.mAdbSocket = socket;
        arrayList.add(new NoReplyPacketInterceptor());
        arrayList.add(new ClientInitializationInterceptor());
        arrayList.add(new DebuggerInterceptor());
        sendHandshake();
    }

    private void sendHandshake() throws IOException, TimeoutException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(JdwpHandshake.HANDSHAKE_LEN);
        JdwpHandshake.putHandshake(byteBufferAllocate);
        writeRaw(byteBufferAllocate);
    }

    void addListener(JdwpProxyClient client) {
        this.mClients.add(client);
    }

    void removeListener(JdwpProxyClient client) {
        this.mClients.remove(client);
    }

    void addShutdownListener(ShutdownListener listener) {
        this.mShutdownListeners.add(listener);
    }

    void addInterceptor(Interceptor interceptor) {
        this.mInterceptors.add(interceptor);
    }

    @Override // com.android.ddmlib.internal.jdwp.JdwpSocketHandler
    public void shutdown() throws IOException {
        Iterator<ShutdownListener> it = this.mShutdownListeners.iterator();
        while (it.hasNext()) {
            it.next().shutdown();
        }
        this.mShutdownListeners.clear();
        while (!this.mClients.isEmpty()) {
            JdwpProxyClient next = this.mClients.iterator().next();
            next.shutdown();
            if (this.mClients.contains(next)) {
                this.mClients.remove(next);
            }
        }
        SocketChannel socketChannel = this.mAdbSocket;
        if (socketChannel != null) {
            socketChannel.close();
            this.mAdbSocket = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        r0 = r6.mReader.readPacket();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r0 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        r1 = java.nio.ByteBuffer.allocate(r0.getLength());
        r0.copy(r1);
        r2 = r6.mClients.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        if (r2.hasNext() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        r3 = r2.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        if (filterToClient(r3, r0) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
    
        r3.write(r1.array(), r1.position());
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
    
        r0.consume();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
    
        return;
     */
    @Override // com.android.ddmlib.internal.jdwp.JdwpSocketHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void read() throws java.io.IOException, com.android.ddmlib.TimeoutException {
        /*
            r6 = this;
            java.nio.channels.SocketChannel r0 = r6.mAdbSocket
            if (r0 != 0) goto L5
            return
        L5:
            com.android.ddmlib.internal.jdwp.JdwpConnectionReader r0 = r6.mReader
            int r0 = r0.read()
            r1 = -1
            if (r0 == r1) goto L77
        Le:
            boolean r0 = r6.isHandshakeComplete
            if (r0 != 0) goto L3b
            com.android.ddmlib.internal.jdwp.JdwpConnectionReader r0 = r6.mReader
            boolean r0 = r0.isHandshake()
            if (r0 == 0) goto L25
            com.android.ddmlib.internal.jdwp.JdwpConnectionReader r0 = r6.mReader
            int r1 = com.android.ddmlib.JdwpHandshake.HANDSHAKE_LEN
            r0.consumeData(r1)
            r0 = 1
            r6.isHandshakeComplete = r0
            goto L3b
        L25:
            com.android.ddmlib.internal.jdwp.JdwpConnectionReader r0 = r6.mReader
            boolean r0 = r0.isAPNMPacket()
            if (r0 != 0) goto L35
            java.lang.String r0 = "DDMLIB"
            java.lang.String r1 = "An unexpected packet was received before the handshake."
            com.android.ddmlib.Log.e(r0, r1)
            return
        L35:
            com.android.ddmlib.internal.jdwp.JdwpConnectionReader r0 = r6.mReader
            r0.consumePacket()
            goto Le
        L3b:
            com.android.ddmlib.internal.jdwp.JdwpConnectionReader r0 = r6.mReader
            com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket r0 = r0.readPacket()
            if (r0 == 0) goto L76
            int r1 = r0.getLength()
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)
            r0.copy(r1)
            java.util.Set<com.android.ddmlib.internal.jdwp.JdwpProxyClient> r2 = r6.mClients
            java.util.Iterator r2 = r2.iterator()
        L54:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L72
            java.lang.Object r3 = r2.next()
            com.android.ddmlib.internal.jdwp.JdwpProxyClient r3 = (com.android.ddmlib.internal.jdwp.JdwpProxyClient) r3
            boolean r4 = r6.filterToClient(r3, r0)
            if (r4 != 0) goto L54
            byte[] r4 = r1.array()
            int r5 = r1.position()
            r3.write(r4, r5)
            goto L54
        L72:
            r0.consume()
            goto L3b
        L76:
            return
        L77:
            r6.shutdown()
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.String r1 = "Client disconnected"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.ddmlib.internal.jdwp.JdwpClientManager.read():void");
    }

    void write(JdwpProxyClient from, JdwpPacket packet) throws IOException, TimeoutException {
        if (this.mAdbSocket == null || filterToDevice(from, packet)) {
            return;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(packet.getLength());
        packet.copy(byteBufferAllocate);
        writeRaw(byteBufferAllocate);
    }

    void writeRaw(ByteBuffer sendBuffer) throws IOException, TimeoutException {
        JdwpLoggingUtils.log("DEVICE", "WRITE", sendBuffer.array(), sendBuffer.position());
        AdbHelper.write(this.mAdbSocket, sendBuffer.array(), sendBuffer.position(), DdmPreferences.getTimeOut());
    }

    private boolean filterToDevice(JdwpProxyClient client, JdwpPacket packet) throws IOException, TimeoutException {
        Iterator<Interceptor> it = this.mInterceptors.iterator();
        boolean zFilterToDevice = false;
        while (it.hasNext()) {
            zFilterToDevice |= it.next().filterToDevice(client, packet);
        }
        return zFilterToDevice;
    }

    private boolean filterToClient(JdwpProxyClient client, JdwpPacket packet) throws IOException, TimeoutException {
        Iterator<Interceptor> it = this.mInterceptors.iterator();
        boolean zFilterToClient = false;
        while (it.hasNext()) {
            zFilterToClient |= it.next().filterToClient(client, packet);
        }
        return zFilterToClient;
    }
}
