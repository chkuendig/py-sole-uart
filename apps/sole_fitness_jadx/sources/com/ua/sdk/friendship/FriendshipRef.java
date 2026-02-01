package com.ua.sdk.friendship;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import com.ua.sdk.user.User;

/* loaded from: classes2.dex */
public class FriendshipRef implements EntityRef<Friendship> {
    public static Parcelable.Creator<FriendshipRef> CREATOR = new Parcelable.Creator<FriendshipRef>() { // from class: com.ua.sdk.friendship.FriendshipRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FriendshipRef createFromParcel(Parcel parcel) {
            return new FriendshipRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FriendshipRef[] newArray(int i) {
            return new FriendshipRef[i];
        }
    };
    private final String fromUserId;
    private final String href;
    private final String id;
    private final String toUserId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private FriendshipRef(Builder builder) {
        this.href = builder.href;
        this.id = builder.id;
        this.toUserId = builder.toUserId;
        this.fromUserId = builder.fromUserId;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return this.id;
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public String getToUserId() {
        return this.toUserId;
    }

    public String getFromUserId() {
        return this.fromUserId;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder extends BaseReferenceBuilder {
        String fromUserId;
        String href;
        String id;
        String toUserId;

        private Builder() {
            super(UrlBuilderImpl.CHANGE_FRIENDSHIP_URL);
        }

        public Builder setHref(String str) {
            this.href = str;
            return this;
        }

        public Builder setToUser(EntityRef<User> entityRef) {
            this.toUserId = entityRef.getId();
            return this;
        }

        public Builder setFromUser(EntityRef<User> entityRef) {
            this.fromUserId = entityRef.getId();
            return this;
        }

        public Builder setToUser(String str) {
            this.toUserId = str;
            return this;
        }

        public Builder setFromUser(String str) {
            this.fromUserId = str;
            return this;
        }

        public FriendshipRef build() throws NullPointerException {
            Precondition.isNotNull(this.fromUserId, "fromUser must be defined");
            Precondition.isNotNull(this.toUserId, "toUser must be defined");
            String str = this.fromUserId + '_' + this.toUserId;
            this.id = str;
            setHref(String.format(UrlBuilderImpl.CHANGE_FRIENDSHIP_URL, str));
            return new FriendshipRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.href);
        parcel.writeString(this.toUserId);
        parcel.writeString(this.fromUserId);
    }

    private FriendshipRef(Parcel parcel) {
        this.id = parcel.readString();
        this.href = parcel.readString();
        this.toUserId = parcel.readString();
        this.fromUserId = parcel.readString();
    }
}
