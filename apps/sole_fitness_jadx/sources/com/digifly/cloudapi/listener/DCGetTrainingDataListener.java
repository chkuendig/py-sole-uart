package com.digifly.cloudapi.listener;

import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.ResponseDataGet;
import java.util.List;

/* loaded from: classes.dex */
public interface DCGetTrainingDataListener {
    void onError(String str);

    void onFail(ResponseDataGet responseDataGet);

    void onSuccess(List<DCTrainingData> list);
}
