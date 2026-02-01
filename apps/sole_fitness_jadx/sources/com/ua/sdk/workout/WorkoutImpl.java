package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.UaLog;
import com.ua.sdk.activitystory.Attachment;
import com.ua.sdk.activitystory.Attachments;
import com.ua.sdk.activitystory.SocialSettings;
import com.ua.sdk.activitytype.ActivityTypeRef;
import com.ua.sdk.gear.user.UserGearRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.privacy.PrivacyHelper;
import com.ua.sdk.route.RouteRef;
import com.ua.sdk.user.User;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class WorkoutImpl extends ApiTransferObject implements Workout {
    public static final Parcelable.Creator<WorkoutImpl> CREATOR = new Parcelable.Creator<WorkoutImpl>() { // from class: com.ua.sdk.workout.WorkoutImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutImpl createFromParcel(Parcel parcel) {
            return new WorkoutImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutImpl[] newArray(int i) {
            return new WorkoutImpl[i];
        }
    };
    private static final String KEY_ACTIVITY_TYPE = "activity_type";
    private static final String KEY_PRIVACY = "privacy";
    private static final String KEY_ROUTE = "route";
    private static final String KEY_SELF = "self";
    private static final String KEY_USER = "user";
    private static final String KEY_USERGEAR = "usergear";

    @SerializedName("attachments")
    Attachments attachments;

    @SerializedName("created_datetime")
    Date createdTime;

    @SerializedName("has_time_series")
    Boolean hasTimeSeries;

    @SerializedName("is_verified")
    Boolean isVerified;

    @SerializedName("name")
    String name;

    @SerializedName("notes")
    String notes;

    @SerializedName("reference_key")
    String referenceKey;

    @SerializedName("sharing")
    SocialSettings socialSettings;

    @SerializedName("source")
    String source;

    @SerializedName("start_datetime")
    Date startTime;

    @SerializedName("time_series")
    TimeSeriesData timeSeries;

    @SerializedName("start_locale_timezone")
    TimeZone timeZone;

    @SerializedName("updated_datetime")
    Date updateTime;

    @SerializedName("aggregates")
    WorkoutAggregates workoutAggregates;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected WorkoutImpl(WorkoutBuilderImpl workoutBuilderImpl) {
        this.startTime = workoutBuilderImpl.startTime;
        this.updateTime = workoutBuilderImpl.updateTime;
        this.createdTime = workoutBuilderImpl.createdTime;
        this.name = workoutBuilderImpl.name;
        this.notes = workoutBuilderImpl.notes;
        this.timeZone = workoutBuilderImpl.timeZone;
        this.source = workoutBuilderImpl.source;
        this.referenceKey = workoutBuilderImpl.referenceKey;
        this.workoutAggregates = workoutBuilderImpl.workoutAggregates;
        this.timeSeries = workoutBuilderImpl.timeSeries;
        this.hasTimeSeries = Boolean.valueOf(workoutBuilderImpl.hasTimeSeries);
        this.socialSettings = workoutBuilderImpl.socialSettings;
        this.attachments = workoutBuilderImpl.attachments;
        if (workoutBuilderImpl.userGearEntityRef != null) {
            setLink(KEY_USERGEAR, new Link(workoutBuilderImpl.userGearEntityRef.getHref(), workoutBuilderImpl.userGearEntityRef.getId()));
        }
        if (workoutBuilderImpl.activityTypeEntityRef != null) {
            setLink(KEY_ACTIVITY_TYPE, new Link(workoutBuilderImpl.activityTypeEntityRef.getHref(), workoutBuilderImpl.activityTypeEntityRef.getId()));
        }
        if (workoutBuilderImpl.privacy != null) {
            setLink("privacy", PrivacyHelper.toLink(workoutBuilderImpl.privacy));
        }
        if (workoutBuilderImpl.workoutRef != null) {
            setLink("self", new Link(workoutBuilderImpl.workoutRef.getHref(), workoutBuilderImpl.workoutRef.getId()));
        }
        if (workoutBuilderImpl.routeRef != null) {
            setLink(KEY_ROUTE, new Link(workoutBuilderImpl.routeRef.getHref(), workoutBuilderImpl.routeRef.getId()));
        }
        if (workoutBuilderImpl.userRef != null) {
            setLink("user", new Link(workoutBuilderImpl.userRef.getHref(), workoutBuilderImpl.userRef.getId()));
        }
    }

    @Override // com.ua.sdk.workout.Workout
    public Date getStartTime() {
        return this.startTime;
    }

    @Override // com.ua.sdk.workout.Workout
    public Date getUpdatedTime() {
        return this.updateTime;
    }

    @Override // com.ua.sdk.workout.Workout
    public Date getCreatedTime() {
        return this.createdTime;
    }

    @Override // com.ua.sdk.workout.Workout
    public String getName() {
        return this.name;
    }

    @Override // com.ua.sdk.workout.Workout
    public String getNotes() {
        return this.notes;
    }

    @Override // com.ua.sdk.workout.Workout
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    @Override // com.ua.sdk.workout.Workout
    public String getSource() {
        return this.source;
    }

    @Override // com.ua.sdk.workout.Workout
    public RouteRef getRouteRef() {
        Link link = getLink(KEY_ROUTE);
        if (link == null) {
            return null;
        }
        return new RouteRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.workout.Workout
    public EntityRef<User> getUserRef() {
        Link link = getLink("user");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.workout.Workout
    public ActivityTypeRef getActivityTypeRef() {
        Link link = getLink(KEY_ACTIVITY_TYPE);
        if (link == null) {
            return null;
        }
        return ActivityTypeRef.getBuilder().setActivityTypeId(link.getId()).build();
    }

    @Override // com.ua.sdk.workout.Workout
    public String getReferenceKey() {
        return this.referenceKey;
    }

    @Override // com.ua.sdk.workout.Workout
    public Boolean hasTimeSeries() {
        return this.hasTimeSeries;
    }

    @Override // com.ua.sdk.workout.Workout
    public Boolean isVerified() {
        return this.isVerified;
    }

    @Override // com.ua.sdk.workout.Workout
    public UserGearRef getUserGearRef() {
        Link link = getLink(KEY_USERGEAR);
        if (link == null) {
            return null;
        }
        return new UserGearRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.workout.Workout
    public Privacy getPrivacy() {
        Link link = getLink("privacy");
        if (link == null) {
            return null;
        }
        try {
            return PrivacyHelper.getPrivacyFromId(Integer.parseInt(link.getId()));
        } catch (NumberFormatException e) {
            UaLog.error("Unable to get privacy", (Throwable) e);
            return null;
        }
    }

    @Override // com.ua.sdk.Resource
    public WorkoutRef getRef() {
        Link link = getLink("self");
        if (link != null) {
            return new WorkoutRef(link.getId(), this.mLocalId, link.getHref());
        }
        if (this.mLocalId == -1) {
            return new WorkoutRef((String) null);
        }
        return new WorkoutRef(null, this.mLocalId, null);
    }

    @Override // com.ua.sdk.workout.Workout
    public WorkoutAggregates getAggregates() {
        return this.workoutAggregates;
    }

    @Override // com.ua.sdk.workout.Workout
    public TimeSeriesData getTimeSeriesData() {
        return this.timeSeries;
    }

    @Override // com.ua.sdk.workout.Workout
    public SocialSettings getSocialSettings() {
        return this.socialSettings;
    }

    @Override // com.ua.sdk.workout.Workout
    public int getAttachmentCount() {
        Attachments attachments = this.attachments;
        if (attachments == null) {
            return 0;
        }
        return attachments.getCount();
    }

    @Override // com.ua.sdk.workout.Workout
    public Attachment getAttachment(int i) throws IndexOutOfBoundsException {
        Attachments attachments = this.attachments;
        if (attachments == null) {
            throw new IndexOutOfBoundsException("Workout does not have any attachments.");
        }
        return attachments.getAttachment(i);
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        Date date = this.startTime;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        Date date2 = this.updateTime;
        parcel.writeLong(date2 != null ? date2.getTime() : -1L);
        Date date3 = this.createdTime;
        parcel.writeLong(date3 != null ? date3.getTime() : -1L);
        parcel.writeString(this.name);
        parcel.writeString(this.notes);
        parcel.writeSerializable(this.timeZone);
        parcel.writeString(this.source);
        parcel.writeString(this.referenceKey);
        parcel.writeValue(this.hasTimeSeries);
        parcel.writeValue(this.isVerified);
        parcel.writeParcelable(this.workoutAggregates, i);
        parcel.writeParcelable(this.timeSeries, i);
        parcel.writeParcelable(this.socialSettings, i);
        parcel.writeParcelable(this.attachments, i);
    }

    public WorkoutImpl() {
    }

    private WorkoutImpl(Parcel parcel) {
        super(parcel);
        long j = parcel.readLong();
        this.startTime = j == -1 ? null : new Date(j);
        long j2 = parcel.readLong();
        this.updateTime = j2 == -1 ? null : new Date(j2);
        long j3 = parcel.readLong();
        this.createdTime = j3 != -1 ? new Date(j3) : null;
        this.name = parcel.readString();
        this.notes = parcel.readString();
        this.timeZone = (TimeZone) parcel.readSerializable();
        this.source = parcel.readString();
        this.referenceKey = parcel.readString();
        this.hasTimeSeries = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isVerified = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.workoutAggregates = (WorkoutAggregates) parcel.readParcelable(WorkoutAggregates.class.getClassLoader());
        this.timeSeries = (TimeSeriesData) parcel.readParcelable(TimeSeries.class.getClassLoader());
        this.socialSettings = (SocialSettings) parcel.readParcelable(SocialSettings.class.getClassLoader());
        this.attachments = (Attachments) parcel.readParcelable(Attachments.class.getClassLoader());
    }
}
