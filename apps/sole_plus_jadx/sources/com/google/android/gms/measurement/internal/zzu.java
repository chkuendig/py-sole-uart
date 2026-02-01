package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzoc;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
/* loaded from: classes4.dex */
final class zzu extends zzmx {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzw> zzc;
    private Long zzd;
    private Long zze;

    private final zzw zza(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzw zzwVar = new zzw(this, this.zza);
        this.zzc.put(num, zzwVar);
        return zzwVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzmx
    protected final boolean zzc() {
        return false;
    }

    final List<zzfn.zzd> zza(String str, List<zzfn.zzf> list, List<zzfn.zzo> list2, Long l, Long l2) {
        return zza(str, list, list2, l, l2, false);
    }

    final List<zzfn.zzd> zza(String str, List<zzfn.zzf> list, List<zzfn.zzo> list2, Long l, Long l2, boolean z) throws IllegalStateException {
        boolean z2;
        Map<Integer, zzfn.zzm> map;
        List<zzff.zzb> list3;
        Map<Integer, List<zzff.zzb>> map2;
        Map<Integer, zzfn.zzm> map3;
        Iterator it;
        Iterator<zzfn.zzn> it2;
        Map<Integer, List<Integer>> map4;
        Iterator<Integer> it3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator<zzfn.zzf> it4 = list.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(it4.next().zzg())) {
                z2 = true;
                break;
            }
        }
        boolean z3 = zzoc.zza() && zze().zzf(this.zza, zzbf.zzbk);
        boolean z4 = zzoc.zza() && zze().zzf(this.zza, zzbf.zzbj);
        if (z2) {
            zzal zzalVarZzh = zzh();
            String str2 = this.zza;
            zzalVarZzh.zzal();
            zzalVarZzh.zzt();
            Preconditions.checkNotEmpty(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                zzalVarZzh.e_().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e) {
                zzalVarZzh.zzj().zzg().zza("Error resetting session-scoped event counts. appId", zzfw.zza(str2), e);
            }
        }
        Map<Integer, List<zzff.zzb>> mapEmptyMap = Collections.emptyMap();
        if (z4 && z3) {
            mapEmptyMap = zzh().zzm(this.zza);
        }
        Map<Integer, zzfn.zzm> mapZzl = zzh().zzl(this.zza);
        if (!mapZzl.isEmpty()) {
            HashSet hashSet = new HashSet(mapZzl.keySet());
            if (z2) {
                String str3 = this.zza;
                Map<Integer, List<Integer>> mapZzn = zzh().zzn(this.zza);
                Preconditions.checkNotEmpty(str3);
                Preconditions.checkNotNull(mapZzl);
                ArrayMap arrayMap = new ArrayMap();
                if (!mapZzl.isEmpty()) {
                    Iterator<Integer> it5 = mapZzl.keySet().iterator();
                    while (it5.hasNext()) {
                        int iIntValue = it5.next().intValue();
                        zzfn.zzm zzmVar = mapZzl.get(Integer.valueOf(iIntValue));
                        List<Integer> list4 = mapZzn.get(Integer.valueOf(iIntValue));
                        if (list4 == null || list4.isEmpty()) {
                            map4 = mapZzn;
                            it3 = it5;
                            arrayMap.put(Integer.valueOf(iIntValue), zzmVar);
                            mapZzn = map4;
                            it5 = it3;
                        } else {
                            List<Long> listZza = g_().zza(zzmVar.zzi(), list4);
                            if (!listZza.isEmpty()) {
                                zzfn.zzm.zza zzaVarZzb = zzmVar.zzcc().zzb().zzb(listZza);
                                zzaVarZzb.zzd().zzd(g_().zza(zzmVar.zzk(), list4));
                                ArrayList arrayList = new ArrayList();
                                for (zzfn.zze zzeVar : zzmVar.zzh()) {
                                    Map<Integer, List<Integer>> map5 = mapZzn;
                                    Iterator<Integer> it6 = it5;
                                    if (!list4.contains(Integer.valueOf(zzeVar.zza()))) {
                                        arrayList.add(zzeVar);
                                    }
                                    mapZzn = map5;
                                    it5 = it6;
                                }
                                map4 = mapZzn;
                                it3 = it5;
                                zzaVarZzb.zza().zza(arrayList);
                                ArrayList arrayList2 = new ArrayList();
                                for (zzfn.zzn zznVar : zzmVar.zzj()) {
                                    if (!list4.contains(Integer.valueOf(zznVar.zzb()))) {
                                        arrayList2.add(zznVar);
                                    }
                                }
                                zzaVarZzb.zzc().zzc(arrayList2);
                                arrayMap.put(Integer.valueOf(iIntValue), (zzfn.zzm) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZzb.zzai()));
                                mapZzn = map4;
                                it5 = it3;
                            }
                        }
                    }
                }
                map = arrayMap;
            } else {
                map = mapZzl;
            }
            Iterator it7 = hashSet.iterator();
            while (it7.hasNext()) {
                int iIntValue2 = ((Integer) it7.next()).intValue();
                zzfn.zzm zzmVar2 = map.get(Integer.valueOf(iIntValue2));
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap2 = new ArrayMap();
                if (zzmVar2 != null && zzmVar2.zza() != 0) {
                    for (zzfn.zze zzeVar2 : zzmVar2.zzh()) {
                        if (zzeVar2.zzf()) {
                            arrayMap2.put(Integer.valueOf(zzeVar2.zza()), zzeVar2.zze() ? Long.valueOf(zzeVar2.zzb()) : null);
                        }
                    }
                }
                ArrayMap arrayMap3 = new ArrayMap();
                if (zzmVar2 != null && zzmVar2.zzc() != 0) {
                    Iterator<zzfn.zzn> it8 = zzmVar2.zzj().iterator();
                    while (it8.hasNext()) {
                        zzfn.zzn next = it8.next();
                        if (!next.zzf() || next.zza() <= 0) {
                            it2 = it8;
                        } else {
                            it2 = it8;
                            arrayMap3.put(Integer.valueOf(next.zzb()), Long.valueOf(next.zza(next.zza() - 1)));
                        }
                        it8 = it2;
                    }
                }
                if (zzmVar2 != null) {
                    int i = 0;
                    while (i < (zzmVar2.zzd() << 6)) {
                        if (zznl.zza(zzmVar2.zzk(), i)) {
                            map3 = map;
                            it = it7;
                            zzj().zzp().zza("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue2), Integer.valueOf(i));
                            bitSet2.set(i);
                            if (zznl.zza(zzmVar2.zzi(), i)) {
                                bitSet.set(i);
                            }
                            i++;
                            map = map3;
                            it7 = it;
                        } else {
                            map3 = map;
                            it = it7;
                        }
                        arrayMap2.remove(Integer.valueOf(i));
                        i++;
                        map = map3;
                        it7 = it;
                    }
                }
                Map<Integer, zzfn.zzm> map6 = map;
                Iterator it9 = it7;
                zzfn.zzm zzmVar3 = mapZzl.get(Integer.valueOf(iIntValue2));
                if (z4 && z3 && (list3 = mapEmptyMap.get(Integer.valueOf(iIntValue2))) != null && this.zze != null && this.zzd != null) {
                    for (zzff.zzb zzbVar : list3) {
                        int iZzb = zzbVar.zzb();
                        long jLongValue = this.zze.longValue() / 1000;
                        if (zzbVar.zzi()) {
                            jLongValue = this.zzd.longValue() / 1000;
                        }
                        if (arrayMap2.containsKey(Integer.valueOf(iZzb))) {
                            map2 = mapEmptyMap;
                            arrayMap2.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        } else {
                            map2 = mapEmptyMap;
                        }
                        if (arrayMap3.containsKey(Integer.valueOf(iZzb))) {
                            arrayMap3.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        }
                        mapEmptyMap = map2;
                    }
                }
                this.zzc.put(Integer.valueOf(iIntValue2), new zzw(this, this.zza, zzmVar3, bitSet, bitSet2, arrayMap2, arrayMap3));
                map = map6;
                it7 = it9;
                mapEmptyMap = mapEmptyMap;
                mapZzl = mapZzl;
            }
        }
        if (com.google.android.gms.internal.measurement.zznk.zza() && zze().zzf(null, zzbf.zzcv)) {
            zza(list, z);
            if (z) {
                return new ArrayList();
            }
            zza(list2);
            return zzu();
        }
        zza(list, true);
        zza(list2);
        return zzu();
    }

    private final List<zzfn.zzd> zzu() throws IllegalStateException {
        ArrayList arrayList = new ArrayList();
        Set<Integer> setKeySet = this.zzc.keySet();
        setKeySet.removeAll(this.zzb);
        Iterator<Integer> it = setKeySet.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            zzw zzwVar = this.zzc.get(Integer.valueOf(iIntValue));
            Preconditions.checkNotNull(zzwVar);
            zzfn.zzd zzdVarZza = zzwVar.zza(iIntValue);
            arrayList.add(zzdVarZza);
            zzal zzalVarZzh = zzh();
            String str = this.zza;
            zzfn.zzm zzmVarZzd = zzdVarZza.zzd();
            zzalVarZzh.zzal();
            zzalVarZzh.zzt();
            Preconditions.checkNotEmpty(str);
            Preconditions.checkNotNull(zzmVarZzd);
            byte[] bArrZzbz = zzmVarZzd.zzbz();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(iIntValue));
            contentValues.put("current_results", bArrZzbz);
            try {
                if (zzalVarZzh.e_().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    zzalVarZzh.zzj().zzg().zza("Failed to insert filter results (got -1). appId", zzfw.zza(str));
                }
            } catch (SQLiteException e) {
                zzalVarZzh.zzj().zzg().zza("Error storing filter results. appId", zzfw.zza(str), e);
            }
        }
        return arrayList;
    }

    zzu(zznc zzncVar) {
        super(zzncVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(List<zzfn.zzf> list, boolean z) throws IllegalStateException {
        zzaz zzazVar;
        int i;
        Map<Integer, List<zzff.zzb>> map;
        long j;
        if (list.isEmpty()) {
            return;
        }
        String str = null;
        zzy zzyVar = new zzy(this);
        ArrayMap arrayMap = new ArrayMap();
        for (zzfn.zzf zzfVar : list) {
            zzfn.zzf zzfVarZza = zzyVar.zza(this.zza, zzfVar);
            if (zzfVarZza != null) {
                zzal zzalVarZzh = zzh();
                String str2 = this.zza;
                String strZzg = zzfVarZza.zzg();
                zzaz zzazVarZzd = zzalVarZzh.zzd(str2, zzfVar.zzg());
                if (zzazVarZzd == null) {
                    zzalVarZzh.zzj().zzu().zza("Event aggregate wasn't created during raw event logging. appId, event", zzfw.zza(str2), zzalVarZzh.zzi().zza(strZzg));
                    zzazVar = new zzaz(str2, zzfVar.zzg(), 1L, 1L, 1L, zzfVar.zzd(), 0L, null, null, null, null);
                } else {
                    zzazVar = new zzaz(zzazVarZzd.zza, zzazVarZzd.zzb, zzazVarZzd.zzc + 1, zzazVarZzd.zzd + 1, zzazVarZzd.zze + 1, zzazVarZzd.zzf, zzazVarZzd.zzg, zzazVarZzd.zzh, zzazVarZzd.zzi, zzazVarZzd.zzj, zzazVarZzd.zzk);
                }
                zzaz zzazVar2 = zzazVar;
                zzh().zza(zzazVar2);
                if (!com.google.android.gms.internal.measurement.zznk.zza() || !zze().zzf(str, zzbf.zzcv) || !z) {
                    long j2 = zzazVar2.zzc;
                    String strZzg2 = zzfVarZza.zzg();
                    Map<Integer, List<zzff.zzb>> mapZzf = (Map) arrayMap.get(strZzg2);
                    if (mapZzf == null) {
                        mapZzf = zzh().zzf(this.zza, strZzg2);
                        arrayMap.put(strZzg2, mapZzf);
                    }
                    Map<Integer, List<zzff.zzb>> map2 = mapZzf;
                    Iterator<Integer> it = map2.keySet().iterator();
                    while (it.hasNext()) {
                        int iIntValue = it.next().intValue();
                        if (this.zzb.contains(Integer.valueOf(iIntValue))) {
                            zzj().zzp().zza("Skipping failed audience ID", Integer.valueOf(iIntValue));
                        } else {
                            Iterator<zzff.zzb> it2 = map2.get(Integer.valueOf(iIntValue)).iterator();
                            boolean zZza = true;
                            while (true) {
                                if (!it2.hasNext()) {
                                    i = iIntValue;
                                    map = map2;
                                    j = j2;
                                    break;
                                }
                                zzff.zzb next = it2.next();
                                zzaa zzaaVar = new zzaa(this, this.zza, iIntValue, next);
                                i = iIntValue;
                                map = map2;
                                j = j2;
                                zZza = zzaaVar.zza(this.zzd, this.zze, zzfVarZza, j2, zzazVar2, zza(iIntValue, next.zzb()));
                                if (zZza) {
                                    zza(Integer.valueOf(i)).zza(zzaaVar);
                                    iIntValue = i;
                                    map2 = map;
                                    j2 = j;
                                } else {
                                    this.zzb.add(Integer.valueOf(i));
                                    break;
                                }
                            }
                            if (!zZza) {
                                this.zzb.add(Integer.valueOf(i));
                            }
                            map2 = map;
                            j2 = j;
                            str = null;
                        }
                    }
                }
            }
        }
    }

    private final void zza(List<zzfn.zzo> list) throws IllegalStateException {
        zzff.zze next;
        if (list.isEmpty()) {
            return;
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzfn.zzo zzoVar : list) {
            String strZzg = zzoVar.zzg();
            Map<Integer, List<zzff.zze>> mapZzg = (Map) arrayMap.get(strZzg);
            if (mapZzg == null) {
                mapZzg = zzh().zzg(this.zza, strZzg);
                arrayMap.put(strZzg, mapZzg);
            }
            Iterator<Integer> it = mapZzg.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    if (this.zzb.contains(Integer.valueOf(iIntValue))) {
                        zzj().zzp().zza("Skipping failed audience ID", Integer.valueOf(iIntValue));
                        break;
                    }
                    Iterator<zzff.zze> it2 = mapZzg.get(Integer.valueOf(iIntValue)).iterator();
                    boolean zZza = true;
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        next = it2.next();
                        if (zzj().zza(2)) {
                            zzj().zzp().zza("Evaluating filter. audience, filter, property", Integer.valueOf(iIntValue), next.zzi() ? Integer.valueOf(next.zza()) : null, zzi().zzc(next.zze()));
                            zzj().zzp().zza("Filter definition", g_().zza(next));
                        }
                        if (!next.zzi() || next.zza() > 256) {
                            break;
                        }
                        zzac zzacVar = new zzac(this, this.zza, iIntValue, next);
                        zZza = zzacVar.zza(this.zzd, this.zze, zzoVar, zza(iIntValue, next.zza()));
                        if (zZza) {
                            zza(Integer.valueOf(iIntValue)).zza(zzacVar);
                        } else {
                            this.zzb.add(Integer.valueOf(iIntValue));
                            break;
                        }
                    }
                    zzj().zzu().zza("Invalid property filter ID. appId, id", zzfw.zza(this.zza), String.valueOf(next.zzi() ? Integer.valueOf(next.zza()) : null));
                    zZza = false;
                    if (!zZza) {
                        this.zzb.add(Integer.valueOf(iIntValue));
                    }
                }
            }
        }
    }

    private final boolean zza(int i, int i2) {
        zzw zzwVar = this.zzc.get(Integer.valueOf(i));
        if (zzwVar == null) {
            return false;
        }
        return zzwVar.zzd.get(i2);
    }
}
