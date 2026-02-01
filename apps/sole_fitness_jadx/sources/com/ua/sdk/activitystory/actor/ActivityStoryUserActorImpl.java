package com.ua.sdk.activitystory.actor;

import android.os.Parcel;
import android.os.Parcelable;
import com.dyaco.sole.database.UserData;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.ImageUrl;
import com.ua.sdk.activitystory.ActivityStoryActor;
import com.ua.sdk.activitystory.ActivityStoryUserActor;
import com.ua.sdk.friendship.FriendshipImpl;
import com.ua.sdk.friendship.FriendshipStatus;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.user.Gender;
import com.ua.sdk.user.User;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class ActivityStoryUserActorImpl extends ApiTransferObject implements ActivityStoryUserActor {
    public static Parcelable.Creator<ActivityStoryUserActorImpl> CREATOR = new Parcelable.Creator<ActivityStoryUserActorImpl>() { // from class: com.ua.sdk.activitystory.actor.ActivityStoryUserActorImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryUserActorImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryUserActorImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryUserActorImpl[] newArray(int i) {
            return new ActivityStoryUserActorImpl[i];
        }
    };

    @SerializedName("first_name")
    String mFirstName;

    @SerializedName("friendship")
    Friendship mFriendship;

    @SerializedName(UserData.GENDER)
    Gender mGender;

    @SerializedName("id")
    String mId;

    @SerializedName("is_mvp")
    Boolean mIsMvp;

    @SerializedName("last_name")
    String mLastName;
    transient ImageUrl mProfilePicture;

    @SerializedName("title")
    String mTitle;

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

    @Override // com.ua.sdk.activitystory.ActivityStoryUserActor
    public String getFirstName() {
        return this.mFirstName;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserActor
    public String getLastName() {
        return this.mLastName;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserActor
    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserActor
    public Gender getGender() {
        return this.mGender;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserActor
    public Boolean isMvp() {
        return this.mIsMvp;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActor
    public ActivityStoryActor.Type getType() {
        return ActivityStoryActor.Type.USER;
    }

    public ActivityStoryUserActorImpl(String str) {
        this.mId = str;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActor
    public String getId() {
        return this.mId;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserActor
    public ImageUrl getProfilePhoto() {
        return this.mProfilePicture;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserActor
    public FriendshipStatus getFriendshipStatus() {
        Friendship friendship = this.mFriendship;
        if (friendship == null) {
            return FriendshipStatus.NONE;
        }
        return friendship.status;
    }

    public void setUserProfilePicture(ImageUrl imageUrl) {
        this.mProfilePicture = imageUrl;
    }

    protected void createFriendship() {
        if (this.mFriendship == null) {
            this.mFriendship = new Friendship();
        }
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryUserActor
    public EntityRef<User> getUserRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    public void setUser(EntityRef<User> entityRef) {
        if (entityRef == null) {
            this.mId = null;
        } else {
            this.mId = entityRef.getId();
        }
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mId);
        parcel.writeString(this.mFirstName);
        parcel.writeString(this.mLastName);
        parcel.writeString(this.mTitle);
        Gender gender = this.mGender;
        int iOrdinal = -1;
        parcel.writeInt(gender == null ? -1 : gender.ordinal());
        parcel.writeValue(this.mIsMvp);
        parcel.writeParcelable(this.mProfilePicture, i);
        Friendship friendship = this.mFriendship;
        String str = "";
        parcel.writeString((friendship == null || friendship.fromUser == null) ? "" : this.mFriendship.fromUser);
        Friendship friendship2 = this.mFriendship;
        if (friendship2 != null && friendship2.status != null) {
            iOrdinal = this.mFriendship.status.ordinal();
        }
        parcel.writeInt(iOrdinal);
        Friendship friendship3 = this.mFriendship;
        if (friendship3 != null && friendship3.toUser != null) {
            str = this.mFriendship.toUser;
        }
        parcel.writeString(str);
    }

    public ActivityStoryUserActorImpl() {
    }

    private ActivityStoryUserActorImpl(Parcel parcel) {
        super(parcel);
        this.mId = parcel.readString();
        this.mFirstName = parcel.readString();
        this.mLastName = parcel.readString();
        this.mTitle = parcel.readString();
        int i = parcel.readInt();
        this.mGender = i == -1 ? null : Gender.values()[i];
        this.mIsMvp = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.mProfilePicture = (ImageUrl) parcel.readParcelable(ImageUrl.class.getClassLoader());
        String string = parcel.readString();
        int i2 = parcel.readInt();
        String string2 = parcel.readString();
        if (string.equals("") && i2 == -1 && string2.equals("")) {
            return;
        }
        createFriendship();
        this.mFriendship.fromUser = string.equals("") ? null : string;
        this.mFriendship.status = i2 == -1 ? null : FriendshipStatus.values()[i2];
        this.mFriendship.toUser = string2.equals("") ? null : string2;
    }

    public String toString() {
        return getFirstName() + StringUtils.SPACE + getLastName();
    }
}
