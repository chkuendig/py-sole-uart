package com.android.ddmlib;

import com.android.ddmlib.IDevice;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class AdbDevice {
    private static Pattern SERIAL_PATTERN = Pattern.compile("([\\S&&[^\\(]]\\S*|\\(.*\\))\\s+(\\S+)\\s*.*$");
    private String serial;
    private IDevice.DeviceState state;

    public AdbDevice(String serial, IDevice.DeviceState state) {
        this.serial = serial;
        this.state = state;
    }

    public String getSerial() {
        return this.serial;
    }

    public IDevice.DeviceState getState() {
        return this.state;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdbDevice adbDevice = (AdbDevice) o;
        return Objects.equals(this.serial, adbDevice.serial) && this.state == adbDevice.state;
    }

    public int hashCode() {
        return Objects.hash(this.serial, this.state);
    }

    public static AdbDevice parseAdbLine(String line) {
        Matcher matcher = SERIAL_PATTERN.matcher(line);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        return new AdbDevice((strGroup == null || !strGroup.startsWith("(")) ? strGroup : null, IDevice.DeviceState.getState(matcher.group(2)));
    }
}
