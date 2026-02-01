package com.ua.sdk;

import com.ua.sdk.Resource;
import java.util.List;

/* loaded from: classes2.dex */
public interface MultipleCreateCallback<T extends Resource> {
    void onSynced(List<T> list, UaException uaException);
}
