package com.soletreadmills.sole_v2._data.classes;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.samsung.android.sdk.healthdata.HealthConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GetSubscriptionStatusApiData.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/SubscriptionStatusType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NoSubscription", "CancelSubscription", "Subscriptioning", "SubscriptionPass", "SubscriptionTest", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionStatusType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SubscriptionStatusType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int value;

    @SerializedName(HealthConstants.FoodIntake.UNIT_TYPE_NOT_DEFINED)
    public static final SubscriptionStatusType NoSubscription = new SubscriptionStatusType("NoSubscription", 0, -1);

    @SerializedName("0")
    public static final SubscriptionStatusType CancelSubscription = new SubscriptionStatusType("CancelSubscription", 1, 0);

    @SerializedName("1")
    public static final SubscriptionStatusType Subscriptioning = new SubscriptionStatusType("Subscriptioning", 2, 1);

    @SerializedName("2")
    public static final SubscriptionStatusType SubscriptionPass = new SubscriptionStatusType("SubscriptionPass", 3, 2);

    @SerializedName(ExifInterface.GPS_MEASUREMENT_3D)
    public static final SubscriptionStatusType SubscriptionTest = new SubscriptionStatusType("SubscriptionTest", 4, 3);

    private static final /* synthetic */ SubscriptionStatusType[] $values() {
        return new SubscriptionStatusType[]{NoSubscription, CancelSubscription, Subscriptioning, SubscriptionPass, SubscriptionTest};
    }

    public static EnumEntries<SubscriptionStatusType> getEntries() {
        return $ENTRIES;
    }

    public static SubscriptionStatusType valueOf(String str) {
        return (SubscriptionStatusType) Enum.valueOf(SubscriptionStatusType.class, str);
    }

    public static SubscriptionStatusType[] values() {
        return (SubscriptionStatusType[]) $VALUES.clone();
    }

    private SubscriptionStatusType(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        SubscriptionStatusType[] subscriptionStatusTypeArr$values = $values();
        $VALUES = subscriptionStatusTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(subscriptionStatusTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: GetSubscriptionStatusApiData.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\n\u0010\u0007\u001a\u00020\b*\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/SubscriptionStatusType$Companion;", "", "()V", "fromValue", "Lcom/soletreadmills/sole_v2/_data/classes/SubscriptionStatusType;", "value", "", "isSubscribedOrTrial", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SubscriptionStatusType fromValue(int value) {
            SubscriptionStatusType subscriptionStatusType;
            SubscriptionStatusType[] subscriptionStatusTypeArrValues = SubscriptionStatusType.values();
            int length = subscriptionStatusTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    subscriptionStatusType = null;
                    break;
                }
                subscriptionStatusType = subscriptionStatusTypeArrValues[i];
                if (subscriptionStatusType.getValue() == value) {
                    break;
                }
                i++;
            }
            return subscriptionStatusType == null ? SubscriptionStatusType.NoSubscription : subscriptionStatusType;
        }

        public final boolean isSubscribedOrTrial(SubscriptionStatusType subscriptionStatusType) {
            Intrinsics.checkNotNullParameter(subscriptionStatusType, "<this>");
            return subscriptionStatusType == SubscriptionStatusType.Subscriptioning || subscriptionStatusType == SubscriptionStatusType.SubscriptionTest || subscriptionStatusType == SubscriptionStatusType.SubscriptionPass;
        }
    }
}
