package com.ua.sdk.actigraphy;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.workout.WorkoutSummary;
import java.util.Date;

/* loaded from: classes2.dex */
public class WorkoutSummaryImpl extends ApiTransferObject implements WorkoutSummary, Parcelable {
    public static Parcelable.Creator<WorkoutSummaryImpl> CREATOR = new Parcelable.Creator<WorkoutSummaryImpl>() { // from class: com.ua.sdk.actigraphy.WorkoutSummaryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutSummaryImpl createFromParcel(Parcel parcel) {
            return new WorkoutSummaryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutSummaryImpl[] newArray(int i) {
            return new WorkoutSummaryImpl[i];
        }
    };
    private ActigraphyAggregatesImpl mActigraphyAggregates;
    private int mActivityTypeId;
    private Date mEndDateTime;
    private String mName;
    private Date mStartDateTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<WorkoutSummary> getRef() {
        return null;
    }

    protected WorkoutSummaryImpl() {
    }

    protected WorkoutSummaryImpl(int i, String str, ActigraphyAggregatesImpl actigraphyAggregatesImpl, Date date, Date date2) {
        this.mActivityTypeId = i;
        this.mName = str;
        this.mActigraphyAggregates = actigraphyAggregatesImpl;
        this.mStartDateTime = date;
        this.mEndDateTime = date2;
    }

    public void setActivityTypeId(int i) {
        this.mActivityTypeId = i;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setWorkoutAggregates(ActigraphyAggregatesImpl actigraphyAggregatesImpl) {
        this.mActigraphyAggregates = actigraphyAggregatesImpl;
    }

    public void setStartDateTime(Date date) {
        this.mStartDateTime = date;
    }

    public void setEndDateTime(Date date) {
        this.mEndDateTime = date;
    }

    @Override // com.ua.sdk.workout.WorkoutSummary
    public int getActivityTypeId() {
        return this.mActivityTypeId;
    }

    @Override // com.ua.sdk.workout.WorkoutSummary
    public String getName() {
        return this.mName;
    }

    @Override // com.ua.sdk.workout.WorkoutSummary
    public ActigraphyAggregatesImpl getWorkoutAggregates() {
        return this.mActigraphyAggregates;
    }

    @Override // com.ua.sdk.workout.WorkoutSummary
    public Date getStartDateTime() {
        return this.mStartDateTime;
    }

    @Override // com.ua.sdk.workout.WorkoutSummary
    public Date getEndDateTime() {
        return this.mEndDateTime;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mActivityTypeId);
        parcel.writeString(this.mName);
        parcel.writeParcelable(this.mActigraphyAggregates, i);
        Date date = this.mStartDateTime;
        parcel.writeLong(date == null ? -1L : date.getTime());
        Date date2 = this.mEndDateTime;
        parcel.writeLong(date2 != null ? date2.getTime() : -1L);
    }

    private WorkoutSummaryImpl(Parcel parcel) {
        super(parcel);
        this.mActivityTypeId = parcel.readInt();
        this.mName = parcel.readString();
        this.mActigraphyAggregates = (ActigraphyAggregatesImpl) parcel.readParcelable(ActigraphyAggregatesImpl.class.getClassLoader());
        Long lValueOf = Long.valueOf(parcel.readLong());
        this.mStartDateTime = lValueOf.longValue() == -1 ? null : new Date(lValueOf.longValue());
        Long lValueOf2 = Long.valueOf(parcel.readLong());
        this.mEndDateTime = lValueOf2.longValue() != -1 ? new Date(lValueOf2.longValue()) : null;
    }
}
