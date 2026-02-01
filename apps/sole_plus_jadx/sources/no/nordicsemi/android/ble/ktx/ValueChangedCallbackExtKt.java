package no.nordicsemi.android.ble.ktx;

import android.bluetooth.BluetoothDevice;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import no.nordicsemi.android.ble.ValueChangedCallback;
import no.nordicsemi.android.ble.callback.DataReceivedCallback;
import no.nordicsemi.android.ble.callback.profile.ProfileReadResponse;
import no.nordicsemi.android.ble.data.Data;
import no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt;
import no.nordicsemi.android.ble.response.ReadResponse;
import org.objectweb.asm.Opcodes;

/* compiled from: ValueChangedCallbackExt.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\u0003H\u0087\b\u001a\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\b*\u00020\u0003H\u0087\b¨\u0006\t"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "Lno/nordicsemi/android/ble/data/Data;", "Lno/nordicsemi/android/ble/ValueChangedCallback;", "asResponseFlow", ExifInterface.GPS_DIRECTION_TRUE, "Lno/nordicsemi/android/ble/response/ReadResponse;", "asValidResponseFlow", "Lno/nordicsemi/android/ble/callback/profile/ProfileReadResponse;", "ble-ktx_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ValueChangedCallbackExtKt {

    /* compiled from: ValueChangedCallbackExt.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lno/nordicsemi/android/ble/data/Data;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt$asFlow$1", f = "ValueChangedCallbackExt.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt$asFlow$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super Data>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ValueChangedCallback $this_asFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ValueChangedCallback valueChangedCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_asFlow = valueChangedCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Data> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                this.$this_asFlow.setHandler(null);
                this.$this_asFlow.with(new DataReceivedCallback() { // from class: no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt$asFlow$1$$ExternalSyntheticLambda0
                    @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
                    public final void onDataReceived(BluetoothDevice bluetoothDevice, Data data) {
                        ValueChangedCallbackExtKt.AnonymousClass1.invokeSuspend$lambda$0(producerScope, bluetoothDevice, data);
                    }
                });
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new AnonymousClass2(this.$this_asFlow), this) == coroutine_suspended) {
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
        public static final void invokeSuspend$lambda$0(ProducerScope producerScope, BluetoothDevice bluetoothDevice, Data data) {
            Intrinsics.checkNotNull(data);
            producerScope.mo10590trySendJP2dKIU(data);
        }

        /* compiled from: ValueChangedCallbackExt.kt */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt$asFlow$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            final /* synthetic */ ValueChangedCallback $this_asFlow;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(ValueChangedCallback valueChangedCallback) {
                super(0);
                this.$this_asFlow = valueChangedCallback;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invoke$lambda$0(BluetoothDevice bluetoothDevice, Data data) {
                Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(data, "<anonymous parameter 1>");
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.$this_asFlow.with(new DataReceivedCallback() { // from class: no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt$asFlow$1$2$$ExternalSyntheticLambda0
                    @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
                    public final void onDataReceived(BluetoothDevice bluetoothDevice, Data data) {
                        ValueChangedCallbackExtKt.AnonymousClass1.AnonymousClass2.invoke$lambda$0(bluetoothDevice, data);
                    }
                });
            }
        }
    }

    public static final Flow<Data> asFlow(ValueChangedCallback valueChangedCallback) {
        Intrinsics.checkNotNullParameter(valueChangedCallback, "<this>");
        return FlowKt.callbackFlow(new AnonymousClass1(valueChangedCallback, null));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ValueChangedCallbackExt.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lno/nordicsemi/android/ble/response/ReadResponse;", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = Opcodes.ARETURN)
    @DebugMetadata(c = "no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt$asResponseFlow$1", f = "ValueChangedCallbackExt.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt$asResponseFlow$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14031<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ValueChangedCallback $this_asResponseFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14031(ValueChangedCallback valueChangedCallback, Continuation<? super C14031> continuation) {
            super(2, continuation);
            this.$this_asResponseFlow = valueChangedCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.needClassReification();
            C14031 c14031 = new C14031(this.$this_asResponseFlow, continuation);
            c14031.L$0 = obj;
            return c14031;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
            return ((C14031) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                this.$this_asResponseFlow.setHandler(null);
                ValueChangedCallback valueChangedCallback = this.$this_asResponseFlow;
                Intrinsics.needClassReification();
                valueChangedCallback.with(new DataReceivedCallback() { // from class: no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt.asResponseFlow.1.1
                    @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
                    public final void onDataReceived(BluetoothDevice device, Data data) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                        Intrinsics.checkNotNullParameter(device, "device");
                        Intrinsics.checkNotNullParameter(data, "data");
                        ProducerScope<T> producerScope2 = producerScope;
                        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                        Object objNewInstance = ReadResponse.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        ((ReadResponse) objNewInstance).onDataReceived(device, data);
                        Intrinsics.checkNotNullExpressionValue(objNewInstance, "apply(...)");
                        producerScope2.mo10590trySendJP2dKIU(objNewInstance);
                    }
                });
                final ValueChangedCallback valueChangedCallback2 = this.$this_asResponseFlow;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt.asResponseFlow.1.2
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
                        valueChangedCallback2.with(new DataReceivedCallback() { // from class: no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt.asResponseFlow.1.2.1
                            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
                            public final void onDataReceived(BluetoothDevice bluetoothDevice, Data data) {
                                Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
                                Intrinsics.checkNotNullParameter(data, "<anonymous parameter 1>");
                            }
                        });
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
    }

    public static final /* synthetic */ <T extends ReadResponse> Flow<T> asResponseFlow(ValueChangedCallback valueChangedCallback) {
        Intrinsics.checkNotNullParameter(valueChangedCallback, "<this>");
        Intrinsics.needClassReification();
        return FlowKt.callbackFlow(new C14031(valueChangedCallback, null));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ValueChangedCallbackExt.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lno/nordicsemi/android/ble/callback/profile/ProfileReadResponse;", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = Opcodes.ARETURN)
    @DebugMetadata(c = "no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt$asValidResponseFlow$1", f = "ValueChangedCallbackExt.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt$asValidResponseFlow$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14041<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ValueChangedCallback $this_asValidResponseFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14041(ValueChangedCallback valueChangedCallback, Continuation<? super C14041> continuation) {
            super(2, continuation);
            this.$this_asValidResponseFlow = valueChangedCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.needClassReification();
            C14041 c14041 = new C14041(this.$this_asValidResponseFlow, continuation);
            c14041.L$0 = obj;
            return c14041;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
            return ((C14041) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                this.$this_asValidResponseFlow.setHandler(null);
                ValueChangedCallback valueChangedCallback = this.$this_asValidResponseFlow;
                Intrinsics.needClassReification();
                valueChangedCallback.with(new DataReceivedCallback() { // from class: no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt.asValidResponseFlow.1.1
                    @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
                    public final void onDataReceived(BluetoothDevice device, Data data) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                        Intrinsics.checkNotNullParameter(device, "device");
                        Intrinsics.checkNotNullParameter(data, "data");
                        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                        Object objNewInstance = ProfileReadResponse.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        ProfileReadResponse profileReadResponse = (ProfileReadResponse) objNewInstance;
                        profileReadResponse.onDataReceived(device, data);
                        if (!profileReadResponse.isValid()) {
                            objNewInstance = null;
                        }
                        ProfileReadResponse profileReadResponse2 = (ProfileReadResponse) objNewInstance;
                        if (profileReadResponse2 != null) {
                            producerScope.mo10590trySendJP2dKIU(profileReadResponse2);
                        }
                    }
                });
                final ValueChangedCallback valueChangedCallback2 = this.$this_asValidResponseFlow;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt.asValidResponseFlow.1.2
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
                        valueChangedCallback2.with(new DataReceivedCallback() { // from class: no.nordicsemi.android.ble.ktx.ValueChangedCallbackExtKt.asValidResponseFlow.1.2.1
                            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
                            public final void onDataReceived(BluetoothDevice bluetoothDevice, Data data) {
                                Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
                                Intrinsics.checkNotNullParameter(data, "<anonymous parameter 1>");
                            }
                        });
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
    }

    public static final /* synthetic */ <T extends ProfileReadResponse> Flow<T> asValidResponseFlow(ValueChangedCallback valueChangedCallback) {
        Intrinsics.checkNotNullParameter(valueChangedCallback, "<this>");
        Intrinsics.needClassReification();
        return FlowKt.callbackFlow(new C14041(valueChangedCallback, null));
    }
}
