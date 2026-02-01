package com.ua.sdk.actigraphy;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class ActigraphyMetricsImpl implements Parcelable, ActigraphyMetrics {
    public static Parcelable.Creator<ActigraphyMetricsImpl> CREATOR = new Parcelable.Creator<ActigraphyMetricsImpl>() { // from class: com.ua.sdk.actigraphy.ActigraphyMetricsImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphyMetricsImpl createFromParcel(Parcel parcel) {
            return new ActigraphyMetricsImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphyMetricsImpl[] newArray(int i) {
            return new ActigraphyMetricsImpl[i];
        }
    };
    private MetricImpl[] mBodyMass;
    private MetricImpl[] mDistance;
    private MetricImpl[] mEnergyBurned;
    private MetricImpl[] mSleep;
    private MetricImpl[] mSteps;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected ActigraphyMetricsImpl() {
    }

    protected ActigraphyMetricsImpl(MetricImpl[] metricImplArr, MetricImpl[] metricImplArr2, MetricImpl[] metricImplArr3, MetricImpl[] metricImplArr4, MetricImpl[] metricImplArr5) {
        this.mDistance = metricImplArr;
        this.mEnergyBurned = metricImplArr2;
        this.mSteps = metricImplArr3;
        this.mSleep = metricImplArr4;
        this.mBodyMass = metricImplArr5;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyMetrics
    public Metric[] getBodyMass() {
        return this.mBodyMass;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyMetrics
    public void setBodyMass(MetricImpl[] metricImplArr) {
        this.mBodyMass = metricImplArr;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyMetrics
    public Metric[] getDistance() {
        return this.mDistance;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyMetrics
    public void setDistance(MetricImpl[] metricImplArr) {
        this.mDistance = metricImplArr;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyMetrics
    public Metric[] getEnergyBurned() {
        return this.mEnergyBurned;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyMetrics
    public void setEnergyBurned(MetricImpl[] metricImplArr) {
        this.mEnergyBurned = metricImplArr;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyMetrics
    public Metric[] getSteps() {
        return this.mSteps;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyMetrics
    public void setSteps(MetricImpl[] metricImplArr) {
        this.mSteps = metricImplArr;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyMetrics
    public Metric[] getSleep() {
        return this.mSleep;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyMetrics
    public void setSleep(MetricImpl[] metricImplArr) {
        this.mSleep = metricImplArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(this.mDistance, i);
        parcel.writeParcelableArray(this.mEnergyBurned, i);
        parcel.writeParcelableArray(this.mSteps, i);
        parcel.writeParcelableArray(this.mSleep, i);
        parcel.writeParcelableArray(this.mBodyMass, i);
    }

    protected ActigraphyMetricsImpl(Parcel parcel) {
        Parcelable[] parcelableArray = parcel.readParcelableArray(MetricImpl.class.getClassLoader());
        if (parcelableArray != null) {
            MetricImpl[] metricImplArr = new MetricImpl[parcelableArray.length];
            this.mDistance = metricImplArr;
            System.arraycopy(parcelableArray, 0, metricImplArr, 0, parcelableArray.length);
        } else {
            this.mDistance = null;
        }
        Parcelable[] parcelableArray2 = parcel.readParcelableArray(MetricImpl.class.getClassLoader());
        if (parcelableArray2 != null) {
            MetricImpl[] metricImplArr2 = new MetricImpl[parcelableArray2.length];
            this.mEnergyBurned = metricImplArr2;
            System.arraycopy(parcelableArray2, 0, metricImplArr2, 0, parcelableArray2.length);
        } else {
            this.mEnergyBurned = null;
        }
        Parcelable[] parcelableArray3 = parcel.readParcelableArray(MetricImpl.class.getClassLoader());
        if (parcelableArray3 != null) {
            MetricImpl[] metricImplArr3 = new MetricImpl[parcelableArray3.length];
            this.mSteps = metricImplArr3;
            System.arraycopy(parcelableArray3, 0, metricImplArr3, 0, parcelableArray3.length);
        } else {
            this.mSteps = null;
        }
        Parcelable[] parcelableArray4 = parcel.readParcelableArray(MetricImpl.class.getClassLoader());
        if (parcelableArray4 != null) {
            MetricImpl[] metricImplArr4 = new MetricImpl[parcelableArray4.length];
            this.mSleep = metricImplArr4;
            System.arraycopy(parcelableArray4, 0, metricImplArr4, 0, parcelableArray4.length);
        } else {
            this.mSleep = null;
        }
        Parcelable[] parcelableArray5 = parcel.readParcelableArray(MetricImpl.class.getClassLoader());
        if (parcelableArray5 != null) {
            MetricImpl[] metricImplArr5 = new MetricImpl[parcelableArray5.length];
            this.mBodyMass = metricImplArr5;
            System.arraycopy(parcelableArray5, 0, metricImplArr5, 0, parcelableArray5.length);
            return;
        }
        this.mBodyMass = null;
    }
}
