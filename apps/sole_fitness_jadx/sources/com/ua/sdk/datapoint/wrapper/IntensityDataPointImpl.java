package com.ua.sdk.datapoint.wrapper;

import com.ua.sdk.datapoint.IntensityDataPoint;
import java.util.Date;

/* loaded from: classes2.dex */
public class IntensityDataPointImpl implements IntensityDataPoint {
    Date dateTime;
    Double intensity;

    public IntensityDataPointImpl(Double d, Date date) {
        this.dateTime = date;
        this.intensity = d;
    }

    @Override // com.ua.sdk.datapoint.IntensityDataPoint
    public Double getIntensity() {
        return this.intensity;
    }

    @Override // com.ua.sdk.datapoint.IntensityDataPoint
    public Date getDateTime() {
        return this.dateTime;
    }
}
