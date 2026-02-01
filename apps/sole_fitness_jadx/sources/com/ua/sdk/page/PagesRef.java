package com.ua.sdk.page;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;

/* loaded from: classes2.dex */
public class PagesRef implements EntityListRef<Page> {
    public static Parcelable.Creator<PagesRef> CREATOR = new Parcelable.Creator<PagesRef>() { // from class: com.ua.sdk.page.PagesRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PagesRef createFromParcel(Parcel parcel) {
            return new PagesRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PagesRef[] newArray(int i) {
            return new PagesRef[i];
        }
    };
    private String params;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    private PagesRef(Builder builder) {
        this.params = "";
        this.params = builder.getHref();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder extends BaseReferenceBuilder {
        private Builder() {
            super(UrlBuilderImpl.GET_PAGES_URL);
        }

        public Builder setPageType(PageTypeEnum pageTypeEnum) throws NullPointerException {
            Precondition.isNotNull(pageTypeEnum, "PageTypeEnum");
            setParam("page_type_id", pageTypeEnum.getName());
            return this;
        }

        public Builder setPageListView(PageListViewEnum pageListViewEnum) throws NullPointerException {
            Precondition.isNotNull(pageListViewEnum, "PageListViewEnum");
            setParam(ViewHierarchyConstants.VIEW_KEY, pageListViewEnum.getName());
            return this;
        }

        public PagesRef build() {
            PagesRef pagesRef;
            synchronized (PagesRef.class) {
                pagesRef = new PagesRef(this);
            }
            return pagesRef;
        }
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.params;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.params);
    }

    private PagesRef(Parcel parcel) {
        this.params = "";
        this.params = parcel.readString();
    }
}
