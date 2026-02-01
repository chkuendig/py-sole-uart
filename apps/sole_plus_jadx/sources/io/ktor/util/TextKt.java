package io.ktor.util;

import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Text.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a>\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b*\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b0\u000bH\u0086\bø\u0001\u0000\u001a\n\u0010\f\u001a\u00020\u0006*\u00020\u0006\u001a\n\u0010\r\u001a\u00020\u0006*\u00020\u0006\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"toLowerCasePreservingASCII", "", "ch", "toUpperCasePreservingASCII", "caseInsensitive", "Lio/ktor/util/CaseInsensitiveString;", "", "chomp", "Lkotlin/Pair;", "separator", "onMissingDelimiter", "Lkotlin/Function0;", "escapeHTML", "toLowerCasePreservingASCIIRules", "toUpperCasePreservingASCIIRules", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TextKt {
    public static final String escapeHTML(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\'') {
                sb.append("&#x27;");
            } else if (cCharAt == '\"') {
                sb.append(SdkConstants.QUOT_ENTITY);
            } else if (cCharAt == '&') {
                sb.append(SdkConstants.AMP_ENTITY);
            } else if (cCharAt == '<') {
                sb.append(SdkConstants.LT_ENTITY);
            } else if (cCharAt == '>') {
                sb.append(SdkConstants.GT_ENTITY);
            } else {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static final Pair<String, String> chomp(String str, String separator, Function0<Pair<String, String>> onMissingDelimiter) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(onMissingDelimiter, "onMissingDelimiter");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, separator, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return onMissingDelimiter.invoke();
        }
        String strSubstring = str.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strSubstring2 = str.substring(iIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
        return TuplesKt.to(strSubstring, strSubstring2);
    }

    public static final String toLowerCasePreservingASCIIRules(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = str;
        int length = str2.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            char cCharAt = str2.charAt(i);
            if (toLowerCasePreservingASCII(cCharAt) != cCharAt) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append((CharSequence) str2, 0, i);
        int lastIndex = StringsKt.getLastIndex(str2);
        if (i <= lastIndex) {
            while (true) {
                sb.append(toLowerCasePreservingASCII(str.charAt(i)));
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static final String toUpperCasePreservingASCIIRules(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = str;
        int length = str2.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            char cCharAt = str2.charAt(i);
            if (toUpperCasePreservingASCII(cCharAt) != cCharAt) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append((CharSequence) str2, 0, i);
        int lastIndex = StringsKt.getLastIndex(str2);
        if (i <= lastIndex) {
            while (true) {
                sb.append(toUpperCasePreservingASCII(str.charAt(i)));
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    private static final char toLowerCasePreservingASCII(char c) {
        return ('A' > c || c >= '[') ? (c < 0 || c >= 128) ? Character.toLowerCase(c) : c : (char) (c + ' ');
    }

    private static final char toUpperCasePreservingASCII(char c) {
        return ('a' > c || c >= '{') ? (c < 0 || c >= 128) ? Character.toLowerCase(c) : c : (char) (c - ' ');
    }

    public static final CaseInsensitiveString caseInsensitive(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new CaseInsensitiveString(str);
    }
}
