package com.ua.sdk.activitystory.target;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.activitystory.ActivityStoryTarget;

/* loaded from: classes2.dex */
public class ActivityStoryUnknownTarget implements ActivityStoryTarget {
    public static Parcelable.Creator<ActivityStoryUnknownTarget> CREATOR = new Parcelable.Creator<ActivityStoryUnknownTarget>() { // from class: com.ua.sdk.activitystory.target.ActivityStoryUnknownTarget.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryUnknownTarget createFromParcel(Parcel parcel) {
            return new ActivityStoryUnknownTarget(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryUnknownTarget[] newArray(int i) {
            return new ActivityStoryUnknownTarget[i];
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

    public ActivityStoryUnknownTarget() {
    }

    private ActivityStoryUnknownTarget(Parcel parcel) {
        this.id = parcel.readString();
        this.type = (ActivityStoryTarget.Type) parcel.readValue(ActivityStoryTarget.Type.class.getClassLoader());
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTarget
    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryTarget
    public ActivityStoryTarget.Type getType() {
        return this.type;
    }

    public void setType(ActivityStoryTarget.Type type) {
        this.type = type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeValue(this.type);
    }
}
