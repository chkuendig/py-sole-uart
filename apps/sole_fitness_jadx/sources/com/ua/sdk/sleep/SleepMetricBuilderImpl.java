package com.ua.sdk.sleep;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.sleep.SleepMetric;
import com.ua.sdk.sleep.SleepMetricImpl;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.UUID;

/* loaded from: classes2.dex */
public class SleepMetricBuilderImpl implements SleepMetricBuilder {
    public static final Parcelable.Creator<SleepMetricBuilderImpl> CREATOR = new Parcelable.Creator<SleepMetricBuilderImpl>() { // from class: com.ua.sdk.sleep.SleepMetricBuilderImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepMetricBuilderImpl createFromParcel(Parcel parcel) {
            return new SleepMetricBuilderImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepMetricBuilderImpl[] newArray(int i) {
            return new SleepMetricBuilderImpl[i];
        }
    };
    private static final String RECORDER_DEFAULT = "client_manual_creation";
    SleepMetricImpl.Aggregates aggregates;
    int deepSleepSeconds;
    Date endDateTime;
    int lightSleepSeconds;
    String recorderTypeKey;
    String referenceKey;
    Date startDateTime;
    TimeZone startTimeZone;
    int timeAwakeSeconds;
    SleepMetricImpl.TimeSeries timeSeries;
    int timeToSleepSeconds;
    int timesAwakened;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.sleep.SleepMetricBuilder
    public SleepMetricBuilder setRecorderTypeKey(String str) {
        this.recorderTypeKey = str;
        return this;
    }

    @Override // com.ua.sdk.sleep.SleepMetricBuilder
    public SleepMetricBuilder setReferenceKey(String str) {
        this.referenceKey = str;
        return this;
    }

    @Override // com.ua.sdk.sleep.SleepMetricBuilder
    public SleepMetricBuilder setStartTimeZone(TimeZone timeZone) {
        this.startTimeZone = timeZone;
        return this;
    }

    @Override // com.ua.sdk.sleep.SleepMetricBuilder
    public SleepMetricBuilder setStartDateTime(Date date) {
        this.startDateTime = date;
        return this;
    }

    @Override // com.ua.sdk.sleep.SleepMetricBuilder
    public SleepMetricBuilder setEndDateTime(Date date) {
        this.endDateTime = date;
        return this;
    }

    @Override // com.ua.sdk.sleep.SleepMetricBuilder
    public SleepMetricBuilder setTotalTimeAwake(int i) {
        this.timeAwakeSeconds = i;
        return this;
    }

    @Override // com.ua.sdk.sleep.SleepMetricBuilder
    public SleepMetricBuilder setTotalLightSleep(int i) {
        this.lightSleepSeconds = i;
        return this;
    }

    @Override // com.ua.sdk.sleep.SleepMetricBuilder
    public SleepMetricBuilder setTotalDeepSleep(int i) {
        this.deepSleepSeconds = i;
        return this;
    }

    @Override // com.ua.sdk.sleep.SleepMetricBuilder
    public SleepMetricBuilder setTimesAwakened(int i) {
        this.timesAwakened = i;
        return this;
    }

    @Override // com.ua.sdk.sleep.SleepMetricBuilder
    public SleepMetricBuilder setTimeToSleep(int i) {
        this.timeToSleepSeconds = i;
        return this;
    }

    @Override // com.ua.sdk.sleep.SleepMetricBuilder
    public SleepMetricBuilder addEvent(long j, SleepMetric.State state) {
        if (this.timeSeries == null) {
            this.timeSeries = new SleepMetricImpl.TimeSeries();
        }
        this.timeSeries.events.add(new SleepStateEntry(j, state));
        return this;
    }

