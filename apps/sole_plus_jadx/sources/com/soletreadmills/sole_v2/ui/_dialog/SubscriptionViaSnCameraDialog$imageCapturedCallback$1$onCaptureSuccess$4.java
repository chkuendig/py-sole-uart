package com.soletreadmills.sole_v2.ui._dialog;

import androidx.appcompat.widget.AppCompatImageView;
import com.soletreadmills.sole_v2.databinding.DialogSubscriptionViaSnCameraBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SubscriptionViaSnCameraDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$4", f = "SubscriptionViaSnCameraDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubscriptionViaSnCameraDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$4(SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialog, Continuation<? super SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$4> continuation) {
        super(2, continuation);
        this.this$0 = subscriptionViaSnCameraDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$4(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DialogSubscriptionViaSnCameraBinding dialogSubscriptionViaSnCameraBinding = this.this$0.binding;
            AppCompatImageView appCompatImageView = dialogSubscriptionViaSnCameraBinding != null ? dialogSubscriptionViaSnCameraBinding.scanning : null;
            if (appCompatImageView != null) {
                appCompatImageView.setEnabled(true);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
