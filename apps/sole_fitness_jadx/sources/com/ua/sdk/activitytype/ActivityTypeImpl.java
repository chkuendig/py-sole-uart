package com.ua.sdk.activitytype;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class ActivityTypeImpl extends ApiTransferObject implements ActivityType, Parcelable {
    public static Parcelable.Creator<ActivityTypeImpl> CREATOR = new Parcelable.Creator<ActivityTypeImpl>() { // from class: com.ua.sdk.activitytype.ActivityTypeImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityTypeImpl createFromParcel(Parcel parcel) {
            return new ActivityTypeImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityTypeImpl[] newArray(int i) {
            return new ActivityTypeImpl[i];
        }
    };
    protected static final String REF_ICON_URL = "icon_url";
    protected static final String REF_ROOT = "root";
    private Date mAccessed;
    private String mActivityId;
    private Boolean mHasChildren;
    private Double mMets;
    private String mMetsSpeed;
    private String mName;
    private String mParentActivityId;
    private String mShortName;
    private transient List<WorkoutMetsSpeed> mSpeedList;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected ActivityTypeImpl() {
    }

    protected ActivityTypeImpl(String str, String str2, String str3, String str4, Double d, String str5, Boolean bool, Date date) {
        this.mActivityId = str;
        this.mParentActivityId = str2;
        this.mName = str3;
        this.mShortName = str4;
        this.mMets = d != null ? Double.valueOf(d.doubleValue()) : null;
        this.mMetsSpeed = str5;
        this.mHasChildren = bool;
        this.mAccessed = date != null ? new Date(date.getTime()) : null;
    }

    @Override // com.ua.sdk.Resource
    public ActivityTypeRef getRef() {
        Link link = getLink("self");
        String id = link != null ? link.getId() : null;
        if (id == null) {
            return null;
        }
        return ActivityTypeRef.getBuilder().setActivityTypeId(id).setLocalId(this.mLocalId).build();
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public String getActivityId() {
        return this.mActivityId;
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public String getParentActivityId() {
        return this.mParentActivityId;
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public String getRootActivityId() {
        Link link = getLink(REF_ROOT);
        if (link == null) {
            return null;
        }
        return link.getId();
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public String getName() {
        return this.mName;
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public String getShortName() {
        return this.mShortName;
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public Boolean getHasChildren() {
        return this.mHasChildren;
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public boolean hasChildren() {
        Boolean bool = this.mHasChildren;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public Date getAccessedDate() {
        if (this.mAccessed != null) {
            return new Date(this.mAccessed.getTime());
        }
        return null;
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public Boolean canCalculateCalories() {
        Double d = this.mMets;
        if ((d != null && d.doubleValue() > 0.0d) || getSpeedList().size() > 0) {
            return true;
        }
        return false;
    }

    public List<WorkoutMetsSpeed> getSpeedList() {
        if (this.mSpeedList == null) {
            this.mSpeedList = WorkoutMetsSpeed.parseSpeedList(this.mMetsSpeed);
        }
        return this.mSpeedList;
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public Double getMetsValue() {
        Double d = this.mMets;
        if (d != null) {
            return Double.valueOf(d.doubleValue());
        }
        return null;
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public String getMetsSpeed() {
        return this.mMetsSpeed;
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public String getIconUrl() {
        return getLinkHelper(REF_ICON_URL);
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public String getParentUrl() {
        return getLinkHelper("parent");
    }

    @Override // com.ua.sdk.activitytype.ActivityType
    public String getRootUrl() {
        return getLinkHelper(REF_ROOT);
    }

    private String getLinkHelper(String str) {
        Link link = getLink(str);
        if (link == null) {
            return null;
        }
        return link.getHref();
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mActivityId);
        parcel.writeString(this.mParentActivityId);
        Date date = this.mAccessed;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        parcel.writeString(this.mName);
        parcel.writeString(this.mShortName);
        parcel.writeValue(this.mMets);
        parcel.writeString(this.mMetsSpeed);
        parcel.writeValue(this.mHasChildren);
    }

    private ActivityTypeImpl(Parcel parcel) {
        super(parcel);
        this.mActivityId = parcel.readString();
        this.mParentActivityId = parcel.readString();
        long j = parcel.readLong();
        this.mAccessed = j == -1 ? null : new Date(j);
        this.mName = parcel.readString();
        this.mShortName = parcel.readString();
        this.mMets = (Double) parcel.readValue(Double.class.getClassLoader());
        this.mMetsSpeed = parcel.readString();
        this.mHasChildren = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }
}
