package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzho implements zzky {
    final /* synthetic */ zzia zza;

    zzho(zzia zziaVar) {
        this.zza = zziaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzky
    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzD("auto", "_err", bundle);
        } else {
            this.zza.zzF("auto", "_err", bundle, str);
        }
    }
}
