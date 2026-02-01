package com.android.ddmlib.internal.jdwp;

import com.android.ddmlib.AdbHelper;
import com.android.ddmlib.DdmPreferences;
import com.android.ddmlib.JdwpHandshake;
import com.android.ddmlib.Log;
import com.android.ddmlib.TimeoutException;
import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public class JdwpProxyClient implements JdwpSocketHandler {
    private SocketChannel mClientImplSocket;
    private JdwpClientManager mConnection;
    private final JdwpClientManagerFactory mFactory;
    private JdwpConnectionReader mReader;
    private String mDeviceId = null;
    private int mPid = 0;
    private boolean mHandshakeComplete = false;

    JdwpProxyClient(SocketChannel socket, JdwpClientManagerFactory factory) {
        this.mClientImplSocket = socket;
        this.mFactory = factory;
        this.mReader = new JdwpConnectionReader(this.mClientImplSocket, 1024);
    }

    public boolean isConnected() {
        return this.mClientImplSocket != null;
    }

    @Override // com.android.ddmlib.internal.jdwp.JdwpSocketHandler
    public void shutdown() throws IOException {
        SocketChannel socketChannel = this.mClientImplSocket;
        if (socketChannel != null) {
            socketChannel.close();
            this.mClientImplSocket = null;
        }
        JdwpClientManager jdwpClientManager = this.mConnection;
        if (jdwpClientManager != null) {
            jdwpClientManager.removeListener(this);
            this.mConnection = null;
        }
    }

    @Override // com.android.ddmlib.internal.jdwp.JdwpSocketHandler
    public void read() throws IOException, TimeoutException {
        if (this.mClientImplSocket == null) {
            return;
        }
        if (this.mReader.read() == -1) {
            shutdown();
            throw new EOFException("Client Disconnected");
        }
        if (this.mDeviceId == null && this.mReader.isHostTransport()) {
            DdmCommandPacket commandPacket = this.mReader.parseCommandPacket();
            this.mDeviceId = commandPacket.getCommand().substring(AdbHelper.HOST_TRANSPORT.length());
            write("OKAY");
            this.mReader.consumeData(commandPacket.getTotalSize());
            return;
        }
        if (this.mPid == 0 && this.mReader.isJdwpPid()) {
            DdmCommandPacket commandPacket2 = this.mReader.parseCommandPacket();
            this.mPid = Integer.parseInt(commandPacket2.getCommand().substring("jdwp:".length()));
            try {
                JdwpClientManager jdwpClientManagerCreateConnection = this.mFactory.createConnection(new JdwpClientManagerId(this.mDeviceId, this.mPid));
                this.mConnection = jdwpClientManagerCreateConnection;
                jdwpClientManagerCreateConnection.addListener(this);
                write("OKAY");
            } catch (Exception e) {
                writeFailHelper(e.getMessage());
                shutdown();
            }
            this.mReader.consumeData(commandPacket2.getTotalSize());
            return;
        }
        if (this.mReader.isDisconnect()) {
            DdmCommandPacket commandPacket3 = this.mReader.parseCommandPacket();
            try {
                String[] strArrSplit = commandPacket3.getCommand().split(":");
                JdwpClientManager connection = this.mFactory.getConnection(strArrSplit[1], Integer.parseInt(strArrSplit[2]));
                if (connection == null) {
                    writeFailHelper("Unable to find client matching: " + strArrSplit[1] + " / " + strArrSplit[2]);
                } else {
                    write("OKAY");
                    connection.shutdown();
                }
            } catch (Exception e2) {
                writeFailHelper(e2.getMessage());
            }
            this.mReader.consumeData(commandPacket3.getTotalSize());
            return;
        }
        if (this.mReader.isHandshake()) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(JdwpHandshake.HANDSHAKE_LEN);
            JdwpHandshake.putHandshake(byteBufferAllocate);
            write(byteBufferAllocate.array(), byteBufferAllocate.position());
            setHandshakeComplete();
            this.mReader.consumeData(JdwpHandshake.HANDSHAKE_LEN);
            return;
        }
        if (!isHandshakeComplete()) {
            Log.e("DDMLIB", "An unexpected packet was received before the handshake.");
            this.mReader.consumePacket();
        } else {
            if (this.mConnection == null) {
                return;
            }
            while (true) {
                JdwpPacket packet = this.mReader.readPacket();
                if (packet == null) {
                    return;
                }
                this.mConnection.write(this, packet);
                packet.consume();
            }
        }
    }

    private void writeFailHelper(String message) throws IOException, TimeoutException {
        write("FAIL");
        byte[] bArrFormAdbRequest = AdbHelper.formAdbRequest(message);
        write(bArrFormAdbRequest, bArrFormAdbRequest.length);
    }

    public boolean isHandshakeComplete() {
        return this.mHandshakeComplete;
    }

    public void setHandshakeComplete() {
        this.mHandshakeComplete = true;
    }

    public void write(byte[] data, int length) throws IOException, TimeoutException {
        JdwpLoggingUtils.log("CLIENT", "WRITE", data, length);
        AdbHelper.write(this.mClientImplSocket, data, length, DdmPreferences.getTimeOut());
    }

    private void write(String value) throws IOException, TimeoutException {
        write(value.getBytes(Charset.defaultCharset()), value.length());
    }
}
