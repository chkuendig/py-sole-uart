package com.ua.sdk.datapoint;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;

/* loaded from: classes2.dex */
public class DataTypeRef implements EntityRef<DataType> {
    public static Parcelable.Creator<DataTypeRef> CREATOR = new Parcelable.Creator<DataTypeRef>() { // from class: com.ua.sdk.datapoint.DataTypeRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataTypeRef createFromParcel(Parcel parcel) {
            return new DataTypeRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataTypeRef[] newArray(int i) {
            return new DataTypeRef[i];
        }
    };
    final String href;
    final String id;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private DataTypeRef(Parcel parcel) {
        this.id = parcel.readString();
        this.href = parcel.readString();
    }

    private DataTypeRef(Builder builder) {
        this.id = builder.id;
        this.href = builder.getHref();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return this.id;
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.id;
        String str2 = ((DataTypeRef) obj).id;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.href);
    }

    public static class Builder extends BaseReferenceBuilder {
        String id;

        protected Builder() {
            super("/v7.0/data_type/{id}/");
        }

        public Builder setId(String str) {
            this.id = str;
            setParam("id", str);
            return this;
        }

        public DataTypeRef build() throws NullPointerException {
            Precondition.isNotNull(this.id, "id");
            return new DataTypeRef(this);
        }
    }
}
