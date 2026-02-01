package com.ua.sdk.actigraphy;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.LinkEntityRef;
import java.util.Date;

/* loaded from: classes2.dex */
public class ActigraphyLinkEntityRef extends LinkEntityRef {
    public static Parcelable.Creator<ActigraphyLinkEntityRef> CREATOR = new Parcelable.Creator<ActigraphyLinkEntityRef>() { // from class: com.ua.sdk.actigraphy.ActigraphyLinkEntityRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphyLinkEntityRef createFromParcel(Parcel parcel) {
            return new ActigraphyLinkEntityRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphyLinkEntityRef[] newArray(int i) {
            return new ActigraphyLinkEntityRef[i];
        }
    };
    private Date mDate;
    private String mUserId;

    protected ActigraphyLinkEntityRef(String str, String str2, Date date, String str3) {
        super(str, str2);
        this.mDate = date;
        this.mUserId = str3;
    }

    public Date getDate() {
        return this.mDate;
    }

    public void setDate(Date date) {
        this.mDate = date;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    @Override // com.ua.sdk.internal.LinkEntityRef, com.ua.sdk.Reference
    public String getId() {
        return super.getId();
    }

    @Override // com.ua.sdk.internal.LinkEntityRef, com.ua.sdk.Reference
    public String getHref() {
        return super.getHref();
    }

    @Override // com.ua.sdk.internal.LinkEntityRef, android.os.Parcelable
    public int describeContents() {
        return super.describeContents();
    }

    @Override // com.ua.sdk.internal.LinkEntityRef, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        Date date = this.mDate;
        parcel.writeLong(date == null ? -1L : date.getTime());
        parcel.writeString(this.mUserId);
    }

    private ActigraphyLinkEntityRef(Parcel parcel) {
        super(parcel);
        Long lValueOf = Long.valueOf(parcel.readLong());
        this.mDate = lValueOf.longValue() == -1 ? null : new Date(lValueOf.longValue());
        this.mUserId = parcel.readString();
    }
}
