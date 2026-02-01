package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
abstract class zzkq {
    private static final zzkq zza;
    private static final zzkq zzb;

    static {
        zzkn zzknVar = null;
        zza = new zzko(zzknVar);
        zzb = new zzkp(zzknVar);
    }

    /* synthetic */ zzkq(zzkn zzknVar) {
    }

    static zzkq zzc() {
        return zza;
    }

    static zzkq zzd() {
        return zzb;
    }

    abstract void zza(Object obj, long j);

    abstract <L> void zzb(Object obj, Object obj2, long j);
}
