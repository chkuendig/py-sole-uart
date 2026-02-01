package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zznl;
import com.google.android.gms.internal.measurement.zzoy;
import com.google.android.gms.internal.measurement.zzpe;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzfm extends zzki implements zzae {
    final Map<String, Map<String, Boolean>> zza;
    final Map<String, Map<String, Boolean>> zzb;
    final LruCache<String, com.google.android.gms.internal.measurement.zzc> zzc;
    final com.google.android.gms.internal.measurement.zzr zzd;
    private final Map<String, Map<String, String>> zze;
    private final Map<String, com.google.android.gms.internal.measurement.zzfc> zzg;
    private final Map<String, Map<String, Integer>> zzh;
    private final Map<String, String> zzi;

    zzfm(zzks zzksVar) {
        super(zzksVar);
        this.zze = new ArrayMap();
        this.zza = new ArrayMap();
        this.zzb = new ArrayMap();
        this.zzg = new ArrayMap();
        this.zzi = new ArrayMap();
        this.zzh = new ArrayMap();
        this.zzc = new zzfj(this, 20);
        this.zzd = new zzfk(this);
    }

    static /* bridge */ /* synthetic */ com.google.android.gms.internal.measurement.zzc zzd(zzfm zzfmVar, String str) throws Throwable {
        zzfmVar.zzY();
        Preconditions.checkNotEmpty(str);
        zzpe.zzc();
        if (!zzfmVar.zzs.zzf().zzs(null, zzdy.zzat) || !zzfmVar.zzl(str)) {
            return null;
        }
        if (!zzfmVar.zzg.containsKey(str) || zzfmVar.zzg.get(str) == null) {
            zzfmVar.zzt(str);
        } else {
            zzfmVar.zzu(str, zzfmVar.zzg.get(str));
        }
        return zzfmVar.zzc.snapshot().get(str);
    }

    private final com.google.android.gms.internal.measurement.zzfc zzr(String str, byte[] bArr) {
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.zzfc.zzg();
        }
        try {
            com.google.android.gms.internal.measurement.zzfc zzfcVarZzaA = ((com.google.android.gms.internal.measurement.zzfb) zzku.zzl(com.google.android.gms.internal.measurement.zzfc.zze(), bArr)).zzaA();
            this.zzs.zzay().zzj().zzc("Parsed config. version, gmp_app_id", zzfcVarZzaA.zzq() ? Long.valueOf(zzfcVarZzaA.zzc()) : null, zzfcVarZzaA.zzp() ? zzfcVarZzaA.zzh() : null);
            return zzfcVarZzaA;
        } catch (com.google.android.gms.internal.measurement.zzkh e) {
            this.zzs.zzay().zzk().zzc("Unable to merge remote config. appId", zzel.zzn(str), e);
            return com.google.android.gms.internal.measurement.zzfc.zzg();
        } catch (RuntimeException e2) {
            this.zzs.zzay().zzk().zzc("Unable to merge remote config. appId", zzel.zzn(str), e2);
            return com.google.android.gms.internal.measurement.zzfc.zzg();
        }
    }

    private final void zzs(String str, com.google.android.gms.internal.measurement.zzfb zzfbVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzfbVar != null) {
            for (int i = 0; i < zzfbVar.zza(); i++) {
                com.google.android.gms.internal.measurement.zzez zzezVarZzbv = zzfbVar.zzb(i).zzbv();
                if (TextUtils.isEmpty(zzezVarZzbv.zzc())) {
                    this.zzs.zzay().zzk().zza("EventConfig contained null event name");
                } else {
                    String strZzc = zzezVarZzbv.zzc();
                    String strZzb = zzgs.zzb(zzezVarZzbv.zzc());
                    if (!TextUtils.isEmpty(strZzb)) {
                        zzezVarZzbv.zzb(strZzb);
                        zzfbVar.zzd(i, zzezVarZzbv);
                    }
                    zznl.zzc();
                    if (!this.zzs.zzf().zzs(null, zzdy.zzaC)) {
                        arrayMap.put(strZzc, Boolean.valueOf(zzezVarZzbv.zzd()));
                    } else if (zzezVarZzbv.zzf() && zzezVarZzbv.zzd()) {
                        arrayMap.put(strZzc, true);
                    }
                    zznl.zzc();
                    if (!this.zzs.zzf().zzs(null, zzdy.zzaC)) {
                        arrayMap2.put(zzezVarZzbv.zzc(), Boolean.valueOf(zzezVarZzbv.zze()));
                    } else if (zzezVarZzbv.zzg() && zzezVarZzbv.zze()) {
                        arrayMap2.put(zzezVarZzbv.zzc(), true);
                    }
                    if (zzezVarZzbv.zzh()) {
                        if (zzezVarZzbv.zza() < 2 || zzezVarZzbv.zza() > 65535) {
                            this.zzs.zzay().zzk().zzc("Invalid sampling rate. Event name, sample rate", zzezVarZzbv.zzc(), Integer.valueOf(zzezVarZzbv.zza()));
                        } else {
                            arrayMap3.put(zzezVarZzbv.zzc(), Integer.valueOf(zzezVarZzbv.zza()));
                        }
                    }
                }
            }
        }
        this.zza.put(str, arrayMap);
        this.zzb.put(str, arrayMap2);
        this.zzh.put(str, arrayMap3);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0121: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:42:0x0121 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzt(String str) throws Throwable {
        SQLiteException e;
        Cursor cursorQuery;
        Cursor cursor;
        Pair pair;
        zzY();
        zzg();
        Preconditions.checkNotEmpty(str);
        if (this.zzg.get(str) == null) {
            zzaj zzajVarZzi = this.zzf.zzi();
            Preconditions.checkNotEmpty(str);
            zzajVarZzi.zzg();
            zzajVarZzi.zzY();
            Cursor cursor2 = null;
            try {
                try {
                    cursorQuery = zzajVarZzi.zzh().query("apps", new String[]{"remote_config", "config_last_modified_time"}, "app_id=?", new String[]{str}, null, null, null);
                    try {
                    } catch (SQLiteException e2) {
                        e = e2;
                        zzajVarZzi.zzs.zzay().zzd().zzc("Error querying remote config. appId", zzel.zzn(str), e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        pair = null;
                        if (pair != null) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                throw th;
            }
            if (cursorQuery.moveToFirst()) {
                byte[] blob = cursorQuery.getBlob(0);
                String string = cursorQuery.getString(1);
                if (cursorQuery.moveToNext()) {
                    zzajVarZzi.zzs.zzay().zzd().zzb("Got multiple records for app config, expected one. appId", zzel.zzn(str));
                }
                if (blob == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    pair = null;
                } else {
                    pair = new Pair(blob, string);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } else {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                pair = null;
            }
            if (pair != null) {
                this.zze.put(str, null);
                this.zza.put(str, null);
                this.zzb.put(str, null);
                this.zzg.put(str, null);
                this.zzi.put(str, null);
                this.zzh.put(str, null);
                return;
            }
            com.google.android.gms.internal.measurement.zzfb zzfbVarZzbv = zzr(str, (byte[]) pair.first).zzbv();
            zzs(str, zzfbVarZzbv);
            this.zze.put(str, zzv(zzfbVarZzbv.zzaA()));
            this.zzg.put(str, zzfbVarZzbv.zzaA());
            zzpe.zzc();
            if (this.zzs.zzf().zzs(null, zzdy.zzat)) {
                zzu(str, zzfbVarZzbv.zzaA());
            }
            zzoy.zzc();
            if (this.zzs.zzf().zzs(null, zzdy.zzaq)) {
                this.zzi.put(str, (String) pair.second);
            } else {
                this.zzi.put(str, null);
            }
        }
    }

    private final void zzu(final String str, com.google.android.gms.internal.measurement.zzfc zzfcVar) {
        if (zzfcVar.zza() == 0) {
            this.zzc.remove(str);
            return;
        }
        this.zzs.zzay().zzj().zzb("EES programs found", Integer.valueOf(zzfcVar.zza()));
        com.google.android.gms.internal.measurement.zzgo zzgoVar = zzfcVar.zzj().get(0);
        try {
            com.google.android.gms.internal.measurement.zzc zzcVar = new com.google.android.gms.internal.measurement.zzc();
            zzcVar.zzd("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfg
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzn("internal.remoteConfig", new zzfl(this.zza, str));
                }
            });
            zzcVar.zzd("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfi
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final zzfm zzfmVar = this.zza;
                    final String str2 = str;
                    return new com.google.android.gms.internal.measurement.zzu("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzfh
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            zzfm zzfmVar2 = zzfmVar;
                            String str3 = str2;
                            zzg zzgVarZzj = zzfmVar2.zzf.zzi().zzj(str3);
                            HashMap map = new HashMap();
                            map.put("platform", Constants.PLATFORM);
                            map.put("package_name", str3);
                            zzfmVar2.zzs.zzf().zzh();
                            map.put("gmp_version", 46000L);
                            if (zzgVarZzj != null) {
                                String strZzw = zzgVarZzj.zzw();
                                if (strZzw != null) {
                                    map.put("app_version", strZzw);
                                }
                                map.put("app_version_int", Long.valueOf(zzgVarZzj.zzb()));
                                map.put("dynamite_version", Long.valueOf(zzgVarZzj.zzk()));
                            }
                            return map;
                        }
                    });
                }
            });
            zzcVar.zzd("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzff
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzt(this.zza.zzd);
                }
            });
            zzcVar.zzc(zzgoVar);
            this.zzc.put(str, zzcVar);
            this.zzs.zzay().zzj().zzc("EES program loaded for appId, activities", str, Integer.valueOf(zzgoVar.zza().zza()));
            Iterator<com.google.android.gms.internal.measurement.zzgm> it = zzgoVar.zza().zzd().iterator();
            while (it.hasNext()) {
                this.zzs.zzay().zzj().zzb("EES program activity", it.next().zzb());
            }
        } catch (com.google.android.gms.internal.measurement.zzd unused) {
            this.zzs.zzay().zzd().zzb("Failed to load EES program. appId", str);
        }
    }

    private static final Map<String, String> zzv(com.google.android.gms.internal.measurement.zzfc zzfcVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzfcVar != null) {
            for (com.google.android.gms.internal.measurement.zzfe zzfeVar : zzfcVar.zzk()) {
                arrayMap.put(zzfeVar.zzb(), zzfeVar.zzc());
            }
        }
        return arrayMap;
    }

    @Override // com.google.android.gms.measurement.internal.zzae
    public final String zza(String str, String str2) throws Throwable {
        zzg();
        zzt(str);
        Map<String, String> map = this.zze.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzki
    protected final boolean zzb() {
        return false;
    }

    final int zzc(String str, String str2) throws Throwable {
        Integer num;
        zzg();
        zzt(str);
        Map<String, Integer> map = this.zzh.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    protected final com.google.android.gms.internal.measurement.zzfc zze(String str) {
        zzY();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzt(str);
        return this.zzg.get(str);
    }

    protected final String zzf(String str) {
        zzg();
        return this.zzi.get(str);
    }

    protected final void zzi(String str) {
        zzg();
        this.zzi.put(str, null);
    }

    final void zzj(String str) {
        zzg();
        this.zzg.remove(str);
    }

    final boolean zzk(String str) {
        zzg();
        com.google.android.gms.internal.measurement.zzfc zzfcVarZze = zze(str);
        if (zzfcVarZze == null) {
            return false;
        }
        return zzfcVarZze.zzo();
    }

    public final boolean zzl(String str) {
        com.google.android.gms.internal.measurement.zzfc zzfcVar;
        zzpe.zzc();
        return (!this.zzs.zzf().zzs(null, zzdy.zzat) || TextUtils.isEmpty(str) || (zzfcVar = this.zzg.get(str)) == null || zzfcVar.zza() == 0) ? false : true;
    }

    final boolean zzm(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    final boolean zzn(String str, String str2) throws Throwable {
        Boolean bool;
        zzg();
        zzt(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzb.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean zzo(String str, String str2) throws Throwable {
        Boolean bool;
        zzg();
        zzt(str);
        if (zzm(str) && zzkz.zzag(str2)) {
            return true;
        }
        if (zzp(str) && zzkz.zzah(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zza.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean zzp(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_public"));
    }

    protected final boolean zzq(String str, byte[] bArr, String str2) throws Throwable {
        zzY();
        zzg();
        Preconditions.checkNotEmpty(str);
        com.google.android.gms.internal.measurement.zzfb zzfbVarZzbv = zzr(str, bArr).zzbv();
        if (zzfbVarZzbv == null) {
            return false;
        }
        zzs(str, zzfbVarZzbv);
        zzpe.zzc();
        if (this.zzs.zzf().zzs(null, zzdy.zzat)) {
            zzu(str, zzfbVarZzbv.zzaA());
        }
        this.zzg.put(str, zzfbVarZzbv.zzaA());
        this.zzi.put(str, str2);
        this.zze.put(str, zzv(zzfbVarZzbv.zzaA()));
        this.zzf.zzi().zzC(str, new ArrayList(zzfbVarZzbv.zze()));
        try {
            zzfbVarZzbv.zzc();
            bArr = zzfbVarZzbv.zzaA().zzbs();
        } catch (RuntimeException e) {
            this.zzs.zzay().zzk().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzel.zzn(str), e);
        }
        zzoy.zzc();
        if (this.zzs.zzf().zzs(null, zzdy.zzaq)) {
            this.zzf.zzi().zzG(str, bArr, str2);
        } else {
            this.zzf.zzi().zzG(str, bArr, null);
        }
        this.zzg.put(str, zzfbVarZzbv.zzaA());
        return true;
    }
}
