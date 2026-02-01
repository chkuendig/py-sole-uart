package com.ua.sdk.remoteconnection;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityList;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.cache.EntityDatabase;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class RemoteConnectionPageTO extends ApiTransferObject {
    public static final String KEY_REMOTE_CONNECTIONS = "remoteconnections";

    @SerializedName("_embedded")
    public Map<String, ArrayList<RemoteConnectionTransferObject>> remoteConnections;

    @SerializedName(EntityDatabase.LIST.COLS.TOTAL_COUNT)
    public Integer totalRemoteConnectionsCount;

    private ArrayList<RemoteConnectionTransferObject> getRemoteConnectionList() {
        Map<String, ArrayList<RemoteConnectionTransferObject>> map = this.remoteConnections;
        if (map == null) {
            return null;
        }
        return map.get(KEY_REMOTE_CONNECTIONS);
    }

    public static RemoteConnectionPageTO fromPage(EntityList<RemoteConnection> entityList) {
        if (entityList == null) {
            return null;
        }
        RemoteConnectionPageTO remoteConnectionPageTO = new RemoteConnectionPageTO();
        Iterator<RemoteConnection> it = entityList.getAll().iterator();
        while (it.hasNext()) {
            remoteConnectionPageTO.getRemoteConnectionList().add(RemoteConnectionTransferObject.fromRemoteConnection(it.next()));
        }
        if (entityList instanceof RemoteConnectionListImpl) {
            remoteConnectionPageTO.setLinkMap(((RemoteConnectionListImpl) entityList).getLinkMap());
        }
        remoteConnectionPageTO.totalRemoteConnectionsCount = Integer.valueOf(entityList.getTotalCount());
        return remoteConnectionPageTO;
    }

    public static RemoteConnectionListImpl toPage(RemoteConnectionPageTO remoteConnectionPageTO) {
        RemoteConnectionListImpl remoteConnectionListImpl = new RemoteConnectionListImpl();
        Iterator<RemoteConnectionTransferObject> it = remoteConnectionPageTO.getRemoteConnectionList().iterator();
        while (it.hasNext()) {
            try {
                remoteConnectionListImpl.add(RemoteConnectionTransferObject.toRemoteConnectionImpl(it.next()));
            } catch (UaException e) {
                UaLog.error("Error converting RemoteConnectionTransferObject to RemoteConnectionImpl.", (Throwable) e);
            }
        }
        remoteConnectionListImpl.setLinkMap(remoteConnectionPageTO.getLinkMap());
        remoteConnectionListImpl.setTotalCount(remoteConnectionPageTO.totalRemoteConnectionsCount.intValue());
        return remoteConnectionListImpl;
    }
}
