package com.ua.sdk.page;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class PageListImpl extends AbstractEntityList<Page> {
    public static Parcelable.Creator<PageListImpl> CREATOR = new Parcelable.Creator<PageListImpl>() { // from class: com.ua.sdk.page.PageListImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageListImpl createFromParcel(Parcel parcel) {
            return new PageListImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageListImpl[] newArray(int i) {
            return new PageListImpl[i];
        }
    };
    public static final String LIST_KEY = "pages";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return "pages";
    }

    public PageListImpl() {
    }

    private PageListImpl(Parcel parcel) {
        super(parcel);
    }
}
