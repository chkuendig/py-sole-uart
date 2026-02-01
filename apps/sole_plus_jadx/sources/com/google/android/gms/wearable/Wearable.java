package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import androidx.core.util.Preconditions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.wearable.internal.zzal;
import com.google.android.gms.wearable.internal.zzar;
import com.google.android.gms.wearable.internal.zzay;
import com.google.android.gms.wearable.internal.zzbh;
import com.google.android.gms.wearable.internal.zzci;
import com.google.android.gms.wearable.internal.zzcz;
import com.google.android.gms.wearable.internal.zzdh;
import com.google.android.gms.wearable.internal.zzgd;
import com.google.android.gms.wearable.internal.zzgo;
import com.google.android.gms.wearable.internal.zzgv;
import com.google.android.gms.wearable.internal.zzhd;
import com.google.android.gms.wearable.internal.zzig;
import com.google.android.gms.wearable.internal.zzjt;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public class Wearable {

    @Deprecated
    public static final Api<WearableOptions> API;
    private static final Api.ClientKey zzf;
    private static final Api.AbstractClientBuilder zzg;

    @Deprecated
    public static final DataApi DataApi = new zzcz();

    @Deprecated
    public static final CapabilityApi CapabilityApi = new zzal();

    @Deprecated
    public static final MessageApi MessageApi = new zzgd();

    @Deprecated
    public static final NodeApi NodeApi = new zzgv();

    @Deprecated
    public static final ChannelApi ChannelApi = new zzay();

    @Deprecated
    public static final com.google.android.gms.wearable.internal.zzm zza = new com.google.android.gms.wearable.internal.zzm();

    @Deprecated
    public static final com.google.android.gms.wearable.internal.zzj zzb = new com.google.android.gms.wearable.internal.zzj();

    @Deprecated
    public static final zzci zzc = new zzci();

    @Deprecated
    public static final zzig zzd = new zzig();

    @Deprecated
    public static final zzjt zze = new zzjt();

    /* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
    public static final class WearableOptions implements Api.ApiOptions.Optional {
        public static final WearableOptions zza = new WearableOptions(new Builder());
        private final Looper zzb;

        /* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
        public static class Builder {
            private Looper zza;

            public WearableOptions build() {
                return new WearableOptions(this);
            }

            public Builder setLooper(Looper looper) {
                this.zza = looper;
                return this;
            }
        }

        private WearableOptions(Builder builder) {
            this.zzb = builder.zza;
        }

        static /* bridge */ /* synthetic */ GoogleApi.Settings zza(WearableOptions wearableOptions) {
            return wearableOptions.zzb != null ? new GoogleApi.Settings.Builder().setLooper(wearableOptions.zzb).build() : GoogleApi.Settings.DEFAULT_SETTINGS;
        }

        public boolean equals(Object obj) {
            return obj instanceof WearableOptions;
        }

        public int hashCode() {
            return Objects.hashCode(getClass());
        }
    }

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zzf = clientKey;
        zzm zzmVar = new zzm();
        zzg = zzmVar;
        API = new Api<>("Wearable.API", zzmVar, clientKey);
    }

    private Wearable() {
    }

    public static CapabilityClient getCapabilityClient(Activity activity) {
        return new zzar(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static ChannelClient getChannelClient(Activity activity) {
        return new zzbh(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static DataClient getDataClient(Activity activity) {
        return new zzdh(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static MessageClient getMessageClient(Activity activity) {
        return new zzgo(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static NodeClient getNodeClient(Activity activity) {
        return new zzhd(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static CapabilityClient getCapabilityClient(Activity activity, WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzar(activity, WearableOptions.zza(wearableOptions));
    }

    public static ChannelClient getChannelClient(Activity activity, WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzbh(activity, WearableOptions.zza(wearableOptions));
    }

    public static DataClient getDataClient(Activity activity, WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzdh(activity, WearableOptions.zza(wearableOptions));
    }

    public static MessageClient getMessageClient(Activity activity, WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzgo(activity, WearableOptions.zza(wearableOptions));
    }

    public static NodeClient getNodeClient(Activity activity, WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzhd(activity, WearableOptions.zza(wearableOptions));
    }

    public static CapabilityClient getCapabilityClient(Context context) {
        return new zzar(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static ChannelClient getChannelClient(Context context) {
        return new zzbh(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static DataClient getDataClient(Context context) {
        return new zzdh(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static MessageClient getMessageClient(Context context) {
        return new zzgo(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static NodeClient getNodeClient(Context context) {
        return new zzhd(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static CapabilityClient getCapabilityClient(Context context, WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzar(context, WearableOptions.zza(wearableOptions));
    }

    public static ChannelClient getChannelClient(Context context, WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzbh(context, WearableOptions.zza(wearableOptions));
    }

    public static DataClient getDataClient(Context context, WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzdh(context, WearableOptions.zza(wearableOptions));
    }

    public static MessageClient getMessageClient(Context context, WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzgo(context, WearableOptions.zza(wearableOptions));
    }

    public static NodeClient getNodeClient(Context context, WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzhd(context, WearableOptions.zza(wearableOptions));
    }
}
