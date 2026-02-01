package io.ktor.http;

import androidx.collection.SieveCacheKt;
import io.ktor.util.Base64Kt;
import io.ktor.util.TextKt;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.objectweb.asm.signature.SignatureVisitor;

/* compiled from: Cookie.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082\b\u001a\u001b\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0082\b\u001a\u0019\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000fH\u0082\b\u001a\u001b\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0082\b\u001a\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f\u001a\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f\u001a$\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u000f\u001a\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0006\u001a\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0019\u001a\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0019\u001a\u0084\u0001\u0010\u001c\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00152\b\b\u0002\u0010&\u001a\u00020\u000f\u001a\f\u0010'\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a\f\u0010(\u001a\u00020\u000f*\u00020\u0004H\u0002\u001a\f\u0010)\u001a\u00020\u001e*\u00020\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"clientCookieHeaderPattern", "Lkotlin/text/Regex;", "cookieCharsShouldBeEscaped", "", "", "loweredPartNames", "", "cookiePart", "name", "value", "", "encoding", "Lio/ktor/http/CookieEncoding;", "cookiePartExt", "cookiePartFlag", "", "cookiePartUnencoded", "decodeCookieValue", "encodedValue", "encodeCookieValue", "parseClientCookiesHeader", "", "cookiesHeader", "skipEscaped", "parseServerSetCookieHeader", "Lio/ktor/http/Cookie;", "renderCookieHeader", "cookie", "renderSetCookieHeader", "maxAge", "", "expires", "Lio/ktor/util/date/GMTDate;", "domain", "path", "secure", "httpOnly", "extensions", "includeEncoding", "assertCookieName", "shouldEscapeInCookies", "toIntClamping", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CookieKt {
    private static final Set<String> loweredPartNames = SetsKt.setOf((Object[]) new String[]{io.ktor.client.utils.CacheControl.MAX_AGE, "expires", "domain", "path", "secure", "httponly", "$x-enc"});
    private static final Regex clientCookieHeaderPattern = new Regex("(^|;)\\s*([^;=\\{\\}\\s]+)\\s*(=\\s*(\"[^\"]*\"|[^;]*))?");
    private static final Set<Character> cookieCharsShouldBeEscaped = SetsKt.setOf((Object[]) new Character[]{';', Character.valueOf(AbstractJsonLexerKt.COMMA), '\"'});

    /* compiled from: Cookie.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CookieEncoding.values().length];
            try {
                iArr[CookieEncoding.RAW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CookieEncoding.DQUOTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CookieEncoding.BASE64_ENCODING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CookieEncoding.URI_ENCODING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Cookie parseServerSetCookieHeader(String cookiesHeader) {
        CookieEncoding cookieEncodingValueOf;
        Intrinsics.checkNotNullParameter(cookiesHeader, "cookiesHeader");
        Map<String, String> clientCookiesHeader = parseClientCookiesHeader(cookiesHeader, false);
        Iterator<T> it = clientCookiesHeader.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!StringsKt.startsWith$default((String) entry.getKey(), "$", false, 2, (Object) null)) {
                String str = clientCookiesHeader.get("$x-enc");
                if (str == null || (cookieEncodingValueOf = CookieEncoding.valueOf(str)) == null) {
                    cookieEncodingValueOf = CookieEncoding.RAW;
                }
                CookieEncoding cookieEncoding = cookieEncodingValueOf;
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(clientCookiesHeader.size()));
                Iterator<T> it2 = clientCookiesHeader.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it2.next();
                    linkedHashMap.put(TextKt.toLowerCasePreservingASCIIRules((String) entry2.getKey()), entry2.getValue());
                }
                String str2 = (String) entry.getKey();
                String strDecodeCookieValue = decodeCookieValue((String) entry.getValue(), cookieEncoding);
                String str3 = (String) linkedHashMap.get(io.ktor.client.utils.CacheControl.MAX_AGE);
                int intClamping = str3 != null ? toIntClamping(str3) : 0;
                String str4 = (String) linkedHashMap.get("expires");
                GMTDate gMTDateFromCookieToGmtDate = str4 != null ? DateUtilsKt.fromCookieToGmtDate(str4) : null;
                String str5 = (String) linkedHashMap.get("domain");
                String str6 = (String) linkedHashMap.get("path");
                boolean zContainsKey = linkedHashMap.containsKey("secure");
                boolean zContainsKey2 = linkedHashMap.containsKey("httponly");
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry<String, String> entry3 : clientCookiesHeader.entrySet()) {
                    String key = entry3.getKey();
                    if (!loweredPartNames.contains(TextKt.toLowerCasePreservingASCIIRules(key)) && !Intrinsics.areEqual(key, entry.getKey())) {
                        linkedHashMap2.put(entry3.getKey(), entry3.getValue());
                    }
                }
                return new Cookie(str2, strDecodeCookieValue, cookieEncoding, intClamping, gMTDateFromCookieToGmtDate, str5, str6, zContainsKey, zContainsKey2, linkedHashMap2);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static /* synthetic */ Map parseClientCookiesHeader$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return parseClientCookiesHeader(str, z);
    }

    public static final Map<String, String> parseClientCookiesHeader(String cookiesHeader, final boolean z) {
        Intrinsics.checkNotNullParameter(cookiesHeader, "cookiesHeader");
        return MapsKt.toMap(SequencesKt.map(SequencesKt.filter(SequencesKt.map(Regex.findAll$default(clientCookieHeaderPattern, cookiesHeader, 0, 2, null), new Function1<MatchResult, Pair<? extends String, ? extends String>>() { // from class: io.ktor.http.CookieKt.parseClientCookiesHeader.1
            @Override // kotlin.jvm.functions.Function1
            public final Pair<String, String> invoke(MatchResult it) {
                String value;
                String value2;
                Intrinsics.checkNotNullParameter(it, "it");
                MatchGroup matchGroup = it.getGroups().get(2);
                String str = "";
                if (matchGroup == null || (value = matchGroup.getValue()) == null) {
                    value = "";
                }
                MatchGroup matchGroup2 = it.getGroups().get(4);
                if (matchGroup2 != null && (value2 = matchGroup2.getValue()) != null) {
                    str = value2;
                }
                return TuplesKt.to(value, str);
            }
        }), new Function1<Pair<? extends String, ? extends String>, Boolean>() { // from class: io.ktor.http.CookieKt.parseClientCookiesHeader.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:6:0x001a  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Boolean invoke2(kotlin.Pair<java.lang.String, java.lang.String> r5) {
                /*
                    r4 = this;
                    java.lang.String r0 = "it"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                    boolean r0 = r1
                    if (r0 == 0) goto L1a
                    java.lang.Object r5 = r5.getFirst()
                    java.lang.String r5 = (java.lang.String) r5
                    r0 = 2
                    r1 = 0
                    java.lang.String r2 = "$"
                    r3 = 0
                    boolean r5 = kotlin.text.StringsKt.startsWith$default(r5, r2, r3, r0, r1)
                    if (r5 != 0) goto L1b
                L1a:
                    r3 = 1
                L1b:
                    java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.CookieKt.AnonymousClass2.invoke2(kotlin.Pair):java.lang.Boolean");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Pair<? extends String, ? extends String> pair) {
                return invoke2((Pair<String, String>) pair);
            }
        }), new Function1<Pair<? extends String, ? extends String>, Pair<? extends String, ? extends String>>() { // from class: io.ktor.http.CookieKt.parseClientCookiesHeader.3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Pair<? extends String, ? extends String> invoke(Pair<? extends String, ? extends String> pair) {
                return invoke2((Pair<String, String>) pair);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Pair<String, String> invoke2(Pair<String, String> cookie) {
                Intrinsics.checkNotNullParameter(cookie, "cookie");
                return (StringsKt.startsWith$default(cookie.getSecond(), "\"", false, 2, (Object) null) && StringsKt.endsWith$default(cookie.getSecond(), "\"", false, 2, (Object) null)) ? Pair.copy$default(cookie, null, StringsKt.removeSurrounding(cookie.getSecond(), (CharSequence) "\""), 1, null) : cookie;
            }
        }));
    }

    public static final String renderSetCookieHeader(Cookie cookie) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        return renderSetCookieHeader$default(cookie.getName(), cookie.getValue(), cookie.getEncoding(), cookie.getMaxAgeInt(), cookie.getExpires(), cookie.getDomain(), cookie.getPath(), cookie.getSecure(), cookie.getHttpOnly(), cookie.getExtensions(), false, 1024, null);
    }

    public static final String renderCookieHeader(Cookie cookie) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        return cookie.getName() + SignatureVisitor.INSTANCEOF + encodeCookieValue(cookie.getValue(), cookie.getEncoding());
    }

    public static /* synthetic */ String renderSetCookieHeader$default(String str, String str2, CookieEncoding cookieEncoding, int i, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map map, boolean z3, int i2, Object obj) {
        return renderSetCookieHeader(str, str2, (i2 & 4) != 0 ? CookieEncoding.URI_ENCODING : cookieEncoding, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? null : gMTDate, (i2 & 32) != 0 ? null : str3, (i2 & 64) == 0 ? str4 : null, (i2 & 128) != 0 ? false : z, (i2 & 256) == 0 ? z2 : false, (i2 & 512) != 0 ? MapsKt.emptyMap() : map, (i2 & 1024) != 0 ? true : z3);
    }

    public static final String renderSetCookieHeader(String name, String value, CookieEncoding encoding, int i, GMTDate gMTDate, String str, String str2, boolean z, boolean z2, Map<String, String> extensions, boolean z3) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        String[] strArr = new String[7];
        strArr[0] = assertCookieName(name) + SignatureVisitor.INSTANCEOF + encodeCookieValue(value.toString(), encoding);
        Integer numValueOf = i > 0 ? Integer.valueOf(i) : null;
        String str9 = "";
        strArr[1] = numValueOf != null ? "Max-Age=" + numValueOf : "";
        String httpDate = gMTDate != null ? DateUtilsKt.toHttpDate(gMTDate) : null;
        if (httpDate == null) {
            str3 = "";
        } else {
            str3 = "Expires=" + ((Object) httpDate);
        }
        strArr[2] = str3;
        CookieEncoding cookieEncoding = CookieEncoding.RAW;
        if (str == null) {
            str4 = "";
        } else {
            str4 = "Domain=" + encodeCookieValue(str.toString(), cookieEncoding);
        }
        strArr[3] = str4;
        CookieEncoding cookieEncoding2 = CookieEncoding.RAW;
        if (str2 == null) {
            str5 = "";
        } else {
            str5 = "Path=" + encodeCookieValue(str2.toString(), cookieEncoding2);
        }
        strArr[4] = str5;
        if (!z) {
            str6 = "";
        } else {
            str6 = "Secure";
        }
        strArr[5] = str6;
        if (!z2) {
            str7 = "";
        } else {
            str7 = "HttpOnly";
        }
        strArr[6] = str7;
        List listListOf = CollectionsKt.listOf((Object[]) strArr);
        ArrayList arrayList = new ArrayList(extensions.size());
        for (Map.Entry<String, String> entry : extensions.entrySet()) {
            String strAssertCookieName = assertCookieName(entry.getKey());
            String value2 = entry.getValue();
            if (value2 != null) {
                strAssertCookieName = strAssertCookieName + SignatureVisitor.INSTANCEOF + encodeCookieValue(value2.toString(), CookieEncoding.RAW);
            }
            arrayList.add(strAssertCookieName);
        }
        List listPlus = CollectionsKt.plus((Collection) listListOf, (Iterable) arrayList);
        if (z3) {
            String strName = encoding.name();
            if (strName == null) {
                str8 = "$x-enc";
            } else {
                str8 = "$x-enc=" + encodeCookieValue(strName.toString(), CookieEncoding.RAW);
            }
            str9 = str8;
        }
        List listPlus2 = CollectionsKt.plus((Collection<? extends String>) listPlus, str9);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listPlus2) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList2, "; ", null, null, 0, null, null, 62, null);
    }

    public static final String encodeCookieValue(String value, CookieEncoding encoding) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        int i = WhenMappings.$EnumSwitchMapping$0[encoding.ordinal()];
        int i2 = 0;
        if (i == 1) {
            String str = value;
            while (i2 < str.length()) {
                if (shouldEscapeInCookies(str.charAt(i2))) {
                    throw new IllegalArgumentException("The cookie value contains characters that cannot be encoded in RAW format.  Consider URL_ENCODING mode");
                }
                i2++;
            }
            return value;
        }
        if (i != 2) {
            if (i == 3) {
                return Base64Kt.encodeBase64(value);
            }
            if (i == 4) {
                return CodecsKt.encodeURLParameter(value, true);
            }
            throw new NoWhenBranchMatchedException();
        }
        String str2 = value;
        if (StringsKt.contains$default((CharSequence) str2, '\"', false, 2, (Object) null)) {
            throw new IllegalArgumentException("The cookie value contains characters that cannot be encoded in DQUOTES format. Consider URL_ENCODING mode");
        }
        while (i2 < str2.length()) {
            if (shouldEscapeInCookies(str2.charAt(i2))) {
                return "\"" + value + '\"';
            }
            i2++;
        }
        return value;
    }

    public static final String decodeCookieValue(String encodedValue, CookieEncoding encoding) {
        Intrinsics.checkNotNullParameter(encodedValue, "encodedValue");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        int i = WhenMappings.$EnumSwitchMapping$0[encoding.ordinal()];
        if (i == 1 || i == 2) {
            String str = encodedValue;
            return (StringsKt.startsWith$default(StringsKt.trimStart((CharSequence) str).toString(), "\"", false, 2, (Object) null) && StringsKt.endsWith$default(StringsKt.trimEnd((CharSequence) str).toString(), "\"", false, 2, (Object) null)) ? StringsKt.removeSurrounding(StringsKt.trim((CharSequence) str).toString(), (CharSequence) "\"") : encodedValue;
        }
        if (i == 3) {
            return Base64Kt.decodeBase64String(encodedValue);
        }
        if (i == 4) {
            return CodecsKt.decodeURLQueryComponent$default(encodedValue, 0, 0, true, null, 11, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final String assertCookieName(String str) {
        String str2 = str;
        for (int i = 0; i < str2.length(); i++) {
            if (shouldEscapeInCookies(str2.charAt(i))) {
                throw new IllegalArgumentException("Cookie name is not valid: " + str);
            }
        }
        return str;
    }

    private static final boolean shouldEscapeInCookies(char c) {
        return CharsKt.isWhitespace(c) || Intrinsics.compare((int) c, 32) < 0 || cookieCharsShouldBeEscaped.contains(Character.valueOf(c));
    }

    private static final String cookiePart(String str, Object obj, CookieEncoding cookieEncoding) {
        return obj != null ? str + SignatureVisitor.INSTANCEOF + encodeCookieValue(obj.toString(), cookieEncoding) : "";
    }

    private static final String cookiePartUnencoded(String str, Object obj) {
        return obj != null ? str + SignatureVisitor.INSTANCEOF + obj : "";
    }

    private static final String cookiePartFlag(String str, boolean z) {
        return z ? str : "";
    }

    private static final String cookiePartExt(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + SignatureVisitor.INSTANCEOF + encodeCookieValue(str2.toString(), CookieEncoding.RAW);
    }

    private static final int toIntClamping(String str) {
        return (int) kotlin.ranges.RangesKt.coerceIn(Long.parseLong(str), 0L, SieveCacheKt.NodeLinkMask);
    }
}
