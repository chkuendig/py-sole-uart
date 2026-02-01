package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes4.dex */
public final class zzab {
    zzab(Context context) {
    }

    public static boolean zza() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
