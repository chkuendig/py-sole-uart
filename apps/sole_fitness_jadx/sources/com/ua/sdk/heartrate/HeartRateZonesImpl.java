package com.ua.sdk.heartrate;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.user.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class HeartRateZonesImpl extends ApiTransferObject implements HeartRateZones {
    public static final Parcelable.Creator<HeartRateZonesImpl> CREATOR = new Parcelable.Creator<HeartRateZonesImpl>() { // from class: com.ua.sdk.heartrate.HeartRateZonesImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateZonesImpl createFromParcel(Parcel parcel) {
            return new HeartRateZonesImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateZonesImpl[] newArray(int i) {
            return new HeartRateZonesImpl[i];
        }
    };
    private transient EntityRef<HeartRateZones> selfRef;
    private transient EntityRef<User> userRef;

    @SerializedName("zones")
    private List<HeartRateZone> zones;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HeartRateZonesImpl() {
        this.zones = new ArrayList();
    }

    public HeartRateZonesImpl(HeartRateZone... heartRateZoneArr) {
        this.zones = new ArrayList();
        this.zones = Arrays.asList(heartRateZoneArr);
    }

    private HeartRateZonesImpl(Parcel parcel) {
        super(parcel);
        ArrayList arrayList = new ArrayList();
        this.zones = arrayList;
        parcel.readList(arrayList, HeartRateZone.class.getClassLoader());
    }

    @Override // com.ua.sdk.heartrate.HeartRateZones
    public List<HeartRateZone> getZones() {
        return this.zones;
    }

    @Override // com.ua.sdk.heartrate.HeartRateZones
    public void add(HeartRateZone heartRateZone) {
        this.zones.add(heartRateZone);
    }

    @Override // com.ua.sdk.heartrate.HeartRateZones
    public HeartRateZone getZone(int i) {
        if (i <= -1 || i >= this.zones.size()) {
            return null;
        }
        return this.zones.get(i);
    }

    @Override // com.ua.sdk.heartrate.HeartRateZones
    public HeartRateZone getZone(String str) {
        for (HeartRateZone heartRateZone : this.zones) {
            if (heartRateZone.getName().equals(str)) {
                return heartRateZone;
            }
        }
        return null;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<HeartRateZones> getRef() {
        Link link;
        if (this.selfRef == null && (link = getLink("self")) != null) {
            this.selfRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.selfRef;
    }

    @Override // com.ua.sdk.heartrate.HeartRateZones
    public EntityRef<User> getUserRef() {
        Link link;
        if (this.userRef == null && (link = getLink("user")) != null) {
            this.userRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.userRef;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.zones);
    }
}
