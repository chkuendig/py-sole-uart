package com.ua.sdk.activitystory.object;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.activitystory.ActivityStoryCommentObject;
import com.ua.sdk.activitystory.ActivityStoryObject;

/* loaded from: classes2.dex */
public class ActivityStoryCommentObjectImpl implements ActivityStoryCommentObject {
    public static Parcelable.Creator<ActivityStoryCommentObjectImpl> CREATOR = new Parcelable.Creator<ActivityStoryCommentObjectImpl>() { // from class: com.ua.sdk.activitystory.object.ActivityStoryCommentObjectImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryCommentObjectImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryCommentObjectImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryCommentObjectImpl[] newArray(int i) {
            return new ActivityStoryCommentObjectImpl[i];
        }
    };

    @SerializedName("text")
    String mText;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityStoryCommentObjectImpl(String str) {
        this.mText = str;
    }

    public ActivityStoryCommentObjectImpl() {
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryCommentObject
    public String getText() {
        return this.mText;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryCommentObject, com.ua.sdk.activitystory.ActivityStoryObject
    public ActivityStoryObject.Type getType() {
        return ActivityStoryObject.Type.COMMENT;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mText);
    }

    private ActivityStoryCommentObjectImpl(Parcel parcel) {
        this.mText = parcel.readString();
    }
}
