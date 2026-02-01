package com.android.ddmlib.internal.jdwp.chunkhandler;

import com.android.ddmlib.ByteBufferUtil;
import com.android.ddmlib.Log;
import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.MonitorThread;
import com.android.ddmlib.jdwp.JdwpInterceptor;
import com.android.ddmlib.jdwp.JdwpPipe;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public abstract class ChunkHandler extends JdwpInterceptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CHUNK_HEADER_LEN = 8;
    public static final int DDMS_CMD = 1;
    public static final int DDMS_CMD_SET = 199;
    public static final ByteOrder CHUNK_ORDER = ByteOrder.BIG_ENDIAN;
    public static final int CHUNK_FAIL = type("FAIL");

    public abstract void clientDisconnected(ClientImpl client);

    public abstract void clientReady(ClientImpl client) throws IOException;

    public abstract void handleChunk(ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId);

    protected void handleUnknownChunk(ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId) {
        if (type == CHUNK_FAIL) {
            Log.w("ddms", "WARNING: failure code=" + data.getInt() + " msg=" + ByteBufferUtil.getString(data, data.getInt()));
        } else {
            Log.w("ddms", "WARNING: received unknown chunk " + name(type) + ": len=" + data.limit() + ", reply=" + isReply + ", msgId=0x" + Integer.toHexString(msgId));
        }
        Log.w("ddms", "         client " + client + ", handler " + this);
    }

    public static int type(String typeName) {
        if (typeName.length() != 4) {
            Log.e("ddms", "Type name must be 4 letter long");
            throw new RuntimeException("Type name must be 4 letter long");
        }
        int iCharAt = 0;
        for (int i = 0; i < 4; i++) {
            iCharAt = (iCharAt << 8) | ((byte) typeName.charAt(i));
        }
        return iCharAt;
    }

    static String name(int type) {
        return new String(new char[]{(char) ((type >> 24) & 255), (char) ((type >> 16) & 255), (char) ((type >> 8) & 255), (char) (type & 255)});
    }

    public static ByteBuffer allocBuffer(int maxChunkLen) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(maxChunkLen + 19);
        byteBufferAllocate.order(CHUNK_ORDER);
        return byteBufferAllocate;
    }

    public static ByteBuffer getChunkDataBuf(ByteBuffer jdwpBuf) {
        jdwpBuf.position(19);
        ByteBuffer byteBufferSlice = jdwpBuf.slice();
        byteBufferSlice.order(CHUNK_ORDER);
        jdwpBuf.position(0);
        return byteBufferSlice;
    }

    public static void finishChunkPacket(JdwpPacket packet, int type, int chunkLen) {
        ByteBuffer payload = packet.getPayload();
        payload.putInt(0, type);
        payload.putInt(4, chunkLen);
        packet.finishPacket(199, 1, chunkLen + 8);
    }

    public void handlePacket(ClientImpl client, JdwpPacket packet) {
        ByteBuffer payload = packet.getPayload();
        int i = payload.getInt();
        Log.d("ddms", "Calling handler for " + name(i) + " [" + this + "] (len=" + payload.getInt() + ")");
        ByteBuffer byteBufferAsReadOnlyBuffer = payload.slice().asReadOnlyBuffer();
        byteBufferAsReadOnlyBuffer.order(CHUNK_ORDER);
        handleChunk(client, i, byteBufferAsReadOnlyBuffer, packet.isReply(), packet.getId());
    }

    @Override // com.android.ddmlib.jdwp.JdwpInterceptor
    public JdwpPacket intercept(JdwpPipe pipe, JdwpPacket packet) {
        if (!(pipe instanceof ClientImpl)) {
            return packet;
        }
        ClientImpl clientImpl = (ClientImpl) pipe;
        MonitorThread.getInstance().getDdmExtension().ddmSeen(clientImpl);
        if (packet.isError()) {
            clientImpl.packetFailed(packet);
            return null;
        }
        if (packet.isEmpty()) {
            Log.d("ddms", "Got empty reply for 0x" + Integer.toHexString(packet.getId()));
            return null;
        }
        handlePacket(clientImpl, packet);
        return null;
    }
}
