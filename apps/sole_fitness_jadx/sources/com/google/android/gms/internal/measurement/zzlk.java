package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzlk {
    private static final zzlk zza = new zzlk();
    private final ConcurrentMap<Class<?>, zzln<?>> zzc = new ConcurrentHashMap();
    private final zzlo zzb = new zzku();

    private zzlk() {
    }

    public static zzlk zza() {
        return zza;
    }

    public final <T> zzln<T> zzb(Class<T> cls) {
        zzkf.zzf(cls, "messageType");
        zzln<T> zzlnVarZza = (zzln) this.zzc.get(cls);
        if (zzlnVarZza == null) {
            zzlnVarZza = this.zzb.zza(cls);
            zzkf.zzf(cls, "messageType");
            zzkf.zzf(zzlnVarZza, "schema");
            zzln<T> zzlnVar = (zzln) this.zzc.putIfAbsent(cls, zzlnVarZza);
            if (zzlnVar != null) {
                return zzlnVar;
            }
        }
        return zzlnVarZza;
    }
}
