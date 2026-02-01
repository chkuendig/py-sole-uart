package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.SdkConstants;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzbu extends AbstractSafeParcelable implements Channel, ChannelClient.Channel {
    public static final Parcelable.Creator<zzbu> CREATOR = new zzbv();
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzbu(String str, String str2, String str3) {
        this.zza = (String) Preconditions.checkNotNull(str);
        this.zzb = (String) Preconditions.checkNotNull(str2);
        this.zzc = (String) Preconditions.checkNotNull(str3);
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        return zze.zza(googleApiClient, new zzbr(this.zza, new IntentFilter[]{zzih.zza("com.google.android.gms.wearable.CHANNEL_EVENT")}), channelListener);
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> close(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzbl(this, googleApiClient));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbu)) {
            return false;
        }
        zzbu zzbuVar = (zzbu) obj;
        return this.zza.equals(zzbuVar.zza) && Objects.equal(zzbuVar.zzb, this.zzb) && Objects.equal(zzbuVar.zzc, this.zzc);
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Channel.GetInputStreamResult> getInputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzbn(this, googleApiClient));
    }

    @Override // com.google.android.gms.wearable.Channel, com.google.android.gms.wearable.ChannelClient.Channel
    public final String getNodeId() {
        return this.zzb;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Channel.GetOutputStreamResult> getOutputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzbo(this, googleApiClient));
    }

    @Override // com.google.android.gms.wearable.Channel, com.google.android.gms.wearable.ChannelClient.Channel
    public final String getPath() {
        return this.zzc;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> receiveFile(GoogleApiClient googleApiClient, Uri uri, boolean z) {
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(uri, "uri is null");
        return googleApiClient.enqueue(new zzbp(this, googleApiClient, uri, z));
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(channelListener, "listener is null");
        return googleApiClient.enqueue(new zzax(googleApiClient, channelListener, this.zza));
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> sendFile(GoogleApiClient googleApiClient, Uri uri) {
        return sendFile(googleApiClient, uri, 0L, -1L);
    }

    public final String toString() {
        int i = 0;
        for (char c : this.zza.toCharArray()) {
            i += c;
        }
        String strTrim = this.zza.trim();
        int length = strTrim.length();
        if (length > 25) {
            strTrim = strTrim.substring(0, 10) + "..." + strTrim.substring(length - 10, length) + "::" + i;
        }
        return "Channel{token=" + strTrim + ", nodeId=" + this.zzb + ", path=" + this.zzc + SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> close(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.enqueue(new zzbm(this, googleApiClient, i));
    }

    @Override // com.google.android.gms.wearable.Channel
    public final PendingResult<Status> sendFile(GoogleApiClient googleApiClient, Uri uri, long j, long j2) {
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(this.zza, "token is null");
        Preconditions.checkNotNull(uri, "uri is null");
        Preconditions.checkArgument(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        Preconditions.checkArgument(j2 >= 0 || j2 == -1, "invalid length: %s", Long.valueOf(j2));
        return googleApiClient.enqueue(new zzbq(this, googleApiClient, uri, j, j2));
    }
}
