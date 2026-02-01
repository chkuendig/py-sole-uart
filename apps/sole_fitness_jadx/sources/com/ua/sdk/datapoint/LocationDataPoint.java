package com.ua.sdk.datapoint;

import java.util.Date;

/* loaded from: classes2.dex */
public interface LocationDataPoint {
    Double getAccuracy();

    Date getDateTime();

    Double getLatitude();

    Double getLongitude();
}
