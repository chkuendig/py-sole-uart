package com.ua.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class Link implements Parcelable {
    public static Parcelable.Creator<Link> CREATOR = new Parcelable.Creator<Link>() { // from class: com.ua.sdk.internal.Link.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Link createFromParcel(Parcel parcel) {
            return new Link(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Link[] newArray(int i) {
            return new Link[i];
        }
    };

    @SerializedName("count")
    Integer mCount;

    @SerializedName("display_name")
    String mDisplayName;

    @SerializedName(ShareConstants.WEB_DIALOG_PARAM_HREF)
    String mHref;

    @SerializedName("id")
    String mId;

    @SerializedName("iteration")
    Integer mIteration;

    @SerializedName("name")
    String mName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Link() {
    }

    public Link(String str) {
        this(str, null, null, null, null, null);
    }

    public Link(String str, String str2) {
        this(str, str2, null, null, null, null);
    }

    public Link(String str, String str2, String str3) {
        this(str, str2, str3, null, null, null);
    }

    public Link(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, null, null);
    }

    public Link(String str, String str2, String str3, String str4, Integer num) {
        this(str, str2, str3, str4, num, null);
    }

    public Link(String str, String str2, String str3, String str4, Integer num, Integer num2) {
        this.mHref = str;
        this.mId = str2;
        this.mName = str3;
        this.mCount = num;
        this.mDisplayName = str4;
        this.mIteration = num2;
    }

    public String getHref() {
        return this.mHref;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public Integer getCount() {
        return this.mCount;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public Integer getIteration() {
        return this.mIteration;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mHref);
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeValue(this.mCount);
        parcel.writeValue(this.mIteration);
    }

    private Link(Parcel parcel) {
        this.mHref = parcel.readString();
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.mCount = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.mIteration = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Link link = (Link) obj;
        Integer num = this.mCount;
        if (num == null ? link.mCount != null : !num.equals(link.mCount)) {
            return false;
        }
        String str = this.mDisplayName;
        if (str == null ? link.mDisplayName != null : !str.equals(link.mDisplayName)) {
            return false;
        }
        String str2 = this.mHref;
        if (str2 == null || !str2.equals(link.mHref)) {
            return false;
        }
        String str3 = this.mId;
        if (str3 == null ? link.mId != null : !str3.equals(link.mId)) {
            return false;
        }
        String str4 = this.mName;
        if (str4 == null ? link.mName != null : !str4.equals(link.mName)) {
            return false;
        }
        Integer num2 = this.mIteration;
        Integer num3 = link.mIteration;
        return num2 == null ? num3 == null : num2.equals(num3);
    }

    public int hashCode() {
        String str = this.mHref;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mName;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.mCount;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        String str4 = this.mDisplayName;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num2 = this.mIteration;
        return iHashCode5 + (num2 != null ? num2.hashCode() : 0);
    }
}
