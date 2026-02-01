package com.soletreadmills.sole_v2.ui.adapter.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.settings.GetSubscriptionPlansApiData;
import com.soletreadmills.sole_v2._extension.StringExtensionsKt;
import com.soletreadmills.sole_v2.databinding.AdapterPayWallItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.settings.PayWallAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayWallAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/PayWallAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPlansApiData$SubscriptionPlansData;", "Lcom/soletreadmills/sole_v2/ui/adapter/settings/PayWallAdapter$ViewHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PayWallAdapter extends ListAdapter<GetSubscriptionPlansApiData.SubscriptionPlansData, ViewHolder> {
    public static final int $stable = 8;
    private final OnItemClickListener listener;

    public static final /* synthetic */ GetSubscriptionPlansApiData.SubscriptionPlansData access$getItem(PayWallAdapter payWallAdapter, int i) {
        return payWallAdapter.getItem(i);
    }

    public final OnItemClickListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayWallAdapter(OnItemClickListener listener) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterPayWallItemBinding adapterPayWallItemBindingInflate = AdapterPayWallItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterPayWallItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterPayWallItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(position);
    }

    /* compiled from: PayWallAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/PayWallAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterPayWallItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/settings/PayWallAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterPayWallItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterPayWallItemBinding;", "bind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterPayWallItemBinding binding;
        final /* synthetic */ PayWallAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PayWallAdapter payWallAdapter, AdapterPayWallItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = payWallAdapter;
            this.binding = binding;
        }

        public final AdapterPayWallItemBinding getBinding() {
            return this.binding;
        }

        public final void bind(int position) {
            GetSubscriptionPlansApiData.SubscriptionPlansData subscriptionPlansDataAccess$getItem = PayWallAdapter.access$getItem(this.this$0, position);
            if (subscriptionPlansDataAccess$getItem == null) {
                return;
            }
            if (Global.INSTANCE.isSubscription()) {
                this.binding.imgCheck.setVisibility(8);
            } else {
                this.binding.imgCheck.setVisibility(0);
            }
            this.binding.tvTitle.setText(subscriptionPlansDataAccess$getItem.getTitle());
            this.binding.tvFee.setText(subscriptionPlansDataAccess$getItem.getFee());
            if (subscriptionPlansDataAccess$getItem.isSelect()) {
                this.binding.LL.setBackgroundResource(R.drawable.bg_corner24_outline_tinted_raised);
                this.binding.imgCheck.setSelected(true);
                this.binding.tvTitle.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorGlobal_accent));
                this.binding.tvDes.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorGlobal_accent));
                this.binding.tvFee.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorGlobal_accent));
            } else {
                this.binding.LL.setBackgroundResource(R.drawable.bg_corner24_outline_tinted_white);
                this.binding.imgCheck.setSelected(false);
                this.binding.tvTitle.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorGlobal_white));
                this.binding.tvDes.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorGlobal_white));
                this.binding.tvFee.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorGlobal_white));
            }
            TextView textView = this.binding.tvDes;
            String desc = subscriptionPlansDataAccess$getItem.getDesc();
            textView.setText(desc != null ? StringExtensionsKt.withHighlight(desc, ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.colorGlobal_notice)) : null);
            View root = this.binding.getRoot();
            final PayWallAdapter payWallAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.settings.PayWallAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PayWallAdapter.ViewHolder.bind$lambda$0(payWallAdapter, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(PayWallAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (Global.INSTANCE.isSubscription()) {
                return;
            }
            this$0.getListener().onClick(this$1.getBindingAdapterPosition());
        }
    }

    /* compiled from: PayWallAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/PayWallAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPlansApiData$SubscriptionPlansData;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<GetSubscriptionPlansApiData.SubscriptionPlansData> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(GetSubscriptionPlansApiData.SubscriptionPlansData oldItem, GetSubscriptionPlansApiData.SubscriptionPlansData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getPlan_id(), newItem.getPlan_id());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(GetSubscriptionPlansApiData.SubscriptionPlansData oldItem, GetSubscriptionPlansApiData.SubscriptionPlansData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }
}
