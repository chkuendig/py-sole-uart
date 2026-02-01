package com.android.ddmlib;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class AdbInitOptions {
    public static final AdbInitOptions DEFAULT = builder().build();
    public final ImmutableMap<String, String> adbEnvVars;
    public final boolean clientSupport;
    public final int maxJdwpPacketSize;
    public final boolean useDdmlibCommandService;
    public final boolean useJdwpProxyService;
    public final boolean userManagedAdbMode;
    public final int userManagedAdbPort;

    public static Builder builder() {
        return new Builder();
    }

    private AdbInitOptions(boolean clientSupport, boolean userManagedAdbMode, int userManagedAdbPort, ImmutableMap<String, String> adbEnvVars, boolean useJdwpService, boolean useDdmlibCommandService, int maxJdwpPacketSize) {
        this.clientSupport = clientSupport;
        this.userManagedAdbMode = userManagedAdbMode;
        this.userManagedAdbPort = userManagedAdbPort;
        this.adbEnvVars = adbEnvVars;
        this.useJdwpProxyService = useJdwpService;
        this.useDdmlibCommandService = useDdmlibCommandService;
        this.maxJdwpPacketSize = maxJdwpPacketSize;
    }

    public static class Builder {
        boolean clientSupport = false;
        boolean userManagedAdbMode = false;
        boolean useJdwpProxyService = DdmPreferences.isJdwpProxyEnabled();
        boolean useDdmlibCommandService = DdmPreferences.isDdmlibCommandServiceEnabled();
        int jdwpMaxPacketSize = DdmPreferences.getJdwpMaxPacketSize();
        int userManagedAdbPort = 0;
        ImmutableMap.Builder<String, String> envVarBuilder = ImmutableMap.builder();

        public Builder setClientSupportEnabled(boolean enabled) {
            this.clientSupport = enabled;
            return this;
        }

        public Builder useJdwpProxyService(boolean enabled) {
            this.useJdwpProxyService = enabled;
            return this;
        }

        public Builder useDdmlibCommandService(boolean enabled) {
            this.useDdmlibCommandService = enabled;
            return this;
        }

        public Builder setJdwpMaxPacketSize(int size) {
            this.jdwpMaxPacketSize = size;
            return this;
        }

        public Builder enableUserManagedAdbMode(int port) {
            this.userManagedAdbMode = true;
            this.userManagedAdbPort = port;
            return this;
        }

        public Builder withEnv(String key, String value) {
            this.envVarBuilder.put(key, value);
            return this;
        }

        public Builder withEnv(Map<String, String> envVars) {
            this.envVarBuilder.putAll(envVars);
            return this;
        }

        public AdbInitOptions build() {
            return new AdbInitOptions(this.clientSupport, this.userManagedAdbMode, this.userManagedAdbPort, this.envVarBuilder.build(), this.useJdwpProxyService, this.useDdmlibCommandService, this.jdwpMaxPacketSize);
        }
    }
}
