package com.ua.sdk.route;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.cache.EntityDatabase;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class RoutePageTO extends ApiTransferObject {
    public static final String KEY_ROUTES = "routes";

    @SerializedName("_embedded")
    public Map<String, ArrayList<RouteTO>> routes;

    @SerializedName(EntityDatabase.LIST.COLS.TOTAL_COUNT)
    public Integer totalRoutesCount;

    private ArrayList<RouteTO> getRoutesList() {
        Map<String, ArrayList<RouteTO>> map = this.routes;
        if (map == null) {
            return null;
        }
        return map.get("routes");
    }

    public static RouteList fromTransferObject(RoutePageTO routePageTO) {
        RouteList routeList = new RouteList();
        Iterator<RouteTO> it = routePageTO.getRoutesList().iterator();
        while (it.hasNext()) {
            routeList.add(RouteTO.fromTransferObject(it.next()));
        }
        routeList.setLinkMap(routePageTO.getLinkMap());
        routeList.setTotalCount(routePageTO.totalRoutesCount.intValue());
        return routeList;
    }
}
