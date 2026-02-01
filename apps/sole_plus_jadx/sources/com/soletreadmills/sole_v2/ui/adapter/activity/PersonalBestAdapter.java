package com.soletreadmills.sole_v2.ui.adapter.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2._data.UserPersonalBestVoData;
import com.soletreadmills.sole_v2._type.PersonalBestType;
import com.soletreadmills.sole_v2.databinding.AdapterPersonalBestItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.activity.PersonalBestAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersonalBestAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/activity/PersonalBestAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/UserPersonalBestVoData;", "Lcom/soletreadmills/sole_v2/ui/adapter/activity/PersonalBestAdapter$ViewHolder;", "onItemClickListener", "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getOnItemClickListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersonalBestAdapter extends ListAdapter<UserPersonalBestVoData, ViewHolder> {
    public static final int $stable = 8;
    private final OnItemClickListener onItemClickListener;

    public static final /* synthetic */ UserPersonalBestVoData access$getItem(PersonalBestAdapter personalBestAdapter, int i) {
        return personalBestAdapter.getItem(i);
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalBestAdapter(OnItemClickListener onItemClickListener) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.onItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterPersonalBestItemBinding adapterPersonalBestItemBindingInflate = AdapterPersonalBestItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterPersonalBestItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterPersonalBestItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(position);
    }

    /* compiled from: PersonalBestAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/activity/PersonalBestAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterPersonalBestItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/activity/PersonalBestAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterPersonalBestItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterPersonalBestItemBinding;", "bind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterPersonalBestItemBinding binding;
        final /* synthetic */ PersonalBestAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PersonalBestAdapter personalBestAdapter, AdapterPersonalBestItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = personalBestAdapter;
            this.binding = binding;
        }

        public final AdapterPersonalBestItemBinding getBinding() {
            return this.binding;
        }

        public final void bind(int position) {
            UserPersonalBestVoData userPersonalBestVoDataAccess$getItem = PersonalBestAdapter.access$getItem(this.this$0, position);
            if (userPersonalBestVoDataAccess$getItem == null) {
                return;
            }
            PersonalBestType personalBestItem = userPersonalBestVoDataAccess$getItem.getPersonalBestItem();
            this.binding.tvTitle.setText(this.binding.getRoot().getContext().getString(personalBestItem.getTitleResId()));
            this.binding.tvDate.setText(userPersonalBestVoDataAccess$getItem.getAchieveDate());
            this.binding.imgBg.setImageResource(personalBestItem.getBackground());
            this.binding.imgIcon.setImageResource(personalBestItem.getIcon());
            this.binding.tvSubtitle1.setText(userPersonalBestVoDataAccess$getItem.getMainValueStr());
            this.binding.tvSubtitle2.setText(userPersonalBestVoDataAccess$getItem.getSubValueStr());
            TextView textView = this.binding.tvSubtitle1Unit;
            Context context = this.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setText(userPersonalBestVoDataAccess$getItem.getUnit(context));
            TextView textView2 = this.binding.tvSubtitle2Unit;
            Context context2 = this.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            textView2.setText(userPersonalBestVoDataAccess$getItem.getUnit(context2));
            TextView tvSubtitle1Unit = this.binding.tvSubtitle1Unit;
            Intrinsics.checkNotNullExpressionValue(tvSubtitle1Unit, "tvSubtitle1Unit");
            tvSubtitle1Unit.setVisibility(!userPersonalBestVoDataAccess$getItem.getMainValueIsTime() ? 0 : 8);
            TextView tvSubtitle2Unit = this.binding.tvSubtitle2Unit;
            Intrinsics.checkNotNullExpressionValue(tvSubtitle2Unit, "tvSubtitle2Unit");
            tvSubtitle2Unit.setVisibility(userPersonalBestVoDataAccess$getItem.getSubValueIsTime() ? 8 : 0);
            ConstraintLayout root = this.binding.getRoot();
            final PersonalBestAdapter personalBestAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.activity.PersonalBestAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PersonalBestAdapter.ViewHolder.bind$lambda$0(personalBestAdapter, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(PersonalBestAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getOnItemClickListener().onClick(this$1.getBindingAdapterPosition());
        }
    }

    /* compiled from: PersonalBestAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/activity/PersonalBestAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/soletreadmills/sole_v2/_data/UserPersonalBestVoData;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<UserPersonalBestVoData> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(UserPersonalBestVoData oldItem, UserPersonalBestVoData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getEventTime(), newItem.getEventTime());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(UserPersonalBestVoData oldItem, UserPersonalBestVoData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }
}
