package io.ktor.util;

import com.android.SdkConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringValues.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aH\u0010\u0000\u001a\u00020\u00012\u001e\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00040\u00032\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00040\u0003H\u0002\u001a0\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00040\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0002\u001a\u0006\u0010\f\u001a\u00020\r\u001aM\u0010\f\u001a\u00020\r26\u0010\u000e\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00100\u000f\"\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0001¢\u0006\u0002\u0010\u0012\u001a \u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0001\u001a&\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0001\u001a*\u0010\f\u001a\u00020\r2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00180\u00172\b\b\u0002\u0010\u0011\u001a\u00020\u0001\u001a\u0012\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a\u001a6\u0010\u001c\u001a\u00020\u001d*\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00012\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010!\u001a\u001a\u0010\"\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005\u001a\u001a\u0010#\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005\u001a.\u0010$\u001a\u00020\r*\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00012\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010!\u001a\u001c\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00100\u0006*\u00020\r\u001a$\u0010&\u001a\u00020\u001d*\u00020\r2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0!\u001a\u001c\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0017*\u00020\r¨\u0006)"}, d2 = {"entriesEquals", "", "a", "", "", "", "", "b", "entriesHashCode", "", "entries", "seed", "valuesOf", "Lio/ktor/util/StringValues;", "pairs", "", "Lkotlin/Pair;", "caseInsensitiveKey", "([Lkotlin/Pair;Z)Lio/ktor/util/StringValues;", "name", "value", SdkConstants.FD_RES_VALUES, "map", "", "", "appendAll", "Lio/ktor/util/StringValuesBuilder;", "builder", "appendFiltered", "", "source", "keepEmpty", "predicate", "Lkotlin/Function2;", "appendIfNameAbsent", "appendIfNameAndValueAbsent", "filter", "flattenEntries", "flattenForEach", "block", "toMap", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StringValuesKt {
    public static /* synthetic */ StringValues valuesOf$default(Pair[] pairArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return valuesOf((Pair<String, ? extends List<String>>[]) pairArr, z);
    }

    public static final StringValues valuesOf(Pair<String, ? extends List<String>>[] pairs, boolean z) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return new StringValuesImpl(z, MapsKt.toMap(ArraysKt.asList(pairs)));
    }

    public static /* synthetic */ StringValues valuesOf$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return valuesOf(str, str2, z);
    }

    public static final StringValues valuesOf(String name, String value, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return new StringValuesSingleImpl(z, name, kotlin.collections.CollectionsKt.listOf(value));
    }

    public static /* synthetic */ StringValues valuesOf$default(String str, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return valuesOf(str, (List<String>) list, z);
    }

    public static final StringValues valuesOf(String name, List<String> values, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        return new StringValuesSingleImpl(z, name, values);
    }

    public static final StringValues valuesOf() {
        return StringValues.INSTANCE.getEmpty();
    }

    public static /* synthetic */ StringValues valuesOf$default(Map map, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return valuesOf((Map<String, ? extends Iterable<String>>) map, z);
    }

    public static final StringValues valuesOf(Map<String, ? extends Iterable<String>> map, boolean z) {
        Intrinsics.checkNotNullParameter(map, "map");
        int size = map.size();
        if (size == 1) {
            Map.Entry entry = (Map.Entry) kotlin.collections.CollectionsKt.single(map.entrySet());
            return new StringValuesSingleImpl(z, (String) entry.getKey(), kotlin.collections.CollectionsKt.toList((Iterable) entry.getValue()));
        }
        LinkedHashMap linkedHashMapCaseInsensitiveMap = z ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap(size);
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            linkedHashMapCaseInsensitiveMap.put(entry2.getKey(), kotlin.collections.CollectionsKt.toList((Iterable) entry2.getValue()));
        }
        return new StringValuesImpl(z, linkedHashMapCaseInsensitiveMap);
    }

    public static final Map<String, List<String>> toMap(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "<this>");
        Set<Map.Entry<String, List<String>>> setEntries = stringValues.entries();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put((String) entry.getKey(), kotlin.collections.CollectionsKt.toList((Iterable) entry.getValue()));
        }
        return linkedHashMap;
    }

    public static final List<Pair<String, String>> flattenEntries(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "<this>");
        Set<Map.Entry<String, List<String>>> setEntries = stringValues.entries();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList2 = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                arrayList2.add(TuplesKt.to(entry.getKey(), (String) it2.next()));
            }
            kotlin.collections.CollectionsKt.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }

    public static final void flattenForEach(StringValues stringValues, final Function2<? super String, ? super String, Unit> block) {
        Intrinsics.checkNotNullParameter(stringValues, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        stringValues.forEach(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.util.StringValuesKt.flattenForEach.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, List<? extends String> list) {
                invoke2(str, (List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String name, List<String> items) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(items, "items");
                Function2<String, String, Unit> function2 = block;
                Iterator<T> it = items.iterator();
                while (it.hasNext()) {
                    function2.invoke(name, (String) it.next());
                }
            }
        });
    }

    public static /* synthetic */ StringValues filter$default(StringValues stringValues, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return filter(stringValues, z, function2);
    }

    public static final StringValues filter(StringValues stringValues, boolean z, Function2<? super String, ? super String, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(stringValues, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Set<Map.Entry<String, List<String>>> setEntries = stringValues.entries();
        LinkedHashMap linkedHashMapCaseInsensitiveMap = stringValues.getCaseInsensitiveName() ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap(setEntries.size());
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList = new ArrayList(((List) entry.getValue()).size());
            for (Object obj : iterable) {
                if (predicate.invoke(entry.getKey(), (String) obj).booleanValue()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (z || !arrayList2.isEmpty()) {
                linkedHashMapCaseInsensitiveMap.put(entry.getKey(), arrayList2);
            }
        }
        return new StringValuesImpl(stringValues.getCaseInsensitiveName(), linkedHashMapCaseInsensitiveMap);
    }

    public static /* synthetic */ void appendFiltered$default(StringValuesBuilder stringValuesBuilder, StringValues stringValues, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        appendFiltered(stringValuesBuilder, stringValues, z, function2);
    }

    public static final void appendFiltered(final StringValuesBuilder stringValuesBuilder, StringValues source, final boolean z, final Function2<? super String, ? super String, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(stringValuesBuilder, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        source.forEach(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.util.StringValuesKt.appendFiltered.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, List<? extends String> list) {
                invoke2(str, (List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String name, List<String> value) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                List<String> list = value;
                ArrayList arrayList = new ArrayList(value.size());
                Function2<String, String, Boolean> function2 = predicate;
                for (Object obj : list) {
                    if (function2.invoke(name, (String) obj).booleanValue()) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                if (z || !arrayList2.isEmpty()) {
                    stringValuesBuilder.appendAll(name, arrayList2);
                }
            }
        });
    }

    public static final StringValuesBuilder appendAll(StringValuesBuilder stringValuesBuilder, StringValuesBuilder builder) {
        Intrinsics.checkNotNullParameter(stringValuesBuilder, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Iterator<T> it = builder.entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            stringValuesBuilder.appendAll((String) entry.getKey(), (List) entry.getValue());
        }
        return stringValuesBuilder;
    }

    public static final StringValuesBuilder appendIfNameAbsent(StringValuesBuilder stringValuesBuilder, String name, String value) {
        Intrinsics.checkNotNullParameter(stringValuesBuilder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!stringValuesBuilder.contains(name)) {
            stringValuesBuilder.append(name, value);
        }
        return stringValuesBuilder;
    }

    public static final StringValuesBuilder appendIfNameAndValueAbsent(StringValuesBuilder stringValuesBuilder, String name, String value) {
        Intrinsics.checkNotNullParameter(stringValuesBuilder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!stringValuesBuilder.contains(name, value)) {
            stringValuesBuilder.append(name, value);
        }
        return stringValuesBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean entriesEquals(Set<? extends Map.Entry<String, ? extends List<String>>> set, Set<? extends Map.Entry<String, ? extends List<String>>> set2) {
        return Intrinsics.areEqual(set, set2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int entriesHashCode(Set<? extends Map.Entry<String, ? extends List<String>>> set, int i) {
        return (i * 31) + set.hashCode();
    }
}
