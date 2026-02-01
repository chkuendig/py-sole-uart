package com.soletreadmills.sole_v2.ui.adapter.club;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.ChallengePrivacyLevelSettings;
import com.soletreadmills.sole_v2.databinding.AdapterClubEditPrivacyItemBinding;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubEditPrivacyAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: ClubEditPrivacyAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001b\u001cB)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u001c\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0015\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000bR\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditPrivacyAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/club/ChallengePrivacyLevelSettings;", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditPrivacyAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "itemOnClickListener", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditPrivacyAdapter$OnItemClickListener;", "activeId", "", "isShow", "", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditPrivacyAdapter$OnItemClickListener;Ljava/lang/Integer;Z)V", "Ljava/lang/Integer;", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "updateActiveId", "newActiveId", "(Ljava/lang/Integer;)V", "updateVisibility", "show", "OnItemClickListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubEditPrivacyAdapter extends ListAdapter<ChallengePrivacyLevelSettings, ViewHolder> {
    public static final int $stable = 8;
    private Integer activeId;
    private final Context context;
    private boolean isShow;
    private final OnItemClickListener itemOnClickListener;

    /* compiled from: ClubEditPrivacyAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditPrivacyAdapter$OnItemClickListener;", "", SdkConstants.ATTR_ON_CLICK, "", "bindingAdapterPosition", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengePrivacyLevelSettings;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnItemClickListener {
        void onClick(int bindingAdapterPosition, ChallengePrivacyLevelSettings item);
    }

    public /* synthetic */ ClubEditPrivacyAdapter(Context context, OnItemClickListener onItemClickListener, Integer num, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onItemClickListener, num, (i & 8) != 0 ? true : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubEditPrivacyAdapter(Context context, OnItemClickListener itemOnClickListener, Integer num, boolean z) {
        super(new DiffUtil.ItemCallback<ChallengePrivacyLevelSettings>() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubEditPrivacyAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(ChallengePrivacyLevelSettings oldItem, ChallengePrivacyLevelSettings newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem == newItem;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(ChallengePrivacyLevelSettings oldItem, ChallengePrivacyLevelSettings newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.getId() == newItem.getId();
            }
        });
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemOnClickListener, "itemOnClickListener");
        this.context = context;
        this.itemOnClickListener = itemOnClickListener;
        this.activeId = num;
        this.isShow = z;
    }

    public final void updateActiveId(Integer newActiveId) {
        Timber.INSTANCE.d("newActiveId:" + newActiveId, new Object[0]);
        if (Intrinsics.areEqual(this.activeId, newActiveId)) {
            return;
        }
        this.activeId = newActiveId;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_club_edit_privacy_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        return new ViewHolder(this, (AdapterClubEditPrivacyItemBinding) viewDataBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ChallengePrivacyLevelSettings item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.setBind(item, position);
    }

    public final void updateVisibility(boolean show) {
        this.isShow = show;
        notifyDataSetChanged();
    }

    /* compiled from: ClubEditPrivacyAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditPrivacyAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterClubEditPrivacyItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditPrivacyAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterClubEditPrivacyItemBinding;)V", "bindData", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengePrivacyLevelSettings;", "position", "", "setBind", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterClubEditPrivacyItemBinding binding;
        final /* synthetic */ ClubEditPrivacyAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClubEditPrivacyAdapter clubEditPrivacyAdapter, AdapterClubEditPrivacyItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = clubEditPrivacyAdapter;
            this.binding = binding;
        }

        public final void setBind(final ChallengePrivacyLevelSettings item, final int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (this.this$0.isShow) {
                this.binding.llBtnWrap.setVisibility(0);
                bindData(item, position);
                LinearLayout linearLayout = this.binding.llBtnWrap;
                final ClubEditPrivacyAdapter clubEditPrivacyAdapter = this.this$0;
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubEditPrivacyAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClubEditPrivacyAdapter.ViewHolder.setBind$lambda$0(clubEditPrivacyAdapter, position, item, view);
                    }
                });
                return;
            }
            this.binding.llBtnWrap.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(ClubEditPrivacyAdapter this$0, int i, ChallengePrivacyLevelSettings item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.itemOnClickListener.onClick(i, item);
        }

        private final void bindData(ChallengePrivacyLevelSettings item, int position) {
            AdapterClubEditPrivacyItemBinding adapterClubEditPrivacyItemBinding = this.binding;
            ClubEditPrivacyAdapter clubEditPrivacyAdapter = this.this$0;
            adapterClubEditPrivacyItemBinding.tvBtn.setText(clubEditPrivacyAdapter.context.getString(item.getFormTitleTextId()));
            int id2 = item.getId();
            Integer num = clubEditPrivacyAdapter.activeId;
            if (num != null && id2 == num.intValue()) {
                this.binding.tvBtn.setTextColor(ContextCompat.getColor(clubEditPrivacyAdapter.context, R.color.colorPalette_red));
                this.binding.tvIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(clubEditPrivacyAdapter.context, R.color.colorPalette_red)));
                this.binding.llBtnWrap.setBackgroundResource(R.drawable.bg_corner28_canvas_white);
            } else {
                this.binding.tvBtn.setTextColor(ContextCompat.getColor(clubEditPrivacyAdapter.context, R.color.colorLabel_label3));
                this.binding.tvIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(clubEditPrivacyAdapter.context, R.color.colorLabel_label4)));
                this.binding.llBtnWrap.setBackgroundResource(android.R.color.transparent);
            }
        }
    }
}
