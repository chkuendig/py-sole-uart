package com.android.ddmlib.jdwp;

import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
public abstract class JdwpPipe {
    private final JdwpProtocol mProtocol;
    private final ConcurrentMap<Integer, JdwpInterceptor> mReplyInterceptors = new ConcurrentHashMap();
    private final List<JdwpInterceptor> mInterceptors = new LinkedList();

    protected abstract void send(JdwpPacket packet) throws IOException;

    public JdwpPipe(JdwpProtocol protocol) {
        this.mProtocol = protocol;
    }

    protected void addReplyInterceptor(int id2, JdwpInterceptor interceptor) {
        this.mReplyInterceptors.put(Integer.valueOf(id2), interceptor);
    }

    protected void removeReplyInterceptor(int id2) {
        this.mReplyInterceptors.remove(Integer.valueOf(id2));
    }

    public void clear() {
        this.mReplyInterceptors.clear();
    }

    public void addJdwpInterceptor(JdwpInterceptor interceptor) {
        this.mInterceptors.add(interceptor);
    }

    public void removeJdwpInterceptor(JdwpInterceptor interceptor) {
        this.mInterceptors.remove(interceptor);
    }

    public void incoming(JdwpPacket packet, JdwpPipe target) throws IOException {
        JdwpInterceptor jdwpInterceptorRemove;
        this.mProtocol.incoming(packet, target);
        int id2 = packet.getId();
        if (packet.isReply() && (jdwpInterceptorRemove = this.mReplyInterceptors.remove(Integer.valueOf(id2))) != null) {
            packet = jdwpInterceptorRemove.intercept(this, packet);
        }
        for (JdwpInterceptor jdwpInterceptor : this.mInterceptors) {
            if (packet == null) {
                break;
            } else {
                packet = jdwpInterceptor.intercept(this, packet);
            }
        }
        if (target == null || packet == null) {
            return;
        }
        target.send(packet);
    }

    public void send(JdwpPacket packet, JdwpInterceptor interceptor) throws IOException {
        this.mReplyInterceptors.put(Integer.valueOf(packet.getId()), interceptor);
        send(packet);
    }

    public JdwpProtocol getJdwpProtocol() {
        return this.mProtocol;
    }
}
