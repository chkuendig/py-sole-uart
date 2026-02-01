package com.android.utils.concurrency;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.function.Supplier;
import kotlin.Metadata;

/* compiled from: AsyncSupplier.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&R\u0014\u0010\u0004\u001a\u0004\u0018\u00018\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/android/utils/concurrency/AsyncSupplier;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/util/function/Supplier;", "Lcom/google/common/util/concurrent/ListenableFuture;", "now", "getNow", "()Ljava/lang/Object;", "get", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface AsyncSupplier<V> extends Supplier<ListenableFuture<V>> {
    @Override // java.util.function.Supplier
    ListenableFuture<V> get();

    V getNow();
}
