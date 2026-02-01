package com.ua.sdk.user.role;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.internal.ApiTransferObject;

/* loaded from: classes2.dex */
public class UserRoleTO extends ApiTransferObject {
    private static final String RESOURCE = "resource";
    private static final String ROLE = "role";
    private static final String USER = "user";

    @SerializedName(RESOURCE)
    String resource;

    @SerializedName(ROLE)
    String role;

    @SerializedName("user")
    String user;

    public static UserRoleTO toTransferObject(UserRole userRole) {
        UserRoleTO userRoleTO = new UserRoleTO();
        userRoleTO.user = userRole.getUser().getId();
        userRoleTO.role = userRole.getRole().getId();
        userRoleTO.resource = userRole.getResource().getHref();
        return userRoleTO;
    }

    public static UserRole fromTransferObject(UserRoleTO userRoleTO) {
        UserRoleImpl userRoleImpl = new UserRoleImpl();
        userRoleImpl.setUser(userRoleTO.getLink("user"));
        userRoleImpl.setRole(userRoleTO.getLink(ROLE));
        userRoleImpl.setResource(userRoleTO.getLink(RESOURCE));
        return userRoleImpl;
    }
}
