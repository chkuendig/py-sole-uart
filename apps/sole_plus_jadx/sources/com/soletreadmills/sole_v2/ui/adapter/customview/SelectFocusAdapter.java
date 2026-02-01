package com.soletreadmills.sole_v2.ui.adapter.customview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.classes.FocusData;
import com.soletreadmills.sole_v2._type.FocusType;
import com.soletreadmills.sole_v2.databinding.AdapterSelectFocusItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.customview.SelectFocusAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectFocusAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/customview/SelectFocusAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/classes/FocusData;", "Lcom/soletreadmills/sole_v2/ui/adapter/customview/SelectFocusAdapter$ViewHolder;", "itemClickListener", "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getItemClickListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectFocusAdapter extends ListAdapter<FocusData, ViewHolder> {
    public static final int $stable = 8;
    private final OnItemClickListener itemClickListener;

    public static final /* synthetic */ FocusData access$getItem(SelectFocusAdapter selectFocusAdapter, int i) {
        return selectFocusAdapter.getItem(i);
    }

    public final OnItemClickListener getItemClickListener() {
        return this.itemClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectFocusAdapter(OnItemClickListener itemClickListener) {
        super(new DiffUtil.ItemCallback<FocusData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.customview.SelectFocusAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(FocusData oldItem, FocusData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.getType() == newItem.getType();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(FocusData oldItem, FocusData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.isSelect() == newItem.isSelect();
            }
        });
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterSelectFocusItemBinding adapterSelectFocusItemBindingInflate = AdapterSelectFocusItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterSelectFocusItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterSelectFocusItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setBind(position);
    }

    /* compiled from: SelectFocusAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/customview/SelectFocusAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterSelectFocusItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/customview/SelectFocusAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterSelectFocusItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterSelectFocusItemBinding;", "setBind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterSelectFocusItemBinding binding;
        final /* synthetic */ SelectFocusAdapter this$0;

        /* compiled from: SelectFocusAdapter.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FocusType.values().length];
                try {
                    iArr[FocusType.ENDURANCE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FocusType.INTERVALS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FocusType.HILLS.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[FocusType.SPRINTS.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[FocusType.WALKS.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SelectFocusAdapter selectFocusAdapter, AdapterSelectFocusItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = selectFocusAdapter;
            this.binding = binding;
        }

        public final AdapterSelectFocusItemBinding getBinding() {
            return this.binding;
        }

        public final void setBind(int position) {
            FocusData focusDataAccess$getItem = SelectFocusAdapter.access$getItem(this.this$0, position);
            if (focusDataAccess$getItem == null) {
                return;
            }
            if (focusDataAccess$getItem.isSelect()) {
                this.binding.title.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorLabel_accent));
                this.binding.LL.setBackgroundResource(R.drawable.bg_corner32_outline_tinted_raised);
            } else {
                this.binding.title.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorLabel_label2));
                this.binding.LL.setBackgroundResource(R.drawable.bg_corner32_outline);
            }
            int i = WhenMappings.$EnumSwitchMapping$0[focusDataAccess$getItem.getType().ordinal()];
            if (i == 1) {
                this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.endurance));
            } else if (i == 2) {
                this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.intervals));
            } else if (i == 3) {
                this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.hills));
            } else if (i == 4) {
                this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.sprints));
            } else if (i == 5) {
                this.binding.title.setText(this.binding.getRoot().getContext().getString(R.string.walks));
            }
            LinearLayout linearLayout = this.binding.LL;
            final SelectFocusAdapter selectFocusAdapter = this.this$0;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.customview.SelectFocusAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectFocusAdapter.ViewHolder.setBind$lambda$0(selectFocusAdapter, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(SelectFocusAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getItemClickListener().onClick(this$1.getBindingAdapterPosition());
        }
    }
}
