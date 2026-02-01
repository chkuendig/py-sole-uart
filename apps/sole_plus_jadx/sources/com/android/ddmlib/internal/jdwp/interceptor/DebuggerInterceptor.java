package com.android.ddmlib.internal.jdwp.interceptor;

import com.android.ddmlib.internal.jdwp.JdwpProxyClient;
import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;

/* loaded from: classes3.dex */
public class DebuggerInterceptor implements Interceptor {
    private JdwpProxyClient mAttachedClient;

    @Override // com.android.ddmlib.internal.jdwp.interceptor.Interceptor
    public boolean filterToDevice(JdwpProxyClient from, JdwpPacket packet) {
        if (packet.is(1, 7)) {
            this.mAttachedClient = from;
        }
        JdwpProxyClient jdwpProxyClient = this.mAttachedClient;
        if (jdwpProxyClient != null && !jdwpProxyClient.isConnected()) {
            this.mAttachedClient = null;
        }
        JdwpProxyClient jdwpProxyClient2 = this.mAttachedClient;
        return (jdwpProxyClient2 == null || jdwpProxyClient2 == from) ? false : true;
    }

    @Override // com.android.ddmlib.internal.jdwp.interceptor.Interceptor
    public boolean filterToClient(JdwpProxyClient to, JdwpPacket packet) {
        JdwpProxyClient jdwpProxyClient = this.mAttachedClient;
        return (jdwpProxyClient == null || jdwpProxyClient == to) ? false : true;
    }
}
