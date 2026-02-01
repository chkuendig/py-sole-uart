package com.ua.sdk.activitystory;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class ActivityStoryList extends AbstractEntityList<ActivityStory> {
    public static Parcelable.Creator<ActivityStoryList> CREATOR = new Parcelable.Creator<ActivityStoryList>() { // from class: com.ua.sdk.activitystory.ActivityStoryList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryList createFromParcel(Parcel parcel) {
            return new ActivityStoryList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryList[] newArray(int i) {
            return new ActivityStoryList[i];
        }
    };
    private static final String LIST_KEY = "activity_stories";

    @Override // com.ua.sdk.internal.AbstractEntityList, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    @Override // com.ua.sdk.internal.AbstractEntityList, com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public ActivityStoryList() {
    }

    private ActivityStoryList(Parcel parcel) {
        super(parcel);
    }
}
