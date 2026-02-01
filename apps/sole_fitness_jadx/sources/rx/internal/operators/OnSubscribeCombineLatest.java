package rx.internal.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.FuncN;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class OnSubscribeCombineLatest<T, R> implements Observable.OnSubscribe<R> {
    final int bufferSize;
    final FuncN<? extends R> combiner;
    final boolean delayError;
    final Observable<? extends T>[] sources;
    final Iterable<? extends Observable<? extends T>> sourcesIterable;

    public OnSubscribeCombineLatest(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        this(null, iterable, funcN, RxRingBuffer.SIZE, false);
    }

    public OnSubscribeCombineLatest(Observable<? extends T>[] observableArr, Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN, int i, boolean z) {
        this.sources = observableArr;
        this.sourcesIterable = iterable;
        this.combiner = funcN;
        this.bufferSize = i;
        this.delayError = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    @Override // rx.functions.Action1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void call(Subscriber<? super R> subscriber) {
        int length;
        int i;
        Observable<? extends T>[] observableArr = this.sources;
        if (observableArr == null) {
            Iterable<? extends Observable<? extends T>> iterable = this.sourcesIterable;
            if (iterable instanceof List) {
                List list = (List) iterable;
                observableArr = (Observable[]) list.toArray(new Observable[list.size()]);
                length = observableArr.length;
            } else {
                Observable<? extends T>[] observableArr2 = new Observable[8];
                int i2 = 0;
                for (Observable<? extends T> observable : iterable) {
                    if (i2 == observableArr2.length) {
                        Observable<? extends T>[] observableArr3 = new Observable[(i2 >> 2) + i2];
                        System.arraycopy(observableArr2, 0, observableArr3, 0, i2);
                        observableArr2 = observableArr3;
                    }
                    observableArr2[i2] = observable;
                    i2++;
                }
                observableArr = observableArr2;
                i = i2;
                if (i != 0) {
                    subscriber.onCompleted();
                    return;
                } else {
                    new LatestCoordinator(subscriber, this.combiner, i, this.bufferSize, this.delayError).subscribe(observableArr);
                    return;
                }
            }
        } else {
            length = observableArr.length;
        }
        i = length;
        if (i != 0) {
        }
    }

    static final class LatestCoordinator<T, R> extends AtomicInteger implements Producer, Subscription {
        static final Object MISSING = new Object();
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final Subscriber<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final FuncN<? extends R> combiner;
        int complete;
        final int count;
        final boolean delayError;
        volatile boolean done;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested;
        final CombinerSubscriber<T, R>[] subscribers;

        public LatestCoordinator(Subscriber<? super R> subscriber, FuncN<? extends R> funcN, int i, int i2, boolean z) {
            this.actual = subscriber;
            this.combiner = funcN;
            this.count = i;
            this.bufferSize = i2;
            this.delayError = z;
            Object[] objArr = new Object[i];
            this.latest = objArr;
            Arrays.fill(objArr, MISSING);
            this.subscribers = new CombinerSubscriber[i];
            this.queue = new SpscLinkedArrayQueue<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
        }

        public void subscribe(Observable<? extends T>[] observableArr) {
            CombinerSubscriber<T, R>[] combinerSubscriberArr = this.subscribers;
            int length = combinerSubscriberArr.length;
            for (int i = 0; i < length; i++) {
                combinerSubscriberArr[i] = new CombinerSubscriber<>(this, i);
            }
            lazySet(0);
            this.actual.add(this);
            this.actual.setProducer(this);
            for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
                observableArr[i2].subscribe((Subscriber<? super Object>) combinerSubscriberArr[i2]);
            }
        }

        @Override // rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            }
            if (j != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                drain();
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                cancel(this.queue);
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        void cancel(Queue<?> queue) {
            queue.clear();
            for (CombinerSubscriber<T, R> combinerSubscriber : this.subscribers) {
                combinerSubscriber.unsubscribe();
            }
        }

        void combine(Object obj, int i) {
            boolean z;
            CombinerSubscriber<T, R> combinerSubscriber = this.subscribers[i];
            synchronized (this) {
                Object[] objArr = this.latest;
                int length = objArr.length;
                Object obj2 = objArr[i];
                int i2 = this.active;
                Object obj3 = MISSING;
                if (obj2 == obj3) {
                    i2++;
                    this.active = i2;
                }
                int i3 = this.complete;
                if (obj == null) {
                    i3++;
                    this.complete = i3;
                } else {
                    objArr[i] = combinerSubscriber.nl.getValue(obj);
                }
                boolean z2 = false;
                z = i2 == length;
                if (i3 == length || (obj == null && obj2 == obj3)) {
                    z2 = true;
                }
                if (z2) {
                    this.done = true;
                } else if (obj != null && z) {
                    this.queue.offer(combinerSubscriber, this.latest.clone());
                } else if (obj == null && this.error.get() != null && (obj2 == obj3 || !this.delayError)) {
                    this.done = true;
                }
            }
            if (!z && obj != null) {
                combinerSubscriber.requestMore(1L);
            } else {
                drain();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x00a3, code lost:
        
            if (r3 == 0) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a5, code lost:
        
            if (r14 != false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a7, code lost:
        
            r10.addAndGet(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00aa, code lost:
        
            r12 = addAndGet(-r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00af, code lost:
        
            if (r12 != 0) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00b1, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            long j;
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Subscriber<? super R> subscriber = this.actual;
            boolean z = this.delayError;
            AtomicLong atomicLong = this.requested;
            int iAddAndGet = 1;
            while (!checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue, z)) {
                long j2 = atomicLong.get();
                boolean z2 = j2 == Long.MAX_VALUE;
                long j3 = j2;
                long j4 = 0;
                while (true) {
                    if (j3 == 0) {
                        j = j4;
                        break;
                    }
                    boolean z3 = this.done;
                    CombinerSubscriber combinerSubscriber = (CombinerSubscriber) spscLinkedArrayQueue.peek();
                    boolean z4 = combinerSubscriber == null;
                    long j5 = j4;
                    if (checkTerminated(z3, z4, subscriber, spscLinkedArrayQueue, z)) {
                        return;
                    }
                    if (z4) {
                        j = j5;
                        break;
                    }
                    spscLinkedArrayQueue.poll();
                    Object[] objArr = (Object[]) spscLinkedArrayQueue.poll();
                    if (objArr == null) {
                        this.cancelled = true;
                        cancel(spscLinkedArrayQueue);
                        subscriber.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                        return;
                    }
                    try {
                        subscriber.onNext(this.combiner.call(objArr));
                        combinerSubscriber.requestMore(1L);
                        j3--;
                        j4 = j5 - 1;
                    } catch (Throwable th) {
                        this.cancelled = true;
                        cancel(spscLinkedArrayQueue);
                        subscriber.onError(th);
                        return;
                    }
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, Queue<?> queue, boolean z3) {
            if (this.cancelled) {
                cancel(queue);
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.error.get();
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onCompleted();
                }
                return true;
            }
            Throwable th2 = this.error.get();
            if (th2 != null) {
                cancel(queue);
                subscriber.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onCompleted();
            return true;
        }

        void onError(Throwable th) {
            Throwable th2;
            Throwable compositeException;
            AtomicReference<Throwable> atomicReference = this.error;
            do {
                th2 = atomicReference.get();
                if (th2 == null) {
                    compositeException = th;
                } else if (th2 instanceof CompositeException) {
                    ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                    arrayList.add(th);
                    compositeException = new CompositeException(arrayList);
                } else {
                    compositeException = new CompositeException(Arrays.asList(th2, th));
                }
            } while (!atomicReference.compareAndSet(th2, compositeException));
        }
    }

    static final class CombinerSubscriber<T, R> extends Subscriber<T> {
        boolean done;
        final int index;
        final NotificationLite<T> nl = NotificationLite.instance();
        final LatestCoordinator<T, R> parent;

        public CombinerSubscriber(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.parent = latestCoordinator;
            this.index = i;
            request(latestCoordinator.bufferSize);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.parent.combine(this.nl.next(t), this.index);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.getInstance().getErrorHandler().handleError(th);
                return;
            }
            this.parent.onError(th);
            this.done = true;
            this.parent.combine(null, this.index);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.combine(null, this.index);
        }

        public void requestMore(long j) {
            request(j);
        }
    }
}
