package com.soletreadmills.sole_v2.ui.adapter.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.classes.FavoritesData;
import com.soletreadmills.sole_v2.databinding.AdapterMyFavoritesItemBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.adapter.settings.MyFavoritesAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: MyFavoritesAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/MyFavoritesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/classes/FavoritesData;", "Lcom/soletreadmills/sole_v2/ui/adapter/settings/MyFavoritesAdapter$ViewHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "getListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyFavoritesAdapter extends ListAdapter<FavoritesData, ViewHolder> {
    public static final int $stable = 8;
    private final OnItemClickListener listener;

    public static final /* synthetic */ FavoritesData access$getItem(MyFavoritesAdapter myFavoritesAdapter, int i) {
        return myFavoritesAdapter.getItem(i);
    }

    public final OnItemClickListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyFavoritesAdapter(OnItemClickListener listener) {
        super(new DiffUtil.ItemCallback<FavoritesData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.settings.MyFavoritesAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(FavoritesData oldItem, FavoritesData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem.getFavoriteId(), newItem.getFavoriteId());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(FavoritesData oldItem, FavoritesData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AdapterMyFavoritesItemBinding adapterMyFavoritesItemBindingInflate = AdapterMyFavoritesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(adapterMyFavoritesItemBindingInflate, "inflate(...)");
        return new ViewHolder(this, adapterMyFavoritesItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setBind(position);
    }

    /* compiled from: MyFavoritesAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/settings/MyFavoritesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterMyFavoritesItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/settings/MyFavoritesAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterMyFavoritesItemBinding;)V", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/AdapterMyFavoritesItemBinding;", "setBind", "", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterMyFavoritesItemBinding binding;
        final /* synthetic */ MyFavoritesAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(MyFavoritesAdapter myFavoritesAdapter, AdapterMyFavoritesItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = myFavoritesAdapter;
            this.binding = binding;
        }

        public final AdapterMyFavoritesItemBinding getBinding() {
            return this.binding;
        }

        public final void setBind(int position) {
            FavoritesData favoritesDataAccess$getItem = MyFavoritesAdapter.access$getItem(this.this$0, position);
            if (favoritesDataAccess$getItem == null) {
                return;
            }
            if (favoritesDataAccess$getItem.isEdit()) {
                this.binding.imgRemove.setVisibility(0);
            } else {
                this.binding.imgRemove.setVisibility(8);
            }
            try {
                Glide.with(this.binding.img).load(favoritesDataAccess$getItem.getObjectBackgroundUrl()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.ic_messages_sys_info)).into(this.binding.img);
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
            }
            this.binding.title.setText(favoritesDataAccess$getItem.getObjectName());
            if (Intrinsics.areEqual(favoritesDataAccess$getItem.getObjectType(), "CL")) {
                this.binding.parts.setText("" + favoritesDataAccess$getItem.getObjectWorkoutAmount() + this.binding.getRoot().getContext().getString(R.string.workouts));
            } else {
                List<String> objectClassTypeName = favoritesDataAccess$getItem.getObjectClassTypeName();
                this.binding.parts.setText(objectClassTypeName != null ? CollectionsKt.joinToString$default(objectClassTypeName, ", ", null, null, 0, null, null, 62, null) : null);
            }
            View root = this.binding.getRoot();
            final MyFavoritesAdapter myFavoritesAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.settings.MyFavoritesAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyFavoritesAdapter.ViewHolder.setBind$lambda$0(myFavoritesAdapter, this, view);
                }
            });
            ImageView imageView = this.binding.imgRemove;
            final MyFavoritesAdapter myFavoritesAdapter2 = this.this$0;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.settings.MyFavoritesAdapter$ViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyFavoritesAdapter.ViewHolder.setBind$lambda$1(myFavoritesAdapter2, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(MyFavoritesAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getListener().onClick(this$1.getBindingAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$1(MyFavoritesAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.getListener().onClick(this$1.getBindingAdapterPosition(), "delete");
        }
    }
}
