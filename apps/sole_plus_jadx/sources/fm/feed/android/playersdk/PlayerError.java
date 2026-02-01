package fm.feed.android.playersdk;

import androidx.health.connect.client.records.metadata.DeviceTypes;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import fm.feed.android.playersdk.models.webservice.FeedFMError;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: PlayerError.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lfm/feed/android/playersdk/PlayerError;", "", "code", "", "message", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "toString", "NO_NETWORK", DeviceTypes.UNKNOWN, "INVALID_CREDENTIALS", "INVALID_SERVER_RESPONSE", "TUNE_UNKNOWN", "TUNE_IO_EXCEPTION", "TUNE_MEDIA_PLAYER_ILLEGAL_STATE", "RETROFIT_UNKNOWN", "RETROFIT_NULL_REQ_SUCCESS", "RETROFIT_NULL_REQ_FAIL", "RUNTIME_ERROR", "Companion", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public enum PlayerError {
    NO_NETWORK(1000, "No Internet Connection"),
    UNKNOWN(1001, "Unkown Error"),
    INVALID_CREDENTIALS(1002, "Credentials are not valid"),
    INVALID_SERVER_RESPONSE(1003, "Invalid server response"),
    TUNE_UNKNOWN(1010, "Error preparing audio stream"),
    TUNE_IO_EXCEPTION(1011, "Error Tuning MediaPlayer (IOException)"),
    TUNE_MEDIA_PLAYER_ILLEGAL_STATE(1020, "Error Tuning MediaPlayer (IllegalStateException)"),
    RETROFIT_UNKNOWN(1030, "Unknown Retrofit Error"),
    RETROFIT_NULL_REQ_SUCCESS(AnalyticsListener.EVENT_AUDIO_TRACK_INITIALIZED, "Retrofit error response is null - Request Response was positive"),
    RETROFIT_NULL_REQ_FAIL(AnalyticsListener.EVENT_AUDIO_TRACK_RELEASED, "Retrofit error response is null - Request Response was negative"),
    RUNTIME_ERROR(1033, "RuntimeException");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int code;
    private final String message;

    PlayerError(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    @Override // java.lang.Enum
    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("{type: \"Generic Error\", code: %d, message: \"%s\"}", Arrays.copyOf(new Object[]{Integer.valueOf(this.code), this.message}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        return str;
    }

    /* compiled from: PlayerError.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lfm/feed/android/playersdk/PlayerError$Companion;", "", "()V", "fromCode", "Lfm/feed/android/playersdk/PlayerError;", "code", "", "fromError", "error", "Lfm/feed/android/playersdk/models/webservice/FeedFMError;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlayerError fromCode(int code) {
            PlayerError[] playerErrorArrValues = PlayerError.values();
            int length = playerErrorArrValues.length;
            int i = 0;
            while (i < length) {
                PlayerError playerError = playerErrorArrValues[i];
                i++;
                if (playerError.getCode() == code) {
                    return playerError;
                }
            }
            return null;
        }

        public final PlayerError fromError(FeedFMError error) {
            if (error == null) {
                return null;
            }
            PlayerError[] playerErrorArrValues = PlayerError.values();
            int length = playerErrorArrValues.length;
            int i = 0;
            while (i < length) {
                PlayerError playerError = playerErrorArrValues[i];
                i++;
                if (playerError.getCode() == error.getCode()) {
                    return playerError;
                }
            }
            return null;
        }
    }
}
