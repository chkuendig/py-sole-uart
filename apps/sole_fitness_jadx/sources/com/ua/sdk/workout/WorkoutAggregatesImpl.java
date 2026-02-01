package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.IntensityCalculator;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.heartrate.HeartRateZones;
import com.ua.sdk.internal.IntensityCalculatorImpl;

/* loaded from: classes2.dex */
public class WorkoutAggregatesImpl implements WorkoutAggregates {
    public static final Parcelable.Creator<WorkoutAggregatesImpl> CREATOR = new Parcelable.Creator<WorkoutAggregatesImpl>() { // from class: com.ua.sdk.workout.WorkoutAggregatesImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutAggregatesImpl createFromParcel(Parcel parcel) {
            return new WorkoutAggregatesImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutAggregatesImpl[] newArray(int i) {
            return new WorkoutAggregatesImpl[i];
        }
    };

    @SerializedName("active_time_total")
    Double activeTimeTotal;

    @SerializedName("cadence_avg")
    Integer cadenceAvg;

    @SerializedName("cadence_max")
    Integer cadenceMax;

    @SerializedName("cadence_min")
    Integer cadenceMin;

    @SerializedName("distance_total")
    Double distanceTotal;

    @SerializedName("elapsed_time_total")
    Double elapsedTimeTotal;

    @SerializedName("heartrate_avg")
    Integer heartRateAvg;

    @SerializedName("heartrate_max")
    Integer heartRateMax;

    @SerializedName("heartrate_min")
    Integer heartRateMin;
    transient IntensityCalculator intensityCalculator;

    @SerializedName("metabolic_energy_total")
    Double metabolicEnergyTotal;

    @SerializedName("power_avg")
    Double powerAvg;

    @SerializedName("power_max")
    Double powerMax;

    @SerializedName("power_min")
    Double powerMin;

    @SerializedName("speed_avg")
    Double speedAvg;

    @SerializedName("speed_max")
    Double speedMax;

    @SerializedName("speed_min")
    Double speedMin;

    @SerializedName("steps_total")
    Integer stepsTotal;

    @SerializedName("torque_avg")
    Double torqueAvg;

    @SerializedName("torque_max")
    Double torqueMax;

    @SerializedName("torque_min")
    Double torqueMin;

