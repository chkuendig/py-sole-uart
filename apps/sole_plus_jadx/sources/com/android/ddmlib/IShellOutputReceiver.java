package com.android.ddmlib;

/* loaded from: classes3.dex */
public interface IShellOutputReceiver {
    void addOutput(byte[] data, int offset, int length);

    void flush();

    boolean isCancelled();
}
