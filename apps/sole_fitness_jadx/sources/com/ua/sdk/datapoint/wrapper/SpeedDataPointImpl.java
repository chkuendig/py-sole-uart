package com.ua.sdk.datapoint.wrapper;

import com.ua.sdk.datapoint.SpeedDataPoint;
import java.util.Date;

/* loaded from: classes2.dex */
public class SpeedDataPointImpl implements SpeedDataPoint {
    Date dateTime;
    Double speed;

    public SpeedDataPointImpl(Double d, Date date) {
        this.dateTime = date;
        this.speed = d;
    }

    @Override // com.ua.sdk.datapoint.SpeedDataPoint
    public Double getSpeed() {
        return this.speed;
    }

    @Override // com.ua.sdk.datapoint.SpeedDataPoint
    public Date getDateTime() {
        return this.dateTime;
    }
}
