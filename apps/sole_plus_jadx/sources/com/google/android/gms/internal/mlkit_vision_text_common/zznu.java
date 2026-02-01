package com.google.android.gms.internal.mlkit_vision_text_common;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public final class zznu {
    private Long zza;
    private Long zzb;
    private Long zzc;
    private Long zzd;
    private Long zze;
    private Long zzf;

    public final zznu zza(Long l) {
        this.zzc = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zznu zzb(Long l) {
        this.zzd = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zznu zzc(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zznu zzd(Long l) {
        this.zze = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zznu zze(Long l) {
        this.zzb = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zznu zzf(Long l) {
        this.zzf = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zznw zzg() {
        return new zznw(this, null);
    }
}
