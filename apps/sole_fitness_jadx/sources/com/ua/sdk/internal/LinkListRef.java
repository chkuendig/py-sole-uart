package com.ua.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;

/* loaded from: classes2.dex */
public class LinkListRef<E> implements EntityListRef<E> {
    public static final Parcelable.Creator<LinkListRef> CREATOR = new Parcelable.Creator<LinkListRef>() { // from class: com.ua.sdk.internal.LinkListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkListRef createFromParcel(Parcel parcel) {
            return new LinkListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkListRef[] newArray(int i) {
            return new LinkListRef[i];
        }
    };
    private final String href;
    private final long localId;

    public boolean checkCache() {
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LinkListRef(String str) {
        this.href = str;
        this.localId = -1L;
    }

    public LinkListRef(long j, String str) {
        this.href = str;
        this.localId = j;
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public long getLocalId() {
        return this.localId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.localId);
        parcel.writeString(this.href);
    }

    protected LinkListRef(Parcel parcel) {
        this.localId = parcel.readLong();
        this.href = parcel.readString();
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return getHref();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LinkListRef linkListRef = (LinkListRef) obj;
        if (this.localId != linkListRef.localId) {
            return false;
        }
        String str = this.href;
        String str2 = linkListRef.href;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.href;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.localId;
        return (iHashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}
