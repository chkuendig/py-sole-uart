package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Action0;
import rx.subscriptions.MultipleAssignmentSubscription;

/* loaded from: classes2.dex */
public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOS = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public abstract Worker createWorker();

    public static abstract class Worker implements Subscription {
        public abstract Subscription schedule(Action0 action0);

        public abstract Subscription schedule(Action0 action0, long j, TimeUnit timeUnit);

        public Subscription schedulePeriodically(Action0 action0, long j, long j2, TimeUnit timeUnit) {
            long nanos = timeUnit.toNanos(j2);
            long nanos2 = TimeUnit.MILLISECONDS.toNanos(now());
            long nanos3 = nanos2 + timeUnit.toNanos(j);
            MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
            Action0 action02 = new Action0(nanos2, nanos3, multipleAssignmentSubscription, action0, nanos) { // from class: rx.Scheduler.Worker.1
                long count;
                long lastNowNanos;
                long startInNanos;
                final /* synthetic */ Action0 val$action;
                final /* synthetic */ long val$firstNowNanos;
                final /* synthetic */ long val$firstStartInNanos;
                final /* synthetic */ MultipleAssignmentSubscription val$mas;
                final /* synthetic */ long val$periodInNanos;

                {
                    this.val$firstNowNanos = nanos2;
                    this.val$firstStartInNanos = nanos3;
                    this.val$mas = multipleAssignmentSubscription;
                    this.val$action = action0;
                    this.val$periodInNanos = nanos;
                    this.lastNowNanos = nanos2;
                    this.startInNanos = nanos3;
                }

                @Override // rx.functions.Action0
                public void call() {
                    long j3;
                    if (this.val$mas.isUnsubscribed()) {
                        return;
                    }
                    this.val$action.call();
                    long nanos4 = TimeUnit.MILLISECONDS.toNanos(Worker.this.now());
                    long j4 = Scheduler.CLOCK_DRIFT_TOLERANCE_NANOS + nanos4;
                    long j5 = this.lastNowNanos;
                    if (j4 < j5 || nanos4 >= j5 + this.val$periodInNanos + Scheduler.CLOCK_DRIFT_TOLERANCE_NANOS) {
                        long j6 = this.val$periodInNanos;
                        long j7 = nanos4 + j6;
                        long j8 = this.count + 1;
                        this.count = j8;
                        this.startInNanos = j7 - (j6 * j8);
                        j3 = j7;
                    } else {
                        long j9 = this.startInNanos;
                        long j10 = this.count + 1;
                        this.count = j10;
                        j3 = j9 + (j10 * this.val$periodInNanos);
                    }
                    this.lastNowNanos = nanos4;
                    this.val$mas.set(Worker.this.schedule(this, j3 - nanos4, TimeUnit.NANOSECONDS));
                }
            };
            MultipleAssignmentSubscription multipleAssignmentSubscription2 = new MultipleAssignmentSubscription();
            multipleAssignmentSubscription.set(multipleAssignmentSubscription2);
            multipleAssignmentSubscription2.set(schedule(action02, j, timeUnit));
            return multipleAssignmentSubscription;
        }

        public long now() {
            return System.currentTimeMillis();
        }
    }

    public long now() {
        return System.currentTimeMillis();
    }
}
