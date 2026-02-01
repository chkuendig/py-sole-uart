package androidx.health.connect.client.impl.platform.response;

import android.health.connect.datatypes.Record;
import androidx.health.connect.client.response.InsertRecordsResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InsertRecordsResponseConverter.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toKtResponse", "Landroidx/health/connect/client/response/InsertRecordsResponse;", "Landroid/health/connect/InsertRecordsResponse;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InsertRecordsResponseConverterKt {
    public static final InsertRecordsResponse toKtResponse(android.health.connect.InsertRecordsResponse insertRecordsResponse) {
        Intrinsics.checkNotNullParameter(insertRecordsResponse, "<this>");
        List<Record> records = insertRecordsResponse.getRecords();
        Intrinsics.checkNotNullExpressionValue(records, "records");
        List<Record> list = records;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String id2 = ((Record) it.next()).getMetadata().getId();
            Intrinsics.checkNotNullExpressionValue(id2, "record.metadata.id");
            arrayList.add(id2);
        }
        return new InsertRecordsResponse(arrayList);
    }
}
