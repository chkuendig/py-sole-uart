package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public abstract class zzfr extends com.google.android.gms.internal.wearable.zzb implements zzfs {
    public zzfr() {
        super("com.google.android.gms.wearable.internal.IWearableListener");
    }

    @Override // com.google.android.gms.internal.wearable.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzfn zzfnVar;
        switch (i) {
            case 1:
                DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.wearable.zzc.zza(parcel, DataHolder.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zze(dataHolder);
                return true;
            case 2:
                zzgp zzgpVar = (zzgp) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzgp.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzg(zzgpVar);
                return true;
            case 3:
                zzhg zzhgVar = (zzhg) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzhg.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzj(zzhgVar);
                return true;
            case 4:
                zzhg zzhgVar2 = (zzhg) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzhg.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzk(zzhgVar2);
                return true;
            case 5:
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzhg.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzd(arrayListCreateTypedArrayList);
                return true;
            case 6:
                zzn zznVar = (zzn) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzn.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzi(zznVar);
                return true;
            case 7:
                zzbj zzbjVar = (zzbj) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzbj.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzb(zzbjVar);
                return true;
            case 8:
                zzas zzasVar = (zzas) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzas.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzc(zzasVar);
                return true;
            case 9:
                zzk zzkVar = (zzk) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzk.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzf(zzkVar);
                return true;
            case 10:
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zzgp zzgpVar2 = (zzgp) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzgp.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzfnVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IRpcResponseCallback");
                    zzfnVar = iInterfaceQueryLocalInterface instanceof zzfn ? (zzfn) iInterfaceQueryLocalInterface : new zzfn(strongBinder);
                }
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzm(zzgpVar2, zzfnVar);
                return true;
            case 14:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                return true;
            case 15:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                return true;
            case 16:
                zzhf zzhfVar = (zzhf) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzhf.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzh(zzhfVar);
                return true;
            case 17:
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                return true;
        }
    }
}
