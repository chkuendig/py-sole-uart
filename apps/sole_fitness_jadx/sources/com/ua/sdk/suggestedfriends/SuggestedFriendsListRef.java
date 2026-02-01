package com.ua.sdk.suggestedfriends;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import com.ua.sdk.user.User;

/* loaded from: classes2.dex */
public class SuggestedFriendsListRef implements EntityListRef<SuggestedFriends> {
    public static Parcelable.Creator<SuggestedFriendsListRef> CREATOR = new Parcelable.Creator<SuggestedFriendsListRef>() { // from class: com.ua.sdk.suggestedfriends.SuggestedFriendsListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuggestedFriendsListRef createFromParcel(Parcel parcel) {
            return new SuggestedFriendsListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuggestedFriendsListRef[] newArray(int i) {
            return new SuggestedFriendsListRef[i];
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

    private SuggestedFriendsListRef(Builder builder) {
        this.href = builder.getHref();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends BaseReferenceBuilder {
        EntityRef<User> user;

        private Builder() {
            super(UrlBuilderImpl.GET_SUGGESTED_FRIENDS_URL);
        }

        public Builder setUser(EntityRef<User> entityRef) {
            this.user = entityRef;
            setParam("user", entityRef.getId());
            return this;
        }

        public SuggestedFriendsListRef build() throws NullPointerException {
            Precondition.isNotNull(this.user);
            return new SuggestedFriendsListRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private SuggestedFriendsListRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
