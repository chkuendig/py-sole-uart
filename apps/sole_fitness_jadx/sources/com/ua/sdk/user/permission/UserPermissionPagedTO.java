package com.ua.sdk.user.permission;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.cache.EntityDatabase;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class UserPermissionPagedTO extends ApiTransferObject {
    private static final String KEY_PERMISSIONS = "user_permissions";

    @SerializedName(EntityDatabase.LIST.COLS.TOTAL_COUNT)
    public Integer totalUserCount;

    @SerializedName("_embedded")
    public Map<String, ArrayList<UserPermissionTO>> userPermissions;

    private ArrayList<UserPermissionTO> getUserPermissionList() {
        Map<String, ArrayList<UserPermissionTO>> map = this.userPermissions;
        if (map == null) {
            return null;
        }
        return map.get(KEY_PERMISSIONS);
    }

    public static UserPermissionList toPage(UserPermissionPagedTO userPermissionPagedTO) {
        UserPermissionList userPermissionList = new UserPermissionList();
        Iterator<UserPermissionTO> it = userPermissionPagedTO.getUserPermissionList().iterator();
        while (it.hasNext()) {
            userPermissionList.add(UserPermissionTO.fromTransferObject(it.next()));
        }
        userPermissionList.setLinkMap(userPermissionPagedTO.getLinkMap());
        userPermissionList.setTotalCount(userPermissionPagedTO.totalUserCount.intValue());
        return userPermissionList;
    }
}
