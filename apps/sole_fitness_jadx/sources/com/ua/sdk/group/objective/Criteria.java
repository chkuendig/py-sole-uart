package com.ua.sdk.group.objective;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public interface Criteria extends Parcelable {
    void addCriteriaItem(CriteriaItem criteriaItem);

    CriteriaItem getCriteriaItem(String str);

    void removeAllItems();

    CriteriaItem removeItem(String str);
}
