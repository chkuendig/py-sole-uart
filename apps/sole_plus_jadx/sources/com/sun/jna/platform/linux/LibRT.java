package com.sun.jna.platform.linux;

import com.sun.jna.Library;
import com.sun.jna.Native;

/* loaded from: classes4.dex */
public interface LibRT extends Library {
    public static final LibRT INSTANCE = (LibRT) Native.load("rt", LibRT.class);

    int shm_open(String str, int i, int i2);

    int shm_unlink(String str);
}
