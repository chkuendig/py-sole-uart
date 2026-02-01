package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzfi extends zzjx<zzfi, zzfh> implements zzld {
    private static final zzfi zza;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";

    static {
        zzfi zzfiVar = new zzfi();
        zza = zzfiVar;
        zzjx.zzbG(zzfi.class, zzfiVar);
    }

    private zzfi() {
    }

    @Override // com.google.android.gms.internal.measurement.zzjx
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbF(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzfi();
        }
        zzff zzffVar = null;
        if (i2 == 4) {
            return new zzfh(zzffVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
