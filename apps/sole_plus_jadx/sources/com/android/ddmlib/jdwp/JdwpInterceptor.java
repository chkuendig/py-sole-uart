package com.android.ddmlib.jdwp;

import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;

/* loaded from: classes3.dex */
public abstract class JdwpInterceptor {
    public abstract JdwpPacket intercept(JdwpPipe pipe, JdwpPacket packet);
}
