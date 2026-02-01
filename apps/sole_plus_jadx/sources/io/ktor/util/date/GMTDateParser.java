package io.ktor.util.date;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GMTDateParser.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003J\u001c\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/ktor/util/date/GMTDateParser;", "", "pattern", "", "(Ljava/lang/String;)V", "parse", "Lio/ktor/util/date/GMTDate;", "dateString", "handleToken", "", "Lio/ktor/util/date/GMTDateBuilder;", "type", "", "chunk", "Companion", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GMTDateParser {
    public static final char ANY = '*';
    public static final char DAY_OF_MONTH = 'd';
    public static final char HOURS = 'h';
    public static final char MINUTES = 'm';
    public static final char MONTH = 'M';
    public static final char SECONDS = 's';
    public static final char YEAR = 'Y';
    public static final char ZONE = 'z';
    private final String pattern;

    public GMTDateParser(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        this.pattern = pattern;
        if (pattern.length() <= 0) {
            throw new IllegalStateException("Date parser pattern shouldn't be empty.".toString());
        }
    }

    public final GMTDate parse(String dateString) {
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        GMTDateBuilder gMTDateBuilder = new GMTDateBuilder();
        char cCharAt = this.pattern.charAt(0);
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i2 < this.pattern.length()) {
            try {
                if (this.pattern.charAt(i2) == cCharAt) {
                    i2++;
                } else {
                    int i4 = (i3 + i2) - i;
                    String strSubstring = dateString.substring(i3, i4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    handleToken(gMTDateBuilder, cCharAt, strSubstring);
                    try {
                        cCharAt = this.pattern.charAt(i2);
                        i = i2;
                        i2++;
                        i3 = i4;
                    } catch (Throwable unused) {
                        i3 = i4;
                        throw new InvalidDateStringException(dateString, i3, this.pattern);
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        if (i3 < dateString.length()) {
            String strSubstring2 = dateString.substring(i3);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            handleToken(gMTDateBuilder, cCharAt, strSubstring2);
        }
        return gMTDateBuilder.build();
    }

    private final void handleToken(GMTDateBuilder gMTDateBuilder, char c, String str) {
        if (c == 's') {
            gMTDateBuilder.setSeconds(Integer.valueOf(Integer.parseInt(str)));
            return;
        }
        if (c == 'm') {
            gMTDateBuilder.setMinutes(Integer.valueOf(Integer.parseInt(str)));
            return;
        }
        if (c == 'h') {
            gMTDateBuilder.setHours(Integer.valueOf(Integer.parseInt(str)));
            return;
        }
        if (c == 'd') {
            gMTDateBuilder.setDayOfMonth(Integer.valueOf(Integer.parseInt(str)));
            return;
        }
        if (c == 'M') {
            gMTDateBuilder.setMonth(Month.INSTANCE.from(str));
            return;
        }
        if (c == 'Y') {
            gMTDateBuilder.setYear(Integer.valueOf(Integer.parseInt(str)));
            return;
        }
        if (c == 'z') {
            if (!Intrinsics.areEqual(str, "GMT")) {
                throw new IllegalStateException("Check failed.".toString());
            }
        } else if (c != '*') {
            String str2 = str;
            for (int i = 0; i < str2.length(); i++) {
                if (str2.charAt(i) != c) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
    }
}
