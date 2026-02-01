package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzez {
    final /* synthetic */ zzfa zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;

    public zzez(zzfa zzfaVar, String str, String str2) {
        this.zza = zzfaVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
    }

    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zza.zza().getString(this.zzb, null);
        }
        return this.zzd;
    }

    public final void zzb(String str) {
        SharedPreferences.Editor editorEdit = this.zza.zza().edit();
        editorEdit.putString(this.zzb, str);
        editorEdit.apply();
        this.zzd = str;
    }
}
