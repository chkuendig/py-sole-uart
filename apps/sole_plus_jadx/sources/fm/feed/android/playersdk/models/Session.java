package fm.feed.android.playersdk.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: Session.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u001e\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lfm/feed/android/playersdk/models/Session;", "", "()V", "clientId", "", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "isAvailable", "", "()Z", "logEverything", "getLogEverything", "setLogEverything", "(Z)V", "loggingEnabled", "getLoggingEnabled", "setLoggingEnabled", "message", "getMessage", "setMessage", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class Session {

    @SerializedName("client_id")
    private String clientId;

    @SerializedName("available")
    private final boolean isAvailable;

    @SerializedName("log_everything")
    private boolean logEverything;

    @SerializedName("log")
    private boolean loggingEnabled;

    @SerializedName("message")
    private String message;

    /* renamed from: isAvailable, reason: from getter */
    public final boolean getIsAvailable() {
        return this.isAvailable;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final void setClientId(String str) {
        this.clientId = str;
    }

    public final boolean getLoggingEnabled() {
        return this.loggingEnabled;
    }

    public final void setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
    }

    public final boolean getLogEverything() {
        return this.logEverything;
    }

    public final void setLogEverything(boolean z) {
        this.logEverything = z;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
