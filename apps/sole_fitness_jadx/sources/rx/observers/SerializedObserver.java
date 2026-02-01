package rx.observers;

import rx.Observer;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;

/* loaded from: classes.dex */
public class SerializedObserver<T> implements Observer<T> {
    private static final int MAX_DRAIN_ITERATION = 1024;
    private final Observer<? super T> actual;
    private boolean emitting;
    private final NotificationLite<T> nl = NotificationLite.instance();
    private FastList queue;
    private volatile boolean terminated;

    static final class FastList {
        Object[] array;
        int size;

        FastList() {
        }

        public void add(Object obj) {
            int i = this.size;
            Object[] objArr = this.array;
            if (objArr == null) {
                objArr = new Object[16];
                this.array = objArr;
            } else if (i == objArr.length) {
                Object[] objArr2 = new Object[(i >> 2) + i];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                this.array = objArr2;
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.size = i + 1;
        }
    }

    public SerializedObserver(Observer<? super T> observer) {
        this.actual = observer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x006d, code lost:
    
        continue;
     */
    @Override // rx.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(T t) {
        if (this.terminated) {
            return;
        }
        synchronized (this) {
            if (this.terminated) {
                return;
            }
            if (this.emitting) {
                FastList fastList = this.queue;
                if (fastList == null) {
                    fastList = new FastList();
                    this.queue = fastList;
                }
                fastList.add(this.nl.next(t));
                return;
            }
            this.emitting = true;
            try {
                this.actual.onNext(t);
                while (true) {
                    for (int i = 0; i < 1024; i++) {
                        synchronized (this) {
                            FastList fastList2 = this.queue;
                            if (fastList2 == null) {
                                this.emitting = false;
                                return;
                            }
                            this.queue = null;
                            for (Object obj : fastList2.array) {
                                if (obj == null) {
                                    break;
                                }
                                try {
                                    if (this.nl.accept(this.actual, obj)) {
                                        this.terminated = true;
                                        return;
                                    }
                                } catch (Throwable th) {
                                    this.terminated = true;
                                    Exceptions.throwIfFatal(th);
                                    this.actual.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                    return;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.terminated = true;
                Exceptions.throwOrReport(th2, this.actual, t);
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        Exceptions.throwIfFatal(th);
        if (this.terminated) {
            return;
        }
        synchronized (this) {
            if (this.terminated) {
                return;
            }
            this.terminated = true;
            if (this.emitting) {
                FastList fastList = this.queue;
                if (fastList == null) {
                    fastList = new FastList();
                    this.queue = fastList;
                }
                fastList.add(this.nl.error(th));
                return;
            }
            this.emitting = true;
            this.actual.onError(th);
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.terminated) {
            return;
        }
        synchronized (this) {
            if (this.terminated) {
                return;
            }
            this.terminated = true;
            if (this.emitting) {
                FastList fastList = this.queue;
                if (fastList == null) {
                    fastList = new FastList();
                    this.queue = fastList;
                }
                fastList.add(this.nl.completed());
                return;
            }
            this.emitting = true;
            this.actual.onCompleted();
        }
    }
}
