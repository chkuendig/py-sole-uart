package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public abstract class zzfo extends com.google.android.gms.internal.wearable.zzb implements zzfp {
    public zzfo() {
        super("com.google.android.gms.wearable.internal.IWearableCallbacks");
    }

    @Override // com.google.android.gms.internal.wearable.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                zzep zzepVar = (zzep) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzep.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzu(zzepVar);
                break;
            case 3:
                zzho zzhoVar = (zzho) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzho.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzI(zzhoVar);
                break;
            case 4:
                zzev zzevVar = (zzev) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzev.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzx(zzevVar);
                break;
            case 5:
                DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.wearable.zzc.zza(parcel, DataHolder.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzi(dataHolder);
                break;
            case 6:
                zzdr zzdrVar = (zzdr) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzdr.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzj(zzdrVar);
                break;
            case 7:
                zzhy zzhyVar = (zzhy) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzhy.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzK(zzhyVar);
                break;
            case 8:
                zzfb zzfbVar = (zzfb) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfb.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzA(zzfbVar);
                break;
            case 9:
                zzfd zzfdVar = (zzfd) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfd.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzB(zzfdVar);
                break;
            case 10:
                zzet zzetVar = (zzet) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzet.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzw(zzetVar);
                break;
            case 11:
                Status status = (Status) com.google.android.gms.internal.wearable.zzc.zza(parcel, Status.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzM(status);
                break;
            case 12:
                zzic zzicVar = (zzic) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzic.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzF(zzicVar);
                break;
            case 13:
                zzer zzerVar = (zzer) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzer.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzv(zzerVar);
                break;
            case 14:
                zzhi zzhiVar = (zzhi) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzhi.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzG(zzhiVar);
                break;
            case 15:
                zzcg zzcgVar = (zzcg) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzcg.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzg(zzcgVar);
                break;
            case 16:
                zzcg zzcgVar2 = (zzcg) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzcg.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzh(zzcgVar2);
                break;
            case 17:
                zzed zzedVar = (zzed) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzed.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzo(zzedVar);
                break;
            case 18:
                zzef zzefVar = (zzef) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzef.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzp(zzefVar);
                break;
            case 19:
                zzca zzcaVar = (zzca) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzca.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zze(zzcaVar);
                break;
            case 20:
                zzcc zzccVar = (zzcc) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzcc.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzf(zzccVar);
                break;
            case 21:
            case 24:
            case 25:
            case 31:
            case 32:
            case 33:
            case 44:
            case 45:
            default:
                return false;
            case 22:
                zzeb zzebVar = (zzeb) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzeb.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzn(zzebVar);
                break;
            case 23:
                zzdv zzdvVar = (zzdv) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzdv.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzk(zzdvVar);
                break;
            case 26:
                zzh zzhVar = (zzh) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzh.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzb(zzhVar);
                break;
            case 27:
                zzhs zzhsVar = (zzhs) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzhs.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzJ(zzhsVar);
                break;
            case 28:
                zzei zzeiVar = (zzei) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzei.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzq(zzeiVar);
                break;
            case 29:
                zzem zzemVar = (zzem) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzem.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzs(zzemVar);
                break;
            case 30:
                zzek zzekVar = (zzek) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzek.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzr(zzekVar);
                break;
            case 34:
                zzhw zzhwVar = (zzhw) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzhw.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzL(zzhwVar);
                break;
            case 35:
                zzex zzexVar = (zzex) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzex.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzy(zzexVar);
                break;
            case 36:
                zzhm zzhmVar = (zzhm) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzhm.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzH(zzhmVar);
                break;
            case 37:
                zzen zzenVar = (zzen) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzen.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzt(zzenVar);
                break;
            case 38:
                zzcl zzclVar = (zzcl) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzcl.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzN(zzclVar);
                break;
            case 39:
                zzff zzffVar = (zzff) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzff.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzC(zzffVar);
                break;
            case 40:
                zzs zzsVar = (zzs) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzs.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzc(zzsVar);
                break;
            case 41:
                zzdx zzdxVar = (zzdx) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzdx.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzl(zzdxVar);
                break;
            case 42:
                zzdz zzdzVar = (zzdz) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzdz.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzm(zzdzVar);
                break;
            case 43:
                zzfj zzfjVar = (zzfj) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfj.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzE(zzfjVar);
                break;
            case 46:
                zzx zzxVar = (zzx) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzx.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzd(zzxVar);
                break;
            case 47:
                zzfh zzfhVar = (zzfh) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfh.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzD(zzfhVar);
                break;
            case 48:
                zzez zzezVar = (zzez) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzez.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzb(parcel);
                zzz(zzezVar);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
