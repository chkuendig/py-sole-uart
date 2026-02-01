package com.google.android.play.agesignals;

import android.os.Bundle;
import com.google.android.gms.internal.playcore_age_signals.zzo;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.agesignals.protocol.IAgeSignalsServiceCallback;
import java.util.Objects;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
final class zzf extends IAgeSignalsServiceCallback.Stub {
    final com.google.android.gms.internal.playcore_age_signals.zzd zza;
    final TaskCompletionSource zzb;
    final /* synthetic */ zzg zzc;

    zzf(zzg zzgVar, TaskCompletionSource taskCompletionSource) {
        Objects.requireNonNull(zzgVar);
        this.zzc = zzgVar;
        this.zza = new com.google.android.gms.internal.playcore_age_signals.zzd("OnCheckAgeSignalsCallback");
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.play.agesignals.protocol.IAgeSignalsServiceCallback
    public final void onCompleteCheckAgeSignals(Bundle bundle) {
        zzo zzoVar = this.zzc.zza;
        TaskCompletionSource taskCompletionSource = this.zzb;
        zzoVar.zzu(taskCompletionSource);
        this.zza.zzc("onCompleteCheckAgeSignals", new Object[0]);
        taskCompletionSource.trySetResult(AgeSignalsResult.zza(bundle));
    }

    @Override // com.google.android.play.agesignals.protocol.IAgeSignalsServiceCallback
    public final void onError(Bundle bundle) {
        zzo zzoVar = this.zzc.zza;
        TaskCompletionSource taskCompletionSource = this.zzb;
        zzoVar.zzu(taskCompletionSource);
        int i = bundle.getInt("error.code");
        this.zza.zza("onError(%d)", Integer.valueOf(i));
        taskCompletionSource.trySetException(new AgeSignalsException(i));
    }
}
