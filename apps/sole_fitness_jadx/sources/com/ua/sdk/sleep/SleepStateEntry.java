package com.ua.sdk.sleep;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.sleep.SleepMetric;

/* loaded from: classes2.dex */
public class SleepStateEntry implements Comparable<SleepStateEntry>, Parcelable {
    public static final Parcelable.Creator<SleepStateEntry> CREATOR = new Parcelable.Creator<SleepStateEntry>() { // from class: com.ua.sdk.sleep.SleepStateEntry.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepStateEntry createFromParcel(Parcel parcel) {
            return new SleepStateEntry(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepStateEntry[] newArray(int i) {
            return new SleepStateEntry[i];
        }
    };
    public final long epoch;
    public final SleepMetric.State state;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SleepStateEntry(long j, SleepMetric.State state) {
        this.epoch = j;
        this.state = state;
    }

    @Override // java.lang.Comparable
    public int compareTo(SleepStateEntry sleepStateEntry) {
        long j = this.epoch;
        long j2 = sleepStateEntry.epoch;
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.epoch);
        SleepMetric.State state = this.state;
        parcel.writeInt(state == null ? -1 : state.ordinal());
    }

    private SleepStateEntry(Parcel parcel) {
        this.epoch = parcel.readLong();
        int i = parcel.readInt();
        this.state = i == -1 ? null : SleepMetric.State.values()[i];
    }
}
