package com.ua.sdk.concurrent;

import com.ua.sdk.MultipleCreateCallback;
import com.ua.sdk.Resource;
import com.ua.sdk.UaException;
import java.util.List;

/* loaded from: classes2.dex */
public class MultipleCreateRequest<T extends Resource> extends AsyncRequest<List<T>> {
    private final MultipleCreateCallback<T> callback;

    public MultipleCreateRequest(MultipleCreateCallback<T> multipleCreateCallback) {
        this.callback = multipleCreateCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ua.sdk.concurrent.AsyncRequest
    public void onDone(List<T> list, UaException uaException) {
        EntityEventHandler.callOnMultipleCreated(list, uaException, this.callback);
    }
}
