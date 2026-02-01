package com.ua.sdk.user.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.dyaco.sole.database.WorkoutData;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.activitytype.ActivityType;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;

/* loaded from: classes2.dex */
public class StatsImpl extends ApiTransferObject implements Stats {
    public static Parcelable.Creator<StatsImpl> CREATOR = new Parcelable.Creator<StatsImpl>() { // from class: com.ua.sdk.user.stats.StatsImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatsImpl createFromParcel(Parcel parcel) {
            return new StatsImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatsImpl[] newArray(int i) {
            return new StatsImpl[i];
        }
    };
    protected static final String REF_ACTIVITY_TYPE = "activity_type";

    @SerializedName("activity_count")
    Integer activityCount;

    @SerializedName("aggregate_period")
    AggregatePeriodImpl aggregatePeriod;

    @SerializedName("avg_pace")
    Double averagePace;

    @SerializedName(WorkoutData.AVG_SPEED)
    Double averageSpeed;

    @SerializedName("distance")
    Double distance;

    @SerializedName("duration")
    Double duration;

    @SerializedName("energy")
    Double energy;

    @SerializedName("time_in_heart_rate_zones")
    HeartRateTimesAggregateImpl heartRateTimesAggregate;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public StatsImpl() {
    }

    @Override // com.ua.sdk.user.stats.Stats
    public Double getDistance() {
        return this.distance;
    }

    @Override // com.ua.sdk.user.stats.Stats
    public HeartRateTimesAggregate getHeartRateTimeAggregate() {
        return this.heartRateTimesAggregate;
    }

    @Override // com.ua.sdk.user.stats.Stats
    public Double getAveragePace() {
        return this.averagePace;
    }

    @Override // com.ua.sdk.user.stats.Stats
    public Integer getActivityCount() {
        return this.activityCount;
    }

    @Override // com.ua.sdk.user.stats.Stats
    public Double getEnergy() {
        return this.energy;
    }

    @Override // com.ua.sdk.user.stats.Stats
    public AggregatePeriod getAggregatePeriod() {
        return this.aggregatePeriod;
    }

    @Override // com.ua.sdk.user.stats.Stats
    public EntityRef<ActivityType> getActivityTypeRef() {
        Link link = getLink(REF_ACTIVITY_TYPE);
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.user.stats.Stats
    public Double getDuration() {
        return this.duration;
    }

    @Override // com.ua.sdk.user.stats.Stats
    public Double getAverageSpeed() {
        return this.averageSpeed;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.distance);
        parcel.writeParcelable(this.heartRateTimesAggregate, i);
        parcel.writeValue(this.averagePace);
        parcel.writeValue(this.activityCount);
        parcel.writeValue(this.energy);
        parcel.writeParcelable(this.aggregatePeriod, i);
        parcel.writeValue(this.duration);
        parcel.writeValue(this.averageSpeed);
    }

    private StatsImpl(Parcel parcel) {
        super(parcel);
        this.distance = (Double) parcel.readValue(Double.class.getClassLoader());
        this.heartRateTimesAggregate = (HeartRateTimesAggregateImpl) parcel.readParcelable(HeartRateTimesAggregate.class.getClassLoader());
        this.averagePace = (Double) parcel.readValue(Double.class.getClassLoader());
        this.activityCount = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.energy = (Double) parcel.readValue(Double.class.getClassLoader());
        this.aggregatePeriod = (AggregatePeriodImpl) parcel.readParcelable(AggregatePeriod.class.getClassLoader());
        this.duration = (Double) parcel.readValue(Double.class.getClassLoader());
        this.averageSpeed = (Double) parcel.readValue(Double.class.getClassLoader());
    }
}
