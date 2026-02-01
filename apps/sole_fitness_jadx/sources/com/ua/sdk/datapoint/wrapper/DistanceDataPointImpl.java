package com.ua.sdk.datapoint.wrapper;

import com.ua.sdk.datapoint.DistanceDataPoint;
import java.util.Date;

/* loaded from: classes2.dex */
public class DistanceDataPointImpl implements DistanceDataPoint {
    Date dateTime;
    Double distance;

    public DistanceDataPointImpl(Double d, Date date) {
        this.distance = d;
        this.dateTime = date;
    }

    @Override // com.ua.sdk.datapoint.DistanceDataPoint
    public Double getDistance() {
        return this.distance;
    }

    @Override // com.ua.sdk.datapoint.DistanceDataPoint
    public Date getDateTime() {
        return this.dateTime;
    }
}
