package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzbh extends ChannelClient {
    public static final /* synthetic */ int zza = 0;
    private final zzay zzb;

    public zzbh(Activity activity, GoogleApi.Settings settings) {
        super(activity, settings);
        this.zzb = new zzay();
    }

    private static zzbu zzc(ChannelClient.Channel channel) {
        Preconditions.checkNotNull(channel, "channel must not be null");
        return (zzbu) channel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzbu zzd(Channel channel) {
        Preconditions.checkNotNull(channel, "channel must not be null");
        return (zzbu) channel;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> close(ChannelClient.Channel channel) {
        zzbu zzbuVarZzc = zzc(channel);
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toVoidTask(googleApiClientAsGoogleApiClient.enqueue(new zzbl(zzbuVarZzc, googleApiClientAsGoogleApiClient)));
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<InputStream> getInputStream(ChannelClient.Channel channel) {
        zzbu zzbuVarZzc = zzc(channel);
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzbn(zzbuVarZzc, googleApiClientAsGoogleApiClient)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzba
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((Channel.GetInputStreamResult) result).getInputStream();
            }
        });
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<OutputStream> getOutputStream(ChannelClient.Channel channel) {
        zzbu zzbuVarZzc = zzc(channel);
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzbo(zzbuVarZzc, googleApiClientAsGoogleApiClient)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzbf
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((Channel.GetOutputStreamResult) result).getOutputStream();
            }
        });
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<ChannelClient.Channel> openChannel(String str, String str2) {
        zzay zzayVar = this.zzb;
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        Preconditions.checkNotNull(googleApiClientAsGoogleApiClient, "client is null");
        Preconditions.checkNotNull(str, "nodeId is null");
        Preconditions.checkNotNull(str2, "path is null");
        return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzau(zzayVar, googleApiClientAsGoogleApiClient, str, str2)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzaz
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return zzbh.zzd(((ChannelApi.OpenChannelResult) result).getChannel());
            }
        });
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> receiveFile(ChannelClient.Channel channel, Uri uri, boolean z) {
        zzbu zzbuVarZzc = zzc(channel);
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        Preconditions.checkNotNull(googleApiClientAsGoogleApiClient, "client is null");
        Preconditions.checkNotNull(uri, "uri is null");
        return PendingResultUtil.toVoidTask(googleApiClientAsGoogleApiClient.enqueue(new zzbp(zzbuVarZzc, googleApiClientAsGoogleApiClient, uri, z)));
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> registerChannelCallback(ChannelClient.Channel channel, ChannelClient.ChannelCallback channelCallback) {
        final String strZzb = ((zzbu) channel).zzb();
        Preconditions.checkNotNull(channelCallback, "listener is null");
        ListenerHolder listenerHolderCreateListenerHolder = ListenerHolders.createListenerHolder(channelCallback, getLooper(), "ChannelListener:".concat(String.valueOf(strZzb)));
        final IntentFilter[] intentFilterArr = {zzih.zza("com.google.android.gms.wearable.CHANNEL_EVENT")};
        final zzbg zzbgVar = new zzbg(channelCallback);
        final ListenerHolder listenerHolderCreateListenerHolder2 = ListenerHolders.createListenerHolder(zzbgVar, getLooper(), "ChannelListener");
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(listenerHolderCreateListenerHolder).register(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzbd
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzbg zzbgVar2 = zzbgVar;
                ListenerHolder listenerHolder = listenerHolderCreateListenerHolder2;
                String str = strZzb;
                IntentFilter[] intentFilterArr2 = intentFilterArr;
                zzjj zzjjVar = (zzjj) obj;
                int i = zzbh.zza;
                zzjjVar.zzq(new zzif((TaskCompletionSource) obj2), zzbgVar2, listenerHolder, str, intentFilterArr2);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzbe
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzbg zzbgVar2 = zzbgVar;
                String str = strZzb;
                int i = zzbh.zza;
                ((zzjj) obj).zzy(new zzie((TaskCompletionSource) obj2), zzbgVar2, str);
            }
        }).setMethodKey(24014).build());
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> sendFile(ChannelClient.Channel channel, Uri uri) {
        return PendingResultUtil.toVoidTask(zzc(channel).sendFile(asGoogleApiClient(), uri, 0L, -1L));
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Boolean> unregisterChannelCallback(ChannelClient.Channel channel, ChannelClient.ChannelCallback channelCallback) {
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(ListenerHolders.createListenerHolder(channelCallback, getLooper(), "ChannelListener:".concat(String.valueOf(zzc(channel).zzb()))).getListenerKey(), "Key must not be null"), 24004);
    }

    public zzbh(Context context, GoogleApi.Settings settings) {
        super(context, settings);
        this.zzb = new zzay();
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> close(ChannelClient.Channel channel, int i) {
        zzbu zzbuVarZzc = zzc(channel);
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toVoidTask(googleApiClientAsGoogleApiClient.enqueue(new zzbm(zzbuVarZzc, googleApiClientAsGoogleApiClient, i)));
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> sendFile(ChannelClient.Channel channel, Uri uri, long j, long j2) {
        return PendingResultUtil.toVoidTask(zzc(channel).sendFile(asGoogleApiClient(), uri, j, j2));
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Boolean> unregisterChannelCallback(ChannelClient.ChannelCallback channelCallback) {
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(ListenerHolders.createListenerHolder(channelCallback, getLooper(), "ChannelListener").getListenerKey(), "Key must not be null"), 24004);
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> registerChannelCallback(ChannelClient.ChannelCallback channelCallback) {
        Preconditions.checkNotNull(channelCallback, "listener is null");
        ListenerHolder listenerHolderCreateListenerHolder = ListenerHolders.createListenerHolder(channelCallback, getLooper(), "ChannelListener");
        final IntentFilter[] intentFilterArr = {zzih.zza("com.google.android.gms.wearable.CHANNEL_EVENT")};
        final zzbg zzbgVar = new zzbg(channelCallback);
        final ListenerHolder listenerHolderCreateListenerHolder2 = ListenerHolders.createListenerHolder(zzbgVar, getLooper(), "ChannelListener");
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(listenerHolderCreateListenerHolder).register(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzbb
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzbg zzbgVar2 = zzbgVar;
                ListenerHolder listenerHolder = listenerHolderCreateListenerHolder2;
                IntentFilter[] intentFilterArr2 = intentFilterArr;
                zzjj zzjjVar = (zzjj) obj;
                int i = zzbh.zza;
                zzjjVar.zzq(new zzif((TaskCompletionSource) obj2), zzbgVar2, listenerHolder, null, intentFilterArr2);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzbc
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzbg zzbgVar2 = zzbgVar;
                int i = zzbh.zza;
                ((zzjj) obj).zzy(new zzie((TaskCompletionSource) obj2), zzbgVar2, null);
            }
        }).setMethodKey(24014).build());
    }
}
