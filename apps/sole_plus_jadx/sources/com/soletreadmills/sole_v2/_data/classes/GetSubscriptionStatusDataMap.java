package com.soletreadmills.sole_v2._data.classes;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetSubscriptionStatusApiData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/GetSubscriptionStatusDataMap;", "", "subscriptionStatus", "Lcom/soletreadmills/sole_v2/_data/classes/SubscriptionStatusType;", "deletedPaymentMethod", "", "(Lcom/soletreadmills/sole_v2/_data/classes/SubscriptionStatusType;Ljava/lang/Boolean;)V", "getDeletedPaymentMethod", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSubscriptionStatus", "()Lcom/soletreadmills/sole_v2/_data/classes/SubscriptionStatusType;", "component1", "component2", "copy", "(Lcom/soletreadmills/sole_v2/_data/classes/SubscriptionStatusType;Ljava/lang/Boolean;)Lcom/soletreadmills/sole_v2/_data/classes/GetSubscriptionStatusDataMap;", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GetSubscriptionStatusDataMap {
    public static final int $stable = 0;

    @SerializedName("deleted_payment_method")
    private final Boolean deletedPaymentMethod;

    @SerializedName("subscription_status")
    private final SubscriptionStatusType subscriptionStatus;

    public static /* synthetic */ GetSubscriptionStatusDataMap copy$default(GetSubscriptionStatusDataMap getSubscriptionStatusDataMap, SubscriptionStatusType subscriptionStatusType, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            subscriptionStatusType = getSubscriptionStatusDataMap.subscriptionStatus;
        }
        if ((i & 2) != 0) {
            bool = getSubscriptionStatusDataMap.deletedPaymentMethod;
        }
        return getSubscriptionStatusDataMap.copy(subscriptionStatusType, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final SubscriptionStatusType getSubscriptionStatus() {
        return this.subscriptionStatus;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getDeletedPaymentMethod() {
        return this.deletedPaymentMethod;
    }

    public final GetSubscriptionStatusDataMap copy(SubscriptionStatusType subscriptionStatus, Boolean deletedPaymentMethod) {
        Intrinsics.checkNotNullParameter(subscriptionStatus, "subscriptionStatus");
        return new GetSubscriptionStatusDataMap(subscriptionStatus, deletedPaymentMethod);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetSubscriptionStatusDataMap)) {
            return false;
        }
        GetSubscriptionStatusDataMap getSubscriptionStatusDataMap = (GetSubscriptionStatusDataMap) other;
        return this.subscriptionStatus == getSubscriptionStatusDataMap.subscriptionStatus && Intrinsics.areEqual(this.deletedPaymentMethod, getSubscriptionStatusDataMap.deletedPaymentMethod);
    }

    public int hashCode() {
        int iHashCode = this.subscriptionStatus.hashCode() * 31;
        Boolean bool = this.deletedPaymentMethod;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "GetSubscriptionStatusDataMap(subscriptionStatus=" + this.subscriptionStatus + ", deletedPaymentMethod=" + this.deletedPaymentMethod + ')';
    }

    public GetSubscriptionStatusDataMap(SubscriptionStatusType subscriptionStatus, Boolean bool) {
        Intrinsics.checkNotNullParameter(subscriptionStatus, "subscriptionStatus");
        this.subscriptionStatus = subscriptionStatus;
        this.deletedPaymentMethod = bool;
    }

    public /* synthetic */ GetSubscriptionStatusDataMap(SubscriptionStatusType subscriptionStatusType, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(subscriptionStatusType, (i & 2) != 0 ? null : bool);
    }

    public final SubscriptionStatusType getSubscriptionStatus() {
        return this.subscriptionStatus;
    }

    public final Boolean getDeletedPaymentMethod() {
        return this.deletedPaymentMethod;
    }
}
