package com.android.builder.testing.api;

import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class DeviceConfigProviderImpl implements DeviceConfigProvider {
    private final DeviceConfig deviceConfig;
    private final DeviceConnector deviceConnector;

    public DeviceConfigProviderImpl(DeviceConnector deviceConnector) throws DeviceException {
        this.deviceConnector = deviceConnector;
        this.deviceConfig = deviceConnector.getDeviceConfig();
    }

    @Override // com.android.builder.testing.api.DeviceConfigProvider
    public String getConfigFor(String str) {
        return this.deviceConfig.getConfigFor(str);
    }

    @Override // com.android.builder.testing.api.DeviceConfigProvider
    public int getDensity() {
        return this.deviceConnector.getDensity();
    }

    @Override // com.android.builder.testing.api.DeviceConfigProvider
    public String getLanguage() {
        return this.deviceConnector.getLanguage();
    }

    @Override // com.android.builder.testing.api.DeviceConfigProvider
    public Set<String> getLanguageSplits() {
        try {
            return this.deviceConnector.getLanguageSplits();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.android.builder.testing.api.DeviceConfigProvider
    public String getRegion() {
        return this.deviceConnector.getRegion();
    }

    @Override // com.android.builder.testing.api.DeviceConfigProvider
    public List<String> getAbis() {
        return this.deviceConnector.getAbis();
    }

    @Override // com.android.builder.testing.api.DeviceConfigProvider
    public String getApiCodeName() {
        return this.deviceConnector.getApiCodeName();
    }

    @Override // com.android.builder.testing.api.DeviceConfigProvider
    public int getApiLevel() {
        return this.deviceConnector.getApiLevel();
    }
}
