package com.soletreadmills.sole_v2.ui.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.classes.DurationType;
import com.soletreadmills.sole_v2._data.home.PickedForYouData;
import com.soletreadmills.sole_v2.databinding.AdapterPickForYouItemBinding;
import com.soletreadmills.sole_v2.ui.adapter.home.PickForYouAdapter;
import com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragmentKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: PickForYouAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u0014\u0015\u0016B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/home/PickForYouAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/home/PickedForYouData;", "Lcom/soletreadmills/sole_v2/ui/adapter/home/PickForYouAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "onItemClickListener", "Lcom/soletreadmills/sole_v2/ui/adapter/home/PickForYouAdapter$OnItemClickListener;", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/ui/adapter/home/PickForYouAdapter$OnItemClickListener;)V", "getOnItemClickListener", "()Lcom/soletreadmills/sole_v2/ui/adapter/home/PickForYouAdapter$OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "OnItemClickListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PickForYouAdapter extends ListAdapter<PickedForYouData, ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private final OnItemClickListener onItemClickListener;

    /* compiled from: PickForYouAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/home/PickForYouAdapter$OnItemClickListener;", "", "onItemClick", "", "data", "Lcom/soletreadmills/sole_v2/_data/home/PickedForYouData;", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnItemClickListener {
        void onItemClick(PickedForYouData data, int position);
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickForYouAdapter(Context context, OnItemClickListener onItemClickListener) {
        super(new DiffCallback());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    /* compiled from: PickForYouAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/home/PickForYouAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/soletreadmills/sole_v2/_data/home/PickedForYouData;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<PickedForYouData> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(PickedForYouData oldItem, PickedForYouData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getClassId(), newItem.getClassId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(PickedForYouData oldItem, PickedForYouData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getClassId(), newItem.getClassId()) && Intrinsics.areEqual(oldItem.isFavorite(), newItem.isFavorite());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterPickForYouItemBinding adapterPickForYouItemBindingInflate = AdapterPickForYouItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterPickForYouItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterPickForYouItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PickedForYouData item = getItem(position);
        Intrinsics.checkNotNull(item);
        holder.bind(item, position);
    }

    /* compiled from: PickForYouAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/home/PickForYouAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterPickForYouItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/home/PickForYouAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterPickForYouItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterPickForYouItemBinding;", "bind", "", "data", "Lcom/soletreadmills/sole_v2/_data/home/PickedForYouData;", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterPickForYouItemBinding binding;
        final /* synthetic */ PickForYouAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PickForYouAdapter pickForYouAdapter, AdapterPickForYouItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = pickForYouAdapter;
            this.binding = binding;
        }

        public final AdapterPickForYouItemBinding getBinding() {
            return this.binding;
        }

        public final void bind(final PickedForYouData data, final int position) {
            String strLocalized;
            Intrinsics.checkNotNullParameter(data, "data");
            this.binding.title.setText(data.getClassName());
            TextView textView = this.binding.parts;
            String classTypeName = data.getClassTypeName();
            if (classTypeName != null) {
                Context context = this.this$0.context;
                String lowerCase = classTypeName.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                strLocalized = ClassesDetailFragmentKt.localized(context, lowerCase);
            } else {
                strLocalized = null;
            }
            textView.setText(strLocalized);
            this.binding.imgFavorite.setVisibility(8);
            if (Intrinsics.areEqual((Object) data.isFavorite(), (Object) true)) {
                this.binding.imgFavorite.setVisibility(0);
            }
            DurationType durationTypeFromRaw = DurationType.INSTANCE.fromRaw(data.getDuration());
            this.binding.min.setText(durationTypeFromRaw != null ? durationTypeFromRaw.getTitle() : null);
            try {
                Glide.with(this.binding.img).load(data.getBackgroundUrl()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.ic_messages_sys_info)).into(this.binding.img);
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
            }
            View root = this.binding.getRoot();
            final PickForYouAdapter pickForYouAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.home.PickForYouAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PickForYouAdapter.ViewHolder.bind$lambda$1(pickForYouAdapter, data, position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(PickForYouAdapter this$0, PickedForYouData data, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            this$0.getOnItemClickListener().onItemClick(data, i);
        }
    }
}
