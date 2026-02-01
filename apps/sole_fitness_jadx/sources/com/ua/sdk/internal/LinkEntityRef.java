package com.ua.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;

/* loaded from: classes2.dex */
public class LinkEntityRef<T> implements EntityRef<T> {
    public static final Parcelable.Creator<LinkEntityRef> CREATOR = new Parcelable.Creator<LinkEntityRef>() { // from class: com.ua.sdk.internal.LinkEntityRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkEntityRef createFromParcel(Parcel parcel) {
            return new LinkEntityRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkEntityRef[] newArray(int i) {
            return new LinkEntityRef[i];
        }
    };
    protected final String href;
    protected final String id;
    protected final long localId;
    protected final int options;

    public boolean checkCache() {
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LinkEntityRef(String str) {
        this(null, str);
    }

    public LinkEntityRef(String str, String str2) {
        this.id = str;
        this.href = str2;
        this.localId = -1L;
        this.options = 0;
    }

    public LinkEntityRef(String str, long j, String str2) {
        this.id = str;
        this.href = str2;
        this.localId = j;
        this.options = 0;
    }

    public LinkEntityRef(String str, long j, String str2, int i) {
        this.id = str;
        this.href = str2;
        this.localId = j;
        this.options = i;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return this.id;
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public long getLocalId() {
        return this.localId;
    }

    public int getOptions() {
        return this.options;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeLong(this.localId);
        parcel.writeString(this.href);
        parcel.writeInt(this.options);
    }

    protected LinkEntityRef(Parcel parcel) {
        this.id = parcel.readString();
        this.localId = parcel.readLong();
        this.href = parcel.readString();
        this.options = parcel.readInt();
    }
}
