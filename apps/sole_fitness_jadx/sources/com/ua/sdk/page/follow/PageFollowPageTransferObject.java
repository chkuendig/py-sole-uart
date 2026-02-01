package com.ua.sdk.page.follow;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.cache.EntityDatabase;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class PageFollowPageTransferObject extends ApiTransferObject {
    public static final String KEY_PAGE_FOLLOWS = "page_follows";

    @SerializedName("_embedded")
    public Map<String, ArrayList<PageFollowTransferObject>> pageFollows;

    @SerializedName(EntityDatabase.LIST.COLS.TOTAL_COUNT)
    public Integer totalPageFollowsCount;

    private ArrayList<PageFollowTransferObject> getPageFollowList() {
        Map<String, ArrayList<PageFollowTransferObject>> map = this.pageFollows;
        if (map == null) {
            return null;
        }
        return map.get("page_follows");
    }

    public static PageFollowPageTransferObject fromPage(PageFollowsListImpl pageFollowsListImpl) {
        if (pageFollowsListImpl == null) {
            return null;
        }
        PageFollowPageTransferObject pageFollowPageTransferObject = new PageFollowPageTransferObject();
        Iterator<PageFollow> it = pageFollowsListImpl.getAll().iterator();
        while (it.hasNext()) {
            pageFollowPageTransferObject.pageFollows.get("page_follows").add(PageFollowTransferObject.fromPageFollow(it.next()));
        }
        if (pageFollowsListImpl instanceof PageFollowsListImpl) {
            pageFollowPageTransferObject.setLinkMap(pageFollowsListImpl.getLinkMap());
        }
        pageFollowPageTransferObject.totalPageFollowsCount = Integer.valueOf(pageFollowsListImpl.getTotalCount());
        return pageFollowPageTransferObject;
    }

    public static PageFollowsListImpl toPage(PageFollowPageTransferObject pageFollowPageTransferObject) {
        PageFollowsListImpl pageFollowsListImpl = new PageFollowsListImpl();
        Iterator<PageFollowTransferObject> it = pageFollowPageTransferObject.getPageFollowList().iterator();
        while (it.hasNext()) {
            try {
                pageFollowsListImpl.add(PageFollowTransferObject.toPageFollowImpl(it.next()));
            } catch (UaException e) {
                UaLog.error("Error converting PageFollowTransferObject to PageFollowImpl.", (Throwable) e);
            }
        }
        pageFollowsListImpl.setLinkMap(pageFollowPageTransferObject.getLinkMap());
        pageFollowsListImpl.setTotalCount(pageFollowPageTransferObject.totalPageFollowsCount.intValue());
        return pageFollowsListImpl;
    }
}
