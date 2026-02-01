package com.google.android.gms.internal.mlkit_vision_text_common;

import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public final class zzcq extends zzcr {
    public static int zza(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }
}
