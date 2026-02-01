package com.ua.sdk.role;

import com.ua.sdk.role.Role;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class RoleHelper {
    public static final String DESC_ADMINISTRATOR = "The ADMINISTRATOR role has permission to Manage object authorization, Edit object settings, Approve content";
    public static final String DESC_CREATOR = "The CREATOR role has permission to Create new objects";
    public static final String DESC_EDITOR = "The EDITOR role has permission to Edit object settings, Approve content";
    public static final String DESC_MODERATOR = "The MODERATOR role has permission to Approve content";
    public static final List<Role.Permission> CREATOR_PERMISSIONS = new ArrayList<Role.Permission>() { // from class: com.ua.sdk.role.RoleHelper.1
        {
            add(Role.Permission.CREATE);
        }
    };
    public static final List<Role.Permission> MODERATOR_PERMISSIONS = new ArrayList<Role.Permission>() { // from class: com.ua.sdk.role.RoleHelper.2
        {
            add(Role.Permission.MODERATE);
        }
    };
    public static final List<Role.Permission> EDITOR_PERMISSIONS = new ArrayList<Role.Permission>() { // from class: com.ua.sdk.role.RoleHelper.3
        {
            add(Role.Permission.EDIT);
            add(Role.Permission.MODERATE);
        }
    };
    public static final List<Role.Permission> ADMINISTRATOR_PERMISSIONS = new ArrayList<Role.Permission>() { // from class: com.ua.sdk.role.RoleHelper.4
        {
            add(Role.Permission.ADMINISTER);
            add(Role.Permission.EDIT);
            add(Role.Permission.MODERATE);
        }
    };

    /* renamed from: com.ua.sdk.role.RoleHelper$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$role$Role$Type;

        static {
            int[] iArr = new int[Role.Type.values().length];
            $SwitchMap$com$ua$sdk$role$Role$Type = iArr;
            try {
                iArr[Role.Type.CREATOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$role$Role$Type[Role.Type.MODERATOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ua$sdk$role$Role$Type[Role.Type.EDITOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ua$sdk$role$Role$Type[Role.Type.ADMINISTRATOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static RoleImpl getRole(Role.Type type) throws IllegalArgumentException {
        int i = AnonymousClass5.$SwitchMap$com$ua$sdk$role$Role$Type[type.ordinal()];
        if (i == 1) {
            return new RoleImpl(Role.Type.CREATOR, CREATOR_PERMISSIONS, DESC_CREATOR);
        }
        if (i == 2) {
            return new RoleImpl(Role.Type.MODERATOR, MODERATOR_PERMISSIONS, DESC_MODERATOR);
        }
        if (i == 3) {
            return new RoleImpl(Role.Type.EDITOR, EDITOR_PERMISSIONS, DESC_EDITOR);
        }
        if (i == 4) {
            return new RoleImpl(Role.Type.ADMINISTRATOR, ADMINISTRATOR_PERMISSIONS, DESC_ADMINISTRATOR);
        }
        throw new IllegalArgumentException("Role passed is not known!");
    }

    public static RoleImpl getRole(String str) throws IllegalArgumentException {
        return getRole(Role.Type.parse(str));
    }
}
