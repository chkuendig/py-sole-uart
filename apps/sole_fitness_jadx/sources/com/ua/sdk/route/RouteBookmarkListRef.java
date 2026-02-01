package com.ua.sdk.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;

/* loaded from: classes2.dex */
public class RouteBookmarkListRef implements EntityListRef<RouteBookmark> {
    public static Parcelable.Creator<RouteBookmarkListRef> CREATOR = new Parcelable.Creator<RouteBookmarkListRef>() { // from class: com.ua.sdk.route.RouteBookmarkListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteBookmarkListRef createFromParcel(Parcel parcel) {
            return new RouteBookmarkListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RouteBookmarkListRef[] newArray(int i) {
            return new RouteBookmarkListRef[i];
        }
    };
    private final String href;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    private RouteBookmarkListRef(Parcel parcel) {
        this.href = parcel.readString();
    }

    private RouteBookmarkListRef(Builder builder) {
        this.href = builder.getHref();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    public static class Builder extends BaseReferenceBuilder {
        private static final String USER = "user";

        public Builder() {
            super(UrlBuilderImpl.ROUTE_BOOKMARK_COLLECTION_URL);
        }

        public Builder setUser(String str) throws NullPointerException {
            Precondition.isNotNull(str);
            setParam("user", str);
            return this;
        }

        public RouteBookmarkListRef build() throws NullPointerException {
            Precondition.isNotNull(getParam("user"));
            return new RouteBookmarkListRef(this);
        }
    }
}
