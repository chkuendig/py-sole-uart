package com.ua.sdk.activitystory;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.Source;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;

/* loaded from: classes2.dex */
public class SourceImpl extends ApiTransferObject implements Source {
    public static Parcelable.Creator<SourceImpl> CREATOR = new Parcelable.Creator<SourceImpl>() { // from class: com.ua.sdk.activitystory.SourceImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SourceImpl createFromParcel(Parcel parcel) {
            return new SourceImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SourceImpl[] newArray(int i) {
            return new SourceImpl[i];
        }
    };

    @SerializedName("id")
    String id;

    @SerializedName("site_name")
    String siteName;

    @SerializedName("site_url")
    String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Source
    public String getId() {
        return this.id;
    }

    @Override // com.ua.sdk.Source
    public void setId(String str) {
        this.id = str;
    }

    @Override // com.ua.sdk.Source
    public String getUrl() {
        return this.url;
    }

    @Override // com.ua.sdk.Source
    public void setUrl(String str) {
        this.url = str;
    }

    @Override // com.ua.sdk.Source
    public String getSiteName() {
        return this.siteName;
    }

    @Override // com.ua.sdk.Source
    public void setSiteName(String str) {
        this.siteName = str;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<Source> getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.id);
        parcel.writeString(this.url);
        parcel.writeString(this.siteName);
    }

    public SourceImpl() {
    }

    private SourceImpl(Parcel parcel) {
        super(parcel);
        this.id = parcel.readString();
        this.url = parcel.readString();
        this.siteName = parcel.readString();
    }
}
