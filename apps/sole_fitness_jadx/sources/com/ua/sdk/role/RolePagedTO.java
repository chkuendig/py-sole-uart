package com.ua.sdk.role;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.cache.EntityDatabase;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class RolePagedTO extends ApiTransferObject {
    private static final String KEY_ROLES = "roles";

    @SerializedName("_embedded")
    public Map<String, ArrayList<RoleTO>> roles;

    @SerializedName(EntityDatabase.LIST.COLS.TOTAL_COUNT)
    public Integer totalUserCount;

    private ArrayList<RoleTO> getRolesList() {
        Map<String, ArrayList<RoleTO>> map = this.roles;
        if (map == null) {
            return null;
        }
        return map.get(KEY_ROLES);
    }

    public static RoleList toPage(RolePagedTO rolePagedTO) {
        RoleList roleList = new RoleList();
        Iterator<RoleTO> it = rolePagedTO.getRolesList().iterator();
        while (it.hasNext()) {
            roleList.add(RoleTO.fromTransferObject(it.next()));
        }
        roleList.setLinkMap(rolePagedTO.getLinkMap());
        roleList.setTotalCount(rolePagedTO.totalUserCount.intValue());
        return roleList;
    }
}
