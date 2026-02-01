package com.ua.sdk.remoteconnection;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class RemoteConnectionPageImpl extends AbstractEntityList<RemoteConnection> {
    public static Parcelable.Creator<RemoteConnectionPageImpl> CREATOR = new Parcelable.Creator<RemoteConnectionPageImpl>() { // from class: com.ua.sdk.remoteconnection.RemoteConnectionPageImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteConnectionPageImpl createFromParcel(Parcel parcel) {
            return new RemoteConnectionPageImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteConnectionPageImpl[] newArray(int i) {
            return new RemoteConnectionPageImpl[i];
        }
    };
    private static final String LIST_KEY = "remote_connections";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public RemoteConnectionPageImpl() {
    }

    private RemoteConnectionPageImpl(Parcel parcel) {
        super(parcel);
    }
}
