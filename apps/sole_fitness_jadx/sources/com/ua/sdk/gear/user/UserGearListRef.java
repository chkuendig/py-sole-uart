package com.ua.sdk.gear.user;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.user.User;

/* loaded from: classes2.dex */
public class UserGearListRef implements EntityListRef<UserGear> {
    public static final Parcelable.Creator<UserGearListRef> CREATOR = new Parcelable.Creator<UserGearListRef>() { // from class: com.ua.sdk.gear.user.UserGearListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserGearListRef createFromParcel(Parcel parcel) {
            return new UserGearListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserGearListRef[] newArray(int i) {
            return new UserGearListRef[i];
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

    private UserGearListRef(Builder builder) {
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
        private EntityRef<User> user;

        private Builder() {
            super("/api/0.1/usergear/");
        }

        public Builder setUser(EntityRef<User> entityRef) {
            this.user = entityRef;
            setParam("user_id", entityRef.getId());
            return this;
        }

        public UserGearListRef build() throws NullPointerException {
            Precondition.isNotNull(this.user);
            return new UserGearListRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private UserGearListRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
