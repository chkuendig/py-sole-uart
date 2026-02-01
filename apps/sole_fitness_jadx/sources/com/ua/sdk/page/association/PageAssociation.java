package com.ua.sdk.page.association;

import com.ua.sdk.Entity;
import com.ua.sdk.EntityRef;
import com.ua.sdk.page.Page;

/* loaded from: classes2.dex */
public interface PageAssociation extends Entity {
    EntityRef<Page> getFromPage();

    EntityRef<Page> getToPage();
}
