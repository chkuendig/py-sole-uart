package io.ktor.client.utils;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionUtilsJvm.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {"unwrapCancellationException", "", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ExceptionUtilsJvmKt {
    public static final Throwable unwrapCancellationException(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Throwable cause = th;
        while (cause instanceof CancellationException) {
            CancellationException cancellationException = (CancellationException) cause;
            if (Intrinsics.areEqual(cause, cancellationException.getCause())) {
                return th;
            }
            cause = cancellationException.getCause();
        }
        return cause == null ? th : cause;
    }
}
