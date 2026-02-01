package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@18.0.0 */
/* loaded from: classes.dex */
public final class zzp extends zza implements zzr {
    zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final int zzd() throws RemoteException {
        Parcel parcelZzH = zzH(1, zza());
        int i = parcelZzH.readInt();
        parcelZzH.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final int zze() throws RemoteException {
        Parcel parcelZzH = zzH(2, zza());
        int i = parcelZzH.readInt();
        parcelZzH.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final int zzf() throws RemoteException {
        Parcel parcelZzH = zzH(6, zza());
        int i = parcelZzH.readInt();
        parcelZzH.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final List<IBinder> zzg() throws RemoteException {
        Parcel parcelZzH = zzH(3, zza());
        ArrayList<IBinder> arrayListCreateBinderArrayList = parcelZzH.createBinderArrayList();
        parcelZzH.recycle();
        return arrayListCreateBinderArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final boolean zzh(zzr zzrVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzf(parcelZza, zzrVar);
        Parcel parcelZzH = zzH(5, parcelZza);
        boolean zZzg = zzc.zzg(parcelZzH);
        parcelZzH.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.maps.zzr
    public final boolean zzi() throws RemoteException {
        Parcel parcelZzH = zzH(4, zza());
        boolean zZzg = zzc.zzg(parcelZzH);
        parcelZzH.recycle();
        return zZzg;
    }
}
