package com.android.ddmlib.internal.jdwp.chunkhandler;

import com.android.ddmlib.Log;
import com.android.ddmlib.jdwp.JdwpCommands;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SocketChannel;

/* loaded from: classes3.dex */
public final class JdwpPacket {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int JDWP_HEADER_LEN = 11;
    private static final int REPLY_PACKET = 128;
    private static int sSerialId = 1073741824;
    private final ByteBuffer mBuffer;
    private int mCmd;
    private int mCmdSet;
    private int mErrCode;
    private int mFlags;
    private int mId;
    private int mLength;

    public JdwpPacket(ByteBuffer buf) {
        this.mBuffer = buf;
    }

    public void finishPacket(int cmdSet, int cmd, int payloadLength) {
        ByteOrder byteOrderOrder = this.mBuffer.order();
        this.mBuffer.order(ChunkHandler.CHUNK_ORDER);
        this.mLength = payloadLength + 11;
        this.mId = getNextSerial();
        this.mFlags = 0;
        this.mCmdSet = cmdSet;
        this.mCmd = cmd;
        this.mBuffer.putInt(0, this.mLength);
        this.mBuffer.putInt(4, this.mId);
        this.mBuffer.put(8, (byte) this.mFlags);
        this.mBuffer.put(9, (byte) this.mCmdSet);
        this.mBuffer.put(10, (byte) this.mCmd);
        this.mBuffer.order(byteOrderOrder);
        this.mBuffer.position(this.mLength);
    }

    private static synchronized int getNextSerial() {
        int i;
        i = sSerialId;
        sSerialId = i + 1;
        return i;
    }

    public ByteBuffer getPayload() {
        int iPosition = this.mBuffer.position();
        this.mBuffer.position(11);
        ByteBuffer byteBufferSlice = this.mBuffer.slice();
        this.mBuffer.position(iPosition);
        int i = this.mLength;
        if (i > 0) {
            byteBufferSlice.limit(i - 11);
        }
        byteBufferSlice.order(ChunkHandler.CHUNK_ORDER);
        return byteBufferSlice;
    }

    public boolean isReply() {
        return (this.mFlags & 128) != 0;
    }

    public boolean isError() {
        return isReply() && this.mErrCode != 0;
    }

    public boolean isEmpty() {
        return this.mLength == 11;
    }

    public int getId() {
        return this.mId;
    }

    public int getLength() {
        return this.mLength;
    }

    public void write(SocketChannel chan) throws IOException {
        int iPosition = this.mBuffer.position();
        this.mBuffer.position(0);
        this.mBuffer.limit(this.mLength);
        while (this.mBuffer.position() != this.mBuffer.limit()) {
            chan.write(this.mBuffer);
        }
        ByteBuffer byteBuffer = this.mBuffer;
        byteBuffer.limit(byteBuffer.capacity());
        this.mBuffer.position(iPosition);
    }

    public void move(ByteBuffer buf) {
        int iPosition = this.mBuffer.position();
        this.mBuffer.position(0);
        this.mBuffer.limit(this.mLength);
        buf.put(this.mBuffer);
        ByteBuffer byteBuffer = this.mBuffer;
        byteBuffer.limit(byteBuffer.capacity());
        this.mBuffer.position(iPosition);
    }

    public void copy(ByteBuffer into) {
        into.put(this.mBuffer.array(), 0, this.mLength);
    }

    public void setPayload(ByteBuffer buf) {
        if (this.mLength - 11 != buf.remaining()) {
            throw new UnsupportedOperationException("Changing payload size not supported");
        }
        int iPosition = this.mBuffer.position();
        this.mBuffer.position(11);
        this.mBuffer.put(buf);
        this.mBuffer.position(iPosition);
    }

    public void consume() {
        this.mBuffer.flip();
        this.mBuffer.position(this.mLength);
        this.mBuffer.compact();
        this.mLength = 0;
    }

    public static int getPacketLength(ByteBuffer buf) {
        int i;
        if (buf.position() >= 11 && (i = buf.getInt(0)) >= 11) {
            return i;
        }
        return -1;
    }

    private static JdwpPacket findPacket(ByteBuffer buf, boolean setPayload) {
        JdwpPacket jdwpPacket;
        int iPosition = buf.position();
        if (iPosition < 11) {
            return null;
        }
        ByteOrder byteOrderOrder = buf.order();
        buf.order(ChunkHandler.CHUNK_ORDER);
        int i = buf.getInt(0);
        int i2 = buf.getInt(4);
        byte b = buf.get(8);
        int i3 = b & 255;
        int i4 = buf.get(9) & 255;
        int i5 = buf.get(10) & 255;
        buf.order(byteOrderOrder);
        if (!setPayload) {
            jdwpPacket = new JdwpPacket(ByteBuffer.allocate(0));
        } else {
            if (i < 11) {
                throw new BadPacketException();
            }
            if (iPosition < i) {
                return null;
            }
            jdwpPacket = new JdwpPacket(buf);
        }
        jdwpPacket.mLength = i;
        jdwpPacket.mId = i2;
        jdwpPacket.mFlags = i3;
        if ((b & 128) == 0) {
            jdwpPacket.mCmdSet = i4;
            jdwpPacket.mCmd = i5;
            jdwpPacket.mErrCode = -1;
        } else {
            jdwpPacket.mCmdSet = -1;
            jdwpPacket.mCmd = -1;
            jdwpPacket.mErrCode = (i5 << 8) | i4;
        }
        return jdwpPacket;
    }

    public static JdwpPacket findPacket(ByteBuffer buf) {
        return findPacket(buf, true);
    }

    public static JdwpPacket findPacketHeader(ByteBuffer buf) {
        return findPacket(buf, false);
    }

    public String toString() {
        return (isReply() ? new StringBuilder(" < # ") : new StringBuilder(" > ").append(this.mCmdSet).append(".").append(this.mCmd).append(" # ")).append(this.mId).toString();
    }

    public boolean is(int cmdSet, int cmd) {
        return cmdSet == this.mCmdSet && cmd == this.mCmd;
    }

    public void log(String action) {
        if (Log.isAtLeast(Log.LogLevel.DEBUG)) {
            if (isReply()) {
                Log.d("jdwp", String.format("%s: jdwp reply: id=%d, length=%d, flags=%d, error=%d", action, Integer.valueOf(this.mId), Integer.valueOf(this.mLength), Integer.valueOf(this.mFlags), Integer.valueOf(this.mErrCode)));
            } else {
                Log.d("jdwp", String.format("%s: jdwp request: id=%d, length=%d, flags=%d, cmdSet=%s, cmd=%s", action, Integer.valueOf(this.mId), Integer.valueOf(this.mLength), Integer.valueOf(this.mFlags), JdwpCommands.commandSetToString(this.mCmdSet), JdwpCommands.commandToString(this.mCmdSet, this.mCmd)));
            }
        }
    }
}
