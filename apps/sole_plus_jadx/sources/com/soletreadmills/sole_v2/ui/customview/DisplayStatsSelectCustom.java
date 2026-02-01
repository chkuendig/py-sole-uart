package com.soletreadmills.sole_v2.ui.customview;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.DisplaySelectStatsData;
import com.soletreadmills.sole_v2._type.DisplayStatsType;
import com.soletreadmills.sole_v2.databinding.CustomDisplayStatsSelectBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayStatsSelectCustom.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/DisplayStatsSelectCustom;", "Lcom/soletreadmills/sole_v2/ui/customview/BaseRelativeLayout;", "mainActivity", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "title", "", "list", "", "Lcom/soletreadmills/sole_v2/_data/club/DisplaySelectStatsData;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/ui/customview/DisplayStatsSelectCustom$BottomDialogCustomListener;", "(Lcom/soletreadmills/sole_v2/ui/MainActivity;Ljava/lang/String;Ljava/util/List;Lcom/soletreadmills/sole_v2/ui/customview/DisplayStatsSelectCustom$BottomDialogCustomListener;)V", "binding", "Lcom/soletreadmills/sole_v2/databinding/CustomDisplayStatsSelectBinding;", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/CustomDisplayStatsSelectBinding;", "getList", "()Ljava/util/List;", "getListener", "()Lcom/soletreadmills/sole_v2/ui/customview/DisplayStatsSelectCustom$BottomDialogCustomListener;", "onBackPressed", "", SdkConstants.ATTR_ON_CLICK, "", "v", "Landroid/view/View;", "setRecyclerview", "BottomDialogCustomListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayStatsSelectCustom extends BaseRelativeLayout {
    public static final int $stable = 8;
    private final CustomDisplayStatsSelectBinding binding;
    private final List<DisplaySelectStatsData> list;
    private final BottomDialogCustomListener listener;

    /* compiled from: DisplayStatsSelectCustom.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/DisplayStatsSelectCustom$BottomDialogCustomListener;", "", SdkConstants.ATTR_ON_CLICK, "", "pos", "", "newType", "Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface BottomDialogCustomListener {
        void onClick(int pos, DisplayStatsType newType);
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout
    public boolean onBackPressed() {
        return false;
    }

    public final List<DisplaySelectStatsData> getList() {
        return this.list;
    }

    public final BottomDialogCustomListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayStatsSelectCustom(MainActivity mainActivity, String title, List<DisplaySelectStatsData> list, BottomDialogCustomListener listener) throws Resources.NotFoundException {
        super(mainActivity, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(mainActivity, "mainActivity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.list = list;
        this.listener = listener;
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(mainActivity), R.layout.custom_display_stats_select, this, true);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        CustomDisplayStatsSelectBinding customDisplayStatsSelectBinding = (CustomDisplayStatsSelectBinding) viewDataBindingInflate;
        this.binding = customDisplayStatsSelectBinding;
        customDisplayStatsSelectBinding.close.setOnClickListener(this);
        customDisplayStatsSelectBinding.title.setText(title);
        setRecyclerview();
    }

    public final CustomDisplayStatsSelectBinding getBinding() {
        return this.binding;
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout, android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == R.id.close) {
            getMainActivity().onBackPressed();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setRecyclerview() throws android.content.res.Resources.NotFoundException {
        /*
            r5 = this;
            android.content.res.Resources r0 = r5.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.orientation
            r1 = 2
            if (r0 != r1) goto Le
            r1 = 3
        Le:
            android.content.res.Resources r0 = r5.getResources()
            int r2 = com.soletreadmills.sole_v2.R.dimen.margin_12
            int r0 = r0.getDimensionPixelSize(r2)
            com.soletreadmills.sole_v2.databinding.CustomDisplayStatsSelectBinding r2 = r5.binding
            androidx.recyclerview.widget.RecyclerView r2 = r2.recyclerview
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r2.getLayoutManager()
            boolean r2 = r2 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r2 == 0) goto L39
            com.soletreadmills.sole_v2.databinding.CustomDisplayStatsSelectBinding r2 = r5.binding
            androidx.recyclerview.widget.RecyclerView r2 = r2.recyclerview
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r2.getLayoutManager()
            java.lang.String r3 = "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            androidx.recyclerview.widget.GridLayoutManager r2 = (androidx.recyclerview.widget.GridLayoutManager) r2
            int r2 = r2.getSpanCount()
            if (r2 == r1) goto L5c
        L39:
            com.soletreadmills.sole_v2.databinding.CustomDisplayStatsSelectBinding r2 = r5.binding
            androidx.recyclerview.widget.RecyclerView r2 = r2.recyclerview
            androidx.recyclerview.widget.GridLayoutManager r3 = new androidx.recyclerview.widget.GridLayoutManager
            com.soletreadmills.sole_v2.ui.MainActivity r4 = r5.getMainActivity()
            android.content.Context r4 = (android.content.Context) r4
            r3.<init>(r4, r1)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r3
            r2.setLayoutManager(r3)
            com.soletreadmills.sole_v2.databinding.CustomDisplayStatsSelectBinding r2 = r5.binding
            androidx.recyclerview.widget.RecyclerView r2 = r2.recyclerview
            com.soletreadmills.sole_v2.ui.adapter.base.GridSpacingItemDecoration r3 = new com.soletreadmills.sole_v2.ui.adapter.base.GridSpacingItemDecoration
            r4 = 1
            r3.<init>(r1, r0, r4)
            androidx.recyclerview.widget.RecyclerView$ItemDecoration r3 = (androidx.recyclerview.widget.RecyclerView.ItemDecoration) r3
            r2.addItemDecoration(r3)
        L5c:
            com.soletreadmills.sole_v2.databinding.CustomDisplayStatsSelectBinding r0 = r5.binding
            androidx.recyclerview.widget.RecyclerView r0 = r0.recyclerview
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
            boolean r0 = r0 instanceof com.soletreadmills.sole_v2.ui.adapter.customview.DisplayStatsSelectAdapter
            if (r0 != 0) goto L7d
            com.soletreadmills.sole_v2.ui.adapter.customview.DisplayStatsSelectAdapter r0 = new com.soletreadmills.sole_v2.ui.adapter.customview.DisplayStatsSelectAdapter
            com.soletreadmills.sole_v2.ui.customview.DisplayStatsSelectCustom$setRecyclerview$adapter$1 r1 = new com.soletreadmills.sole_v2.ui.customview.DisplayStatsSelectCustom$setRecyclerview$adapter$1
            r1.<init>()
            com.soletreadmills.sole_v2.listener.OnItemClickListener r1 = (com.soletreadmills.sole_v2.listener.OnItemClickListener) r1
            r0.<init>(r1)
            com.soletreadmills.sole_v2.databinding.CustomDisplayStatsSelectBinding r1 = r5.binding
            androidx.recyclerview.widget.RecyclerView r1 = r1.recyclerview
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = (androidx.recyclerview.widget.RecyclerView.Adapter) r0
            r1.setAdapter(r0)
        L7d:
            com.soletreadmills.sole_v2.databinding.CustomDisplayStatsSelectBinding r0 = r5.binding
            androidx.recyclerview.widget.RecyclerView r0 = r0.recyclerview
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
            boolean r1 = r0 instanceof com.soletreadmills.sole_v2.ui.adapter.customview.DisplayStatsSelectAdapter
            if (r1 == 0) goto L90
            com.soletreadmills.sole_v2.ui.adapter.customview.DisplayStatsSelectAdapter r0 = (com.soletreadmills.sole_v2.ui.adapter.customview.DisplayStatsSelectAdapter) r0
            java.util.List<com.soletreadmills.sole_v2._data.club.DisplaySelectStatsData> r1 = r5.list
            r0.submitList(r1)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.customview.DisplayStatsSelectCustom.setRecyclerview():void");
    }
}
