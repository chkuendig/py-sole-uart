package com.ua.sdk.page.follow;

import com.ua.sdk.UaException;
import com.ua.sdk.internal.ApiTransferObject;

/* loaded from: classes2.dex */
public class PageFollowTransferObject extends ApiTransferObject {
    public static PageFollowTransferObject fromPageFollow(PageFollow pageFollow) {
        if (pageFollow == null) {
            return null;
        }
        PageFollowTransferObject pageFollowTransferObject = new PageFollowTransferObject();
        if (pageFollow instanceof PageFollowImpl) {
            pageFollowTransferObject.setLinkMap(((PageFollowImpl) pageFollow).getLinkMap());
        }
        return pageFollowTransferObject;
    }

    public static PageFollowImpl toPageFollowImpl(PageFollowTransferObject pageFollowTransferObject) throws UaException {
        if (pageFollowTransferObject == null) {
            return null;
        }
        PageFollowImpl pageFollowImpl = new PageFollowImpl();
        for (String str : pageFollowTransferObject.getLinkKeys()) {
            pageFollowImpl.setLinksForRelation(str, pageFollowTransferObject.getLinks(str));
        }
        return pageFollowImpl;
    }
}
