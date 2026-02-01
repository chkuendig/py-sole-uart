package com.android.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class NonClosingInputStream extends FilterInputStream {
    private CloseBehavior mCloseBehavior;
    private final InputStream mInputStream;

    public enum CloseBehavior {
        CLOSE,
        IGNORE,
        RESET
    }

    public NonClosingInputStream(InputStream in) {
        super(in);
        this.mCloseBehavior = CloseBehavior.CLOSE;
        this.mInputStream = in;
    }

    public CloseBehavior getCloseBehavior() {
        return this.mCloseBehavior;
    }

    public NonClosingInputStream setCloseBehavior(CloseBehavior closeBehavior) {
        this.mCloseBehavior = closeBehavior;
        return this;
    }

    /* renamed from: com.android.io.NonClosingInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$io$NonClosingInputStream$CloseBehavior;

        static {
            int[] iArr = new int[CloseBehavior.values().length];
            $SwitchMap$com$android$io$NonClosingInputStream$CloseBehavior = iArr;
            try {
                iArr[CloseBehavior.IGNORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$io$NonClosingInputStream$CloseBehavior[CloseBehavior.RESET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$android$io$NonClosingInputStream$CloseBehavior[CloseBehavior.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int i = AnonymousClass1.$SwitchMap$com$android$io$NonClosingInputStream$CloseBehavior[this.mCloseBehavior.ordinal()];
        if (i == 2) {
            this.mInputStream.reset();
        } else {
            if (i != 3) {
                return;
            }
            this.mInputStream.close();
        }
    }
}
