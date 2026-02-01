package com.google.android.play.agesignals;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.playcore_age_signals.zzp;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.agesignals.protocol.IAgeSignalsService;
import java.util.Objects;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
final class zze extends com.google.android.gms.internal.playcore_age_signals.zze {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ AgeSignalsRequest zzb;
    final /* synthetic */ zzg zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zze(zzg zzgVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, AgeSignalsRequest ageSignalsRequest) {
        super(taskCompletionSource);
        this.zza = taskCompletionSource2;
        this.zzb = ageSignalsRequest;
        Objects.requireNonNull(zzgVar);
        this.zzc = zzgVar;
    }

    @Override // com.google.android.gms.internal.playcore_age_signals.zze
    public final void zza(Exception exc) {
        if (exc instanceof zzp) {
            super.zza(new AgeSignalsException(-5));
        } else {
            super.zza(exc);
        }
    }

    @Override // com.google.android.gms.internal.playcore_age_signals.zze
    protected final void zzb() {
        try {
            zzg zzgVar = this.zzc;
            IAgeSignalsService iAgeSignalsService = (IAgeSignalsService) zzgVar.zza.zze();
            String packageName = zzgVar.zzc.getPackageName();
            Bundle bundle = new Bundle();
            bundle.putInt("playcore.version.code", 2);
            iAgeSignalsService.checkAgeRange(packageName, bundle, new zzf(zzgVar, this.zza));
        } catch (RemoteException e) {
            zzg.zzb.zzb(e, "checkAgeSignals(%s)", this.zzb);
            this.zza.trySetException(new AgeSignalsException(-100));
        }
    }
}
