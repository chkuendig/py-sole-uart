package com.ua.sdk.activitystory;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class ActivityStoryGroupLeaderboardImpl implements ActivityStoryGroupLeaderboard {
    public static Parcelable.Creator<ActivityStoryGroupLeaderboardImpl> CREATOR = new Parcelable.Creator<ActivityStoryGroupLeaderboardImpl>() { // from class: com.ua.sdk.activitystory.ActivityStoryGroupLeaderboardImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryGroupLeaderboardImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryGroupLeaderboardImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryGroupLeaderboardImpl[] newArray(int i) {
            return new ActivityStoryGroupLeaderboardImpl[i];
        }
    };

    @SerializedName("rank")
    int rank;

    @SerializedName("user_id")
    long userId;

    @SerializedName("value")
    Object value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityStoryGroupLeaderboardImpl() {
    }

    private ActivityStoryGroupLeaderboardImpl(Parcel parcel) {
        this.value = parcel.readValue(Object.class.getClassLoader());
        this.userId = parcel.readLong();
        this.rank = parcel.readInt();
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupLeaderboard
    public Double getValueDouble() {
        Object obj = this.value;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Long) {
            return Double.valueOf(((Long) obj).doubleValue());
        }
        return null;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupLeaderboard
    public Long getValueLong() {
        Object obj = this.value;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Double) {
            return Long.valueOf(((Double) obj).longValue());
        }
        return null;
    }

    public void addValue(Object obj) {
        this.value = obj;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupLeaderboard
    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupLeaderboard
    public int getRank() {
        return this.rank;
    }

    public void setRank(int i) {
        this.rank = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.value);
        parcel.writeLong(this.userId);
        parcel.writeInt(this.rank);
    }
}
