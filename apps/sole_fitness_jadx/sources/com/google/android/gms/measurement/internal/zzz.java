package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzoa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzz extends zzki {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzt> zzc;
    private Long zzd;
    private Long zze;

    zzz(zzks zzksVar) {
        super(zzksVar);
    }

    private final zzt zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzt zztVar = new zzt(this, this.zza, null);
        this.zzc.put(num, zztVar);
        return zztVar;
    }

    private final boolean zzf(int i, int i2) {
        zzt zztVar = this.zzc.get(Integer.valueOf(i));
        if (zztVar == null) {
            return false;
        }
        return zztVar.zze.get(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:400:0x0a1e, code lost:
    
        r0 = r65.zzs.zzay().zzk();
        r6 = com.google.android.gms.measurement.internal.zzel.zzn(r65.zza);
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0a32, code lost:
    
        if (r7.zzj() == false) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0a34, code lost:
    
        r7 = java.lang.Integer.valueOf(r7.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0a3d, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0a3e, code lost:
    
        r0.zzc("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r7));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02e1 A[PHI: r0 r5
      0x02e1: PHI (r0v64 java.util.Map) = (r0v46 java.util.Map), (r0v66 java.util.Map), (r0v40 java.util.Map) binds: [B:129:0x030e, B:118:0x02e9, B:115:0x02df] A[DONT_GENERATE, DONT_INLINE]
      0x02e1: PHI (r5v16 android.database.Cursor) = (r5v9 android.database.Cursor), (r5v17 android.database.Cursor), (r5v17 android.database.Cursor) binds: [B:129:0x030e, B:118:0x02e9, B:115:0x02df] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x072a A[PHI: r0 r11 r13 r25 r28 r29
      0x072a: PHI (r0v97 java.util.Map) = (r0v99 java.util.Map), (r0v108 java.util.Map) binds: [B:294:0x0760, B:278:0x0728] A[DONT_GENERATE, DONT_INLINE]
      0x072a: PHI (r11v14 android.database.Cursor) = (r11v15 android.database.Cursor), (r11v17 android.database.Cursor) binds: [B:294:0x0760, B:278:0x0728] A[DONT_GENERATE, DONT_INLINE]
      0x072a: PHI (r13v12 java.lang.String) = (r13v13 java.lang.String), (r13v16 java.lang.String) binds: [B:294:0x0760, B:278:0x0728] A[DONT_GENERATE, DONT_INLINE]
      0x072a: PHI (r25v4 java.lang.String) = (r25v5 java.lang.String), (r25v7 java.lang.String) binds: [B:294:0x0760, B:278:0x0728] A[DONT_GENERATE, DONT_INLINE]
      0x072a: PHI (r28v7 java.lang.String) = (r28v8 java.lang.String), (r28v13 java.lang.String) binds: [B:294:0x0760, B:278:0x0728] A[DONT_GENERATE, DONT_INLINE]
      0x072a: PHI (r29v7 java.lang.String) = (r29v8 java.lang.String), (r29v14 java.lang.String) binds: [B:294:0x0760, B:278:0x0728] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0785  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x082d  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x08f8 A[PHI: r0 r13 r67
      0x08f8: PHI (r0v150 java.util.Map) = (r0v152 java.util.Map), (r0v158 java.util.Map) binds: [B:365:0x091e, B:354:0x08f6] A[DONT_GENERATE, DONT_INLINE]
      0x08f8: PHI (r13v31 android.database.Cursor) = (r13v32 android.database.Cursor), (r13v33 android.database.Cursor) binds: [B:365:0x091e, B:354:0x08f6] A[DONT_GENERATE, DONT_INLINE]
      0x08f8: PHI (r67v7 java.util.Iterator<com.google.android.gms.internal.measurement.zzgh>) = 
      (r67v8 java.util.Iterator<com.google.android.gms.internal.measurement.zzgh>)
      (r67v11 java.util.Iterator<com.google.android.gms.internal.measurement.zzgh>)
     binds: [B:365:0x091e, B:354:0x08f6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0941  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0a7b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0153 A[PHI: r0 r5
      0x0153: PHI (r0v207 java.util.Map) = (r0v206 java.util.Map), (r0v211 java.util.Map) binds: [B:53:0x0175, B:42:0x0151] A[DONT_GENERATE, DONT_INLINE]
      0x0153: PHI (r5v43 android.database.Cursor) = (r5v42 android.database.Cursor), (r5v44 android.database.Cursor) binds: [B:53:0x0175, B:42:0x0151] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b4 A[Catch: SQLiteException -> 0x0228, all -> 0x0b0b, TRY_LEAVE, TryCatch #12 {SQLiteException -> 0x0228, blocks: (B:61:0x01ae, B:63:0x01b4, B:67:0x01c4, B:68:0x01c9, B:69:0x01d3, B:70:0x01e3, B:72:0x01f2), top: B:450:0x01ae }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c4 A[Catch: SQLiteException -> 0x0228, all -> 0x0b0b, TRY_ENTER, TryCatch #12 {SQLiteException -> 0x0228, blocks: (B:61:0x01ae, B:63:0x01b4, B:67:0x01c4, B:68:0x01c9, B:69:0x01d3, B:70:0x01e3, B:72:0x01f2), top: B:450:0x01ae }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0251  */
    /* JADX WARN: Type inference failed for: r4v45, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v45, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final List<com.google.android.gms.internal.measurement.zzfk> zza(String str, List<com.google.android.gms.internal.measurement.zzfo> list, List<com.google.android.gms.internal.measurement.zzgh> list2, Long l, Long l2) throws Throwable {
        int i;
        int i2;
        boolean z;
        Cursor cursor;
        Map map;
        zzaj zzajVarZzi;
        String str2;
        Cursor cursor2;
        String str3;
        String str4;
        Cursor cursorQuery;
        Map map2;
        Map map3;
        Iterator it;
        List<com.google.android.gms.internal.measurement.zzej> list3;
        String str5;
        String str6;
        Cursor cursorRawQuery;
        Iterator it2;
        Map map4;
        Iterator it3;
        zzap zzapVar;
        zzv zzvVar;
        Iterator<com.google.android.gms.internal.measurement.zzfo> it4;
        String str7;
        String str8;
        Iterator it5;
        Map map5;
        Iterator it6;
        Cursor cursor3;
        Cursor cursorQuery2;
        ArrayMap arrayMap;
        List arrayList;
        Iterator<com.google.android.gms.internal.measurement.zzgh> it7;
        String str9;
        String str10;
        Iterator it8;
        Map map6;
        Cursor cursor4;
        Cursor cursorQuery3;
        List arrayList2;
        Iterator<Integer> it9;
        ArrayMap arrayMap2;
        Cursor cursorQuery4;
        List arrayList3;
        String str11 = "current_results";
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator<com.google.android.gms.internal.measurement.zzfo> it10 = list.iterator();
        while (true) {
            i = 0;
            i2 = 1;
            if (!it10.hasNext()) {
                z = false;
                break;
            }
            if ("_s".equals(it10.next().zzh())) {
                z = true;
                break;
            }
        }
        zzoa.zzc();
        boolean zZzs = this.zzs.zzf().zzs(this.zza, zzdy.zzY);
        zzoa.zzc();
        boolean zZzs2 = this.zzs.zzf().zzs(this.zza, zzdy.zzX);
        if (z) {
            zzaj zzajVarZzi2 = this.zzf.zzi();
            String str12 = this.zza;
            zzajVarZzi2.zzY();
            zzajVarZzi2.zzg();
            Preconditions.checkNotEmpty(str12);
            ContentValues contentValues = new ContentValues();
            ?? r5 = "current_session_count";
            contentValues.put("current_session_count", (Integer) 0);
            try {
                r5 = new String[]{str12};
                zzajVarZzi2.zzh().update("events", contentValues, "app_id = ?", r5);
                cursor = r5;
            } catch (SQLiteException e) {
                zzajVarZzi2.zzs.zzay().zzd().zzc("Error resetting session-scoped event counts. appId", zzel.zzn(str12), e);
                cursor = r5;
            }
        }
        Map mapEmptyMap = Collections.emptyMap();
        String str13 = "Failed to merge filter. appId";
        String str14 = "Database error querying filters. appId";
        String str15 = "data";
        String str16 = "audience_id";
        if (zZzs2 && zZzs) {
            zzaj zzajVarZzi3 = this.zzf.zzi();
            String str17 = this.zza;
            Preconditions.checkNotEmpty(str17);
            ArrayMap arrayMap3 = new ArrayMap();
            try {
                try {
                    cursorQuery4 = zzajVarZzi3.zzh().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str17}, null, null, null);
                    try {
                    } catch (SQLiteException e2) {
                        e = e2;
                        zzajVarZzi3.zzs.zzay().zzd().zzc("Database error querying filters. appId", zzel.zzn(str17), e);
                        mapEmptyMap = Collections.emptyMap();
                        if (cursorQuery4 != null) {
                        }
                        map = mapEmptyMap;
                        zzajVarZzi = this.zzf.zzi();
                        str2 = this.zza;
                        zzajVarZzi.zzY();
                        zzajVarZzi.zzg();
                        Preconditions.checkNotEmpty(str2);
                        cursorQuery = zzajVarZzi.zzh().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str2}, null, null, null);
                        try {
                            try {
                                if (cursorQuery.moveToFirst()) {
                                }
                            } catch (SQLiteException e3) {
                                e = e3;
                                str3 = "audience_id";
                            }
                            if (!map2.isEmpty()) {
                            }
                            String str18 = str14;
                            String str19 = str13;
                            String str20 = str3;
                            String str21 = str4;
                            zzu zzuVar = null;
                            if (!list.isEmpty()) {
                            }
                            String str22 = str11;
                            if (!list2.isEmpty()) {
                            }
                            String str23 = str20;
                            ArrayList arrayList4 = new ArrayList();
                            Set<Integer> setKeySet = this.zzc.keySet();
                            setKeySet.removeAll(this.zzb);
                            it9 = setKeySet.iterator();
                            while (it9.hasNext()) {
                            }
                            return arrayList4;
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursorQuery;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursorQuery4 = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
            if (cursorQuery4.moveToFirst()) {
                while (true) {
                    try {
                        com.google.android.gms.internal.measurement.zzej zzejVarZzaA = ((com.google.android.gms.internal.measurement.zzei) zzku.zzl(com.google.android.gms.internal.measurement.zzej.zzc(), cursorQuery4.getBlob(i2))).zzaA();
                        if (zzejVarZzaA.zzo()) {
                            Integer numValueOf = Integer.valueOf(cursorQuery4.getInt(i));
                            List list4 = (List) arrayMap3.get(numValueOf);
                            if (list4 == null) {
                                arrayList3 = new ArrayList();
                                arrayMap3.put(numValueOf, arrayList3);
                            } else {
                                arrayList3 = list4;
                            }
                            arrayList3.add(zzejVarZzaA);
                        }
                    } catch (IOException e5) {
                        zzajVarZzi3.zzs.zzay().zzd().zzc("Failed to merge filter. appId", zzel.zzn(str17), e5);
                    }
                    if (!cursorQuery4.moveToNext()) {
                        break;
                    }
                    i = 0;
                    i2 = 1;
                }
                if (cursorQuery4 != null) {
                    cursorQuery4.close();
                }
                map = arrayMap3;
            } else {
                mapEmptyMap = Collections.emptyMap();
                if (cursorQuery4 != null) {
                    cursorQuery4.close();
                }
                map = mapEmptyMap;
            }
        } else {
            map = mapEmptyMap;
        }
        zzajVarZzi = this.zzf.zzi();
        str2 = this.zza;
        zzajVarZzi.zzY();
        zzajVarZzi.zzg();
        Preconditions.checkNotEmpty(str2);
        try {
            cursorQuery = zzajVarZzi.zzh().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str2}, null, null, null);
            if (cursorQuery.moveToFirst()) {
                Map mapEmptyMap2 = Collections.emptyMap();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                map2 = mapEmptyMap2;
                str3 = "audience_id";
                str4 = "data";
            } else {
                ArrayMap arrayMap4 = new ArrayMap();
                while (true) {
                    int i3 = cursorQuery.getInt(0);
                    try {
                        arrayMap4.put(Integer.valueOf(i3), ((com.google.android.gms.internal.measurement.zzgc) zzku.zzl(com.google.android.gms.internal.measurement.zzgd.zzf(), cursorQuery.getBlob(1))).zzaA());
                        arrayMap2 = arrayMap4;
                        str3 = str16;
                        str4 = str15;
                    } catch (IOException e6) {
                        arrayMap2 = arrayMap4;
                        str3 = str16;
                        try {
                            str4 = str15;
                            try {
                                zzajVarZzi.zzs.zzay().zzd().zzd("Failed to merge filter results. appId, audienceId, error", zzel.zzn(str2), Integer.valueOf(i3), e6);
                            } catch (SQLiteException e7) {
                                e = e7;
                                zzajVarZzi.zzs.zzay().zzd().zzc("Database error querying filter results. appId", zzel.zzn(str2), e);
                                Map mapEmptyMap3 = Collections.emptyMap();
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                map2 = mapEmptyMap3;
                                if (!map2.isEmpty()) {
                                }
                                String str182 = str14;
                                String str192 = str13;
                                String str202 = str3;
                                String str212 = str4;
                                zzu zzuVar2 = null;
                                if (!list.isEmpty()) {
                                }
                                String str222 = str11;
                                if (!list2.isEmpty()) {
                                }
                                String str232 = str202;
                                ArrayList arrayList42 = new ArrayList();
                                Set<Integer> setKeySet2 = this.zzc.keySet();
                                setKeySet2.removeAll(this.zzb);
                                it9 = setKeySet2.iterator();
                                while (it9.hasNext()) {
                                }
                                return arrayList42;
                            }
                        } catch (SQLiteException e8) {
                            e = e8;
                            str4 = str15;
                            zzajVarZzi.zzs.zzay().zzd().zzc("Database error querying filter results. appId", zzel.zzn(str2), e);
                            Map mapEmptyMap32 = Collections.emptyMap();
                            if (cursorQuery != null) {
                            }
                            map2 = mapEmptyMap32;
                            if (!map2.isEmpty()) {
                            }
                            String str1822 = str14;
                            String str1922 = str13;
                            String str2022 = str3;
                            String str2122 = str4;
                            zzu zzuVar22 = null;
                            if (!list.isEmpty()) {
                            }
                            String str2222 = str11;
                            if (!list2.isEmpty()) {
                            }
                            String str2322 = str2022;
                            ArrayList arrayList422 = new ArrayList();
                            Set<Integer> setKeySet22 = this.zzc.keySet();
                            setKeySet22.removeAll(this.zzb);
                            it9 = setKeySet22.iterator();
                            while (it9.hasNext()) {
                            }
                            return arrayList422;
                        }
                    }
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    arrayMap4 = arrayMap2;
                    str16 = str3;
                    str15 = str4;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                map2 = arrayMap2;
            }
        } catch (SQLiteException e9) {
            e = e9;
            str3 = "audience_id";
            str4 = "data";
            cursorQuery = null;
        } catch (Throwable th4) {
            th = th4;
            cursor2 = null;
        }
        if (!map2.isEmpty()) {
            HashSet hashSet = new HashSet(map2.keySet());
            if (z) {
                String str24 = this.zza;
                Preconditions.checkNotEmpty(str24);
                Preconditions.checkNotNull(map2);
                ArrayMap arrayMap5 = new ArrayMap();
                if (!map2.isEmpty()) {
                    zzaj zzajVarZzi4 = this.zzf.zzi();
                    zzajVarZzi4.zzY();
                    zzajVarZzi4.zzg();
                    Preconditions.checkNotEmpty(str24);
                    Map arrayMap6 = new ArrayMap();
                    ?? Zzh = zzajVarZzi4.zzh();
                    try {
                        try {
                            cursorRawQuery = Zzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str24, str24});
                            try {
                            } catch (SQLiteException e10) {
                                e = e10;
                                zzajVarZzi4.zzs.zzay().zzd().zzc("Database error querying scoped filters. appId", zzel.zzn(str24), e);
                                arrayMap6 = Collections.emptyMap();
                                if (cursorRawQuery != null) {
                                }
                                it2 = map2.keySet().iterator();
                                while (it2.hasNext()) {
                                }
                                map3 = arrayMap5;
                                it = hashSet.iterator();
                                while (it.hasNext()) {
                                }
                                String str18222 = str14;
                                String str19222 = str13;
                                String str20222 = str3;
                                String str21222 = str4;
                                zzu zzuVar222 = null;
                                if (!list.isEmpty()) {
                                }
                                String str22222 = str11;
                                if (!list2.isEmpty()) {
                                }
                                String str23222 = str20222;
                                ArrayList arrayList4222 = new ArrayList();
                                Set<Integer> setKeySet222 = this.zzc.keySet();
                                setKeySet222.removeAll(this.zzb);
                                it9 = setKeySet222.iterator();
                                while (it9.hasNext()) {
                                }
                                return arrayList4222;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            if (Zzh != 0) {
                                Zzh.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e11) {
                        e = e11;
                        cursorRawQuery = null;
                    } catch (Throwable th6) {
                        th = th6;
                        Zzh = 0;
                        if (Zzh != 0) {
                        }
                        throw th;
                    }
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            Integer numValueOf2 = Integer.valueOf(cursorRawQuery.getInt(0));
                            List arrayList5 = (List) arrayMap6.get(numValueOf2);
                            if (arrayList5 == null) {
                                arrayList5 = new ArrayList();
                                arrayMap6.put(numValueOf2, arrayList5);
                            }
                            arrayList5.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                        } while (cursorRawQuery.moveToNext());
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        it2 = map2.keySet().iterator();
                        while (it2.hasNext()) {
                            int iIntValue = ((Integer) it2.next()).intValue();
                            Integer numValueOf3 = Integer.valueOf(iIntValue);
                            com.google.android.gms.internal.measurement.zzgd zzgdVar = (com.google.android.gms.internal.measurement.zzgd) map2.get(numValueOf3);
                            List<Integer> list5 = (List) arrayMap6.get(numValueOf3);
                            if (list5 == null || list5.isEmpty()) {
                                map4 = arrayMap6;
                                it3 = it2;
                                arrayMap5.put(numValueOf3, zzgdVar);
                                arrayMap6 = map4;
                                it2 = it3;
                            } else {
                                map4 = arrayMap6;
                                List<Long> listZzr = this.zzf.zzu().zzr(zzgdVar.zzk(), list5);
                                if (listZzr.isEmpty()) {
                                    arrayMap6 = map4;
                                } else {
                                    com.google.android.gms.internal.measurement.zzgc zzgcVarZzbv = zzgdVar.zzbv();
                                    zzgcVarZzbv.zze();
                                    zzgcVarZzbv.zzb(listZzr);
                                    it3 = it2;
                                    List<Long> listZzr2 = this.zzf.zzu().zzr(zzgdVar.zzn(), list5);
                                    zzgcVarZzbv.zzf();
                                    zzgcVarZzbv.zzd(listZzr2);
                                    for (int i4 = 0; i4 < zzgdVar.zza(); i4++) {
                                        if (list5.contains(Integer.valueOf(zzgdVar.zze(i4).zza()))) {
                                            zzgcVarZzbv.zzg(i4);
                                        }
                                    }
                                    for (int i5 = 0; i5 < zzgdVar.zzc(); i5++) {
                                        if (list5.contains(Integer.valueOf(zzgdVar.zzi(i5).zzb()))) {
                                            zzgcVarZzbv.zzh(i5);
                                        }
                                    }
                                    arrayMap5.put(Integer.valueOf(iIntValue), zzgcVarZzbv.zzaA());
                                    arrayMap6 = map4;
                                    it2 = it3;
                                }
                            }
                        }
                    } else {
                        arrayMap6 = Collections.emptyMap();
                        if (cursorRawQuery != null) {
                        }
                        it2 = map2.keySet().iterator();
                        while (it2.hasNext()) {
                        }
                    }
                }
                map3 = arrayMap5;
            } else {
                map3 = map2;
            }
            it = hashSet.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                com.google.android.gms.internal.measurement.zzgd zzgdVar2 = (com.google.android.gms.internal.measurement.zzgd) map3.get(Integer.valueOf(iIntValue2));
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap7 = new ArrayMap();
                if (zzgdVar2 != null && zzgdVar2.zza() != 0) {
                    for (com.google.android.gms.internal.measurement.zzfm zzfmVar : zzgdVar2.zzj()) {
                        if (zzfmVar.zzh()) {
                            arrayMap7.put(Integer.valueOf(zzfmVar.zza()), zzfmVar.zzg() ? Long.valueOf(zzfmVar.zzb()) : null);
                        }
                    }
                }
                ArrayMap arrayMap8 = new ArrayMap();
                if (zzgdVar2 != null && zzgdVar2.zzc() != 0) {
                    Iterator<com.google.android.gms.internal.measurement.zzgf> it11 = zzgdVar2.zzm().iterator();
                    while (it11.hasNext()) {
                        com.google.android.gms.internal.measurement.zzgf next = it11.next();
                        if (next.zzi() && next.zza() > 0) {
                            arrayMap8.put(Integer.valueOf(next.zzb()), Long.valueOf(next.zzc(next.zza() - 1)));
                            map3 = map3;
                            it11 = it11;
                        }
                    }
                }
                Map map7 = map3;
                if (zzgdVar2 != null) {
                    int i6 = 0;
                    while (i6 < zzgdVar2.zzd() * 64) {
                        if (zzku.zzw(zzgdVar2.zzn(), i6)) {
                            str5 = str14;
                            str6 = str13;
                            this.zzs.zzay().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue2), Integer.valueOf(i6));
                            bitSet2.set(i6);
                            if (zzku.zzw(zzgdVar2.zzk(), i6)) {
                                bitSet.set(i6);
                            }
                            i6++;
                            str14 = str5;
                            str13 = str6;
                        } else {
                            str5 = str14;
                            str6 = str13;
                        }
                        arrayMap7.remove(Integer.valueOf(i6));
                        i6++;
                        str14 = str5;
                        str13 = str6;
                    }
                }
                String str25 = str14;
                String str26 = str13;
                Integer numValueOf4 = Integer.valueOf(iIntValue2);
                com.google.android.gms.internal.measurement.zzgd zzgdVar3 = (com.google.android.gms.internal.measurement.zzgd) map2.get(numValueOf4);
                if (zZzs2 && zZzs && (list3 = (List) map.get(numValueOf4)) != null && this.zze != null && this.zzd != null) {
                    for (com.google.android.gms.internal.measurement.zzej zzejVar : list3) {
                        int iZzb = zzejVar.zzb();
                        long jLongValue = this.zze.longValue() / 1000;
                        if (zzejVar.zzm()) {
                            jLongValue = this.zzd.longValue() / 1000;
                        }
                        Integer numValueOf5 = Integer.valueOf(iZzb);
                        if (arrayMap7.containsKey(numValueOf5)) {
                            arrayMap7.put(numValueOf5, Long.valueOf(jLongValue));
                        }
                        if (arrayMap8.containsKey(numValueOf5)) {
                            arrayMap8.put(numValueOf5, Long.valueOf(jLongValue));
                        }
                    }
                }
                this.zzc.put(Integer.valueOf(iIntValue2), new zzt(this, this.zza, zzgdVar3, bitSet, bitSet2, arrayMap7, arrayMap8, null));
                map2 = map2;
                str14 = str25;
                map = map;
                map3 = map7;
                str13 = str26;
            }
        }
        String str182222 = str14;
        String str192222 = str13;
        String str202222 = str3;
        String str212222 = str4;
        zzu zzuVar2222 = null;
        if (!list.isEmpty()) {
            zzv zzvVar2 = new zzv(this, zzuVar2222);
            ArrayMap arrayMap9 = new ArrayMap();
            Iterator<com.google.android.gms.internal.measurement.zzfo> it12 = list.iterator();
            while (it12.hasNext()) {
                com.google.android.gms.internal.measurement.zzfo next2 = it12.next();
                com.google.android.gms.internal.measurement.zzfo zzfoVarZza = zzvVar2.zza(this.zza, next2);
                if (zzfoVarZza != null) {
                    zzaj zzajVarZzi5 = this.zzf.zzi();
                    String str27 = this.zza;
                    String strZzh = zzfoVarZza.zzh();
                    zzap zzapVarZzn = zzajVarZzi5.zzn(str27, next2.zzh());
                    if (zzapVarZzn == null) {
                        zzajVarZzi5.zzs.zzay().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzel.zzn(str27), zzajVarZzi5.zzs.zzj().zzd(strZzh));
                        zzapVar = new zzap(str27, next2.zzh(), 1L, 1L, 1L, next2.zzd(), 0L, null, null, null, null);
                    } else {
                        zzapVar = new zzap(zzapVarZzn.zza, zzapVarZzn.zzb, zzapVarZzn.zzc + 1, zzapVarZzn.zzd + 1, zzapVarZzn.zze + 1, zzapVarZzn.zzf, zzapVarZzn.zzg, zzapVarZzn.zzh, zzapVarZzn.zzi, zzapVarZzn.zzj, zzapVarZzn.zzk);
                    }
                    this.zzf.zzi().zzF(zzapVar);
                    long j = zzapVar.zzc;
                    String strZzh2 = zzfoVarZza.zzh();
                    Map mapEmptyMap4 = (Map) arrayMap9.get(strZzh2);
                    if (mapEmptyMap4 == null) {
                        zzaj zzajVarZzi6 = this.zzf.zzi();
                        String str28 = this.zza;
                        zzajVarZzi6.zzY();
                        zzajVarZzi6.zzg();
                        Preconditions.checkNotEmpty(str28);
                        Preconditions.checkNotEmpty(strZzh2);
                        ArrayMap arrayMap10 = new ArrayMap();
                        zzvVar = zzvVar2;
                        it4 = it12;
                        String str29 = str202222;
                        String str30 = str212222;
                        try {
                            try {
                                str7 = str11;
                                try {
                                    cursorQuery2 = zzajVarZzi6.zzh().query("event_filters", new String[]{str29, str30}, "app_id=? AND event_name=?", new String[]{str28, strZzh2}, null, null, null);
                                    try {
                                        try {
                                        } catch (Throwable th7) {
                                            th = th7;
                                            cursor3 = cursorQuery2;
                                            if (cursor3 != null) {
                                                cursor3.close();
                                            }
                                            throw th;
                                        }
                                    } catch (SQLiteException e12) {
                                        e = e12;
                                        str212222 = str30;
                                    }
                                } catch (SQLiteException e13) {
                                    e = e13;
                                    str212222 = str30;
                                    str202222 = str29;
                                    str8 = str192222;
                                    cursorQuery2 = null;
                                    zzajVarZzi6.zzs.zzay().zzd().zzc(str182222, zzel.zzn(str28), e);
                                    mapEmptyMap4 = Collections.emptyMap();
                                    if (cursorQuery2 != null) {
                                    }
                                    arrayMap9.put(strZzh2, mapEmptyMap4);
                                    it5 = mapEmptyMap4.keySet().iterator();
                                    while (it5.hasNext()) {
                                    }
                                    it12 = it4;
                                    str192222 = str8;
                                    zzvVar2 = zzvVar;
                                    str11 = str7;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                cursor3 = null;
                            }
                        } catch (SQLiteException e14) {
                            e = e14;
                            str212222 = str30;
                            str202222 = str29;
                            str7 = str11;
                        }
                        if (cursorQuery2.moveToFirst()) {
                            str212222 = str30;
                            while (true) {
                                try {
                                    try {
                                        com.google.android.gms.internal.measurement.zzej zzejVarZzaA2 = ((com.google.android.gms.internal.measurement.zzei) zzku.zzl(com.google.android.gms.internal.measurement.zzej.zzc(), cursorQuery2.getBlob(1))).zzaA();
                                        Integer numValueOf6 = Integer.valueOf(cursorQuery2.getInt(0));
                                        List list6 = (List) arrayMap10.get(numValueOf6);
                                        if (list6 == null) {
                                            str202222 = str29;
                                            try {
                                                arrayList = new ArrayList();
                                                arrayMap10.put(numValueOf6, arrayList);
                                            } catch (SQLiteException e15) {
                                                e = e15;
                                                str8 = str192222;
                                                zzajVarZzi6.zzs.zzay().zzd().zzc(str182222, zzel.zzn(str28), e);
                                                mapEmptyMap4 = Collections.emptyMap();
                                                if (cursorQuery2 != null) {
                                                }
                                                arrayMap9.put(strZzh2, mapEmptyMap4);
                                                it5 = mapEmptyMap4.keySet().iterator();
                                                while (it5.hasNext()) {
                                                }
                                                it12 = it4;
                                                str192222 = str8;
                                                zzvVar2 = zzvVar;
                                                str11 = str7;
                                            }
                                        } else {
                                            str202222 = str29;
                                            arrayList = list6;
                                        }
                                        arrayList.add(zzejVarZzaA2);
                                        arrayMap = arrayMap10;
                                        str8 = str192222;
                                    } catch (IOException e16) {
                                        str202222 = str29;
                                        arrayMap = arrayMap10;
                                        str8 = str192222;
                                        try {
                                            zzajVarZzi6.zzs.zzay().zzd().zzc(str8, zzel.zzn(str28), e16);
                                        } catch (SQLiteException e17) {
                                            e = e17;
                                            zzajVarZzi6.zzs.zzay().zzd().zzc(str182222, zzel.zzn(str28), e);
                                            mapEmptyMap4 = Collections.emptyMap();
                                            if (cursorQuery2 != null) {
                                            }
                                            arrayMap9.put(strZzh2, mapEmptyMap4);
                                            it5 = mapEmptyMap4.keySet().iterator();
                                            while (it5.hasNext()) {
                                            }
                                            it12 = it4;
                                            str192222 = str8;
                                            zzvVar2 = zzvVar;
                                            str11 = str7;
                                        }
                                    }
                                    if (!cursorQuery2.moveToNext()) {
                                        break;
                                    }
                                    str192222 = str8;
                                    arrayMap10 = arrayMap;
                                    str29 = str202222;
                                } catch (SQLiteException e18) {
                                    e = e18;
                                    str202222 = str29;
                                    str8 = str192222;
                                    zzajVarZzi6.zzs.zzay().zzd().zzc(str182222, zzel.zzn(str28), e);
                                    mapEmptyMap4 = Collections.emptyMap();
                                    if (cursorQuery2 != null) {
                                    }
                                    arrayMap9.put(strZzh2, mapEmptyMap4);
                                    it5 = mapEmptyMap4.keySet().iterator();
                                    while (it5.hasNext()) {
                                    }
                                    it12 = it4;
                                    str192222 = str8;
                                    zzvVar2 = zzvVar;
                                    str11 = str7;
                                }
                            }
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                            mapEmptyMap4 = arrayMap;
                        } else {
                            str212222 = str30;
                            str202222 = str29;
                            str8 = str192222;
                            mapEmptyMap4 = Collections.emptyMap();
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                        }
                        arrayMap9.put(strZzh2, mapEmptyMap4);
                    } else {
                        zzvVar = zzvVar2;
                        it4 = it12;
                        str7 = str11;
                        str8 = str192222;
                    }
                    it5 = mapEmptyMap4.keySet().iterator();
                    while (it5.hasNext()) {
                        int iIntValue3 = ((Integer) it5.next()).intValue();
                        Set<Integer> set = this.zzb;
                        Integer numValueOf7 = Integer.valueOf(iIntValue3);
                        if (set.contains(numValueOf7)) {
                            this.zzs.zzay().zzj().zzb("Skipping failed audience ID", numValueOf7);
                        } else {
                            Iterator it13 = ((List) mapEmptyMap4.get(numValueOf7)).iterator();
                            boolean zZzd = true;
                            while (true) {
                                if (!it13.hasNext()) {
                                    map5 = mapEmptyMap4;
                                    it6 = it5;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.zzej zzejVar2 = (com.google.android.gms.internal.measurement.zzej) it13.next();
                                zzw zzwVar = new zzw(this, this.zza, iIntValue3, zzejVar2);
                                map5 = mapEmptyMap4;
                                it6 = it5;
                                zZzd = zzwVar.zzd(this.zzd, this.zze, zzfoVarZza, j, zzapVar, zzf(iIntValue3, zzejVar2.zzb()));
                                if (!zZzd) {
                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                    break;
                                }
                                zzd(Integer.valueOf(iIntValue3)).zzc(zzwVar);
                                mapEmptyMap4 = map5;
                                it5 = it6;
                            }
                            if (!zZzd) {
                                this.zzb.add(Integer.valueOf(iIntValue3));
                            }
                            mapEmptyMap4 = map5;
                            it5 = it6;
                        }
                    }
                    it12 = it4;
                    str192222 = str8;
                    zzvVar2 = zzvVar;
                    str11 = str7;
                }
            }
        }
        String str222222 = str11;
        if (!list2.isEmpty()) {
            ArrayMap arrayMap11 = new ArrayMap();
            Iterator<com.google.android.gms.internal.measurement.zzgh> it14 = list2.iterator();
            while (it14.hasNext()) {
                com.google.android.gms.internal.measurement.zzgh next3 = it14.next();
                String strZzf = next3.zzf();
                Map mapEmptyMap5 = (Map) arrayMap11.get(strZzf);
                if (mapEmptyMap5 == null) {
                    zzaj zzajVarZzi7 = this.zzf.zzi();
                    String str31 = this.zza;
                    zzajVarZzi7.zzY();
                    zzajVarZzi7.zzg();
                    Preconditions.checkNotEmpty(str31);
                    Preconditions.checkNotEmpty(strZzf);
                    ArrayMap arrayMap12 = new ArrayMap();
                    str9 = str202222;
                    str10 = str212222;
                    try {
                        cursorQuery3 = zzajVarZzi7.zzh().query("property_filters", new String[]{str9, str10}, "app_id=? AND property_name=?", new String[]{str31, strZzf}, null, null, null);
                        try {
                            try {
                            } catch (Throwable th9) {
                                th = th9;
                                cursor4 = cursorQuery3;
                                if (cursor4 != null) {
                                    cursor4.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e19) {
                            e = e19;
                            it7 = it14;
                        }
                    } catch (SQLiteException e20) {
                        e = e20;
                        it7 = it14;
                        cursorQuery3 = null;
                    } catch (Throwable th10) {
                        th = th10;
                        cursor4 = null;
                    }
                    if (cursorQuery3.moveToFirst()) {
                        while (true) {
                            try {
                                com.google.android.gms.internal.measurement.zzes zzesVarZzaA = ((com.google.android.gms.internal.measurement.zzer) zzku.zzl(com.google.android.gms.internal.measurement.zzes.zzc(), cursorQuery3.getBlob(1))).zzaA();
                                Integer numValueOf8 = Integer.valueOf(cursorQuery3.getInt(0));
                                List list7 = (List) arrayMap12.get(numValueOf8);
                                if (list7 == null) {
                                    arrayList2 = new ArrayList();
                                    arrayMap12.put(numValueOf8, arrayList2);
                                } else {
                                    arrayList2 = list7;
                                }
                                arrayList2.add(zzesVarZzaA);
                                it7 = it14;
                            } catch (IOException e21) {
                                it7 = it14;
                                try {
                                    zzajVarZzi7.zzs.zzay().zzd().zzc("Failed to merge filter", zzel.zzn(str31), e21);
                                } catch (SQLiteException e22) {
                                    e = e22;
                                    zzajVarZzi7.zzs.zzay().zzd().zzc(str182222, zzel.zzn(str31), e);
                                    mapEmptyMap5 = Collections.emptyMap();
                                    if (cursorQuery3 != null) {
                                    }
                                    arrayMap11.put(strZzf, mapEmptyMap5);
                                    it8 = mapEmptyMap5.keySet().iterator();
                                    while (true) {
                                        if (!it8.hasNext()) {
                                            break;
                                        }
                                        mapEmptyMap5 = map6;
                                    }
                                    it14 = it7;
                                    str212222 = str10;
                                    str202222 = str9;
                                }
                            }
                            if (!cursorQuery3.moveToNext()) {
                                break;
                            }
                            it14 = it7;
                        }
                        if (cursorQuery3 != null) {
                            cursorQuery3.close();
                        }
                        mapEmptyMap5 = arrayMap12;
                    } else {
                        it7 = it14;
                        mapEmptyMap5 = Collections.emptyMap();
                        if (cursorQuery3 != null) {
                            cursorQuery3.close();
                        }
                    }
                    arrayMap11.put(strZzf, mapEmptyMap5);
                } else {
                    it7 = it14;
                    str9 = str202222;
                    str10 = str212222;
                }
                it8 = mapEmptyMap5.keySet().iterator();
                while (true) {
                    if (!it8.hasNext()) {
                        int iIntValue4 = ((Integer) it8.next()).intValue();
                        Set<Integer> set2 = this.zzb;
                        Integer numValueOf9 = Integer.valueOf(iIntValue4);
                        if (set2.contains(numValueOf9)) {
                            this.zzs.zzay().zzj().zzb("Skipping failed audience ID", numValueOf9);
                            break;
                        }
                        Iterator it15 = ((List) mapEmptyMap5.get(numValueOf9)).iterator();
                        boolean zZzd2 = true;
                        while (true) {
                            if (!it15.hasNext()) {
                                map6 = mapEmptyMap5;
                                break;
                            }
                            com.google.android.gms.internal.measurement.zzes zzesVar = (com.google.android.gms.internal.measurement.zzes) it15.next();
                            if (Log.isLoggable(this.zzs.zzay().zzq(), 2)) {
                                map6 = mapEmptyMap5;
                                this.zzs.zzay().zzj().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(iIntValue4), zzesVar.zzj() ? Integer.valueOf(zzesVar.zza()) : null, this.zzs.zzj().zzf(zzesVar.zze()));
                                this.zzs.zzay().zzj().zzb("Filter definition", this.zzf.zzu().zzp(zzesVar));
                            } else {
                                map6 = mapEmptyMap5;
                            }
                            if (!zzesVar.zzj() || zzesVar.zza() > 256) {
                                break;
                            }
                            zzy zzyVar = new zzy(this, this.zza, iIntValue4, zzesVar);
                            zZzd2 = zzyVar.zzd(this.zzd, this.zze, next3, zzf(iIntValue4, zzesVar.zza()));
                            if (!zZzd2) {
                                this.zzb.add(Integer.valueOf(iIntValue4));
                                break;
                            }
                            zzd(Integer.valueOf(iIntValue4)).zzc(zzyVar);
                            mapEmptyMap5 = map6;
                        }
                        if (!zZzd2) {
                            this.zzb.add(Integer.valueOf(iIntValue4));
                        }
                        mapEmptyMap5 = map6;
                    }
                }
                it14 = it7;
                str212222 = str10;
                str202222 = str9;
            }
        }
        String str232222 = str202222;
        ArrayList arrayList42222 = new ArrayList();
        Set<Integer> setKeySet2222 = this.zzc.keySet();
        setKeySet2222.removeAll(this.zzb);
        it9 = setKeySet2222.iterator();
        while (it9.hasNext()) {
            int iIntValue5 = it9.next().intValue();
            Map<Integer, zzt> map8 = this.zzc;
            Integer numValueOf10 = Integer.valueOf(iIntValue5);
            zzt zztVar = map8.get(numValueOf10);
            Preconditions.checkNotNull(zztVar);
            com.google.android.gms.internal.measurement.zzfk zzfkVarZza = zztVar.zza(iIntValue5);
            arrayList42222.add(zzfkVarZza);
            zzaj zzajVarZzi8 = this.zzf.zzi();
            String str32 = this.zza;
            com.google.android.gms.internal.measurement.zzgd zzgdVarZzd = zzfkVarZza.zzd();
            zzajVarZzi8.zzY();
            zzajVarZzi8.zzg();
            Preconditions.checkNotEmpty(str32);
            Preconditions.checkNotNull(zzgdVarZzd);
            byte[] bArrZzbs = zzgdVarZzd.zzbs();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str32);
            contentValues2.put(str232222, numValueOf10);
            String str33 = str222222;
            contentValues2.put(str33, bArrZzbs);
            try {
                try {
                    if (zzajVarZzi8.zzh().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                        zzajVarZzi8.zzs.zzay().zzd().zzb("Failed to insert filter results (got -1). appId", zzel.zzn(str32));
                    }
                } catch (SQLiteException e23) {
                    e = e23;
                    zzajVarZzi8.zzs.zzay().zzd().zzc("Error storing filter results. appId", zzel.zzn(str32), e);
                    str222222 = str33;
                }
            } catch (SQLiteException e24) {
                e = e24;
            }
            str222222 = str33;
        }
        return arrayList42222;
    }

    @Override // com.google.android.gms.measurement.internal.zzki
    protected final boolean zzb() {
        return false;
    }
}
