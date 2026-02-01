package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzgm extends zzjx<zzgm, zzgl> implements zzld {
    private static final zzgm zza;
    private int zze;
    private String zzf = "";
    private zzke<zzgt> zzg = zzbA();

    static {
        zzgm zzgmVar = new zzgm();
        zza = zzgmVar;
        zzjx.zzbG(zzgm.class, zzgmVar);
    }

    private zzgm() {
    }

    public final String zzb() {
        return this.zzf;
    }

    public final List<zzgt> zzc() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.zzjx
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbF(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", zzgt.class});
        }
        if (i2 == 3) {
            return new zzgm();
        }
        zzgi zzgiVar = null;
        if (i2 == 4) {
            return new zzgl(zzgiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
