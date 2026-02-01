package com.google.android.gms.internal.wearable;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzea {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzep zzc;
    private static final zzep zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzep zzepVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzepVar = (zzep) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzepVar;
        zzd = new zzer();
    }

    public static void zzA(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzz(i, list, z);
    }

    public static void zzB(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzB(i, list, z);
    }

    public static void zzC(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzD(i, list, z);
    }

    public static void zzD(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzI(i, list, z);
    }

    public static void zzE(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzK(i, list, z);
    }

    static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int iZzu;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzch) {
            zzch zzchVar = (zzch) list;
            iZzu = 0;
            while (i < size) {
                iZzu += zzbp.zzu(zzchVar.zze(i));
                i++;
            }
        } else {
            iZzu = 0;
            while (i < size) {
                iZzu += zzbp.zzu(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzu;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbp.zzx(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbp.zzx(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int iZzu;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzch) {
            zzch zzchVar = (zzch) list;
            iZzu = 0;
            while (i < size) {
                iZzu += zzbp.zzu(zzchVar.zze(i));
                i++;
            }
        } else {
            iZzu = 0;
            while (i < size) {
                iZzu += zzbp.zzu(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzu;
    }

    static int zzg(List list) {
        int iZzy;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdc) {
            zzdc zzdcVar = (zzdc) list;
            iZzy = 0;
            while (i < size) {
                iZzy += zzbp.zzy(zzdcVar.zze(i));
                i++;
            }
        } else {
            iZzy = 0;
            while (i < size) {
                iZzy += zzbp.zzy(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzy;
    }

    static int zzh(int i, Object obj, zzdy zzdyVar) {
        if (!(obj instanceof zzct)) {
            return zzbp.zzx(i << 3) + zzbp.zzv((zzdn) obj, zzdyVar);
        }
        int i2 = zzbp.zzb;
        int iZza = ((zzct) obj).zza();
        return zzbp.zzx(i << 3) + zzbp.zzx(iZza) + iZza;
    }

    static int zzi(List list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzch) {
            zzch zzchVar = (zzch) list;
            iZzx = 0;
            while (i < size) {
                int iZze = zzchVar.zze(i);
                iZzx += zzbp.zzx((iZze >> 31) ^ (iZze + iZze));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzx += zzbp.zzx((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzx;
    }

    static int zzj(List list) {
        int iZzy;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdc) {
            zzdc zzdcVar = (zzdc) list;
            iZzy = 0;
            while (i < size) {
                long jZze = zzdcVar.zze(i);
                iZzy += zzbp.zzy((jZze >> 63) ^ (jZze + jZze));
                i++;
            }
        } else {
            iZzy = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzy += zzbp.zzy((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iZzy;
    }

    static int zzk(List list) {
        int iZzx;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzch) {
            zzch zzchVar = (zzch) list;
            iZzx = 0;
            while (i < size) {
                iZzx += zzbp.zzx(zzchVar.zze(i));
                i++;
            }
        } else {
            iZzx = 0;
            while (i < size) {
                iZzx += zzbp.zzx(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzx;
    }

    static int zzl(List list) {
        int iZzy;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdc) {
            zzdc zzdcVar = (zzdc) list;
            iZzy = 0;
            while (i < size) {
                iZzy += zzbp.zzy(zzdcVar.zze(i));
                i++;
            }
        } else {
            iZzy = 0;
            while (i < size) {
                iZzy += zzbp.zzy(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzy;
    }

    public static zzep zzm() {
        return zzc;
    }

    public static zzep zzn() {
        return zzd;
    }

    static Object zzo(Object obj, int i, int i2, Object obj2, zzep zzepVar) {
        if (obj2 == null) {
            obj2 = zzepVar.zzc(obj);
        }
        zzepVar.zzf(obj2, i, i2);
        return obj2;
    }

    static void zzp(zzep zzepVar, Object obj, Object obj2) {
        zzepVar.zzh(obj, zzepVar.zze(zzepVar.zzd(obj), zzepVar.zzd(obj2)));
    }

    public static void zzq(Class cls) {
        Class cls2;
        if (!zzcg.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzr(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzc(i, list, z);
    }

    public static void zzs(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzg(i, list, z);
    }

    public static void zzt(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzj(i, list, z);
    }

    public static void zzu(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzl(i, list, z);
    }

    public static void zzv(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzn(i, list, z);
    }

    public static void zzw(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzp(i, list, z);
    }

    public static void zzx(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzs(i, list, z);
    }

    public static void zzy(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzu(i, list, z);
    }

    public static void zzz(int i, List list, zzfh zzfhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfhVar.zzx(i, list, z);
    }
}
