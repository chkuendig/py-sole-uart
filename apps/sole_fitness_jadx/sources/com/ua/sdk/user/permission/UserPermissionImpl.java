package com.ua.sdk.user.permission;

import android.os.Parcel;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.Reference;

/* loaded from: classes2.dex */
public class UserPermissionImpl implements UserPermission {

    @SerializedName("permission")
    private String permission;

    @SerializedName("resource")
    private String resource;

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

    @Override // com.ua.sdk.user.permission.UserPermission
    public String getResource() {
        return this.resource;
    }

    @Override // com.ua.sdk.user.permission.UserPermission
    public String getPermission() {
        return this.permission;
    }

    @Override // com.ua.sdk.user.permission.UserPermission
    public void setResource(String str) {
        this.resource = str;
    }

    @Override // com.ua.sdk.user.permission.UserPermission
    public void setPermission(String str) {
        this.permission = str;
    }
}
