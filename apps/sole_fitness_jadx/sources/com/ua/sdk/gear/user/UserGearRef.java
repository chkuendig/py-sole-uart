package com.ua.sdk.gear.user;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.LinkEntityRef;

/* loaded from: classes2.dex */
public class UserGearRef extends LinkEntityRef<UserGear> {
    public static final Parcelable.Creator<UserGearRef> CREATOR = new Parcelable.Creator<UserGearRef>() { // from class: com.ua.sdk.gear.user.UserGearRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserGearRef createFromParcel(Parcel parcel) {
            return new UserGearRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserGearRef[] newArray(int i) {
            return new UserGearRef[i];
        }
    };

    @Override // com.ua.sdk.internal.LinkEntityRef, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserGearRef(String str) {
        super(str);
    }

    public UserGearRef(String str, String str2) {
        super(str, str2);
    }

    public UserGearRef(String str, long j, String str2) {
        super(str, j, str2);
    }

    private UserGearRef(Builder builder) {
        super(builder.id, builder.getHref());
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends BaseReferenceBuilder {
        private String id;

        private Builder() {
            super("/api/0.1/usergear/{id}/");
        }

        public Builder setGearId(String str) {
            this.id = str;
            setParam("id", str);
            return this;
        }

        public UserGearRef build() {
            if (this.id == null) {
                throw new IllegalArgumentException("An id must be specified in the builder.");
            }
            return new UserGearRef(this);
        }
    }

    @Override // com.ua.sdk.internal.LinkEntityRef, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private UserGearRef(Parcel parcel) {
        super(parcel);
    }
}
