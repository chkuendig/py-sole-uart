package com.android.ddmlib.jdwp;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public abstract class JdwpPayload {
    public abstract void parse(ByteBuffer buffer, JdwpProtocol protocol);
}
