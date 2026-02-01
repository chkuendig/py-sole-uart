package com.ua.sdk.activitystory.object;

import android.os.Parcel;
import android.os.Parcelable;
import com.dyaco.sole.database.WorkoutData;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.activitystory.ActivityStoryHighlight;
import com.ua.sdk.activitystory.ActivityStoryObject;
import com.ua.sdk.activitystory.ActivityStoryWorkoutObject;
import com.ua.sdk.activitytype.ActivityType;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.workout.WorkoutRef;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class ActivityStoryWorkoutObjectImpl extends ApiTransferObject implements ActivityStoryWorkoutObject {
    public static Parcelable.Creator<ActivityStoryWorkoutObjectImpl> CREATOR = new Parcelable.Creator<ActivityStoryWorkoutObjectImpl>() { // from class: com.ua.sdk.activitystory.object.ActivityStoryWorkoutObjectImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryWorkoutObjectImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryWorkoutObjectImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryWorkoutObjectImpl[] newArray(int i) {
            return new ActivityStoryWorkoutObjectImpl[i];
        }
    };

    @SerializedName("avg_pace")
    Double mAveragePace;

    @SerializedName(WorkoutData.AVG_SPEED)
    Double mAverageSpeed;

    @SerializedName("distance")
    Double mDistance;

    @SerializedName("duration")
    Long mDuration;

    @SerializedName("energy_burned")
    Integer mEnergyBurned;

    @SerializedName("highlights")
    List<ActivityStoryHighlight> mHighlights;

    @SerializedName("notes")
    String mNotes;

    @SerializedName(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)
    Privacy mPrivacy;

    @SerializedName(BaseDataTypes.ID_STEPS)
    Integer mSteps;

    @SerializedName("title")
    String mTitle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryWorkoutObject
    public EntityRef<ActivityType> getActivityTypeRef() {
        return null;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryWorkoutObject
    public Double getDistance() {
        return this.mDistance;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryWorkoutObject
    public Double getAveragePace() {
        return this.mAveragePace;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryWorkoutObject
    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryWorkoutObject
    public List<ActivityStoryHighlight> getHighlights() {
        List<ActivityStoryHighlight> list = this.mHighlights;
        return list == null ? Collections.emptyList() : list;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryWorkoutObject
    public String getNotes() {
        return this.mNotes;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryWorkoutObject
    public Privacy getPrivacy() {
        return this.mPrivacy;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryWorkoutObject
    public Integer getSteps() {
        return this.mSteps;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryWorkoutObject
    public Double getAverageSpeed() {
        return this.mAverageSpeed;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryWorkoutObject
    public long getDuration() {
        Long l = this.mDuration;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryWorkoutObject
    public Integer getEnergyBurned() {
        return this.mEnergyBurned;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryWorkoutObject
    public WorkoutRef getWorkoutRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new WorkoutRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryWorkoutObject, com.ua.sdk.activitystory.ActivityStoryObject
    public ActivityStoryObject.Type getType() {
        return ActivityStoryObject.Type.WORKOUT;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.mDistance);
        parcel.writeValue(this.mAveragePace);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mNotes);
        parcel.writeParcelable(this.mPrivacy, i);
        parcel.writeValue(this.mSteps);
        parcel.writeValue(this.mAverageSpeed);
        parcel.writeValue(this.mEnergyBurned);
        parcel.writeValue(this.mDuration);
        parcel.writeList(this.mHighlights);
    }

    public ActivityStoryWorkoutObjectImpl() {
    }

    public ActivityStoryWorkoutObjectImpl(String str) {
        this.mNotes = str;
    }

    private ActivityStoryWorkoutObjectImpl(Parcel parcel) {
        super(parcel);
        this.mDistance = (Double) parcel.readValue(Double.class.getClassLoader());
        this.mAveragePace = (Double) parcel.readValue(Double.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mNotes = parcel.readString();
        this.mPrivacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.mSteps = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.mAverageSpeed = (Double) parcel.readValue(Double.class.getClassLoader());
        this.mEnergyBurned = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.mDuration = (Long) parcel.readValue(Long.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.mHighlights = arrayList;
        parcel.readList(arrayList, ActivityStoryHighlightImpl.class.getClassLoader());
        if (this.mHighlights.isEmpty()) {
            this.mHighlights = null;
        }
    }
}
