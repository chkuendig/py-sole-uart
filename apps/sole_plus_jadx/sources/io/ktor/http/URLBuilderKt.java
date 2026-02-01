package io.ktor.http;

import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: URLBuilder.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u000e\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\"\u00020\u0003¢\u0006\u0002\u0010\u0011\u001a\u0018\u0010\u000e\u001a\u00020\u0004*\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u001a \u0010\u0014\u001a\u00020\u0015*\u00060\u0016j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a \u0010\u0019\u001a\u00020\u0015*\u00060\u0016j\u0002`\u00172\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0002\u001a%\u0010\u001b\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\"\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0011\u001a-\u0010\u001b\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\"\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001e\u001a\u001a\u0010\u001b\u001a\u00020\u0004*\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0007\u001a\"\u0010\u001b\u001a\u00020\u0004*\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u001a'\u0010\u001f\u001a\u0002H \"\f\b\u0000\u0010 *\u00060\u0016j\u0002`\u0017*\u00020\u00042\u0006\u0010!\u001a\u0002H H\u0002¢\u0006\u0002\u0010\"\u001a\n\u0010#\u001a\u00020\u0004*\u00020\u0004\u001a\u0012\u0010$\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002\u001a#\u0010%\u001a\u00020\u0015*\u00020\u00042\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\"\u00020\u0003¢\u0006\u0002\u0010&\u001a%\u0010'\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\"\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0011\u001a\u001a\u0010'\u001a\u00020\u0004*\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0007\u001aZ\u0010(\u001a\u00020\u0015*\u00020\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150,¢\u0006\u0002\b-¢\u0006\u0002\u0010.\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"(\u0010\b\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\u000b\"\u0018\u0010\f\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006¨\u0006/"}, d2 = {"DEFAULT_PORT", "", "authority", "", "Lio/ktor/http/URLBuilder;", "getAuthority", "(Lio/ktor/http/URLBuilder;)Ljava/lang/String;", "value", "encodedPath", "getEncodedPath", "setEncodedPath", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;)V", "encodedUserAndPassword", "getEncodedUserAndPassword", "appendEncodedPathSegments", "components", "", "(Lio/ktor/http/URLBuilder;[Ljava/lang/String;)Lio/ktor/http/URLBuilder;", "segments", "", "appendFile", "", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", SdkConstants.ATTR_HOST, "appendMailto", "encodedUser", "appendPathSegments", "encodeSlash", "", "(Lio/ktor/http/URLBuilder;[Ljava/lang/String;Z)Lio/ktor/http/URLBuilder;", "appendTo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "out", "(Lio/ktor/http/URLBuilder;Ljava/lang/Appendable;)Ljava/lang/Appendable;", "clone", "joinPath", "path", "(Lio/ktor/http/URLBuilder;[Ljava/lang/String;)V", "pathComponents", "set", SdkConstants.ATTR_SCHEME, "port", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class URLBuilderKt {
    public static final int DEFAULT_PORT = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final <A extends Appendable> A appendTo(URLBuilder uRLBuilder, A a) throws IOException {
        a.append(uRLBuilder.getProtocol().getName());
        String name = uRLBuilder.getProtocol().getName();
        if (Intrinsics.areEqual(name, "file")) {
            appendFile(a, uRLBuilder.getHost(), getEncodedPath(uRLBuilder));
            return a;
        }
        if (Intrinsics.areEqual(name, "mailto")) {
            appendMailto(a, getEncodedUserAndPassword(uRLBuilder), uRLBuilder.getHost());
            return a;
        }
        a.append("://");
        a.append(getAuthority(uRLBuilder));
        URLUtilsKt.appendUrlFullPath(a, getEncodedPath(uRLBuilder), uRLBuilder.getEncodedParameters(), uRLBuilder.getTrailingQuery());
        if (uRLBuilder.getEncodedFragment().length() > 0) {
            a.append('#');
            a.append(uRLBuilder.getEncodedFragment());
        }
        return a;
    }

    private static final void appendMailto(Appendable appendable, String str, String str2) throws IOException {
        appendable.append(":");
        appendable.append(str);
        appendable.append(str2);
    }

    private static final void appendFile(Appendable appendable, String str, String str2) throws IOException {
        appendable.append("://");
        appendable.append(str);
        String str3 = str2;
        if (!StringsKt.startsWith$default((CharSequence) str3, '/', false, 2, (Object) null)) {
            appendable.append('/');
        }
        appendable.append(str3);
    }

    public static final URLBuilder clone(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        return URLUtilsKt.takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), uRLBuilder);
    }

    public static final String getEncodedUserAndPassword(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        StringBuilder sb = new StringBuilder();
        URLUtilsKt.appendUserAndPassword(sb, uRLBuilder.getEncodedUser(), uRLBuilder.getEncodedPassword());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ URLBuilder appendPathSegments$default(URLBuilder uRLBuilder, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return appendPathSegments(uRLBuilder, (List<String>) list, z);
    }

    public static final URLBuilder appendPathSegments(URLBuilder uRLBuilder, List<String> segments, boolean z) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(segments, "segments");
        if (!z) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = segments.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, StringsKt.split$default((CharSequence) it.next(), new char[]{'/'}, false, 0, 6, (Object) null));
            }
            segments = arrayList;
        }
        List<String> list = segments;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(CodecsKt.encodeURLPathPart((String) it2.next()));
        }
        appendEncodedPathSegments(uRLBuilder, arrayList2);
        return uRLBuilder;
    }

    public static /* synthetic */ URLBuilder appendPathSegments$default(URLBuilder uRLBuilder, String[] strArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return appendPathSegments(uRLBuilder, strArr, z);
    }

    public static final URLBuilder appendPathSegments(URLBuilder uRLBuilder, String[] components, boolean z) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(components, "components");
        return appendPathSegments(uRLBuilder, (List<String>) ArraysKt.toList(components), z);
    }

    public static final URLBuilder appendEncodedPathSegments(URLBuilder uRLBuilder, List<String> segments) {
        List<String> listPlus;
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(segments, "segments");
        boolean z = false;
        boolean z2 = uRLBuilder.getEncodedPathSegments().size() > 1 && ((CharSequence) CollectionsKt.last((List) uRLBuilder.getEncodedPathSegments())).length() == 0 && !segments.isEmpty();
        if (segments.size() > 1 && ((CharSequence) CollectionsKt.first((List) segments)).length() == 0 && !uRLBuilder.getEncodedPathSegments().isEmpty()) {
            z = true;
        }
        if (z2 && z) {
            listPlus = CollectionsKt.plus((Collection) CollectionsKt.dropLast(uRLBuilder.getEncodedPathSegments(), 1), (Iterable) CollectionsKt.drop(segments, 1));
        } else if (z2) {
            listPlus = CollectionsKt.plus((Collection) CollectionsKt.dropLast(uRLBuilder.getEncodedPathSegments(), 1), (Iterable) segments);
        } else if (z) {
            listPlus = CollectionsKt.plus((Collection) uRLBuilder.getEncodedPathSegments(), (Iterable) CollectionsKt.drop(segments, 1));
        } else {
            listPlus = CollectionsKt.plus((Collection) uRLBuilder.getEncodedPathSegments(), (Iterable) segments);
        }
        uRLBuilder.setEncodedPathSegments(listPlus);
        return uRLBuilder;
    }

    public static final URLBuilder appendEncodedPathSegments(URLBuilder uRLBuilder, String... components) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(components, "components");
        return appendEncodedPathSegments(uRLBuilder, (List<String>) ArraysKt.toList(components));
    }

    public static final String getAuthority(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(getEncodedUserAndPassword(uRLBuilder));
        sb.append(uRLBuilder.getHost());
        if (uRLBuilder.getPort() != 0 && uRLBuilder.getPort() != uRLBuilder.getProtocol().getDefaultPort()) {
            sb.append(":");
            sb.append(String.valueOf(uRLBuilder.getPort()));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final String getEncodedPath(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        return joinPath(uRLBuilder.getEncodedPathSegments());
    }

    public static final void setEncodedPath(URLBuilder uRLBuilder, String value) {
        List<String> root_path;
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        String str = value;
        if (StringsKt.isBlank(str)) {
            root_path = CollectionsKt.emptyList();
        } else {
            root_path = Intrinsics.areEqual(value, "/") ? URLParserKt.getROOT_PATH() : CollectionsKt.toMutableList((Collection) StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null));
        }
        uRLBuilder.setEncodedPathSegments(root_path);
    }

    private static final String joinPath(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        if (list.size() == 1) {
            return ((CharSequence) CollectionsKt.first((List) list)).length() == 0 ? "/" : (String) CollectionsKt.first((List) list);
        }
        return CollectionsKt.joinToString$default(list, "/", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ void set$default(URLBuilder uRLBuilder, String str, String str2, Integer num, String str3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            function1 = new Function1<URLBuilder, Unit>() { // from class: io.ktor.http.URLBuilderKt.set.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(URLBuilder uRLBuilder2) {
                    Intrinsics.checkNotNullParameter(uRLBuilder2, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(URLBuilder uRLBuilder2) {
                    invoke2(uRLBuilder2);
                    return Unit.INSTANCE;
                }
            };
        }
        set(uRLBuilder, str, str2, num, str3, function1);
    }

    public static final void set(URLBuilder uRLBuilder, String str, String str2, Integer num, String str3, Function1<? super URLBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (str != null) {
            uRLBuilder.setProtocol(URLProtocol.INSTANCE.createOrDefault(str));
        }
        if (str2 != null) {
            uRLBuilder.setHost(str2);
        }
        if (num != null) {
            uRLBuilder.setPort(num.intValue());
        }
        if (str3 != null) {
            setEncodedPath(uRLBuilder, str3);
        }
        block.invoke(uRLBuilder);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Plesae use method with boolean parameter")
    public static final /* synthetic */ URLBuilder appendPathSegments(URLBuilder uRLBuilder, List segments) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(segments, "segments");
        return appendPathSegments(uRLBuilder, (List<String>) segments, false);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Plesae use method with boolean parameter")
    public static final /* synthetic */ URLBuilder appendPathSegments(URLBuilder uRLBuilder, String... components) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(components, "components");
        return appendPathSegments(uRLBuilder, (List<String>) ArraysKt.toList(components), false);
    }

    @Deprecated(message = "Please use appendPathSegments method", replaceWith = @ReplaceWith(expression = "this.appendPathSegments(components", imports = {}))
    public static final URLBuilder pathComponents(URLBuilder uRLBuilder, String... components) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(components, "components");
        return appendPathSegments$default(uRLBuilder, ArraysKt.toList(components), false, 2, (Object) null);
    }

    @Deprecated(message = "Please use appendPathSegments method", replaceWith = @ReplaceWith(expression = "this.appendPathSegments(components", imports = {}))
    public static final URLBuilder pathComponents(URLBuilder uRLBuilder, List<String> components) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(components, "components");
        return appendPathSegments$default(uRLBuilder, (List) components, false, 2, (Object) null);
    }

    public static final void path(URLBuilder uRLBuilder, String... path) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        ArrayList arrayList = new ArrayList(path.length);
        for (String str : path) {
            arrayList.add(CodecsKt.encodeURLPath(str));
        }
        uRLBuilder.setEncodedPathSegments(arrayList);
    }
}
