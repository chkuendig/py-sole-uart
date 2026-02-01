package com.ua.sdk.bodymass;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.user.User;
import java.util.Date;

/* loaded from: classes2.dex */
public class BodyMassImpl extends ApiTransferObject implements BodyMass {
    public static Parcelable.Creator<BodyMassImpl> CREATOR = new Parcelable.Creator<BodyMassImpl>() { // from class: com.ua.sdk.bodymass.BodyMassImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BodyMassImpl createFromParcel(Parcel parcel) {
            return new BodyMassImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BodyMassImpl[] newArray(int i) {
            return new BodyMassImpl[i];
        }
    };
    private static final String LINK_USER = "user";

    @SerializedName("bmi")
    String bmi;

    @SerializedName("created_datetime")
    Date createdDateTime;

    @SerializedName("datetime_timezone")
    String dateTimeTimezone;

    @SerializedName("datetime_utc")
    Date dateTimeUtc;

    @SerializedName("fat_mass")
    String fatMass;

    @SerializedName("fat_percent")
    String fatPercent;

    @SerializedName("lean_mass")
    String leanMass;

    @SerializedName("mass")
    String mass;

    @SerializedName("recorder_type_key")
    String recorderType;

    @SerializedName("reference_key")
    String referenceKey;

    @SerializedName("updated_datetime")
    Date updatedDateTime;
    private transient LinkEntityRef<User> userRef;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BodyMassImpl() {
    }

    private BodyMassImpl(Parcel parcel) {
        super(parcel);
        this.dateTimeUtc = (Date) parcel.readValue(Date.class.getClassLoader());
        this.dateTimeTimezone = parcel.readString();
        this.createdDateTime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.updatedDateTime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.recorderType = parcel.readString();
        this.referenceKey = parcel.readString();
        this.mass = parcel.readString();
        this.bmi = parcel.readString();
        this.fatPercent = parcel.readString();
        this.leanMass = parcel.readString();
        this.fatMass = parcel.readString();
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public Date getDateTimeUtc() {
        return this.dateTimeUtc;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public void setDateTimeUtc(Date date) {
        this.dateTimeUtc = date;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public String getDateTimeTimezone() {
        return this.dateTimeTimezone;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public void setDateTimeTimezone(String str) {
        this.dateTimeTimezone = str;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public Date getCreatedDateTime() {
        return this.createdDateTime;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public void setCreatedDateTime(Date date) {
        this.createdDateTime = date;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public Date getUpdatedDateTime() {
        return this.updatedDateTime;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public void setUpdatedDateTime(Date date) {
        this.updatedDateTime = date;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public String getRecorderType() {
        return this.recorderType;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public void setRecorderType(String str) {
        this.recorderType = str;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public String getReferenceKey() {
        return this.referenceKey;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public void setReferenceKey(String str) {
        this.referenceKey = str;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public String getMass() {
        return this.mass;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public void setMass(String str) {
        this.mass = str;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public String getBmi() {
        return this.bmi;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public void setBmi(String str) {
        this.bmi = str;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public String getFatPercent() {
        return this.fatPercent;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public void setFatPercent(String str) {
        this.fatPercent = str;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public String getLeanMass() {
        return this.leanMass;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public void setLeanMass(String str) {
        this.leanMass = str;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public String getFatMass() {
        return this.fatMass;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public void setFatMass(String str) {
        this.fatMass = str;
    }

    @Override // com.ua.sdk.bodymass.BodyMass
    public EntityRef<User> getUserRef() {
        Link link;
        if (this.userRef == null && (link = getLink("user")) != null) {
            this.userRef = new LinkEntityRef<>(link.getId(), link.getHref());
        }
        return this.userRef;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<BodyMass> getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.dateTimeUtc);
        parcel.writeString(this.dateTimeTimezone);
        parcel.writeValue(this.createdDateTime);
        parcel.writeValue(this.updatedDateTime);
        parcel.writeString(this.recorderType);
        parcel.writeString(this.referenceKey);
        parcel.writeString(this.mass);
        parcel.writeString(this.bmi);
        parcel.writeString(this.fatPercent);
        parcel.writeString(this.leanMass);
        parcel.writeString(this.fatMass);
    }
}
