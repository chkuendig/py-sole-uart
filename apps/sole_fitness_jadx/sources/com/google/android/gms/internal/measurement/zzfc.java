package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzfc extends zzjx<zzfc, zzfb> implements zzld {
    private static final zzfc zza;
    private int zze;
    private long zzf;
    private int zzh;
    private boolean zzm;
    private String zzg = "";
    private zzke<zzfe> zzi = zzbA();
    private zzke<zzfa> zzj = zzbA();
    private zzke<zzeh> zzk = zzbA();
    private String zzl = "";
    private zzke<zzgo> zzn = zzbA();

    static {
        zzfc zzfcVar = new zzfc();
        zza = zzfcVar;
        zzjx.zzbG(zzfc.class, zzfcVar);
    }

    private zzfc() {
    }

    public static zzfb zze() {
        return zza.zzbu();
    }

    public static zzfc zzg() {
        return zza;
    }

    static /* synthetic */ void zzm(zzfc zzfcVar, int i, zzfa zzfaVar) {
        zzfaVar.getClass();
        zzke<zzfa> zzkeVar = zzfcVar.zzj;
        if (!zzkeVar.zzc()) {
            zzfcVar.zzj = zzjx.zzbB(zzkeVar);
        }
        zzfcVar.zzj.set(i, zzfaVar);
    }

    public final int zza() {
        return this.zzn.size();
    }

    public final int zzb() {
        return this.zzj.size();
    }

    public final long zzc() {
        return this.zzf;
    }

    public final zzfa zzd(int i) {
        return this.zzj.get(i);
    }

    public final String zzh() {
        return this.zzg;
    }

    public final List<zzeh> zzi() {
        return this.zzk;
    }

    public final List<zzgo> zzj() {
        return this.zzn;
    }

    public final List<zzfe> zzk() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzjx
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbF(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzfe.class, "zzj", zzfa.class, "zzk", zzeh.class, "zzl", "zzm", "zzn", zzgo.class});
        }
        if (i2 == 3) {
            return new zzfc();
        }
        zzey zzeyVar = null;
        if (i2 == 4) {
            return new zzfb(zzeyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final boolean zzo() {
        return this.zzm;
    }

    public final boolean zzp() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzq() {
        return (this.zze & 1) != 0;
    }
}
