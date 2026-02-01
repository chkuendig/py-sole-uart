package com.ua.sdk.activitystory.object;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.activitystory.ActivityStoryObject;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.privacy.PrivacyHelper;

/* loaded from: classes2.dex */
public class ActivityStoryPrivacyObjectImpl implements ActivityStoryObject {
    public static Parcelable.Creator<ActivityStoryPrivacyObjectImpl> CREATOR = new Parcelable.Creator<ActivityStoryPrivacyObjectImpl>() { // from class: com.ua.sdk.activitystory.object.ActivityStoryPrivacyObjectImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryPrivacyObjectImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryPrivacyObjectImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryPrivacyObjectImpl[] newArray(int i) {
            return new ActivityStoryPrivacyObjectImpl[i];
        }
    };

    @SerializedName(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)
    Privacy privacy;

    @SerializedName("type")
    ActivityStoryObject.Type type;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityStoryPrivacyObjectImpl() {
    }

    private ActivityStoryPrivacyObjectImpl(Builder builder) {
        this.type = builder.type;
        this.privacy = builder.privacy;
    }

    private ActivityStoryPrivacyObjectImpl(Parcel parcel) {
        this.type = (ActivityStoryObject.Type) parcel.readSerializable();
        this.privacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryObject
    public ActivityStoryObject.Type getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.type);
        parcel.writeParcelable(this.privacy, i);
    }

    public static class Builder {
        final Privacy privacy;
        final ActivityStoryObject.Type type;

        public Builder(ActivityStoryObject.Type type, Privacy.Level level) {
            this.type = type;
            this.privacy = PrivacyHelper.getPrivacy(level);
        }

        public ActivityStoryPrivacyObjectImpl build() {
            return new ActivityStoryPrivacyObjectImpl(this);
        }
    }
}
