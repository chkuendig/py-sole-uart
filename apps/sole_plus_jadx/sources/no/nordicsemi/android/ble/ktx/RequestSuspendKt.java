package no.nordicsemi.android.ble.ktx;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import no.nordicsemi.android.ble.MtuRequest;
import no.nordicsemi.android.ble.PhyRequest;
import no.nordicsemi.android.ble.ReadRequest;
import no.nordicsemi.android.ble.ReadRssiRequest;
import no.nordicsemi.android.ble.Request;
import no.nordicsemi.android.ble.TimeoutableRequest;
import no.nordicsemi.android.ble.WaitForReadRequest;
import no.nordicsemi.android.ble.WaitForValueChangedRequest;
import no.nordicsemi.android.ble.WriteRequest;
import no.nordicsemi.android.ble.callback.BeforeCallback;
import no.nordicsemi.android.ble.callback.DataReceivedCallback;
import no.nordicsemi.android.ble.callback.DataSentCallback;
import no.nordicsemi.android.ble.callback.FailCallback;
import no.nordicsemi.android.ble.callback.InvalidRequestCallback;
import no.nordicsemi.android.ble.callback.SuccessCallback;
import no.nordicsemi.android.ble.callback.profile.ProfileReadResponse;
import no.nordicsemi.android.ble.data.Data;
import no.nordicsemi.android.ble.exception.BluetoothDisabledException;
import no.nordicsemi.android.ble.exception.DeviceDisconnectedException;
import no.nordicsemi.android.ble.exception.InvalidDataException;
import no.nordicsemi.android.ble.exception.InvalidRequestException;
import no.nordicsemi.android.ble.exception.RequestFailedException;
import no.nordicsemi.android.ble.response.ReadResponse;
import no.nordicsemi.android.ble.response.WriteResponse;
import org.objectweb.asm.Opcodes;

