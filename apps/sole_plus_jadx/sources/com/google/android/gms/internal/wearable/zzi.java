package com.google.android.gms.internal.wearable;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public class zzi extends Handler {
    private final Looper zza;

    public zzi(Looper looper) {
        super(looper);
        this.zza = Looper.getMainLooper();
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        zza(message);
    }

    protected void zza(Message message) {
        super.dispatchMessage(message);
    }
}
