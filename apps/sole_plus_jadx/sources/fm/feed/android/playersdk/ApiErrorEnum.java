package fm.feed.android.playersdk;

import fm.feed.android.playersdk.models.webservice.FeedFMError;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: ApiErrorEnum.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\u0001\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001e"}, d2 = {"Lfm/feed/android/playersdk/ApiErrorEnum;", "", "code", "", "message", "", "status", "(Ljava/lang/String;IILjava/lang/String;I)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getStatus", "toString", "INVALID_CREDENTIALS", "FORBIDDEN", "SKIP_LIMIT_REACHED", "END_OF_PLAYLIST", "CANT_SKIP_NO_PLAY", "INVALID_PARAMETER", "MISSING_PARAMETER", "NO_SUCH_OBJECT", "UNHANDLED_INTERNAL_ERROR", "NOT_IN_US", "PLAYBACK_ALREADY_STARTED", "PLAYBACK_COMPLETE", "THROTTLED", "NOT_ON_DEMAND", "FORMAT_UNAVAILABLE", "Companion", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public enum ApiErrorEnum {
    INVALID_CREDENTIALS(5, "Invalid credentials. Credentials are missing or invalid.", 401),
    FORBIDDEN(6, "Forbidden. Access forbidden to the requested resource.", 401),
    SKIP_LIMIT_REACHED(7, "User has reached their skip limit and may not skip this song.", 200),
    END_OF_PLAYLIST(9, "End of available music. There is no more music that can be played from this station.", 200),
    CANT_SKIP_NO_PLAY(12, "This play is not currently being played so we can't determine skippability.", 200),
    INVALID_PARAMETER(15, "Invalid parameter value. See error message for details.", 400),
    MISSING_PARAMETER(16, "400\tMissing required parameter. See error message for details.", 400),
    NO_SUCH_OBJECT(17, "No such object. The requested resource couldn't be found.", 404),
    UNHANDLED_INTERNAL_ERROR(18, "Unhandled internal error.", 500),
    NOT_IN_US(19, "The client's IP address does not map to one in the United States, and so cannot play music.", 403),
    PLAYBACK_ALREADY_STARTED(20, "Playback of this song has already started.", 403),
    PLAYBACK_COMPLETE(21, "This play has already completed playback", 403),
    THROTTLED(22, "You have exceeded normal request limits and are being throttled", 429),
    NOT_ON_DEMAND(23, "This station is not on-demand", 403),
    FORMAT_UNAVAILABLE(24, "Unable to find a version of this file that meets format and bitrate constriants", 200);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int code;
    private final String message;
    private final int status;

    @JvmStatic
    public static final ApiErrorEnum fromCode(int i) {
        return INSTANCE.fromCode(i);
    }

    ApiErrorEnum(int i, String str, int i2) {
        this.code = i;
        this.message = str;
        this.status = i2;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getStatus() {
        return this.status;
    }

    @Override // java.lang.Enum
    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("{type: \"Api Error\", code: %d, message: \"%s\", status: %s}", Arrays.copyOf(new Object[]{Integer.valueOf(this.code), this.message, Integer.valueOf(this.status)}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        return str;
    }

    /* compiled from: ApiErrorEnum.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lfm/feed/android/playersdk/ApiErrorEnum$Companion;", "", "()V", "fromCode", "Lfm/feed/android/playersdk/ApiErrorEnum;", "code", "", "fromError", "error", "Lfm/feed/android/playersdk/models/webservice/FeedFMError;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ApiErrorEnum fromCode(int code) {
            ApiErrorEnum[] apiErrorEnumArrValues = ApiErrorEnum.values();
            int length = apiErrorEnumArrValues.length;
            int i = 0;
            while (i < length) {
                ApiErrorEnum apiErrorEnum = apiErrorEnumArrValues[i];
                i++;
                if (apiErrorEnum.getCode() == code) {
                    return apiErrorEnum;
                }
            }
            return null;
        }

        public final ApiErrorEnum fromError(FeedFMError error) {
            if (error == null) {
                return null;
            }
            ApiErrorEnum[] apiErrorEnumArrValues = ApiErrorEnum.values();
            int length = apiErrorEnumArrValues.length;
            int i = 0;
            while (i < length) {
                ApiErrorEnum apiErrorEnum = apiErrorEnumArrValues[i];
                i++;
                if (apiErrorEnum.getCode() == error.getCode()) {
                    return apiErrorEnum;
                }
            }
            return null;
        }
    }
}
