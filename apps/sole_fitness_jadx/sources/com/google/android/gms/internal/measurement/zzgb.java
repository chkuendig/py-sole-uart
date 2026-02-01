package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzgb extends zzjx<zzgb, zzfz> implements zzld {
    private static final zzgb zza;
    private int zze;
    private int zzf = 1;
    private zzke<zzfq> zzg = zzbA();

    static {
        zzgb zzgbVar = new zzgb();
        zza = zzgbVar;
        zzjx.zzbG(zzgb.class, zzgbVar);
    }

    private zzgb() {
    }

    public static zzfz zza() {
        return zza.zzbu();
    }

    static /* synthetic */ void zzc(zzgb zzgbVar, zzfq zzfqVar) {
        zzfqVar.getClass();
        zzke<zzfq> zzkeVar = zzgbVar.zzg;
        if (!zzkeVar.zzc()) {
            zzgbVar.zzg = zzjx.zzbB(zzkeVar);
        }
        zzgbVar.zzg.add(zzfqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzjx
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbF(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zze", "zzf", zzga.zza, "zzg", zzfq.class});
        }
        if (i2 == 3) {
            return new zzgb();
        }
        zzff zzffVar = null;
        if (i2 == 4) {
            return new zzfz(zzffVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
