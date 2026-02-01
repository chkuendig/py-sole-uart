package com.ua.sdk.friendship;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.cache.EntityDatabase;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class FriendshipPageTransferObject extends ApiTransferObject {
    public static final String KEY_FRIENDSHIPS = "friendships";

    @SerializedName("_embedded")
    public Map<String, ArrayList<FriendshipTransferObject>> friendships;

    @SerializedName(EntityDatabase.LIST.COLS.TOTAL_COUNT)
    public Integer totalFriendsCount;

    private ArrayList<FriendshipTransferObject> getFriendshipList() {
        Map<String, ArrayList<FriendshipTransferObject>> map = this.friendships;
        if (map == null) {
            return null;
        }
        return map.get(KEY_FRIENDSHIPS);
    }

    public static FriendshipPageTransferObject toTransferObject(FriendshipListImpl friendshipListImpl) {
        if (friendshipListImpl == null) {
            return null;
        }
        FriendshipPageTransferObject friendshipPageTransferObject = new FriendshipPageTransferObject();
        Iterator<Friendship> it = friendshipListImpl.getElements().iterator();
        while (it.hasNext()) {
            friendshipPageTransferObject.friendships.get(KEY_FRIENDSHIPS).add(FriendshipTransferObject.fromFriendship((FriendshipImpl) it.next()));
        }
        friendshipPageTransferObject.setLinkMap(friendshipListImpl.getLinkMap());
        friendshipPageTransferObject.totalFriendsCount = Integer.valueOf(friendshipListImpl.getTotalCount());
        return friendshipPageTransferObject;
    }

    public static FriendshipListImpl fromTransferObject(FriendshipPageTransferObject friendshipPageTransferObject) {
        FriendshipListImpl friendshipListImpl = new FriendshipListImpl();
        Iterator<FriendshipTransferObject> it = friendshipPageTransferObject.getFriendshipList().iterator();
        while (it.hasNext()) {
            friendshipListImpl.add(FriendshipTransferObject.toFriendship(it.next()));
        }
        friendshipListImpl.setLinkMap(friendshipPageTransferObject.getLinkMap());
        friendshipListImpl.setTotalCount(friendshipPageTransferObject.totalFriendsCount.intValue());
        return friendshipListImpl;
    }
}
