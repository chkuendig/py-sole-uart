package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public final class zzcb {
    @CheckForNull
    static Object zza(Map map, @CheckForNull Object obj) {
        map.getClass();
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static boolean zzb(Map map, @CheckForNull Object obj) {
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
