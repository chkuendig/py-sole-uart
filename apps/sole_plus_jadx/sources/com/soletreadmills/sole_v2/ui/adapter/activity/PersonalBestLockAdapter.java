package com.soletreadmills.sole_v2.ui.adapter.activity;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2._type.PersonalBestType;
import com.soletreadmills.sole_v2.databinding.AdapterPersonalBestLockItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersonalBestLockAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/activity/PersonalBestLockAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_type/PersonalBestType;", "Lcom/soletreadmills/sole_v2/ui/adapter/activity/PersonalBestLockAdapter$ViewHolder;", "onItemClickListener", "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getOnItemClickListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersonalBestLockAdapter extends ListAdapter<PersonalBestType, ViewHolder> {
    public static final int $stable = 8;
    private final OnItemClickListener onItemClickListener;

    /* compiled from: PersonalBestLockAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/activity/PersonalBestLockAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/soletreadmills/sole_v2/_type/PersonalBestType;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<PersonalBestType> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(PersonalBestType oldItem, PersonalBestType newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem == newItem;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(PersonalBestType oldItem, PersonalBestType newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem == newItem;
        }
    }

    public static final /* synthetic */ PersonalBestType access$getItem(PersonalBestLockAdapter personalBestLockAdapter, int i) {
        return personalBestLockAdapter.getItem(i);
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalBestLockAdapter(OnItemClickListener onItemClickListener) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.onItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterPersonalBestLockItemBinding adapterPersonalBestLockItemBindingInflate = AdapterPersonalBestLockItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterPersonalBestLockItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterPersonalBestLockItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(position);
    }

    /* compiled from: PersonalBestLockAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/activity/PersonalBestLockAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterPersonalBestLockItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/activity/PersonalBestLockAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterPersonalBestLockItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterPersonalBestLockItemBinding;", "bind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterPersonalBestLockItemBinding binding;
        final /* synthetic */ PersonalBestLockAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PersonalBestLockAdapter personalBestLockAdapter, AdapterPersonalBestLockItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = personalBestLockAdapter;
            this.binding = binding;
        }

        public final AdapterPersonalBestLockItemBinding getBinding() {
            return this.binding;
        }

        public final void bind(int position) {
            PersonalBestType personalBestTypeAccess$getItem = PersonalBestLockAdapter.access$getItem(this.this$0, position);
            if (personalBestTypeAccess$getItem == null) {
                return;
            }
            this.binding.tvTitle.setText(this.binding.getRoot().getContext().getString(personalBestTypeAccess$getItem.getTitleResId()));
            this.binding.tvSubtitle.setText(this.binding.getRoot().getContext().getString(personalBestTypeAccess$getItem.getCaptionResId()));
            this.binding.imgBg.setImageResource(personalBestTypeAccess$getItem.getBackground());
        }
    }
}
