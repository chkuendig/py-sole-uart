package com.google.android.gms.internal.wearable;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzam extends zzan {
    static /* bridge */ /* synthetic */ int zza(float[] fArr, float f, int i, int i2) {
        while (i < i2) {
            if (fArr[i] == f) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static List zzb(float... fArr) {
        int length = fArr.length;
        return length == 0 ? Collections.emptyList() : new zzal(fArr, 0, length);
    }
}
