package com.ua.sdk.group.purpose;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;

/* loaded from: classes2.dex */
public class GroupPurposeImpl extends ApiTransferObject implements GroupPurpose {
    public static Parcelable.Creator<GroupPurposeImpl> CREATOR = new Parcelable.Creator<GroupPurposeImpl>() { // from class: com.ua.sdk.group.purpose.GroupPurposeImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupPurposeImpl createFromParcel(Parcel parcel) {
            return new GroupPurposeImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupPurposeImpl[] newArray(int i) {
            return new GroupPurposeImpl[i];
        }
    };

    @SerializedName("restrict_membership")
    Boolean isRestricted;

    @SerializedName("purpose")
    String purpose;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GroupPurposeImpl() {
    }

    private GroupPurposeImpl(Parcel parcel) {
        super(parcel);
        this.purpose = parcel.readString();
        this.isRestricted = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }

    @Override // com.ua.sdk.group.purpose.GroupPurpose
    public String getPurpose() {
        return this.purpose;
    }

    @Override // com.ua.sdk.group.purpose.GroupPurpose
    public Boolean isRestricted() {
        return this.isRestricted;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<GroupPurpose> getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.purpose);
        parcel.writeValue(this.isRestricted);
    }
}
