package com.android.ddmlib.internal.jdwp.chunkhandler;

import com.android.ddmlib.ByteBufferUtil;
import com.android.ddmlib.Log;
import com.android.ddmlib.ThreadInfo;
import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.MonitorThread;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class HandleThread extends ChunkHandler {
    public static final int CHUNK_THEN = type("THEN");
    public static final int CHUNK_THCR = type("THCR");
    public static final int CHUNK_THDE = type("THDE");
    public static final int CHUNK_THST = type("THST");
    public static final int CHUNK_THNM = type("THNM");
    public static final int CHUNK_STKL = type("STKL");
    private static final HandleThread mInst = new HandleThread();
    private static volatile boolean sThreadStatusReqRunning = false;
    private static volatile boolean sThreadStackTraceReqRunning = false;

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientDisconnected(ClientImpl client) {
    }

    private HandleThread() {
    }

    public static void register(MonitorThread mt) {
        int i = CHUNK_THCR;
        HandleThread handleThread = mInst;
        mt.registerChunkHandler(i, handleThread);
        mt.registerChunkHandler(CHUNK_THDE, handleThread);
        mt.registerChunkHandler(CHUNK_THST, handleThread);
        mt.registerChunkHandler(CHUNK_THNM, handleThread);
        mt.registerChunkHandler(CHUNK_STKL, handleThread);
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientReady(ClientImpl client) throws IOException {
        Log.d("ddm-thread", "Now ready: " + client);
        if (client.isThreadUpdateEnabled()) {
            sendTHEN(client, true);
        }
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void handleChunk(ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId) {
        Log.d("ddm-thread", "handling " + ChunkHandler.name(type));
        if (type == CHUNK_THCR) {
            handleTHCR(client, data);
            return;
        }
        if (type == CHUNK_THDE) {
            handleTHDE(client, data);
            return;
        }
        if (type == CHUNK_THST) {
            handleTHST(client, data);
            return;
        }
        if (type == CHUNK_THNM) {
            handleTHNM(client, data);
        } else if (type == CHUNK_STKL) {
            handleSTKL(client, data);
        } else {
            handleUnknownChunk(client, type, data, isReply, msgId);
        }
    }

    private void handleTHCR(ClientImpl client, ByteBuffer data) {
        int i = data.getInt();
        String string = ByteBufferUtil.getString(data, data.getInt());
        Log.v("ddm-thread", "THCR: " + i + " '" + string + "'");
        client.getClientData().addThread(i, string);
        client.update(16);
    }

    private void handleTHDE(ClientImpl client, ByteBuffer data) {
        int i = data.getInt();
        Log.v("ddm-thread", "THDE: " + i);
        client.getClientData().removeThread(i);
        client.update(16);
    }

    private void handleTHST(ClientImpl client, ByteBuffer data) {
        boolean z;
        int i = data.get() & 255;
        int i2 = data.get() & 255;
        short s = data.getShort();
        int i3 = i - 4;
        while (true) {
            int i4 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            data.get();
            i3 = i4;
        }
        int i5 = i2 - 18;
        Log.v("ddm-thread", "THST: threadCount=" + ((int) s));
        for (int i6 = 0; i6 < s; i6++) {
            int i7 = data.getInt();
            byte b = data.get();
            int i8 = data.getInt();
            int i9 = data.getInt();
            int i10 = data.getInt();
            if (i2 >= 18) {
                z = data.get() != 0;
            } else {
                z = false;
            }
            Log.v("ddm-thread", "  id=" + i7 + ", status=" + ((int) b) + ", tid=" + i8 + ", utime=" + i9 + ", stime=" + i10);
            ThreadInfo thread = client.getClientData().getThread(i7);
            if (thread != null) {
                thread.updateThread(b, i8, i9, i10, z);
            } else {
                Log.d("ddms", "Thread with id=" + i7 + " not found");
            }
            for (int i11 = i5; i11 > 0; i11--) {
                data.get();
            }
        }
        client.update(16);
    }

    private void handleTHNM(ClientImpl client, ByteBuffer data) {
        int i = data.getInt();
        String string = ByteBufferUtil.getString(data, data.getInt());
        Log.v("ddm-thread", "THNM: " + i + " '" + string + "'");
        ThreadInfo thread = client.getClientData().getThread(i);
        if (thread != null) {
            thread.setThreadName(string);
            client.update(16);
        } else {
            Log.d("ddms", "Thread with id=" + i + " not found");
        }
    }

    private void handleSTKL(ClientImpl client, ByteBuffer data) {
        data.getInt();
        int i = data.getInt();
        Log.v("ddms", "STKL: " + i);
        int i2 = data.getInt();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            String string = ByteBufferUtil.getString(data, data.getInt());
            String string2 = ByteBufferUtil.getString(data, data.getInt());
            int i4 = data.getInt();
            stackTraceElementArr[i3] = new StackTraceElement(string, string2, i4 == 0 ? null : ByteBufferUtil.getString(data, i4), data.getInt());
        }
        ThreadInfo thread = client.getClientData().getThread(i);
        if (thread != null) {
            thread.setStackCall(stackTraceElementArr);
            client.update(256);
        } else {
            Log.d("STKL", String.format("Got stackcall for thread %1$d, which does not exists (anymore?).", Integer.valueOf(i)));
        }
    }

    public static void sendTHEN(ClientImpl client, boolean enable) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(1);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        if (enable) {
            chunkDataBuf.put((byte) 1);
        } else {
            chunkDataBuf.put((byte) 0);
        }
        int i = CHUNK_THEN;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-thread", "Sending " + name(i) + ": " + enable);
        client.send(jdwpPacket, mInst);
    }

    public static void sendSTKL(ClientImpl client, int threadId) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(4);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(threadId);
        int i = CHUNK_STKL;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-thread", "Sending " + name(i) + ": " + threadId);
        client.send(jdwpPacket, mInst);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.android.ddmlib.internal.jdwp.chunkhandler.HandleThread$1] */
    public static void requestThreadUpdate(final ClientImpl client) {
        if (client.isDdmAware() && client.isThreadUpdateEnabled()) {
            if (sThreadStatusReqRunning) {
                Log.w("ddms", "Waiting for previous thread update req to finish");
            } else {
                new Thread("Thread Status Req") { // from class: com.android.ddmlib.internal.jdwp.chunkhandler.HandleThread.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        boolean unused = HandleThread.sThreadStatusReqRunning = true;
                        try {
                            try {
                                HandleThread.sendTHST(client);
                            } catch (IOException e) {
                                Log.d("ddms", "Unable to request thread updates from " + client + ": " + e.getMessage());
                            }
                        } finally {
                            boolean unused2 = HandleThread.sThreadStatusReqRunning = false;
                        }
                    }
                }.start();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.android.ddmlib.internal.jdwp.chunkhandler.HandleThread$2] */
    public static void requestThreadStackCallRefresh(final ClientImpl client, final int threadId) {
        if (client.isDdmAware() && client.isThreadUpdateEnabled()) {
            if (sThreadStackTraceReqRunning) {
                Log.w("ddms", "Waiting for previous thread stack call req to finish");
            } else {
                new Thread("Thread Status Req") { // from class: com.android.ddmlib.internal.jdwp.chunkhandler.HandleThread.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        boolean unused = HandleThread.sThreadStackTraceReqRunning = true;
                        try {
                            try {
                                HandleThread.sendSTKL(client, threadId);
                            } catch (IOException e) {
                                Log.d("ddms", "Unable to request thread stack call updates from " + client + ": " + e.getMessage());
                            }
                        } finally {
                            boolean unused2 = HandleThread.sThreadStackTraceReqRunning = false;
                        }
                    }
                }.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendTHST(ClientImpl client) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(0);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        int i = CHUNK_THST;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-thread", "Sending " + name(i));
        client.send(jdwpPacket, mInst);
    }
}
