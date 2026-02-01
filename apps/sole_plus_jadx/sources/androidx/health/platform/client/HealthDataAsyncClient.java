package androidx.health.platform.client;

import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.PermissionProto;
import androidx.health.platform.client.proto.RequestProto;
import androidx.health.platform.client.proto.ResponseProto;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: HealthDataAsyncClient.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\u0006\u0010\u0005\u001a\u00020\u0016H&J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\u0006\u0010\u0005\u001a\u00020\u0019H&J\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\"\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\n0\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001d0\nH&J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\u0006\u0010\u000e\u001a\u00020\u001fH&J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\u0006\u0010\u000e\u001a\u00020\"H&J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\u0006\u0010\u0005\u001a\u00020%H&J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H&J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u00032\u0006\u0010\u0005\u001a\u00020(H&J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001d0\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006*À\u0006\u0001"}, d2 = {"Landroidx/health/platform/client/HealthDataAsyncClient;", "", "aggregate", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/health/platform/client/proto/ResponseProto$AggregateDataResponse;", "request", "Landroidx/health/platform/client/proto/RequestProto$AggregateDataRequest;", "deleteData", "", "uidsCollection", "", "Landroidx/health/platform/client/proto/RequestProto$DataTypeIdPair;", "clientIdsCollection", "deleteDataRange", "dataCollection", "Landroidx/health/platform/client/proto/RequestProto$DeleteDataRangeRequest;", "filterGrantedPermissions", "", "Landroidx/health/platform/client/proto/PermissionProto$Permission;", "permissions", "getChanges", "Landroidx/health/platform/client/proto/ResponseProto$GetChangesResponse;", "Landroidx/health/platform/client/proto/RequestProto$GetChangesRequest;", "getChangesToken", "Landroidx/health/platform/client/proto/ResponseProto$GetChangesTokenResponse;", "Landroidx/health/platform/client/proto/RequestProto$GetChangesTokenRequest;", "getGrantedPermissions", "insertData", "", "Landroidx/health/platform/client/proto/DataProto$DataPoint;", "readData", "Landroidx/health/platform/client/proto/RequestProto$ReadDataRequest;", "readDataRange", "Landroidx/health/platform/client/proto/ResponseProto$ReadDataRangeResponse;", "Landroidx/health/platform/client/proto/RequestProto$ReadDataRangeRequest;", "registerForDataNotifications", "Ljava/lang/Void;", "Landroidx/health/platform/client/proto/RequestProto$RegisterForDataNotificationsRequest;", "revokeAllPermissions", "unregisterFromDataNotifications", "Landroidx/health/platform/client/proto/RequestProto$UnregisterFromDataNotificationsRequest;", "updateData", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface HealthDataAsyncClient {
    ListenableFuture<ResponseProto.AggregateDataResponse> aggregate(RequestProto.AggregateDataRequest request);

    ListenableFuture<Unit> deleteData(List<RequestProto.DataTypeIdPair> uidsCollection, List<RequestProto.DataTypeIdPair> clientIdsCollection);

    ListenableFuture<Unit> deleteDataRange(RequestProto.DeleteDataRangeRequest dataCollection);

    ListenableFuture<Set<PermissionProto.Permission>> filterGrantedPermissions(Set<PermissionProto.Permission> permissions);

    ListenableFuture<ResponseProto.GetChangesResponse> getChanges(RequestProto.GetChangesRequest request);

    ListenableFuture<ResponseProto.GetChangesTokenResponse> getChangesToken(RequestProto.GetChangesTokenRequest request);

    ListenableFuture<Set<PermissionProto.Permission>> getGrantedPermissions(Set<PermissionProto.Permission> permissions);

    ListenableFuture<List<String>> insertData(List<DataProto.DataPoint> dataCollection);

    ListenableFuture<DataProto.DataPoint> readData(RequestProto.ReadDataRequest dataCollection);

    ListenableFuture<ResponseProto.ReadDataRangeResponse> readDataRange(RequestProto.ReadDataRangeRequest dataCollection);

    ListenableFuture<Void> registerForDataNotifications(RequestProto.RegisterForDataNotificationsRequest request);

    ListenableFuture<Unit> revokeAllPermissions();

    ListenableFuture<Void> unregisterFromDataNotifications(RequestProto.UnregisterFromDataNotificationsRequest request);

    ListenableFuture<Unit> updateData(List<DataProto.DataPoint> dataCollection);
}
