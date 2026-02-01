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
import com.soletreadmills.sole_v2._data.classes.DurationData;
import com.soletreadmills.sole_v2._type.DurationType;
import com.soletreadmills.sole_v2.databinding.AdapterSelectDurationItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.customview.SelectDurationAdapter;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectDurationAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/customview/SelectDurationAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/classes/DurationData;", "Lcom/soletreadmills/sole_v2/ui/adapter/customview/SelectDurationAdapter$ViewHolder;", "itemClickListener", "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getItemClickListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectDurationAdapter extends ListAdapter<DurationData, ViewHolder> {
    public static final int $stable = 8;
    private final OnItemClickListener itemClickListener;

    public static final /* synthetic */ DurationData access$getItem(SelectDurationAdapter selectDurationAdapter, int i) {
        return selectDurationAdapter.getItem(i);
    }

    public final OnItemClickListener getItemClickListener() {
        return this.itemClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectDurationAdapter(OnItemClickListener itemClickListener) {
        super(new DiffUtil.ItemCallback<DurationData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.customview.SelectDurationAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(DurationData oldItem, DurationData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return false;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(DurationData oldItem, DurationData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterSelectDurationItemBinding adapterSelectDurationItemBindingInflate = AdapterSelectDurationItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterSelectDurationItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterSelectDurationItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setBind(position);
    }

    /* compiled from: SelectDurationAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/customview/SelectDurationAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterSelectDurationItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/customview/SelectDurationAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterSelectDurationItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterSelectDurationItemBinding;", "setBind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterSelectDurationItemBinding binding;
        final /* synthetic */ SelectDurationAdapter this$0;

        /* compiled from: SelectDurationAdapter.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DurationType.values().length];
                try {
                    iArr[DurationType.MIN_5.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DurationType.MIN_10.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DurationType.MIN_15.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[DurationType.MIN_20.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[DurationType.MIN_30.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[DurationType.MIN_45.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[DurationType.MIN_60.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SelectDurationAdapter selectDurationAdapter, AdapterSelectDurationItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = selectDurationAdapter;
            this.binding = binding;
        }

        public final AdapterSelectDurationItemBinding getBinding() {
            return this.binding;
        }

        public final void setBind(int position) {
            DurationData durationDataAccess$getItem = SelectDurationAdapter.access$getItem(this.this$0, position);
            if (durationDataAccess$getItem == null) {
                return;
            }
            if (durationDataAccess$getItem.isSelect()) {
                this.binding.time.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorLabel_accent));
                this.binding.unit.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorLabel_accent));
                this.binding.LL.setBackgroundResource(R.drawable.bg_corner32_outline_tinted_raised);
            } else {
                this.binding.time.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorLabel_label2));
                this.binding.unit.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorLabel_label2));
                this.binding.LL.setBackgroundResource(R.drawable.bg_corner32_outline);
            }
            switch (WhenMappings.$EnumSwitchMapping$0[durationDataAccess$getItem.getType().ordinal()]) {
                case 1:
                    this.binding.time.setText(TlbConst.TYPELIB_MINOR_VERSION_OFFICE);
                    break;
                case 2:
                    this.binding.time.setText("10");
                    break;
                case 3:
                    this.binding.time.setText("15");
                    break;
                case 4:
                    this.binding.time.setText("20");
                    break;
                case 5:
                    this.binding.time.setText("30");
                    break;
                case 6:
                    this.binding.time.setText("45");
                    break;
                case 7:
                    this.binding.time.setText("60");
                    break;
            }
            LinearLayout linearLayout = this.binding.LL;
            final SelectDurationAdapter selectDurationAdapter = this.this$0;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.customview.SelectDurationAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectDurationAdapter.ViewHolder.setBind$lambda$0(selectDurationAdapter, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(SelectDurationAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getItemClickListener().onClick(this$1.getBindingAdapterPosition());
        }
    }
}
