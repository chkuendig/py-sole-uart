package com.google.android.gms.internal.playcore_age_signals;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
public class zza implements IInterface {
    private final IBinder zza;
    private final String zzb;

    protected zza(IBinder iBinder, String str) {
        this.zza = iBinder;
        this.zzb = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zza;
    }

    protected final Parcel zza() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.zzb);
        return parcelObtain;
    }

    protected final void zzb(int i, Parcel parcel) throws RemoteException {
        try {
            this.zza.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
