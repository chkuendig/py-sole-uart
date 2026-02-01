package com.google.firebase.crashlytics.internal.settings;

import com.blankj.utilcode.constant.CacheConstants;
import com.blankj.utilcode.constant.TimeConstants;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.Settings;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    DefaultSettingsJsonTransform() {
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    public Settings buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        return defaultSettings(currentTimeProvider);
    }

    static Settings defaultSettings(CurrentTimeProvider currentTimeProvider) {
        return new Settings(currentTimeProvider.getCurrentTimeMillis() + TimeConstants.HOUR, new Settings.SessionData(8, 4), new Settings.FeatureFlagData(true, false, false), 0, CacheConstants.HOUR, 10.0d, 1.2d, 60);
    }
}
