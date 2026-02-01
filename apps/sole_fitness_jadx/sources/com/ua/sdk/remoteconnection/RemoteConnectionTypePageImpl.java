package com.ua.sdk.remoteconnection;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class RemoteConnectionTypePageImpl extends AbstractEntityList<RemoteConnectionType> {
    public static Parcelable.Creator<RemoteConnectionTypePageImpl> CREATOR = new Parcelable.Creator<RemoteConnectionTypePageImpl>() { // from class: com.ua.sdk.remoteconnection.RemoteConnectionTypePageImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteConnectionTypePageImpl createFromParcel(Parcel parcel) {
            return new RemoteConnectionTypePageImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteConnectionTypePageImpl[] newArray(int i) {
            return new RemoteConnectionTypePageImpl[i];
        }
    };
    private static final String LIST_KEY = "remote_connection_types";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public RemoteConnectionTypePageImpl() {
    }

    private RemoteConnectionTypePageImpl(Parcel parcel) {
        super(parcel);
    }
}
