package fm.feed.android.playersdk.models.webservice;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: SimulcastConnectResponse.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lfm/feed/android/playersdk/models/webservice/SimulcastConnectResponse;", "Lfm/feed/android/playersdk/models/webservice/FeedFMResponse;", "()V", "clientId", "", "getClientId", "()Ljava/lang/String;", "metadataUrl", "getMetadataUrl", "streamUrl", "getStreamUrl", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SimulcastConnectResponse extends FeedFMResponse {

    @SerializedName("client_id")
    private final String clientId;

    @SerializedName("metadata_url")
    private final String metadataUrl;

    @SerializedName("stream_url")
    private final String streamUrl;

    public final String getClientId() {
        return this.clientId;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final String getMetadataUrl() {
        return this.metadataUrl;
    }
}
