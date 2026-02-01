package com.ua.sdk.friendship;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.Precondition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class FriendshipTransferObject extends ApiTransferObject {

    @SerializedName("created_datetime")
    Date dateTimeCreated;

    @SerializedName(FriendshipPageTransferObject.KEY_FRIENDSHIPS)
    List<Friendship> friendships;

    @SerializedName("message")
    String message;

    @SerializedName("status")
    String status;

    public static FriendshipTransferObject fromFriendship(Friendship friendship) throws NullPointerException {
        Precondition.isNotNull(friendship, "friendship");
        Precondition.isNotNull(friendship.getFriendshipStatus());
        FriendshipTransferObject friendshipTransferObject = new FriendshipTransferObject();
        friendshipTransferObject.status = friendship.getFriendshipStatus().getValue();
        friendshipTransferObject.dateTimeCreated = friendship.getCreatedDateTime();
        friendshipTransferObject.message = friendship.getMessage();
        if (friendship instanceof FriendshipImpl) {
            FriendshipImpl friendshipImpl = (FriendshipImpl) friendship;
            Map<String, ArrayList<Link>> linkMap = friendshipImpl.getLinkMap();
            if (linkMap != null) {
                friendshipTransferObject.setLinkMap(linkMap);
            }
            if (!friendshipImpl.getFriendships().isEmpty()) {
                friendshipTransferObject.friendships = friendshipImpl.getFriendships();
            }
        }
        return friendshipTransferObject;
    }

    public static FriendshipImpl toFriendship(FriendshipTransferObject friendshipTransferObject) throws NullPointerException {
        Precondition.isNotNull(friendshipTransferObject);
        FriendshipImpl friendshipImpl = new FriendshipImpl();
        friendshipImpl.setFriendshipStatus(FriendshipStatus.getStatusFromString(friendshipTransferObject.status));
        friendshipImpl.setCreatedDateTime(friendshipTransferObject.dateTimeCreated);
        friendshipImpl.setMessage(friendshipTransferObject.message);
        for (String str : friendshipTransferObject.getLinkKeys()) {
            friendshipImpl.setLinksForRelation(str, friendshipTransferObject.getLinks(str));
        }
        return friendshipImpl;
    }
}
