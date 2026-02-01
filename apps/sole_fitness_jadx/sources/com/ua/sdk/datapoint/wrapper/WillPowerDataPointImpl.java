package com.ua.sdk.datapoint.wrapper;

import com.ua.sdk.datapoint.WillPowerDataPoint;
import java.util.Date;

/* loaded from: classes2.dex */
public class WillPowerDataPointImpl implements WillPowerDataPoint {
    Date dateTime;
    Double willPower;

    public WillPowerDataPointImpl(Double d, Date date) {
        this.dateTime = date;
        this.willPower = d;
    }

    @Override // com.ua.sdk.datapoint.WillPowerDataPoint
    public Double getWillPower() {
        return this.willPower;
    }

    @Override // com.ua.sdk.datapoint.WillPowerDataPoint
    public Date getDateTime() {
        return this.dateTime;
    }
}
