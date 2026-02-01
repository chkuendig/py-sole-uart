package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeClient;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzhd extends NodeClient {
    final NodeApi zza;

    public zzhd(Activity activity, GoogleApi.Settings settings) {
        super(activity, settings);
        this.zza = new zzgv();
    }

    @Override // com.google.android.gms.wearable.NodeClient
    public final Task<String> getCompanionPackageForNode(final String str) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzgw
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzhd zzhdVar = this.zza;
                ((zzft) ((zzjj) obj).getService()).zzm(new zzir(new zzha(zzhdVar, (TaskCompletionSource) obj2)), str);
            }
        }).setFeatures(com.google.android.gms.wearable.zzj.zzc).setMethodKey(24023).build());
    }

    @Override // com.google.android.gms.wearable.NodeClient
    public final Task<List<Node>> getConnectedNodes() {
        NodeApi nodeApi = this.zza;
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzgs((zzgv) nodeApi, googleApiClientAsGoogleApiClient)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzgx
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((NodeApi.GetConnectedNodesResult) result).getNodes();
            }
        });
    }

    @Override // com.google.android.gms.wearable.NodeClient
    public final Task<Node> getLocalNode() {
        NodeApi nodeApi = this.zza;
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzgr((zzgv) nodeApi, googleApiClientAsGoogleApiClient)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzgz
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((NodeApi.GetLocalNodeResult) result).getNode();
            }
        });
    }

    @Override // com.google.android.gms.wearable.NodeClient
    public final Task<String> getNodeId(final String str) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzgy
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzhd zzhdVar = this.zza;
                String str2 = str;
                ((zzft) ((zzjj) obj).getService()).zzt(new zzhb(zzhdVar, (TaskCompletionSource) obj2), str2);
            }
        }).setFeatures(com.google.android.gms.wearable.zzj.zzn).setMethodKey(24025).build());
    }

    public zzhd(Context context, GoogleApi.Settings settings) {
        super(context, settings);
        this.zza = new zzgv();
    }
}
