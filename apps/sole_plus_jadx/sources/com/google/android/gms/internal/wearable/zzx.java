package com.google.android.gms.internal.wearable;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzx extends zzcg implements zzdo {
    private static final zzx zzb;
    private byte zze = 2;
    private zzcn zzd = zzU();

    static {
        zzx zzxVar = new zzx();
        zzb = zzxVar;
        zzcg.zzab(zzx.class, zzxVar);
    }

    private zzx() {
    }

    public static zzn zza() {
        return (zzn) zzb.zzN();
    }

    public static zzx zzc(byte[] bArr) throws zzcq {
        return (zzx) zzcg.zzQ(zzb, bArr);
    }

    public static zzx zzd(byte[] bArr, zzbu zzbuVar) throws zzcq {
        return (zzx) zzcg.zzR(zzb, bArr, zzbuVar);
    }

    static /* synthetic */ void zzf(zzx zzxVar, Iterable iterable) {
        zzcn zzcnVar = zzxVar.zzd;
        if (!zzcnVar.zzc()) {
            zzxVar.zzd = zzcg.zzV(zzcnVar);
        }
        zzar.zzJ(iterable, zzxVar.zzd);
    }

    public final List zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.wearable.zzcg
    protected final Object zzG(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        if (i2 == 2) {
            return zzY(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzd", zzw.class});
        }
        if (i2 == 3) {
            return new zzx();
        }
        zzm zzmVar = null;
        if (i2 == 4) {
            return new zzn(zzmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
