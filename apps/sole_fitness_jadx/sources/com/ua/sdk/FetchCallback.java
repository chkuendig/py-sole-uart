package com.ua.sdk;

import com.ua.sdk.Resource;

/* loaded from: classes2.dex */
public interface FetchCallback<T extends Resource> {
    void onFetched(T t, UaException uaException);
}
