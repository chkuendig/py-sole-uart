package rx.subjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
import rx.subscriptions.Subscriptions;

/* loaded from: classes.dex */
final class SubjectSubscriptionManager<T> extends AtomicReference<State<T>> implements Observable.OnSubscribe<T> {
    private static final long serialVersionUID = 6035251036011671568L;
    boolean active;
    volatile Object latest;
    public final NotificationLite<T> nl;
    Action1<SubjectObserver<T>> onAdded;
    Action1<SubjectObserver<T>> onStart;
    Action1<SubjectObserver<T>> onTerminated;

    public SubjectSubscriptionManager() {
        super(State.EMPTY);
        this.active = true;
        this.onStart = Actions.empty();
        this.onAdded = Actions.empty();
        this.onTerminated = Actions.empty();
        this.nl = NotificationLite.instance();
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        SubjectObserver<T> subjectObserver = new SubjectObserver<>(subscriber);
        addUnsubscriber(subscriber, subjectObserver);
        this.onStart.call(subjectObserver);
        if (!subscriber.isUnsubscribed() && add(subjectObserver) && subscriber.isUnsubscribed()) {
            remove(subjectObserver);
        }
    }

    void addUnsubscriber(Subscriber<? super T> subscriber, final SubjectObserver<T> subjectObserver) {
        subscriber.add(Subscriptions.create(new Action0() { // from class: rx.subjects.SubjectSubscriptionManager.1
            @Override // rx.functions.Action0
            public void call() {
                SubjectSubscriptionManager.this.remove(subjectObserver);
            }
        }));
    }

    void setLatest(Object obj) {
        this.latest = obj;
    }

    Object getLatest() {
        return this.latest;
    }

    SubjectObserver<T>[] observers() {
        return get().observers;
    }

    boolean add(SubjectObserver<T> subjectObserver) {
        State<T> state;
        do {
            state = get();
            if (state.terminated) {
                this.onTerminated.call(subjectObserver);
                return false;
            }
        } while (!compareAndSet(state, state.add(subjectObserver)));
        this.onAdded.call(subjectObserver);
        return true;
    }

    void remove(SubjectObserver<T> subjectObserver) {
        State<T> state;
        State<T> stateRemove;
        do {
            state = get();
            if (state.terminated || (stateRemove = state.remove(subjectObserver)) == state) {
                return;
            }
        } while (!compareAndSet(state, stateRemove));
    }

    SubjectObserver<T>[] next(Object obj) {
        setLatest(obj);
        return get().observers;
    }

    SubjectObserver<T>[] terminate(Object obj) {
        setLatest(obj);
        this.active = false;
        if (get().terminated) {
            return State.NO_OBSERVERS;
        }
        return getAndSet(State.TERMINATED).observers;
    }

    protected static final class State<T> {
        static final State EMPTY;
        static final SubjectObserver[] NO_OBSERVERS;
        static final State TERMINATED;
        final SubjectObserver[] observers;
        final boolean terminated;

        static {
            SubjectObserver[] subjectObserverArr = new SubjectObserver[0];
            NO_OBSERVERS = subjectObserverArr;
            TERMINATED = new State(true, subjectObserverArr);
            EMPTY = new State(false, subjectObserverArr);
        }

        public State(boolean z, SubjectObserver[] subjectObserverArr) {
            this.terminated = z;
            this.observers = subjectObserverArr;
        }

        public State add(SubjectObserver subjectObserver) {
            SubjectObserver[] subjectObserverArr = this.observers;
            int length = subjectObserverArr.length;
            SubjectObserver[] subjectObserverArr2 = new SubjectObserver[length + 1];
            System.arraycopy(subjectObserverArr, 0, subjectObserverArr2, 0, length);
            subjectObserverArr2[length] = subjectObserver;
            return new State(this.terminated, subjectObserverArr2);
        }

        public State remove(SubjectObserver subjectObserver) {
            SubjectObserver[] subjectObserverArr = this.observers;
            int length = subjectObserverArr.length;
            if (length == 1 && subjectObserverArr[0] == subjectObserver) {
                return EMPTY;
            }
            if (length == 0) {
                return this;
            }
            int i = length - 1;
            SubjectObserver[] subjectObserverArr2 = new SubjectObserver[i];
            int i2 = 0;
            for (SubjectObserver subjectObserver2 : subjectObserverArr) {
                if (subjectObserver2 != subjectObserver) {
                    if (i2 == i) {
                        return this;
                    }
                    subjectObserverArr2[i2] = subjectObserver2;
                    i2++;
                }
            }
            if (i2 == 0) {
                return EMPTY;
            }
            if (i2 < i) {
                SubjectObserver[] subjectObserverArr3 = new SubjectObserver[i2];
                System.arraycopy(subjectObserverArr2, 0, subjectObserverArr3, 0, i2);
                subjectObserverArr2 = subjectObserverArr3;
            }
            return new State(this.terminated, subjectObserverArr2);
        }
    }

    protected static final class SubjectObserver<T> implements Observer<T> {
        final Subscriber<? super T> actual;
        protected volatile boolean caughtUp;
        boolean emitting;
        boolean fastPath;
        boolean first = true;
        private volatile Object index;
        List<Object> queue;

        public SubjectObserver(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.actual.onCompleted();
        }

        protected void emitNext(Object obj, NotificationLite<T> notificationLite) {
            if (!this.fastPath) {
                synchronized (this) {
                    this.first = false;
                    if (this.emitting) {
                        if (this.queue == null) {
                            this.queue = new ArrayList();
                        }
                        this.queue.add(obj);
                        return;
                    }
                    this.fastPath = true;
                }
            }
            notificationLite.accept(this.actual, obj);
        }

        protected void emitFirst(Object obj, NotificationLite<T> notificationLite) throws Throwable {
            synchronized (this) {
                if (this.first && !this.emitting) {
                    this.first = false;
                    this.emitting = obj != null;
                    if (obj != null) {
                        emitLoop(null, obj, notificationLite);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x001c A[Catch: all -> 0x0017, TryCatch #2 {all -> 0x0017, blocks: (B:5:0x0005, B:6:0x0009, B:8:0x000f, B:12:0x001c, B:13:0x0020), top: B:41:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void emitLoop(List<Object> list, Object obj, NotificationLite<T> notificationLite) throws Throwable {
            boolean z = true;
            boolean z2 = true;
            while (true) {
                if (list != null) {
                    try {
                        Iterator<Object> it = list.iterator();
                        while (it.hasNext()) {
                            accept(it.next(), notificationLite);
                        }
                        if (z2) {
                            accept(obj, notificationLite);
                            z2 = false;
                        }
                        try {
                            synchronized (this) {
                                try {
                                    list = this.queue;
                                    this.queue = null;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z = false;
                    }
                } else {
                    if (z2) {
                    }
                    synchronized (this) {
                    }
                    throw th;
                }
                if (!z) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
                throw th;
            }
        }

        protected void accept(Object obj, NotificationLite<T> notificationLite) {
            if (obj != null) {
                notificationLite.accept(this.actual, obj);
            }
        }

        protected Observer<? super T> getActual() {
            return this.actual;
        }

        public <I> I index() {
            return (I) this.index;
        }

        public void index(Object obj) {
            this.index = obj;
        }
    }
}
