package com.soletreadmills.sole_v2.ui._dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognizer;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.databinding.DialogSubscriptionViaSnCameraBinding;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbBase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

/* compiled from: SubscriptionViaSnCameraDialog.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/soletreadmills/sole_v2/ui/_dialog/SubscriptionViaSnCameraDialog$imageCapturedCallback$1", "Landroidx/camera/core/ImageCapture$OnImageCapturedCallback;", "onCaptureSuccess", "", "imageProxy", "Landroidx/camera/core/ImageProxy;", "onError", "exception", "Landroidx/camera/core/ImageCaptureException;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionViaSnCameraDialog$imageCapturedCallback$1 extends ImageCapture.OnImageCapturedCallback {
    final /* synthetic */ SubscriptionViaSnCameraDialog this$0;

    SubscriptionViaSnCameraDialog$imageCapturedCallback$1(SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialog) {
        this.this$0 = subscriptionViaSnCameraDialog;
    }

    @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
    public void onCaptureSuccess(final ImageProxy imageProxy) {
        InputImage inputImageFromMediaImage;
        View view;
        View view2;
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        Timber.INSTANCE.d("imageCapturedCallback -> imageAnalyzer imageProxy=" + imageProxy.getImageInfo(), new Object[0]);
        Timber.INSTANCE.d("imageCapturedCallback -> imageAnalyzer imageProxy format=" + imageProxy.getFormat(), new Object[0]);
        try {
            Image image = imageProxy.getImage();
            Timber.INSTANCE.d("imageCapturedCallback -> imageAnalyzer mediaImage width=" + (image != null ? Integer.valueOf(image.getWidth()) : null), new Object[0]);
            Timber.INSTANCE.d("imageCapturedCallback -> imageAnalyzer mediaImage height=" + (image != null ? Integer.valueOf(image.getHeight()) : null), new Object[0]);
            if (image != null) {
                DialogSubscriptionViaSnCameraBinding dialogSubscriptionViaSnCameraBinding = this.this$0.binding;
                int measuredWidth = (dialogSubscriptionViaSnCameraBinding == null || (view2 = dialogSubscriptionViaSnCameraBinding.redLineBox) == null) ? 0 : view2.getMeasuredWidth();
                DialogSubscriptionViaSnCameraBinding dialogSubscriptionViaSnCameraBinding2 = this.this$0.binding;
                int measuredHeight = (dialogSubscriptionViaSnCameraBinding2 == null || (view = dialogSubscriptionViaSnCameraBinding2.redLineBox) == null) ? 0 : view.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    Bitmap bitmapConvertJpegToUpRightBitmap = ImageConvertUtils.getInstance().convertJpegToUpRightBitmap(image, imageProxy.getImageInfo().getRotationDegrees());
                    Intrinsics.checkNotNullExpressionValue(bitmapConvertJpegToUpRightBitmap, "convertJpegToUpRightBitmap(...)");
                    int width = (int) ((bitmapConvertJpegToUpRightBitmap.getWidth() / measuredWidth) * measuredHeight);
                    inputImageFromMediaImage = InputImage.fromBitmap(Bitmap.createBitmap(bitmapConvertJpegToUpRightBitmap, 0, (bitmapConvertJpegToUpRightBitmap.getHeight() - width) / 2, bitmapConvertJpegToUpRightBitmap.getWidth(), width), 0);
                } else {
                    inputImageFromMediaImage = InputImage.fromMediaImage(image, imageProxy.getImageInfo().getRotationDegrees());
                }
                Intrinsics.checkNotNull(inputImageFromMediaImage);
                Timber.INSTANCE.d("imageCapturedCallback -> imageAnalyzer image width=" + inputImageFromMediaImage.getWidth(), new Object[0]);
                Timber.INSTANCE.d("imageCapturedCallback -> imageAnalyzer image height=" + inputImageFromMediaImage.getHeight(), new Object[0]);
                TextRecognizer textRecognizer = this.this$0.recognizer;
                if (textRecognizer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recognizer");
                    textRecognizer = null;
                }
                Task<Text> taskProcess = textRecognizer.process(inputImageFromMediaImage);
                Intrinsics.checkNotNullExpressionValue(taskProcess, "process(...)");
                final SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialog = this.this$0;
                final Function1<Text, Unit> function1 = new Function1<Text, Unit>() { // from class: com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                        invoke2(text);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Text text) {
                        Timber.INSTANCE.d("imageCapturedCallback -> imageAnalyzer -> onSuccess text=" + text.getText(), new Object[0]);
                        int i = 0;
                        for (Text.TextBlock textBlock : text.getTextBlocks()) {
                            Timber.INSTANCE.d("imageCapturedCallback -> imageAnalyzer -> onSuccess i=" + i + "\u3000| textBlock=" + textBlock.getText() + " | recognizedLanguage=" + textBlock.getRecognizedLanguage(), new Object[0]);
                            i++;
                        }
                        String text2 = text.getText();
                        Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                        String strReplace = StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(text2, " ", "", false, 4, (Object) null), "\n", "", false, 4, (Object) null), "\r", "", false, 4, (Object) null), TlbBase.TAB, "", false, 4, (Object) null), "serial", "", true), "number", "", true), "numbe", "", true), "numerber", "", true), "numeber", "", true), "numerer", "", true), "numben", "", true), "erial", "", true), "rial", "", true);
                        Timber.INSTANCE.d("imageCapturedCallback -> imageAnalyzer -> onSuccess sn2=" + strReplace, new Object[0]);
                        String str = strReplace;
                        if (str == null || str.length() == 0) {
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(subscriptionViaSnCameraDialog), Dispatchers.getMain(), null, new AnonymousClass2(subscriptionViaSnCameraDialog, null), 2, null);
                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putString(SubscriptionViaSnCameraDialog.KEY_RESULT_SN, strReplace);
                            FragmentKt.setFragmentResult(subscriptionViaSnCameraDialog, SubscriptionViaSnCameraDialog.KEY_RESULT, bundle);
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(subscriptionViaSnCameraDialog), Dispatchers.getMain(), null, new AnonymousClass1(subscriptionViaSnCameraDialog, null), 2, null);
                        }
                        imageProxy.close();
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(subscriptionViaSnCameraDialog), Dispatchers.getMain(), null, new AnonymousClass3(subscriptionViaSnCameraDialog, null), 2, null);
                    }

                    /* compiled from: SubscriptionViaSnCameraDialog.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$1$1", f = "SubscriptionViaSnCameraDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$1$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ SubscriptionViaSnCameraDialog this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialog, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = subscriptionViaSnCameraDialog;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            AppCompatImageView appCompatImageView;
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.label == 0) {
                                ResultKt.throwOnFailure(obj);
                                DialogSubscriptionViaSnCameraBinding dialogSubscriptionViaSnCameraBinding = this.this$0.binding;
                                if (dialogSubscriptionViaSnCameraBinding != null && (appCompatImageView = dialogSubscriptionViaSnCameraBinding.close) != null) {
                                    Boxing.boxBoolean(appCompatImageView.performClick());
                                }
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }

                    /* compiled from: SubscriptionViaSnCameraDialog.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$1$2", f = "SubscriptionViaSnCameraDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$1$2, reason: invalid class name */
                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ SubscriptionViaSnCameraDialog this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialog, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.this$0 = subscriptionViaSnCameraDialog;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.label != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            Context context = this.this$0.getContext();
                            if (context != null) {
                                Toast.makeText(context, R.string.scan_failed, 0).show();
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    /* compiled from: SubscriptionViaSnCameraDialog.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$1$3", f = "SubscriptionViaSnCameraDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$1$3, reason: invalid class name */
                    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ SubscriptionViaSnCameraDialog this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass3(SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialog, Continuation<? super AnonymousClass3> continuation) {
                            super(2, continuation);
                            this.this$0 = subscriptionViaSnCameraDialog;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass3(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                };
                taskProcess.addOnSuccessListener(new OnSuccessListener() { // from class: com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$imageCapturedCallback$1$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        SubscriptionViaSnCameraDialog$imageCapturedCallback$1.onCaptureSuccess$lambda$0(function1, obj);
                    }
                });
                final SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialog2 = this.this$0;
                taskProcess.addOnFailureListener(new OnFailureListener() { // from class: com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$imageCapturedCallback$1$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        SubscriptionViaSnCameraDialog$imageCapturedCallback$1.onCaptureSuccess$lambda$1(imageProxy, subscriptionViaSnCameraDialog2, exc);
                    }
                });
                final SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialog3 = this.this$0;
                taskProcess.addOnCompleteListener(new OnCompleteListener() { // from class: com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$imageCapturedCallback$1$$ExternalSyntheticLambda2
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        SubscriptionViaSnCameraDialog$imageCapturedCallback$1.onCaptureSuccess$lambda$2(imageProxy, subscriptionViaSnCameraDialog3, task);
                    }
                });
                return;
            }
            imageProxy.close();
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getMain(), null, new SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$4(this.this$0, null), 2, null);
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            imageProxy.close();
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getMain(), null, new SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$5(this.this$0, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCaptureSuccess$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCaptureSuccess$lambda$1(ImageProxy imageProxy, SubscriptionViaSnCameraDialog this$0, Exception e) {
        Intrinsics.checkNotNullParameter(imageProxy, "$imageProxy");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(e, "e");
        Timber.INSTANCE.e("imageCapturedCallback -> imageAnalyzer -> OnFailure ", new Object[0]);
        Timber.INSTANCE.e(e);
        imageProxy.close();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getMain(), null, new SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$2$1(this$0, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCaptureSuccess$lambda$2(ImageProxy imageProxy, SubscriptionViaSnCameraDialog this$0, Task it) {
        Intrinsics.checkNotNullParameter(imageProxy, "$imageProxy");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Timber.INSTANCE.d("imageCapturedCallback -> imageAnalyzer -> Complete", new Object[0]);
        imageProxy.close();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getMain(), null, new SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onCaptureSuccess$3$1(this$0, null), 2, null);
    }

    @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
    public void onError(ImageCaptureException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Timber.INSTANCE.e("imageCapturedCallback -> onError", new Object[0]);
        Timber.INSTANCE.e(exception);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getMain(), null, new SubscriptionViaSnCameraDialog$imageCapturedCallback$1$onError$1(this.this$0, null), 2, null);
    }
}
