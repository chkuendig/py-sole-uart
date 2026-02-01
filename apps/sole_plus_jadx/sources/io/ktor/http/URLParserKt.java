package io.ktor.http;

import com.android.SdkConstants;
import io.ktor.util.CharsetKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: URLParser.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a$\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u000bH\u0002\u001a,\u0010\u0013\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002\u001a$\u0010\u0015\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a$\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a$\u0010\u0017\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0018\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u0014\u0010\u0019\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001a"}, d2 = {"ROOT_PATH", "", "", "getROOT_PATH", "()Ljava/util/List;", "count", "", "urlString", "startIndex", "endIndex", "char", "", "findScheme", "fillHost", "", "Lio/ktor/http/URLBuilder;", "indexOfColonInHostPort", "isLetter", "", "parseFile", "slashCount", "parseFragment", "parseMailto", "parseQuery", "takeFrom", "takeFromUnsafe", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class URLParserKt {
    private static final List<String> ROOT_PATH = CollectionsKt.listOf("");

    public static final List<String> getROOT_PATH() {
        return ROOT_PATH;
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, String urlString) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        if (StringsKt.isBlank(urlString)) {
            return uRLBuilder;
        }
        try {
            return takeFromUnsafe(uRLBuilder, urlString);
        } catch (Throwable th) {
            throw new URLParserException(urlString, th);
        }
    }

    public static final URLBuilder takeFromUnsafe(URLBuilder uRLBuilder, String urlString) {
        int i;
        int i2;
        List<String> listEmptyList;
        List<String> listEmptyList2;
        int i3;
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        String str = urlString;
        int length = str.length();
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                i4 = -1;
                break;
            }
            if (!CharsKt.isWhitespace(str.charAt(i4))) {
                break;
            }
            i4++;
        }
        int length2 = str.length() - 1;
        if (length2 >= 0) {
            while (true) {
                int i5 = length2 - 1;
                if (!CharsKt.isWhitespace(str.charAt(length2))) {
                    i = length2;
                    break;
                }
                if (i5 < 0) {
                    break;
                }
                length2 = i5;
            }
            i = -1;
        } else {
            i = -1;
        }
        int i6 = i + 1;
        int iFindScheme = findScheme(urlString, i4, i6);
        if (iFindScheme > 0) {
            String strSubstring = urlString.substring(i4, i4 + iFindScheme);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setProtocol(URLProtocol.INSTANCE.createOrDefault(strSubstring));
            i4 += iFindScheme + 1;
        }
        int iCount = count(urlString, i4, i6, '/');
        int iIntValue = i4 + iCount;
        if (Intrinsics.areEqual(uRLBuilder.getProtocol().getName(), "file")) {
            parseFile(uRLBuilder, urlString, iIntValue, i6, iCount);
            return uRLBuilder;
        }
        if (Intrinsics.areEqual(uRLBuilder.getProtocol().getName(), "mailto")) {
            if (iCount != 0) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            parseMailto(uRLBuilder, urlString, iIntValue, i6);
            return uRLBuilder;
        }
        if (iCount >= 2) {
            int i7 = iIntValue;
            while (true) {
                i3 = i7;
                i2 = iCount;
                Integer numValueOf = Integer.valueOf(StringsKt.indexOfAny$default((CharSequence) str, CharsetKt.toCharArray("@/\\?#"), i7, false, 4, (Object) null));
                if (numValueOf.intValue() <= 0) {
                    numValueOf = null;
                }
                iIntValue = numValueOf != null ? numValueOf.intValue() : i6;
                if (iIntValue >= i6 || urlString.charAt(iIntValue) != '@') {
                    break;
                }
                int iIndexOfColonInHostPort = indexOfColonInHostPort(urlString, i3, iIntValue);
                if (iIndexOfColonInHostPort != -1) {
                    String strSubstring2 = urlString.substring(i3, iIndexOfColonInHostPort);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    uRLBuilder.setEncodedUser(strSubstring2);
                    String strSubstring3 = urlString.substring(iIndexOfColonInHostPort + 1, iIntValue);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    uRLBuilder.setEncodedPassword(strSubstring3);
                } else {
                    String strSubstring4 = urlString.substring(i3, iIntValue);
                    Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                    uRLBuilder.setEncodedUser(strSubstring4);
                }
                i7 = iIntValue + 1;
                iCount = i2;
            }
            fillHost(uRLBuilder, urlString, i3, iIntValue);
        } else {
            i2 = iCount;
        }
        int query = iIntValue;
        if (query >= i6) {
            uRLBuilder.setEncodedPathSegments(urlString.charAt(i) == '/' ? ROOT_PATH : CollectionsKt.emptyList());
            return uRLBuilder;
        }
        if (i2 == 0) {
            listEmptyList = CollectionsKt.dropLast(uRLBuilder.getEncodedPathSegments(), 1);
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        uRLBuilder.setEncodedPathSegments(listEmptyList);
        Integer numValueOf2 = Integer.valueOf(StringsKt.indexOfAny$default((CharSequence) str, CharsetKt.toCharArray("?#"), query, false, 4, (Object) null));
        Integer num = numValueOf2.intValue() > 0 ? numValueOf2 : null;
        int iIntValue2 = num != null ? num.intValue() : i6;
        if (iIntValue2 > query) {
            String strSubstring5 = urlString.substring(query, iIntValue2);
            Intrinsics.checkNotNullExpressionValue(strSubstring5, "this as java.lang.String…ing(startIndex, endIndex)");
            List<String> listEmptyList3 = (uRLBuilder.getEncodedPathSegments().size() == 1 && ((CharSequence) CollectionsKt.first((List) uRLBuilder.getEncodedPathSegments())).length() == 0) ? CollectionsKt.emptyList() : uRLBuilder.getEncodedPathSegments();
            List<String> listSplit$default = Intrinsics.areEqual(strSubstring5, "/") ? ROOT_PATH : StringsKt.split$default((CharSequence) strSubstring5, new char[]{'/'}, false, 0, 6, (Object) null);
            if (i2 == 1) {
                listEmptyList2 = ROOT_PATH;
            } else {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            uRLBuilder.setEncodedPathSegments(CollectionsKt.plus((Collection) listEmptyList3, (Iterable) CollectionsKt.plus((Collection) listEmptyList2, (Iterable) listSplit$default)));
            query = iIntValue2;
        }
        if (query < i6 && urlString.charAt(query) == '?') {
            query = parseQuery(uRLBuilder, urlString, query, i6);
        }
        parseFragment(uRLBuilder, urlString, query, i6);
        return uRLBuilder;
    }

    private static final void parseFile(URLBuilder uRLBuilder, String str, int i, int i2, int i3) {
        if (i3 != 2) {
            if (i3 == 3) {
                uRLBuilder.setHost("");
                StringBuilder sb = new StringBuilder("/");
                String strSubstring = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                URLBuilderKt.setEncodedPath(uRLBuilder, sb.append(strSubstring).toString());
                return;
            }
            throw new IllegalArgumentException("Invalid file url: " + str);
        }
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, '/', i, false, 4, (Object) null);
        if (iIndexOf$default == -1 || iIndexOf$default == i2) {
            String strSubstring2 = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setHost(strSubstring2);
        } else {
            String strSubstring3 = str.substring(i, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setHost(strSubstring3);
            String strSubstring4 = str.substring(iIndexOf$default, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
            URLBuilderKt.setEncodedPath(uRLBuilder, strSubstring4);
        }
    }

    private static final void parseMailto(URLBuilder uRLBuilder, String str, int i, int i2) {
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, SdkConstants.PREFIX_RESOURCE_REF, i, false, 4, (Object) null);
        if (iIndexOf$default == -1) {
            throw new IllegalArgumentException("Invalid mailto url: " + str + ", it should contain '@'.");
        }
        String strSubstring = str.substring(i, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setUser(CodecsKt.decodeURLPart$default(strSubstring, 0, 0, null, 7, null));
        String strSubstring2 = str.substring(iIndexOf$default + 1, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setHost(strSubstring2);
    }

    private static final int parseQuery(final URLBuilder uRLBuilder, String str, int i, int i2) {
        int i3 = i + 1;
        if (i3 == i2) {
            uRLBuilder.setTrailingQuery(true);
            return i2;
        }
        Integer numValueOf = Integer.valueOf(StringsKt.indexOf$default((CharSequence) str, '#', i3, false, 4, (Object) null));
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            i2 = numValueOf.intValue();
        }
        String strSubstring = str.substring(i3, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        QueryKt.parseQueryString$default(strSubstring, 0, 0, false, 6, null).forEach(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.http.URLParserKt.parseQuery.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str2, List<? extends String> list) {
                invoke2(str2, (List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String key, List<String> values) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(values, "values");
                uRLBuilder.getEncodedParameters().appendAll(key, values);
            }
        });
        return i2;
    }

    private static final void parseFragment(URLBuilder uRLBuilder, String str, int i, int i2) {
        if (i >= i2 || str.charAt(i) != '#') {
            return;
        }
        String strSubstring = str.substring(i + 1, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setEncodedFragment(strSubstring);
    }

    private static final void fillHost(URLBuilder uRLBuilder, String str, int i, int i2) {
        Integer numValueOf = Integer.valueOf(indexOfColonInHostPort(str, i, i2));
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : i2;
        String strSubstring = str.substring(i, iIntValue);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setHost(strSubstring);
        int i3 = iIntValue + 1;
        if (i3 < i2) {
            String strSubstring2 = str.substring(i3, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setPort(Integer.parseInt(strSubstring2));
            return;
        }
        uRLBuilder.setPort(0);
    }

    private static final int findScheme(String str, int i, int i2) {
        int i3;
        int i4;
        char cCharAt = str.charAt(i);
        if (('a' > cCharAt || cCharAt >= '{') && ('A' > cCharAt || cCharAt >= '[')) {
            i3 = i;
            i4 = i3;
        } else {
            i3 = i;
            i4 = -1;
        }
        while (i3 < i2) {
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 == ':') {
                if (i4 == -1) {
                    return i3 - i;
                }
                throw new IllegalArgumentException("Illegal character in scheme at position " + i4);
            }
            if (cCharAt2 == '/' || cCharAt2 == '?' || cCharAt2 == '#') {
                break;
            }
            if (i4 == -1 && (('a' > cCharAt2 || cCharAt2 >= '{') && (('A' > cCharAt2 || cCharAt2 >= '[') && (('0' > cCharAt2 || cCharAt2 >= ':') && cCharAt2 != '.' && cCharAt2 != '+' && cCharAt2 != '-')))) {
                i4 = i3;
            }
            i3++;
        }
        return -1;
    }

    private static final int count(String str, int i, int i2, char c) {
        int i3 = 0;
        while (true) {
            int i4 = i + i3;
            if (i4 >= i2 || str.charAt(i4) != c) {
                break;
            }
            i3++;
        }
        return i3;
    }

    private static final int indexOfColonInHostPort(String str, int i, int i2) {
        boolean z = false;
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '[') {
                z = true;
            } else if (cCharAt == ']') {
                z = false;
            } else if (cCharAt == ':' && !z) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static final boolean isLetter(char c) {
        char lowerCase = Character.toLowerCase(c);
        return 'a' <= lowerCase && lowerCase < '{';
    }
}
