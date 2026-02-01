package com.ua.sdk.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.ua.sdk.EntityRef;
import com.ua.sdk.UaLog;
import com.ua.sdk.activitytype.ActivityType;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.privacy.PrivacyHelper;
import com.ua.sdk.user.User;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes2.dex */
public class RouteImpl extends ApiTransferObject implements Route, Parcelable {
    public static final Parcelable.Creator<RouteImpl> CREATOR = new Parcelable.Creator<RouteImpl>() { // from class: com.ua.sdk.route.RouteImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteImpl createFromParcel(Parcel parcel) {
            return new RouteImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteImpl[] newArray(int i) {
            return new RouteImpl[i];
        }
    };
    EntityRef<ActivityType> activityTypeRef;
    String city;
    ArrayList<Climb> climbs;
    String country;
    Date createdDate;
    String dataSource;
    String description;
    Double distanceMeters;
    Double maxElevation;
    Double minElevation;
    String name;
    String postalCode;
    Privacy privacy;
    ArrayList<Point> routePoints;
    EntityRef<Route> routeRef;
    String startPointType;
    StartingLocation startingLocation;
    String state;
    String thumbnailLink;
    Double totalAscent;
    Double totalDescent;
    Date updatedDate;
    EntityRef<User> userRef;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteImpl() {
        this.routePoints = new ArrayList<>();
        this.climbs = new ArrayList<>();
    }

    protected RouteImpl(RouteBuilderImpl routeBuilderImpl) {
        this.name = routeBuilderImpl.name;
        this.description = routeBuilderImpl.description;
        this.routePoints = routeBuilderImpl.points;
        this.startPointType = routeBuilderImpl.startPointType;
        this.postalCode = routeBuilderImpl.postalCode;
    }

    @Override // com.ua.sdk.route.Route
    public String getCity() {
        return this.city;
    }

    @Override // com.ua.sdk.route.Route
    public String getCountry() {
        return this.country;
    }

    @Override // com.ua.sdk.route.Route
    public String getState() {
        return this.state;
    }

    public StartingLocation getStartingLocation() {
        return this.startingLocation;
    }

    @Override // com.ua.sdk.route.Route
    public Double getStartingLatitude() {
        return Double.valueOf(this.startingLocation.coordinates[0]);
    }

    @Override // com.ua.sdk.route.Route
    public Double getStartingLongitude() {
        return Double.valueOf(this.startingLocation.coordinates[1]);
    }

    @Override // com.ua.sdk.route.Route
    public String getStartPointType() {
        return this.startPointType;
    }

    @Override // com.ua.sdk.route.Route
    public String getPostalCode() {
        return this.postalCode;
    }

    @Override // com.ua.sdk.route.Route
    public Double getDistanceMeters() {
        return this.distanceMeters;
    }

    @Override // com.ua.sdk.route.Route
    public String getName() {
        return this.name;
    }

    @Override // com.ua.sdk.route.Route
    public String getDescription() {
        return this.description;
    }

    @Override // com.ua.sdk.route.Route
    public String getDataSource() {
        return this.dataSource;
    }

    @Override // com.ua.sdk.route.Route
    public Date getCreatedDate() {
        return this.createdDate;
    }

    @Override // com.ua.sdk.route.Route
    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    @Override // com.ua.sdk.route.Route
    public Point getPointAt(int i) {
        return this.routePoints.get(i);
    }

    @Override // com.ua.sdk.route.Route
    public Double getLatitudeAt(int i) {
        return this.routePoints.get(i).getLatitude();
    }

    @Override // com.ua.sdk.route.Route
    public Double getLongitudeAt(int i) {
        return this.routePoints.get(i).getLongitude();
    }

    @Override // com.ua.sdk.route.Route
    public Double getElevationAt(int i) {
        return this.routePoints.get(i).getElevation();
    }

    @Override // com.ua.sdk.route.Route
    public Double getDistanceAt(int i) {
        return this.routePoints.get(i).getDistanceMeters();
    }

    @Override // com.ua.sdk.route.Route
    public int getTotalPoints() {
        return this.routePoints.size();
    }

    @Override // com.ua.sdk.route.Route
    public ArrayList<Climb> getClimbs() {
        return this.climbs;
    }

    @Override // com.ua.sdk.route.Route
    public Double getTotalAscent() {
        return this.totalAscent;
    }

    @Override // com.ua.sdk.route.Route
    public Double getTotalDescent() {
        return this.totalDescent;
    }

    @Override // com.ua.sdk.route.Route
    public Double getMinElevation() {
        return this.minElevation;
    }

    @Override // com.ua.sdk.route.Route
    public Double getMaxElevation() {
        return this.maxElevation;
    }

