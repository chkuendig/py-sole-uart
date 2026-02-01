package com.ua.sdk.activitystory.actor;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.activitystory.ActivityStoryActor;

/* loaded from: classes2.dex */
public class ActivityStoryUnknownActorImpl implements ActivityStoryActor {
    public static Parcelable.Creator<ActivityStoryUnknownActorImpl> CREATOR = new Parcelable.Creator<ActivityStoryUnknownActorImpl>() { // from class: com.ua.sdk.activitystory.actor.ActivityStoryUnknownActorImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryUnknownActorImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryUnknownActorImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryUnknownActorImpl[] newArray(int i) {
            return new ActivityStoryUnknownActorImpl[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActor
    public String getId() {
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public ActivityStoryUnknownActorImpl() {
    }

    private ActivityStoryUnknownActorImpl(Parcel parcel) {
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActor
    public ActivityStoryActor.Type getType() {
        return ActivityStoryActor.Type.UNKNOWN;
    }
}
