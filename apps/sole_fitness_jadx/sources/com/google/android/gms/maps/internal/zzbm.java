package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* compiled from: com.google.android.gms:play-services-maps@@18.0.0 */
/* loaded from: classes2.dex */
public abstract class zzbm extends com.google.android.gms.internal.maps.zzb implements zzbn {
    public zzbm() {
        super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzb((StreetViewPanoramaOrientation) com.google.android.gms.internal.maps.zzc.zza(parcel, StreetViewPanoramaOrientation.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
