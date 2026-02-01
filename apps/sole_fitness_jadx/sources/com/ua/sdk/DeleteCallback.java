package com.ua.sdk;

import com.ua.sdk.Reference;

/* loaded from: classes2.dex */
public interface DeleteCallback<R extends Reference> {
    void onDeleted(R r, UaException uaException);
}
