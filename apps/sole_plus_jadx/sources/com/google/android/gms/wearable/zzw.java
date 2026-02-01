package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzw implements Runnable {
    final /* synthetic */ DataHolder zza;
    final /* synthetic */ zzag zzb;

    zzw(zzag zzagVar, DataHolder dataHolder) {
        this.zzb = zzagVar;
        this.zza = dataHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataEventBuffer dataEventBuffer = new DataEventBuffer(this.zza);
        try {
            this.zzb.zza.onDataChanged(dataEventBuffer);
        } finally {
            dataEventBuffer.release();
        }
    }
}
