package com.android.ddmlib.logcat;

import com.android.ddmlib.Log;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes3.dex */
public class LogCatHeader {
    private static final DateTimeFormatter EPOCH_TIME_FORMATTER = new DateTimeFormatterBuilder().appendValue(ChronoField.INSTANT_SECONDS).appendFraction(ChronoField.MILLI_OF_SECOND, 3, 3, true).toFormatter(Locale.ROOT);
    private final String appName;
    private final Log.LogLevel logLevel;
    private final int pid;
    private final String tag;
    private final int tid;
    private final Instant timestamp;

    public LogCatHeader(Log.LogLevel level, int pid, int tid, String name, String tag, Instant timestamp) {
        this.logLevel = level;
        this.pid = pid;
        this.tid = tid;
        this.appName = name;
        this.tag = tag;
        this.timestamp = timestamp;
    }

    public Log.LogLevel getLogLevel() {
        return this.logLevel;
    }

    public int getPid() {
        return this.pid;
    }

    public int getTid() {
        return this.tid;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getTag() {
        return this.tag;
    }

    public Instant getTimestamp() {
        return this.timestamp;
    }

    public Log.LogLevel component1() {
        return getLogLevel();
    }

    public int component2() {
        return getPid();
    }

    public int component3() {
        return getTid();
    }

    public String component4() {
        return getAppName();
    }

    public String component5() {
        return getTag();
    }

    public Instant component6() {
        return getTimestamp();
    }

    public String toString() {
        return String.format(Locale.ROOT, "%s: %c/%s(%d:%d) %s", EPOCH_TIME_FORMATTER.format(this.timestamp), Character.valueOf(this.logLevel.getPriorityLetter()), this.tag, Integer.valueOf(this.pid), Integer.valueOf(this.tid), this.appName);
    }

    public int hashCode() {
        return Objects.hash(this.logLevel, Integer.valueOf(this.pid), Integer.valueOf(this.tid), this.appName, this.tag, this.timestamp);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LogCatHeader)) {
            return false;
        }
        LogCatHeader logCatHeader = (LogCatHeader) obj;
        return this.logLevel == logCatHeader.logLevel && this.pid == logCatHeader.pid && this.tid == logCatHeader.tid && this.appName.equals(logCatHeader.appName) && this.tag.equals(logCatHeader.tag) && this.timestamp.equals(logCatHeader.timestamp);
    }
}
