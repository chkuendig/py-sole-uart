package com.ua.sdk.net.json;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.ua.sdk.UaException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class Iso8601PeriodFormat implements Parcelable {
    public static Parcelable.Creator<Iso8601PeriodFormat> CREATOR = new Parcelable.Creator<Iso8601PeriodFormat>() { // from class: com.ua.sdk.net.json.Iso8601PeriodFormat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Iso8601PeriodFormat createFromParcel(Parcel parcel) {
            return new Iso8601PeriodFormat(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Iso8601PeriodFormat[] newArray(int i) {
            return new Iso8601PeriodFormat[i];
        }
    };
    private static final String PERIOD = "P";
    final List<Duration> durations;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private Iso8601PeriodFormat(Builder builder) {
        ArrayList arrayList = new ArrayList();
        this.durations = arrayList;
        arrayList.addAll(builder.durations);
    }

    private Iso8601PeriodFormat(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.durations = arrayList;
        arrayList.addAll(parcel.readArrayList(Duration.class.getClassLoader()));
    }

    public static Iso8601PeriodFormat parse(String str) throws UaException {
        try {
            String upperCase = str.toUpperCase();
            String[] strArrSplit = upperCase.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            if (strArrSplit.length == 0 || !strArrSplit[0].equalsIgnoreCase(PERIOD) || strArrSplit.length % 2 == 0) {
                throw new UaException("Unable to parse '" + upperCase + "'");
            }
            Builder builder = new Builder();
            for (int i = 1; i < strArrSplit.length; i += 2) {
                builder.addDuration(new Duration(Integer.valueOf(strArrSplit[i]).intValue(), Interval.parse(strArrSplit[i + 1])));
            }
            return builder.build();
        } catch (Exception e) {
            throw new UaException("Unable to parse '" + str + "'", e);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.durations);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PERIOD);
        Iterator<Duration> it = this.durations.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString().toUpperCase();
    }

    static class Builder {
        final Set<Interval> intervals = Collections.synchronizedSet(EnumSet.noneOf(Interval.class));
        final List<Duration> durations = new ArrayList();

        public Builder addDuration(Duration duration) {
            if (this.intervals.add(duration.interval)) {
                this.durations.add(duration);
            }
            return this;
        }

        public Iso8601PeriodFormat build() {
            Collections.sort(this.durations, new Comparator<Duration>() { // from class: com.ua.sdk.net.json.Iso8601PeriodFormat.Builder.1
                @Override // java.util.Comparator
                public int compare(Duration duration, Duration duration2) {
                    if (duration2.interval.weight > duration.interval.weight) {
                        return 1;
                    }
                    return duration2.interval.weight == duration.interval.weight ? 0 : -1;
                }
            });
            return new Iso8601PeriodFormat(this);
        }
    }

    static class Duration implements Parcelable {
        public static Parcelable.Creator<Duration> CREATOR = new Parcelable.Creator<Duration>() { // from class: com.ua.sdk.net.json.Iso8601PeriodFormat.Duration.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Duration createFromParcel(Parcel parcel) {
                return new Duration(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Duration[] newArray(int i) {
                return new Duration[i];
            }
        };
        final int elapsed;
        final Interval interval;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Duration(int i, Interval interval) {
            this.elapsed = i;
            this.interval = interval;
        }

        private Duration(Parcel parcel) {
            this.elapsed = parcel.readInt();
            this.interval = (Interval) parcel.readValue(Interval.class.getClassLoader());
        }

        public String toString() {
            return this.elapsed + this.interval.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.elapsed);
            parcel.writeValue(this.interval);
        }
    }

    enum Interval {
        DAYS("D", 0),
        WEEKS(ExifInterface.LONGITUDE_WEST, 1),
        MONTHS("M", 2),
        YEARS("Y", 3);

        String name;
        int weight;

        Interval(String str, int i) {
            this.name = str;
            this.weight = i;
        }

        public static Interval parse(String str) throws UaException {
            for (Interval interval : values()) {
                if (interval.name.equalsIgnoreCase(str)) {
                    return interval;
                }
            }
            throw new UaException(str + " is currently not supported!");
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }
}
