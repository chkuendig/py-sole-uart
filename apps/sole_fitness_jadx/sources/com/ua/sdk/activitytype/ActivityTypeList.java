package com.ua.sdk.activitytype;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class ActivityTypeList extends AbstractEntityList<ActivityType> {
    public static Parcelable.Creator<ActivityTypeList> CREATOR = new Parcelable.Creator<ActivityTypeList>() { // from class: com.ua.sdk.activitytype.ActivityTypeList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityTypeList createFromParcel(Parcel parcel) {
            return new ActivityTypeList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityTypeList[] newArray(int i) {
            return new ActivityTypeList[i];
        }
    };
    private static final String LIST_KEY = "activity_types";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public ActivityTypeList() {
    }

    private ActivityTypeList(Parcel parcel) {
        super(parcel);
    }
}
