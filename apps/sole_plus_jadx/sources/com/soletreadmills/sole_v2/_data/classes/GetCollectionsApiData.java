package com.soletreadmills.sole_v2._data.classes;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassCollectionData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/GetCollectionsApiData;", "", "()V", "ClassCollectionListDataMap", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetCollectionsApiData {
    public static final int $stable = 0;

    /* compiled from: ClassCollectionData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/GetCollectionsApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/classes/GetCollectionsApiData$ClassCollectionListDataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/classes/GetCollectionsApiData$ClassCollectionListDataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/classes/GetCollectionsApiData$ClassCollectionListDataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtApiBaseData {
        public static final int $stable = 8;

        @SerializedName("sys_response_data")
        private ClassCollectionListDataMap dataMap;

        public final ClassCollectionListDataMap getDataMap() {
            return this.dataMap;
        }

        public final void setDataMap(ClassCollectionListDataMap classCollectionListDataMap) {
            this.dataMap = classCollectionListDataMap;
        }
    }

    /* compiled from: ClassCollectionData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/GetCollectionsApiData$ClassCollectionListDataMap;", "", "total", "", "data", "", "Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionData;", "(Ljava/lang/Integer;Ljava/util/List;)V", "getData", "()Ljava/util/List;", "getTotal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/soletreadmills/sole_v2/_data/classes/GetCollectionsApiData$ClassCollectionListDataMap;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ClassCollectionListDataMap {
        public static final int $stable = 8;
        private final List<ClassCollectionData> data;
        private final Integer total;

        /* JADX WARN: Multi-variable type inference failed */
        public ClassCollectionListDataMap() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ClassCollectionListDataMap copy$default(ClassCollectionListDataMap classCollectionListDataMap, Integer num, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                num = classCollectionListDataMap.total;
            }
            if ((i & 2) != 0) {
                list = classCollectionListDataMap.data;
            }
            return classCollectionListDataMap.copy(num, list);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getTotal() {
            return this.total;
        }

        public final List<ClassCollectionData> component2() {
            return this.data;
        }

        public final ClassCollectionListDataMap copy(Integer total, List<ClassCollectionData> data) {
            return new ClassCollectionListDataMap(total, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClassCollectionListDataMap)) {
                return false;
            }
            ClassCollectionListDataMap classCollectionListDataMap = (ClassCollectionListDataMap) other;
            return Intrinsics.areEqual(this.total, classCollectionListDataMap.total) && Intrinsics.areEqual(this.data, classCollectionListDataMap.data);
        }

        public int hashCode() {
            Integer num = this.total;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            List<ClassCollectionData> list = this.data;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "ClassCollectionListDataMap(total=" + this.total + ", data=" + this.data + ')';
        }

        public ClassCollectionListDataMap(Integer num, List<ClassCollectionData> list) {
            this.total = num;
            this.data = list;
        }

        public /* synthetic */ ClassCollectionListDataMap(Integer num, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : list);
        }

        public final Integer getTotal() {
            return this.total;
        }

        public final List<ClassCollectionData> getData() {
            return this.data;
        }
    }
}
