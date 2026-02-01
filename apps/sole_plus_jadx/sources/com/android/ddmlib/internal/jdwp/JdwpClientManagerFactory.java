package com.android.ddmlib.internal.jdwp;

import com.android.ddmlib.AdbCommandRejectedException;
import com.android.ddmlib.TimeoutException;
import com.android.ddmlib.internal.jdwp.JdwpClientManager;
import java.io.IOException;
import java.nio.channels.Selector;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class JdwpClientManagerFactory {
    private Map<JdwpClientManagerId, JdwpClientManager> myConnections = new HashMap();
    Selector selector;

    public JdwpClientManagerFactory(Selector selector) {
        this.selector = selector;
    }

    public JdwpClientManager getConnection(String deviceId, int pid) {
        return this.myConnections.getOrDefault(new JdwpClientManagerId(deviceId, pid), null);
    }

    public JdwpClientManager createConnection(final JdwpClientManagerId id2) throws IOException, TimeoutException, AdbCommandRejectedException {
        JdwpClientManager jdwpClientManager = this.myConnections.get(id2);
        if (jdwpClientManager != null) {
            return jdwpClientManager;
        }
        JdwpClientManager jdwpClientManager2 = new JdwpClientManager(id2, this.selector);
        jdwpClientManager2.addShutdownListener(new JdwpClientManager.ShutdownListener() { // from class: com.android.ddmlib.internal.jdwp.JdwpClientManagerFactory$$ExternalSyntheticLambda0
            @Override // com.android.ddmlib.internal.jdwp.JdwpClientManager.ShutdownListener
            public final void shutdown() {
                this.f$0.m7988xccb2ceef(id2);
            }
        });
        this.myConnections.put(id2, jdwpClientManager2);
        return jdwpClientManager2;
    }

    /* renamed from: lambda$createConnection$0$com-android-ddmlib-internal-jdwp-JdwpClientManagerFactory, reason: not valid java name */
    /* synthetic */ void m7988xccb2ceef(JdwpClientManagerId jdwpClientManagerId) {
        this.myConnections.remove(jdwpClientManagerId);
    }
}
