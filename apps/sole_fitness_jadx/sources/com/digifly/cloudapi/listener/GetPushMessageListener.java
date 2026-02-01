package com.digifly.cloudapi.listener;

import com.digifly.cloudapi.data.ResponseMessagePush;

/* loaded from: classes.dex */
public interface GetPushMessageListener {
    void onError(String str);

    void onFail(ResponseMessagePush responseMessagePush);

    void onSuccess(ResponseMessagePush responseMessagePush);
}
