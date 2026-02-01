package fm.feed.android.playersdk.models.webservice;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: ClientResponse.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lfm/feed/android/playersdk/models/webservice/ClientResponse;", "Lfm/feed/android/playersdk/models/webservice/FeedFMResponse;", "()V", "clientId", "", "getClientId", "()Ljava/lang/String;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class ClientResponse extends FeedFMResponse {

    @SerializedName("client_id")
    private final String clientId;

    public final String getClientId() {
        return this.clientId;
    }
}
