package com.ua.sdk.remoteconnection;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.Date;

/* loaded from: classes2.dex */
public class RemoteConnectionTransferObject extends ApiTransferObject {

    @SerializedName("created_datetime")
    Date createdDatetime;

    @SerializedName("last_sync_time")
    Date lastSyncTime;

    @SerializedName("type")
    String type;

    public static RemoteConnectionTransferObject fromRemoteConnection(RemoteConnection remoteConnection) {
        if (remoteConnection == null) {
            return null;
        }
        RemoteConnectionTransferObject remoteConnectionTransferObject = new RemoteConnectionTransferObject();
        remoteConnectionTransferObject.createdDatetime = remoteConnection.getCreatedDateTime();
        remoteConnectionTransferObject.lastSyncTime = remoteConnection.getLastSyncTime();
        remoteConnectionTransferObject.type = remoteConnection.getType();
        if (remoteConnection instanceof RemoteConnectionImpl) {
            remoteConnectionTransferObject.setLinkMap(((RemoteConnectionImpl) remoteConnection).getLinkMap());
        }
        return remoteConnectionTransferObject;
    }

    public static RemoteConnectionImpl toRemoteConnectionImpl(RemoteConnectionTransferObject remoteConnectionTransferObject) throws UaException {
        if (remoteConnectionTransferObject == null) {
            return null;
        }
        RemoteConnectionImpl remoteConnectionImpl = new RemoteConnectionImpl();
        remoteConnectionImpl.setCreatedDateTime(remoteConnectionTransferObject.createdDatetime);
        remoteConnectionImpl.setLastSyncTime(remoteConnectionTransferObject.lastSyncTime);
        remoteConnectionImpl.setType(remoteConnectionTransferObject.type);
        for (String str : remoteConnectionTransferObject.getLinkKeys()) {
            remoteConnectionImpl.setLinksForRelation(str, remoteConnectionTransferObject.getLinks(str));
        }
        return remoteConnectionImpl;
    }
}
