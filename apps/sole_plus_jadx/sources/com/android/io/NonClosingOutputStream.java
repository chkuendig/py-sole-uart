package com.android.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* compiled from: NonClosingOutputStream.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/android/io/NonClosingOutputStream;", "Ljava/io/FilterOutputStream;", "out", "Ljava/io/OutputStream;", "(Ljava/io/OutputStream;)V", "close", "", "write", "b", "", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "", "len", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
final class NonClosingOutputStream extends FilterOutputStream {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonClosingOutputStream(OutputStream out) {
        super(out);
        Intrinsics.checkNotNullParameter(out, "out");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        Intrinsics.checkNotNullParameter(b, "b");
        this.out.write(b, off, len);
    }
}
