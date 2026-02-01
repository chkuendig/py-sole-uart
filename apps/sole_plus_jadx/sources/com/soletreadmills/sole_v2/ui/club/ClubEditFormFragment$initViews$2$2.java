package com.soletreadmills.sole_v2.ui.club;

import android.content.Context;
import android.net.Uri;
import com.soletreadmills.sole_v2.ui.MainActivity;
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

/* compiled from: ClubEditFormFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEditFormFragment$initViews$2$2", f = "ClubEditFormFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class ClubEditFormFragment$initViews$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ClubEditFormFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClubEditFormFragment$initViews$2$2(ClubEditFormFragment clubEditFormFragment, Continuation<? super ClubEditFormFragment$initViews$2$2> continuation) {
        super(2, continuation);
        this.this$0 = clubEditFormFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClubEditFormFragment$initViews$2$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClubEditFormFragment$initViews$2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        File fileResizeImageWithGlide;
        Context applicationContext;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MainActivity mainActivity = this.this$0.getMainActivity();
        if (mainActivity == null || (applicationContext = mainActivity.getApplicationContext()) == null) {
            fileResizeImageWithGlide = null;
        } else {
            ClubEditFormFragment clubEditFormFragment = this.this$0;
            Uri uri = clubEditFormFragment.photoUri;
            Intrinsics.checkNotNull(uri);
            fileResizeImageWithGlide = clubEditFormFragment.resizeImageWithGlide(applicationContext, uri, 2000, 2000);
        }
        Timber.INSTANCE.d("resizeImage-----" + fileResizeImageWithGlide, new Object[0]);
        if (fileResizeImageWithGlide != null) {
            this.this$0.tempResizeImgFile = fileResizeImageWithGlide;
            return Unit.INSTANCE;
        }
        Timber.INSTANCE.e("resize Error", new Object[0]);
        return Unit.INSTANCE;
    }
}
