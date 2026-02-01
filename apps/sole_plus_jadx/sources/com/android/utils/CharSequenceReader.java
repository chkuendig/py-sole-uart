package com.android.utils;

import java.io.Reader;
import java.nio.CharBuffer;

/* loaded from: classes3.dex */
public final class CharSequenceReader extends Reader {
    private int mark;
    private int pos;
    private CharSequence seq;

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public boolean ready() {
        return true;
    }

    public CharSequenceReader(CharSequence seq) {
        this.seq = seq;
    }

    private boolean hasRemaining() {
        return remaining() > 0;
    }

    private int remaining() {
        return this.seq.length() - this.pos;
    }

    @Override // java.io.Reader, java.lang.Readable
    public int read(CharBuffer target) {
        if (!hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(target.remaining(), remaining());
        for (int i = 0; i < iMin; i++) {
            CharSequence charSequence = this.seq;
            int i2 = this.pos;
            this.pos = i2 + 1;
            target.put(charSequence.charAt(i2));
        }
        return iMin;
    }

    @Override // java.io.Reader
    public int read() {
        if (!hasRemaining()) {
            return -1;
        }
        CharSequence charSequence = this.seq;
        int i = this.pos;
        this.pos = i + 1;
        return charSequence.charAt(i);
    }

    @Override // java.io.Reader
    public int read(char[] cbuf, int off, int len) {
        if (!hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(len, remaining());
        for (int i = 0; i < iMin; i++) {
            CharSequence charSequence = this.seq;
            int i2 = this.pos;
            this.pos = i2 + 1;
            cbuf[off + i] = charSequence.charAt(i2);
        }
        return iMin;
    }

    @Override // java.io.Reader
    public long skip(long n) {
        int iMin = (int) Math.min(remaining(), n);
        this.pos += iMin;
        return iMin;
    }

    @Override // java.io.Reader
    public void mark(int readAheadLimit) {
        this.mark = this.pos;
    }

    @Override // java.io.Reader
    public void reset() {
        this.pos = this.mark;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.seq = null;
    }
}
