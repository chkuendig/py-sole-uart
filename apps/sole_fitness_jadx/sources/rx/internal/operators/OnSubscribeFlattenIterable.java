package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func1;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.RxJavaPluginUtils;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

/* loaded from: classes2.dex */
public final class OnSubscribeFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
    final Func1<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;
    final Observable<? extends T> source;

    protected OnSubscribeFlattenIterable(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        this.source = observable;
        this.mapper = func1;
        this.prefetch = i;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        final FlattenIterableSubscriber flattenIterableSubscriber = new FlattenIterableSubscriber(subscriber, this.mapper, this.prefetch);
        subscriber.add(flattenIterableSubscriber);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OnSubscribeFlattenIterable.1
            @Override // rx.Producer
            public void request(long j) {
                flattenIterableSubscriber.requestMore(j);
            }
        });
        this.source.unsafeSubscribe(flattenIterableSubscriber);
    }

    public static <T, R> Observable<R> createFrom(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        if (observable instanceof ScalarSynchronousObservable) {
            return Observable.create(new OnSubscribeScalarFlattenIterable(((ScalarSynchronousObservable) observable).get(), func1));
        }
        return Observable.create(new OnSubscribeFlattenIterable(observable, func1, i));
    }

    static final class FlattenIterableSubscriber<T, R> extends Subscriber<T> {
        Iterator<? extends R> active;
        final Subscriber<? super R> actual;
        volatile boolean done;
        final long limit;
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        long produced;
        final Queue<Object> queue;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicLong requested = new AtomicLong();
        final NotificationLite<T> nl = NotificationLite.instance();

        public FlattenIterableSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
            this.actual = subscriber;
            this.mapper = func1;
            if (i == Integer.MAX_VALUE) {
                this.limit = Long.MAX_VALUE;
                this.queue = new SpscLinkedArrayQueue(RxRingBuffer.SIZE);
            } else {
                this.limit = i - (i >> 2);
                if (UnsafeAccess.isUnsafeAvailable()) {
                    this.queue = new SpscArrayQueue(i);
                } else {
                    this.queue = new SpscAtomicArrayQueue(i);
                }
            }
            request(i);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (!this.queue.offer(this.nl.next(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
            } else {
                drain();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (ExceptionsUtils.addThrowable(this.error, th)) {
                this.done = true;
                drain();
            } else {
                RxJavaPluginUtils.handleException(th);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        void requestMore(long j) {
            if (j > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                drain();
            } else {
                if (j >= 0) {
                    return;
                }
                throw new IllegalStateException("n >= 0 required but it was " + j);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            int i;
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.actual;
            Queue<?> queue = this.queue;
            int iAddAndGet = 1;
            while (true) {
                Iterator<? extends R> it = this.active;
                boolean z = false;
                if (it == null) {
                    boolean z2 = this.done;
                    Object objPoll = queue.poll();
                    boolean z3 = objPoll == null;
                    if (checkTerminated(z2, z3, subscriber, queue)) {
                        return;
                    }
                    if (z3) {
                        i = iAddAndGet;
                    } else {
                        long j = this.produced + 1;
                        i = iAddAndGet;
                        if (j == this.limit) {
                            this.produced = 0L;
                            request(j);
                        } else {
                            this.produced = j;
                        }
                        try {
                            it = this.mapper.call(this.nl.getValue(objPoll)).iterator();
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            onError(th);
                        }
                        if (it.hasNext()) {
                            this.active = it;
                        } else {
                            iAddAndGet = i;
                        }
                    }
                    if (it != null) {
                        long j2 = this.requested.get();
                        long j3 = 0;
                        while (j3 != j2) {
                            if (checkTerminated(this.done, false, subscriber, queue)) {
                                return;
                            }
                            try {
                                subscriber.onNext(it.next());
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.active = null;
                                onError(th2);
                            }
                            if (checkTerminated(this.done, false, subscriber, queue)) {
                                return;
                            }
                            j3++;
                            try {
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                this.active = null;
                                onError(th3);
                            }
                            if (!it.hasNext()) {
                                this.active = null;
                                it = null;
                                break;
                            }
                        }
                        if (j3 == j2) {
                            boolean z4 = this.done;
                            if (queue.isEmpty() && it == null) {
                                z = true;
                            }
                            if (checkTerminated(z4, z, subscriber, queue)) {
                                return;
                            }
                        }
                        if (j3 != 0) {
                            BackpressureUtils.produced(this.requested, j3);
                        }
                        if (it == null) {
                            iAddAndGet = i;
                        }
                    }
                    iAddAndGet = this.wip.addAndGet(-i);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, Queue<?> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                this.active = null;
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.error.get() == null) {
                if (!z2) {
                    return false;
                }
                subscriber.onCompleted();
                return true;
            }
            Throwable thTerminate = ExceptionsUtils.terminate(this.error);
            unsubscribe();
            queue.clear();
            this.active = null;
            subscriber.onError(thTerminate);
            return true;
        }
    }

    static final class OnSubscribeScalarFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        final T value;

        public OnSubscribeScalarFlattenIterable(T t, Func1<? super T, ? extends Iterable<? extends R>> func1) {
            this.value = t;
            this.mapper = func1;
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super R> subscriber) {
            try {
                Iterator<? extends R> it = this.mapper.call(this.value).iterator();
                if (!it.hasNext()) {
                    subscriber.onCompleted();
                } else {
                    subscriber.setProducer(new OnSubscribeFromIterable.IterableProducer(subscriber, it));
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, subscriber, this.value);
            }
        }
    }
}
