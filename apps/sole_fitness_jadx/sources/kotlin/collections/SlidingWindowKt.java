package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* compiled from: SlidingWindow.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\u000f"}, d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SlidingWindowKt {
    public static final void checkWindowSizeStep(int i, int i2) {
        String str;
        if (i > 0 && i2 > 0) {
            return;
        }
        if (i != i2) {
            str = "Both size " + i + " and step " + i2 + " must be greater than zero.";
        } else {
            str = "size " + i + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public static final <T> Sequence<List<T>> windowedSequence(final Sequence<? extends T> windowedSequence, final int i, final int i2, final boolean z, final boolean z2) {
        Intrinsics.checkNotNullParameter(windowedSequence, "$this$windowedSequence");
        checkWindowSizeStep(i, i2);
        return new Sequence<List<? extends T>>() { // from class: kotlin.collections.SlidingWindowKt$windowedSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<List<? extends T>> iterator() {
                return SlidingWindowKt.windowedIterator(windowedSequence.iterator(), i, i2, z, z2);
            }
        };
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SlidingWindow.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlin.collections.SlidingWindowKt$windowedIterator$1, reason: invalid class name */
    static final class AnonymousClass1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Iterator $iterator;
        final /* synthetic */ boolean $partialWindows;
        final /* synthetic */ boolean $reuseBuffer;
        final /* synthetic */ int $size;
        final /* synthetic */ int $step;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, int i2, Iterator it, boolean z, boolean z2, Continuation continuation) {
            super(2, continuation);
            this.$size = i;
            this.$step = i2;
            this.$iterator = it;
            this.$reuseBuffer = z;
            this.$partialWindows = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, completion);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00dd A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x013c  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0163  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a7 -> B:30:0x00a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0125 -> B:59:0x0128). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x015a -> B:72:0x015d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i;
            Iterator it;
            SequenceScope sequenceScope;
            AnonymousClass1<T> anonymousClass1;
            int i2;
            SequenceScope sequenceScope2;
            AnonymousClass1<T> anonymousClass12;
            ArrayList arrayList;
            Iterator it2;
            RingBuffer ringBufferExpanded;
            RingBuffer ringBuffer;
            SequenceScope sequenceScope3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                SequenceScope sequenceScope4 = (SequenceScope) this.L$0;
                int iCoerceAtMost = RangesKt.coerceAtMost(this.$size, 1024);
                i = this.$step - this.$size;
                if (i >= 0) {
                    ArrayList arrayList2 = new ArrayList(iCoerceAtMost);
                    i2 = 0;
                    sequenceScope2 = sequenceScope4;
                    anonymousClass12 = this;
                    arrayList = arrayList2;
                    it2 = this.$iterator;
                    while (it2.hasNext()) {
                    }
                    if (!arrayList.isEmpty()) {
                        anonymousClass12.L$0 = null;
                        anonymousClass12.L$1 = null;
                        anonymousClass12.L$2 = null;
                        anonymousClass12.label = 2;
                        if (sequenceScope2.yield(arrayList, anonymousClass12) == coroutine_suspended) {
                        }
                    }
                    return Unit.INSTANCE;
                }
                RingBuffer ringBuffer2 = new RingBuffer(iCoerceAtMost);
                it = this.$iterator;
                sequenceScope = sequenceScope4;
                anonymousClass1 = this;
                ringBufferExpanded = ringBuffer2;
                while (it.hasNext()) {
                }
                if (anonymousClass1.$partialWindows) {
                }
                return Unit.INSTANCE;
            }
            if (i3 == 1) {
                i2 = this.I$0;
                it2 = (Iterator) this.L$2;
                arrayList = (ArrayList) this.L$1;
                sequenceScope2 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                anonymousClass12 = this;
                if (anonymousClass12.$reuseBuffer) {
                    arrayList = new ArrayList(anonymousClass12.$size);
                } else {
                    arrayList.clear();
                }
                i = i2;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (i2 > 0) {
                        i2--;
                    } else {
                        arrayList.add(next);
                        if (arrayList.size() == anonymousClass12.$size) {
                            anonymousClass12.L$0 = sequenceScope2;
                            anonymousClass12.L$1 = arrayList;
                            anonymousClass12.L$2 = it2;
                            anonymousClass12.I$0 = i;
                            anonymousClass12.label = 1;
                            if (sequenceScope2.yield(arrayList, anonymousClass12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i2 = i;
                            if (anonymousClass12.$reuseBuffer) {
                            }
                            i = i2;
                            while (it2.hasNext()) {
                            }
                        }
                    }
                }
                if ((!arrayList.isEmpty()) && (anonymousClass12.$partialWindows || arrayList.size() == anonymousClass12.$size)) {
                    anonymousClass12.L$0 = null;
                    anonymousClass12.L$1 = null;
                    anonymousClass12.L$2 = null;
                    anonymousClass12.label = 2;
                    if (sequenceScope2.yield(arrayList, anonymousClass12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i3 != 2) {
                if (i3 == 3) {
                    it = (Iterator) this.L$2;
                    RingBuffer ringBuffer3 = (RingBuffer) this.L$1;
                    sequenceScope = (SequenceScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    anonymousClass1 = this;
                    RingBuffer ringBuffer4 = ringBuffer3;
                    ringBuffer4.removeFirst(anonymousClass1.$step);
                    ringBufferExpanded = ringBuffer4;
                    while (it.hasNext()) {
                        ringBufferExpanded.add((RingBuffer) it.next());
                        if (ringBufferExpanded.isFull()) {
                            int size = ringBufferExpanded.size();
                            int i4 = anonymousClass1.$size;
                            if (size >= i4) {
                                List arrayList3 = anonymousClass1.$reuseBuffer ? ringBufferExpanded : new ArrayList(ringBufferExpanded);
                                anonymousClass1.L$0 = sequenceScope;
                                anonymousClass1.L$1 = ringBufferExpanded;
                                anonymousClass1.L$2 = it;
                                anonymousClass1.label = 3;
                                ringBuffer4 = ringBufferExpanded;
                                if (sequenceScope.yield(arrayList3, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ringBuffer4.removeFirst(anonymousClass1.$step);
                                ringBufferExpanded = ringBuffer4;
                                while (it.hasNext()) {
                                }
                            } else {
                                ringBufferExpanded = ringBufferExpanded.expanded(i4);
                            }
                        }
                    }
                    if (anonymousClass1.$partialWindows) {
                        ringBuffer = ringBufferExpanded;
                        sequenceScope3 = sequenceScope;
                        if (ringBuffer.size() <= anonymousClass1.$step) {
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i3 == 4) {
                    ringBuffer = (RingBuffer) this.L$1;
                    sequenceScope3 = (SequenceScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    anonymousClass1 = this;
                    ringBuffer.removeFirst(anonymousClass1.$step);
                    if (ringBuffer.size() <= anonymousClass1.$step) {
                        List arrayList4 = anonymousClass1.$reuseBuffer ? ringBuffer : new ArrayList(ringBuffer);
                        anonymousClass1.L$0 = sequenceScope3;
                        anonymousClass1.L$1 = ringBuffer;
                        anonymousClass1.L$2 = null;
                        anonymousClass1.label = 4;
                        if (sequenceScope3.yield(arrayList4, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ringBuffer.removeFirst(anonymousClass1.$step);
                        if (ringBuffer.size() <= anonymousClass1.$step) {
                            if (!ringBuffer.isEmpty()) {
                                anonymousClass1.L$0 = null;
                                anonymousClass1.L$1 = null;
                                anonymousClass1.L$2 = null;
                                anonymousClass1.label = 5;
                                if (sequenceScope3.yield(ringBuffer, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                } else if (i3 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> iterator, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return !iterator.hasNext() ? EmptyIterator.INSTANCE : SequencesKt.iterator(new AnonymousClass1(i, i2, iterator, z2, z, null));
    }
}
