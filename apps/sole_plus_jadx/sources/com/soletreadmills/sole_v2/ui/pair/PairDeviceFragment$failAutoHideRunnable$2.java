package com.soletreadmills.sole_v2.ui.pair;

import com.soletreadmills.sole_v2.databinding.FragmentPairDeviceBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: PairDeviceFragment.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
final class PairDeviceFragment$failAutoHideRunnable$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ PairDeviceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PairDeviceFragment$failAutoHideRunnable$2(PairDeviceFragment pairDeviceFragment) {
        super(0);
        this.this$0 = pairDeviceFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Runnable invoke() {
        final PairDeviceFragment pairDeviceFragment = this.this$0;
        return new Runnable() { // from class: com.soletreadmills.sole_v2.ui.pair.PairDeviceFragment$failAutoHideRunnable$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PairDeviceFragment$failAutoHideRunnable$2.invoke$lambda$1(pairDeviceFragment);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(PairDeviceFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentPairDeviceBinding fragmentPairDeviceBindingAccess$getBinding = PairDeviceFragment.access$getBinding(this$0);
        if (fragmentPairDeviceBindingAccess$getBinding != null) {
            fragmentPairDeviceBindingAccess$getBinding.LLPairFailed.setVisibility(8);
            fragmentPairDeviceBindingAccess$getBinding.CLProgressbar.setVisibility(8);
        }
    }
}
