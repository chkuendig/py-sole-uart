package com.android.ddmlib.internal.jdwp.interceptor;

import com.android.ddmlib.TimeoutException;
import com.android.ddmlib.internal.jdwp.JdwpProxyClient;
import com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleHeap;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleHello;
import com.android.ddmlib.internal.jdwp.chunkhandler.HandleProfiling;
import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* loaded from: classes3.dex */
public class ClientInitializationInterceptor implements Interceptor {
    private static int PACKET_ID_OFFSET = 4;
    private final Set<Integer> mCachePacketFilter;
    private final Map<Integer, byte[]> mCachedPackets;
    private final HashMap<Integer, Set<ClientRequestId>> mPendingPackets;
    private final Set<Integer> mReplyPacketFilter;

    private static class ClientRequestId {
        public JdwpProxyClient client;
        public int requestId;

        ClientRequestId(JdwpProxyClient client, int requestId) {
            this.client = client;
            this.requestId = requestId;
        }
    }

    public ClientInitializationInterceptor() {
        HashSet hashSet = new HashSet();
        this.mCachePacketFilter = hashSet;
        HashSet hashSet2 = new HashSet();
        this.mReplyPacketFilter = hashSet2;
        this.mCachedPackets = new HashMap();
        this.mPendingPackets = new HashMap<>();
        hashSet.add(Integer.valueOf(HandleHello.CHUNK_HELO));
        hashSet.add(Integer.valueOf(HandleHello.CHUNK_FEAT));
        hashSet2.add(Integer.valueOf(HandleProfiling.CHUNK_MPRQ));
        hashSet2.add(Integer.valueOf(HandleHeap.CHUNK_HPIF));
        hashSet2.add(Integer.valueOf(HandleHeap.CHUNK_REAQ));
    }

    @Override // com.android.ddmlib.internal.jdwp.interceptor.Interceptor
    public boolean filterToDevice(JdwpProxyClient from, JdwpPacket packet) throws IOException, TimeoutException {
        if (packet.isEmpty() || packet.isError() || packet.getLength() < 15) {
            return false;
        }
        int i = packet.getPayload().getInt();
        if (!this.mCachePacketFilter.contains(Integer.valueOf(i)) && !this.mReplyPacketFilter.contains(Integer.valueOf(i))) {
            return false;
        }
        if (this.mCachedPackets.containsKey(Integer.valueOf(i))) {
            sendCachedPacket(from, i, packet.getId());
            return true;
        }
        boolean zContainsKey = this.mPendingPackets.containsKey(Integer.valueOf(i));
        this.mPendingPackets.computeIfAbsent(Integer.valueOf(i), new Function() { // from class: com.android.ddmlib.internal.jdwp.interceptor.ClientInitializationInterceptor$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ClientInitializationInterceptor.lambda$filterToDevice$0((Integer) obj);
            }
        }).add(new ClientRequestId(from, packet.getId()));
        return zContainsKey;
    }

    static /* synthetic */ Set lambda$filterToDevice$0(Integer num) {
        return new HashSet();
    }

    @Override // com.android.ddmlib.internal.jdwp.interceptor.Interceptor
    public boolean filterToClient(JdwpProxyClient to, JdwpPacket packet) throws IOException, TimeoutException {
        if (!packet.isReply() || packet.isEmpty() || packet.isError() || packet.getLength() < 15) {
            return false;
        }
        int i = packet.getPayload().getInt();
        if (!this.mPendingPackets.containsKey(Integer.valueOf(i))) {
            return false;
        }
        if (this.mCachePacketFilter.contains(Integer.valueOf(i))) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(packet.getLength());
            byteBufferAllocate.order(ChunkHandler.CHUNK_ORDER);
            packet.copy(byteBufferAllocate);
            this.mCachedPackets.put(Integer.valueOf(i), byteBufferAllocate.array());
            for (ClientRequestId clientRequestId : this.mPendingPackets.get(Integer.valueOf(i))) {
                sendCachedPacket(clientRequestId.client, i, clientRequestId.requestId);
            }
        } else if (this.mReplyPacketFilter.contains(Integer.valueOf(i))) {
            for (ClientRequestId clientRequestId2 : this.mPendingPackets.get(Integer.valueOf(i))) {
                sendPacketWithUpdatedPacketId(clientRequestId2.client, clientRequestId2.requestId, packet);
            }
        }
        this.mPendingPackets.remove(Integer.valueOf(i));
        return true;
    }

    private void sendCachedPacket(JdwpProxyClient to, int type, int id2) throws IOException, TimeoutException {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.mCachedPackets.get(Integer.valueOf(type)));
        byteBufferWrap.order(ChunkHandler.CHUNK_ORDER);
        byteBufferWrap.putInt(PACKET_ID_OFFSET, id2);
        to.write(byteBufferWrap.array(), byteBufferWrap.limit());
    }

    private static void sendPacketWithUpdatedPacketId(JdwpProxyClient to, int id2, JdwpPacket packet) throws IOException, TimeoutException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(packet.getLength());
        byteBufferAllocate.order(ChunkHandler.CHUNK_ORDER);
        packet.copy(byteBufferAllocate);
        byteBufferAllocate.putInt(PACKET_ID_OFFSET, id2);
        to.write(byteBufferAllocate.array(), byteBufferAllocate.limit());
    }
}
