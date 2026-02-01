package com.android.ddmlib;

import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.jdwp.chunkhandler.ChunkHandler;
import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;
import com.android.ddmlib.jdwp.JdwpExtension;
import com.android.ddmlib.jdwp.JdwpInterceptor;
import com.android.ddmlib.jdwp.JdwpPipe;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
public class DdmJdwpExtension extends JdwpExtension {
    private final ConcurrentMap<Integer, ChunkHandler> mHandlerMap = new ConcurrentHashMap();

    public enum Event {
        CLIENT_READY,
        CLIENT_DISCONNECTED
    }

    @Override // com.android.ddmlib.jdwp.JdwpExtension
    public void intercept(ClientImpl client) {
        client.addJdwpInterceptor(new DdmInterceptor(client));
    }

    public void registerHandler(int type, ChunkHandler handler) {
        this.mHandlerMap.putIfAbsent(Integer.valueOf(type), handler);
    }

    public void broadcast(Event event, ClientImpl client) {
        Log.d("ddms", "broadcast " + event + ": " + client);
        Iterator it = new HashSet(this.mHandlerMap.values()).iterator();
        while (it.hasNext()) {
            ChunkHandler chunkHandler = (ChunkHandler) it.next();
            int i = AnonymousClass1.$SwitchMap$com$android$ddmlib$DdmJdwpExtension$Event[event.ordinal()];
            if (i == 1) {
                try {
                    chunkHandler.clientReady(client);
                } catch (IOException unused) {
                    Log.w("ddms", "Got exception while broadcasting 'ready'");
                    return;
                }
            } else if (i == 2) {
                chunkHandler.clientDisconnected(client);
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* renamed from: com.android.ddmlib.DdmJdwpExtension$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$ddmlib$DdmJdwpExtension$Event;

        static {
            int[] iArr = new int[Event.values().length];
            $SwitchMap$com$android$ddmlib$DdmJdwpExtension$Event = iArr;
            try {
                iArr[Event.CLIENT_READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$ddmlib$DdmJdwpExtension$Event[Event.CLIENT_DISCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void ddmSeen(ClientImpl client) {
        if (client.ddmSeen()) {
            return;
        }
        broadcast(Event.CLIENT_READY, client);
    }

    static boolean isDdmPacket(JdwpPacket packet) {
        return !packet.isReply() && packet.is(199, 1);
    }

    public class DdmInterceptor extends JdwpInterceptor {
        private final ClientImpl mClient;

        public DdmInterceptor(ClientImpl client) {
            this.mClient = client;
        }

        @Override // com.android.ddmlib.jdwp.JdwpInterceptor
        public JdwpPacket intercept(JdwpPipe pipe, JdwpPacket packet) {
            if (!DdmJdwpExtension.isDdmPacket(packet)) {
                return packet;
            }
            DdmJdwpExtension.this.ddmSeen(this.mClient);
            ByteBuffer payload = packet.getPayload();
            ChunkHandler chunkHandler = (ChunkHandler) DdmJdwpExtension.this.mHandlerMap.get(Integer.valueOf(payload.getInt(payload.position())));
            if (chunkHandler == null) {
                Log.w("ddms", "Received unsupported chunk type ChunkHandler.name(type)");
                return null;
            }
            chunkHandler.handlePacket(this.mClient, packet);
            return null;
        }
    }
}
