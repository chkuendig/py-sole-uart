package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzgk extends zzjx<zzgk, zzgj> implements zzld {
    private static final zzgk zza;
    private zzke<zzgm> zze = zzbA();

    static {
        zzgk zzgkVar = new zzgk();
        zza = zzgkVar;
        zzjx.zzbG(zzgk.class, zzgkVar);
    }

    private zzgk() {
    }

    public static zzgk zzc() {
        return zza;
    }

    public final int zza() {
        return this.zze.size();
    }

    public final List<zzgm> zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzjx
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbF(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzgm.class});
        }
        if (i2 == 3) {
            return new zzgk();
        }
        zzgi zzgiVar = null;
        if (i2 == 4) {
            return new zzgj(zzgiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
