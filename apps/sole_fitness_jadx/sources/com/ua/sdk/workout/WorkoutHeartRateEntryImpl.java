package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/* loaded from: classes2.dex */
public class WorkoutHeartRateEntryImpl implements WorkoutHeartRateEntry {
    public static final Parcelable.Creator<WorkoutHeartRateEntryImpl> CREATOR = new Parcelable.Creator<WorkoutHeartRateEntryImpl>() { // from class: com.ua.sdk.workout.WorkoutHeartRateEntryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutHeartRateEntryImpl createFromParcel(Parcel parcel) {
            return new WorkoutHeartRateEntryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutHeartRateEntryImpl[] newArray(int i) {
            return new WorkoutHeartRateEntryImpl[i];
        }
    };
    private int bpm;
    private double offset;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.workout.BaseTimeSeriesEntry
    public Date getTime() {
        return null;
    }

    @Override // com.ua.sdk.workout.BaseTimeSeriesEntry
    public Long getTimeInMillis() {
        return null;
    }

    public WorkoutHeartRateEntryImpl(Double d, Integer num) {
        this.offset = d.doubleValue();
        this.bpm = num.intValue();
    }

    @Override // com.ua.sdk.workout.WorkoutHeartRateEntry
    public int getBpm() {
        return this.bpm;
    }

    @Override // com.ua.sdk.workout.BaseTimeSeriesEntry
    public double getOffset() {
        return this.offset;
    }

    @Override // java.lang.Comparable
    public int compareTo(WorkoutHeartRateEntry workoutHeartRateEntry) {
        return Double.compare(this.offset, workoutHeartRateEntry.getOffset());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(Double.valueOf(this.offset));
        parcel.writeValue(Integer.valueOf(this.bpm));
    }

    private WorkoutHeartRateEntryImpl(Parcel parcel) {
        this.offset = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
        this.bpm = ((Integer) parcel.readValue(Integer.class.getClassLoader())).intValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkoutHeartRateEntryImpl workoutHeartRateEntryImpl = (WorkoutHeartRateEntryImpl) obj;
        return this.bpm == workoutHeartRateEntryImpl.bpm && Double.compare(workoutHeartRateEntryImpl.offset, this.offset) == 0;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.offset);
        return (((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31) + this.bpm;
    }
}
