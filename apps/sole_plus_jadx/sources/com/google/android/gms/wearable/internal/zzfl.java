package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public abstract class zzfl extends com.google.android.gms.internal.wearable.zzb implements zzfm {
    public zzfl() {
        super("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
    }

    @Override // com.google.android.gms.internal.wearable.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        int i3 = parcel.readInt();
        int i4 = parcel.readInt();
        com.google.android.gms.internal.wearable.zzc.zzb(parcel);
        zzb(i3, i4);
        parcel2.writeNoException();
        return true;
    }
}
