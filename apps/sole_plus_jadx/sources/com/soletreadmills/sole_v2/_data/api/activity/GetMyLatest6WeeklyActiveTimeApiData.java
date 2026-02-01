package com.soletreadmills.sole_v2._data.api.activity;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetMyLatest6WeeklyActiveTimeApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest6WeeklyActiveTimeApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "ResponseData", "WeeklyStatsData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetMyLatest6WeeklyActiveTimeApiData {
    public static final int $stable = 0;

    /* compiled from: GetMyLatest6WeeklyActiveTimeApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest6WeeklyActiveTimeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest6WeeklyActiveTimeApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest6WeeklyActiveTimeApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest6WeeklyActiveTimeApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: GetMyLatest6WeeklyActiveTimeApiData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest6WeeklyActiveTimeApiData$DataMap;", "", "data", "", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest6WeeklyActiveTimeApiData$WeeklyStatsData;", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;

        @SerializedName("data")
        private final List<WeeklyStatsData> data;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataMap copy$default(DataMap dataMap, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = dataMap.data;
            }
            return dataMap.copy(list);
        }

        public final List<WeeklyStatsData> component1() {
            return this.data;
        }

        public final DataMap copy(List<WeeklyStatsData> data) {
            return new DataMap(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.data, ((DataMap) other).data);
        }

        public int hashCode() {
            List<WeeklyStatsData> list = this.data;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "DataMap(data=" + this.data + ')';
        }

        public DataMap(List<WeeklyStatsData> list) {
            this.data = list;
        }

        public /* synthetic */ DataMap(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        public final List<WeeklyStatsData> getData() {
            return this.data;
        }
    }

    /* compiled from: GetMyLatest6WeeklyActiveTimeApiData.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest6WeeklyActiveTimeApiData$WeeklyStatsData;", "", "yearWeek", "", "totalTime", "", "weekStartDate", "weekEndDate", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getTotalTime", "()J", "getWeekEndDate", "()Ljava/lang/String;", "getWeekStartDate", "getYearWeek", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class WeeklyStatsData {
        public static final int $stable = 0;

        @SerializedName("totalTime")
        private final long totalTime;

        @SerializedName("weekEndDate")
        private final String weekEndDate;

        @SerializedName("weekStartDate")
        private final String weekStartDate;

        @SerializedName("yearWeek")
        private final String yearWeek;

        public WeeklyStatsData() {
            this(null, 0L, null, null, 15, null);
        }

        public static /* synthetic */ WeeklyStatsData copy$default(WeeklyStatsData weeklyStatsData, String str, long j, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = weeklyStatsData.yearWeek;
            }
            if ((i & 2) != 0) {
                j = weeklyStatsData.totalTime;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                str2 = weeklyStatsData.weekStartDate;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                str3 = weeklyStatsData.weekEndDate;
            }
            return weeklyStatsData.copy(str, j2, str4, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getYearWeek() {
            return this.yearWeek;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTotalTime() {
            return this.totalTime;
        }

        /* renamed from: component3, reason: from getter */
        public final String getWeekStartDate() {
            return this.weekStartDate;
        }

        /* renamed from: component4, reason: from getter */
        public final String getWeekEndDate() {
            return this.weekEndDate;
        }

        public final WeeklyStatsData copy(String yearWeek, long totalTime, String weekStartDate, String weekEndDate) {
            return new WeeklyStatsData(yearWeek, totalTime, weekStartDate, weekEndDate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WeeklyStatsData)) {
                return false;
            }
            WeeklyStatsData weeklyStatsData = (WeeklyStatsData) other;
            return Intrinsics.areEqual(this.yearWeek, weeklyStatsData.yearWeek) && this.totalTime == weeklyStatsData.totalTime && Intrinsics.areEqual(this.weekStartDate, weeklyStatsData.weekStartDate) && Intrinsics.areEqual(this.weekEndDate, weeklyStatsData.weekEndDate);
        }

        public int hashCode() {
            String str = this.yearWeek;
            int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + Long.hashCode(this.totalTime)) * 31;
            String str2 = this.weekStartDate;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.weekEndDate;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "WeeklyStatsData(yearWeek=" + this.yearWeek + ", totalTime=" + this.totalTime + ", weekStartDate=" + this.weekStartDate + ", weekEndDate=" + this.weekEndDate + ')';
        }

        public WeeklyStatsData(String str, long j, String str2, String str3) {
            this.yearWeek = str;
            this.totalTime = j;
            this.weekStartDate = str2;
            this.weekEndDate = str3;
        }

        public /* synthetic */ WeeklyStatsData(String str, long j, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }

        public final String getYearWeek() {
            return this.yearWeek;
        }

        public final long getTotalTime() {
            return this.totalTime;
        }

        public final String getWeekStartDate() {
            return this.weekStartDate;
        }

        public final String getWeekEndDate() {
            return this.weekEndDate;
        }
    }
}
