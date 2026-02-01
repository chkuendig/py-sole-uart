package io.ktor.util.collections;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import com.android.ddmlib.testrunner.IInstrumentationResultParser;
import io.ktor.util.InternalAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CopyOnWriteHashMap.kt */
@InternalAPI
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\u000b\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u00002!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\r\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u000eJ \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/util/collections/CopyOnWriteHashMap;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, SdkConstants.CONSTRUCTOR_NAME, "()V", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "producer", "computeIfAbsent", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CopyOnWriteHashMap<K, V> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater current$FU = AtomicReferenceFieldUpdater.newUpdater(CopyOnWriteHashMap.class, Object.class, IInstrumentationResultParser.StatusKeys.CURRENT);
    private volatile /* synthetic */ Object current = MapsKt.emptyMap();

    public final V put(K key, V value) {
        Map map;
        HashMap map2;
        V v;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        do {
            map = (Map) this.current;
            if (map.get(key) == value) {
                return value;
            }
            map2 = new HashMap(map);
            v = (V) map2.put(key, value);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(current$FU, this, map, map2));
        return v;
    }

    public final V get(K key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (V) ((Map) this.current).get(key);
    }

    public final void set(K key, V value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        put(key, value);
    }

    public final V remove(K key) {
        Map map;
        HashMap map2;
        V v;
        Intrinsics.checkNotNullParameter(key, "key");
        do {
            map = (Map) this.current;
            if (map.get(key) == null) {
                return null;
            }
            map2 = new HashMap(map);
            v = (V) map2.remove(key);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(current$FU, this, map, map2));
        return v;
    }

    public final V computeIfAbsent(K key, Function1<? super K, ? extends V> producer) {
        Map map;
        HashMap map2;
        V vInvoke;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(producer, "producer");
        do {
            map = (Map) this.current;
            V v = (V) map.get(key);
            if (v != null) {
                return v;
            }
            map2 = new HashMap(map);
            vInvoke = producer.invoke(key);
            map2.put(key, vInvoke);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(current$FU, this, map, map2));
        return vInvoke;
    }
}
