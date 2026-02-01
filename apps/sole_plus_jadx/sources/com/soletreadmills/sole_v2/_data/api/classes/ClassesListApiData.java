package com.soletreadmills.sole_v2._data.api.classes;

import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._data.classes.ClassesData;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ClassesListApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/classes/ClassesListApiData;", "", "()V", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesListApiData {
    public static final int $stable = 0;

    /* compiled from: ClassesListApiData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/classes/ClassesListApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "data", "", "Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "total", "", "getTotal", "()Ljava/lang/Integer;", "setTotal", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 8;
        private List<ClassesData> data;
        private Integer total;

        public final Integer getTotal() {
            return this.total;
        }

        public final void setTotal(Integer num) {
            this.total = num;
        }

        public final List<ClassesData> getData() {
            return this.data;
        }

        public final void setData(List<ClassesData> list) {
            this.data = list;
        }
    }
}
