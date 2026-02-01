package com.ua.sdk.remoteconnection;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.cache.EntityDatabase;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class RemoteConnectionTypePageTO extends ApiTransferObject {
    public static final String KEY_REMOTE_CONNECTION_TYPE = "remoteconnectiontypes";

    @SerializedName("_embedded")
    Map<String, ArrayList<RemoteConnectionTypeTransferObject>> remoteConnectionTypes;

    @SerializedName(EntityDatabase.LIST.COLS.TOTAL_COUNT)
    Integer totalCount;

    private List<RemoteConnectionTypeTransferObject> getRemoteConnectionTypeList() {
        Map<String, ArrayList<RemoteConnectionTypeTransferObject>> map = this.remoteConnectionTypes;
        if (map == null) {
            return null;
        }
        return map.get(KEY_REMOTE_CONNECTION_TYPE);
    }

    public static RemoteConnectionTypeListImpl fromTransferObject(RemoteConnectionTypePageTO remoteConnectionTypePageTO) {
        RemoteConnectionTypeListImpl remoteConnectionTypeListImpl = new RemoteConnectionTypeListImpl();
        Iterator<RemoteConnectionTypeTransferObject> it = remoteConnectionTypePageTO.getRemoteConnectionTypeList().iterator();
        while (it.hasNext()) {
            try {
                remoteConnectionTypeListImpl.add(RemoteConnectionTypeTransferObject.toRemoteConnectionTypeImpl(it.next()));
            } catch (UaException e) {
                UaLog.error("Error converting RemoteConnectionTypeTransferObject to RemoteConnectionTypeImpl.", (Throwable) e);
            }
        }
        remoteConnectionTypeListImpl.setLinkMap(remoteConnectionTypePageTO.getLinkMap());
        remoteConnectionTypeListImpl.setTotalCount(remoteConnectionTypePageTO.totalCount.intValue());
        return remoteConnectionTypeListImpl;
    }
}
