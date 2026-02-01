package com.soletreadmills.sole_v2.ui.adapter.club;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.bumptech.glide.Glide;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberData;
import com.soletreadmills.sole_v2.databinding.AdapterClubAvatarItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClubAvatarItemAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0014B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubAvatarItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubAvatarItemAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "isShow", "", "(Landroid/content/Context;Z)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "updateVisibility", "show", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubAvatarItemAdapter extends ListAdapter<ChallengeMemberData, ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private boolean isShow;

    public /* synthetic */ ClubAvatarItemAdapter(Context context, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? true : z);
    }

    public ClubAvatarItemAdapter(Context context, boolean z) {
        super(new DiffUtil.ItemCallback<ChallengeMemberData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubAvatarItemAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(ChallengeMemberData oldItem, ChallengeMemberData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem.getGlobalUserUuid(), newItem.getGlobalUserUuid());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(ChallengeMemberData oldItem, ChallengeMemberData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
        this.context = context;
        this.isShow = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_club_avatar_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        return new ViewHolder(this, (AdapterClubAvatarItemBinding) viewDataBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ChallengeMemberData item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.setBind(item, position);
    }

    public final void updateVisibility(boolean show) {
        this.isShow = show;
        notifyDataSetChanged();
    }

    /* compiled from: ClubAvatarItemAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubAvatarItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterClubAvatarItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubAvatarItemAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterClubAvatarItemBinding;)V", "bindData", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "setBind", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterClubAvatarItemBinding binding;
        final /* synthetic */ ClubAvatarItemAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClubAvatarItemAdapter clubAvatarItemAdapter, AdapterClubAvatarItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = clubAvatarItemAdapter;
            this.binding = binding;
        }

        public final void setBind(ChallengeMemberData item, int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (this.this$0.isShow) {
                this.binding.cvAvatarWrap.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.binding.cvAvatarWrap.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, 0, -this.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_8), 0);
                if (position + 1 == this.this$0.getItemCount()) {
                    marginLayoutParams.setMarginStart(0);
                }
                bindData(item);
                return;
            }
            this.binding.cvAvatarWrap.setVisibility(8);
        }

        private final void bindData(ChallengeMemberData item) {
            AdapterClubAvatarItemBinding adapterClubAvatarItemBinding = this.binding;
            ClubAvatarItemAdapter clubAvatarItemAdapter = this.this$0;
            if (item.getUserSimpleInfo().getPhotoUrl() == null || clubAvatarItemAdapter.context == null) {
                return;
            }
            Glide.with(clubAvatarItemAdapter.context).load(item.getUserSimpleInfo().getPhotoUrl()).into(adapterClubAvatarItemBinding.imgAvatar);
        }
    }
}
