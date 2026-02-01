package com.android.ddmlib.logcat;

import java.util.Objects;

/* loaded from: classes3.dex */
public class LogCatMessage {
    private final LogCatHeader header;
    private final String message;

    public LogCatMessage(LogCatHeader header, String message) {
        this.header = header;
        this.message = message;
    }

    public LogCatHeader getHeader() {
        return this.header;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return String.format("%s: %s", this.header, this.message);
    }

    public int hashCode() {
        return Objects.hash(this.header, this.message);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LogCatMessage)) {
            return false;
        }
        LogCatMessage logCatMessage = (LogCatMessage) obj;
        return Objects.equals(this.header, logCatMessage.header) && Objects.equals(this.message, logCatMessage.message);
    }
}
