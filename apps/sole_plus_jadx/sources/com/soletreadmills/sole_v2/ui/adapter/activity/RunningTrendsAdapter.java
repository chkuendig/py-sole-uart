package com.soletreadmills.sole_v2.ui.adapter.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2._data.TrendItemWithDWM;
import com.soletreadmills.sole_v2._data.UserWorkout12WeeklyStatsVoData;
import com.soletreadmills.sole_v2._type.TrendsType;
import com.soletreadmills.sole_v2.databinding.AdapterRunningTrendsItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.activity.RunningTrendsAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RunningTrendsAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0016\u0017B\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/activity/RunningTrendsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_type/TrendsType;", "Lcom/soletreadmills/sole_v2/ui/adapter/activity/RunningTrendsAdapter$ViewHolder;", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/UserWorkout12WeeklyStatsVoData;", "onItemClickListener", "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/_data/UserWorkout12WeeklyStatsVoData;Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getItem", "()Lcom/soletreadmills/sole_v2/_data/UserWorkout12WeeklyStatsVoData;", "getOnItemClickListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RunningTrendsAdapter extends ListAdapter<TrendsType, ViewHolder> {
    public static final int $stable = 8;
    private final UserWorkout12WeeklyStatsVoData item;
    private final OnItemClickListener onItemClickListener;

    /* compiled from: RunningTrendsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/activity/RunningTrendsAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/soletreadmills/sole_v2/_type/TrendsType;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<TrendsType> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(TrendsType oldItem, TrendsType newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem == newItem;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(TrendsType oldItem, TrendsType newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem == newItem;
        }
    }

    public static final /* synthetic */ TrendsType access$getItem(RunningTrendsAdapter runningTrendsAdapter, int i) {
        return runningTrendsAdapter.getItem(i);
    }

    public final UserWorkout12WeeklyStatsVoData getItem() {
        return this.item;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunningTrendsAdapter(UserWorkout12WeeklyStatsVoData userWorkout12WeeklyStatsVoData, OnItemClickListener onItemClickListener) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.item = userWorkout12WeeklyStatsVoData;
        this.onItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterRunningTrendsItemBinding adapterRunningTrendsItemBindingInflate = AdapterRunningTrendsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterRunningTrendsItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterRunningTrendsItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(position);
    }

    /* compiled from: RunningTrendsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/activity/RunningTrendsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterRunningTrendsItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/activity/RunningTrendsAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterRunningTrendsItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterRunningTrendsItemBinding;", "bind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterRunningTrendsItemBinding binding;
        final /* synthetic */ RunningTrendsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(RunningTrendsAdapter runningTrendsAdapter, AdapterRunningTrendsItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = runningTrendsAdapter;
            this.binding = binding;
        }

        public final AdapterRunningTrendsItemBinding getBinding() {
            return this.binding;
        }

        public final void bind(int position) {
            TrendsType trendsTypeAccess$getItem = RunningTrendsAdapter.access$getItem(this.this$0, position);
            this.binding.name.setText(this.binding.getRoot().getContext().getString(trendsTypeAccess$getItem.getTitleResId()));
            TextView textView = this.binding.unit;
            Context context = this.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setText(trendsTypeAccess$getItem.getUnit(context));
            final TrendItemWithDWM<Double> threeMonthsDetailData = trendsTypeAccess$getItem.getThreeMonthsDetailData(this.this$0.getItem());
            this.binding.value.setText(trendsTypeAccess$getItem.formatValue(threeMonthsDetailData != null ? threeMonthsDetailData.getItemValue() : null));
            this.binding.unit2.setText(this.binding.getRoot().getContext().getString(trendsTypeAccess$getItem.getCaptionResId()));
            this.binding.value.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), trendsTypeAccess$getItem.getColorResId()));
            this.binding.unit.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), trendsTypeAccess$getItem.getColorResId()));
            View root = this.binding.getRoot();
            final RunningTrendsAdapter runningTrendsAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.activity.RunningTrendsAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RunningTrendsAdapter.ViewHolder.bind$lambda$0(threeMonthsDetailData, runningTrendsAdapter, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(TrendItemWithDWM trendItemWithDWM, RunningTrendsAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if ((trendItemWithDWM != null ? (Double) trendItemWithDWM.getItemValue() : null) == null) {
                return;
            }
            this$0.getOnItemClickListener().onClick(this$1.getBindingAdapterPosition());
        }
    }
}
