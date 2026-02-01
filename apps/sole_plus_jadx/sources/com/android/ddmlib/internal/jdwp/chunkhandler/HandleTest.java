package com.android.ddmlib.internal.jdwp.chunkhandler;

import com.android.ddmlib.Log;
import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.MonitorThread;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class HandleTest extends ChunkHandler {
    public static final int CHUNK_TEST = type("TEST");
    private static final HandleTest mInst = new HandleTest();

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientDisconnected(ClientImpl client) {
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientReady(ClientImpl client) {
    }

    private HandleTest() {
    }

    public static void register(MonitorThread mt) {
        mt.registerChunkHandler(CHUNK_TEST, mInst);
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void handleChunk(ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId) {
        Log.d("ddm-test", "handling " + ChunkHandler.name(type));
        if (type == CHUNK_TEST) {
            handleTEST(client, data);
        } else {
            handleUnknownChunk(client, type, data, isReply, msgId);
        }
    }

    private static void handleTEST(ClientImpl client, ByteBuffer data) {
        int iLimit = data.limit();
        byte[] bArr = new byte[iLimit];
        data.get(bArr);
        Log.d("ddm-test", "Received:");
        Log.hexDump("ddm-test", Log.LogLevel.DEBUG, bArr, 0, iLimit);
    }
}
