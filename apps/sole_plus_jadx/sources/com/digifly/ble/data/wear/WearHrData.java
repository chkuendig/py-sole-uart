package com.digifly.ble.data.wear;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WearHrData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/digifly/ble/data/wear/WearHrData;", "", "hrValue", "", "time", "", "(Ljava/lang/Integer;Ljava/lang/Long;)V", "getHrValue", "()Ljava/lang/Integer;", "setHrValue", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTime", "()Ljava/lang/Long;", "setTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "checkTimeInRangeAndGetValue", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;)Lcom/digifly/ble/data/wear/WearHrData;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class WearHrData {
    public static final int $stable = 8;

    @SerializedName("heart")
    private Integer hrValue;

    @SerializedName("time")
    private Long time;

    /* JADX WARN: Multi-variable type inference failed */
    public WearHrData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WearHrData copy$default(WearHrData wearHrData, Integer num, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            num = wearHrData.hrValue;
        }
        if ((i & 2) != 0) {
            l = wearHrData.time;
        }
        return wearHrData.copy(num, l);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getHrValue() {
        return this.hrValue;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getTime() {
        return this.time;
    }

    public final WearHrData copy(Integer hrValue, Long time) {
        return new WearHrData(hrValue, time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WearHrData)) {
            return false;
        }
        WearHrData wearHrData = (WearHrData) other;
        return Intrinsics.areEqual(this.hrValue, wearHrData.hrValue) && Intrinsics.areEqual(this.time, wearHrData.time);
    }

    public int hashCode() {
        Integer num = this.hrValue;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l = this.time;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "WearHrData(hrValue=" + this.hrValue + ", time=" + this.time + ')';
    }

    public WearHrData(Integer num, Long l) {
        this.hrValue = num;
        this.time = l;
    }

    public /* synthetic */ WearHrData(Integer num, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : l);
    }

    public final Integer getHrValue() {
        return this.hrValue;
    }

    public final void setHrValue(Integer num) {
        this.hrValue = num;
    }

    public final Long getTime() {
        return this.time;
    }

    public final void setTime(Long l) {
        this.time = l;
    }

    public final int checkTimeInRangeAndGetValue() {
        Integer num;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l = this.time;
        if (l == null || jCurrentTimeMillis - l.longValue() > 3000 || (num = this.hrValue) == null) {
            return -1;
        }
        return num.intValue();
    }
}
