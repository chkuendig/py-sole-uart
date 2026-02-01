package androidx.navigation;

import androidx.lifecycle.ViewModelStore;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;

/* compiled from: NavGraphViewModelLazy.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = Opcodes.ARETURN)
/* loaded from: classes3.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 implements Function0<ViewModelStore> {
    final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;

    public NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(Lazy<NavBackStackEntry> lazy) {
        this.$backStackEntry$delegate = lazy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelStore invoke() {
        return NavGraphViewModelLazyKt.m7763navGraphViewModels$lambda1(this.$backStackEntry$delegate).getViewModelStore();
    }
}
