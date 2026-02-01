package com.ua.sdk.concurrent;

import com.ua.sdk.FetchCallback;
import com.ua.sdk.Resource;
import com.ua.sdk.UaException;

/* loaded from: classes2.dex */
public class FetchRequest<T extends Resource> extends AsyncRequest<T> {
    private final FetchCallback<T> callback;

    public FetchRequest(FetchCallback<T> fetchCallback) {
        this.callback = fetchCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ua.sdk.concurrent.AsyncRequest
    public void onDone(T t, UaException uaException) {
        EntityEventHandler.callOnFetched(t, uaException, this.callback);
    }
}
