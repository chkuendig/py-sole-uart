package com.ua.sdk.route;

import com.facebook.appevents.UserDataStore;
import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class RouteTO extends ApiTransferObject {

    @SerializedName("city")
    String city;

    @SerializedName("climbs")
    List<ClimbImpl> climbs;

    @SerializedName(UserDataStore.COUNTRY)
    String country;

    @SerializedName("created_datetime")
    Date createdDate;

    @SerializedName("data_source")
    String dataSource;

    @SerializedName("description")
    String description;

    @SerializedName("distance")
    Double distanceMeters;

    @SerializedName("max_elevation")
    Double maxElevation;

    @SerializedName("min_elevation")
    Double minElevation;

    @SerializedName("name")
    String name;

    @SerializedName("postal_code")
    String postalCode;

    @SerializedName("points")
    List<PointImpl> routePoints;

    @SerializedName("start_point_type")
    String startPointType;

    @SerializedName("starting_location")
    StartingLocation startingLocation;

    @SerializedName(ServerProtocol.DIALOG_PARAM_STATE)
    String state;

    @SerializedName("total_ascent")
    Double totalAscent;

    @SerializedName("total_descent")
    Double totalDescent;

    @SerializedName("updated_datetime")
    Date updatedDate;

    public static RouteImpl fromTransferObject(RouteTO routeTO) {
        if (routeTO == null) {
            return null;
        }
        RouteImpl routeImpl = new RouteImpl();
        routeImpl.setCity(routeTO.city);
        routeImpl.setCountry(routeTO.country);
        routeImpl.setState(routeTO.state);
        routeImpl.setPostalCode(routeTO.postalCode);
        routeImpl.setDistanceMeters(routeTO.distanceMeters);
        routeImpl.setName(routeTO.name);
        routeImpl.setDescription(routeTO.description);
        routeImpl.setDataSource(routeTO.dataSource);
        routeImpl.setCreatedDate(routeTO.createdDate);
        routeImpl.setUpdatedDate(routeTO.updatedDate);
        routeImpl.setTotalAscent(routeTO.totalAscent);
        routeImpl.setTotalDescent(routeTO.totalDescent);
        routeImpl.setMinElevation(routeTO.minElevation);
        routeImpl.setMaxElevation(routeTO.maxElevation);
        routeImpl.setStartPointType(routeTO.startPointType);
        routeImpl.setStartingLocation(routeTO.startingLocation);
        if (routeTO.routePoints != null) {
            routeImpl.routePoints.addAll(routeTO.routePoints);
        }
        if (routeTO.climbs != null) {
            routeImpl.climbs.addAll(routeTO.climbs);
        }
        for (String str : routeTO.getLinkKeys()) {
            routeImpl.setLinksForRelation(str, routeTO.getLinks(str));
        }
        return routeImpl;
    }

    public static RouteTO toTransferObject(Route route) {
        if (route == null) {
            return null;
        }
        RouteImpl routeImpl = (RouteImpl) route;
        RouteTO routeTO = new RouteTO();
        routeTO.city = routeImpl.getCity();
        routeTO.country = routeImpl.getCountry();
        routeTO.state = routeImpl.getState();
        routeTO.postalCode = routeImpl.getPostalCode();
        routeTO.distanceMeters = routeImpl.getDistanceMeters();
        routeTO.name = routeImpl.getName();
        routeTO.description = routeImpl.getDescription();
        routeTO.dataSource = routeImpl.getDataSource();
        routeTO.createdDate = routeImpl.getCreatedDate();
        routeTO.updatedDate = routeImpl.getUpdatedDate();
        routeTO.totalAscent = routeImpl.getTotalAscent();
        routeTO.totalDescent = routeImpl.getTotalDescent();
        routeTO.minElevation = routeImpl.getMinElevation();
        routeTO.maxElevation = routeImpl.getMaxElevation();
        routeTO.startPointType = routeImpl.getStartPointType();
        routeTO.startingLocation = routeImpl.getStartingLocation();
        if (routeImpl.routePoints != null) {
            routeTO.routePoints = new ArrayList();
            Iterator<Point> it = routeImpl.routePoints.iterator();
            while (it.hasNext()) {
                routeTO.routePoints.add((PointImpl) it.next());
            }
        }
        if (routeImpl.climbs != null) {
            routeTO.climbs = new ArrayList();
            Iterator<Climb> it2 = routeImpl.climbs.iterator();
            while (it2.hasNext()) {
                routeTO.climbs.add((ClimbImpl) it2.next());
            }
        }
        routeTO.setLinkMap(routeImpl.getLinkMap());
        return routeTO;
    }
}
