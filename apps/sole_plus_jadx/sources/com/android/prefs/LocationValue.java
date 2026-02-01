package com.android.prefs;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidLocationsException.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0096\u0002R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/android/prefs/LocationValue;", "", "propertyName", "", "getPropertyName", "()Ljava/lang/String;", "queryType", "getQueryType", "value", "getValue", "compareTo", "", "other", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface LocationValue extends Comparable<LocationValue> {
    int compareTo(LocationValue other);

    String getPropertyName();

    String getQueryType();

    String getValue();

    /* compiled from: AndroidLocationsException.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static int compareTo(LocationValue locationValue, LocationValue other) {
            Intrinsics.checkNotNullParameter(locationValue, "this");
            Intrinsics.checkNotNullParameter(other, "other");
            int iCompareTo = locationValue.getPropertyName().compareTo(other.getPropertyName());
            return iCompareTo == 0 ? locationValue.getQueryType().compareTo(other.getQueryType()) : iCompareTo;
        }
    }
}
