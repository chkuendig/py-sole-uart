package com.soletreadmills.sole_v2._data.api.settings;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import com.soletreadmills.sole_v2._data.classes.SubscriptionStatusType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetUserSubscriptionApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData;", "", "()V", "ChangePlan", "RequestBody", "ResponseData", "UserSubscriptionData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetUserSubscriptionApiData {
    public static final int $stable = 0;

    /* compiled from: GetUserSubscriptionApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$RequestBody;", "", "timeZone", "", "(Ljava/lang/String;)V", "getTimeZone", "()Ljava/lang/String;", "setTimeZone", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBody {
        public static final int $stable = 8;

        @SerializedName("time_zone")
        private String timeZone;

        public RequestBody(String timeZone) {
            Intrinsics.checkNotNullParameter(timeZone, "timeZone");
            this.timeZone = timeZone;
        }

        public final String getTimeZone() {
            return this.timeZone;
        }

        public final void setTimeZone(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.timeZone = str;
        }
    }

    /* compiled from: GetUserSubscriptionApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData;", "()V", "sysResponseData", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$UserSubscriptionData;", "getSysResponseData", "()Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$UserSubscriptionData;", "setSysResponseData", "(Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$UserSubscriptionData;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtApiBaseData {
        public static final int $stable = 8;

        @SerializedName("sys_response_data")
        private UserSubscriptionData sysResponseData;

        public final UserSubscriptionData getSysResponseData() {
            return this.sysResponseData;
        }

        public final void setSysResponseData(UserSubscriptionData userSubscriptionData) {
            this.sysResponseData = userSubscriptionData;
        }
    }

    /* compiled from: GetUserSubscriptionApiData.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÂ\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b#\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017¨\u0006A"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$UserSubscriptionData;", "", "billing_management_link", "", "card_brand_logo_url", "card_last4", "change_plan", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$ChangePlan;", "desc", "end_time_millis", "", "fee", "renewal_desc", "sn", "start_time_millis", "subscription_method", "subscription_status", "Lcom/soletreadmills/sole_v2/_data/classes/SubscriptionStatusType;", "title", "user_subscription_id", "valid_and_sufficient_desc", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$ChangePlan;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/classes/SubscriptionStatusType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBilling_management_link", "()Ljava/lang/String;", "getCard_brand_logo_url", "getCard_last4", "getChange_plan", "()Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$ChangePlan;", "getDesc", "getEnd_time_millis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFee", "getRenewal_desc", "getSn", "getStart_time_millis", "getSubscription_method", "getSubscription_status", "()Lcom/soletreadmills/sole_v2/_data/classes/SubscriptionStatusType;", "getTitle", "getUser_subscription_id", "getValid_and_sufficient_desc", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$ChangePlan;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/classes/SubscriptionStatusType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$UserSubscriptionData;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class UserSubscriptionData {
        public static final int $stable = 0;
        private final String billing_management_link;
        private final String card_brand_logo_url;
        private final String card_last4;
        private final ChangePlan change_plan;
        private final String desc;
        private final Long end_time_millis;
        private final String fee;
        private final String renewal_desc;
        private final String sn;
        private final Long start_time_millis;
        private final String subscription_method;
        private final SubscriptionStatusType subscription_status;
        private final String title;
        private final String user_subscription_id;
        private final String valid_and_sufficient_desc;

        /* renamed from: component1, reason: from getter */
        public final String getBilling_management_link() {
            return this.billing_management_link;
        }

        /* renamed from: component10, reason: from getter */
        public final Long getStart_time_millis() {
            return this.start_time_millis;
        }

        /* renamed from: component11, reason: from getter */
        public final String getSubscription_method() {
            return this.subscription_method;
        }

        /* renamed from: component12, reason: from getter */
        public final SubscriptionStatusType getSubscription_status() {
            return this.subscription_status;
        }

        /* renamed from: component13, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component14, reason: from getter */
        public final String getUser_subscription_id() {
            return this.user_subscription_id;
        }

        /* renamed from: component15, reason: from getter */
        public final String getValid_and_sufficient_desc() {
            return this.valid_and_sufficient_desc;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCard_brand_logo_url() {
            return this.card_brand_logo_url;
        }

        /* renamed from: component3, reason: from getter */
        public final String getCard_last4() {
            return this.card_last4;
        }

        /* renamed from: component4, reason: from getter */
        public final ChangePlan getChange_plan() {
            return this.change_plan;
        }

        /* renamed from: component5, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        /* renamed from: component6, reason: from getter */
        public final Long getEnd_time_millis() {
            return this.end_time_millis;
        }

        /* renamed from: component7, reason: from getter */
        public final String getFee() {
            return this.fee;
        }

        /* renamed from: component8, reason: from getter */
        public final String getRenewal_desc() {
            return this.renewal_desc;
        }

        /* renamed from: component9, reason: from getter */
        public final String getSn() {
            return this.sn;
        }

        public final UserSubscriptionData copy(String billing_management_link, String card_brand_logo_url, String card_last4, ChangePlan change_plan, String desc, Long end_time_millis, String fee, String renewal_desc, String sn, Long start_time_millis, String subscription_method, SubscriptionStatusType subscription_status, String title, String user_subscription_id, String valid_and_sufficient_desc) {
            return new UserSubscriptionData(billing_management_link, card_brand_logo_url, card_last4, change_plan, desc, end_time_millis, fee, renewal_desc, sn, start_time_millis, subscription_method, subscription_status, title, user_subscription_id, valid_and_sufficient_desc);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserSubscriptionData)) {
                return false;
            }
            UserSubscriptionData userSubscriptionData = (UserSubscriptionData) other;
            return Intrinsics.areEqual(this.billing_management_link, userSubscriptionData.billing_management_link) && Intrinsics.areEqual(this.card_brand_logo_url, userSubscriptionData.card_brand_logo_url) && Intrinsics.areEqual(this.card_last4, userSubscriptionData.card_last4) && Intrinsics.areEqual(this.change_plan, userSubscriptionData.change_plan) && Intrinsics.areEqual(this.desc, userSubscriptionData.desc) && Intrinsics.areEqual(this.end_time_millis, userSubscriptionData.end_time_millis) && Intrinsics.areEqual(this.fee, userSubscriptionData.fee) && Intrinsics.areEqual(this.renewal_desc, userSubscriptionData.renewal_desc) && Intrinsics.areEqual(this.sn, userSubscriptionData.sn) && Intrinsics.areEqual(this.start_time_millis, userSubscriptionData.start_time_millis) && Intrinsics.areEqual(this.subscription_method, userSubscriptionData.subscription_method) && this.subscription_status == userSubscriptionData.subscription_status && Intrinsics.areEqual(this.title, userSubscriptionData.title) && Intrinsics.areEqual(this.user_subscription_id, userSubscriptionData.user_subscription_id) && Intrinsics.areEqual(this.valid_and_sufficient_desc, userSubscriptionData.valid_and_sufficient_desc);
        }

        public int hashCode() {
            String str = this.billing_management_link;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.card_brand_logo_url;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.card_last4;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            ChangePlan changePlan = this.change_plan;
            int iHashCode4 = (iHashCode3 + (changePlan == null ? 0 : changePlan.hashCode())) * 31;
            String str4 = this.desc;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Long l = this.end_time_millis;
            int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
            String str5 = this.fee;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.renewal_desc;
            int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.sn;
            int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Long l2 = this.start_time_millis;
            int iHashCode10 = (iHashCode9 + (l2 == null ? 0 : l2.hashCode())) * 31;
            String str8 = this.subscription_method;
            int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
            SubscriptionStatusType subscriptionStatusType = this.subscription_status;
            int iHashCode12 = (iHashCode11 + (subscriptionStatusType == null ? 0 : subscriptionStatusType.hashCode())) * 31;
            String str9 = this.title;
            int iHashCode13 = (iHashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.user_subscription_id;
            int iHashCode14 = (iHashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.valid_and_sufficient_desc;
            return iHashCode14 + (str11 != null ? str11.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("UserSubscriptionData(billing_management_link=");
            sb.append(this.billing_management_link).append(", card_brand_logo_url=").append(this.card_brand_logo_url).append(", card_last4=").append(this.card_last4).append(", change_plan=").append(this.change_plan).append(", desc=").append(this.desc).append(", end_time_millis=").append(this.end_time_millis).append(", fee=").append(this.fee).append(", renewal_desc=").append(this.renewal_desc).append(", sn=").append(this.sn).append(", start_time_millis=").append(this.start_time_millis).append(", subscription_method=").append(this.subscription_method).append(", subscription_status=");
            sb.append(this.subscription_status).append(", title=").append(this.title).append(", user_subscription_id=").append(this.user_subscription_id).append(", valid_and_sufficient_desc=").append(this.valid_and_sufficient_desc).append(')');
            return sb.toString();
        }

        public UserSubscriptionData(String str, String str2, String str3, ChangePlan changePlan, String str4, Long l, String str5, String str6, String str7, Long l2, String str8, SubscriptionStatusType subscriptionStatusType, String str9, String str10, String str11) {
            this.billing_management_link = str;
            this.card_brand_logo_url = str2;
            this.card_last4 = str3;
            this.change_plan = changePlan;
            this.desc = str4;
            this.end_time_millis = l;
            this.fee = str5;
            this.renewal_desc = str6;
            this.sn = str7;
            this.start_time_millis = l2;
            this.subscription_method = str8;
            this.subscription_status = subscriptionStatusType;
            this.title = str9;
            this.user_subscription_id = str10;
            this.valid_and_sufficient_desc = str11;
        }

        public final String getBilling_management_link() {
            return this.billing_management_link;
        }

        public final String getCard_brand_logo_url() {
            return this.card_brand_logo_url;
        }

        public final String getCard_last4() {
            return this.card_last4;
        }

        public final ChangePlan getChange_plan() {
            return this.change_plan;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final Long getEnd_time_millis() {
            return this.end_time_millis;
        }

        public final String getFee() {
            return this.fee;
        }

        public final String getRenewal_desc() {
            return this.renewal_desc;
        }

        public final String getSn() {
            return this.sn;
        }

        public final Long getStart_time_millis() {
            return this.start_time_millis;
        }

        public final String getSubscription_method() {
            return this.subscription_method;
        }

        public final SubscriptionStatusType getSubscription_status() {
            return this.subscription_status;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUser_subscription_id() {
            return this.user_subscription_id;
        }

        public final String getValid_and_sufficient_desc() {
            return this.valid_and_sufficient_desc;
        }
    }

    /* compiled from: GetUserSubscriptionApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$ChangePlan;", "", "charge_desc", "", "desc", "fee", "price_id", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCharge_desc", "()Ljava/lang/String;", "getDesc", "getFee", "getPrice_id", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ChangePlan {
        public static final int $stable = 0;
        private final String charge_desc;
        private final String desc;
        private final String fee;
        private final String price_id;
        private final String title;

        public static /* synthetic */ ChangePlan copy$default(ChangePlan changePlan, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = changePlan.charge_desc;
            }
            if ((i & 2) != 0) {
                str2 = changePlan.desc;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = changePlan.fee;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = changePlan.price_id;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = changePlan.title;
            }
            return changePlan.copy(str, str6, str7, str8, str5);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCharge_desc() {
            return this.charge_desc;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        /* renamed from: component3, reason: from getter */
        public final String getFee() {
            return this.fee;
        }

        /* renamed from: component4, reason: from getter */
        public final String getPrice_id() {
            return this.price_id;
        }

        /* renamed from: component5, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final ChangePlan copy(String charge_desc, String desc, String fee, String price_id, String title) {
            return new ChangePlan(charge_desc, desc, fee, price_id, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChangePlan)) {
                return false;
            }
            ChangePlan changePlan = (ChangePlan) other;
            return Intrinsics.areEqual(this.charge_desc, changePlan.charge_desc) && Intrinsics.areEqual(this.desc, changePlan.desc) && Intrinsics.areEqual(this.fee, changePlan.fee) && Intrinsics.areEqual(this.price_id, changePlan.price_id) && Intrinsics.areEqual(this.title, changePlan.title);
        }

        public int hashCode() {
            String str = this.charge_desc;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.desc;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.fee;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.price_id;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.title;
            return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "ChangePlan(charge_desc=" + this.charge_desc + ", desc=" + this.desc + ", fee=" + this.fee + ", price_id=" + this.price_id + ", title=" + this.title + ')';
        }

        public ChangePlan(String str, String str2, String str3, String str4, String str5) {
            this.charge_desc = str;
            this.desc = str2;
            this.fee = str3;
            this.price_id = str4;
            this.title = str5;
        }

        public final String getCharge_desc() {
            return this.charge_desc;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getFee() {
            return this.fee;
        }

        public final String getPrice_id() {
            return this.price_id;
        }

        public final String getTitle() {
            return this.title;
        }
    }
}
