package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferedChannel;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: Channel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016R\t\u0010\u0007\u001a\u00020\bX\u0082\u0004R\u0011\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/reactive/SubscriptionChannel;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/BufferedChannel;", "Lorg/reactivestreams/Subscriber;", "request", "", "(I)V", "_requested", "Lkotlinx/atomicfu/AtomicInt;", "_subscription", "Lkotlinx/atomicfu/AtomicRef;", "Lorg/reactivestreams/Subscription;", "onClosedIdempotent", "", "onComplete", "onError", "e", "", "onNext", "t", "(Ljava/lang/Object;)V", "onReceiveDequeued", "onReceiveEnqueued", "onSubscribe", "s", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
final class SubscriptionChannel<T> extends BufferedChannel<T> implements Subscriber<T> {
    private volatile /* synthetic */ int _requested$volatile;
    private volatile /* synthetic */ Object _subscription$volatile;
    private final int request;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _subscription$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SubscriptionChannel.class, Object.class, "_subscription$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _requested$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(SubscriptionChannel.class, "_requested$volatile");

    private final /* synthetic */ int get_requested$volatile() {
        return this._requested$volatile;
    }

    private final /* synthetic */ Object get_subscription$volatile() {
        return this._subscription$volatile;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function1) {
        while (true) {
            function1.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void set_requested$volatile(int i) {
        this._requested$volatile = i;
    }

    private final /* synthetic */ void set_subscription$volatile(Object obj) {
        this._subscription$volatile = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscriptionChannel(int i) {
        super(Integer.MAX_VALUE, null, 2, 0 == true ? 1 : 0);
        this.request = i;
        if (i < 0) {
            throw new IllegalArgumentException(("Invalid request size: " + i).toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
    
        r2.request(r6.request - r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        return;
     */
    @Override // kotlinx.coroutines.channels.BufferedChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceiveEnqueued() {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = get_requested$volatile$FU()
        L4:
            int r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = get_subscription$volatile$FU()
            java.lang.Object r2 = r2.get(r6)
            org.reactivestreams.Subscription r2 = (org.reactivestreams.Subscription) r2
            int r3 = r1 + (-1)
            if (r2 == 0) goto L31
            if (r3 >= 0) goto L31
            int r4 = r6.request
            if (r1 == r4) goto L29
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = get_requested$volatile$FU()
            int r5 = r6.request
            boolean r1 = r4.compareAndSet(r6, r1, r5)
            if (r1 != 0) goto L29
            goto L4
        L29:
            int r0 = r6.request
            int r0 = r0 - r3
            long r0 = (long) r0
            r2.request(r0)
            return
        L31:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = get_requested$volatile$FU()
            boolean r1 = r2.compareAndSet(r6, r1, r3)
            if (r1 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.SubscriptionChannel.onReceiveEnqueued():void");
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void onReceiveDequeued() {
        _requested$volatile$FU.incrementAndGet(this);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void onClosedIdempotent() {
        Subscription subscription = (Subscription) _subscription$volatile$FU.getAndSet(this, null);
        if (subscription != null) {
            subscription.cancel();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription s) {
        _subscription$volatile$FU.set(this, s);
        while (!isClosedForSend()) {
            int i = _requested$volatile$FU.get(this);
            if (i >= this.request) {
                return;
            }
            if (_requested$volatile$FU.compareAndSet(this, i, this.request)) {
                s.request(this.request - i);
                return;
            }
        }
        s.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        _requested$volatile$FU.decrementAndGet(this);
        mo10590trySendJP2dKIU(t);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        close(null);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable e) {
        close(e);
    }
}
