package com.google.android.gms.measurement.internal;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzgx implements zzef {
    final /* synthetic */ zzfv zza;

    zzgx(zzgy zzgyVar, zzfv zzfvVar) {
        this.zza = zzfvVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzef
    public final boolean zza() {
        return this.zza.zzL() && Log.isLoggable(this.zza.zzay().zzq(), 3);
    }
}
