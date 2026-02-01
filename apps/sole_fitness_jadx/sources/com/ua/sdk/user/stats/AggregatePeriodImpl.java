package com.ua.sdk.user.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.LocalDate;

/* loaded from: classes2.dex */
public class AggregatePeriodImpl implements AggregatePeriod {
    public static Parcelable.Creator<AggregatePeriodImpl> CREATOR = new Parcelable.Creator<AggregatePeriodImpl>() { // from class: com.ua.sdk.user.stats.AggregatePeriodImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AggregatePeriodImpl createFromParcel(Parcel parcel) {
            return new AggregatePeriodImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AggregatePeriodImpl[] newArray(int i) {
            return new AggregatePeriodImpl[i];
        }
    };

    @SerializedName("end")
    LocalDate mEndDate;

    @SerializedName("start")
    LocalDate mStartDate;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected AggregatePeriodImpl() {
    }

    @Override // com.ua.sdk.user.stats.AggregatePeriod
    public LocalDate getStartDate() {
        return this.mStartDate;
    }

    @Override // com.ua.sdk.user.stats.AggregatePeriod
    public LocalDate getEndDate() {
        return this.mEndDate;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mStartDate, 0);
        parcel.writeParcelable(this.mEndDate, 0);
    }

    private AggregatePeriodImpl(Parcel parcel) {
        this.mStartDate = (LocalDate) parcel.readParcelable(LocalDate.class.getClassLoader());
        this.mEndDate = (LocalDate) parcel.readParcelable(LocalDate.class.getClassLoader());
    }
}
