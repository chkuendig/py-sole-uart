package com.soletreadmills.sole_v2._data.api.settings;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetSubscriptionPlansApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPlansApiData;", "", "()V", "ResponseData", "SubscriptionPlansData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetSubscriptionPlansApiData {
    public static final int $stable = 0;

    /* compiled from: GetSubscriptionPlansApiData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPlansApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData;", "()V", "sysResponseData", "", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPlansApiData$SubscriptionPlansData;", "getSysResponseData", "()Ljava/util/List;", "setSysResponseData", "(Ljava/util/List;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtApiBaseData {
        public static final int $stable = 8;

        @SerializedName("sys_response_data")
        private List<SubscriptionPlansData> sysResponseData;

        public final List<SubscriptionPlansData> getSysResponseData() {
            return this.sysResponseData;
        }

        public final void setSysResponseData(List<SubscriptionPlansData> list) {
            this.sysResponseData = list;
        }
    }

    /* compiled from: GetSubscriptionPlansApiData.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0002\u0010\u000fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J~\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0006HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011¨\u00060"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPlansApiData$SubscriptionPlansData;", "", "desc", "", "fee", "free_trial_days", "", "has_free_trial", "", "plan_id", "price_id", "subscription_methods", "", "title", "isSelect", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)V", "getDesc", "()Ljava/lang/String;", "getFee", "getFree_trial_days", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHas_free_trial", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()Z", "setSelect", "(Z)V", "getPlan_id", "getPrice_id", "getSubscription_methods", "()Ljava/util/List;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPlansApiData$SubscriptionPlansData;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SubscriptionPlansData {
        public static final int $stable = 8;
        private final String desc;
        private final String fee;
        private final Integer free_trial_days;
        private final Boolean has_free_trial;
        private boolean isSelect;
        private final String plan_id;
        private final String price_id;
        private final List<String> subscription_methods;
        private final String title;

        /* renamed from: component1, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFee() {
            return this.fee;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getFree_trial_days() {
            return this.free_trial_days;
        }

        /* renamed from: component4, reason: from getter */
        public final Boolean getHas_free_trial() {
            return this.has_free_trial;
        }

        /* renamed from: component5, reason: from getter */
        public final String getPlan_id() {
            return this.plan_id;
        }

        /* renamed from: component6, reason: from getter */
        public final String getPrice_id() {
            return this.price_id;
        }

        public final List<String> component7() {
            return this.subscription_methods;
        }

        /* renamed from: component8, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsSelect() {
            return this.isSelect;
        }

        public final SubscriptionPlansData copy(String desc, String fee, Integer free_trial_days, Boolean has_free_trial, String plan_id, String price_id, List<String> subscription_methods, String title, boolean isSelect) {
            return new SubscriptionPlansData(desc, fee, free_trial_days, has_free_trial, plan_id, price_id, subscription_methods, title, isSelect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubscriptionPlansData)) {
                return false;
            }
            SubscriptionPlansData subscriptionPlansData = (SubscriptionPlansData) other;
            return Intrinsics.areEqual(this.desc, subscriptionPlansData.desc) && Intrinsics.areEqual(this.fee, subscriptionPlansData.fee) && Intrinsics.areEqual(this.free_trial_days, subscriptionPlansData.free_trial_days) && Intrinsics.areEqual(this.has_free_trial, subscriptionPlansData.has_free_trial) && Intrinsics.areEqual(this.plan_id, subscriptionPlansData.plan_id) && Intrinsics.areEqual(this.price_id, subscriptionPlansData.price_id) && Intrinsics.areEqual(this.subscription_methods, subscriptionPlansData.subscription_methods) && Intrinsics.areEqual(this.title, subscriptionPlansData.title) && this.isSelect == subscriptionPlansData.isSelect;
        }

        public int hashCode() {
            String str = this.desc;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.fee;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.free_trial_days;
            int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Boolean bool = this.has_free_trial;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str3 = this.plan_id;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.price_id;
            int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            List<String> list = this.subscription_methods;
            int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
            String str5 = this.title;
            return ((iHashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSelect);
        }

        public String toString() {
            return "SubscriptionPlansData(desc=" + this.desc + ", fee=" + this.fee + ", free_trial_days=" + this.free_trial_days + ", has_free_trial=" + this.has_free_trial + ", plan_id=" + this.plan_id + ", price_id=" + this.price_id + ", subscription_methods=" + this.subscription_methods + ", title=" + this.title + ", isSelect=" + this.isSelect + ')';
        }

        public SubscriptionPlansData(String str, String str2, Integer num, Boolean bool, String str3, String str4, List<String> list, String str5, boolean z) {
            this.desc = str;
            this.fee = str2;
            this.free_trial_days = num;
            this.has_free_trial = bool;
            this.plan_id = str3;
            this.price_id = str4;
            this.subscription_methods = list;
            this.title = str5;
            this.isSelect = z;
        }

        public /* synthetic */ SubscriptionPlansData(String str, String str2, Integer num, Boolean bool, String str3, String str4, List list, String str5, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, num, bool, str3, str4, list, str5, (i & 256) != 0 ? false : z);
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getFee() {
            return this.fee;
        }

        public final Integer getFree_trial_days() {
            return this.free_trial_days;
        }

        public final Boolean getHas_free_trial() {
            return this.has_free_trial;
        }

        public final String getPlan_id() {
            return this.plan_id;
        }

        public final String getPrice_id() {
            return this.price_id;
        }

        public final List<String> getSubscription_methods() {
            return this.subscription_methods;
        }

        public final String getTitle() {
            return this.title;
        }

        public final boolean isSelect() {
            return this.isSelect;
        }

        public final void setSelect(boolean z) {
            this.isSelect = z;
        }
    }
}
