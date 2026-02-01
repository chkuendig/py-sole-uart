package androidx.health.connect.client.impl.platform.aggregate;

import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HealthConnectClientAggregationExtensions.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0005J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0086\u0002J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/AvgData;", "", "count", "", "total", "", "(ID)V", "getCount", "()I", "setCount", "(I)V", "getTotal", "()D", "setTotal", "(D)V", "average", "component1", "component2", "copy", "equals", "", "other", "hashCode", "plusAssign", "", "value", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AvgData {
    private int count;
    private double total;

    public AvgData() {
        this(0, AudioStats.AUDIO_AMPLITUDE_NONE, 3, null);
    }

    public static /* synthetic */ AvgData copy$default(AvgData avgData, int i, double d, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = avgData.count;
        }
        if ((i2 & 2) != 0) {
            d = avgData.total;
        }
        return avgData.copy(i, d);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: component2, reason: from getter */
    public final double getTotal() {
        return this.total;
    }

    public final AvgData copy(int count, double total) {
        return new AvgData(count, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvgData)) {
            return false;
        }
        AvgData avgData = (AvgData) other;
        return this.count == avgData.count && Double.compare(this.total, avgData.total) == 0;
    }

    public int hashCode() {
        return (Integer.hashCode(this.count) * 31) + Double.hashCode(this.total);
    }

    public String toString() {
        return "AvgData(count=" + this.count + ", total=" + this.total + ')';
    }

    public AvgData(int i, double d) {
        this.count = i;
        this.total = d;
    }

    public /* synthetic */ AvgData(int i, double d, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d);
    }

    public final int getCount() {
        return this.count;
    }

    public final double getTotal() {
        return this.total;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setTotal(double d) {
        this.total = d;
    }

    public final void plusAssign(double value) {
        this.count++;
        this.total += value;
    }

    public final double average() {
        return this.total / this.count;
    }
}
