package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzv extends zzcg implements zzdo {
    private static final zzv zzb;
    private int zzd;
    private zzu zzf;
    private byte zzg = 2;
    private int zze = 1;

    static {
        zzv zzvVar = new zzv();
        zzb = zzvVar;
        zzcg.zzab(zzv.class, zzvVar);
    }

    private zzv() {
    }

    public static zzp zza() {
        return (zzp) zzb.zzN();
    }

    public static zzv zzd() {
        return zzb;
    }

    static /* synthetic */ void zze(zzv zzvVar, zzu zzuVar) {
        zzuVar.getClass();
        zzvVar.zzf = zzuVar;
        zzvVar.zzd |= 2;
    }

    static /* synthetic */ void zzg(zzv zzvVar, int i) {
        zzvVar.zze = i;
        zzvVar.zzd |= 1;
    }

    public final zzu zzb() {
        zzu zzuVar = this.zzf;
        return zzuVar == null ? zzu.zzj() : zzuVar;
    }

    public final int zzf() {
        int iZza = zzs.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.wearable.zzcg
    protected final Object zzG(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzY(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᴌ\u0000\u0002ᐉ\u0001", new Object[]{"zzd", "zze", zzr.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzv();
        }
        zzm zzmVar = null;
        if (i2 == 4) {
            return new zzp(zzmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
