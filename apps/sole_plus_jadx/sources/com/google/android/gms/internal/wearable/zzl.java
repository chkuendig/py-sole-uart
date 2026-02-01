package com.google.android.gms.internal.wearable;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzl {
    public static DataMap zza(zzk zzkVar) {
        DataMap dataMap = new DataMap();
        for (zzw zzwVar : zzkVar.zza.zze()) {
            zzd(zzkVar.zzb, dataMap, zzwVar.zzd(), zzwVar.zzb());
        }
        return dataMap;
    }

    public static zzk zzb(DataMap dataMap) {
        ArrayList arrayList = new ArrayList();
        zzn zznVarZza = zzx.zza();
        TreeSet treeSet = new TreeSet(dataMap.keySet());
        ArrayList arrayList2 = new ArrayList();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object obj = dataMap.get(str);
            zzo zzoVarZza = zzw.zza();
            zzoVarZza.zza(str);
            zzoVarZza.zzb(zzc(arrayList, obj));
            arrayList2.add((zzw) zzoVarZza.zzq());
        }
        zznVarZza.zza(arrayList2);
        return new zzk((zzx) zznVarZza.zzq(), arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x01bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.internal.wearable.zzv zzc(java.util.List r13, java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.wearable.zzl.zzc(java.util.List, java.lang.Object):com.google.android.gms.internal.wearable.zzv");
    }

    private static void zzd(List list, DataMap dataMap, String str, zzv zzvVar) {
        int iZzf = zzvVar.zzf();
        if (iZzf == 14) {
            dataMap.putString(str, null);
            return;
        }
        zzu zzuVarZzb = zzvVar.zzb();
        if (iZzf == 1) {
            dataMap.putByteArray(str, zzuVarZzb.zzk().zzo());
            return;
        }
        int i = 0;
        if (iZzf == 11) {
            dataMap.putStringArray(str, (String[]) zzuVarZzb.zzq().toArray(new String[0]));
            return;
        }
        if (iZzf == 12) {
            Object[] array = zzuVarZzb.zzp().toArray();
            int length = array.length;
            long[] jArr = new long[length];
            while (i < length) {
                Object obj = array[i];
                obj.getClass();
                jArr[i] = ((Number) obj).longValue();
                i++;
            }
            dataMap.putLongArray(str, jArr);
            return;
        }
        if (iZzf == 15) {
            Object[] array2 = zzuVarZzb.zzo().toArray();
            int length2 = array2.length;
            float[] fArr = new float[length2];
            while (i < length2) {
                Object obj2 = array2[i];
                obj2.getClass();
                fArr[i] = ((Number) obj2).floatValue();
                i++;
            }
            dataMap.putFloatArray(str, fArr);
            return;
        }
        if (iZzf == 2) {
            dataMap.putString(str, zzuVarZzb.zzl());
            return;
        }
        if (iZzf == 3) {
            dataMap.putDouble(str, zzuVarZzb.zza());
            return;
        }
        if (iZzf == 4) {
            dataMap.putFloat(str, zzuVarZzb.zzb());
            return;
        }
        if (iZzf == 5) {
            dataMap.putLong(str, zzuVarZzb.zzg());
            return;
        }
        if (iZzf == 6) {
            dataMap.putInt(str, zzuVarZzb.zze());
            return;
        }
        if (iZzf == 7) {
            dataMap.putByte(str, (byte) zzuVarZzb.zzd());
            return;
        }
        if (iZzf == 8) {
            dataMap.putBoolean(str, zzuVarZzb.zzF());
            return;
        }
        if (iZzf == 13) {
            dataMap.putAsset(str, (Asset) list.get((int) zzuVarZzb.zzf()));
            return;
        }
        if (iZzf == 9) {
            DataMap dataMap2 = new DataMap();
            for (zzw zzwVar : zzuVarZzb.zzn()) {
                zzd(list, dataMap2, zzwVar.zzd(), zzwVar.zzb());
            }
            dataMap.putDataMap(str, dataMap2);
            return;
        }
        if (iZzf != 10) {
            throw new RuntimeException("populateBundle: unexpected type ".concat(Integer.toString(iZzf)));
        }
        int iZzf2 = 14;
        for (zzv zzvVar2 : zzuVarZzb.zzm()) {
            if (iZzf2 != 14) {
                if (zzvVar2.zzf() != iZzf2) {
                    throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + Integer.toString(iZzf2) + " and " + Integer.toString(zzvVar2.zzf()));
                }
            } else if (zzvVar2.zzf() == 9 || zzvVar2.zzf() == 2 || zzvVar2.zzf() == 6) {
                iZzf2 = zzvVar2.zzf();
            } else if (zzvVar2.zzf() != 14) {
                throw new IllegalArgumentException("Unexpected TypedValue type: " + Integer.toString(zzvVar2.zzf()) + " for key " + str);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>(zzuVarZzb.zzc());
        for (zzv zzvVar3 : zzuVarZzb.zzm()) {
            if (zzvVar3.zzf() == 14) {
                arrayList.add(null);
            } else if (iZzf2 == 9) {
                DataMap dataMap3 = new DataMap();
                for (zzw zzwVar2 : zzvVar3.zzb().zzn()) {
                    zzd(list, dataMap3, zzwVar2.zzd(), zzwVar2.zzb());
                }
                arrayList.add(dataMap3);
            } else if (iZzf2 == 2) {
                arrayList.add(zzvVar3.zzb().zzl());
            } else {
                if (iZzf2 != 6) {
                    throw new IllegalArgumentException("Unexpected typeOfArrayList: ".concat(Integer.toString(iZzf2)));
                }
                arrayList.add(Integer.valueOf(zzvVar3.zzb().zze()));
            }
        }
        if (iZzf2 == 14) {
            dataMap.putStringArrayList(str, arrayList);
            return;
        }
        if (iZzf2 == 9) {
            dataMap.putDataMapArrayList(str, arrayList);
        } else if (iZzf2 == 2) {
            dataMap.putStringArrayList(str, arrayList);
        } else {
            if (iZzf2 != 6) {
                throw new IllegalStateException("Unexpected typeOfArrayList: ".concat(Integer.toString(iZzf2)));
            }
            dataMap.putIntegerArrayList(str, arrayList);
        }
    }
}
