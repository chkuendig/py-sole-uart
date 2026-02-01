package com.ua.sdk.actigraphy;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class MetricImpl implements Parcelable, Metric {
    public static Parcelable.Creator<MetricImpl> CREATOR = new Parcelable.Creator<MetricImpl>() { // from class: com.ua.sdk.actigraphy.MetricImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetricImpl createFromParcel(Parcel parcel) {
            return new MetricImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetricImpl[] newArray(int i) {
            return new MetricImpl[i];
        }
    };
    private AggregateValueImpl mAggregateValueImpl;
    private Date mEndDate;
    private long[] mEpochTimes;
    private Date mStartDate;
    private TimeZone mTimeZone;
    private double[] mValues;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected MetricImpl() {
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public Date getStartDateTime() {
        return this.mStartDate;
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public void setStartDateTime(Date date) {
        this.mStartDate = date;
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public Date getEndDateTime() {
        return this.mEndDate;
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public void setEndDateTime(Date date) {
        this.mEndDate = date;
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public AggregateValueImpl getAggregateValue() {
        return this.mAggregateValueImpl;
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public void setAggregateValue(AggregateValueImpl aggregateValueImpl) {
        this.mAggregateValueImpl = aggregateValueImpl;
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public long[] getEpochTimes() {
        return this.mEpochTimes;
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public void setEpochTimes(long[] jArr) {
        this.mEpochTimes = jArr;
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public long getEpochTime(int i) {
        return this.mEpochTimes[i];
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public void setTimeZone(TimeZone timeZone) {
        this.mTimeZone = timeZone;
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public double[] getValues() {
        return this.mValues;
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public void setValues(double[] dArr) {
        this.mValues = dArr;
    }

    @Override // com.ua.sdk.actigraphy.Metric
    public double getValue(int i) {
        return this.mValues[i];
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Date date = this.mStartDate;
        parcel.writeValue(Long.valueOf(date != null ? date.getTime() : -1L));
        Date date2 = this.mEndDate;
        parcel.writeValue(Long.valueOf(date2 != null ? date2.getTime() : -1L));
        parcel.writeParcelable(this.mAggregateValueImpl, i);
        parcel.writeLongArray(this.mEpochTimes);
        TimeZone timeZone = this.mTimeZone;
        parcel.writeString(timeZone == null ? null : timeZone.getID());
        parcel.writeDoubleArray(this.mValues);
    }

    protected MetricImpl(Parcel parcel) {
        long jLongValue = ((Long) parcel.readValue(Long.class.getClassLoader())).longValue();
        this.mStartDate = jLongValue == -1 ? null : new Date(jLongValue);
        long jLongValue2 = ((Long) parcel.readValue(Long.class.getClassLoader())).longValue();
        this.mEndDate = jLongValue2 == -1 ? null : new Date(jLongValue2);
        this.mAggregateValueImpl = (AggregateValueImpl) parcel.readParcelable(AggregateValueImpl.class.getClassLoader());
        this.mEpochTimes = parcel.createLongArray();
        String string = parcel.readString();
        this.mTimeZone = string != null ? TimeZone.getTimeZone(string) : null;
        this.mValues = parcel.createDoubleArray();
    }
}
