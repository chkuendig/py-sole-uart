package com.ua.sdk.page.follow;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class PageFollowRequestTransferObject extends ApiTransferObject {

    @SerializedName("page_follows")
    List<PageFollowPatchTransferObject> pageFollowTOs;

    void addPageFollow(PageFollow pageFollow) {
        if (this.pageFollowTOs == null) {
            this.pageFollowTOs = new ArrayList();
        }
        this.pageFollowTOs.add(new PageFollowPatchTransferObject(pageFollow));
    }

    public static PageFollowRequestTransferObject fromPageFollow(PageFollow pageFollow) {
        PageFollowRequestTransferObject pageFollowRequestTransferObject = new PageFollowRequestTransferObject();
        List<PageFollow> pageFollows = ((PageFollowImpl) pageFollow).getPageFollows();
        if (!pageFollows.isEmpty()) {
            Iterator<PageFollow> it = pageFollows.iterator();
            while (it.hasNext()) {
                pageFollowRequestTransferObject.addPageFollow(it.next());
            }
        } else {
            if (pageFollow.getPageReference() != null) {
                pageFollowRequestTransferObject.addLink("page", new Link(pageFollow.getPageReference().getHref(), pageFollow.getPageReference().getId()));
            }
            if (pageFollow.getUserReference() != null) {
                pageFollowRequestTransferObject.addLink("user", new Link(String.format(UrlBuilderImpl.GET_USER_URL, pageFollow.getUserReference().getId()), pageFollow.getUserReference().getId()));
            }
        }
        return pageFollowRequestTransferObject;
    }

    static class PageFollowPatchTransferObject extends ApiTransferObject {
        PageFollowPatchTransferObject(PageFollow pageFollow) {
            if (pageFollow.getPageReference() != null) {
                addLink("page", new Link(pageFollow.getPageReference().getHref(), pageFollow.getPageReference().getId()));
            }
            if (pageFollow.getUserReference() != null) {
                addLink("user", new Link(String.format(UrlBuilderImpl.GET_USER_URL, pageFollow.getUserReference().getId()), pageFollow.getUserReference().getId()));
            }
        }
    }
}
