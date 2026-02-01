package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
/* loaded from: classes4.dex */
public final class zzbe {
    private static zzaf zza(zzaf zzafVar, zzh zzhVar, zzal zzalVar, Boolean bool, Boolean bool2) {
        zzaf zzafVar2 = new zzaf();
        Iterator<Integer> itZzg = zzafVar.zzg();
        while (itZzg.hasNext()) {
            int iIntValue = itZzg.next().intValue();
            if (zzafVar.zzc(iIntValue)) {
                zzaq zzaqVarZza = zzalVar.zza(zzhVar, Arrays.asList(zzafVar.zza(iIntValue), new zzai(Double.valueOf(iIntValue)), zzafVar));
                if (zzaqVarZza.zzd().equals(bool)) {
                    return zzafVar2;
                }
                if (bool2 == null || zzaqVarZza.zzd().equals(bool2)) {
                    zzafVar2.zzb(iIntValue, zzaqVarZza);
                }
            }
        }
        return zzafVar2;
    }

    private static zzaf zza(zzaf zzafVar, zzh zzhVar, zzal zzalVar) {
        return zza(zzafVar, zzhVar, zzalVar, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:4:0x003c A[PHI: r17
      0x003c: PHI (r17v7 char) = 
      (r17v0 char)
      (r17v0 char)
      (r17v2 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v0 char)
      (r17v5 char)
      (r17v0 char)
     binds: [B:3:0x0039, B:79:0x011c, B:81:0x0120, B:75:0x010d, B:71:0x0100, B:66:0x00f0, B:62:0x00e3, B:58:0x00d9, B:54:0x00cf, B:50:0x00c1, B:46:0x00b7, B:42:0x00ad, B:38:0x00a3, B:34:0x0096, B:30:0x008b, B:26:0x0080, B:22:0x0075, B:18:0x006a, B:14:0x005f, B:10:0x0051, B:69:0x00f5, B:6:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.measurement.zzaq zza(java.lang.String r21, com.google.android.gms.internal.measurement.zzaf r22, com.google.android.gms.internal.measurement.zzh r23, java.util.List<com.google.android.gms.internal.measurement.zzaq> r24) {
        /*
            Method dump skipped, instructions count: 2044
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbe.zza(java.lang.String, com.google.android.gms.internal.measurement.zzaf, com.google.android.gms.internal.measurement.zzh, java.util.List):com.google.android.gms.internal.measurement.zzaq");
    }

    private static zzaq zza(zzaf zzafVar, zzh zzhVar, List<zzaq> list, boolean z) {
        zzaq zzaqVarZza;
        zzg.zzb("reduce", 1, list);
        zzg.zzc("reduce", 2, list);
        zzaq zzaqVarZza2 = zzhVar.zza(list.get(0));
        if (!(zzaqVarZza2 instanceof zzal)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (list.size() == 2) {
            zzaqVarZza = zzhVar.zza(list.get(1));
            if (zzaqVarZza instanceof zzaj) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (zzafVar.zzb() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            zzaqVarZza = null;
        }
        zzal zzalVar = (zzal) zzaqVarZza2;
        int iZzb = zzafVar.zzb();
        int i = z ? 0 : iZzb - 1;
        int i2 = z ? iZzb - 1 : 0;
        int i3 = z ? 1 : -1;
        if (zzaqVarZza == null) {
            zzaqVarZza = zzafVar.zza(i);
            i += i3;
        }
        while ((i2 - i) * i3 >= 0) {
            if (zzafVar.zzc(i)) {
                zzaqVarZza = zzalVar.zza(zzhVar, Arrays.asList(zzaqVarZza, zzafVar.zza(i), new zzai(Double.valueOf(i)), zzafVar));
                if (zzaqVarZza instanceof zzaj) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i += i3;
            } else {
                i += i3;
            }
        }
        return zzaqVarZza;
    }
}
