package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzlg<T> implements zzln<T> {
    private final zzlc zza;
    private final zzmb<?, ?> zzb;
    private final boolean zzc;
    private final zzjk<?> zzd;

    private zzlg(zzmb<?, ?> zzmbVar, zzjk<?> zzjkVar, zzlc zzlcVar) {
        this.zzb = zzmbVar;
        this.zzc = zzjkVar.zzc(zzlcVar);
        this.zzd = zzjkVar;
        this.zza = zzlcVar;
    }

    static <T> zzlg<T> zzc(zzmb<?, ?> zzmbVar, zzjk<?> zzjkVar, zzlc zzlcVar) {
        return new zzlg<>(zzmbVar, zzjkVar, zzlcVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final int zza(T t) {
        zzmb<?, ?> zzmbVar = this.zzb;
        int iZzb = zzmbVar.zzb(zzmbVar.zzc(t));
        if (!this.zzc) {
            return iZzb;
        }
        this.zzd.zza(t);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final int zzb(T t) {
        int iHashCode = this.zzb.zzc(t).hashCode();
        if (!this.zzc) {
            return iHashCode;
        }
        this.zzd.zza(t);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final T zze() {
        return (T) this.zza.zzbC().zzaC();
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final void zzf(T t) {
        this.zzb.zzg(t);
        this.zzd.zzb(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final void zzg(T t, T t2) {
        zzlp.zzF(this.zzb, t, t2);
        if (this.zzc) {
            zzlp.zzE(this.zzd, t, t2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzln
    public final void zzh(T t, byte[] bArr, int i, int i2, zzik zzikVar) throws IOException {
        zzjx zzjxVar = (zzjx) t;
        if (zzjxVar.zzc == zzmc.zzc()) {
            zzjxVar.zzc = zzmc.zze();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final boolean zzi(T t, T t2) {
        if (!this.zzb.zzc(t).equals(this.zzb.zzc(t2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(t);
        this.zzd.zza(t2);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final boolean zzj(T t) {
        this.zzd.zza(t);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final void zzm(T t, zzjf zzjfVar) throws IOException {
        this.zzd.zza(t);
        throw null;
    }
}
