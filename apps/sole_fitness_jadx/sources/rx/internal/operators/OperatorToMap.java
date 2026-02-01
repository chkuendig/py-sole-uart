package rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observers.Subscribers;

/* loaded from: classes2.dex */
public final class OperatorToMap<T, K, V> implements Observable.Operator<Map<K, V>, T> {
    final Func1<? super T, ? extends K> keySelector;
    private final Func0<? extends Map<K, V>> mapFactory;
    final Func1<? super T, ? extends V> valueSelector;

    public static final class DefaultToMapFactory<K, V> implements Func0<Map<K, V>> {
        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public Map<K, V> call() {
            return new HashMap();
        }
    }

    public OperatorToMap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this(func1, func12, new DefaultToMapFactory());
    }

    public OperatorToMap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, V>> func0) {
        this.keySelector = func1;
        this.valueSelector = func12;
        this.mapFactory = func0;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Map<K, V>> subscriber) {
        try {
            return new Subscriber<T>(subscriber, this.mapFactory.call(), subscriber) { // from class: rx.internal.operators.OperatorToMap.1
                private Map<K, V> map;
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
                        this.map.put(OperatorToMap.this.keySelector.call(t), OperatorToMap.this.valueSelector.call(t));
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, this.val$subscriber);
                    }
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    this.map = null;
                    this.val$subscriber.onError(th);
                }

                @Override // rx.Observer
                public void onCompleted() {
                    Map<K, V> map = this.map;
                    this.map = null;
                    this.val$subscriber.onNext(map);
                    this.val$subscriber.onCompleted();
                }
            };
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, subscriber);
            Subscriber<? super T> subscriberEmpty = Subscribers.empty();
            subscriberEmpty.unsubscribe();
            return subscriberEmpty;
        }
    }
}
