package com.android.ddmlib.internal.jdwp.chunkhandler;

import com.android.ddmlib.ByteBufferUtil;
import com.android.ddmlib.Client;
import com.android.ddmlib.DebugViewDumpHandler;
import com.android.ddmlib.Log;
import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.MonitorThread;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class HandleViewDebug extends ChunkHandler {
    private static final String TAG = "ddmlib";
    private static final int VUOP_CAPTURE_VIEW = 1;
    private static final int VUOP_DUMP_DISPLAYLIST = 2;
    private static final int VUOP_INVOKE_VIEW_METHOD = 4;
    private static final int VUOP_PROFILE_VIEW = 3;
    private static final int VUOP_SET_LAYOUT_PARAMETER = 5;
    private static final int VURT_CAPTURE_LAYERS = 2;
    private static final int VURT_DUMP_HIERARCHY = 1;
    private static final int VURT_DUMP_THEME = 3;
    private static final HandleViewDebug sInstance = new HandleViewDebug();
    private static final DebugViewDumpHandler sViewOpNullChunkHandler = new NullChunkHandler(DebugViewDumpHandler.CHUNK_VUOP);

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientDisconnected(ClientImpl client) {
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void clientReady(ClientImpl client) throws IOException {
    }

    @Override // com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler
    public void handleChunk(ClientImpl client, int type, ByteBuffer data, boolean isReply, int msgId) {
    }

    private HandleViewDebug() {
    }

    public static void register(MonitorThread mt) {
        int i = DebugViewDumpHandler.CHUNK_VUGL;
        HandleViewDebug handleViewDebug = sInstance;
        mt.registerChunkHandler(i, handleViewDebug);
        mt.registerChunkHandler(DebugViewDumpHandler.CHUNK_VULW, handleViewDebug);
        mt.registerChunkHandler(DebugViewDumpHandler.CHUNK_VUOP, handleViewDebug);
        mt.registerChunkHandler(DebugViewDumpHandler.CHUNK_VURT, handleViewDebug);
    }

    public static void listViewRoots(Client client, DebugViewDumpHandler replyHandler) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(8);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(1);
        finishChunkPacket(jdwpPacket, DebugViewDumpHandler.CHUNK_VULW, chunkDataBuf.position());
        ((ClientImpl) client).send(jdwpPacket, replyHandler);
    }

    public static void dumpViewHierarchy(Client client, String str, boolean z, boolean z2, boolean z3, DebugViewDumpHandler debugViewDumpHandler) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer((str.length() * 2) + 20);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(1);
        chunkDataBuf.putInt(str.length());
        ByteBufferUtil.putString(chunkDataBuf, str);
        chunkDataBuf.putInt(z ? 1 : 0);
        chunkDataBuf.putInt(z2 ? 1 : 0);
        chunkDataBuf.putInt(z3 ? 1 : 0);
        finishChunkPacket(jdwpPacket, DebugViewDumpHandler.CHUNK_VURT, chunkDataBuf.position());
        ((ClientImpl) client).send(jdwpPacket, debugViewDumpHandler);
    }

    public static void captureLayers(ClientImpl client, String viewRoot, DebugViewDumpHandler handler) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer((viewRoot.length() * 2) + 8);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(2);
        chunkDataBuf.putInt(viewRoot.length());
        ByteBufferUtil.putString(chunkDataBuf, viewRoot);
        finishChunkPacket(jdwpPacket, DebugViewDumpHandler.CHUNK_VURT, chunkDataBuf.position());
        client.send(jdwpPacket, handler);
    }

    private static void sendViewOpPacket(Client client, int op, String viewRoot, String view, byte[] extra, DebugViewDumpHandler handler) throws IOException {
        int length = (viewRoot.length() * 2) + 12 + (view.length() * 2);
        if (extra != null) {
            length += extra.length;
        }
        ByteBuffer byteBufferAllocBuffer = allocBuffer(length);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(op);
        chunkDataBuf.putInt(viewRoot.length());
        ByteBufferUtil.putString(chunkDataBuf, viewRoot);
        chunkDataBuf.putInt(view.length());
        ByteBufferUtil.putString(chunkDataBuf, view);
        if (extra != null) {
            chunkDataBuf.put(extra);
        }
        finishChunkPacket(jdwpPacket, DebugViewDumpHandler.CHUNK_VUOP, chunkDataBuf.position());
        ((ClientImpl) client).send(jdwpPacket, handler);
    }

    public static void profileView(ClientImpl client, String viewRoot, String view, DebugViewDumpHandler handler) throws IOException {
        sendViewOpPacket(client, 3, viewRoot, view, null, handler);
    }

    public static void captureView(Client client, String viewRoot, String view, DebugViewDumpHandler handler) throws IOException {
        sendViewOpPacket(client, 1, viewRoot, view, null, handler);
    }

    public static void invalidateView(ClientImpl client, String viewRoot, String view) throws IOException {
        invokeMethod(client, viewRoot, view, "invalidate", new Object[0]);
    }

    public static void requestLayout(ClientImpl client, String viewRoot, String view) throws IOException {
        invokeMethod(client, viewRoot, view, "requestLayout", new Object[0]);
    }

    public static void dumpDisplayList(Client client, String viewRoot, String view) throws IOException {
        sendViewOpPacket(client, 2, viewRoot, view, null, sViewOpNullChunkHandler);
    }

    public static void dumpTheme(ClientImpl client, String viewRoot, DebugViewDumpHandler handler) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer((viewRoot.length() * 2) + 8);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(3);
        chunkDataBuf.putInt(viewRoot.length());
        ByteBufferUtil.putString(chunkDataBuf, viewRoot);
        finishChunkPacket(jdwpPacket, DebugViewDumpHandler.CHUNK_VURT, chunkDataBuf.position());
        client.send(jdwpPacket, handler);
    }

    private static class NullChunkHandler extends DebugViewDumpHandler {
        @Override // com.android.ddmlib.DebugViewDumpHandler
        protected void handleViewDebugResult(ByteBuffer data) {
        }

        public NullChunkHandler(int chunkType) {
            super(chunkType);
        }
    }

    public static void invokeMethod(ClientImpl clientImpl, String str, String str2, String str3, Object... objArr) throws IOException {
        int length = str3.length() * 2;
        int length2 = length + 4;
        if (objArr != null) {
            length2 = (objArr.length * 10) + length + 8;
        }
        byte[] bArr = new byte[length2];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.putInt(str3.length());
        ByteBufferUtil.putString(byteBufferWrap, str3);
        if (objArr != null) {
            byteBufferWrap.putInt(objArr.length);
            for (Object obj : objArr) {
                if (obj instanceof Boolean) {
                    byteBufferWrap.putChar('Z');
                    byteBufferWrap.put(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                } else if (obj instanceof Byte) {
                    byteBufferWrap.putChar('B');
                    byteBufferWrap.put(((Byte) obj).byteValue());
                } else if (obj instanceof Character) {
                    byteBufferWrap.putChar('C');
                    byteBufferWrap.putChar(((Character) obj).charValue());
                } else if (obj instanceof Short) {
                    byteBufferWrap.putChar('S');
                    byteBufferWrap.putShort(((Short) obj).shortValue());
                } else if (obj instanceof Integer) {
                    byteBufferWrap.putChar('I');
                    byteBufferWrap.putInt(((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    byteBufferWrap.putChar('J');
                    byteBufferWrap.putLong(((Long) obj).longValue());
                } else if (obj instanceof Float) {
                    byteBufferWrap.putChar('F');
                    byteBufferWrap.putFloat(((Float) obj).floatValue());
                } else if (obj instanceof Double) {
                    byteBufferWrap.putChar('D');
                    byteBufferWrap.putDouble(((Double) obj).doubleValue());
                } else {
                    Log.e(TAG, "View method invocation only supports primitive arguments, supplied: " + obj);
                    return;
                }
            }
        }
        sendViewOpPacket(clientImpl, 4, str, str2, bArr, sViewOpNullChunkHandler);
    }

    public static void setLayoutParameter(ClientImpl client, String viewRoot, String view, String parameter, int value) throws IOException {
        byte[] bArr = new byte[(parameter.length() * 2) + 8];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.putInt(parameter.length());
        ByteBufferUtil.putString(byteBufferWrap, parameter);
        byteBufferWrap.putInt(value);
        sendViewOpPacket(client, 5, viewRoot, view, bArr, sViewOpNullChunkHandler);
    }

    public static void sendStartGlTracing(ClientImpl client) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(4);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(1);
        finishChunkPacket(jdwpPacket, DebugViewDumpHandler.CHUNK_VUGL, chunkDataBuf.position());
        client.send(jdwpPacket, null);
    }

    public static void sendStopGlTracing(ClientImpl client) throws IOException {
        ByteBuffer byteBufferAllocBuffer = allocBuffer(4);
        JdwpPacket jdwpPacket = new JdwpPacket(byteBufferAllocBuffer);
        ByteBuffer chunkDataBuf = getChunkDataBuf(byteBufferAllocBuffer);
        chunkDataBuf.putInt(0);
        finishChunkPacket(jdwpPacket, DebugViewDumpHandler.CHUNK_VUGL, chunkDataBuf.position());
        client.send(jdwpPacket, null);
    }
}
