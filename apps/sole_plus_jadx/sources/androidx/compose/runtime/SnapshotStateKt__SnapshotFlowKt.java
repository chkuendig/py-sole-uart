package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: SnapshotFlow.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\b\b\u0000\u0010\u0002*\u0002H\u0007\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\t\u001a\u0002H\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\n\u001a \u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r\u001a%\u0010\u000e\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0002¢\u0006\u0002\b\u0014¨\u0006\u0015"}, d2 = {"collectAsState", "Landroidx/compose/runtime/State;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/StateFlow;", SdkConstants.ATTR_CONTEXT, "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "R", "Lkotlinx/coroutines/flow/Flow;", "initial", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "snapshotFlow", "block", "Lkotlin/Function0;", "intersects", "", "Landroidx/collection/MutableScatterSet;", "", "set", "", "intersects$SnapshotStateKt__SnapshotFlowKt", "runtime"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
/* loaded from: classes.dex */
final /* synthetic */ class SnapshotStateKt__SnapshotFlowKt {
    public static final <T> State<T> collectAsState(StateFlow<? extends T> stateFlow, CoroutineContext coroutineContext, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1439883919, "C(collectAsState)N(context)49@1914L30:SnapshotFlow.kt#9igjgp");
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1439883919, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:49)");
        }
        State<T> stateCollectAsState = SnapshotStateKt.collectAsState(stateFlow, stateFlow.getValue(), coroutineContext2, composer, (i & 14) | ((i << 3) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateCollectAsState;
    }

    public static final <T extends R, R> State<R> collectAsState(Flow<? extends T> flow, R r, CoroutineContext coroutineContext, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -606625098, "C(collectAsState)N(initial,context)65@2592L153,65@2555L190:SnapshotFlow.kt#9igjgp");
        if ((i2 & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-606625098, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:65)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1148839119, "CC(remember):SnapshotFlow.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(coroutineContext2) | composer.changedInstance(flow);
        SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1 snapshotStateKt__SnapshotFlowKt$collectAsState$1$1RememberedValue = composer.rememberedValue();
        if (zChangedInstance || snapshotStateKt__SnapshotFlowKt$collectAsState$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            snapshotStateKt__SnapshotFlowKt$collectAsState$1$1RememberedValue = new SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1(coroutineContext2, flow, null);
            composer.updateRememberedValue(snapshotStateKt__SnapshotFlowKt$collectAsState$1$1RememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State<R> stateProduceState = SnapshotStateKt.produceState(r, flow, coroutineContext2, (Function2) snapshotStateKt__SnapshotFlowKt$collectAsState$1$1RememberedValue, composer, ((i >> 3) & 14) | ((i << 3) & 112) | (i & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateProduceState;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SnapshotFlow.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {143, 147, 170}, m = "invokeSuspend", n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    /* renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1, reason: invalid class name */
    static final class AnonymousClass1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<T> $block;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function0<? extends T> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:32:0x00e6, B:36:0x00ef], limit reached: 76 */
        /* JADX WARN: Path cross not found for [B:40:0x00fe, B:55:0x013f], limit reached: 76 */
        /* JADX WARN: Path cross not found for [B:55:0x013f, B:40:0x00fe], limit reached: 76 */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00da A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00fe A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #1 {all -> 0x0052, blocks: (B:30:0x00e2, B:32:0x00e6, B:37:0x00f0, B:40:0x00fe, B:44:0x0114, B:46:0x011d, B:53:0x013b, B:54:0x013e, B:13:0x004d, B:41:0x0109, B:43:0x0111, B:50:0x0136, B:51:0x0139), top: B:67:0x004d, inners: #4 }] */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r10v14 */
        /* JADX WARN: Type inference failed for: r10v15 */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v9 */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r11v5 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 342
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(MutableScatterSet mutableScatterSet, Object obj) {
            if (obj instanceof StateObjectImpl) {
                ReaderKind.Companion companion = ReaderKind.INSTANCE;
                ((StateObjectImpl) obj).m4015recordReadInh_f27i8$runtime(ReaderKind.m3997constructorimpl(4));
            }
            mutableScatterSet.add(obj);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final kotlin.Unit invokeSuspend$lambda$2(kotlinx.coroutines.channels.Channel r16, java.util.Set r17, androidx.compose.runtime.snapshots.Snapshot r18) {
            /*
                r0 = r17
                boolean r1 = r0 instanceof androidx.compose.runtime.collection.ScatterSetWrapper
                r2 = 4
                if (r1 == 0) goto L61
                r1 = r0
                androidx.compose.runtime.collection.ScatterSetWrapper r1 = (androidx.compose.runtime.collection.ScatterSetWrapper) r1
                androidx.collection.ScatterSet r1 = r1.getSet$runtime()
                java.lang.Object[] r3 = r1.elements
                long[] r1 = r1.metadata
                int r4 = r1.length
                int r4 = r4 + (-2)
                if (r4 < 0) goto L95
                r5 = 0
                r6 = r5
            L19:
                r7 = r1[r6]
                long r9 = ~r7
                r11 = 7
                long r9 = r9 << r11
                long r9 = r9 & r7
                r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r9 = r9 & r11
                int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r9 == 0) goto L5c
                int r9 = r6 - r4
                int r9 = ~r9
                int r9 = r9 >>> 31
                r10 = 8
                int r9 = 8 - r9
                r11 = r5
            L33:
                if (r11 >= r9) goto L5a
                r12 = 255(0xff, double:1.26E-321)
                long r12 = r12 & r7
                r14 = 128(0x80, double:6.3E-322)
                int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r12 >= 0) goto L56
                int r12 = r6 << 3
                int r12 = r12 + r11
                r12 = r3[r12]
                boolean r13 = r12 instanceof androidx.compose.runtime.snapshots.StateObjectImpl
                if (r13 == 0) goto L92
                androidx.compose.runtime.snapshots.StateObjectImpl r12 = (androidx.compose.runtime.snapshots.StateObjectImpl) r12
                androidx.compose.runtime.snapshots.ReaderKind$Companion r13 = androidx.compose.runtime.snapshots.ReaderKind.INSTANCE
                int r13 = androidx.compose.runtime.snapshots.ReaderKind.m3997constructorimpl(r2)
                boolean r12 = r12.m4014isReadInh_f27i8$runtime(r13)
                if (r12 == 0) goto L56
                goto L92
            L56:
                long r7 = r7 >> r10
                int r11 = r11 + 1
                goto L33
            L5a:
                if (r9 != r10) goto L95
            L5c:
                if (r6 == r4) goto L95
                int r6 = r6 + 1
                goto L19
            L61:
                r1 = r0
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                boolean r3 = r1 instanceof java.util.Collection
                if (r3 == 0) goto L72
                r3 = r1
                java.util.Collection r3 = (java.util.Collection) r3
                boolean r3 = r3.isEmpty()
                if (r3 == 0) goto L72
                goto L95
            L72:
                java.util.Iterator r1 = r1.iterator()
            L76:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L95
                java.lang.Object r3 = r1.next()
                boolean r4 = r3 instanceof androidx.compose.runtime.snapshots.StateObjectImpl
                if (r4 == 0) goto L92
                androidx.compose.runtime.snapshots.StateObjectImpl r3 = (androidx.compose.runtime.snapshots.StateObjectImpl) r3
                androidx.compose.runtime.snapshots.ReaderKind$Companion r4 = androidx.compose.runtime.snapshots.ReaderKind.INSTANCE
                int r4 = androidx.compose.runtime.snapshots.ReaderKind.m3997constructorimpl(r2)
                boolean r3 = r3.m4014isReadInh_f27i8$runtime(r4)
                if (r3 == 0) goto L76
            L92:
                r16.mo10590trySendJP2dKIU(r17)
            L95:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.AnonymousClass1.invokeSuspend$lambda$2(kotlinx.coroutines.channels.Channel, java.util.Set, androidx.compose.runtime.snapshots.Snapshot):kotlin.Unit");
        }
    }

    public static final <T> Flow<T> snapshotFlow(Function0<? extends T> function0) {
        return FlowKt.flow(new AnonymousClass1(function0, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean intersects$SnapshotStateKt__SnapshotFlowKt(MutableScatterSet<Object> mutableScatterSet, Set<? extends Object> set) {
        MutableScatterSet<Object> mutableScatterSet2 = mutableScatterSet;
        Object[] objArr = mutableScatterSet2.elements;
        long[] jArr = mutableScatterSet2.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128 && set.contains(objArr[(i << 3) + i3])) {
                        return true;
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return false;
                }
            }
            if (i == length) {
                return false;
            }
            i++;
        }
    }
}
