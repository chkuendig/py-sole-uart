package com.ua.sdk.activitystory.object;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.activitystory.ActivityStoryObject;
import com.ua.sdk.activitystory.ActivityStoryStatusObject;
import com.ua.sdk.privacy.Privacy;

/* loaded from: classes2.dex */
public class ActivityStoryStatusObjectImpl implements ActivityStoryStatusObject {
    public static Parcelable.Creator<ActivityStoryStatusObjectImpl> CREATOR = new Parcelable.Creator<ActivityStoryStatusObjectImpl>() { // from class: com.ua.sdk.activitystory.object.ActivityStoryStatusObjectImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryStatusObjectImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryStatusObjectImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryStatusObjectImpl[] newArray(int i) {
            return new ActivityStoryStatusObjectImpl[i];
        }
    };

    @SerializedName(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)
    Privacy mPrivacy;

    @SerializedName("text")
    String mText;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityStoryStatusObjectImpl(String str, Privacy privacy) {
        this.mText = str;
        this.mPrivacy = privacy;
    }

    public ActivityStoryStatusObjectImpl() {
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryStatusObject
    public String getText() {
        return this.mText;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryStatusObject
    public Privacy getPrivacy() {
        return this.mPrivacy;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryStatusObject, com.ua.sdk.activitystory.ActivityStoryObject
    public ActivityStoryObject.Type getType() {
        return ActivityStoryObject.Type.STATUS;
    }

    public void setPrivacy(Privacy privacy) {
        this.mPrivacy = privacy;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mText);
        parcel.writeParcelable(this.mPrivacy, i);
    }

    protected ActivityStoryStatusObjectImpl(Parcel parcel) {
        this.mText = parcel.readString();
        this.mPrivacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
    }
}
