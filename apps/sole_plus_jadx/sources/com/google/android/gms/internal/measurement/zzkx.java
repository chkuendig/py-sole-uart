package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import com.sun.jna.platform.win32.WinNT;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
/* loaded from: classes4.dex */
final class zzkx<T> implements zzll<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmg.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzkt zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzlb zzn;
    private final zzkd zzo;
    private final zzmf<?, ?> zzp;
    private final zziz<?> zzq;
    private final zzkm zzr;

    private static <T> double zza(T t, long j) {
        return ((Double) zzmg.zze(t, j)).doubleValue();
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> float zzb(T t, long j) {
        return ((Float) zzmg.zze(t, j)).floatValue();
    }

    private static int zza(byte[] bArr, int i, int i2, zzmn zzmnVar, Class<?> cls, zzhv zzhvVar) throws IOException {
        switch (zzkw.zza[zzmnVar.ordinal()]) {
            case 1:
                int iZzd = zzhw.zzd(bArr, i, zzhvVar);
                zzhvVar.zzc = Boolean.valueOf(zzhvVar.zzb != 0);
                return iZzd;
            case 2:
                return zzhw.zza(bArr, i, zzhvVar);
            case 3:
                zzhvVar.zzc = Double.valueOf(zzhw.zza(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzhvVar.zzc = Integer.valueOf(zzhw.zzc(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzhvVar.zzc = Long.valueOf(zzhw.zzd(bArr, i));
                return i + 8;
            case 8:
                zzhvVar.zzc = Float.valueOf(zzhw.zzb(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZzc = zzhw.zzc(bArr, i, zzhvVar);
                zzhvVar.zzc = Integer.valueOf(zzhvVar.zza);
                return iZzc;
            case 12:
            case 13:
                int iZzd2 = zzhw.zzd(bArr, i, zzhvVar);
                zzhvVar.zzc = Long.valueOf(zzhvVar.zzb);
                return iZzd2;
            case 14:
                return zzhw.zza(zzlh.zza().zza((Class) cls), bArr, i, i2, zzhvVar);
            case 15:
                int iZzc2 = zzhw.zzc(bArr, i, zzhvVar);
                zzhvVar.zzc = Integer.valueOf(zzio.zze(zzhvVar.zza));
                return iZzc2;
            case 16:
                int iZzd3 = zzhw.zzd(bArr, i, zzhvVar);
                zzhvVar.zzc = Long.valueOf(zzio.zza(zzhvVar.zzb));
                return iZzd3;
            case 17:
                return zzhw.zzb(bArr, i, zzhvVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v19 */
    @Override // com.google.android.gms.internal.measurement.zzll
    public final int zza(T t) {
        int i;
        int i2;
        int i3;
        boolean z;
        int iZza;
        int iZzb;
        int iZzd;
        int iZzd2;
        int iZzi;
        int iZzj;
        Unsafe unsafe = zzb;
        ?? r9 = 0;
        int i4 = WinNT.NLS_VALID_LOCALE_MASK;
        int i5 = 0;
        int i6 = 0;
        int iZzh = 0;
        int i7 = 1048575;
        while (i6 < this.zzc.length) {
            int iZzc = zzc(i6);
            int i8 = (267386880 & iZzc) >>> 20;
            int[] iArr = this.zzc;
            int i9 = iArr[i6];
            int i10 = iArr[i6 + 2];
            int i11 = i10 & i4;
            if (i8 <= 17) {
                if (i11 != i7) {
                    i5 = i11 == i4 ? r9 : unsafe.getInt(t, i11);
                    i7 = i11;
                }
                i = i7;
                i2 = i5;
                i3 = 1 << (i10 >>> 20);
            } else {
                i = i7;
                i2 = i5;
                i3 = r9;
            }
            long j = iZzc & i4;
            if (i8 >= zzje.DOUBLE_LIST_PACKED.zza()) {
                zzje.SINT64_LIST_PACKED.zza();
            }
            int i12 = i3;
            switch (i8) {
                case 0:
                    z = r9;
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZza = zzit.zza(i9, AudioStats.AUDIO_AMPLITUDE_NONE);
                        iZzh += iZza;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    z = r9;
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZza = zzit.zza(i9, 0.0f);
                        iZzh += iZza;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    z = r9;
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZza = zzit.zzd(i9, unsafe.getLong(t, j));
                        iZzh += iZza;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    z = r9;
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZza = zzit.zzg(i9, unsafe.getLong(t, j));
                        iZzh += iZza;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    z = r9;
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZza = zzit.zzg(i9, unsafe.getInt(t, j));
                        iZzh += iZza;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    z = r9;
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZza = zzit.zzc(i9, 0L);
                        iZzh += iZza;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        z = false;
                        iZza = zzit.zzf(i9, 0);
                        iZzh += iZza;
                        break;
                    }
                    z = false;
                    break;
                case 7:
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZzb = zzit.zzb(i9, true);
                        iZzh += iZzb;
                    }
                    z = false;
                    break;
                case 8:
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        Object object = unsafe.getObject(t, j);
                        if (object instanceof zzia) {
                            iZzb = zzit.zzc(i9, (zzia) object);
                        } else {
                            iZzb = zzit.zzb(i9, (String) object);
                        }
                        iZzh += iZzb;
                    }
                    z = false;
                    break;
                case 9:
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZzb = zzln.zza(i9, unsafe.getObject(t, j), zze(i6));
                        iZzh += iZzb;
                    }
                    z = false;
                    break;
                case 10:
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZzb = zzit.zzc(i9, (zzia) unsafe.getObject(t, j));
                        iZzh += iZzb;
                    }
                    z = false;
                    break;
                case 11:
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZzb = zzit.zzj(i9, unsafe.getInt(t, j));
                        iZzh += iZzb;
                    }
                    z = false;
                    break;
                case 12:
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZzb = zzit.zze(i9, unsafe.getInt(t, j));
                        iZzh += iZzb;
                    }
                    z = false;
                    break;
                case 13:
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZzh += zzit.zzh(i9, 0);
                    }
                    z = false;
                    break;
                case 14:
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZzb = zzit.zze(i9, 0L);
                        iZzh += iZzb;
                    }
                    z = false;
                    break;
                case 15:
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZzb = zzit.zzi(i9, unsafe.getInt(t, j));
                        iZzh += iZzb;
                    }
                    z = false;
                    break;
                case 16:
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZzb = zzit.zzf(i9, unsafe.getLong(t, j));
                        iZzh += iZzb;
                    }
                    z = false;
                    break;
                case 17:
                    if (zza((zzkx<T>) t, i6, i, i2, i12)) {
                        iZzb = zzit.zzb(i9, (zzkt) unsafe.getObject(t, j), zze(i6));
                        iZzh += iZzb;
                    }
                    z = false;
                    break;
                case 18:
                    iZzd = zzln.zzd(i9, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 19:
                    iZzd = zzln.zzc(i9, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 20:
                    iZzd = zzln.zzf(i9, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 21:
                    iZzd = zzln.zzj(i9, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 22:
                    iZzd = zzln.zze(i9, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 23:
                    iZzd = zzln.zzd(i9, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 24:
                    iZzd = zzln.zzc(i9, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 25:
                    iZzd = zzln.zza(i9, (List<?>) unsafe.getObject(t, j), (boolean) r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 26:
                    iZzd = zzln.zzb(i9, (List) unsafe.getObject(t, j));
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 27:
                    iZzd = zzln.zzb(i9, (List<?>) unsafe.getObject(t, j), zze(i6));
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 28:
                    iZzd = zzln.zza(i9, (List<zzia>) unsafe.getObject(t, j));
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 29:
                    iZzd = zzln.zzi(i9, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 30:
                    iZzd = zzln.zzb(i9, (List<Integer>) unsafe.getObject(t, j), (boolean) r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 31:
                    iZzd = zzln.zzc(i9, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 32:
                    iZzd = zzln.zzd(i9, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 33:
                    iZzd = zzln.zzg(i9, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 34:
                    iZzd = zzln.zzh(i9, (List) unsafe.getObject(t, j), r9);
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 35:
                    iZzd2 = zzln.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 36:
                    iZzd2 = zzln.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 37:
                    iZzd2 = zzln.zzf((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 38:
                    iZzd2 = zzln.zzj((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 39:
                    iZzd2 = zzln.zze((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 40:
                    iZzd2 = zzln.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 41:
                    iZzd2 = zzln.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 42:
                    iZzd2 = zzln.zza((List<?>) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 43:
                    iZzd2 = zzln.zzi((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 44:
                    iZzd2 = zzln.zzb((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 45:
                    iZzd2 = zzln.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 46:
                    iZzd2 = zzln.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 47:
                    iZzd2 = zzln.zzg((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 48:
                    iZzd2 = zzln.zzh((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzi = zzit.zzi(i9);
                        iZzj = zzit.zzj(iZzd2);
                        iZzh += iZzi + iZzj + iZzd2;
                    }
                    z = r9;
                    break;
                case 49:
                    iZzd = zzln.zza(i9, (List<zzkt>) unsafe.getObject(t, j), zze(i6));
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 50:
                    iZzd = this.zzr.zza(i9, unsafe.getObject(t, j), zzf(i6));
                    iZzh += iZzd;
                    z = r9;
                    break;
                case 51:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zza(i9, AudioStats.AUDIO_AMPLITUDE_NONE);
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 52:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zza(i9, 0.0f);
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 53:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zzd(i9, zzd(t, j));
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 54:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zzg(i9, zzd(t, j));
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 55:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zzg(i9, zzc(t, j));
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 56:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zzc(i9, 0L);
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 57:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zzf(i9, (int) r9);
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 58:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zzb(i9, true);
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 59:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        Object object2 = unsafe.getObject(t, j);
                        if (object2 instanceof zzia) {
                            iZzd = zzit.zzc(i9, (zzia) object2);
                        } else {
                            iZzd = zzit.zzb(i9, (String) object2);
                        }
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 60:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzln.zza(i9, unsafe.getObject(t, j), zze(i6));
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 61:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zzc(i9, (zzia) unsafe.getObject(t, j));
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 62:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zzj(i9, zzc(t, j));
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 63:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zze(i9, zzc(t, j));
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 64:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zzh(i9, (int) r9);
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 65:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zze(i9, 0L);
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 66:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zzi(i9, zzc(t, j));
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 67:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zzf(i9, zzd(t, j));
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                case 68:
                    if (zzc((zzkx<T>) t, i9, i6)) {
                        iZzd = zzit.zzb(i9, (zzkt) unsafe.getObject(t, j), zze(i6));
                        iZzh += iZzd;
                    }
                    z = r9;
                    break;
                default:
                    z = r9;
                    break;
            }
            i6 += 3;
            i7 = i;
            r9 = z;
            i5 = i2;
            i4 = WinNT.NLS_VALID_LOCALE_MASK;
        }
        int iZza2 = r9;
        zzmf<?, ?> zzmfVar = this.zzp;
        int iZza3 = iZzh + zzmfVar.zza((zzmf<?, ?>) zzmfVar.zzd(t));
        if (!this.zzh) {
            return iZza3;
        }
        zzjd<T> zzjdVarZza = this.zzq.zza(t);
        for (int i13 = iZza2; i13 < zzjdVarZza.zza.zza(); i13++) {
            Map.Entry entryZza = zzjdVarZza.zza.zza(i13);
            iZza2 += zzjd.zza((zzjf<?>) entryZza.getKey(), entryZza.getValue());
        }
        for (Map.Entry entry : zzjdVarZza.zza.zzb()) {
            iZza2 += zzjd.zza((zzjf<?>) entry.getKey(), entry.getValue());
        }
        return iZza3 + iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final int zzb(T t) {
        int i;
        int iZza;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzc = zzc(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzc;
            int iHashCode = 37;
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZza = zzjm.zza(Double.doubleToLongBits(zzmg.zza(t, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zzmg.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzh(t, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zzmg.zze(t, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZze = zzmg.zze(t, j);
                    if (objZze != null) {
                        iHashCode = objZze.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zzmg.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zzmg.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzjm.zza(zzmg.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZze2 = zzmg.zze(t, j);
                    if (objZze2 != null) {
                        iHashCode = objZze2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZza = zzmg.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = zzmg.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 51:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(Double.doubleToLongBits(zza(t, j)));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzb(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zzmg.zze(t, j)).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmg.zze(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmg.zze(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjm.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzc((zzkx<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmg.zze(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzp.zzd(t).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzq.zza(t).hashCode() : iHashCode2;
    }

    private static <T> int zzc(T t, long j) {
        return ((Integer) zzmg.zze(t, j)).intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:425:0x09d5, code lost:
    
        throw com.google.android.gms.internal.measurement.zzjs.zzh();
     */
    /* JADX WARN: Code restructure failed: missing block: B:522:0x0ce3, code lost:
    
        if (r14 == r0) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:523:0x0ce5, code lost:
    
        r27.putInt(r7, r14, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:524:0x0ceb, code lost:
    
        r10 = r9.zzl;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:526:0x0cf2, code lost:
    
        if (r10 >= r9.zzm) goto L641;
     */
    /* JADX WARN: Code restructure failed: missing block: B:527:0x0cf4, code lost:
    
        r3 = (com.google.android.gms.internal.measurement.zzme) zza((java.lang.Object) r31, r9.zzk[r10], (int) r3, (com.google.android.gms.internal.measurement.zzmf<UT, int>) r9.zzp, (java.lang.Object) r31);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:528:0x0d0a, code lost:
    
        if (r3 == null) goto L530;
     */
    /* JADX WARN: Code restructure failed: missing block: B:529:0x0d0c, code lost:
    
        r9.zzp.zzb((java.lang.Object) r7, (T) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:530:0x0d11, code lost:
    
        if (r6 != 0) goto L536;
     */
    /* JADX WARN: Code restructure failed: missing block: B:532:0x0d15, code lost:
    
        if (r8 != r34) goto L534;
     */
    /* JADX WARN: Code restructure failed: missing block: B:535:0x0d1c, code lost:
    
        throw com.google.android.gms.internal.measurement.zzjs.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:537:0x0d1f, code lost:
    
        if (r8 > r34) goto L540;
     */
    /* JADX WARN: Code restructure failed: missing block: B:538:0x0d21, code lost:
    
        if (r11 != r6) goto L540;
     */
    /* JADX WARN: Code restructure failed: missing block: B:539:0x0d23, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:541:0x0d28, code lost:
    
        throw com.google.android.gms.internal.measurement.zzjs.zzg();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0c55 A[PHI: r4 r5 r6 r8 r13 r14 r19
      0x0c55: PHI (r4v96 int) = 
      (r4v70 int)
      (r4v71 int)
      (r4v72 int)
      (r4v73 int)
      (r4v74 int)
      (r4v76 int)
      (r4v77 int)
      (r4v78 int)
      (r4v85 int)
      (r4v92 int)
      (r4v97 int)
     binds: [B:498:0x0c41, B:495:0x0c21, B:492:0x0c01, B:489:0x0be1, B:486:0x0bc1, B:483:0x0ba0, B:476:0x0b76, B:462:0x0b38, B:460:0x0b27, B:434:0x0a3f, B:430:0x09fe] A[DONT_GENERATE, DONT_INLINE]
      0x0c55: PHI (r5v97 com.google.android.gms.internal.measurement.zzkx<T>) = 
      (r5v72 com.google.android.gms.internal.measurement.zzkx<T>)
      (r5v73 com.google.android.gms.internal.measurement.zzkx<T>)
      (r5v74 com.google.android.gms.internal.measurement.zzkx<T>)
      (r5v75 com.google.android.gms.internal.measurement.zzkx<T>)
      (r5v76 com.google.android.gms.internal.measurement.zzkx<T>)
      (r5v78 com.google.android.gms.internal.measurement.zzkx<T>)
      (r5v79 com.google.android.gms.internal.measurement.zzkx<T>)
      (r5v80 com.google.android.gms.internal.measurement.zzkx<T>)
      (r5v87 com.google.android.gms.internal.measurement.zzkx<T>)
      (r5v93 com.google.android.gms.internal.measurement.zzkx<T>)
      (r5v98 com.google.android.gms.internal.measurement.zzkx<T>)
     binds: [B:498:0x0c41, B:495:0x0c21, B:492:0x0c01, B:489:0x0be1, B:486:0x0bc1, B:483:0x0ba0, B:476:0x0b76, B:462:0x0b38, B:460:0x0b27, B:434:0x0a3f, B:430:0x09fe] A[DONT_GENERATE, DONT_INLINE]
      0x0c55: PHI (r6v36 int) = 
      (r6v12 int)
      (r6v13 int)
      (r6v14 int)
      (r6v15 int)
      (r6v16 int)
      (r6v18 int)
      (r6v19 int)
      (r6v20 int)
      (r6v25 int)
      (r6v31 int)
      (r6v37 int)
     binds: [B:498:0x0c41, B:495:0x0c21, B:492:0x0c01, B:489:0x0be1, B:486:0x0bc1, B:483:0x0ba0, B:476:0x0b76, B:462:0x0b38, B:460:0x0b27, B:434:0x0a3f, B:430:0x09fe] A[DONT_GENERATE, DONT_INLINE]
      0x0c55: PHI (r8v100 int) = 
      (r8v76 int)
      (r8v77 int)
      (r8v78 int)
      (r8v79 int)
      (r8v80 int)
      (r8v82 int)
      (r8v83 int)
      (r8v84 int)
      (r8v92 int)
      (r8v96 int)
      (r8v101 int)
     binds: [B:498:0x0c41, B:495:0x0c21, B:492:0x0c01, B:489:0x0be1, B:486:0x0bc1, B:483:0x0ba0, B:476:0x0b76, B:462:0x0b38, B:460:0x0b27, B:434:0x0a3f, B:430:0x09fe] A[DONT_GENERATE, DONT_INLINE]
      0x0c55: PHI (r13v89 com.google.android.gms.internal.measurement.zzhv) = 
      (r13v65 com.google.android.gms.internal.measurement.zzhv)
      (r13v66 com.google.android.gms.internal.measurement.zzhv)
      (r13v67 com.google.android.gms.internal.measurement.zzhv)
      (r13v68 com.google.android.gms.internal.measurement.zzhv)
      (r13v69 com.google.android.gms.internal.measurement.zzhv)
      (r13v71 com.google.android.gms.internal.measurement.zzhv)
      (r13v72 com.google.android.gms.internal.measurement.zzhv)
      (r13v73 com.google.android.gms.internal.measurement.zzhv)
      (r13v78 com.google.android.gms.internal.measurement.zzhv)
      (r13v84 com.google.android.gms.internal.measurement.zzhv)
      (r13v90 com.google.android.gms.internal.measurement.zzhv)
     binds: [B:498:0x0c41, B:495:0x0c21, B:492:0x0c01, B:489:0x0be1, B:486:0x0bc1, B:483:0x0ba0, B:476:0x0b76, B:462:0x0b38, B:460:0x0b27, B:434:0x0a3f, B:430:0x09fe] A[DONT_GENERATE, DONT_INLINE]
      0x0c55: PHI (r14v83 byte[]) = 
      (r14v56 byte[])
      (r14v57 byte[])
      (r14v58 byte[])
      (r14v59 byte[])
      (r14v60 byte[])
      (r14v62 byte[])
      (r14v63 byte[])
      (r14v64 byte[])
      (r14v69 byte[])
      (r14v78 byte[])
      (r14v84 byte[])
     binds: [B:498:0x0c41, B:495:0x0c21, B:492:0x0c01, B:489:0x0be1, B:486:0x0bc1, B:483:0x0ba0, B:476:0x0b76, B:462:0x0b38, B:460:0x0b27, B:434:0x0a3f, B:430:0x09fe] A[DONT_GENERATE, DONT_INLINE]
      0x0c55: PHI (r19v48 int) = 
      (r19v27 int)
      (r19v28 int)
      (r19v29 int)
      (r19v30 int)
      (r19v31 int)
      (r19v33 int)
      (r19v34 int)
      (r19v35 int)
      (r19v39 int)
      (r19v45 int)
      (r19v49 int)
     binds: [B:498:0x0c41, B:495:0x0c21, B:492:0x0c01, B:489:0x0be1, B:486:0x0bc1, B:483:0x0ba0, B:476:0x0b76, B:462:0x0b38, B:460:0x0b27, B:434:0x0a3f, B:430:0x09fe] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:503:0x0c58  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x0ca4  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x0cc6  */
    /* JADX WARN: Removed duplicated region for block: B:579:0x08ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:624:0x08ac A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v135, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zza(T r31, byte[] r32, int r33, int r34, int r35, com.google.android.gms.internal.measurement.zzhv r36) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkx.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzhv):int");
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    private final int zza(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzd(T t, long j) {
        return ((Long) zzmg.zze(t, j)).longValue();
    }

    private final zzjo zzd(int i) {
        return (zzjo) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0276  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <T> com.google.android.gms.internal.measurement.zzkx<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.measurement.zzkr r34, com.google.android.gms.internal.measurement.zzlb r35, com.google.android.gms.internal.measurement.zzkd r36, com.google.android.gms.internal.measurement.zzmf<?, ?> r37, com.google.android.gms.internal.measurement.zziz<?> r38, com.google.android.gms.internal.measurement.zzkm r39) {
        /*
            Method dump skipped, instructions count: 1034
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkx.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzkr, com.google.android.gms.internal.measurement.zzlb, com.google.android.gms.internal.measurement.zzkd, com.google.android.gms.internal.measurement.zzmf, com.google.android.gms.internal.measurement.zziz, com.google.android.gms.internal.measurement.zzkm):com.google.android.gms.internal.measurement.zzkx");
    }

    private final zzll zze(int i) {
        int i2 = (i / 3) << 1;
        zzll zzllVar = (zzll) this.zzd[i2];
        if (zzllVar != null) {
            return zzllVar;
        }
        zzll<T> zzllVarZza = zzlh.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzllVarZza;
        return zzllVarZza;
    }

    private static zzme zze(Object obj) {
        zzjk zzjkVar = (zzjk) obj;
        zzme zzmeVar = zzjkVar.zzb;
        if (zzmeVar != zzme.zzc()) {
            return zzmeVar;
        }
        zzme zzmeVarZzd = zzme.zzd();
        zzjkVar.zzb = zzmeVarZzd;
        return zzmeVarZzd;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzmf<UT, UB> zzmfVar, Object obj2) {
        zzjo zzjoVarZzd;
        int i2 = this.zzc[i];
        Object objZze = zzmg.zze(obj, zzc(i) & WinNT.NLS_VALID_LOCALE_MASK);
        return (objZze == null || (zzjoVarZzd = zzd(i)) == null) ? ub : (UB) zza(i, i2, this.zzr.zze(objZze), zzjoVarZzd, (zzjo) ub, (zzmf<UT, zzjo>) zzmfVar, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzjo zzjoVar, UB ub, zzmf<UT, UB> zzmfVar, Object obj) {
        zzkk<?, ?> zzkkVarZza = this.zzr.zza(zzf(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzjoVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzmfVar.zzc(obj);
                }
                zzif zzifVarZzc = zzia.zzc(zzkl.zza(zzkkVarZza, next.getKey(), next.getValue()));
                try {
                    zzkl.zza(zzifVarZzc.zzb(), zzkkVarZza, next.getKey(), next.getValue());
                    zzmfVar.zza((zzmf<UT, UB>) ub, i2, zzifVarZzc.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i) {
        zzll zzllVarZze = zze(i);
        long jZzc = zzc(i) & WinNT.NLS_VALID_LOCALE_MASK;
        if (!zzc((zzkx<T>) t, i)) {
            return zzllVarZze.zza();
        }
        Object object = zzb.getObject(t, jZzc);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzllVarZze.zza();
        if (object != null) {
            zzllVarZze.zza(objZza, object);
        }
        return objZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i, int i2) {
        zzll zzllVarZze = zze(i2);
        if (!zzc((zzkx<T>) t, i, i2)) {
            return zzllVarZze.zza();
        }
        Object object = zzb.getObject(t, zzc(i2) & WinNT.NLS_VALID_LOCALE_MASK);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzllVarZze.zza();
        if (object != null) {
            zzllVarZze.zza(objZza, object);
        }
        return objZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final T zza() {
        return (T) this.zzn.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private zzkx(int[] iArr, Object[] objArr, int i, int i2, zzkt zzktVar, zzle zzleVar, boolean z, int[] iArr2, int i3, int i4, zzlb zzlbVar, zzkd zzkdVar, zzmf<?, ?> zzmfVar, zziz<?> zzizVar, zzkm zzkmVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzktVar instanceof zzjk;
        this.zzh = zzizVar != null && zzizVar.zza(zzktVar);
        this.zzj = false;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzn = zzlbVar;
        this.zzo = zzkdVar;
        this.zzp = zzmfVar;
        this.zzq = zzizVar;
        this.zzg = zzktVar;
        this.zzr = zzkmVar;
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    @Override // com.google.android.gms.internal.measurement.zzll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzc(T r8) {
        /*
            r7 = this;
            boolean r0 = zzg(r8)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8 instanceof com.google.android.gms.internal.measurement.zzjk
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r8
            com.google.android.gms.internal.measurement.zzjk r0 = (com.google.android.gms.internal.measurement.zzjk) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.zzc(r2)
            r0.zza = r1
            r0.zzcl()
        L1a:
            int[] r0 = r7.zzc
            int r0 = r0.length
        L1d:
            if (r1 >= r0) goto L83
            int r2 = r7.zzc(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            long r3 = (long) r3
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r2 = r2 & r5
            int r2 = r2 >>> 20
            r5 = 9
            if (r2 == r5) goto L6d
            r5 = 60
            if (r2 == r5) goto L55
            r5 = 68
            if (r2 == r5) goto L55
            switch(r2) {
                case 17: goto L6d;
                case 18: goto L4f;
                case 19: goto L4f;
                case 20: goto L4f;
                case 21: goto L4f;
                case 22: goto L4f;
                case 23: goto L4f;
                case 24: goto L4f;
                case 25: goto L4f;
                case 26: goto L4f;
                case 27: goto L4f;
                case 28: goto L4f;
                case 29: goto L4f;
                case 30: goto L4f;
                case 31: goto L4f;
                case 32: goto L4f;
                case 33: goto L4f;
                case 34: goto L4f;
                case 35: goto L4f;
                case 36: goto L4f;
                case 37: goto L4f;
                case 38: goto L4f;
                case 39: goto L4f;
                case 40: goto L4f;
                case 41: goto L4f;
                case 42: goto L4f;
                case 43: goto L4f;
                case 44: goto L4f;
                case 45: goto L4f;
                case 46: goto L4f;
                case 47: goto L4f;
                case 48: goto L4f;
                case 49: goto L4f;
                case 50: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L80
        L3d:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.measurement.zzkx.zzb
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L80
            com.google.android.gms.internal.measurement.zzkm r6 = r7.zzr
            java.lang.Object r5 = r6.zzc(r5)
            r2.putObject(r8, r3, r5)
            goto L80
        L4f:
            com.google.android.gms.internal.measurement.zzkd r2 = r7.zzo
            r2.zzb(r8, r3)
            goto L80
        L55:
            int[] r2 = r7.zzc
            r2 = r2[r1]
            boolean r2 = r7.zzc(r8, r2, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.measurement.zzll r2 = r7.zze(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.measurement.zzkx.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzc(r3)
            goto L80
        L6d:
            boolean r2 = r7.zzc(r8, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.measurement.zzll r2 = r7.zze(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.measurement.zzkx.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzc(r3)
        L80:
            int r1 = r1 + 3
            goto L1d
        L83:
            com.google.android.gms.internal.measurement.zzmf<?, ?> r0 = r7.zzp
            r0.zzf(r8)
            boolean r0 = r7.zzh
            if (r0 == 0) goto L91
            com.google.android.gms.internal.measurement.zziz<?> r0 = r7.zzq
            r0.zzc(r8)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkx.zzc(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zza(T t, T t2) {
        zzf(t);
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzc = zzc(i);
            long j = 1048575 & iZzc;
            int i2 = this.zzc[i];
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza(t, j, zzmg.zza(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzb(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zzc(t, j, zzmg.zzh(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza(t, j, zzmg.zze(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza(t, j, zzmg.zze(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzc(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzc((zzkx<T>) t2, i)) {
                        zzmg.zza((Object) t, j, zzmg.zzd(t2, j));
                        zzb((zzkx<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzo.zza(t, t2, j);
                    break;
                case 50:
                    zzln.zza(this.zzr, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzc((zzkx<T>) t2, i2, i)) {
                        zzmg.zza(t, j, zzmg.zze(t2, j));
                        zzb((zzkx<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzc((zzkx<T>) t2, i2, i)) {
                        zzmg.zza(t, j, zzmg.zze(t2, j));
                        zzb((zzkx<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzln.zza(this.zzp, t, t2);
        if (this.zzh) {
            zzln.zza(this.zzq, t, t2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0620 A[Catch: all -> 0x0295, TryCatch #1 {all -> 0x0295, blocks: (B:153:0x05f4, B:163:0x061b, B:165:0x0620, B:166:0x0625, B:49:0x00c9, B:50:0x00db, B:51:0x00ed, B:52:0x00ff, B:53:0x0110, B:54:0x0121, B:56:0x012b, B:59:0x0132, B:60:0x0139, B:61:0x0146, B:62:0x0157, B:63:0x0164, B:64:0x0175, B:66:0x0180, B:67:0x0191, B:68:0x01a2, B:69:0x01b3, B:70:0x01c4, B:71:0x01d5, B:72:0x01e6, B:73:0x01f7, B:74:0x0209, B:76:0x0219, B:80:0x023a, B:77:0x0223, B:79:0x022b, B:81:0x024b, B:82:0x025d, B:83:0x026b, B:84:0x0279, B:85:0x0287), top: B:189:0x05f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0657 A[LOOP:2: B:181:0x0653->B:183:0x0657, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x062b A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.google.android.gms.internal.measurement.zzli] */
    @Override // com.google.android.gms.internal.measurement.zzll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r18, com.google.android.gms.internal.measurement.zzli r19, com.google.android.gms.internal.measurement.zzix r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkx.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzli, com.google.android.gms.internal.measurement.zzix):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zza(T t, byte[] bArr, int i, int i2, zzhv zzhvVar) throws IOException {
        zza((zzkx<T>) t, bArr, i, i2, 0, zzhvVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t, T t2, int i) {
        if (zzc((zzkx<T>) t2, i)) {
            long jZzc = zzc(i) & WinNT.NLS_VALID_LOCALE_MASK;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzll zzllVarZze = zze(i);
            if (!zzc((zzkx<T>) t, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzllVarZze.zza();
                    zzllVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb((zzkx<T>) t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzllVarZze.zza();
                zzllVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzllVarZze.zza(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t, T t2, int i) {
        int i2 = this.zzc[i];
        if (zzc((zzkx<T>) t2, i2, i)) {
            long jZzc = zzc(i) & WinNT.NLS_VALID_LOCALE_MASK;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzll zzllVarZze = zze(i);
            if (!zzc((zzkx<T>) t, i2, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzllVarZze.zza();
                    zzllVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb((zzkx<T>) t, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzllVarZze.zza();
                zzllVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzllVarZze.zza(object2, object);
        }
    }

    private final void zza(Object obj, int i, zzli zzliVar) throws IOException {
        if (zzg(i)) {
            zzmg.zza(obj, i & WinNT.NLS_VALID_LOCALE_MASK, zzliVar.zzr());
        } else if (this.zzi) {
            zzmg.zza(obj, i & WinNT.NLS_VALID_LOCALE_MASK, zzliVar.zzq());
        } else {
            zzmg.zza(obj, i & WinNT.NLS_VALID_LOCALE_MASK, zzliVar.zzp());
        }
    }

    private final void zzb(T t, int i) {
        int iZzb = zzb(i);
        long j = 1048575 & iZzb;
        if (j == 1048575) {
            return;
        }
        zzmg.zza((Object) t, j, (1 << (iZzb >>> 20)) | zzmg.zzc(t, j));
    }

    private final void zzb(T t, int i, int i2) {
        zzmg.zza((Object) t, zzb(i2) & WinNT.NLS_VALID_LOCALE_MASK, i);
    }

    private final void zza(T t, int i, Object obj) {
        zzb.putObject(t, zzc(i) & WinNT.NLS_VALID_LOCALE_MASK, obj);
        zzb((zzkx<T>) t, i);
    }

    private final void zza(T t, int i, int i2, Object obj) {
        zzb.putObject(t, zzc(i2) & WinNT.NLS_VALID_LOCALE_MASK, obj);
        zzb((zzkx<T>) t, i, i2);
    }

    private final <K, V> void zza(zzna zznaVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zznaVar.zza(i, this.zzr.zza(zzf(i2)), this.zzr.zzd(obj));
        }
    }

    private static void zza(int i, Object obj, zzna zznaVar) throws IOException {
        if (obj instanceof String) {
            zznaVar.zza(i, (String) obj);
        } else {
            zznaVar.zza(i, (zzia) obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:176:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    @Override // com.google.android.gms.internal.measurement.zzll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r24, com.google.android.gms.internal.measurement.zzna r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkx.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzna):void");
    }

    private static <UT, UB> void zza(zzmf<UT, UB> zzmfVar, T t, zzna zznaVar) throws IOException {
        zzmfVar.zzb((zzmf<UT, UB>) zzmfVar.zzd(t), zznaVar);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzc((zzkx<T>) t, i) == zzc((zzkx<T>) t2, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.measurement.zzll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzb(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkx.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    private final boolean zzc(T t, int i) {
        int iZzb = zzb(i);
        long j = iZzb & WinNT.NLS_VALID_LOCALE_MASK;
        if (j != 1048575) {
            return (zzmg.zzc(t, j) & (1 << (iZzb >>> 20))) != 0;
        }
        int iZzc = zzc(i);
        long j2 = iZzc & WinNT.NLS_VALID_LOCALE_MASK;
        switch ((iZzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzmg.zza(t, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmg.zzb(t, j2)) != 0;
            case 2:
                return zzmg.zzd(t, j2) != 0;
            case 3:
                return zzmg.zzd(t, j2) != 0;
            case 4:
                return zzmg.zzc(t, j2) != 0;
            case 5:
                return zzmg.zzd(t, j2) != 0;
            case 6:
                return zzmg.zzc(t, j2) != 0;
            case 7:
                return zzmg.zzh(t, j2);
            case 8:
                Object objZze = zzmg.zze(t, j2);
                if (objZze instanceof String) {
                    return !((String) objZze).isEmpty();
                }
                if (objZze instanceof zzia) {
                    return !zzia.zza.equals(objZze);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmg.zze(t, j2) != null;
            case 10:
                return !zzia.zza.equals(zzmg.zze(t, j2));
            case 11:
                return zzmg.zzc(t, j2) != 0;
            case 12:
                return zzmg.zzc(t, j2) != 0;
            case 13:
                return zzmg.zzc(t, j2) != 0;
            case 14:
                return zzmg.zzd(t, j2) != 0;
            case 15:
                return zzmg.zzc(t, j2) != 0;
            case 16:
                return zzmg.zzd(t, j2) != 0;
            case 17:
                return zzmg.zze(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzc((zzkx<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2  */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzll] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzll] */
    @Override // com.google.android.gms.internal.measurement.zzll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzd(T r18) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkx.zzd(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzll zzllVar) {
        return zzllVar.zzd(zzmg.zze(obj, i & WinNT.NLS_VALID_LOCALE_MASK));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzjk) {
            return ((zzjk) obj).zzcn();
        }
        return true;
    }

    private final boolean zzc(T t, int i, int i2) {
        return zzmg.zzc(t, (long) (zzb(i2) & WinNT.NLS_VALID_LOCALE_MASK)) == i;
    }

    private static <T> boolean zze(T t, long j) {
        return ((Boolean) zzmg.zze(t, j)).booleanValue();
    }
}
