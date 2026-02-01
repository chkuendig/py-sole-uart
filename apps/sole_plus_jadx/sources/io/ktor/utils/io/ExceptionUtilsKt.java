package io.ktor.utils.io;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionUtils.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"unwrapCancellationException", "", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ExceptionUtilsKt {
    public static final Throwable unwrapCancellationException(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Throwable th2 = th;
        while (th2 instanceof CancellationException) {
            if (Intrinsics.areEqual(th2, th2.getCause())) {
                return th;
            }
            Throwable cause = th2.getCause();
            if (cause == null) {
                return th2;
            }
            th2 = cause;
        }
        return th2;
    }
}
