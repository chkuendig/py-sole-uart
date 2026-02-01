package com.ua.sdk.route.bookmark;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.cache.EntityDatabase;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class RouteBookmarkListTO {
    private static final String LIST_KEY = "route_bookmarks";

    @SerializedName("_embedded")
    Map<String, List<RouteBookmarkTO>> embedded;

    @SerializedName(EntityDatabase.LIST.COLS.TOTAL_COUNT)
    Integer totalCount;

    public List<RouteBookmarkTO> getRouteBookmarks() {
        return this.embedded.get(LIST_KEY);
    }

    public static RouteBookmarkList fromTransferObject(RouteBookmarkListTO routeBookmarkListTO) {
        List<RouteBookmarkTO> routeBookmarks = routeBookmarkListTO.getRouteBookmarks();
        if (routeBookmarks == null) {
            return null;
        }
        RouteBookmarkList routeBookmarkList = new RouteBookmarkList();
        Iterator<RouteBookmarkTO> it = routeBookmarks.iterator();
        while (it.hasNext()) {
            routeBookmarkList.add(RouteBookmarkTO.fromTransferObject(it.next()));
        }
        return routeBookmarkList;
    }
}
