package com.android.ddmlib;

import com.google.common.collect.Sets;
import io.ktor.util.date.GMTDateParser;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.objectweb.asm.signature.SignatureVisitor;

/* loaded from: classes3.dex */
public final class Log {
    private static final char[] mSpaceLine;
    private static ILogOutput sLogOutput;
    private static LogLevel sLevel = DdmPreferences.getLogLevel();
    private static final Set<ILogOutput> sOutputLoggers = Sets.newCopyOnWriteArraySet();
    private static final SimpleDateFormat sLogFormatter = new SimpleDateFormat("hh:mm:ss", Locale.US);
    private static final char[] mHexDigit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};

    public static final class Config {
        public static final boolean LOGD = true;
        public static final boolean LOGV = true;
    }

    public interface ILogOutput {
        void printAndPromptLog(LogLevel logLevel, String tag, String message);

        void printLog(LogLevel logLevel, String tag, String message);
    }

    public enum LogLevel {
        VERBOSE(2, "verbose", 'V'),
        DEBUG(3, "debug", 'D'),
        INFO(4, "info", 'I'),
        WARN(5, "warn", 'W'),
        ERROR(6, "error", 'E'),
        ASSERT(7, "assert", 'A');

        private char mPriorityLetter;
        private int mPriorityLevel;
        private String mStringValue;

        LogLevel(int intPriority, String stringValue, char priorityChar) {
            this.mPriorityLevel = intPriority;
            this.mStringValue = stringValue;
            this.mPriorityLetter = priorityChar;
        }

        public static LogLevel getByString(String value) {
            for (LogLevel logLevel : values()) {
                if (logLevel.mStringValue.equals(value)) {
                    return logLevel;
                }
            }
            return null;
        }

        public static LogLevel getByLetter(char letter) {
            for (LogLevel logLevel : values()) {
                if (logLevel.mPriorityLetter == letter) {
                    return logLevel;
                }
            }
            return null;
        }

        public static LogLevel getByLetterString(String letter) {
            if (letter.isEmpty()) {
                return null;
            }
            return getByLetter(letter.charAt(0));
        }

        public char getPriorityLetter() {
            return this.mPriorityLetter;
        }

        public int getPriority() {
            return this.mPriorityLevel;
        }

        public String getStringValue() {
            return this.mStringValue;
        }
    }

    static {
        char[] cArr = new char[72];
        mSpaceLine = cArr;
        for (int length = cArr.length - 1; length >= 0; length--) {
            mSpaceLine[length] = ' ';
        }
        char[] cArr2 = mSpaceLine;
        cArr2[3] = '0';
        cArr2[2] = '0';
        cArr2[1] = '0';
        cArr2[0] = '0';
        cArr2[4] = SignatureVisitor.SUPER;
    }

    private Log() {
    }

    public static void v(String tag, String message) {
        println(LogLevel.VERBOSE, tag, message);
    }

    public static void d(String tag, String message) {
        println(LogLevel.DEBUG, tag, message);
    }

    public static void i(String tag, String message) {
        println(LogLevel.INFO, tag, message);
    }

    public static void w(String tag, String message) {
        println(LogLevel.WARN, tag, message);
    }

    public static void e(String tag, String message) {
        println(LogLevel.ERROR, tag, message);
    }

    public static void logAndDisplay(LogLevel logLevel, String tag, String message) {
        Set<ILogOutput> set = sOutputLoggers;
        if (!set.isEmpty()) {
            Iterator<ILogOutput> it = set.iterator();
            while (it.hasNext()) {
                it.next().printAndPromptLog(logLevel, tag, message);
            }
        }
        ILogOutput iLogOutput = sLogOutput;
        if (iLogOutput != null) {
            iLogOutput.printAndPromptLog(logLevel, tag, message);
        } else if (sOutputLoggers.isEmpty()) {
            println(logLevel, tag, message);
        }
    }

    public static void v(String tag, Throwable throwable) {
        logThrowable(LogLevel.VERBOSE, tag, throwable);
    }

    public static void d(String tag, Throwable throwable) {
        logThrowable(LogLevel.DEBUG, tag, throwable);
    }

    public static void i(String tag, Throwable throwable) {
        logThrowable(LogLevel.INFO, tag, throwable);
    }

    public static void w(String tag, Throwable throwable) {
        logThrowable(LogLevel.WARN, tag, throwable);
    }

    public static void e(String tag, Throwable throwable) {
        logThrowable(LogLevel.ERROR, tag, throwable);
    }

    private static void logThrowable(LogLevel level, String tag, Throwable throwable) {
        if (throwable != null) {
            StringWriter stringWriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringWriter));
            println(level, tag, throwable.getMessage() + '\n' + stringWriter.toString());
        }
    }

    public static void setLevel(LogLevel logLevel) {
        sLevel = logLevel;
    }

    public static boolean isAtLeast(LogLevel logLevel) {
        return logLevel.getPriority() >= sLevel.getPriority();
    }

    @Deprecated
    public static void setLogOutput(ILogOutput logOutput) {
        sLogOutput = logOutput;
    }

    public static void addLogger(ILogOutput logOutput) {
        sOutputLoggers.add(logOutput);
    }

    public static void removeLogger(ILogOutput logOutput) {
        sOutputLoggers.remove(logOutput);
    }

    public static void hexDump(String tag, LogLevel level, byte[] data, int offset, int length) {
        char[] cArr = new char[mSpaceLine.length];
        int i = offset;
        int i2 = length;
        boolean z = true;
        int i3 = 0;
        while (i2 != 0) {
            int i4 = 16;
            if (i2 <= 16) {
                z = true;
                i4 = i2;
            }
            if (z) {
                char[] cArr2 = mSpaceLine;
                System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
                z = false;
            }
            int i5 = 3;
            for (int i6 = 65535 & i3; i6 != 0; i6 >>>= 4) {
                cArr[i5] = mHexDigit[i6 & 15];
                i5--;
            }
            int i7 = 6;
            for (int i8 = 0; i8 < i4; i8++) {
                byte b = data[i + i8];
                char[] cArr3 = mHexDigit;
                cArr[i7] = cArr3[(b >>> 4) & 15];
                cArr[i7 + 1] = cArr3[b & 15];
                i7 += 3;
                if (b >= 32 && b < 127) {
                    cArr[55 + i8] = (char) b;
                } else {
                    cArr[55 + i8] = '.';
                }
            }
            println(level, tag, new String(cArr));
            i2 -= i4;
            i += i4;
            i3 += i4;
        }
    }

    static void hexDump(byte[] data) {
        hexDump("ddms", LogLevel.DEBUG, data, 0, data.length);
    }

    public static void println(LogLevel logLevel, String tag, String message) {
        if (isAtLeast(logLevel)) {
            Set<ILogOutput> set = sOutputLoggers;
            if (!set.isEmpty()) {
                Iterator<ILogOutput> it = set.iterator();
                while (it.hasNext()) {
                    it.next().printLog(logLevel, tag, message);
                }
            }
            ILogOutput iLogOutput = sLogOutput;
            if (iLogOutput != null) {
                iLogOutput.printLog(logLevel, tag, message);
            } else if (sOutputLoggers.isEmpty()) {
                printLog(logLevel, tag, message);
            }
        }
    }

    public static void printLog(LogLevel logLevel, String tag, String message) {
        System.out.print(getLogFormatString(logLevel, tag, message));
    }

    public static String getLogFormatString(LogLevel logLevel, String tag, String message) {
        return String.format("%s %c/%s: %s\n", sLogFormatter.format(new Date()), Character.valueOf(logLevel.getPriorityLetter()), tag, message);
    }
}
