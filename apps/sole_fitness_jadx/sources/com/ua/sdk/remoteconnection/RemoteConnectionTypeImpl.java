package com.ua.sdk.remoteconnection;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.internal.Precondition;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class RemoteConnectionTypeImpl extends ApiTransferObject implements RemoteConnectionType, Parcelable {
    public static Parcelable.Creator<RemoteConnectionTypeImpl> CREATOR = new Parcelable.Creator<RemoteConnectionTypeImpl>() { // from class: com.ua.sdk.remoteconnection.RemoteConnectionTypeImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteConnectionTypeImpl createFromParcel(Parcel parcel) {
            return new RemoteConnectionTypeImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteConnectionTypeImpl[] newArray(int i) {
            return new RemoteConnectionTypeImpl[i];
        }
    };
    private String disconnectCancelStr;
    private String disconnectConfirmStr;
    private String disconnectStr;
    private String introBodyStr;
    private String introHeadingStr;
    private String logoLink;
    private String logoLinkLight;
    private String name;
    private String oAuthLink;
    private String recorderTypeKey;
    private String type;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected RemoteConnectionTypeImpl() {
    }

    protected RemoteConnectionTypeImpl(RemoteConnectionType remoteConnectionType) throws NullPointerException {
        Precondition.isNotNull(remoteConnectionType, "remoteConnectionType");
        this.type = remoteConnectionType.getType();
        this.recorderTypeKey = remoteConnectionType.getRecorderTypeKey();
        this.name = remoteConnectionType.getName();
        this.introHeadingStr = remoteConnectionType.getIntroHeadingStr();
        this.introBodyStr = remoteConnectionType.getIntroBodyStr();
        this.disconnectStr = remoteConnectionType.getDisconnectStr();
        this.disconnectCancelStr = remoteConnectionType.getDisconnectCancelStr();
        this.disconnectConfirmStr = remoteConnectionType.getDisconnectConfirmStr();
        this.logoLink = remoteConnectionType.getLogoLink();
        this.logoLinkLight = remoteConnectionType.getLogoLinkLight();
        this.oAuthLink = remoteConnectionType.getOAuthLink();
        if (remoteConnectionType instanceof RemoteConnectionTypeImpl) {
            copyLinkMap(((RemoteConnectionTypeImpl) remoteConnectionType).getLinkMap());
        }
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<RemoteConnectionType> getRef() {
        ArrayList<Link> links = getLinks("self");
        if (links == null || links.isEmpty()) {
            return null;
        }
        return new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public String getType() {
        return this.type;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public String getRecorderTypeKey() {
        return this.recorderTypeKey;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public String getName() {
        return this.name;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public String getIntroHeadingStr() {
        return this.introHeadingStr;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public String getIntroBodyStr() {
        return this.introBodyStr;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public String getDisconnectStr() {
        return this.disconnectStr;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public String getDisconnectCancelStr() {
        return this.disconnectCancelStr;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public String getDisconnectConfirmStr() {
        return this.disconnectConfirmStr;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public String getLogoLink() {
        return this.logoLink;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public String getLogoLinkLight() {
        return this.logoLinkLight;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public String getOAuthLink() {
        return this.oAuthLink;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public void setType(String str) {
        this.type = str;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public void setRecorderTypeKey(String str) {
        this.recorderTypeKey = str;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public void setName(String str) {
        this.name = str;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public void setIntroHeadingStr(String str) {
        this.introHeadingStr = str;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public void setIntroBodyStr(String str) {
        this.introBodyStr = str;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public void setDisconnectStr(String str) {
        this.disconnectStr = str;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public void setDisconnectCancelStr(String str) {
        this.disconnectCancelStr = str;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public void setDisconnectConfirmStr(String str) {
        this.disconnectConfirmStr = str;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public void setLogoLink(String str) {
        this.logoLink = str;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public void setLogoLinkLight(String str) {
        this.logoLinkLight = str;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionType
    public void setOAuthLink(String str) {
        this.oAuthLink = str;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.type);
        parcel.writeString(this.recorderTypeKey);
        parcel.writeString(this.name);
        parcel.writeString(this.introHeadingStr);
        parcel.writeString(this.introBodyStr);
        parcel.writeString(this.disconnectStr);
        parcel.writeString(this.disconnectCancelStr);
        parcel.writeString(this.disconnectConfirmStr);
        parcel.writeString(this.logoLink);
        parcel.writeString(this.logoLinkLight);
        parcel.writeString(this.oAuthLink);
    }

    private RemoteConnectionTypeImpl(Parcel parcel) {
        super(parcel);
        this.type = parcel.readString();
        this.recorderTypeKey = parcel.readString();
        this.name = parcel.readString();
        this.introHeadingStr = parcel.readString();
        this.introBodyStr = parcel.readString();
        this.disconnectStr = parcel.readString();
        this.disconnectCancelStr = parcel.readString();
        this.disconnectConfirmStr = parcel.readString();
        this.logoLink = parcel.readString();
        this.logoLinkLight = parcel.readString();
        this.oAuthLink = parcel.readString();
    }
}
