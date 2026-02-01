package com.android.ddmlib;

import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class DebugViewDumpHandler extends ChunkHandler {
    private final int mChunkType;
    private final CountDownLatch mLatch = new CountDownLatch(1);
    public static final int CHUNK_VUGL = type("VUGL");
    public static final int CHUNK_VULW = type("VULW");
    public static final int CHUNK_VURT = type("VURT");
    public static final int CHUNK_VUOP = type("VUOP");

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientDisconnected(ClientImpl client) {
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientReady(ClientImpl client) throws IOException {
    }

    protected abstract void handleViewDebugResult(ByteBuffer data);

    public DebugViewDumpHandler(int chunkType) {
        this.mChunkType = chunkType;
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void handleChunk(ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId) {
        if (type != this.mChunkType) {
            handleUnknownChunk(client, type, data, isReply, msgId);
        } else {
            handleViewDebugResult(data);
            this.mLatch.countDown();
        }
    }

    protected void waitForResult(long timeout, TimeUnit unit) throws InterruptedException {
        try {
            this.mLatch.await(timeout, unit);
        } catch (InterruptedException unused) {
        }
    }

    public static String getString(ByteBuffer buf, int len) {
        return ByteBufferUtil.getString(buf, len);
    }
}
