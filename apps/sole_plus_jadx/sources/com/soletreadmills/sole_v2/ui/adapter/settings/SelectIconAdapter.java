package com.soletreadmills.sole_v2.ui.adapter.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.bumptech.glide.Glide;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.settings.SelectIconData;
import com.soletreadmills.sole_v2.databinding.AdapterSelectIconItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.settings.SelectIconAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: SelectIconAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u001c\u0010\u000b\u001a\u00020\n2\n\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/SelectIconAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/settings/SelectIconData;", "Lcom/soletreadmills/sole_v2/ui/adapter/settings/SelectIconAdapter$ViewHolder;", "itemClickListener", "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getItemClickListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "notifyItemChangedAll", "", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectIconAdapter extends ListAdapter<SelectIconData, ViewHolder> {
    public static final int $stable = 8;
    private final OnItemClickListener itemClickListener;

    public static final /* synthetic */ SelectIconData access$getItem(SelectIconAdapter selectIconAdapter, int i) {
        return selectIconAdapter.getItem(i);
    }

    public final OnItemClickListener getItemClickListener() {
        return this.itemClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectIconAdapter(OnItemClickListener itemClickListener) {
        super(new DiffUtil.ItemCallback<SelectIconData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.settings.SelectIconAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(SelectIconData oldItem, SelectIconData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(SelectIconData oldItem, SelectIconData newItem) {
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
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_select_icon_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        return new ViewHolder(this, (AdapterSelectIconItemBinding) viewDataBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setBind(position);
    }

    /* compiled from: SelectIconAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/SelectIconAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterSelectIconItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/settings/SelectIconAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterSelectIconItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterSelectIconItemBinding;", "setBind", "", "position", "", "setSelect", "select", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterSelectIconItemBinding binding;
        final /* synthetic */ SelectIconAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SelectIconAdapter selectIconAdapter, AdapterSelectIconItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = selectIconAdapter;
            this.binding = binding;
        }

        public final AdapterSelectIconItemBinding getBinding() {
            return this.binding;
        }

        public final void setBind(int position) {
            SelectIconData selectIconDataAccess$getItem;
            try {
                selectIconDataAccess$getItem = SelectIconAdapter.access$getItem(this.this$0, position);
            } catch (Exception e) {
                Timber.INSTANCE.e(e.fillInStackTrace());
                selectIconDataAccess$getItem = null;
            }
            if (selectIconDataAccess$getItem == null) {
                return;
            }
            setSelect(selectIconDataAccess$getItem.isSelect());
            try {
                Glide.with(this.binding.getRoot()).clear(this.binding.headImg);
            } catch (Exception e2) {
                Timber.INSTANCE.e(e2);
            }
            try {
                Glide.with(this.binding.getRoot()).load(Integer.valueOf(selectIconDataAccess$getItem.getResouceId())).into(this.binding.headImg);
            } catch (Exception e3) {
                Timber.INSTANCE.e(e3);
            }
            ConstraintLayout constraintLayout = this.binding.mainLayout;
            final SelectIconAdapter selectIconAdapter = this.this$0;
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.settings.SelectIconAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectIconAdapter.ViewHolder.setBind$lambda$0(selectIconAdapter, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(SelectIconAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getItemClickListener().onClick(this$1.getBindingAdapterPosition());
        }

        public final void setSelect(boolean select) {
            this.binding.LLHead.setSelected(select);
            if (select) {
                this.binding.iconSelect.setVisibility(0);
                this.binding.outLine.setBackgroundResource(R.drawable.bg_corner24_outline_tinted_raised);
            } else {
                this.binding.iconSelect.setVisibility(8);
                this.binding.outLine.setBackgroundResource(R.drawable.bg_corner24_outline);
            }
        }
    }

    public final void notifyItemChangedAll() {
        notifyItemRangeChanged(0, getCurrentList().size());
    }
}
