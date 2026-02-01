package com.android.io;

import com.android.io.NonClosingInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NonClosingOutputStream.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0000\u001a\u00020\u0002*\u00020\u0002¨\u0006\u0003"}, d2 = {"nonClosing", "Ljava/io/InputStream;", "Ljava/io/OutputStream;", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NonClosingStreams {
    public static final OutputStream nonClosing(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        return new NonClosingOutputStream(outputStream);
    }

    public static final InputStream nonClosing(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        NonClosingInputStream nonClosingInputStream = new NonClosingInputStream(inputStream);
        nonClosingInputStream.setCloseBehavior(NonClosingInputStream.CloseBehavior.IGNORE);
        return nonClosingInputStream;
    }
}
