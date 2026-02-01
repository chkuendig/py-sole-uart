package com.android.utils;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

/* loaded from: classes3.dex */
public interface EnvironmentProvider {
    public static final DirectEnvironmentProvider DIRECT = new DirectEnvironmentProvider();

    String getEnvVariable(String key);

    String getSystemProperty(String key);

    default FileSystem getFileSystem() {
        return FileSystems.getDefault();
    }

    public static class DirectEnvironmentProvider implements EnvironmentProvider {
        public FileSystem fileSystemOverrideForTests = null;

        @Override // com.android.utils.EnvironmentProvider
        public String getSystemProperty(String key) {
            return System.getProperty(key);
        }

        @Override // com.android.utils.EnvironmentProvider
        public String getEnvVariable(String key) {
            return System.getenv(key);
        }

        @Override // com.android.utils.EnvironmentProvider
        public FileSystem getFileSystem() {
            FileSystem fileSystem = this.fileSystemOverrideForTests;
            return fileSystem != null ? fileSystem : super.getFileSystem();
        }
    }
}
