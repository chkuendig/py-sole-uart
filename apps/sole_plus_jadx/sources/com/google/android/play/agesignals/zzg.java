package com.google.android.play.agesignals;

import android.content.Context;
import com.google.android.gms.internal.playcore_age_signals.zzo;
import com.google.android.gms.internal.playcore_age_signals.zzr;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
public final class zzg {
    private static final com.google.android.gms.internal.playcore_age_signals.zzd zzb = new com.google.android.gms.internal.playcore_age_signals.zzd("AgeSignalsService");
    final zzo zza;
    private final Context zzc;

    public zzg(Context context) {
        this.zzc = context;
        if (zzr.zzb(context)) {
            this.zza = new zzo(context, zzb, "AgeSignalsService", zza.zza, new zzd(), null);
        } else {
            this.zza = null;
        }
    }

    private static Task zzd(int i) {
        zzb.zza("onError(%d)", Integer.valueOf(i));
        return Tasks.forException(new AgeSignalsException(i));
    }

    public final Task zzb(AgeSignalsRequest ageSignalsRequest) {
        zzo zzoVar = this.zza;
        if (zzoVar == null) {
            return zzd(-2);
        }
        if (zzr.zza(this.zzc) < 82380000) {
            return zzd(-6);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzoVar.zzt(new zze(this, taskCompletionSource, taskCompletionSource, ageSignalsRequest), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
