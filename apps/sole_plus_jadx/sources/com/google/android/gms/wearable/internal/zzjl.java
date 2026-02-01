package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzjl implements ListenerHolder.Notifier {
    final /* synthetic */ DataHolder zza;

    zzjl(DataHolder dataHolder) {
        this.zza = dataHolder;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        try {
            ((DataApi.DataListener) obj).onDataChanged(new DataEventBuffer(this.zza));
        } finally {
            this.zza.close();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
        this.zza.close();
    }
}
