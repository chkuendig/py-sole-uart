package com.soletreadmills.sole_v2.ui.adapter.club;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.VirtualRaceCodeType;
import com.soletreadmills.sole_v2.databinding.AdapterClubEditScoreItemBinding;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubEditRaceDistanceItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClubEditRaceDistanceItemAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001a\u001bB'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditRaceDistanceItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/club/VirtualRaceCodeType;", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditRaceDistanceItemAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "itemOnClickListener", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditRaceDistanceItemAdapter$OnItemClickListener;", "activeId", "", "isShow", "", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditRaceDistanceItemAdapter$OnItemClickListener;Ljava/lang/String;Z)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "updateActiveId", "newActiveId", "updateVisibility", "show", "OnItemClickListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubEditRaceDistanceItemAdapter extends ListAdapter<VirtualRaceCodeType, ViewHolder> {
    public static final int $stable = 8;
    private String activeId;
    private final Context context;
    private boolean isShow;
    private final OnItemClickListener itemOnClickListener;

    /* compiled from: ClubEditRaceDistanceItemAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditRaceDistanceItemAdapter$OnItemClickListener;", "", SdkConstants.ATTR_ON_CLICK, "", "bindingAdapterPosition", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/VirtualRaceCodeType;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnItemClickListener {
        void onClick(int bindingAdapterPosition, VirtualRaceCodeType item);
    }

    public /* synthetic */ ClubEditRaceDistanceItemAdapter(Context context, OnItemClickListener onItemClickListener, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onItemClickListener, str, (i & 8) != 0 ? true : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubEditRaceDistanceItemAdapter(Context context, OnItemClickListener itemOnClickListener, String activeId, boolean z) {
        super(new DiffUtil.ItemCallback<VirtualRaceCodeType>() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubEditRaceDistanceItemAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(VirtualRaceCodeType oldItem, VirtualRaceCodeType newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem == newItem;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(VirtualRaceCodeType oldItem, VirtualRaceCodeType newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem.getCode(), newItem.getCode());
            }
        });
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemOnClickListener, "itemOnClickListener");
        Intrinsics.checkNotNullParameter(activeId, "activeId");
        this.context = context;
        this.itemOnClickListener = itemOnClickListener;
        this.activeId = activeId;
        this.isShow = z;
    }

    public final void updateActiveId(String newActiveId) {
        Intrinsics.checkNotNullParameter(newActiveId, "newActiveId");
        if (Intrinsics.areEqual(this.activeId, newActiveId)) {
            return;
        }
        this.activeId = newActiveId;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_club_edit_score_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        return new ViewHolder(this, (AdapterClubEditScoreItemBinding) viewDataBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        VirtualRaceCodeType item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.setBind(item, position);
    }

    public final void updateVisibility(boolean show) {
        this.isShow = show;
        notifyDataSetChanged();
    }

    /* compiled from: ClubEditRaceDistanceItemAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditRaceDistanceItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterClubEditScoreItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditRaceDistanceItemAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterClubEditScoreItemBinding;)V", "bindData", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/VirtualRaceCodeType;", "position", "", "setBind", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterClubEditScoreItemBinding binding;
        final /* synthetic */ ClubEditRaceDistanceItemAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClubEditRaceDistanceItemAdapter clubEditRaceDistanceItemAdapter, AdapterClubEditScoreItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = clubEditRaceDistanceItemAdapter;
            this.binding = binding;
        }

        public final void setBind(final VirtualRaceCodeType item, final int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (this.this$0.isShow) {
                this.binding.llBtnWrap.setVisibility(0);
                bindData(item, position);
                TextView textView = this.binding.tvBtn;
                final ClubEditRaceDistanceItemAdapter clubEditRaceDistanceItemAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubEditRaceDistanceItemAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClubEditRaceDistanceItemAdapter.ViewHolder.setBind$lambda$0(clubEditRaceDistanceItemAdapter, position, item, view);
                    }
                });
                return;
            }
            this.binding.llBtnWrap.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(ClubEditRaceDistanceItemAdapter this$0, int i, VirtualRaceCodeType item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.itemOnClickListener.onClick(i, item);
        }

        private final void bindData(VirtualRaceCodeType item, int position) {
            AdapterClubEditScoreItemBinding adapterClubEditScoreItemBinding = this.binding;
            ClubEditRaceDistanceItemAdapter clubEditRaceDistanceItemAdapter = this.this$0;
            adapterClubEditScoreItemBinding.tvBtn.setText(new StringBuilder().append(item.getDistanceKm()).append('K').toString());
            if (Intrinsics.areEqual(item.getCode(), clubEditRaceDistanceItemAdapter.activeId)) {
                this.binding.tvBtn.setTextColor(ContextCompat.getColor(clubEditRaceDistanceItemAdapter.context, R.color.colorPalette_red));
                this.binding.tvBtn.setBackgroundResource(R.drawable.bg_corner28_canvas_white);
            } else {
                this.binding.tvBtn.setTextColor(ContextCompat.getColor(clubEditRaceDistanceItemAdapter.context, R.color.colorLabel_label3));
                this.binding.tvBtn.setBackgroundResource(android.R.color.transparent);
            }
        }
    }
}
