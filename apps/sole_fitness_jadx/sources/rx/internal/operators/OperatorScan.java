package rx.internal.operators;

import android.R;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;

/* loaded from: classes2.dex */
public final class OperatorScan<R, T> implements Observable.Operator<R, T> {
    private static final Object NO_INITIAL_VALUE = new Object();
    final Func2<R, ? super T, R> accumulator;
    private final Func0<R> initialValueFactory;

    public OperatorScan(final R r, Func2<R, ? super T, R> func2) {
        this((Func0) new Func0<R>() { // from class: rx.internal.operators.OperatorScan.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public R call() {
                return (R) r;
            }
        }, (Func2) func2);
    }

    public OperatorScan(Func0<R> func0, Func2<R, ? super T, R> func2) {
        this.initialValueFactory = func0;
        this.accumulator = func2;
    }

    public OperatorScan(Func2<R, ? super T, R> func2) {
        this(NO_INITIAL_VALUE, func2);
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super R> subscriber) {
        R rCall = this.initialValueFactory.call();
        if (rCall == NO_INITIAL_VALUE) {
            return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorScan.2
                boolean once;
                R value;

                @Override // rx.Observer
                public void onNext(T t) {
                    if (!this.once) {
                        this.once = true;
                    } else {
                        try {
                            t = OperatorScan.this.accumulator.call(this.value, t);
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, subscriber, t);
                            return;
                        }
                    }
                    this.value = (R) t;
                    subscriber.onNext(t);
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    subscriber.onError(th);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    subscriber.onCompleted();
                }
            };
        }
        InitialProducer initialProducer = new InitialProducer(rCall, subscriber);
        Subscriber<T> subscriber2 = new Subscriber<T>(rCall, initialProducer) { // from class: rx.internal.operators.OperatorScan.3
            final /* synthetic */ Object val$initialValue;
            final /* synthetic */ InitialProducer val$ip;
            private R value;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.val$initialValue = rCall;
                this.val$ip = initialProducer;
                this.value = rCall;
            }

            @Override // rx.Observer
            public void onNext(T t) {
                try {
                    R rCall2 = OperatorScan.this.accumulator.call(this.value, t);
                    this.value = rCall2;
                    this.val$ip.onNext(rCall2);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this, t);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                this.val$ip.onError(th);
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.val$ip.onCompleted();
            }

            @Override // rx.Subscriber
            public void setProducer(Producer producer) {
                this.val$ip.setProducer(producer);
            }
        };
        subscriber.add(subscriber2);
        subscriber.setProducer(initialProducer);
        return subscriber2;
    }

    static final class InitialProducer<R> implements Producer, Observer<R> {
        final Subscriber<? super R> child;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        boolean missed;
        long missedRequested;
        volatile Producer producer;
        final Queue<Object> queue;
        final AtomicLong requested;

        public InitialProducer(R r, Subscriber<? super R> subscriber) {
            Queue<Object> spscLinkedAtomicQueue;
            this.child = subscriber;
            if (UnsafeAccess.isUnsafeAvailable()) {
                spscLinkedAtomicQueue = new SpscLinkedQueue<>();
            } else {
                spscLinkedAtomicQueue = new SpscLinkedAtomicQueue<>();
            }
            this.queue = spscLinkedAtomicQueue;
            spscLinkedAtomicQueue.offer(NotificationLite.instance().next(r));
            this.requested = new AtomicLong();
        }

        @Override // rx.Observer
        public void onNext(R r) {
            this.queue.offer(NotificationLite.instance().next(r));
            emit();
        }

        boolean checkTerminated(boolean z, boolean z2, Subscriber<? super R> subscriber) {
            if (subscriber.isUnsubscribed()) {
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                subscriber.onError(th);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onCompleted();
            return true;
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            emit();
        }

        @Override // rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            }
            if (j != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                Producer producer = this.producer;
                if (producer == null) {
                    synchronized (this.requested) {
                        producer = this.producer;
                        if (producer == null) {
                            this.missedRequested = BackpressureUtils.addCap(this.missedRequested, j);
                        }
                    }
                }
                if (producer != null) {
                    producer.request(j);
                }
                emit();
            }
        }

        public void setProducer(Producer producer) {
            long j;
            Objects.requireNonNull(producer);
            synchronized (this.requested) {
                if (this.producer != null) {
                    throw new IllegalStateException("Can't set more than one Producer!");
                }
                j = this.missedRequested;
                if (j != Long.MAX_VALUE) {
                    j--;
                }
                this.missedRequested = 0L;
                this.producer = producer;
            }
            if (j > 0) {
                producer.request(j);
            }
            emit();
        }

        void emit() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                } else {
                    this.emitting = true;
                    emitLoop();
                }
            }
        }

        void emitLoop() {
            Subscriber<? super R> subscriber = this.child;
            Queue<Object> queue = this.queue;
            NotificationLite notificationLiteInstance = NotificationLite.instance();
            AtomicLong atomicLong = this.requested;
            long jAddAndGet = atomicLong.get();
            while (true) {
                boolean z = jAddAndGet == Long.MAX_VALUE;
                if (checkTerminated(this.done, queue.isEmpty(), subscriber)) {
                    return;
                }
                long j = 0;
                while (jAddAndGet != 0) {
                    boolean z2 = this.done;
                    Object objPoll = queue.poll();
                    boolean z3 = objPoll == null;
                    if (checkTerminated(z2, z3, subscriber)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    R.bool boolVar = (Object) notificationLiteInstance.getValue(objPoll);
                    try {
                        subscriber.onNext(boolVar);
                        jAddAndGet--;
                        j--;
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, subscriber, boolVar);
                        return;
                    }
                }
                if (j != 0 && !z) {
                    jAddAndGet = atomicLong.addAndGet(j);
                }
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                        return;
                    }
                    this.missed = false;
                }
            }
        }
    }
}