    @SerializedName(BaseDataTypes.ID_WILLPOWER)
    Double willPower;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WorkoutAggregatesImpl() {
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Integer getHeartRateMin() {
        return this.heartRateMin;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Integer getHeartRateMax() {
        return this.heartRateMax;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Integer getHeartRateAvg() {
        return this.heartRateAvg;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getIntensityMin(HeartRateZones heartRateZones) {
        if (this.heartRateMin == null || heartRateZones == null) {
            return null;
        }
        if (this.intensityCalculator == null) {
            this.intensityCalculator = new IntensityCalculatorImpl();
        }
        return Double.valueOf(this.intensityCalculator.calculateCurrentIntensity(heartRateZones, this.heartRateMin.intValue()));
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getIntensityMax(HeartRateZones heartRateZones) {
        if (this.heartRateMax == null || heartRateZones == null) {
            return null;
        }
        if (this.intensityCalculator == null) {
            this.intensityCalculator = new IntensityCalculatorImpl();
        }
        return Double.valueOf(this.intensityCalculator.calculateCurrentIntensity(heartRateZones, this.heartRateMax.intValue()));
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getIntensityAvg(HeartRateZones heartRateZones) {
        if (this.heartRateAvg == null || heartRateZones == null) {
            return null;
        }
        if (this.intensityCalculator == null) {
            this.intensityCalculator = new IntensityCalculatorImpl();
        }
        return Double.valueOf(this.intensityCalculator.calculateCurrentIntensity(heartRateZones, this.heartRateAvg.intValue()));
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getSpeedMin() {
        return this.speedMin;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getSpeedMax() {
        return this.speedMax;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getSpeedAvg() {
        return this.speedAvg;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Integer getCadenceMin() {
        return this.cadenceMin;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Integer getCadenceMax() {
        return this.cadenceMax;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Integer getCadenceAvg() {
        return this.cadenceAvg;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getPowerMin() {
        return this.powerMin;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getPowerMax() {
        return this.powerMax;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getPowerAvg() {
        return this.powerAvg;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getTorqueMin() {
        return this.torqueMin;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getTorqueMax() {
        return this.torqueMax;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getTorqueAvg() {
        return this.torqueAvg;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getWillPower() {
        return this.willPower;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getDistanceTotal() {
        return this.distanceTotal;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getMetabolicEnergyTotal() {
        return this.metabolicEnergyTotal;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getActiveTimeTotal() {
        return this.activeTimeTotal;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Double getElapsedTimeTotal() {
        return this.elapsedTimeTotal;
    }

    @Override // com.ua.sdk.workout.WorkoutAggregates
    public Integer getStepsTotal() {
        return this.stepsTotal;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.heartRateMin);
        parcel.writeValue(this.heartRateMax);
        parcel.writeValue(this.heartRateAvg);
        parcel.writeValue(this.speedMin);
        parcel.writeValue(this.speedMax);
        parcel.writeValue(this.speedAvg);
        parcel.writeValue(this.cadenceMin);
        parcel.writeValue(this.cadenceMax);
        parcel.writeValue(this.cadenceAvg);
        parcel.writeValue(this.powerMin);
        parcel.writeValue(this.powerMax);
        parcel.writeValue(this.powerAvg);
        parcel.writeValue(this.torqueMin);
        parcel.writeValue(this.torqueMax);
        parcel.writeValue(this.torqueAvg);
        parcel.writeValue(this.willPower);
        parcel.writeValue(this.distanceTotal);
        parcel.writeValue(this.metabolicEnergyTotal);
        parcel.writeValue(this.activeTimeTotal);
        parcel.writeValue(this.elapsedTimeTotal);
        parcel.writeValue(this.stepsTotal);
    }

    private WorkoutAggregatesImpl(Parcel parcel) {
        this.heartRateMin = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.heartRateMax = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.heartRateAvg = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.speedMin = (Double) parcel.readValue(Double.class.getClassLoader());
        this.speedMax = (Double) parcel.readValue(Double.class.getClassLoader());
        this.speedAvg = (Double) parcel.readValue(Double.class.getClassLoader());
        this.cadenceMin = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.cadenceMax = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.cadenceAvg = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.powerMin = (Double) parcel.readValue(Double.class.getClassLoader());
        this.powerMax = (Double) parcel.readValue(Double.class.getClassLoader());
        this.powerAvg = (Double) parcel.readValue(Double.class.getClassLoader());
        this.torqueMin = (Double) parcel.readValue(Double.class.getClassLoader());
        this.torqueMax = (Double) parcel.readValue(Double.class.getClassLoader());
        this.torqueAvg = (Double) parcel.readValue(Double.class.getClassLoader());
        this.willPower = (Double) parcel.readValue(Double.class.getClassLoader());
        this.distanceTotal = (Double) parcel.readValue(Double.class.getClassLoader());
        this.metabolicEnergyTotal = (Double) parcel.readValue(Double.class.getClassLoader());
        this.activeTimeTotal = (Double) parcel.readValue(Double.class.getClassLoader());
        this.elapsedTimeTotal = (Double) parcel.readValue(Double.class.getClassLoader());
        this.stepsTotal = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkoutAggregatesImpl workoutAggregatesImpl = (WorkoutAggregatesImpl) obj;
        Double d = this.activeTimeTotal;
        if (d == null ? workoutAggregatesImpl.activeTimeTotal != null : !d.equals(workoutAggregatesImpl.activeTimeTotal)) {
            return false;
        }
        Integer num = this.cadenceAvg;
        if (num == null ? workoutAggregatesImpl.cadenceAvg != null : !num.equals(workoutAggregatesImpl.cadenceAvg)) {
            return false;
        }
        Integer num2 = this.cadenceMax;
        if (num2 == null ? workoutAggregatesImpl.cadenceMax != null : !num2.equals(workoutAggregatesImpl.cadenceMax)) {
            return false;
        }
        Integer num3 = this.cadenceMin;
        if (num3 == null ? workoutAggregatesImpl.cadenceMin != null : !num3.equals(workoutAggregatesImpl.cadenceMin)) {
            return false;
        }
        Double d2 = this.distanceTotal;
        if (d2 == null ? workoutAggregatesImpl.distanceTotal != null : !d2.equals(workoutAggregatesImpl.distanceTotal)) {
            return false;
        }
        Double d3 = this.elapsedTimeTotal;
        if (d3 == null ? workoutAggregatesImpl.elapsedTimeTotal != null : !d3.equals(workoutAggregatesImpl.elapsedTimeTotal)) {
            return false;
        }
        Integer num4 = this.heartRateAvg;
        if (num4 == null ? workoutAggregatesImpl.heartRateAvg != null : !num4.equals(workoutAggregatesImpl.heartRateAvg)) {
            return false;
        }
        Integer num5 = this.heartRateMax;
        if (num5 == null ? workoutAggregatesImpl.heartRateMax != null : !num5.equals(workoutAggregatesImpl.heartRateMax)) {
            return false;
        }
        Integer num6 = this.heartRateMin;
        if (num6 == null ? workoutAggregatesImpl.heartRateMin != null : !num6.equals(workoutAggregatesImpl.heartRateMin)) {
            return false;
        }
        Double d4 = this.metabolicEnergyTotal;
        if (d4 == null ? workoutAggregatesImpl.metabolicEnergyTotal != null : !d4.equals(workoutAggregatesImpl.metabolicEnergyTotal)) {
            return false;
        }
        Double d5 = this.powerAvg;
        if (d5 == null ? workoutAggregatesImpl.powerAvg != null : !d5.equals(workoutAggregatesImpl.powerAvg)) {
            return false;
        }
        Double d6 = this.powerMax;
        if (d6 == null ? workoutAggregatesImpl.powerMax != null : !d6.equals(workoutAggregatesImpl.powerMax)) {
            return false;
        }
        Double d7 = this.powerMin;
        if (d7 == null ? workoutAggregatesImpl.powerMin != null : !d7.equals(workoutAggregatesImpl.powerMin)) {
            return false;
        }
        Double d8 = this.speedAvg;
        if (d8 == null ? workoutAggregatesImpl.speedAvg != null : !d8.equals(workoutAggregatesImpl.speedAvg)) {
            return false;
        }
        Double d9 = this.speedMax;
        if (d9 == null ? workoutAggregatesImpl.speedMax != null : !d9.equals(workoutAggregatesImpl.speedMax)) {
            return false;
        }
        Double d10 = this.speedMin;
        if (d10 == null ? workoutAggregatesImpl.speedMin != null : !d10.equals(workoutAggregatesImpl.speedMin)) {
            return false;
        }
        Integer num7 = this.stepsTotal;
        if (num7 == null ? workoutAggregatesImpl.stepsTotal != null : !num7.equals(workoutAggregatesImpl.stepsTotal)) {
            return false;
        }
        Double d11 = this.torqueAvg;
        if (d11 == null ? workoutAggregatesImpl.torqueAvg != null : !d11.equals(workoutAggregatesImpl.torqueAvg)) {
            return false;
        }
        Double d12 = this.torqueMax;
        if (d12 == null ? workoutAggregatesImpl.torqueMax != null : !d12.equals(workoutAggregatesImpl.torqueMax)) {
            return false;
        }
        Double d13 = this.torqueMin;
        if (d13 == null ? workoutAggregatesImpl.torqueMin != null : !d13.equals(workoutAggregatesImpl.torqueMin)) {
            return false;
        }
        Double d14 = this.willPower;
        Double d15 = workoutAggregatesImpl.willPower;
        return d14 == null ? d15 == null : d14.equals(d15);
    }

    public int hashCode() {
        Integer num = this.heartRateMin;
        int iHashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.heartRateMax;
        int iHashCode2 = (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.heartRateAvg;
        int iHashCode3 = (iHashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Double d = this.speedMin;
        int iHashCode4 = (iHashCode3 + (d != null ? d.hashCode() : 0)) * 31;
        Double d2 = this.speedMax;
        int iHashCode5 = (iHashCode4 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.speedAvg;
        int iHashCode6 = (iHashCode5 + (d3 != null ? d3.hashCode() : 0)) * 31;
        Integer num4 = this.cadenceMin;
        int iHashCode7 = (iHashCode6 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.cadenceMax;
        int iHashCode8 = (iHashCode7 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.cadenceAvg;
        int iHashCode9 = (iHashCode8 + (num6 != null ? num6.hashCode() : 0)) * 31;
        Double d4 = this.powerMin;
        int iHashCode10 = (iHashCode9 + (d4 != null ? d4.hashCode() : 0)) * 31;
        Double d5 = this.powerMax;
        int iHashCode11 = (iHashCode10 + (d5 != null ? d5.hashCode() : 0)) * 31;
        Double d6 = this.powerAvg;
        int iHashCode12 = (iHashCode11 + (d6 != null ? d6.hashCode() : 0)) * 31;
        Double d7 = this.torqueMin;
        int iHashCode13 = (iHashCode12 + (d7 != null ? d7.hashCode() : 0)) * 31;
        Double d8 = this.torqueMax;
        int iHashCode14 = (iHashCode13 + (d8 != null ? d8.hashCode() : 0)) * 31;
        Double d9 = this.torqueAvg;
        int iHashCode15 = (iHashCode14 + (d9 != null ? d9.hashCode() : 0)) * 31;
        Double d10 = this.willPower;
        int iHashCode16 = (iHashCode15 + (d10 != null ? d10.hashCode() : 0)) * 31;
        Double d11 = this.distanceTotal;
        int iHashCode17 = (iHashCode16 + (d11 != null ? d11.hashCode() : 0)) * 31;
        Double d12 = this.metabolicEnergyTotal;
        int iHashCode18 = (iHashCode17 + (d12 != null ? d12.hashCode() : 0)) * 31;
        Double d13 = this.activeTimeTotal;
        int iHashCode19 = (iHashCode18 + (d13 != null ? d13.hashCode() : 0)) * 31;
        Double d14 = this.elapsedTimeTotal;
        int iHashCode20 = (iHashCode19 + (d14 != null ? d14.hashCode() : 0)) * 31;
        Integer num7 = this.stepsTotal;
        return iHashCode20 + (num7 != null ? num7.hashCode() : 0);
    }
}
