package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzli {
    private static final zzlh zza;
    private static final zzlh zzb;

    static {
        zzlh zzlhVar;
        try {
            zzlhVar = (zzlh) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzlhVar = null;
        }
        zza = zzlhVar;
        zzb = new zzlh();
    }

    static zzlh zza() {
        return zza;
    }

    static zzlh zzb() {
        return zzb;
    }
}
