package com.samsung.android.sdk.internal.healthdata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes5.dex */
public class HealthResultHolderImpl<T extends HealthResultHolder.BaseResult> implements HealthResultHolder<T>, RemoteResultListener<T> {
    private final a<T> b;
    private HealthResultHolder.ResultListener<T> d;
    private volatile T e;
    private volatile boolean f;
    private boolean g;
    private boolean h;
    private final Object a = new Object();
    private final CountDownLatch c = new CountDownLatch(1);

    private static class a<T extends HealthResultHolder.BaseResult> extends Handler {
        a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                Log.d("Health.ResultHolder", "No default handler");
                return;
            }
            Pair pair = (Pair) message.obj;
            HealthResultHolder.ResultListener resultListener = (HealthResultHolder.ResultListener) pair.first;
            HealthResultHolder.BaseResult baseResult = (HealthResultHolder.BaseResult) pair.second;
            if (resultListener != 0) {
                resultListener.onResult(baseResult);
            }
        }
    }

    HealthResultHolderImpl(Looper looper) {
        this.b = new a<>(looper);
    }

    private void a() {
        if (this.f) {
            throw new IllegalStateException("Result has already been processed");
        }
    }

    private boolean b() {
        boolean z;
        synchronized (this.a) {
            z = this.g;
        }
        return z;
    }

    private boolean c() {
        return this.c.getCount() == 0;
    }

    private void d() {
        synchronized (this.a) {
            if (!c()) {
                this.h = true;
            }
        }
    }

    protected T acquireResult() {
        T t;
        synchronized (this.a) {
            if (!c()) {
                throw new IllegalStateException("Result is not ready");
            }
            a();
            t = this.e;
            this.f = true;
            this.e = null;
            this.d = null;
        }
        return t;
    }

    @Override // com.samsung.android.sdk.healthdata.HealthResultHolder
    public final T await() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return (T) awaitAllowingMainThread();
        }
        throw new IllegalStateException("await() must not be called on the main thread");
    }

    public final T awaitAllowingMainThread() throws InterruptedException {
        a();
        try {
            this.c.await();
        } catch (InterruptedException unused) {
            d();
        }
        if (c()) {
            return (T) acquireResult();
        }
        throw new IllegalStateException("Result is not ready");
    }

    @Override // com.samsung.android.sdk.healthdata.HealthResultHolder
    public final void cancel() {
        synchronized (this.a) {
            if (this.g || this.f) {
                return;
            }
            try {
                cancelResult();
            } catch (RemoteException e) {
                Log.d("Health.ResultHolder", e.toString());
            }
            this.d = null;
            this.g = true;
        }
    }

    protected void cancelResult() throws RemoteException {
    }

    @Override // com.samsung.android.sdk.internal.healthdata.RemoteResultListener
    public void onReceiveHealthResult(int i, T t) {
        setResult(t);
    }

    public final void setResult(T t) {
        synchronized (this.a) {
            if (!this.h && !this.g) {
                if (c()) {
                    throw new IllegalStateException("Result have been set already");
                }
                a();
                this.e = t;
                this.c.countDown();
                HealthResultHolder.ResultListener<T> resultListener = this.d;
                if (resultListener != null && !this.g) {
                    a<T> aVar = this.b;
                    HealthResultHolder.BaseResult baseResultAcquireResult = acquireResult();
                    if (aVar == null) {
                        throw null;
                    }
                    aVar.sendMessage(aVar.obtainMessage(1, new Pair(resultListener, baseResultAcquireResult)));
                }
            }
        }
    }

    @Override // com.samsung.android.sdk.healthdata.HealthResultHolder
    public final void setResultListener(HealthResultHolder.ResultListener<T> resultListener) {
        a();
        synchronized (this.a) {
            if (b()) {
                return;
            }
            if (c()) {
                a<T> aVar = this.b;
                HealthResultHolder.BaseResult baseResultAcquireResult = acquireResult();
                if (aVar == null) {
                    throw null;
                }
                aVar.sendMessage(aVar.obtainMessage(1, new Pair(resultListener, baseResultAcquireResult)));
            } else {
                this.d = resultListener;
            }
        }
    }
}
