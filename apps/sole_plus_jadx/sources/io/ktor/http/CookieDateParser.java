package io.ktor.http;

import androidx.exifinterface.media.ExifInterface;
import com.sun.jna.platform.win32.WinError;
import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: CookieUtils.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u0001H\u0005H\u0002¢\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0012"}, d2 = {"Lio/ktor/http/CookieDateParser;", "", "()V", "checkFieldNotNull", "", ExifInterface.GPS_DIRECTION_TRUE, "source", "", "name", "field", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "checkRequirement", "requirement", "", "msg", "Lkotlin/Function0;", "parse", "Lio/ktor/util/date/GMTDate;", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CookieDateParser {
    private final <T> void checkFieldNotNull(String source, String name, T field) {
        if (field == null) {
            throw new InvalidCookieDateException(source, "Could not find " + name);
        }
    }

    private final void checkRequirement(String source, boolean requirement, Function0<String> msg) {
        if (!requirement) {
            throw new InvalidCookieDateException(source, msg.invoke());
        }
    }

    public final GMTDate parse(String source) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(source, "source");
        StringLexer stringLexer = new StringLexer(source);
        CookieDateBuilder cookieDateBuilder = new CookieDateBuilder();
        stringLexer.acceptWhile(new Function1<Character, Boolean>() { // from class: io.ktor.http.CookieDateParser.parse.1
            public final Boolean invoke(char c) {
                return Boolean.valueOf(CookieUtilsKt.isDelimiter(c));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
                return invoke(ch.charValue());
            }
        });
        while (stringLexer.getHasRemaining()) {
            if (stringLexer.test(new Function1<Character, Boolean>() { // from class: io.ktor.http.CookieDateParser.parse.2
                public final Boolean invoke(char c) {
                    return Boolean.valueOf(CookieUtilsKt.isNonDelimiter(c));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
                    return invoke(ch.charValue());
                }
            })) {
                int index = stringLexer.getIndex();
                stringLexer.acceptWhile(new Function1<Character, Boolean>() { // from class: io.ktor.http.CookieDateParser$parse$token$1$1
                    public final Boolean invoke(char c) {
                        return Boolean.valueOf(CookieUtilsKt.isNonDelimiter(c));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
                        return invoke(ch.charValue());
                    }
                });
                String strSubstring = stringLexer.getSource().substring(index, stringLexer.getIndex());
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                CookieUtilsKt.handleToken(cookieDateBuilder, strSubstring);
                stringLexer.acceptWhile(new Function1<Character, Boolean>() { // from class: io.ktor.http.CookieDateParser.parse.3
                    public final Boolean invoke(char c) {
                        return Boolean.valueOf(CookieUtilsKt.isDelimiter(c));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
                        return invoke(ch.charValue());
                    }
                });
            }
        }
        Integer year = cookieDateBuilder.getYear();
        IntRange intRange = new IntRange(70, 99);
        if (year == null || !intRange.contains(year.intValue())) {
            IntRange intRange2 = new IntRange(0, 69);
            if (year != null && intRange2.contains(year.intValue())) {
                Integer year2 = cookieDateBuilder.getYear();
                Intrinsics.checkNotNull(year2);
                cookieDateBuilder.setYear(Integer.valueOf(year2.intValue() + 2000));
            }
        } else {
            Integer year3 = cookieDateBuilder.getYear();
            Intrinsics.checkNotNull(year3);
            cookieDateBuilder.setYear(Integer.valueOf(year3.intValue() + WinError.RPC_S_INVALID_OBJECT));
        }
        checkFieldNotNull(source, "day-of-month", cookieDateBuilder.getDayOfMonth());
        checkFieldNotNull(source, "month", cookieDateBuilder.getMonth());
        checkFieldNotNull(source, "year", cookieDateBuilder.getYear());
        checkFieldNotNull(source, "time", cookieDateBuilder.getHours());
        checkFieldNotNull(source, "time", cookieDateBuilder.getMinutes());
        checkFieldNotNull(source, "time", cookieDateBuilder.getSeconds());
        IntRange intRange3 = new IntRange(1, 31);
        Integer dayOfMonth = cookieDateBuilder.getDayOfMonth();
        checkRequirement(source, dayOfMonth != null && intRange3.contains(dayOfMonth.intValue()), new Function0<String>() { // from class: io.ktor.http.CookieDateParser.parse.4
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "day-of-month not in [1,31]";
            }
        });
        Integer year4 = cookieDateBuilder.getYear();
        Intrinsics.checkNotNull(year4);
        checkRequirement(source, year4.intValue() >= 1601, new Function0<String>() { // from class: io.ktor.http.CookieDateParser.parse.5
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "year >= 1601";
            }
        });
        Integer hours = cookieDateBuilder.getHours();
        Intrinsics.checkNotNull(hours);
        checkRequirement(source, hours.intValue() <= 23, new Function0<String>() { // from class: io.ktor.http.CookieDateParser.parse.6
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "hours > 23";
            }
        });
        Integer minutes = cookieDateBuilder.getMinutes();
        Intrinsics.checkNotNull(minutes);
        checkRequirement(source, minutes.intValue() <= 59, new Function0<String>() { // from class: io.ktor.http.CookieDateParser.parse.7
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "minutes > 59";
            }
        });
        Integer seconds = cookieDateBuilder.getSeconds();
        Intrinsics.checkNotNull(seconds);
        checkRequirement(source, seconds.intValue() <= 59, new Function0<String>() { // from class: io.ktor.http.CookieDateParser.parse.8
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "seconds > 59";
            }
        });
        return cookieDateBuilder.build();
    }
}
