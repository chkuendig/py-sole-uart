package com.google.android.gms.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzac implements Runnable {
    final /* synthetic */ com.google.android.gms.wearable.internal.zzn zza;
    final /* synthetic */ zzag zzb;

    zzac(zzag zzagVar, com.google.android.gms.wearable.internal.zzn zznVar) {
        this.zzb = zzagVar;
        this.zza = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.onNotificationReceived(this.zza);
    }
}
