package com.android.ddmlib.logcat;

import com.android.ddmlib.IDevice;
import com.android.ddmlib.Log;
import com.samsung.android.sdk.healthdata.HealthConstants;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class LogCatHeaderParser {
    private static final Pattern DATE;
    private static final Pattern EPOCH;
    private static final Pattern HEADER;
    private static final Pattern PID;
    private static final Pattern PRIORITY;
    private static final Pattern TAG;
    private static final Pattern TID;
    private static final Pattern TIME;
    private static final String UNKNOWN_APP_NAME = "?";
    private final int defaultYear;
    private final ZoneId defaultZoneId;

    @FunctionalInterface
    public interface PidToPackageName {
        String apply(int pid);
    }

    static {
        Pattern patternCompile = Pattern.compile("(?<epoch>(?<epochSec>\\d+)\\.(?<epochMilli>\\d\\d\\d))");
        EPOCH = patternCompile;
        Pattern patternCompile2 = Pattern.compile("(?<month>\\d\\d)-(?<day>\\d\\d)");
        DATE = patternCompile2;
        Pattern patternCompile3 = Pattern.compile("(?<hour>\\d\\d):(?<min>\\d\\d):(?<sec>\\d\\d)\\.(?<milli>\\d\\d\\d)");
        TIME = patternCompile3;
        Pattern patternCompile4 = Pattern.compile("(?<pid>\\d+)");
        PID = patternCompile4;
        Pattern patternCompile5 = Pattern.compile("(?<tid>\\w+)");
        TID = patternCompile5;
        Pattern patternCompile6 = Pattern.compile("(?<priority>[VDIWEAF])");
        PRIORITY = patternCompile6;
        Pattern patternCompile7 = Pattern.compile("(?<tag>.*?)");
        TAG = patternCompile7;
        HEADER = Pattern.compile(String.format("^\\[ +((%s +%s)|(%s)) +%s: *%s +%s/%s +]$", patternCompile2, patternCompile3, patternCompile, patternCompile4, patternCompile5, patternCompile6, patternCompile7));
    }

    public LogCatHeaderParser() {
        this(ZonedDateTime.now().getYear(), ZoneId.systemDefault());
    }

    public LogCatHeaderParser(int year, ZoneId id2) {
        this.defaultYear = year;
        this.defaultZoneId = id2;
    }

    public LogCatHeader parseHeader(String line, final IDevice device) {
        return parseHeader(line, new PidToPackageName() { // from class: com.android.ddmlib.logcat.LogCatHeaderParser$$ExternalSyntheticLambda0
            @Override // com.android.ddmlib.logcat.LogCatHeaderParser.PidToPackageName
            public final String apply(int i) {
                return this.f$0.m7989x56f3ad23(device, i);
            }
        });
    }

    public LogCatHeader parseHeader(String line, PidToPackageName pidToPackageName) {
        Instant instantFrom;
        Matcher matcher = HEADER.matcher(line);
        if (!matcher.matches()) {
            return null;
        }
        if (matcher.group("epoch") != null) {
            instantFrom = Instant.ofEpochSecond(parseEpochSeconds(matcher.group("epochSec")), TimeUnit.MILLISECONDS.toNanos(Long.parseLong(matcher.group("epochMilli"))));
        } else {
            instantFrom = Instant.from(ZonedDateTime.of(this.defaultYear, Integer.parseInt(matcher.group("month")), Integer.parseInt(matcher.group("day")), Integer.parseInt(matcher.group("hour")), Integer.parseInt(matcher.group(HealthConstants.HeartRate.MIN)), Integer.parseInt(matcher.group("sec")), (int) TimeUnit.MILLISECONDS.toNanos(Long.parseLong(matcher.group("milli"))), this.defaultZoneId));
        }
        Instant instant = instantFrom;
        int pid = parsePid(matcher.group("pid"));
        return new LogCatHeader(parsePriority(matcher.group("priority")), pid, parseThreadId(matcher.group("tid")), pidToPackageName.apply(pid), matcher.group("tag"), instant);
    }

    private Log.LogLevel parsePriority(String string) {
        Log.LogLevel byLetterString = Log.LogLevel.getByLetterString(string);
        if (byLetterString != null) {
            return byLetterString;
        }
        if (!string.equals("F")) {
            return Log.LogLevel.WARN;
        }
        return Log.LogLevel.ASSERT;
    }

    private int parseThreadId(String string) {
        try {
            return Integer.decode(string).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private int parsePid(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private long parseEpochSeconds(String string) {
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPackageName, reason: merged with bridge method [inline-methods] */
    public String m7989x56f3ad23(IDevice device, int pid) {
        String clientName;
        return (device == null || (clientName = device.getClientName(pid)) == null || clientName.isEmpty()) ? "?" : clientName;
    }
}
