package com.ua.sdk.concurrent;

import com.ua.sdk.Resource;
import com.ua.sdk.SaveCallback;
import com.ua.sdk.UaException;

/* loaded from: classes2.dex */
public class SaveRequest<T extends Resource> extends AsyncRequest<T> {
    private final SaveCallback<T> callback;

    public SaveRequest(SaveCallback<T> saveCallback) {
        this.callback = saveCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ua.sdk.concurrent.AsyncRequest
    public void onDone(T t, UaException uaException) {
        EntityEventHandler.callOnSaved(t, uaException, this.callback);
    }
}
