package com.ua.sdk.datapoint.wrapper;

import com.ua.sdk.datapoint.LocationDataPoint;
import java.util.Date;

/* loaded from: classes2.dex */
public class LocationDataPointImpl implements LocationDataPoint {
    Double accuracy;
    Date dateTime;
    Double latitude;
    Double longitude;

    public LocationDataPointImpl(Double d, Double d2, Double d3, Date date) {
        this.dateTime = date;
        this.latitude = d;
        this.longitude = d2;
        this.accuracy = d3;
    }

    @Override // com.ua.sdk.datapoint.LocationDataPoint
    public Double getLatitude() {
        return this.latitude;
    }

    @Override // com.ua.sdk.datapoint.LocationDataPoint
    public Double getLongitude() {
        return this.longitude;
    }

    @Override // com.ua.sdk.datapoint.LocationDataPoint
    public Double getAccuracy() {
        return this.accuracy;
    }

    @Override // com.ua.sdk.datapoint.LocationDataPoint
    public Date getDateTime() {
        return this.dateTime;
    }
}
