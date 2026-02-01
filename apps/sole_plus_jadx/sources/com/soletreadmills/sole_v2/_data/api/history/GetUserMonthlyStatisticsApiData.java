package com.soletreadmills.sole_v2._data.api.history;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data.UserMonthlyStatisticsBeanData;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetUserMonthlyStatisticsApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetUserMonthlyStatisticsApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetUserMonthlyStatisticsApiData {
    public static final int $stable = 0;

    /* compiled from: GetUserMonthlyStatisticsApiData.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetUserMonthlyStatisticsApiData$RequestBodyData;", "", "toFilter", "", "activityTypes", "", "", "includeExternalDataSources", "months", "years", "minTotalTime", "maxTotalTime", "sortAsc", "pageSize", "page", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getActivityTypes", "()Ljava/util/List;", "getIncludeExternalDataSources", "getMaxTotalTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMinTotalTime", "getMonths", "getPage", "getPageSize", "getSortAsc", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getToFilter", "getYears", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("activityTypes")
        private final List<Integer> activityTypes;

        @SerializedName("includeExternalDataSources")
        private final List<Integer> includeExternalDataSources;

        @SerializedName("maxTotalTime")
        private final Integer maxTotalTime;

        @SerializedName("minTotalTime")
        private final Integer minTotalTime;

        @SerializedName("months")
        private final List<Integer> months;

        @SerializedName("page")
        private final Integer page;

        @SerializedName("pageSize")
        private final Integer pageSize;

        @SerializedName("sortAsc")
        private final Boolean sortAsc;

        @SerializedName("toFilter")
        private final Boolean toFilter;

        @SerializedName("years")
        private final List<Integer> years;

        public RequestBodyData() {
            this(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }

        public RequestBodyData(Boolean bool, List<Integer> list, List<Integer> list2, List<Integer> list3, List<Integer> list4, Integer num, Integer num2, Boolean bool2, Integer num3, Integer num4) {
            this.toFilter = bool;
            this.activityTypes = list;
            this.includeExternalDataSources = list2;
            this.months = list3;
            this.years = list4;
            this.minTotalTime = num;
            this.maxTotalTime = num2;
            this.sortAsc = bool2;
            this.pageSize = num3;
            this.page = num4;
        }

        public final Boolean getToFilter() {
            return this.toFilter;
        }

        public final List<Integer> getActivityTypes() {
            return this.activityTypes;
        }

        public final List<Integer> getIncludeExternalDataSources() {
            return this.includeExternalDataSources;
        }

        public final List<Integer> getMonths() {
            return this.months;
        }

        public final List<Integer> getYears() {
            return this.years;
        }

        public final Integer getMinTotalTime() {
            return this.minTotalTime;
        }

        public final Integer getMaxTotalTime() {
            return this.maxTotalTime;
        }

        public /* synthetic */ RequestBodyData(Boolean bool, List list, List list2, List list3, List list4, Integer num, Integer num2, Boolean bool2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : list3, (i & 16) != 0 ? null : list4, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? false : bool2, (i & 256) != 0 ? null : num3, (i & 512) == 0 ? num4 : null);
        }

        public final Boolean getSortAsc() {
            return this.sortAsc;
        }

        public final Integer getPageSize() {
            return this.pageSize;
        }

        public final Integer getPage() {
            return this.page;
        }
    }

    /* compiled from: GetUserMonthlyStatisticsApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetUserMonthlyStatisticsApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/history/GetUserMonthlyStatisticsApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/history/GetUserMonthlyStatisticsApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/history/GetUserMonthlyStatisticsApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    }

    /* compiled from: GetUserMonthlyStatisticsApiData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetUserMonthlyStatisticsApiData$DataMap;", "", "data", "", "Lcom/soletreadmills/sole_v2/_data/UserMonthlyStatisticsBeanData;", "totalCount", "", "totalPage", "(Ljava/util/List;II)V", "getData", "()Ljava/util/List;", "getTotalCount", "()I", "setTotalCount", "(I)V", "getTotalPage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;

        @SerializedName("data")
        private final List<UserMonthlyStatisticsBeanData> data;

        @SerializedName("totalCount")
        private int totalCount;

        @SerializedName("totalPage")
        private final int totalPage;

        public DataMap() {
            this(null, 0, 0, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataMap copy$default(DataMap dataMap, List list, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = dataMap.data;
            }
            if ((i3 & 2) != 0) {
                i = dataMap.totalCount;
            }
            if ((i3 & 4) != 0) {
                i2 = dataMap.totalPage;
            }
            return dataMap.copy(list, i, i2);
        }

        public final List<UserMonthlyStatisticsBeanData> component1() {
            return this.data;
        }

        /* renamed from: component2, reason: from getter */
        public final int getTotalCount() {
            return this.totalCount;
        }

        /* renamed from: component3, reason: from getter */
        public final int getTotalPage() {
            return this.totalPage;
        }

        public final DataMap copy(List<UserMonthlyStatisticsBeanData> data, int totalCount, int totalPage) {
            return new DataMap(data, totalCount, totalPage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataMap)) {
                return false;
            }
            DataMap dataMap = (DataMap) other;
            return Intrinsics.areEqual(this.data, dataMap.data) && this.totalCount == dataMap.totalCount && this.totalPage == dataMap.totalPage;
        }

        public int hashCode() {
            List<UserMonthlyStatisticsBeanData> list = this.data;
            return ((((list == null ? 0 : list.hashCode()) * 31) + Integer.hashCode(this.totalCount)) * 31) + Integer.hashCode(this.totalPage);
        }

        public String toString() {
            return "DataMap(data=" + this.data + ", totalCount=" + this.totalCount + ", totalPage=" + this.totalPage + ')';
        }

        public DataMap(List<UserMonthlyStatisticsBeanData> list, int i, int i2) {
            this.data = list;
            this.totalCount = i;
            this.totalPage = i2;
        }

        public /* synthetic */ DataMap(List list, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : list, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
        }

        public final List<UserMonthlyStatisticsBeanData> getData() {
            return this.data;
        }

        public final int getTotalCount() {
            return this.totalCount;
        }

        public final void setTotalCount(int i) {
            this.totalCount = i;
        }

        public final int getTotalPage() {
            return this.totalPage;
        }
    }
}
