package com.soletreadmills.sole_v2._data.api.settings;

import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import kotlin.Metadata;

/* compiled from: DeleteSubscriptionApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionApiData;", "", "()V", "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeleteSubscriptionApiData {
    public static final int $stable = 0;

    /* compiled from: DeleteSubscriptionApiData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtApiBaseData {
        public static final int $stable = 0;
    }

    /* compiled from: DeleteSubscriptionApiData.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionApiData$RequestBodyData;", "", "cancel_time_millis", "", "comment", "", "feedback_id", "", "user_subscription_id", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getCancel_time_millis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getComment", "()Ljava/lang/String;", "getFeedback_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUser_subscription_id", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 0;
        private final Long cancel_time_millis;
        private final String comment;
        private final Integer feedback_id;
        private final String user_subscription_id;

        public RequestBodyData(Long l, String str, Integer num, String str2) {
            this.cancel_time_millis = l;
            this.comment = str;
            this.feedback_id = num;
            this.user_subscription_id = str2;
        }

        public final Long getCancel_time_millis() {
            return this.cancel_time_millis;
        }

        public final String getComment() {
            return this.comment;
        }

        public final Integer getFeedback_id() {
            return this.feedback_id;
        }

        public final String getUser_subscription_id() {
            return this.user_subscription_id;
        }
    }
}
