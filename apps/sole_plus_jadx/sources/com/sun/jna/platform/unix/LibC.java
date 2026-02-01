package com.sun.jna.platform.unix;

import com.sun.jna.Library;
import com.sun.jna.Native;

/* loaded from: classes4.dex */
public interface LibC extends LibCAPI, Library {
    public static final LibC INSTANCE = (LibC) Native.load("c", LibC.class);
    public static final String NAME = "c";
}
