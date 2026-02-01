package com.soletreadmills.sole_v2.ui.adapter.club;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.cardview.widget.CardView;
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
import com.soletreadmills.sole_v2._data.club.ChallengeActivityStatus;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleDataWithMemberData;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberData;
import com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings;
import com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings;
import com.soletreadmills.sole_v2._data.club.ChallengeVirtualRaceFailReasonSettings;
import com.soletreadmills.sole_v2._data.club.VirtualRaceCodeType;
import com.soletreadmills.sole_v2._tools.CalcDaysBetweenKt;
import com.soletreadmills.sole_v2.databinding.AdapterClubOngiongItemBinding;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: ClubOngoingItemAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0016\u0017B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubOngoingItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleDataWithMemberData;", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubOngoingItemAdapter$ViewHolder;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "itemOnClickListener", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubOngoingItemAdapter$OnItemClickListener;", "isShow", "", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubOngoingItemAdapter$OnItemClickListener;Z)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", SdkConstants.ATTR_PARENT, "Landroid/view/ViewGroup;", "viewType", "updateVisibility", "show", "OnItemClickListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubOngoingItemAdapter extends ListAdapter<ChallengeItemSimpleDataWithMemberData, ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private boolean isShow;
    private final OnItemClickListener itemOnClickListener;

    /* compiled from: ClubOngoingItemAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubOngoingItemAdapter$OnItemClickListener;", "", SdkConstants.ATTR_ON_CLICK, "", "bindingAdapterPosition", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleDataWithMemberData;", "onStartRaceClick", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnItemClickListener {
        void onClick(int bindingAdapterPosition, ChallengeItemSimpleDataWithMemberData item);

        void onStartRaceClick(int bindingAdapterPosition, ChallengeItemSimpleDataWithMemberData item);
    }

    public /* synthetic */ ClubOngoingItemAdapter(Context context, OnItemClickListener onItemClickListener, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onItemClickListener, (i & 4) != 0 ? true : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClubOngoingItemAdapter(Context context, OnItemClickListener itemOnClickListener, boolean z) {
        super(new DiffUtil.ItemCallback<ChallengeItemSimpleDataWithMemberData>() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(ChallengeItemSimpleDataWithMemberData oldItem, ChallengeItemSimpleDataWithMemberData newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem.getChallengeUuid(), newItem.getChallengeUuid());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(ChallengeItemSimpleDataWithMemberData oldItem, ChallengeItemSimpleDataWithMemberData newItem) {
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
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_club_ongiong_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        return new ViewHolder(this, (AdapterClubOngiongItemBinding) viewDataBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ChallengeItemSimpleDataWithMemberData item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.setBind(item, position);
    }

    public final void updateVisibility(boolean show) {
        this.isShow = show;
        notifyDataSetChanged();
    }

    /* compiled from: ClubOngoingItemAdapter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J8\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J8\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubOngoingItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/soletreadmills/sole_v2/databinding/AdapterClubOngiongItemBinding;", "(Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubOngoingItemAdapter;Lcom/soletreadmills/sole_v2/databinding/AdapterClubOngiongItemBinding;)V", "bindData", "", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleDataWithMemberData;", "bindRankingItem", "data", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "position", "", "maxScore", "", "minScore", "scoreItem", "challengeType", "bindRankingProgressItem", "hideGoalArea", "hideRankArea", "hideVirtualRaceArea", "setBind", "showGoalArea", "myData", "showRankArea", "showVirtualRaceArea", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterClubOngiongItemBinding binding;
        final /* synthetic */ ClubOngoingItemAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClubOngoingItemAdapter clubOngoingItemAdapter, AdapterClubOngiongItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = clubOngoingItemAdapter;
            this.binding = binding;
        }

        public final void setBind(final ChallengeItemSimpleDataWithMemberData item, int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (this.this$0.isShow) {
                this.binding.cvOngoingCard.setVisibility(0);
                this.binding.tvGoalUnit.setVisibility(0);
                this.binding.LLProgress1.getLayoutParams().width = -2;
                this.binding.LLProgress2.getLayoutParams().width = -2;
                this.binding.LLProgress3.getLayoutParams().width = -2;
                this.binding.LLProgress1.requestLayout();
                this.binding.LLProgress2.requestLayout();
                this.binding.LLProgress3.requestLayout();
                bindData(item);
                this.binding.getRoot().post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ClubOngoingItemAdapter.ViewHolder.setBind$lambda$3(this.f$0, item);
                    }
                });
                CardView cardView = this.binding.cvOngoingCard;
                final ClubOngoingItemAdapter clubOngoingItemAdapter = this.this$0;
                cardView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapter$ViewHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClubOngoingItemAdapter.ViewHolder.setBind$lambda$4(clubOngoingItemAdapter, this, item, view);
                    }
                });
                TextView textView = this.binding.tvRaceButton;
                final ClubOngoingItemAdapter clubOngoingItemAdapter2 = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapter$ViewHolder$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ClubOngoingItemAdapter.ViewHolder.setBind$lambda$5(clubOngoingItemAdapter2, this, item, view);
                    }
                });
                return;
            }
            this.binding.cvOngoingCard.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$3(final ViewHolder this$0, final ChallengeItemSimpleDataWithMemberData item) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            int iMax = Math.max(this$0.binding.LLProgress1.getWidth(), Math.max(this$0.binding.LLProgress2.getWidth(), this$0.binding.LLProgress3.getWidth()));
            this$0.binding.LLProgress1.getLayoutParams().width = iMax;
            this$0.binding.LLProgress2.getLayoutParams().width = iMax;
            this$0.binding.LLProgress3.getLayoutParams().width = iMax;
            this$0.binding.LLProgress1.requestLayout();
            this$0.binding.LLProgress2.requestLayout();
            this$0.binding.LLProgress3.requestLayout();
            this$0.binding.LLProgress3.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapter$ViewHolder$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ClubOngoingItemAdapter.ViewHolder.setBind$lambda$3$lambda$2(item, this$0);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$3$lambda$2(ChallengeItemSimpleDataWithMemberData item, ViewHolder this$0) {
            double dDoubleValue;
            int i;
            Double currentScore;
            Double currentScore2;
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            List<ChallengeMemberData> rankingList = ClubOngoingItemAdapterKt.getRankingList(item.getMemberList(), Global.getLoginAccountNo());
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = rankingList.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
                if (!zHasNext) {
                    break;
                }
                Object next = it.next();
                Double currentScore3 = ((ChallengeMemberData) next).getCurrentScore();
                if ((currentScore3 != null ? currentScore3.doubleValue() : 0.0d) > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = arrayList;
            ChallengeMemberData challengeMemberData = (ChallengeMemberData) CollectionsKt.firstOrNull((List) arrayList2);
            double dDoubleValue2 = (challengeMemberData == null || (currentScore2 = challengeMemberData.getCurrentScore()) == null) ? 0.0d : currentScore2.doubleValue();
            ChallengeMemberData challengeMemberData2 = (ChallengeMemberData) CollectionsKt.lastOrNull((List) arrayList2);
            if (challengeMemberData2 != null && (currentScore = challengeMemberData2.getCurrentScore()) != null) {
                dDoubleValue = currentScore.doubleValue();
            }
            double d = dDoubleValue;
            int i2 = 0;
            int i3 = 0;
            for (Object obj : rankingList) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ChallengeMemberData challengeMemberData3 = (ChallengeMemberData) obj;
                if (i3 == 0) {
                    i = i2;
                    this$0.binding.imgRank1Wrap.setVisibility(i);
                    this$0.bindRankingProgressItem(challengeMemberData3, 1, dDoubleValue2, d, item.getScoreItem(), item.getChallengeType());
                } else if (i3 == 1) {
                    i = i2;
                    this$0.binding.imgRank2Wrap.setVisibility(i);
                    this$0.bindRankingProgressItem(challengeMemberData3, 2, dDoubleValue2, d, item.getScoreItem(), item.getChallengeType());
                } else if (i3 != 2) {
                    i = i2;
                } else {
                    this$0.binding.imgRank3Wrap.setVisibility(i2);
                    i = i2;
                    this$0.bindRankingProgressItem(challengeMemberData3, 3, dDoubleValue2, d, item.getScoreItem(), item.getChallengeType());
                }
                i2 = i;
                i3 = i4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$4(ClubOngoingItemAdapter this$0, ViewHolder this$1, ChallengeItemSimpleDataWithMemberData item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.itemOnClickListener.onClick(this$1.getBindingAdapterPosition(), item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setBind$lambda$5(ClubOngoingItemAdapter this$0, ViewHolder this$1, ChallengeItemSimpleDataWithMemberData item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.itemOnClickListener.onStartRaceClick(this$1.getBindingAdapterPosition(), item);
        }

        private final void bindData(ChallengeItemSimpleDataWithMemberData item) {
            Object next;
            String loginAccountNo = Global.getLoginAccountNo();
            Iterator<T> it = item.getMemberList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((ChallengeMemberData) next).getGlobalUserUuid(), loginAccountNo)) {
                        break;
                    }
                }
            }
            ChallengeMemberData challengeMemberData = (ChallengeMemberData) next;
            if (challengeMemberData == null) {
                Timber.INSTANCE.e("錯誤: 找不到該用戶資料 globalUserUuid:" + loginAccountNo, new Object[0]);
            }
            AdapterClubOngiongItemBinding adapterClubOngiongItemBinding = this.binding;
            ClubOngoingItemAdapter clubOngoingItemAdapter = this.this$0;
            if (item.getChallengeType() == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
                adapterClubOngiongItemBinding.imgOngoingThumb.setScaleType(ImageView.ScaleType.FIT_CENTER);
                VirtualRaceCodeType.Companion companion = VirtualRaceCodeType.INSTANCE;
                String virtualRaceCode = item.getVirtualRaceCode();
                if (virtualRaceCode == null) {
                    virtualRaceCode = "";
                }
                VirtualRaceCodeType virtualRaceCodeTypeFromCode = companion.fromCode(virtualRaceCode);
                if ((virtualRaceCodeTypeFromCode != null ? virtualRaceCodeTypeFromCode.getImageResourceId() : null) != null) {
                    Glide.with(clubOngoingItemAdapter.context).load(virtualRaceCodeTypeFromCode.getImageResourceId()).into(adapterClubOngiongItemBinding.imgOngoingThumb);
                } else {
                    Glide.with(clubOngoingItemAdapter.context).load(item.getPhotoUrl()).into(adapterClubOngiongItemBinding.imgOngoingThumb);
                }
            } else {
                adapterClubOngiongItemBinding.imgOngoingThumb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Glide.with(clubOngoingItemAdapter.context).load(item.getPhotoUrl()).into(adapterClubOngiongItemBinding.imgOngoingThumb);
            }
            adapterClubOngiongItemBinding.imgOngoingTitle.setText(item.getChallengeName());
            int iCalculateProgressPercent$default = ClubOngoingItemAdapterKt.calculateProgressPercent$default(item.getStartTimeMillis(), item.getEndTimeMillis(), false, 4, null);
            int iCalculateProgressPercent = ClubOngoingItemAdapterKt.calculateProgressPercent(item.getStartTimeMillis(), item.getEndTimeMillis(), true);
            adapterClubOngiongItemBinding.imgOngoingProcessVal.setText(String.valueOf((int) item.getProgress()));
            if (item.getChallengeType() == ChallengeTypeSettings.RANKING.getId()) {
                adapterClubOngiongItemBinding.imgOngoingProcessVal.setText(String.valueOf(iCalculateProgressPercent$default));
            }
            if (item.getChallengeType() == ChallengeTypeSettings.VIRTUAL_RACE.getId() && challengeMemberData != null && challengeMemberData.isPassForVirtualRace()) {
                adapterClubOngiongItemBinding.imgOngoingProcessVal.setText("100");
            }
            this.binding.participantCount.setText(String.valueOf(item.getMemberCount()));
            adapterClubOngiongItemBinding.progressBar.setProgress(iCalculateProgressPercent$default);
            if (item.getChallengeType() == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
                adapterClubOngiongItemBinding.progressBar.setProgress(iCalculateProgressPercent);
            }
            adapterClubOngiongItemBinding.imgOngoingLeftTimeVal.setText(CalcDaysBetweenKt.formatDurationText(Calendar.getInstance().getTimeInMillis(), item.getEndTimeMillis()));
            hideVirtualRaceArea();
            hideGoalArea();
            hideRankArea();
            int challengeType = item.getChallengeType();
            if (challengeType == ChallengeTypeSettings.GOAL.getId()) {
                if (challengeMemberData != null) {
                    showGoalArea(item, challengeMemberData);
                }
            } else if (challengeType == ChallengeTypeSettings.RANKING.getId()) {
                showRankArea(item);
            } else if (challengeType == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
                showVirtualRaceArea(item, challengeMemberData);
            } else {
                showVirtualRaceArea(item, challengeMemberData);
            }
        }

        private final void showVirtualRaceArea(ChallengeItemSimpleDataWithMemberData item, ChallengeMemberData myData) {
            this.binding.llVirtualRaceAreaWrap.setVisibility(0);
            this.binding.llVirtualRaceNotStartYet.setVisibility(8);
            this.binding.llVirtualRaceNotComplete.setVisibility(8);
            this.binding.llVirtualRaceSelfDelete.setVisibility(8);
            this.binding.llVirtualRaceSingleScore.setVisibility(8);
            this.binding.tvVrScore.setText(ClubOngoingItemAdapterKt.getCurrentScoreVal$default(myData != null ? myData.getCurrentScore() : null, item.getScoreItem(), Integer.valueOf(item.getChallengeType()), false, false, false, 56, null));
            if (myData != null && myData.isPassForVirtualRace()) {
                List<ChallengeMemberData> memberList = item.getMemberList();
                ArrayList arrayList = new ArrayList();
                for (Object obj : memberList) {
                    if (((ChallengeMemberData) obj).isPassForVirtualRace()) {
                        arrayList.add(obj);
                    }
                }
                if (CollectionsKt.take(arrayList, 2).size() > 1) {
                    Timber.INSTANCE.d("VIEW:多位通過 - 顯示rankList1", new Object[0]);
                    LinearLayout linearLayout = this.binding.llVirtualRaceAreaWrap;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    showRankArea(item);
                } else {
                    Timber.INSTANCE.d("VIEW:1位通過1", new Object[0]);
                    LinearLayout linearLayout2 = this.binding.llVirtualRaceSingleScore;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                }
            } else {
                Integer virtualRaceFailReason = myData != null ? myData.getVirtualRaceFailReason() : null;
                int id2 = ChallengeVirtualRaceFailReasonSettings.NOT_START_YET.getId();
                if (virtualRaceFailReason != null && virtualRaceFailReason.intValue() == id2) {
                    if (item.getActivityStatus() == ChallengeActivityStatus.FINISHED.getId()) {
                        Timber.INSTANCE.d("VIEW: NotComplete", new Object[0]);
                        this.binding.llVirtualRaceNotComplete.setVisibility(0);
                    } else {
                        Timber.INSTANCE.d("VIEW: NotStart", new Object[0]);
                        if (item.getActivityStatus() == ChallengeActivityStatus.IN_PROGRESS.getId() || item.getActivityStatus() == ChallengeActivityStatus.IN_PROGRESS_EARLY.getId()) {
                            AdapterClubOngiongItemBinding adapterClubOngiongItemBinding = this.binding;
                            LinearLayout linearLayout3 = adapterClubOngiongItemBinding != null ? adapterClubOngiongItemBinding.llVirtualRaceNotStartYet : null;
                            if (linearLayout3 != null) {
                                linearLayout3.setVisibility(0);
                            }
                        }
                    }
                } else {
                    int id3 = ChallengeVirtualRaceFailReasonSettings.USER_DELETE_WORKOUT.getId();
                    if (virtualRaceFailReason != null && virtualRaceFailReason.intValue() == id3) {
                        Timber.INSTANCE.d("VIEW: SelfDelete", new Object[0]);
                        this.binding.llVirtualRaceSelfDelete.setVisibility(0);
                    } else if (virtualRaceFailReason == null) {
                        Timber.INSTANCE.d("VIEW: NotStart", new Object[0]);
                        this.binding.llVirtualRaceNotStartYet.setVisibility(0);
                    }
                }
            }
            TimeZone timeZone = TimeZone.getDefault();
            Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault(...)");
            this.binding.llVirtualRaceNotStartYetTime.setText(this.binding.getRoot().getContext().getString(R.string.club_race_ongoing_desc, ClubListItemAdapterKt.formatCountdownToEndLabel(this.this$0.context, item.getEndTimeMillis(), item.getTimeZone(), timeZone, true)));
        }

        private final void hideVirtualRaceArea() {
            this.binding.llVirtualRaceAreaWrap.setVisibility(8);
        }

        private final void showGoalArea(final ChallengeItemSimpleDataWithMemberData item, ChallengeMemberData myData) {
            this.binding.llGoalAreaWrap.setVisibility(0);
            final FrameLayout vGoalProgressWrap = this.binding.vGoalProgressWrap;
            Intrinsics.checkNotNullExpressionValue(vGoalProgressWrap, "vGoalProgressWrap");
            final View vGoalProgress = this.binding.vGoalProgress;
            Intrinsics.checkNotNullExpressionValue(vGoalProgress, "vGoalProgress");
            vGoalProgressWrap.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ClubOngoingItemAdapter.ViewHolder.showGoalArea$lambda$9(vGoalProgressWrap, item, vGoalProgress);
                }
            });
            this.binding.tvGoalVal.setText(ClubOngoingItemAdapterKt.getCurrentScoreVal$default(Double.valueOf(item.getGoalValue()), item.getScoreItem(), Integer.valueOf(item.getChallengeType()), false, true, false, 40, null));
            this.binding.tvGoalNowVal.setText(ClubOngoingItemAdapterKt.getCurrentScoreVal$default(item.getCurrentScore(), item.getScoreItem(), Integer.valueOf(item.getChallengeType()), false, false, false, 56, null));
            this.binding.tvGoalUnit.setText(ClubListItemAdapterKt.getUnitText$default(this.this$0.context, item.getScoreItem(), Global.INSTANCE.getUnitType(), item.getScoreItem() > 1, Integer.valueOf(item.getChallengeType()), false, false, 96, null));
            if (item.getChallengeType() == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
                this.binding.tvGoalUnit.setText(this.this$0.context.getString(R.string.race));
            }
            if (item.getChallengeType() == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
                this.binding.tvGoalUnit.setVisibility(8);
            }
            Triple<Integer, Integer, Integer> goalColors = ClubOngoingItemAdapterKt.getGoalColors(this.this$0.context, item.getScoreItem(), Integer.valueOf(item.getChallengeType()));
            int iIntValue = goalColors.component1().intValue();
            int iIntValue2 = goalColors.component2().intValue();
            int scoreItem = item.getScoreItem();
            if (scoreItem == ChallengeScoreItemSettings.TOTAL_CALORIES.getId()) {
                this.binding.imgArea2Icon.setImageResource(R.drawable.ic_stats_calories_orange66);
            } else if (scoreItem == ChallengeScoreItemSettings.TOTAL_DISTANCE.getId()) {
                this.binding.imgArea2Icon.setImageResource(R.drawable.ic_stats_distance_green66);
            } else if (scoreItem == ChallengeScoreItemSettings.TOTAL_TIME.getId()) {
                this.binding.imgArea2Icon.setImageResource(R.drawable.ic_stats_timer_fill_purple66);
            } else if (scoreItem == ChallengeScoreItemSettings.SESSION.getId()) {
                this.binding.imgArea2Icon.setImageResource(R.drawable.ic_calendar_log_red66);
            }
            vGoalProgress.setBackgroundColor(iIntValue);
            vGoalProgressWrap.setBackgroundColor(iIntValue2);
            this.binding.tvGoalUnit.setTextColor(iIntValue);
            this.binding.tvGoalLine.setTextColor(iIntValue);
            this.binding.tvGoalNowVal.setTextColor(iIntValue);
            this.binding.tvGoalVal.setTextColor(iIntValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showGoalArea$lambda$9(FrameLayout goalProgressWrap, ChallengeItemSimpleDataWithMemberData item, View goalProgress) {
            Intrinsics.checkNotNullParameter(goalProgressWrap, "$goalProgressWrap");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(goalProgress, "$goalProgress");
            int width = (int) ((goalProgressWrap.getWidth() * item.getProgress()) / 100.0f);
            ViewGroup.LayoutParams layoutParams = goalProgress.getLayoutParams();
            layoutParams.width = width;
            goalProgress.setLayoutParams(layoutParams);
        }

        private final void hideGoalArea() {
            this.binding.llGoalAreaWrap.setVisibility(8);
        }

        private final void showRankArea(ChallengeItemSimpleDataWithMemberData item) {
            Double currentScore;
            Double currentScore2;
            this.binding.llRankAreaWrap.setVisibility(0);
            List<ChallengeMemberData> rankingList = ClubOngoingItemAdapterKt.getRankingList(item.getMemberList(), Global.getLoginAccountNo());
            this.binding.imgRank1Wrap.setVisibility(8);
            this.binding.imgRank2Wrap.setVisibility(8);
            this.binding.imgRank3Wrap.setVisibility(8);
            ChallengeMemberData challengeMemberData = (ChallengeMemberData) CollectionsKt.firstOrNull((List) rankingList);
            double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
            double dDoubleValue2 = (challengeMemberData == null || (currentScore2 = challengeMemberData.getCurrentScore()) == null) ? 0.0d : currentScore2.doubleValue();
            ChallengeMemberData challengeMemberData2 = (ChallengeMemberData) CollectionsKt.lastOrNull((List) rankingList);
            if (challengeMemberData2 != null && (currentScore = challengeMemberData2.getCurrentScore()) != null) {
                dDoubleValue = currentScore.doubleValue();
            }
            double d = dDoubleValue;
            int i = 0;
            for (Object obj : rankingList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ChallengeMemberData challengeMemberData3 = (ChallengeMemberData) obj;
                if (i == 0) {
                    this.binding.imgRank1Wrap.setVisibility(0);
                    bindRankingItem(challengeMemberData3, 1, dDoubleValue2, d, item.getScoreItem(), item.getChallengeType());
                } else if (i == 1) {
                    this.binding.imgRank2Wrap.setVisibility(0);
                    bindRankingItem(challengeMemberData3, 2, dDoubleValue2, d, item.getScoreItem(), item.getChallengeType());
                } else if (i == 2) {
                    this.binding.imgRank3Wrap.setVisibility(0);
                    bindRankingItem(challengeMemberData3, 3, dDoubleValue2, d, item.getScoreItem(), item.getChallengeType());
                }
                i = i2;
            }
        }

        private final void hideRankArea() {
            this.binding.llRankAreaWrap.setVisibility(8);
        }

        private final void bindRankingItem(ChallengeMemberData data, int position, double maxScore, double minScore, int scoreItem, int challengeType) {
            ImageView imageView;
            TextView textView;
            TextView textView2;
            TextView textView3;
            if (position == 1) {
                imageView = this.binding.imgRankAvatar1;
            } else if (position == 2) {
                imageView = this.binding.imgRankAvatar2;
            } else if (position != 3) {
                return;
            } else {
                imageView = this.binding.imgRankAvatar3;
            }
            ImageView imageView2 = imageView;
            Intrinsics.checkNotNull(imageView2);
            if (position == 1) {
                textView = this.binding.tvRankVal1;
            } else if (position == 2) {
                textView = this.binding.tvRankVal2;
            } else if (position != 3) {
                return;
            } else {
                textView = this.binding.tvRankVal3;
            }
            TextView textView4 = textView;
            Intrinsics.checkNotNull(textView4);
            if (position == 1) {
                textView2 = this.binding.tvScore1;
            } else if (position == 2) {
                textView2 = this.binding.tvScore2;
            } else if (position != 3) {
                return;
            } else {
                textView2 = this.binding.tvScore3;
            }
            TextView textView5 = textView2;
            Intrinsics.checkNotNull(textView5);
            if (position == 1) {
                textView3 = this.binding.tvScoreUnit1;
            } else if (position == 2) {
                textView3 = this.binding.tvScoreUnit2;
            } else if (position != 3) {
                return;
            } else {
                textView3 = this.binding.tvScoreUnit3;
            }
            TextView textView6 = textView3;
            Intrinsics.checkNotNull(textView6);
            Glide.with(this.this$0.context).load(data.getUserSimpleInfo().getPhotoUrl()).placeholder(R.drawable.video_classes).error(R.drawable.video_classes).into(imageView2);
            Double currentScore = data.getCurrentScore();
            double dDoubleValue = currentScore != null ? currentScore.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
            textView4.setText("#" + data.getRank());
            textView5.setText(ClubOngoingItemAdapterKt.getCurrentScoreVal$default(Double.valueOf(dDoubleValue), scoreItem, Integer.valueOf(challengeType), false, false, false, 56, null));
            textView6.setText(ClubListItemAdapterKt.getUnitText$default(this.this$0.context, scoreItem, Global.INSTANCE.getUnitType(), scoreItem > 1, Integer.valueOf(challengeType), false, false, 96, null));
            Triple<Integer, Integer, Integer> goalColors = ClubOngoingItemAdapterKt.getGoalColors(this.this$0.context, scoreItem, Integer.valueOf(challengeType));
            int iIntValue = goalColors.component1().intValue();
            goalColors.component2().intValue();
            int iIntValue2 = goalColors.component3().intValue();
            textView5.setTextColor(iIntValue2);
            textView6.setTextColor(iIntValue2);
            textView4.setTextColor(ContextCompat.getColor(this.this$0.context, R.color.colorLabel_label4));
            if (Intrinsics.areEqual(data.getGlobalUserUuid(), Global.getLoginAccountNo())) {
                textView5.setTextColor(iIntValue);
                textView6.setTextColor(iIntValue);
                textView4.setTextColor(ContextCompat.getColor(this.this$0.context, R.color.colorLabel_label1));
            }
            if (ClubScoreboardItemAdapterKt.isNoScoreData(challengeType, data.getRank(), data.getCurrentScore())) {
                Glide.with(this.this$0.context).clear(imageView2);
                imageView2.setImageDrawable(null);
                imageView2.setBackgroundColor(ContextCompat.getColor(this.this$0.context, R.color.gray_d9d9d9));
                textView4.setText("#--");
                textView5.setText("--");
            }
            this.binding.LLProgress1.requestLayout();
            this.binding.LLProgress2.requestLayout();
            this.binding.LLProgress3.requestLayout();
        }

        private final void bindRankingProgressItem(ChallengeMemberData data, int position, double maxScore, double minScore, int scoreItem, int challengeType) {
            CardView cardView;
            FrameLayout frameLayout;
            View view;
            int i;
            if (position == 1) {
                cardView = this.binding.cardProgress1;
            } else if (position == 2) {
                cardView = this.binding.cardProgress2;
            } else if (position != 3) {
                return;
            } else {
                cardView = this.binding.cardProgress3;
            }
            Intrinsics.checkNotNull(cardView);
            if (position == 1) {
                frameLayout = this.binding.vRankProgress1Wrap;
            } else if (position == 2) {
                frameLayout = this.binding.vRankProgress2Wrap;
            } else if (position != 3) {
                return;
            } else {
                frameLayout = this.binding.vRankProgress3Wrap;
            }
            Intrinsics.checkNotNull(frameLayout);
            if (position == 1) {
                view = this.binding.vRankProgress1;
            } else if (position == 2) {
                view = this.binding.vRankProgress2;
            } else if (position != 3) {
                return;
            } else {
                view = this.binding.vRankProgress3;
            }
            Intrinsics.checkNotNull(view);
            int width = cardView.getWidth();
            Double currentScore = data.getCurrentScore();
            double dDoubleValue = currentScore != null ? currentScore.doubleValue() : 0.0d;
            if (dDoubleValue == AudioStats.AUDIO_AMPLITUDE_NONE) {
                i = 0;
            } else if (maxScore == minScore) {
                i = width;
            } else {
                i = (int) ((maxScore < minScore ? maxScore / dDoubleValue : dDoubleValue / maxScore) * width);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = Math.max(0, Math.min(i, width));
            }
            view.requestLayout();
            Triple<Integer, Integer, Integer> goalColors = ClubOngoingItemAdapterKt.getGoalColors(this.this$0.context, scoreItem, Integer.valueOf(challengeType));
            int iIntValue = goalColors.component1().intValue();
            int iIntValue2 = goalColors.component2().intValue();
            view.setBackgroundColor(goalColors.component3().intValue());
            frameLayout.setBackgroundColor(iIntValue2);
            if (Intrinsics.areEqual(data.getGlobalUserUuid(), Global.getLoginAccountNo())) {
                view.setBackgroundColor(iIntValue);
                frameLayout.setBackgroundColor(iIntValue2);
            }
            if (data.getRank() == null || ((int) dDoubleValue) == 0) {
                view.setBackgroundColor(ContextCompat.getColor(this.this$0.context, R.color.gray_d9d9d9));
                frameLayout.setBackgroundColor(ContextCompat.getColor(this.this$0.context, R.color.gray_d9d9d9));
            }
        }
    }
}
