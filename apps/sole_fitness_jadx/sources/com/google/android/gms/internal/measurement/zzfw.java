package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzfw extends zzjx<zzfw, zzfv> implements zzld {
    private static final zzfw zza;
    private zzke<zzfy> zze = zzbA();

    static {
        zzfw zzfwVar = new zzfw();
        zza = zzfwVar;
        zzjx.zzbG(zzfw.class, zzfwVar);
    }

    private zzfw() {
    }

    public static zzfv zza() {
        return zza.zzbu();
    }

    static /* synthetic */ void zze(zzfw zzfwVar, zzfy zzfyVar) {
        zzfyVar.getClass();
        zzke<zzfy> zzkeVar = zzfwVar.zze;
        if (!zzkeVar.zzc()) {
            zzfwVar.zze = zzjx.zzbB(zzkeVar);
        }
        zzfwVar.zze.add(zzfyVar);
    }

    public final zzfy zzc(int i) {
        return this.zze.get(0);
    }

    public final List<zzfy> zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzjx
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbF(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzfy.class});
        }
        if (i2 == 3) {
            return new zzfw();
        }
        zzff zzffVar = null;
        if (i2 == 4) {
            return new zzfv(zzffVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
