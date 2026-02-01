package com.ua.sdk.page.association;

import com.ua.sdk.internal.ApiTransferObject;

/* loaded from: classes2.dex */
public class PageAssociationTransferObject extends ApiTransferObject {
    public static PageAssociationTransferObject fromPageAssocaition(PageAssociation pageAssociation) {
        PageAssociationTransferObject pageAssociationTransferObject = new PageAssociationTransferObject();
        if (pageAssociation instanceof PageAssociationImpl) {
            pageAssociationTransferObject.setLinkMap(((PageAssociationImpl) pageAssociation).getLinkMap());
        }
        return pageAssociationTransferObject;
    }

    public static PageAssociationImpl toPageAssocaitionImpl(PageAssociationTransferObject pageAssociationTransferObject) {
        if (pageAssociationTransferObject == null) {
            return null;
        }
        PageAssociationImpl pageAssociationImpl = new PageAssociationImpl();
        pageAssociationImpl.setLinkMap(pageAssociationTransferObject.getLinkMap());
        return pageAssociationImpl;
    }
}
