package com.ua.sdk.remoteconnection;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;

/* loaded from: classes2.dex */
public class RemoteConnectionTypeRef implements EntityRef<RemoteConnectionType>, Parcelable {
    public static final Parcelable.Creator<RemoteConnectionTypeRef> CREATOR = new Parcelable.Creator<RemoteConnectionTypeRef>() { // from class: com.ua.sdk.remoteconnection.RemoteConnectionTypeRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteConnectionTypeRef createFromParcel(Parcel parcel) {
            return new RemoteConnectionTypeRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteConnectionTypeRef[] newArray(int i) {
            return new RemoteConnectionTypeRef[i];
        }
    };
    private final String href;
    private final String id;
    private final String recorderTypeKey;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private RemoteConnectionTypeRef(Builder builder) {
        this.id = builder.id;
        this.href = builder.getHref();
        this.recorderTypeKey = builder.recorderTypeKey;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends BaseReferenceBuilder {
        String id;
        String recorderTypeKey;

        private Builder() {
            super("/v7.0/remoteconnectiontype/{id}/");
        }

        public Builder setId(String str) {
            this.id = str;
            setParam("id", str);
            return this;
        }

        public Builder setRecorderTypeKey(String str) {
            this.recorderTypeKey = str;
            return this;
        }

        public RemoteConnectionTypeRef build() {
            RemoteConnectionTypeRef remoteConnectionTypeRef;
            synchronized (RemoteConnectionTypeRef.class) {
                remoteConnectionTypeRef = new RemoteConnectionTypeRef(this);
            }
            return remoteConnectionTypeRef;
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

    public String getRecorderTypeKey() {
        return this.recorderTypeKey;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.href);
        parcel.writeString(this.recorderTypeKey);
    }

    private RemoteConnectionTypeRef(Parcel parcel) {
        this.id = parcel.readString();
        this.href = parcel.readString();
        this.recorderTypeKey = parcel.readString();
    }
}
