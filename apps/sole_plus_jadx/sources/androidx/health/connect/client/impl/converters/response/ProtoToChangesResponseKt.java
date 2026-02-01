package androidx.health.connect.client.impl.converters.response;

import androidx.health.connect.client.changes.Change;
import androidx.health.connect.client.changes.DeletionChange;
import androidx.health.connect.client.changes.UpsertionChange;
import androidx.health.connect.client.impl.converters.records.ProtoToRecordConvertersKt;
import androidx.health.connect.client.response.ChangesResponse;
import androidx.health.platform.client.proto.ChangeProto;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.ResponseProto;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProtoToChangesResponse.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"extractChanges", "", "Landroidx/health/connect/client/changes/Change;", "changes", "Landroidx/health/platform/client/proto/ChangeProto$DataChange;", "toChangesResponse", "Landroidx/health/connect/client/response/ChangesResponse;", "proto", "Landroidx/health/platform/client/proto/ResponseProto$GetChangesResponse;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProtoToChangesResponseKt {
    public static final ChangesResponse toChangesResponse(ResponseProto.GetChangesResponse proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        List<ChangeProto.DataChange> changesList = proto.getChangesList();
        Intrinsics.checkNotNullExpressionValue(changesList, "proto.changesList");
        List<Change> listExtractChanges = extractChanges(changesList);
        String nextChangesToken = proto.getNextChangesToken();
        Intrinsics.checkNotNullExpressionValue(nextChangesToken, "proto.nextChangesToken");
        return new ChangesResponse(listExtractChanges, nextChangesToken, proto.getHasMore(), proto.getChangesTokenExpired());
    }

    private static final List<Change> extractChanges(List<ChangeProto.DataChange> list) {
        UpsertionChange upsertionChange;
        ArrayList arrayList = new ArrayList();
        for (ChangeProto.DataChange dataChange : list) {
            if (dataChange.hasDeleteUid()) {
                String deleteUid = dataChange.getDeleteUid();
                Intrinsics.checkNotNullExpressionValue(deleteUid, "it.deleteUid");
                upsertionChange = new DeletionChange(deleteUid);
            } else if (dataChange.hasUpsertDataPoint()) {
                DataProto.DataPoint upsertDataPoint = dataChange.getUpsertDataPoint();
                Intrinsics.checkNotNullExpressionValue(upsertDataPoint, "it.upsertDataPoint");
                upsertionChange = new UpsertionChange(ProtoToRecordConvertersKt.toRecord(upsertDataPoint));
            } else {
                upsertionChange = null;
            }
            if (upsertionChange != null) {
                arrayList.add(upsertionChange);
            }
        }
        return arrayList;
    }
}
