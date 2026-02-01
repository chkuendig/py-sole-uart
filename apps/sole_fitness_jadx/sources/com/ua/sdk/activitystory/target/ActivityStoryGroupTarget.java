package com.ua.sdk.activitystory.target;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.activitystory.ActivityStoryTarget;

/* loaded from: classes2.dex */
public class ActivityStoryGroupTarget implements ActivityStoryTarget {
    public static Parcelable.Creator<ActivityStoryGroupTarget> CREATOR = new Parcelable.Creator<ActivityStoryGroupTarget>() { // from class: com.ua.sdk.activitystory.target.ActivityStoryGroupTarget.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryGroupTarget createFromParcel(Parcel parcel) {
            return new ActivityStoryGroupTarget(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryGroupTarget[] newArray(int i) {
            return new ActivityStoryGroupTarget[i];
        }
    };

    @SerializedName("id")
    String id;

    @SerializedName("type")
    ActivityStoryTarget.Type type;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTarget
    public String getId() {
        return this.id;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTarget
    public ActivityStoryTarget.Type getType() {
        return ActivityStoryTarget.Type.GROUP;
    }

    public ActivityStoryGroupTarget() {
    }

    public ActivityStoryGroupTarget(String str) {
        this.id = str;
        this.type = ActivityStoryTarget.Type.GROUP;
    }

    private ActivityStoryGroupTarget(Parcel parcel) {
        this.id = parcel.readString();
        this.type = (ActivityStoryTarget.Type) parcel.readValue(ActivityStoryTarget.Type.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeValue(this.type);
    }
}
