package com.ua.sdk.datapoint.wrapper;

import com.ua.sdk.datapoint.EnergyExpendedDataPoint;
import java.util.Date;

/* loaded from: classes2.dex */
public class EnergyExpendedDataPointImpl implements EnergyExpendedDataPoint {
    Date dateTime;
    Double energy;

    public EnergyExpendedDataPointImpl(Double d, Date date) {
        this.energy = d;
        this.dateTime = date;
    }

    @Override // com.ua.sdk.datapoint.EnergyExpendedDataPoint
    public Double getEnergyExpended() {
        return this.energy;
    }

    @Override // com.ua.sdk.datapoint.EnergyExpendedDataPoint
    public Date getDateTime() {
        return this.dateTime;
    }
}
