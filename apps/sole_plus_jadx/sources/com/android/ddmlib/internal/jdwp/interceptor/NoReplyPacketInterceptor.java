package com.android.ddmlib.internal.jdwp.interceptor;

import com.android.ddmlib.TimeoutException;
import com.android.ddmlib.internal.jdwp.JdwpProxyClient;
import com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler;
import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/* loaded from: classes3.dex */
public class NoReplyPacketInterceptor implements Interceptor {
    private List<ByteBuffer> mCachedPackets = new ArrayList();
    private Set<JdwpProxyClient> mClientsSentCacheTo = new HashSet();

    List<ByteBuffer> getCachedPackets() {
        return this.mCachedPackets;
    }

    Set<JdwpProxyClient> getClientsSentCacheTo() {
        return this.mClientsSentCacheTo;
    }

    @Override // com.android.ddmlib.internal.jdwp.interceptor.Interceptor
    public boolean filterToClient(JdwpProxyClient to, JdwpPacket packetToSend) throws IOException, TimeoutException {
        if (to.isHandshakeComplete() && !this.mClientsSentCacheTo.contains(to)) {
            sendCacheToClient(to);
        }
        if (packetToSend.isEmpty() || packetToSend.isError() || packetToSend.isReply()) {
            return false;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(packetToSend.getLength());
        byteBufferAllocate.order(ChunkHandler.CHUNK_ORDER);
        packetToSend.copy(byteBufferAllocate);
        this.mCachedPackets.add(byteBufferAllocate);
        return !to.isHandshakeComplete();
    }

    private void sendCacheToClient(JdwpProxyClient client) throws IOException, TimeoutException {
        for (ByteBuffer byteBuffer : this.mCachedPackets) {
            client.write(byteBuffer.array(), byteBuffer.position());
        }
        this.mClientsSentCacheTo.add(client);
        this.mClientsSentCacheTo.removeIf(new Predicate() { // from class: com.android.ddmlib.internal.jdwp.interceptor.NoReplyPacketInterceptor$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return NoReplyPacketInterceptor.lambda$sendCacheToClient$0((JdwpProxyClient) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$sendCacheToClient$0(JdwpProxyClient jdwpProxyClient) {
        return !jdwpProxyClient.isConnected();
    }
}
