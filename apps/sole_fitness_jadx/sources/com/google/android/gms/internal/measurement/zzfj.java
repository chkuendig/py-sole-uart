package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzfj extends zzjt<zzfk, zzfj> implements zzld {
    private zzfj() {
        super(zzfk.zza);
    }

    public final zzfj zza(int i) {
        if (this.zzb) {
            zzaE();
            this.zzb = false;
        }
        zzfk.zzf((zzfk) this.zza, i);
        return this;
    }

    public final zzfj zzb(zzgc zzgcVar) {
        if (this.zzb) {
            zzaE();
            this.zzb = false;
        }
        zzfk.zzg((zzfk) this.zza, zzgcVar.zzaA());
        return this;
    }

    public final zzfj zzc(boolean z) {
        if (this.zzb) {
            zzaE();
            this.zzb = false;
        }
        zzfk.zzi((zzfk) this.zza, z);
        return this;
    }

    public final zzfj zzd(zzgd zzgdVar) {
        if (this.zzb) {
            zzaE();
            this.zzb = false;
        }
        zzfk.zzh((zzfk) this.zza, zzgdVar);
        return this;
    }

    /* synthetic */ zzfj(zzff zzffVar) {
        super(zzfk.zza);
    }
}
