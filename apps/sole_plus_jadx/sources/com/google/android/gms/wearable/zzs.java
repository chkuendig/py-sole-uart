package com.google.android.gms.wearable;

import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzs extends com.google.android.gms.internal.wearable.zzi {
    final /* synthetic */ WearableListenerService zza;
    private boolean zzb;
    private final zzr zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzs(WearableListenerService wearableListenerService, Looper looper) {
        super(looper);
        this.zza = wearableListenerService;
        this.zzc = new zzr(wearableListenerService, null);
    }

    private final synchronized void zzc() {
        if (this.zzb) {
            return;
        }
        if (Log.isLoggable("WearableLS", 2)) {
            Log.v("WearableLS", "bindService: ".concat(String.valueOf(String.valueOf(this.zza.zza))));
        }
        WearableListenerService wearableListenerService = this.zza;
        wearableListenerService.bindService(wearableListenerService.zzd, this.zzc, 1);
        this.zzb = true;
    }

    private final synchronized void zzd(String str) {
        if (this.zzb) {
            if (Log.isLoggable("WearableLS", 2)) {
                Log.v("WearableLS", "unbindService: " + str + ", " + String.valueOf(this.zza.zza));
            }
            try {
                this.zza.unbindService(this.zzc);
            } catch (RuntimeException e) {
                Log.e("WearableLS", "Exception when unbinding from local service", e);
            }
            this.zzb = false;
        }
    }

    @Override // com.google.android.gms.internal.wearable.zzi
    protected final void zza(Message message) {
        zzc();
        try {
            super.zza(message);
            if (hasMessages(0)) {
                return;
            }
            zzd("dispatch");
        } catch (Throwable th) {
            if (!hasMessages(0)) {
                zzd("dispatch");
            }
            throw th;
        }
    }

    final void zzb() {
        getLooper().quit();
        zzd("quit");
    }
}
