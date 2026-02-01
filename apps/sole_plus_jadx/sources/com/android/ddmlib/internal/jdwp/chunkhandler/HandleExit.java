package com.android.ddmlib.internal.jdwp.chunkhandler;

import com.android.ddmlib.Log;
import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.MonitorThread;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class HandleExit extends ChunkHandler {
    public static final int CHUNK_EXIT = type("EXIT");
    private static final HandleExit mInst = new HandleExit();

    public static void register(MonitorThread mt) {
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientDisconnected(ClientImpl client) {
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientReady(ClientImpl client) {
    }

    private HandleExit() {
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void handleChunk(ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId) {
        handleUnknownChunk(client, type, data, isReply, msgId);
    }

    public static void sendEXIT(ClientImpl client, int status) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(4);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(status);
        int i = CHUNK_EXIT;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-exit", "Sending " + name(i) + ": " + status);
        client.send(jdwpPacket, mInst);
    }
}
