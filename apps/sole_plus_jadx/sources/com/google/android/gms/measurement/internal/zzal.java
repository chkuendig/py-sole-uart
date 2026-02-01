package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Marker;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
/* loaded from: classes4.dex */
final class zzal extends zzmx {
    private static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;"};
    private static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzj = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzk = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};
    private final zzar zzl;
    private final zzmr zzm;

    public final int zza(String str, String str2) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            return e_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting conditional property", zzfw.zza(str), zzi().zzc(str2), e);
            return 0;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzmx
    protected final boolean zzc() {
        return false;
    }

    public final long zza(String str) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        try {
            return e_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zze().zzb(str, zzbf.zzp))))});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzfw.zza(str), e);
            return 0L;
        }
    }

    public final long b_() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return -1L;
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying raw events", e);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final long zza(zzfn.zzk zzkVar) throws IllegalStateException, IOException {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzkVar);
        Preconditions.checkNotEmpty(zzkVar.zzz());
        byte[] bArrZzbz = zzkVar.zzbz();
        long jZza = g_().zza(bArrZzbz);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkVar.zzz());
        contentValues.put("metadata_fingerprint", Long.valueOf(jZza));
        contentValues.put("metadata", bArrZzbz);
        try {
            e_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jZza;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzfw.zza(zzkVar.zzz()), e);
            throw e;
        }
    }

    protected final long zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        SQLiteDatabase sQLiteDatabaseE_ = e_();
        sQLiteDatabaseE_.beginTransaction();
        long j = 0;
        try {
            try {
                long jZza = zza("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
                if (jZza == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseE_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzj().zzg().zza("Failed to insert column (got -1). appId", zzfw.zza(str), str2);
                        return -1L;
                    }
                    jZza = 0;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put(str2, Long.valueOf(1 + jZza));
                    if (sQLiteDatabaseE_.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        zzj().zzg().zza("Failed to update column (got 0). appId", zzfw.zza(str), str2);
                        return -1L;
                    }
                    sQLiteDatabaseE_.setTransactionSuccessful();
                    return jZza;
                } catch (SQLiteException e) {
                    e = e;
                    j = jZza;
                    zzj().zzg().zza("Error inserting column. appId", zzfw.zza(str), str2, e);
                    sQLiteDatabaseE_.endTransaction();
                    return j;
                }
            } finally {
                sQLiteDatabaseE_.endTransaction();
            }
        } catch (SQLiteException e2) {
            e = e2;
        }
    }

    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        return zza("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
    }

    public final long c_() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    public final long d_() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = e_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    long j = cursorRawQuery.getLong(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getLong(0);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    final SQLiteDatabase e_() {
        zzt();
        try {
            return this.zzl.getWritableDatabase();
        } catch (SQLiteException e) {
            zzj().zzu().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x008a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x008a */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle zzd(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r5.zzt()
            r5.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.e_()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L74
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L74
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L74
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L74
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            if (r2 != 0) goto L31
            com.google.android.gms.measurement.internal.zzfw r6 = r5.zzj()     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzp()     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            java.lang.String r2 = "Default event parameters not found"
            r6.zza(r2)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            if (r1 == 0) goto L30
            r1.close()
        L30:
            return r0
        L31:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r3 = com.google.android.gms.internal.measurement.zzfn.zzf.zze()     // Catch: java.io.IOException -> L58 android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            com.google.android.gms.internal.measurement.zzks r2 = com.google.android.gms.measurement.internal.zznl.zza(r3, r2)     // Catch: java.io.IOException -> L58 android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r2     // Catch: java.io.IOException -> L58 android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            com.google.android.gms.internal.measurement.zzkt r2 = r2.zzai()     // Catch: java.io.IOException -> L58 android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            com.google.android.gms.internal.measurement.zzjk r2 = (com.google.android.gms.internal.measurement.zzjk) r2     // Catch: java.io.IOException -> L58 android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            com.google.android.gms.internal.measurement.zzfn$zzf r2 = (com.google.android.gms.internal.measurement.zzfn.zzf) r2     // Catch: java.io.IOException -> L58 android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            r5.g_()     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            java.util.List r6 = r2.zzh()     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.zznl.zza(r6)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            if (r1 == 0) goto L57
            r1.close()
        L57:
            return r6
        L58:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfw r3 = r5.zzj()     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfw.zza(r6)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            r3.zza(r4, r6, r2)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> L89
            if (r1 == 0) goto L6f
            r1.close()
        L6f:
            return r0
        L70:
            r6 = move-exception
            goto L76
        L72:
            r6 = move-exception
            goto L8b
        L74:
            r6 = move-exception
            r1 = r0
        L76:
            com.google.android.gms.measurement.internal.zzfw r2 = r5.zzj()     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzg()     // Catch: java.lang.Throwable -> L89
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r6)     // Catch: java.lang.Throwable -> L89
            if (r1 == 0) goto L88
            r1.close()
        L88:
            return r0
        L89:
            r6 = move-exception
            r0 = r1
        L8b:
            if (r0 == 0) goto L90
            r0.close()
        L90:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzd(java.lang.String):android.os.Bundle");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0092: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0092 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzfn.zzf, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.zzt()
            r7.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.e_()     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7c
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7c
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7c
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7c
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7c
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7c
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            if (r2 != 0) goto L38
            com.google.android.gms.measurement.internal.zzfw r8 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            com.google.android.gms.measurement.internal.zzfy r8 = r8.zzp()     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            if (r1 == 0) goto L37
            r1.close()
        L37:
            return r0
        L38:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r4 = com.google.android.gms.internal.measurement.zzfn.zzf.zze()     // Catch: java.io.IOException -> L60 android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzks r2 = com.google.android.gms.measurement.internal.zznl.zza(r4, r2)     // Catch: java.io.IOException -> L60 android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r2     // Catch: java.io.IOException -> L60 android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzkt r2 = r2.zzai()     // Catch: java.io.IOException -> L60 android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzjk r2 = (com.google.android.gms.internal.measurement.zzjk) r2     // Catch: java.io.IOException -> L60 android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzfn$zzf r2 = (com.google.android.gms.internal.measurement.zzfn.zzf) r2     // Catch: java.io.IOException -> L60 android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            if (r1 == 0) goto L5f
            r1.close()
        L5f:
            return r8
        L60:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfw r3 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfw.zza(r8)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            r3.zza(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L91
            if (r1 == 0) goto L77
            r1.close()
        L77:
            return r0
        L78:
            r8 = move-exception
            goto L7e
        L7a:
            r8 = move-exception
            goto L93
        L7c:
            r8 = move-exception
            r1 = r0
        L7e:
            com.google.android.gms.measurement.internal.zzfw r9 = r7.zzj()     // Catch: java.lang.Throwable -> L91
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzg()     // Catch: java.lang.Throwable -> L91
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch: java.lang.Throwable -> L91
            if (r1 == 0) goto L90
            r1.close()
        L90:
            return r0
        L91:
            r8 = move-exception
            r0 = r1
        L93:
            if (r0 == 0) goto L98
            r0.close()
        L98:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzg zze(java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 1120
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zze(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzae zzc(java.lang.String r33, java.lang.String r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzae");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzan zzf(java.lang.String r13) throws java.lang.Throwable {
        /*
            r12 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            r12.zzt()
            r12.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r12.e_()     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            java.lang.String r2 = "apps"
            r3 = 3
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            java.lang.String r4 = "remote_config"
            r9 = 0
            r3[r9] = r4     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            java.lang.String r4 = "config_last_modified_time"
            r10 = 1
            r3[r10] = r4     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            java.lang.String r4 = "e_tag"
            r11 = 2
            r3[r11] = r4     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            java.lang.String r4 = "app_id=?"
            java.lang.String[] r5 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            r5[r9] = r13     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L74 android.database.sqlite.SQLiteException -> L76
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8f
            if (r2 != 0) goto L3c
            if (r1 == 0) goto L3b
            r1.close()
        L3b:
            return r0
        L3c:
            byte[] r2 = r1.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8f
            java.lang.String r3 = r1.getString(r10)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8f
            java.lang.String r4 = r1.getString(r11)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8f
            boolean r5 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8f
            if (r5 == 0) goto L5f
            com.google.android.gms.measurement.internal.zzfw r5 = r12.zzj()     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8f
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzg()     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8f
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfw.zza(r13)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8f
            r5.zza(r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8f
        L5f:
            if (r2 != 0) goto L67
            if (r1 == 0) goto L66
            r1.close()
        L66:
            return r0
        L67:
            com.google.android.gms.measurement.internal.zzan r5 = new com.google.android.gms.measurement.internal.zzan     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8f
            r5.<init>(r2, r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L72 java.lang.Throwable -> L8f
            if (r1 == 0) goto L71
            r1.close()
        L71:
            return r5
        L72:
            r2 = move-exception
            goto L78
        L74:
            r13 = move-exception
            goto L91
        L76:
            r2 = move-exception
            r1 = r0
        L78:
            com.google.android.gms.measurement.internal.zzfw r3 = r12.zzj()     // Catch: java.lang.Throwable -> L8f
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzfw.zza(r13)     // Catch: java.lang.Throwable -> L8f
            r3.zza(r4, r13, r2)     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8e
            r1.close()
        L8e:
            return r0
        L8f:
            r13 = move-exception
            r0 = r1
        L91:
            if (r0 == 0) goto L96
            r0.close()
        L96:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzf(java.lang.String):com.google.android.gms.measurement.internal.zzan");
    }

    public final zzaq zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return zza(j, str, 1L, false, false, z3, false, z5, z6);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzaq zza(long r22, java.lang.String r24, long r25, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31, boolean r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(long, java.lang.String, long, boolean, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzaq");
    }

    public final zzav zzg(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        return zzav.zza(zza("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzaz zzd(String str, String str2) {
        return zzc("events", str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.measurement.internal.zzaz zzc(java.lang.String r28, java.lang.String r29, java.lang.String r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzc(java.lang.String, java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzaz");
    }

    public final zzin zzh(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        return zzin.zzb(zza("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzin zzi(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        zzin zzinVar = (zzin) zza("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new zzas() { // from class: com.google.android.gms.measurement.internal.zzao
            @Override // com.google.android.gms.measurement.internal.zzas
            public final Object zza(Cursor cursor) {
                return zzin.zza(cursor.getString(0), cursor.getInt(1));
            }
        });
        return zzinVar == null ? zzin.zza : zzinVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zznq zze(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzt()
            r18.zzal()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.e_()     // Catch: java.lang.Throwable -> L8e android.database.sqlite.SQLiteException -> L92
            java.lang.String r11 = "user_attributes"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L8e android.database.sqlite.SQLiteException -> L92
            java.lang.String r0 = "set_timestamp"
            r1 = 0
            r12[r1] = r0     // Catch: java.lang.Throwable -> L8e android.database.sqlite.SQLiteException -> L92
            java.lang.String r0 = "value"
            r2 = 1
            r12[r2] = r0     // Catch: java.lang.Throwable -> L8e android.database.sqlite.SQLiteException -> L92
            java.lang.String r0 = "origin"
            r3 = 2
            r12[r3] = r0     // Catch: java.lang.Throwable -> L8e android.database.sqlite.SQLiteException -> L92
            java.lang.String r13 = "app_id=? and name=?"
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L8e android.database.sqlite.SQLiteException -> L92
            r14[r1] = r19     // Catch: java.lang.Throwable -> L8e android.database.sqlite.SQLiteException -> L92
            r14[r2] = r8     // Catch: java.lang.Throwable -> L8e android.database.sqlite.SQLiteException -> L92
            r16 = 0
            r17 = 0
            r15 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L8e android.database.sqlite.SQLiteException -> L92
            boolean r0 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            if (r0 != 0) goto L47
            if (r10 == 0) goto L46
            r10.close()
        L46:
            return r9
        L47:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L86 android.database.sqlite.SQLiteException -> L8a
            r11 = r18
            java.lang.Object r7 = r11.zza(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L84 java.lang.Throwable -> Lb5
            if (r7 != 0) goto L59
            if (r10 == 0) goto L58
            r10.close()
        L58:
            return r9
        L59:
            java.lang.String r3 = r10.getString(r3)     // Catch: android.database.sqlite.SQLiteException -> L84 java.lang.Throwable -> Lb5
            com.google.android.gms.measurement.internal.zznq r0 = new com.google.android.gms.measurement.internal.zznq     // Catch: android.database.sqlite.SQLiteException -> L84 java.lang.Throwable -> Lb5
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L84 java.lang.Throwable -> Lb5
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L84 java.lang.Throwable -> Lb5
            if (r1 == 0) goto L7e
            com.google.android.gms.measurement.internal.zzfw r1 = r18.zzj()     // Catch: android.database.sqlite.SQLiteException -> L84 java.lang.Throwable -> Lb5
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch: android.database.sqlite.SQLiteException -> L84 java.lang.Throwable -> Lb5
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfw.zza(r19)     // Catch: android.database.sqlite.SQLiteException -> L84 java.lang.Throwable -> Lb5
            r1.zza(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L84 java.lang.Throwable -> Lb5
        L7e:
            if (r10 == 0) goto L83
            r10.close()
        L83:
            return r0
        L84:
            r0 = move-exception
            goto L96
        L86:
            r0 = move-exception
            r11 = r18
            goto Lb6
        L8a:
            r0 = move-exception
            r11 = r18
            goto L96
        L8e:
            r0 = move-exception
            r11 = r18
            goto Lb7
        L92:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L96:
            com.google.android.gms.measurement.internal.zzfw r1 = r18.zzj()     // Catch: java.lang.Throwable -> Lb5
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfw.zza(r19)     // Catch: java.lang.Throwable -> Lb5
            com.google.android.gms.measurement.internal.zzfr r4 = r18.zzi()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r4 = r4.zzc(r8)     // Catch: java.lang.Throwable -> Lb5
            r1.zza(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> Lb5
            if (r10 == 0) goto Lb4
            r10.close()
        Lb4:
            return r9
        Lb5:
            r0 = move-exception
        Lb6:
            r9 = r10
        Lb7:
            if (r9 == 0) goto Lbc
            r9.close()
        Lbc:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zze(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zznq");
    }

    private final Object zza(Cursor cursor, int i) throws IllegalStateException {
        int type = cursor.getType(i);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type == 4) {
            zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
        zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final <T> T zza(java.lang.String r3, java.lang.String[] r4, com.google.android.gms.measurement.internal.zzas<T> r5) throws java.lang.Throwable {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.e_()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30
            android.database.Cursor r3 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30
            boolean r4 = r3.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            if (r4 != 0) goto L22
            com.google.android.gms.measurement.internal.zzfw r4 = r2.zzj()     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            com.google.android.gms.measurement.internal.zzfy r4 = r4.zzp()     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            java.lang.String r5 = "No data found"
            r4.zza(r5)     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            if (r3 == 0) goto L21
            r3.close()
        L21:
            return r0
        L22:
            java.lang.Object r4 = r5.zza(r3)     // Catch: android.database.sqlite.SQLiteException -> L2c java.lang.Throwable -> L45
            if (r3 == 0) goto L2b
            r3.close()
        L2b:
            return r4
        L2c:
            r4 = move-exception
            goto L32
        L2e:
            r4 = move-exception
            goto L47
        L30:
            r4 = move-exception
            r3 = r0
        L32:
            com.google.android.gms.measurement.internal.zzfw r5 = r2.zzj()     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzg()     // Catch: java.lang.Throwable -> L45
            java.lang.String r1 = "Error querying database."
            r5.zza(r1, r4)     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L44
            r3.close()
        L44:
            return r0
        L45:
            r4 = move-exception
            r0 = r3
        L47:
            if (r0 == 0) goto L4c
            r0.close()
        L4c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.String[], com.google.android.gms.measurement.internal.zzas):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zza(long r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r4.zzt()
            r4.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.e_()     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L58
            if (r1 != 0) goto L35
            com.google.android.gms.measurement.internal.zzfw r6 = r4.zzj()     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L58
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzp()     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L58
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L58
            if (r5 == 0) goto L34
            r5.close()
        L34:
            return r0
        L35:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3f java.lang.Throwable -> L58
            if (r5 == 0) goto L3e
            r5.close()
        L3e:
            return r6
        L3f:
            r6 = move-exception
            goto L45
        L41:
            r6 = move-exception
            goto L5a
        L43:
            r6 = move-exception
            r5 = r0
        L45:
            com.google.android.gms.measurement.internal.zzfw r1 = r4.zzj()     // Catch: java.lang.Throwable -> L58
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch: java.lang.Throwable -> L58
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L57
            r5.close()
        L57:
            return r0
        L58:
            r6 = move-exception
            r0 = r5
        L5a:
            if (r0 == 0) goto L5f
            r0.close()
        L5f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(long):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f_() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.e_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L25 android.database.sqlite.SQLiteException -> L2a
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L23 java.lang.Throwable -> L3f
            if (r2 == 0) goto L1d
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L23 java.lang.Throwable -> L3f
            if (r0 == 0) goto L1c
            r0.close()
        L1c:
            return r1
        L1d:
            if (r0 == 0) goto L22
            r0.close()
        L22:
            return r1
        L23:
            r2 = move-exception
            goto L2c
        L25:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L40
        L2a:
            r2 = move-exception
            r0 = r1
        L2c:
            com.google.android.gms.measurement.internal.zzfw r3 = r6.zzj()     // Catch: java.lang.Throwable -> L3f
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch: java.lang.Throwable -> L3f
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch: java.lang.Throwable -> L3f
            if (r0 == 0) goto L3e
            r0.close()
        L3e:
            return r1
        L3f:
            r1 = move-exception
        L40:
            if (r0 == 0) goto L45
            r0.close()
        L45:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.f_():java.lang.String");
    }

    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getString(0);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return str2;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    public final List<Pair<zzfn.zzk, Long>> zza(String str, int i, int i2) {
        byte[] bArrZzc;
        long jZzc;
        long jZzc2;
        zzt();
        zzal();
        int i3 = 1;
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
                if (!cursorQuery.moveToFirst()) {
                    List<Pair<zzfn.zzk, Long>> listEmptyList = Collections.emptyList();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return listEmptyList;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                while (true) {
                    long j = cursorQuery.getLong(0);
                    try {
                        bArrZzc = g_().zzc(cursorQuery.getBlob(i3));
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to unzip queued bundle. appId", zzfw.zza(str), e);
                    }
                    if (!arrayList.isEmpty() && bArrZzc.length + length > i2) {
                        break;
                    }
                    try {
                        zzfn.zzk.zza zzaVar = (zzfn.zzk.zza) zznl.zza(zzfn.zzk.zzw(), bArrZzc);
                        if (!arrayList.isEmpty()) {
                            zzfn.zzk zzkVar = (zzfn.zzk) ((Pair) arrayList.get(0)).first;
                            zzfn.zzk zzkVar2 = (zzfn.zzk) ((com.google.android.gms.internal.measurement.zzjk) zzaVar.zzai());
                            if (!zzkVar.zzae().equals(zzkVar2.zzae()) || !zzkVar.zzad().equals(zzkVar2.zzad()) || zzkVar.zzau() != zzkVar2.zzau() || !zzkVar.zzaf().equals(zzkVar2.zzaf())) {
                                break;
                            }
                            Iterator<zzfn.zzo> it = zzkVar.zzas().iterator();
                            while (true) {
                                jZzc = -1;
                                if (!it.hasNext()) {
                                    jZzc2 = -1;
                                    break;
                                }
                                zzfn.zzo next = it.next();
                                if ("_npa".equals(next.zzg())) {
                                    jZzc2 = next.zzc();
                                    break;
                                }
                            }
                            Iterator<zzfn.zzo> it2 = zzkVar2.zzas().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                zzfn.zzo next2 = it2.next();
                                if ("_npa".equals(next2.zzg())) {
                                    jZzc = next2.zzc();
                                    break;
                                }
                            }
                            if (jZzc2 != jZzc) {
                                break;
                            }
                        }
                        if (!cursorQuery.isNull(2)) {
                            zzaVar.zzi(cursorQuery.getInt(2));
                        }
                        length += bArrZzc.length;
                        arrayList.add(Pair.create((zzfn.zzk) ((com.google.android.gms.internal.measurement.zzjk) zzaVar.zzai()), Long.valueOf(j)));
                    } catch (IOException e2) {
                        zzj().zzg().zza("Failed to merge queued bundle. appId", zzfw.zza(str), e2);
                    }
                    if (!cursorQuery.moveToNext() || length > i2) {
                        break;
                    }
                    i3 = 1;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                zzj().zzg().zza("Error querying bundles. appId", zzfw.zza(str), e3);
                List<Pair<zzfn.zzk, Long>> listEmptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return listEmptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzae> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + Marker.ANY_MARKER);
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0094, code lost:
    
        zzj().zzg().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzae> zza(java.lang.String r40, java.lang.String[] r41) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final List<zzmu> zzj(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = e_().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new zzmu(string, cursorQuery.getLong(1), cursorQuery.getInt(2)));
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying trigger uris. appId", zzfw.zza(str), e);
                List<zzmu> listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zznq> zzk(java.lang.String r23) throws java.lang.Throwable {
        /*
            r22 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23)
            r22.zzt()
            r22.zzal()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r22.e_()     // Catch: java.lang.Throwable -> L91 android.database.sqlite.SQLiteException -> L95
            java.lang.String r3 = "user_attributes"
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L91 android.database.sqlite.SQLiteException -> L95
            java.lang.String r5 = "name"
            r11 = 0
            r4[r11] = r5     // Catch: java.lang.Throwable -> L91 android.database.sqlite.SQLiteException -> L95
            java.lang.String r5 = "origin"
            r12 = 1
            r4[r12] = r5     // Catch: java.lang.Throwable -> L91 android.database.sqlite.SQLiteException -> L95
            java.lang.String r5 = "set_timestamp"
            r13 = 2
            r4[r13] = r5     // Catch: java.lang.Throwable -> L91 android.database.sqlite.SQLiteException -> L95
            java.lang.String r5 = "value"
            r14 = 3
            r4[r14] = r5     // Catch: java.lang.Throwable -> L91 android.database.sqlite.SQLiteException -> L95
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch: java.lang.Throwable -> L91 android.database.sqlite.SQLiteException -> L95
            r6[r11] = r23     // Catch: java.lang.Throwable -> L91 android.database.sqlite.SQLiteException -> L95
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L91 android.database.sqlite.SQLiteException -> L95
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L91 android.database.sqlite.SQLiteException -> L95
            if (r2 != 0) goto L4c
            if (r1 == 0) goto L4b
            r1.close()
        L4b:
            return r0
        L4c:
            java.lang.String r18 = r1.getString(r11)     // Catch: java.lang.Throwable -> L91 android.database.sqlite.SQLiteException -> L95
            java.lang.String r2 = r1.getString(r12)     // Catch: java.lang.Throwable -> L91 android.database.sqlite.SQLiteException -> L95
            if (r2 != 0) goto L58
            java.lang.String r2 = ""
        L58:
            r17 = r2
            long r19 = r1.getLong(r13)     // Catch: java.lang.Throwable -> L91 android.database.sqlite.SQLiteException -> L95
            r2 = r22
            java.lang.Object r21 = r2.zza(r1, r14)     // Catch: android.database.sqlite.SQLiteException -> L8f java.lang.Throwable -> Lb3
            if (r21 != 0) goto L78
            com.google.android.gms.measurement.internal.zzfw r3 = r22.zzj()     // Catch: android.database.sqlite.SQLiteException -> L8f java.lang.Throwable -> Lb3
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L8f java.lang.Throwable -> Lb3
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfw.zza(r23)     // Catch: android.database.sqlite.SQLiteException -> L8f java.lang.Throwable -> Lb3
            r3.zza(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L8f java.lang.Throwable -> Lb3
            goto L83
        L78:
            com.google.android.gms.measurement.internal.zznq r3 = new com.google.android.gms.measurement.internal.zznq     // Catch: android.database.sqlite.SQLiteException -> L8f java.lang.Throwable -> Lb3
            r15 = r3
            r16 = r23
            r15.<init>(r16, r17, r18, r19, r21)     // Catch: android.database.sqlite.SQLiteException -> L8f java.lang.Throwable -> Lb3
            r0.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L8f java.lang.Throwable -> Lb3
        L83:
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L8f java.lang.Throwable -> Lb3
            if (r3 != 0) goto L4c
            if (r1 == 0) goto L8e
            r1.close()
        L8e:
            return r0
        L8f:
            r0 = move-exception
            goto L98
        L91:
            r0 = move-exception
            r2 = r22
            goto Lb4
        L95:
            r0 = move-exception
            r2 = r22
        L98:
            com.google.android.gms.measurement.internal.zzfw r3 = r22.zzj()     // Catch: java.lang.Throwable -> Lb3
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfw.zza(r23)     // Catch: java.lang.Throwable -> Lb3
            r3.zza(r4, r5, r0)     // Catch: java.lang.Throwable -> Lb3
            java.util.List r0 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> Lb3
            if (r1 == 0) goto Lb2
            r1.close()
        Lb2:
            return r0
        Lb3:
            r0 = move-exception
        Lb4:
            if (r1 == 0) goto Lb9
            r1.close()
        Lb9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzk(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a9, code lost:
    
        zzj().zzg().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zznq> zzb(java.lang.String r23, java.lang.String r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    final Map<Integer, zzfn.zzm> zzl(String str) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, zzfn.zzm> mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap;
                }
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i = cursorQuery.getInt(0);
                    try {
                        arrayMap.put(Integer.valueOf(i), (zzfn.zzm) ((com.google.android.gms.internal.measurement.zzjk) ((zzfn.zzm.zza) zznl.zza(zzfn.zzm.zze(), cursorQuery.getBlob(1))).zzai()));
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter results. appId, audienceId, error", zzfw.zza(str), Integer.valueOf(i), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filter results. appId", zzfw.zza(str), e2);
                Map<Integer, zzfn.zzm> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<zzff.zzb>> zzm(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzff.zzb>> mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzff.zzb zzbVar = (zzff.zzb) ((com.google.android.gms.internal.measurement.zzjk) ((zzff.zzb.zza) zznl.zza(zzff.zzb.zzc(), cursorQuery.getBlob(1))).zzai());
                        if (zzbVar.zzk()) {
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(zzbVar);
                        }
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzfw.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filters. appId", zzfw.zza(str), e2);
            Map<Integer, List<zzff.zzb>> mapEmptyMap2 = Collections.emptyMap();
            if (0 != 0) {
                cursor.close();
            }
            return mapEmptyMap2;
        }
    }

    final Map<Integer, List<zzff.zzb>> zzf(String str, String str2) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzff.zzb>> mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzff.zzb zzbVar = (zzff.zzb) ((com.google.android.gms.internal.measurement.zzjk) ((zzff.zzb.zza) zznl.zza(zzff.zzb.zzc(), cursorQuery.getBlob(1))).zzai());
                        int i = cursorQuery.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), arrayList);
                        }
                        arrayList.add(zzbVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzfw.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filters. appId", zzfw.zza(str), e2);
            Map<Integer, List<zzff.zzb>> mapEmptyMap2 = Collections.emptyMap();
            if (0 != 0) {
                cursor.close();
            }
            return mapEmptyMap2;
        }
    }

    final Map<Integer, List<zzff.zze>> zzg(String str, String str2) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzff.zze>> mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzff.zze zzeVar = (zzff.zze) ((com.google.android.gms.internal.measurement.zzjk) ((zzff.zze.zza) zznl.zza(zzff.zze.zzc(), cursorQuery.getBlob(1))).zzai());
                        int i = cursorQuery.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), arrayList);
                        }
                        arrayList.add(zzeVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter", zzfw.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzfw.zza(str), e2);
                Map<Integer, List<zzff.zze>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<Integer>> zzn(String str) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = e_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                if (!cursorRawQuery.moveToFirst()) {
                    Map<Integer, List<Integer>> mapEmptyMap = Collections.emptyMap();
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    int i = cursorRawQuery.getInt(0);
                    List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), arrayList);
                    }
                    arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                } while (cursorRawQuery.moveToNext());
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayMap;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error querying scoped filters. appId", zzfw.zza(str), e);
                Map<Integer, List<Integer>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    zzal(zznc zzncVar) {
        super(zzncVar);
        this.zzm = new zzmr(zzb());
        this.zzl = new zzar(this, zza(), "google_app_measurement.db");
    }

    public final void zzp() {
        zzal();
        e_().beginTransaction();
    }

    private final void zzi(String str, String str2) throws IllegalStateException {
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            e_().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting snapshot. appId", zzfw.zza(str2), e);
        }
    }

    public final void zzo(String str) throws IllegalStateException {
        zzaz zzazVarZzd;
        zzi("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = e_().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return;
                    }
                    return;
                }
                do {
                    String string = cursorQuery.getString(0);
                    if (string != null && (zzazVarZzd = zzd(str, string)) != null) {
                        zza("events_snapshot", zzazVarZzd);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error creating snapshot. appId", zzfw.zza(str), e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final void zzu() {
        zzal();
        e_().endTransaction();
    }

    final void zza(List<Long> list) throws IllegalStateException, SQLException {
        zzt();
        zzal();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzaa()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzb("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzu().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                e_().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error incrementing retry count. error", e);
            }
        }
    }

    final void zzv() {
        int iDelete;
        zzt();
        zzal();
        if (zzaa()) {
            long jZza = zzn().zza.zza();
            long jElapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jZza) > zzbf.zzy.zza(null).longValue()) {
                zzn().zza.zza(jElapsedRealtime);
                zzt();
                zzal();
                if (!zzaa() || (iDelete = e_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzag.zzm())})) <= 0) {
                    return;
                }
                zzj().zzp().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    public final void zzh(String str, String str2) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            e_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting user property. appId", zzfw.zza(str), zzi().zzc(str2), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzp(java.lang.String r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzp(java.lang.String):void");
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0210 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void zza(java.lang.String r18, java.util.List<com.google.android.gms.internal.measurement.zzff.zza> r19) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.util.List):void");
    }

    public final void zzw() {
        zzal();
        e_().setTransactionSuccessful();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.measurement.internal.zzg r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(com.google.android.gms.measurement.internal.zzg, boolean, boolean):void");
    }

    public final void zza(String str, zzav zzavVar) throws IllegalStateException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzavVar);
        zzt();
        zzal();
        if (zze().zza(zzbf.zzcj) && zzi(str) == zzin.zza) {
            zzb(str, zzin.zza);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzavVar.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zza(zzaz zzazVar) throws IllegalStateException {
        zza("events", zzazVar);
    }

    private final void zza(String str, zzaz zzazVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzazVar);
        zzt();
        zzal();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzazVar.zza);
        contentValues.put("name", zzazVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzazVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzazVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzazVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzazVar.zzg));
        contentValues.put("last_bundled_day", zzazVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzazVar.zzi);
        contentValues.put("last_sampling_rate", zzazVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzazVar.zze));
        contentValues.put("last_exempt_from_sampling", (zzazVar.zzk == null || !zzazVar.zzk.booleanValue()) ? null : 1L);
        try {
            if (e_().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzfw.zza(zzazVar.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzfw.zza(zzazVar.zza), e);
        }
    }

    private final void zza(String str, String str2, ContentValues contentValues) throws IllegalStateException {
        try {
            SQLiteDatabase sQLiteDatabaseE_ = e_();
            if (contentValues.getAsString(str2) == null) {
                zzj().zzh().zza("Value of the primary key is not set.", zzfw.zza(str2));
            } else if (sQLiteDatabaseE_.update(str, contentValues, str2 + " = ?", new String[]{r1}) == 0 && sQLiteDatabaseE_.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update table (got -1). key", zzfw.zza(str), zzfw.zza(str2));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing into table. key", zzfw.zza(str), zzfw.zza(str2), e);
        }
    }

    public final void zza(String str, zzin zzinVar) throws IllegalStateException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzinVar);
        zzt();
        zzal();
        zzb(str, zzi(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzinVar.zzh());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zzb(String str, zzin zzinVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzinVar);
        zzt();
        zzal();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzinVar.zzh());
        contentValues.put("consent_source", Integer.valueOf(zzinVar.zza()));
        zza("consent_settings", "app_id", contentValues);
    }

    private final boolean zzb(String str, List<Integer> list) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        zzal();
        zzt();
        SQLiteDatabase sQLiteDatabaseE_ = e_();
        try {
            long jZzb = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, zze().zzb(str, zzbf.zzaf)));
            if (jZzb <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            return sQLiteDatabaseE_.delete("audience_filter_values", new StringBuilder("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(new StringBuilder("(").append(TextUtils.join(",", arrayList)).append(")").toString()).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error querying filters. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final boolean zza(zzfn.zzk zzkVar, boolean z) throws IllegalStateException {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzkVar);
        Preconditions.checkNotEmpty(zzkVar.zzz());
        Preconditions.checkState(zzkVar.zzbi());
        zzv();
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        if (zzkVar.zzm() < jCurrentTimeMillis - zzag.zzm() || zzkVar.zzm() > zzag.zzm() + jCurrentTimeMillis) {
            zzj().zzu().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfw.zza(zzkVar.zzz()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzkVar.zzm()));
        }
        try {
            byte[] bArrZzb = g_().zzb(zzkVar.zzbz());
            zzj().zzp().zza("Saving bundle, size", Integer.valueOf(bArrZzb.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkVar.zzz());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzkVar.zzm()));
            contentValues.put("data", bArrZzb);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzkVar.zzbp()) {
                contentValues.put("retry_count", Integer.valueOf(zzkVar.zzg()));
            }
            try {
                if (e_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzfw.zza(zzkVar.zzz()));
                return false;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error storing bundle. appId", zzfw.zza(zzkVar.zzz()), e);
                return false;
            }
        } catch (IOException e2) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzfw.zza(zzkVar.zzz()), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzff.zzb zzbVar) throws IllegalStateException {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (zzbVar.zzf().isEmpty()) {
            zzj().zzu().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzfw.zza(str), Integer.valueOf(i), String.valueOf(zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbz = zzbVar.zzbz();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzf());
        contentValues.put("session_scoped", zzbVar.zzm() ? Boolean.valueOf(zzbVar.zzj()) : null);
        contentValues.put("data", bArrZzbz);
        try {
            if (e_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzfw.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event filter. appId", zzfw.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzff.zze zzeVar) throws IllegalStateException {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (zzeVar.zze().isEmpty()) {
            zzj().zzu().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzfw.zza(str), Integer.valueOf(i), String.valueOf(zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null));
            return false;
        }
        byte[] bArrZzbz = zzeVar.zzbz();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null);
        contentValues.put("property_name", zzeVar.zze());
        contentValues.put("session_scoped", zzeVar.zzj() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put("data", bArrZzbz);
        try {
            if (e_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing property filter. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzba zzbaVar, long j, boolean z) throws IllegalStateException {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzbaVar);
        Preconditions.checkNotEmpty(zzbaVar.zza);
        byte[] bArrZzbz = g_().zza(zzbaVar).zzbz();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbaVar.zza);
        contentValues.put("name", zzbaVar.zzb);
        contentValues.put(SDKConstants.PARAM_DEBUG_MESSAGE_TIMESTAMP, Long.valueOf(zzbaVar.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", bArrZzbz);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (e_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzfw.zza(zzbaVar.zza));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event. appId", zzfw.zza(zzbaVar.zza), e);
            return false;
        }
    }

    public final boolean zza(String str, zzmu zzmuVar) throws IllegalStateException {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzmuVar);
        Preconditions.checkNotEmpty(str);
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        if (zzmuVar.zzb < jCurrentTimeMillis - zzag.zzm() || zzmuVar.zzb > zzag.zzm() + jCurrentTimeMillis) {
            zzj().zzu().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzfw.zza(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzmuVar.zzb));
        }
        zzj().zzp().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzmuVar.zza);
        contentValues.put("source", Integer.valueOf(zzmuVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(zzmuVar.zzb));
        try {
            if (e_().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzfw.zza(str), e);
            return false;
        }
    }

    protected final boolean zzaa() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean zza(String str, Long l, long j, zzfn.zzf zzfVar) throws IllegalStateException {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzfVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] bArrZzbz = zzfVar.zzbz();
        zzj().zzp().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(bArrZzbz.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrZzbz);
        try {
            if (e_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing complex main event. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzae zzaeVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzaeVar);
        zzt();
        zzal();
        String str = zzaeVar.zza;
        Preconditions.checkNotNull(str);
        if (zze(str, zzaeVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzaeVar.zzb);
        contentValues.put("name", zzaeVar.zzc.zza);
        zza(contentValues, "value", Preconditions.checkNotNull(zzaeVar.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzaeVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzaeVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzaeVar.zzh));
        zzq();
        contentValues.put("timed_out_event", zznp.zza((Parcelable) zzaeVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzaeVar.zzd));
        zzq();
        contentValues.put("triggered_event", zznp.zza((Parcelable) zzaeVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzaeVar.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzaeVar.zzj));
        zzq();
        contentValues.put("expired_event", zznp.zza((Parcelable) zzaeVar.zzk));
        try {
            if (e_().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzfw.zza(str));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing conditional user property", zzfw.zza(str), e);
        }
        return true;
    }

    final boolean zza(String str, Bundle bundle) {
        zzt();
        zzal();
        byte[] bArrZzbz = g_().zza(new zzba(this.zzu, "", str, "dep", 0L, 0L, bundle)).zzbz();
        zzj().zzp().zza("Saving default event parameters, appId, data size", zzi().zza(str), Integer.valueOf(bArrZzbz.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrZzbz);
        try {
            if (e_().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing default event parameters. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zznq zznqVar) {
        Preconditions.checkNotNull(zznqVar);
        zzt();
        zzal();
        if (zze(zznqVar.zza, zznqVar.zzc) == null) {
            if (zznp.zzh(zznqVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zznqVar.zza}) >= zze().zza(zznqVar.zza, zzbf.zzag, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zznqVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zznqVar.zza, zznqVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zznqVar.zza);
        contentValues.put("origin", zznqVar.zzb);
        contentValues.put("name", zznqVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zznqVar.zzd));
        zza(contentValues, "value", zznqVar.zze);
        try {
            if (e_().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzfw.zza(zznqVar.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing user property. appId", zzfw.zza(zznqVar.zza), e);
        }
        return true;
    }
}
