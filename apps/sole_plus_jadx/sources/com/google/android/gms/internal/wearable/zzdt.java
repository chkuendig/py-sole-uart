package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzdt {
    private static final zzds zza;
    private static final zzds zzb;

    static {
        zzds zzdsVar;
        try {
            zzdsVar = (zzds) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzdsVar = null;
        }
        zza = zzdsVar;
        zzb = new zzds();
    }

    static zzds zza() {
        return zza;
    }

    static zzds zzb() {
        return zzb;
    }
}
