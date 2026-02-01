package io.ktor.http;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.share.internal.ShareConstants;
import io.ktor.http.ContentType;
import io.ktor.util.CharsetKt;
import io.ktor.util.CollectionsKt;
import io.ktor.util.TextKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: FileContentType.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\f\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002\u001a\u0012\u0010\u000f\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0002\u001a\u0010\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003*\u00020\u0004\u001a\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0002\u001a\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0002\u001a<\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u00030\u0001\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\u0017*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00170\u00190\u0018H\u0000\u001a\u0012\u0010\u001a\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000\u001a\f\u0010\u001b\u001a\u00020\u0004*\u00020\u0002H\u0000\"-\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"-\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u001c"}, d2 = {"contentTypesByExtensions", "", "", "", "Lio/ktor/http/ContentType;", "getContentTypesByExtensions", "()Ljava/util/Map;", "contentTypesByExtensions$delegate", "Lkotlin/Lazy;", "extensionsByContentType", "getExtensionsByContentType", "extensionsByContentType$delegate", "defaultForFileExtension", "Lio/ktor/http/ContentType$Companion;", ShareConstants.MEDIA_EXTENSION, "defaultForFilePath", "path", "fileExtensions", "fromFileExtension", "ext", "fromFilePath", "groupByPairs", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "selectDefault", "toContentType", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FileContentTypeKt {
    private static final Lazy contentTypesByExtensions$delegate = LazyKt.lazy(new Function0<Map<String, List<? extends ContentType>>>() { // from class: io.ktor.http.FileContentTypeKt$contentTypesByExtensions$2
        @Override // kotlin.jvm.functions.Function0
        public final Map<String, List<? extends ContentType>> invoke() {
            Map<String, List<? extends ContentType>> mapCaseInsensitiveMap = CollectionsKt.caseInsensitiveMap();
            mapCaseInsensitiveMap.putAll(FileContentTypeKt.groupByPairs(kotlin.collections.CollectionsKt.asSequence(MimesKt.getMimes())));
            return mapCaseInsensitiveMap;
        }
    });
    private static final Lazy extensionsByContentType$delegate = LazyKt.lazy(new Function0<Map<ContentType, ? extends List<? extends String>>>() { // from class: io.ktor.http.FileContentTypeKt$extensionsByContentType$2
        @Override // kotlin.jvm.functions.Function0
        public final Map<ContentType, ? extends List<? extends String>> invoke() {
            return FileContentTypeKt.groupByPairs(SequencesKt.map(kotlin.collections.CollectionsKt.asSequence(MimesKt.getMimes()), new Function1<Pair<? extends String, ? extends ContentType>, Pair<? extends ContentType, ? extends String>>() { // from class: io.ktor.http.FileContentTypeKt$extensionsByContentType$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Pair<? extends ContentType, ? extends String> invoke(Pair<? extends String, ? extends ContentType> pair) {
                    return invoke2((Pair<String, ContentType>) pair);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Pair<ContentType, String> invoke2(Pair<String, ContentType> pair) {
                    Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
                    return TuplesKt.to(pair.component2(), pair.component1());
                }
            }));
        }
    });

    public static final ContentType defaultForFileExtension(ContentType.Companion companion, String extension) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(extension, "extension");
        return selectDefault(fromFileExtension(ContentType.INSTANCE, extension));
    }

    public static final ContentType defaultForFilePath(ContentType.Companion companion, String path) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return selectDefault(fromFilePath(ContentType.INSTANCE, path));
    }

    public static final List<ContentType> fromFilePath(ContentType.Companion companion, String path) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        String str = path;
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, '.', StringsKt.lastIndexOfAny$default((CharSequence) str, CharsetKt.toCharArray("/\\"), 0, false, 6, (Object) null) + 1, false, 4, (Object) null);
        if (iIndexOf$default == -1) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        String strSubstring = path.substring(iIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return fromFileExtension(companion, strSubstring);
    }

    public static final List<ContentType> fromFileExtension(ContentType.Companion companion, String ext) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(ext, "ext");
        for (String lowerCasePreservingASCIIRules = TextKt.toLowerCasePreservingASCIIRules(StringsKt.removePrefix(ext, (CharSequence) ".")); lowerCasePreservingASCIIRules.length() > 0; lowerCasePreservingASCIIRules = StringsKt.substringAfter(lowerCasePreservingASCIIRules, ".", "")) {
            List<ContentType> list = getContentTypesByExtensions().get(lowerCasePreservingASCIIRules);
            if (list != null) {
                return list;
            }
        }
        return kotlin.collections.CollectionsKt.emptyList();
    }

    public static final List<String> fileExtensions(ContentType contentType) {
        Intrinsics.checkNotNullParameter(contentType, "<this>");
        List<String> list = getExtensionsByContentType().get(contentType);
        if (list != null) {
            return list;
        }
        List<String> list2 = getExtensionsByContentType().get(contentType.withoutParameters());
        return list2 == null ? kotlin.collections.CollectionsKt.emptyList() : list2;
    }

    private static final Map<String, List<ContentType>> getContentTypesByExtensions() {
        return (Map) contentTypesByExtensions$delegate.getValue();
    }

    private static final Map<ContentType, List<String>> getExtensionsByContentType() {
        return (Map) extensionsByContentType$delegate.getValue();
    }

    public static final ContentType selectDefault(List<ContentType> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ContentType octetStream = (ContentType) kotlin.collections.CollectionsKt.firstOrNull((List) list);
        if (octetStream == null) {
            octetStream = ContentType.Application.INSTANCE.getOctetStream();
        }
        return (Intrinsics.areEqual(octetStream.getContentType(), "text") && ContentTypesKt.charset(octetStream) == null) ? ContentTypesKt.withCharset(octetStream, Charsets.UTF_8) : octetStream;
    }

    public static final ContentType toContentType(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return ContentType.INSTANCE.parse(str);
        } catch (Throwable th) {
            throw new IllegalArgumentException("Failed to parse " + str, th);
        }
    }

    public static final <A, B> Map<A, List<B>> groupByPairs(Sequence<? extends Pair<? extends A, ? extends B>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair<? extends A, ? extends B> pair : sequence) {
            A first = pair.getFirst();
            Object obj = linkedHashMap.get(first);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(first, obj);
            }
            ((List) obj).add(pair);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(((Pair) it.next()).getSecond());
            }
            linkedHashMap2.put(key, arrayList);
        }
        return linkedHashMap2;
    }
}
