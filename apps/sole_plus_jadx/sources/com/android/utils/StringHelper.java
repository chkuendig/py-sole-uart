package com.android.utils;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringHelper.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u001c\n\u0002\b\u0006\u001a.\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000b\u001a:\u0010\u0005\u001a\u00020\f\"\u0004\b\u0000\u0010\u00072\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000b\u001a\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002\u001a%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016\"\u00020\u0017¢\u0006\u0002\u0010\u0018\u001a\u001a\u0010\u0019\u001a\u00060\u000ej\u0002`\u000f*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u001a\u001a\u00020\u0006\u001a#\u0010\u001b\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0016\"\u00020\u0006¢\u0006\u0002\u0010\u001d\u001a\u0012\u0010\u001b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006\u001a\u001a\u0010\u001b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006\u001a\u001a\u0010\u001b\u001a\u00060\u000ej\u0002`\u000f*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u001a\u001a\u00020\u0006\u001a\u0012\u0010 \u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006\u001a\u0010\u0010\u0005\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00060\"\u001a\n\u0010#\u001a\u00020\u0006*\u00020\u0006\u001a\u0010\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014*\u00020\u0006\u001a\u0010\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014*\u00020\u0006\u001a\n\u0010&\u001a\u00020\u0006*\u00020\u0006\u001a\n\u0010'\u001a\u00020\u0006*\u00020\u0006\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"CR", "Lcom/google/common/base/CharMatcher;", "kotlin.jvm.PlatformType", "LF", "Ljava/util/regex/Pattern;", "combineAsCamelCase", "", ExifInterface.GPS_DIRECTION_TRUE, "objectList", "", "mapFunction", "Lkotlin/Function1;", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "toLineSeparator", "separator", "input", "toStrings", "", "objects", "", "", "([Ljava/lang/Object;)Ljava/util/List;", "appendCamelCase", "word", "appendCapitalized", "words", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "word1", "word2", "capitalizeAndAppend", "suffix", "", "toSystemLineSeparator", "tokenizeCommandLineToEscaped", "tokenizeCommandLineToRaw", "usLocaleCapitalize", "usLocaleDecapitalize", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class StringHelper {
    private static final CharMatcher CR = CharMatcher.is('\r');
    private static final Pattern LF = Pattern.compile("\n", 16);

    public static final StringBuilder appendCapitalized(StringBuilder sb, String word) {
        char cCharAt;
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(word, "word");
        String str = word;
        if (str.length() == 0) {
            return sb;
        }
        char cCharAt2 = word.charAt(0);
        if (cCharAt2 >= 55296 && cCharAt2 <= 56319) {
            int iCharCount = Character.charCount(word.codePointAt(0));
            String strSubstring = word.substring(0, iCharCount);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            if (strSubstring == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String upperCase = strSubstring.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
            sb.append((CharSequence) str, iCharCount, word.length());
        } else {
            int upperCase2 = Character.toUpperCase((int) cCharAt2);
            if (upperCase2 != -1) {
                cCharAt = (char) upperCase2;
            } else {
                String strSubstring2 = word.substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Locale US2 = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US2, "US");
                if (strSubstring2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String upperCase3 = strSubstring2.toUpperCase(US2);
                Intrinsics.checkNotNullExpressionValue(upperCase3, "(this as java.lang.String).toUpperCase(locale)");
                cCharAt = upperCase3.charAt(0);
            }
            sb.append(cCharAt);
            sb.append((CharSequence) str, 1, word.length());
        }
        return sb;
    }

    public static final String usLocaleCapitalize(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        appendCapitalized(sb, str);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final String usLocaleDecapitalize(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        String strSubstring = str.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        if (strSubstring == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strSubstring.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        sb.append(lowerCase);
        String strSubstring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring2);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final String appendCapitalized(String str, String word) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(word, "word");
        StringBuilder sb = new StringBuilder(str.length() + word.length());
        sb.append(str);
        appendCapitalized(sb, word);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final String appendCapitalized(String str, String word1, String word2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(word1, "word1");
        Intrinsics.checkNotNullParameter(word2, "word2");
        StringBuilder sb = new StringBuilder(str.length() + word1.length() + word2.length());
        sb.append(str);
        appendCapitalized(sb, word1);
        appendCapitalized(sb, word2);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final String appendCapitalized(String str, String... words) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(words, "words");
        int length = str.length();
        int i = 0;
        for (String str2 : words) {
            length += str2.length();
        }
        StringBuilder sb = new StringBuilder(length);
        sb.append(str);
        int length2 = words.length;
        while (i < length2) {
            String str3 = words[i];
            i++;
            appendCapitalized(sb, str3);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final String capitalizeAndAppend(String str, String suffix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        StringBuilder sb = new StringBuilder(str.length() + suffix.length());
        appendCapitalized(sb, str);
        sb.append(suffix);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final StringBuilder appendCamelCase(StringBuilder sb, String word) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(word, "word");
        if (sb.length() == 0) {
            sb.append(word);
        } else {
            appendCapitalized(sb, word);
        }
        return sb;
    }

    public static final String combineAsCamelCase(Iterable<String> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<String> it = iterable.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        StringBuilder sb = new StringBuilder(length);
        boolean z = true;
        for (String str : iterable) {
            if (z) {
                sb.append(str);
                z = false;
            } else {
                appendCapitalized(sb, str);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final <T> String combineAsCamelCase(Collection<? extends T> objectList, Function1<? super T, String> mapFunction) {
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        Intrinsics.checkNotNullParameter(mapFunction, "mapFunction");
        StringBuilder sb = new StringBuilder(objectList.size() * 20);
        combineAsCamelCase(sb, objectList, mapFunction);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final <T> void combineAsCamelCase(StringBuilder sb, Collection<? extends T> objectList, Function1<? super T, String> mapFunction) {
        Intrinsics.checkNotNullParameter(sb, "sb");
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        Intrinsics.checkNotNullParameter(mapFunction, "mapFunction");
        boolean z = true;
        for (T t : objectList) {
            if (z) {
                sb.append(mapFunction.invoke(t));
                z = false;
            } else {
                appendCapitalized(sb, mapFunction.invoke(t));
            }
        }
    }

    public static final List<String> toStrings(Object... objects) {
        Intrinsics.checkNotNullParameter(objects, "objects");
        ImmutableList.Builder builder = ImmutableList.builder();
        int length = objects.length;
        int i = 0;
        while (i < length) {
            Object obj = objects[i];
            i++;
            if (obj instanceof String) {
                builder.add((ImmutableList.Builder) obj);
            } else if (obj instanceof Collection) {
                for (Object obj2 : (Collection) obj) {
                    if (obj2 instanceof String) {
                        builder.add((ImmutableList.Builder) obj2);
                    } else {
                        builder.add((ImmutableList.Builder) obj.toString());
                    }
                }
            } else {
                builder.add((ImmutableList.Builder) obj.toString());
            }
        }
        ImmutableList immutableListBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(immutableListBuild, "builder.build()");
        return immutableListBuild;
    }

    public static final List<String> tokenizeCommandLineToEscaped(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new TokenizedCommandLine(str, false, 0, null, 12, null).toTokenList();
    }

    public static final List<String> tokenizeCommandLineToRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new TokenizedCommandLine(str, true, 0, null, 12, null).toTokenList();
    }

    public static final String toSystemLineSeparator(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String strLineSeparator = System.lineSeparator();
        Intrinsics.checkNotNullExpressionValue(strLineSeparator, "lineSeparator()");
        return toLineSeparator(strLineSeparator, str);
    }

    private static final String toLineSeparator(String str, String str2) {
        String str3;
        CharMatcher charMatcher = CR;
        String str4 = str2;
        if (charMatcher.matchesAnyOf(str4)) {
            str2 = charMatcher.removeFrom(str4);
        }
        if (Intrinsics.areEqual(str, "\n")) {
            str3 = "unixStyle";
        } else {
            str2 = LF.matcher(str2).replaceAll("\r\n");
            str3 = "LF.matcher(unixStyle).replaceAll(\"\\r\\n\")";
        }
        Intrinsics.checkNotNullExpressionValue(str2, str3);
        return str2;
    }
}
