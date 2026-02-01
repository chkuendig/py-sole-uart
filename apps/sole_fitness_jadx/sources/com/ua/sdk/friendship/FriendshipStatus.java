package com.ua.sdk.friendship;

import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* loaded from: classes2.dex */
public enum FriendshipStatus {
    NONE(IntegrityManager.INTEGRITY_TYPE_NONE),
    PENDING("pending"),
    ACTIVE(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);

    private String value;

    FriendshipStatus(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static FriendshipStatus getStatusFromString(String str) {
        for (FriendshipStatus friendshipStatus : values()) {
            if (friendshipStatus.value.equals(str)) {
                return friendshipStatus;
            }
        }
        return null;
    }
}
