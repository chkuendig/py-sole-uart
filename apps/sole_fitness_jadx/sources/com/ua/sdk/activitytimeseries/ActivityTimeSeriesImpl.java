package com.ua.sdk.activitytimeseries;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.Reference;

/* loaded from: classes2.dex */
public class ActivityTimeSeriesImpl implements ActivityTimeSeries, Parcelable {
    public static Parcelable.Creator<ActivityTimeSeriesImpl> CREATOR = new Parcelable.Creator<ActivityTimeSeriesImpl>() { // from class: com.ua.sdk.activitytimeseries.ActivityTimeSeriesImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityTimeSeriesImpl createFromParcel(Parcel parcel) {
            return new ActivityTimeSeriesImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityTimeSeriesImpl[] newArray(int i) {
            return new ActivityTimeSeriesImpl[i];
        }
    };

    @SerializedName("recorder_identifier")
    String recorderIdentifier;

    @SerializedName("recorder_type_key")
    String recorderTypeKey;

    @SerializedName("time_series")
    TimeSeries timeSeries;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Resource
    public Reference getRef() {
        return null;
    }

    ActivityTimeSeriesImpl() {
    }

    ActivityTimeSeriesImpl(ActivityTimeSeriesBuilderImpl activityTimeSeriesBuilderImpl) {
        this.recorderTypeKey = activityTimeSeriesBuilderImpl.recorderTypeKey;
        this.recorderIdentifier = activityTimeSeriesBuilderImpl.recorderIdentifier;
        if (activityTimeSeriesBuilderImpl.distanceEpochs == null && activityTimeSeriesBuilderImpl.distanceValues == null && activityTimeSeriesBuilderImpl.calorieEpochs == null && activityTimeSeriesBuilderImpl.calorieValues == null && activityTimeSeriesBuilderImpl.stepEpochs == null && activityTimeSeriesBuilderImpl.stepValues == null) {
            return;
        }
        this.timeSeries = new TimeSeries();
        if (activityTimeSeriesBuilderImpl.stepEpochs != null) {
            this.timeSeries.stepEpochs = activityTimeSeriesBuilderImpl.stepEpochs.toArray();
            this.timeSeries.stepValues = activityTimeSeriesBuilderImpl.stepValues.toArray();
        }
        if (activityTimeSeriesBuilderImpl.calorieEpochs != null) {
            this.timeSeries.calorieEpochs = activityTimeSeriesBuilderImpl.calorieEpochs.toArray();
            this.timeSeries.calorieValues = activityTimeSeriesBuilderImpl.calorieValues.toArray();
        }
        if (activityTimeSeriesBuilderImpl.distanceEpochs != null) {
            this.timeSeries.distanceEpochs = activityTimeSeriesBuilderImpl.distanceEpochs.toArray();
            this.timeSeries.distanceValues = activityTimeSeriesBuilderImpl.distanceValues.toArray();
        }
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeries
    public String getRecorderTypeKey() {
        return this.recorderTypeKey;
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeries
    public String getRecorderIdentifier() {
        return this.recorderIdentifier;
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeries
    public int getStepsSize() {
        TimeSeries timeSeries = this.timeSeries;
        if (timeSeries == null || timeSeries.stepEpochs == null) {
            return 0;
        }
        return this.timeSeries.stepEpochs.length;
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeries
    public long getStepEpoch(int i) {
        TimeSeries timeSeries = this.timeSeries;
        if (timeSeries == null || timeSeries.stepEpochs == null) {
            throwIndexOutOfBoundsException(i, 0);
        }
        return this.timeSeries.stepEpochs[i];
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeries
    public int getStepValue(int i) {
        TimeSeries timeSeries = this.timeSeries;
        if (timeSeries == null || timeSeries.stepValues == null) {
            throwIndexOutOfBoundsException(i, 0);
        }
        return this.timeSeries.stepValues[i];
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeries
    public int getDistancesSize() {
        TimeSeries timeSeries = this.timeSeries;
        if (timeSeries == null || timeSeries.distanceEpochs == null) {
            return 0;
        }
        return this.timeSeries.distanceEpochs.length;
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeries
    public long getDistanceEpoch(int i) {
        TimeSeries timeSeries = this.timeSeries;
        if (timeSeries == null || timeSeries.distanceEpochs == null) {
            throwIndexOutOfBoundsException(i, 0);
        }
        return this.timeSeries.distanceEpochs[i];
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeries
    public double getDistanceValue(int i) {
        TimeSeries timeSeries = this.timeSeries;
        if (timeSeries == null || timeSeries.distanceValues == null) {
            throwIndexOutOfBoundsException(i, 0);
        }
        return this.timeSeries.distanceValues[i];
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeries
    public int getCaloriesSize() {
        TimeSeries timeSeries = this.timeSeries;
        if (timeSeries == null || timeSeries.calorieEpochs == null) {
            return 0;
        }
        return this.timeSeries.calorieEpochs.length;
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeries
    public long getCalorieEpoch(int i) {
        TimeSeries timeSeries = this.timeSeries;
        if (timeSeries == null || timeSeries.calorieEpochs == null) {
            throwIndexOutOfBoundsException(i, 0);
        }
        return this.timeSeries.calorieEpochs[i];
    }

    @Override // com.ua.sdk.activitytimeseries.ActivityTimeSeries
    public double getCalorieValue(int i) {
        TimeSeries timeSeries = this.timeSeries;
        if (timeSeries == null || timeSeries.calorieValues == null) {
            throwIndexOutOfBoundsException(i, 0);
        }
        return this.timeSeries.calorieValues[i];
    }

    static IndexOutOfBoundsException throwIndexOutOfBoundsException(int i, int i2) {
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + i2);
    }

    public static class TimeSeries implements Parcelable {
        public static final Parcelable.Creator<TimeSeries> CREATOR = new Parcelable.Creator<TimeSeries>() { // from class: com.ua.sdk.activitytimeseries.ActivityTimeSeriesImpl.TimeSeries.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TimeSeries createFromParcel(Parcel parcel) {
                return new TimeSeries(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TimeSeries[] newArray(int i) {
                return new TimeSeries[i];
            }
        };
        long[] calorieEpochs;
        double[] calorieValues;
        long[] distanceEpochs;
        double[] distanceValues;
        long[] stepEpochs;
        int[] stepValues;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLongArray(this.stepEpochs);
            parcel.writeIntArray(this.stepValues);
            parcel.writeLongArray(this.distanceEpochs);
            parcel.writeDoubleArray(this.distanceValues);
            parcel.writeLongArray(this.calorieEpochs);
            parcel.writeDoubleArray(this.calorieValues);
        }

        public TimeSeries() {
            this.stepEpochs = null;
            this.stepValues = null;
            this.distanceEpochs = null;
            this.distanceValues = null;
            this.calorieEpochs = null;
            this.calorieValues = null;
        }

        private TimeSeries(Parcel parcel) {
            this.stepEpochs = null;
            this.stepValues = null;
            this.distanceEpochs = null;
            this.distanceValues = null;
            this.calorieEpochs = null;
            this.calorieValues = null;
            this.stepEpochs = parcel.createLongArray();
            this.stepValues = parcel.createIntArray();
            this.distanceEpochs = parcel.createLongArray();
            this.distanceValues = parcel.createDoubleArray();
            this.calorieEpochs = parcel.createLongArray();
            this.calorieValues = parcel.createDoubleArray();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.recorderTypeKey);
        parcel.writeString(this.recorderIdentifier);
        parcel.writeParcelable(this.timeSeries, i);
    }

    ActivityTimeSeriesImpl(Parcel parcel) {
        this.recorderTypeKey = parcel.readString();
        this.recorderIdentifier = parcel.readString();
        this.timeSeries = (TimeSeries) parcel.readParcelable(TimeSeries.class.getClassLoader());
    }
}
