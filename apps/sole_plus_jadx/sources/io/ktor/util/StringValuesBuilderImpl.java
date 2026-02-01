package io.ktor.util;

import androidx.health.connect.client.records.CervicalMucusRecord;
import com.android.SdkConstants;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringValues.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\u0010 \n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\u0011\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000bH\u0096\u0002J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J \u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001f0\u001e0\u001dH\u0016J\u0013\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0096\u0002J\u0018\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dH\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020\u0010H\u0016J\u0019\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0096\u0002J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0014J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\f0\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006)"}, d2 = {"Lio/ktor/util/StringValuesBuilderImpl;", "Lio/ktor/util/StringValuesBuilder;", "caseInsensitiveName", "", ContentDisposition.Parameters.Size, "", "(ZI)V", "getCaseInsensitiveName", "()Z", SdkConstants.FD_RES_VALUES, "", "", "", "getValues", "()Ljava/util/Map;", "append", "", "name", "value", "appendAll", "stringValues", "Lio/ktor/util/StringValues;", "", "appendMissing", "build", CervicalMucusRecord.Appearance.CLEAR, "contains", "ensureListForKey", "entries", "", "", "", "get", "getAll", "isEmpty", "names", "remove", "removeKeysWithNoEntries", "set", "validateName", "validateValue", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public class StringValuesBuilderImpl implements StringValuesBuilder {
    private final boolean caseInsensitiveName;
    private final Map<String, List<String>> values;

    /* JADX WARN: Multi-variable type inference failed */
    public StringValuesBuilderImpl() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    protected void validateName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
    }

    protected void validateValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    public StringValuesBuilderImpl(boolean z, int i) {
        this.caseInsensitiveName = z;
        this.values = z ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap(i);
    }

    public /* synthetic */ StringValuesBuilderImpl(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 8 : i);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    protected final Map<String, List<String>> getValues() {
        return this.values;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public List<String> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.values.get(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.values.containsKey(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        List<String> list = this.values.get(name);
        if (list != null) {
            return list.contains(value);
        }
        return false;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set<String> names() {
        return this.values.keySet();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set<Map.Entry<String, List<String>>> entries() {
        return CollectionsJvmKt.unmodifiable(this.values.entrySet());
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void set(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        validateValue(value);
        List<String> listEnsureListForKey = ensureListForKey(name);
        listEnsureListForKey.clear();
        listEnsureListForKey.add(value);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public String get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<String> all = getAll(name);
        if (all != null) {
            return (String) kotlin.collections.CollectionsKt.firstOrNull((List) all);
        }
        return null;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void append(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        validateValue(value);
        ensureListForKey(name).add(value);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        stringValues.forEach(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.util.StringValuesBuilderImpl.appendAll.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, List<? extends String> list) {
                invoke2(str, (List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String name, List<String> values) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(values, "values");
                StringValuesBuilderImpl.this.appendAll(name, values);
            }
        });
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendMissing(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        stringValues.forEach(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.util.StringValuesBuilderImpl.appendMissing.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, List<? extends String> list) {
                invoke2(str, (List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String name, List<String> values) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(values, "values");
                StringValuesBuilderImpl.this.appendMissing(name, values);
            }
        });
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(String name, Iterable<String> values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        List<String> listEnsureListForKey = ensureListForKey(name);
        for (String str : values) {
            validateValue(str);
            listEnsureListForKey.add(str);
        }
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendMissing(String name, Iterable<String> values) {
        Set setEmptySet;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        List<String> list = this.values.get(name);
        if (list == null || (setEmptySet = kotlin.collections.CollectionsKt.toSet(list)) == null) {
            setEmptySet = SetsKt.emptySet();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : values) {
            if (!setEmptySet.contains(str)) {
                arrayList.add(str);
            }
        }
        appendAll(name, arrayList);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void remove(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.values.remove(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void removeKeysWithNoEntries() {
        Map<String, List<String>> map = this.values;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            remove((String) ((Map.Entry) it.next()).getKey());
        }
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean remove(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        List<String> list = this.values.get(name);
        if (list != null) {
            return list.remove(value);
        }
        return false;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void clear() {
        this.values.clear();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public StringValues build() {
        return new StringValuesImpl(this.caseInsensitiveName, this.values);
    }

    private final List<String> ensureListForKey(String name) {
        List<String> list = this.values.get(name);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        validateName(name);
        this.values.put(name, arrayList);
        return arrayList;
    }
}
