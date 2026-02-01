package com.ua.sdk.internal;

import com.ua.sdk.UploadCallback;
import com.ua.sdk.concurrent.EntityEventHandler;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class ProgressOutputStream extends FilterOutputStream {
    private final UploadCallback callback;
    private final long totalLength;
    private volatile long transferred;

    public ProgressOutputStream(OutputStream outputStream, long j, UploadCallback uploadCallback) {
        super(outputStream);
        this.callback = uploadCallback;
        this.totalLength = j;
        this.transferred = 0L;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        try {
            this.out.write(i);
            this.transferred++;
            if (this.transferred < this.totalLength) {
                EntityEventHandler.callOnUploadProgress(this.transferred, this.callback);
            }
        } catch (IOException unused) {
            throw new InterruptedIOException();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.out.write(bArr, i, i2);
            this.transferred += i2;
            if (this.transferred < this.totalLength) {
                EntityEventHandler.callOnUploadProgress(this.transferred, this.callback);
            }
        } catch (IOException unused) {
            throw new InterruptedIOException();
        }
    }
}
