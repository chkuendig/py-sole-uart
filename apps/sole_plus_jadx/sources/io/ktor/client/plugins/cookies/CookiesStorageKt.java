package io.ktor.client.plugins.cookies;

import io.ktor.http.Cookie;
import io.ktor.http.IpParserKt;
import io.ktor.http.URLProtocolKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.TextKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CookiesStorage.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u000b\u001a\u00020\f*\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"addCookie", "", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "urlString", "", "cookie", "Lio/ktor/http/Cookie;", "(Lio/ktor/client/plugins/cookies/CookiesStorage;Ljava/lang/String;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fillDefaults", "requestUrl", "Lio/ktor/http/Url;", "matches", "", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CookiesStorageKt {
    public static final Object addCookie(CookiesStorage cookiesStorage, String str, Cookie cookie, Continuation<? super Unit> continuation) {
        Object objAddCookie = cookiesStorage.addCookie(URLUtilsKt.Url(str), cookie, continuation);
        return objAddCookie == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAddCookie : Unit.INSTANCE;
    }

    public static final boolean matches(Cookie cookie, Url requestUrl) {
        String lowerCasePreservingASCIIRules;
        String strTrimStart;
        Intrinsics.checkNotNullParameter(cookie, "<this>");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        String domain = cookie.getDomain();
        if (domain == null || (lowerCasePreservingASCIIRules = TextKt.toLowerCasePreservingASCIIRules(domain)) == null || (strTrimStart = StringsKt.trimStart(lowerCasePreservingASCIIRules, '.')) == null) {
            throw new IllegalStateException("Domain field should have the default value".toString());
        }
        cookie.getPath();
        String path = cookie.getPath();
        if (path == null) {
            throw new IllegalStateException("Path field should have the default value".toString());
        }
        if (!StringsKt.endsWith$default((CharSequence) path, '/', false, 2, (Object) null)) {
            path = cookie.getPath() + '/';
        }
        String lowerCasePreservingASCIIRules2 = TextKt.toLowerCasePreservingASCIIRules(requestUrl.getHost());
        String encodedPath = requestUrl.getEncodedPath();
        if (!StringsKt.endsWith$default((CharSequence) encodedPath, '/', false, 2, (Object) null)) {
            encodedPath = encodedPath + '/';
        }
        if (!Intrinsics.areEqual(lowerCasePreservingASCIIRules2, strTrimStart) && (IpParserKt.hostIsIp(lowerCasePreservingASCIIRules2) || !StringsKt.endsWith$default(lowerCasePreservingASCIIRules2, "." + strTrimStart, false, 2, (Object) null))) {
            return false;
        }
        if (Intrinsics.areEqual(path, "/") || Intrinsics.areEqual(encodedPath, path) || StringsKt.startsWith$default(encodedPath, path, false, 2, (Object) null)) {
            return !cookie.getSecure() || URLProtocolKt.isSecure(requestUrl.getProtocol());
        }
        return false;
    }

    public static final Cookie fillDefaults(Cookie cookie, Url requestUrl) {
        Cookie cookieCopy = cookie;
        Intrinsics.checkNotNullParameter(cookie, "<this>");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        String path = cookie.getPath();
        if (path == null || !StringsKt.startsWith$default(path, "/", false, 2, (Object) null)) {
            cookieCopy = cookie.copy((991 & 1) != 0 ? cookie.name : null, (991 & 2) != 0 ? cookie.value : null, (991 & 4) != 0 ? cookie.encoding : null, (991 & 8) != 0 ? cookie.maxAge : 0, (991 & 16) != 0 ? cookie.expires : null, (991 & 32) != 0 ? cookie.domain : null, (991 & 64) != 0 ? cookie.path : requestUrl.getEncodedPath(), (991 & 128) != 0 ? cookie.secure : false, (991 & 256) != 0 ? cookie.httpOnly : false, (991 & 512) != 0 ? cookie.extensions : null);
        }
        String domain = cookieCopy.getDomain();
        return (domain == null || StringsKt.isBlank(domain)) ? cookieCopy.copy((991 & 1) != 0 ? cookieCopy.name : null, (991 & 2) != 0 ? cookieCopy.value : null, (991 & 4) != 0 ? cookieCopy.encoding : null, (991 & 8) != 0 ? cookieCopy.maxAge : 0, (991 & 16) != 0 ? cookieCopy.expires : null, (991 & 32) != 0 ? cookieCopy.domain : requestUrl.getHost(), (991 & 64) != 0 ? cookieCopy.path : null, (991 & 128) != 0 ? cookieCopy.secure : false, (991 & 256) != 0 ? cookieCopy.httpOnly : false, (991 & 512) != 0 ? cookieCopy.extensions : null) : cookieCopy;
    }
}
