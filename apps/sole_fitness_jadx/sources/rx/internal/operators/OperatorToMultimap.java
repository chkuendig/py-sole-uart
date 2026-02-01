package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observers.Subscribers;

/* loaded from: classes2.dex */
public final class OperatorToMultimap<T, K, V> implements Observable.Operator<Map<K, Collection<V>>, T> {
    final Func1<? super K, ? extends Collection<V>> collectionFactory;
    final Func1<? super T, ? extends K> keySelector;
    private final Func0<? extends Map<K, Collection<V>>> mapFactory;
    final Func1<? super T, ? extends V> valueSelector;

    public static final class DefaultToMultimapFactory<K, V> implements Func0<Map<K, Collection<V>>> {
        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public Map<K, Collection<V>> call() {
            return new HashMap();
        }
    }

    public static final class DefaultMultimapCollectionFactory<K, V> implements Func1<K, Collection<V>> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((DefaultMultimapCollectionFactory<K, V>) obj);
        }

        @Override // rx.functions.Func1
        public Collection<V> call(K k) {
            return new ArrayList();
        }
    }

    public OperatorToMultimap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this(func1, func12, new DefaultToMultimapFactory(), new DefaultMultimapCollectionFactory());
    }

    public OperatorToMultimap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0) {
        this(func1, func12, func0, new DefaultMultimapCollectionFactory());
    }

    public OperatorToMultimap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0, Func1<? super K, ? extends Collection<V>> func13) {
        this.keySelector = func1;
        this.valueSelector = func12;
        this.mapFactory = func0;
        this.collectionFactory = func13;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Map<K, Collection<V>>> subscriber) {
        try {
            return new Subscriber<T>(subscriber, this.mapFactory.call(), subscriber) { // from class: rx.internal.operators.OperatorToMultimap.1
                private Map<K, Collection<V>> map;
                final /* synthetic */ Map val$fLocalMap;
                final /* synthetic */ Subscriber val$subscriber;

                {
                    this.val$fLocalMap = map;
                    this.val$subscriber = subscriber;
                    this.map = map;
                }

                @Override // rx.Subscriber
                public void onStart() {
                    request(Long.MAX_VALUE);
                }

                @Override // rx.Observer
                public void onNext(T t) {
                    try {
                        K kCall = OperatorToMultimap.this.keySelector.call(t);
                        V vCall = OperatorToMultimap.this.valueSelector.call(t);
                        Collection<V> collectionCall = this.map.get(kCall);
                        if (collectionCall == null) {
                            try {
                                collectionCall = OperatorToMultimap.this.collectionFactory.call(kCall);
                                this.map.put(kCall, collectionCall);
                            } catch (Throwable th) {
                                Exceptions.throwOrReport(th, this.val$subscriber);
                                return;
                            }
                        }
                        collectionCall.add(vCall);
                    } catch (Throwable th2) {
                        Exceptions.throwOrReport(th2, this.val$subscriber);
                    }
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    this.map = null;
                    this.val$subscriber.onError(th);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    Map<K, Collection<V>> map = this.map;
                    this.map = null;
                    this.val$subscriber.onNext(map);
                    this.val$subscriber.onCompleted();
                }
            };
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscriber.onError(th);
            Subscriber<? super T> subscriberEmpty = Subscribers.empty();
            subscriberEmpty.unsubscribe();
            return subscriberEmpty;
        }
    }
}
