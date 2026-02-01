package com.ua.sdk.gear;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;

/* loaded from: classes2.dex */
public class GearListRef implements EntityListRef<Gear> {
    public static final Parcelable.Creator<GearListRef> CREATOR = new Parcelable.Creator<GearListRef>() { // from class: com.ua.sdk.gear.GearListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GearListRef createFromParcel(Parcel parcel) {
            return new GearListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GearListRef[] newArray(int i) {
            return new GearListRef[i];
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

    private GearListRef(Builder builder) {
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
        String brand;

        private Builder() {
            super(UrlBuilderImpl.GET_GEAR_URL);
        }

        public Builder setBrand(String str) {
            this.brand = str;
            setParam("brand", str);
            return this;
        }

        public GearListRef build() throws NullPointerException {
            Precondition.isNotNull(this.brand);
            return new GearListRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private GearListRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
