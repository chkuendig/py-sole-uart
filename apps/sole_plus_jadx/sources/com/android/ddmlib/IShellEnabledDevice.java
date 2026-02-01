package com.android.ddmlib;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public interface IShellEnabledDevice {
    void executeShellCommand(String command, IShellOutputReceiver receiver, long maxTimeout, long maxTimeToOutputResponse, TimeUnit maxTimeUnits) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    void executeShellCommand(String command, IShellOutputReceiver receiver, long maxTimeToOutputResponse, TimeUnit maxTimeUnits) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    String getName();

    ListenableFuture<String> getSystemProperty(String name);
}
