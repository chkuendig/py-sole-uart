package com.android.ddmlib.internal.jdwp.chunkhandler;

import com.android.ddmlib.ClientData;
import com.android.ddmlib.Log;
import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.MonitorThread;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class HandleWait extends ChunkHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CHUNK_WAIT = ChunkHandler.type("WAIT");
    private static final HandleWait mInst = new HandleWait();

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientDisconnected(ClientImpl client) {
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientReady(ClientImpl client) {
    }

    private HandleWait() {
    }

    public static void register(MonitorThread mt) {
        mt.registerChunkHandler(CHUNK_WAIT, mInst);
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void handleChunk(ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId) {
        Log.d("ddm-wait", "handling " + ChunkHandler.name(type));
        if (type == CHUNK_WAIT) {
            handleWAIT(client, data);
        } else {
            handleUnknownChunk(client, type, data, isReply, msgId);
        }
    }

    private static void handleWAIT(ClientImpl client, ByteBuffer data) {
        Log.d("ddm-wait", "WAIT: reason=" + ((int) data.get()));
        ClientData clientData = client.getClientData();
        synchronized (clientData) {
            clientData.setDebuggerConnectionStatus(ClientData.DebuggerStatus.WAITING);
        }
        client.update(2);
    }
}
