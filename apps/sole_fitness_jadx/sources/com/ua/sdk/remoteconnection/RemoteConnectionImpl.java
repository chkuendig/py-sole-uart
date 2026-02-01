package com.ua.sdk.remoteconnection;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.internal.Precondition;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes2.dex */
public class RemoteConnectionImpl extends ApiTransferObject implements RemoteConnection, Parcelable {
    public static Parcelable.Creator<RemoteConnectionImpl> CREATOR = new Parcelable.Creator<RemoteConnectionImpl>() { // from class: com.ua.sdk.remoteconnection.RemoteConnectionImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteConnectionImpl createFromParcel(Parcel parcel) {
            return new RemoteConnectionImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteConnectionImpl[] newArray(int i) {
            return new RemoteConnectionImpl[i];
        }
    };
    private Date mCreatedDateTime;
    private Date mLastSyncTime;
    private String mType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected RemoteConnectionImpl() {
    }

    protected RemoteConnectionImpl(RemoteConnection remoteConnection) throws NullPointerException {
        Precondition.isNotNull(remoteConnection, "remoteConnection");
        this.mCreatedDateTime = remoteConnection.getCreatedDateTime();
        this.mLastSyncTime = remoteConnection.getLastSyncTime();
        this.mType = remoteConnection.getType();
        if (remoteConnection instanceof RemoteConnectionImpl) {
            copyLinkMap(((RemoteConnectionImpl) remoteConnection).getLinkMap());
        }
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<RemoteConnection> getRef() {
        ArrayList<Link> links = getLinks("self");
        if (links == null || links.isEmpty()) {
            return null;
        }
        return new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnection
    public Date getCreatedDateTime() {
        return this.mCreatedDateTime;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnection
    public Date getLastSyncTime() {
        return this.mLastSyncTime;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnection
    public String getType() {
        return this.mType;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnection
    public void setCreatedDateTime(Date date) {
        this.mCreatedDateTime = date;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnection
    public void setLastSyncTime(Date date) {
        this.mLastSyncTime = date;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnection
    public void setType(String str) {
        this.mType = str;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.mCreatedDateTime.getTime());
        parcel.writeLong(this.mLastSyncTime.getTime());
        parcel.writeString(this.mType);
    }

    private RemoteConnectionImpl(Parcel parcel) {
        super(parcel);
        this.mCreatedDateTime = new Date(parcel.readLong());
        this.mLastSyncTime = new Date(parcel.readLong());
        this.mType = parcel.readString();
    }
}
