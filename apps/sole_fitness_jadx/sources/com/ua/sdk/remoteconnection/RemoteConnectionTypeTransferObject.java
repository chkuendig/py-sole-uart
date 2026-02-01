package com.ua.sdk.remoteconnection;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.ApiTransferObject;

/* loaded from: classes2.dex */
public class RemoteConnectionTypeTransferObject extends ApiTransferObject {

    @SerializedName("disconnect_cancel")
    String disconnectCancel;

    @SerializedName("disconnect_confirm")
    String disconnectConfirm;

    @SerializedName("disconnect_copy")
    String disconnectCopy;

    @SerializedName("intro_copy_body")
    String introCopyBody;

    @SerializedName("intro_copy_heading")
    String introCopyHeading;

    @SerializedName("logo_link")
    String logoLink;

    @SerializedName("logo_link_light")
    String logoLinkLight;

    @SerializedName("name")
    String name;

    @SerializedName("oauth_connect_link")
    String oauthConnectLink;

    @SerializedName("recorder_type_key")
    String recorderTypeKey;

    @SerializedName("type")
    String type;

    public static RemoteConnectionTypeTransferObject fromRemoteConnectionType(RemoteConnectionType remoteConnectionType) {
        if (remoteConnectionType == null) {
            return null;
        }
        RemoteConnectionTypeTransferObject remoteConnectionTypeTransferObject = new RemoteConnectionTypeTransferObject();
        remoteConnectionTypeTransferObject.type = remoteConnectionType.getType();
        remoteConnectionTypeTransferObject.recorderTypeKey = remoteConnectionType.getRecorderTypeKey();
        remoteConnectionTypeTransferObject.name = remoteConnectionType.getName();
        remoteConnectionTypeTransferObject.introCopyHeading = remoteConnectionType.getIntroHeadingStr();
        remoteConnectionTypeTransferObject.introCopyBody = remoteConnectionType.getIntroBodyStr();
        remoteConnectionTypeTransferObject.disconnectCopy = remoteConnectionType.getDisconnectStr();
        remoteConnectionTypeTransferObject.disconnectCancel = remoteConnectionType.getDisconnectCancelStr();
        remoteConnectionTypeTransferObject.disconnectConfirm = remoteConnectionType.getDisconnectConfirmStr();
        remoteConnectionTypeTransferObject.logoLink = remoteConnectionType.getLogoLink();
        remoteConnectionTypeTransferObject.logoLinkLight = remoteConnectionType.getLogoLinkLight();
        remoteConnectionTypeTransferObject.oauthConnectLink = remoteConnectionType.getOAuthLink();
        if (remoteConnectionType instanceof RemoteConnectionTypeImpl) {
            remoteConnectionTypeTransferObject.setLinkMap(((RemoteConnectionTypeImpl) remoteConnectionType).getLinkMap());
        }
        return remoteConnectionTypeTransferObject;
    }

    public static RemoteConnectionTypeImpl toRemoteConnectionTypeImpl(RemoteConnectionTypeTransferObject remoteConnectionTypeTransferObject) throws UaException {
        if (remoteConnectionTypeTransferObject == null) {
            return null;
        }
        RemoteConnectionTypeImpl remoteConnectionTypeImpl = new RemoteConnectionTypeImpl();
        remoteConnectionTypeImpl.setType(remoteConnectionTypeTransferObject.type);
        remoteConnectionTypeImpl.setRecorderTypeKey(remoteConnectionTypeTransferObject.recorderTypeKey);
        remoteConnectionTypeImpl.setName(remoteConnectionTypeTransferObject.name);
        remoteConnectionTypeImpl.setIntroHeadingStr(remoteConnectionTypeTransferObject.introCopyHeading);
        remoteConnectionTypeImpl.setIntroBodyStr(remoteConnectionTypeTransferObject.introCopyBody);
        remoteConnectionTypeImpl.setDisconnectStr(remoteConnectionTypeTransferObject.disconnectCopy);
        remoteConnectionTypeImpl.setDisconnectCancelStr(remoteConnectionTypeTransferObject.disconnectCancel);
        remoteConnectionTypeImpl.setDisconnectConfirmStr(remoteConnectionTypeTransferObject.disconnectConfirm);
        remoteConnectionTypeImpl.setLogoLink(remoteConnectionTypeTransferObject.logoLink);
        remoteConnectionTypeImpl.setLogoLinkLight(remoteConnectionTypeTransferObject.logoLink);
        remoteConnectionTypeImpl.setOAuthLink(remoteConnectionTypeTransferObject.oauthConnectLink);
        for (String str : remoteConnectionTypeTransferObject.getLinkKeys()) {
            remoteConnectionTypeImpl.setLinksForRelation(str, remoteConnectionTypeTransferObject.getLinks(str));
        }
        return remoteConnectionTypeImpl;
    }
}
