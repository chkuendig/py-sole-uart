package com.ua.sdk.user.profilephoto;

import com.ua.sdk.internal.ApiTransferObject;

/* loaded from: classes2.dex */
public class UserProfilePhotoTransferObject extends ApiTransferObject {
    public static UserProfilePhotoImpl toUserProfilePhotoImpl(UserProfilePhotoTransferObject userProfilePhotoTransferObject) {
        UserProfilePhotoImpl userProfilePhotoImpl = new UserProfilePhotoImpl();
        for (String str : userProfilePhotoTransferObject.getLinkKeys()) {
            userProfilePhotoImpl.setLinksForRelation(str, userProfilePhotoTransferObject.getLinks(str));
        }
        return userProfilePhotoImpl;
    }
}
