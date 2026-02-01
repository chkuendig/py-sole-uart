package com.android.ddmlib.internal;

import com.android.ddmlib.ClientData;
import com.android.ddmlib.JdwpHandshake;
import com.android.ddmlib.Log;
import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;
import com.android.ddmlib.jdwp.JdwpPipe;
import com.android.utils.XmlUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/* loaded from: classes3.dex */
public class Debugger extends JdwpPipe {
    private static final int INITIAL_BUF_SIZE = 1024;
    private static final int MAX_BUF_SIZE = 16777216;
    private static final int PRE_DATA_BUF_SIZE = 1024;
    private SocketChannel mChannel;
    private final ClientImpl mClient;
    private ConnectionState mConnState;
    private ServerSocketChannel mListenChannel;
    private int mListenPort;
    private ByteBuffer mPreDataBuffer;
    private ByteBuffer mReadBuffer;

    enum ConnectionState {
        ST_NOT_CONNECTED,
        ST_AWAIT_SHAKE,
        ST_READY
    }

    int getReadBufferInitialCapacity() {
        return 1024;
    }

    int getReadBufferMaximumCapacity() {
        return 16777216;
    }

    public Debugger(ClientImpl client) throws IOException {
        this(client, 0);
    }

    Debugger(ClientImpl client, int listenPort) throws IOException {
        super(client.getJdwpProtocol());
        this.mClient = client;
        ServerSocketChannel serverSocketChannelOpen = ServerSocketChannel.open();
        this.mListenChannel = serverSocketChannelOpen;
        serverSocketChannelOpen.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getByName("localhost"), listenPort);
        this.mListenChannel.socket().setReuseAddress(true);
        this.mListenChannel.socket().bind(inetSocketAddress);
        this.mListenPort = this.mListenChannel.socket().getLocalPort();
        this.mReadBuffer = ByteBuffer.allocate(1024);
        this.mPreDataBuffer = ByteBuffer.allocate(1024);
        this.mConnState = ConnectionState.ST_NOT_CONNECTED;
        Log.d("ddms", "Created: " + toString());
    }

    int getListenPort() {
        return this.mListenPort;
    }

    int getReadBufferCapacity() {
        return this.mReadBuffer.capacity();
    }

    ConnectionState getConnectionState() {
        return this.mConnState;
    }

    boolean isDebuggerAttached() {
        return this.mChannel != null;
    }

    public String toString() {
        return "[Debugger " + this.mListenPort + XmlUtils.XML_COMMENT_END + this.mClient.getClientData().getPid() + (this.mConnState != ConnectionState.ST_READY ? " inactive]" : " active]");
    }

    void registerListener(Selector sel) throws IOException {
        this.mListenChannel.register(sel, 16, this);
    }

    ClientImpl getClient() {
        return this.mClient;
    }

    synchronized SocketChannel accept() throws IOException {
        return accept(this.mListenChannel);
    }

    synchronized SocketChannel accept(ServerSocketChannel listenChan) throws IOException {
        if (listenChan == null) {
            return null;
        }
        SocketChannel socketChannelAccept = listenChan.accept();
        if (this.mChannel != null) {
            Log.w("ddms", "debugger already talking to " + this.mClient + " on " + this.mListenPort);
            socketChannelAccept.close();
            return null;
        }
        this.mChannel = socketChannelAccept;
        socketChannelAccept.configureBlocking(false);
        this.mConnState = ConnectionState.ST_AWAIT_SHAKE;
        return this.mChannel;
    }

    synchronized void closeData() {
        SocketChannel socketChannel;
        try {
            socketChannel = this.mChannel;
        } catch (IOException unused) {
            Log.w("ddms", "Failed to close data " + this);
        }
        if (socketChannel != null) {
            socketChannel.close();
            this.mChannel = null;
            this.mConnState = ConnectionState.ST_NOT_CONNECTED;
            this.mClient.getClientData().setDebuggerConnectionStatus(ClientData.DebuggerStatus.DEFAULT);
            this.mClient.update(2);
        }
    }

    synchronized void close() {
        try {
            ServerSocketChannel serverSocketChannel = this.mListenChannel;
            if (serverSocketChannel != null) {
                serverSocketChannel.close();
            }
            this.mListenChannel = null;
            closeData();
        } catch (IOException unused) {
            Log.w("ddms", "Failed to close listener " + this);
        }
    }

    void processChannelData() {
        try {
            read();
            JdwpPacket jdwpPacket = getJdwpPacket();
            while (jdwpPacket != null) {
                Log.v("ddms", "Forwarding dbg req 0x" + Integer.toHexString(jdwpPacket.getId()) + " to " + getClient());
                jdwpPacket.log("Debugger: forwarding jdwp packet from Java Debugger to Client");
                incoming(jdwpPacket, getClient());
                jdwpPacket.consume();
                jdwpPacket = getJdwpPacket();
            }
        } catch (IOException | BufferOverflowException unused) {
            Log.d("ddms", "Closing connection to debugger " + this + " (recycling client connection as well)");
            closeData();
            ClientImpl client = getClient();
            ((DeviceImpl) client.getDevice()).getClientTracker().trackClientToDropAndReopen(client);
        }
    }

    void read() throws IOException {
        if (this.mReadBuffer.position() == 0 && this.mReadBuffer.capacity() > 1024) {
            Log.i("ddms", String.format("Shrinking buffer from %d bytes to %d bytes", Integer.valueOf(this.mReadBuffer.capacity()), 1024));
            this.mReadBuffer = ByteBuffer.allocate(1024);
        }
        if (this.mReadBuffer.position() == this.mReadBuffer.capacity()) {
            int iCapacity = this.mReadBuffer.capacity() * 2;
            if (iCapacity > 16777216) {
                Log.w("ddms", String.format("Buffer has reached maximum size of %d", 16777216));
                throw new BufferOverflowException();
            }
            Log.d("ddms", "Expanding read buffer to " + iCapacity);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iCapacity);
            this.mReadBuffer.position(0);
            byteBufferAllocate.put(this.mReadBuffer);
            this.mReadBuffer = byteBufferAllocate;
        }
        int i = this.mChannel.read(this.mReadBuffer);
        if (Log.isAtLeast(Log.LogLevel.VERBOSE)) {
            Log.v("ddms", String.format("Read %d bytes from %s", Integer.valueOf(i), this));
        }
        if (i < 0) {
            throw new IOException("read failed");
        }
    }

    JdwpPacket getJdwpPacket() throws IOException {
        if (this.mConnState == ConnectionState.ST_AWAIT_SHAKE) {
            int iFindHandshake = JdwpHandshake.findHandshake(this.mReadBuffer);
            if (iFindHandshake != 1) {
                if (iFindHandshake != 2) {
                    if (iFindHandshake == 3) {
                        Log.d("ddms", "Bad handshake from debugger");
                        throw new IOException("bad handshake");
                    }
                    Log.e("ddms", "Unknown packet while waiting for client handshake");
                }
                return null;
            }
            Log.d("ddms", "Good handshake from debugger");
            JdwpHandshake.consumeHandshake(this.mReadBuffer);
            sendHandshake();
            this.mConnState = ConnectionState.ST_READY;
            this.mClient.getClientData().setDebuggerConnectionStatus(ClientData.DebuggerStatus.ATTACHED);
            this.mClient.update(2);
            return getJdwpPacket();
        }
        if (this.mConnState == ConnectionState.ST_READY) {
            if (this.mReadBuffer.position() != 0) {
                Log.v("ddms", "Checking " + this.mReadBuffer.position() + " bytes");
            }
            return JdwpPacket.findPacket(this.mReadBuffer);
        }
        Log.e("ddms", "Receiving data in state = " + this.mConnState);
        return null;
    }

    private synchronized void sendHandshake() throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(JdwpHandshake.HANDSHAKE_LEN);
        JdwpHandshake.putHandshake(byteBufferAllocate);
        int iPosition = byteBufferAllocate.position();
        byteBufferAllocate.flip();
        if (this.mChannel.write(byteBufferAllocate) != iPosition) {
            throw new IOException("partial handshake write");
        }
        int iPosition2 = this.mPreDataBuffer.position();
        if (iPosition2 > 0) {
            Log.d("ddms", "Sending " + this.mPreDataBuffer.position() + " bytes of saved data");
            this.mPreDataBuffer.flip();
            if (this.mChannel.write(this.mPreDataBuffer) != iPosition2) {
                throw new IOException("partial pre-data write");
            }
            this.mPreDataBuffer.clear();
        }
    }

    @Override // com.android.ddmlib.jdwp.JdwpPipe
    protected void send(JdwpPacket packet) throws IOException {
        packet.log("Debugger: forwarding jdwp packet from Client to Java Debugger");
        synchronized (this) {
            SocketChannel socketChannel = this.mChannel;
            if (socketChannel == null) {
                Log.d("ddms", "Saving packet 0x" + Integer.toHexString(packet.getId()));
                packet.move(this.mPreDataBuffer);
            } else {
                packet.write(socketChannel);
            }
        }
    }
}
