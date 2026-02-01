package com.soletreadmills.sole_v2._data.api.settings;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.JwtNotificationApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PatchMessageStatusApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/PatchMessageStatusApiData;", "", "()V", "RequestBody", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PatchMessageStatusApiData {
    public static final int $stable = 0;

    /* compiled from: PatchMessageStatusApiData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/PatchMessageStatusApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtNotificationApiBaseData;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtNotificationApiBaseData {
        public static final int $stable = 0;
    }

    /* compiled from: PatchMessageStatusApiData.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/PatchMessageStatusApiData$RequestBody;", "", "messageId", "", "(Ljava/lang/String;)V", "is_read", "", "()Z", "getMessageId", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBody {
        public static final int $stable = 0;

        @SerializedName("is_read")
        private final boolean is_read;

        @SerializedName(Constants.MessagePayloadKeys.MSGID_SERVER)
        private final String messageId;

        public RequestBody(String messageId) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            this.messageId = messageId;
            this.is_read = true;
        }

        public final String getMessageId() {
            return this.messageId;
        }

        /* renamed from: is_read, reason: from getter */
        public final boolean getIs_read() {
            return this.is_read;
        }
    }
}
