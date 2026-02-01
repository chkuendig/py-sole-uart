package com.ua.sdk.datapoint.wrapper;

import com.ua.sdk.datapoint.RunCadenceDataPoint;
import java.util.Date;

/* loaded from: classes2.dex */
public class RunCadenceDataPointImpl implements RunCadenceDataPoint {
    Long cadence;
    Date dateTime;

    public RunCadenceDataPointImpl(Long l, Date date) {
        this.dateTime = date;
        this.cadence = l;
    }

    @Override // com.ua.sdk.datapoint.RunCadenceDataPoint
    public Long getRunCadence() {
        return this.cadence;
    }

    @Override // com.ua.sdk.datapoint.RunCadenceDataPoint
    public Date getDateTime() {
        return this.dateTime;
    }
}
