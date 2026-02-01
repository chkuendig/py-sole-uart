package com.google.android.gms.internal.wearable;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzdv {
    private static final zzdv zza = new zzdv();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzdz zzb = new zzdf();

    private zzdv() {
    }

    public static zzdv zza() {
        return zza;
    }

    public final zzdy zzb(Class cls) {
        zzco.zzc(cls, "messageType");
        zzdy zzdyVarZza = (zzdy) this.zzc.get(cls);
        if (zzdyVarZza == null) {
            zzdyVarZza = this.zzb.zza(cls);
            zzco.zzc(cls, "messageType");
            zzdy zzdyVar = (zzdy) this.zzc.putIfAbsent(cls, zzdyVarZza);
            if (zzdyVar != null) {
                return zzdyVar;
            }
        }
        return zzdyVarZza;
    }
}
