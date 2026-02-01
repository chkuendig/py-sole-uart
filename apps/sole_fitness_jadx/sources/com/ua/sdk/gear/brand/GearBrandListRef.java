package com.ua.sdk.gear.brand;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.gear.GearType;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;

/* loaded from: classes2.dex */
public class GearBrandListRef implements EntityListRef<GearBrand> {
    public static final Parcelable.Creator<GearBrandListRef> CREATOR = new Parcelable.Creator<GearBrandListRef>() { // from class: com.ua.sdk.gear.brand.GearBrandListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GearBrandListRef createFromParcel(Parcel parcel) {
            return new GearBrandListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GearBrandListRef[] newArray(int i) {
            return new GearBrandListRef[i];
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

    private GearBrandListRef(Builder builder) {
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
        GearType type;

        private Builder() {
            super(UrlBuilderImpl.GET_GEAR_BRAND_URL);
        }

        public Builder setType(GearType gearType) {
            this.type = gearType;
            setParam("type", gearType.getValue());
            return this;
        }

        public GearBrandListRef build() throws NullPointerException {
            Precondition.isNotNull(this.type);
            return new GearBrandListRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private GearBrandListRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
