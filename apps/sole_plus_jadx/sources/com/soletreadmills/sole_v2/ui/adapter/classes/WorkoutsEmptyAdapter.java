package com.soletreadmills.sole_v2.ui.adapter.classes;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutsEmptyAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0012B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\n\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\nH\u0016J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/classes/WorkoutsEmptyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/soletreadmills/sole_v2/ui/adapter/classes/WorkoutsEmptyAdapter$WorkoutsEmptyVH;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "onResetFiltersClick", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "WorkoutsEmptyVH", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WorkoutsEmptyAdapter extends RecyclerView.Adapter<WorkoutsEmptyVH> {
    public static final int $stable = 8;
    private final Context context;
    private final Function0<Unit> onResetFiltersClick;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public WorkoutsEmptyAdapter(Context context, Function0<Unit> onResetFiltersClick) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onResetFiltersClick, "onResetFiltersClick");
        this.context = context;
        this.onResetFiltersClick = onResetFiltersClick;
    }

    /* compiled from: WorkoutsEmptyAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/classes/WorkoutsEmptyAdapter$WorkoutsEmptyVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "(Lcom/soletreadmills/sole_v2/ui/adapter/classes/WorkoutsEmptyAdapter;Landroidx/compose/ui/platform/ComposeView;)V", "getComposeView", "()Landroidx/compose/ui/platform/ComposeView;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class WorkoutsEmptyVH extends RecyclerView.ViewHolder {
        private final ComposeView composeView;
        final /* synthetic */ WorkoutsEmptyAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WorkoutsEmptyVH(WorkoutsEmptyAdapter workoutsEmptyAdapter, ComposeView composeView) {
            super(composeView);
            Intrinsics.checkNotNullParameter(composeView, "composeView");
            this.this$0 = workoutsEmptyAdapter;
            this.composeView = composeView;
        }

        public final ComposeView getComposeView() {
            return this.composeView;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WorkoutsEmptyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        return new WorkoutsEmptyVH(this, composeView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(WorkoutsEmptyVH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getComposeView().setContent(ComposableLambdaKt.composableLambdaInstance(880765135, true, new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.adapter.classes.WorkoutsEmptyAdapter.onBindViewHolder.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Resources.NotFoundException {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) throws Resources.NotFoundException {
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(880765135, i, -1, "com.soletreadmills.sole_v2.ui.adapter.classes.WorkoutsEmptyAdapter.onBindViewHolder.<anonymous> (WorkoutsEmptyAdapter.kt:46)");
                }
                WorkoutsEmptyAdapterKt.WorkoutsEmpty(WorkoutsEmptyAdapter.this.onResetFiltersClick, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }
}
