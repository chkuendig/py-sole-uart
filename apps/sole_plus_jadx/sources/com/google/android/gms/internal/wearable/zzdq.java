package com.google.android.gms.internal.wearable;

import com.sun.jna.platform.win32.WinNT;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzdq<T> implements zzdy<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzez.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzdn zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzdb zzl;
    private final zzep zzm;
    private final zzbv zzn;
    private final zzds zzo;
    private final zzdi zzp;

    private zzdq(int[] iArr, Object[] objArr, int i, int i2, zzdn zzdnVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzds zzdsVar, zzdb zzdbVar, zzep zzepVar, zzbv zzbvVar, zzdi zzdiVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzbvVar != null && zzbvVar.zzc(zzdnVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzo = zzdsVar;
        this.zzl = zzdbVar;
        this.zzm = zzepVar;
        this.zzn = zzbvVar;
        this.zzg = zzdnVar;
        this.zzp = zzdiVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i) & WinNT.NLS_VALID_LOCALE_MASK;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzdy zzdyVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zzdyVarZzv.zze();
                    zzdyVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzdyVarZzv.zze();
                zzdyVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzdyVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i) & WinNT.NLS_VALID_LOCALE_MASK;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzdy zzdyVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zzdyVarZzv.zze();
                    zzdyVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzdyVarZzv.zze();
                zzdyVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzdyVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzez.zzq(obj, j, (1 << (iZzp >>> 20)) | zzez.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzez.zzq(obj, zzp(i2) & WinNT.NLS_VALID_LOCALE_MASK, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & WinNT.NLS_VALID_LOCALE_MASK, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & WinNT.NLS_VALID_LOCALE_MASK, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & WinNT.NLS_VALID_LOCALE_MASK;
        if (j != 1048575) {
            return (zzez.zzc(obj, j) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & WinNT.NLS_VALID_LOCALE_MASK;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzez.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzez.zzb(obj, j2)) != 0;
            case 2:
                return zzez.zzd(obj, j2) != 0;
            case 3:
                return zzez.zzd(obj, j2) != 0;
            case 4:
                return zzez.zzc(obj, j2) != 0;
            case 5:
                return zzez.zzd(obj, j2) != 0;
            case 6:
                return zzez.zzc(obj, j2) != 0;
            case 7:
                return zzez.zzw(obj, j2);
            case 8:
                Object objZzf = zzez.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzbh) {
                    return !zzbh.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzez.zzf(obj, j2) != null;
            case 10:
                return !zzbh.zzb.equals(zzez.zzf(obj, j2));
            case 11:
                return zzez.zzc(obj, j2) != 0;
            case 12:
                return zzez.zzc(obj, j2) != 0;
            case 13:
                return zzez.zzc(obj, j2) != 0;
            case 14:
                return zzez.zzd(obj, j2) != 0;
            case 15:
                return zzez.zzc(obj, j2) != 0;
            case 16:
                return zzez.zzd(obj, j2) != 0;
            case 17:
                return zzez.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzI(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzdy zzdyVar) {
        return zzdyVar.zzk(zzez.zzf(obj, i & WinNT.NLS_VALID_LOCALE_MASK));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzcg) {
            return ((zzcg) obj).zzaf();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzez.zzc(obj, (long) (zzp(i2) & WinNT.NLS_VALID_LOCALE_MASK)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzez.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzfh zzfhVar) throws IOException {
        if (obj instanceof String) {
            zzfhVar.zzF(i, (String) obj);
        } else {
            zzfhVar.zzd(i, (zzbh) obj);
        }
    }

    static zzeq zzd(Object obj) {
        zzcg zzcgVar = (zzcg) obj;
        zzeq zzeqVar = zzcgVar.zzc;
        if (zzeqVar != zzeq.zzc()) {
            return zzeqVar;
        }
        zzeq zzeqVarZzf = zzeq.zzf();
        zzcgVar.zzc = zzeqVarZzf;
        return zzeqVarZzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x026d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.android.gms.internal.wearable.zzdq zzl(java.lang.Class r31, com.google.android.gms.internal.wearable.zzdk r32, com.google.android.gms.internal.wearable.zzds r33, com.google.android.gms.internal.wearable.zzdb r34, com.google.android.gms.internal.wearable.zzep r35, com.google.android.gms.internal.wearable.zzbv r36, com.google.android.gms.internal.wearable.zzdi r37) {
        /*
            Method dump skipped, instructions count: 1007
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.wearable.zzdq.zzl(java.lang.Class, com.google.android.gms.internal.wearable.zzdk, com.google.android.gms.internal.wearable.zzds, com.google.android.gms.internal.wearable.zzdb, com.google.android.gms.internal.wearable.zzep, com.google.android.gms.internal.wearable.zzbv, com.google.android.gms.internal.wearable.zzdi):com.google.android.gms.internal.wearable.zzdq");
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzez.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzez.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzez.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzez.zzf(obj, j)).longValue();
    }

    private final zzck zzu(int i) {
        int i2 = i / 3;
        return (zzck) this.zzd[i2 + i2 + 1];
    }

    private final zzdy zzv(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzdy zzdyVar = (zzdy) this.zzd[i3];
        if (zzdyVar != null) {
            return zzdyVar;
        }
        zzdy zzdyVarZzb = zzdv.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzdyVarZzb;
        return zzdyVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzdy zzdyVarZzv = zzv(i);
        int iZzs = zzs(i) & WinNT.NLS_VALID_LOCALE_MASK;
        if (!zzI(obj, i)) {
            return zzdyVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzdyVarZzv.zze();
        if (object != null) {
            zzdyVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzdy zzdyVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzdyVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & WinNT.NLS_VALID_LOCALE_MASK);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzdyVarZzv.zze();
        if (object != null) {
            zzdyVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v117, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [com.google.android.gms.internal.wearable.zzcv] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v122, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v140 */
    /* JADX WARN: Type inference failed for: r0v188, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v267, types: [int] */
    /* JADX WARN: Type inference failed for: r0v274, types: [int] */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r0v281 */
    /* JADX WARN: Type inference failed for: r0v282 */
    /* JADX WARN: Type inference failed for: r0v283 */
    /* JADX WARN: Type inference failed for: r0v284 */
    /* JADX WARN: Type inference failed for: r0v285 */
    /* JADX WARN: Type inference failed for: r0v286 */
    /* JADX WARN: Type inference failed for: r0v287 */
    /* JADX WARN: Type inference failed for: r0v288 */
    /* JADX WARN: Type inference failed for: r0v289 */
    /* JADX WARN: Type inference failed for: r0v290 */
    /* JADX WARN: Type inference failed for: r0v291 */
    /* JADX WARN: Type inference failed for: r0v292 */
    /* JADX WARN: Type inference failed for: r0v293 */
    /* JADX WARN: Type inference failed for: r0v294 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v121, types: [int] */
    /* JADX WARN: Type inference failed for: r1v123, types: [int] */
    /* JADX WARN: Type inference failed for: r1v126 */
    /* JADX WARN: Type inference failed for: r1v129 */
    /* JADX WARN: Type inference failed for: r1v130 */
    /* JADX WARN: Type inference failed for: r1v131 */
    /* JADX WARN: Type inference failed for: r1v132 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v59, types: [int] */
    /* JADX WARN: Type inference failed for: r2v100 */
    /* JADX WARN: Type inference failed for: r2v101 */
    /* JADX WARN: Type inference failed for: r2v102 */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /* JADX WARN: Type inference failed for: r2v45, types: [int] */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55, types: [int] */
    /* JADX WARN: Type inference failed for: r2v93, types: [int] */
    /* JADX WARN: Type inference failed for: r2v95, types: [int] */
    /* JADX WARN: Type inference failed for: r2v98 */
    /* JADX WARN: Type inference failed for: r2v99 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [int] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [int] */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v35, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v42, types: [int] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v37, types: [int] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.wearable.zzdy
    public final int zza(Object obj) {
        int i;
        int i2;
        ?? r5;
        int iZzx;
        int iZzx2;
        int iZzy;
        int iZzx3;
        int iZzx4;
        int iZzx5;
        int iZzx6;
        int iZzx7;
        int iZzy2;
        int size;
        int iZzl;
        int iZzx8;
        ?? r2;
        int iZzw;
        int iZzw2;
        ?? Zzx;
        int iZzv;
        ?? Zzx2;
        ?? Zzx3;
        int iZzx9;
        int iZzx10;
        ?? r4;
        Unsafe unsafe = zzb;
        boolean z = false;
        int i3 = WinNT.NLS_VALID_LOCALE_MASK;
        ?? r1 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < this.zzc.length) {
            int iZzs = zzs(i4);
            int iZzr = zzr(iZzs);
            int[] iArr = this.zzc;
            int i7 = iArr[i4];
            int i8 = iArr[i4 + 2];
            int i9 = i8 & i3;
            if (iZzr <= 17) {
                if (i9 != i6) {
                    r1 = i9 == i3 ? z : unsafe.getInt(obj, i9);
                    i6 = i9;
                }
                i = i6;
                i2 = r1;
                r5 = 1 << (i8 >>> 20);
            } else {
                i = i6;
                i2 = r1;
                r5 = z;
            }
            int i10 = iZzs & i3;
            if (iZzr >= zzca.DOUBLE_LIST_PACKED.zza()) {
                zzca.SINT64_LIST_PACKED.zza();
            }
            long j = i10;
            switch (iZzr) {
                case 0:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        iZzx = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx + 8;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 1:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        iZzx2 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx2 + 4;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 2:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        iZzy = zzbp.zzy(unsafe.getLong(obj, j));
                        iZzx3 = zzbp.zzx(i7 << 3);
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 3:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        iZzy = zzbp.zzy(unsafe.getLong(obj, j));
                        iZzx3 = zzbp.zzx(i7 << 3);
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 4:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        iZzy = zzbp.zzu(unsafe.getInt(obj, j));
                        iZzx3 = zzbp.zzx(i7 << 3);
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 5:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        iZzx = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx + 8;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 6:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        iZzx2 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx2 + 4;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 7:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        iZzx4 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx4 + 1;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 8:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzbh) {
                            int i11 = zzbp.zzb;
                            int iZzd = ((zzbh) object).zzd();
                            iZzx5 = zzbp.zzx(iZzd) + iZzd;
                            iZzx6 = zzbp.zzx(i7 << 3);
                            Zzx3 = iZzx6 + iZzx5;
                            i5 += Zzx3;
                            i4 += 3;
                            i6 = i;
                            r1 = i2;
                            z = false;
                            i3 = WinNT.NLS_VALID_LOCALE_MASK;
                        } else {
                            iZzy = zzbp.zzw((String) object);
                            iZzx3 = zzbp.zzx(i7 << 3);
                            Zzx2 = iZzx3 + iZzy;
                            i5 += Zzx2;
                            i4 += 3;
                            i6 = i;
                            r1 = i2;
                            z = false;
                            i3 = WinNT.NLS_VALID_LOCALE_MASK;
                        }
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 9:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        Zzx3 = zzea.zzh(i7, unsafe.getObject(obj, j), zzv(i4));
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 10:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        zzbh zzbhVar = (zzbh) unsafe.getObject(obj, j);
                        int i12 = zzbp.zzb;
                        int iZzd2 = zzbhVar.zzd();
                        iZzx5 = zzbp.zzx(iZzd2) + iZzd2;
                        iZzx6 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx6 + iZzx5;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 11:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        iZzy = zzbp.zzx(unsafe.getInt(obj, j));
                        iZzx3 = zzbp.zzx(i7 << 3);
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 12:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        iZzy = zzbp.zzu(unsafe.getInt(obj, j));
                        iZzx3 = zzbp.zzx(i7 << 3);
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 13:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        iZzx2 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx2 + 4;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 14:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        iZzx = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx + 8;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 15:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        int i13 = unsafe.getInt(obj, j);
                        iZzx3 = zzbp.zzx(i7 << 3);
                        iZzy = zzbp.zzx((i13 >> 31) ^ (i13 + i13));
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 16:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzx7 = zzbp.zzx(i7 << 3);
                        iZzy2 = zzbp.zzy((j2 >> 63) ^ (j2 + j2));
                        r2 = iZzx7 + iZzy2;
                        i5 += r2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 17:
                    if (zzJ(obj, i4, i, i2, r5)) {
                        Zzx3 = zzbp.zzt(i7, (zzdn) unsafe.getObject(obj, j), zzv(i4));
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 18:
                    Zzx3 = zzea.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += Zzx3;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 19:
                    Zzx3 = zzea.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += Zzx3;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zzea.zza;
                    if (list.size() != 0) {
                        iZzx3 = zzea.zzg(list);
                        iZzy = list.size() * zzbp.zzx(i7 << 3);
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                    Zzx2 = z;
                    i5 += Zzx2;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i15 = zzea.zza;
                    size = list2.size();
                    if (size != 0) {
                        iZzl = zzea.zzl(list2);
                        iZzx8 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzl + (size * iZzx8);
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                    i5 += Zzx3;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zzea.zza;
                    size = list3.size();
                    if (size != 0) {
                        iZzl = zzea.zzf(list3);
                        iZzx8 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzl + (size * iZzx8);
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                    i5 += Zzx3;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 23:
                    Zzx3 = zzea.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += Zzx3;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 24:
                    Zzx3 = zzea.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += Zzx3;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zzea.zza;
                    int size2 = list4.size();
                    Zzx3 = size2 == 0 ? z : size2 * (zzbp.zzx(i7 << 3) + 1);
                    i5 += Zzx3;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 26:
                    ?? r0 = (List) unsafe.getObject(obj, j);
                    int i18 = zzea.zza;
                    int size3 = r0.size();
                    if (size3 == 0) {
                        r2 = z;
                    } else {
                        boolean z2 = r0 instanceof zzcv;
                        int iZzx11 = zzbp.zzx(i7 << 3) * size3;
                        if (z2) {
                            ?? r02 = (zzcv) r0;
                            r2 = iZzx11;
                            for (?? r3 = z; r3 < size3; r3++) {
                                Object objZzf = r02.zzf(r3);
                                if (objZzf instanceof zzbh) {
                                    int iZzd3 = ((zzbh) objZzf).zzd();
                                    iZzw2 = r2 + zzbp.zzx(iZzd3) + iZzd3;
                                } else {
                                    iZzw2 = r2 + zzbp.zzw((String) objZzf);
                                }
                                r2 = iZzw2;
                            }
                        } else {
                            r2 = iZzx11;
                            for (?? r32 = z; r32 < size3; r32++) {
                                Object obj2 = r0.get(r32);
                                if (obj2 instanceof zzbh) {
                                    int iZzd4 = ((zzbh) obj2).zzd();
                                    iZzw = r2 + zzbp.zzx(iZzd4) + iZzd4;
                                } else {
                                    iZzw = r2 + zzbp.zzw((String) obj2);
                                }
                                r2 = iZzw;
                            }
                        }
                    }
                    i5 += r2;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 27:
                    ?? r03 = (List) unsafe.getObject(obj, j);
                    zzdy zzdyVarZzv = zzv(i4);
                    int i19 = zzea.zza;
                    int size4 = r03.size();
                    if (size4 == 0) {
                        Zzx = z;
                    } else {
                        Zzx = zzbp.zzx(i7 << 3) * size4;
                        for (?? r42 = z; r42 < size4; r42++) {
                            Object obj3 = r03.get(r42);
                            if (obj3 instanceof zzct) {
                                int iZza = ((zzct) obj3).zza();
                                iZzv = (Zzx == true ? 1 : 0) + zzbp.zzx(iZza) + iZza;
                            } else {
                                iZzv = (Zzx == true ? 1 : 0) + zzbp.zzv((zzdn) obj3, zzdyVarZzv);
                            }
                            Zzx = iZzv;
                        }
                    }
                    i5 += Zzx;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 28:
                    ?? r04 = (List) unsafe.getObject(obj, j);
                    int i20 = zzea.zza;
                    int size5 = r04.size();
                    if (size5 == 0) {
                        Zzx2 = z;
                    } else {
                        Zzx2 = size5 * zzbp.zzx(i7 << 3);
                        for (?? r22 = z; r22 < r04.size(); r22++) {
                            int iZzd5 = ((zzbh) r04.get(r22)).zzd();
                            Zzx2 += zzbp.zzx(iZzd5) + iZzd5;
                        }
                    }
                    i5 += Zzx2;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i21 = zzea.zza;
                    size = list5.size();
                    if (size != 0) {
                        iZzl = zzea.zzk(list5);
                        iZzx8 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzl + (size * iZzx8);
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                    i5 += Zzx3;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i22 = zzea.zza;
                    size = list6.size();
                    if (size != 0) {
                        iZzl = zzea.zza(list6);
                        iZzx8 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzl + (size * iZzx8);
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                    i5 += Zzx3;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 31:
                    Zzx3 = zzea.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += Zzx3;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 32:
                    Zzx3 = zzea.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i5 += Zzx3;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zzea.zza;
                    size = list7.size();
                    if (size != 0) {
                        iZzl = zzea.zzi(list7);
                        iZzx8 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzl + (size * iZzx8);
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                    i5 += Zzx3;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zzea.zza;
                    size = list8.size();
                    if (size != 0) {
                        iZzl = zzea.zzj(list8);
                        iZzx8 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzl + (size * iZzx8);
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                    i5 += Zzx3;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 35:
                    iZzy = zzea.zze((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 36:
                    iZzy = zzea.zzc((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 37:
                    iZzy = zzea.zzg((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 38:
                    iZzy = zzea.zzl((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 39:
                    iZzy = zzea.zzf((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 40:
                    iZzy = zzea.zze((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 41:
                    iZzy = zzea.zzc((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zzea.zza;
                    iZzy = list9.size();
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 43:
                    iZzy = zzea.zzk((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 44:
                    iZzy = zzea.zza((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 45:
                    iZzy = zzea.zzc((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 46:
                    iZzy = zzea.zze((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 47:
                    iZzy = zzea.zzi((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 48:
                    iZzy = zzea.zzj((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        iZzx9 = zzbp.zzx(iZzy);
                        iZzx10 = zzbp.zzx(i7 << 3);
                        iZzx3 = iZzx10 + iZzx9;
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 49:
                    ?? r05 = (List) unsafe.getObject(obj, j);
                    zzdy zzdyVarZzv2 = zzv(i4);
                    int i26 = zzea.zza;
                    int size6 = r05.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z3 = z;
                        r4 = z3;
                        ?? r33 = z3;
                        while (r33 < size6) {
                            int iZzt = zzbp.zzt(i7, (zzdn) r05.get(r33), zzdyVarZzv2);
                            r33++;
                            r4 = (r4 == true ? 1 : 0) + iZzt;
                        }
                    }
                    i5 += r4;
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 50:
                    zzdh zzdhVar = (zzdh) unsafe.getObject(obj, j);
                    if (zzdhVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzdhVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
                case 51:
                    if (zzM(obj, i7, i4)) {
                        iZzx = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx + 8;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 52:
                    if (zzM(obj, i7, i4)) {
                        iZzx2 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx2 + 4;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 53:
                    if (zzM(obj, i7, i4)) {
                        iZzy = zzbp.zzy(zzt(obj, j));
                        iZzx3 = zzbp.zzx(i7 << 3);
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 54:
                    if (zzM(obj, i7, i4)) {
                        iZzy = zzbp.zzy(zzt(obj, j));
                        iZzx3 = zzbp.zzx(i7 << 3);
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 55:
                    if (zzM(obj, i7, i4)) {
                        iZzy = zzbp.zzu(zzo(obj, j));
                        iZzx3 = zzbp.zzx(i7 << 3);
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 56:
                    if (zzM(obj, i7, i4)) {
                        iZzx = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx + 8;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 57:
                    if (zzM(obj, i7, i4)) {
                        iZzx2 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx2 + 4;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 58:
                    if (zzM(obj, i7, i4)) {
                        iZzx4 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx4 + 1;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 59:
                    if (zzM(obj, i7, i4)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzbh) {
                            int i27 = zzbp.zzb;
                            int iZzd6 = ((zzbh) object2).zzd();
                            iZzx5 = zzbp.zzx(iZzd6) + iZzd6;
                            iZzx6 = zzbp.zzx(i7 << 3);
                            Zzx3 = iZzx6 + iZzx5;
                            i5 += Zzx3;
                            i4 += 3;
                            i6 = i;
                            r1 = i2;
                            z = false;
                            i3 = WinNT.NLS_VALID_LOCALE_MASK;
                        } else {
                            iZzy = zzbp.zzw((String) object2);
                            iZzx3 = zzbp.zzx(i7 << 3);
                            Zzx2 = iZzx3 + iZzy;
                            i5 += Zzx2;
                            i4 += 3;
                            i6 = i;
                            r1 = i2;
                            z = false;
                            i3 = WinNT.NLS_VALID_LOCALE_MASK;
                        }
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 60:
                    if (zzM(obj, i7, i4)) {
                        Zzx3 = zzea.zzh(i7, unsafe.getObject(obj, j), zzv(i4));
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 61:
                    if (zzM(obj, i7, i4)) {
                        zzbh zzbhVar2 = (zzbh) unsafe.getObject(obj, j);
                        int i28 = zzbp.zzb;
                        int iZzd7 = zzbhVar2.zzd();
                        iZzx5 = zzbp.zzx(iZzd7) + iZzd7;
                        iZzx6 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx6 + iZzx5;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 62:
                    if (zzM(obj, i7, i4)) {
                        iZzy = zzbp.zzx(zzo(obj, j));
                        iZzx3 = zzbp.zzx(i7 << 3);
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 63:
                    if (zzM(obj, i7, i4)) {
                        iZzy = zzbp.zzu(zzo(obj, j));
                        iZzx3 = zzbp.zzx(i7 << 3);
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 64:
                    if (zzM(obj, i7, i4)) {
                        iZzx2 = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx2 + 4;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 65:
                    if (zzM(obj, i7, i4)) {
                        iZzx = zzbp.zzx(i7 << 3);
                        Zzx3 = iZzx + 8;
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 66:
                    if (zzM(obj, i7, i4)) {
                        int iZzo = zzo(obj, j);
                        iZzx3 = zzbp.zzx(i7 << 3);
                        iZzy = zzbp.zzx((iZzo >> 31) ^ (iZzo + iZzo));
                        Zzx2 = iZzx3 + iZzy;
                        i5 += Zzx2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 67:
                    if (zzM(obj, i7, i4)) {
                        long jZzt = zzt(obj, j);
                        iZzx7 = zzbp.zzx(i7 << 3);
                        iZzy2 = zzbp.zzy((jZzt >> 63) ^ (jZzt + jZzt));
                        r2 = iZzx7 + iZzy2;
                        i5 += r2;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                case 68:
                    if (zzM(obj, i7, i4)) {
                        Zzx3 = zzbp.zzt(i7, (zzdn) unsafe.getObject(obj, j), zzv(i4));
                        i5 += Zzx3;
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    } else {
                        i4 += 3;
                        i6 = i;
                        r1 = i2;
                        z = false;
                        i3 = WinNT.NLS_VALID_LOCALE_MASK;
                    }
                default:
                    i4 += 3;
                    i6 = i;
                    r1 = i2;
                    z = false;
                    i3 = WinNT.NLS_VALID_LOCALE_MASK;
            }
        }
        zzep zzepVar = this.zzm;
        int iZza2 = i5 + zzepVar.zza(zzepVar.zzd(obj));
        if (!this.zzh) {
            return iZza2;
        }
        this.zzn.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzs = zzs(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzs;
            int iHashCode = 37;
            switch (zzr(iZzs)) {
                case 0:
                    i = i2 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzez.zza(obj, j));
                    byte[] bArr = zzco.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i2 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzez.zzb(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i2 * 53;
                    jDoubleToLongBits = zzez.zzd(obj, j);
                    byte[] bArr2 = zzco.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i2 * 53;
                    jDoubleToLongBits = zzez.zzd(obj, j);
                    byte[] bArr3 = zzco.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i2 * 53;
                    iFloatToIntBits = zzez.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i2 * 53;
                    jDoubleToLongBits = zzez.zzd(obj, j);
                    byte[] bArr4 = zzco.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i2 * 53;
                    iFloatToIntBits = zzez.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i2 * 53;
                    iFloatToIntBits = zzco.zza(zzez.zzw(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i2 * 53;
                    iFloatToIntBits = ((String) zzez.zzf(obj, j)).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 9:
                    Object objZzf = zzez.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iFloatToIntBits = zzez.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i2 * 53;
                    iFloatToIntBits = zzez.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i2 * 53;
                    iFloatToIntBits = zzez.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i2 * 53;
                    iFloatToIntBits = zzez.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i2 * 53;
                    jDoubleToLongBits = zzez.zzd(obj, j);
                    byte[] bArr5 = zzco.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i2 * 53;
                    iFloatToIntBits = zzez.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i2 * 53;
                    jDoubleToLongBits = zzez.zzd(obj, j);
                    byte[] bArr6 = zzco.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 17:
                    Object objZzf2 = zzez.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
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
                    iFloatToIntBits = zzez.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i2 * 53;
                    iFloatToIntBits = zzez.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzco.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzco.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzco.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzco.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzco.zza(zzN(obj, j));
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = ((String) zzez.zzf(obj, j)).hashCode();
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzez.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzez.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzco.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzco.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzez.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzm.zzd(obj).hashCode();
        if (!this.zzh) {
            return iHashCode2;
        }
        this.zzn.zza(obj);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:555:0x0d15, code lost:
    
        if (r6 == 1048575) goto L557;
     */
    /* JADX WARN: Code restructure failed: missing block: B:556:0x0d17, code lost:
    
        r13.putInt(r7, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:557:0x0d1b, code lost:
    
        r2 = r0.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:559:0x0d1f, code lost:
    
        if (r2 >= r0.zzk) goto L675;
     */
    /* JADX WARN: Code restructure failed: missing block: B:560:0x0d21, code lost:
    
        r3 = r0.zzi[r2];
        r5 = r0.zzc[r3];
        r5 = com.google.android.gms.internal.wearable.zzez.zzf(r7, r0.zzs(r3) & com.sun.jna.platform.win32.WinNT.NLS_VALID_LOCALE_MASK);
     */
    /* JADX WARN: Code restructure failed: missing block: B:561:0x0d36, code lost:
    
        if (r5 != null) goto L563;
     */
    /* JADX WARN: Code restructure failed: missing block: B:564:0x0d3d, code lost:
    
        if (r0.zzu(r3) != null) goto L674;
     */
    /* JADX WARN: Code restructure failed: missing block: B:565:0x0d3f, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:566:0x0d42, code lost:
    
        r5 = (com.google.android.gms.internal.wearable.zzdh) r5;
        r1 = (com.google.android.gms.internal.wearable.zzdg) r0.zzw(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:567:0x0d4a, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:568:0x0d4b, code lost:
    
        if (r8 != 0) goto L573;
     */
    /* JADX WARN: Code restructure failed: missing block: B:569:0x0d4d, code lost:
    
        if (r1 != r9) goto L571;
     */
    /* JADX WARN: Code restructure failed: missing block: B:572:0x0d54, code lost:
    
        throw com.google.android.gms.internal.wearable.zzcq.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:573:0x0d55, code lost:
    
        if (r1 > r9) goto L576;
     */
    /* JADX WARN: Code restructure failed: missing block: B:574:0x0d57, code lost:
    
        if (r4 != r8) goto L576;
     */
    /* JADX WARN: Code restructure failed: missing block: B:575:0x0d59, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:577:0x0d5e, code lost:
    
        throw com.google.android.gms.internal.wearable.zzcq.zze();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x099d A[PHI: r0 r7 r8 r9 r10 r11 r14 r25
      0x099d: PHI (r0v31 com.google.android.gms.internal.wearable.zzdq<T>) = 
      (r0v1 com.google.android.gms.internal.wearable.zzdq<T>)
      (r0v1 com.google.android.gms.internal.wearable.zzdq<T>)
      (r0v1 com.google.android.gms.internal.wearable.zzdq<T>)
      (r0v7 com.google.android.gms.internal.wearable.zzdq<T>)
      (r0v29 com.google.android.gms.internal.wearable.zzdq<T>)
      (r0v1 com.google.android.gms.internal.wearable.zzdq<T>)
      (r0v1 com.google.android.gms.internal.wearable.zzdq<T>)
     binds: [B:438:0x0956, B:422:0x08fd, B:406:0x08ab, B:280:0x0683, B:330:0x0754, B:199:0x04cc, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x099d: PHI (r7v30 int) = (r7v7 int), (r7v8 int), (r7v9 int), (r7v18 int), (r7v23 int), (r7v28 int), (r7v34 int) binds: [B:438:0x0956, B:422:0x08fd, B:406:0x08ab, B:280:0x0683, B:330:0x0754, B:199:0x04cc, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x099d: PHI (r8v99 sun.misc.Unsafe) = 
      (r8v48 sun.misc.Unsafe)
      (r8v49 sun.misc.Unsafe)
      (r8v50 sun.misc.Unsafe)
      (r8v86 sun.misc.Unsafe)
      (r8v93 sun.misc.Unsafe)
      (r8v97 sun.misc.Unsafe)
      (r8v102 sun.misc.Unsafe)
     binds: [B:438:0x0956, B:422:0x08fd, B:406:0x08ab, B:280:0x0683, B:330:0x0754, B:199:0x04cc, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x099d: PHI (r9v80 int) = (r9v41 int), (r9v42 int), (r9v43 int), (r9v65 int), (r9v73 int), (r9v78 int), (r9v82 int) binds: [B:438:0x0956, B:422:0x08fd, B:406:0x08ab, B:280:0x0683, B:330:0x0754, B:199:0x04cc, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x099d: PHI (r10v74 int) = (r10v41 int), (r10v42 int), (r10v43 int), (r10v64 int), (r10v67 int), (r10v72 int), (r10v77 int) binds: [B:438:0x0956, B:422:0x08fd, B:406:0x08ab, B:280:0x0683, B:330:0x0754, B:199:0x04cc, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x099d: PHI (r11v42 int) = (r11v15 int), (r11v16 int), (r11v17 int), (r11v28 int), (r11v35 int), (r11v40 int), (r11v45 int) binds: [B:438:0x0956, B:422:0x08fd, B:406:0x08ab, B:280:0x0683, B:330:0x0754, B:199:0x04cc, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x099d: PHI (r14v39 int) = (r14v17 int), (r14v18 int), (r14v19 int), (r14v27 int), (r14v31 int), (r14v35 int), (r14v41 int) binds: [B:438:0x0956, B:422:0x08fd, B:406:0x08ab, B:280:0x0683, B:330:0x0754, B:199:0x04cc, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]
      0x099d: PHI (r25v38 int) = (r25v13 int), (r25v14 int), (r25v15 int), (r25v24 int), (r25v31 int), (r25v36 int), (r25v40 int) binds: [B:438:0x0956, B:422:0x08fd, B:406:0x08ab, B:280:0x0683, B:330:0x0754, B:199:0x04cc, B:181:0x044b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:535:0x0c8c A[PHI: r1 r5 r6 r7 r8 r17 r20 r26
      0x0c8c: PHI (r1v181 int) = 
      (r1v162 int)
      (r1v163 int)
      (r1v164 int)
      (r1v165 int)
      (r1v166 int)
      (r1v167 int)
      (r1v169 int)
      (r1v172 int)
      (r1v176 int)
      (r1v182 int)
     binds: [B:533:0x0c75, B:530:0x0c4f, B:527:0x0c2d, B:524:0x0c0b, B:521:0x0be9, B:518:0x0bc6, B:516:0x0bb4, B:492:0x0b31, B:488:0x0af0, B:465:0x0a18] A[DONT_GENERATE, DONT_INLINE]
      0x0c8c: PHI (r5v103 com.google.android.gms.internal.wearable.zzau) = 
      (r5v86 com.google.android.gms.internal.wearable.zzau)
      (r5v87 com.google.android.gms.internal.wearable.zzau)
      (r5v88 com.google.android.gms.internal.wearable.zzau)
      (r5v89 com.google.android.gms.internal.wearable.zzau)
      (r5v90 com.google.android.gms.internal.wearable.zzau)
      (r5v91 com.google.android.gms.internal.wearable.zzau)
      (r5v93 com.google.android.gms.internal.wearable.zzau)
      (r5v95 com.google.android.gms.internal.wearable.zzau)
      (r5v98 com.google.android.gms.internal.wearable.zzau)
      (r5v104 com.google.android.gms.internal.wearable.zzau)
     binds: [B:533:0x0c75, B:530:0x0c4f, B:527:0x0c2d, B:524:0x0c0b, B:521:0x0be9, B:518:0x0bc6, B:516:0x0bb4, B:492:0x0b31, B:488:0x0af0, B:465:0x0a18] A[DONT_GENERATE, DONT_INLINE]
      0x0c8c: PHI (r6v74 int) = 
      (r6v49 int)
      (r6v50 int)
      (r6v51 int)
      (r6v52 int)
      (r6v53 int)
      (r6v54 int)
      (r6v56 int)
      (r6v59 int)
      (r6v66 int)
      (r6v75 int)
     binds: [B:533:0x0c75, B:530:0x0c4f, B:527:0x0c2d, B:524:0x0c0b, B:521:0x0be9, B:518:0x0bc6, B:516:0x0bb4, B:492:0x0b31, B:488:0x0af0, B:465:0x0a18] A[DONT_GENERATE, DONT_INLINE]
      0x0c8c: PHI (r7v57 java.lang.Object) = 
      (r7v39 java.lang.Object)
      (r7v40 java.lang.Object)
      (r7v41 java.lang.Object)
      (r7v42 java.lang.Object)
      (r7v43 java.lang.Object)
      (r7v44 java.lang.Object)
      (r7v46 java.lang.Object)
      (r7v48 java.lang.Object)
      (r7v52 java.lang.Object)
      (r7v58 java.lang.Object)
     binds: [B:533:0x0c75, B:530:0x0c4f, B:527:0x0c2d, B:524:0x0c0b, B:521:0x0be9, B:518:0x0bc6, B:516:0x0bb4, B:492:0x0b31, B:488:0x0af0, B:465:0x0a18] A[DONT_GENERATE, DONT_INLINE]
      0x0c8c: PHI (r8v139 int) = 
      (r8v104 int)
      (r8v105 int)
      (r8v106 int)
      (r8v107 int)
      (r8v108 int)
      (r8v109 int)
      (r8v111 int)
      (r8v118 int)
      (r8v129 int)
      (r8v140 int)
     binds: [B:533:0x0c75, B:530:0x0c4f, B:527:0x0c2d, B:524:0x0c0b, B:521:0x0be9, B:518:0x0bc6, B:516:0x0bb4, B:492:0x0b31, B:488:0x0af0, B:465:0x0a18] A[DONT_GENERATE, DONT_INLINE]
      0x0c8c: PHI (r17v25 int) = 
      (r17v10 int)
      (r17v11 int)
      (r17v12 int)
      (r17v13 int)
      (r17v14 int)
      (r17v15 int)
      (r17v17 int)
      (r17v19 int)
      (r17v21 int)
      (r17v26 int)
     binds: [B:533:0x0c75, B:530:0x0c4f, B:527:0x0c2d, B:524:0x0c0b, B:521:0x0be9, B:518:0x0bc6, B:516:0x0bb4, B:492:0x0b31, B:488:0x0af0, B:465:0x0a18] A[DONT_GENERATE, DONT_INLINE]
      0x0c8c: PHI (r20v27 int) = 
      (r20v11 int)
      (r20v12 int)
      (r20v13 int)
      (r20v14 int)
      (r20v15 int)
      (r20v16 int)
      (r20v18 int)
      (r20v21 int)
      (r20v23 int)
      (r20v28 int)
     binds: [B:533:0x0c75, B:530:0x0c4f, B:527:0x0c2d, B:524:0x0c0b, B:521:0x0be9, B:518:0x0bc6, B:516:0x0bb4, B:492:0x0b31, B:488:0x0af0, B:465:0x0a18] A[DONT_GENERATE, DONT_INLINE]
      0x0c8c: PHI (r26v14 sun.misc.Unsafe) = 
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v10 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
      (r26v9 sun.misc.Unsafe)
     binds: [B:533:0x0c75, B:530:0x0c4f, B:527:0x0c2d, B:524:0x0c0b, B:521:0x0be9, B:518:0x0bc6, B:516:0x0bb4, B:492:0x0b31, B:488:0x0af0, B:465:0x0a18] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:551:0x0ce7  */
    /* JADX WARN: Removed duplicated region for block: B:615:0x09a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:618:0x0c8f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:621:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:662:0x09b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:663:0x0ca6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zzc(java.lang.Object r40, byte[] r41, int r42, int r43, int r44, com.google.android.gms.internal.wearable.zzau r45) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.wearable.zzdq.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.wearable.zzau):int");
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final Object zze() {
        return ((zzcg) this.zzg).zzP();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    @Override // com.google.android.gms.internal.wearable.zzdy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzf(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = zzL(r8)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8 instanceof com.google.android.gms.internal.wearable.zzcg
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r8
            com.google.android.gms.internal.wearable.zzcg r0 = (com.google.android.gms.internal.wearable.zzcg) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.zzac(r2)
            r0.zza = r1
            r0.zzaa()
        L1a:
            int[] r0 = r7.zzc
            int r0 = r0.length
        L1d:
            if (r1 >= r0) goto L82
            int r2 = r7.zzs(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            int r2 = zzr(r2)
            long r3 = (long) r3
            r5 = 9
            if (r2 == r5) goto L6c
            r5 = 60
            if (r2 == r5) goto L54
            r5 = 68
            if (r2 == r5) goto L54
            switch(r2) {
                case 17: goto L6c;
                case 18: goto L4e;
                case 19: goto L4e;
                case 20: goto L4e;
                case 21: goto L4e;
                case 22: goto L4e;
                case 23: goto L4e;
                case 24: goto L4e;
                case 25: goto L4e;
                case 26: goto L4e;
                case 27: goto L4e;
                case 28: goto L4e;
                case 29: goto L4e;
                case 30: goto L4e;
                case 31: goto L4e;
                case 32: goto L4e;
                case 33: goto L4e;
                case 34: goto L4e;
                case 35: goto L4e;
                case 36: goto L4e;
                case 37: goto L4e;
                case 38: goto L4e;
                case 39: goto L4e;
                case 40: goto L4e;
                case 41: goto L4e;
                case 42: goto L4e;
                case 43: goto L4e;
                case 44: goto L4e;
                case 45: goto L4e;
                case 46: goto L4e;
                case 47: goto L4e;
                case 48: goto L4e;
                case 49: goto L4e;
                case 50: goto L3c;
                default: goto L3b;
            }
        L3b:
            goto L7f
        L3c:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.wearable.zzdq.zzb
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L7f
            r6 = r5
            com.google.android.gms.internal.wearable.zzdh r6 = (com.google.android.gms.internal.wearable.zzdh) r6
            r6.zzc()
            r2.putObject(r8, r3, r5)
            goto L7f
        L4e:
            com.google.android.gms.internal.wearable.zzdb r2 = r7.zzl
            r2.zza(r8, r3)
            goto L7f
        L54:
            int[] r2 = r7.zzc
            r2 = r2[r1]
            boolean r2 = r7.zzM(r8, r2, r1)
            if (r2 == 0) goto L7f
            com.google.android.gms.internal.wearable.zzdy r2 = r7.zzv(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.wearable.zzdq.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzf(r3)
            goto L7f
        L6c:
            boolean r2 = r7.zzI(r8, r1)
            if (r2 == 0) goto L7f
            com.google.android.gms.internal.wearable.zzdy r2 = r7.zzv(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.wearable.zzdq.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzf(r3)
        L7f:
            int r1 = r1 + 3
            goto L1d
        L82:
            com.google.android.gms.internal.wearable.zzep r0 = r7.zzm
            r0.zzg(r8)
            boolean r0 = r7.zzh
            if (r0 == 0) goto L90
            com.google.android.gms.internal.wearable.zzbv r0 = r7.zzn
            r0.zzb(r8)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.wearable.zzdq.zzf(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            int i2 = this.zzc[i];
            long j = 1048575 & iZzs;
            switch (zzr(iZzs)) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzez.zzo(obj, j, zzez.zza(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzI(obj2, i)) {
                        zzez.zzp(obj, j, zzez.zzb(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzI(obj2, i)) {
                        zzez.zzr(obj, j, zzez.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzI(obj2, i)) {
                        zzez.zzr(obj, j, zzez.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzI(obj2, i)) {
                        zzez.zzq(obj, j, zzez.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzI(obj2, i)) {
                        zzez.zzr(obj, j, zzez.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzI(obj2, i)) {
                        zzez.zzq(obj, j, zzez.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzI(obj2, i)) {
                        zzez.zzm(obj, j, zzez.zzw(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzI(obj2, i)) {
                        zzez.zzs(obj, j, zzez.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzez.zzs(obj, j, zzez.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzI(obj2, i)) {
                        zzez.zzq(obj, j, zzez.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzI(obj2, i)) {
                        zzez.zzq(obj, j, zzez.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzI(obj2, i)) {
                        zzez.zzq(obj, j, zzez.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzI(obj2, i)) {
                        zzez.zzr(obj, j, zzez.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzI(obj2, i)) {
                        zzez.zzq(obj, j, zzez.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzI(obj2, i)) {
                        zzez.zzr(obj, j, zzez.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i);
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
                    this.zzl.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i3 = zzea.zza;
                    zzez.zzs(obj, j, zzdi.zza(zzez.zzf(obj, j), zzez.zzf(obj2, j)));
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
                    if (zzM(obj2, i2, i)) {
                        zzez.zzs(obj, j, zzez.zzf(obj2, j));
                        zzE(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i2, i)) {
                        zzez.zzs(obj, j, zzez.zzf(obj2, j));
                        zzE(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzea.zzp(this.zzm, obj, obj2);
        if (this.zzh) {
            this.zzn.zza(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzau zzauVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzauVar);
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final void zzi(Object obj, zzfh zzfhVar) throws IOException {
        int i;
        int i2;
        int i3;
        if (this.zzh) {
            this.zzn.zza(obj);
            throw null;
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i4 = WinNT.NLS_VALID_LOCALE_MASK;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < length) {
            int iZzs = zzs(i7);
            int[] iArr = this.zzc;
            int i8 = iArr[i7];
            int iZzr = zzr(iZzs);
            if (iZzr <= 17) {
                int i9 = iArr[i7 + 2];
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i6 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i = i5;
                i2 = i6;
                i3 = 1 << (i9 >>> 20);
            } else {
                i = i5;
                i2 = i6;
                i3 = 0;
            }
            long j = iZzs & i4;
            switch (iZzr) {
                case 0:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzf(i8, zzez.zza(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzo(i8, zzez.zzb(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzt(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzJ(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzr(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzm(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzk(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzb(i8, zzez.zzw(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzO(i8, unsafe.getObject(obj, j), zzfhVar);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzv(i8, unsafe.getObject(obj, j), zzv(i7));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzd(i8, (zzbh) unsafe.getObject(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzH(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzi(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzw(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzy(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzA(i8, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzC(i8, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzJ(obj, i7, i, i2, i3)) {
                        zzfhVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzea.zzs(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 19:
                    zzea.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 20:
                    zzea.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 21:
                    zzea.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 22:
                    zzea.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 23:
                    zzea.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 24:
                    zzea.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 25:
                    zzea.zzr(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 26:
                    int i11 = this.zzc[i7];
                    List list = (List) unsafe.getObject(obj, j);
                    int i12 = zzea.zza;
                    if (list != null && !list.isEmpty()) {
                        zzfhVar.zzG(i11, list);
                        break;
                    } else {
                        break;
                    }
                case 27:
                    int i13 = this.zzc[i7];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzdy zzdyVarZzv = zzv(i7);
                    int i14 = zzea.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15++) {
                            ((zzbq) zzfhVar).zzv(i13, list2.get(i15), zzdyVarZzv);
                        }
                        break;
                    } else {
                        break;
                    }
                    break;
                case 28:
                    int i16 = this.zzc[i7];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i17 = zzea.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzfhVar.zze(i16, list3);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 29:
                    zzea.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 30:
                    zzea.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 31:
                    zzea.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 32:
                    zzea.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 33:
                    zzea.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 34:
                    zzea.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, false);
                    break;
                case 35:
                    zzea.zzs(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 36:
                    zzea.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 37:
                    zzea.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 38:
                    zzea.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 39:
                    zzea.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 40:
                    zzea.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 41:
                    zzea.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 42:
                    zzea.zzr(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 43:
                    zzea.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 44:
                    zzea.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 45:
                    zzea.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 46:
                    zzea.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 47:
                    zzea.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 48:
                    zzea.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzfhVar, true);
                    break;
                case 49:
                    int i18 = this.zzc[i7];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzdy zzdyVarZzv2 = zzv(i7);
                    int i19 = zzea.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            ((zzbq) zzfhVar).zzq(i18, list4.get(i20), zzdyVarZzv2);
                        }
                        break;
                    } else {
                        break;
                    }
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    break;
                case 51:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzf(i8, zzm(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzo(i8, zzn(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzt(i8, zzt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzJ(i8, zzt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzr(i8, zzo(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzm(i8, zzt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzk(i8, zzo(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzb(i8, zzN(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i8, i7)) {
                        zzO(i8, unsafe.getObject(obj, j), zzfhVar);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzv(i8, unsafe.getObject(obj, j), zzv(i7));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzd(i8, (zzbh) unsafe.getObject(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzH(i8, zzo(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzi(i8, zzo(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzw(i8, zzo(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzy(i8, zzt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzA(i8, zzo(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzC(i8, zzt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i8, i7)) {
                        zzfhVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
                        break;
                    } else {
                        break;
                    }
            }
            i7 += 3;
            i5 = i;
            i6 = i2;
            i4 = WinNT.NLS_VALID_LOCALE_MASK;
        }
        zzep zzepVar = this.zzm;
        zzepVar.zzi(zzepVar.zzd(obj), zzfhVar);
    }

    @Override // com.google.android.gms.internal.wearable.zzdy
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzF;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzs = zzs(i);
            long j = iZzs & WinNT.NLS_VALID_LOCALE_MASK;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzez.zza(obj, j)) != Double.doubleToLongBits(zzez.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzez.zzb(obj, j)) != Float.floatToIntBits(zzez.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i) || zzez.zzd(obj, j) != zzez.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i) || zzez.zzd(obj, j) != zzez.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i) || zzez.zzc(obj, j) != zzez.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i) || zzez.zzd(obj, j) != zzez.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i) || zzez.zzc(obj, j) != zzez.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i) || zzez.zzw(obj, j) != zzez.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i) || !zzea.zzF(zzez.zzf(obj, j), zzez.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i) || !zzea.zzF(zzez.zzf(obj, j), zzez.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i) || !zzea.zzF(zzez.zzf(obj, j), zzez.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i) || zzez.zzc(obj, j) != zzez.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i) || zzez.zzc(obj, j) != zzez.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i) || zzez.zzc(obj, j) != zzez.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i) || zzez.zzd(obj, j) != zzez.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i) || zzez.zzc(obj, j) != zzez.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i) || zzez.zzd(obj, j) != zzez.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i) || !zzea.zzF(zzez.zzf(obj, j), zzez.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
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
                    zZzF = zzea.zzF(zzez.zzf(obj, j), zzez.zzf(obj2, j));
                    break;
                case 50:
                    zZzF = zzea.zzF(zzez.zzf(obj, j), zzez.zzf(obj2, j));
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
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzp = zzp(i) & WinNT.NLS_VALID_LOCALE_MASK;
                    if (zzez.zzc(obj, jZzp) != zzez.zzc(obj2, jZzp) || !zzea.zzF(zzez.zzf(obj, j), zzez.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!zZzF) {
                return false;
            }
        }
        if (!this.zzm.zzd(obj).equals(this.zzm.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzn.zza(obj);
        this.zzn.zza(obj2);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009e  */
    @Override // com.google.android.gms.internal.wearable.zzdy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzk(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.wearable.zzdq.zzk(java.lang.Object):boolean");
    }
}
