package com.ua.sdk.role;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.role.Role;
import com.ua.sdk.user.permission.UserPermission;
import com.ua.sdk.user.permission.UserPermissionManager;
import com.ua.sdk.user.role.UserRole;
import com.ua.sdk.user.role.UserRoleManager;

/* loaded from: classes2.dex */
public class RoleSuperManagerImpl implements RoleSuperManager {
    private final RoleManager roleManager;
    private final UserPermissionManager userPermissionManager;
    private final UserRoleManager userRoleManager;

    public RoleSuperManagerImpl(RoleManager roleManager, UserPermissionManager userPermissionManager, UserRoleManager userRoleManager) {
        this.roleManager = roleManager;
        this.userPermissionManager = userPermissionManager;
        this.userRoleManager = userRoleManager;
    }

    @Override // com.ua.sdk.role.RoleManager
    public Role fetchRole(Role.Type type) {
        return this.roleManager.fetchRole(type);
    }

    @Override // com.ua.sdk.role.RoleManager
    public EntityList<Role> fetchRoleList() throws UaException {
        return this.roleManager.fetchRoleList();
    }

    @Override // com.ua.sdk.role.RoleManager
    public Request fetchRoleList(FetchCallback<EntityList<Role>> fetchCallback) {
        return this.roleManager.fetchRoleList(fetchCallback);
    }

    @Override // com.ua.sdk.user.permission.UserPermissionManager
    public EntityList<UserPermission> fetchUserPermission(EntityRef entityRef) throws UaException {
        return this.userPermissionManager.fetchUserPermission(entityRef);
    }

    @Override // com.ua.sdk.user.permission.UserPermissionManager
    public Request fetchUserPermission(EntityRef entityRef, FetchCallback<EntityList<UserPermission>> fetchCallback) {
        return this.userPermissionManager.fetchUserPermission(entityRef, fetchCallback);
    }

    @Override // com.ua.sdk.user.permission.UserPermissionManager
    public EntityList<UserPermission> fetchUserPermissionList() throws UaException {
        return this.userPermissionManager.fetchUserPermissionList();
    }

    @Override // com.ua.sdk.user.permission.UserPermissionManager
    public Request fetchUserPermissionList(FetchCallback<EntityList<UserPermission>> fetchCallback) {
        return this.userPermissionManager.fetchUserPermissionList(fetchCallback);
    }

    @Override // com.ua.sdk.user.role.UserRoleManager
    public UserRole fetchUserRole(EntityRef entityRef) throws UaException {
        return this.userRoleManager.fetchUserRole(entityRef);
    }

    @Override // com.ua.sdk.user.role.UserRoleManager
    public Request fetchUserRole(EntityRef entityRef, FetchCallback<UserRole> fetchCallback) {
        return this.userRoleManager.fetchUserRole(entityRef, fetchCallback);
    }

    @Override // com.ua.sdk.user.role.UserRoleManager
    public UserRole createUserRole(UserRole userRole) throws UaException {
        return this.userRoleManager.createUserRole(userRole);
    }

    @Override // com.ua.sdk.user.role.UserRoleManager
    public Request createUserRole(UserRole userRole, CreateCallback<UserRole> createCallback) {
        return this.userRoleManager.createUserRole(userRole, createCallback);
    }
}
