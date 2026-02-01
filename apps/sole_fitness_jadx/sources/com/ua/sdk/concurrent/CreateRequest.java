package com.ua.sdk.concurrent;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.Resource;
import com.ua.sdk.UaException;

/* loaded from: classes2.dex */
public class CreateRequest<T extends Resource> extends AsyncRequest<T> {
    private final CreateCallback<T> callback;

    public CreateRequest(CreateCallback<T> createCallback) {
        this.callback = createCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ua.sdk.concurrent.AsyncRequest
    public void onDone(T t, UaException uaException) {
        EntityEventHandler.callOnCreated(t, uaException, this.callback);
    }
}
