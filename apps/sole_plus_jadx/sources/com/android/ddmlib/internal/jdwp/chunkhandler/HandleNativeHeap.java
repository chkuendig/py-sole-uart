package com.android.ddmlib.internal.jdwp.chunkhandler;

import com.android.ddmlib.ClientData;
import com.android.ddmlib.Log;
import com.android.ddmlib.NativeAllocationInfo;
import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.MonitorThread;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public final class HandleNativeHeap extends ChunkHandler {
    public static final int CHUNK_NHGT = type("NHGT");
    public static final int CHUNK_NHSG = type("NHSG");
    public static final int CHUNK_NHST = type("NHST");
    public static final int CHUNK_NHEN = type("NHEN");
    private static final HandleNativeHeap mInst = new HandleNativeHeap();

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientDisconnected(ClientImpl client) {
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientReady(ClientImpl client) {
    }

    abstract class NativeBuffer {
        protected ByteBuffer mBuffer;

        public abstract long getPtr();

        public abstract int getSizeT();

        public NativeBuffer(ByteBuffer buffer) {
            this.mBuffer = buffer;
        }
    }

    final class NativeBuffer32 extends NativeBuffer {
        public NativeBuffer32(ByteBuffer buffer) {
            super(buffer);
        }

        @Override // com.android.ddmlib.internal.jdwp.chunkhandler.HandleNativeHeap.NativeBuffer
        public int getSizeT() {
            return this.mBuffer.getInt();
        }

        @Override // com.android.ddmlib.internal.jdwp.chunkhandler.HandleNativeHeap.NativeBuffer
        public long getPtr() {
            return this.mBuffer.getInt() & 4294967295L;
        }
    }

    final class NativeBuffer64 extends NativeBuffer {
        public NativeBuffer64(ByteBuffer buffer) {
            super(buffer);
        }

        @Override // com.android.ddmlib.internal.jdwp.chunkhandler.HandleNativeHeap.NativeBuffer
        public int getSizeT() {
            return (int) this.mBuffer.getLong();
        }

        @Override // com.android.ddmlib.internal.jdwp.chunkhandler.HandleNativeHeap.NativeBuffer
        public long getPtr() {
            return this.mBuffer.getLong();
        }
    }

    private HandleNativeHeap() {
    }

    public static void register(MonitorThread mt) {
        int i = CHUNK_NHGT;
        HandleNativeHeap handleNativeHeap = mInst;
        mt.registerChunkHandler(i, handleNativeHeap);
        mt.registerChunkHandler(CHUNK_NHSG, handleNativeHeap);
        mt.registerChunkHandler(CHUNK_NHST, handleNativeHeap);
        mt.registerChunkHandler(CHUNK_NHEN, handleNativeHeap);
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void handleChunk(ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId) throws IOException, NumberFormatException {
        Log.d("ddm-nativeheap", "handling " + ChunkHandler.name(type));
        if (type == CHUNK_NHGT) {
            handleNHGT(client, data);
        } else if (type == CHUNK_NHST) {
            client.getClientData().getNativeHeapData().clearHeapData();
        } else if (type == CHUNK_NHEN) {
            client.getClientData().getNativeHeapData().sealHeapData();
        } else if (type == CHUNK_NHSG) {
            handleNHSG(client, data);
        } else {
            handleUnknownChunk(client, type, data, isReply, msgId);
        }
        client.update(128);
    }

    public static void sendNHGT(ClientImpl client) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(0);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        int i = CHUNK_NHGT;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-nativeheap", "Sending " + name(i));
        HandleNativeHeap handleNativeHeap = mInst;
        client.send(jdwpPacket, handleNativeHeap);
        ByteBuffer byteBufferAllocBuffer2 = allocBuffer(2);
        JdwpPacket jdwpPacket2 = new JdwpPacket(byteBufferAllocBuffer2);
        ByteBuffer chunkDataBuf2 = getChunkDataBuf(byteBufferAllocBuffer2);
        chunkDataBuf2.put((byte) 0);
        chunkDataBuf2.put((byte) 1);
        int i2 = CHUNK_NHSG;
        finishChunkPacket(jdwpPacket2, i2, chunkDataBuf2.position());
        Log.d("ddm-nativeheap", "Sending " + name(i2));
        client.send(jdwpPacket2, handleNativeHeap);
    }

    private void handleNHGT(ClientImpl client, ByteBuffer data) throws IOException, NumberFormatException {
        short s;
        NativeBuffer nativeBuffer64;
        ClientData clientData = client.getClientData();
        Log.d("ddm-nativeheap", "NHGT: " + data.limit() + " bytes");
        data.order(ByteOrder.LITTLE_ENDIAN);
        if (data.getInt(0) == -2128394787) {
            data.getInt();
            short s2 = data.getShort();
            if (s2 != 2) {
                Log.e("ddms", "Unknown header version: " + ((int) s2));
                return;
            }
            s = data.getShort();
        } else {
            s = 4;
        }
        if (s == 4) {
            nativeBuffer64 = new NativeBuffer32(data);
        } else {
            if (s != 8) {
                Log.e("ddms", "Unknown pointer size: " + ((int) s));
                return;
            }
            nativeBuffer64 = new NativeBuffer64(data);
        }
        clientData.clearNativeAllocationInfo();
        int sizeT = nativeBuffer64.getSizeT();
        int sizeT2 = nativeBuffer64.getSizeT();
        int sizeT3 = nativeBuffer64.getSizeT();
        int sizeT4 = nativeBuffer64.getSizeT();
        int sizeT5 = nativeBuffer64.getSizeT();
        Log.d("ddms", "mapSize: " + sizeT);
        Log.d("ddms", "allocSize: " + sizeT2);
        Log.d("ddms", "allocInfoSize: " + sizeT3);
        Log.d("ddms", "totalMemory: " + sizeT4);
        clientData.setTotalNativeMemory(sizeT4);
        if (sizeT3 == 0) {
            return;
        }
        if (sizeT > 0) {
            byte[] bArr = new byte[sizeT];
            data.get(bArr, 0, sizeT);
            parseMaps(clientData, bArr);
        }
        int i = sizeT2 / sizeT3;
        for (int i2 = 0; i2 < i; i2++) {
            NativeAllocationInfo nativeAllocationInfo = new NativeAllocationInfo(nativeBuffer64.getSizeT(), nativeBuffer64.getSizeT());
            for (int i3 = 0; i3 < sizeT5; i3++) {
                long ptr = nativeBuffer64.getPtr();
                if (ptr != 0) {
                    nativeAllocationInfo.addStackCallAddress(ptr);
                }
            }
            clientData.addNativeAllocation(nativeAllocationInfo);
        }
    }

    private void handleNHSG(ClientImpl client, ByteBuffer data) {
        byte[] bArr = new byte[data.limit()];
        data.rewind();
        data.get(bArr);
        client.getClientData().getNativeHeapData().addHeapData(ByteBuffer.wrap(bArr));
    }

    private void parseMaps(ClientData clientData, byte[] maps) throws IOException, NumberFormatException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(maps)));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return;
                }
                Log.d("ddms", "line: " + line);
                int iLastIndexOf = line.lastIndexOf(32);
                if (iLastIndexOf != -1) {
                    String strSubstring = line.substring(iLastIndexOf + 1);
                    if (strSubstring.startsWith("/")) {
                        int iIndexOf = line.indexOf(45);
                        int iIndexOf2 = line.indexOf(32, iIndexOf);
                        if (iIndexOf != -1 && iIndexOf2 != -1) {
                            try {
                                long j = Long.parseLong(line.substring(0, iIndexOf), 16);
                                long j2 = Long.parseLong(line.substring(iIndexOf + 1, iIndexOf2), 16);
                                clientData.addNativeLibraryMapInfo(j, j2, strSubstring);
                                Log.d("ddms", strSubstring + "(" + Long.toHexString(j) + " - " + Long.toHexString(j2) + ")");
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
    }
}
