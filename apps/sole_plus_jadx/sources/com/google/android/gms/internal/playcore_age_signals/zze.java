package com.google.android.gms.internal.playcore_age_signals;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
public abstract class zze implements Runnable {
    private final TaskCompletionSource zza;

    zze() {
        this.zza = null;
    }

    public zze(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzb();
        } catch (Exception e) {
            zza(e);
        }
    }

    public void zza(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.zza;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    protected abstract void zzb();

    final TaskCompletionSource zzc() {
        return this.zza;
    }
}
