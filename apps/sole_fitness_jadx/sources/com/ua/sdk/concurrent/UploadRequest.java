package com.ua.sdk.concurrent;

import com.ua.sdk.Resource;
import com.ua.sdk.UaException;
import com.ua.sdk.UploadCallback;

/* loaded from: classes2.dex */
public class UploadRequest<T extends Resource> extends AsyncRequest<T> {
    private final UploadCallback callback;

    public UploadRequest(UploadCallback uploadCallback) {
        this.callback = uploadCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ua.sdk.concurrent.AsyncRequest
    public void onDone(T t, UaException uaException) {
        EntityEventHandler.callOnUploadUploaded(t, uaException, this.callback);
    }
}
