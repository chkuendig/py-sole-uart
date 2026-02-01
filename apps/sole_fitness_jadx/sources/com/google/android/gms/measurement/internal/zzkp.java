package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzkp implements zzky {
    final /* synthetic */ zzks zza;

    zzkp(zzks zzksVar) {
        this.zza = zzksVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzky
    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzaz().zzp(new zzko(this, str, "_err", bundle));
        } else if (this.zza.zzn != null) {
            this.zza.zzn.zzay().zzd().zzb("AppId not known when logging event", "_err");
        }
    }
}
