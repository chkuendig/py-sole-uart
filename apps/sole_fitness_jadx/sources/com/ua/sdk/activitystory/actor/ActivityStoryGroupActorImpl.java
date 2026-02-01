package com.ua.sdk.activitystory.actor;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.activitystory.ActivityStoryActor;
import com.ua.sdk.activitystory.ActivityStoryGroupActor;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datapoint.DataField;
import com.ua.sdk.datapoint.DataType;
import com.ua.sdk.group.Group;
import com.ua.sdk.group.invite.GroupInvite;
import com.ua.sdk.group.objective.Criteria;
import com.ua.sdk.group.user.GroupUser;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.internal.Period;
import com.ua.sdk.user.User;
import java.util.Date;

/* loaded from: classes2.dex */
public class ActivityStoryGroupActorImpl extends ApiTransferObject implements ActivityStoryGroupActor {
    public static final Parcelable.Creator<ActivityStoryGroupActorImpl> CREATOR = new Parcelable.Creator<ActivityStoryGroupActorImpl>() { // from class: com.ua.sdk.activitystory.actor.ActivityStoryGroupActorImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryGroupActorImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryGroupActorImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryGroupActorImpl[] newArray(int i) {
            return new ActivityStoryGroupActorImpl[i];
        }
    };
    private static final String GROUP_INVITE_LINK = "group_invites";
    private static final String GROUP_OWNER_LINK = "group_owner";
    private static final String GROUP_USER_LINK = "group_users";

    @SerializedName("criteria")
    private Criteria criteria;
    private transient DataField dataField;

    @SerializedName("data_type_field")
    private String dataFieldStr;
    private transient DataType dataType;
    private transient EntityRef<DataType> dataTypeRef;

    @SerializedName("data_type")
    private String dataTypeStr;

    @SerializedName("end_time")
    private Date endTime;
    private transient Integer groupInviteCount;
    private transient EntityRef<GroupInvite> groupInviteRef;
    private transient EntityRef<User> groupOwnerRef;
    private transient Integer groupUserCount;
    private transient EntityRef<GroupUser> groupUserRef;

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName(TypedValues.CycleType.S_WAVE_PERIOD)
    private Period period;
    private transient EntityRef<Group> selfRef;

    @SerializedName("start_time")
    private Date startTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityStoryGroupActorImpl() {
    }

    private ActivityStoryGroupActorImpl(Parcel parcel) {
        super(parcel);
        this.startTime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.endTime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.name = parcel.readString();
        this.dataTypeStr = parcel.readString();
        this.id = parcel.readString();
        this.period = (Period) parcel.readParcelable(Period.class.getClassLoader());
        this.dataFieldStr = parcel.readString();
        this.criteria = (Criteria) parcel.readValue(Criteria.class.getClassLoader());
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActor
    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date date) {
        this.startTime = date;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date date) {
        this.endTime = date;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public Period getPeriod() {
        return this.period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public DataType getDataType() {
        if (this.dataType == null && this.dataTypeStr != null) {
            this.dataType = BaseDataTypes.ALL_BASE_TYPE_MAP.get(this.dataTypeStr);
        }
        return this.dataType;
    }

    public void setDataType(DataType dataType) {
        if (dataType == null) {
            return;
        }
        DataType dataType2 = BaseDataTypes.ALL_BASE_TYPE_MAP.get(dataType.getId());
        this.dataType = dataType2;
        if (dataType2 != null) {
            this.dataTypeStr = dataType2.getId();
        }
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public DataField getDataField() {
        String str = this.dataFieldStr;
        if (str != null && this.dataField == null) {
            this.dataField = BaseDataTypes.findDataField(str, getDataType());
        }
        return this.dataField;
    }

    public void setDataField(DataField dataField) {
        if (dataField == null) {
            return;
        }
        DataField dataFieldFindDataField = BaseDataTypes.findDataField(dataField.getId(), getDataType());
        this.dataField = dataFieldFindDataField;
        if (dataFieldFindDataField != null) {
            this.dataFieldStr = dataFieldFindDataField.getId();
        }
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public int getGroupInviteCount() {
        if (this.groupInviteCount == null) {
            Link link = getLink(GROUP_INVITE_LINK);
            if (link == null) {
                this.groupInviteCount = 0;
            } else {
                this.groupInviteCount = Integer.valueOf(link.getCount() != null ? link.getCount().intValue() : 0);
            }
        }
        return this.groupInviteCount.intValue();
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActor
    public ActivityStoryActor.Type getType() {
        return ActivityStoryActor.Type.GROUP;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public int getGroupUserCount() {
        if (this.groupUserCount == null) {
            Link link = getLink(GROUP_USER_LINK);
            if (link == null) {
                this.groupUserCount = 0;
            } else {
                this.groupUserCount = Integer.valueOf(link.getCount() != null ? link.getCount().intValue() : 0);
            }
        }
        return this.groupUserCount.intValue();
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public EntityRef<Group> getRef() {
        Link link;
        if (this.selfRef == null && (link = getLink("self")) != null) {
            this.selfRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.selfRef;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public Criteria getCriteria() {
        return this.criteria;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public EntityRef<User> getGroupOwnerRef() {
        Link link;
        if (this.groupOwnerRef == null && (link = getLink(GROUP_OWNER_LINK)) != null) {
            this.groupOwnerRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.groupOwnerRef;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public EntityRef<GroupInvite> getGroupInviteRef() {
        Link link;
        if (this.groupInviteRef == null && (link = getLink(GROUP_INVITE_LINK)) != null) {
            this.groupInviteRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.groupInviteRef;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public EntityRef<DataType> getDataTypeRef() {
        Link link;
        if (this.dataTypeRef == null && (link = getLink("data_type")) != null) {
            this.dataTypeRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.dataTypeRef;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryGroupActor
    public EntityRef<GroupUser> getGroupUserRef() {
        Link link;
        if (this.groupUserRef == null && (link = getLink(GROUP_USER_LINK)) != null) {
            this.groupUserRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.groupUserRef;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.startTime);
        parcel.writeValue(this.endTime);
        parcel.writeString(this.name);
        parcel.writeString(this.dataTypeStr);
        parcel.writeString(this.id);
        parcel.writeParcelable(this.period, i);
        parcel.writeString(this.dataFieldStr);
        parcel.writeValue(this.criteria);
    }
}
