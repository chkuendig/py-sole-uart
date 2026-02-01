package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageClient;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzjj extends GmsClient {
    private final ExecutorService zze;
    private final zzfx zzf;
    private final zzfx zzg;
    private final zzfx zzh;
    private final zzfx zzi;
    private final zzfx zzj;
    private final zzfx zzk;
    private final zzfx zzl;
    private final zzfx zzm;
    private final zzfx zzn;
    private final zzfx zzo;
    private final zzfx zzp;
    private final zzfx zzq;
    private final zzjr zzr;
    private final com.google.android.gms.internal.wearable.zzah zzs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjj(final Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings) {
        super(context, looper, 14, clientSettings, connectionCallbacks, onConnectionFailedListener);
        com.google.android.gms.internal.wearable.zzh.zza();
        ExecutorService executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        zzjr zzjrVarZza = zzjr.zza(context);
        this.zzf = new zzfx();
        this.zzg = new zzfx();
        this.zzh = new zzfx();
        this.zzi = new zzfx();
        this.zzj = new zzfx();
        this.zzk = new zzfx();
        this.zzl = new zzfx();
        this.zzm = new zzfx();
        this.zzn = new zzfx();
        this.zzo = new zzfx();
        this.zzp = new zzfx();
        this.zzq = new zzfx();
        this.zze = (ExecutorService) Preconditions.checkNotNull(executorServiceUnconfigurableExecutorService);
        this.zzr = zzjrVarZza;
        this.zzs = com.google.android.gms.internal.wearable.zzak.zza(new com.google.android.gms.internal.wearable.zzah() { // from class: com.google.android.gms.wearable.internal.zzjf
            @Override // com.google.android.gms.internal.wearable.zzah
            public final Object zza() {
                File file = new File(new File(context.getFilesDir(), "wearos_assets"), "streamtmp");
                file.mkdirs();
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        file2.delete();
                    }
                }
                return file;
            }
        });
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        if (!requiresGooglePlayServices()) {
            try {
                Bundle bundle = getContext().getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
                int i = bundle != null ? bundle.getInt("com.google.android.wearable.api.version", 0) : 0;
                if (i < 8600000) {
                    Log.w("WearableClient", "The Wear OS app is out of date. Requires API version 8600000 but found " + i);
                    Context context = getContext();
                    Context context2 = getContext();
                    Intent intent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
                    if (context2.getPackageManager().resolveActivity(intent, 65536) == null) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
                    }
                    triggerNotAvailable(connectionProgressReportCallbacks, 6, PendingIntent.getActivity(context, 0, intent, com.google.android.gms.internal.wearable.zzd.zza));
                    return;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                triggerNotAvailable(connectionProgressReportCallbacks, 16, null);
                return;
            }
        }
        super.connect(connectionProgressReportCallbacks);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
        return iInterfaceQueryLocalInterface instanceof zzft ? (zzft) iInterfaceQueryLocalInterface : new zzft(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.wearable.zzj.zzx;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 8600000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.wearable.BIND";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServicePackage() {
        return this.zzr.zzb() ? "com.google.android.wearable.app.cn" : "com.google.android.gms";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.v("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.zzf.zzb(iBinder);
            this.zzg.zzb(iBinder);
            this.zzh.zzb(iBinder);
            this.zzj.zzb(iBinder);
            this.zzk.zzb(iBinder);
            this.zzl.zzb(iBinder);
            this.zzm.zzb(iBinder);
            this.zzn.zzb(iBinder);
            this.zzo.zzb(iBinder);
            this.zzi.zzb(iBinder);
            i = 0;
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return !this.zzr.zzb();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzA(BaseImplementation.ResultHolder resultHolder, MessageApi.MessageListener messageListener) throws RemoteException {
        this.zzk.zzc(this, resultHolder, messageListener);
    }

    public final void zzB(BaseImplementation.ResultHolder resultHolder, MessageClient.RpcService rpcService) throws RemoteException {
        this.zzl.zzc(this, resultHolder, rpcService);
    }

    public final void zzC(BaseImplementation.ResultHolder resultHolder, String str, Uri uri, long j, long j2) {
        try {
            ExecutorService executorService = this.zze;
            Preconditions.checkNotNull(resultHolder);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(uri);
            boolean z = true;
            Preconditions.checkArgument(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
            if (j2 < -1) {
                z = false;
            }
            Preconditions.checkArgument(z, "invalid length: %s", Long.valueOf(j2));
            executorService.execute(new zzji(this, uri, resultHolder, str, j, j2));
        } catch (RuntimeException e) {
            resultHolder.setFailedResult(new Status(8));
            throw e;
        }
    }

    public final void zzp(BaseImplementation.ResultHolder resultHolder, CapabilityApi.CapabilityListener capabilityListener, ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzo.zza(this, resultHolder, capabilityListener, zzjq.zzl(listenerHolder, intentFilterArr));
    }

    public final void zzq(BaseImplementation.ResultHolder resultHolder, ChannelApi.ChannelListener channelListener, ListenerHolder listenerHolder, @Nullable String str, IntentFilter[] intentFilterArr) throws RemoteException {
        if (str == null) {
            this.zzh.zza(this, resultHolder, channelListener, zzjq.zzn(listenerHolder, intentFilterArr));
        } else {
            this.zzh.zza(this, resultHolder, new zzia(str, channelListener), zzjq.zzo(listenerHolder, str, intentFilterArr));
        }
    }

    public final void zzr(BaseImplementation.ResultHolder resultHolder, DataApi.DataListener dataListener, ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzj.zza(this, resultHolder, dataListener, zzjq.zzp(listenerHolder, intentFilterArr));
    }

    public final void zzs(BaseImplementation.ResultHolder resultHolder, MessageApi.MessageListener messageListener, ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzk.zza(this, resultHolder, messageListener, zzjq.zzq(listenerHolder, intentFilterArr));
    }

    public final void zzt(BaseImplementation.ResultHolder resultHolder, MessageClient.RpcService rpcService, ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzl.zza(this, resultHolder, rpcService, zzjq.zzr(listenerHolder, intentFilterArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzu(BaseImplementation.ResultHolder resultHolder, Asset asset) throws RemoteException {
        ((zzft) getService()).zzr(new zziv(resultHolder), asset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzv(com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder r17, com.google.android.gms.wearable.PutDataRequest r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzjj.zzv(com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder, com.google.android.gms.wearable.PutDataRequest):void");
    }

    public final void zzw(BaseImplementation.ResultHolder resultHolder, String str, Uri uri, boolean z) {
        try {
            ExecutorService executorService = this.zze;
            Preconditions.checkNotNull(resultHolder);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(uri);
            executorService.execute(new zzjh(this, uri, resultHolder, z, str));
        } catch (RuntimeException e) {
            resultHolder.setFailedResult(new Status(8));
            throw e;
        }
    }

    public final void zzx(BaseImplementation.ResultHolder resultHolder, CapabilityApi.CapabilityListener capabilityListener) throws RemoteException {
        this.zzo.zzc(this, resultHolder, capabilityListener);
    }

    public final void zzy(BaseImplementation.ResultHolder resultHolder, ChannelApi.ChannelListener channelListener, String str) throws RemoteException {
        if (str == null) {
            this.zzh.zzc(this, resultHolder, channelListener);
        } else {
            this.zzh.zzc(this, resultHolder, new zzia(str, channelListener));
        }
    }

    public final void zzz(BaseImplementation.ResultHolder resultHolder, DataApi.DataListener dataListener) throws RemoteException {
        this.zzj.zzc(this, resultHolder, dataListener);
    }
}
