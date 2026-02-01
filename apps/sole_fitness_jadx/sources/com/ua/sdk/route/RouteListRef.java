package com.ua.sdk.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.user.User;

/* loaded from: classes2.dex */
public class RouteListRef implements EntityListRef<Route>, Parcelable {
    public static final Parcelable.Creator<RouteListRef> CREATOR = new Parcelable.Creator<RouteListRef>() { // from class: com.ua.sdk.route.RouteListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteListRef createFromParcel(Parcel parcel) {
            return new RouteListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteListRef[] newArray(int i) {
            return new RouteListRef[i];
        }
    };
    private String href;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    private RouteListRef(Builder builder) throws NullPointerException {
        Precondition.isNotNull(builder);
        this.href = builder.getHref();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends BaseReferenceBuilder {
        private String city;
        private String country;
        private String fieldSet;
        private double latitude;
        private double longitude;
        private double maxDistance;
        private double minDistance;
        private Privacy.Level privacy;
        private double radius;
        private String state;
        private EntityRef<User> user;

        protected Builder() {
            super("/v7.0/route/");
        }

        public Builder setUser(EntityRef<User> entityRef) {
            this.user = entityRef;
            setParam("user", entityRef.getId());
            return this;
        }

        public Builder setLocation(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
            setParam("close_to_location", String.format("%f,%f", Double.valueOf(d), Double.valueOf(this.longitude)));
            return this;
        }

        public Builder setRadius(double d) {
            this.radius = d;
            setParam("search_radius", String.valueOf(d));
            return this;
        }

        public Builder setMinDistance(double d) {
            this.minDistance = d;
            setParam("minimum_distance", String.valueOf(d));
            return this;
        }

        public Builder setMaxDistance(double d) {
            this.maxDistance = d;
            setParam("maximum_distance", String.valueOf(d));
            return this;
        }

        public Builder setPrivacy(Privacy.Level level) {
            this.privacy = level;
            setParam(ShareConstants.WEB_DIALOG_PARAM_PRIVACY, level.id);
            return this;
        }

        public Builder setCity(String str) {
            this.city = str;
            setParam("city", String.valueOf(str));
            return this;
        }

        public Builder setState(String str) {
            this.state = str;
            setParam(ServerProtocol.DIALOG_PARAM_STATE, String.valueOf(str));
            return this;
        }

        public Builder setCountry(String str) {
            this.country = str;
            setParam(UserDataStore.COUNTRY, String.valueOf(str));
            return this;
        }

        public Builder setFieldSet(String str) {
            this.fieldSet = str;
            setParam("field_set", String.valueOf(str));
            return this;
        }

        public RouteListRef build() {
            if (getParam("user") == null && getParam("close_to_location") == null) {
                throw new IllegalStateException("Must specify either user or location.");
            }
            return new RouteListRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private RouteListRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
