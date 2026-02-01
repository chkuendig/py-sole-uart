package com.ua.sdk.role;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.role.Role;
import java.util.List;

/* loaded from: classes2.dex */
public class RoleTO extends ApiTransferObject {

    @SerializedName("description")
    String description;

    @SerializedName("name")
    Role.Type name;

    @SerializedName("permissions")
    List<Role.Permission> permissions;

    public static RoleTO toTransferObject(RoleImpl roleImpl) {
        RoleTO roleTO = new RoleTO();
        roleTO.permissions = roleImpl.getPermissions();
        roleTO.description = roleImpl.getDescription();
        roleTO.name = roleImpl.getName();
        return roleTO;
    }

    public static RoleImpl fromTransferObject(RoleTO roleTO) {
        RoleImpl roleImpl = new RoleImpl();
        roleImpl.setDescription(roleTO.description);
        roleImpl.setPermissions(roleTO.permissions);
        roleImpl.setName(roleTO.name);
        return roleImpl;
    }
}
