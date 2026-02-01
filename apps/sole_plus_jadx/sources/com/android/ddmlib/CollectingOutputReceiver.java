package com.android.ddmlib;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class CollectingOutputReceiver implements IShellOutputReceiver {
    private final CountDownLatch mCompletionLatch;
    private final AtomicBoolean mIsCanceled;
    private final StringBuffer mOutputBuffer;

    public CollectingOutputReceiver() {
        this.mOutputBuffer = new StringBuffer();
        this.mIsCanceled = new AtomicBoolean(false);
        this.mCompletionLatch = new CountDownLatch(1);
    }

    public CollectingOutputReceiver(CountDownLatch commandCompleteLatch) {
        this.mOutputBuffer = new StringBuffer();
        this.mIsCanceled = new AtomicBoolean(false);
        this.mCompletionLatch = commandCompleteLatch;
    }

    public String getOutput() {
        return this.mOutputBuffer.toString();
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public boolean isCancelled() {
        return this.mIsCanceled.get();
    }

    public void cancel() {
        this.mIsCanceled.set(true);
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public void addOutput(byte[] data, int offset, int length) {
        if (isCancelled()) {
            return;
        }
        this.mOutputBuffer.append(new String(data, offset, length, StandardCharsets.UTF_8));
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public void flush() {
        this.mCompletionLatch.countDown();
    }

    public boolean isComplete() {
        return this.mCompletionLatch.getCount() == 0;
    }

    public boolean awaitCompletion(long timeout, TimeUnit unit) throws InterruptedException {
        return this.mCompletionLatch.await(timeout, unit);
    }
}
