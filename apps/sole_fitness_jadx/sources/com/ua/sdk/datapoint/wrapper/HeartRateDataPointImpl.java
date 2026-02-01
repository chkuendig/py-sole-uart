package com.ua.sdk.datapoint.wrapper;

import com.ua.sdk.datapoint.HeartRateDataPoint;
import java.util.Date;

/* loaded from: classes2.dex */
public class HeartRateDataPointImpl implements HeartRateDataPoint {
    Date dateTime;
    Long hearRate;

    public HeartRateDataPointImpl(Long l, Date date) {
        this.dateTime = date;
        this.hearRate = l;
    }

    @Override // com.ua.sdk.datapoint.HeartRateDataPoint
    public Long getHeartRate() {
        return this.hearRate;
    }

    @Override // com.ua.sdk.datapoint.HeartRateDataPoint
    public Date getDateTime() {
        return this.dateTime;
    }
}
