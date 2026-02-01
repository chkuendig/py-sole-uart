package com.ua.sdk.friendship;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.user.User;

/* loaded from: classes2.dex */
public class FriendshipListRef implements EntityListRef<Friendship> {
    public static Parcelable.Creator<FriendshipListRef> CREATOR = new Parcelable.Creator<FriendshipListRef>() { // from class: com.ua.sdk.friendship.FriendshipListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FriendshipListRef createFromParcel(Parcel parcel) {
            return new FriendshipListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FriendshipListRef[] newArray(int i) {
            return new FriendshipListRef[i];
        }
    };
    private final String href;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    private FriendshipListRef(Builder builder) {
        this.href = builder.getHref();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder extends BaseReferenceBuilder {
        EntityRef<User> fromUser;
        String href;
        FriendshipStatus status;
        EntityRef<User> toUser;

        private Builder() {
            super("/v7.0/friendship/");
        }

        public Builder setHref(String str) {
            this.href = str;
            return this;
        }

        public Builder setToUser(EntityRef<User> entityRef) {
            this.toUser = entityRef;
            return this;
        }

        public Builder setFromUser(EntityRef<User> entityRef) {
            this.fromUser = entityRef;
            return this;
        }

        public Builder setFriendshipStatus(FriendshipStatus friendshipStatus) {
            this.status = friendshipStatus;
            return this;
        }

        public FriendshipListRef build() throws IllegalArgumentException {
            if (this.status == FriendshipStatus.NONE) {
                Precondition.check(false, "none is not a valid status type.");
            }
            if (this.fromUser == null && this.toUser == null) {
                Precondition.check(false, "a from_user and/or a to_user filter must be defined.");
            }
            EntityRef<User> entityRef = this.fromUser;
            if (entityRef != null) {
                setParam(FriendshipImpl.ARG_FROM_USER, entityRef.getId());
            }
            EntityRef<User> entityRef2 = this.toUser;
            if (entityRef2 != null) {
                setParam(FriendshipImpl.ARG_TO_USER, entityRef2.getId());
            }
            FriendshipStatus friendshipStatus = this.status;
            if (friendshipStatus != null) {
                if (this.fromUser == null || this.toUser == null) {
                    setParam("status", friendshipStatus.getValue());
                } else {
                    Precondition.check(false, "a status cannot be applied when a to_user and from_user filter are applied");
                }
            }
            return new FriendshipListRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private FriendshipListRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
