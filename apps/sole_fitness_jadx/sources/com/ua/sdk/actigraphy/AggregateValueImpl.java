package com.ua.sdk.actigraphy;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.aggregate.AggregateDetails;
import com.ua.sdk.aggregate.AggregateValue;

/* loaded from: classes2.dex */
public class AggregateValueImpl implements Parcelable, AggregateValue {
    public static Parcelable.Creator<AggregateValueImpl> CREATOR = new Parcelable.Creator<AggregateValueImpl>() { // from class: com.ua.sdk.actigraphy.AggregateValueImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AggregateValueImpl createFromParcel(Parcel parcel) {
            return new AggregateValueImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AggregateValueImpl[] newArray(int i) {
            return new AggregateValueImpl[i];
        }
    };
    private AggregateDetails mAggregateDetails;
    private Double mAverage;
    private Double mCount;
    private Double mLatest;
    private Double mMax;
    private Double mMin;
    private Double mSum;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected AggregateValueImpl() {
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public Double getCount() {
        return this.mCount;
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public void setCount(Double d) {
        this.mCount = d;
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public Double getSum() {
        return this.mSum;
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public void setSum(Double d) {
        this.mSum = d;
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public Double getMin() {
        return this.mMin;
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public void setMin(Double d) {
        this.mMin = d;
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public Double getMax() {
        return this.mMax;
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public void setMax(Double d) {
        this.mMax = d;
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public Double getLatest() {
        return this.mLatest;
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public void setLatest(Double d) {
        this.mLatest = d;
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public Double getAverage() {
        return this.mAverage;
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public void setAverage(Double d) {
        this.mAverage = d;
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public AggregateDetails getAggregateDetails() {
        return this.mAggregateDetails;
    }

    @Override // com.ua.sdk.aggregate.AggregateValue
    public void setAggregateDetails(AggregateDetails aggregateDetails) {
        this.mAggregateDetails = aggregateDetails;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Double d = this.mSum;
        parcel.writeString(d == null ? null : d.toString());
        Double d2 = this.mMin;
        parcel.writeString(d2 == null ? null : d2.toString());
        Double d3 = this.mMax;
        parcel.writeString(d3 == null ? null : d3.toString());
        Double d4 = this.mLatest;
        parcel.writeString(d4 == null ? null : d4.toString());
        Double d5 = this.mCount;
        parcel.writeString(d5 == null ? null : d5.toString());
        Double d6 = this.mAverage;
        parcel.writeString(d6 != null ? d6.toString() : null);
        parcel.writeParcelable(this.mAggregateDetails, i);
    }

    private AggregateValueImpl(Parcel parcel) {
        String string = parcel.readString();
        this.mSum = string == null ? null : new Double(string);
        String string2 = parcel.readString();
        this.mMin = string2 == null ? null : new Double(string2);
        String string3 = parcel.readString();
        this.mMax = string3 == null ? null : new Double(string3);
        String string4 = parcel.readString();
        this.mLatest = string4 == null ? null : new Double(string4);
        String string5 = parcel.readString();
        this.mCount = string5 == null ? null : new Double(string5);
        String string6 = parcel.readString();
        this.mAverage = string6 != null ? new Double(string6) : null;
        this.mAggregateDetails = (AggregateDetails) parcel.readParcelable(AggregateDetails.class.getClassLoader());
    }
}
