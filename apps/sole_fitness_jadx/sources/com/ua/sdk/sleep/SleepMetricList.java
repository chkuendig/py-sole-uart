package com.ua.sdk.sleep;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class SleepMetricList extends AbstractEntityList<SleepMetric> {
    public static Parcelable.Creator<SleepMetricList> CREATOR = new Parcelable.Creator<SleepMetricList>() { // from class: com.ua.sdk.sleep.SleepMetricList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepMetricList createFromParcel(Parcel parcel) {
            return new SleepMetricList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepMetricList[] newArray(int i) {
            return new SleepMetricList[i];
        }
    };
    private static final String LIST_KEY = "sleeps";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public SleepMetricList() {
    }

    private SleepMetricList(Parcel parcel) {
        super(parcel);
    }
}
