package com.google.android.play.agesignals.testing;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.agesignals.AgeSignalsException;
import com.google.android.play.agesignals.AgeSignalsManager;
import com.google.android.play.agesignals.AgeSignalsRequest;
import com.google.android.play.agesignals.AgeSignalsResult;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
public class FakeAgeSignalsManager implements AgeSignalsManager {
    private AgeSignalsException zza;
    private AgeSignalsResult zzb;

    @Override // com.google.android.play.agesignals.AgeSignalsManager
    public Task<AgeSignalsResult> checkAgeSignals(AgeSignalsRequest ageSignalsRequest) {
        AgeSignalsException ageSignalsException = this.zza;
        if (ageSignalsException != null) {
            return Tasks.forException(ageSignalsException);
        }
        AgeSignalsResult ageSignalsResult = this.zzb;
        return ageSignalsResult != null ? Tasks.forResult(ageSignalsResult) : Tasks.forException(new IllegalStateException("FakeAgeSignalsManager not configured with a response or exception."));
    }

    public void setNextAgeSignalsException(AgeSignalsException ageSignalsException) {
        this.zza = ageSignalsException;
        this.zzb = null;
    }

    public void setNextAgeSignalsResult(AgeSignalsResult ageSignalsResult) {
        this.zza = null;
        this.zzb = ageSignalsResult;
    }
}
