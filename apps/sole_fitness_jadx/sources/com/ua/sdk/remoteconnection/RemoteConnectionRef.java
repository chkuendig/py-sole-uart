package com.ua.sdk.remoteconnection;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;

/* loaded from: classes2.dex */
public class RemoteConnectionRef implements EntityRef<RemoteConnection> {
    public static final Parcelable.Creator<RemoteConnectionRef> CREATOR = new Parcelable.Creator<RemoteConnectionRef>() { // from class: com.ua.sdk.remoteconnection.RemoteConnectionRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteConnectionRef createFromParcel(Parcel parcel) {
            return new RemoteConnectionRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteConnectionRef[] newArray(int i) {
            return new RemoteConnectionRef[i];
        }
    };
    private final String href;
    private final String id;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private RemoteConnectionRef(Builder builder) {
        this.id = builder.id;
        this.href = builder.getHref();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends BaseReferenceBuilder {
        private String id;

        private Builder() {
            super("/v7.0/remoteconnection/{id}/");
        }

        public Builder setId(String str) {
            this.id = str;
            setParam("id", str);
            return this;
        }

        public RemoteConnectionRef build() {
            RemoteConnectionRef remoteConnectionRef;
            synchronized (RemoteConnectionRef.class) {
                remoteConnectionRef = new RemoteConnectionRef(this);
            }
            return remoteConnectionRef;
        }
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return this.id;
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.href);
    }

    private RemoteConnectionRef(Parcel parcel) {
        this.id = parcel.readString();
        this.href = parcel.readString();
    }
}
