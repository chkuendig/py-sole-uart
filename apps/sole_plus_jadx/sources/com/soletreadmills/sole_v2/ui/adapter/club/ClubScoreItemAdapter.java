package com.soletreadmills.sole_v2.ui.adapter.club;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.bumptech.glide.Glide;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberData;
import com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings;
import com.soletreadmills.sole_v2.databinding.AdapterClubScoreboardItemBinding;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubScoreItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClubScoreboardItemAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0019\u001aB7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u001c\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\tR\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubScoreItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubScoreItemAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "itemOnClickListener", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubScoreItemAdapter$OnItemClickListener;", "isShow", "", "scoreItem", "", "challengeType", "isEdit", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubScoreItemAdapter$OnItemClickListener;ZIIZ)V", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "updateVisibility", "show", "OnItemClickListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubScoreItemAdapter extends ListAdapter<ChallengeMemberData, ViewHolder> {
    public static final int $stable = 8;
    private int challengeType;
    private final Context context;
    private boolean isEdit;
    private boolean isShow;
    private final OnItemClickListener itemOnClickListener;
    private int scoreItem;

    /* compiled from: ClubScoreboardItemAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubScoreItemAdapter$OnItemClickListener;", "", SdkConstants.ATTR_ON_CLICK, "", "bindingAdapterPosition", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "onDeleteClick", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnItemClickListener {
        void onClick(int bindingAdapterPosition, ChallengeMemberData item);

        void onDeleteClick(int bindingAdapterPosition, ChallengeMemberData item);
    }

    public /* synthetic */ ClubScoreItemAdapter(Context context, OnItemClickListener onItemClickListener, boolean z, int i, int i2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onItemClickListener, (i3 & 4) != 0 ? true : z, i, i2, z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubScoreItemAdapter(Context context, OnItemClickListener itemOnClickListener, boolean z, int i, int i2, boolean z2) {
        super(new DiffUtil.ItemCallback<ChallengeMemberData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubScoreItemAdapter.1
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
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemOnClickListener, "itemOnClickListener");
        this.context = context;
        this.itemOnClickListener = itemOnClickListener;
        this.isShow = z;
        this.scoreItem = i;
        this.challengeType = i2;
        this.isEdit = z2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_club_scoreboard_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        return new ViewHolder(this, (AdapterClubScoreboardItemBinding) viewDataBindingInflate);
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

    /* compiled from: ClubScoreboardItemAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubScoreItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterClubScoreboardItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubScoreItemAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterClubScoreboardItemBinding;)V", "bindData", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "position", "", "setBind", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterClubScoreboardItemBinding binding;
        final /* synthetic */ ClubScoreItemAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClubScoreItemAdapter clubScoreItemAdapter, AdapterClubScoreboardItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = clubScoreItemAdapter;
            this.binding = binding;
        }

        public final void setBind(final ChallengeMemberData item, int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (this.this$0.isShow) {
                this.binding.llScoreboardWrap.setVisibility(0);
                bindData(item, position);
                LinearLayout linearLayout = this.binding.llScoreboardWrap;
                final ClubScoreItemAdapter clubScoreItemAdapter = this.this$0;
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubScoreItemAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClubScoreItemAdapter.ViewHolder.setBind$lambda$0(clubScoreItemAdapter, item, this, view);
                    }
                });
                if (this.this$0.isEdit) {
                    this.binding.imgDelete.setVisibility(0);
                    ImageView imageView = this.binding.imgDelete;
                    final ClubScoreItemAdapter clubScoreItemAdapter2 = this.this$0;
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubScoreItemAdapter$ViewHolder$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ClubScoreItemAdapter.ViewHolder.setBind$lambda$1(clubScoreItemAdapter2, this, item, view);
                        }
                    });
                    return;
                }
                this.binding.imgDelete.setVisibility(8);
                return;
            }
            this.binding.llScoreboardWrap.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$0(ClubScoreItemAdapter this$0, ChallengeMemberData item, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.challengeType == ChallengeTypeSettings.VIRTUAL_RACE.getId() || ClubScoreboardItemAdapterKt.isNoScoreData(this$0.challengeType, item.getRank(), item.getCurrentScore())) {
                return;
            }
            this$0.itemOnClickListener.onClick(this$1.getBindingAdapterPosition(), item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$1(ClubScoreItemAdapter this$0, ViewHolder this$1, ChallengeMemberData item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.itemOnClickListener.onDeleteClick(this$1.getBindingAdapterPosition(), item);
        }

        private final void bindData(ChallengeMemberData item, int position) {
            boolean zAreEqual = Intrinsics.areEqual(item.getGlobalUserUuid(), Global.getLoginAccountNo());
            ClubScoreItemAdapter clubScoreItemAdapter = this.this$0;
            Glide.with(clubScoreItemAdapter.context).load(item.getUserSimpleInfo().getPhotoUrl()).into(this.binding.imgAvatar);
            this.binding.tvUsername.setText(item.getUserSimpleInfo().getNickName());
            int i = clubScoreItemAdapter.challengeType;
            if (i == ChallengeTypeSettings.RANKING.getId()) {
                this.binding.imgArrow.setVisibility(0);
                this.binding.tvRank.setText(String.valueOf(item.getRank()));
                this.binding.tvScoreValue.setText(ClubOngoingItemAdapterKt.getCurrentScoreVal$default(item.getCurrentScore(), clubScoreItemAdapter.scoreItem, Integer.valueOf(clubScoreItemAdapter.challengeType), false, false, false, 56, null));
                this.binding.tvUnit.setText(ClubListItemAdapterKt.getUnitText$default(clubScoreItemAdapter.context, clubScoreItemAdapter.scoreItem, Global.INSTANCE.getUnitType(), clubScoreItemAdapter.scoreItem > 1, Integer.valueOf(clubScoreItemAdapter.challengeType), false, false, 96, null));
            } else if (i == ChallengeTypeSettings.GOAL.getId()) {
                this.binding.tvRank.setVisibility(8);
                this.binding.imgArrow.setVisibility(0);
                this.binding.tvScoreValue.setText(String.valueOf((int) item.getProgress()));
                this.binding.tvUnit.setText("%");
            } else if (i == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
                this.binding.tvRank.setText(String.valueOf(item.getRank()));
                this.binding.tvScoreValue.setText(ClubOngoingItemAdapterKt.getCurrentScoreVal$default(item.getCurrentScore(), clubScoreItemAdapter.scoreItem, Integer.valueOf(clubScoreItemAdapter.challengeType), false, false, false, 56, null));
                this.binding.tvUnit.setVisibility(8);
                this.binding.imgArrow.setVisibility(8);
                this.binding.tvUnit.setText(ClubListItemAdapterKt.getUnitText$default(clubScoreItemAdapter.context, clubScoreItemAdapter.scoreItem, Global.INSTANCE.getUnitType(), clubScoreItemAdapter.scoreItem > 1, Integer.valueOf(clubScoreItemAdapter.challengeType), false, false, 96, null));
            }
            if (ClubScoreboardItemAdapterKt.isNoScoreData(clubScoreItemAdapter.challengeType, item.getRank(), item.getCurrentScore())) {
                this.binding.tvRank.setText("--");
                this.binding.tvUnit.setVisibility(8);
                this.binding.imgAvatar.setBackground(null);
                this.binding.imgArrow.setVisibility(8);
                this.binding.tvUsername.setTextColor(ContextCompat.getColor(clubScoreItemAdapter.context, R.color.colorLabel_label3));
                this.binding.tvRank.setTextColor(ContextCompat.getColor(clubScoreItemAdapter.context, R.color.colorLabel_label3));
                this.binding.tvScoreValue.setText("--");
                this.binding.tvScoreValue.setTextColor(ContextCompat.getColor(clubScoreItemAdapter.context, R.color.colorLabel_label3));
            }
            if (position % 2 == 0) {
                this.binding.llBg.setBackgroundResource(R.drawable.bg_corner18_black_alpha_8);
                if (zAreEqual) {
                    this.binding.llBg.setBackgroundResource(R.drawable.bg_corner18_red_alpha_12);
                } else {
                    this.binding.llBg.setBackgroundResource(R.drawable.bg_corner18_black_alpha_8);
                }
            }
            if (zAreEqual) {
                this.binding.imgIsSelf.setVisibility(0);
                this.binding.tvUsername.setTextColor(ContextCompat.getColor(clubScoreItemAdapter.context, R.color.colorPalette_red));
                this.binding.tvRank.setTextColor(ContextCompat.getColor(clubScoreItemAdapter.context, R.color.colorPalette_red));
                this.binding.tvScoreValue.setTextColor(ContextCompat.getColor(clubScoreItemAdapter.context, R.color.colorPalette_red));
                this.binding.tvUnit.setTextColor(ContextCompat.getColor(clubScoreItemAdapter.context, R.color.colorPalette_red));
                this.binding.tvUsername.setText(clubScoreItemAdapter.context.getString(R.string.challenge_self_name));
            }
        }
    }
}
