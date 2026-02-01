package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.workout.BaseTimeSeriesEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class TimeSeriesImpl<T extends BaseTimeSeriesEntry> implements TimeSeries<T> {
    public static final Parcelable.Creator<TimeSeriesImpl> CREATOR = new Parcelable.Creator<TimeSeriesImpl>() { // from class: com.ua.sdk.workout.TimeSeriesImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimeSeriesImpl createFromParcel(Parcel parcel) {
            return new TimeSeriesImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimeSeriesImpl[] newArray(int i) {
            return new TimeSeriesImpl[i];
        }
    };
    List<T> arrayList;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TimeSeriesImpl() {
        this.arrayList = new ArrayList();
    }

    protected TimeSeriesImpl(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    public void add(T t) {
        this.arrayList.add(t);
    }

    public void sort() {
        Collections.sort(this.arrayList);
    }

    @Override // com.ua.sdk.workout.TimeSeries
    public T get(int i) {
        return this.arrayList.get(i);
    }

    @Override // com.ua.sdk.workout.TimeSeries
    public int getSize() {
        return this.arrayList.size();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int index;

        private MyIterator() {
            this.index = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < TimeSeriesImpl.this.getSize();
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.index < TimeSeriesImpl.this.getSize()) {
                T t = TimeSeriesImpl.this.arrayList.get(this.index);
                this.index++;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.arrayList);
    }

    protected TimeSeriesImpl(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.arrayList = arrayList;
        parcel.readList(arrayList, BaseTimeSeriesEntry.class.getClassLoader());
    }
}
