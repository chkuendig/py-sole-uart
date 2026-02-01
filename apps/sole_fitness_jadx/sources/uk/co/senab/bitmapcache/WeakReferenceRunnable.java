package uk.co.senab.bitmapcache;

import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
abstract class WeakReferenceRunnable<T> implements Runnable {
    private final WeakReference<T> mObjectRef;

    public abstract void run(T t);

    public WeakReferenceRunnable(T t) {
        this.mObjectRef = new WeakReference<>(t);
    }

    @Override // java.lang.Runnable
    public final void run() {
        T t = this.mObjectRef.get();
        if (t != null) {
            run(t);
        }
    }
}
