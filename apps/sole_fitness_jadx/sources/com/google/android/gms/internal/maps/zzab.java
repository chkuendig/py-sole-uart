package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@18.0.0 */
/* loaded from: classes.dex */
public final class zzab extends zza implements zzad {
    zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolylineDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzA(float f) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzB(zzad zzadVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzf(parcelZza, zzadVar);
        Parcel parcelZzH = zzH(15, parcelZza);
        boolean zZzg = zzc.zzg(parcelZzH);
        parcelZzH.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzC() throws RemoteException {
        Parcel parcelZzH = zzH(18, zza());
        boolean zZzg = zzc.zzg(parcelZzH);
        parcelZzH.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzD() throws RemoteException {
        Parcel parcelZzH = zzH(14, zza());
        boolean zZzg = zzc.zzg(parcelZzH);
        parcelZzH.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final boolean zzE() throws RemoteException {
        Parcel parcelZzH = zzH(12, zza());
        boolean zZzg = zzc.zzg(parcelZzH);
        parcelZzH.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final float zzd() throws RemoteException {
        Parcel parcelZzH = zzH(6, zza());
        float f = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final float zze() throws RemoteException {
        Parcel parcelZzH = zzH(10, zza());
        float f = parcelZzH.readFloat();
        parcelZzH.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final int zzf() throws RemoteException {
        Parcel parcelZzH = zzH(8, zza());
        int i = parcelZzH.readInt();
        parcelZzH.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final int zzg() throws RemoteException {
        Parcel parcelZzH = zzH(24, zza());
        int i = parcelZzH.readInt();
        parcelZzH.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final int zzh() throws RemoteException {
        Parcel parcelZzH = zzH(16, zza());
        int i = parcelZzH.readInt();
        parcelZzH.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final IObjectWrapper zzi() throws RemoteException {
        Parcel parcelZzH = zzH(28, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzH.readStrongBinder());
        parcelZzH.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final Cap zzj() throws RemoteException {
        Parcel parcelZzH = zzH(22, zza());
        Cap cap = (Cap) zzc.zza(parcelZzH, Cap.CREATOR);
        parcelZzH.recycle();
        return cap;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final Cap zzk() throws RemoteException {
        Parcel parcelZzH = zzH(20, zza());
        Cap cap = (Cap) zzc.zza(parcelZzH, Cap.CREATOR);
        parcelZzH.recycle();
        return cap;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final String zzl() throws RemoteException {
        Parcel parcelZzH = zzH(2, zza());
        String string = parcelZzH.readString();
        parcelZzH.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final List<PatternItem> zzm() throws RemoteException {
        Parcel parcelZzH = zzH(26, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzH.createTypedArrayList(PatternItem.CREATOR);
        parcelZzH.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final List<LatLng> zzn() throws RemoteException {
        Parcel parcelZzH = zzH(4, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzH.createTypedArrayList(LatLng.CREATOR);
        parcelZzH.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzo() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzp(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, z);
        zzc(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzq(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzr(Cap cap) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, cap);
        zzc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzs(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, z);
        zzc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzt(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzu(List<PatternItem> list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzv(List<LatLng> list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzw(Cap cap) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, cap);
        zzc(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzx(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzf(parcelZza, iObjectWrapper);
        zzc(27, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzy(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, z);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzad
    public final void zzz(float f) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f);
        zzc(5, parcelZza);
    }
}
