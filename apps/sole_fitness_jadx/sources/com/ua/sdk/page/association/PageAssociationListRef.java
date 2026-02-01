package com.ua.sdk.page.association;

import android.os.Parcel;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.page.Page;

/* loaded from: classes2.dex */
public class PageAssociationListRef implements EntityListRef<PageAssociation> {
    private String href;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    private PageAssociationListRef(Builder builder) throws NullPointerException {
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
        private String fromPageId;
        private String toPageId;

        protected Builder() {
            super("/v7.0/page_association/");
        }

        public Builder setFromPage(EntityRef<Page> entityRef) {
            if (entityRef == null) {
                this.fromPageId = null;
            } else {
                this.fromPageId = entityRef.getId();
            }
            setParam("from_page_id", this.fromPageId);
            return this;
        }

        public Builder setToPage(EntityRef<Page> entityRef) {
            if (entityRef == null) {
                this.toPageId = null;
            } else {
                this.toPageId = entityRef.getId();
            }
            setParam("to_page_id", this.toPageId);
            return this;
        }

        public PageAssociationListRef build() {
            return new PageAssociationListRef(this);
        }
    }
}
