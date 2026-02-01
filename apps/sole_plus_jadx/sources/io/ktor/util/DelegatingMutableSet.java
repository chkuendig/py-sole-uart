package io.ktor.util;

import androidx.health.connect.client.records.CervicalMucusRecord;
import com.google.common.net.HttpHeaders;
import io.ktor.http.ContentDisposition;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableSet;

/* compiled from: DelegatingMutableSet.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003BE\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\tJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0013\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001fH\u0096\u0002J\u0015\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u0016\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\"\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014*\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014*\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016R\u001f\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lio/ktor/util/DelegatingMutableSet;", HttpHeaders.FROM, "To", "", "delegate", "convertTo", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "convert", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", ContentDisposition.Parameters.Size, "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", CervicalMucusRecord.Appearance.CLEAR, "", "contains", "containsAll", "equals", "other", "", "hashCode", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "toString", "", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public class DelegatingMutableSet<From, To> implements Set<To>, KMutableSet {
    private final Function1<To, From> convert;
    private final Function1<From, To> convertTo;
    private final Set<From> delegate;
    private final int size;

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelegatingMutableSet(Set<From> delegate, Function1<? super From, ? extends To> convertTo, Function1<? super To, ? extends From> convert) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(convertTo, "convertTo");
        Intrinsics.checkNotNullParameter(convert, "convert");
        this.delegate = delegate;
        this.convertTo = convertTo;
        this.convert = convert;
        this.size = delegate.size();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public Collection<From> convert(Collection<? extends To> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Collection<? extends To> collection2 = collection;
        ArrayList arrayList = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.convert.invoke(it.next()));
        }
        return arrayList;
    }

    public Collection<To> convertTo(Collection<? extends From> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Collection<? extends From> collection2 = collection;
        ArrayList arrayList = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.convertTo.invoke(it.next()));
        }
        return arrayList;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(To element) {
        return this.delegate.add(this.convert.invoke(element));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends To> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.delegate.addAll(convert(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object element) {
        return this.delegate.remove(this.convert.invoke(element));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.delegate.removeAll(convert(elements));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.delegate.retainAll(convert(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object element) {
        return this.delegate.contains(this.convert.invoke(element));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.delegate.containsAll(convert(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    /* compiled from: DelegatingMutableSet.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\u000e\u0010\u0007\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"io/ktor/util/DelegatingMutableSet$iterator$1", "", "delegateIterator", "getDelegateIterator", "()Ljava/util/Iterator;", "hasNext", "", LinkHeader.Rel.Next, "()Ljava/lang/Object;", "remove", "", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: io.ktor.util.DelegatingMutableSet$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<To>, KMutableIterator {
        private final Iterator<From> delegateIterator;
        final /* synthetic */ DelegatingMutableSet<From, To> this$0;

        AnonymousClass1(DelegatingMutableSet<From, To> delegatingMutableSet) {
            this.this$0 = delegatingMutableSet;
            this.delegateIterator = ((DelegatingMutableSet) delegatingMutableSet).delegate.iterator();
        }

        public final Iterator<From> getDelegateIterator() {
            return this.delegateIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.delegateIterator.hasNext();
        }

        @Override // java.util.Iterator
        public To next() {
            return (To) ((DelegatingMutableSet) this.this$0).convertTo.invoke(this.delegateIterator.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.delegateIterator.remove();
        }
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<To> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Set)) {
            return false;
        }
        Collection<To> collectionConvertTo = convertTo(this.delegate);
        return ((Set) other).containsAll(collectionConvertTo) && collectionConvertTo.containsAll((Collection) other);
    }

    public String toString() {
        return convertTo(this.delegate).toString();
    }
}
