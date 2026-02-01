package com.android.utils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* loaded from: classes3.dex */
public class ImmutableCollectors {
    public static <T> Collector<T, ImmutableList.Builder<T>, ImmutableList<T>> toImmutableList() {
        return Collector.of(new Supplier() { // from class: com.android.utils.ImmutableCollectors$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableList.builder();
            }
        }, new BiConsumer() { // from class: com.android.utils.ImmutableCollectors$$ExternalSyntheticLambda1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((ImmutableList.Builder) obj).add((ImmutableList.Builder) obj2);
            }
        }, new BinaryOperator() { // from class: com.android.utils.ImmutableCollectors$$ExternalSyntheticLambda2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableList.Builder) obj).addAll((Iterable) ((ImmutableList.Builder) obj2).build());
            }
        }, new Function() { // from class: com.android.utils.ImmutableCollectors$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableList.Builder) obj).build();
            }
        }, new Collector.Characteristics[0]);
    }

    public static <T> Collector<T, ImmutableSet.Builder<T>, ImmutableSet<T>> toImmutableSet() {
        return Collector.of(new Supplier() { // from class: com.android.utils.ImmutableCollectors$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableSet.builder();
            }
        }, new BiConsumer() { // from class: com.android.utils.ImmutableCollectors$$ExternalSyntheticLambda5
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((ImmutableSet.Builder) obj).add((ImmutableSet.Builder) obj2);
            }
        }, new BinaryOperator() { // from class: com.android.utils.ImmutableCollectors$$ExternalSyntheticLambda6
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSet.Builder) obj).addAll((Iterable) ((ImmutableSet.Builder) obj2).build());
            }
        }, new Function() { // from class: com.android.utils.ImmutableCollectors$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSet.Builder) obj).build();
            }
        }, new Collector.Characteristics[0]);
    }
}
