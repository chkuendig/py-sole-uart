package com.ua.sdk.route;

import android.os.Parcel;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.LinkEntityRef;

/* loaded from: classes2.dex */
public class RouteRef extends LinkEntityRef<Route> {
    public RouteRef(String str) {
        super(str);
    }

    public RouteRef(String str, String str2) {
        super(str, str2);
    }

    public RouteRef(String str, long j, String str2) {
        super(str, j, str2);
    }

    public RouteRef(Parcel parcel) {
        super(parcel);
    }

    private RouteRef(Builder builder) {
        super(builder.id, builder.getHref());
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends BaseReferenceBuilder {
        private String fieldSet;
        private String id;

        protected Builder() {
            super("/v7.0/route/{id}/");
        }

        public Builder setId(String str) {
            this.id = str;
            setParam("id", str);
            return this;
        }

        public Builder setFieldSet(String str) {
            this.fieldSet = str;
            setParam("field_set", String.valueOf(str));
            return this;
        }

        public RouteRef build() {
            return new RouteRef(getHref());
        }
    }
}
