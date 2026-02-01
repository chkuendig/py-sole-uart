package io.ktor.client.plugins.cache;

import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import io.ktor.client.engine.UtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLProtocol;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* compiled from: HttpCache.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001aN\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f0\u0006H\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0002\"\u0018\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0010"}, d2 = {"LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "getLOGGER", "()Lorg/slf4j/Logger;", "mergedHeadersLookup", "Lkotlin/Function1;", "", "content", "Lio/ktor/http/content/OutgoingContent;", "headerExtractor", "allHeadersExtractor", "", "canStore", "", "Lio/ktor/http/URLProtocol;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpCacheKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpCache");

    public static final Logger getLOGGER() {
        return LOGGER;
    }

    public static final Function1<String, String> mergedHeadersLookup(final OutgoingContent content, final Function1<? super String, String> headerExtractor, final Function1<? super String, ? extends List<String>> allHeadersExtractor) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(headerExtractor, "headerExtractor");
        Intrinsics.checkNotNullParameter(allHeadersExtractor, "allHeadersExtractor");
        return new Function1<String, String>() { // from class: io.ktor.client.plugins.cache.HttpCacheKt.mergedHeadersLookup.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String header) {
                String string;
                Intrinsics.checkNotNullParameter(header, "header");
                if (Intrinsics.areEqual(header, HttpHeaders.INSTANCE.getContentLength())) {
                    Long contentLength = content.getContentLength();
                    if (contentLength == null || (string = contentLength.toString()) == null) {
                        return "";
                    }
                } else {
                    if (!Intrinsics.areEqual(header, HttpHeaders.INSTANCE.getContentType())) {
                        if (Intrinsics.areEqual(header, HttpHeaders.INSTANCE.getUserAgent())) {
                            String str = content.getHeaders().get(HttpHeaders.INSTANCE.getUserAgent());
                            if (str != null) {
                                return str;
                            }
                            String strInvoke = headerExtractor.invoke(HttpHeaders.INSTANCE.getUserAgent());
                            return strInvoke == null ? UtilsKt.getKTOR_DEFAULT_USER_AGENT() : strInvoke;
                        }
                        List<String> all = content.getHeaders().getAll(header);
                        if (all == null && (all = allHeadersExtractor.invoke(header)) == null) {
                            all = CollectionsKt.emptyList();
                        }
                        return CollectionsKt.joinToString$default(all, ";", null, null, 0, null, null, 62, null);
                    }
                    ContentType contentType = content.getContentType();
                    if (contentType == null || (string = contentType.toString()) == null) {
                        return "";
                    }
                }
                return string;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean canStore(URLProtocol uRLProtocol) {
        return Intrinsics.areEqual(uRLProtocol.getName(), "http") || Intrinsics.areEqual(uRLProtocol.getName(), TournamentShareDialogURIBuilder.scheme);
    }
}
