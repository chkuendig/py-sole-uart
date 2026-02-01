package com.ua.sdk.activitystory.actor;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.activitystory.ActivityStoryActor;

/* loaded from: classes2.dex */
public class ActivityStoryBrandActorImpl implements ActivityStoryActor {
    public static Parcelable.Creator<ActivityStoryBrandActorImpl> CREATOR = new Parcelable.Creator<ActivityStoryBrandActorImpl>() { // from class: com.ua.sdk.activitystory.actor.ActivityStoryBrandActorImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryBrandActorImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryBrandActorImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryBrandActorImpl[] newArray(int i) {
            return new ActivityStoryBrandActorImpl[i];
        }
    };

    @SerializedName("id")
    String mId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActor
    public ActivityStoryActor.Type getType() {
        return ActivityStoryActor.Type.BRAND;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActor
    public String getId() {
        return this.mId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
    }

    public ActivityStoryBrandActorImpl() {
    }

    private ActivityStoryBrandActorImpl(Parcel parcel) {
        this.mId = parcel.readString();
    }
}
