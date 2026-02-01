package com.android.ddmlib.internal.jdwp;

import com.android.ddmlib.AdbHelper;
import com.android.ddmlib.DdmPreferences;
import com.android.ddmlib.JdwpHandshake;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleAppName;
import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/* loaded from: classes3.dex */
public class JdwpConnectionReader {
    static final String JDWP_DISCONNECT = "disconnect:";
    private ByteBuffer mReadBuffer;
    private SocketChannel mSocket;

    public JdwpConnectionReader(SocketChannel channelToReadFrom, int initialBufferSize) {
        this.mReadBuffer = ByteBuffer.allocate(initialBufferSize);
        this.mSocket = channelToReadFrom;
    }

    public int read() throws IOException {
        return this.mSocket.read(this.mReadBuffer);
    }

    public boolean isHostTransport() {
        return bufferOffsetStartsWith(4, AdbHelper.HOST_TRANSPORT);
    }

    public boolean isJdwpPid() {
        return bufferOffsetStartsWith(4, "jdwp:");
    }

    public boolean isDisconnect() {
        return bufferOffsetStartsWith(4, JDWP_DISCONNECT);
    }

    public boolean isHandshake() {
        return JdwpHandshake.findHandshake(this.mReadBuffer) == 1;
    }

    public boolean isAPNMPacket() throws IOException {
        JdwpPacket packetHeader = readPacketHeader();
        return packetHeader != null && packetHeader.is(199, 1) && readPacketPayloadPartial(4).getInt() == HandleAppName.CHUNK_APNM;
    }

    public DdmCommandPacket parseCommandPacket() {
        return new DdmCommandPacket(this.mReadBuffer);
    }

    public void consumeData(int length) {
        this.mReadBuffer.flip();
        this.mReadBuffer.position(length);
        this.mReadBuffer.compact();
    }

    public JdwpPacket readPacket() throws IOException {
        int packetLength = JdwpPacket.getPacketLength(this.mReadBuffer);
        if (packetLength <= 0) {
            return null;
        }
        if (packetLength > DdmPreferences.getJdwpMaxPacketSize()) {
            JdwpLoggingUtils.logPacketError("Packet size exceeds expected max", this.mReadBuffer);
            throw new BufferOverflowException();
        }
        if (this.mReadBuffer.capacity() < packetLength) {
            resizeBuffer(packetLength);
        }
        while (packetLength > this.mReadBuffer.position()) {
            this.mSocket.read(this.mReadBuffer);
        }
        return JdwpPacket.findPacket(this.mReadBuffer);
    }

    public JdwpPacket readPacketHeader() throws IOException {
        if (JdwpPacket.getPacketLength(this.mReadBuffer) <= 0) {
            return null;
        }
        while (this.mReadBuffer.position() < 11) {
            this.mSocket.read(this.mReadBuffer);
        }
        return JdwpPacket.findPacketHeader(this.mReadBuffer);
    }

    public ByteBuffer readPacketPayloadPartial(int size) throws IOException {
        if (size <= 0) {
            return ByteBuffer.allocate(0);
        }
        while (this.mReadBuffer.position() < size + 11) {
            this.mSocket.read(this.mReadBuffer);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(size);
        byteBufferAllocate.put(this.mReadBuffer.array(), 11, size);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private void resizeBuffer(int requestedSize) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(requestedSize);
        int iPosition = this.mReadBuffer.position();
        this.mReadBuffer.position(0);
        byteBufferAllocate.put(this.mReadBuffer);
        byteBufferAllocate.position(iPosition);
        this.mReadBuffer = byteBufferAllocate;
    }

    public void consumePacket() throws IOException {
        JdwpPacket packet = readPacket();
        if (packet != null) {
            packet.consume();
        }
    }

    private boolean bufferOffsetStartsWith(int offset, String match) {
        for (int i = 0; i < match.length() && offset < this.mReadBuffer.position(); i++) {
            if (match.charAt(i) != this.mReadBuffer.get(offset)) {
                return false;
            }
            offset++;
        }
        return true;
    }
}
