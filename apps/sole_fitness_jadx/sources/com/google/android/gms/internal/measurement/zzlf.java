package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzlf<T> implements zzln<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzml.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlc zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzkq zzm;
    private final zzmb<?, ?> zzn;
    private final zzjk<?> zzo;
    private final zzlh zzp;
    private final zzkx zzq;

    /* JADX WARN: Multi-variable type inference failed */
    private zzlf(int[] iArr, int[] iArr2, Object[] objArr, int i, int i2, zzlc zzlcVar, boolean z, boolean z2, int[] iArr3, int i3, int i4, zzlh zzlhVar, zzkq zzkqVar, zzmb<?, ?> zzmbVar, zzjk<?> zzjkVar, zzkx zzkxVar) {
        this.zzc = iArr;
        this.zzd = iArr2;
        this.zze = objArr;
        this.zzf = i;
        this.zzi = zzlcVar;
        boolean z3 = false;
        if (zzmbVar != 0 && zzmbVar.zzc((zzlc) i2)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = z2;
        this.zzk = iArr3;
        this.zzl = i3;
        this.zzp = i4;
        this.zzm = zzlhVar;
        this.zzn = zzkqVar;
        this.zzo = zzmbVar;
        this.zzg = i2;
        this.zzq = zzjkVar;
    }

    private static int zzA(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzB(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzC(T t, long j) {
        return ((Long) zzml.zzf(t, j)).longValue();
    }

    private final zzkb zzD(int i) {
        int i2 = i / 3;
        return (zzkb) this.zzd[i2 + i2 + 1];
    }

    private final zzln zzE(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzln zzlnVar = (zzln) this.zzd[i3];
        if (zzlnVar != null) {
            return zzlnVar;
        }
        zzln<T> zzlnVarZzb = zzlk.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzlnVarZzb;
        return zzlnVarZzb;
    }

    private final Object zzF(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzG(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzH(T t, T t2, int i) {
        long jZzB = zzB(i) & 1048575;
        if (zzM(t2, i)) {
            Object objZzf = zzml.zzf(t, jZzB);
            Object objZzf2 = zzml.zzf(t2, jZzB);
            if (objZzf != null && objZzf2 != null) {
                zzml.zzs(t, jZzB, zzkf.zzg(objZzf, objZzf2));
                zzJ(t, i);
            } else if (objZzf2 != null) {
                zzml.zzs(t, jZzB, objZzf2);
                zzJ(t, i);
            }
        }
    }

    private final void zzI(T t, T t2, int i) {
        int iZzB = zzB(i);
        int i2 = this.zzc[i];
        long j = iZzB & 1048575;
        if (zzP(t2, i2, i)) {
            Object objZzf = zzP(t, i2, i) ? zzml.zzf(t, j) : null;
            Object objZzf2 = zzml.zzf(t2, j);
            if (objZzf != null && objZzf2 != null) {
                zzml.zzs(t, j, zzkf.zzg(objZzf, objZzf2));
                zzK(t, i2, i);
            } else if (objZzf2 != null) {
                zzml.zzs(t, j, objZzf2);
                zzK(t, i2, i);
            }
        }
    }

    private final void zzJ(T t, int i) {
        int iZzy = zzy(i);
        long j = 1048575 & iZzy;
        if (j == 1048575) {
            return;
        }
        zzml.zzq(t, j, (1 << (iZzy >>> 20)) | zzml.zzc(t, j));
    }

    private final void zzK(T t, int i, int i2) {
        zzml.zzq(t, zzy(i2) & 1048575, i);
    }

    private final boolean zzL(T t, T t2, int i) {
        return zzM(t, i) == zzM(t2, i);
    }

    private final boolean zzM(T t, int i) {
        int iZzy = zzy(i);
        long j = iZzy & 1048575;
        if (j != 1048575) {
            return (zzml.zzc(t, j) & (1 << (iZzy >>> 20))) != 0;
        }
        int iZzB = zzB(i);
        long j2 = iZzB & 1048575;
        switch (zzA(iZzB)) {
            case 0:
                return Double.doubleToRawLongBits(zzml.zza(t, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzml.zzb(t, j2)) != 0;
            case 2:
                return zzml.zzd(t, j2) != 0;
            case 3:
                return zzml.zzd(t, j2) != 0;
            case 4:
                return zzml.zzc(t, j2) != 0;
            case 5:
                return zzml.zzd(t, j2) != 0;
            case 6:
                return zzml.zzc(t, j2) != 0;
            case 7:
                return zzml.zzw(t, j2);
            case 8:
                Object objZzf = zzml.zzf(t, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzix) {
                    return !zzix.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzml.zzf(t, j2) != null;
            case 10:
                return !zzix.zzb.equals(zzml.zzf(t, j2));
            case 11:
                return zzml.zzc(t, j2) != 0;
            case 12:
                return zzml.zzc(t, j2) != 0;
            case 13:
                return zzml.zzc(t, j2) != 0;
            case 14:
                return zzml.zzd(t, j2) != 0;
            case 15:
                return zzml.zzc(t, j2) != 0;
            case 16:
                return zzml.zzd(t, j2) != 0;
            case 17:
                return zzml.zzf(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzN(T t, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzM(t, i) : (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zzO(Object obj, int i, zzln zzlnVar) {
        return zzlnVar.zzj(zzml.zzf(obj, i & 1048575));
    }

    private final boolean zzP(T t, int i, int i2) {
        return zzml.zzc(t, (long) (zzy(i2) & 1048575)) == i;
    }

    private static <T> boolean zzQ(T t, long j) {
        return ((Boolean) zzml.zzf(t, j)).booleanValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final void zzR(T t, zzjf zzjfVar) throws IOException {
        int i;
        boolean z;
        if (this.zzh) {
            this.zzo.zza(t);
            throw null;
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int iZzB = zzB(i4);
            int i6 = this.zzc[i4];
            int iZzA = zzA(iZzB);
            if (iZzA <= 17) {
                int i7 = this.zzc[i4 + 2];
                int i8 = i7 & i2;
                if (i8 != i3) {
                    i5 = unsafe.getInt(t, i8);
                    i3 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            long j = iZzB & i2;
            switch (iZzA) {
                case 0:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzf(i6, zzml.zza(t, j));
                        break;
                    }
                case 1:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzo(i6, zzml.zzb(t, j));
                        break;
                    }
                case 2:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzt(i6, unsafe.getLong(t, j));
                        break;
                    }
                case 3:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzJ(i6, unsafe.getLong(t, j));
                        break;
                    }
                case 4:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzr(i6, unsafe.getInt(t, j));
                        break;
                    }
                case 5:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzm(i6, unsafe.getLong(t, j));
                        break;
                    }
                case 6:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzk(i6, unsafe.getInt(t, j));
                        break;
                    }
                case 7:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzb(i6, zzml.zzw(t, j));
                        break;
                    }
                case 8:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzT(i6, unsafe.getObject(t, j), zzjfVar);
                        break;
                    }
                case 9:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzv(i6, unsafe.getObject(t, j), zzE(i4));
                        break;
                    }
                case 10:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzd(i6, (zzix) unsafe.getObject(t, j));
                        break;
                    }
                case 11:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzH(i6, unsafe.getInt(t, j));
                        break;
                    }
                case 12:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzi(i6, unsafe.getInt(t, j));
                        break;
                    }
                case 13:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzw(i6, unsafe.getInt(t, j));
                        break;
                    }
                case 14:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzy(i6, unsafe.getLong(t, j));
                        break;
                    }
                case 15:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzA(i6, unsafe.getInt(t, j));
                        break;
                    }
                case 16:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzC(i6, unsafe.getLong(t, j));
                        break;
                    }
                case 17:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        zzjfVar.zzq(i6, unsafe.getObject(t, j), zzE(i4));
                        break;
                    }
                case 18:
                    zzlp.zzL(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 19:
                    zzlp.zzP(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 20:
                    zzlp.zzS(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 21:
                    zzlp.zzaa(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 22:
                    zzlp.zzR(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 23:
                    zzlp.zzO(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 24:
                    zzlp.zzN(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 25:
                    zzlp.zzJ(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 26:
                    zzlp.zzY(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar);
                    break;
                case 27:
                    zzlp.zzT(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, zzE(i4));
                    break;
                case 28:
                    zzlp.zzK(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar);
                    break;
                case 29:
                    z = false;
                    zzlp.zzZ(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 30:
                    z = false;
                    zzlp.zzM(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 31:
                    z = false;
                    zzlp.zzU(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 32:
                    z = false;
                    zzlp.zzV(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 33:
                    z = false;
                    zzlp.zzW(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 34:
                    z = false;
                    zzlp.zzX(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, false);
                    break;
                case 35:
                    zzlp.zzL(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 36:
                    zzlp.zzP(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 37:
                    zzlp.zzS(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 38:
                    zzlp.zzaa(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 39:
                    zzlp.zzR(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 40:
                    zzlp.zzO(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 41:
                    zzlp.zzN(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 42:
                    zzlp.zzJ(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 43:
                    zzlp.zzZ(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 44:
                    zzlp.zzM(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 45:
                    zzlp.zzU(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 46:
                    zzlp.zzV(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 47:
                    zzlp.zzW(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 48:
                    zzlp.zzX(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, true);
                    break;
                case 49:
                    zzlp.zzQ(this.zzc[i4], (List) unsafe.getObject(t, j), zzjfVar, zzE(i4));
                    break;
                case 50:
                    zzS(zzjfVar, i6, unsafe.getObject(t, j), i4);
                    break;
                case 51:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzf(i6, zzn(t, j));
                    }
                    break;
                case 52:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzo(i6, zzo(t, j));
                    }
                    break;
                case 53:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzt(i6, zzC(t, j));
                    }
                    break;
                case 54:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzJ(i6, zzC(t, j));
                    }
                    break;
                case 55:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzr(i6, zzr(t, j));
                    }
                    break;
                case 56:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzm(i6, zzC(t, j));
                    }
                    break;
                case 57:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzk(i6, zzr(t, j));
                    }
                    break;
                case 58:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzb(i6, zzQ(t, j));
                    }
                    break;
                case 59:
                    if (zzP(t, i6, i4)) {
                        zzT(i6, unsafe.getObject(t, j), zzjfVar);
                    }
                    break;
                case 60:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzv(i6, unsafe.getObject(t, j), zzE(i4));
                    }
                    break;
                case 61:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzd(i6, (zzix) unsafe.getObject(t, j));
                    }
                    break;
                case 62:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzH(i6, zzr(t, j));
                    }
                    break;
                case 63:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzi(i6, zzr(t, j));
                    }
                    break;
                case 64:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzw(i6, zzr(t, j));
                    }
                    break;
                case 65:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzy(i6, zzC(t, j));
                    }
                    break;
                case 66:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzA(i6, zzr(t, j));
                    }
                    break;
                case 67:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzC(i6, zzC(t, j));
                    }
                    break;
                case 68:
                    if (zzP(t, i6, i4)) {
                        zzjfVar.zzq(i6, unsafe.getObject(t, j), zzE(i4));
                    }
                    break;
            }
            i4 += 3;
            i2 = 1048575;
        }
        zzmb<?, ?> zzmbVar = this.zzn;
        zzmbVar.zzi(zzmbVar.zzc(t), zzjfVar);
    }

    private final <K, V> void zzS(zzjf zzjfVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private static final void zzT(int i, Object obj, zzjf zzjfVar) throws IOException {
        if (obj instanceof String) {
            zzjfVar.zzF(i, (String) obj);
        } else {
            zzjfVar.zzd(i, (zzix) obj);
        }
    }

    static zzmc zzd(Object obj) {
        zzjx zzjxVar = (zzjx) obj;
        zzmc zzmcVar = zzjxVar.zzc;
        if (zzmcVar != zzmc.zzc()) {
            return zzmcVar;
        }
        zzmc zzmcVarZze = zzmc.zze();
        zzjxVar.zzc = zzmcVarZze;
        return zzmcVarZze;
    }

    static <T> zzlf<T> zzk(Class<T> cls, zzkz zzkzVar, zzlh zzlhVar, zzkq zzkqVar, zzmb<?, ?> zzmbVar, zzjk<?> zzjkVar, zzkx zzkxVar) {
        if (zzkzVar instanceof zzlm) {
            return zzl((zzlm) zzkzVar, zzlhVar, zzkqVar, zzmbVar, zzjkVar, zzkxVar);
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0379  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <T> zzlf<T> zzl(zzlm zzlmVar, zzlh zzlhVar, zzkq zzkqVar, zzmb<?, ?> zzmbVar, zzjk<?> zzjkVar, zzkx zzkxVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int[] iArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        char cCharAt;
        int i7;
        char cCharAt2;
        int i8;
        char cCharAt3;
        int i9;
        char cCharAt4;
        int i10;
        char cCharAt5;
        int i11;
        char cCharAt6;
        int i12;
        char cCharAt7;
        int i13;
        char cCharAt8;
        int i14;
        int i15;
        int i16;
        int[] iArr2;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset;
        Object[] objArr;
        String str;
        Class<?> cls;
        int iObjectFieldOffset2;
        int i20;
        int i21;
        Field fieldZzG;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        Object obj;
        Field fieldZzG2;
        Object obj2;
        Field fieldZzG3;
        int i25;
        char cCharAt10;
        int i26;
        char cCharAt11;
        int i27;
        char cCharAt12;
        int i28;
        char cCharAt13;
        boolean z = zzlmVar.zzc() == 2;
        String strZzd = zzlmVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i29 = 1;
            while (true) {
                i = i29 + 1;
                if (strZzd.charAt(i29) < 55296) {
                    break;
                }
                i29 = i;
            }
        } else {
            i = 1;
        }
        int i30 = i + 1;
        int iCharAt4 = strZzd.charAt(i);
        if (iCharAt4 >= 55296) {
            int i31 = iCharAt4 & 8191;
            int i32 = 13;
            while (true) {
                i28 = i30 + 1;
                cCharAt13 = strZzd.charAt(i30);
                if (cCharAt13 < 55296) {
                    break;
                }
                i31 |= (cCharAt13 & 8191) << i32;
                i32 += 13;
                i30 = i28;
            }
            iCharAt4 = i31 | (cCharAt13 << i32);
            i30 = i28;
        }
        if (iCharAt4 == 0) {
            iCharAt = 0;
            i5 = 0;
            iCharAt2 = 0;
            i4 = 0;
            iCharAt3 = 0;
            i2 = 0;
            iArr = zza;
            i3 = 0;
        } else {
            int i33 = i30 + 1;
            int iCharAt5 = strZzd.charAt(i30);
            if (iCharAt5 >= 55296) {
                int i34 = iCharAt5 & 8191;
                int i35 = 13;
                while (true) {
                    i13 = i33 + 1;
                    cCharAt8 = strZzd.charAt(i33);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i34 |= (cCharAt8 & 8191) << i35;
                    i35 += 13;
                    i33 = i13;
                }
                iCharAt5 = i34 | (cCharAt8 << i35);
                i33 = i13;
            }
            int i36 = i33 + 1;
            int iCharAt6 = strZzd.charAt(i33);
            if (iCharAt6 >= 55296) {
                int i37 = iCharAt6 & 8191;
                int i38 = 13;
                while (true) {
                    i12 = i36 + 1;
                    cCharAt7 = strZzd.charAt(i36);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt7 & 8191) << i38;
                    i38 += 13;
                    i36 = i12;
                }
                iCharAt6 = i37 | (cCharAt7 << i38);
                i36 = i12;
            }
            int i39 = i36 + 1;
            iCharAt = strZzd.charAt(i36);
            if (iCharAt >= 55296) {
                int i40 = iCharAt & 8191;
                int i41 = 13;
                while (true) {
                    i11 = i39 + 1;
                    cCharAt6 = strZzd.charAt(i39);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt6 & 8191) << i41;
                    i41 += 13;
                    i39 = i11;
                }
                iCharAt = i40 | (cCharAt6 << i41);
                i39 = i11;
            }
            int i42 = i39 + 1;
            int iCharAt7 = strZzd.charAt(i39);
            if (iCharAt7 >= 55296) {
                int i43 = iCharAt7 & 8191;
                int i44 = 13;
                while (true) {
                    i10 = i42 + 1;
                    cCharAt5 = strZzd.charAt(i42);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt5 & 8191) << i44;
                    i44 += 13;
                    i42 = i10;
                }
                iCharAt7 = i43 | (cCharAt5 << i44);
                i42 = i10;
            }
            int i45 = i42 + 1;
            iCharAt2 = strZzd.charAt(i42);
            if (iCharAt2 >= 55296) {
                int i46 = iCharAt2 & 8191;
                int i47 = 13;
                while (true) {
                    i9 = i45 + 1;
                    cCharAt4 = strZzd.charAt(i45);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt4 & 8191) << i47;
                    i47 += 13;
                    i45 = i9;
                }
                iCharAt2 = i46 | (cCharAt4 << i47);
                i45 = i9;
            }
            int i48 = i45 + 1;
            int iCharAt8 = strZzd.charAt(i45);
            if (iCharAt8 >= 55296) {
                int i49 = iCharAt8 & 8191;
                int i50 = 13;
                while (true) {
                    i8 = i48 + 1;
                    cCharAt3 = strZzd.charAt(i48);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt3 & 8191) << i50;
                    i50 += 13;
                    i48 = i8;
                }
                iCharAt8 = i49 | (cCharAt3 << i50);
                i48 = i8;
            }
            int i51 = i48 + 1;
            int iCharAt9 = strZzd.charAt(i48);
            if (iCharAt9 >= 55296) {
                int i52 = iCharAt9 & 8191;
                int i53 = 13;
                while (true) {
                    i7 = i51 + 1;
                    cCharAt2 = strZzd.charAt(i51);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt2 & 8191) << i53;
                    i53 += 13;
                    i51 = i7;
                }
                iCharAt9 = i52 | (cCharAt2 << i53);
                i51 = i7;
            }
            int i54 = i51 + 1;
            iCharAt3 = strZzd.charAt(i51);
            if (iCharAt3 >= 55296) {
                int i55 = iCharAt3 & 8191;
                int i56 = 13;
                while (true) {
                    i6 = i54 + 1;
                    cCharAt = strZzd.charAt(i54);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i55 |= (cCharAt & 8191) << i56;
                    i56 += 13;
                    i54 = i6;
                }
                iCharAt3 = i55 | (cCharAt << i56);
                i54 = i6;
            }
            iArr = new int[iCharAt3 + iCharAt8 + iCharAt9];
            i2 = iCharAt5 + iCharAt5 + iCharAt6;
            i3 = iCharAt5;
            i30 = i54;
            int i57 = iCharAt8;
            i4 = iCharAt7;
            i5 = i57;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzlmVar.zze();
        Class<?> cls2 = zzlmVar.zza().getClass();
        int[] iArr3 = new int[iCharAt2 * 3];
        Object[] objArr2 = new Object[iCharAt2 + iCharAt2];
        int i58 = iCharAt3 + i5;
        int i59 = iCharAt3;
        int i60 = i58;
        int i61 = 0;
        int i62 = 0;
        while (i30 < length) {
            int i63 = i30 + 1;
            int iCharAt10 = strZzd.charAt(i30);
            if (iCharAt10 >= c) {
                int i64 = iCharAt10 & 8191;
                int i65 = i63;
                int i66 = 13;
                while (true) {
                    i27 = i65 + 1;
                    cCharAt12 = strZzd.charAt(i65);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i64 |= (cCharAt12 & 8191) << i66;
                    i66 += 13;
                    i65 = i27;
                }
                iCharAt10 = i64 | (cCharAt12 << i66);
                i14 = i27;
            } else {
                i14 = i63;
            }
            int i67 = i14 + 1;
            int iCharAt11 = strZzd.charAt(i14);
            if (iCharAt11 >= c) {
                int i68 = iCharAt11 & 8191;
                int i69 = i67;
                int i70 = 13;
                while (true) {
                    i26 = i69 + 1;
                    cCharAt11 = strZzd.charAt(i69);
                    i15 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i68 |= (cCharAt11 & 8191) << i70;
                    i70 += 13;
                    i69 = i26;
                    length = i15;
                }
                iCharAt11 = i68 | (cCharAt11 << i70);
                i16 = i26;
            } else {
                i15 = length;
                i16 = i67;
            }
            int i71 = iCharAt11 & 255;
            int i72 = iCharAt3;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i62] = i61;
                i62++;
            }
            if (i71 >= 51) {
                int i73 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i74 = iCharAt12 & 8191;
                    int i75 = i73;
                    int i76 = 13;
                    while (true) {
                        i25 = i75 + 1;
                        cCharAt10 = strZzd.charAt(i75);
                        i18 = i4;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i74 |= (cCharAt10 & 8191) << i76;
                        i76 += 13;
                        i75 = i25;
                        i4 = i18;
                    }
                    iCharAt12 = i74 | (cCharAt10 << i76);
                    i23 = i25;
                } else {
                    i18 = i4;
                    i23 = i73;
                }
                int i77 = i71 - 51;
                i20 = i23;
                if (i77 == 9 || i77 == 17) {
                    int i78 = i61 / 3;
                    i24 = i2 + 1;
                    objArr2[i78 + i78 + 1] = objArrZze[i2];
                } else {
                    if (i77 == 12 && !z) {
                        int i79 = i61 / 3;
                        i24 = i2 + 1;
                        objArr2[i79 + i79 + 1] = objArrZze[i2];
                    }
                    int i80 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i80];
                    if (obj instanceof Field) {
                        fieldZzG2 = zzG(cls2, (String) obj);
                        objArrZze[i80] = fieldZzG2;
                    } else {
                        fieldZzG2 = (Field) obj;
                    }
                    iArr2 = iArr3;
                    i17 = iCharAt;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzG2);
                    int i81 = i80 + 1;
                    obj2 = objArrZze[i81];
                    if (obj2 instanceof Field) {
                        fieldZzG3 = zzG(cls2, (String) obj2);
                        objArrZze[i81] = fieldZzG3;
                    } else {
                        fieldZzG3 = (Field) obj2;
                    }
                    int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzG3);
                    str = strZzd;
                    cls = cls2;
                    iObjectFieldOffset2 = iObjectFieldOffset4;
                    objArr = objArr2;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = 0;
                }
                i2 = i24;
                int i802 = iCharAt12 + iCharAt12;
                obj = objArrZze[i802];
                if (obj instanceof Field) {
                }
                iArr2 = iArr3;
                i17 = iCharAt;
                int iObjectFieldOffset32 = (int) unsafe.objectFieldOffset(fieldZzG2);
                int i812 = i802 + 1;
                obj2 = objArrZze[i812];
                if (obj2 instanceof Field) {
                }
                int iObjectFieldOffset42 = (int) unsafe.objectFieldOffset(fieldZzG3);
                str = strZzd;
                cls = cls2;
                iObjectFieldOffset2 = iObjectFieldOffset42;
                objArr = objArr2;
                iObjectFieldOffset = iObjectFieldOffset32;
                i21 = 0;
            } else {
                iArr2 = iArr3;
                i17 = iCharAt;
                i18 = i4;
                int i82 = i2 + 1;
                Field fieldZzG4 = zzG(cls2, (String) objArrZze[i2]);
                if (i71 == 9 || i71 == 17) {
                    int i83 = i61 / 3;
                    objArr2[i83 + i83 + 1] = fieldZzG4.getType();
                } else {
                    if (i71 == 27 || i71 == 49) {
                        int i84 = i61 / 3;
                        i22 = i82 + 1;
                        objArr2[i84 + i84 + 1] = objArrZze[i82];
                    } else if (i71 == 12 || i71 == 30 || i71 == 44) {
                        if (!z) {
                            int i85 = i61 / 3;
                            i22 = i82 + 1;
                            objArr2[i85 + i85 + 1] = objArrZze[i82];
                        }
                    } else if (i71 == 50) {
                        int i86 = i59 + 1;
                        iArr[i59] = i61;
                        int i87 = i61 / 3;
                        int i88 = i87 + i87;
                        int i89 = i82 + 1;
                        objArr2[i88] = objArrZze[i82];
                        if ((iCharAt11 & 2048) != 0) {
                            i82 = i89 + 1;
                            objArr2[i88 + 1] = objArrZze[i89];
                            i59 = i86;
                        } else {
                            i59 = i86;
                            i19 = i89;
                            iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzG4);
                            objArr = objArr2;
                            if ((iCharAt11 & 4096) != 4096 || i71 > 17) {
                                str = strZzd;
                                cls = cls2;
                                iObjectFieldOffset2 = 1048575;
                                i20 = i16;
                                i21 = 0;
                            } else {
                                int i90 = i16 + 1;
                                int iCharAt13 = strZzd.charAt(i16);
                                if (iCharAt13 >= 55296) {
                                    int i91 = iCharAt13 & 8191;
                                    int i92 = 13;
                                    while (true) {
                                        i20 = i90 + 1;
                                        cCharAt9 = strZzd.charAt(i90);
                                        if (cCharAt9 < 55296) {
                                            break;
                                        }
                                        i91 |= (cCharAt9 & 8191) << i92;
                                        i92 += 13;
                                        i90 = i20;
                                    }
                                    iCharAt13 = i91 | (cCharAt9 << i92);
                                } else {
                                    i20 = i90;
                                }
                                int i93 = i3 + i3 + (iCharAt13 / 32);
                                Object obj3 = objArrZze[i93];
                                str = strZzd;
                                if (obj3 instanceof Field) {
                                    fieldZzG = (Field) obj3;
                                } else {
                                    fieldZzG = zzG(cls2, (String) obj3);
                                    objArrZze[i93] = fieldZzG;
                                }
                                cls = cls2;
                                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzG);
                                i21 = iCharAt13 % 32;
                            }
                            if (i71 >= 18 && i71 <= 49) {
                                iArr[i60] = iObjectFieldOffset;
                                i60++;
                            }
                            i2 = i19;
                        }
                    }
                    i19 = i22;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzG4);
                    objArr = objArr2;
                    if ((iCharAt11 & 4096) != 4096) {
                        str = strZzd;
                        cls = cls2;
                        iObjectFieldOffset2 = 1048575;
                        i20 = i16;
                        i21 = 0;
                        if (i71 >= 18) {
                            iArr[i60] = iObjectFieldOffset;
                            i60++;
                        }
                        i2 = i19;
                    }
                }
                i19 = i82;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzG4);
                objArr = objArr2;
                if ((iCharAt11 & 4096) != 4096) {
                }
            }
            int i94 = i61 + 1;
            iArr2[i61] = iCharAt10;
            int i95 = i94 + 1;
            iArr2[i94] = ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i71 << 20) | iObjectFieldOffset;
            i61 = i95 + 1;
            iArr2[i95] = iObjectFieldOffset2 | (i21 << 20);
            cls2 = cls;
            iCharAt = i17;
            iCharAt3 = i72;
            i30 = i20;
            length = i15;
            objArr2 = objArr;
            strZzd = str;
            iArr3 = iArr2;
            i4 = i18;
            c = 55296;
        }
        return new zzlf<>(iArr3, objArr2, iCharAt, i4, zzlmVar.zza(), z, false, iArr, iCharAt3, i58, zzlhVar, zzkqVar, zzmbVar, zzjkVar, zzkxVar, null);
    }

    private static <T> double zzn(T t, long j) {
        return ((Double) zzml.zzf(t, j)).doubleValue();
    }

    private static <T> float zzo(T t, long j) {
        return ((Float) zzml.zzf(t, j)).floatValue();
    }

    private final int zzp(T t) {
        int i;
        int iZzA;
        int iZzA2;
        int iZzA3;
        int iZzB;
        int iZzA4;
        int iZzv;
        int iZzA5;
        int iZzA6;
        int iZzd;
        int iZzA7;
        int iZzo;
        int iZzz;
        int iZzA8;
        int i2;
        Unsafe unsafe = zzb;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int iZzB2 = zzB(i6);
            int i7 = this.zzc[i6];
            int iZzA9 = zzA(iZzB2);
            if (iZzA9 <= 17) {
                int i8 = this.zzc[i6 + 2];
                int i9 = i8 & 1048575;
                i = 1 << (i8 >>> 20);
                if (i9 != i3) {
                    i5 = unsafe.getInt(t, i9);
                    i3 = i9;
                }
            } else {
                i = 0;
            }
            long j = iZzB2 & 1048575;
            switch (iZzA9) {
                case 0:
                    if ((i5 & i) != 0) {
                        iZzA = zzje.zzA(i7 << 3);
                        iZzo = iZzA + 8;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i5 & i) != 0) {
                        iZzA2 = zzje.zzA(i7 << 3);
                        iZzo = iZzA2 + 4;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i5 & i) != 0) {
                        long j2 = unsafe.getLong(t, j);
                        iZzA3 = zzje.zzA(i7 << 3);
                        iZzB = zzje.zzB(j2);
                        iZzo = iZzA3 + iZzB;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i5 & i) != 0) {
                        long j3 = unsafe.getLong(t, j);
                        iZzA3 = zzje.zzA(i7 << 3);
                        iZzB = zzje.zzB(j3);
                        iZzo = iZzA3 + iZzB;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i5 & i) != 0) {
                        int i10 = unsafe.getInt(t, j);
                        iZzA4 = zzje.zzA(i7 << 3);
                        iZzv = zzje.zzv(i10);
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i5 & i) != 0) {
                        iZzA = zzje.zzA(i7 << 3);
                        iZzo = iZzA + 8;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i5 & i) != 0) {
                        iZzA2 = zzje.zzA(i7 << 3);
                        iZzo = iZzA2 + 4;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i5 & i) != 0) {
                        iZzA5 = zzje.zzA(i7 << 3);
                        iZzo = iZzA5 + 1;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i5 & i) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(t, j);
                        if (object instanceof zzix) {
                            iZzA6 = zzje.zzA(i7 << 3);
                            iZzd = ((zzix) object).zzd();
                            iZzA7 = zzje.zzA(iZzd);
                            i2 = iZzA6 + iZzA7 + iZzd;
                            i4 += i2;
                            break;
                        } else {
                            iZzA4 = zzje.zzA(i7 << 3);
                            iZzv = zzje.zzy((String) object);
                            i2 = iZzA4 + iZzv;
                            i4 += i2;
                        }
                    }
                case 9:
                    if ((i5 & i) != 0) {
                        iZzo = zzlp.zzo(i7, unsafe.getObject(t, j), zzE(i6));
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i5 & i) != 0) {
                        zzix zzixVar = (zzix) unsafe.getObject(t, j);
                        iZzA6 = zzje.zzA(i7 << 3);
                        iZzd = zzixVar.zzd();
                        iZzA7 = zzje.zzA(iZzd);
                        i2 = iZzA6 + iZzA7 + iZzd;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i5 & i) != 0) {
                        int i11 = unsafe.getInt(t, j);
                        iZzA4 = zzje.zzA(i7 << 3);
                        iZzv = zzje.zzA(i11);
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i5 & i) != 0) {
                        int i12 = unsafe.getInt(t, j);
                        iZzA4 = zzje.zzA(i7 << 3);
                        iZzv = zzje.zzv(i12);
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i5 & i) != 0) {
                        iZzA2 = zzje.zzA(i7 << 3);
                        iZzo = iZzA2 + 4;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i5 & i) != 0) {
                        iZzA = zzje.zzA(i7 << 3);
                        iZzo = iZzA + 8;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i5 & i) != 0) {
                        int i13 = unsafe.getInt(t, j);
                        iZzA4 = zzje.zzA(i7 << 3);
                        iZzv = zzje.zzA((i13 >> 31) ^ (i13 + i13));
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i5 & i) != 0) {
                        long j4 = unsafe.getLong(t, j);
                        iZzA4 = zzje.zzA(i7 << 3);
                        iZzv = zzje.zzB((j4 >> 63) ^ (j4 + j4));
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i5 & i) != 0) {
                        iZzo = zzje.zzu(i7, (zzlc) unsafe.getObject(t, j), zzE(i6));
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iZzo = zzlp.zzh(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 19:
                    iZzo = zzlp.zzf(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 20:
                    iZzo = zzlp.zzm(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 21:
                    iZzo = zzlp.zzx(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 22:
                    iZzo = zzlp.zzk(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 23:
                    iZzo = zzlp.zzh(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 24:
                    iZzo = zzlp.zzf(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 25:
                    iZzo = zzlp.zza(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 26:
                    iZzo = zzlp.zzu(i7, (List) unsafe.getObject(t, j));
                    i4 += iZzo;
                    break;
                case 27:
                    iZzo = zzlp.zzp(i7, (List) unsafe.getObject(t, j), zzE(i6));
                    i4 += iZzo;
                    break;
                case 28:
                    iZzo = zzlp.zzc(i7, (List) unsafe.getObject(t, j));
                    i4 += iZzo;
                    break;
                case 29:
                    iZzo = zzlp.zzv(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 30:
                    iZzo = zzlp.zzd(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 31:
                    iZzo = zzlp.zzf(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 32:
                    iZzo = zzlp.zzh(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 33:
                    iZzo = zzlp.zzq(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 34:
                    iZzo = zzlp.zzs(i7, (List) unsafe.getObject(t, j), false);
                    i4 += iZzo;
                    break;
                case 35:
                    iZzv = zzlp.zzi((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    iZzv = zzlp.zzg((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    iZzv = zzlp.zzn((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    iZzv = zzlp.zzy((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    iZzv = zzlp.zzl((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    iZzv = zzlp.zzi((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    iZzv = zzlp.zzg((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    iZzv = zzlp.zzb((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    iZzv = zzlp.zzw((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    iZzv = zzlp.zze((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    iZzv = zzlp.zzg((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    iZzv = zzlp.zzi((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    iZzv = zzlp.zzr((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    iZzv = zzlp.zzt((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i7);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    iZzo = zzlp.zzj(i7, (List) unsafe.getObject(t, j), zzE(i6));
                    i4 += iZzo;
                    break;
                case 50:
                    zzkx.zza(i7, unsafe.getObject(t, j), zzF(i6));
                    break;
                case 51:
                    if (zzP(t, i7, i6)) {
                        iZzA = zzje.zzA(i7 << 3);
                        iZzo = iZzA + 8;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzP(t, i7, i6)) {
                        iZzA2 = zzje.zzA(i7 << 3);
                        iZzo = iZzA2 + 4;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzP(t, i7, i6)) {
                        long jZzC = zzC(t, j);
                        iZzA3 = zzje.zzA(i7 << 3);
                        iZzB = zzje.zzB(jZzC);
                        iZzo = iZzA3 + iZzB;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzP(t, i7, i6)) {
                        long jZzC2 = zzC(t, j);
                        iZzA3 = zzje.zzA(i7 << 3);
                        iZzB = zzje.zzB(jZzC2);
                        iZzo = iZzA3 + iZzB;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzP(t, i7, i6)) {
                        int iZzr = zzr(t, j);
                        iZzA4 = zzje.zzA(i7 << 3);
                        iZzv = zzje.zzv(iZzr);
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzP(t, i7, i6)) {
                        iZzA = zzje.zzA(i7 << 3);
                        iZzo = iZzA + 8;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzP(t, i7, i6)) {
                        iZzA2 = zzje.zzA(i7 << 3);
                        iZzo = iZzA2 + 4;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzP(t, i7, i6)) {
                        iZzA5 = zzje.zzA(i7 << 3);
                        iZzo = iZzA5 + 1;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzP(t, i7, i6)) {
                        break;
                    } else {
                        Object object2 = unsafe.getObject(t, j);
                        if (object2 instanceof zzix) {
                            iZzA6 = zzje.zzA(i7 << 3);
                            iZzd = ((zzix) object2).zzd();
                            iZzA7 = zzje.zzA(iZzd);
                            i2 = iZzA6 + iZzA7 + iZzd;
                            i4 += i2;
                            break;
                        } else {
                            iZzA4 = zzje.zzA(i7 << 3);
                            iZzv = zzje.zzy((String) object2);
                            i2 = iZzA4 + iZzv;
                            i4 += i2;
                        }
                    }
                case 60:
                    if (zzP(t, i7, i6)) {
                        iZzo = zzlp.zzo(i7, unsafe.getObject(t, j), zzE(i6));
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzP(t, i7, i6)) {
                        zzix zzixVar2 = (zzix) unsafe.getObject(t, j);
                        iZzA6 = zzje.zzA(i7 << 3);
                        iZzd = zzixVar2.zzd();
                        iZzA7 = zzje.zzA(iZzd);
                        i2 = iZzA6 + iZzA7 + iZzd;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzP(t, i7, i6)) {
                        int iZzr2 = zzr(t, j);
                        iZzA4 = zzje.zzA(i7 << 3);
                        iZzv = zzje.zzA(iZzr2);
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzP(t, i7, i6)) {
                        int iZzr3 = zzr(t, j);
                        iZzA4 = zzje.zzA(i7 << 3);
                        iZzv = zzje.zzv(iZzr3);
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzP(t, i7, i6)) {
                        iZzA2 = zzje.zzA(i7 << 3);
                        iZzo = iZzA2 + 4;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzP(t, i7, i6)) {
                        iZzA = zzje.zzA(i7 << 3);
                        iZzo = iZzA + 8;
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzP(t, i7, i6)) {
                        int iZzr4 = zzr(t, j);
                        iZzA4 = zzje.zzA(i7 << 3);
                        iZzv = zzje.zzA((iZzr4 >> 31) ^ (iZzr4 + iZzr4));
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzP(t, i7, i6)) {
                        long jZzC3 = zzC(t, j);
                        iZzA4 = zzje.zzA(i7 << 3);
                        iZzv = zzje.zzB((jZzC3 >> 63) ^ (jZzC3 + jZzC3));
                        i2 = iZzA4 + iZzv;
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzP(t, i7, i6)) {
                        iZzo = zzje.zzu(i7, (zzlc) unsafe.getObject(t, j), zzE(i6));
                        i4 += iZzo;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzmb<?, ?> zzmbVar = this.zzn;
        int iZza = i4 + zzmbVar.zza(zzmbVar.zzc(t));
        if (!this.zzh) {
            return iZza;
        }
        this.zzo.zza(t);
        throw null;
    }

    private final int zzq(T t) {
        int iZzA;
        int iZzA2;
        int iZzA3;
        int iZzB;
        int iZzA4;
        int iZzv;
        int iZzA5;
        int iZzA6;
        int iZzd;
        int iZzA7;
        int iZzo;
        int iZzz;
        int iZzA8;
        int i;
        Unsafe unsafe = zzb;
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int iZzB2 = zzB(i3);
            int iZzA9 = zzA(iZzB2);
            int i4 = this.zzc[i3];
            long j = iZzB2 & 1048575;
            if (iZzA9 >= zzjp.DOUBLE_LIST_PACKED.zza() && iZzA9 <= zzjp.SINT64_LIST_PACKED.zza()) {
                int i5 = this.zzc[i3 + 2];
            }
            switch (iZzA9) {
                case 0:
                    if (zzM(t, i3)) {
                        iZzA = zzje.zzA(i4 << 3);
                        iZzo = iZzA + 8;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzM(t, i3)) {
                        iZzA2 = zzje.zzA(i4 << 3);
                        iZzo = iZzA2 + 4;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzM(t, i3)) {
                        long jZzd = zzml.zzd(t, j);
                        iZzA3 = zzje.zzA(i4 << 3);
                        iZzB = zzje.zzB(jZzd);
                        i2 += iZzA3 + iZzB;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzM(t, i3)) {
                        long jZzd2 = zzml.zzd(t, j);
                        iZzA3 = zzje.zzA(i4 << 3);
                        iZzB = zzje.zzB(jZzd2);
                        i2 += iZzA3 + iZzB;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzM(t, i3)) {
                        int iZzc = zzml.zzc(t, j);
                        iZzA4 = zzje.zzA(i4 << 3);
                        iZzv = zzje.zzv(iZzc);
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzM(t, i3)) {
                        iZzA = zzje.zzA(i4 << 3);
                        iZzo = iZzA + 8;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzM(t, i3)) {
                        iZzA2 = zzje.zzA(i4 << 3);
                        iZzo = iZzA2 + 4;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzM(t, i3)) {
                        iZzA5 = zzje.zzA(i4 << 3);
                        iZzo = iZzA5 + 1;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzM(t, i3)) {
                        break;
                    } else {
                        Object objZzf = zzml.zzf(t, j);
                        if (objZzf instanceof zzix) {
                            iZzA6 = zzje.zzA(i4 << 3);
                            iZzd = ((zzix) objZzf).zzd();
                            iZzA7 = zzje.zzA(iZzd);
                            i = iZzA6 + iZzA7 + iZzd;
                            i2 += i;
                            break;
                        } else {
                            iZzA4 = zzje.zzA(i4 << 3);
                            iZzv = zzje.zzy((String) objZzf);
                            i = iZzA4 + iZzv;
                            i2 += i;
                        }
                    }
                case 9:
                    if (zzM(t, i3)) {
                        iZzo = zzlp.zzo(i4, zzml.zzf(t, j), zzE(i3));
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzM(t, i3)) {
                        zzix zzixVar = (zzix) zzml.zzf(t, j);
                        iZzA6 = zzje.zzA(i4 << 3);
                        iZzd = zzixVar.zzd();
                        iZzA7 = zzje.zzA(iZzd);
                        i = iZzA6 + iZzA7 + iZzd;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzM(t, i3)) {
                        int iZzc2 = zzml.zzc(t, j);
                        iZzA4 = zzje.zzA(i4 << 3);
                        iZzv = zzje.zzA(iZzc2);
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzM(t, i3)) {
                        int iZzc3 = zzml.zzc(t, j);
                        iZzA4 = zzje.zzA(i4 << 3);
                        iZzv = zzje.zzv(iZzc3);
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzM(t, i3)) {
                        iZzA2 = zzje.zzA(i4 << 3);
                        iZzo = iZzA2 + 4;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzM(t, i3)) {
                        iZzA = zzje.zzA(i4 << 3);
                        iZzo = iZzA + 8;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzM(t, i3)) {
                        int iZzc4 = zzml.zzc(t, j);
                        iZzA4 = zzje.zzA(i4 << 3);
                        iZzv = zzje.zzA((iZzc4 >> 31) ^ (iZzc4 + iZzc4));
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzM(t, i3)) {
                        long jZzd3 = zzml.zzd(t, j);
                        iZzA4 = zzje.zzA(i4 << 3);
                        iZzv = zzje.zzB((jZzd3 >> 63) ^ (jZzd3 + jZzd3));
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzM(t, i3)) {
                        iZzo = zzje.zzu(i4, (zzlc) zzml.zzf(t, j), zzE(i3));
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iZzo = zzlp.zzh(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 19:
                    iZzo = zzlp.zzf(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 20:
                    iZzo = zzlp.zzm(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 21:
                    iZzo = zzlp.zzx(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 22:
                    iZzo = zzlp.zzk(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 23:
                    iZzo = zzlp.zzh(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 24:
                    iZzo = zzlp.zzf(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 25:
                    iZzo = zzlp.zza(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 26:
                    iZzo = zzlp.zzu(i4, (List) zzml.zzf(t, j));
                    i2 += iZzo;
                    break;
                case 27:
                    iZzo = zzlp.zzp(i4, (List) zzml.zzf(t, j), zzE(i3));
                    i2 += iZzo;
                    break;
                case 28:
                    iZzo = zzlp.zzc(i4, (List) zzml.zzf(t, j));
                    i2 += iZzo;
                    break;
                case 29:
                    iZzo = zzlp.zzv(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 30:
                    iZzo = zzlp.zzd(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 31:
                    iZzo = zzlp.zzf(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 32:
                    iZzo = zzlp.zzh(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 33:
                    iZzo = zzlp.zzq(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 34:
                    iZzo = zzlp.zzs(i4, (List) zzml.zzf(t, j), false);
                    i2 += iZzo;
                    break;
                case 35:
                    iZzv = zzlp.zzi((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    iZzv = zzlp.zzg((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    iZzv = zzlp.zzn((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    iZzv = zzlp.zzy((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    iZzv = zzlp.zzl((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    iZzv = zzlp.zzi((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    iZzv = zzlp.zzg((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    iZzv = zzlp.zzb((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    iZzv = zzlp.zzw((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    iZzv = zzlp.zze((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    iZzv = zzlp.zzg((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    iZzv = zzlp.zzi((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    iZzv = zzlp.zzr((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    iZzv = zzlp.zzt((List) unsafe.getObject(t, j));
                    if (iZzv > 0) {
                        iZzz = zzje.zzz(i4);
                        iZzA8 = zzje.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    iZzo = zzlp.zzj(i4, (List) zzml.zzf(t, j), zzE(i3));
                    i2 += iZzo;
                    break;
                case 50:
                    zzkx.zza(i4, zzml.zzf(t, j), zzF(i3));
                    break;
                case 51:
                    if (zzP(t, i4, i3)) {
                        iZzA = zzje.zzA(i4 << 3);
                        iZzo = iZzA + 8;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzP(t, i4, i3)) {
                        iZzA2 = zzje.zzA(i4 << 3);
                        iZzo = iZzA2 + 4;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzP(t, i4, i3)) {
                        long jZzC = zzC(t, j);
                        iZzA3 = zzje.zzA(i4 << 3);
                        iZzB = zzje.zzB(jZzC);
                        i2 += iZzA3 + iZzB;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzP(t, i4, i3)) {
                        long jZzC2 = zzC(t, j);
                        iZzA3 = zzje.zzA(i4 << 3);
                        iZzB = zzje.zzB(jZzC2);
                        i2 += iZzA3 + iZzB;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzP(t, i4, i3)) {
                        int iZzr = zzr(t, j);
                        iZzA4 = zzje.zzA(i4 << 3);
                        iZzv = zzje.zzv(iZzr);
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzP(t, i4, i3)) {
                        iZzA = zzje.zzA(i4 << 3);
                        iZzo = iZzA + 8;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzP(t, i4, i3)) {
                        iZzA2 = zzje.zzA(i4 << 3);
                        iZzo = iZzA2 + 4;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzP(t, i4, i3)) {
                        iZzA5 = zzje.zzA(i4 << 3);
                        iZzo = iZzA5 + 1;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzP(t, i4, i3)) {
                        break;
                    } else {
                        Object objZzf2 = zzml.zzf(t, j);
                        if (objZzf2 instanceof zzix) {
                            iZzA6 = zzje.zzA(i4 << 3);
                            iZzd = ((zzix) objZzf2).zzd();
                            iZzA7 = zzje.zzA(iZzd);
                            i = iZzA6 + iZzA7 + iZzd;
                            i2 += i;
                            break;
                        } else {
                            iZzA4 = zzje.zzA(i4 << 3);
                            iZzv = zzje.zzy((String) objZzf2);
                            i = iZzA4 + iZzv;
                            i2 += i;
                        }
                    }
                case 60:
                    if (zzP(t, i4, i3)) {
                        iZzo = zzlp.zzo(i4, zzml.zzf(t, j), zzE(i3));
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzP(t, i4, i3)) {
                        zzix zzixVar2 = (zzix) zzml.zzf(t, j);
                        iZzA6 = zzje.zzA(i4 << 3);
                        iZzd = zzixVar2.zzd();
                        iZzA7 = zzje.zzA(iZzd);
                        i = iZzA6 + iZzA7 + iZzd;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzP(t, i4, i3)) {
                        int iZzr2 = zzr(t, j);
                        iZzA4 = zzje.zzA(i4 << 3);
                        iZzv = zzje.zzA(iZzr2);
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzP(t, i4, i3)) {
                        int iZzr3 = zzr(t, j);
                        iZzA4 = zzje.zzA(i4 << 3);
                        iZzv = zzje.zzv(iZzr3);
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzP(t, i4, i3)) {
                        iZzA2 = zzje.zzA(i4 << 3);
                        iZzo = iZzA2 + 4;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzP(t, i4, i3)) {
                        iZzA = zzje.zzA(i4 << 3);
                        iZzo = iZzA + 8;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzP(t, i4, i3)) {
                        int iZzr4 = zzr(t, j);
                        iZzA4 = zzje.zzA(i4 << 3);
                        iZzv = zzje.zzA((iZzr4 >> 31) ^ (iZzr4 + iZzr4));
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzP(t, i4, i3)) {
                        long jZzC3 = zzC(t, j);
                        iZzA4 = zzje.zzA(i4 << 3);
                        iZzv = zzje.zzB((jZzC3 >> 63) ^ (jZzC3 + jZzC3));
                        i = iZzA4 + iZzv;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzP(t, i4, i3)) {
                        iZzo = zzje.zzu(i4, (zzlc) zzml.zzf(t, j), zzE(i3));
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzmb<?, ?> zzmbVar = this.zzn;
        return i2 + zzmbVar.zza(zzmbVar.zzc(t));
    }

    private static <T> int zzr(T t, long j) {
        return ((Integer) zzml.zzf(t, j)).intValue();
    }

    private final <K, V> int zzs(T t, byte[] bArr, int i, int i2, int i3, long j, zzik zzikVar) throws IOException {
        Unsafe unsafe = zzb;
        Object objZzF = zzF(i3);
        Object object = unsafe.getObject(t, j);
        if (!((zzkw) object).zze()) {
            zzkw<K, V> zzkwVarZzb = zzkw.zza().zzb();
            zzkx.zzb(zzkwVarZzb, object);
            unsafe.putObject(t, j, zzkwVarZzb);
        }
        throw null;
    }

    private final int zzt(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzik zzikVar) throws IOException {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(Double.longBitsToDouble(zzil.zzn(bArr, i))));
                    unsafe.putInt(t, j2, i4);
                    return i + 8;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(Float.intBitsToFloat(zzil.zzb(bArr, i))));
                    unsafe.putInt(t, j2, i4);
                    return i + 4;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int iZzm = zzil.zzm(bArr, i, zzikVar);
                    unsafe.putObject(t, j, Long.valueOf(zzikVar.zzb));
                    unsafe.putInt(t, j2, i4);
                    return iZzm;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int iZzj = zzil.zzj(bArr, i, zzikVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzikVar.zza));
                    unsafe.putInt(t, j2, i4);
                    return iZzj;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzil.zzn(bArr, i)));
                    unsafe.putInt(t, j2, i4);
                    return i + 8;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzil.zzb(bArr, i)));
                    unsafe.putInt(t, j2, i4);
                    return i + 4;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int iZzm2 = zzil.zzm(bArr, i, zzikVar);
                    unsafe.putObject(t, j, Boolean.valueOf(zzikVar.zzb != 0));
                    unsafe.putInt(t, j2, i4);
                    return iZzm2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int iZzj2 = zzil.zzj(bArr, i, zzikVar);
                    int i9 = zzikVar.zza;
                    if (i9 == 0) {
                        unsafe.putObject(t, j, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !zzmq.zzf(bArr, iZzj2, iZzj2 + i9)) {
                            throw zzkh.zzc();
                        }
                        unsafe.putObject(t, j, new String(bArr, iZzj2, i9, zzkf.zzb));
                        iZzj2 += i9;
                    }
                    unsafe.putInt(t, j2, i4);
                    return iZzj2;
                }
                break;
            case 60:
                if (i5 == 2) {
                    int iZzd = zzil.zzd(zzE(i8), bArr, i, i2, zzikVar);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzikVar.zzc);
                    } else {
                        unsafe.putObject(t, j, zzkf.zzg(object, zzikVar.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iZzd;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int iZza = zzil.zza(bArr, i, zzikVar);
                    unsafe.putObject(t, j, zzikVar.zzc);
                    unsafe.putInt(t, j2, i4);
                    return iZza;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int iZzj3 = zzil.zzj(bArr, i, zzikVar);
                    int i10 = zzikVar.zza;
                    zzkb zzkbVarZzD = zzD(i8);
                    if (zzkbVarZzD == null || zzkbVarZzD.zza(i10)) {
                        unsafe.putObject(t, j, Integer.valueOf(i10));
                        unsafe.putInt(t, j2, i4);
                    } else {
                        zzd(t).zzh(i3, Long.valueOf(i10));
                    }
                    return iZzj3;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int iZzj4 = zzil.zzj(bArr, i, zzikVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzja.zzb(zzikVar.zza)));
                    unsafe.putInt(t, j2, i4);
                    return iZzj4;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int iZzm3 = zzil.zzm(bArr, i, zzikVar);
                    unsafe.putObject(t, j, Long.valueOf(zzja.zzc(zzikVar.zzb)));
                    unsafe.putInt(t, j2, i4);
                    return iZzm3;
                }
                break;
            case 68:
                if (i5 == 3) {
                    int iZzc = zzil.zzc(zzE(i8), bArr, i, i2, (i3 & (-8)) | 4, zzikVar);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzikVar.zzc);
                    } else {
                        unsafe.putObject(t, j, zzkf.zzg(object2, zzikVar.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iZzc;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x02a9, code lost:
    
        if (r0 != r15) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02ab, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r10 = r18;
        r2 = r19;
        r1 = r20;
        r6 = r24;
        r7 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02c1, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02f4, code lost:
    
        if (r0 != r15) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0317, code lost:
    
        if (r0 != r15) goto L107;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0096. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int zzu(T t, byte[] bArr, int i, int i2, zzik zzikVar) throws IOException {
        byte b;
        int iZzk;
        int i3;
        int i4;
        Unsafe unsafe;
        int i5;
        int i6;
        int i7;
        Unsafe unsafe2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Unsafe unsafe3;
        zzlf<T> zzlfVar = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i16 = i2;
        zzik zzikVar2 = zzikVar;
        Unsafe unsafe4 = zzb;
        int i17 = -1;
        int i18 = 1048575;
        int iZzi = i;
        int i19 = 1048575;
        int i20 = -1;
        int i21 = 0;
        int i22 = 0;
        while (iZzi < i16) {
            int i23 = iZzi + 1;
            byte b2 = bArr2[iZzi];
            if (b2 < 0) {
                iZzk = zzil.zzk(b2, bArr2, i23, zzikVar2);
                b = zzikVar2.zza;
            } else {
                b = b2;
                iZzk = i23;
            }
            int i24 = b >>> 3;
            int i25 = b & 7;
            int iZzx = i24 > i20 ? zzlfVar.zzx(i24, i21 / 3) : zzlfVar.zzw(i24);
            if (iZzx == i17) {
                i3 = iZzk;
                i4 = i24;
                unsafe = unsafe4;
                i5 = i17;
                i6 = 0;
            } else {
                int i26 = zzlfVar.zzc[iZzx + 1];
                int iZzA = zzA(i26);
                Unsafe unsafe5 = unsafe4;
                long j = i26 & i18;
                if (iZzA <= 17) {
                    int i27 = zzlfVar.zzc[iZzx + 2];
                    int i28 = 1 << (i27 >>> 20);
                    int i29 = i27 & 1048575;
                    if (i29 != i19) {
                        i12 = i26;
                        i13 = iZzx;
                        if (i19 != 1048575) {
                            long j2 = i19;
                            unsafe3 = unsafe5;
                            unsafe3.putInt(t2, j2, i22);
                        } else {
                            unsafe3 = unsafe5;
                        }
                        if (i29 != 1048575) {
                            i22 = unsafe3.getInt(t2, i29);
                        }
                        unsafe2 = unsafe3;
                        i19 = i29;
                    } else {
                        i12 = i26;
                        i13 = iZzx;
                        unsafe2 = unsafe5;
                    }
                    switch (iZzA) {
                        case 0:
                            i8 = 1048575;
                            i7 = i13;
                            i4 = i24;
                            if (i25 != 1) {
                                i3 = iZzk;
                                unsafe = unsafe2;
                                i6 = i7;
                                i5 = -1;
                                break;
                            } else {
                                zzml.zzo(t2, j, Double.longBitsToDouble(zzil.zzn(bArr2, iZzk)));
                                iZzi = iZzk + 8;
                                i22 |= i28;
                                unsafe4 = unsafe2;
                                i21 = i7;
                                i18 = i8;
                                i20 = i4;
                                i17 = -1;
                                i16 = i2;
                                break;
                            }
                        case 1:
                            i8 = 1048575;
                            i7 = i13;
                            i4 = i24;
                            if (i25 != 5) {
                                i3 = iZzk;
                                unsafe = unsafe2;
                                i6 = i7;
                                i5 = -1;
                                break;
                            } else {
                                zzml.zzp(t2, j, Float.intBitsToFloat(zzil.zzb(bArr2, iZzk)));
                                iZzi = iZzk + 4;
                                i22 |= i28;
                                unsafe4 = unsafe2;
                                i21 = i7;
                                i18 = i8;
                                i20 = i4;
                                i17 = -1;
                                i16 = i2;
                                break;
                            }
                        case 2:
                        case 3:
                            i8 = 1048575;
                            i7 = i13;
                            i4 = i24;
                            if (i25 != 0) {
                                i3 = iZzk;
                                unsafe = unsafe2;
                                i6 = i7;
                                i5 = -1;
                                break;
                            } else {
                                int iZzm = zzil.zzm(bArr2, iZzk, zzikVar2);
                                unsafe2.putLong(t, j, zzikVar2.zzb);
                                i22 |= i28;
                                unsafe4 = unsafe2;
                                i21 = i7;
                                iZzi = iZzm;
                                i18 = i8;
                                i20 = i4;
                                i17 = -1;
                                i16 = i2;
                                break;
                            }
                        case 4:
                        case 11:
                            i8 = 1048575;
                            i7 = i13;
                            i4 = i24;
                            if (i25 != 0) {
                                i3 = iZzk;
                                unsafe = unsafe2;
                                i6 = i7;
                                i5 = -1;
                                break;
                            } else {
                                iZzi = zzil.zzj(bArr2, iZzk, zzikVar2);
                                unsafe2.putInt(t2, j, zzikVar2.zza);
                                i22 |= i28;
                                unsafe4 = unsafe2;
                                i21 = i7;
                                i18 = i8;
                                i20 = i4;
                                i17 = -1;
                                i16 = i2;
                                break;
                            }
                        case 5:
                        case 14:
                            i8 = 1048575;
                            i7 = i13;
                            i4 = i24;
                            if (i25 != 1) {
                                i3 = iZzk;
                                unsafe = unsafe2;
                                i6 = i7;
                                i5 = -1;
                                break;
                            } else {
                                unsafe2.putLong(t, j, zzil.zzn(bArr2, iZzk));
                                iZzi = iZzk + 8;
                                i22 |= i28;
                                unsafe4 = unsafe2;
                                i21 = i7;
                                i18 = i8;
                                i20 = i4;
                                i17 = -1;
                                i16 = i2;
                                break;
                            }
                        case 6:
                        case 13:
                            i14 = i2;
                            i15 = 1048575;
                            i7 = i13;
                            i4 = i24;
                            if (i25 != 5) {
                                i3 = iZzk;
                                unsafe = unsafe2;
                                i6 = i7;
                                i5 = -1;
                                break;
                            } else {
                                unsafe2.putInt(t2, j, zzil.zzb(bArr2, iZzk));
                                iZzi = iZzk + 4;
                                i22 |= i28;
                                unsafe4 = unsafe2;
                                i18 = i15;
                                i20 = i4;
                                i17 = -1;
                                int i30 = i7;
                                i16 = i14;
                                i21 = i30;
                                break;
                            }
                        case 7:
                            i14 = i2;
                            i15 = 1048575;
                            i7 = i13;
                            i4 = i24;
                            if (i25 != 0) {
                                i3 = iZzk;
                                unsafe = unsafe2;
                                i6 = i7;
                                i5 = -1;
                                break;
                            } else {
                                iZzi = zzil.zzm(bArr2, iZzk, zzikVar2);
                                zzml.zzm(t2, j, zzikVar2.zzb != 0);
                                i22 |= i28;
                                unsafe4 = unsafe2;
                                i18 = i15;
                                i20 = i4;
                                i17 = -1;
                                int i302 = i7;
                                i16 = i14;
                                i21 = i302;
                                break;
                            }
                        case 8:
                            i14 = i2;
                            i15 = 1048575;
                            i7 = i13;
                            i4 = i24;
                            if (i25 != 2) {
                                i3 = iZzk;
                                unsafe = unsafe2;
                                i6 = i7;
                                i5 = -1;
                                break;
                            } else {
                                iZzi = (i12 & 536870912) == 0 ? zzil.zzg(bArr2, iZzk, zzikVar2) : zzil.zzh(bArr2, iZzk, zzikVar2);
                                unsafe2.putObject(t2, j, zzikVar2.zzc);
                                i22 |= i28;
                                unsafe4 = unsafe2;
                                i18 = i15;
                                i20 = i4;
                                i17 = -1;
                                int i3022 = i7;
                                i16 = i14;
                                i21 = i3022;
                                break;
                            }
                        case 9:
                            i7 = i13;
                            i4 = i24;
                            if (i25 != 2) {
                                i3 = iZzk;
                                unsafe = unsafe2;
                                i6 = i7;
                                i5 = -1;
                                break;
                            } else {
                                i14 = i2;
                                i15 = 1048575;
                                iZzi = zzil.zzd(zzlfVar.zzE(i7), bArr2, iZzk, i14, zzikVar2);
                                Object object = unsafe2.getObject(t2, j);
                                if (object == null) {
                                    unsafe2.putObject(t2, j, zzikVar2.zzc);
                                } else {
                                    unsafe2.putObject(t2, j, zzkf.zzg(object, zzikVar2.zzc));
                                }
                                i22 |= i28;
                                unsafe4 = unsafe2;
                                i18 = i15;
                                i20 = i4;
                                i17 = -1;
                                int i30222 = i7;
                                i16 = i14;
                                i21 = i30222;
                                break;
                            }
                        case 10:
                            i7 = i13;
                            i4 = i24;
                            if (i25 != 2) {
                                i3 = iZzk;
                                unsafe = unsafe2;
                                i6 = i7;
                                i5 = -1;
                                break;
                            } else {
                                iZzi = zzil.zza(bArr2, iZzk, zzikVar2);
                                unsafe2.putObject(t2, j, zzikVar2.zzc);
                                i22 |= i28;
                                unsafe4 = unsafe2;
                                i21 = i7;
                                i20 = i4;
                                i18 = 1048575;
                                i17 = -1;
                                i16 = i2;
                                break;
                            }
                        case 12:
                            i7 = i13;
                            i4 = i24;
                            if (i25 != 0) {
                                i3 = iZzk;
                                unsafe = unsafe2;
                                i6 = i7;
                                i5 = -1;
                                break;
                            } else {
                                iZzi = zzil.zzj(bArr2, iZzk, zzikVar2);
                                unsafe2.putInt(t2, j, zzikVar2.zza);
                                i22 |= i28;
                                unsafe4 = unsafe2;
                                i21 = i7;
                                i20 = i4;
                                i18 = 1048575;
                                i17 = -1;
                                i16 = i2;
                                break;
                            }
                        case 15:
                            i7 = i13;
                            i4 = i24;
                            if (i25 != 0) {
                                i3 = iZzk;
                                unsafe = unsafe2;
                                i6 = i7;
                                i5 = -1;
                                break;
                            } else {
                                iZzi = zzil.zzj(bArr2, iZzk, zzikVar2);
                                unsafe2.putInt(t2, j, zzja.zzb(zzikVar2.zza));
                                i22 |= i28;
                                unsafe4 = unsafe2;
                                i21 = i7;
                                i20 = i4;
                                i18 = 1048575;
                                i17 = -1;
                                i16 = i2;
                                break;
                            }
                        case 16:
                            if (i25 != 0) {
                                i7 = i13;
                                i4 = i24;
                                i3 = iZzk;
                                unsafe = unsafe2;
                                i6 = i7;
                                i5 = -1;
                                break;
                            } else {
                                int iZzm2 = zzil.zzm(bArr2, iZzk, zzikVar2);
                                int i31 = i13;
                                i4 = i24;
                                unsafe2.putLong(t, j, zzja.zzc(zzikVar2.zzb));
                                i22 |= i28;
                                unsafe4 = unsafe2;
                                i21 = i31;
                                iZzi = iZzm2;
                                i20 = i4;
                                i18 = 1048575;
                                i17 = -1;
                                i16 = i2;
                                break;
                            }
                        default:
                            i7 = i13;
                            i4 = i24;
                            i3 = iZzk;
                            unsafe = unsafe2;
                            i6 = i7;
                            i5 = -1;
                            break;
                    }
                } else {
                    i4 = i24;
                    i7 = iZzx;
                    unsafe2 = unsafe5;
                    i8 = 1048575;
                    if (iZzA != 27) {
                        if (iZzA <= 49) {
                            int i32 = iZzk;
                            i10 = i22;
                            i11 = i19;
                            unsafe = unsafe2;
                            i5 = -1;
                            i6 = i7;
                            iZzi = zzv(t, bArr, iZzk, i2, b, i4, i25, i7, i26, iZzA, j, zzikVar);
                        } else {
                            i9 = iZzk;
                            i10 = i22;
                            i11 = i19;
                            unsafe = unsafe2;
                            i6 = i7;
                            i5 = -1;
                            if (iZzA != 50) {
                                iZzi = zzt(t, bArr, i9, i2, b, i4, i25, i26, iZzA, j, i6, zzikVar);
                            } else if (i25 == 2) {
                                iZzi = zzs(t, bArr, i9, i2, i6, j, zzikVar);
                            }
                        }
                        unsafe4 = unsafe;
                        i18 = 1048575;
                    } else if (i25 == 2) {
                        zzke zzkeVarZzd = (zzke) unsafe2.getObject(t2, j);
                        if (!zzkeVarZzd.zzc()) {
                            int size = zzkeVarZzd.size();
                            zzkeVarZzd = zzkeVarZzd.zzd(size == 0 ? 10 : size + size);
                            unsafe2.putObject(t2, j, zzkeVarZzd);
                        }
                        iZzi = zzil.zze(zzlfVar.zzE(i7), b, bArr, iZzk, i2, zzkeVarZzd, zzikVar);
                        i22 = i22;
                        unsafe4 = unsafe2;
                        i21 = i7;
                        i18 = i8;
                        i20 = i4;
                        i17 = -1;
                        i16 = i2;
                    } else {
                        i9 = iZzk;
                        i10 = i22;
                        i11 = i19;
                        unsafe = unsafe2;
                        i6 = i7;
                        i5 = -1;
                    }
                    i3 = i9;
                    i22 = i10;
                    i19 = i11;
                }
            }
            iZzi = zzil.zzi(b, bArr, i3, i2, zzd(t), zzikVar);
            zzlfVar = this;
            t2 = t;
            bArr2 = bArr;
            i16 = i2;
            zzikVar2 = zzikVar;
            i17 = i5;
            i21 = i6;
            i20 = i4;
            unsafe4 = unsafe;
            i18 = 1048575;
        }
        int i33 = i22;
        Unsafe unsafe6 = unsafe4;
        if (i19 != i18) {
            unsafe6.putInt(t, i19, i33);
        }
        if (iZzi == i2) {
            return iZzi;
        }
        throw zzkh.zze();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int zzv(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzik zzikVar) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzj;
        int iZzj2 = i;
        Unsafe unsafe = zzb;
        zzke zzkeVarZzd = (zzke) unsafe.getObject(t, j2);
        if (!zzkeVarZzd.zzc()) {
            int size = zzkeVarZzd.size();
            zzkeVarZzd = zzkeVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(t, j2, zzkeVarZzd);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzjg zzjgVar = (zzjg) zzkeVarZzd;
                    int iZzj3 = zzil.zzj(bArr, iZzj2, zzikVar);
                    int i12 = zzikVar.zza + iZzj3;
                    while (iZzj3 < i12) {
                        zzjgVar.zze(Double.longBitsToDouble(zzil.zzn(bArr, iZzj3)));
                        iZzj3 += 8;
                    }
                    if (iZzj3 == i12) {
                        return iZzj3;
                    }
                    throw zzkh.zzf();
                }
                if (i5 == 1) {
                    zzjg zzjgVar2 = (zzjg) zzkeVarZzd;
                    zzjgVar2.zze(Double.longBitsToDouble(zzil.zzn(bArr, i)));
                    while (true) {
                        i8 = iZzj2 + 8;
                        if (i8 < i2) {
                            iZzj2 = zzil.zzj(bArr, i8, zzikVar);
                            if (i3 == zzikVar.zza) {
                                zzjgVar2.zze(Double.longBitsToDouble(zzil.zzn(bArr, iZzj2)));
                            }
                        }
                    }
                    return i8;
                }
                return iZzj2;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzjq zzjqVar = (zzjq) zzkeVarZzd;
                    int iZzj4 = zzil.zzj(bArr, iZzj2, zzikVar);
                    int i13 = zzikVar.zza + iZzj4;
                    while (iZzj4 < i13) {
                        zzjqVar.zze(Float.intBitsToFloat(zzil.zzb(bArr, iZzj4)));
                        iZzj4 += 4;
                    }
                    if (iZzj4 == i13) {
                        return iZzj4;
                    }
                    throw zzkh.zzf();
                }
                if (i5 == 5) {
                    zzjq zzjqVar2 = (zzjq) zzkeVarZzd;
                    zzjqVar2.zze(Float.intBitsToFloat(zzil.zzb(bArr, i)));
                    while (true) {
                        i9 = iZzj2 + 4;
                        if (i9 < i2) {
                            iZzj2 = zzil.zzj(bArr, i9, zzikVar);
                            if (i3 == zzikVar.zza) {
                                zzjqVar2.zze(Float.intBitsToFloat(zzil.zzb(bArr, iZzj2)));
                            }
                        }
                    }
                    return i9;
                }
                return iZzj2;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzkr zzkrVar = (zzkr) zzkeVarZzd;
                    int iZzj5 = zzil.zzj(bArr, iZzj2, zzikVar);
                    int i14 = zzikVar.zza + iZzj5;
                    while (iZzj5 < i14) {
                        iZzj5 = zzil.zzm(bArr, iZzj5, zzikVar);
                        zzkrVar.zzg(zzikVar.zzb);
                    }
                    if (iZzj5 == i14) {
                        return iZzj5;
                    }
                    throw zzkh.zzf();
                }
                if (i5 == 0) {
                    zzkr zzkrVar2 = (zzkr) zzkeVarZzd;
                    int iZzm = zzil.zzm(bArr, iZzj2, zzikVar);
                    zzkrVar2.zzg(zzikVar.zzb);
                    while (iZzm < i2) {
                        int iZzj6 = zzil.zzj(bArr, iZzm, zzikVar);
                        if (i3 != zzikVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzil.zzm(bArr, iZzj6, zzikVar);
                        zzkrVar2.zzg(zzikVar.zzb);
                    }
                    return iZzm;
                }
                return iZzj2;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzil.zzf(bArr, iZzj2, zzkeVarZzd, zzikVar);
                }
                if (i5 == 0) {
                    return zzil.zzl(i3, bArr, i, i2, zzkeVarZzd, zzikVar);
                }
                return iZzj2;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzkr zzkrVar3 = (zzkr) zzkeVarZzd;
                    int iZzj7 = zzil.zzj(bArr, iZzj2, zzikVar);
                    int i15 = zzikVar.zza + iZzj7;
                    while (iZzj7 < i15) {
                        zzkrVar3.zzg(zzil.zzn(bArr, iZzj7));
                        iZzj7 += 8;
                    }
                    if (iZzj7 == i15) {
                        return iZzj7;
                    }
                    throw zzkh.zzf();
                }
                if (i5 == 1) {
                    zzkr zzkrVar4 = (zzkr) zzkeVarZzd;
                    zzkrVar4.zzg(zzil.zzn(bArr, i));
                    while (true) {
                        i10 = iZzj2 + 8;
                        if (i10 < i2) {
                            iZzj2 = zzil.zzj(bArr, i10, zzikVar);
                            if (i3 == zzikVar.zza) {
                                zzkrVar4.zzg(zzil.zzn(bArr, iZzj2));
                            }
                        }
                    }
                    return i10;
                }
                return iZzj2;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzjy zzjyVar = (zzjy) zzkeVarZzd;
                    int iZzj8 = zzil.zzj(bArr, iZzj2, zzikVar);
                    int i16 = zzikVar.zza + iZzj8;
                    while (iZzj8 < i16) {
                        zzjyVar.zzh(zzil.zzb(bArr, iZzj8));
                        iZzj8 += 4;
                    }
                    if (iZzj8 == i16) {
                        return iZzj8;
                    }
                    throw zzkh.zzf();
                }
                if (i5 == 5) {
                    zzjy zzjyVar2 = (zzjy) zzkeVarZzd;
                    zzjyVar2.zzh(zzil.zzb(bArr, i));
                    while (true) {
                        i11 = iZzj2 + 4;
                        if (i11 < i2) {
                            iZzj2 = zzil.zzj(bArr, i11, zzikVar);
                            if (i3 == zzikVar.zza) {
                                zzjyVar2.zzh(zzil.zzb(bArr, iZzj2));
                            }
                        }
                    }
                    return i11;
                }
                return iZzj2;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzim zzimVar = (zzim) zzkeVarZzd;
                    iZzj = zzil.zzj(bArr, iZzj2, zzikVar);
                    int i17 = zzikVar.zza + iZzj;
                    while (iZzj < i17) {
                        iZzj = zzil.zzm(bArr, iZzj, zzikVar);
                        zzimVar.zze(zzikVar.zzb != 0);
                    }
                    if (iZzj != i17) {
                        throw zzkh.zzf();
                    }
                    return iZzj;
                }
                if (i5 == 0) {
                    zzim zzimVar2 = (zzim) zzkeVarZzd;
                    int iZzm2 = zzil.zzm(bArr, iZzj2, zzikVar);
                    zzimVar2.zze(zzikVar.zzb != 0);
                    while (iZzm2 < i2) {
                        int iZzj9 = zzil.zzj(bArr, iZzm2, zzikVar);
                        if (i3 != zzikVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzil.zzm(bArr, iZzj9, zzikVar);
                        zzimVar2.zze(zzikVar.zzb != 0);
                    }
                    return iZzm2;
                }
                return iZzj2;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZzj10 = zzil.zzj(bArr, iZzj2, zzikVar);
                        int i18 = zzikVar.zza;
                        if (i18 < 0) {
                            throw zzkh.zzd();
                        }
                        if (i18 == 0) {
                            zzkeVarZzd.add("");
                        } else {
                            zzkeVarZzd.add(new String(bArr, iZzj10, i18, zzkf.zzb));
                            iZzj10 += i18;
                        }
                        while (iZzj10 < i2) {
                            int iZzj11 = zzil.zzj(bArr, iZzj10, zzikVar);
                            if (i3 != zzikVar.zza) {
                                return iZzj10;
                            }
                            iZzj10 = zzil.zzj(bArr, iZzj11, zzikVar);
                            int i19 = zzikVar.zza;
                            if (i19 < 0) {
                                throw zzkh.zzd();
                            }
                            if (i19 == 0) {
                                zzkeVarZzd.add("");
                            } else {
                                zzkeVarZzd.add(new String(bArr, iZzj10, i19, zzkf.zzb));
                                iZzj10 += i19;
                            }
                        }
                        return iZzj10;
                    }
                    int iZzj12 = zzil.zzj(bArr, iZzj2, zzikVar);
                    int i20 = zzikVar.zza;
                    if (i20 < 0) {
                        throw zzkh.zzd();
                    }
                    if (i20 == 0) {
                        zzkeVarZzd.add("");
                    } else {
                        int i21 = iZzj12 + i20;
                        if (!zzmq.zzf(bArr, iZzj12, i21)) {
                            throw zzkh.zzc();
                        }
                        zzkeVarZzd.add(new String(bArr, iZzj12, i20, zzkf.zzb));
                        iZzj12 = i21;
                    }
                    while (iZzj12 < i2) {
                        int iZzj13 = zzil.zzj(bArr, iZzj12, zzikVar);
                        if (i3 != zzikVar.zza) {
                            return iZzj12;
                        }
                        iZzj12 = zzil.zzj(bArr, iZzj13, zzikVar);
                        int i22 = zzikVar.zza;
                        if (i22 < 0) {
                            throw zzkh.zzd();
                        }
                        if (i22 == 0) {
                            zzkeVarZzd.add("");
                        } else {
                            int i23 = iZzj12 + i22;
                            if (!zzmq.zzf(bArr, iZzj12, i23)) {
                                throw zzkh.zzc();
                            }
                            zzkeVarZzd.add(new String(bArr, iZzj12, i22, zzkf.zzb));
                            iZzj12 = i23;
                        }
                    }
                    return iZzj12;
                }
                return iZzj2;
            case 27:
                if (i5 == 2) {
                    return zzil.zze(zzE(i6), i3, bArr, i, i2, zzkeVarZzd, zzikVar);
                }
                return iZzj2;
            case 28:
                if (i5 == 2) {
                    int iZzj14 = zzil.zzj(bArr, iZzj2, zzikVar);
                    int i24 = zzikVar.zza;
                    if (i24 < 0) {
                        throw zzkh.zzd();
                    }
                    if (i24 > bArr.length - iZzj14) {
                        throw zzkh.zzf();
                    }
                    if (i24 == 0) {
                        zzkeVarZzd.add(zzix.zzb);
                    } else {
                        zzkeVarZzd.add(zzix.zzl(bArr, iZzj14, i24));
                        iZzj14 += i24;
                    }
                    while (iZzj14 < i2) {
                        int iZzj15 = zzil.zzj(bArr, iZzj14, zzikVar);
                        if (i3 != zzikVar.zza) {
                            return iZzj14;
                        }
                        iZzj14 = zzil.zzj(bArr, iZzj15, zzikVar);
                        int i25 = zzikVar.zza;
                        if (i25 < 0) {
                            throw zzkh.zzd();
                        }
                        if (i25 > bArr.length - iZzj14) {
                            throw zzkh.zzf();
                        }
                        if (i25 == 0) {
                            zzkeVarZzd.add(zzix.zzb);
                        } else {
                            zzkeVarZzd.add(zzix.zzl(bArr, iZzj14, i25));
                            iZzj14 += i25;
                        }
                    }
                    return iZzj14;
                }
                return iZzj2;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZzj = zzil.zzl(i3, bArr, i, i2, zzkeVarZzd, zzikVar);
                    }
                    return iZzj2;
                }
                iZzj = zzil.zzf(bArr, iZzj2, zzkeVarZzd, zzikVar);
                zzjx zzjxVar = (zzjx) t;
                zzmc zzmcVar = zzjxVar.zzc;
                if (zzmcVar == zzmc.zzc()) {
                    zzmcVar = null;
                }
                Object objZzC = zzlp.zzC(i4, zzkeVarZzd, zzD(i6), zzmcVar, this.zzn);
                if (objZzC != null) {
                    zzjxVar.zzc = (zzmc) objZzC;
                    return iZzj;
                }
                return iZzj;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzjy zzjyVar3 = (zzjy) zzkeVarZzd;
                    int iZzj16 = zzil.zzj(bArr, iZzj2, zzikVar);
                    int i26 = zzikVar.zza + iZzj16;
                    while (iZzj16 < i26) {
                        iZzj16 = zzil.zzj(bArr, iZzj16, zzikVar);
                        zzjyVar3.zzh(zzja.zzb(zzikVar.zza));
                    }
                    if (iZzj16 == i26) {
                        return iZzj16;
                    }
                    throw zzkh.zzf();
                }
                if (i5 == 0) {
                    zzjy zzjyVar4 = (zzjy) zzkeVarZzd;
                    int iZzj17 = zzil.zzj(bArr, iZzj2, zzikVar);
                    zzjyVar4.zzh(zzja.zzb(zzikVar.zza));
                    while (iZzj17 < i2) {
                        int iZzj18 = zzil.zzj(bArr, iZzj17, zzikVar);
                        if (i3 != zzikVar.zza) {
                            return iZzj17;
                        }
                        iZzj17 = zzil.zzj(bArr, iZzj18, zzikVar);
                        zzjyVar4.zzh(zzja.zzb(zzikVar.zza));
                    }
                    return iZzj17;
                }
                return iZzj2;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzkr zzkrVar5 = (zzkr) zzkeVarZzd;
                    int iZzj19 = zzil.zzj(bArr, iZzj2, zzikVar);
                    int i27 = zzikVar.zza + iZzj19;
                    while (iZzj19 < i27) {
                        iZzj19 = zzil.zzm(bArr, iZzj19, zzikVar);
                        zzkrVar5.zzg(zzja.zzc(zzikVar.zzb));
                    }
                    if (iZzj19 == i27) {
                        return iZzj19;
                    }
                    throw zzkh.zzf();
                }
                if (i5 == 0) {
                    zzkr zzkrVar6 = (zzkr) zzkeVarZzd;
                    int iZzm3 = zzil.zzm(bArr, iZzj2, zzikVar);
                    zzkrVar6.zzg(zzja.zzc(zzikVar.zzb));
                    while (iZzm3 < i2) {
                        int iZzj20 = zzil.zzj(bArr, iZzm3, zzikVar);
                        if (i3 != zzikVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzil.zzm(bArr, iZzj20, zzikVar);
                        zzkrVar6.zzg(zzja.zzc(zzikVar.zzb));
                    }
                    return iZzm3;
                }
                return iZzj2;
            default:
                if (i5 == 3) {
                    zzln zzlnVarZzE = zzE(i6);
                    int i28 = (i3 & (-8)) | 4;
                    int iZzc = zzil.zzc(zzlnVarZzE, bArr, i, i2, i28, zzikVar);
                    zzkeVarZzd.add(zzikVar.zzc);
                    while (iZzc < i2) {
                        int iZzj21 = zzil.zzj(bArr, iZzc, zzikVar);
                        if (i3 != zzikVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzil.zzc(zzlnVarZzE, bArr, iZzj21, i2, i28, zzikVar);
                        zzkeVarZzd.add(zzikVar.zzc);
                    }
                    return iZzc;
                }
                return iZzj2;
        }
    }

    private final int zzw(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, 0);
    }

    private final int zzx(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, i2);
    }

    private final int zzy(int i) {
        return this.zzc[i + 2];
    }

    private final int zzz(int i, int i2) {
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

    @Override // com.google.android.gms.internal.measurement.zzln
    public final int zza(T t) {
        return this.zzi ? zzq(t) : zzp(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final int zzb(T t) {
        int i;
        int iZzc;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzB = zzB(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzB;
            int iHashCode = 37;
            switch (zzA(iZzB)) {
                case 0:
                    i = i2 * 53;
                    iZzc = zzkf.zzc(Double.doubleToLongBits(zzml.zza(t, j)));
                    i2 = i + iZzc;
                    break;
                case 1:
                    i = i2 * 53;
                    iZzc = Float.floatToIntBits(zzml.zzb(t, j));
                    i2 = i + iZzc;
                    break;
                case 2:
                    i = i2 * 53;
                    iZzc = zzkf.zzc(zzml.zzd(t, j));
                    i2 = i + iZzc;
                    break;
                case 3:
                    i = i2 * 53;
                    iZzc = zzkf.zzc(zzml.zzd(t, j));
                    i2 = i + iZzc;
                    break;
                case 4:
                    i = i2 * 53;
                    iZzc = zzml.zzc(t, j);
                    i2 = i + iZzc;
                    break;
                case 5:
                    i = i2 * 53;
                    iZzc = zzkf.zzc(zzml.zzd(t, j));
                    i2 = i + iZzc;
                    break;
                case 6:
                    i = i2 * 53;
                    iZzc = zzml.zzc(t, j);
                    i2 = i + iZzc;
                    break;
                case 7:
                    i = i2 * 53;
                    iZzc = zzkf.zza(zzml.zzw(t, j));
                    i2 = i + iZzc;
                    break;
                case 8:
                    i = i2 * 53;
                    iZzc = ((String) zzml.zzf(t, j)).hashCode();
                    i2 = i + iZzc;
                    break;
                case 9:
                    Object objZzf = zzml.zzf(t, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZzc = zzml.zzf(t, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 11:
                    i = i2 * 53;
                    iZzc = zzml.zzc(t, j);
                    i2 = i + iZzc;
                    break;
                case 12:
                    i = i2 * 53;
                    iZzc = zzml.zzc(t, j);
                    i2 = i + iZzc;
                    break;
                case 13:
                    i = i2 * 53;
                    iZzc = zzml.zzc(t, j);
                    i2 = i + iZzc;
                    break;
                case 14:
                    i = i2 * 53;
                    iZzc = zzkf.zzc(zzml.zzd(t, j));
                    i2 = i + iZzc;
                    break;
                case 15:
                    i = i2 * 53;
                    iZzc = zzml.zzc(t, j);
                    i2 = i + iZzc;
                    break;
                case 16:
                    i = i2 * 53;
                    iZzc = zzkf.zzc(zzml.zzd(t, j));
                    i2 = i + iZzc;
                    break;
                case 17:
                    Object objZzf2 = zzml.zzf(t, j);
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
                    iZzc = zzml.zzf(t, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 50:
                    i = i2 * 53;
                    iZzc = zzml.zzf(t, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 51:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkf.zzc(Double.doubleToLongBits(zzn(t, j)));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = Float.floatToIntBits(zzo(t, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkf.zzc(zzC(t, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkf.zzc(zzC(t, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(t, j);
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkf.zzc(zzC(t, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(t, j);
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkf.zza(zzQ(t, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = ((String) zzml.zzf(t, j)).hashCode();
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzml.zzf(t, j).hashCode();
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzml.zzf(t, j).hashCode();
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(t, j);
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(t, j);
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(t, j);
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkf.zzc(zzC(t, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(t, j);
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkf.zzc(zzC(t, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzP(t, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzml.zzf(t, j).hashCode();
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzn.zzc(t).hashCode();
        if (!this.zzh) {
            return iHashCode2;
        }
        this.zzo.zza(t);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x041b, code lost:
    
        if (r6 == 1048575) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x041d, code lost:
    
        r26.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0423, code lost:
    
        r3 = r9.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0427, code lost:
    
        if (r3 >= r9.zzl) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0429, code lost:
    
        r4 = r9.zzj[r3];
        r5 = r9.zzc[r4];
        r5 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r9.zzB(r4) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x043b, code lost:
    
        if (r5 != null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0442, code lost:
    
        if (r9.zzD(r4) != null) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0444, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0447, code lost:
    
        r5 = (com.google.android.gms.internal.measurement.zzkw) r5;
        r0 = (com.google.android.gms.internal.measurement.zzkv) r9.zzF(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x044f, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0450, code lost:
    
        if (r7 != 0) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0454, code lost:
    
        if (r0 != r32) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x045b, code lost:
    
        throw com.google.android.gms.internal.measurement.zzkh.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x045e, code lost:
    
        if (r0 > r32) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0460, code lost:
    
        if (r1 != r7) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0462, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0467, code lost:
    
        throw com.google.android.gms.internal.measurement.zzkh.zze();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int zzc(T t, byte[] bArr, int i, int i2, int i3, zzik zzikVar) throws IOException {
        Unsafe unsafe;
        int i4;
        Object obj;
        zzlf<T> zzlfVar;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Object obj2;
        int i11;
        zzik zzikVar2;
        int i12;
        int i13;
        int i14;
        int i15;
        char c;
        int iZzm;
        int i16;
        int i17;
        int i18;
        zzlf<T> zzlfVar2 = this;
        Object obj3 = t;
        byte[] bArr2 = bArr;
        int i19 = i2;
        int i20 = i3;
        zzik zzikVar3 = zzikVar;
        Unsafe unsafe2 = zzb;
        int iZzi = i;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = -1;
        int i25 = 1048575;
        while (true) {
            if (iZzi < i19) {
                int i26 = iZzi + 1;
                byte b = bArr2[iZzi];
                if (b < 0) {
                    int iZzk = zzil.zzk(b, bArr2, i26, zzikVar3);
                    i5 = zzikVar3.zza;
                    i26 = iZzk;
                } else {
                    i5 = b;
                }
                int i27 = i5 >>> 3;
                int i28 = i5 & 7;
                int iZzx = i27 > i24 ? zzlfVar2.zzx(i27, i22 / 3) : zzlfVar2.zzw(i27);
                if (iZzx == -1) {
                    i6 = i27;
                    i7 = i26;
                    i8 = i5;
                    i9 = i23;
                    unsafe = unsafe2;
                    i4 = i20;
                    i10 = 0;
                } else {
                    int i29 = zzlfVar2.zzc[iZzx + 1];
                    int iZzA = zzA(i29);
                    int i30 = i5;
                    long j = i29 & 1048575;
                    if (iZzA <= 17) {
                        int i31 = zzlfVar2.zzc[iZzx + 2];
                        int i32 = 1 << (i31 >>> 20);
                        int i33 = i31 & 1048575;
                        if (i33 != i25) {
                            if (i25 != 1048575) {
                                unsafe2.putInt(obj3, i25, i23);
                            }
                            i23 = unsafe2.getInt(obj3, i33);
                            i12 = i33;
                        } else {
                            i12 = i25;
                        }
                        int i34 = i23;
                        switch (iZzA) {
                            case 0:
                                bArr2 = bArr;
                                i13 = iZzx;
                                i14 = i12;
                                i15 = i30;
                                c = 65535;
                                i7 = i26;
                                if (i28 != 1) {
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    zzml.zzo(obj3, j, Double.longBitsToDouble(zzil.zzn(bArr2, i7)));
                                    iZzi = i7 + 8;
                                    i23 = i34 | i32;
                                    i25 = i14;
                                    i22 = i13;
                                    i21 = i15;
                                    i24 = i27;
                                    i20 = i3;
                                }
                            case 1:
                                bArr2 = bArr;
                                i13 = iZzx;
                                i14 = i12;
                                i15 = i30;
                                c = 65535;
                                i7 = i26;
                                if (i28 != 5) {
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    zzml.zzp(obj3, j, Float.intBitsToFloat(zzil.zzb(bArr2, i7)));
                                    iZzi = i7 + 4;
                                    i23 = i34 | i32;
                                    i25 = i14;
                                    i22 = i13;
                                    i21 = i15;
                                    i24 = i27;
                                    i20 = i3;
                                }
                            case 2:
                            case 3:
                                bArr2 = bArr;
                                i13 = iZzx;
                                i14 = i12;
                                i15 = i30;
                                c = 65535;
                                i7 = i26;
                                if (i28 != 0) {
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    iZzm = zzil.zzm(bArr2, i7, zzikVar3);
                                    unsafe2.putLong(t, j, zzikVar3.zzb);
                                    i23 = i34 | i32;
                                    i25 = i14;
                                    iZzi = iZzm;
                                    i22 = i13;
                                    i21 = i15;
                                    i24 = i27;
                                    i20 = i3;
                                }
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i13 = iZzx;
                                i14 = i12;
                                i15 = i30;
                                c = 65535;
                                i7 = i26;
                                if (i28 != 0) {
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    iZzi = zzil.zzj(bArr2, i7, zzikVar3);
                                    unsafe2.putInt(obj3, j, zzikVar3.zza);
                                    i23 = i34 | i32;
                                    i25 = i14;
                                    i22 = i13;
                                    i21 = i15;
                                    i24 = i27;
                                    i20 = i3;
                                }
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i13 = iZzx;
                                i14 = i12;
                                i15 = i30;
                                c = 65535;
                                if (i28 != 1) {
                                    i7 = i26;
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    unsafe2.putLong(t, j, zzil.zzn(bArr2, i26));
                                    iZzi = i26 + 8;
                                    i23 = i34 | i32;
                                    i25 = i14;
                                    i22 = i13;
                                    i21 = i15;
                                    i24 = i27;
                                    i20 = i3;
                                }
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i13 = iZzx;
                                i14 = i12;
                                i15 = i30;
                                c = 65535;
                                if (i28 != 5) {
                                    i7 = i26;
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    unsafe2.putInt(obj3, j, zzil.zzb(bArr2, i26));
                                    iZzi = i26 + 4;
                                    i23 = i34 | i32;
                                    i25 = i14;
                                    i22 = i13;
                                    i21 = i15;
                                    i24 = i27;
                                    i20 = i3;
                                }
                            case 7:
                                bArr2 = bArr;
                                i13 = iZzx;
                                i14 = i12;
                                i15 = i30;
                                c = 65535;
                                if (i28 != 0) {
                                    i7 = i26;
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    iZzi = zzil.zzm(bArr2, i26, zzikVar3);
                                    zzml.zzm(obj3, j, zzikVar3.zzb != 0);
                                    i23 = i34 | i32;
                                    i25 = i14;
                                    i22 = i13;
                                    i21 = i15;
                                    i24 = i27;
                                    i20 = i3;
                                }
                            case 8:
                                bArr2 = bArr;
                                i13 = iZzx;
                                i14 = i12;
                                i15 = i30;
                                c = 65535;
                                if (i28 != 2) {
                                    i7 = i26;
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    iZzi = (i29 & 536870912) == 0 ? zzil.zzg(bArr2, i26, zzikVar3) : zzil.zzh(bArr2, i26, zzikVar3);
                                    unsafe2.putObject(obj3, j, zzikVar3.zzc);
                                    i23 = i34 | i32;
                                    i25 = i14;
                                    i22 = i13;
                                    i21 = i15;
                                    i24 = i27;
                                    i20 = i3;
                                }
                            case 9:
                                bArr2 = bArr;
                                i13 = iZzx;
                                i14 = i12;
                                i15 = i30;
                                c = 65535;
                                if (i28 != 2) {
                                    i7 = i26;
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    iZzi = zzil.zzd(zzlfVar2.zzE(i13), bArr2, i26, i19, zzikVar3);
                                    if ((i34 & i32) == 0) {
                                        unsafe2.putObject(obj3, j, zzikVar3.zzc);
                                    } else {
                                        unsafe2.putObject(obj3, j, zzkf.zzg(unsafe2.getObject(obj3, j), zzikVar3.zzc));
                                    }
                                    i23 = i34 | i32;
                                    i25 = i14;
                                    i22 = i13;
                                    i21 = i15;
                                    i24 = i27;
                                    i20 = i3;
                                }
                            case 10:
                                bArr2 = bArr;
                                i13 = iZzx;
                                i14 = i12;
                                i15 = i30;
                                c = 65535;
                                if (i28 != 2) {
                                    i7 = i26;
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    iZzi = zzil.zza(bArr2, i26, zzikVar3);
                                    unsafe2.putObject(obj3, j, zzikVar3.zzc);
                                    i23 = i34 | i32;
                                    i25 = i14;
                                    i22 = i13;
                                    i21 = i15;
                                    i24 = i27;
                                    i20 = i3;
                                }
                            case 12:
                                bArr2 = bArr;
                                i13 = iZzx;
                                i14 = i12;
                                i15 = i30;
                                c = 65535;
                                if (i28 != 0) {
                                    i7 = i26;
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    iZzi = zzil.zzj(bArr2, i26, zzikVar3);
                                    int i35 = zzikVar3.zza;
                                    zzkb zzkbVarZzD = zzlfVar2.zzD(i13);
                                    if (zzkbVarZzD == null || zzkbVarZzD.zza(i35)) {
                                        unsafe2.putInt(obj3, j, i35);
                                        i23 = i34 | i32;
                                        i25 = i14;
                                        i22 = i13;
                                        i21 = i15;
                                        i24 = i27;
                                        i20 = i3;
                                    } else {
                                        zzd(t).zzh(i15, Long.valueOf(i35));
                                        i23 = i34;
                                        i22 = i13;
                                        i21 = i15;
                                        i24 = i27;
                                        i25 = i14;
                                        i20 = i3;
                                    }
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i13 = iZzx;
                                i14 = i12;
                                i15 = i30;
                                c = 65535;
                                if (i28 != 0) {
                                    i7 = i26;
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    iZzi = zzil.zzj(bArr2, i26, zzikVar3);
                                    unsafe2.putInt(obj3, j, zzja.zzb(zzikVar3.zza));
                                    i23 = i34 | i32;
                                    i25 = i14;
                                    i22 = i13;
                                    i21 = i15;
                                    i24 = i27;
                                    i20 = i3;
                                }
                            case 16:
                                if (i28 != 0) {
                                    i13 = iZzx;
                                    i14 = i12;
                                    i15 = i30;
                                    c = 65535;
                                    i7 = i26;
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    bArr2 = bArr;
                                    iZzm = zzil.zzm(bArr2, i26, zzikVar3);
                                    i14 = i12;
                                    i15 = i30;
                                    i13 = iZzx;
                                    unsafe2.putLong(t, j, zzja.zzc(zzikVar3.zzb));
                                    i23 = i34 | i32;
                                    i25 = i14;
                                    iZzi = iZzm;
                                    i22 = i13;
                                    i21 = i15;
                                    i24 = i27;
                                    i20 = i3;
                                }
                            default:
                                i13 = iZzx;
                                i14 = i12;
                                i15 = i30;
                                c = 65535;
                                i7 = i26;
                                if (i28 != 3) {
                                    i4 = i3;
                                    i10 = i13;
                                    unsafe = unsafe2;
                                    i8 = i15;
                                    i25 = i14;
                                    i6 = i27;
                                    i9 = i34;
                                    break;
                                } else {
                                    iZzi = zzil.zzc(zzlfVar2.zzE(i13), bArr, i7, i2, (i27 << 3) | 4, zzikVar);
                                    if ((i34 & i32) == 0) {
                                        unsafe2.putObject(obj3, j, zzikVar3.zzc);
                                    } else {
                                        unsafe2.putObject(obj3, j, zzkf.zzg(unsafe2.getObject(obj3, j), zzikVar3.zzc));
                                    }
                                    i23 = i34 | i32;
                                    bArr2 = bArr;
                                    i25 = i14;
                                    i19 = i2;
                                    i22 = i13;
                                    i21 = i15;
                                    i24 = i27;
                                    i20 = i3;
                                }
                        }
                    } else {
                        int i36 = iZzx;
                        int i37 = i26;
                        if (iZzA != 27) {
                            i9 = i23;
                            i16 = i25;
                            if (iZzA <= 49) {
                                i6 = i27;
                                i10 = i36;
                                unsafe = unsafe2;
                                i18 = i30;
                                iZzi = zzv(t, bArr, i37, i2, i30, i6, i28, i36, i29, iZzA, j, zzikVar);
                                if (iZzi != i37) {
                                    zzlfVar2 = this;
                                    obj3 = t;
                                    bArr2 = bArr;
                                    i24 = i6;
                                    i19 = i2;
                                    i20 = i3;
                                    zzikVar3 = zzikVar;
                                    i22 = i10;
                                    i23 = i9;
                                    i25 = i16;
                                    i21 = i18;
                                    unsafe2 = unsafe;
                                } else {
                                    i4 = i3;
                                    i7 = iZzi;
                                    i25 = i16;
                                    i8 = i18;
                                }
                            } else {
                                i6 = i27;
                                i17 = i37;
                                i10 = i36;
                                unsafe = unsafe2;
                                i18 = i30;
                                if (iZzA != 50) {
                                    iZzi = zzt(t, bArr, i17, i2, i18, i6, i28, i29, iZzA, j, i10, zzikVar);
                                    if (iZzi != i17) {
                                        zzlfVar2 = this;
                                        obj3 = t;
                                        bArr2 = bArr;
                                        i24 = i6;
                                        i19 = i2;
                                        i20 = i3;
                                        zzikVar3 = zzikVar;
                                        i22 = i10;
                                        i23 = i9;
                                        i25 = i16;
                                        i21 = i18;
                                        unsafe2 = unsafe;
                                    } else {
                                        i4 = i3;
                                        i7 = iZzi;
                                        i25 = i16;
                                        i8 = i18;
                                    }
                                } else if (i28 == 2) {
                                    iZzi = zzs(t, bArr, i17, i2, i10, j, zzikVar);
                                    if (iZzi != i17) {
                                        zzlfVar2 = this;
                                        obj3 = t;
                                        bArr2 = bArr;
                                        i24 = i6;
                                        i19 = i2;
                                        i20 = i3;
                                        zzikVar3 = zzikVar;
                                        i22 = i10;
                                        i23 = i9;
                                        i25 = i16;
                                        i21 = i18;
                                        unsafe2 = unsafe;
                                    } else {
                                        i4 = i3;
                                        i7 = iZzi;
                                        i25 = i16;
                                        i8 = i18;
                                    }
                                }
                            }
                        } else if (i28 == 2) {
                            zzke zzkeVarZzd = (zzke) unsafe2.getObject(obj3, j);
                            if (!zzkeVarZzd.zzc()) {
                                int size = zzkeVarZzd.size();
                                zzkeVarZzd = zzkeVarZzd.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj3, j, zzkeVarZzd);
                            }
                            i21 = i30;
                            iZzi = zzil.zze(zzlfVar2.zzE(i36), i21, bArr, i37, i2, zzkeVarZzd, zzikVar);
                            i19 = i2;
                            i22 = i36;
                            i24 = i27;
                            i23 = i23;
                            i25 = i25;
                            bArr2 = bArr;
                            i20 = i3;
                        } else {
                            i9 = i23;
                            i16 = i25;
                            i17 = i37;
                            i6 = i27;
                            i10 = i36;
                            unsafe = unsafe2;
                            i18 = i30;
                        }
                        i4 = i3;
                        i7 = i17;
                        i25 = i16;
                        i8 = i18;
                    }
                }
                if (i8 != i4 || i4 == 0) {
                    if (this.zzh) {
                        zzikVar2 = zzikVar;
                        if (zzikVar2.zzd != zzjj.zza()) {
                            i11 = i6;
                            if (zzikVar2.zzd.zzc(this.zzg, i11) != null) {
                                throw null;
                            }
                            iZzi = zzil.zzi(i8, bArr, i7, i2, zzd(t), zzikVar);
                            obj2 = t;
                            i19 = i2;
                            i21 = i8;
                            zzlfVar2 = this;
                            zzikVar3 = zzikVar2;
                            i24 = i11;
                            obj3 = obj2;
                            i22 = i10;
                            i23 = i9;
                            unsafe2 = unsafe;
                            bArr2 = bArr;
                            i20 = i4;
                        } else {
                            obj2 = t;
                            i11 = i6;
                        }
                    } else {
                        obj2 = t;
                        i11 = i6;
                        zzikVar2 = zzikVar;
                    }
                    iZzi = zzil.zzi(i8, bArr, i7, i2, zzd(t), zzikVar);
                    i19 = i2;
                    i21 = i8;
                    zzlfVar2 = this;
                    zzikVar3 = zzikVar2;
                    i24 = i11;
                    obj3 = obj2;
                    i22 = i10;
                    i23 = i9;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i20 = i4;
                } else {
                    zzlfVar = this;
                    obj = t;
                    iZzi = i7;
                    i21 = i8;
                    i23 = i9;
                }
            } else {
                unsafe = unsafe2;
                i4 = i20;
                obj = obj3;
                zzlfVar = zzlfVar2;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final T zze() {
        return (T) ((zzjx) this.zzg).zzl(4, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final void zzf(T t) {
        int i;
        int i2 = this.zzk;
        while (true) {
            i = this.zzl;
            if (i2 >= i) {
                break;
            }
            long jZzB = zzB(this.zzj[i2]) & 1048575;
            Object objZzf = zzml.zzf(t, jZzB);
            if (objZzf != null) {
                ((zzkw) objZzf).zzc();
                zzml.zzs(t, jZzB, objZzf);
            }
            i2++;
        }
        int length = this.zzj.length;
        while (i < length) {
            this.zzm.zza(t, this.zzj[i]);
            i++;
        }
        this.zzn.zzg(t);
        if (this.zzh) {
            this.zzo.zzb(t);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final void zzh(T t, byte[] bArr, int i, int i2, zzik zzikVar) throws IOException {
        if (this.zzi) {
            zzu(t, bArr, i, i2, zzikVar);
        } else {
            zzc(t, bArr, i, i2, 0, zzikVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final boolean zzi(T t, T t2) {
        boolean zZzH;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzB = zzB(i);
            long j = iZzB & 1048575;
            switch (zzA(iZzB)) {
                case 0:
                    if (!zzL(t, t2, i) || Double.doubleToLongBits(zzml.zza(t, j)) != Double.doubleToLongBits(zzml.zza(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 1:
                    if (!zzL(t, t2, i) || Float.floatToIntBits(zzml.zzb(t, j)) != Float.floatToIntBits(zzml.zzb(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!zzL(t, t2, i) || zzml.zzd(t, j) != zzml.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 3:
                    if (!zzL(t, t2, i) || zzml.zzd(t, j) != zzml.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!zzL(t, t2, i) || zzml.zzc(t, j) != zzml.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!zzL(t, t2, i) || zzml.zzd(t, j) != zzml.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!zzL(t, t2, i) || zzml.zzc(t, j) != zzml.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!zzL(t, t2, i) || zzml.zzw(t, j) != zzml.zzw(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!zzL(t, t2, i) || !zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!zzL(t, t2, i) || !zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!zzL(t, t2, i) || !zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!zzL(t, t2, i) || zzml.zzc(t, j) != zzml.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!zzL(t, t2, i) || zzml.zzc(t, j) != zzml.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!zzL(t, t2, i) || zzml.zzc(t, j) != zzml.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!zzL(t, t2, i) || zzml.zzd(t, j) != zzml.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!zzL(t, t2, i) || zzml.zzc(t, j) != zzml.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!zzL(t, t2, i) || zzml.zzd(t, j) != zzml.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!zzL(t, t2, i) || !zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j))) {
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
                    zZzH = zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j));
                    break;
                case 50:
                    zZzH = zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j));
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
                    long jZzy = zzy(i) & 1048575;
                    if (zzml.zzc(t, jZzy) != zzml.zzc(t2, jZzy) || !zzlp.zzH(zzml.zzf(t, j), zzml.zzf(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!zZzH) {
                return false;
            }
        }
        if (!this.zzn.zzc(t).equals(this.zzn.zzc(t2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(t);
        this.zzo.zza(t2);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009e  */
    @Override // com.google.android.gms.internal.measurement.zzln
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzj(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzk) {
            int i6 = this.zzj[i5];
            int i7 = this.zzc[i6];
            int iZzB = zzB(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t, i9);
                }
                i2 = i4;
                i = i9;
            } else {
                i = i3;
                i2 = i4;
            }
            if ((268435456 & iZzB) != 0 && !zzN(t, i6, i, i2, i10)) {
                return false;
            }
            int iZzA = zzA(iZzB);
            if (iZzA == 9 || iZzA == 17) {
                if (zzN(t, i6, i, i2, i10) && !zzO(t, iZzB, zzE(i6))) {
                    return false;
                }
            } else if (iZzA == 27) {
                List list = (List) zzml.zzf(t, iZzB & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzln zzlnVarZzE = zzE(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzlnVarZzE.zzj(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (iZzA == 60 || iZzA == 68) {
                if (zzP(t, i7, i6) && !zzO(t, iZzB, zzE(i6))) {
                    return false;
                }
            } else if (iZzA != 49) {
                if (iZzA == 50 && !((zzkw) zzml.zzf(t, iZzB & 1048575)).isEmpty()) {
                    throw null;
                }
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(t);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final void zzm(T t, zzjf zzjfVar) throws IOException {
        if (!this.zzi) {
            zzR(t, zzjfVar);
            return;
        }
        if (this.zzh) {
            this.zzo.zza(t);
            throw null;
        }
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzB = zzB(i);
            int i2 = this.zzc[i];
            switch (zzA(iZzB)) {
                case 0:
                    if (zzM(t, i)) {
                        zzjfVar.zzf(i2, zzml.zza(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzM(t, i)) {
                        zzjfVar.zzo(i2, zzml.zzb(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzM(t, i)) {
                        zzjfVar.zzt(i2, zzml.zzd(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzM(t, i)) {
                        zzjfVar.zzJ(i2, zzml.zzd(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzM(t, i)) {
                        zzjfVar.zzr(i2, zzml.zzc(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzM(t, i)) {
                        zzjfVar.zzm(i2, zzml.zzd(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzM(t, i)) {
                        zzjfVar.zzk(i2, zzml.zzc(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzM(t, i)) {
                        zzjfVar.zzb(i2, zzml.zzw(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzM(t, i)) {
                        zzT(i2, zzml.zzf(t, iZzB & 1048575), zzjfVar);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (zzM(t, i)) {
                        zzjfVar.zzv(i2, zzml.zzf(t, iZzB & 1048575), zzE(i));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzM(t, i)) {
                        zzjfVar.zzd(i2, (zzix) zzml.zzf(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzM(t, i)) {
                        zzjfVar.zzH(i2, zzml.zzc(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzM(t, i)) {
                        zzjfVar.zzi(i2, zzml.zzc(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzM(t, i)) {
                        zzjfVar.zzw(i2, zzml.zzc(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzM(t, i)) {
                        zzjfVar.zzy(i2, zzml.zzd(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzM(t, i)) {
                        zzjfVar.zzA(i2, zzml.zzc(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzM(t, i)) {
                        zzjfVar.zzC(i2, zzml.zzd(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzM(t, i)) {
                        zzjfVar.zzq(i2, zzml.zzf(t, iZzB & 1048575), zzE(i));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    zzlp.zzL(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 19:
                    zzlp.zzP(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 20:
                    zzlp.zzS(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 21:
                    zzlp.zzaa(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 22:
                    zzlp.zzR(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 23:
                    zzlp.zzO(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 24:
                    zzlp.zzN(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 25:
                    zzlp.zzJ(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 26:
                    zzlp.zzY(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar);
                    break;
                case 27:
                    zzlp.zzT(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, zzE(i));
                    break;
                case 28:
                    zzlp.zzK(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar);
                    break;
                case 29:
                    zzlp.zzZ(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 30:
                    zzlp.zzM(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 31:
                    zzlp.zzU(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 32:
                    zzlp.zzV(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 33:
                    zzlp.zzW(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 34:
                    zzlp.zzX(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, false);
                    break;
                case 35:
                    zzlp.zzL(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 36:
                    zzlp.zzP(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 37:
                    zzlp.zzS(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 38:
                    zzlp.zzaa(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 39:
                    zzlp.zzR(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 40:
                    zzlp.zzO(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 41:
                    zzlp.zzN(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 42:
                    zzlp.zzJ(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 43:
                    zzlp.zzZ(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 44:
                    zzlp.zzM(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 45:
                    zzlp.zzU(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 46:
                    zzlp.zzV(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 47:
                    zzlp.zzW(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 48:
                    zzlp.zzX(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, true);
                    break;
                case 49:
                    zzlp.zzQ(this.zzc[i], (List) zzml.zzf(t, iZzB & 1048575), zzjfVar, zzE(i));
                    break;
                case 50:
                    zzS(zzjfVar, i2, zzml.zzf(t, iZzB & 1048575), i);
                    break;
                case 51:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzf(i2, zzn(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzo(i2, zzo(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzt(i2, zzC(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzJ(i2, zzC(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzr(i2, zzr(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzm(i2, zzC(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzk(i2, zzr(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzb(i2, zzQ(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzP(t, i2, i)) {
                        zzT(i2, zzml.zzf(t, iZzB & 1048575), zzjfVar);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzv(i2, zzml.zzf(t, iZzB & 1048575), zzE(i));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzd(i2, (zzix) zzml.zzf(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzH(i2, zzr(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzi(i2, zzr(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzw(i2, zzr(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzy(i2, zzC(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzA(i2, zzr(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzC(i2, zzC(t, iZzB & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzP(t, i2, i)) {
                        zzjfVar.zzq(i2, zzml.zzf(t, iZzB & 1048575), zzE(i));
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzmb<?, ?> zzmbVar = this.zzn;
        zzmbVar.zzi(zzmbVar.zzc(t), zzjfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final void zzg(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzB = zzB(i);
            long j = 1048575 & iZzB;
            int i2 = this.zzc[i];
            switch (zzA(iZzB)) {
                case 0:
                    if (zzM(t2, i)) {
                        zzml.zzo(t, j, zzml.zza(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzM(t2, i)) {
                        zzml.zzp(t, j, zzml.zzb(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzM(t2, i)) {
                        zzml.zzr(t, j, zzml.zzd(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzM(t2, i)) {
                        zzml.zzr(t, j, zzml.zzd(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzM(t2, i)) {
                        zzml.zzq(t, j, zzml.zzc(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzM(t2, i)) {
                        zzml.zzr(t, j, zzml.zzd(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzM(t2, i)) {
                        zzml.zzq(t, j, zzml.zzc(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzM(t2, i)) {
                        zzml.zzm(t, j, zzml.zzw(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzM(t2, i)) {
                        zzml.zzs(t, j, zzml.zzf(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzH(t, t2, i);
                    break;
                case 10:
                    if (zzM(t2, i)) {
                        zzml.zzs(t, j, zzml.zzf(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzM(t2, i)) {
                        zzml.zzq(t, j, zzml.zzc(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzM(t2, i)) {
                        zzml.zzq(t, j, zzml.zzc(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzM(t2, i)) {
                        zzml.zzq(t, j, zzml.zzc(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzM(t2, i)) {
                        zzml.zzr(t, j, zzml.zzd(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzM(t2, i)) {
                        zzml.zzq(t, j, zzml.zzc(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzM(t2, i)) {
                        zzml.zzr(t, j, zzml.zzd(t2, j));
                        zzJ(t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzH(t, t2, i);
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
                    this.zzm.zzb(t, t2, j);
                    break;
                case 50:
                    zzlp.zzI(this.zzq, t, t2, j);
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
                    if (zzP(t2, i2, i)) {
                        zzml.zzs(t, j, zzml.zzf(t2, j));
                        zzK(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzI(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzP(t2, i2, i)) {
                        zzml.zzs(t, j, zzml.zzf(t2, j));
                        zzK(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzI(t, t2, i);
                    break;
            }
        }
        zzlp.zzF(this.zzn, t, t2);
        if (this.zzh) {
            zzlp.zzE(this.zzo, t, t2);
        }
    }
}
