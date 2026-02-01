package com.ua.sdk.activitystory.object;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.activitystory.ActivityStoryActigraphyObject;
import com.ua.sdk.activitystory.ActivityStoryHighlight;
import com.ua.sdk.activitystory.ActivityStoryObject;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.privacy.Privacy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class ActivityStoryActigraphyObjectImpl extends ApiTransferObject implements ActivityStoryActigraphyObject {
    public static Parcelable.Creator<ActivityStoryActigraphyObjectImpl> CREATOR = new Parcelable.Creator<ActivityStoryActigraphyObjectImpl>() { // from class: com.ua.sdk.activitystory.object.ActivityStoryActigraphyObjectImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryActigraphyObjectImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryActigraphyObjectImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryActigraphyObjectImpl[] newArray(int i) {
            return new ActivityStoryActigraphyObjectImpl[i];
        }
    };

    @SerializedName("end_time")
    Date mEndTime;

    @SerializedName("highlights")
    List<ActivityStoryHighlight> mHighlights;

    @SerializedName(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)
    Privacy mPrivacy;

    @SerializedName("published")
    Date mPublishedTime;

    @SerializedName("start_time")
    Date mStartTime;

    @SerializedName(BaseDataTypes.ID_STEPS)
    Integer mSteps;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActigraphyObject
    public Privacy getPrivacy() {
        return this.mPrivacy;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActigraphyObject
    public List<ActivityStoryHighlight> getHighlights() {
        List<ActivityStoryHighlight> list = this.mHighlights;
        return list == null ? Collections.emptyList() : list;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActigraphyObject
    public Date getStartTime() {
        return this.mStartTime;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActigraphyObject
    public Date getEndTime() {
        return this.mEndTime;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActigraphyObject
    public Integer getSteps() {
        return this.mSteps;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActigraphyObject
    public Date getPublishedTime() {
        return this.mPublishedTime;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActigraphyObject, com.ua.sdk.activitystory.ActivityStoryObject
    public ActivityStoryObject.Type getType() {
        return ActivityStoryObject.Type.ACTIGRAPHY;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mPrivacy, i);
        Date date = this.mStartTime;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        Date date2 = this.mEndTime;
        parcel.writeLong(date2 != null ? date2.getTime() : -1L);
        Date date3 = this.mPublishedTime;
        parcel.writeLong(date3 != null ? date3.getTime() : -1L);
        parcel.writeValue(this.mSteps);
        parcel.writeList(this.mHighlights);
    }

    public ActivityStoryActigraphyObjectImpl() {
    }

    private ActivityStoryActigraphyObjectImpl(Parcel parcel) {
        super(parcel);
        this.mPrivacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        long j = parcel.readLong();
        this.mStartTime = j == -1 ? null : new Date(j);
        long j2 = parcel.readLong();
        this.mEndTime = j2 == -1 ? null : new Date(j2);
        long j3 = parcel.readLong();
        this.mPublishedTime = j3 == -1 ? null : new Date(j3);
        this.mSteps = (Integer) parcel.readValue(Integer.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.mHighlights = arrayList;
        parcel.readList(arrayList, ActivityStoryHighlightImpl.class.getClassLoader());
        if (this.mHighlights.isEmpty()) {
            this.mHighlights = null;
        }
    }
}
