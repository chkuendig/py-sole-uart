package com.android.incfs.install;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface IDeviceConnection extends AutoCloseable {

    public interface Factory {
        IDeviceConnection connectToService(String service, String[] parameters) throws IOException;
    }

    int read(ByteBuffer buffer, long timeOutMs) throws IOException;

    int write(ByteBuffer buffer, long timeOutMs) throws IOException;
}
