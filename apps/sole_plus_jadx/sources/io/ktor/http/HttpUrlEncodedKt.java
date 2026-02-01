package io.ktor.http;

import io.ktor.http.Parameters;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
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
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.objectweb.asm.signature.SignatureVisitor;

/* compiled from: HttpUrlEncoded.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\n\u0010\u0007\u001a\u00060\bj\u0002`\t\u001a\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\n2\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0000\u001a*\u0010\u0005\u001a\u00020\u0006*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\t\u001a0\u0010\u0005\u001a\u00020\u0006*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\f0\u000b2\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0000\u001a\"\u0010\r\u001a\u00020\u0002*\u00020\u00012\f\b\u0002\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, d2 = {"formUrlEncode", "", "Lio/ktor/http/Parameters;", "", "Lkotlin/Pair;", "formUrlEncodeTo", "", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Lio/ktor/http/ParametersBuilder;", "", "", "parseUrlEncodedParameters", "defaultEncoding", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "limit", "", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpUrlEncodedKt {
    public static /* synthetic */ Parameters parseUrlEncodedParameters$default(String str, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = 1000;
        }
        return parseUrlEncodedParameters(str, charset, i);
    }

    public static final Parameters parseUrlEncodedParameters(String str, Charset defaultEncoding, int i) {
        Object next;
        String name;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(defaultEncoding, "defaultEncoding");
        List<String> listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"&"}, false, i, 2, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
        for (String str2 : listSplit$default) {
            arrayList.add(TuplesKt.to(StringsKt.substringBefore$default(str2, "=", (String) null, 2, (Object) null), StringsKt.substringAfter(str2, "=", "")));
        }
        ArrayList<Pair> arrayList2 = arrayList;
        Iterator it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((Pair) next).getFirst(), "_charset_")) {
                break;
            }
        }
        Pair pair = (Pair) next;
        if (pair == null || (name = (String) pair.getSecond()) == null) {
            name = CharsetJVMKt.getName(defaultEncoding);
        }
        Charset charset = Charset.forName(name);
        Parameters.Companion companion = Parameters.INSTANCE;
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        for (Pair pair2 : arrayList2) {
            String str3 = (String) pair2.component1();
            String str4 = (String) pair2.component2();
            Intrinsics.checkNotNullExpressionValue(charset, "charset");
            parametersBuilderParametersBuilder$default.append(CodecsKt.decodeURLQueryComponent$default(str3, 0, 0, false, charset, 7, null), CodecsKt.decodeURLQueryComponent$default(str4, 0, 0, false, charset, 7, null));
        }
        return parametersBuilderParametersBuilder$default.build();
    }

    public static final String formUrlEncode(List<Pair<String, String>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        StringBuilder sb = new StringBuilder();
        formUrlEncodeTo(list, sb);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final void formUrlEncodeTo(List<Pair<String, String>> list, Appendable out) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        CollectionsKt.joinTo(list, out, (124 & 2) != 0 ? ", " : "&", (124 & 4) != 0 ? "" : null, (124 & 8) != 0 ? "" : null, (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: io.ktor.http.HttpUrlEncodedKt.formUrlEncodeTo.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Pair<? extends String, ? extends String> pair) {
                return invoke2((Pair<String, String>) pair);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Pair<String, String> it) throws Throwable {
                Intrinsics.checkNotNullParameter(it, "it");
                String strEncodeURLParameter = CodecsKt.encodeURLParameter(it.getFirst(), true);
                if (it.getSecond() == null) {
                    return strEncodeURLParameter;
                }
                return strEncodeURLParameter + SignatureVisitor.INSTANCEOF + CodecsKt.encodeURLParameterValue(String.valueOf(it.getSecond()));
            }
        });
    }

    public static final String formUrlEncode(Parameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "<this>");
        Set<Map.Entry<String, List<String>>> setEntries = parameters.entries();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                arrayList2.add(TuplesKt.to(entry.getKey(), (String) it2.next()));
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        return formUrlEncode(arrayList);
    }

    public static final void formUrlEncodeTo(Parameters parameters, Appendable out) {
        Intrinsics.checkNotNullParameter(parameters, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        formUrlEncodeTo(parameters.entries(), out);
    }

    public static final void formUrlEncodeTo(ParametersBuilder parametersBuilder, Appendable out) {
        Intrinsics.checkNotNullParameter(parametersBuilder, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        formUrlEncodeTo(parametersBuilder.entries(), out);
    }

    public static final void formUrlEncodeTo(Set<? extends Map.Entry<String, ? extends List<String>>> set, Appendable out) {
        ArrayList arrayListListOf;
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.isEmpty()) {
                arrayListListOf = CollectionsKt.listOf(TuplesKt.to(str, null));
            } else {
                List list2 = list;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(TuplesKt.to(str, (String) it2.next()));
                }
                arrayListListOf = arrayList2;
            }
            CollectionsKt.addAll(arrayList, arrayListListOf);
        }
        formUrlEncodeTo(arrayList, out);
    }
}
