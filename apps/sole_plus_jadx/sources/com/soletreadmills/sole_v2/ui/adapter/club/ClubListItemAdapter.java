package com.soletreadmills.sole_v2.ui.adapter.club;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleData;
import com.soletreadmills.sole_v2.databinding.AdapterClubListItemBinding;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubListItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClubListItemAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0019\u001aB5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\fJ\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubListItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubListItemAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "itemOnClickListener", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubListItemAdapter$OnItemClickListener;", "isShow", "", "isTinyImg", "isAllView", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubListItemAdapter$OnItemClickListener;ZZLjava/lang/Boolean;)V", "Ljava/lang/Boolean;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "updateVisibility", "show", "OnItemClickListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubListItemAdapter extends ListAdapter<ChallengeItemSimpleData, ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private Boolean isAllView;
    private boolean isShow;
    private boolean isTinyImg;
    private final OnItemClickListener itemOnClickListener;

    /* compiled from: ClubListItemAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubListItemAdapter$OnItemClickListener;", "", SdkConstants.ATTR_ON_CLICK, "", "bindingAdapterPosition", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnItemClickListener {
        void onClick(int bindingAdapterPosition, ChallengeItemSimpleData item);
    }

    public /* synthetic */ ClubListItemAdapter(Context context, OnItemClickListener onItemClickListener, boolean z, boolean z2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onItemClickListener, (i & 4) != 0 ? true : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : bool);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubListItemAdapter(Context context, OnItemClickListener itemOnClickListener, boolean z, boolean z2, Boolean bool) {
        super(new DiffUtil.ItemCallback<ChallengeItemSimpleData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubListItemAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(ChallengeItemSimpleData oldItem, ChallengeItemSimpleData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem.getChallengeUuid(), newItem.getChallengeUuid());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(ChallengeItemSimpleData oldItem, ChallengeItemSimpleData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemOnClickListener, "itemOnClickListener");
        this.context = context;
        this.itemOnClickListener = itemOnClickListener;
        this.isShow = z;
        this.isTinyImg = z2;
        this.isAllView = bool;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_club_list_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        return new ViewHolder(this, (AdapterClubListItemBinding) viewDataBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ChallengeItemSimpleData item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.setBind(item, position);
    }

    public final void updateVisibility(boolean show) {
        this.isShow = show;
        notifyDataSetChanged();
    }

    /* compiled from: ClubListItemAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubListItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterClubListItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubListItemAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterClubListItemBinding;)V", "bindData", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "dpToPx", "", SdkConstants.UNIT_DP, "setBind", "position", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterClubListItemBinding binding;
        final /* synthetic */ ClubListItemAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClubListItemAdapter clubListItemAdapter, AdapterClubListItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = clubListItemAdapter;
            this.binding = binding;
        }

        public final void setBind(final ChallengeItemSimpleData item, final int position) throws NumberFormatException {
            Intrinsics.checkNotNullParameter(item, "item");
            if (this.this$0.isShow) {
                this.binding.llMainWrap.setVisibility(0);
                if (!Intrinsics.areEqual((Object) this.this$0.isAllView, (Object) true)) {
                    if (!this.this$0.isTinyImg) {
                        this.binding.llMainWrap.getLayoutParams().width = dpToPx(300);
                    } else {
                        this.binding.llMainWrap.getLayoutParams().width = dpToPx(144);
                    }
                } else {
                    int iDpToPx = (this.itemView.getContext().getResources().getDisplayMetrics().widthPixels - dpToPx(12)) - dpToPx(12);
                    ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = iDpToPx;
                    }
                    this.itemView.requestLayout();
                    ViewGroup.LayoutParams layoutParams2 = this.binding.imgMainWrap.getLayoutParams();
                    layoutParams2.width = iDpToPx;
                    this.binding.imgMainWrap.setLayoutParams(layoutParams2);
                }
                bindData(item);
                LinearLayout linearLayout = this.binding.llMainWrap;
                final ClubListItemAdapter clubListItemAdapter = this.this$0;
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubListItemAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClubListItemAdapter.ViewHolder.setBind$lambda$0(clubListItemAdapter, position, item, view);
                    }
                });
                return;
            }
            this.binding.llMainWrap.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(ClubListItemAdapter this$0, int i, ChallengeItemSimpleData item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.itemOnClickListener.onClick(i, item);
        }

        private final int dpToPx(int dp) {
            return (int) (dp * this.this$0.context.getResources().getDisplayMetrics().density);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0117  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void bindData(com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleData r19) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 941
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.adapter.club.ClubListItemAdapter.ViewHolder.bindData(com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleData):void");
        }
    }
}
