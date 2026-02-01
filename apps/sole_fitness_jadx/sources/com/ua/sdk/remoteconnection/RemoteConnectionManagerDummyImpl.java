package com.ua.sdk.remoteconnection;

import com.ua.sdk.DeleteCallback;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.Link;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: classes2.dex */
public class RemoteConnectionManagerDummyImpl implements RemoteConnectionManager {
    private Map<Long, RemoteConnectionImpl> connectionMap = new HashMap();
    private Random random = new Random();

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionManager
    public Request deleteRemoteConnection(EntityRef<RemoteConnection> entityRef, DeleteCallback<RemoteConnectionRef> deleteCallback) {
        return null;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionManager
    public Request fetchRemoteConnection(EntityRef<RemoteConnection> entityRef, FetchCallback<RemoteConnection> fetchCallback) {
        return null;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionManager
    public Request fetchRemoteConnectionList(FetchCallback<EntityList<RemoteConnection>> fetchCallback) {
        return null;
    }

    public RemoteConnectionManagerDummyImpl() {
        long jNextLong;
        for (int i = 0; i < 14; i++) {
            do {
                jNextLong = this.random.nextLong();
            } while (this.connectionMap.containsKey(Long.valueOf(jNextLong)));
            this.connectionMap.put(Long.valueOf(jNextLong), createRemoteConnection(jNextLong));
        }
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionManager
    public RemoteConnectionPageImpl fetchRemoteConnectionList() throws UaException {
        RemoteConnectionPageImpl remoteConnectionPageImpl = new RemoteConnectionPageImpl();
        Iterator<Long> it = this.connectionMap.keySet().iterator();
        while (it.hasNext()) {
            remoteConnectionPageImpl.add(this.connectionMap.get(it.next()));
        }
        return remoteConnectionPageImpl;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionManager
    public RemoteConnection fetchRemoteConnection(EntityRef<RemoteConnection> entityRef) throws UaException {
        for (RemoteConnectionImpl remoteConnectionImpl : this.connectionMap.values()) {
            if (remoteConnectionImpl.getLinks("self").get(0).getId().equals(entityRef.getId())) {
                return remoteConnectionImpl;
            }
        }
        return null;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionManager
    public void deleteRemoteConnection(EntityRef<RemoteConnection> entityRef) throws UaException {
        for (Long l : this.connectionMap.keySet()) {
            if (this.connectionMap.get(l).getLinks("self").get(0).getId().equals(entityRef.getId())) {
                this.connectionMap.remove(l);
                return;
            }
        }
    }

    public RemoteConnectionImpl createRemoteConnection(long j) {
        long jAbs;
        RemoteConnectionImpl remoteConnectionImpl = new RemoteConnectionImpl();
        ArrayList<Link> arrayList = new ArrayList<>();
        long jAbs2 = Math.abs(this.random.nextLong());
        remoteConnectionImpl.setCreatedDateTime(new Date(jAbs2));
        do {
            jAbs = Math.abs(this.random.nextLong());
        } while (jAbs < jAbs2);
        remoteConnectionImpl.setLastSyncTime(new Date(jAbs));
        remoteConnectionImpl.setType(this.random.nextBoolean() ? "jawboneup" : "withings");
        arrayList.add(new Link("/vx/remoteconnection/" + j + "/", String.valueOf(j)));
        remoteConnectionImpl.setLinksForRelation("self", arrayList);
        int iAbs = Math.abs(this.random.nextInt());
        arrayList.add(new Link("/v7.0/user/" + iAbs + "/", String.valueOf(iAbs)));
        remoteConnectionImpl.setLinksForRelation("user", arrayList);
        return remoteConnectionImpl;
    }

    public void addConnection(RemoteConnectionImpl remoteConnectionImpl) {
        this.connectionMap.put(Long.valueOf(remoteConnectionImpl.getLinks("self").get(0).getId()), remoteConnectionImpl);
    }
}
