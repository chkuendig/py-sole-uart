package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* loaded from: classes2.dex */
public final class OnSubscribeRange implements Observable.OnSubscribe<Integer> {
    private final int endIndex;
    private final int startIndex;

    public OnSubscribeRange(int i, int i2) {
        this.startIndex = i;
        this.endIndex = i2;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super Integer> subscriber) {
        subscriber.setProducer(new RangeProducer(subscriber, this.startIndex, this.endIndex));
    }

    private static final class RangeProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = 4114392207069098388L;
        private final Subscriber<? super Integer> childSubscriber;
        private long currentIndex;
        private final int endOfRange;

        RangeProducer(Subscriber<? super Integer> subscriber, int i, int i2) {
            this.childSubscriber = subscriber;
            this.currentIndex = i;
            this.endOfRange = i2;
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

        /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
        
            r12.currentIndex = r4;
            r13 = addAndGet(-r9);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void slowpath(long j) {
            long j2 = this.endOfRange + 1;
            long j3 = this.currentIndex;
            Subscriber<? super Integer> subscriber = this.childSubscriber;
            do {
                long j4 = 0;
                while (true) {
                    if (j4 != j && j3 != j2) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        subscriber.onNext(Integer.valueOf((int) j3));
                        j3++;
                        j4++;
                    } else {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        if (j3 == j2) {
                            subscriber.onCompleted();
                            return;
                        } else {
                            j = get();
                            if (j == j4) {
                                break;
                            }
                        }
                    }
                }
            } while (j != 0);
        }

        void fastpath() {
            long j = this.endOfRange + 1;
            Subscriber<? super Integer> subscriber = this.childSubscriber;
            for (long j2 = this.currentIndex; j2 != j; j2++) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onNext(Integer.valueOf((int) j2));
            }
            if (subscriber.isUnsubscribed()) {
                return;
            }
            subscriber.onCompleted();
        }
    }
}
