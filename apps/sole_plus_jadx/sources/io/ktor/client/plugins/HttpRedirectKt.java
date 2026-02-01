package io.ktor.client.plugins;

import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import org.slf4j.Logger;

/* compiled from: HttpRedirect.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"ALLOWED_FOR_REDIRECT", "", "Lio/ktor/http/HttpMethod;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "isRedirect", "", "Lio/ktor/http/HttpStatusCode;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpRedirectKt {
    private static final Set<HttpMethod> ALLOWED_FOR_REDIRECT = SetsKt.setOf((Object[]) new HttpMethod[]{HttpMethod.INSTANCE.getGet(), HttpMethod.INSTANCE.getHead()});
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRedirect");

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRedirect(HttpStatusCode httpStatusCode) {
        int value = httpStatusCode.getValue();
        return value == HttpStatusCode.INSTANCE.getMovedPermanently().getValue() || value == HttpStatusCode.INSTANCE.getFound().getValue() || value == HttpStatusCode.INSTANCE.getTemporaryRedirect().getValue() || value == HttpStatusCode.INSTANCE.getPermanentRedirect().getValue() || value == HttpStatusCode.INSTANCE.getSeeOther().getValue();
    }
}
