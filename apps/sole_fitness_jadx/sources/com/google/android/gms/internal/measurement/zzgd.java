package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzgd extends zzjx<zzgd, zzgc> implements zzld {
    private static final zzgd zza;
    private zzkd zze = zzby();
    private zzkd zzf = zzby();
    private zzke<zzfm> zzg = zzbA();
    private zzke<zzgf> zzh = zzbA();

    static {
        zzgd zzgdVar = new zzgd();
        zza = zzgdVar;
        zzjx.zzbG(zzgd.class, zzgdVar);
    }

    private zzgd() {
    }

    public static zzgc zzf() {
        return zza.zzbu();
    }

    public static zzgd zzh() {
        return zza;
    }

    static /* synthetic */ void zzo(zzgd zzgdVar, Iterable iterable) {
        zzkd zzkdVar = zzgdVar.zze;
        if (!zzkdVar.zzc()) {
            zzgdVar.zze = zzjx.zzbz(zzkdVar);
        }
        zzih.zzbq(iterable, zzgdVar.zze);
    }

    static /* synthetic */ void zzq(zzgd zzgdVar, Iterable iterable) {
        zzkd zzkdVar = zzgdVar.zzf;
        if (!zzkdVar.zzc()) {
            zzgdVar.zzf = zzjx.zzbz(zzkdVar);
        }
        zzih.zzbq(iterable, zzgdVar.zzf);
    }

    static /* synthetic */ void zzs(zzgd zzgdVar, Iterable iterable) {
        zzgdVar.zzw();
        zzih.zzbq(iterable, zzgdVar.zzg);
    }

    static /* synthetic */ void zzt(zzgd zzgdVar, int i) {
        zzgdVar.zzw();
        zzgdVar.zzg.remove(i);
    }

    static /* synthetic */ void zzu(zzgd zzgdVar, Iterable iterable) {
        zzgdVar.zzx();
        zzih.zzbq(iterable, zzgdVar.zzh);
    }

    static /* synthetic */ void zzv(zzgd zzgdVar, int i) {
        zzgdVar.zzx();
        zzgdVar.zzh.remove(i);
    }

    private final void zzw() {
        zzke<zzfm> zzkeVar = this.zzg;
        if (zzkeVar.zzc()) {
            return;
        }
        this.zzg = zzjx.zzbB(zzkeVar);
    }

    private final void zzx() {
        zzke<zzgf> zzkeVar = this.zzh;
        if (zzkeVar.zzc()) {
            return;
        }
        this.zzh = zzjx.zzbB(zzkeVar);
    }

    public final int zza() {
        return this.zzg.size();
    }

    public final int zzb() {
        return this.zzf.size();
    }

    public final int zzc() {
        return this.zzh.size();
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final zzfm zze(int i) {
        return this.zzg.get(i);
    }

    public final zzgf zzi(int i) {
        return this.zzh.get(i);
    }

    public final List<zzfm> zzj() {
        return this.zzg;
    }

    public final List<Long> zzk() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzjx
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbF(zza, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zze", "zzf", "zzg", zzfm.class, "zzh", zzgf.class});
        }
        if (i2 == 3) {
            return new zzgd();
        }
        zzff zzffVar = null;
        if (i2 == 4) {
            return new zzgc(zzffVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final List<zzgf> zzm() {
        return this.zzh;
    }

    public final List<Long> zzn() {
        return this.zze;
    }
}
