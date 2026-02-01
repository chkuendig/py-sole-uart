package com.soletreadmills.sole_v2.ui.settings;

import android.content.Context;
import android.net.Uri;
import com.soletreadmills.sole_v2._tools.FileTool;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

/* compiled from: SettingProfileFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingProfileFragment$initViews$2$1", f = "SettingProfileFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SettingProfileFragment$initViews$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SettingProfileFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SettingProfileFragment$initViews$2$1(SettingProfileFragment settingProfileFragment, Continuation<? super SettingProfileFragment$initViews$2$1> continuation) {
        super(2, continuation);
        this.this$0 = settingProfileFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingProfileFragment$initViews$2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingProfileFragment$initViews$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        FileTool fileTool = FileTool.INSTANCE;
        Context contextRequireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Uri uri = this.this$0.photoUri;
        Intrinsics.checkNotNull(uri);
        File fileResizeImageWithGlide = fileTool.resizeImageWithGlide(contextRequireContext, uri, 500, 500);
        Timber.INSTANCE.d("resizeImage-----" + fileResizeImageWithGlide, new Object[0]);
        if (fileResizeImageWithGlide == null) {
            Timber.INSTANCE.e("resize Error", new Object[0]);
            return Unit.INSTANCE;
        }
        Timber.INSTANCE.e("resize Success", new Object[0]);
        SettingProfileFragment settingProfileFragment = this.this$0;
        Uri uri2 = settingProfileFragment.photoUri;
        Intrinsics.checkNotNull(uri2);
        settingProfileFragment.uploadImage(fileResizeImageWithGlide, uri2);
        return Unit.INSTANCE;
    }
}
