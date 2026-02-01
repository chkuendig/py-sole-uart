package com.ua.sdk.role;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.Reference;
import com.ua.sdk.role.Role;
import java.util.List;

/* loaded from: classes2.dex */
public class RoleImpl implements Role {
    public static Parcelable.Creator<RoleImpl> CREATOR = new Parcelable.Creator<RoleImpl>() { // from class: com.ua.sdk.role.RoleImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RoleImpl createFromParcel(Parcel parcel) {
            return new RoleImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RoleImpl[] newArray(int i) {
            return new RoleImpl[i];
        }
    };

    @SerializedName("description")
    private String description;

    @SerializedName("name")
    private Role.Type name;

    @SerializedName("permissions")
    private List<Role.Permission> permissions;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Resource
    public Reference getRef() {
        return null;
    }

    public RoleImpl() {
    }

    private RoleImpl(Parcel parcel) {
        this.description = parcel.readString();
        int i = parcel.readInt();
        this.name = i == -1 ? null : Role.Type.values()[i];
        this.permissions = parcel.readArrayList(Role.Permission.class.getClassLoader());
    }

    protected RoleImpl(Role.Type type, List<Role.Permission> list, String str) {
        this.name = type;
        this.permissions = list;
        this.description = str;
    }

    @Override // com.ua.sdk.role.Role
    public String getDescription() {
        return this.description;
    }

    @Override // com.ua.sdk.role.Role
    public Role.Type getName() {
        return this.name;
    }

    @Override // com.ua.sdk.role.Role
    public List<Role.Permission> getPermissions() {
        return this.permissions;
    }

    @Override // com.ua.sdk.role.Role
    public void setDescription(String str) {
        this.description = str;
    }

    @Override // com.ua.sdk.role.Role
    public void setName(Role.Type type) {
        this.name = type;
    }

    @Override // com.ua.sdk.role.Role
    public void setPermissions(List<Role.Permission> list) {
        this.permissions = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.description);
        Role.Type type = this.name;
        parcel.writeInt(type == null ? -1 : type.ordinal());
        parcel.writeList(this.permissions);
    }
}
