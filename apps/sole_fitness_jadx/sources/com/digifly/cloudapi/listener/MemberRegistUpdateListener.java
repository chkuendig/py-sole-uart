package com.digifly.cloudapi.listener;

import com.digifly.cloudapi.data.MemberData;
import com.digifly.cloudapi.data.ResponseMessage;

/* loaded from: classes.dex */
public interface MemberRegistUpdateListener {
    void onError(String str);

    void onFail(ResponseMessage responseMessage);

    void onSuccess(MemberData memberData);
}
