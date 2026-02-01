package com.ua.sdk.group.objective;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public interface CriteriaItem<T> extends Parcelable {
    String getName();

    T getValue();

    void setValue(T t);
}
