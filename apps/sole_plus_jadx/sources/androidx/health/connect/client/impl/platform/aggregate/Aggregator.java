package androidx.health.connect.client.impl.platform.aggregate;

import androidx.exifinterface.media.ExifInterface;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.records.metadata.DataOrigin;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* compiled from: Aggregator.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u0013R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;", ExifInterface.GPS_DIRECTION_TRUE, "", "dataOrigins", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "getDataOrigins", "()Ljava/util/Set;", "doubleValues", "", "", "", "getDoubleValues", "()Ljava/util/Map;", "getResult", "Landroidx/health/connect/client/aggregate/AggregationResult;", "plusAssign", "", "value", "(Ljava/lang/Object;)V", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Aggregator<T> {
    Set<DataOrigin> getDataOrigins();

    Map<String, Double> getDoubleValues();

    void plusAssign(T value);

    default AggregationResult getResult() {
        if (getDataOrigins().isEmpty()) {
            return HealthConnectClientAggregationExtensionsKt.emptyAggregationResult();
        }
        return new AggregationResult(MapsKt.emptyMap(), getDoubleValues(), getDataOrigins());
    }
}
