package com.android.ddmlib.logcat;

import com.android.ddmlib.IDevice;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class LogCatMessageParser {
    private final LogCatHeaderParser mHeaderParser;
    LogCatHeader mPrevHeader;

    public LogCatMessageParser() {
        this(ZonedDateTime.now().getYear(), ZoneId.systemDefault());
    }

    LogCatMessageParser(int year, ZoneId zoneId) {
        this.mHeaderParser = new LogCatHeaderParser(year, zoneId);
    }

    private LogCatHeader processLogHeader(String line, IDevice device) {
        LogCatHeader header = this.mHeaderParser.parseHeader(line, device);
        if (header == null) {
            return null;
        }
        this.mPrevHeader = header;
        return header;
    }

    public List<LogCatMessage> processLogLines(String[] lines, IDevice device) {
        ArrayList arrayList = new ArrayList(lines.length);
        for (String str : lines) {
            if (!str.isEmpty() && processLogHeader(str, device) == null && this.mPrevHeader != null) {
                arrayList.add(new LogCatMessage(this.mPrevHeader, str));
            }
        }
        return arrayList;
    }
}
