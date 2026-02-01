package com.ua.sdk.page.association;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class PageAssociationList extends AbstractEntityList<PageAssociation> {
    public static Parcelable.Creator<PageAssociationList> CREATOR = new Parcelable.Creator<PageAssociationList>() { // from class: com.ua.sdk.page.association.PageAssociationList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageAssociationList createFromParcel(Parcel parcel) {
            return new PageAssociationList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageAssociationList[] newArray(int i) {
            return new PageAssociationList[i];
        }
    };
    private static final String LIST_KEY = "page_associations";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public PageAssociationList() {
    }

    private PageAssociationList(Parcel parcel) {
        super(parcel);
    }
}
