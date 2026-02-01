package com.ua.sdk.heartrate;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import com.ua.sdk.user.User;
import java.util.Objects;

/* loaded from: classes2.dex */
public class HeartRateZonesListRef implements EntityListRef<HeartRateZones> {
    public static Parcelable.Creator<HeartRateZonesListRef> CREATOR = new Parcelable.Creator<HeartRateZonesListRef>() { // from class: com.ua.sdk.heartrate.HeartRateZonesListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateZonesListRef createFromParcel(Parcel parcel) {
            return new HeartRateZonesListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateZonesListRef[] newArray(int i) {
            return new HeartRateZonesListRef[i];
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

    private HeartRateZonesListRef(Parcel parcel) {
        this.href = parcel.readString();
    }

    private HeartRateZonesListRef(Builder builder) {
        this.href = builder.getHref();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    public static class Builder extends BaseReferenceBuilder {
        private static final String USER_ID = "user";

        public Builder() {
            super(UrlBuilderImpl.BASE_HEART_RATE_ZONES);
        }

        public Builder setUser(EntityRef<User> entityRef) throws NullPointerException {
            Precondition.isNotNull(entityRef);
            setParam("user", entityRef.getId());
            return this;
        }

        public Builder setUserId(String str) throws NullPointerException {
            Precondition.isNotNull(str);
            setParam("user", str);
            return this;
        }

        public HeartRateZonesListRef build() {
            Objects.requireNonNull(getParam("user"), "User or User ID must be supplied.");
            return new HeartRateZonesListRef(this);
        }
    }
}
