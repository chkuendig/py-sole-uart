package com.soletreadmills.sole_v2.ui.displayMode;

import androidx.exifinterface.media.ExifInterface;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: Merge.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayDashboardP3Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1", f = "DisplayDashboardP3Fragment.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class DisplayDashboardP3Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super FtmsBaseData>, Boolean, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ DisplayDashboardP3Fragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayDashboardP3Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1(Continuation continuation, DisplayDashboardP3Fragment displayDashboardP3Fragment) {
        super(3, continuation);
        this.this$0 = displayDashboardP3Fragment;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super FtmsBaseData> flowCollector, Boolean bool, Continuation<? super Unit> continuation) {
        DisplayDashboardP3Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1 displayDashboardP3Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1 = new DisplayDashboardP3Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1(continuation, this.this$0);
        displayDashboardP3Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1.L$0 = flowCollector;
        displayDashboardP3Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1.L$1 = bool;
        return displayDashboardP3Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            DisplayDashboardP3Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1 displayDashboardP3Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1 = this;
            Flow flowSample = ((Boolean) this.L$1).booleanValue() ? FlowKt.sample(FlowKt.filterNotNull(this.this$0.getViewModel().getFtmsData()), 1000L) : FlowKt.emptyFlow();
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, flowSample, displayDashboardP3Fragment$observeFtmsData$1$1$invokeSuspend$$inlined$flatMapLatest$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
