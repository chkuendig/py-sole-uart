package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpg;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* loaded from: classes4.dex */
public final class zzgj {
    private final String zza;
    private final Bundle zzb;
    private Bundle zzc;
    private final /* synthetic */ zzgh zzd;

    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0123 A[Catch: NumberFormatException | JSONException -> 0x012b, NumberFormatException | JSONException -> 0x012b, TRY_LEAVE, TryCatch #1 {NumberFormatException | JSONException -> 0x012b, blocks: (B:9:0x0025, B:42:0x0094, B:42:0x0094, B:43:0x00a5, B:43:0x00a5, B:45:0x00ab, B:45:0x00ab, B:47:0x00b9, B:47:0x00b9, B:49:0x00cb, B:49:0x00cb, B:50:0x00d4, B:50:0x00d4, B:51:0x00d8, B:51:0x00d8, B:53:0x00de, B:53:0x00de, B:55:0x00ec, B:55:0x00ec, B:57:0x00fe, B:57:0x00fe, B:58:0x0107, B:58:0x0107, B:59:0x010b, B:59:0x010b, B:60:0x0117, B:60:0x0117, B:61:0x0123, B:61:0x0123, B:20:0x0053, B:23:0x005d, B:26:0x0067, B:29:0x0072, B:32:0x007c), top: B:75:0x0025, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle zza() {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgj.zza():android.os.Bundle");
    }

    private final String zzb(Bundle bundle) throws IllegalStateException, JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str);
                    if (zzpg.zza() && this.zzd.zze().zza(zzbf.zzca)) {
                        if (obj instanceof String) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put("t", "l");
                        } else if (obj instanceof int[]) {
                            jSONObject.put("v", Arrays.toString((int[]) obj));
                            jSONObject.put("t", "ia");
                        } else if (obj instanceof long[]) {
                            jSONObject.put("v", Arrays.toString((long[]) obj));
                            jSONObject.put("t", "la");
                        } else if (obj instanceof Double) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put("t", "d");
                        } else {
                            this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    } else {
                        jSONObject.put("v", String.valueOf(obj));
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e) {
                    this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences", e);
                }
            }
        }
        return jSONArray.toString();
    }

    public zzgj(zzgh zzghVar, String str, Bundle bundle) {
        this.zzd = zzghVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = new Bundle();
    }

    public final void zza(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor editorEdit = this.zzd.zzg().edit();
        if (bundle.size() == 0) {
            editorEdit.remove(this.zza);
        } else {
            editorEdit.putString(this.zza, zzb(bundle));
        }
        editorEdit.apply();
        this.zzc = bundle;
    }
}
