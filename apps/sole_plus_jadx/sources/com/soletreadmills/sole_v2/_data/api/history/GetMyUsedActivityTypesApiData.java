package com.soletreadmills.sole_v2._data.api.history;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._type.HistoryActivityType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetMyUsedActivityTypesApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetMyUsedActivityTypesApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetMyUsedActivityTypesApiData {
    public static final int $stable = 0;

    /* compiled from: GetMyUsedActivityTypesApiData.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetMyUsedActivityTypesApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/history/GetMyUsedActivityTypesApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/history/GetMyUsedActivityTypesApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/history/GetMyUsedActivityTypesApiData$DataMap;)V", "getHistoryActivityTypes", "", "Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 8;

        @SerializedName("dataMap")
        private DataMap dataMap;

        public final DataMap getDataMap() {
            return this.dataMap;
        }

        public final void setDataMap(DataMap dataMap) {
            this.dataMap = dataMap;
        }

        public final List<HistoryActivityType> getHistoryActivityTypes() {
            List<Integer> activityTypes;
            DataMap dataMap = this.dataMap;
            if (dataMap == null || (activityTypes = dataMap.getActivityTypes()) == null) {
                return CollectionsKt.emptyList();
            }
            List<Integer> list = activityTypes;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(HistoryActivityType.INSTANCE.fromCode(((Number) it.next()).intValue()));
            }
            return arrayList;
        }
    }

    /* compiled from: GetMyUsedActivityTypesApiData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetMyUsedActivityTypesApiData$DataMap;", "", "activityTypes", "", "", "(Ljava/util/List;)V", "getActivityTypes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;

        @SerializedName("activityTypes")
        private final List<Integer> activityTypes;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataMap copy$default(DataMap dataMap, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = dataMap.activityTypes;
            }
            return dataMap.copy(list);
        }

        public final List<Integer> component1() {
            return this.activityTypes;
        }

        public final DataMap copy(List<Integer> activityTypes) {
            return new DataMap(activityTypes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.activityTypes, ((DataMap) other).activityTypes);
        }

        public int hashCode() {
            List<Integer> list = this.activityTypes;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "DataMap(activityTypes=" + this.activityTypes + ')';
        }

        public DataMap(List<Integer> list) {
            this.activityTypes = list;
        }

        public /* synthetic */ DataMap(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        public final List<Integer> getActivityTypes() {
            return this.activityTypes;
        }
    }
}
