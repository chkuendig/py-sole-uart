package com.google.android.gms.internal.playcore_age_signals;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.play.agesignals.protocol.IAgeSignalsService;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
final class zzk extends zze {
    final /* synthetic */ IBinder zza;
    final /* synthetic */ zzm zzb;

    zzk(zzm zzmVar, IBinder iBinder) {
        this.zza = iBinder;
        Objects.requireNonNull(zzmVar);
        this.zzb = zzmVar;
    }

    @Override // com.google.android.gms.internal.playcore_age_signals.zze
    public final void zzb() throws RemoteException {
        IAgeSignalsService iAgeSignalsServiceAsInterface = IAgeSignalsService.Stub.asInterface(this.zza);
        zzo zzoVar = this.zzb.zza;
        zzoVar.zzn = iAgeSignalsServiceAsInterface;
        zzo.zzr(zzoVar);
        zzoVar.zzh = false;
        Iterator it = zzoVar.zze.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        zzoVar.zze.clear();
    }
}
