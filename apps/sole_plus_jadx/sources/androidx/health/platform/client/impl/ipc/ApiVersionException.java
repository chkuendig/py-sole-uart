package androidx.health.platform.client.impl.ipc;

import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public class ApiVersionException extends ExecutionException {
    private final int mMinVersion;
    private final int mRemoteVersion;

    public ApiVersionException(int i, int i2) {
        super("Version requirements for calling the method was not met, remoteVersion: " + i + ", minVersion: " + i2);
        this.mRemoteVersion = i;
        this.mMinVersion = i2;
    }

    public int getRemoteVersion() {
        return this.mRemoteVersion;
    }

    public int getMinVersion() {
        return this.mMinVersion;
    }
}
