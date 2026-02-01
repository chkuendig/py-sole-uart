package com.ua.sdk.actigraphy;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class ActigraphyList extends AbstractEntityList<Actigraphy> {
    public static Parcelable.Creator<ActigraphyList> CREATOR = new Parcelable.Creator<ActigraphyList>() { // from class: com.ua.sdk.actigraphy.ActigraphyList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphyList createFromParcel(Parcel parcel) {
            return new ActigraphyList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphyList[] newArray(int i) {
            return new ActigraphyList[i];
        }
    };
    private static final String LIST_KEY = "actigraphies";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return "actigraphies";
    }

    public ActigraphyList() {
    }

    private ActigraphyList(Parcel parcel) {
        super(parcel);
    }
}
