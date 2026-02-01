package com.android.builder.testing.api;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

@Deprecated
/* loaded from: classes3.dex */
public abstract class DeviceProvider {
    public abstract List<? extends DeviceConnector> getDevices();

    public abstract String getName();

    public abstract int getTimeoutInMs();

    public abstract void init() throws DeviceException;

    public abstract boolean isConfigured();

    public abstract void terminate() throws DeviceException;

    public final <V> V use(Callable<V> callable) throws ExecutionException, DeviceException {
        init();
        try {
            try {
                return callable.call();
            } catch (Exception e) {
                throw new ExecutionException(e);
            }
        } finally {
            terminate();
        }
    }
}
