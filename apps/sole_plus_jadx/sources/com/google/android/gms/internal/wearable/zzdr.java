package com.google.android.gms.internal.wearable;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzdr implements zzdy {
    private final zzdn zza;
    private final zzep zzb;
    private final boolean zzc;
    private final zzbv zzd;

    private zzdr(zzep zzepVar, zzbv zzbvVar, zzdn zzdnVar) {
        this.zzb = zzepVar;
        this.zzc = zzbvVar.zzc(zzdnVar);
        this.zzd = zzbvVar;
        this.zza = zzdnVar;
    }

    static zzdr zzc(zzep zzepVar, zzbv zzbvVar, zzdn zzdnVar) {
        return new zzdr(zzepVar, zzbvVar, zzdnVar);
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final int zza(Object obj) {
        zzep zzepVar = this.zzb;
        int iZzb = zzepVar.zzb(zzepVar.zzd(obj));
        if (!this.zzc) {
            return iZzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final int zzb(Object obj) {
        int iHashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return iHashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final Object zze() {
        zzdn zzdnVar = this.zza;
        return zzdnVar instanceof zzcg ? ((zzcg) zzdnVar).zzP() : zzdnVar.zzW().zzs();
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzb(obj);
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final void zzg(Object obj, Object obj2) {
        zzea.zzp(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzau zzauVar) throws IOException {
        zzcg zzcgVar = (zzcg) obj;
        if (zzcgVar.zzc == zzeq.zzc()) {
            zzcgVar.zzc = zzeq.zzf();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final void zzi(Object obj, zzfh zzfhVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
