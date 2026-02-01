package rx.internal.operators;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements Observable.OnSubscribe<T> {
    final Iterable<? extends T> is;

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable, "iterable must not be null");
        this.is = iterable;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        try {
            Iterator<? extends T> it = this.is.iterator();
            boolean zHasNext = it.hasNext();
            if (subscriber.isUnsubscribed()) {
                return;
            }
            if (!zHasNext) {
                subscriber.onCompleted();
            } else {
                subscriber.setProducer(new IterableProducer(subscriber, it));
            }
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, subscriber);
        }
    }

    static final class IterableProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;
        private final Iterator<? extends T> it;
        private final Subscriber<? super T> o;

        IterableProducer(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            this.o = subscriber;
            this.it = it;
        }

        @Override // rx.Producer
        public void request(long j) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastpath();
            } else {
                if (j <= 0 || BackpressureUtils.getAndAddRequest(this, j) != 0) {
                    return;
                }
                slowpath(j);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
        
            r9 = rx.internal.operators.BackpressureUtils.produced(r8, r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void slowpath(long j) {
            Subscriber<? super T> subscriber = this.o;
            Iterator<? extends T> it = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        try {
                            subscriber.onNext(it.next());
                            if (subscriber.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (subscriber.isUnsubscribed()) {
                                        return;
                                    }
                                    subscriber.onCompleted();
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                Exceptions.throwOrReport(th, subscriber);
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwOrReport(th2, subscriber);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            break;
                        }
                    }
                }
            } while (j != 0);
        }

        void fastpath() {
            Subscriber<? super T> subscriber = this.o;
            Iterator<? extends T> it = this.it;
            while (!subscriber.isUnsubscribed()) {
                try {
                    subscriber.onNext(it.next());
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (subscriber.isUnsubscribed()) {
                                return;
                            }
                            subscriber.onCompleted();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, subscriber);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, subscriber);
                    return;
                }
            }
        }
    }
}
