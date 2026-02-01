package com.soletreadmills.sole_v2.ui.club;

import androidx.lifecycle.ViewModel;
import com.soletreadmills.sole_v2._data.club.ChallengeFormData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemFullData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleDataWithMemberData;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberData;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberWorkoutData;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import timber.log.Timber;

/* compiled from: ClubViewModel.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u00106\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u00109\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\n0\u0007J\u0014\u0010:\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010;\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010<\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010=\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010>\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010?\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0006\u0010@\u001a\u000207J\u0006\u0010A\u001a\u000207J\u0006\u0010B\u001a\u000207J\u0006\u0010C\u001a\u000207J\u0006\u0010D\u001a\u000207J\u0006\u0010E\u001a\u000207J\u0006\u0010F\u001a\u000207J\u0006\u0010G\u001a\u000207J\u0006\u0010H\u001a\u000207J\u000e\u0010I\u001a\u0002072\u0006\u0010J\u001a\u00020\u0013J\u0014\u0010K\u001a\u0002072\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007J\u000e\u0010L\u001a\u0002072\u0006\u0010J\u001a\u00020\u000fJ\u000e\u0010M\u001a\u0002072\u0006\u0010N\u001a\u00020\u0011J\u001a\u0010O\u001a\u0002072\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050QJ\u0014\u0010R\u001a\u0002072\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010T\u001a\u0002072\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\n0\u0007J\u0014\u0010U\u001a\u0002072\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010V\u001a\u0002072\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010W\u001a\u0002072\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010X\u001a\u0002072\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010Y\u001a\u0002072\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010Z\u001a\u0002072\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00048F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00048F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00048F¢\u0006\u0006\u001a\u0004\b!\u0010\u001bR\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00048F¢\u0006\u0006\u001a\u0004\b#\u0010\u001bR\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00048F¢\u0006\u0006\u001a\u0004\b%\u0010\u001bR\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110'8F¢\u0006\u0006\u001a\u0004\b+\u0010)R\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130'8F¢\u0006\u0006\u001a\u0004\b-\u0010)R\u001f\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00070\u00048F¢\u0006\u0006\u001a\u0004\b/\u0010\u001bR\u001d\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00048F¢\u0006\u0006\u001a\u0004\b1\u0010\u001bR\u001d\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00048F¢\u0006\u0006\u001a\u0004\b3\u0010\u001bR\u001d\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00048F¢\u0006\u0006\u001a\u0004\b5\u0010\u001b¨\u0006["}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_editChallengeDataForm", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeFormData;", "_finishedChallengesList", "", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "_myOngoingChallengesList", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleDataWithMemberData;", "_ongoingChallengesList", "_rankingsChallengeList", "_searchChallengeList", "_selectedChallengeData", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemFullData;", "_selectedChallengeId", "", "_selectedChallengeMemberData", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "_selectedChallengeMemberWorkout", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberWorkoutData;", "_shareGoalsChallengeList", "_upcomingChallengesList", "_virtualRacesChallengeList", "editChallengeDataForm", "getEditChallengeDataForm", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "finishedList", "getFinishedList", "myOngoingList", "getMyOngoingList", "ongoingList", "getOngoingList", "rankingsList", "getRankingsList", "searchChallengeList", "getSearchChallengeList", "selectedChallengeData", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectedChallengeData", "()Lkotlinx/coroutines/flow/StateFlow;", "selectedChallengeId", "getSelectedChallengeId", "selectedChallengeMemberData", "getSelectedChallengeMemberData", "selectedChallengeMemberWorkout", "getSelectedChallengeMemberWorkout", "shareGoalsList", "getShareGoalsList", "upcomingList", "getUpcomingList", "virtualRacesList", "getVirtualRacesList", "addToFinishedChallengesList", "", "newDatas", "addToMyOngoingChallengesList", "addToOngoingChallengesList", "addToRankingsChallengesList", "addToSearchChallengesList", "addToShareGoalsChallengesList", "addToUpcomingChallengesList", "addToVirtualRacesChallengesList", "resetChallengeFormData", "resetFinishedChallengesList", "resetMyOngoingChallengesList", "resetOngoingChallengesList", "resetRankingsChallengesList", "resetSearchChallengesList", "resetShareGoalsChallengesList", "resetUpcomingChallengesList", "resetVirtualRacesChallengesList", "setChallengeMemberData", "data", "setChallengeMemberWorkout", "setSelectChallengeData", "setSelectChallengeId", "id", "updateChallengeFormData", "updateFunction", "Lkotlin/Function1;", "updateFinishedChallengesList", "datas", "updateMyOngoingChallengesList", "updateOngoingChallengesList", "updateRankingsChallengesList", "updateSearchChallengesList", "updateShareGoalsChallengesList", "updateUpcomingChallengesList", "updateVirtualRacesChallengesList", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _selectedChallengeId = StateFlowKt.MutableStateFlow(null);
    private final MutableStateFlow<ChallengeItemFullData> _selectedChallengeData = StateFlowKt.MutableStateFlow(null);
    private final MutableStateFlow<ChallengeMemberData> _selectedChallengeMemberData = StateFlowKt.MutableStateFlow(null);
    private final MutableStateFlow<List<ChallengeMemberWorkoutData>> _selectedChallengeMemberWorkout = StateFlowKt.MutableStateFlow(null);
    private final MutableStateFlow<List<ChallengeItemSimpleDataWithMemberData>> _myOngoingChallengesList = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private final MutableStateFlow<List<ChallengeItemSimpleData>> _ongoingChallengesList = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private final MutableStateFlow<List<ChallengeItemSimpleData>> _upcomingChallengesList = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private final MutableStateFlow<List<ChallengeItemSimpleData>> _finishedChallengesList = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private final MutableStateFlow<List<ChallengeItemSimpleData>> _virtualRacesChallengeList = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private final MutableStateFlow<List<ChallengeItemSimpleData>> _shareGoalsChallengeList = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private final MutableStateFlow<List<ChallengeItemSimpleData>> _rankingsChallengeList = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private final MutableStateFlow<List<ChallengeItemSimpleData>> _searchChallengeList = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private MutableStateFlow<ChallengeFormData> _editChallengeDataForm = StateFlowKt.MutableStateFlow(null);

    public final StateFlow<String> getSelectedChallengeId() {
        return this._selectedChallengeId;
    }

    public final void setSelectChallengeId(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        this._selectedChallengeId.setValue(id2);
    }

    public final StateFlow<ChallengeItemFullData> getSelectedChallengeData() {
        return this._selectedChallengeData;
    }

    public final void setSelectChallengeData(ChallengeItemFullData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this._selectedChallengeData.setValue(data);
    }

    public final StateFlow<ChallengeMemberData> getSelectedChallengeMemberData() {
        return this._selectedChallengeMemberData;
    }

    public final void setChallengeMemberData(ChallengeMemberData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this._selectedChallengeMemberData.setValue(data);
    }

    public final MutableStateFlow<List<ChallengeMemberWorkoutData>> getSelectedChallengeMemberWorkout() {
        return this._selectedChallengeMemberWorkout;
    }

    public final void setChallengeMemberWorkout(List<ChallengeMemberWorkoutData> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this._selectedChallengeMemberWorkout.setValue(data);
    }

    public final MutableStateFlow<List<ChallengeItemSimpleDataWithMemberData>> getMyOngoingList() {
        return this._myOngoingChallengesList;
    }

    public final void updateMyOngoingChallengesList(List<ChallengeItemSimpleDataWithMemberData> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        this._myOngoingChallengesList.setValue(datas);
    }

    public final void addToMyOngoingChallengesList(List<ChallengeItemSimpleDataWithMemberData> newDatas) {
        Intrinsics.checkNotNullParameter(newDatas, "newDatas");
        List<ChallengeItemSimpleDataWithMemberData> mutableList = CollectionsKt.toMutableList((Collection) this._myOngoingChallengesList.getValue());
        mutableList.addAll(newDatas);
        Timber.INSTANCE.d("addToMyOngoingChallengesList:" + mutableList.size(), new Object[0]);
        this._myOngoingChallengesList.setValue(mutableList);
    }

    public final void resetMyOngoingChallengesList() {
        this._myOngoingChallengesList.setValue(CollectionsKt.emptyList());
    }

    public final MutableStateFlow<List<ChallengeItemSimpleData>> getOngoingList() {
        return this._ongoingChallengesList;
    }

    public final void updateOngoingChallengesList(List<ChallengeItemSimpleData> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        this._ongoingChallengesList.setValue(datas);
    }

    public final void addToOngoingChallengesList(List<ChallengeItemSimpleData> newDatas) {
        Intrinsics.checkNotNullParameter(newDatas, "newDatas");
        List<ChallengeItemSimpleData> mutableList = CollectionsKt.toMutableList((Collection) this._ongoingChallengesList.getValue());
        mutableList.addAll(newDatas);
        Timber.INSTANCE.d("addToMyOngoingChallengesList:" + mutableList.size(), new Object[0]);
        this._ongoingChallengesList.setValue(mutableList);
    }

    public final void resetOngoingChallengesList() {
        this._ongoingChallengesList.setValue(CollectionsKt.emptyList());
    }

    public final MutableStateFlow<List<ChallengeItemSimpleData>> getUpcomingList() {
        return this._upcomingChallengesList;
    }

    public final void updateUpcomingChallengesList(List<ChallengeItemSimpleData> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        this._upcomingChallengesList.setValue(datas);
    }

    public final void addToUpcomingChallengesList(List<ChallengeItemSimpleData> newDatas) {
        Intrinsics.checkNotNullParameter(newDatas, "newDatas");
        List<ChallengeItemSimpleData> mutableList = CollectionsKt.toMutableList((Collection) this._upcomingChallengesList.getValue());
        mutableList.addAll(newDatas);
        Timber.INSTANCE.d("addToUpcomingChallengesList:" + mutableList.size(), new Object[0]);
        this._upcomingChallengesList.setValue(mutableList);
    }

    public final void resetUpcomingChallengesList() {
        this._upcomingChallengesList.setValue(CollectionsKt.emptyList());
    }

    public final MutableStateFlow<List<ChallengeItemSimpleData>> getFinishedList() {
        return this._finishedChallengesList;
    }

    public final void updateFinishedChallengesList(List<ChallengeItemSimpleData> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        this._finishedChallengesList.setValue(datas);
    }

    public final void addToFinishedChallengesList(List<ChallengeItemSimpleData> newDatas) {
        Intrinsics.checkNotNullParameter(newDatas, "newDatas");
        List<ChallengeItemSimpleData> mutableList = CollectionsKt.toMutableList((Collection) this._finishedChallengesList.getValue());
        mutableList.addAll(newDatas);
        Timber.INSTANCE.d("addToFinishedChallengesList:" + mutableList.size(), new Object[0]);
        this._finishedChallengesList.setValue(mutableList);
    }

    public final void resetFinishedChallengesList() {
        this._finishedChallengesList.setValue(CollectionsKt.emptyList());
    }

    public final MutableStateFlow<List<ChallengeItemSimpleData>> getVirtualRacesList() {
        return this._virtualRacesChallengeList;
    }

    public final void updateVirtualRacesChallengesList(List<ChallengeItemSimpleData> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        this._virtualRacesChallengeList.setValue(datas);
    }

    public final void addToVirtualRacesChallengesList(List<ChallengeItemSimpleData> newDatas) {
        Intrinsics.checkNotNullParameter(newDatas, "newDatas");
        List<ChallengeItemSimpleData> mutableList = CollectionsKt.toMutableList((Collection) this._virtualRacesChallengeList.getValue());
        mutableList.addAll(newDatas);
        Timber.INSTANCE.d("addToVirtualRacesChallengesList:" + mutableList.size(), new Object[0]);
        this._virtualRacesChallengeList.setValue(mutableList);
    }

    public final void resetVirtualRacesChallengesList() {
        this._virtualRacesChallengeList.setValue(CollectionsKt.emptyList());
    }

    public final MutableStateFlow<List<ChallengeItemSimpleData>> getShareGoalsList() {
        return this._shareGoalsChallengeList;
    }

    public final void updateShareGoalsChallengesList(List<ChallengeItemSimpleData> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        this._shareGoalsChallengeList.setValue(datas);
    }

    public final void addToShareGoalsChallengesList(List<ChallengeItemSimpleData> newDatas) {
        Intrinsics.checkNotNullParameter(newDatas, "newDatas");
        List<ChallengeItemSimpleData> mutableList = CollectionsKt.toMutableList((Collection) this._shareGoalsChallengeList.getValue());
        mutableList.addAll(newDatas);
        Timber.INSTANCE.d("addToShareGoalsChallengesList:" + mutableList.size(), new Object[0]);
        this._shareGoalsChallengeList.setValue(mutableList);
    }

    public final void resetShareGoalsChallengesList() {
        this._shareGoalsChallengeList.setValue(CollectionsKt.emptyList());
    }

    public final MutableStateFlow<List<ChallengeItemSimpleData>> getRankingsList() {
        return this._rankingsChallengeList;
    }

    public final void updateRankingsChallengesList(List<ChallengeItemSimpleData> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        this._rankingsChallengeList.setValue(datas);
    }

    public final void addToRankingsChallengesList(List<ChallengeItemSimpleData> newDatas) {
        Intrinsics.checkNotNullParameter(newDatas, "newDatas");
        List<ChallengeItemSimpleData> mutableList = CollectionsKt.toMutableList((Collection) this._rankingsChallengeList.getValue());
        mutableList.addAll(newDatas);
        Timber.INSTANCE.d("addToRankingshCallengesList:" + mutableList.size(), new Object[0]);
        this._rankingsChallengeList.setValue(mutableList);
    }

    public final void resetRankingsChallengesList() {
        this._rankingsChallengeList.setValue(CollectionsKt.emptyList());
    }

    public final MutableStateFlow<List<ChallengeItemSimpleData>> getSearchChallengeList() {
        return this._searchChallengeList;
    }

    public final void updateSearchChallengesList(List<ChallengeItemSimpleData> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        Timber.INSTANCE.d("updateSearchChallengesList:" + datas.size(), new Object[0]);
        this._searchChallengeList.setValue(datas);
    }

    public final void addToSearchChallengesList(List<ChallengeItemSimpleData> newDatas) {
        Intrinsics.checkNotNullParameter(newDatas, "newDatas");
        List<ChallengeItemSimpleData> mutableList = CollectionsKt.toMutableList((Collection) this._searchChallengeList.getValue());
        mutableList.addAll(newDatas);
        Timber.INSTANCE.d("addToSearchChallengesList:" + mutableList.size(), new Object[0]);
        this._searchChallengeList.setValue(mutableList);
    }

    public final void resetSearchChallengesList() {
        this._searchChallengeList.setValue(CollectionsKt.emptyList());
    }

    public final MutableStateFlow<ChallengeFormData> getEditChallengeDataForm() {
        return this._editChallengeDataForm;
    }

    public final void updateChallengeFormData(Function1<? super ChallengeFormData, ChallengeFormData> updateFunction) {
        Intrinsics.checkNotNullParameter(updateFunction, "updateFunction");
        ChallengeFormData value = this._editChallengeDataForm.getValue();
        if (value == null) {
            value = new ChallengeFormData(null, 0, null, null, 0, 0, null, null, null, null, null, null, 4095, null);
        }
        this._editChallengeDataForm.setValue(updateFunction.invoke(value));
    }

    public final void resetChallengeFormData() {
        this._editChallengeDataForm.setValue(null);
    }
}
