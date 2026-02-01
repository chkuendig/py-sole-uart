package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzky {
    private static final zzkx zza;
    private static final zzkx zzb;

    static {
        zzkx zzkxVar;
        try {
            zzkxVar = (zzkx) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzkxVar = null;
        }
        zza = zzkxVar;
        zzb = new zzkx();
    }

    static zzkx zza() {
        return zza;
    }

    static zzkx zzb() {
        return zzb;
    }
}
