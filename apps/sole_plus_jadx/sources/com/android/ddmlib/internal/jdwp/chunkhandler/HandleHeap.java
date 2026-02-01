package com.android.ddmlib.internal.jdwp.chunkhandler;

import com.android.ddmlib.ByteBufferUtil;
import com.android.ddmlib.ClientData;
import com.android.ddmlib.Log;
import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.MonitorThread;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class HandleHeap extends ChunkHandler {
    public static final int HPIF_WHEN_EVERY_GC = 3;
    public static final int HPIF_WHEN_NEVER = 0;
    public static final int HPIF_WHEN_NEXT_GC = 2;
    public static final int HPIF_WHEN_NOW = 1;
    public static final int WHAT_MERGE = 0;
    public static final int WHAT_OBJ = 1;
    public static final int WHEN_DISABLE = 0;
    public static final int WHEN_GC = 1;
    public static final int CHUNK_HPIF = type("HPIF");
    public static final int CHUNK_HPST = type("HPST");
    public static final int CHUNK_HPEN = type("HPEN");
    public static final int CHUNK_HPSG = type("HPSG");
    public static final int CHUNK_HPGC = type("HPGC");
    public static final int CHUNK_HPDU = type("HPDU");
    public static final int CHUNK_HPDS = type("HPDS");
    public static final int CHUNK_REAE = type("REAE");
    public static final int CHUNK_REAQ = type("REAQ");
    public static final int CHUNK_REAL = type("REAL");
    private static final HandleHeap mInst = new HandleHeap();

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientDisconnected(ClientImpl client) {
    }

    private HandleHeap() {
    }

    public static void register(MonitorThread mt) {
        int i = CHUNK_HPIF;
        HandleHeap handleHeap = mInst;
        mt.registerChunkHandler(i, handleHeap);
        mt.registerChunkHandler(CHUNK_HPST, handleHeap);
        mt.registerChunkHandler(CHUNK_HPEN, handleHeap);
        mt.registerChunkHandler(CHUNK_HPSG, handleHeap);
        mt.registerChunkHandler(CHUNK_HPDS, handleHeap);
        mt.registerChunkHandler(CHUNK_REAQ, handleHeap);
        mt.registerChunkHandler(CHUNK_REAL, handleHeap);
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientReady(ClientImpl client) throws IOException {
        client.initializeHeapUpdateStatus();
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void handleChunk(ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId) {
        Log.d("ddm-heap", "handling " + ChunkHandler.name(type));
        if (type == CHUNK_HPIF) {
            handleHPIF(client, data);
            return;
        }
        if (type == CHUNK_HPST) {
            handleHPST(client, data);
            return;
        }
        if (type == CHUNK_HPEN) {
            handleHPEN(client, data);
            return;
        }
        if (type == CHUNK_HPSG) {
            handleHPSG(client, data);
            return;
        }
        if (type == CHUNK_HPDU) {
            handleHPDU(client, data);
            return;
        }
        if (type == CHUNK_HPDS) {
            handleHPDS(client, data);
            return;
        }
        if (type == CHUNK_REAQ) {
            handleREAQ(client, data);
        } else if (type == CHUNK_REAL) {
            handleREAL(client, data);
        } else {
            handleUnknownChunk(client, type, data, isReply, msgId);
        }
    }

    private void handleHPIF(ClientImpl client, ByteBuffer data) {
        Log.d("ddm-heap", "HPIF!");
        try {
            int i = data.getInt();
            for (int i2 = 0; i2 < i; i2++) {
                client.getClientData().setHeapInfo(data.getInt(), data.getInt(), data.getInt(), data.getInt(), data.getInt(), data.getLong(), data.get());
                client.update(64);
            }
        } catch (BufferUnderflowException unused) {
            Log.w("ddm-heap", "malformed HPIF chunk from client");
        }
    }

    public static void sendHPIF(ClientImpl client, int when) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(1);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.put((byte) when);
        int i = CHUNK_HPIF;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-heap", "Sending " + name(i) + ": when=" + when);
        client.send(jdwpPacket, mInst);
    }

    private void handleHPST(ClientImpl client, ByteBuffer data) {
        client.getClientData().getVmHeapData().clearHeapData();
    }

    private void handleHPEN(ClientImpl client, ByteBuffer data) {
        client.getClientData().getVmHeapData().sealHeapData();
        client.update(64);
    }

    private void handleHPSG(ClientImpl client, ByteBuffer data) {
        byte[] bArr = new byte[data.limit()];
        data.rewind();
        data.get(bArr);
        client.getClientData().getVmHeapData().addHeapData(ByteBuffer.wrap(bArr));
    }

    public static void sendHPSG(ClientImpl client, int when, int what) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(2);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.put((byte) when);
        chunkDataBuf.put((byte) what);
        int i = CHUNK_HPSG;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-heap", "Sending " + name(i) + ": when=" + when + ", what=" + what);
        client.send(jdwpPacket, mInst);
    }

    public static void sendHPGC(ClientImpl client) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(0);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        int i = CHUNK_HPGC;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-heap", "Sending " + name(i));
        client.send(jdwpPacket, mInst);
    }

    public static void sendHPDU(ClientImpl client, String fileName) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer((fileName.length() * 2) + 4);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(fileName.length());
        ByteBufferUtil.putString(chunkDataBuf, fileName);
        int i = CHUNK_HPDU;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-heap", "Sending " + name(i) + " '" + fileName + "'");
        client.send(jdwpPacket, mInst);
        client.getClientData().setPendingHprofDump(fileName);
    }

    public static void sendHPDS(ClientImpl client) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(0);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        int i = CHUNK_HPDS;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-heap", "Sending " + name(i));
        client.send(jdwpPacket, mInst);
    }

    private void handleHPDU(ClientImpl client, ByteBuffer data) {
        String pendingHprofDump = client.getClientData().getPendingHprofDump();
        client.getClientData().setPendingHprofDump(null);
        byte b = data.get();
        ClientData.IHprofDumpHandler hprofDumpHandler = ClientData.getHprofDumpHandler();
        if (b == 0) {
            if (hprofDumpHandler != null) {
                hprofDumpHandler.onSuccess(pendingHprofDump, client);
            }
            client.getClientData().setHprofData(pendingHprofDump);
            Log.d("ddm-heap", "Heap dump request has finished");
        } else {
            if (hprofDumpHandler != null) {
                hprofDumpHandler.onEndFailure(client, null);
            }
            client.getClientData().clearHprofData();
            Log.w("ddm-heap", "Heap dump request failed (check device log)");
        }
        client.update(4096);
        client.getClientData().clearHprofData();
    }

    private void handleHPDS(ClientImpl client, ByteBuffer data) {
        int iCapacity = data.capacity();
        byte[] bArr = new byte[iCapacity];
        data.get(bArr, 0, iCapacity);
        Log.d("ddm-hprof", "got hprof file, size: " + data.capacity() + " bytes");
        client.getClientData().setHprofData(bArr);
        ClientData.IHprofDumpHandler hprofDumpHandler = ClientData.getHprofDumpHandler();
        if (hprofDumpHandler != null) {
            hprofDumpHandler.onSuccess(bArr, client);
        }
        client.update(4096);
        client.getClientData().clearHprofData();
    }

    public static void sendREAE(ClientImpl clientImpl, boolean z) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(1);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.put(z ? (byte) 1 : (byte) 0);
        int i = CHUNK_REAE;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-heap", "Sending " + name(i) + ": " + z);
        clientImpl.send(jdwpPacket, mInst);
    }

    public static void sendREAQ(ClientImpl client) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(0);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        int i = CHUNK_REAQ;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-heap", "Sending " + name(i));
        client.send(jdwpPacket, mInst);
    }

    public static void sendREAL(ClientImpl client) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(0);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        int i = CHUNK_REAL;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-heap", "Sending " + name(i));
        client.send(jdwpPacket, mInst);
    }

    private void handleREAQ(ClientImpl client, ByteBuffer data) {
        boolean z = data.get() != 0;
        Log.d("ddm-heap", "REAQ says: enabled=" + z);
        client.getClientData().setAllocationStatus(z ? ClientData.AllocationTrackingStatus.ON : ClientData.AllocationTrackingStatus.OFF);
        client.update(1024);
    }

    private void handleREAL(ClientImpl client, ByteBuffer data) {
        Log.e("ddm-heap", "*** Received " + name(CHUNK_REAL));
        int iCapacity = data.capacity();
        byte[] bArr = new byte[iCapacity];
        data.get(bArr, 0, iCapacity);
        data.rewind();
        ClientData.IAllocationTrackingHandler allocationTrackingHandler = ClientData.getAllocationTrackingHandler();
        if (allocationTrackingHandler != null) {
            Log.d("ddm-prof", "got allocations file, size: " + iCapacity + " bytes");
            allocationTrackingHandler.onSuccess(bArr, client);
        }
        client.getClientData().setAllocationsData(bArr);
        client.update(512);
        client.getClientData().setAllocationsData(null);
    }
}
