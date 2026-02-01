package com.digifly.cloudapi.listener;

import com.digifly.cloudapi.data.ResponseMessage;

/* loaded from: classes.dex */
public interface DLUploadErrorCodeListener {
    void onError(String str);

    void onFail(ResponseMessage responseMessage);

    void onSuccess(ResponseMessage responseMessage);
}
