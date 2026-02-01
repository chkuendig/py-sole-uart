package com.ua.sdk;

import com.ua.sdk.Resource;

/* loaded from: classes2.dex */
public interface UploadCallback<T extends Resource> {
    void onProgress(long j);

    void onUploaded(T t, UaException uaException);
}
