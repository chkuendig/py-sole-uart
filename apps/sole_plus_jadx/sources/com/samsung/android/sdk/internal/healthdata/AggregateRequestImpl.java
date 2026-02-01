package com.samsung.android.sdk.internal.healthdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class AggregateRequestImpl implements Parcelable, HealthDataResolver.AggregateRequest {
    public static final Parcelable.Creator<AggregateRequestImpl> CREATOR = new a();
    private final String a;
    private final String b;
    private final List<AggregatePair> c;
    private final List<Group> d;
    private final TimeGroup e;
    private final HealthDataResolver.Filter f;
    private final List<String> g;
    private final String h;
    private final long i;
    private final long j;
    private final String k;
    private final String l;
    private final long m;
    private final long n;

    static class a implements Parcelable.Creator<AggregateRequestImpl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public AggregateRequestImpl createFromParcel(Parcel parcel) {
            return new AggregateRequestImpl(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public AggregateRequestImpl[] newArray(int i) {
            return new AggregateRequestImpl[i];
        }
    }

    /* synthetic */ AggregateRequestImpl(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<AggregatePair> getAggregatePair() {
        return this.c;
    }

    public String getDataType() {
        return this.a;
    }

    public List<String> getDeviceUuids() {
        return this.g;
    }

    public long getEndTime() {
        return this.j;
    }

    public HealthDataResolver.Filter getFilter() {
        return this.f;
    }

    public List<Group> getGroups() {
        return this.d;
    }

    public long getLocalTimeBegin() {
        return this.m;
    }

    public long getLocalTimeEnd() {
        return this.n;
    }

    public String getLocalTimeOffsetProperty() {
        return this.l;
    }

    public String getLocalTimeProperty() {
        return this.k;
    }

    public String getPackageName() {
        return this.b;
    }

    public String getSortOrder() {
        return this.h;
    }

    public long getStartTime() {
        return this.i;
    }

    public TimeGroup getTimeGroup() {
        return this.e;
    }

    public boolean isEmpty() {
        return this.f == null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeTypedList(this.c);
        parcel.writeTypedList(this.d);
        parcel.writeParcelable(this.e, 0);
        parcel.writeParcelable(this.f, 0);
        parcel.writeStringList(this.g);
        parcel.writeString(this.h);
        parcel.writeLong(this.i);
        parcel.writeLong(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeLong(this.m);
        parcel.writeLong(this.n);
    }

    public AggregateRequestImpl(String str, String str2, List<AggregatePair> list, List<Group> list2, TimeGroup timeGroup, HealthDataResolver.Filter filter, List<String> list3, String str3, long j, long j2, String str4, String str5, Long l, Long l2) {
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = list2;
        this.e = timeGroup;
        this.f = filter;
        this.g = list3;
        this.h = str3;
        this.i = j;
        this.j = j2;
        this.k = str4;
        this.l = str5;
        this.m = l.longValue();
        this.n = l2.longValue();
    }

    public static class Group implements Parcelable {
        public static final Parcelable.Creator<Group> CREATOR = new a();
        final String a;
        final String b;

        static class a implements Parcelable.Creator<Group> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public Group createFromParcel(Parcel parcel) {
                return new Group(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Group[] newArray(int i) {
                return new Group[i];
            }
        }

        public Group(String str, String str2) {
            if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("Insufficient arguments for group");
            }
            this.a = str;
            this.b = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAlias() {
            return this.b;
        }

        public String getProperty() {
            return this.a;
        }

        public String toString() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
        }

        public Group(Parcel parcel) {
            this.a = parcel.readString();
            this.b = parcel.readString();
        }
    }

    public static class AggregatePair implements Parcelable {
        public static final Parcelable.Creator<AggregatePair> CREATOR = new a();
        final int a;
        final String b;
        final String c;

        static class a implements Parcelable.Creator<AggregatePair> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public AggregatePair createFromParcel(Parcel parcel) {
                return new AggregatePair(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public AggregatePair[] newArray(int i) {
                return new AggregatePair[i];
            }
        }

        public AggregatePair(HealthDataResolver.AggregateRequest.AggregateFunction aggregateFunction, String str, String str2) {
            if (aggregateFunction == null || str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("Insufficient arguments for aggregate function");
            }
            this.a = aggregateFunction.getValue();
            this.b = str;
            this.c = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getAggNum() {
            return this.a;
        }

        public String getAlias() {
            return this.c;
        }

        public String getField() {
            return this.b;
        }

        public String toString() {
            return HealthDataResolver.AggregateRequest.AggregateFunction.from(this.a).toSqlLiteral() + '(' + this.b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
        }

        public AggregatePair(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readString();
            this.c = parcel.readString();
        }
    }

    private AggregateRequestImpl(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.createTypedArrayList(AggregatePair.CREATOR);
        this.d = parcel.createTypedArrayList(Group.CREATOR);
        this.e = (TimeGroup) parcel.readParcelable(TimeGroup.class.getClassLoader());
        this.f = (HealthDataResolver.Filter) parcel.readParcelable(HealthDataResolver.Filter.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        parcel.readStringList(arrayList);
        this.h = parcel.readString();
        this.i = parcel.readLong();
        this.j = parcel.readLong();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readLong();
        this.n = parcel.readLong();
    }

    public static class TimeGroup implements Parcelable {
        public static final Parcelable.Creator<TimeGroup> CREATOR = new a();
        final int a;
        final int b;
        final String c;
        final String d;
        final String e;

        static class a implements Parcelable.Creator<TimeGroup> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public TimeGroup createFromParcel(Parcel parcel) {
                return new TimeGroup(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public TimeGroup[] newArray(int i) {
                return new TimeGroup[i];
            }
        }

        public TimeGroup(HealthDataResolver.AggregateRequest.TimeGroupUnit timeGroupUnit, int i, String str, String str2, String str3) throws IllegalArgumentException {
            if (timeGroupUnit == null) {
                throw new IllegalArgumentException("Invalid timeUnit");
            }
            if (i == 0) {
                throw new IllegalArgumentException("Invalid amount");
            }
            int iOrdinal = timeGroupUnit.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal == 2 || iOrdinal == 3) {
                        if (i != 1) {
                            throw new IllegalArgumentException("Invalid amount");
                        }
                    } else {
                        if (iOrdinal != 4) {
                            throw new IllegalArgumentException("Invalid timeUnit");
                        }
                        if (i != 1 && i != 3 && i != 6) {
                            throw new IllegalArgumentException("Invalid amount");
                        }
                    }
                } else if (24 % i != 0) {
                    throw new IllegalArgumentException("Invalid amount");
                }
            } else if (60 % i != 0) {
                throw new IllegalArgumentException("Invalid amount");
            }
            if (str == null || str.isEmpty() || str3 == null || str3.isEmpty()) {
                throw new IllegalArgumentException("Insufficient arguments for time group");
            }
            this.a = timeGroupUnit.getValue();
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAlias() {
            return this.e;
        }

        public int getAmount() {
            return this.b;
        }

        public String getOffsetProperty() {
            return this.d;
        }

        public String getTimeProperty() {
            return this.c;
        }

        public int getTimeUnit() {
            return this.a;
        }

        public String toString() {
            return HealthDataResolver.AggregateRequest.TimeGroupUnit.from(this.a).toSqlLiteral(this.c, this.d, this.b);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
        }

        public TimeGroup(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
        }
    }
}
