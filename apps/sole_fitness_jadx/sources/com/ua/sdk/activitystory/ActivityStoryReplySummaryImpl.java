package com.ua.sdk.activitystory;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.LinkEntityRef;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class ActivityStoryReplySummaryImpl implements ActivityStoryReplySummary {
    public static Parcelable.Creator<ActivityStoryReplySummaryImpl> CREATOR = new Parcelable.Creator<ActivityStoryReplySummaryImpl>() { // from class: com.ua.sdk.activitystory.ActivityStoryReplySummaryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryReplySummaryImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryReplySummaryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryReplySummaryImpl[] newArray(int i) {
            return new ActivityStoryReplySummaryImpl[i];
        }
    };

    @SerializedName(FirebaseAnalytics.Param.ITEMS)
    ArrayList<ActivityStory> mItems;

    @SerializedName("replied")
    Boolean mReplied;

    @SerializedName("reply_id")
    String mReplyId;

    @SerializedName("count")
    Integer mTotalCount;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryReplySummary
    public int getTotalCount() {
        Integer num = this.mTotalCount;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryReplySummary
    public boolean isReplied() {
        Boolean bool = this.mReplied;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryReplySummary
    public EntityRef<ActivityStory> getReplyRef() {
        if (this.mReplyId != null) {
            return new LinkEntityRef(this.mReplyId, null);
        }
        return null;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryReplySummary
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
        parcel.writeValue(this.mReplied);
        parcel.writeString(this.mReplyId);
        parcel.writeList(this.mItems);
    }

    public ActivityStoryReplySummaryImpl() {
    }

    private ActivityStoryReplySummaryImpl(Parcel parcel) {
        this.mTotalCount = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.mReplied = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.mReplyId = parcel.readString();
        ArrayList<ActivityStory> arrayList = new ArrayList<>(5);
        this.mItems = arrayList;
        parcel.readList(arrayList, ActivityStory.class.getClassLoader());
        if (this.mItems.isEmpty()) {
            this.mItems = null;
        }
    }
}
