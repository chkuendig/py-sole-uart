package com.ua.sdk.route.bookmark;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.friendship.FriendshipImpl;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.route.RouteBookmark;

/* loaded from: classes2.dex */
public class RouteBookmarkTO extends ApiTransferObject {

    @SerializedName(FriendshipImpl.ARG_FROM_USER)
    public String fromUserHref;

    public static RouteBookmarkImpl fromTransferObject(RouteBookmarkTO routeBookmarkTO) {
        if (routeBookmarkTO == null) {
            return null;
        }
        RouteBookmarkImpl routeBookmarkImpl = new RouteBookmarkImpl();
        routeBookmarkImpl.setFromUserHref(routeBookmarkTO.fromUserHref);
        for (String str : routeBookmarkTO.getLinkKeys()) {
            routeBookmarkImpl.setLinksForRelation(str, routeBookmarkTO.getLinks(str));
        }
        return routeBookmarkImpl;
    }

    public static RouteBookmarkTO toTransferObject(RouteBookmark routeBookmark) {
        if (routeBookmark == null) {
            return null;
        }
        RouteBookmarkImpl routeBookmarkImpl = (RouteBookmarkImpl) routeBookmark;
        RouteBookmarkTO routeBookmarkTO = new RouteBookmarkTO();
        routeBookmarkTO.fromUserHref = routeBookmarkImpl.getFromUserHref();
        routeBookmarkTO.setLinkMap(routeBookmarkImpl.getLinkMap());
        return routeBookmarkTO;
    }
}
