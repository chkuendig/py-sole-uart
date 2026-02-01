package com.digifly.cloudapi.listener;

import com.digifly.cloudapi.data.DCTrainingDetailData;
import com.digifly.cloudapi.data.ResponseDetailDataGet;
import java.util.List;

/* loaded from: classes.dex */
public interface DCGetTrainingDetailDataListener {
    void onError(String str);

    void onFail(ResponseDetailDataGet responseDetailDataGet);

    void onSuccess(List<DCTrainingDetailData> list);
}
