package com.android.ddmlib.internal.jdwp.chunkhandler;

import com.android.ddmlib.Log;
import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.MonitorThread;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class HandleAppName extends ChunkHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CHUNK_APNM = ChunkHandler.type("APNM");
    private static final HandleAppName mInst = new HandleAppName();

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientDisconnected(ClientImpl client) {
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientReady(ClientImpl client) {
    }

    private HandleAppName() {
    }

    public static void register(MonitorThread mt) {
        mt.registerChunkHandler(CHUNK_APNM, mInst);
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void handleChunk(ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId) {
        Log.d("ddm-appname", "handling " + ChunkHandler.name(type));
        if (type == CHUNK_APNM) {
            handleAPNM(client, data);
        } else {
            handleUnknownChunk(client, type, data, isReply, msgId);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void handleAPNM(com.android.ddmlib.internal.ClientImpl r6, java.nio.ByteBuffer r7) {
        /*
            int r0 = r7.getInt()
            java.lang.String r0 = com.android.ddmlib.ByteBufferUtil.getString(r7, r0)
            boolean r1 = r7.hasRemaining()
            java.lang.String r2 = "Actual chunk length: "
            java.lang.String r3 = "ddm-appname"
            if (r1 == 0) goto L39
            int r1 = r7.remaining()
            int r4 = r7.getInt()     // Catch: java.nio.BufferUnderflowException -> L1f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch: java.nio.BufferUnderflowException -> L1f
            goto L3a
        L1f:
            java.lang.String r4 = "Insufficient data in APNM chunk to retrieve user id."
            com.android.ddmlib.Log.e(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r1 = r1.toString()
            com.android.ddmlib.Log.e(r3, r1)
            java.lang.String r1 = "Expected chunk length: 4"
            com.android.ddmlib.Log.e(r3, r1)
        L39:
            r1 = 0
        L3a:
            boolean r4 = r7.hasRemaining()
            if (r4 == 0) goto L79
            int r4 = r7.remaining()
            int r5 = r7.getInt()     // Catch: java.nio.BufferUnderflowException -> L4d
            java.lang.String r7 = com.android.ddmlib.ByteBufferUtil.getString(r7, r5)     // Catch: java.nio.BufferUnderflowException -> L4e
            goto L7b
        L4d:
            r5 = 0
        L4e:
            int r5 = r5 * 2
            int r5 = r5 + 4
            java.lang.String r7 = "Insufficient data in APNM chunk to retrieve package name."
            com.android.ddmlib.Log.e(r3, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r2)
            java.lang.StringBuilder r7 = r7.append(r4)
            java.lang.String r7 = r7.toString()
            com.android.ddmlib.Log.e(r3, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected chunk length: "
            r7.<init>(r2)
            java.lang.StringBuilder r7 = r7.append(r5)
            java.lang.String r7 = r7.toString()
            com.android.ddmlib.Log.e(r3, r7)
        L79:
            java.lang.String r7 = ""
        L7b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "APNM: app='"
            r2.<init>(r4)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r4 = "'"
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.android.ddmlib.Log.d(r3, r2)
            com.android.ddmlib.ClientData$Names r2 = new com.android.ddmlib.ClientData$Names
            r2.<init>(r0, r1, r7)
            com.android.ddmlib.ClientData r7 = r6.getClientData()
            r7.setNames(r2)
            if (r6 == 0) goto La5
            r7 = 1
            r6.update(r7)
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.ddmlib.internal.jdwp.chunkhandler.HandleAppName.handleAPNM(com.android.ddmlib.internal.ClientImpl, java.nio.ByteBuffer):void");
    }
}
