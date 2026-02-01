package org.apache.http.impl.cookie;

import org.apache.http.conn.util.PublicSuffixList;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.cookie.CommonCookieAttributeHandler;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

/* loaded from: classes2.dex */
public class PublicSuffixDomainFilter implements CommonCookieAttributeHandler {
    private final CommonCookieAttributeHandler handler;
    private final PublicSuffixMatcher publicSuffixMatcher;

    public PublicSuffixDomainFilter(CommonCookieAttributeHandler commonCookieAttributeHandler, PublicSuffixMatcher publicSuffixMatcher) {
        this.handler = (CommonCookieAttributeHandler) Args.notNull(commonCookieAttributeHandler, "Cookie handler");
        this.publicSuffixMatcher = (PublicSuffixMatcher) Args.notNull(publicSuffixMatcher, "Public suffix matcher");
    }

    public PublicSuffixDomainFilter(CommonCookieAttributeHandler commonCookieAttributeHandler, PublicSuffixList publicSuffixList) {
        Args.notNull(commonCookieAttributeHandler, "Cookie handler");
        Args.notNull(publicSuffixList, "Public suffix list");
        this.handler = commonCookieAttributeHandler;
        this.publicSuffixMatcher = new PublicSuffixMatcher(publicSuffixList.getRules(), publicSuffixList.getExceptions());
    }

    @Override // org.apache.http.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        String domain = cookie.getDomain();
        if (domain.equalsIgnoreCase("localhost") || !this.publicSuffixMatcher.matches(domain)) {
            return this.handler.match(cookie, cookieOrigin);
        }
        return false;
    }

    @Override // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        this.handler.parse(setCookie, str);
    }

    @Override // org.apache.http.cookie.CookieAttributeHandler
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        this.handler.validate(cookie, cookieOrigin);
    }

    @Override // org.apache.http.cookie.CommonCookieAttributeHandler
    public String getAttributeName() {
        return this.handler.getAttributeName();
    }

    public static CommonCookieAttributeHandler decorate(CommonCookieAttributeHandler commonCookieAttributeHandler, PublicSuffixMatcher publicSuffixMatcher) {
        Args.notNull(commonCookieAttributeHandler, "Cookie attribute handler");
        return publicSuffixMatcher != null ? new PublicSuffixDomainFilter(commonCookieAttributeHandler, publicSuffixMatcher) : commonCookieAttributeHandler;
    }
}
