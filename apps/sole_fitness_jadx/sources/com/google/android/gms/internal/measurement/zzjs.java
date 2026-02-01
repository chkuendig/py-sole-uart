package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzjs implements zzla {
    private static final zzjs zza = new zzjs();

    private zzjs() {
    }

    public static zzjs zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final zzkz zzb(Class<?> cls) {
        if (!zzjx.class.isAssignableFrom(cls)) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported message type: ".concat(strValueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzkz) zzjx.zzbw(cls.asSubclass(zzjx.class)).zzl(3, null, null);
        } catch (Exception e) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(strValueOf2.length() != 0 ? "Unable to get message info for ".concat(strValueOf2) : new String("Unable to get message info for "), e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final boolean zzc(Class<?> cls) {
        return zzjx.class.isAssignableFrom(cls);
    }
}
