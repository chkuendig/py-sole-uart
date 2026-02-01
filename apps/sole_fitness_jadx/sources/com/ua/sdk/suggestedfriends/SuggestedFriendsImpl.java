package com.ua.sdk.suggestedfriends;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.ImageUrlImpl;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.internal.LinkListRef;
import com.ua.sdk.user.User;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SuggestedFriendsImpl extends ApiTransferObject implements SuggestedFriends {
    public static Parcelable.Creator<SuggestedFriendsImpl> CREATOR = new Parcelable.Creator<SuggestedFriendsImpl>() { // from class: com.ua.sdk.suggestedfriends.SuggestedFriendsImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuggestedFriendsImpl createFromParcel(Parcel parcel) {
            return new SuggestedFriendsImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuggestedFriendsImpl[] newArray(int i) {
            return new SuggestedFriendsImpl[i];
        }
    };
    public static final String REF_MUTUAL_FRIENDS = "mutual_friends";
    public static final String REF_PROFILE_PIC = "profile_picture";
    public static final String REF_USER = "user";
    Integer mutualFriendCount;

    @SerializedName("reasons")
    List<SuggestedFriendsReasonImpl> reasons;
    ImageUrlImpl suggestedFriendsProfilePicture;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef getRef() {
        return null;
    }

    public SuggestedFriendsImpl() {
        this.reasons = new ArrayList();
        this.suggestedFriendsProfilePicture = new ImageUrlImpl();
    }

    @Override // com.ua.sdk.suggestedfriends.SuggestedFriends
    public List<SuggestedFriendsReason> getReasons() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.reasons);
        return arrayList;
    }

    @Override // com.ua.sdk.suggestedfriends.SuggestedFriends
    public ImageUrlImpl getSuggestedFriendsProfilePicture() {
        return this.suggestedFriendsProfilePicture;
    }

    @Override // com.ua.sdk.suggestedfriends.SuggestedFriends
    public EntityListRef<User> getMutualFriendsRef() {
        Link link = getLink(REF_MUTUAL_FRIENDS);
        if (link == null) {
            return null;
        }
        return new LinkListRef(link.getHref());
    }

    @Override // com.ua.sdk.suggestedfriends.SuggestedFriends
    public Integer getMutualFriendCount() {
        Link link = getLink(REF_MUTUAL_FRIENDS);
        if (link == null) {
            return null;
        }
        return link.getCount();
    }

    @Override // com.ua.sdk.suggestedfriends.SuggestedFriends
    public EntityRef<User> getSuggestedFriendRef() {
        Link link = getLink("user");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.suggestedfriends.SuggestedFriends
    public String getSuggestFriendDisplayName() {
        Link link = getLink("user");
        if (link == null) {
            return null;
        }
        return link.getDisplayName();
    }

    public void setReasons(List<SuggestedFriendsReasonImpl> list) {
        this.reasons = list;
    }

    public void setMutualFriendCount(Integer num) {
        this.mutualFriendCount = num;
    }

    public void setSuggestedFriendsProfilePicture(ImageUrlImpl imageUrlImpl) {
        this.suggestedFriendsProfilePicture = imageUrlImpl;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.reasons);
        parcel.writeValue(this.mutualFriendCount);
        parcel.writeParcelable(this.suggestedFriendsProfilePicture, i);
    }

    private SuggestedFriendsImpl(Parcel parcel) {
        super(parcel);
        this.reasons = new ArrayList();
        this.suggestedFriendsProfilePicture = new ImageUrlImpl();
        parcel.readTypedList(this.reasons, SuggestedFriendsReasonImpl.CREATOR);
        this.mutualFriendCount = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.suggestedFriendsProfilePicture = (ImageUrlImpl) parcel.readParcelable(ImageUrlImpl.class.getClassLoader());
    }
}
