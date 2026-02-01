package com.ua.sdk.actigraphy;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class SleepAggregateDetailsImpl implements Parcelable, SleepAggregateDetails {
    public static Parcelable.Creator<SleepAggregateDetailsImpl> CREATOR = new Parcelable.Creator<SleepAggregateDetailsImpl>() { // from class: com.ua.sdk.actigraphy.SleepAggregateDetailsImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepAggregateDetailsImpl createFromParcel(Parcel parcel) {
            return new SleepAggregateDetailsImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepAggregateDetailsImpl[] newArray(int i) {
            return new SleepAggregateDetailsImpl[i];
        }
    };
    private Double mAwake;
    private Double mDeepSleep;
    private Double mLightSleep;
    private Double mTimeToSleep;
    private Integer mTimesAwaken;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected SleepAggregateDetailsImpl() {
    }

    @Override // com.ua.sdk.actigraphy.SleepAggregateDetails
    public Double getDeepSleep() {
        return this.mDeepSleep;
    }

    @Override // com.ua.sdk.actigraphy.SleepAggregateDetails
    public void setDeepSleep(Double d) {
        this.mDeepSleep = d;
    }

    @Override // com.ua.sdk.actigraphy.SleepAggregateDetails
    public Double getAwake() {
        return this.mAwake;
    }

    @Override // com.ua.sdk.actigraphy.SleepAggregateDetails
    public void setAwake(Double d) {
        this.mAwake = d;
    }

    @Override // com.ua.sdk.actigraphy.SleepAggregateDetails
    public Double getTimeToSleep() {
        return this.mTimeToSleep;
    }

    @Override // com.ua.sdk.actigraphy.SleepAggregateDetails
    public void setTimeToSleep(Double d) {
        this.mTimeToSleep = d;
    }

    @Override // com.ua.sdk.actigraphy.SleepAggregateDetails
    public Integer getTimesAwaken() {
        return this.mTimesAwaken;
    }

    @Override // com.ua.sdk.actigraphy.SleepAggregateDetails
    public void setTimesAwaken(Integer num) {
        this.mTimesAwaken = num;
    }

    @Override // com.ua.sdk.actigraphy.SleepAggregateDetails
    public Double getLightSleep() {
        return this.mLightSleep;
    }

    @Override // com.ua.sdk.actigraphy.SleepAggregateDetails
    public void setLightSleep(Double d) {
        this.mLightSleep = d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.mDeepSleep);
        parcel.writeValue(this.mAwake);
        parcel.writeValue(this.mTimeToSleep);
        parcel.writeValue(this.mTimesAwaken);
        parcel.writeValue(this.mLightSleep);
    }

    private SleepAggregateDetailsImpl(Parcel parcel) {
        this.mDeepSleep = (Double) parcel.readValue(Double.class.getClassLoader());
        this.mAwake = (Double) parcel.readValue(Double.class.getClassLoader());
        this.mTimeToSleep = (Double) parcel.readValue(Double.class.getClassLoader());
        this.mTimesAwaken = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.mLightSleep = (Double) parcel.readValue(Double.class.getClassLoader());
    }
}
