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
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityClient;
import com.google.android.gms.wearable.CapabilityInfo;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzar extends CapabilityClient {
    public static final /* synthetic */ int zza = 0;
    private final CapabilityApi zzb;

    public zzar(Activity activity, GoogleApi.Settings settings) {
        super(activity, settings);
        this.zzb = new zzal();
    }

    private final Task zza(final ListenerHolder listenerHolder, final CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, final IntentFilter[] intentFilterArr) {
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(listenerHolder).register(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzao
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener2 = onCapabilityChangedListener;
                ListenerHolder listenerHolder2 = listenerHolder;
                IntentFilter[] intentFilterArr2 = intentFilterArr;
                int i = zzar.zza;
                ((zzjj) obj).zzp(new zzif((TaskCompletionSource) obj2), onCapabilityChangedListener2, listenerHolder2, intentFilterArr2);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzap
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener2 = onCapabilityChangedListener;
                int i = zzar.zza;
                ((zzjj) obj).zzx(new zzie((TaskCompletionSource) obj2), onCapabilityChangedListener2);
            }
        }).setMethodKey(24013).build());
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Void> addListener(CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, Uri uri, int i) {
        boolean z;
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Asserts.checkNotNull(uri, "uri must not be null");
        if (i == 0) {
            z = true;
        } else if (i == 1) {
            i = 1;
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "invalid filter type");
        return zza(ListenerHolders.createListenerHolder(onCapabilityChangedListener, getLooper(), "CapabilityListener"), onCapabilityChangedListener, new IntentFilter[]{zzih.zzb("com.google.android.gms.wearable.CAPABILITY_CHANGED", uri, i)});
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Void> addLocalCapability(String str) {
        Asserts.checkNotNull(str, "capability must not be null");
        CapabilityApi capabilityApi = this.zzb;
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toVoidTask(googleApiClientAsGoogleApiClient.enqueue(new zzab((zzal) capabilityApi, googleApiClientAsGoogleApiClient, str)));
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Map<String, CapabilityInfo>> getAllCapabilities(int i) {
        CapabilityApi capabilityApi = this.zzb;
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        boolean z = true;
        if (i != 0) {
            if (i == 1) {
                i = 1;
            } else {
                z = false;
            }
        }
        Preconditions.checkArgument(z);
        return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzaa((zzal) capabilityApi, googleApiClientAsGoogleApiClient, i)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzan
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((CapabilityApi.GetAllCapabilitiesResult) result).getAllCapabilities();
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<CapabilityInfo> getCapability(String str, int i) {
        Asserts.checkNotNull(str, "capability must not be null");
        CapabilityApi capabilityApi = this.zzb;
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        boolean z = true;
        if (i != 0) {
            if (i == 1) {
                i = 1;
            } else {
                z = false;
            }
        }
        Preconditions.checkArgument(z);
        return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzz((zzal) capabilityApi, googleApiClientAsGoogleApiClient, str, i)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzam
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((CapabilityApi.GetCapabilityResult) result).getCapability();
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Boolean> removeListener(CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener) {
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(ListenerHolders.createListenerHolder(onCapabilityChangedListener, getLooper(), "CapabilityListener").getListenerKey(), "Key must not be null"), 24003);
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Void> removeLocalCapability(String str) {
        Asserts.checkNotNull(str, "capability must not be null");
        CapabilityApi capabilityApi = this.zzb;
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toVoidTask(googleApiClientAsGoogleApiClient.enqueue(new zzac((zzal) capabilityApi, googleApiClientAsGoogleApiClient, str)));
    }

    public zzar(Context context, GoogleApi.Settings settings) {
        super(context, settings);
        this.zzb = new zzal();
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Boolean> removeListener(CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, String str) {
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Asserts.checkNotNull(str, "capability must not be null");
        if (!str.startsWith("/")) {
            str = "/".concat(String.valueOf(str));
        }
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(ListenerHolders.createListenerHolder(onCapabilityChangedListener, getLooper(), "CapabilityListener:".concat(String.valueOf(str))).getListenerKey(), "Key must not be null"), 24003);
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Void> addListener(CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, String str) {
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Asserts.checkNotNull(str, "capability must not be null");
        IntentFilter intentFilterZza = zzih.zza("com.google.android.gms.wearable.CAPABILITY_CHANGED");
        if (!str.startsWith("/")) {
            str = "/".concat(String.valueOf(str));
        }
        intentFilterZza.addDataPath(str, 0);
        return zza(ListenerHolders.createListenerHolder(onCapabilityChangedListener, getLooper(), "CapabilityListener:".concat(String.valueOf(str))), new zzaq(onCapabilityChangedListener, str), new IntentFilter[]{intentFilterZza});
    }
}
