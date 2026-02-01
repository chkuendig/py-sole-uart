package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzfl implements com.google.android.gms.internal.measurement.zzo {
    final /* synthetic */ String zza;
    final /* synthetic */ zzfm zzb;

    zzfl(zzfm zzfmVar, String str) {
        this.zzb = zzfmVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map = (Map) this.zzb.zze.get(this.zza);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
