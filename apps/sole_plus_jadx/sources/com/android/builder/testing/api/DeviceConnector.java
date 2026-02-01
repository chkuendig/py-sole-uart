package com.android.builder.testing.api;

import com.android.ddmlib.AdbCommandRejectedException;
import com.android.ddmlib.IDevice;
import com.android.ddmlib.IShellEnabledDevice;
import com.android.ddmlib.ShellCommandUnresponsiveException;
import com.android.ddmlib.TimeoutException;
import com.android.utils.ILogger;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class DeviceConnector implements IShellEnabledDevice {
    public abstract void connect(int i, ILogger iLogger) throws TimeoutException;

    public abstract void disconnect(int i, ILogger iLogger) throws TimeoutException;

    public abstract List<String> getAbis();

    public abstract String getApiCodeName();

    public abstract int getApiLevel();

    public abstract int getDensity();

    public abstract DeviceConfig getDeviceConfig() throws DeviceException;

    public abstract int getHeight();

    public abstract String getLanguage();

    public abstract Set<String> getLanguageSplits() throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    public abstract String getNullableProperty(String str);

    public abstract String getProperty(String str);

    public abstract String getRegion();

    public abstract String getSerialNumber();

    public abstract IDevice.DeviceState getState();

    public abstract int getWidth();

    public abstract void installPackage(File file, Collection<String> collection, int i, ILogger iLogger) throws DeviceException;

    public abstract void installPackages(List<File> list, Collection<String> collection, int i, ILogger iLogger) throws DeviceException;

    public abstract void pullFile(String str, String str2) throws IOException;

    public abstract void uninstallPackage(String str, int i, ILogger iLogger) throws DeviceException;
}
