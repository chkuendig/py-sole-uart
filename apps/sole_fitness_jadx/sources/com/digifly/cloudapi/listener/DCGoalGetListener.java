package com.digifly.cloudapi.listener;

import com.digifly.cloudapi.data.DCGoalWebData;
import com.digifly.cloudapi.data.ResponseMessage;
import java.util.List;

/* loaded from: classes.dex */
public interface DCGoalGetListener {
    void onError(String str);

    void onFail(ResponseMessage responseMessage);

    void onSuccess(List<DCGoalWebData> list);
}
