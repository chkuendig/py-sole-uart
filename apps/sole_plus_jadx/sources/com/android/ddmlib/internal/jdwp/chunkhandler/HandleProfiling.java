package com.android.ddmlib.internal.jdwp.chunkhandler;

import com.android.ddmlib.ByteBufferUtil;
import com.android.ddmlib.ClientData;
import com.android.ddmlib.Log;
import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.MonitorThread;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class HandleProfiling extends ChunkHandler {
    public static final int CHUNK_MPRS = type("MPRS");
    public static final int CHUNK_MPRE = type("MPRE");
    public static final int CHUNK_MPSS = type("MPSS");
    public static final int CHUNK_MPSE = type("MPSE");
    public static final int CHUNK_SPSS = type("SPSS");
    public static final int CHUNK_SPSE = type("SPSE");
    public static final int CHUNK_MPRQ = type("MPRQ");
    public static final int CHUNK_FAIL = type("FAIL");
    private static final HandleProfiling mInst = new HandleProfiling();

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientDisconnected(ClientImpl client) {
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientReady(ClientImpl client) throws IOException {
    }

    private HandleProfiling() {
    }

    public static void register(MonitorThread mt) {
        int i = CHUNK_MPRE;
        HandleProfiling handleProfiling = mInst;
        mt.registerChunkHandler(i, handleProfiling);
        mt.registerChunkHandler(CHUNK_MPSE, handleProfiling);
        mt.registerChunkHandler(CHUNK_MPRQ, handleProfiling);
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void handleChunk(ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId) {
        Log.d("ddm-prof", "handling " + ChunkHandler.name(type));
        if (type == CHUNK_MPRE) {
            handleMPRE(client, data);
            return;
        }
        if (type == CHUNK_MPSE) {
            handleMPSE(client, data);
            return;
        }
        if (type == CHUNK_MPRQ) {
            handleMPRQ(client, data);
        } else if (type == CHUNK_FAIL) {
            handleFAIL(client, data);
        } else {
            handleUnknownChunk(client, type, data, isReply, msgId);
        }
    }

    public static void sendMPRS(ClientImpl client, String fileName, int bufferSize, int flags) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer((fileName.length() * 2) + 12);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(bufferSize);
        chunkDataBuf.putInt(flags);
        chunkDataBuf.putInt(fileName.length());
        ByteBufferUtil.putString(chunkDataBuf, fileName);
        int i = CHUNK_MPRS;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-prof", "Sending " + name(i) + " '" + fileName + "', size=" + bufferSize + ", flags=" + flags);
        client.send(jdwpPacket, mInst);
        client.getClientData().setPendingMethodProfiling(fileName);
        sendMPRQ(client);
    }

    public static void sendMPRE(ClientImpl client) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(0);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        int i = CHUNK_MPRE;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-prof", "Sending " + name(i));
        client.send(jdwpPacket, mInst);
    }

    private void handleMPRE(ClientImpl client, ByteBuffer data) {
        String pendingMethodProfiling = client.getClientData().getPendingMethodProfiling();
        client.getClientData().setPendingMethodProfiling(null);
        byte b = data.get();
        ClientData.IMethodProfilingHandler methodProfilingHandler = ClientData.getMethodProfilingHandler();
        if (methodProfilingHandler != null) {
            if (b == 0) {
                methodProfilingHandler.onSuccess(pendingMethodProfiling, client);
                Log.d("ddm-prof", "Method profiling has finished");
            } else {
                methodProfilingHandler.onEndFailure(client, null);
                Log.w("ddm-prof", "Method profiling has failed (check device log)");
            }
        }
        client.getClientData().setMethodProfilingStatus(ClientData.MethodProfilingStatus.OFF);
        client.update(2048);
    }

    public static void sendMPSS(ClientImpl client, int bufferSize, int flags) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(8);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(bufferSize);
        chunkDataBuf.putInt(flags);
        int i = CHUNK_MPSS;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-prof", "Sending " + name(i) + "', size=" + bufferSize + ", flags=" + flags);
        client.send(jdwpPacket, mInst);
        sendMPRQ(client);
    }

    public static void sendSPSS(ClientImpl client, int bufferSize, int samplingInterval, TimeUnit samplingIntervalTimeUnits) throws IOException {
        int micros = (int) samplingIntervalTimeUnits.toMicros(samplingInterval);
        ByteBuffer byteBufferAllocBuffer = allocBuffer(12);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(bufferSize);
        chunkDataBuf.putInt(0);
        chunkDataBuf.putInt(micros);
        int i = CHUNK_SPSS;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-prof", "Sending " + name(i) + "', size=" + bufferSize + ", flags=0, samplingInterval=" + micros);
        client.send(jdwpPacket, mInst);
        sendMPRQ(client);
    }

    public static void sendMPSE(ClientImpl client) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(0);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        int i = CHUNK_MPSE;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-prof", "Sending " + name(i));
        client.send(jdwpPacket, mInst);
    }

    public static void sendSPSE(ClientImpl client) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(0);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        int i = CHUNK_SPSE;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-prof", "Sending " + name(i));
        client.send(jdwpPacket, mInst);
    }

    private void handleMPSE(ClientImpl client, ByteBuffer data) {
        ClientData.IMethodProfilingHandler methodProfilingHandler = ClientData.getMethodProfilingHandler();
        if (methodProfilingHandler != null) {
            int iCapacity = data.capacity();
            byte[] bArr = new byte[iCapacity];
            data.get(bArr, 0, iCapacity);
            Log.d("ddm-prof", "got trace file, size: " + iCapacity + " bytes");
            methodProfilingHandler.onSuccess(bArr, client);
        }
        client.getClientData().setMethodProfilingStatus(ClientData.MethodProfilingStatus.OFF);
        client.update(2048);
    }

    public static void sendMPRQ(ClientImpl client) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(0);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        int i = CHUNK_MPRQ;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-prof", "Sending " + name(i));
        client.send(jdwpPacket, mInst);
    }

    private void handleMPRQ(ClientImpl client, ByteBuffer data) {
        byte b = data.get();
        if (b == 0) {
            client.getClientData().setMethodProfilingStatus(ClientData.MethodProfilingStatus.OFF);
            Log.d("ddm-prof", "Method profiling is not running");
        } else if (b == 1) {
            client.getClientData().setMethodProfilingStatus(ClientData.MethodProfilingStatus.TRACER_ON);
            Log.d("ddm-prof", "Method tracing is active");
        } else if (b == 2) {
            client.getClientData().setMethodProfilingStatus(ClientData.MethodProfilingStatus.SAMPLER_ON);
            Log.d("ddm-prof", "Sampler based profiling is active");
        }
        client.update(2048);
    }

    private void handleFAIL(ClientImpl client, ByteBuffer data) {
        String str;
        data.getInt();
        int i = data.getInt() * 2;
        if (i > 0) {
            byte[] bArr = new byte[i];
            data.get(bArr, 0, i);
            str = new String(bArr);
        } else {
            str = null;
        }
        if (client.getClientData().getPendingMethodProfiling() != null) {
            client.getClientData().setPendingMethodProfiling(null);
            ClientData.IMethodProfilingHandler methodProfilingHandler = ClientData.getMethodProfilingHandler();
            if (methodProfilingHandler != null) {
                methodProfilingHandler.onStartFailure(client, str);
            }
        } else {
            ClientData.IMethodProfilingHandler methodProfilingHandler2 = ClientData.getMethodProfilingHandler();
            if (methodProfilingHandler2 != null) {
                methodProfilingHandler2.onEndFailure(client, str);
            }
        }
        try {
            sendMPRQ(client);
        } catch (IOException e) {
            Log.e("HandleProfiling", e);
        }
    }
}
