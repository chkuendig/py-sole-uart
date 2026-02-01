package com.ua.sdk.bodymass;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class BodyMassList extends AbstractEntityList<BodyMass> {
    public static Parcelable.Creator<BodyMassList> CREATOR = new Parcelable.Creator<BodyMassList>() { // from class: com.ua.sdk.bodymass.BodyMassList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BodyMassList createFromParcel(Parcel parcel) {
            return new BodyMassList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BodyMassList[] newArray(int i) {
            return new BodyMassList[i];
        }
    };
    private static final String LIST_KEY = "bodymasses";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public BodyMassList() {
    }

    private BodyMassList(Parcel parcel) {
        super(parcel);
    }
}
