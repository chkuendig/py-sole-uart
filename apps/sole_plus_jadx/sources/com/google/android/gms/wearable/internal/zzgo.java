package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.RemoteException;
import androidx.core.util.Preconditions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageClient;
import com.google.android.gms.wearable.MessageOptions;
import com.google.android.gms.wearable.PutDataRequest;
import org.slf4j.Marker;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzgo extends MessageClient {
    public static final /* synthetic */ int zzb = 0;
    final zzgd zza;

    public zzgo(Activity activity, GoogleApi.Settings settings) {
        super(activity, settings);
        this.zza = new zzgd();
    }

    private final Task zza(final MessageClient.OnMessageReceivedListener onMessageReceivedListener, final IntentFilter[] intentFilterArr) {
        final ListenerHolder listenerHolderCreateListenerHolder = ListenerHolders.createListenerHolder(onMessageReceivedListener, getLooper(), "MessageListener");
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(listenerHolderCreateListenerHolder).register(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzgi
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                MessageClient.OnMessageReceivedListener onMessageReceivedListener2 = onMessageReceivedListener;
                ListenerHolder listenerHolder = listenerHolderCreateListenerHolder;
                IntentFilter[] intentFilterArr2 = intentFilterArr;
                int i = zzgo.zzb;
                ((zzjj) obj).zzs(new zzif((TaskCompletionSource) obj2), onMessageReceivedListener2, listenerHolder, intentFilterArr2);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzgj
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                MessageClient.OnMessageReceivedListener onMessageReceivedListener2 = onMessageReceivedListener;
                int i = zzgo.zzb;
                ((zzjj) obj).zzA(new zzie((TaskCompletionSource) obj2), onMessageReceivedListener2);
            }
        }).setMethodKey(24016).build());
    }

    private final Task zzb(final MessageClient.RpcService rpcService, final IntentFilter[] intentFilterArr) {
        final ListenerHolder listenerHolderCreateListenerHolder = ListenerHolders.createListenerHolder(rpcService, getLooper(), "RequestListener");
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(listenerHolderCreateListenerHolder).register(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzgf
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                MessageClient.RpcService rpcService2 = rpcService;
                ListenerHolder listenerHolder = listenerHolderCreateListenerHolder;
                IntentFilter[] intentFilterArr2 = intentFilterArr;
                int i = zzgo.zzb;
                ((zzjj) obj).zzt(new zzif((TaskCompletionSource) obj2), rpcService2, listenerHolder, intentFilterArr2);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzgg
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                MessageClient.RpcService rpcService2 = rpcService;
                int i = zzgo.zzb;
                ((zzjj) obj).zzB(new zzie((TaskCompletionSource) obj2), rpcService2);
            }
        }).setMethodKey(24017).build());
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Void> addListener(MessageClient.OnMessageReceivedListener onMessageReceivedListener) {
        return zza(onMessageReceivedListener, new IntentFilter[]{zzih.zza("com.google.android.gms.wearable.MESSAGE_RECEIVED")});
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Void> addRpcService(MessageClient.RpcService rpcService, String str) {
        Preconditions.checkNotNull(str, "pathPrefix must not be null");
        return zzb(rpcService, new IntentFilter[]{zzih.zzb(MessageClient.ACTION_REQUEST_RECEIVED, new Uri.Builder().scheme(PutDataRequest.WEAR_URI_SCHEME).authority(Marker.ANY_MARKER).path(str).build(), 1)});
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Boolean> removeListener(MessageClient.OnMessageReceivedListener onMessageReceivedListener) {
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(ListenerHolders.createListenerHolder(onMessageReceivedListener, getLooper(), "MessageListener").getListenerKey(), "Key must not be null"), 24007);
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Boolean> removeRpcService(MessageClient.RpcService rpcService) {
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(ListenerHolders.createListenerHolder(rpcService, getLooper(), "RequestListener").getListenerKey(), "Key must not be null"), 24008);
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Integer> sendMessage(String str, String str2, byte[] bArr) {
        zzgd zzgdVar = this.zza;
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzfy(zzgdVar, googleApiClientAsGoogleApiClient, str, str2, bArr)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzgh
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return Integer.valueOf(((MessageApi.SendMessageResult) result).getRequestId());
            }
        });
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<byte[]> sendRequest(final String str, final String str2, final byte[] bArr) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzge
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzgo zzgoVar = this.zza;
                ((zzft) ((zzjj) obj).getService()).zzB(new zzjd(new zzgm(zzgoVar, (TaskCompletionSource) obj2)), str, str2, bArr);
            }
        }).setMethodKey(24006).build());
    }

    public zzgo(Context context, GoogleApi.Settings settings) {
        super(context, settings);
        this.zza = new zzgd();
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Void> addListener(MessageClient.OnMessageReceivedListener onMessageReceivedListener, Uri uri, int i) {
        boolean z;
        Preconditions.checkNotNull(uri, "uri must not be null");
        if (i == 0) {
            z = true;
        } else if (i == 1) {
            i = 1;
            z = true;
        } else {
            z = false;
        }
        com.google.android.gms.common.internal.Preconditions.checkArgument(z, "invalid filter type");
        return zza(onMessageReceivedListener, new IntentFilter[]{zzih.zzb("com.google.android.gms.wearable.MESSAGE_RECEIVED", uri, i)});
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Integer> sendMessage(final String str, final String str2, final byte[] bArr, final MessageOptions messageOptions) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzgk
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzgo zzgoVar = this.zza;
                ((zzft) ((zzjj) obj).getService()).zzA(new zzjc(new zzgl(zzgoVar, (TaskCompletionSource) obj2)), str, str2, bArr, messageOptions);
            }
        }).setMethodKey(24020).setFeatures(com.google.android.gms.wearable.zzj.zzs).build());
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Void> addRpcService(MessageClient.RpcService rpcService, String str, String str2) {
        Preconditions.checkNotNull(str, "pathPrefix must not be null");
        return zzb(rpcService, new IntentFilter[]{zzih.zzb(MessageClient.ACTION_REQUEST_RECEIVED, new Uri.Builder().scheme(PutDataRequest.WEAR_URI_SCHEME).authority(str2).path(str).build(), 1)});
    }
}
