package com.android.utils.concurrency;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Throwables;
import com.google.common.cache.Cache;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CacheUtils.kt */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\u001a=\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\u0010\u0007\u001a0\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b¨\u0006\f"}, d2 = {"getAndUnwrap", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "K", "Lcom/google/common/cache/Cache;", "key", "loader", "Lkotlin/Function0;", "(Lcom/google/common/cache/Cache;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "retainAll", "", UserMetadata.KEYDATA_FILENAME, "", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CacheUtils {
    public static final <K, V> V getAndUnwrap(Cache<K, V> cache, K k, final Function0<? extends V> loader) {
        Intrinsics.checkNotNullParameter(cache, "<this>");
        Intrinsics.checkNotNullParameter(loader, "loader");
        try {
            return cache.get(k, new Callable() { // from class: com.android.utils.concurrency.CacheUtils$sam$java_util_concurrent_Callable$0
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return loader.invoke();
                }
            });
        } catch (UncheckedExecutionException e) {
            Throwable cause = e.getCause();
            Intrinsics.checkNotNull(cause);
            Throwables.throwIfUnchecked(cause);
            throw e;
        } catch (ExecutionException e2) {
            Throwable cause2 = e2.getCause();
            Intrinsics.checkNotNull(cause2);
            Throwables.throwIfUnchecked(cause2);
            Throwable cause3 = e2.getCause();
            Intrinsics.checkNotNull(cause3);
            throw new UncheckedExecutionException(cause3);
        }
    }

    public static final <K, V> void retainAll(Cache<K, V> cache, Collection<? extends K> keys) {
        Intrinsics.checkNotNullParameter(cache, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        cache.asMap().keySet().retainAll(keys);
    }
}
