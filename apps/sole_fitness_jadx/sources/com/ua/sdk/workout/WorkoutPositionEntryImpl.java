package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/* loaded from: classes2.dex */
public class WorkoutPositionEntryImpl implements WorkoutPositionEntry {
    public static final Parcelable.Creator<WorkoutPositionEntryImpl> CREATOR = new Parcelable.Creator<WorkoutPositionEntryImpl>() { // from class: com.ua.sdk.workout.WorkoutPositionEntryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutPositionEntryImpl createFromParcel(Parcel parcel) {
            return new WorkoutPositionEntryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutPositionEntryImpl[] newArray(int i) {
            return new WorkoutPositionEntryImpl[i];
        }
    };
    private Double elevation;
    private Double latitude;
    private Double longitude;
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

    public WorkoutPositionEntryImpl(Double d, Double d2, Double d3, Double d4) {
        this.offset = d.doubleValue();
        this.elevation = d2;
        this.latitude = d3;
        this.longitude = d4;
    }

    @Override // com.ua.sdk.workout.WorkoutPositionEntry
    public Double getElevation() {
        return this.elevation;
    }

    @Override // com.ua.sdk.workout.WorkoutPositionEntry
    public Double getLatitude() {
        return this.latitude;
    }

    @Override // com.ua.sdk.workout.WorkoutPositionEntry
    public Double getLongitude() {
        return this.longitude;
    }

    @Override // com.ua.sdk.workout.BaseTimeSeriesEntry
    public double getOffset() {
        return this.offset;
    }

    @Override // java.lang.Comparable
    public int compareTo(WorkoutPositionEntry workoutPositionEntry) {
        return Double.compare(this.offset, workoutPositionEntry.getOffset());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.offset);
        parcel.writeValue(this.elevation);
        parcel.writeValue(this.latitude);
        parcel.writeValue(this.longitude);
    }

    private WorkoutPositionEntryImpl(Parcel parcel) {
        this.offset = parcel.readDouble();
        this.elevation = (Double) parcel.readValue(Double.class.getClassLoader());
        this.latitude = (Double) parcel.readValue(Double.class.getClassLoader());
        this.longitude = (Double) parcel.readValue(Double.class.getClassLoader());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkoutPositionEntryImpl workoutPositionEntryImpl = (WorkoutPositionEntryImpl) obj;
        if (Double.compare(workoutPositionEntryImpl.offset, this.offset) != 0) {
            return false;
        }
        Double d = this.elevation;
        if (d == null ? workoutPositionEntryImpl.elevation != null : !d.equals(workoutPositionEntryImpl.elevation)) {
            return false;
        }
        Double d2 = this.latitude;
        if (d2 == null ? workoutPositionEntryImpl.latitude != null : !d2.equals(workoutPositionEntryImpl.latitude)) {
            return false;
        }
        Double d3 = this.longitude;
        Double d4 = workoutPositionEntryImpl.longitude;
        return d3 == null ? d4 == null : d3.equals(d4);
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.offset);
        int i = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31;
        Double d = this.elevation;
        int iHashCode = (i + (d != null ? d.hashCode() : 0)) * 31;
        Double d2 = this.latitude;
        int iHashCode2 = (iHashCode + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.longitude;
        return iHashCode2 + (d3 != null ? d3.hashCode() : 0);
    }
}