/* compiled from: RequestSuspend.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004*\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\u0000\u001a\u00020\u0007*\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u0015\u0010\u0000\u001a\u00020\f*\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0015\u0010\u0000\u001a\u00020\f*\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0000\u001a\u00020\u0007*\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0000\u001a\u00020\u0007*\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u0015\u0010\u0000\u001a\u00020\u0007*\u00020\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0015\u0010\u0017\u001a\u00020\f*\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a!\u0010\u0018\u001a\u0002H\u0019\"\n\b\u0000\u0010\u0019\u0018\u0001*\u00020\u001a*\u00020\bH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\t\u001a!\u0010\u0018\u001a\u0002H\u0019\"\n\b\u0000\u0010\u0019\u0018\u0001*\u00020\u001b*\u00020\u0011H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a!\u0010\u0018\u001a\u0002H\u0019\"\n\b\u0000\u0010\u0019\u0018\u0001*\u00020\u001a*\u00020\u0013H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a!\u0010\u0018\u001a\u0002H\u0019\"\n\b\u0000\u0010\u0019\u0018\u0001*\u00020\u001b*\u00020\u0015H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a!\u0010\u001c\u001a\u0002H\u0019\"\n\b\u0000\u0010\u0019\u0018\u0001*\u00020\u001d*\u00020\bH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\t\u001a!\u0010\u001c\u001a\u0002H\u0019\"\n\b\u0000\u0010\u0019\u0018\u0001*\u00020\u001d*\u00020\u0013H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u0015\u0010\u001e\u001a\u00020\f*\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"suspend", "", "Lno/nordicsemi/android/ble/MtuRequest;", "(Lno/nordicsemi/android/ble/MtuRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Pair;", "Lno/nordicsemi/android/ble/PhyRequest;", "(Lno/nordicsemi/android/ble/PhyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lno/nordicsemi/android/ble/data/Data;", "Lno/nordicsemi/android/ble/ReadRequest;", "(Lno/nordicsemi/android/ble/ReadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lno/nordicsemi/android/ble/ReadRssiRequest;", "(Lno/nordicsemi/android/ble/ReadRssiRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lno/nordicsemi/android/ble/Request;", "(Lno/nordicsemi/android/ble/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lno/nordicsemi/android/ble/TimeoutableRequest;", "(Lno/nordicsemi/android/ble/TimeoutableRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lno/nordicsemi/android/ble/WaitForReadRequest;", "(Lno/nordicsemi/android/ble/WaitForReadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lno/nordicsemi/android/ble/WaitForValueChangedRequest;", "(Lno/nordicsemi/android/ble/WaitForValueChangedRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lno/nordicsemi/android/ble/WriteRequest;", "(Lno/nordicsemi/android/ble/WriteRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendCancellable", "suspendForResponse", ExifInterface.GPS_DIRECTION_TRUE, "Lno/nordicsemi/android/ble/response/ReadResponse;", "Lno/nordicsemi/android/ble/response/WriteResponse;", "suspendForValidResponse", "Lno/nordicsemi/android/ble/callback/profile/ProfileReadResponse;", "suspendNonCancellable", "ble-ktx_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RequestSuspendKt {

    /* compiled from: RequestSuspend.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "no.nordicsemi.android.ble.ktx.RequestSuspendKt", f = "RequestSuspend.kt", i = {0}, l = {219}, m = "suspend", n = {"result"}, s = {"L$0"})
    /* renamed from: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$11, reason: invalid class name */
    static final class AnonymousClass11 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass11(Continuation<? super AnonymousClass11> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RequestSuspendKt.suspend((PhyRequest) null, (Continuation<? super Pair<Integer, Integer>>) this);
        }
    }

    /* compiled from: RequestSuspend.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "no.nordicsemi.android.ble.ktx.RequestSuspendKt", f = "RequestSuspend.kt", i = {0}, l = {57}, m = "suspend", n = {"result"}, s = {"L$0"})
    /* renamed from: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$3, reason: invalid class name */
    static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RequestSuspendKt.suspend((WriteRequest) null, (Continuation<? super Data>) this);
        }
    }

    /* compiled from: RequestSuspend.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "no.nordicsemi.android.ble.ktx.RequestSuspendKt", f = "RequestSuspend.kt", i = {0}, l = {109}, m = "suspend", n = {"result"}, s = {"L$0"})
    /* renamed from: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$5, reason: invalid class name */
    static final class AnonymousClass5 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RequestSuspendKt.suspend((ReadRequest) null, (Continuation<? super Data>) this);
        }
    }

    /* compiled from: RequestSuspend.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "no.nordicsemi.android.ble.ktx.RequestSuspendKt", f = "RequestSuspend.kt", i = {0}, l = {Opcodes.PUTFIELD}, m = "suspend", n = {"result"}, s = {"L$0"})
    /* renamed from: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$7, reason: invalid class name */
    static final class AnonymousClass7 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RequestSuspendKt.suspend((ReadRssiRequest) null, (Continuation<? super Integer>) this);
        }
    }

    /* compiled from: RequestSuspend.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "no.nordicsemi.android.ble.ktx.RequestSuspendKt", f = "RequestSuspend.kt", i = {0}, l = {200}, m = "suspend", n = {"result"}, s = {"L$0"})
    /* renamed from: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$9, reason: invalid class name */
    static final class AnonymousClass9 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass9(Continuation<? super AnonymousClass9> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RequestSuspendKt.suspend((MtuRequest) null, (Continuation<? super Integer>) this);
        }
    }

    public static final Object suspend(Request request, Continuation<? super Unit> continuation) throws Throwable {
        Object objSuspendNonCancellable = suspendNonCancellable(request, continuation);
        return objSuspendNonCancellable == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSuspendNonCancellable : Unit.INSTANCE;
    }

    public static final Object suspend(TimeoutableRequest timeoutableRequest, Continuation<? super Unit> continuation) throws DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        Object objSuspendCancellable = suspendCancellable(timeoutableRequest, continuation);
        return objSuspendCancellable == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSuspendCancellable : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object suspend(no.nordicsemi.android.ble.WriteRequest r4, kotlin.coroutines.Continuation<? super no.nordicsemi.android.ble.data.Data> r5) throws no.nordicsemi.android.ble.exception.DeviceDisconnectedException, no.nordicsemi.android.ble.exception.RequestFailedException, no.nordicsemi.android.ble.exception.InvalidRequestException, no.nordicsemi.android.ble.exception.BluetoothDisabledException {
        /*
            boolean r0 = r5 instanceof no.nordicsemi.android.ble.ktx.RequestSuspendKt.AnonymousClass3
            if (r0 == 0) goto L14
            r0 = r5
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$3 r0 = (no.nordicsemi.android.ble.ktx.RequestSuspendKt.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$3 r0 = new no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$3
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L5a
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$$ExternalSyntheticLambda1 r2 = new no.nordicsemi.android.ble.ktx.RequestSuspendKt$$ExternalSyntheticLambda1
            r2.<init>()
            no.nordicsemi.android.ble.WriteRequest r4 = r4.with(r2)
            java.lang.String r2 = "with(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            no.nordicsemi.android.ble.Request r4 = (no.nordicsemi.android.ble.Request) r4
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = suspendNonCancellable(r4, r0)
            if (r4 != r1) goto L59
            return r1
        L59:
            r4 = r5
        L5a:
            T r4 = r4.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.ble.ktx.RequestSuspendKt.suspend(no.nordicsemi.android.ble.WriteRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void suspend$lambda$0(Ref.ObjectRef result, BluetoothDevice bluetoothDevice, Data data) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(data, "data");
        result.element = data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T extends WriteResponse> Object suspendForResponse(WriteRequest writeRequest, Continuation<? super T> continuation) throws DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        WriteRequest writeRequestBefore = writeRequest.before(new BeforeCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt.suspendForResponse.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // no.nordicsemi.android.ble.callback.BeforeCallback
            public final void onRequestStarted(BluetoothDevice d) {
                Intrinsics.checkNotNullParameter(d, "d");
                objectRef.element = d;
            }
        });
        Intrinsics.checkNotNullExpressionValue(writeRequestBefore, "before(...)");
        InlineMarker.mark(0);
        Object objSuspend = suspend(writeRequestBefore, (Continuation<? super Data>) continuation);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        WriteResponse writeResponse = (WriteResponse) WriteResponse.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        T t = objectRef.element;
        Intrinsics.checkNotNull(t);
        writeResponse.onDataSent((BluetoothDevice) t, (Data) objSuspend);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(writeResponse, "let(...)");
        return writeResponse;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object suspend(no.nordicsemi.android.ble.ReadRequest r4, kotlin.coroutines.Continuation<? super no.nordicsemi.android.ble.data.Data> r5) throws no.nordicsemi.android.ble.exception.DeviceDisconnectedException, no.nordicsemi.android.ble.exception.RequestFailedException, no.nordicsemi.android.ble.exception.InvalidRequestException, no.nordicsemi.android.ble.exception.BluetoothDisabledException {
        /*
            boolean r0 = r5 instanceof no.nordicsemi.android.ble.ktx.RequestSuspendKt.AnonymousClass5
            if (r0 == 0) goto L14
            r0 = r5
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$5 r0 = (no.nordicsemi.android.ble.ktx.RequestSuspendKt.AnonymousClass5) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$5 r0 = new no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$5
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L5a
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$$ExternalSyntheticLambda3 r2 = new no.nordicsemi.android.ble.ktx.RequestSuspendKt$$ExternalSyntheticLambda3
            r2.<init>()
            no.nordicsemi.android.ble.ReadRequest r4 = r4.with(r2)
            java.lang.String r2 = "with(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            no.nordicsemi.android.ble.Request r4 = (no.nordicsemi.android.ble.Request) r4
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = suspendNonCancellable(r4, r0)
            if (r4 != r1) goto L59
            return r1
        L59:
            r4 = r5
        L5a:
            T r4 = r4.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.ble.ktx.RequestSuspendKt.suspend(no.nordicsemi.android.ble.ReadRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void suspend$lambda$3(Ref.ObjectRef result, BluetoothDevice bluetoothDevice, Data data) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(data, "data");
        result.element = data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T extends ReadResponse> Object suspendForResponse(ReadRequest readRequest, Continuation<? super T> continuation) throws DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ReadRequest readRequestBefore = readRequest.before((BeforeCallback) new C14025(objectRef));
        Intrinsics.checkNotNullExpressionValue(readRequestBefore, "before(...)");
        InlineMarker.mark(0);
        Object objSuspend = suspend(readRequestBefore, (Continuation<? super Data>) continuation);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ReadResponse readResponse = (ReadResponse) ReadResponse.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        T t = objectRef.element;
        Intrinsics.checkNotNull(t);
        readResponse.onDataReceived((BluetoothDevice) t, (Data) objSuspend);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(readResponse, "let(...)");
        return readResponse;
    }

    /* compiled from: RequestSuspend.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lno/nordicsemi/android/ble/response/ReadResponse;", "d", "Landroid/bluetooth/BluetoothDevice;", "onRequestStarted"}, k = 3, mv = {1, 9, 0}, xi = Opcodes.ARETURN)
    /* renamed from: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspendForResponse$5, reason: invalid class name and case insensitive filesystem */
    public static final class C14025 implements BeforeCallback {
        final /* synthetic */ Ref.ObjectRef<BluetoothDevice> $device;

        public C14025(Ref.ObjectRef<BluetoothDevice> objectRef) {
            this.$device = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // no.nordicsemi.android.ble.callback.BeforeCallback
        public final void onRequestStarted(BluetoothDevice d) {
            Intrinsics.checkNotNullParameter(d, "d");
            this.$device.element = d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object suspend(no.nordicsemi.android.ble.ReadRssiRequest r4, kotlin.coroutines.Continuation<? super java.lang.Integer> r5) throws no.nordicsemi.android.ble.exception.DeviceDisconnectedException, no.nordicsemi.android.ble.exception.RequestFailedException, no.nordicsemi.android.ble.exception.InvalidRequestException, no.nordicsemi.android.ble.exception.BluetoothDisabledException {
        /*
            boolean r0 = r5 instanceof no.nordicsemi.android.ble.ktx.RequestSuspendKt.AnonymousClass7
            if (r0 == 0) goto L14
            r0 = r5
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$7 r0 = (no.nordicsemi.android.ble.ktx.RequestSuspendKt.AnonymousClass7) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$7 r0 = new no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$7
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L5a
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$$ExternalSyntheticLambda4 r2 = new no.nordicsemi.android.ble.ktx.RequestSuspendKt$$ExternalSyntheticLambda4
            r2.<init>()
            no.nordicsemi.android.ble.ReadRssiRequest r4 = r4.with(r2)
            java.lang.String r2 = "with(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            no.nordicsemi.android.ble.Request r4 = (no.nordicsemi.android.ble.Request) r4
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = suspendNonCancellable(r4, r0)
            if (r4 != r1) goto L59
            return r1
        L59:
            r4 = r5
        L5a:
            T r4 = r4.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.ble.ktx.RequestSuspendKt.suspend(no.nordicsemi.android.ble.ReadRssiRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Integer] */
    public static final void suspend$lambda$7(Ref.ObjectRef result, BluetoothDevice bluetoothDevice, int i) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
        result.element = Integer.valueOf(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object suspend(no.nordicsemi.android.ble.MtuRequest r4, kotlin.coroutines.Continuation<? super java.lang.Integer> r5) throws no.nordicsemi.android.ble.exception.DeviceDisconnectedException, no.nordicsemi.android.ble.exception.RequestFailedException, no.nordicsemi.android.ble.exception.InvalidRequestException, no.nordicsemi.android.ble.exception.BluetoothDisabledException {
        /*
            boolean r0 = r5 instanceof no.nordicsemi.android.ble.ktx.RequestSuspendKt.AnonymousClass9
            if (r0 == 0) goto L14
            r0 = r5
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$9 r0 = (no.nordicsemi.android.ble.ktx.RequestSuspendKt.AnonymousClass9) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$9 r0 = new no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$9
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L5a
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$$ExternalSyntheticLambda0 r2 = new no.nordicsemi.android.ble.ktx.RequestSuspendKt$$ExternalSyntheticLambda0
            r2.<init>()
            no.nordicsemi.android.ble.MtuRequest r4 = r4.with(r2)
            java.lang.String r2 = "with(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            no.nordicsemi.android.ble.Request r4 = (no.nordicsemi.android.ble.Request) r4
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = suspendNonCancellable(r4, r0)
            if (r4 != r1) goto L59
            return r1
        L59:
            r4 = r5
        L5a:
            T r4 = r4.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.ble.ktx.RequestSuspendKt.suspend(no.nordicsemi.android.ble.MtuRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Integer] */
    public static final void suspend$lambda$8(Ref.ObjectRef result, BluetoothDevice bluetoothDevice, int i) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
        result.element = Integer.valueOf(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object suspend(no.nordicsemi.android.ble.PhyRequest r4, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Integer, java.lang.Integer>> r5) throws no.nordicsemi.android.ble.exception.DeviceDisconnectedException, no.nordicsemi.android.ble.exception.RequestFailedException, no.nordicsemi.android.ble.exception.InvalidRequestException, no.nordicsemi.android.ble.exception.BluetoothDisabledException {
        /*
            boolean r0 = r5 instanceof no.nordicsemi.android.ble.ktx.RequestSuspendKt.AnonymousClass11
            if (r0 == 0) goto L14
            r0 = r5
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$11 r0 = (no.nordicsemi.android.ble.ktx.RequestSuspendKt.AnonymousClass11) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$11 r0 = new no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$11
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L5a
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            no.nordicsemi.android.ble.ktx.RequestSuspendKt$$ExternalSyntheticLambda2 r2 = new no.nordicsemi.android.ble.ktx.RequestSuspendKt$$ExternalSyntheticLambda2
            r2.<init>()
            no.nordicsemi.android.ble.PhyRequest r4 = r4.with(r2)
            java.lang.String r2 = "with(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            no.nordicsemi.android.ble.Request r4 = (no.nordicsemi.android.ble.Request) r4
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = suspendNonCancellable(r4, r0)
            if (r4 != r1) goto L59
            return r1
        L59:
            r4 = r5
        L5a:
            T r4 = r4.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.ble.ktx.RequestSuspendKt.suspend(no.nordicsemi.android.ble.PhyRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.Pair] */
    public static final void suspend$lambda$9(Ref.ObjectRef result, BluetoothDevice bluetoothDevice, int i, int i2) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
        result.element = TuplesKt.to(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T extends ReadResponse> Object suspendForResponse(WaitForValueChangedRequest waitForValueChangedRequest, Continuation<? super T> continuation) throws DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        WaitForValueChangedRequest waitForValueChangedRequestBefore = waitForValueChangedRequest.before((BeforeCallback) new AnonymousClass8(objectRef));
        Intrinsics.checkNotNullExpressionValue(waitForValueChangedRequestBefore, "before(...)");
        InlineMarker.mark(0);
        Object objSuspend = suspend(waitForValueChangedRequestBefore, (Continuation<? super Data>) continuation);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ReadResponse readResponse = (ReadResponse) ReadResponse.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        T t = objectRef.element;
        Intrinsics.checkNotNull(t);
        readResponse.onDataReceived((BluetoothDevice) t, (Data) objSuspend);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(readResponse, "let(...)");
        return readResponse;
    }

    /* compiled from: RequestSuspend.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lno/nordicsemi/android/ble/response/ReadResponse;", "d", "Landroid/bluetooth/BluetoothDevice;", "onRequestStarted"}, k = 3, mv = {1, 9, 0}, xi = Opcodes.ARETURN)
    /* renamed from: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspendForResponse$8, reason: invalid class name */
    public static final class AnonymousClass8 implements BeforeCallback {
        final /* synthetic */ Ref.ObjectRef<BluetoothDevice> $device;

        public AnonymousClass8(Ref.ObjectRef<BluetoothDevice> objectRef) {
            this.$device = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // no.nordicsemi.android.ble.callback.BeforeCallback
        public final void onRequestStarted(BluetoothDevice d) {
            Intrinsics.checkNotNullParameter(d, "d");
            this.$device.element = d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T extends WriteResponse> Object suspendForResponse(WaitForReadRequest waitForReadRequest, Continuation<? super T> continuation) throws DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        WaitForReadRequest waitForReadRequestBefore = waitForReadRequest.before(new BeforeCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt.suspendForResponse.11
            /* JADX WARN: Multi-variable type inference failed */
            @Override // no.nordicsemi.android.ble.callback.BeforeCallback
            public final void onRequestStarted(BluetoothDevice d) {
                Intrinsics.checkNotNullParameter(d, "d");
                objectRef.element = d;
            }
        });
        Intrinsics.checkNotNullExpressionValue(waitForReadRequestBefore, "before(...)");
        InlineMarker.mark(0);
        Object objSuspend = suspend(waitForReadRequestBefore, (Continuation<? super Data>) continuation);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        WriteResponse writeResponse = (WriteResponse) WriteResponse.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        T t = objectRef.element;
        Intrinsics.checkNotNull(t);
        writeResponse.onDataSent((BluetoothDevice) t, (Data) objSuspend);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(writeResponse, "let(...)");
        return writeResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object suspendNonCancellable(final Request request, Continuation<? super Unit> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        request.setHandler(null).invalid(new InvalidRequestCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspendNonCancellable$2$1
            @Override // no.nordicsemi.android.ble.callback.InvalidRequestCallback
            public final void onInvalidRequest() {
                Continuation<Unit> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m9087constructorimpl(ResultKt.createFailure(new InvalidRequestException(request))));
            }
        }).fail(new FailCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspendNonCancellable$2$2
            @Override // no.nordicsemi.android.ble.callback.FailCallback
            public final void onRequestFailed(BluetoothDevice bluetoothDevice, int i) {
                BluetoothDisabledException bluetoothDisabledException;
                Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
                if (i == -100) {
                    bluetoothDisabledException = new BluetoothDisabledException();
                } else if (i == -1) {
                    bluetoothDisabledException = new DeviceDisconnectedException();
                } else {
                    bluetoothDisabledException = new RequestFailedException(request, i);
                }
                Continuation<Unit> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m9087constructorimpl(ResultKt.createFailure(bluetoothDisabledException)));
            }
        }).done(new SuccessCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspendNonCancellable$2$3
            @Override // no.nordicsemi.android.ble.callback.SuccessCallback
            public final void onRequestCompleted(BluetoothDevice it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Continuation<Unit> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m9087constructorimpl(Unit.INSTANCE));
            }
        }).enqueue();
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T extends ProfileReadResponse> Object suspendForValidResponse(ReadRequest readRequest, Continuation<? super T> continuation) throws InvalidDataException, DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ReadRequest readRequestBefore = readRequest.before((BeforeCallback) new C14025(objectRef));
        Intrinsics.checkNotNullExpressionValue(readRequestBefore, "before(...)");
        InlineMarker.mark(0);
        Object objSuspend = suspend(readRequestBefore, (Continuation<? super Data>) continuation);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ReadResponse readResponse = (ReadResponse) ReadResponse.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        T t = objectRef.element;
        Intrinsics.checkNotNull(t);
        readResponse.onDataReceived((BluetoothDevice) t, (Data) objSuspend);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(readResponse, "let(...)");
        ProfileReadResponse profileReadResponse = (ProfileReadResponse) readResponse;
        ProfileReadResponse profileReadResponse2 = Boolean.valueOf(profileReadResponse.isValid()).booleanValue() ? profileReadResponse : null;
        if (profileReadResponse2 != null) {
            return profileReadResponse2;
        }
        throw new InvalidDataException(profileReadResponse);
    }

    public static final Object suspend(final WaitForValueChangedRequest waitForValueChangedRequest, Continuation<? super Data> continuation) throws DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$14$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                waitForValueChangedRequest.cancel();
            }
        });
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        waitForValueChangedRequest.with(new DataReceivedCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$14$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // no.nordicsemi.android.ble.callback.DataReceivedCallback
            public final void onDataReceived(BluetoothDevice bluetoothDevice, Data d) {
                Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(d, "d");
                objectRef.element = d;
            }
        }).invalid(new InvalidRequestCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$14$3
            @Override // no.nordicsemi.android.ble.callback.InvalidRequestCallback
            public final void onInvalidRequest() {
                CancellableContinuation<Data> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m9087constructorimpl(ResultKt.createFailure(new InvalidRequestException(waitForValueChangedRequest))));
            }
        }).fail(new FailCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$14$4
            @Override // no.nordicsemi.android.ble.callback.FailCallback
            public final void onRequestFailed(BluetoothDevice bluetoothDevice, int i) {
                BluetoothDisabledException bluetoothDisabledException;
                Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
                if (i == -100) {
                    bluetoothDisabledException = new BluetoothDisabledException();
                } else {
                    if (i == -7) {
                        return;
                    }
                    if (i == -1) {
                        bluetoothDisabledException = new DeviceDisconnectedException();
                    } else {
                        bluetoothDisabledException = new RequestFailedException(waitForValueChangedRequest, i);
                    }
                }
                CancellableContinuation<Data> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m9087constructorimpl(ResultKt.createFailure(bluetoothDisabledException)));
            }
        }).done(new SuccessCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$14$5
            @Override // no.nordicsemi.android.ble.callback.SuccessCallback
            public final void onRequestCompleted(BluetoothDevice it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuation<Data> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                Data data = objectRef.element;
                Intrinsics.checkNotNull(data);
                cancellableContinuation.resumeWith(Result.m9087constructorimpl(data));
            }
        }).enqueue();
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T extends ProfileReadResponse> Object suspendForValidResponse(WaitForValueChangedRequest waitForValueChangedRequest, Continuation<? super T> continuation) throws InvalidDataException, DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        WaitForValueChangedRequest waitForValueChangedRequestBefore = waitForValueChangedRequest.before((BeforeCallback) new AnonymousClass8(objectRef));
        Intrinsics.checkNotNullExpressionValue(waitForValueChangedRequestBefore, "before(...)");
        InlineMarker.mark(0);
        Object objSuspend = suspend(waitForValueChangedRequestBefore, (Continuation<? super Data>) continuation);
        InlineMarker.mark(1);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ReadResponse readResponse = (ReadResponse) ReadResponse.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        T t = objectRef.element;
        Intrinsics.checkNotNull(t);
        readResponse.onDataReceived((BluetoothDevice) t, (Data) objSuspend);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(readResponse, "let(...)");
        ProfileReadResponse profileReadResponse = (ProfileReadResponse) readResponse;
        ProfileReadResponse profileReadResponse2 = Boolean.valueOf(profileReadResponse.isValid()).booleanValue() ? profileReadResponse : null;
        if (profileReadResponse2 != null) {
            return profileReadResponse2;
        }
        throw new InvalidDataException(profileReadResponse);
    }

    public static final Object suspend(final WaitForReadRequest waitForReadRequest, Continuation<? super Data> continuation) throws DeviceDisconnectedException, RequestFailedException, InvalidRequestException, BluetoothDisabledException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$16$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                waitForReadRequest.cancel();
            }
        });
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        waitForReadRequest.setHandler((Handler) null).with(new DataSentCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$16$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // no.nordicsemi.android.ble.callback.DataSentCallback
            public final void onDataSent(BluetoothDevice bluetoothDevice, Data d) {
                Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(d, "d");
                objectRef.element = d;
            }
        }).invalid(new InvalidRequestCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$16$3
            @Override // no.nordicsemi.android.ble.callback.InvalidRequestCallback
            public final void onInvalidRequest() {
                CancellableContinuation<Data> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m9087constructorimpl(ResultKt.createFailure(new InvalidRequestException(waitForReadRequest))));
            }
        }).fail(new FailCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$16$4
            @Override // no.nordicsemi.android.ble.callback.FailCallback
            public final void onRequestFailed(BluetoothDevice bluetoothDevice, int i) {
                BluetoothDisabledException bluetoothDisabledException;
                Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
                if (i == -100) {
                    bluetoothDisabledException = new BluetoothDisabledException();
                } else {
                    if (i == -7) {
                        return;
                    }
                    if (i == -1) {
                        bluetoothDisabledException = new DeviceDisconnectedException();
                    } else {
                        bluetoothDisabledException = new RequestFailedException(waitForReadRequest, i);
                    }
                }
                CancellableContinuation<Data> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m9087constructorimpl(ResultKt.createFailure(bluetoothDisabledException)));
            }
        }).done(new SuccessCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspend$16$5
            @Override // no.nordicsemi.android.ble.callback.SuccessCallback
            public final void onRequestCompleted(BluetoothDevice it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuation<Data> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                Data data = objectRef.element;
                Intrinsics.checkNotNull(data);
                cancellableContinuation.resumeWith(Result.m9087constructorimpl(data));
            }
        }).enqueue();
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object suspendCancellable(final TimeoutableRequest timeoutableRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspendCancellable$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                timeoutableRequest.cancel();
            }
        });
        timeoutableRequest.setHandler((Handler) null).invalid(new InvalidRequestCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspendCancellable$2$2
            @Override // no.nordicsemi.android.ble.callback.InvalidRequestCallback
            public final void onInvalidRequest() {
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m9087constructorimpl(ResultKt.createFailure(new InvalidRequestException(timeoutableRequest))));
            }
        }).fail(new FailCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspendCancellable$2$3
            @Override // no.nordicsemi.android.ble.callback.FailCallback
            public final void onRequestFailed(BluetoothDevice bluetoothDevice, int i) {
                BluetoothDisabledException bluetoothDisabledException;
                Intrinsics.checkNotNullParameter(bluetoothDevice, "<anonymous parameter 0>");
                if (i == -100) {
                    bluetoothDisabledException = new BluetoothDisabledException();
                } else {
                    if (i == -7) {
                        return;
                    }
                    if (i == -1) {
                        bluetoothDisabledException = new DeviceDisconnectedException();
                    } else {
                        bluetoothDisabledException = new RequestFailedException(timeoutableRequest, i);
                    }
                }
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m9087constructorimpl(ResultKt.createFailure(bluetoothDisabledException)));
            }
        }).done(new SuccessCallback() { // from class: no.nordicsemi.android.ble.ktx.RequestSuspendKt$suspendCancellable$2$4
            @Override // no.nordicsemi.android.ble.callback.SuccessCallback
            public final void onRequestCompleted(BluetoothDevice it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m9087constructorimpl(Unit.INSTANCE));
            }
        }).enqueue();
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
