package com.ua.sdk.page;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.cache.EntityDatabase;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class PagePageTO extends ApiTransferObject {
    public static final String KEY_PAGE = "pages";

    @SerializedName("_embedded")
    public Map<String, ArrayList<PageTO>> pages;

    @SerializedName(EntityDatabase.LIST.COLS.TOTAL_COUNT)
    public Integer totalPagesCount;

    private ArrayList<PageTO> getPageList() {
        Map<String, ArrayList<PageTO>> map = this.pages;
        if (map == null) {
            return null;
        }
        return map.get("pages");
    }

    public static PageListImpl toPage(PagePageTO pagePageTO) {
        PageListImpl pageListImpl = new PageListImpl();
        Iterator<PageTO> it = pagePageTO.getPageList().iterator();
        while (it.hasNext()) {
            try {
                pageListImpl.add(PageTO.toPageImpl(it.next()));
            } catch (UaException e) {
                UaLog.error("Error converting PageTO to PageImpl.", (Throwable) e);
            }
        }
        pageListImpl.setLinkMap(pagePageTO.getLinkMap());
        pageListImpl.setTotalCount(pagePageTO.totalPagesCount.intValue());
        return pageListImpl;
    }
}
