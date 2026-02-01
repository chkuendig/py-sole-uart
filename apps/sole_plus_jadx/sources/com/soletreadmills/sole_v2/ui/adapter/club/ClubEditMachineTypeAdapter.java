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
import com.soletreadmills.sole_v2._data.club.ChallengeMachineTypeItems;
import com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings;
import com.soletreadmills.sole_v2.databinding.AdapterClubEditScoreItemBinding;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubEditMachineTypeAdapter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: ClubEditMachineTypeAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001e\u001fB3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u001c\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0015\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\fR\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006 "}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditMachineTypeAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMachineTypeItems;", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditMachineTypeAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "itemOnClickListener", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditMachineTypeAdapter$OnItemClickListener;", "activeId", "", "itemScoreId", "isShow", "", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditMachineTypeAdapter$OnItemClickListener;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "Ljava/lang/Integer;", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "updateActiveId", "newActiveId", "(Ljava/lang/Integer;)V", "updateItemScoreId", "newItemScoreId", "updateVisibility", "show", "OnItemClickListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubEditMachineTypeAdapter extends ListAdapter<ChallengeMachineTypeItems, ViewHolder> {
    public static final int $stable = 8;
    private Integer activeId;
    private final Context context;
    private boolean isShow;
    private final OnItemClickListener itemOnClickListener;
    private Integer itemScoreId;

    /* compiled from: ClubEditMachineTypeAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditMachineTypeAdapter$OnItemClickListener;", "", SdkConstants.ATTR_ON_CLICK, "", "bindingAdapterPosition", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMachineTypeItems;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnItemClickListener {
        void onClick(int bindingAdapterPosition, ChallengeMachineTypeItems item);
    }

    public /* synthetic */ ClubEditMachineTypeAdapter(Context context, OnItemClickListener onItemClickListener, Integer num, Integer num2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onItemClickListener, num, num2, (i & 16) != 0 ? true : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubEditMachineTypeAdapter(Context context, OnItemClickListener itemOnClickListener, Integer num, Integer num2, boolean z) {
        super(new DiffUtil.ItemCallback<ChallengeMachineTypeItems>() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubEditMachineTypeAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(ChallengeMachineTypeItems oldItem, ChallengeMachineTypeItems newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem == newItem;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(ChallengeMachineTypeItems oldItem, ChallengeMachineTypeItems newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
            }
        });
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemOnClickListener, "itemOnClickListener");
        this.context = context;
        this.itemOnClickListener = itemOnClickListener;
        this.activeId = num;
        this.itemScoreId = num2;
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

    public final void updateItemScoreId(Integer newItemScoreId) {
        Timber.INSTANCE.d("updateItemScoreId:" + newItemScoreId, new Object[0]);
        if (Intrinsics.areEqual(this.itemScoreId, newItemScoreId)) {
            return;
        }
        this.itemScoreId = newItemScoreId;
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
        ChallengeMachineTypeItems item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.setBind(item, position);
    }

    public final void updateVisibility(boolean show) {
        this.isShow = show;
        notifyDataSetChanged();
    }

    /* compiled from: ClubEditMachineTypeAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditMachineTypeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterClubEditScoreItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubEditMachineTypeAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterClubEditScoreItemBinding;)V", "bindData", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMachineTypeItems;", "position", "", "setBind", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterClubEditScoreItemBinding binding;
        final /* synthetic */ ClubEditMachineTypeAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClubEditMachineTypeAdapter clubEditMachineTypeAdapter, AdapterClubEditScoreItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = clubEditMachineTypeAdapter;
            this.binding = binding;
        }

        public final void setBind(final ChallengeMachineTypeItems item, final int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (this.this$0.isShow) {
                this.binding.llBtnWrap.setVisibility(0);
                bindData(item, position);
                TextView textView = this.binding.tvBtn;
                final ClubEditMachineTypeAdapter clubEditMachineTypeAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubEditMachineTypeAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClubEditMachineTypeAdapter.ViewHolder.setBind$lambda$0(clubEditMachineTypeAdapter, position, item, view);
                    }
                });
                return;
            }
            this.binding.llBtnWrap.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(ClubEditMachineTypeAdapter this$0, int i, ChallengeMachineTypeItems item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.itemOnClickListener.onClick(i, item);
        }

        private final void bindData(ChallengeMachineTypeItems item, int position) {
            String string;
            ClubEditMachineTypeAdapter clubEditMachineTypeAdapter = this.this$0;
            List<ChallengeScoreItemSettings> supportList = item.getSupportList();
            if ((supportList instanceof Collection) && supportList.isEmpty()) {
                this.binding.tvBtn.setVisibility(8);
            } else {
                Iterator<T> it = supportList.iterator();
                while (it.hasNext()) {
                    int id2 = ((ChallengeScoreItemSettings) it.next()).getId();
                    Integer num = clubEditMachineTypeAdapter.itemScoreId;
                    if (num != null && id2 == num.intValue()) {
                        this.binding.tvBtn.setVisibility(0);
                        break;
                    }
                }
                this.binding.tvBtn.setVisibility(8);
            }
            TextView textView = this.binding.tvBtn;
            Integer formTitleTextId = item.getFormTitleTextId();
            if (formTitleTextId != null) {
                string = clubEditMachineTypeAdapter.context.getString(formTitleTextId.intValue());
            } else {
                string = null;
            }
            textView.setText(string);
            if (Intrinsics.areEqual(item.getId(), clubEditMachineTypeAdapter.activeId)) {
                this.binding.tvBtn.setTextColor(ContextCompat.getColor(clubEditMachineTypeAdapter.context, R.color.colorPalette_red));
                this.binding.tvBtn.setBackgroundResource(R.drawable.bg_corner28_canvas_white);
            } else {
                this.binding.tvBtn.setTextColor(ContextCompat.getColor(clubEditMachineTypeAdapter.context, R.color.colorLabel_label3));
                this.binding.tvBtn.setBackgroundResource(android.R.color.transparent);
            }
        }
    }
}
