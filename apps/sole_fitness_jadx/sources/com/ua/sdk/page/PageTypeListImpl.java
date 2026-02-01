package com.ua.sdk.page;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class PageTypeListImpl extends AbstractEntityList<PageType> {
    public static Parcelable.Creator<PageTypeListImpl> CREATOR = new Parcelable.Creator<PageTypeListImpl>() { // from class: com.ua.sdk.page.PageTypeListImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageTypeListImpl createFromParcel(Parcel parcel) {
            return new PageTypeListImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageTypeListImpl[] newArray(int i) {
            return new PageTypeListImpl[i];
        }
    };
    public static final String LIST_KEY = "page_types";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public PageTypeListImpl() {
    }

    private PageTypeListImpl(Parcel parcel) {
        super(parcel);
    }
}
