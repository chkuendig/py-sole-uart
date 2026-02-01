package io.ktor.util.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionUtilsJvm.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0004"}, d2 = {"initCauseBridge", "", "", "cause", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ExceptionUtilsJvmKt {
    public static final void initCauseBridge(Throwable th, Throwable cause) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(cause, "cause");
        th.initCause(cause);
    }
}
