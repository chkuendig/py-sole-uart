package com.ua.sdk.user;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.EntityDatabase;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class UserPageTransferObject extends ApiTransferObject {
    public static final String KEY_USERS = "user";

    @SerializedName(EntityDatabase.LIST.COLS.TOTAL_COUNT)
    public Integer totalUserCount;

    @SerializedName("_embedded")
    public Map<String, ArrayList<UserTO>> users;

    private ArrayList<UserTO> getUserList() {
        Map<String, ArrayList<UserTO>> map = this.users;
        if (map == null) {
            return null;
        }
        return map.get("user");
    }

    public static UserListImpl toPage(UserPageTransferObject userPageTransferObject) throws UaException {
        UserListImpl userListImpl = new UserListImpl();
        Iterator<UserTO> it = userPageTransferObject.getUserList().iterator();
        while (it.hasNext()) {
            userListImpl.add(UserTO.fromTransferObject(it.next()));
        }
        userListImpl.setLinkMap(userPageTransferObject.getLinkMap());
        userListImpl.setTotalCount(userPageTransferObject.totalUserCount.intValue());
        return userListImpl;
    }
}
