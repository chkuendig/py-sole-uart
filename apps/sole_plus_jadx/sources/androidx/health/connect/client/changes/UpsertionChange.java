package androidx.health.connect.client.changes;

import androidx.health.connect.client.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpsertionChange.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Landroidx/health/connect/client/changes/UpsertionChange;", "Landroidx/health/connect/client/changes/Change;", "record", "Landroidx/health/connect/client/records/Record;", "(Landroidx/health/connect/client/records/Record;)V", "getRecord", "()Landroidx/health/connect/client/records/Record;", "equals", "", "other", "", "hashCode", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpsertionChange implements Change {
    private final Record record;

    public UpsertionChange(Record record) {
        Intrinsics.checkNotNullParameter(record, "record");
        this.record = record;
    }

    public final Record getRecord() {
        return this.record;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.health.connect.client.changes.UpsertionChange");
        return Intrinsics.areEqual(this.record, ((UpsertionChange) other).record);
    }

    public int hashCode() {
        return this.record.hashCode();
    }
}
