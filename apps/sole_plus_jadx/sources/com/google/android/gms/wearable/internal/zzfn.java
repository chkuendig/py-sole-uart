package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzfn extends com.google.android.gms.internal.wearable.zza implements IInterface {
    zzfn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wearable.internal.IRpcResponseCallback");
    }

    public final void zzd(boolean z, byte[] bArr) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeInt(z ? 1 : 0);
        parcelZza.writeByteArray(bArr);
        zzQ(1, parcelZza);
    }
}
