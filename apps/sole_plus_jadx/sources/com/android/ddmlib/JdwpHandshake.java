package com.android.ddmlib;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class JdwpHandshake {
    private static final byte[] HANDSHAKE;
    public static final int HANDSHAKE_BAD = 3;
    public static final int HANDSHAKE_GOOD = 1;
    public static final int HANDSHAKE_LEN;
    public static final int HANDSHAKE_NOTYET = 2;

    static {
        byte[] bArr = {74, 68, 87, 80, 45, 72, 97, 110, 100, 115, 104, 97, 107, 101};
        HANDSHAKE = bArr;
        HANDSHAKE_LEN = bArr.length;
    }

    public static int findHandshake(ByteBuffer buf) {
        int iPosition = buf.position();
        byte[] bArr = HANDSHAKE;
        if (iPosition < bArr.length) {
            return 2;
        }
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (buf.get(length) != HANDSHAKE[length]) {
                return 3;
            }
        }
        return 1;
    }

    public static void consumeHandshake(ByteBuffer buf) {
        buf.flip();
        buf.position(HANDSHAKE.length);
        buf.compact();
    }

    public static void putHandshake(ByteBuffer buf) {
        buf.put(HANDSHAKE);
    }
}
