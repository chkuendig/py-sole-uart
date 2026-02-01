package com.ua.sdk.activitystory.object;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.activitystory.ActivityStoryGroupLeaderboard;
import com.ua.sdk.activitystory.ActivityStoryGroupLeaderboardObject;
import com.ua.sdk.activitystory.ActivityStoryObject;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class ActivityStoryGroupLeaderboardObjectImpl extends ApiTransferObject implements ActivityStoryGroupLeaderboardObject {
    public static Parcelable.Creator<ActivityStoryGroupLeaderboardObjectImpl> CREATOR = new Parcelable.Creator<ActivityStoryGroupLeaderboardObjectImpl>() { // from class: com.ua.sdk.activitystory.object.ActivityStoryGroupLeaderboardObjectImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryGroupLeaderboardObjectImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryGroupLeaderboardObjectImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryGroupLeaderboardObjectImpl[] newArray(int i) {
            return new ActivityStoryGroupLeaderboardObjectImpl[i];
        }
    };

    @SerializedName("end_time")
    private Date endTime;

    @SerializedName("leaderboard")
    private List<ActivityStoryGroupLeaderboard> leaderboard;

    @SerializedName("result")
    private ActivityStoryGroupLeaderboard result;

    @SerializedName("start_time")
    private Date startTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityStoryGroupLeaderboardObjectImpl() {
        this.leaderboard = new ArrayList(10);
    }

    private ActivityStoryGroupLeaderboardObjectImpl(Parcel parcel) {
        super(parcel);
        this.leaderboard = new ArrayList(10);
        this.startTime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.endTime = (Date) parcel.readValue(Date.class.getClassLoader());
        parcel.readList(this.leaderboard, ActivityStoryGroupLeaderboard.class.getClassLoader());
        this.result = (ActivityStoryGroupLeaderboard) parcel.readValue(ActivityStoryGroupLeaderboard.class.getClassLoader());
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupLeaderboardObject
    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date date) {
        this.startTime = date;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupLeaderboardObject
    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date date) {
        this.endTime = date;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupLeaderboardObject
    public List<ActivityStoryGroupLeaderboard> getLeaderboard() {
        return this.leaderboard;
    }

    public void setLeaderboard(List<ActivityStoryGroupLeaderboard> list) {
        this.leaderboard.clear();
        this.leaderboard.addAll(list);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupLeaderboardObject
    public ActivityStoryGroupLeaderboard getResult() {
        return this.result;
    }

    public void setResult(ActivityStoryGroupLeaderboard activityStoryGroupLeaderboard) {
        this.result = activityStoryGroupLeaderboard;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryObject
    public ActivityStoryObject.Type getType() {
        return ActivityStoryObject.Type.GROUP_LEADERBOARD;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.startTime);
        parcel.writeValue(this.endTime);
        parcel.writeList(this.leaderboard);
        parcel.writeValue(this.result);
    }
}
