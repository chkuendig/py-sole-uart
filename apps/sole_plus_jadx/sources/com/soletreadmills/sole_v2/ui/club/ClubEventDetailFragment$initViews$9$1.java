package com.soletreadmills.sole_v2.ui.club;

import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ClubEventDetailFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$initViews$9$1", f = "ClubEventDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class ClubEventDetailFragment$initViews$9$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $challengeId;
    int label;
    final /* synthetic */ ClubEventDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClubEventDetailFragment$initViews$9$1(ClubEventDetailFragment clubEventDetailFragment, String str, Continuation<? super ClubEventDetailFragment$initViews$9$1> continuation) {
        super(2, continuation);
        this.this$0 = clubEventDetailFragment;
        this.$challengeId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClubEventDetailFragment$initViews$9$1(this.this$0, this.$challengeId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClubEventDetailFragment$initViews$9$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ClubEventDetailFragment clubEventDetailFragment = this.this$0;
        String string = clubEventDetailFragment.getString(R.string.delete_event_title);
        String string2 = this.this$0.getString(R.string.delete_event_desc);
        String string3 = this.this$0.getString(R.string.delete_event_confirm);
        String string4 = this.this$0.getString(R.string.delete_event_cancel);
        final ClubEventDetailFragment clubEventDetailFragment2 = this.this$0;
        final String str = this.$challengeId;
        CustomDialogKt.showCustomDialog$default(clubEventDetailFragment, string, string2, string3, string4, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$initViews$9$1.1
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
                clubEventDetailFragment2.deleteChallenge(str);
            }
        }, null, false, 96, null);
        return Unit.INSTANCE;
    }
}
