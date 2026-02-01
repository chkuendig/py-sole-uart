package com.android.utils.concurrency;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AsyncSupplier.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002Bg\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00128\b\u0002\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/android/utils/concurrency/CachedAsyncSupplierWithTimestamp;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/android/utils/concurrency/AsyncSupplier;", "compute", "Lkotlin/Function0;", "isUpToDate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "timestampMs", "value", "", "executor", "Ljava/util/concurrent/ExecutorService;", "timestampSource", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Ljava/util/concurrent/ExecutorService;Lkotlin/jvm/functions/Function0;)V", "delegate", "Lcom/android/utils/concurrency/CachedAsyncSupplier;", "Lcom/android/utils/concurrency/ValueWithTimestamp;", "now", "getNow", "()Ljava/lang/Object;", "get", "Lcom/google/common/util/concurrent/ListenableFuture;", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CachedAsyncSupplierWithTimestamp<V> implements AsyncSupplier<V> {
    private final CachedAsyncSupplier<ValueWithTimestamp<V>> delegate;
    private final ExecutorService executor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CachedAsyncSupplierWithTimestamp(Function0<? extends V> compute, ExecutorService executor) {
        this(compute, null, executor, null, 10, null);
        Intrinsics.checkNotNullParameter(compute, "compute");
        Intrinsics.checkNotNullParameter(executor, "executor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CachedAsyncSupplierWithTimestamp(Function0<? extends V> compute, Function2<? super Long, ? super V, Boolean> isUpToDate, ExecutorService executor) {
        this(compute, isUpToDate, executor, null, 8, null);
        Intrinsics.checkNotNullParameter(compute, "compute");
        Intrinsics.checkNotNullParameter(isUpToDate, "isUpToDate");
        Intrinsics.checkNotNullParameter(executor, "executor");
    }

    public CachedAsyncSupplierWithTimestamp(final Function0<? extends V> compute, final Function2<? super Long, ? super V, Boolean> isUpToDate, ExecutorService executor, final Function0<Long> timestampSource) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        Intrinsics.checkNotNullParameter(isUpToDate, "isUpToDate");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(timestampSource, "timestampSource");
        this.executor = executor;
        this.delegate = new CachedAsyncSupplier<>(new Function0<ValueWithTimestamp<V>>() { // from class: com.android.utils.concurrency.CachedAsyncSupplierWithTimestamp$delegate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ValueWithTimestamp<V> invoke() {
                return new ValueWithTimestamp<>(compute.invoke(), timestampSource.invoke().longValue());
            }
        }, new Function1<ValueWithTimestamp<V>, Boolean>() { // from class: com.android.utils.concurrency.CachedAsyncSupplierWithTimestamp$delegate$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ValueWithTimestamp<V> valueWithTimestamp) {
                Intrinsics.checkNotNullParameter(valueWithTimestamp, "valueWithTimestamp");
                return isUpToDate.invoke(Long.valueOf(valueWithTimestamp.getTimestampMs()), valueWithTimestamp.getValue());
            }
        }, executor);
    }

    public /* synthetic */ CachedAsyncSupplierWithTimestamp(Function0 function0, AnonymousClass1 anonymousClass1, ExecutorService executorService, AnonymousClass2 anonymousClass2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? new Function2<Long, V, Boolean>() { // from class: com.android.utils.concurrency.CachedAsyncSupplierWithTimestamp.1
            public final Boolean invoke(long j, V v) {
                return true;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(Long l, Object obj) {
                return invoke(l.longValue(), (long) obj);
            }
        } : anonymousClass1, executorService, (i & 8) != 0 ? new Function0<Long>() { // from class: com.android.utils.concurrency.CachedAsyncSupplierWithTimestamp.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(System.currentTimeMillis());
            }
        } : anonymousClass2);
    }

    @Override // com.android.utils.concurrency.AsyncSupplier
    public V getNow() {
        ValueWithTimestamp<V> now = this.delegate.getNow();
        if (now == null) {
            return null;
        }
        return now.getValue();
    }

    @Override // java.util.function.Supplier
    public ListenableFuture<V> get() {
        ListenableFuture<V> listenableFutureTransform = Futures.transform(this.delegate.get(), new Function() { // from class: com.android.utils.concurrency.CachedAsyncSupplierWithTimestamp.get.1
            @Override // com.google.common.base.Function
            public final V apply(ValueWithTimestamp<V> valueWithTimestamp) {
                Intrinsics.checkNotNull(valueWithTimestamp);
                return valueWithTimestamp.getValue();
            }
        }, this.executor);
        Intrinsics.checkNotNullExpressionValue(listenableFutureTransform, "transform(delegate.get()…                executor)");
        return listenableFutureTransform;
    }
}
