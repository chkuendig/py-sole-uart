package com.android.ddmlib;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class AdbVersion implements Comparable<AdbVersion> {
    public final int major;
    public final int micro;
    public final int minor;
    public static final AdbVersion UNKNOWN = new AdbVersion(-1, -1, -1);
    private static final Pattern ADB_VERSION_PATTERN = Pattern.compile("^.*(\\d+)\\.(\\d+)\\.(\\d+).*");

    private AdbVersion(int major, int minor, int micro) {
        this.major = major;
        this.minor = minor;
        this.micro = micro;
    }

    public String toString() {
        return String.format(Locale.US, "%1$d.%2$d.%3$d", Integer.valueOf(this.major), Integer.valueOf(this.minor), Integer.valueOf(this.micro));
    }

    @Override // java.lang.Comparable
    public int compareTo(AdbVersion o) {
        int i = this.major;
        int i2 = o.major;
        if (i != i2) {
            return i - i2;
        }
        int i3 = this.minor;
        int i4 = o.minor;
        return i3 != i4 ? i3 - i4 : this.micro - o.micro;
    }

    public static AdbVersion parseFrom(String input) {
        Matcher matcher = ADB_VERSION_PATTERN.matcher(input);
        if (matcher.matches()) {
            return new AdbVersion(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
        }
        return UNKNOWN;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdbVersion adbVersion = (AdbVersion) o;
        return this.major == adbVersion.major && this.minor == adbVersion.minor && this.micro == adbVersion.micro;
    }

    public int hashCode() {
        return (((this.major * 31) + this.minor) * 31) + this.micro;
    }
}
