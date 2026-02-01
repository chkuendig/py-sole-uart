package com.ua.sdk.user.stats;

import android.os.Parcelable;
import com.ua.sdk.LocalDate;

/* loaded from: classes2.dex */
public interface AggregatePeriod extends Parcelable {
    LocalDate getEndDate();

    LocalDate getStartDate();
}
