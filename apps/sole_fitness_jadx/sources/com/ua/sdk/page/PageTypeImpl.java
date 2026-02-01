package com.ua.sdk.page;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;

/* loaded from: classes2.dex */
public class PageTypeImpl extends ApiTransferObject implements PageType, Parcelable {
    public static Parcelable.Creator<PageTypeImpl> CREATOR = new Parcelable.Creator<PageTypeImpl>() { // from class: com.ua.sdk.page.PageTypeImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageTypeImpl createFromParcel(Parcel parcel) {
            return new PageTypeImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageTypeImpl[] newArray(int i) {
            return new PageTypeImpl[i];
        }
    };

    @SerializedName("title")
    private String mTitle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PageTypeImpl() {
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<PageType> getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.page.PageType
    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mTitle);
    }

    private PageTypeImpl(Parcel parcel) {
        super(parcel);
        this.mTitle = parcel.readString();
    }
}
