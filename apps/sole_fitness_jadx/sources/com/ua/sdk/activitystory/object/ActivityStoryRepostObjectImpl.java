package com.ua.sdk.activitystory.object;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.activitystory.ActivityStory;
import com.ua.sdk.activitystory.ActivityStoryObject;
import com.ua.sdk.activitystory.ActivityStoryRepostObject;
import com.ua.sdk.privacy.Privacy;

/* loaded from: classes2.dex */
public class ActivityStoryRepostObjectImpl extends ActivityStoryStatusObjectImpl implements ActivityStoryRepostObject {
    public static Parcelable.Creator<ActivityStoryRepostObjectImpl> CREATOR = new Parcelable.Creator<ActivityStoryRepostObjectImpl>() { // from class: com.ua.sdk.activitystory.object.ActivityStoryRepostObjectImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryRepostObjectImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryRepostObjectImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryRepostObjectImpl[] newArray(int i) {
            return new ActivityStoryRepostObjectImpl[i];
        }
    };

    @SerializedName("id")
    String mId;

    @SerializedName("story")
    ActivityStory originalStory;

    public ActivityStoryRepostObjectImpl() {
    }

    public ActivityStoryRepostObjectImpl(String str, String str2, Privacy privacy) {
        super(str2, privacy);
        this.mId = str;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryRepostObject
    public String getId() {
        return this.mId;
    }

    @Override // com.ua.sdk.activitystory.object.ActivityStoryStatusObjectImpl, com.ua.sdk.activitystory.ActivityStoryStatusObject, com.ua.sdk.activitystory.ActivityStoryObject
    public ActivityStoryObject.Type getType() {
        return ActivityStoryObject.Type.REPOST;
    }

    public ActivityStory getOriginalStory() {
        return this.originalStory;
    }

    public void setOriginalStory(ActivityStory activityStory) {
        this.originalStory = activityStory;
    }

    @Override // com.ua.sdk.activitystory.object.ActivityStoryStatusObjectImpl, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mId);
        parcel.writeParcelable(this.originalStory, i);
    }

    protected ActivityStoryRepostObjectImpl(Parcel parcel) {
        super(parcel);
        this.mId = parcel.readString();
        this.originalStory = (ActivityStory) parcel.readParcelable(ActivityStory.class.getClassLoader());
    }
}
