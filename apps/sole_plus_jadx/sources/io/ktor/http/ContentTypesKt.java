package io.ktor.http;

import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentTypes.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002*\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\n\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u0005*\u00020\u00052\n\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002¨\u0006\u0007"}, d2 = {HttpAuthHeader.Parameters.Charset, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "Lio/ktor/http/HeaderValueWithParameters;", "withCharset", "Lio/ktor/http/ContentType;", "withCharsetIfNeeded", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ContentTypesKt {
    public static final ContentType withCharset(ContentType contentType, Charset charset) {
        Intrinsics.checkNotNullParameter(contentType, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return contentType.withParameter(HttpAuthHeader.Parameters.Charset, CharsetJVMKt.getName(charset));
    }

    public static final ContentType withCharsetIfNeeded(ContentType contentType, Charset charset) {
        Intrinsics.checkNotNullParameter(contentType, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String lowerCase = contentType.getContentType().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return !Intrinsics.areEqual(lowerCase, "text") ? contentType : contentType.withParameter(HttpAuthHeader.Parameters.Charset, CharsetJVMKt.getName(charset));
    }

    public static final Charset charset(HeaderValueWithParameters headerValueWithParameters) {
        Intrinsics.checkNotNullParameter(headerValueWithParameters, "<this>");
        String strParameter = headerValueWithParameters.parameter(HttpAuthHeader.Parameters.Charset);
        if (strParameter == null) {
            return null;
        }
        try {
            return Charset.forName(strParameter);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
