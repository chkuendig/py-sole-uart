package com.android.ddmlib;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class EmulatorConsole {
    private static final Map<String, EmulatorConsole> sTestConsoles = new HashMap();

    public abstract void close();

    public abstract String getAvdName();

    public abstract String getAvdPath() throws CommandFailedException;

    public abstract void kill();

    public abstract String startEmulatorScreenRecording(String args);

    public abstract String stopScreenRecording();

    public static void registerConsoleForTest(String deviceSerial, EmulatorConsole console) {
        sTestConsoles.put(deviceSerial, console);
    }

    public static void clearConsolesForTest() {
        sTestConsoles.clear();
    }

    public static EmulatorConsole getConsole(IDevice d) {
        EmulatorConsole emulatorConsole = sTestConsoles.get(d.getSerialNumber());
        return emulatorConsole == null ? EmulatorConsoleImpl.createConsole(d) : emulatorConsole;
    }

    public static Integer getEmulatorPort(String serialNumber) {
        return EmulatorConsoleImpl.getEmulatorPortFromSerialNumber(serialNumber);
    }
}
