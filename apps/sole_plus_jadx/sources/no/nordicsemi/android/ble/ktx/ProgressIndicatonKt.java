package no.nordicsemi.android.ble.ktx;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import no.nordicsemi.android.ble.ReadRequest;
import no.nordicsemi.android.ble.ValueChangedCallback;
import no.nordicsemi.android.ble.WaitForReadRequest;
import no.nordicsemi.android.ble.WaitForValueChangedRequest;
import no.nordicsemi.android.ble.WriteRequest;
import no.nordicsemi.android.ble.callback.AfterCallback;
import no.nordicsemi.android.ble.callback.ClosedCallback;
import no.nordicsemi.android.ble.callback.ReadProgressCallback;
import no.nordicsemi.android.ble.callback.WriteProgressCallback;
import no.nordicsemi.android.ble.data.DataMerger;
import no.nordicsemi.android.ble.data.DataSplitter;
import no.nordicsemi.android.ble.data.DefaultMtuSplitter;
import no.nordicsemi.android.ble.ktx.ProgressIndicatonKt;

/* compiled from: ProgressIndicaton.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0010\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\t\u001a\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0010\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\f\u001a\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\f2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, d2 = {"mergeWithProgressFlow", "Lkotlinx/coroutines/flow/Flow;", "Lno/nordicsemi/android/ble/ktx/ProgressIndication;", "Lno/nordicsemi/android/ble/ReadRequest;", "merger", "Lno/nordicsemi/android/ble/data/DataMerger;", "Lno/nordicsemi/android/ble/ValueChangedCallback;", "Lno/nordicsemi/android/ble/WaitForValueChangedRequest;", "splitWithProgressFlow", "Lno/nordicsemi/android/ble/WaitForReadRequest;", "splitter", "Lno/nordicsemi/android/ble/data/DataSplitter;", "Lno/nordicsemi/android/ble/WriteRequest;", "ble-ktx_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ProgressIndicatonKt {
    public static final Flow<ProgressIndication> mergeWithProgressFlow(ReadRequest readRequest, DataMerger merger) {
        Intrinsics.checkNotNullParameter(readRequest, "<this>");
        Intrinsics.checkNotNullParameter(merger, "merger");
        readRequest.setHandler((Handler) null);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        readRequest.merge(merger, new ReadProgressCallback() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$$ExternalSyntheticLambda4
            @Override // no.nordicsemi.android.ble.callback.ReadProgressCallback
            public final void onPacketReceived(BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
                ProgressIndicatonKt.mergeWithProgressFlow$lambda$0(objectRef, bluetoothDevice, bArr, i);
            }
        });
        return FlowKt.callbackFlow(new AnonymousClass2(objectRef, readRequest, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mergeWithProgressFlow$lambda$0(Ref.ObjectRef callback, BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
        Function1 function1 = (Function1) callback.element;
        if (function1 != null) {
            function1.invoke(new ProgressIndication(i, bArr));
        }
    }

    /* compiled from: ProgressIndicaton.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lno/nordicsemi/android/ble/ktx/ProgressIndication;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$mergeWithProgressFlow$2", f = "ProgressIndicaton.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$mergeWithProgressFlow$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ProducerScope<? super ProgressIndication>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Function1<ProgressIndication, Unit>> $callback;
        final /* synthetic */ ReadRequest $this_mergeWithProgressFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<Function1<ProgressIndication, Unit>> objectRef, ReadRequest readRequest, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$callback = objectRef;
            this.$this_mergeWithProgressFlow = readRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$callback, this.$this_mergeWithProgressFlow, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super ProgressIndication> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [T, no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$mergeWithProgressFlow$2$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                this.$callback.element = new Function1<ProgressIndication, Unit>() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt.mergeWithProgressFlow.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ProgressIndication progressIndication) {
                        invoke2(progressIndication);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ProgressIndication it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        producerScope.mo10590trySendJP2dKIU(it);
                    }
                };
                this.$this_mergeWithProgressFlow.then(new AfterCallback() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$mergeWithProgressFlow$2$$ExternalSyntheticLambda0
                    @Override // no.nordicsemi.android.ble.callback.AfterCallback
                    public final void onRequestFinished(BluetoothDevice bluetoothDevice) {
                        ProgressIndicatonKt.AnonymousClass2.invokeSuspend$lambda$0(producerScope, bluetoothDevice);
                    }
                });
                final Ref.ObjectRef<Function1<ProgressIndication, Unit>> objectRef = this.$callback;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt.mergeWithProgressFlow.2.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        objectRef.element = null;
                    }
                }, this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ProducerScope producerScope, BluetoothDevice bluetoothDevice) {
            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
        }
    }

    public static final Flow<ProgressIndication> mergeWithProgressFlow(WaitForValueChangedRequest waitForValueChangedRequest, DataMerger merger) {
        Intrinsics.checkNotNullParameter(waitForValueChangedRequest, "<this>");
        Intrinsics.checkNotNullParameter(merger, "merger");
        waitForValueChangedRequest.setHandler((Handler) null);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        waitForValueChangedRequest.merge(merger, new ReadProgressCallback() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$$ExternalSyntheticLambda0
            @Override // no.nordicsemi.android.ble.callback.ReadProgressCallback
            public final void onPacketReceived(BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
                ProgressIndicatonKt.mergeWithProgressFlow$lambda$1(objectRef, bluetoothDevice, bArr, i);
            }
        });
        return FlowKt.callbackFlow(new AnonymousClass4(objectRef, waitForValueChangedRequest, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mergeWithProgressFlow$lambda$1(Ref.ObjectRef callback, BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
        Function1 function1 = (Function1) callback.element;
        if (function1 != null) {
            function1.invoke(new ProgressIndication(i, bArr));
        }
    }

    /* compiled from: ProgressIndicaton.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lno/nordicsemi/android/ble/ktx/ProgressIndication;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$mergeWithProgressFlow$4", f = "ProgressIndicaton.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$mergeWithProgressFlow$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2<ProducerScope<? super ProgressIndication>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Function1<ProgressIndication, Unit>> $callback;
        final /* synthetic */ WaitForValueChangedRequest $this_mergeWithProgressFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Ref.ObjectRef<Function1<ProgressIndication, Unit>> objectRef, WaitForValueChangedRequest waitForValueChangedRequest, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$callback = objectRef;
            this.$this_mergeWithProgressFlow = waitForValueChangedRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$callback, this.$this_mergeWithProgressFlow, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super ProgressIndication> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [T, no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$mergeWithProgressFlow$4$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                this.$callback.element = new Function1<ProgressIndication, Unit>() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt.mergeWithProgressFlow.4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ProgressIndication progressIndication) {
                        invoke2(progressIndication);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ProgressIndication it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        producerScope.mo10590trySendJP2dKIU(it);
                    }
                };
                this.$this_mergeWithProgressFlow.then(new AfterCallback() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$mergeWithProgressFlow$4$$ExternalSyntheticLambda0
                    @Override // no.nordicsemi.android.ble.callback.AfterCallback
                    public final void onRequestFinished(BluetoothDevice bluetoothDevice) {
                        ProgressIndicatonKt.AnonymousClass4.invokeSuspend$lambda$0(producerScope, bluetoothDevice);
                    }
                });
                final Ref.ObjectRef<Function1<ProgressIndication, Unit>> objectRef = this.$callback;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt.mergeWithProgressFlow.4.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        objectRef.element = null;
                    }
                }, this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ProducerScope producerScope, BluetoothDevice bluetoothDevice) {
            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
        }
    }

    public static final Flow<ProgressIndication> mergeWithProgressFlow(ValueChangedCallback valueChangedCallback, DataMerger merger) {
        Intrinsics.checkNotNullParameter(valueChangedCallback, "<this>");
        Intrinsics.checkNotNullParameter(merger, "merger");
        valueChangedCallback.setHandler(null);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        valueChangedCallback.merge(merger, new ReadProgressCallback() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$$ExternalSyntheticLambda2
            @Override // no.nordicsemi.android.ble.callback.ReadProgressCallback
            public final void onPacketReceived(BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
                ProgressIndicatonKt.mergeWithProgressFlow$lambda$2(objectRef, bluetoothDevice, bArr, i);
            }
        });
        return FlowKt.callbackFlow(new AnonymousClass6(objectRef, valueChangedCallback, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mergeWithProgressFlow$lambda$2(Ref.ObjectRef callback, BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
        Function1 function1 = (Function1) callback.element;
        if (function1 != null) {
            function1.invoke(new ProgressIndication(i, bArr));
        }
    }

    /* compiled from: ProgressIndicaton.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lno/nordicsemi/android/ble/ktx/ProgressIndication;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$mergeWithProgressFlow$6", f = "ProgressIndicaton.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$mergeWithProgressFlow$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function2<ProducerScope<? super ProgressIndication>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Function1<ProgressIndication, Unit>> $callback;
        final /* synthetic */ ValueChangedCallback $this_mergeWithProgressFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(Ref.ObjectRef<Function1<ProgressIndication, Unit>> objectRef, ValueChangedCallback valueChangedCallback, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$callback = objectRef;
            this.$this_mergeWithProgressFlow = valueChangedCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass6 anonymousClass6 = new AnonymousClass6(this.$callback, this.$this_mergeWithProgressFlow, continuation);
            anonymousClass6.L$0 = obj;
            return anonymousClass6;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super ProgressIndication> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [T, no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$mergeWithProgressFlow$6$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                this.$callback.element = new Function1<ProgressIndication, Unit>() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt.mergeWithProgressFlow.6.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ProgressIndication progressIndication) {
                        invoke2(progressIndication);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ProgressIndication it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        producerScope.mo10590trySendJP2dKIU(it);
                    }
                };
                this.$this_mergeWithProgressFlow.then(new ClosedCallback() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$mergeWithProgressFlow$6$$ExternalSyntheticLambda0
                    @Override // no.nordicsemi.android.ble.callback.ClosedCallback
                    public final void onClosed() {
                        ProgressIndicatonKt.AnonymousClass6.invokeSuspend$lambda$0(producerScope);
                    }
                });
                final Ref.ObjectRef<Function1<ProgressIndication, Unit>> objectRef = this.$callback;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt.mergeWithProgressFlow.6.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        objectRef.element = null;
                    }
                }, this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ProducerScope producerScope) {
            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
        }
    }

    public static final Flow<ProgressIndication> splitWithProgressFlow(WriteRequest writeRequest) {
        Intrinsics.checkNotNullParameter(writeRequest, "<this>");
        return splitWithProgressFlow(writeRequest, new DefaultMtuSplitter());
    }

    public static final Flow<ProgressIndication> splitWithProgressFlow(WriteRequest writeRequest, DataSplitter splitter) {
        Intrinsics.checkNotNullParameter(writeRequest, "<this>");
        Intrinsics.checkNotNullParameter(splitter, "splitter");
        writeRequest.setHandler((Handler) null);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        writeRequest.split(splitter, new WriteProgressCallback() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$$ExternalSyntheticLambda1
            @Override // no.nordicsemi.android.ble.callback.WriteProgressCallback
            public final void onPacketSent(BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
                ProgressIndicatonKt.splitWithProgressFlow$lambda$3(objectRef, bluetoothDevice, bArr, i);
            }
        });
        return FlowKt.callbackFlow(new C13992(objectRef, writeRequest, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void splitWithProgressFlow$lambda$3(Ref.ObjectRef callback, BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
        Function1 function1 = (Function1) callback.element;
        if (function1 != null) {
            function1.invoke(new ProgressIndication(i, bArr));
        }
    }

    /* compiled from: ProgressIndicaton.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lno/nordicsemi/android/ble/ktx/ProgressIndication;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$splitWithProgressFlow$2", f = "ProgressIndicaton.kt", i = {}, l = {165}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$splitWithProgressFlow$2, reason: invalid class name and case insensitive filesystem */
    static final class C13992 extends SuspendLambda implements Function2<ProducerScope<? super ProgressIndication>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Function1<ProgressIndication, Unit>> $callback;
        final /* synthetic */ WriteRequest $this_splitWithProgressFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13992(Ref.ObjectRef<Function1<ProgressIndication, Unit>> objectRef, WriteRequest writeRequest, Continuation<? super C13992> continuation) {
            super(2, continuation);
            this.$callback = objectRef;
            this.$this_splitWithProgressFlow = writeRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C13992 c13992 = new C13992(this.$callback, this.$this_splitWithProgressFlow, continuation);
            c13992.L$0 = obj;
            return c13992;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super ProgressIndication> producerScope, Continuation<? super Unit> continuation) {
            return ((C13992) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [T, no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$splitWithProgressFlow$2$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                this.$callback.element = new Function1<ProgressIndication, Unit>() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt.splitWithProgressFlow.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ProgressIndication progressIndication) {
                        invoke2(progressIndication);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ProgressIndication it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        producerScope.mo10590trySendJP2dKIU(it);
                    }
                };
                this.$this_splitWithProgressFlow.then(new AfterCallback() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$splitWithProgressFlow$2$$ExternalSyntheticLambda0
                    @Override // no.nordicsemi.android.ble.callback.AfterCallback
                    public final void onRequestFinished(BluetoothDevice bluetoothDevice) {
                        ProgressIndicatonKt.C13992.invokeSuspend$lambda$0(producerScope, bluetoothDevice);
                    }
                });
                final Ref.ObjectRef<Function1<ProgressIndication, Unit>> objectRef = this.$callback;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt.splitWithProgressFlow.2.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        objectRef.element = null;
                    }
                }, this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ProducerScope producerScope, BluetoothDevice bluetoothDevice) {
            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
        }
    }

    public static final Flow<ProgressIndication> splitWithProgressFlow(WaitForReadRequest waitForReadRequest) {
        Intrinsics.checkNotNullParameter(waitForReadRequest, "<this>");
        return splitWithProgressFlow(waitForReadRequest, new DefaultMtuSplitter());
    }

    public static final Flow<ProgressIndication> splitWithProgressFlow(WaitForReadRequest waitForReadRequest, DataSplitter splitter) {
        Intrinsics.checkNotNullParameter(waitForReadRequest, "<this>");
        Intrinsics.checkNotNullParameter(splitter, "splitter");
        waitForReadRequest.setHandler((Handler) null);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        waitForReadRequest.split(splitter, new WriteProgressCallback() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$$ExternalSyntheticLambda3
            @Override // no.nordicsemi.android.ble.callback.WriteProgressCallback
            public final void onPacketSent(BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
                ProgressIndicatonKt.splitWithProgressFlow$lambda$4(objectRef, bluetoothDevice, bArr, i);
            }
        });
        return FlowKt.callbackFlow(new C14004(objectRef, waitForReadRequest, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void splitWithProgressFlow$lambda$4(Ref.ObjectRef callback, BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
        Function1 function1 = (Function1) callback.element;
        if (function1 != null) {
            function1.invoke(new ProgressIndication(i, bArr));
        }
    }

    /* compiled from: ProgressIndicaton.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lno/nordicsemi/android/ble/ktx/ProgressIndication;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$splitWithProgressFlow$4", f = "ProgressIndicaton.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$splitWithProgressFlow$4, reason: invalid class name and case insensitive filesystem */
    static final class C14004 extends SuspendLambda implements Function2<ProducerScope<? super ProgressIndication>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Function1<ProgressIndication, Unit>> $callback;
        final /* synthetic */ WaitForReadRequest $this_splitWithProgressFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14004(Ref.ObjectRef<Function1<ProgressIndication, Unit>> objectRef, WaitForReadRequest waitForReadRequest, Continuation<? super C14004> continuation) {
            super(2, continuation);
            this.$callback = objectRef;
            this.$this_splitWithProgressFlow = waitForReadRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14004 c14004 = new C14004(this.$callback, this.$this_splitWithProgressFlow, continuation);
            c14004.L$0 = obj;
            return c14004;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super ProgressIndication> producerScope, Continuation<? super Unit> continuation) {
            return ((C14004) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [T, no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$splitWithProgressFlow$4$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                this.$callback.element = new Function1<ProgressIndication, Unit>() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt.splitWithProgressFlow.4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ProgressIndication progressIndication) {
                        invoke2(progressIndication);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ProgressIndication it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        producerScope.mo10590trySendJP2dKIU(it);
                    }
                };
                this.$this_splitWithProgressFlow.then(new AfterCallback() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt$splitWithProgressFlow$4$$ExternalSyntheticLambda0
                    @Override // no.nordicsemi.android.ble.callback.AfterCallback
                    public final void onRequestFinished(BluetoothDevice bluetoothDevice) {
                        ProgressIndicatonKt.C14004.invokeSuspend$lambda$0(producerScope, bluetoothDevice);
                    }
                });
                final Ref.ObjectRef<Function1<ProgressIndication, Unit>> objectRef = this.$callback;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: no.nordicsemi.android.ble.ktx.ProgressIndicatonKt.splitWithProgressFlow.4.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        objectRef.element = null;
                    }
                }, this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ProducerScope producerScope, BluetoothDevice bluetoothDevice) {
            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
        }
    }
}
