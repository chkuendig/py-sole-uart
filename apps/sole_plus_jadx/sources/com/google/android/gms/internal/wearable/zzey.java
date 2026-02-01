package com.google.android.gms.internal.wearable;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
abstract class zzey {
    final Unsafe zza;

    zzey(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(Object obj, long j);

    public abstract float zzb(Object obj, long j);

    public abstract void zzc(Object obj, long j, boolean z);

    public abstract void zzd(Object obj, long j, byte b);

    public abstract void zze(Object obj, long j, double d);

    public abstract void zzf(Object obj, long j, float f);

    public abstract boolean zzg(Object obj, long j);
}
