package androidx.health.connect.client.impl;

import android.health.connect.HealthConnectManager;
import android.health.connect.InsertRecordsResponse;
import androidx.core.os.OutcomeReceiverKt;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.records.Record;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: HealthConnectClientUpsideDownImpl.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroid/health/connect/InsertRecordsResponse;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.health.connect.client.impl.HealthConnectClientUpsideDownImpl$insertRecords$response$1", f = "HealthConnectClientUpsideDownImpl.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class HealthConnectClientUpsideDownImpl$insertRecords$response$1 extends SuspendLambda implements Function1<Continuation<? super InsertRecordsResponse>, Object> {
    final /* synthetic */ List<Record> $records;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ HealthConnectClientUpsideDownImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HealthConnectClientUpsideDownImpl$insertRecords$response$1(HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl, List<? extends Record> list, Continuation<? super HealthConnectClientUpsideDownImpl$insertRecords$response$1> continuation) {
        super(1, continuation);
        this.this$0 = healthConnectClientUpsideDownImpl;
        this.$records = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new HealthConnectClientUpsideDownImpl$insertRecords$response$1(this.this$0, this.$records, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super InsertRecordsResponse> continuation) {
        return ((HealthConnectClientUpsideDownImpl$insertRecords$response$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HealthConnectClientUpsideDownImpl healthConnectClientUpsideDownImpl = this.this$0;
            List<Record> list = this.$records;
            this.L$0 = healthConnectClientUpsideDownImpl;
            this.L$1 = list;
            this.label = 1;
            HealthConnectClientUpsideDownImpl$insertRecords$response$1 healthConnectClientUpsideDownImpl$insertRecords$response$1 = this;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(healthConnectClientUpsideDownImpl$insertRecords$response$1), 1);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            HealthConnectManager healthConnectManager = healthConnectClientUpsideDownImpl.healthConnectManager;
            List<Record> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(RecordConvertersKt.toPlatformRecord((Record) it.next()));
            }
            healthConnectManager.insertRecords(arrayList, healthConnectClientUpsideDownImpl.executor, OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl2));
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(healthConnectClientUpsideDownImpl$insertRecords$response$1);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
