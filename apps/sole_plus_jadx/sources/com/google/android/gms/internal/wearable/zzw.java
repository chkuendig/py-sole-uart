package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzw extends zzcg implements zzdo {
    private static final zzw zzb;
    private int zzd;
    private zzv zzf;
    private byte zzg = 2;
    private String zze = "";

    static {
        zzw zzwVar = new zzw();
        zzb = zzwVar;
        zzcg.zzab(zzw.class, zzwVar);
    }

    private zzw() {
    }

    public static zzo zza() {
        return (zzo) zzb.zzN();
    }

    static /* synthetic */ void zze(zzw zzwVar, String str) {
        str.getClass();
        zzwVar.zzd |= 1;
        zzwVar.zze = str;
    }

    static /* synthetic */ void zzf(zzw zzwVar, zzv zzvVar) {
        zzvVar.getClass();
        zzwVar.zzf = zzvVar;
        zzwVar.zzd |= 2;
    }

    public final zzv zzb() {
        zzv zzvVar = this.zzf;
        return zzvVar == null ? zzv.zzd() : zzvVar;
    }

    public final String zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.wearable.zzcg
    protected final Object zzG(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzY(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzw();
        }
        zzm zzmVar = null;
        if (i2 == 4) {
            return new zzo(zzmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