    protected void createAggregates() {
        int i;
        int i2;
        int i3;
        int i4;
        SleepMetricImpl.TimeSeries timeSeries = this.timeSeries;
        int i5 = 0;
        if (timeSeries == null || timeSeries.events.isEmpty()) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            SleepStateEntry sleepStateEntry = this.timeSeries.events.get(0);
            int size = this.timeSeries.events.size();
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            int time = 0;
            int i6 = 1;
            while (i6 < size) {
                SleepStateEntry sleepStateEntry2 = this.timeSeries.events.get(i6);
                if (i5 != 0) {
                    long j = sleepStateEntry2.epoch - sleepStateEntry.epoch;
                    int i7 = AnonymousClass2.$SwitchMap$com$ua$sdk$sleep$SleepMetric$State[sleepStateEntry.state.ordinal()];
                    if (i7 == 1) {
                        i = (int) (i + j);
                    } else if (i7 == 2) {
                        i2 = (int) (i2 + j);
                    } else if (i7 == 3) {
                        i3++;
                        i4 = (int) (i4 + j);
                    }
                } else if (sleepStateEntry2.state != SleepMetric.State.AWAKE) {
                    time = (int) (sleepStateEntry2.epoch - (this.startDateTime.getTime() / 1000));
                    i5 = 1;
                }
                i6++;
                sleepStateEntry = sleepStateEntry2;
            }
            long time2 = (this.endDateTime.getTime() / 1000) - sleepStateEntry.epoch;
            int i8 = AnonymousClass2.$SwitchMap$com$ua$sdk$sleep$SleepMetric$State[sleepStateEntry.state.ordinal()];
            if (i8 == 1) {
                i = (int) (i + time2);
            } else if (i8 == 2) {
                i2 = (int) (i2 + time2);
            } else if (i8 == 3) {
                i3++;
                i4 = (int) (i4 + time2);
            }
            i5 = time;
        }
        SleepMetricImpl.Aggregates aggregates = new SleepMetricImpl.Aggregates();
        int i9 = this.timeToSleepSeconds;
        if (i9 >= 0) {
            i5 = i9;
        }
        aggregates.timeToSleep = i5;
        int i10 = this.timesAwakened;
        if (i10 >= 0) {
            i3 = i10;
        }
        aggregates.timesAwakened = i3;
        int i11 = this.timeAwakeSeconds;
        if (i11 >= 0) {
            i4 = i11;
        }
        aggregates.totalTimeAwake = i4;
        int i12 = this.lightSleepSeconds;
        if (i12 >= 0) {
            i = i12;
        }
        aggregates.totalLightSleep = i;
        int i13 = this.deepSleepSeconds;
        if (i13 >= 0) {
            i2 = i13;
        }
        aggregates.totalDeepSleep = i2;
        aggregates.totalSleep = aggregates.totalLightSleep + aggregates.totalDeepSleep;
        this.aggregates = aggregates;
    }

    /* renamed from: com.ua.sdk.sleep.SleepMetricBuilderImpl$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$sleep$SleepMetric$State;

        static {
            int[] iArr = new int[SleepMetric.State.values().length];
            $SwitchMap$com$ua$sdk$sleep$SleepMetric$State = iArr;
            try {
                iArr[SleepMetric.State.LIGHT_SLEEP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$sleep$SleepMetric$State[SleepMetric.State.DEEP_SLEEP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ua$sdk$sleep$SleepMetric$State[SleepMetric.State.AWAKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.ua.sdk.sleep.SleepMetricBuilder
    public SleepMetricImpl build() {
        if (this.recorderTypeKey == null) {
            this.recorderTypeKey = RECORDER_DEFAULT;
        }
        if (this.referenceKey == null) {
            this.referenceKey = UUID.randomUUID().toString();
        }
        if (this.startTimeZone == null) {
            this.startTimeZone = TimeZone.getDefault();
        }
        SleepMetricImpl.TimeSeries timeSeries = this.timeSeries;
        if (timeSeries != null) {
            Collections.sort(timeSeries.events);
            if (this.startDateTime == null) {
                if (this.timeToSleepSeconds > 0) {
                    Iterator<SleepStateEntry> it = this.timeSeries.events.iterator();
                    while (it.hasNext()) {
                        SleepStateEntry next = it.next();
                        if (next.state == SleepMetric.State.LIGHT_SLEEP || next.state == SleepMetric.State.DEEP_SLEEP) {
                            this.startDateTime = new Date((next.epoch - this.timeToSleepSeconds) * 1000);
                            break;
                        }
                    }
                }
                if (this.startDateTime == null) {
                    this.startDateTime = new Date(this.timeSeries.events.get(0).epoch * 1000);
                }
            }
            if (this.endDateTime == null) {
                this.endDateTime = new Date(this.timeSeries.events.get(this.timeSeries.events.size() - 1).epoch * 1000);
            }
        } else if (this.startDateTime == null || this.endDateTime == null) {
            throw new IllegalStateException("start datetime and end datetime must be specified if no time series data is set.");
        }
        createAggregates();
        return new SleepMetricImpl(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.recorderTypeKey);
        parcel.writeString(this.referenceKey);
        parcel.writeValue(this.startDateTime);
        parcel.writeValue(this.endDateTime);
        parcel.writeSerializable(this.startTimeZone);
        parcel.writeParcelable(this.timeSeries, 0);
        parcel.writeParcelable(this.aggregates, 0);
        parcel.writeInt(this.timeAwakeSeconds);
        parcel.writeInt(this.lightSleepSeconds);
        parcel.writeInt(this.deepSleepSeconds);
        parcel.writeInt(this.timesAwakened);
        parcel.writeInt(this.timeToSleepSeconds);
    }

    public SleepMetricBuilderImpl() {
        this.timeAwakeSeconds = -1;
        this.lightSleepSeconds = -1;
        this.deepSleepSeconds = -1;
        this.timesAwakened = -1;
        this.timeToSleepSeconds = -1;
    }

    private SleepMetricBuilderImpl(Parcel parcel) {
        this.timeAwakeSeconds = -1;
        this.lightSleepSeconds = -1;
        this.deepSleepSeconds = -1;
        this.timesAwakened = -1;
        this.timeToSleepSeconds = -1;
        this.recorderTypeKey = parcel.readString();
        this.referenceKey = parcel.readString();
        this.startDateTime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.endDateTime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.startTimeZone = (TimeZone) parcel.readSerializable();
        this.timeSeries = (SleepMetricImpl.TimeSeries) parcel.readParcelable(SleepMetricImpl.TimeSeries.class.getClassLoader());
        this.aggregates = (SleepMetricImpl.Aggregates) parcel.readParcelable(SleepMetricImpl.Aggregates.class.getClassLoader());
        this.timeAwakeSeconds = parcel.readInt();
        this.lightSleepSeconds = parcel.readInt();
        this.deepSleepSeconds = parcel.readInt();
        this.timesAwakened = parcel.readInt();
        this.timeToSleepSeconds = parcel.readInt();
    }
}
