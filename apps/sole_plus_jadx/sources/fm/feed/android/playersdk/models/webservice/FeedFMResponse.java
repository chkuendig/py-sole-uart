package fm.feed.android.playersdk.models.webservice;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: FeedFMResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\t¨\u0006\f"}, d2 = {"Lfm/feed/android/playersdk/models/webservice/FeedFMResponse;", "", "()V", "error", "Lfm/feed/android/playersdk/models/webservice/FeedFMError;", "getError", "()Lfm/feed/android/playersdk/models/webservice/FeedFMError;", "isSuccess", "", "()Z", "toString", "", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public class FeedFMResponse {

    @SerializedName("error")
    private final FeedFMError error;

    @SerializedName("success")
    private final boolean isSuccess;

    /* renamed from: isSuccess, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public final FeedFMError getError() {
        return this.error;
    }

    public String toString() {
        return "{ success: " + this.isSuccess + ", error: " + this.error + " }";
    }
}
