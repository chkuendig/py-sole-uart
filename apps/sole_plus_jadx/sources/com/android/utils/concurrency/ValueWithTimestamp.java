package com.android.utils.concurrency;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AsyncSupplier.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/android/utils/concurrency/ValueWithTimestamp;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "value", "timestampMs", "", "(Ljava/lang/Object;J)V", "getTimestampMs", "()J", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/Object;J)Lcom/android/utils/concurrency/ValueWithTimestamp;", "equals", "", "other", "hashCode", "", "toString", "", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ValueWithTimestamp<V> {
    private final long timestampMs;
    private final V value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ValueWithTimestamp copy$default(ValueWithTimestamp valueWithTimestamp, Object obj, long j, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = valueWithTimestamp.value;
        }
        if ((i & 2) != 0) {
            j = valueWithTimestamp.timestampMs;
        }
        return valueWithTimestamp.copy(obj, j);
    }

    public final V component1() {
        return this.value;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public final ValueWithTimestamp<V> copy(V value, long timestampMs) {
        return new ValueWithTimestamp<>(value, timestampMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ValueWithTimestamp)) {
            return false;
        }
        ValueWithTimestamp valueWithTimestamp = (ValueWithTimestamp) other;
        return Intrinsics.areEqual(this.value, valueWithTimestamp.value) && this.timestampMs == valueWithTimestamp.timestampMs;
    }

    public int hashCode() {
        V v = this.value;
        return ((v == null ? 0 : v.hashCode()) * 31) + Long.hashCode(this.timestampMs);
    }

    public String toString() {
        return "ValueWithTimestamp(value=" + this.value + ", timestampMs=" + this.timestampMs + ')';
    }

    public ValueWithTimestamp(V v, long j) {
        this.value = v;
        this.timestampMs = j;
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public final V getValue() {
        return this.value;
    }
}
