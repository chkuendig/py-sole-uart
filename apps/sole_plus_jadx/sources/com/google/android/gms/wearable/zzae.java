package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzbj;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzae implements Runnable {
    final /* synthetic */ zzbj zza;
    final /* synthetic */ zzag zzb;

    zzae(zzag zzagVar, zzbj zzbjVar) {
        this.zzb = zzagVar;
        this.zza = zzbjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza(this.zzb.zza);
        this.zza.zza(this.zzb.zza.zzh);
    }
}
