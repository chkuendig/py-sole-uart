package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public abstract class zzut extends zzb implements zzuu {
    public static zzuu zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ICommonTextRecognizerCreator");
        return iInterfaceQueryLocalInterface instanceof zzuu ? (zzuu) iInterfaceQueryLocalInterface : new zzus(iBinder);
    }
}
