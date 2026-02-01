package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public class zzct {
    private static final zzbu zzb = zzbu.zza;
    protected volatile zzdn zza;
    private volatile zzbh zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzct)) {
            return false;
        }
        zzct zzctVar = (zzct) obj;
        zzdn zzdnVar = this.zza;
        zzdn zzdnVar2 = zzctVar.zza;
        if (zzdnVar == null && zzdnVar2 == null) {
            return zzb().equals(zzctVar.zzb());
        }
        if (zzdnVar != null && zzdnVar2 != null) {
            return zzdnVar.equals(zzdnVar2);
        }
        if (zzdnVar != null) {
            zzctVar.zzc(zzdnVar.zzag());
            return zzdnVar.equals(zzctVar.zza);
        }
        zzc(zzdnVar2.zzag());
        return this.zza.equals(zzdnVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzbe) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzM();
        }
        return 0;
    }

    public final zzbh zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzbh.zzb;
            } else {
                this.zzc = this.zza.zzI();
            }
            return this.zzc;
        }
    }

    protected final void zzc(zzdn zzdnVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzdnVar;
                    this.zzc = zzbh.zzb;
                } catch (zzcq unused) {
                    this.zza = zzdnVar;
                    this.zzc = zzbh.zzb;
                }
            }
        }
    }
}
