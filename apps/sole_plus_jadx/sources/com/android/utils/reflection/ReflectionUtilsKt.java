package com.android.utils.reflection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: ReflectionUtils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"qualifiedName", "", "Lkotlin/reflect/KProperty;", "getQualifiedName", "(Lkotlin/reflect/KProperty;)Ljava/lang/String;", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ReflectionUtilsKt {
    public static final String getQualifiedName(KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "<this>");
        return ((Object) kProperty.getClass().getName()) + '.' + kProperty.getName();
    }
}
