package com.ua.sdk;

import com.ua.sdk.Resource;

/* loaded from: classes2.dex */
public interface SaveCallback<T extends Resource> {
    void onSaved(T t, UaException uaException);
}
