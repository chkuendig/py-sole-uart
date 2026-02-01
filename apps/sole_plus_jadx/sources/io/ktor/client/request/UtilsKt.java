package io.ktor.client.request;

import androidx.autofill.HintConstants;
import com.android.SdkConstants;
import io.ktor.http.ContentType;
import io.ktor.http.Cookie;
import io.ktor.http.CookieKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.util.Base64Kt;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: utils.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0012\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001a\u0010\u0013\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0012\u0010\u0016\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0001\u001at\u0010\u0018\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010#\u001a\u001c\u0010$\u001a\u00020\u000f*\u00020\u00102\u0006\u0010%\u001a\u00020\u00012\b\u0010\u0000\u001a\u0004\u0018\u00010&\u001a\u001c\u0010'\u001a\u00020\u000f*\u00020\u00032\u0006\u0010%\u001a\u00020\u00012\b\u0010\u0000\u001a\u0004\u0018\u00010&\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\t\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006("}, d2 = {"value", "", SdkConstants.ATTR_HOST, "Lio/ktor/client/request/HttpRequestBuilder;", "getHost", "(Lio/ktor/client/request/HttpRequestBuilder;)Ljava/lang/String;", "setHost", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;)V", "", "port", "getPort", "(Lio/ktor/client/request/HttpRequestBuilder;)I", "setPort", "(Lio/ktor/client/request/HttpRequestBuilder;I)V", "accept", "", "Lio/ktor/http/HttpMessageBuilder;", "contentType", "Lio/ktor/http/ContentType;", "basicAuth", HintConstants.AUTOFILL_HINT_USERNAME, "password", "bearerAuth", "token", "cookie", "name", "maxAge", "expires", "Lio/ktor/util/date/GMTDate;", "domain", "path", "secure", "", "httpOnly", "extensions", "", SdkConstants.TAG_HEADER, "key", "", "parameter", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilsKt {
    public static final String getHost(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return httpRequestBuilder.getUrl().getHost();
    }

    public static final void setHost(HttpRequestBuilder httpRequestBuilder, String value) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        httpRequestBuilder.getUrl().setHost(value);
    }

    public static final int getPort(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return httpRequestBuilder.getUrl().getPort();
    }

    public static final void setPort(HttpRequestBuilder httpRequestBuilder, int i) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        httpRequestBuilder.getUrl().setPort(i);
    }

    public static final void header(HttpMessageBuilder httpMessageBuilder, String key, Object obj) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (obj != null) {
            httpMessageBuilder.getHeaders().append(key, obj.toString());
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final void cookie(HttpMessageBuilder httpMessageBuilder, String name, String value, int i, GMTDate gMTDate, String str, String str2, boolean z, boolean z2, Map<String, String> extensions) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        String strRenderCookieHeader = CookieKt.renderCookieHeader(new Cookie(name, value, null, i, gMTDate, str, str2, z, z2, extensions, 4, null));
        if (!httpMessageBuilder.getHeaders().contains(HttpHeaders.INSTANCE.getCookie())) {
            httpMessageBuilder.getHeaders().append(HttpHeaders.INSTANCE.getCookie(), strRenderCookieHeader);
        } else {
            httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getCookie(), httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getCookie()) + "; " + strRenderCookieHeader);
        }
    }

    public static final void parameter(HttpRequestBuilder httpRequestBuilder, String key, Object obj) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (obj != null) {
            httpRequestBuilder.getUrl().getParameters().append(key, obj.toString());
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final void accept(HttpMessageBuilder httpMessageBuilder, ContentType contentType) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        httpMessageBuilder.getHeaders().append(HttpHeaders.INSTANCE.getAccept(), contentType.toString());
    }

    public static final void basicAuth(HttpMessageBuilder httpMessageBuilder, String username, String password) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        header(httpMessageBuilder, HttpHeaders.INSTANCE.getAuthorization(), "Basic " + Base64Kt.encodeBase64(username + ':' + password));
    }

    public static final void bearerAuth(HttpMessageBuilder httpMessageBuilder, String token) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(token, "token");
        header(httpMessageBuilder, HttpHeaders.INSTANCE.getAuthorization(), "Bearer " + token);
    }
}
