package com.ua.sdk.friendship;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.user.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class FriendshipImpl extends ApiTransferObject implements Friendship {
    public static final String ARG_FROM_USER = "from_user";
    public static final String ARG_SELF = "self";
    public static final String ARG_TO_USER = "to_user";
    public static Parcelable.Creator<FriendshipImpl> CREATOR = new Parcelable.Creator<FriendshipImpl>() { // from class: com.ua.sdk.friendship.FriendshipImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FriendshipImpl createFromParcel(Parcel parcel) {
            return new FriendshipImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FriendshipImpl[] newArray(int i) {
            return new FriendshipImpl[i];
        }
    };
    private transient List<Friendship> friendships;
    private Date mCreatedDateTime;
    private FriendshipStatus mFriendshipStatus;
    private String mMessage;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected FriendshipImpl() {
        this.mFriendshipStatus = FriendshipStatus.NONE;
    }

    protected FriendshipImpl(FriendshipStatus friendshipStatus, Date date, String str) {
        FriendshipStatus friendshipStatus2 = FriendshipStatus.NONE;
        this.mFriendshipStatus = friendshipStatus;
        this.mCreatedDateTime = date;
        this.mMessage = str;
    }

    protected FriendshipImpl(FriendshipRef friendshipRef) {
        this.mFriendshipStatus = FriendshipStatus.NONE;
        ArrayList<Link> arrayList = new ArrayList<>(1);
        arrayList.add(new Link(friendshipRef.getHref(), friendshipRef.getId()));
        setLinksForRelation("self", arrayList);
        ArrayList<Link> arrayList2 = new ArrayList<>(1);
        arrayList2.add(new Link("/v7.0/user/" + friendshipRef.getToUserId() + "/", friendshipRef.getToUserId()));
        setLinksForRelation(ARG_TO_USER, arrayList2);
        ArrayList<Link> arrayList3 = new ArrayList<>(1);
        arrayList3.add(new Link("/v7.0/user/" + friendshipRef.getFromUserId() + "/", friendshipRef.getFromUserId()));
        setLinksForRelation(ARG_FROM_USER, arrayList3);
    }

    public void addFriendship(Friendship friendship) {
        if (this.friendships == null) {
            this.friendships = new ArrayList();
        }
        this.friendships.add(friendship);
    }

    public List<Friendship> getFriendships() {
        if (this.friendships == null) {
            this.friendships = new ArrayList();
        }
        return this.friendships;
    }

    @Override // com.ua.sdk.friendship.Friendship
    public FriendshipStatus getFriendshipStatus() {
        return this.mFriendshipStatus;
    }

    @Override // com.ua.sdk.friendship.Friendship
    public Date getCreatedDateTime() {
        return this.mCreatedDateTime;
    }

    @Override // com.ua.sdk.friendship.Friendship
    public String getMessage() {
        return this.mMessage;
    }

    @Override // com.ua.sdk.friendship.Friendship
    public EntityRef<User> getToUserEntityRef() {
        ArrayList<Link> links = getLinks(ARG_TO_USER);
        if (links == null && links.isEmpty()) {
            return null;
        }
        return new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
    }

    @Override // com.ua.sdk.friendship.Friendship
    public EntityRef<User> getFromUserEntityRef() {
        ArrayList<Link> links = getLinks(ARG_FROM_USER);
        if (links == null && links.isEmpty()) {
            return null;
        }
        return new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<Friendship> getRef() {
        ArrayList<Link> links = getLinks("self");
        if (links == null && links.isEmpty()) {
            return null;
        }
        return new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
    }

    public void setFriendshipStatus(FriendshipStatus friendshipStatus) {
        this.mFriendshipStatus = friendshipStatus;
    }

    public void setCreatedDateTime(Date date) {
        this.mCreatedDateTime = date;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        FriendshipStatus friendshipStatus = this.mFriendshipStatus;
        parcel.writeInt(friendshipStatus == null ? -1 : friendshipStatus.ordinal());
        Date date = this.mCreatedDateTime;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        parcel.writeString(this.mMessage);
    }

    private FriendshipImpl(Parcel parcel) {
        super(parcel);
        this.mFriendshipStatus = FriendshipStatus.NONE;
        int i = parcel.readInt();
        this.mFriendshipStatus = i == -1 ? null : FriendshipStatus.values()[i];
        long j = parcel.readLong();
        this.mCreatedDateTime = j != -1 ? new Date(j) : null;
        this.mMessage = parcel.readString();
    }
}
