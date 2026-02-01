package com.ua.sdk.bodymass;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;

/* loaded from: classes2.dex */
public class BodyMassRef implements EntityRef<BodyMass> {
    public static Parcelable.Creator<BodyMassRef> CREATOR = new Parcelable.Creator<BodyMassRef>() { // from class: com.ua.sdk.bodymass.BodyMassRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BodyMassRef createFromParcel(Parcel parcel) {
            return new BodyMassRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BodyMassRef[] newArray(int i) {
            return new BodyMassRef[i];
        }
    };
    private final String id;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private BodyMassRef(Builder builder) {
        this.id = builder.id;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        String str = this.id;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return this.id;
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        String str = this.id;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return String.format(UrlBuilderImpl.BODYMASS_URL, this.id);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder extends BaseReferenceBuilder {
        private String id;

        private Builder() {
            super(UrlBuilderImpl.BODYMASS_URL);
        }

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public BodyMassRef build() throws NullPointerException {
            Precondition.isNotNull(this.id, "BodyMass Id");
            return new BodyMassRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
    }

    private BodyMassRef(Parcel parcel) {
        this.id = parcel.readString();
    }
}