    @Override // com.ua.sdk.route.Route
    public Privacy getPrivacy() {
        ArrayList<Link> links;
        if (this.privacy == null && (links = getLinks(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)) != null) {
            try {
                this.privacy = PrivacyHelper.getPrivacyFromId(Integer.parseInt(links.get(0).getId()));
            } catch (NumberFormatException e) {
                UaLog.error("Unable to get privacy.", (Throwable) e);
                return null;
            }
        }
        return this.privacy;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setPostalCode(String str) {
        this.postalCode = str;
    }

    public void setDistanceMeters(Double d) {
        this.distanceMeters = d;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDataSource(String str) {
        this.dataSource = str;
    }

    public void setCreatedDate(Date date) {
        this.createdDate = date;
    }

    public void setUpdatedDate(Date date) {
        this.updatedDate = date;
    }

    public void setTotalAscent(Double d) {
        this.totalAscent = d;
    }

    public void setTotalDescent(Double d) {
        this.totalDescent = d;
    }

    public void setMinElevation(Double d) {
        this.minElevation = d;
    }

    public void setMaxElevation(Double d) {
        this.maxElevation = d;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public void setUserRef(EntityRef<User> entityRef) {
        this.userRef = entityRef;
    }

    public void setRouteRef(EntityRef<Route> entityRef) {
        this.routeRef = entityRef;
    }

    public void setActivityTypeRef(EntityRef<ActivityType> entityRef) {
        this.activityTypeRef = entityRef;
    }

    public void setStartPointType(String str) {
        this.startPointType = str;
    }

    public void setStartingLocation(StartingLocation startingLocation) {
        this.startingLocation = startingLocation;
    }

    public void setThumbnailLink(String str) {
        this.thumbnailLink = str;
    }

    public void setRoutePoints(ArrayList<Point> arrayList) {
        this.routePoints = arrayList;
    }

    public void setClimbs(ArrayList<Climb> arrayList) {
        this.climbs = arrayList;
    }

    @Override // com.ua.sdk.route.Route
    public EntityRef<User> getUserRef() {
        ArrayList<Link> links;
        if (this.userRef == null && (links = getLinks("user")) != null) {
            this.userRef = new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
        }
        return this.userRef;
    }

    @Override // com.ua.sdk.route.Route
    public EntityRef<ActivityType> getActivityTypeRef() {
        ArrayList<Link> links;
        if (this.activityTypeRef == null && (links = getLinks("activity_type")) != null) {
            this.activityTypeRef = new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
        }
        return this.activityTypeRef;
    }

    @Override // com.ua.sdk.route.Route
    public String getThumbnailLink() {
        ArrayList<Link> links;
        if (this.thumbnailLink == null && (links = getLinks("thumbnail")) != null) {
            this.thumbnailLink = links.get(0).getHref();
        }
        return this.thumbnailLink;
    }

    @Override // com.ua.sdk.Resource
    public RouteRef getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new RouteRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.city);
        parcel.writeString(this.country);
        parcel.writeString(this.state);
        parcel.writeString(this.postalCode);
        parcel.writeValue(this.distanceMeters);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.dataSource);
        Date date = this.createdDate;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        Date date2 = this.updatedDate;
        parcel.writeLong(date2 != null ? date2.getTime() : -1L);
        parcel.writeValue(this.totalAscent);
        parcel.writeValue(this.totalDescent);
        parcel.writeValue(this.minElevation);
        parcel.writeValue(this.maxElevation);
        parcel.writeString(this.thumbnailLink);
        parcel.writeList(this.routePoints);
        parcel.writeList(this.climbs);
        parcel.writeLong(this.mLocalId);
        parcel.writeString(this.startPointType);
        parcel.writeParcelable(this.startingLocation, i);
        parcel.writeParcelable(this.userRef, i);
        parcel.writeParcelable(this.routeRef, i);
        parcel.writeParcelable(this.activityTypeRef, i);
        parcel.writeParcelable(this.privacy, i);
    }

    private RouteImpl(Parcel parcel) {
        super(parcel);
        this.city = parcel.readString();
        this.country = parcel.readString();
        this.state = parcel.readString();
        this.postalCode = parcel.readString();
        this.distanceMeters = (Double) parcel.readValue(Double.class.getClassLoader());
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.dataSource = parcel.readString();
        long j = parcel.readLong();
        this.createdDate = j == -1 ? null : new Date(j);
        long j2 = parcel.readLong();
        this.updatedDate = j2 != -1 ? new Date(j2) : null;
        this.totalAscent = (Double) parcel.readValue(Double.class.getClassLoader());
        this.totalDescent = (Double) parcel.readValue(Double.class.getClassLoader());
        this.minElevation = (Double) parcel.readValue(Double.class.getClassLoader());
        this.maxElevation = (Double) parcel.readValue(Double.class.getClassLoader());
        this.thumbnailLink = parcel.readString();
        this.routePoints = parcel.readArrayList(PointImpl.class.getClassLoader());
        this.climbs = parcel.readArrayList(ClimbImpl.class.getClassLoader());
        this.mLocalId = parcel.readLong();
        this.startPointType = parcel.readString();
        this.startingLocation = (StartingLocation) parcel.readParcelable(StartingLocation.class.getClassLoader());
        this.userRef = (EntityRef) parcel.readParcelable(LinkEntityRef.class.getClassLoader());
        this.routeRef = (EntityRef) parcel.readParcelable(LinkEntityRef.class.getClassLoader());
        this.activityTypeRef = (EntityRef) parcel.readParcelable(LinkEntityRef.class.getClassLoader());
        this.privacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
    }
}
