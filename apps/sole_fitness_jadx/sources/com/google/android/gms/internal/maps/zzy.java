package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@18.0.0 */
/* loaded from: classes.dex */
public final class zzy extends zza implements zzaa {
    zzy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolygonDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzA(float f) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f);
        zzc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final boolean zzB(zzaa zzaaVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzf(parcelZza, zzaaVar);
        Parcel parcelZzH = zzH(19, parcelZza);
        boolean zZzg = zzc.zzg(parcelZzH);
        parcelZzH.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final boolean zzC() throws RemoteException {
        Parcel parcelZzH = zzH(22, zza());
        boolean zZzg = zzc.zzg(parcelZzH);
        parcelZzH.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final boolean zzD() throws RemoteException {
        Parcel parcelZzH = zzH(18, zza());
        boolean zZzg = zzc.zzg(parcelZzH);
        parcelZzH.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final boolean zzE() throws RemoteException {
        Parcel parcelZzH = zzH(16, zza());
        boolean zZzg = zzc.zzg(parcelZzH);
        parcelZzH.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final float zzd() throws RemoteException {
        Parcel parcelZzH = zzH(8, zza());
        float f = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final float zze() throws RemoteException {
        Parcel parcelZzH = zzH(14, zza());
        float f = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final int zzf() throws RemoteException {
        Parcel parcelZzH = zzH(12, zza());
        int i = parcelZzH.readInt();
        parcelZzH.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final int zzg() throws RemoteException {
        Parcel parcelZzH = zzH(10, zza());
        int i = parcelZzH.readInt();
        parcelZzH.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final int zzh() throws RemoteException {
        Parcel parcelZzH = zzH(24, zza());
        int i = parcelZzH.readInt();
        parcelZzH.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final int zzi() throws RemoteException {
        Parcel parcelZzH = zzH(20, zza());
        int i = parcelZzH.readInt();
        parcelZzH.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final IObjectWrapper zzj() throws RemoteException {
        Parcel parcelZzH = zzH(28, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzH.readStrongBinder());
        parcelZzH.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final String zzk() throws RemoteException {
        Parcel parcelZzH = zzH(2, zza());
        String string = parcelZzH.readString();
        parcelZzH.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final List zzl() throws RemoteException {
        Parcel parcelZzH = zzH(6, zza());
        ArrayList arrayListZzb = zzc.zzb(parcelZzH);
        parcelZzH.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final List<LatLng> zzm() throws RemoteException {
        Parcel parcelZzH = zzH(4, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzH.createTypedArrayList(LatLng.CREATOR);
        parcelZzH.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final List<PatternItem> zzn() throws RemoteException {
        Parcel parcelZzH = zzH(26, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzH.createTypedArrayList(PatternItem.CREATOR);
        parcelZzH.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzo() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzp(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, z);
        zzc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzq(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzr(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, z);
        zzc(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzs(List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeList(list);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzt(List<LatLng> list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzu(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzv(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzw(List<PatternItem> list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzx(float f) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzf(parcelZza, iObjectWrapper);
        zzc(27, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzaa
    public final void zzz(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, z);
        zzc(15, parcelZza);
    }
}
