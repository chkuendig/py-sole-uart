package com.android.ddmlib;

/* loaded from: classes3.dex */
public final class NullOutputReceiver implements IShellOutputReceiver {
    private static NullOutputReceiver sReceiver = new NullOutputReceiver();

    @Override // com.android.ddmlib.IShellOutputReceiver
    public void addOutput(byte[] data, int offset, int length) {
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public void flush() {
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public boolean isCancelled() {
        return false;
    }

    public static IShellOutputReceiver getReceiver() {
        return sReceiver;
    }
}
