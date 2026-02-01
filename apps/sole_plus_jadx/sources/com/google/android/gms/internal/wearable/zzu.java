package com.google.android.gms.internal.wearable;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzu extends zzcg implements zzdo {
    private static final zzu zzb;
    private int zzd;
    private double zzg;
    private float zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private long zzr;
    private byte zzs = 2;
    private zzbh zze = zzbh.zzb;
    private String zzf = "";
    private zzcn zzm = zzU();
    private zzcn zzn = zzU();
    private zzcn zzo = zzcg.zzU();
    private zzcm zzp = zzT();
    private zzcl zzq = zzS();

    static {
        zzu zzuVar = new zzu();
        zzb = zzuVar;
        zzcg.zzab(zzu.class, zzuVar);
    }

    private zzu() {
    }

    static /* synthetic */ void zzA(zzu zzuVar, Iterable iterable) {
        zzcm zzcmVar = zzuVar.zzp;
        if (!zzcmVar.zzc()) {
            int size = zzcmVar.size();
            zzuVar.zzp = zzcmVar.zzd(size == 0 ? 10 : size + size);
        }
        zzar.zzJ(iterable, zzuVar.zzp);
    }

    static /* synthetic */ void zzB(zzu zzuVar, Iterable iterable) {
        zzcl zzclVar = zzuVar.zzq;
        if (!zzclVar.zzc()) {
            int size = zzclVar.size();
            zzuVar.zzq = zzclVar.zzd(size == 0 ? 10 : size + size);
        }
        zzar.zzJ(iterable, zzuVar.zzq);
    }

    static /* synthetic */ void zzC(zzu zzuVar, long j) {
        zzuVar.zzd |= 256;
        zzuVar.zzr = j;
    }

    static /* synthetic */ void zzD(zzu zzuVar, double d) {
        zzuVar.zzd |= 4;
        zzuVar.zzg = d;
    }

    static /* synthetic */ void zzE(zzu zzuVar, float f) {
        zzuVar.zzd |= 8;
        zzuVar.zzh = f;
    }

    public static zzt zzh() {
        return (zzt) zzb.zzN();
    }

    public static zzu zzj() {
        return zzb;
    }

    static /* synthetic */ void zzr(zzu zzuVar, zzbh zzbhVar) {
        zzuVar.zzd |= 1;
        zzuVar.zze = zzbhVar;
    }

    static /* synthetic */ void zzs(zzu zzuVar, long j) {
        zzuVar.zzd |= 16;
        zzuVar.zzi = j;
    }

    static /* synthetic */ void zzt(zzu zzuVar, int i) {
        zzuVar.zzd |= 32;
        zzuVar.zzj = i;
    }

    static /* synthetic */ void zzu(zzu zzuVar, int i) {
        zzuVar.zzd |= 64;
        zzuVar.zzk = i;
    }

    static /* synthetic */ void zzv(zzu zzuVar, boolean z) {
        zzuVar.zzd |= 128;
        zzuVar.zzl = z;
    }

    static /* synthetic */ void zzw(zzu zzuVar, Iterable iterable) {
        zzcn zzcnVar = zzuVar.zzm;
        if (!zzcnVar.zzc()) {
            zzuVar.zzm = zzcg.zzV(zzcnVar);
        }
        zzar.zzJ(iterable, zzuVar.zzm);
    }

    static /* synthetic */ void zzx(zzu zzuVar, zzv zzvVar) {
        zzvVar.getClass();
        zzcn zzcnVar = zzuVar.zzn;
        if (!zzcnVar.zzc()) {
            zzuVar.zzn = zzcg.zzV(zzcnVar);
        }
        zzuVar.zzn.add(zzvVar);
    }

    static /* synthetic */ void zzy(zzu zzuVar, String str) {
        zzuVar.zzd |= 2;
        zzuVar.zzf = str;
    }

    static /* synthetic */ void zzz(zzu zzuVar, Iterable iterable) {
        zzcn zzcnVar = zzuVar.zzo;
        if (!zzcnVar.zzc()) {
            zzuVar.zzo = zzcg.zzV(zzcnVar);
        }
        zzar.zzJ(iterable, zzuVar.zzo);
    }

    public final boolean zzF() {
        return this.zzl;
    }

    public final double zza() {
        return this.zzg;
    }

    public final float zzb() {
        return this.zzh;
    }

    public final int zzc() {
        return this.zzn.size();
    }

    public final int zzd() {
        return this.zzk;
    }

    public final int zze() {
        return this.zzj;
    }

    public final long zzf() {
        return this.zzr;
    }

    public final long zzg() {
        return this.zzi;
    }

    public final zzbh zzk() {
        return this.zze;
    }

    public final String zzl() {
        return this.zzf;
    }

    public final List zzm() {
        return this.zzn;
    }

    public final List zzn() {
        return this.zzm;
    }

    public final List zzo() {
        return this.zzq;
    }

    public final List zzp() {
        return this.zzp;
    }

    public final List zzq() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.wearable.zzcg
    protected final Object zzG(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzs);
        }
        if (i2 == 2) {
            return zzY(zzb, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0005\u0002\u0001ည\u0000\u0002ဈ\u0001\u0003က\u0002\u0004ခ\u0003\u0005ဂ\u0004\u0006င\u0005\u0007ဏ\u0006\bဇ\u0007\tЛ\nЛ\u000b\u001a\f\u0014\rဂ\b\u000e\u0013", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzw.class, "zzn", zzv.class, "zzo", "zzp", "zzr", "zzq"});
        }
        if (i2 == 3) {
            return new zzu();
        }
        zzm zzmVar = null;
        if (i2 == 4) {
            return new zzt(zzmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzs = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
