package com.ua.sdk.recorder;

import com.ua.sdk.datapoint.DataFrameImpl;
import com.ua.sdk.util.Pools;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class RecyclableDataFrameImpl extends DataFrameImpl {
    private Pools.Pool<RecyclableDataFrameImpl> pool;
    private AtomicInteger referenceCount = new AtomicInteger();

    public RecyclableDataFrameImpl(Pools.Pool<RecyclableDataFrameImpl> pool) {
        this.pool = pool;
    }

    protected void retain() {
        this.referenceCount.incrementAndGet();
    }

    protected void release() {
        int iDecrementAndGet = this.referenceCount.decrementAndGet();
        if (iDecrementAndGet == 0) {
            this.pool.release(this);
        } else if (iDecrementAndGet < 0) {
            throw new IllegalStateException("Release but not retained!");
        }
    }
}
