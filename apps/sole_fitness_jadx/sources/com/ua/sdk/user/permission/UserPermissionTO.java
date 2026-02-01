package com.ua.sdk.user.permission;

import android.os.Parcel;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.Reference;
import com.ua.sdk.Resource;

/* loaded from: classes2.dex */
public class UserPermissionTO implements Resource {

    @SerializedName("permission")
    String permission;

    @SerializedName("resource")
    String resource;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Resource
    public Reference getRef() {
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public static UserPermissionTO toTransferObject(UserPermissionImpl userPermissionImpl) {
        UserPermissionTO userPermissionTO = new UserPermissionTO();
        userPermissionTO.resource = userPermissionImpl.getResource();
        userPermissionTO.permission = userPermissionImpl.getPermission();
        return userPermissionTO;
    }

    public static UserPermission fromTransferObject(UserPermissionTO userPermissionTO) {
        UserPermissionImpl userPermissionImpl = new UserPermissionImpl();
        userPermissionImpl.setResource(userPermissionTO.resource);
        userPermissionImpl.setPermission(userPermissionTO.permission);
        return userPermissionImpl;
    }
}
