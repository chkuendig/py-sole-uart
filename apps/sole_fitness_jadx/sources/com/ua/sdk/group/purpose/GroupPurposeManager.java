package com.ua.sdk.group.purpose;

import com.ua.sdk.EntityList;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;

/* loaded from: classes2.dex */
public interface GroupPurposeManager {
    EntityList<GroupPurpose> fetchGroupPurposeList() throws UaException;

    Request fetchGroupPurposeList(FetchCallback<EntityList<GroupPurpose>> fetchCallback);
}
