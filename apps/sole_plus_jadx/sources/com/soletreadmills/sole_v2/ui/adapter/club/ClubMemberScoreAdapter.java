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
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberWorkoutData;
import com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2.databinding.AdapterClubMemberScoreItemBinding;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClubMemberScoreItemAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0016B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubMemberScoreAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberWorkoutData;", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubMemberScoreAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "isShow", "", "scoreItem", "", "challengeType", "(Landroid/content/Context;ZII)V", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "updateVisibility", "show", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubMemberScoreAdapter extends ListAdapter<ChallengeMemberWorkoutData, ViewHolder> {
    public static final int $stable = 8;
    private int challengeType;
    private final Context context;
    private boolean isShow;
    private int scoreItem;

    public /* synthetic */ ClubMemberScoreAdapter(Context context, boolean z, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? true : z, i, i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubMemberScoreAdapter(Context context, boolean z, int i, int i2) {
        super(new DiffUtil.ItemCallback<ChallengeMemberWorkoutData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubMemberScoreAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(ChallengeMemberWorkoutData oldItem, ChallengeMemberWorkoutData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(ChallengeMemberWorkoutData oldItem, ChallengeMemberWorkoutData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.isShow = z;
        this.scoreItem = i;
        this.challengeType = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_club_member_score_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        return new ViewHolder(this, (AdapterClubMemberScoreItemBinding) viewDataBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ChallengeMemberWorkoutData item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.setBind(item, position);
    }

    public final void updateVisibility(boolean show) {
        this.isShow = show;
        notifyDataSetChanged();
    }

    /* compiled from: ClubMemberScoreItemAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubMemberScoreAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterClubMemberScoreItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubMemberScoreAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterClubMemberScoreItemBinding;)V", "bindData", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberWorkoutData;", "position", "", "setBind", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterClubMemberScoreItemBinding binding;
        final /* synthetic */ ClubMemberScoreAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClubMemberScoreAdapter clubMemberScoreAdapter, AdapterClubMemberScoreItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = clubMemberScoreAdapter;
            this.binding = binding;
        }

        public final void setBind(ChallengeMemberWorkoutData item, int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (this.this$0.isShow) {
                this.binding.llScoreboardWrap.setVisibility(0);
                bindData(item, position);
            } else {
                this.binding.llScoreboardWrap.setVisibility(8);
            }
        }

        private final void bindData(ChallengeMemberWorkoutData item, int position) {
            AdapterClubMemberScoreItemBinding adapterClubMemberScoreItemBinding = this.binding;
            ClubMemberScoreAdapter clubMemberScoreAdapter = this.this$0;
            adapterClubMemberScoreItemBinding.tvOrderNum.setText(String.valueOf(position + 1));
            this.binding.tvDate.setText(TimeTools.formatDateTime$default(TimeTools.INSTANCE, item.getEndTimeMillis(), null, 2, null));
            this.binding.tvDate.setText(Instant.ofEpochMilli(item.getEndTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault())));
            this.binding.tvUnit.setText(ClubListItemAdapterKt.getUnitText$default(clubMemberScoreAdapter.context, clubMemberScoreAdapter.scoreItem, Global.INSTANCE.getUnitType(), clubMemberScoreAdapter.scoreItem > 1, Integer.valueOf(clubMemberScoreAdapter.challengeType), true, false, 64, null));
            int i = clubMemberScoreAdapter.scoreItem;
            if (i == ChallengeScoreItemSettings.TOTAL_TIME.getId()) {
                this.binding.tvScoreValue.setText(ClubOngoingItemAdapterKt.getCurrentScoreVal$default(item.getTotalTime() != null ? Double.valueOf(r13.intValue()) : null, clubMemberScoreAdapter.scoreItem, Integer.valueOf(clubMemberScoreAdapter.challengeType), true, false, false, 48, null));
            } else if (i == ChallengeScoreItemSettings.TOTAL_DISTANCE.getId()) {
                this.binding.tvScoreValue.setText(ClubOngoingItemAdapterKt.getCurrentScoreVal$default(item.getTotalDistance(), clubMemberScoreAdapter.scoreItem, Integer.valueOf(clubMemberScoreAdapter.challengeType), false, false, false, 56, null));
            } else if (i == ChallengeScoreItemSettings.TOTAL_CALORIES.getId()) {
                this.binding.tvScoreValue.setText(ClubOngoingItemAdapterKt.getCurrentScoreVal$default(item.getTotalCalories() != null ? Double.valueOf(r13.intValue()) : null, clubMemberScoreAdapter.scoreItem, Integer.valueOf(clubMemberScoreAdapter.challengeType), false, false, false, 56, null));
            } else if (i == ChallengeScoreItemSettings.SESSION.getId()) {
                this.binding.tvScoreValue.setText(item.getTotalTime() != null ? TimeTools.secToTime02$default(TimeTools.INSTANCE, r13.intValue(), false, 2, null) : null);
                this.binding.tvUnit.setText("");
            } else if (i == ChallengeScoreItemSettings.RACE.getId()) {
                this.binding.tvScoreValue.setText(item.getTotalTime() != null ? TimeTools.secToTime02$default(TimeTools.INSTANCE, r13.intValue(), false, 2, null) : null);
                this.binding.tvUnit.setText("");
            }
            if (position % 2 == 0) {
                this.binding.llBg.setBackgroundResource(R.drawable.bg_corner18_black_alpha_8);
            } else {
                this.binding.llBg.setBackground(null);
            }
        }
    }
}
