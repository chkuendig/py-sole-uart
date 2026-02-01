package com.ua.sdk.page.association;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.page.Page;

/* loaded from: classes2.dex */
public class PageAssociationImpl extends ApiTransferObject implements PageAssociation, Parcelable {
    public static Parcelable.Creator<PageAssociationImpl> CREATOR = new Parcelable.Creator<PageAssociationImpl>() { // from class: com.ua.sdk.page.association.PageAssociationImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageAssociationImpl createFromParcel(Parcel parcel) {
            return new PageAssociationImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageAssociationImpl[] newArray(int i) {
            return new PageAssociationImpl[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PageAssociationImpl() {
    }

    @Override // com.ua.sdk.page.association.PageAssociation
    public EntityRef<Page> getFromPage() {
        Link link = getLink("from_page");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.page.association.PageAssociation
    public EntityRef<Page> getToPage() {
        Link link = getLink("to_page");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.Resource
    public EntityRef getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private PageAssociationImpl(Parcel parcel) {
        super(parcel);
    }
}
