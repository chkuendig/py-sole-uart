package com.ua.sdk.heartrate;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;

/* loaded from: classes2.dex */
public class HeartRateZonesRef implements EntityRef<HeartRateZones> {
    public static Parcelable.Creator<HeartRateZonesRef> CREATOR = new Parcelable.Creator<HeartRateZonesRef>() { // from class: com.ua.sdk.heartrate.HeartRateZonesRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateZonesRef createFromParcel(Parcel parcel) {
            return new HeartRateZonesRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateZonesRef[] newArray(int i) {
            return new HeartRateZonesRef[i];
        }
    };
    private final String id;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private HeartRateZonesRef(Builder builder) {
        this.id = builder.id;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return this.id.length() > 0 ? this.id : "";
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return !this.id.isEmpty() ? String.format(UrlBuilderImpl.GET_HEART_RATE_ZONES, this.id) : "";
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder extends BaseReferenceBuilder {
        private String id;

        private Builder() {
            super(UrlBuilderImpl.GET_HEART_RATE_ZONES);
        }

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public HeartRateZonesRef build() throws NullPointerException {
            Precondition.isNotNull(this.id, "HeartRateZones Id");
            return new HeartRateZonesRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
    }

    private HeartRateZonesRef(Parcel parcel) {
        this.id = parcel.readString();
    }
}
