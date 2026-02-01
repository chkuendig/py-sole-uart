package com.ua.sdk.aggregate;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class AggregateList extends AbstractEntityList<Aggregate> {
    public static Parcelable.Creator<AggregateList> CREATOR = new Parcelable.Creator<AggregateList>() { // from class: com.ua.sdk.aggregate.AggregateList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AggregateList createFromParcel(Parcel parcel) {
            return new AggregateList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AggregateList[] newArray(int i) {
            return new AggregateList[i];
        }
    };
    private static final String LIST_KEY = "aggregates";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public AggregateList() {
    }

    protected AggregateList(Parcel parcel) {
        super(parcel);
    }
}
