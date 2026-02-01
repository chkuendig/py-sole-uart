package com.ua.sdk.user.permission;

import com.ua.sdk.Resource;

/* loaded from: classes2.dex */
public interface UserPermission extends Resource {
    String getPermission();

    String getResource();

    void setPermission(String str);

    void setResource(String str);
}
