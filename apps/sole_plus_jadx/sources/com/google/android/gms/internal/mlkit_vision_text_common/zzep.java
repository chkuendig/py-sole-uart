package com.google.android.gms.internal.mlkit_vision_text_common;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public final class zzep {
    private zzes zza;
    private Integer zzb;
    private zznw zzc;

    public final zzep zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzep zzb(zznw zznwVar) {
        this.zzc = zznwVar;
        return this;
    }

    public final zzep zzc(zzes zzesVar) {
        this.zza = zzesVar;
        return this;
    }

    public final zzeu zze() {
        return new zzeu(this, null);
    }
}
