package com.ua.sdk.sleep;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.sleep.SleepMetric;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class SleepMetricImpl extends ApiTransferObject implements SleepMetric {
    public static final Parcelable.Creator<SleepMetricImpl> CREATOR = new Parcelable.Creator<SleepMetricImpl>() { // from class: com.ua.sdk.sleep.SleepMetricImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepMetricImpl createFromParcel(Parcel parcel) {
            return new SleepMetricImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepMetricImpl[] newArray(int i) {
            return new SleepMetricImpl[i];
        }
    };

    @SerializedName("aggregates")
    Aggregates aggregates;

    @SerializedName("created_datetime")
    Date createdDateTime;

    @SerializedName("end_datetime_utc")
    Date endDateTime;

    @SerializedName("recorder_type_key")
    String recordTypeKey;

    @SerializedName("reference_key")
    String referenceKey;

    @SerializedName("start_datetime_utc")
    Date startDateTime;

    @SerializedName("start_datetime_timezone")
    TimeZone startTimeZone;

    @SerializedName("time_series")
    TimeSeries timeSeries;

    @SerializedName("updated_datetime")
    Date updatedDateTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected SleepMetricImpl(SleepMetricBuilderImpl sleepMetricBuilderImpl) {
        this.recordTypeKey = sleepMetricBuilderImpl.recorderTypeKey;
        this.referenceKey = sleepMetricBuilderImpl.referenceKey;
        this.startDateTime = sleepMetricBuilderImpl.startDateTime;
        this.endDateTime = sleepMetricBuilderImpl.endDateTime;
        this.startTimeZone = sleepMetricBuilderImpl.startTimeZone;
        this.aggregates = sleepMetricBuilderImpl.aggregates;
        this.timeSeries = sleepMetricBuilderImpl.timeSeries;
    }

    @Override // com.ua.sdk.sleep.SleepMetric
    public String getRecorderTypeKey() {
        return this.recordTypeKey;
    }

    @Override // com.ua.sdk.sleep.SleepMetric
    public String getReferenceKey() {
        return this.referenceKey;
    }

    @Override // com.ua.sdk.sleep.SleepMetric
    public TimeZone getStartTimeZone() {
        return this.startTimeZone;
    }

    @Override // com.ua.sdk.sleep.SleepMetric
    public Date getStartDateTime() {
        return this.startDateTime;
    }

    @Override // com.ua.sdk.sleep.SleepMetric
    public Date getEndDateTime() {
        return this.endDateTime;
    }

    @Override // com.ua.sdk.sleep.SleepMetric
    public SleepMetric.TimeSeries getTimeSeries() {
        return this.timeSeries;
    }

    @Override // com.ua.sdk.sleep.SleepMetric
    public SleepMetric.Aggregates getAggregates() {
        return this.aggregates;
    }

    @Override // com.ua.sdk.sleep.SleepMetric
    public Date getUpdatedDateTime() {
        return this.updatedDateTime;
    }

    @Override // com.ua.sdk.sleep.SleepMetric
    public Date getCreatedDateTime() {
        return this.createdDateTime;
    }

    @Override // com.ua.sdk.Resource
    public SleepRef getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new SleepRef(link.getId(), link.getHref());
    }

    public static class TimeSeries implements SleepMetric.TimeSeries {
        public static final Parcelable.Creator<TimeSeries> CREATOR = new Parcelable.Creator<TimeSeries>() { // from class: com.ua.sdk.sleep.SleepMetricImpl.TimeSeries.1
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
        final ArrayList<SleepStateEntry> events;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public TimeSeries() {
            this.events = new ArrayList<>();
        }

        @Override // com.ua.sdk.sleep.SleepMetric.TimeSeries
        public int size() {
            return this.events.size();
        }

        @Override // com.ua.sdk.sleep.SleepMetric.TimeSeries
        public long getEpoch(int i) {
            return this.events.get(i).epoch;
        }

        @Override // com.ua.sdk.sleep.SleepMetric.TimeSeries
        public SleepMetric.State getState(int i) {
            return this.events.get(i).state;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeList(this.events);
        }

        private TimeSeries(Parcel parcel) {
            this.events = parcel.readArrayList(SleepStateEntry.class.getClassLoader());
        }
    }

    public static class Aggregates implements SleepMetric.Aggregates {
        public static final Parcelable.Creator<Aggregates> CREATOR = new Parcelable.Creator<Aggregates>() { // from class: com.ua.sdk.sleep.SleepMetricImpl.Aggregates.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Aggregates createFromParcel(Parcel parcel) {
                return new Aggregates(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Aggregates[] newArray(int i) {
                return new Aggregates[i];
            }
        };

        @SerializedName("time_to_sleep")
        int timeToSleep;

        @SerializedName("times_awakened")
        int timesAwakened;

        @SerializedName("total_deep_sleep")
        int totalDeepSleep;

        @SerializedName("total_light_sleep")
        int totalLightSleep;

        @SerializedName("total_sleep")
        int totalSleep;

        @SerializedName("total_time_awake")
        int totalTimeAwake;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.ua.sdk.sleep.SleepMetric.Aggregates
        public int getTotalTimeAwake() {
            return this.totalTimeAwake;
        }

        @Override // com.ua.sdk.sleep.SleepMetric.Aggregates
        public int getTotalLightSleep() {
            return this.totalLightSleep;
        }

        @Override // com.ua.sdk.sleep.SleepMetric.Aggregates
        public int getTotalDeepSleep() {
            return this.totalDeepSleep;
        }

        @Override // com.ua.sdk.sleep.SleepMetric.Aggregates
        public int getTotalSleep() {
            return this.totalSleep;
        }

        @Override // com.ua.sdk.sleep.SleepMetric.Aggregates
        public int getTimesAwakened() {
            return this.timesAwakened;
        }

        @Override // com.ua.sdk.sleep.SleepMetric.Aggregates
        public int getTimeToSleep() {
            return this.timeToSleep;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.timeToSleep);
            parcel.writeInt(this.totalTimeAwake);
            parcel.writeInt(this.totalLightSleep);
            parcel.writeInt(this.totalDeepSleep);
            parcel.writeInt(this.totalSleep);
            parcel.writeInt(this.timesAwakened);
        }

        public Aggregates() {
        }

        private Aggregates(Parcel parcel) {
            this.timeToSleep = parcel.readInt();
            this.totalTimeAwake = parcel.readInt();
            this.totalLightSleep = parcel.readInt();
            this.totalDeepSleep = parcel.readInt();
            this.totalSleep = parcel.readInt();
            this.timesAwakened = parcel.readInt();
        }
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.timeSeries, 0);
        parcel.writeString(this.recordTypeKey);
        parcel.writeString(this.referenceKey);
        Date date = this.startDateTime;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        Date date2 = this.endDateTime;
        parcel.writeLong(date2 != null ? date2.getTime() : -1L);
        parcel.writeSerializable(this.startTimeZone);
        parcel.writeParcelable(this.aggregates, 0);
        Date date3 = this.createdDateTime;
        parcel.writeLong(date3 != null ? date3.getTime() : -1L);
        Date date4 = this.updatedDateTime;
        parcel.writeLong(date4 != null ? date4.getTime() : -1L);
    }

    public SleepMetricImpl() {
    }

    private SleepMetricImpl(Parcel parcel) {
        this.timeSeries = (TimeSeries) parcel.readParcelable(TimeSeries.class.getClassLoader());
        this.recordTypeKey = parcel.readString();
        this.referenceKey = parcel.readString();
        long j = parcel.readLong();
        this.startDateTime = j == -1 ? null : new Date(j);
        long j2 = parcel.readLong();
        this.endDateTime = j2 == -1 ? null : new Date(j2);
        this.startTimeZone = (TimeZone) parcel.readSerializable();
        this.aggregates = (Aggregates) parcel.readParcelable(Aggregates.class.getClassLoader());
        long j3 = parcel.readLong();
        this.createdDateTime = j3 == -1 ? null : new Date(j3);
        long j4 = parcel.readLong();
        this.updatedDateTime = j4 != -1 ? new Date(j4) : null;
    }
}
