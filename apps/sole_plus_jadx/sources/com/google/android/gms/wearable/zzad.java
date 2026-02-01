package com.google.android.gms.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzad implements Runnable {
    final /* synthetic */ com.google.android.gms.wearable.internal.zzk zza;
    final /* synthetic */ zzag zzb;

    zzad(zzag zzagVar, com.google.android.gms.wearable.internal.zzk zzkVar) {
        this.zzb = zzagVar;
        this.zza = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.onEntityUpdate(this.zza);
    }
}
