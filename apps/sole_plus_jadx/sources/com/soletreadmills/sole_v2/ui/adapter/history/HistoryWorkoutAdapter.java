package com.soletreadmills.sole_v2.ui.adapter.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._type.HistoryActivityType;
import com.soletreadmills.sole_v2.databinding.AdapterHistoryWorkoutItemBinding;
import com.soletreadmills.sole_v2.ui.adapter.history.HistoryWorkoutAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HistoryWorkoutAdapter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0011\u0012B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u001c\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryWorkoutAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "", "Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryWorkoutAdapter$ViewHolder;", "rootHistoryActivityType", "Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "(Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;)V", "getRootHistoryActivityType", "()Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HistoryWorkoutAdapter extends ListAdapter<Integer, ViewHolder> {
    public static final int $stable = 0;
    private final HistoryActivityType rootHistoryActivityType;

    public static final /* synthetic */ Integer access$getItem(HistoryWorkoutAdapter historyWorkoutAdapter, int i) {
        return historyWorkoutAdapter.getItem(i);
    }

    public final HistoryActivityType getRootHistoryActivityType() {
        return this.rootHistoryActivityType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryWorkoutAdapter(HistoryActivityType rootHistoryActivityType) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(rootHistoryActivityType, "rootHistoryActivityType");
        this.rootHistoryActivityType = rootHistoryActivityType;
    }

    /* compiled from: HistoryWorkoutAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryWorkoutAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<Integer> {
        public static final int $stable = 0;

        public boolean areContentsTheSame(int oldItem, int newItem) {
            return oldItem == newItem;
        }

        public boolean areItemsTheSame(int oldItem, int newItem) {
            return oldItem == newItem;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public /* bridge */ /* synthetic */ boolean areContentsTheSame(Integer num, Integer num2) {
            return areContentsTheSame(num.intValue(), num2.intValue());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public /* bridge */ /* synthetic */ boolean areItemsTheSame(Integer num, Integer num2) {
            return areItemsTheSame(num.intValue(), num2.intValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterHistoryWorkoutItemBinding adapterHistoryWorkoutItemBindingInflate = AdapterHistoryWorkoutItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterHistoryWorkoutItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterHistoryWorkoutItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(position);
    }

    /* compiled from: HistoryWorkoutAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryWorkoutAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterHistoryWorkoutItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/history/HistoryWorkoutAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterHistoryWorkoutItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterHistoryWorkoutItemBinding;", "bind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterHistoryWorkoutItemBinding binding;
        final /* synthetic */ HistoryWorkoutAdapter this$0;

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(View view) {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(HistoryWorkoutAdapter historyWorkoutAdapter, AdapterHistoryWorkoutItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = historyWorkoutAdapter;
            this.binding = binding;
        }

        public final AdapterHistoryWorkoutItemBinding getBinding() {
            return this.binding;
        }

        public final void bind(int position) {
            String string;
            String str;
            Integer numAccess$getItem = HistoryWorkoutAdapter.access$getItem(this.this$0, position);
            if (numAccess$getItem == null) {
                return;
            }
            int iIntValue = numAccess$getItem.intValue();
            if (this.this$0.getRootHistoryActivityType() == HistoryActivityType.ROWING) {
                string = this.binding.getRoot().getContext().getString(R.string.m);
            } else if (Global.INSTANCE.getUnitType()) {
                string = this.binding.getRoot().getContext().getString(R.string.mi);
            } else {
                string = this.binding.getRoot().getContext().getString(R.string.km);
            }
            Intrinsics.checkNotNull(string);
            TextView textView = this.binding.txtTitle;
            if (this.this$0.getRootHistoryActivityType() == HistoryActivityType.ROWING) {
                str = "" + ((position + 1) * 500) + ' ' + string;
            } else {
                str = "" + (position + 1) + ' ' + string;
            }
            textView.setText(str);
            this.binding.txtPace.setText(TimeTools.secToTime02$default(TimeTools.INSTANCE, iIntValue, false, 2, null));
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.history.HistoryWorkoutAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistoryWorkoutAdapter.ViewHolder.bind$lambda$0(view);
                }
            });
        }
    }
}
