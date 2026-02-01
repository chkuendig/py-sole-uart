package androidx.health.connect.client.request;

import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.metadata.DataOrigin;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: ChangesTokenRequest.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\u0010\bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/health/connect/client/request/ChangesTokenRequest;", "", "recordTypes", "", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "dataOriginFilters", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "(Ljava/util/Set;Ljava/util/Set;)V", "getDataOriginFilters", "()Ljava/util/Set;", "getRecordTypes", "equals", "", "other", "hashCode", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChangesTokenRequest {
    private final Set<DataOrigin> dataOriginFilters;
    private final Set<KClass<? extends Record>> recordTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public ChangesTokenRequest(Set<? extends KClass<? extends Record>> recordTypes, Set<DataOrigin> dataOriginFilters) {
        Intrinsics.checkNotNullParameter(recordTypes, "recordTypes");
        Intrinsics.checkNotNullParameter(dataOriginFilters, "dataOriginFilters");
        this.recordTypes = recordTypes;
        this.dataOriginFilters = dataOriginFilters;
    }

    public final Set<KClass<? extends Record>> getRecordTypes() {
        return this.recordTypes;
    }

    public /* synthetic */ ChangesTokenRequest(Set set, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i & 2) != 0 ? SetsKt.emptySet() : set2);
    }

    public final Set<DataOrigin> getDataOriginFilters() {
        return this.dataOriginFilters;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.health.connect.client.request.ChangesTokenRequest");
        ChangesTokenRequest changesTokenRequest = (ChangesTokenRequest) other;
        return Intrinsics.areEqual(this.recordTypes, changesTokenRequest.recordTypes) && Intrinsics.areEqual(this.dataOriginFilters, changesTokenRequest.dataOriginFilters);
    }

    public int hashCode() {
        return (this.recordTypes.hashCode() * 31) + this.dataOriginFilters.hashCode();
    }
}
