package com.soletreadmills.sole_v2.ui.adapter.club;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleData;
import com.soletreadmills.sole_v2.databinding.AdapterClubSearchItemBinding;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClubSearchItemAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0017\u0018B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubSearchItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubSearchItemAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "itemOnClickListener", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubSearchItemAdapter$OnItemClickListener;", "isShow", "", "isEdit", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubSearchItemAdapter$OnItemClickListener;ZZ)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "updateVisibility", "show", "OnItemClickListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubSearchItemAdapter extends ListAdapter<ChallengeItemSimpleData, ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private boolean isEdit;
    private boolean isShow;
    private final OnItemClickListener itemOnClickListener;

    /* compiled from: ClubSearchItemAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubSearchItemAdapter$OnItemClickListener;", "", SdkConstants.ATTR_ON_CLICK, "", "bindingAdapterPosition", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "onDeleteClick", "onQuitClick", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnItemClickListener {
        void onClick(int bindingAdapterPosition, ChallengeItemSimpleData item);

        void onDeleteClick(int bindingAdapterPosition, ChallengeItemSimpleData item);

        void onQuitClick(int bindingAdapterPosition, ChallengeItemSimpleData item);
    }

    public /* synthetic */ ClubSearchItemAdapter(Context context, OnItemClickListener onItemClickListener, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onItemClickListener, (i & 4) != 0 ? true : z, (i & 8) != 0 ? false : z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubSearchItemAdapter(Context context, OnItemClickListener itemOnClickListener, boolean z, boolean z2) {
        super(new DiffUtil.ItemCallback<ChallengeItemSimpleData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.1
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
        this.isEdit = z2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_club_search_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        return new ViewHolder(this, (AdapterClubSearchItemBinding) viewDataBindingInflate);
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

    /* compiled from: ClubSearchItemAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubSearchItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterClubSearchItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubSearchItemAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterClubSearchItemBinding;)V", "bindData", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "setBind", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterClubSearchItemBinding binding;
        final /* synthetic */ ClubSearchItemAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClubSearchItemAdapter clubSearchItemAdapter, AdapterClubSearchItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = clubSearchItemAdapter;
            this.binding = binding;
        }

        public final void setBind(final ChallengeItemSimpleData item, final int position) throws NumberFormatException {
            Intrinsics.checkNotNullParameter(item, "item");
            if (this.this$0.isShow) {
                this.binding.llMainWrap.setVisibility(0);
                bindData(item);
                LinearLayout linearLayout = this.binding.llCardWrap;
                final ClubSearchItemAdapter clubSearchItemAdapter = this.this$0;
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClubSearchItemAdapter.ViewHolder.setBind$lambda$0(clubSearchItemAdapter, position, item, view);
                    }
                });
                ImageView imageView = this.binding.imgQuitBtn;
                final ClubSearchItemAdapter clubSearchItemAdapter2 = this.this$0;
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClubSearchItemAdapter.ViewHolder.setBind$lambda$1(clubSearchItemAdapter2, position, item, view);
                    }
                });
                ImageView imageView2 = this.binding.imgDeleteBtn;
                final ClubSearchItemAdapter clubSearchItemAdapter3 = this.this$0;
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClubSearchItemAdapter.ViewHolder.setBind$lambda$2(clubSearchItemAdapter3, position, item, view);
                    }
                });
                return;
            }
            this.binding.llMainWrap.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(ClubSearchItemAdapter this$0, int i, ChallengeItemSimpleData item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.itemOnClickListener.onClick(i, item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$1(ClubSearchItemAdapter this$0, int i, ChallengeItemSimpleData item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.itemOnClickListener.onQuitClick(i, item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$2(ClubSearchItemAdapter this$0, int i, ChallengeItemSimpleData item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.itemOnClickListener.onDeleteClick(i, item);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00f6  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void bindData(com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleData r17) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 851
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.ViewHolder.bindData(com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleData):void");
        }
    }
}
