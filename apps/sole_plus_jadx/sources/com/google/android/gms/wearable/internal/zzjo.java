package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.MessageClient;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzjo implements ListenerHolder.Notifier {
    public static final /* synthetic */ int zzc = 0;
    final /* synthetic */ zzgp zza;
    final /* synthetic */ zzfn zzb;

    zzjo(zzgp zzgpVar, zzfn zzfnVar) {
        this.zza = zzgpVar;
        this.zzb = zzfnVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        Task<byte[]> taskOnRequest = ((MessageClient.RpcService) obj).onRequest(this.zza.getSourceNodeId(), this.zza.getPath(), this.zza.getData());
        if (taskOnRequest == null) {
            zzjq.zzy(this.zzb, false, null);
        } else {
            final zzfn zzfnVar = this.zzb;
            taskOnRequest.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.wearable.internal.zzjn
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    zzfn zzfnVar2 = zzfnVar;
                    int i = zzjo.zzc;
                    if (task.isSuccessful()) {
                        zzjq.zzy(zzfnVar2, true, (byte[]) task.getResult());
                    } else {
                        Log.e("WearableListenerStub", "Failed to resolve future, sending null response", task.getException());
                        zzjq.zzy(zzfnVar2, false, null);
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
        Log.e("WearableListenerStub", "Failed to notify listener, sending null response");
        zzjq.zzy(this.zzb, false, null);
    }
}
