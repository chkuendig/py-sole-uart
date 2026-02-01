package com.android.utils;

import com.android.SdkConstants;
import java.io.PrintStream;

/* loaded from: classes3.dex */
public class StdLogger implements ILogger {
    private final Level mLevel;

    public enum Level {
        VERBOSE(0),
        INFO(1),
        WARNING(2),
        ERROR(3);

        private final int mLevel;

        Level(int level) {
            this.mLevel = level;
        }
    }

    public StdLogger(Level level) {
        if (level == null) {
            throw new IllegalArgumentException("level cannot be null");
        }
        this.mLevel = level;
    }

    public Level getLevel() {
        return this.mLevel;
    }

    @Override // com.android.utils.ILogger
    public void error(Throwable t, String errorFormat, Object... args) {
        if (errorFormat != null) {
            printMessage(String.format("Error: " + errorFormat, args), System.err);
        }
        if (t != null) {
            System.err.println(String.format("Error: %1$s", t.getMessage()));
        }
    }

    @Override // com.android.utils.ILogger
    public void warning(String warningFormat, Object... args) {
        if (this.mLevel.mLevel > Level.WARNING.mLevel) {
            return;
        }
        printMessage(String.format("Warning: " + warningFormat, args), System.out);
    }

    @Override // com.android.utils.ILogger
    public void info(String msgFormat, Object... args) {
        if (this.mLevel.mLevel > Level.INFO.mLevel) {
            return;
        }
        printMessage(String.format(msgFormat, args), System.out);
    }

    @Override // com.android.utils.ILogger
    public void verbose(String msgFormat, Object... args) {
        if (this.mLevel.mLevel > Level.VERBOSE.mLevel) {
            return;
        }
        printMessage(String.format(msgFormat, args), System.out);
    }

    private void printMessage(String msg, PrintStream stream) {
        if (SdkConstants.CURRENT_PLATFORM == 2 && !msg.endsWith("\r\n") && msg.endsWith("\n")) {
            msg = msg.substring(0, msg.length() - 1);
        }
        if (msg.endsWith("\n")) {
            stream.print(msg);
        } else {
            stream.println(msg);
        }
    }
}
