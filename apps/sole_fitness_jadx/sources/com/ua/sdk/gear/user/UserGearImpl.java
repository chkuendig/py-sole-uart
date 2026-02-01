package com.ua.sdk.gear.user;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.LocalDate;
import com.ua.sdk.activitytype.ActivityType;
import com.ua.sdk.gear.Gear;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.user.User;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class UserGearImpl extends ApiTransferObject implements UserGear {
    public static final Parcelable.Creator<UserGearImpl> CREATOR = new Parcelable.Creator<UserGearImpl>() { // from class: com.ua.sdk.gear.user.UserGearImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserGearImpl createFromParcel(Parcel parcel) {
            return new UserGearImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserGearImpl[] newArray(int i) {
            return new UserGearImpl[i];
        }
    };
    private static final String REF_DEFAULT_ACTIVITIES = "default_activities";
    private static final String REF_SELF = "self";
    private static final String REF_USER = "user";

    @SerializedName("current_distance")
    Double currentDistance;

    @SerializedName("gear")
    Gear gear;

    @SerializedName("initial_distance")
    Double initialDistance;

    @SerializedName("retired")
    Boolean isRetired;

    @SerializedName("name")
    String name;

    @SerializedName("purchase_date")
    LocalDate purchaseDate;

    @SerializedName("target_distance")
    Double targetDistance;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserGearImpl() {
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public Gear getGear() {
        return this.gear;
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public String getName() {
        return this.name;
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public Double getInitialDistance() {
        return this.initialDistance;
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public Double getTargetDistance() {
        return this.targetDistance;
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public LocalDate getPurchaseDate() {
        return this.purchaseDate;
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public Double getCurrentDistance() {
        return this.currentDistance;
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public Boolean isRetired() {
        return this.isRetired;
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public EntityRef<User> getUser() {
        Link link = getLink("user");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public List<EntityRef<ActivityType>> getDefaultActivities() {
        ArrayList<Link> links = getLinks(REF_DEFAULT_ACTIVITIES);
        if (links == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(links.size());
        for (Link link : links) {
            arrayList.add(new LinkEntityRef(link.getId(), link.getHref()));
        }
        return arrayList;
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public void setGear(Gear gear) {
        this.gear = gear;
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public void setName(String str) {
        this.name = str;
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public void setPurchaseDate(LocalDate localDate) {
        this.purchaseDate = localDate;
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public void setInitialDistance(Double d) {
        this.initialDistance = d;
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public void setTargetDistance(Double d) {
        this.targetDistance = d;
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public void setDefaultActivities(List<EntityRef<ActivityType>> list) {
        for (EntityRef<ActivityType> entityRef : list) {
            addLink(REF_DEFAULT_ACTIVITIES, new Link(entityRef.getHref(), entityRef.getId()));
        }
    }

    @Override // com.ua.sdk.gear.user.UserGear
    public void setRetired(Boolean bool) {
        this.isRetired = bool;
    }

    @Override // com.ua.sdk.Resource
    public UserGearRef getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new UserGearRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.gear, 0);
        parcel.writeString(this.name);
        parcel.writeValue(this.initialDistance);
        parcel.writeValue(this.targetDistance);
        parcel.writeParcelable(this.purchaseDate, 0);
        parcel.writeValue(this.currentDistance);
        parcel.writeValue(this.isRetired);
    }

    private UserGearImpl(Parcel parcel) {
        super(parcel);
        this.gear = (Gear) parcel.readParcelable(Gear.class.getClassLoader());
        this.name = parcel.readString();
        this.initialDistance = (Double) parcel.readValue(Double.class.getClassLoader());
        this.targetDistance = (Double) parcel.readValue(Double.class.getClassLoader());
        this.purchaseDate = (LocalDate) parcel.readParcelable(LocalDate.class.getClassLoader());
        this.currentDistance = (Double) parcel.readValue(Double.class.getClassLoader());
        this.isRetired = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }
}
