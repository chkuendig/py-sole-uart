package com.ua.sdk.actigraphy;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class ActigraphyAggregatesImpl implements ActigraphyAggregates, Parcelable {
    public static Parcelable.Creator<ActigraphyAggregatesImpl> CREATOR = new Parcelable.Creator<ActigraphyAggregatesImpl>() { // from class: com.ua.sdk.actigraphy.ActigraphyAggregatesImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphyAggregatesImpl createFromParcel(Parcel parcel) {
            return new ActigraphyAggregatesImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphyAggregatesImpl[] newArray(int i) {
            return new ActigraphyAggregatesImpl[i];
        }
    };
    private AggregateValueImpl mActiveTime;
    private AggregateValueImpl mBodyMass;
    private AggregateValueImpl mDistance;
    private AggregateValueImpl mEnergyBurned;
    private AggregateValueImpl mSleep;
    private AggregateValueImpl mSteps;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected ActigraphyAggregatesImpl() {
    }

    protected ActigraphyAggregatesImpl(AggregateValueImpl aggregateValueImpl, AggregateValueImpl aggregateValueImpl2, AggregateValueImpl aggregateValueImpl3, AggregateValueImpl aggregateValueImpl4, AggregateValueImpl aggregateValueImpl5, AggregateValueImpl aggregateValueImpl6) {
        this.mDistance = aggregateValueImpl;
        this.mBodyMass = aggregateValueImpl2;
        this.mActiveTime = aggregateValueImpl3;
        this.mEnergyBurned = aggregateValueImpl4;
        this.mSleep = aggregateValueImpl5;
        this.mSteps = aggregateValueImpl6;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyAggregates
    public AggregateValueImpl getDistance() {
        return this.mDistance;
    }

    public void setDistance(AggregateValueImpl aggregateValueImpl) {
        this.mDistance = aggregateValueImpl;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyAggregates
    public AggregateValueImpl getBodyMass() {
        return this.mBodyMass;
    }

    public void setBodyMass(AggregateValueImpl aggregateValueImpl) {
        this.mBodyMass = aggregateValueImpl;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyAggregates
    public AggregateValueImpl getActiveTime() {
        return this.mActiveTime;
    }

    public void setActiveTime(AggregateValueImpl aggregateValueImpl) {
        this.mActiveTime = aggregateValueImpl;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyAggregates
    public AggregateValueImpl getEnergyBurned() {
        return this.mEnergyBurned;
    }

    public void setEnergyBurned(AggregateValueImpl aggregateValueImpl) {
        this.mEnergyBurned = aggregateValueImpl;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyAggregates
    public AggregateValueImpl getSleep() {
        return this.mSleep;
    }

    public void setSleep(AggregateValueImpl aggregateValueImpl) {
        this.mSleep = aggregateValueImpl;
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyAggregates
    public AggregateValueImpl getSteps() {
        return this.mSteps;
    }

    public void setSteps(AggregateValueImpl aggregateValueImpl) {
        this.mSteps = aggregateValueImpl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mDistance, i);
        parcel.writeParcelable(this.mBodyMass, i);
        parcel.writeParcelable(this.mActiveTime, i);
        parcel.writeParcelable(this.mEnergyBurned, i);
        parcel.writeParcelable(this.mSleep, i);
        parcel.writeParcelable(this.mSteps, i);
    }

    private ActigraphyAggregatesImpl(Parcel parcel) {
        this.mDistance = (AggregateValueImpl) parcel.readParcelable(AggregateValueImpl.class.getClassLoader());
        this.mBodyMass = (AggregateValueImpl) parcel.readParcelable(AggregateValueImpl.class.getClassLoader());
        this.mActiveTime = (AggregateValueImpl) parcel.readParcelable(AggregateValueImpl.class.getClassLoader());
        this.mEnergyBurned = (AggregateValueImpl) parcel.readParcelable(AggregateValueImpl.class.getClassLoader());
        this.mSleep = (AggregateValueImpl) parcel.readParcelable(AggregateValueImpl.class.getClassLoader());
        this.mSteps = (AggregateValueImpl) parcel.readParcelable(AggregateValueImpl.class.getClassLoader());
    }
}
