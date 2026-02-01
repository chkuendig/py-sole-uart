package fm.feed.android.playersdk.models.webservice;

import com.google.gson.annotations.SerializedName;
import fm.feed.android.playersdk.ApiErrorEnum;
import fm.feed.android.playersdk.PlayerError;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: FeedFMError.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001*B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u0011\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0011\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010(\u001a\u00020\u0005H\u0016J\u0006\u0010)\u001a\u00020&R\"\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\"\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\r\u001a\u0004\u0018\u00010\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006+"}, d2 = {"Lfm/feed/android/playersdk/models/webservice/FeedFMError;", "Ljava/lang/Exception;", "code", "", "message", "", "status", "(ILjava/lang/String;I)V", "errorEnum", "Lfm/feed/android/playersdk/ApiErrorEnum;", "(Lfm/feed/android/playersdk/ApiErrorEnum;)V", "Lfm/feed/android/playersdk/PlayerError;", "(Lfm/feed/android/playersdk/PlayerError;)V", "<set-?>", "apiError", "getApiError", "()Lfm/feed/android/playersdk/ApiErrorEnum;", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "playerError", "getPlayerError", "()Lfm/feed/android/playersdk/PlayerError;", "getStatus", "setStatus", "Lfm/feed/android/playersdk/models/webservice/FeedFMError$Type;", "type", "getType", "()Lfm/feed/android/playersdk/models/webservice/FeedFMError$Type;", "isApiError", "", "isPlayerError", "setApiError", "", "setPlayerError", "toString", "updateErrorType", "Type", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public class FeedFMError extends Exception {
    private ApiErrorEnum apiError;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;
    private PlayerError playerError;

    @SerializedName("status")
    private int status;
    private Type type;

    /* compiled from: FeedFMError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lfm/feed/android/playersdk/models/webservice/FeedFMError$Type;", "", "(Ljava/lang/String;I)V", "Player", "Api", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Type {
        Player,
        Api
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final PlayerError getPlayerError() {
        return this.playerError;
    }

    public final ApiErrorEnum getApiError() {
        return this.apiError;
    }

    public final Type getType() {
        return this.type;
    }

    public FeedFMError(int i, String message, int i2) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = i;
        setMessage(message);
        this.status = i2;
        setPlayerError(i);
        if (this.playerError != null) {
            this.type = Type.Player;
        }
        setApiError(i);
        if (this.apiError != null) {
            this.type = Type.Api;
        }
    }

    public FeedFMError(ApiErrorEnum apiErrorEnum) {
        this.apiError = apiErrorEnum;
        Intrinsics.checkNotNull(apiErrorEnum);
        this.code = apiErrorEnum.getCode();
        ApiErrorEnum apiErrorEnum2 = this.apiError;
        Intrinsics.checkNotNull(apiErrorEnum2);
        setMessage(apiErrorEnum2.getMessage());
        ApiErrorEnum apiErrorEnum3 = this.apiError;
        Intrinsics.checkNotNull(apiErrorEnum3);
        this.status = apiErrorEnum3.getStatus();
        this.type = Type.Api;
    }

    public FeedFMError(PlayerError playerError) {
        this.playerError = playerError;
        Intrinsics.checkNotNull(playerError);
        this.code = playerError.getCode();
        PlayerError playerError2 = this.playerError;
        Intrinsics.checkNotNull(playerError2);
        setMessage(playerError2.getMessage());
        this.status = -1;
        this.type = Type.Player;
    }

    public final void updateErrorType() {
        setPlayerError(this.code);
        setApiError(this.code);
    }

    private final void setPlayerError(int code) {
        this.playerError = PlayerError.INSTANCE.fromCode(code);
    }

    private final void setApiError(int code) {
        this.apiError = ApiErrorEnum.INSTANCE.fromCode(code);
    }

    public final boolean isPlayerError() {
        if (this.playerError != null) {
            return true;
        }
        setPlayerError(this.code);
        return this.playerError != null;
    }

    public final boolean isApiError() {
        if (this.apiError != null) {
            return true;
        }
        setApiError(this.code);
        return this.apiError != null;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("{ type: \"%s Error\", code: %d, message: \"%s\", status: %s }", Arrays.copyOf(new Object[]{this.type, Integer.valueOf(this.code), getMessage(), Integer.valueOf(this.status)}, 4));
        Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        return str;
    }
}
