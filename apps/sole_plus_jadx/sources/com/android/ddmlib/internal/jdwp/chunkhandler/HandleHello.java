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
public final class HandleHello extends ChunkHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CHUNK_HELO = ChunkHandler.type("HELO");
    public static final int CHUNK_FEAT = ChunkHandler.type("FEAT");
    private static final HandleHello mInst = new HandleHello();

    private HandleHello() {
    }

    public static void register(MonitorThread mt) {
        mt.registerChunkHandler(CHUNK_HELO, mInst);
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientReady(ClientImpl client) {
        Log.d("ddm-hello", "Now ready: " + client);
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientDisconnected(ClientImpl client) {
        Log.d("ddm-hello", "Now disconnected: " + client);
    }

    public static void sendHelloCommands(ClientImpl client, int serverProtocolVersion) throws IOException {
        sendHELO(client, serverProtocolVersion);
        sendFEAT(client);
        HandleProfiling.sendMPRQ(client);
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void handleChunk(ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId) {
        Log.d("ddm-hello", "handling " + ChunkHandler.name(type));
        if (type == CHUNK_HELO) {
            handleHELO(client, data);
        } else if (type == CHUNK_FEAT) {
            handleFEAT(client, data);
        } else {
            handleUnknownChunk(client, type, data, isReply, msgId);
        }
    }

    private static void handleHELO(ClientImpl client, ByteBuffer data) {
        Integer numValueOf;
        String string;
        boolean z;
        boolean z2;
        int i = data.getInt();
        int i2 = data.getInt();
        int i3 = data.getInt();
        int i4 = data.getInt();
        String string2 = ByteBufferUtil.getString(data, i3);
        String string3 = ByteBufferUtil.getString(data, i4);
        Log.d("ddm-hello", String.format("HELO: v=%d, pid=%d, vm='%s', app='%s'", Integer.valueOf(i), Integer.valueOf(i2), string2, string3));
        String string4 = null;
        if (data.hasRemaining()) {
            try {
                numValueOf = Integer.valueOf(data.getInt());
            } catch (BufferUnderflowException unused) {
                Log.e("ddm-hello", "Insufficient data in HELO chunk to retrieve user id.");
                Log.e("ddm-hello", "Actual chunk length: " + data.capacity());
                Log.e("ddm-hello", "Expected chunk length: " + ((i4 * 2) + 20 + (i3 * 2)));
            }
        } else {
            numValueOf = null;
        }
        boolean z3 = false;
        if (data.hasRemaining()) {
            try {
                string = ByteBufferUtil.getString(data, data.getInt());
                z = true;
            } catch (BufferUnderflowException unused2) {
                Log.e("ddm-hello", "Insufficient data in HELO chunk to retrieve ABI.");
            }
        } else {
            z = false;
            string = null;
        }
        if (data.hasRemaining()) {
            try {
                string4 = ByteBufferUtil.getString(data, data.getInt());
                z2 = true;
            } catch (BufferUnderflowException unused3) {
                Log.e("ddm-hello", "Insufficient data in HELO chunk to retrieve JVM flags");
            }
        } else {
            z2 = false;
        }
        if (data.hasRemaining()) {
            try {
                if (data.get() == 1) {
                    z3 = true;
                }
            } catch (BufferUnderflowException unused4) {
                Log.e("ddm-hello", "Insufficient data in HELO chunk to retrieve nativeDebuggable");
            }
        }
        String string5 = "";
        if (data.hasRemaining()) {
            try {
                string5 = ByteBufferUtil.getString(data, data.getInt());
                Log.d("ddm-hello", String.format("HELO: pkg='%s'", string5));
            } catch (BufferUnderflowException unused5) {
                Log.e("ddm-hello", "Insufficient data in HELO chunk to retrieve packageName");
            }
        }
        ClientData clientData = client.getClientData();
        if (clientData.getPid() == i2) {
            clientData.setVmIdentifier(string2);
            clientData.setNames(new ClientData.Names(string3, numValueOf, string5));
            if (z) {
                clientData.setAbi(string);
            }
            if (z2) {
                clientData.setJvmFlags(string4);
            }
            clientData.setNativeDebuggable(z3);
        } else {
            Log.e("ddm-hello", "Received pid (" + i2 + ") does not match client pid (" + clientData.getPid() + ")");
        }
        if (client != null) {
            client.update(1);
        }
    }

    public static void sendHELO(ClientImpl client, int serverProtocolVersion) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(4);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(serverProtocolVersion);
        int i = CHUNK_HELO;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-hello", "Sending " + name(i) + " ID=0x" + Integer.toHexString(jdwpPacket.getId()));
        client.send(jdwpPacket, mInst);
    }

    private static void handleFEAT(ClientImpl client, ByteBuffer data) {
        int i = data.getInt();
        for (int i2 = 0; i2 < i; i2++) {
            String string = ByteBufferUtil.getString(data, data.getInt());
            client.getClientData().addFeature(string);
            Log.d("ddm-hello", "Feature: " + string);
        }
    }

    public static void sendFEAT(ClientImpl client) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(0);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        int i = CHUNK_FEAT;
        finishChunkPacket(jdwpPacket, i, chunkDataBuf.position());
        Log.d("ddm-heap", "Sending " + name(i));
        client.send(jdwpPacket, mInst);
    }
}
