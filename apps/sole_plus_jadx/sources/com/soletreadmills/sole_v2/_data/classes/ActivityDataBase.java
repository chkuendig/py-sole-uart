package com.soletreadmills.sole_v2._data.classes;

import com.soletreadmills.sole_v2._type.ActivityType;
import kotlin.Metadata;

/* compiled from: ActivityData.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/ActivityDataBase;", "", "isSelect", "", "()Z", "setSelect", "(Z)V", "type", "Lcom/soletreadmills/sole_v2/_type/ActivityType;", "getType", "()Lcom/soletreadmills/sole_v2/_type/ActivityType;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ActivityDataBase {
    ActivityType getType();

    boolean isSelect();

    void setSelect(boolean z);
}
