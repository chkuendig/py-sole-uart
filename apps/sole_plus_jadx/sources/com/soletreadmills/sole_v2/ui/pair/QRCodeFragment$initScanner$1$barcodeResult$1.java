package com.soletreadmills.sole_v2.ui.pair;

import com.journeyapps.barcodescanner.BarcodeView;
import com.soletreadmills.sole_v2.databinding.FragmentQrcodeBinding;
import com.soletreadmills.sole_v2.ui.pair.QRCodeFragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

/* compiled from: QRCodeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.QRCodeFragment$initScanner$1$barcodeResult$1", f = "QRCodeFragment.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class QRCodeFragment$initScanner$1$barcodeResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ QRCodeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QRCodeFragment$initScanner$1$barcodeResult$1(QRCodeFragment qRCodeFragment, String str, Continuation<? super QRCodeFragment$initScanner$1$barcodeResult$1> continuation) {
        super(2, continuation);
        this.this$0 = qRCodeFragment;
        this.$text = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QRCodeFragment$initScanner$1$barcodeResult$1(this.this$0, this.$text, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QRCodeFragment$initScanner$1$barcodeResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BarcodeView barcodeView;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.showLoading();
            this.label = 1;
            obj = this.this$0.callQrApi(this.$text, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.stopLoading();
        if (((QRCodeFragment.ApiOutcome) obj).getOk()) {
            Timber.INSTANCE.i("QR API success", new Object[0]);
            this.this$0.goPrevPage();
        } else {
            Timber.INSTANCE.i("QR API fail", new Object[0]);
            this.this$0.inFlight = false;
            FragmentQrcodeBinding fragmentQrcodeBindingAccess$getBinding = QRCodeFragment.access$getBinding(this.this$0);
            if (fragmentQrcodeBindingAccess$getBinding != null && (barcodeView = fragmentQrcodeBindingAccess$getBinding.barcodeView) != null) {
                barcodeView.resume();
            }
        }
        return Unit.INSTANCE;
    }
}
