package com.ua.sdk.page.follow;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.user.User;
import java.util.Objects;

/* loaded from: classes2.dex */
public class PageFollowListRef implements EntityListRef<PageFollow> {
    public static Parcelable.Creator<PageFollowListRef> CREATOR = new Parcelable.Creator<PageFollowListRef>() { // from class: com.ua.sdk.page.follow.PageFollowListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageFollowListRef createFromParcel(Parcel parcel) {
            return new PageFollowListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageFollowListRef[] newArray(int i) {
            return new PageFollowListRef[i];
        }
    };
    private String href;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    private PageFollowListRef(Builder builder) {
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
        private String id;
        private EntityRef<User> user;

        private Builder() {
            super("/v7.0/page_follow/");
        }

        public Builder setUserId(String str) {
            this.id = str;
            return this;
        }

        public Builder setUser(EntityRef<User> entityRef) {
            this.user = entityRef;
            return this;
        }

        public PageFollowListRef build() {
            String str = this.id;
            if (str == null) {
                Objects.requireNonNull(this.user, "user id is null.");
            }
            EntityRef<User> entityRef = this.user;
            if (entityRef == null) {
                setParam("user_id", str);
            } else if (str == null) {
                setParam("user_id", entityRef.getId());
            } else {
                throw new IllegalStateException("cannot specify a user and an id");
            }
            return new PageFollowListRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private PageFollowListRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
