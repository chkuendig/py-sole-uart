package io.ktor.http;

import com.android.SdkConstants;
import io.ktor.util.StringValuesKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.objectweb.asm.signature.SignatureVisitor;

/* compiled from: URLUtils.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t\u001a\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002\u001a\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\t\u001a\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001\u001a&\u0010\u0012\u001a\u00020\u0013*\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b\u001a(\u0010\u0012\u001a\u00020\u0013*\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\bH\u0000\u001a$\u0010\u001b\u001a\u00020\u0013*\u00060\u001cj\u0002`\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0012\u0010 \u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\t\u001a\u0012\u0010 \u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\b*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\n\"\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u000b\"\u0015\u0010\f\u001a\u00020\b*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\f\u0010\n\"\u0015\u0010\f\u001a\u00020\b*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b¨\u0006!"}, d2 = {"fullPath", "", "Lio/ktor/http/Url;", "getFullPath", "(Lio/ktor/http/Url;)Ljava/lang/String;", "hostWithPort", "getHostWithPort", "isAbsolutePath", "", "Lio/ktor/http/URLBuilder;", "(Lio/ktor/http/URLBuilder;)Z", "(Lio/ktor/http/Url;)Z", "isRelativePath", "URLBuilder", "builder", "url", "urlString", "Url", "appendUrlFullPath", "", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "encodedPath", "encodedQueryParameters", "Lio/ktor/http/ParametersBuilder;", "trailingQuery", "encodedQuery", "appendUserAndPassword", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "encodedUser", "encodedPassword", "takeFrom", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class URLUtilsKt {
    public static final Url Url(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        return URLBuilder(urlString).build();
    }

    public static final Url Url(URLBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), builder).build();
    }

    public static final URLBuilder URLBuilder(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        return URLParserKt.takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), urlString);
    }

    public static final URLBuilder URLBuilder(Url url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), url);
    }

    public static final URLBuilder URLBuilder(URLBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), builder);
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, URLBuilder url) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        uRLBuilder.setProtocol(url.getProtocol());
        uRLBuilder.setHost(url.getHost());
        uRLBuilder.setPort(url.getPort());
        uRLBuilder.setEncodedPathSegments(url.getEncodedPathSegments());
        uRLBuilder.setEncodedUser(url.getEncodedUser());
        uRLBuilder.setEncodedPassword(url.getEncodedPassword());
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        StringValuesKt.appendAll(parametersBuilderParametersBuilder$default, url.getEncodedParameters());
        uRLBuilder.setEncodedParameters(parametersBuilderParametersBuilder$default);
        uRLBuilder.setEncodedFragment(url.getEncodedFragment());
        uRLBuilder.setTrailingQuery(url.getTrailingQuery());
        return uRLBuilder;
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, Url url) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        uRLBuilder.setProtocol(url.getProtocol());
        uRLBuilder.setHost(url.getHost());
        uRLBuilder.setPort(url.getPort());
        URLBuilderKt.setEncodedPath(uRLBuilder, url.getEncodedPath());
        uRLBuilder.setEncodedUser(url.getEncodedUser());
        uRLBuilder.setEncodedPassword(url.getEncodedPassword());
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        parametersBuilderParametersBuilder$default.appendAll(QueryKt.parseQueryString$default(url.getEncodedQuery(), 0, 0, false, 6, null));
        uRLBuilder.setEncodedParameters(parametersBuilderParametersBuilder$default);
        uRLBuilder.setEncodedFragment(url.getEncodedFragment());
        uRLBuilder.setTrailingQuery(url.getTrailingQuery());
        return uRLBuilder;
    }

    public static final String getFullPath(Url url) throws IOException {
        Intrinsics.checkNotNullParameter(url, "<this>");
        StringBuilder sb = new StringBuilder();
        appendUrlFullPath(sb, url.getEncodedPath(), url.getEncodedQuery(), url.getTrailingQuery());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final String getHostWithPort(Url url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        return url.getHost() + ':' + url.getPort();
    }

    public static final void appendUrlFullPath(Appendable appendable, String encodedPath, String encodedQuery, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Intrinsics.checkNotNullParameter(encodedPath, "encodedPath");
        Intrinsics.checkNotNullParameter(encodedQuery, "encodedQuery");
        String str = encodedPath;
        if (!StringsKt.isBlank(str) && !StringsKt.startsWith$default(encodedPath, "/", false, 2, (Object) null)) {
            appendable.append('/');
        }
        appendable.append(str);
        String str2 = encodedQuery;
        if (str2.length() > 0 || z) {
            appendable.append(SdkConstants.PREFIX_THEME_REF);
        }
        appendable.append(str2);
    }

    public static final void appendUrlFullPath(Appendable appendable, String encodedPath, ParametersBuilder encodedQueryParameters, boolean z) {
        ArrayList arrayListListOf;
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Intrinsics.checkNotNullParameter(encodedPath, "encodedPath");
        Intrinsics.checkNotNullParameter(encodedQueryParameters, "encodedQueryParameters");
        String str = encodedPath;
        if (!StringsKt.isBlank(str) && !StringsKt.startsWith$default(encodedPath, "/", false, 2, (Object) null)) {
            appendable.append('/');
        }
        appendable.append(str);
        if (!encodedQueryParameters.isEmpty() || z) {
            appendable.append(SdkConstants.PREFIX_THEME_REF);
        }
        Set<Map.Entry<String, List<String>>> setEntries = encodedQueryParameters.entries();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str2 = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.isEmpty()) {
                arrayListListOf = CollectionsKt.listOf(TuplesKt.to(str2, null));
            } else {
                List list2 = list;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(TuplesKt.to(str2, (String) it2.next()));
                }
                arrayListListOf = arrayList2;
            }
            CollectionsKt.addAll(arrayList, arrayListListOf);
        }
        CollectionsKt.joinTo(arrayList, appendable, (124 & 2) != 0 ? ", " : "&", (124 & 4) != 0 ? "" : null, (124 & 8) != 0 ? "" : null, (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: io.ktor.http.URLUtilsKt.appendUrlFullPath.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Pair<? extends String, ? extends String> pair) {
                return invoke2((Pair<String, String>) pair);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Pair<String, String> it3) {
                Intrinsics.checkNotNullParameter(it3, "it");
                String first = it3.getFirst();
                if (it3.getSecond() == null) {
                    return first;
                }
                return first + SignatureVisitor.INSTANCEOF + String.valueOf(it3.getSecond());
            }
        });
    }

    public static final boolean isAbsolutePath(Url url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        return Intrinsics.areEqual(CollectionsKt.firstOrNull((List) url.getPathSegments()), "");
    }

    public static final boolean isRelativePath(Url url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        return !isAbsolutePath(url);
    }

    public static final boolean isAbsolutePath(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        return Intrinsics.areEqual(CollectionsKt.firstOrNull((List) uRLBuilder.getPathSegments()), "");
    }

    public static final boolean isRelativePath(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        return !isAbsolutePath(uRLBuilder);
    }

    public static final void appendUserAndPassword(StringBuilder sb, String str, String str2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        if (str == null) {
            return;
        }
        sb.append(str);
        if (str2 != null) {
            sb.append(':');
            sb.append(str2);
        }
        sb.append(SdkConstants.PREFIX_RESOURCE_REF);
    }
}
