package com.android.ddmlib.internal.jdwp.interceptor;

import com.android.ddmlib.TimeoutException;
import com.android.ddmlib.internal.jdwp.JdwpProxyClient;
import com.android.ddmlib.internal.jdwp.chunkhandler.JdwpPacket;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface Interceptor {
    default boolean filterToClient(JdwpProxyClient to, JdwpPacket packetToSend) throws IOException, TimeoutException {
        return false;
    }

    default boolean filterToDevice(JdwpProxyClient from, JdwpPacket packetToSend) throws IOException, TimeoutException {
        return false;
    }
}
