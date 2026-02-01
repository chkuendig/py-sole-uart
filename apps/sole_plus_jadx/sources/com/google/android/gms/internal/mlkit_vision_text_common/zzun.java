package com.google.android.gms.internal.mlkit_vision_text_common;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public final class zzun {
    private static zzum zza;

    public static synchronized zzuc zza(zztu zztuVar) {
        if (zza == null) {
            zza = new zzum(null);
        }
        return (zzuc) zza.get(zztuVar);
    }

    public static synchronized zzuc zzb(String str) {
        return zza(zztu.zzd(str).zzd());
    }
}
