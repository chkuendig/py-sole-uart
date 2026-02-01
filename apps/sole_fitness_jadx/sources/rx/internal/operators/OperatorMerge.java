package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.Pow2;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

/* loaded from: classes2.dex */
public final class OperatorMerge<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayErrors;
    final int maxConcurrent;

    private static final class HolderNoDelay {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(false, Integer.MAX_VALUE);

        private HolderNoDelay() {
        }
    }

    private static final class HolderDelayErrors {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(true, Integer.MAX_VALUE);

        private HolderDelayErrors() {
        }
    }

    public static <T> OperatorMerge<T> instance(boolean z) {
        if (z) {
            return (OperatorMerge<T>) HolderDelayErrors.INSTANCE;
        }
        return (OperatorMerge<T>) HolderNoDelay.INSTANCE;
    }

    public static <T> OperatorMerge<T> instance(boolean z, int i) {
        if (i > 0) {
            if (i == Integer.MAX_VALUE) {
                return instance(z);
            }
            return new OperatorMerge<>(z, i);
        }
        throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i);
    }

    OperatorMerge(boolean z, int i) {
        this.delayErrors = z;
        this.maxConcurrent = i;
    }

    @Override // rx.functions.Func1
    public Subscriber<Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        MergeSubscriber mergeSubscriber = new MergeSubscriber(subscriber, this.delayErrors, this.maxConcurrent);
        MergeProducer<T> mergeProducer = new MergeProducer<>(mergeSubscriber);
        mergeSubscriber.producer = mergeProducer;
        subscriber.add(mergeSubscriber);
        subscriber.setProducer(mergeProducer);
        return mergeSubscriber;
    }

    static final class MergeProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1214379189873595503L;
        final MergeSubscriber<T> subscriber;

        public MergeProducer(MergeSubscriber<T> mergeSubscriber) {
            this.subscriber = mergeSubscriber;
        }

        @Override // rx.Producer
        public void request(long j) throws Throwable {
            if (j <= 0) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            } else {
                if (get() == Long.MAX_VALUE) {
                    return;
                }
                BackpressureUtils.getAndAddRequest(this, j);
                this.subscriber.emit();
            }
        }

        public long produced(int i) {
            return addAndGet(-i);
        }
    }

    static final class MergeSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final InnerSubscriber<?>[] EMPTY = new InnerSubscriber[0];
        final Subscriber<? super T> child;
        final boolean delayErrors;
        volatile boolean done;
        boolean emitting;
        volatile ConcurrentLinkedQueue<Throwable> errors;
        long lastId;
        int lastIndex;
        final int maxConcurrent;
        boolean missed;
        MergeProducer<T> producer;
        volatile Queue<Object> queue;
        int scalarEmissionCount;
        final int scalarEmissionLimit;
        volatile CompositeSubscription subscriptions;
        long uniqueId;
        final NotificationLite<T> nl = NotificationLite.instance();
        final Object innerGuard = new Object();
        volatile InnerSubscriber<?>[] innerSubscribers = EMPTY;

        public MergeSubscriber(Subscriber<? super T> subscriber, boolean z, int i) {
            this.child = subscriber;
            this.delayErrors = z;
            this.maxConcurrent = i;
            if (i == Integer.MAX_VALUE) {
                this.scalarEmissionLimit = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
            } else {
                this.scalarEmissionLimit = Math.max(1, i >> 1);
                request(i);
            }
        }

        Queue<Throwable> getOrCreateErrorQueue() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.errors;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.errors = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        CompositeSubscription getOrCreateComposite() {
            CompositeSubscription compositeSubscription;
            CompositeSubscription compositeSubscription2 = this.subscriptions;
            if (compositeSubscription2 != null) {
                return compositeSubscription2;
            }
            boolean z = false;
            synchronized (this) {
                compositeSubscription = this.subscriptions;
                if (compositeSubscription == null) {
                    CompositeSubscription compositeSubscription3 = new CompositeSubscription();
                    this.subscriptions = compositeSubscription3;
                    compositeSubscription = compositeSubscription3;
                    z = true;
                }
            }
            if (z) {
                add(compositeSubscription);
            }
            return compositeSubscription;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public void onNext(Observable<? extends T> observable) throws Throwable {
            if (observable == null) {
                return;
            }
            if (observable == Observable.empty()) {
                emitEmpty();
                return;
            }
            if (observable instanceof ScalarSynchronousObservable) {
                tryEmit(((ScalarSynchronousObservable) observable).get());
                return;
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
            addInner(innerSubscriber);
            observable.unsafeSubscribe(innerSubscriber);
            emit();
        }

        void emitEmpty() {
            int i = this.scalarEmissionCount + 1;
            if (i == this.scalarEmissionLimit) {
                this.scalarEmissionCount = 0;
                requestMore(i);
            } else {
                this.scalarEmissionCount = i;
            }
        }

        private void reportError() {
            ArrayList arrayList = new ArrayList(this.errors);
            if (arrayList.size() == 1) {
                this.child.onError((Throwable) arrayList.get(0));
            } else {
                this.child.onError(new CompositeException(arrayList));
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) throws Throwable {
            getOrCreateErrorQueue().offer(th);
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onCompleted() throws Throwable {
            this.done = true;
            emit();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void addInner(InnerSubscriber<T> innerSubscriber) {
            getOrCreateComposite().add(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
                this.innerSubscribers = innerSubscriberArr2;
            }
        }

        void removeInner(InnerSubscriber<T> innerSubscriber) {
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer != null) {
                rxRingBuffer.release();
            }
            this.subscriptions.remove(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerSubscriber.equals(innerSubscriberArr[i2])) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    this.innerSubscribers = EMPTY;
                    return;
                }
                InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[length - 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, i);
                System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr2, i, (length - i) - 1);
                this.innerSubscribers = innerSubscriberArr2;
            }
        }

        void tryEmit(InnerSubscriber<T> innerSubscriber, T t) throws Throwable {
            long j = this.producer.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.producer.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            }
            if (z) {
                emitScalar(innerSubscriber, t, j);
            } else {
                queueScalar(innerSubscriber, t);
            }
        }

        protected void queueScalar(InnerSubscriber<T> innerSubscriber, T t) throws Throwable {
            RxRingBuffer spscInstance = innerSubscriber.queue;
            if (spscInstance == null) {
                spscInstance = RxRingBuffer.getSpscInstance();
                innerSubscriber.add(spscInstance);
                innerSubscriber.queue = spscInstance;
            }
            try {
                spscInstance.onNext(this.nl.next(t));
                emit();
            } catch (IllegalStateException e) {
                if (innerSubscriber.isUnsubscribed()) {
                    return;
                }
                innerSubscriber.unsubscribe();
                innerSubscriber.onError(e);
            } catch (MissingBackpressureException e2) {
                innerSubscriber.unsubscribe();
                innerSubscriber.onError(e2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x004a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void emitScalar(InnerSubscriber<T> innerSubscriber, T t, long j) throws Throwable {
            boolean z = true;
            try {
                try {
                    try {
                        this.child.onNext(t);
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (!z) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (!this.delayErrors) {
                        Exceptions.throwIfFatal(th2);
                        innerSubscriber.unsubscribe();
                        innerSubscriber.onError(th2);
                        return;
                    }
                    getOrCreateErrorQueue().offer(th2);
                }
                if (j != Long.MAX_VALUE) {
                    this.producer.produced(1);
                }
                innerSubscriber.requestMore(1L);
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                    } else {
                        this.missed = false;
                        emitLoop();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (!z) {
                }
                throw th;
            }
        }

        public void requestMore(long j) {
            request(j);
        }

        void tryEmit(T t) throws Throwable {
            long j = this.producer.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.producer.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            }
            if (z) {
                emitScalar(t, j);
            } else {
                queueScalar(t);
            }
        }

        protected void queueScalar(T t) throws Throwable {
            Queue<Object> spscExactAtomicArrayQueue;
            Queue<Object> spscUnboundedAtomicArrayQueue = this.queue;
            if (spscUnboundedAtomicArrayQueue == null) {
                int i = this.maxConcurrent;
                if (i == Integer.MAX_VALUE) {
                    spscUnboundedAtomicArrayQueue = new SpscUnboundedAtomicArrayQueue<>(RxRingBuffer.SIZE);
                } else {
                    if (Pow2.isPowerOfTwo(i)) {
                        if (UnsafeAccess.isUnsafeAvailable()) {
                            spscExactAtomicArrayQueue = new SpscArrayQueue<>(i);
                        } else {
                            spscExactAtomicArrayQueue = new SpscAtomicArrayQueue<>(i);
                        }
                    } else {
                        spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i);
                    }
                    spscUnboundedAtomicArrayQueue = spscExactAtomicArrayQueue;
                }
                this.queue = spscUnboundedAtomicArrayQueue;
            }
            if (!spscUnboundedAtomicArrayQueue.offer(this.nl.next(t))) {
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
            } else {
                emit();
            }
        }

        protected void emitScalar(T t, long j) throws Throwable {
            boolean z = true;
            try {
                try {
                    try {
                        this.child.onNext(t);
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (!z) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (!this.delayErrors) {
                        Exceptions.throwIfFatal(th2);
                        unsubscribe();
                        onError(th2);
                        return;
                    }
                    getOrCreateErrorQueue().offer(th2);
                }
                if (j != Long.MAX_VALUE) {
                    this.producer.produced(1);
                }
                int i = this.scalarEmissionCount + 1;
                if (i == this.scalarEmissionLimit) {
                    this.scalarEmissionCount = 0;
                    requestMore(i);
                } else {
                    this.scalarEmissionCount = i;
                }
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                    } else {
                        this.missed = false;
                        emitLoop();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        void emit() throws Throwable {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                } else {
                    this.emitting = true;
                    emitLoop();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0076, code lost:
        
            if (r7 <= 0) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
        
            if (r10 == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007a, code lost:
        
            r16 = Long.MAX_VALUE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
        
            r16 = r23.producer.produced(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x008a, code lost:
        
            if (r16 == 0) goto L196;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x008c, code lost:
        
            if (r0 != null) goto L45;
         */
        /* JADX WARN: Removed duplicated region for block: B:159:0x01ac  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void emitLoop() throws Throwable {
            boolean z;
            long jProduced;
            int i;
            boolean z2;
            try {
                Subscriber<? super T> subscriber = this.child;
                while (!checkTerminate()) {
                    Queue<Object> queue = this.queue;
                    long j = this.producer.get();
                    boolean z3 = j == Long.MAX_VALUE;
                    if (queue != null) {
                        int i2 = 0;
                        while (true) {
                            jProduced = j;
                            i = i2;
                            int i3 = 0;
                            Object obj = null;
                            while (true) {
                                if (jProduced <= 0) {
                                    break;
                                }
                                Object objPoll = queue.poll();
                                if (checkTerminate()) {
                                    return;
                                }
                                if (objPoll == null) {
                                    obj = objPoll;
                                    break;
                                }
                                try {
                                    subscriber.onNext(this.nl.getValue(objPoll));
                                } catch (Throwable th) {
                                    if (!this.delayErrors) {
                                        Exceptions.throwIfFatal(th);
                                        unsubscribe();
                                        subscriber.onError(th);
                                        return;
                                    }
                                    getOrCreateErrorQueue().offer(th);
                                }
                                i++;
                                i3++;
                                jProduced--;
                                obj = objPoll;
                            }
                            i2 = i;
                            j = jProduced;
                        }
                    } else {
                        jProduced = j;
                        i = 0;
                    }
                    boolean z4 = this.done;
                    Queue<Object> queue2 = this.queue;
                    InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                    int length = innerSubscriberArr.length;
                    if (z4 && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
                        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                            reportError();
                            return;
                        }
                        subscriber.onCompleted();
                        return;
                    }
                    if (length > 0) {
                        long j2 = this.lastId;
                        int i4 = this.lastIndex;
                        if (length <= i4 || innerSubscriberArr[i4].id != j2) {
                            if (length <= i4) {
                                i4 = 0;
                            }
                            for (int i5 = 0; i5 < length && innerSubscriberArr[i4].id != j2; i5++) {
                                i4++;
                                if (i4 == length) {
                                    i4 = 0;
                                }
                            }
                            this.lastIndex = i4;
                            this.lastId = innerSubscriberArr[i4].id;
                        }
                        z2 = false;
                        for (int i6 = 0; i6 < length; i6++) {
                            if (checkTerminate()) {
                                return;
                            }
                            InnerSubscriber<?> innerSubscriber = innerSubscriberArr[i4];
                            Object objPoll2 = null;
                            do {
                                int i7 = 0;
                                while (jProduced > 0) {
                                    if (checkTerminate()) {
                                        return;
                                    }
                                    RxRingBuffer rxRingBuffer = innerSubscriber.queue;
                                    if (rxRingBuffer == null || (objPoll2 = rxRingBuffer.poll()) == null) {
                                        break;
                                    }
                                    try {
                                        try {
                                            subscriber.onNext(this.nl.getValue(objPoll2));
                                            jProduced--;
                                            i7++;
                                        } catch (Throwable th2) {
                                            Exceptions.throwIfFatal(th2);
                                            try {
                                                subscriber.onError(th2);
                                                return;
                                            } finally {
                                                unsubscribe();
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        z = true;
                                        if (!z) {
                                        }
                                        throw th;
                                    }
                                }
                                if (i7 > 0) {
                                    jProduced = !z3 ? this.producer.produced(i7) : Long.MAX_VALUE;
                                    innerSubscriber.requestMore(i7);
                                }
                                if (jProduced == 0) {
                                    break;
                                }
                            } while (objPoll2 != null);
                            boolean z5 = innerSubscriber.done;
                            RxRingBuffer rxRingBuffer2 = innerSubscriber.queue;
                            if (z5 && (rxRingBuffer2 == null || rxRingBuffer2.isEmpty())) {
                                removeInner(innerSubscriber);
                                if (checkTerminate()) {
                                    return;
                                }
                                i++;
                                z2 = true;
                            }
                            if (jProduced == 0) {
                                break;
                            }
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                        }
                        this.lastIndex = i4;
                        this.lastId = innerSubscriberArr[i4].id;
                    } else {
                        z2 = false;
                    }
                    if (i > 0) {
                        request(i);
                    }
                    if (!z2) {
                        synchronized (this) {
                            try {
                                if (!this.missed) {
                                    try {
                                        this.emitting = false;
                                        return;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        z = true;
                                        while (true) {
                                            try {
                                                break;
                                            } catch (Throwable th5) {
                                                th = th5;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                this.missed = false;
                            } catch (Throwable th6) {
                                th = th6;
                                z = false;
                            }
                        }
                        try {
                            break;
                            throw th;
                        } catch (Throwable th7) {
                            th = th7;
                            if (!z) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                z = false;
            }
        }

        boolean checkTerminate() {
            if (this.child.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (this.delayErrors || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                reportError();
                return true;
            } finally {
                unsubscribe();
            }
        }
    }

    static final class InnerSubscriber<T> extends Subscriber<T> {
        static final int limit = RxRingBuffer.SIZE / 4;
        volatile boolean done;
        final long id;
        int outstanding;
        final MergeSubscriber<T> parent;
        volatile RxRingBuffer queue;

        public InnerSubscriber(MergeSubscriber<T> mergeSubscriber, long j) {
            this.parent = mergeSubscriber;
            this.id = j;
        }

        @Override // rx.Subscriber
        public void onStart() {
            this.outstanding = RxRingBuffer.SIZE;
            request(RxRingBuffer.SIZE);
        }

        @Override // rx.Observer
        public void onNext(T t) throws Throwable {
            this.parent.tryEmit(this, t);
        }

        @Override // rx.Observer
        public void onError(Throwable th) throws Throwable {
            this.done = true;
            this.parent.getOrCreateErrorQueue().offer(th);
            this.parent.emit();
        }

        @Override // rx.Observer
        public void onCompleted() throws Throwable {
            this.done = true;
            this.parent.emit();
        }

        public void requestMore(long j) {
            int i = this.outstanding - ((int) j);
            if (i > limit) {
                this.outstanding = i;
                return;
            }
            this.outstanding = RxRingBuffer.SIZE;
            int i2 = RxRingBuffer.SIZE - i;
            if (i2 > 0) {
                request(i2);
            }
        }
    }
}
