package com.digifly.cloudapi.listener;

import com.digifly.cloudapi.data.ResponseDataCollection;

/* loaded from: classes.dex */
public interface DCGoalUploadUpdateListener {
    void onError(String str);

    void onFail(ResponseDataCollection responseDataCollection);

    void onSuccess(ResponseDataCollection responseDataCollection);
}
