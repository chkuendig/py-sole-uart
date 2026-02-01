package com.soletreadmills.sole_v2.adapter.selectProgram;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.android.material.slider.Slider;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.ble.SelectProgramSeekbarData;
import com.soletreadmills.sole_v2.adapter.selectProgram.SelectProgramSeekbarAdapter;
import com.soletreadmills.sole_v2.databinding.AdapterConnectEditProgramItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: SelectProgramSeekbarAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/soletreadmills/sole_v2/adapter/selectProgram/SelectProgramSeekbarAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/ble/SelectProgramSeekbarData;", "Lcom/soletreadmills/sole_v2/adapter/selectProgram/SelectProgramSeekbarAdapter$ViewHolder;", "itemOnClickListener", "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getItemOnClickListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectProgramSeekbarAdapter extends ListAdapter<SelectProgramSeekbarData, ViewHolder> {
    public static final int $stable = 8;
    private final OnItemClickListener itemOnClickListener;

    public final OnItemClickListener getItemOnClickListener() {
        return this.itemOnClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectProgramSeekbarAdapter(OnItemClickListener itemOnClickListener) {
        super(new DiffUtil.ItemCallback<SelectProgramSeekbarData>() { // from class: com.soletreadmills.sole_v2.adapter.selectProgram.SelectProgramSeekbarAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(SelectProgramSeekbarData oldItem, SelectProgramSeekbarData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.getValue() == newItem.getValue();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(SelectProgramSeekbarData oldItem, SelectProgramSeekbarData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
        Intrinsics.checkNotNullParameter(itemOnClickListener, "itemOnClickListener");
        this.itemOnClickListener = itemOnClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterConnectEditProgramItemBinding adapterConnectEditProgramItemBinding = (AdapterConnectEditProgramItemBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_connect_edit_program_item, parent, false);
        Intrinsics.checkNotNull(adapterConnectEditProgramItemBinding);
        return new ViewHolder(this, adapterConnectEditProgramItemBinding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setBind(position);
    }

    /* compiled from: SelectProgramSeekbarAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/adapter/selectProgram/SelectProgramSeekbarAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterConnectEditProgramItemBinding;", "(Lcom/soletreadmills/sole_v2/adapter/selectProgram/SelectProgramSeekbarAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterConnectEditProgramItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterConnectEditProgramItemBinding;", "setBind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterConnectEditProgramItemBinding binding;
        final /* synthetic */ SelectProgramSeekbarAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SelectProgramSeekbarAdapter selectProgramSeekbarAdapter, AdapterConnectEditProgramItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = selectProgramSeekbarAdapter;
            this.binding = binding;
        }

        public final AdapterConnectEditProgramItemBinding getBinding() {
            return this.binding;
        }

        public final void setBind(int position) {
            final SelectProgramSeekbarData selectProgramSeekbarData;
            String str;
            try {
                selectProgramSeekbarData = this.this$0.getCurrentList().get(position);
            } catch (Exception e) {
                Timber.INSTANCE.e(e.getMessage(), new Object[0]);
                selectProgramSeekbarData = null;
            }
            if (selectProgramSeekbarData == null) {
                return;
            }
            int seekbarType = selectProgramSeekbarData.getSeekbarType();
            if (seekbarType == 0) {
                this.binding.seekBar.setStepSize(5.0f);
                this.binding.seekBar.setValueTo(100.0f);
                this.binding.seekBar.setValueFrom(5.0f);
                str = " %";
            } else {
                if (seekbarType == 1) {
                    this.binding.seekBar.setStepSize(1.0f);
                    this.binding.seekBar.setValueTo(15.0f);
                    this.binding.seekBar.setValueFrom(0.0f);
                } else if (seekbarType == 2) {
                    this.binding.seekBar.setStepSize(1.0f);
                    this.binding.seekBar.setValueTo(20.0f);
                    this.binding.seekBar.setValueFrom(1.0f);
                }
                str = "";
            }
            this.binding.seekBar.setValue(selectProgramSeekbarData.getValue());
            this.binding.value.setText(selectProgramSeekbarData.getValue() + str);
            this.binding.number.setText(String.valueOf(position + 1));
            Slider slider = this.binding.seekBar;
            final SelectProgramSeekbarAdapter selectProgramSeekbarAdapter = this.this$0;
            slider.addOnChangeListener(new Slider.OnChangeListener() { // from class: com.soletreadmills.sole_v2.adapter.selectProgram.SelectProgramSeekbarAdapter$ViewHolder$$ExternalSyntheticLambda0
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.android.material.slider.Slider.OnChangeListener, com.google.android.material.slider.BaseOnChangeListener
                public final void onValueChange(Slider slider2, float f, boolean z) {
                    SelectProgramSeekbarAdapter.ViewHolder.setBind$lambda$0(selectProgramSeekbarData, this, selectProgramSeekbarAdapter, slider2, f, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(SelectProgramSeekbarData data, ViewHolder this$0, SelectProgramSeekbarAdapter this$1, Slider slider, float f, boolean z) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(slider, "slider");
            if (z) {
                int i = (int) f;
                if (data.getSeekbarType() == 0) {
                    this$0.binding.value.setText(i + " %");
                    this$1.getCurrentList().get(this$0.getBindingAdapterPosition()).setValue(i);
                } else {
                    this$0.binding.value.setText(String.valueOf(i));
                    this$1.getCurrentList().get(this$0.getBindingAdapterPosition()).setValue(i);
                }
                this$1.getItemOnClickListener().onClick(this$0.getBindingAdapterPosition());
            }
        }
    }
}
