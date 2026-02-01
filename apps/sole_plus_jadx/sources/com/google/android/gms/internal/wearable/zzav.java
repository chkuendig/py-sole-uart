package com.google.android.gms.internal.wearable;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzav {
    static int zza(byte[] bArr, int i, zzau zzauVar) throws zzcq {
        int iZzh = zzh(bArr, i, zzauVar);
        int i2 = zzauVar.zza;
        if (i2 < 0) {
            throw zzcq.zzd();
        }
        if (i2 > bArr.length - iZzh) {
            throw zzcq.zzg();
        }
        if (i2 == 0) {
            zzauVar.zzc = zzbh.zzb;
            return iZzh;
        }
        zzauVar.zzc = zzbh.zzm(bArr, iZzh, i2);
        return iZzh + i2;
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzc(zzdy zzdyVar, byte[] bArr, int i, int i2, int i3, zzau zzauVar) throws IOException {
        Object objZze = zzdyVar.zze();
        int iZzl = zzl(objZze, zzdyVar, bArr, i, i2, i3, zzauVar);
        zzdyVar.zzf(objZze);
        zzauVar.zzc = objZze;
        return iZzl;
    }

    static int zzd(zzdy zzdyVar, byte[] bArr, int i, int i2, zzau zzauVar) throws IOException {
        Object objZze = zzdyVar.zze();
        int iZzm = zzm(objZze, zzdyVar, bArr, i, i2, zzauVar);
        zzdyVar.zzf(objZze);
        zzauVar.zzc = objZze;
        return iZzm;
    }

    static int zze(zzdy zzdyVar, int i, byte[] bArr, int i2, int i3, zzcn zzcnVar, zzau zzauVar) throws IOException {
        int iZzd = zzd(zzdyVar, bArr, i2, i3, zzauVar);
        zzcnVar.add(zzauVar.zzc);
        while (iZzd < i3) {
            int iZzh = zzh(bArr, iZzd, zzauVar);
            if (i != zzauVar.zza) {
                break;
            }
            iZzd = zzd(zzdyVar, bArr, iZzh, i3, zzauVar);
            zzcnVar.add(zzauVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i, zzcn zzcnVar, zzau zzauVar) throws IOException {
        zzch zzchVar = (zzch) zzcnVar;
        int iZzh = zzh(bArr, i, zzauVar);
        int i2 = zzauVar.zza + iZzh;
        while (iZzh < i2) {
            iZzh = zzh(bArr, iZzh, zzauVar);
            zzchVar.zzf(zzauVar.zza);
        }
        if (iZzh == i2) {
            return iZzh;
        }
        throw zzcq.zzg();
    }

    static int zzg(int i, byte[] bArr, int i2, int i3, zzeq zzeqVar, zzau zzauVar) throws zzcq {
        if ((i >>> 3) == 0) {
            throw zzcq.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzk = zzk(bArr, i2, zzauVar);
            zzeqVar.zzj(i, Long.valueOf(zzauVar.zzb));
            return iZzk;
        }
        if (i4 == 1) {
            zzeqVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzh = zzh(bArr, i2, zzauVar);
            int i5 = zzauVar.zza;
            if (i5 < 0) {
                throw zzcq.zzd();
            }
            if (i5 > bArr.length - iZzh) {
                throw zzcq.zzg();
            }
            if (i5 == 0) {
                zzeqVar.zzj(i, zzbh.zzb);
            } else {
                zzeqVar.zzj(i, zzbh.zzm(bArr, iZzh, i5));
            }
            return iZzh + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzcq.zzb();
            }
            zzeqVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzeq zzeqVarZzf = zzeq.zzf();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzh2 = zzh(bArr, i2, zzauVar);
            int i8 = zzauVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = iZzh2;
                break;
            }
            int iZzg = zzg(i7, bArr, iZzh2, i3, zzeqVarZzf, zzauVar);
            i7 = i8;
            i2 = iZzg;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzcq.zze();
        }
        zzeqVar.zzj(i, zzeqVarZzf);
        return i2;
    }

    static int zzh(byte[] bArr, int i, zzau zzauVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzauVar);
        }
        zzauVar.zza = b;
        return i2;
    }

    static int zzi(int i, byte[] bArr, int i2, zzau zzauVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzauVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzauVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzauVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzauVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzauVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzj(int i, byte[] bArr, int i2, int i3, zzcn zzcnVar, zzau zzauVar) {
        zzch zzchVar = (zzch) zzcnVar;
        int iZzh = zzh(bArr, i2, zzauVar);
        zzchVar.zzf(zzauVar.zza);
        while (iZzh < i3) {
            int iZzh2 = zzh(bArr, iZzh, zzauVar);
            if (i != zzauVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzauVar);
            zzchVar.zzf(zzauVar.zza);
        }
        return iZzh;
    }

    static int zzk(byte[] bArr, int i, zzau zzauVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzauVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & 127) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & 127) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        zzauVar.zzb = j2;
        return i3;
    }

    static int zzl(Object obj, zzdy zzdyVar, byte[] bArr, int i, int i2, int i3, zzau zzauVar) throws IOException {
        int iZzc = ((zzdq) zzdyVar).zzc(obj, bArr, i, i2, i3, zzauVar);
        zzauVar.zzc = obj;
        return iZzc;
    }

    static int zzm(Object obj, zzdy zzdyVar, byte[] bArr, int i, int i2, zzau zzauVar) throws IOException {
        int iZzi = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzi = zzi(i3, bArr, iZzi, zzauVar);
            i3 = zzauVar.zza;
        }
        int i4 = iZzi;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzcq.zzg();
        }
        int i5 = i3 + i4;
        zzdyVar.zzh(obj, bArr, i4, i5, zzauVar);
        zzauVar.zzc = obj;
        return i5;
    }

    static long zzn(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }
}
