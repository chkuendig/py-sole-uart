package com.ua.sdk.concurrent;

import com.ua.sdk.DeleteCallback;
import com.ua.sdk.Reference;
import com.ua.sdk.UaException;

/* loaded from: classes2.dex */
public class DeleteRequest<T extends Reference> extends AsyncRequest<T> {
    private final DeleteCallback<T> callback;

    public DeleteRequest(DeleteCallback<T> deleteCallback) {
        this.callback = deleteCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ua.sdk.concurrent.AsyncRequest
    public void onDone(T t, UaException uaException) {
        EntityEventHandler.callOnDeleted(t, uaException, this.callback);
    }
}
