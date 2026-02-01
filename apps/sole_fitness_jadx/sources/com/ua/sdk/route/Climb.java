package com.ua.sdk.route;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public interface Climb extends Parcelable {
    String getCategory();

    Double getChangeMeters();

    Double getDistanceMeters();

    Double getEnd();

    int getEndIndex();

    Double getMaxElevation();

    Double getStart();

    int getStartIndex();
}
