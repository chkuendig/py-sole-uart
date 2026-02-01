package com.soletreadmills.sole_v2._data.api.settings;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateSubscriptionPaymentLinkApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateSubscriptionPaymentLinkApiData;", "", "()V", "RequestBody", "ResponseData", "UpdateSubscriptionPaymentData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UpdateSubscriptionPaymentLinkApiData {
    public static final int $stable = 0;

    /* compiled from: UpdateSubscriptionPaymentLinkApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateSubscriptionPaymentLinkApiData$RequestBody;", "", "user_subscription_id", "", "(Ljava/lang/String;)V", "getUser_subscription_id", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBody {
        public static final int $stable = 0;

        @SerializedName("price_id")
        private final String user_subscription_id;

        public RequestBody(String user_subscription_id) {
            Intrinsics.checkNotNullParameter(user_subscription_id, "user_subscription_id");
            this.user_subscription_id = user_subscription_id;
        }

        public final String getUser_subscription_id() {
            return this.user_subscription_id;
        }
    }

    /* compiled from: UpdateSubscriptionPaymentLinkApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateSubscriptionPaymentLinkApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData;", "()V", "sysResponseData", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateSubscriptionPaymentLinkApiData$UpdateSubscriptionPaymentData;", "getSysResponseData", "()Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateSubscriptionPaymentLinkApiData$UpdateSubscriptionPaymentData;", "setSysResponseData", "(Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateSubscriptionPaymentLinkApiData$UpdateSubscriptionPaymentData;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtApiBaseData {
        public static final int $stable = 8;

        @SerializedName("sys_response_data")
        private UpdateSubscriptionPaymentData sysResponseData;

        public final UpdateSubscriptionPaymentData getSysResponseData() {
            return this.sysResponseData;
        }

        public final void setSysResponseData(UpdateSubscriptionPaymentData updateSubscriptionPaymentData) {
            this.sysResponseData = updateSubscriptionPaymentData;
        }
    }

    /* compiled from: UpdateSubscriptionPaymentLinkApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateSubscriptionPaymentLinkApiData$UpdateSubscriptionPaymentData;", "", "updatePaymentLinkUrl", "", "(Ljava/lang/String;)V", "getUpdatePaymentLinkUrl", "()Ljava/lang/String;", "setUpdatePaymentLinkUrl", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class UpdateSubscriptionPaymentData {
        public static final int $stable = 8;

        @SerializedName("update_payment_link_url")
        private String updatePaymentLinkUrl;

        public static /* synthetic */ UpdateSubscriptionPaymentData copy$default(UpdateSubscriptionPaymentData updateSubscriptionPaymentData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateSubscriptionPaymentData.updatePaymentLinkUrl;
            }
            return updateSubscriptionPaymentData.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUpdatePaymentLinkUrl() {
            return this.updatePaymentLinkUrl;
        }

        public final UpdateSubscriptionPaymentData copy(String updatePaymentLinkUrl) {
            Intrinsics.checkNotNullParameter(updatePaymentLinkUrl, "updatePaymentLinkUrl");
            return new UpdateSubscriptionPaymentData(updatePaymentLinkUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UpdateSubscriptionPaymentData) && Intrinsics.areEqual(this.updatePaymentLinkUrl, ((UpdateSubscriptionPaymentData) other).updatePaymentLinkUrl);
        }

        public int hashCode() {
            return this.updatePaymentLinkUrl.hashCode();
        }

        public String toString() {
            return "UpdateSubscriptionPaymentData(updatePaymentLinkUrl=" + this.updatePaymentLinkUrl + ')';
        }

        public UpdateSubscriptionPaymentData(String updatePaymentLinkUrl) {
            Intrinsics.checkNotNullParameter(updatePaymentLinkUrl, "updatePaymentLinkUrl");
            this.updatePaymentLinkUrl = updatePaymentLinkUrl;
        }

        public final String getUpdatePaymentLinkUrl() {
            return this.updatePaymentLinkUrl;
        }

        public final void setUpdatePaymentLinkUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.updatePaymentLinkUrl = str;
        }
    }
}
