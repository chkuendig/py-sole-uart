package com.soletreadmills.sole_v2._data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserWorkout12WeeklyStatsVoData.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001$B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003JF\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006%"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/DWMTrendStats;", "", "maxValue", "", "avgValue", "durationCoverMonths", "", "", "dataKeyValueList", "Lcom/soletreadmills/sole_v2/_data/DWMTrendStats$KeyValuePair;", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;)V", "getAvgValue", "()Ljava/lang/Double;", "setAvgValue", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getDataKeyValueList", "()Ljava/util/List;", "setDataKeyValueList", "(Ljava/util/List;)V", "getDurationCoverMonths", "setDurationCoverMonths", "getMaxValue", "setMaxValue", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;)Lcom/soletreadmills/sole_v2/_data/DWMTrendStats;", "equals", "", "other", "hashCode", "", "toString", "KeyValuePair", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DWMTrendStats {
    public static final int $stable = 8;
    private Double avgValue;
    private List<KeyValuePair> dataKeyValueList;
    private List<String> durationCoverMonths;
    private Double maxValue;

    public DWMTrendStats() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DWMTrendStats copy$default(DWMTrendStats dWMTrendStats, Double d, Double d2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = dWMTrendStats.maxValue;
        }
        if ((i & 2) != 0) {
            d2 = dWMTrendStats.avgValue;
        }
        if ((i & 4) != 0) {
            list = dWMTrendStats.durationCoverMonths;
        }
        if ((i & 8) != 0) {
            list2 = dWMTrendStats.dataKeyValueList;
        }
        return dWMTrendStats.copy(d, d2, list, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final Double getMaxValue() {
        return this.maxValue;
    }

    /* renamed from: component2, reason: from getter */
    public final Double getAvgValue() {
        return this.avgValue;
    }

    public final List<String> component3() {
        return this.durationCoverMonths;
    }

    public final List<KeyValuePair> component4() {
        return this.dataKeyValueList;
    }

    public final DWMTrendStats copy(Double maxValue, Double avgValue, List<String> durationCoverMonths, List<KeyValuePair> dataKeyValueList) {
        Intrinsics.checkNotNullParameter(durationCoverMonths, "durationCoverMonths");
        Intrinsics.checkNotNullParameter(dataKeyValueList, "dataKeyValueList");
        return new DWMTrendStats(maxValue, avgValue, durationCoverMonths, dataKeyValueList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DWMTrendStats)) {
            return false;
        }
        DWMTrendStats dWMTrendStats = (DWMTrendStats) other;
        return Intrinsics.areEqual((Object) this.maxValue, (Object) dWMTrendStats.maxValue) && Intrinsics.areEqual((Object) this.avgValue, (Object) dWMTrendStats.avgValue) && Intrinsics.areEqual(this.durationCoverMonths, dWMTrendStats.durationCoverMonths) && Intrinsics.areEqual(this.dataKeyValueList, dWMTrendStats.dataKeyValueList);
    }

    public int hashCode() {
        Double d = this.maxValue;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.avgValue;
        return ((((iHashCode + (d2 != null ? d2.hashCode() : 0)) * 31) + this.durationCoverMonths.hashCode()) * 31) + this.dataKeyValueList.hashCode();
    }

    public String toString() {
        return "DWMTrendStats(maxValue=" + this.maxValue + ", avgValue=" + this.avgValue + ", durationCoverMonths=" + this.durationCoverMonths + ", dataKeyValueList=" + this.dataKeyValueList + ')';
    }

    public DWMTrendStats(Double d, Double d2, List<String> durationCoverMonths, List<KeyValuePair> dataKeyValueList) {
        Intrinsics.checkNotNullParameter(durationCoverMonths, "durationCoverMonths");
        Intrinsics.checkNotNullParameter(dataKeyValueList, "dataKeyValueList");
        this.maxValue = d;
        this.avgValue = d2;
        this.durationCoverMonths = durationCoverMonths;
        this.dataKeyValueList = dataKeyValueList;
    }

    public final Double getMaxValue() {
        return this.maxValue;
    }

    public final void setMaxValue(Double d) {
        this.maxValue = d;
    }

    public final Double getAvgValue() {
        return this.avgValue;
    }

    public final void setAvgValue(Double d) {
        this.avgValue = d;
    }

    public /* synthetic */ DWMTrendStats(Double d, Double d2, ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2, (i & 4) != 0 ? new ArrayList() : arrayList, (i & 8) != 0 ? new ArrayList() : arrayList2);
    }

    public final List<String> getDurationCoverMonths() {
        return this.durationCoverMonths;
    }

    public final void setDurationCoverMonths(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.durationCoverMonths = list;
    }

    public final List<KeyValuePair> getDataKeyValueList() {
        return this.dataKeyValueList;
    }

    public final void setDataKeyValueList(List<KeyValuePair> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataKeyValueList = list;
    }

    /* compiled from: UserWorkout12WeeklyStatsVoData.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/DWMTrendStats$KeyValuePair;", "", "key", "", "value", "", "(Ljava/lang/String;Ljava/lang/Number;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/Number;", "setValue", "(Ljava/lang/Number;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class KeyValuePair {
        public static final int $stable = 8;
        private String key;
        private Number value;

        /* JADX WARN: Multi-variable type inference failed */
        public KeyValuePair() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ KeyValuePair copy$default(KeyValuePair keyValuePair, String str, Number number, int i, Object obj) {
            if ((i & 1) != 0) {
                str = keyValuePair.key;
            }
            if ((i & 2) != 0) {
                number = keyValuePair.value;
            }
            return keyValuePair.copy(str, number);
        }

        /* renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* renamed from: component2, reason: from getter */
        public final Number getValue() {
            return this.value;
        }

        public final KeyValuePair copy(String key, Number value) {
            return new KeyValuePair(key, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof KeyValuePair)) {
                return false;
            }
            KeyValuePair keyValuePair = (KeyValuePair) other;
            return Intrinsics.areEqual(this.key, keyValuePair.key) && Intrinsics.areEqual(this.value, keyValuePair.value);
        }

        public int hashCode() {
            String str = this.key;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Number number = this.value;
            return iHashCode + (number != null ? number.hashCode() : 0);
        }

        public String toString() {
            return "KeyValuePair(key=" + this.key + ", value=" + this.value + ')';
        }

        public KeyValuePair(String str, Number number) {
            this.key = str;
            this.value = number;
        }

        public /* synthetic */ KeyValuePair(String str, Number number, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : number);
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final Number getValue() {
            return this.value;
        }

        public final void setValue(Number number) {
            this.value = number;
        }
    }
}
