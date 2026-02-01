package com.ua.sdk.activitystory.object;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.activitystory.ActivityStoryHighlight;
import com.ua.sdk.activitystory.ActivityStoryObject;
import com.ua.sdk.activitystory.ActivityStoryRouteObject;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.location.Location;
import com.ua.sdk.privacy.Privacy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class ActivityStoryRouteObjectImpl extends ApiTransferObject implements ActivityStoryRouteObject, Parcelable {
    public static Parcelable.Creator<ActivityStoryRouteObjectImpl> CREATOR = new Parcelable.Creator<ActivityStoryRouteObjectImpl>() { // from class: com.ua.sdk.activitystory.object.ActivityStoryRouteObjectImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryRouteObjectImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryRouteObjectImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryRouteObjectImpl[] newArray(int i) {
            return new ActivityStoryRouteObjectImpl[i];
        }
    };

    @SerializedName("distance")
    private Double mDistance;

    @SerializedName("highlights")
    private List<ActivityStoryHighlight> mHighlights;

    @SerializedName("location")
    private Location mLocation;

    @SerializedName(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)
    private Privacy mPrivacy;

    @SerializedName("title")
    private String mTitle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityStoryRouteObjectImpl() {
    }

    public void setDistance(Double d) {
        this.mDistance = d;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setPrivacy(Privacy privacy) {
        this.mPrivacy = privacy;
    }

    public void setHighlights(List<ActivityStoryHighlight> list) {
        this.mHighlights = list;
    }

    public void setLocation(Location location) {
        this.mLocation = location;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryRouteObject
    public Double getDistance() {
        return this.mDistance;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryRouteObject
    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryRouteObject
    public Privacy getPrivacy() {
        return this.mPrivacy;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryRouteObject
    public List<ActivityStoryHighlight> getHighlights() {
        List<ActivityStoryHighlight> list = this.mHighlights;
        return list == null ? Collections.emptyList() : list;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryRouteObject
    public Location getLocation() {
        return this.mLocation;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryRouteObject, com.ua.sdk.activitystory.ActivityStoryObject
    public ActivityStoryObject.Type getType() {
        return ActivityStoryObject.Type.ROUTE;
    }

    public String getRouteId() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return link.getId();
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.mDistance);
        parcel.writeString(this.mTitle);
        parcel.writeParcelable(this.mPrivacy, i);
        parcel.writeList(this.mHighlights);
        parcel.writeParcelable(this.mLocation, 0);
    }

    private ActivityStoryRouteObjectImpl(Parcel parcel) {
        super(parcel);
        this.mDistance = (Double) parcel.readValue(Double.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mPrivacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.mHighlights = arrayList;
        parcel.readList(arrayList, ActivityStoryHighlightImpl.class.getClassLoader());
        if (this.mHighlights.isEmpty()) {
            this.mHighlights = null;
        }
        this.mLocation = (Location) parcel.readParcelable(Location.class.getClassLoader());
    }
}
