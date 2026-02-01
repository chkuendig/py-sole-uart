package com.soletreadmills.sole_v2.ui.adapter.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.history.HistoryListData;
import com.soletreadmills.sole_v2.databinding.AdapterHistoryHeaderItemBinding;
import com.soletreadmills.sole_v2.databinding.AdapterHistoryItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HistoryAdapter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u001b\u001c\u001d\u001e\u001fB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/api/history/HistoryListData;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "value", "", "showFooter", "getShowFooter", "()Z", "setShowFooter", "(Z)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "Companion", "DiffCallback", "FooterViewHolder", "HeaderViewHolder", "ItemViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HistoryAdapter extends ListAdapter<HistoryListData, RecyclerView.ViewHolder> {
    public static final int TYPE_FOOTER = 2;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    private final OnItemClickListener listener;
    private boolean showFooter;
    public static final int $stable = 8;

    public static final /* synthetic */ HistoryListData access$getItem(HistoryAdapter historyAdapter, int i) {
        return historyAdapter.getItem(i);
    }

    public final OnItemClickListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryAdapter(OnItemClickListener listener) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final boolean getShowFooter() {
        return this.showFooter;
    }

    public final void setShowFooter(boolean z) {
        if (this.showFooter != z) {
            this.showFooter = z;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return super.getItemCount() + (this.showFooter ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position < super.getItemCount()) {
            return getItem(position).isHeader() ? 0 : 1;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            AdapterHistoryHeaderItemBinding adapterHistoryHeaderItemBindingInflate = AdapterHistoryHeaderItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(adapterHistoryHeaderItemBindingInflate, "inflate(...)");
            return new HeaderViewHolder(this, adapterHistoryHeaderItemBindingInflate);
        }
        if (viewType == 2) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_history_footer_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new FooterViewHolder(viewInflate);
        }
        AdapterHistoryItemBinding adapterHistoryItemBindingInflate = AdapterHistoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterHistoryItemBindingInflate, "inflate(...)");
        return new ItemViewHolder(this, adapterHistoryItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).setBind(position);
        } else if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).setBind(position);
        } else {
            boolean z = holder instanceof FooterViewHolder;
        }
    }

    /* compiled from: HistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FooterViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FooterViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    /* compiled from: HistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterHistoryHeaderItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterHistoryHeaderItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterHistoryHeaderItemBinding;", "setBind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class HeaderViewHolder extends RecyclerView.ViewHolder {
        private final AdapterHistoryHeaderItemBinding binding;
        final /* synthetic */ HistoryAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(HistoryAdapter historyAdapter, AdapterHistoryHeaderItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = historyAdapter;
            this.binding = binding;
        }

        public final AdapterHistoryHeaderItemBinding getBinding() {
            return this.binding;
        }

        public final void setBind(int position) {
            HistoryListData historyListDataAccess$getItem = HistoryAdapter.access$getItem(this.this$0, position);
            if (historyListDataAccess$getItem == null) {
                return;
            }
            String string = this.binding.getRoot().getContext().getString(R.string.january);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = this.binding.getRoot().getContext().getString(R.string.february);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = this.binding.getRoot().getContext().getString(R.string.march);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = this.binding.getRoot().getContext().getString(R.string.april);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            String string5 = this.binding.getRoot().getContext().getString(R.string.may);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            String string6 = this.binding.getRoot().getContext().getString(R.string.june);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            String string7 = this.binding.getRoot().getContext().getString(R.string.july);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            String string8 = this.binding.getRoot().getContext().getString(R.string.august);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            String string9 = this.binding.getRoot().getContext().getString(R.string.september);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            String string10 = this.binding.getRoot().getContext().getString(R.string.october);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            String string11 = this.binding.getRoot().getContext().getString(R.string.november);
            Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
            String string12 = this.binding.getRoot().getContext().getString(R.string.december);
            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
            String[] strArr = {string, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12};
            int iIntValue = historyListDataAccess$getItem.getMonth() != null ? historyListDataAccess$getItem.getMonth().intValue() - 1 : 1;
            int iIntValue2 = historyListDataAccess$getItem.getYear() != null ? historyListDataAccess$getItem.getYear().intValue() : 2000;
            if (iIntValue >= 0 && iIntValue < 12) {
                this.binding.title.setText(strArr[iIntValue] + ' ' + iIntValue2);
            }
            Integer totalSize = historyListDataAccess$getItem.getTotalSize();
            this.binding.tvWorkoutsCount.setText(this.binding.getRoot().getContext().getString(R.string.workouts_count, String.valueOf(totalSize != null ? totalSize.intValue() : 0)));
        }
    }

    /* compiled from: HistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterHistoryItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterHistoryItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterHistoryItemBinding;", "setBind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ItemViewHolder extends RecyclerView.ViewHolder {
        private final AdapterHistoryItemBinding binding;
        final /* synthetic */ HistoryAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(HistoryAdapter historyAdapter, AdapterHistoryItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = historyAdapter;
            this.binding = binding;
        }

        public final AdapterHistoryItemBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x012f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void setBind(int r9) {
            /*
                Method dump skipped, instructions count: 404
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.adapter.history.HistoryAdapter.ItemViewHolder.setBind(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$1(HistoryAdapter this$0, ItemViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getListener().onClick(this$1.getBindingAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$2(HistoryAdapter this$0, ItemViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getListener().onClick(this$1.getBindingAdapterPosition(), "delete");
        }
    }

    /* compiled from: HistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/soletreadmills/sole_v2/_data/api/history/HistoryListData;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<HistoryListData> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(HistoryListData oldItem, HistoryListData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(HistoryListData oldItem, HistoryListData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
        }
    }
}
