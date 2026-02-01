package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public final class zzuw extends zza implements zzuy {
    zzuw(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzuy
    public final zzuv zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzuv zzuvVar;
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, iObjectWrapper);
        Parcel parcelZzb = zzb(1, parcelZza);
        IBinder strongBinder = parcelZzb.readStrongBinder();
        if (strongBinder == null) {
            zzuvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizer");
            zzuvVar = iInterfaceQueryLocalInterface instanceof zzuv ? (zzuv) iInterfaceQueryLocalInterface : new zzuv(strongBinder);
        }
        parcelZzb.recycle();
        return zzuvVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzuy
    public final zzuv zze(IObjectWrapper iObjectWrapper, zzvh zzvhVar) throws RemoteException {
        zzuv zzuvVar;
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, iObjectWrapper);
        zzc.zza(parcelZza, zzvhVar);
        Parcel parcelZzb = zzb(2, parcelZza);
        IBinder strongBinder = parcelZzb.readStrongBinder();
        if (strongBinder == null) {
            zzuvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizer");
            zzuvVar = iInterfaceQueryLocalInterface instanceof zzuv ? (zzuv) iInterfaceQueryLocalInterface : new zzuv(strongBinder);
        }
        parcelZzb.recycle();
        return zzuvVar;
    }
}
