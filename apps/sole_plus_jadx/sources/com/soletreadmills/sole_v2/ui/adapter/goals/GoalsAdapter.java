package com.soletreadmills.sole_v2.ui.adapter.goals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.facebook.internal.AnalyticsEvents;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.goal.GoalTimeFrame;
import com.soletreadmills.sole_v2._data.goal.GoalsStatsType;
import com.soletreadmills.sole_v2._data.goal.UserGoalData;
import com.soletreadmills.sole_v2._tools.DpToPxKt;
import com.soletreadmills.sole_v2.databinding.AdapterGoalsItemBinding;
import com.soletreadmills.sole_v2.ui.adapter.goals.GoalsAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoalsAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u001c\u001d\u001eB)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/goal/UserGoalData;", "Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "onItemClickListener", "Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsAdapter$OnItemClickListener;", "isFullWidth", "", "isEdit", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsAdapter$OnItemClickListener;ZZ)V", "()Z", "setEdit", "(Z)V", "getOnItemClickListener", "()Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsAdapter$OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "setEditMode", "editMode", "DiffCallback", "OnItemClickListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GoalsAdapter extends ListAdapter<UserGoalData, ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private boolean isEdit;
    private final boolean isFullWidth;
    private final OnItemClickListener onItemClickListener;

    /* compiled from: GoalsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsAdapter$OnItemClickListener;", "", "onItemClick", "", "userGoalData", "Lcom/soletreadmills/sole_v2/_data/goal/UserGoalData;", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnItemClickListener {
        void onItemClick(UserGoalData userGoalData, int position);
    }

    public /* synthetic */ GoalsAdapter(Context context, OnItemClickListener onItemClickListener, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onItemClickListener, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    /* renamed from: isFullWidth, reason: from getter */
    public final boolean getIsFullWidth() {
        return this.isFullWidth;
    }

    /* renamed from: isEdit, reason: from getter */
    public final boolean getIsEdit() {
        return this.isEdit;
    }

    public final void setEdit(boolean z) {
        this.isEdit = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoalsAdapter(Context context, OnItemClickListener onItemClickListener, boolean z, boolean z2) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.context = context;
        this.onItemClickListener = onItemClickListener;
        this.isFullWidth = z;
        this.isEdit = z2;
    }

    /* compiled from: GoalsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/soletreadmills/sole_v2/_data/goal/UserGoalData;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<UserGoalData> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(UserGoalData oldItem, UserGoalData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getUserGoalUuid(), newItem.getUserGoalUuid());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(UserGoalData oldItem, UserGoalData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getUserGoalUuid(), newItem.getUserGoalUuid()) && Intrinsics.areEqual(oldItem.getMachineCategoryType(), newItem.getMachineCategoryType()) && Intrinsics.areEqual(oldItem.getTimeFrame(), newItem.getTimeFrame()) && Intrinsics.areEqual(oldItem.getCompleteRate(), newItem.getCompleteRate());
        }
    }

    public final void setEditMode(boolean editMode) {
        if (this.isEdit != editMode) {
            this.isEdit = editMode;
            notifyItemRangeChanged(0, getItemCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterGoalsItemBinding adapterGoalsItemBindingInflate = AdapterGoalsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterGoalsItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterGoalsItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        UserGoalData item = getItem(position);
        Intrinsics.checkNotNull(item);
        holder.bind(item, position);
    }

    /* compiled from: GoalsAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J&\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterGoalsItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterGoalsItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterGoalsItemBinding;", "bind", "", "data", "Lcom/soletreadmills/sole_v2/_data/goal/UserGoalData;", "position", "", "loadPieChartData", "pieChart", "Lcom/github/mikephil/charting/charts/PieChart;", "userGoalData", "completeRate", "", "setupPieChart", "updatePieChart", "value", "total", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterGoalsItemBinding binding;
        final /* synthetic */ GoalsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(GoalsAdapter goalsAdapter, AdapterGoalsItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = goalsAdapter;
            this.binding = binding;
        }

        public final AdapterGoalsItemBinding getBinding() {
            return this.binding;
        }

        public final void bind(final UserGoalData data, final int position) {
            Intrinsics.checkNotNullParameter(data, "data");
            PieChart pieChart = this.binding.pieChart;
            Intrinsics.checkNotNullExpressionValue(pieChart, "pieChart");
            setupPieChart(pieChart);
            Integer completeRate = data.getCompleteRate();
            if (completeRate != null) {
                int iIntValue = completeRate.intValue();
                PieChart pieChart2 = this.binding.pieChart;
                Intrinsics.checkNotNullExpressionValue(pieChart2, "pieChart");
                loadPieChartData(pieChart2, data, iIntValue);
            }
            Triple<Integer, Integer, Integer> goalsColors = GoalsAdapterKt.getGoalsColors(this.this$0.context, data.getStatsType());
            View root = this.binding.getRoot();
            final GoalsAdapter goalsAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.goals.GoalsAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GoalsAdapter.ViewHolder.bind$lambda$1(goalsAdapter, data, position, view);
                }
            });
            this.binding.tvCompleteRate.setText(new StringBuilder().append(data.getCompleteRate()).append('%').toString());
            UserGoalData userGoalData = (data.getStatsType() == null || data.getTimeFrame() == null) ? null : data;
            if (userGoalData != null) {
                GoalsAdapter goalsAdapter2 = this.this$0;
                Context context = goalsAdapter2.context;
                GoalTimeFrame.Companion companion = GoalTimeFrame.INSTANCE;
                Integer timeFrame = userGoalData.getTimeFrame();
                Intrinsics.checkNotNull(timeFrame);
                String string = context.getString(GoalTimeFrame.Companion.getTitleId$default(companion, timeFrame.intValue(), 0, 2, null));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Context context2 = goalsAdapter2.context;
                GoalsStatsType.Companion companion2 = GoalsStatsType.INSTANCE;
                Integer statsType = userGoalData.getStatsType();
                Intrinsics.checkNotNull(statsType);
                int iIntValue2 = statsType.intValue();
                Integer timeFrame2 = userGoalData.getTimeFrame();
                Intrinsics.checkNotNull(timeFrame2);
                String string2 = context2.getString(GoalsStatsType.Companion.getTitleUnitId$default(companion2, iIntValue2, timeFrame2.intValue(), 0, 4, null));
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                this.binding.tvTimeFrame.setText(string + ' ' + string2);
            }
            this.binding.tvCompleteRate.setTextColor(goalsColors.getFirst().intValue());
            this.binding.layoutGoalBg.setCardBackgroundColor(goalsColors.getThird().intValue());
            ViewGroup.LayoutParams layoutParams = this.binding.layoutGoalWrap.getLayoutParams();
            this.binding.layoutGoal.setVisibility(0);
            this.binding.layoutAdd.setVisibility(8);
            if (Intrinsics.areEqual(data.getUserGoalUuid(), "addGoal")) {
                this.binding.layoutGoal.setVisibility(8);
                this.binding.layoutAdd.setVisibility(0);
                this.binding.layoutGoalBg.setCardBackgroundColor(ContextCompat.getColor(this.this$0.context, R.color.colorBackground_raised));
            }
            layoutParams.width = DpToPxKt.dpToPx(300, this.this$0.context);
            if (this.this$0.getIsFullWidth() || Intrinsics.areEqual(data.getUserGoalUuid(), "addGoal")) {
                layoutParams.width = -1;
            }
            this.binding.layoutGoalWrap.setLayoutParams(layoutParams);
            this.binding.imgDeleteBtn.setVisibility(8);
            this.binding.imgArrow.setVisibility(0);
            this.binding.layoutAddBtnCover.setVisibility(8);
            if (this.this$0.getIsEdit()) {
                this.binding.imgDeleteBtn.setVisibility(0);
                this.binding.imgArrow.setVisibility(8);
                this.binding.layoutAddBtnCover.setVisibility(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(GoalsAdapter this$0, UserGoalData data, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            this$0.getOnItemClickListener().onItemClick(data, i);
        }

        private final void setupPieChart(PieChart pieChart) {
            pieChart.setUsePercentValues(false);
            pieChart.getDescription().setEnabled(false);
            pieChart.setDrawHoleEnabled(false);
            pieChart.setCenterText(null);
            pieChart.setDrawEntryLabels(false);
            pieChart.getLegend().setEnabled(false);
            pieChart.setRotationEnabled(false);
            pieChart.setTouchEnabled(false);
        }

        private final void loadPieChartData(PieChart pieChart, UserGoalData userGoalData, float completeRate) {
            Triple<Integer, Integer, Integer> goalsColors = GoalsAdapterKt.getGoalsColors(this.this$0.context, userGoalData.getStatsType());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PieEntry(completeRate, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED));
            arrayList.add(new PieEntry(100.0f - completeRate, "Remaining"));
            List<Integer> listListOf = CollectionsKt.listOf((Object[]) new Integer[]{goalsColors.getFirst(), goalsColors.getSecond()});
            PieDataSet pieDataSet = new PieDataSet(arrayList, "");
            pieDataSet.setColors(listListOf);
            pieDataSet.setSliceSpace(0.0f);
            pieDataSet.setSelectionShift(5.0f);
            pieDataSet.setDrawValues(false);
            pieChart.setData(new PieData(pieDataSet));
            pieChart.invalidate();
            pieChart.animateY(1000, Easing.EaseInOutQuad);
        }

        public final void updatePieChart(PieChart pieChart, float value, float total, UserGoalData data) {
            Intrinsics.checkNotNullParameter(pieChart, "pieChart");
            Intrinsics.checkNotNullParameter(data, "data");
            List listListOf = CollectionsKt.listOf((Object[]) new PieEntry[]{new PieEntry(value, ""), new PieEntry(total - value, "")});
            Triple<Integer, Integer, Integer> goalsColors = GoalsAdapterKt.getGoalsColors(this.this$0.context, data.getStatsType());
            PieDataSet pieDataSet = new PieDataSet(listListOf, "");
            pieDataSet.setColors(CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(this.this$0.context.getColor(goalsColors.getFirst().intValue())), Integer.valueOf(this.this$0.context.getColor(goalsColors.getSecond().intValue()))}));
            pieDataSet.setDrawValues(false);
            pieChart.setData(new PieData(pieDataSet));
            pieChart.invalidate();
        }
    }
}
