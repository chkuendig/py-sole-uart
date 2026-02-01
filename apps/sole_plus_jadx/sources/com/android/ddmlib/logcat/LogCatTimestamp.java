package com.android.ddmlib.logcat;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class LogCatTimestamp {
    private static final Pattern sTimePattern = Pattern.compile("^(\\d\\d)-(\\d\\d)\\s(\\d\\d):(\\d\\d):(\\d\\d)\\.(\\d+)$");

    private LogCatTimestamp() {
    }

    public static Instant parse(String timeString) {
        return parse(timeString, ZonedDateTime.now().getYear(), ZoneId.systemDefault());
    }

    static Instant parse(String timeString, int year, ZoneId zoneId) throws NumberFormatException {
        Matcher matcher = sTimePattern.matcher(timeString);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid timestamp. Expected MM-DD HH:MM:SS:mmm");
        }
        int i = Integer.parseInt(matcher.group(1));
        int i2 = Integer.parseInt(matcher.group(2));
        int i3 = Integer.parseInt(matcher.group(3));
        int i4 = Integer.parseInt(matcher.group(4));
        int i5 = Integer.parseInt(matcher.group(5));
        int i6 = Integer.parseInt(matcher.group(6));
        while (i6 >= 1000) {
            i6 /= 10;
        }
        return Instant.from(ZonedDateTime.of(year, i, i2, i3, i4, i5, (int) TimeUnit.MILLISECONDS.toNanos(i6), zoneId));
    }
}
