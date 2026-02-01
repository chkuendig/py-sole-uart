package com.android;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Properties;

/* loaded from: classes3.dex */
public final class Version {
    public static final String ANDROID_GRADLE_PLUGIN_VERSION;
    public static final String ANDROID_TOOLS_BASE_VERSION;
    public static final int BUILDER_MODEL_API_VERSION;
    public static final int BUILDER_NATIVE_MODEL_API_VERSION;
    public static final String TOOLS_VERSION;

    static {
        Properties properties = new Properties();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Version.class.getResourceAsStream("version.properties"));
        try {
            try {
                properties.load(bufferedInputStream);
                ANDROID_GRADLE_PLUGIN_VERSION = properties.getProperty("buildVersion");
                TOOLS_VERSION = properties.getProperty("cmdlineToolsVersion");
                ANDROID_TOOLS_BASE_VERSION = properties.getProperty("baseVersion");
                BUILDER_MODEL_API_VERSION = Integer.parseInt(properties.getProperty("apiVersion"));
                BUILDER_NATIVE_MODEL_API_VERSION = Integer.parseInt(properties.getProperty("nativeApiVersion"));
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private Version() {
    }
}
