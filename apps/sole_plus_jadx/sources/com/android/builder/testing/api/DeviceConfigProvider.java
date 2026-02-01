package com.android.builder.testing.api;

import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public interface DeviceConfigProvider {
    List<String> getAbis();

    default String getApiCodeName() {
        return null;
    }

    default int getApiLevel() {
        return 1;
    }

    String getConfigFor(String str);

    int getDensity();

    String getLanguage();

    default Set<String> getLanguageSplits() {
        return null;
    }

    String getRegion();
}
