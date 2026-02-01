package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.MessageOptions;
import com.google.android.gms.wearable.PutDataRequest;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzft extends com.google.android.gms.internal.wearable.zza implements IInterface {
    zzft(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wearable.internal.IWearableService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzA(zzfp zzfpVar, String str, String str2, byte[] bArr, MessageOptions messageOptions) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeByteArray(bArr);
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, messageOptions);
        zzP(59, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzB(zzfp zzfpVar, String str, String str2, byte[] bArr) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeByteArray(bArr);
        zzP(58, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzC(zzfp zzfpVar, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeString(str);
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, parcelFileDescriptor);
        zzP(38, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzd(zzfp zzfpVar, zzf zzfVar) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, zzfVar);
        zzP(16, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zze(zzfp zzfpVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeString(str);
        zzP(46, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzf(zzfp zzfpVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeString(str);
        zzP(32, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzg(zzfp zzfpVar, String str, int i) throws RemoteException {
        Parcel parcelZza = zza();
        int i2 = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        zzP(33, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzh(zzfp zzfpVar, Uri uri, int i) throws RemoteException {
        Parcel parcelZza = zza();
        int i2 = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, uri);
        parcelZza.writeInt(i);
        zzP(41, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzi(zzfp zzfpVar, int i) throws RemoteException {
        Parcel parcelZza = zza();
        int i2 = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeInt(i);
        zzP(43, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzj(zzfp zzfpVar, String str, int i) throws RemoteException {
        Parcel parcelZza = zza();
        int i2 = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        zzP(42, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzk(zzfp zzfpVar, zzfm zzfmVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeStrongBinder(zzfmVar);
        parcelZza.writeString(str);
        zzP(34, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzl(zzfp zzfpVar, zzfm zzfmVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeStrongBinder(zzfmVar);
        parcelZza.writeString(str);
        zzP(35, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzm(zzfp zzfpVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeString(str);
        zzP(63, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzn(zzfp zzfpVar) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        zzP(15, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzo(zzfp zzfpVar, Uri uri) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, uri);
        zzP(7, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzp(zzfp zzfpVar) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        zzP(8, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzq(zzfp zzfpVar, Uri uri, int i) throws RemoteException {
        Parcel parcelZza = zza();
        int i2 = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, uri);
        parcelZza.writeInt(i);
        zzP(40, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzr(zzfp zzfpVar, Asset asset) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, asset);
        zzP(13, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzs(zzfp zzfpVar) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        zzP(14, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzt(zzfp zzfpVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeString(str);
        zzP(67, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzu(zzfp zzfpVar, String str, String str2) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzP(31, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzv(zzfp zzfpVar, PutDataRequest putDataRequest) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, putDataRequest);
        zzP(6, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzw(zzfp zzfpVar, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeString(str);
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, parcelFileDescriptor);
        parcelZza.writeLong(j);
        parcelZza.writeLong(j2);
        zzP(39, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzx(zzfp zzfpVar, zzhq zzhqVar) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        com.google.android.gms.internal.wearable.zzc.zzc(parcelZza, zzhqVar);
        zzP(17, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzy(zzfp zzfpVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeString(str);
        zzP(47, parcelZza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzz(zzfp zzfpVar, String str, String str2, byte[] bArr) throws RemoteException {
        Parcel parcelZza = zza();
        int i = com.google.android.gms.internal.wearable.zzc.zza;
        parcelZza.writeStrongBinder(zzfpVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeByteArray(bArr);
        zzP(12, parcelZza);
    }
}
