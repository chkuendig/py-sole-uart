package com.soletreadmills.sole_v2._data.api.classes;

import com.soletreadmills.sole_v2._data.api.classes.GetClassInstructorsApiData;
import kotlin.Metadata;

/* compiled from: GetClassInstructorsApiData.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/classes/ClassInstructorsDataBase;", "", "instructorsData", "Lcom/soletreadmills/sole_v2/_data/api/classes/GetClassInstructorsApiData$ClassInstructorsData;", "getInstructorsData", "()Lcom/soletreadmills/sole_v2/_data/api/classes/GetClassInstructorsApiData$ClassInstructorsData;", "setInstructorsData", "(Lcom/soletreadmills/sole_v2/_data/api/classes/GetClassInstructorsApiData$ClassInstructorsData;)V", "isSelect", "", "()Z", "setSelect", "(Z)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ClassInstructorsDataBase {
    GetClassInstructorsApiData.ClassInstructorsData getInstructorsData();

    boolean isSelect();

    void setInstructorsData(GetClassInstructorsApiData.ClassInstructorsData classInstructorsData);

    void setSelect(boolean z);
}
