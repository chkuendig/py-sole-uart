package com.ua.sdk.activitystory.object;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.activitystory.ActivityStoryHighlight;

/* loaded from: classes2.dex */
public class ActivityStoryHighlightImpl implements ActivityStoryHighlight {
    public static Parcelable.Creator<ActivityStoryHighlightImpl> CREATOR = new Parcelable.Creator<ActivityStoryHighlightImpl>() { // from class: com.ua.sdk.activitystory.object.ActivityStoryHighlightImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryHighlightImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryHighlightImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryHighlightImpl[] newArray(int i) {
            return new ActivityStoryHighlightImpl[i];
        }
    };

    @SerializedName(SDKConstants.PARAM_KEY)
    String mKey;

    @SerializedName("percentile")
    Double mPercentile;

    @SerializedName("thumbnail_url")
    String mThumbnailUrl;
    transient Number mValue;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityStoryHighlightImpl() {
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryHighlight
    public String getKey() {
        return this.mKey;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryHighlight
    public Number getValue() {
        return this.mValue;
    }

    public void setValue(Number number) {
        this.mValue = number;
    }

    public void setKey(String str) {
        this.mKey = str;
    }

    public void setPercentile(Double d) {
        this.mPercentile = d;
    }

    public void setThumbnailUrl(String str) {
        this.mThumbnailUrl = str;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryHighlight
    public Double getPercentile() {
        return this.mPercentile;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryHighlight
    public String getThumbnailUrl() {
        return this.mThumbnailUrl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mKey);
        parcel.writeValue(this.mPercentile);
        parcel.writeString(this.mThumbnailUrl);
    }

    private ActivityStoryHighlightImpl(Parcel parcel) {
        this.mKey = parcel.readString();
        this.mPercentile = (Double) parcel.readValue(Double.class.getClassLoader());
        this.mThumbnailUrl = parcel.readString();
    }
}
