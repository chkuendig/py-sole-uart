package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/* loaded from: classes2.dex */
public class WorkoutTorqueEntryImpl implements WorkoutTorqueEntry {
    public static final Parcelable.Creator<WorkoutTorqueEntryImpl> CREATOR = new Parcelable.Creator<WorkoutTorqueEntryImpl>() { // from class: com.ua.sdk.workout.WorkoutTorqueEntryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutTorqueEntryImpl createFromParcel(Parcel parcel) {
            return new WorkoutTorqueEntryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutTorqueEntryImpl[] newArray(int i) {
            return new WorkoutTorqueEntryImpl[i];
        }
    };
    private double offset;
    private double torque;

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

    public WorkoutTorqueEntryImpl(Double d, Double d2) {
        this.offset = d.doubleValue();
        this.torque = d2.doubleValue();
    }

    @Override // com.ua.sdk.workout.WorkoutTorqueEntry
    public double getInstantaneousTorque() {
        return this.torque;
    }

    @Override // com.ua.sdk.workout.BaseTimeSeriesEntry
    public double getOffset() {
        return this.offset;
    }

    @Override // java.lang.Comparable
    public int compareTo(WorkoutTorqueEntry workoutTorqueEntry) {
        return Double.compare(this.offset, workoutTorqueEntry.getOffset());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(Double.valueOf(this.offset));
        parcel.writeValue(Double.valueOf(this.torque));
    }

    private WorkoutTorqueEntryImpl(Parcel parcel) {
        this.offset = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
        this.torque = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkoutTorqueEntryImpl workoutTorqueEntryImpl = (WorkoutTorqueEntryImpl) obj;
        return Double.compare(workoutTorqueEntryImpl.offset, this.offset) == 0 && Double.compare(workoutTorqueEntryImpl.torque, this.torque) == 0;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.offset);
        int i = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.torque);
        return (i * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }
}
