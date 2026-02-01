package com.ua.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.user.User;

@Deprecated
/* loaded from: classes2.dex */
public class UserSearchByNameListRef implements EntityListRef<User> {
    public static Parcelable.Creator<UserSearchByNameListRef> CREATOR = new Parcelable.Creator<UserSearchByNameListRef>() { // from class: com.ua.sdk.UserSearchByNameListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserSearchByNameListRef createFromParcel(Parcel parcel) {
            return new UserSearchByNameListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserSearchByNameListRef[] newArray(int i) {
            return new UserSearchByNameListRef[i];
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

    private UserSearchByNameListRef(Builder builder) {
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
        private String searchName;

        private Builder() {
            super("/v7.0/user/");
        }

        public Builder setSearchName(String str) {
            this.searchName = str;
            setParam("q", str);
            return this;
        }

        public UserSearchByNameListRef build() throws NullPointerException {
            Precondition.isNotNull(this.searchName);
            return new UserSearchByNameListRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private UserSearchByNameListRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
