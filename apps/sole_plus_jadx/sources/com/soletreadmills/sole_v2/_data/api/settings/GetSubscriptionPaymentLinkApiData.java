package com.soletreadmills.sole_v2._data.api.settings;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetSubscriptionPaymentLinkApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPaymentLinkApiData;", "", "()V", "GetSubscriptionPaymentData", "RequestBody", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetSubscriptionPaymentLinkApiData {
    public static final int $stable = 0;

    /* compiled from: GetSubscriptionPaymentLinkApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPaymentLinkApiData$RequestBody;", "", "priceId", "", "email", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getPriceId", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBody {
        public static final int $stable = 0;
        private final String email;

        @SerializedName("price_id")
        private final String priceId;

        public RequestBody(String priceId, String str) {
            Intrinsics.checkNotNullParameter(priceId, "priceId");
            this.priceId = priceId;
            this.email = str;
        }

        public final String getPriceId() {
            return this.priceId;
        }

        public final String getEmail() {
            return this.email;
        }
    }

    /* compiled from: GetSubscriptionPaymentLinkApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPaymentLinkApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData;", "()V", "sysResponseData", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPaymentLinkApiData$GetSubscriptionPaymentData;", "getSysResponseData", "()Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPaymentLinkApiData$GetSubscriptionPaymentData;", "setSysResponseData", "(Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPaymentLinkApiData$GetSubscriptionPaymentData;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtApiBaseData {
        public static final int $stable = 8;

        @SerializedName("sys_response_data")
        private GetSubscriptionPaymentData sysResponseData;

        public final GetSubscriptionPaymentData getSysResponseData() {
            return this.sysResponseData;
        }

        public final void setSysResponseData(GetSubscriptionPaymentData getSubscriptionPaymentData) {
            this.sysResponseData = getSubscriptionPaymentData;
        }
    }

    /* compiled from: GetSubscriptionPaymentLinkApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPaymentLinkApiData$GetSubscriptionPaymentData;", "", "paymentLinkUrl", "", "(Ljava/lang/String;)V", "getPaymentLinkUrl", "()Ljava/lang/String;", "setPaymentLinkUrl", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class GetSubscriptionPaymentData {
        public static final int $stable = 8;

        @SerializedName("payment_link_url")
        private String paymentLinkUrl;

        public static /* synthetic */ GetSubscriptionPaymentData copy$default(GetSubscriptionPaymentData getSubscriptionPaymentData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getSubscriptionPaymentData.paymentLinkUrl;
            }
            return getSubscriptionPaymentData.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPaymentLinkUrl() {
            return this.paymentLinkUrl;
        }

        public final GetSubscriptionPaymentData copy(String paymentLinkUrl) {
            Intrinsics.checkNotNullParameter(paymentLinkUrl, "paymentLinkUrl");
            return new GetSubscriptionPaymentData(paymentLinkUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GetSubscriptionPaymentData) && Intrinsics.areEqual(this.paymentLinkUrl, ((GetSubscriptionPaymentData) other).paymentLinkUrl);
        }

        public int hashCode() {
            return this.paymentLinkUrl.hashCode();
        }

        public String toString() {
            return "GetSubscriptionPaymentData(paymentLinkUrl=" + this.paymentLinkUrl + ')';
        }

        public GetSubscriptionPaymentData(String paymentLinkUrl) {
            Intrinsics.checkNotNullParameter(paymentLinkUrl, "paymentLinkUrl");
            this.paymentLinkUrl = paymentLinkUrl;
        }

        public final String getPaymentLinkUrl() {
            return this.paymentLinkUrl;
        }

        public final void setPaymentLinkUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.paymentLinkUrl = str;
        }
    }
}
