package com.ua.sdk.activitystory.object;

import android.os.Parcel;
import android.os.Parcelable;
import com.dyaco.sole.database.UserData;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.activitystory.ActivityStoryObject;
import com.ua.sdk.activitystory.ActivityStoryUserObject;
import com.ua.sdk.friendship.FriendshipImpl;
import com.ua.sdk.friendship.FriendshipStatus;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.location.Location;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.user.Gender;
import com.ua.sdk.user.User;
import java.util.Date;

/* loaded from: classes2.dex */
public class ActivityStoryUserObjectImpl extends ApiTransferObject implements ActivityStoryUserObject {
    public static Parcelable.Creator<ActivityStoryUserObjectImpl> CREATOR = new Parcelable.Creator<ActivityStoryUserObjectImpl>() { // from class: com.ua.sdk.activitystory.object.ActivityStoryUserObjectImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryUserObjectImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryUserObjectImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryUserObjectImpl[] newArray(int i) {
            return new ActivityStoryUserObjectImpl[i];
        }
    };

    @SerializedName("date_joined")
    Date dateJoined;

    @SerializedName("first_name")
    String firstName;

    @SerializedName("friendship")
    Friendship friendship;

    @SerializedName(UserData.GENDER)
    Gender gender;

    @SerializedName("id")
    String id;

    @SerializedName("is_mvp")
    Boolean isMvp;

    @SerializedName("last_name")
    String lastName;

    @SerializedName("location")
    Location location;

    @SerializedName(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)
    Privacy privacy;

    @SerializedName("title")
    String title;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static class Friendship {

        @SerializedName(FriendshipImpl.ARG_FROM_USER)
        String fromUser;

        @SerializedName("status")
        FriendshipStatus status;

        @SerializedName(FriendshipImpl.ARG_TO_USER)
        String toUser;

        Friendship() {
        }
    }

    public ActivityStoryUserObjectImpl() {
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserObject, com.ua.sdk.activitystory.ActivityStoryObject
    public ActivityStoryObject.Type getType() {
        return ActivityStoryObject.Type.USER;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserObject
    public Privacy getPrivacy() {
        return this.privacy;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserObject
    public Location getLocation() {
        return this.location;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserObject
    public Date getJoinedDate() {
        return this.dateJoined;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserObject
    public String getFirstName() {
        return this.firstName;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserObject
    public String getLastName() {
        return this.lastName;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserObject
    public String getTitle() {
        return this.title;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserObject
    public Gender getGender() {
        return this.gender;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserObject
    public Boolean isMvp() {
        return this.isMvp;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserObject
    public EntityRef<User> getUserRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserObject
    public String getId() {
        return this.id;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserObject
    public FriendshipStatus getFriendshipStatus() {
        Friendship friendship = this.friendship;
        if (friendship == null) {
            return FriendshipStatus.NONE;
        }
        return friendship.status;
    }

    protected void createFriendship() {
        if (this.friendship == null) {
            this.friendship = new Friendship();
        }
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.id);
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.title);
        Gender gender = this.gender;
        int iOrdinal = -1;
        parcel.writeInt(gender == null ? -1 : gender.ordinal());
        parcel.writeValue(this.isMvp);
        parcel.writeParcelable(this.privacy, i);
        parcel.writeParcelable(this.location, i);
        Date date = this.dateJoined;
        parcel.writeLong(date == null ? -1L : date.getTime());
        Friendship friendship = this.friendship;
        String str = "";
        parcel.writeString((friendship == null || friendship.fromUser == null) ? "" : this.friendship.fromUser);
        Friendship friendship2 = this.friendship;
        if (friendship2 != null && friendship2.status != null) {
            iOrdinal = this.friendship.status.ordinal();
        }
        parcel.writeInt(iOrdinal);
        Friendship friendship3 = this.friendship;
        if (friendship3 != null && friendship3.toUser != null) {
            str = this.friendship.toUser;
        }
        parcel.writeString(str);
    }

    private ActivityStoryUserObjectImpl(Parcel parcel) {
        super(parcel);
        this.id = parcel.readString();
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
        this.title = parcel.readString();
        int i = parcel.readInt();
        this.gender = i == -1 ? null : Gender.values()[i];
        this.isMvp = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.privacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.location = (Location) parcel.readParcelable(Location.class.getClassLoader());
        Long lValueOf = Long.valueOf(parcel.readLong());
        this.dateJoined = lValueOf.longValue() == -1 ? null : new Date(lValueOf.longValue());
        String string = parcel.readString();
        int i2 = parcel.readInt();
        String string2 = parcel.readString();
        if (string.equals("") && i2 == -1 && string2.equals("")) {
            return;
        }
        createFriendship();
        this.friendship.fromUser = string.equals("") ? null : string;
        this.friendship.status = i2 == -1 ? null : FriendshipStatus.values()[i2];
        this.friendship.toUser = string2.equals("") ? null : string2;
    }
}
