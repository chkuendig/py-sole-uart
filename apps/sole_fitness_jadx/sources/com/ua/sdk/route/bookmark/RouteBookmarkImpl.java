package com.ua.sdk.route.bookmark;

import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.route.RouteBookmark;

/* loaded from: classes2.dex */
public class RouteBookmarkImpl extends ApiTransferObject implements RouteBookmark {
    private String fromUserHref;
    private transient Link route;
    private transient Link user;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteBookmarkImpl() {
    }

    private RouteBookmarkImpl(Builder builder) {
        this.route = builder.route;
        this.user = builder.user;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<RouteBookmark> getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.route.RouteBookmark
    public Link getRoute() {
        Link link = this.route;
        return link != null ? link : getLink("route");
    }

    @Override // com.ua.sdk.route.RouteBookmark
    public Link getUser() {
        Link link = this.user;
        return link != null ? link : getLink("user");
    }

    @Override // com.ua.sdk.route.RouteBookmark
    public String getFromUserHref() {
        return this.fromUserHref;
    }

    @Override // com.ua.sdk.route.RouteBookmark
    public void setRoute(Link link) {
        setLink("route", link);
    }

    @Override // com.ua.sdk.route.RouteBookmark
    public void setUser(Link link) {
        setLink("user", link);
    }

    @Override // com.ua.sdk.route.RouteBookmark
    public void setFromUserHref(String str) {
        this.fromUserHref = str;
    }

    public static class Builder {
        Link route;
        Link user;

        public Builder setRoute(String str) {
            this.route = new Link((String) null, str);
            return this;
        }

        public Builder setUser(String str) {
            this.user = new Link((String) null, str);
            return this;
        }

        public RouteBookmarkImpl build() {
            return new RouteBookmarkImpl(this);
        }
    }
}
