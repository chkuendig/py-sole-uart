package com.dyaco.srvo.ui.CustomItemDecoration;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.history.HistoryListData;
import com.soletreadmills.sole_v2.databinding.AdapterHistoryHeaderItemBinding;
import com.soletreadmills.sole_v2.ui.adapter.history.HistoryAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HistoryHeaderDecoration.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/dyaco/srvo/ui/CustomItemDecoration/HistoryHeaderDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "adapter", "Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryAdapter;", "(Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryAdapter;)V", "nowHeader", "Lcom/soletreadmills/sole_v2/_data/api/history/HistoryListData;", "getNowHeader", "()Lcom/soletreadmills/sole_v2/_data/api/history/HistoryListData;", "setNowHeader", "(Lcom/soletreadmills/sole_v2/_data/api/history/HistoryListData;)V", "drawHeader", "", "c", "Landroid/graphics/Canvas;", "title", "", SdkConstants.ATTR_PARENT, "Landroidx/recyclerview/widget/RecyclerView;", "workoutSize", "", "onDrawOver", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HistoryHeaderDecoration extends RecyclerView.ItemDecoration {
    public static final int $stable = 8;
    private final HistoryAdapter adapter;
    private HistoryListData nowHeader;

    public HistoryHeaderDecoration(HistoryAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
    }

    public final HistoryListData getNowHeader() {
        return this.nowHeader;
    }

    public final void setNowHeader(HistoryListData historyListData) {
        this.nowHeader = historyListData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int iFindFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition != -1 && this.adapter.getCurrentList().size() > 0) {
            Context context = parent.getContext();
            HistoryListData historyListData = this.adapter.getCurrentList().get(iFindFirstVisibleItemPosition);
            String string = context.getString(R.string.january);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = context.getString(R.string.february);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = context.getString(R.string.march);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = context.getString(R.string.april);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            String string5 = context.getString(R.string.may);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            String string6 = context.getString(R.string.june);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            String string7 = context.getString(R.string.july);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            String string8 = context.getString(R.string.august);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            String string9 = context.getString(R.string.september);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            String string10 = context.getString(R.string.october);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            String string11 = context.getString(R.string.november);
            Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
            String string12 = context.getString(R.string.december);
            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
            String[] strArr = {string, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12};
            int iIntValue = historyListData.getMonth() != null ? historyListData.getMonth().intValue() - 1 : 1;
            int iIntValue2 = historyListData.getYear() != null ? historyListData.getYear().intValue() : 2000;
            if (historyListData.isHeader()) {
                this.nowHeader = historyListData;
                String str = strArr[iIntValue] + ' ' + iIntValue2;
                Integer totalSize = historyListData.getTotalSize();
                drawHeader(c, str, parent, totalSize != null ? totalSize.intValue() : 0);
                return;
            }
            int i = iFindFirstVisibleItemPosition + 1;
            if (i < this.adapter.getCurrentList().size() && this.adapter.getCurrentList().get(i).isHeader()) {
                String str2 = strArr[iIntValue] + ' ' + iIntValue2;
                Integer totalSize2 = historyListData.getTotalSize();
                drawHeader(c, str2, parent, totalSize2 != null ? totalSize2.intValue() : 0);
            } else if (this.nowHeader != null) {
                String str3 = strArr[iIntValue] + ' ' + iIntValue2;
                Integer totalSize3 = historyListData.getTotalSize();
                drawHeader(c, str3, parent, totalSize3 != null ? totalSize3.intValue() : 0);
            }
        }
    }

    private final void drawHeader(Canvas c, String title, RecyclerView parent, int workoutSize) {
        Context context = parent.getContext();
        AdapterHistoryHeaderItemBinding adapterHistoryHeaderItemBindingInflate = AdapterHistoryHeaderItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterHistoryHeaderItemBindingInflate, "inflate(...)");
        TextView title2 = adapterHistoryHeaderItemBindingInflate.title;
        Intrinsics.checkNotNullExpressionValue(title2, "title");
        title2.setText(title);
        adapterHistoryHeaderItemBindingInflate.tvWorkoutsCount.setText(context.getString(R.string.workouts_count, String.valueOf(workoutSize)));
        adapterHistoryHeaderItemBindingInflate.getRoot().measure(View.MeasureSpec.makeMeasureSpec(parent.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(100, 0));
        adapterHistoryHeaderItemBindingInflate.getRoot().layout(0, 0, parent.getWidth(), adapterHistoryHeaderItemBindingInflate.getRoot().getMeasuredHeight());
        c.save();
        c.translate(0.0f, 0.0f);
        adapterHistoryHeaderItemBindingInflate.getRoot().draw(c);
        c.restore();
    }
}
