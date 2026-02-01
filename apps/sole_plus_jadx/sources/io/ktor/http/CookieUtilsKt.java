package io.ktor.http;

import io.ktor.util.date.Month;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.objectweb.asm.Opcodes;

/* compiled from: CookieUtils.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\f\u0010\t\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\f\u0010\n\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\f\u0010\u000b\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0080\bø\u0001\u0000\u001a$\u0010\u000f\u001a\u00020\u0001*\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011H\u0080\bø\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0001*\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0011H\u0080\bø\u0001\u0000\u001a0\u0010\u0015\u001a\u00020\u0001*\u00020\u00042\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0016H\u0080\bø\u0001\u0000\u001a$\u0010\u0017\u001a\u00020\u0001*\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011H\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"handleToken", "", "Lio/ktor/http/CookieDateBuilder;", "token", "", "isDelimiter", "", "", "isDigit", "isNonDelimiter", "isNonDigit", "isOctet", "otherwise", "block", "Lkotlin/Function0;", "tryParseDayOfMonth", "success", "Lkotlin/Function1;", "", "tryParseMonth", "Lio/ktor/util/date/Month;", "tryParseTime", "Lkotlin/Function3;", "tryParseYear", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CookieUtilsKt {
    public static final boolean isDelimiter(char c) {
        return c == '\t' || (' ' <= c && c < '0') || ((';' <= c && c < 'A') || (('[' <= c && c < 'a') || ('{' <= c && c < 127)));
    }

    public static final boolean isDigit(char c) {
        return '0' <= c && c < ':';
    }

    public static final boolean isNonDelimiter(char c) {
        return (c >= 0 && c < '\t') || ('\n' <= c && c < ' ') || (('0' <= c && c < ':') || c == ':' || (('a' <= c && c < '{') || (('A' <= c && c < '[') || (127 <= c && c < 256))));
    }

    public static final boolean isNonDigit(char c) {
        return (c >= 0 && c < '0') || ('J' <= c && c < 256);
    }

    public static final boolean isOctet(char c) {
        return c >= 0 && c < 256;
    }

    public static final void otherwise(boolean z, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (z) {
            return;
        }
        block.invoke();
    }

    public static final void tryParseTime(String str, Function3<? super Integer, ? super Integer, ? super Integer, Unit> success) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(success, "success");
        StringLexer stringLexer = new StringLexer(str);
        int index = stringLexer.getIndex();
        if (stringLexer.accept(CookieUtilsKt$tryParseTime$hour$1$1.INSTANCE)) {
            stringLexer.accept(CookieUtilsKt$tryParseTime$hour$1$3.INSTANCE);
            String strSubstring = stringLexer.getSource().substring(index, stringLexer.getIndex());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            int i = Integer.parseInt(strSubstring);
            if (stringLexer.accept(C11551.INSTANCE)) {
                int index2 = stringLexer.getIndex();
                if (stringLexer.accept(CookieUtilsKt$tryParseTime$minute$1$1.INSTANCE)) {
                    stringLexer.accept(CookieUtilsKt$tryParseTime$minute$1$3.INSTANCE);
                    String strSubstring2 = stringLexer.getSource().substring(index2, stringLexer.getIndex());
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    int i2 = Integer.parseInt(strSubstring2);
                    if (stringLexer.accept(AnonymousClass3.INSTANCE)) {
                        int index3 = stringLexer.getIndex();
                        if (stringLexer.accept(CookieUtilsKt$tryParseTime$second$1$1.INSTANCE)) {
                            stringLexer.accept(CookieUtilsKt$tryParseTime$second$1$3.INSTANCE);
                            String strSubstring3 = stringLexer.getSource().substring(index3, stringLexer.getIndex());
                            Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                            int i3 = Integer.parseInt(strSubstring3);
                            if (stringLexer.accept(AnonymousClass5.INSTANCE)) {
                                stringLexer.acceptWhile(AnonymousClass6.INSTANCE);
                            }
                            success.invoke(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                        }
                    }
                }
            }
        }
    }

    /* compiled from: CookieUtils.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(C)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseTime$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11551 extends Lambda implements Function1<Character, Boolean> {
        public static final C11551 INSTANCE = new C11551();

        public C11551() {
            super(1);
        }

        public final Boolean invoke(char c) {
            return Boolean.valueOf(c == ':');
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    /* compiled from: CookieUtils.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(C)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseTime$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Character, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        public final Boolean invoke(char c) {
            return Boolean.valueOf(c == ':');
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    /* compiled from: CookieUtils.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(C)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseTime$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Character, Boolean> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        public final Boolean invoke(char c) {
            return Boolean.valueOf(CookieUtilsKt.isNonDigit(c));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    /* compiled from: CookieUtils.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(C)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseTime$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<Character, Boolean> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public AnonymousClass6() {
            super(1);
        }

        public final Boolean invoke(char c) {
            return Boolean.valueOf(CookieUtilsKt.isOctet(c));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    public static final void tryParseMonth(String str, Function1<? super Month, Unit> success) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(success, "success");
        if (str.length() < 3) {
            return;
        }
        for (Month month : Month.values()) {
            if (StringsKt.startsWith(str, month.getValue(), true)) {
                success.invoke(month);
                return;
            }
        }
    }

    public static final void tryParseDayOfMonth(String str, Function1<? super Integer, Unit> success) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(success, "success");
        StringLexer stringLexer = new StringLexer(str);
        int index = stringLexer.getIndex();
        if (stringLexer.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$1.INSTANCE)) {
            stringLexer.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$3.INSTANCE);
            String strSubstring = stringLexer.getSource().substring(index, stringLexer.getIndex());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            int i = Integer.parseInt(strSubstring);
            if (stringLexer.accept(AnonymousClass1.INSTANCE)) {
                stringLexer.acceptWhile(AnonymousClass2.INSTANCE);
            }
            success.invoke(Integer.valueOf(i));
        }
    }

    /* compiled from: CookieUtils.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(C)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseDayOfMonth$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Character, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        public final Boolean invoke(char c) {
            return Boolean.valueOf(CookieUtilsKt.isNonDigit(c));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    /* compiled from: CookieUtils.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(C)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseDayOfMonth$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Character, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        public final Boolean invoke(char c) {
            return Boolean.valueOf(CookieUtilsKt.isOctet(c));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    public static final void tryParseYear(String str, Function1<? super Integer, Unit> success) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(success, "success");
        StringLexer stringLexer = new StringLexer(str);
        int index = stringLexer.getIndex();
        for (int i = 0; i < 2; i++) {
            if (!stringLexer.accept(CookieUtilsKt$tryParseYear$year$1$1$1.INSTANCE)) {
                return;
            }
        }
        for (int i2 = 0; i2 < 2; i2++) {
            stringLexer.accept(CookieUtilsKt$tryParseYear$year$1$2$1.INSTANCE);
        }
        String strSubstring = stringLexer.getSource().substring(index, stringLexer.getIndex());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        int i3 = Integer.parseInt(strSubstring);
        if (stringLexer.accept(C11561.INSTANCE)) {
            stringLexer.acceptWhile(C11572.INSTANCE);
        }
        success.invoke(Integer.valueOf(i3));
    }

    /* compiled from: CookieUtils.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(C)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseYear$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11561 extends Lambda implements Function1<Character, Boolean> {
        public static final C11561 INSTANCE = new C11561();

        public C11561() {
            super(1);
        }

        public final Boolean invoke(char c) {
            return Boolean.valueOf(CookieUtilsKt.isNonDigit(c));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    /* compiled from: CookieUtils.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(C)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseYear$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11572 extends Lambda implements Function1<Character, Boolean> {
        public static final C11572 INSTANCE = new C11572();

        public C11572() {
            super(1);
        }

        public final Boolean invoke(char c) {
            return Boolean.valueOf(CookieUtilsKt.isOctet(c));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    public static final void handleToken(CookieDateBuilder cookieDateBuilder, String token) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(cookieDateBuilder, "<this>");
        Intrinsics.checkNotNullParameter(token, "token");
        if (cookieDateBuilder.getHours() == null || cookieDateBuilder.getMinutes() == null || cookieDateBuilder.getSeconds() == null) {
            StringLexer stringLexer = new StringLexer(token);
            int index = stringLexer.getIndex();
            if (stringLexer.accept(CookieUtilsKt$tryParseTime$hour$1$1.INSTANCE)) {
                stringLexer.accept(CookieUtilsKt$tryParseTime$hour$1$3.INSTANCE);
                String strSubstring = stringLexer.getSource().substring(index, stringLexer.getIndex());
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                int i = Integer.parseInt(strSubstring);
                if (stringLexer.accept(C11551.INSTANCE)) {
                    int index2 = stringLexer.getIndex();
                    if (stringLexer.accept(CookieUtilsKt$tryParseTime$minute$1$1.INSTANCE)) {
                        stringLexer.accept(CookieUtilsKt$tryParseTime$minute$1$3.INSTANCE);
                        String strSubstring2 = stringLexer.getSource().substring(index2, stringLexer.getIndex());
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        int i2 = Integer.parseInt(strSubstring2);
                        if (stringLexer.accept(AnonymousClass3.INSTANCE)) {
                            int index3 = stringLexer.getIndex();
                            if (stringLexer.accept(CookieUtilsKt$tryParseTime$second$1$1.INSTANCE)) {
                                stringLexer.accept(CookieUtilsKt$tryParseTime$second$1$3.INSTANCE);
                                String strSubstring3 = stringLexer.getSource().substring(index3, stringLexer.getIndex());
                                Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                                int i3 = Integer.parseInt(strSubstring3);
                                if (stringLexer.accept(AnonymousClass5.INSTANCE)) {
                                    stringLexer.acceptWhile(AnonymousClass6.INSTANCE);
                                }
                                cookieDateBuilder.setHours(Integer.valueOf(i));
                                cookieDateBuilder.setMinutes(Integer.valueOf(i2));
                                cookieDateBuilder.setSeconds(Integer.valueOf(i3));
                                return;
                            }
                        }
                    }
                }
            }
        }
        if (cookieDateBuilder.getDayOfMonth() == null) {
            StringLexer stringLexer2 = new StringLexer(token);
            int index4 = stringLexer2.getIndex();
            if (stringLexer2.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$1.INSTANCE)) {
                stringLexer2.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$3.INSTANCE);
                String strSubstring4 = stringLexer2.getSource().substring(index4, stringLexer2.getIndex());
                Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                int i4 = Integer.parseInt(strSubstring4);
                if (stringLexer2.accept(AnonymousClass1.INSTANCE)) {
                    stringLexer2.acceptWhile(AnonymousClass2.INSTANCE);
                }
                cookieDateBuilder.setDayOfMonth(Integer.valueOf(i4));
                return;
            }
        }
        if (cookieDateBuilder.getMonth() == null && token.length() >= 3) {
            for (Month month : Month.values()) {
                if (StringsKt.startsWith(token, month.getValue(), true)) {
                    cookieDateBuilder.setMonth(month);
                    return;
                }
            }
        }
        if (cookieDateBuilder.getYear() == null) {
            StringLexer stringLexer3 = new StringLexer(token);
            int index5 = stringLexer3.getIndex();
            for (int i5 = 0; i5 < 2; i5++) {
                if (!stringLexer3.accept(CookieUtilsKt$tryParseYear$year$1$1$1.INSTANCE)) {
                    return;
                }
            }
            for (int i6 = 0; i6 < 2; i6++) {
                stringLexer3.accept(CookieUtilsKt$tryParseYear$year$1$2$1.INSTANCE);
            }
            String strSubstring5 = stringLexer3.getSource().substring(index5, stringLexer3.getIndex());
            Intrinsics.checkNotNullExpressionValue(strSubstring5, "this as java.lang.String…ing(startIndex, endIndex)");
            int i7 = Integer.parseInt(strSubstring5);
            if (stringLexer3.accept(C11561.INSTANCE)) {
                stringLexer3.acceptWhile(C11572.INSTANCE);
            }
            cookieDateBuilder.setYear(Integer.valueOf(i7));
        }
    }
}
