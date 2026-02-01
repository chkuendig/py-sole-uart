package com.ua.sdk.recorder;

/* loaded from: classes2.dex */
public interface RecorderManagerObserver {
    void onRecorderCreated(String str);

    void onRecorderDestroyed(String str);

    void onRecorderRecovered(String str);
}
