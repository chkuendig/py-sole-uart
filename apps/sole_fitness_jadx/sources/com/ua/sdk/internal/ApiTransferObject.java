package com.ua.sdk.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.cache.EntityDatabase;
import com.ua.sdk.util.Utility;
import com.ua.sdk.util.Validate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class ApiTransferObject {
    public static final String LINK_SELF = "self";

    @SerializedName(EntityDatabase.LINKS.TABLE_SUFFIX)
    Map<String, ArrayList<Link>> mLinkMap;
    protected transient long mLocalId;

    public ApiTransferObject() {
        this.mLocalId = -1L;
    }

    protected ApiTransferObject(Parcel parcel) {
        this.mLocalId = -1L;
        Bundle bundle = parcel.readBundle(Link.class.getClassLoader());
        this.mLinkMap = new HashMap(0);
        for (String str : bundle.keySet()) {
            this.mLinkMap.put(str, bundle.getParcelableArrayList(str));
        }
        if (this.mLinkMap.isEmpty()) {
            this.mLinkMap = null;
        }
        this.mLocalId = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle;
        if (this.mLinkMap == null) {
            bundle = new Bundle(0);
        } else {
            bundle = new Bundle(this.mLinkMap.size());
            for (Map.Entry<String, ArrayList<Link>> entry : this.mLinkMap.entrySet()) {
                bundle.putParcelableArrayList(entry.getKey(), entry.getValue());
            }
        }
        parcel.writeBundle(bundle);
        parcel.writeLong(this.mLocalId);
    }

    public void setLocalId(long j) {
        this.mLocalId = j;
    }

    public long getLocalId() {
        return this.mLocalId;
    }

    protected String getHref() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return link.getHref();
    }

    public void setLinkMap(Map<String, ArrayList<Link>> map) {
        if (map == null || map.isEmpty()) {
            this.mLinkMap = null;
        } else {
            this.mLinkMap = map;
        }
    }

    public Map<String, ArrayList<Link>> getLinkMap() {
        return this.mLinkMap;
    }

    public void copyLinkMap(Map<String, ArrayList<Link>> map) {
        if (map == null) {
            this.mLinkMap = null;
            return;
        }
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<String, ArrayList<Link>> entry : map.entrySet()) {
            map2.put(entry.getKey(), new ArrayList(entry.getValue()));
        }
        this.mLinkMap = map2;
    }

    public void setLinksForRelation(String str, ArrayList<Link> arrayList) {
        if (this.mLinkMap == null) {
            this.mLinkMap = new HashMap(1);
        }
        this.mLinkMap.put(str, arrayList);
    }

    public void addLink(String str, Link link) {
        if (this.mLinkMap == null) {
            this.mLinkMap = new HashMap();
        }
        ArrayList<Link> arrayList = this.mLinkMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(link);
        this.mLinkMap.put(str, arrayList);
    }

    public void setLink(String str, Link link) {
        if (this.mLinkMap == null) {
            this.mLinkMap = new HashMap();
        }
        ArrayList<Link> arrayList = this.mLinkMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
        } else {
            arrayList.clear();
        }
        arrayList.add(link);
        this.mLinkMap.put(str, arrayList);
    }

    public ArrayList<Link> getLinks(String str) {
        Map<String, ArrayList<Link>> map = this.mLinkMap;
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    public Link getLink(String str) {
        Validate.notNull(str, SDKConstants.PARAM_KEY);
        return getLink(str, 0);
    }

    public Link getLink(String str, String str2) {
        ArrayList<Link> links = getLinks(str);
        if (links == null) {
            return null;
        }
        for (Link link : links) {
            if (Utility.isEqual(str2, link.getName(), true)) {
                return link;
            }
        }
        return null;
    }

    public Link getLink(String str, int i) {
        ArrayList<Link> links = getLinks(str);
        if (links == null || links.size() <= i) {
            return null;
        }
        return links.get(i);
    }

    public Set<String> getLinkKeys() {
        Map<String, ArrayList<Link>> map = this.mLinkMap;
        if (map == null) {
            return Collections.emptySet();
        }
        return map.keySet();
    }
}
