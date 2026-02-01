package com.ua.sdk.activitystory;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class ActivityStoryRepostSummaryImpl implements ActivityStoryRepostSummary {
    public static Parcelable.Creator<ActivityStoryRepostSummaryImpl> CREATOR = new Parcelable.Creator<ActivityStoryRepostSummaryImpl>() { // from class: com.ua.sdk.activitystory.ActivityStoryRepostSummaryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryRepostSummaryImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryRepostSummaryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryRepostSummaryImpl[] newArray(int i) {
            return new ActivityStoryRepostSummaryImpl[i];
        }
    };

    @SerializedName(FirebaseAnalytics.Param.ITEMS)
    ArrayList<ActivityStory> mItems;

    @SerializedName("reposted")
    Boolean mReposted;

    @SerializedName("count")
    Integer mTotalCount;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryRepostSummary
    public int getTotalCount() {
        Integer num = this.mTotalCount;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryRepostSummary
    public boolean isReposted() {
        Boolean bool = this.mReposted;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryRepostSummary
    public List<ActivityStory> getItems() {
        ArrayList<ActivityStory> arrayList = this.mItems;
        if (arrayList == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.mTotalCount);
        parcel.writeValue(this.mReposted);
        parcel.writeList(this.mItems);
    }

    public ActivityStoryRepostSummaryImpl() {
    }

    private ActivityStoryRepostSummaryImpl(Parcel parcel) {
        this.mTotalCount = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.mReposted = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        ArrayList<ActivityStory> arrayList = new ArrayList<>(5);
        this.mItems = arrayList;
        parcel.readList(arrayList, ActivityStory.class.getClassLoader());
        if (this.mItems.isEmpty()) {
            this.mItems = null;
        }
    }
}
