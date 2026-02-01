package com.ua.sdk.actigraphy;

/* loaded from: classes2.dex */
public interface ActigraphyMetrics {
    Metric[] getBodyMass();

    Metric[] getDistance();

    Metric[] getEnergyBurned();

    Metric[] getSleep();

    Metric[] getSteps();

    void setBodyMass(MetricImpl[] metricImplArr);

    void setDistance(MetricImpl[] metricImplArr);

    void setEnergyBurned(MetricImpl[] metricImplArr);

    void setSleep(MetricImpl[] metricImplArr);

    void setSteps(MetricImpl[] metricImplArr);
}
