package com.ua.sdk.activitystory.object;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.activitystory.ActivityStoryObject;
import com.ua.sdk.activitystory.ActivityStoryToutObject;

/* loaded from: classes2.dex */
public class ActivityStoryToutObjectImpl implements ActivityStoryToutObject {
    public static Parcelable.Creator<ActivityStoryToutObjectImpl> CREATOR = new Parcelable.Creator<ActivityStoryToutObjectImpl>() { // from class: com.ua.sdk.activitystory.object.ActivityStoryToutObjectImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryToutObjectImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryToutObjectImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryToutObjectImpl[] newArray(int i) {
            return new ActivityStoryToutObjectImpl[i];
        }
    };
    private final ActivityStoryToutObject.Subtype mSubtype;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityStoryToutObjectImpl(ActivityStoryToutObject.Subtype subtype) {
        this.mSubtype = subtype;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryToutObject
    public ActivityStoryToutObject.Subtype getSubtype() {
        return this.mSubtype;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryToutObject, com.ua.sdk.activitystory.ActivityStoryObject
    public ActivityStoryObject.Type getType() {
        return ActivityStoryObject.Type.TOUT;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ActivityStoryToutObject.Subtype subtype = this.mSubtype;
        parcel.writeInt(subtype == null ? -1 : subtype.ordinal());
    }

    private ActivityStoryToutObjectImpl(Parcel parcel) {
        int i = parcel.readInt();
        this.mSubtype = i == -1 ? null : ActivityStoryToutObject.Subtype.values()[i];
    }
}
