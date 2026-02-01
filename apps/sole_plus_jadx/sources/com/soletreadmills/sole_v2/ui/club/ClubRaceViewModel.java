package com.soletreadmills.sole_v2.ui.club;

import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleDataWithMemberData;
import com.soletreadmills.sole_v2._data.club.DisplaySelectStatsData;
import com.soletreadmills.sole_v2._type.DisplayStatsType;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.ui._base.BaseViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: ClubRaceViewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u000fJ\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u0006%"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubRaceViewModel;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseViewModel;", "()V", "_selectedList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/soletreadmills/sole_v2/_data/club/DisplaySelectStatsData;", "_statsList", "challengeItemSimpleDataWithMemberData", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleDataWithMemberData;", "getChallengeItemSimpleDataWithMemberData", "()Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleDataWithMemberData;", "setChallengeItemSimpleDataWithMemberData", "(Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleDataWithMemberData;)V", "nowSelectPos", "", "getNowSelectPos", "()I", "setNowSelectPos", "(I)V", "selectedList", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectedList", "()Lkotlinx/coroutines/flow/StateFlow;", "statsList", "getStatsList", "loadStatsForMachine", "", "type", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "refreshSelectedList", "replaceSelectedItem", "newType", "Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "updateSelection", "position", "updateSelectionWithNewType", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubRaceViewModel extends BaseViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<List<DisplaySelectStatsData>> _selectedList;
    private final MutableStateFlow<List<DisplaySelectStatsData>> _statsList;
    private ChallengeItemSimpleDataWithMemberData challengeItemSimpleDataWithMemberData;
    private int nowSelectPos;
    private final StateFlow<List<DisplaySelectStatsData>> selectedList;
    private final StateFlow<List<DisplaySelectStatsData>> statsList;

    /* compiled from: ClubRaceViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BleFtmsMachineType.values().length];
            try {
                iArr[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BleFtmsMachineType.BIKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BleFtmsMachineType.ROWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BleFtmsMachineType.STEPPER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ClubRaceViewModel() {
        MutableStateFlow<List<DisplaySelectStatsData>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._statsList = MutableStateFlow;
        this.statsList = MutableStateFlow;
        MutableStateFlow<List<DisplaySelectStatsData>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._selectedList = MutableStateFlow2;
        this.selectedList = MutableStateFlow2;
    }

    public final StateFlow<List<DisplaySelectStatsData>> getStatsList() {
        return this.statsList;
    }

    public final StateFlow<List<DisplaySelectStatsData>> getSelectedList() {
        return this.selectedList;
    }

    public final int getNowSelectPos() {
        return this.nowSelectPos;
    }

    public final void setNowSelectPos(int i) {
        this.nowSelectPos = i;
    }

    public final ChallengeItemSimpleDataWithMemberData getChallengeItemSimpleDataWithMemberData() {
        return this.challengeItemSimpleDataWithMemberData;
    }

    public final void setChallengeItemSimpleDataWithMemberData(ChallengeItemSimpleDataWithMemberData challengeItemSimpleDataWithMemberData) {
        this.challengeItemSimpleDataWithMemberData = challengeItemSimpleDataWithMemberData;
    }

    public final void loadStatsForMachine(BleFtmsMachineType type) {
        List listListOf;
        Set of;
        Intrinsics.checkNotNullParameter(type, "type");
        if (this._statsList.getValue().isEmpty()) {
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.DISTANCE, DisplayStatsType.SPEED, DisplayStatsType.PACE, DisplayStatsType.AVG_PACE, DisplayStatsType.HEART_RATE, DisplayStatsType.INCLINE, DisplayStatsType.CALORIES, DisplayStatsType.METS, DisplayStatsType.ASCENT, DisplayStatsType.OUTPUT});
                of = SetsKt.setOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.DISTANCE, DisplayStatsType.CALORIES, DisplayStatsType.PACE});
            } else if (i == 2) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.DISTANCE, DisplayStatsType.RESISTANCE, DisplayStatsType.CADENCE, DisplayStatsType.AVG_CADENCE, DisplayStatsType.HEART_RATE, DisplayStatsType.INCLINE, DisplayStatsType.STRIDES, DisplayStatsType.CALORIES, DisplayStatsType.METS, DisplayStatsType.OUTPUT});
                of = SetsKt.setOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.DISTANCE, DisplayStatsType.CADENCE, DisplayStatsType.CALORIES});
            } else if (i == 3) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.DISTANCE, DisplayStatsType.RESISTANCE, DisplayStatsType.SPEED, DisplayStatsType.AVG_SPEED, DisplayStatsType.HEART_RATE, DisplayStatsType.CADENCE, DisplayStatsType.AVG_CADENCE, DisplayStatsType.CALORIES, DisplayStatsType.METS, DisplayStatsType.OUTPUT});
                of = SetsKt.setOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.DISTANCE, DisplayStatsType.CADENCE, DisplayStatsType.CALORIES});
            } else if (i == 4) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.DISTANCE, DisplayStatsType.RESISTANCE, DisplayStatsType.PACE, DisplayStatsType.AVG_PACE, DisplayStatsType.HEART_RATE, DisplayStatsType.CADENCE, DisplayStatsType.STROKES, DisplayStatsType.CALORIES, DisplayStatsType.METS, DisplayStatsType.OUTPUT});
                of = SetsKt.setOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.DISTANCE, DisplayStatsType.CALORIES, DisplayStatsType.PACE});
            } else if (i == 5) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.ASCENT, DisplayStatsType.RESISTANCE, DisplayStatsType.CADENCE, DisplayStatsType.AVG_CADENCE, DisplayStatsType.HEART_RATE, DisplayStatsType.FLOORS, DisplayStatsType.STEPS, DisplayStatsType.CALORIES, DisplayStatsType.CALORIES_PER_MIN, DisplayStatsType.METS});
                of = SetsKt.setOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.ASCENT, DisplayStatsType.CALORIES, DisplayStatsType.STEPS});
            } else {
                listListOf = CollectionsKt.emptyList();
                of = SetsKt.emptySet();
            }
            MutableStateFlow<List<DisplaySelectStatsData>> mutableStateFlow = this._statsList;
            List<DisplayStatsType> list = listListOf;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (DisplayStatsType displayStatsType : list) {
                arrayList.add(new DisplaySelectStatsData(displayStatsType, of.contains(displayStatsType), false, 4, null));
            }
            mutableStateFlow.setValue(arrayList);
            refreshSelectedList();
        }
    }

    public final void updateSelection(int position) {
        List<DisplaySelectStatsData> value = this._selectedList.getValue();
        List<DisplaySelectStatsData> value2 = this._statsList.getValue();
        if (position < 0 || position >= value.size()) {
            return;
        }
        this.nowSelectPos = position;
        DisplayStatsType type = value.get(position).getType();
        MutableStateFlow<List<DisplaySelectStatsData>> mutableStateFlow = this._statsList;
        List<DisplaySelectStatsData> list = value2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DisplaySelectStatsData displaySelectStatsData : list) {
            arrayList.add(DisplaySelectStatsData.copy$default(displaySelectStatsData, null, false, displaySelectStatsData.getType() == type, 3, null));
        }
        mutableStateFlow.setValue(arrayList);
        MutableStateFlow<List<DisplaySelectStatsData>> mutableStateFlow2 = this._selectedList;
        List<DisplaySelectStatsData> list2 = value;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DisplaySelectStatsData displaySelectStatsData2 : list2) {
            arrayList2.add(DisplaySelectStatsData.copy$default(displaySelectStatsData2, null, false, displaySelectStatsData2.getType() == type, 3, null));
        }
        mutableStateFlow2.setValue(arrayList2);
    }

    public final void refreshSelectedList() {
        MutableStateFlow<List<DisplaySelectStatsData>> mutableStateFlow = this._selectedList;
        List<DisplaySelectStatsData> value = this._statsList.getValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (((DisplaySelectStatsData) obj).isSelect()) {
                arrayList.add(obj);
            }
        }
        mutableStateFlow.setValue(arrayList);
    }

    public final void updateSelectionWithNewType(DisplayStatsType newType) {
        Intrinsics.checkNotNullParameter(newType, "newType");
        MutableStateFlow<List<DisplaySelectStatsData>> mutableStateFlow = this._statsList;
        List<DisplaySelectStatsData> value = mutableStateFlow.getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
        for (DisplaySelectStatsData displaySelectStatsDataCopy$default : value) {
            if (displaySelectStatsDataCopy$default.getNowSelect()) {
                displaySelectStatsDataCopy$default = DisplaySelectStatsData.copy$default(displaySelectStatsDataCopy$default, null, false, false, 1, null);
            } else if (displaySelectStatsDataCopy$default.getType() == newType) {
                displaySelectStatsDataCopy$default = DisplaySelectStatsData.copy$default(displaySelectStatsDataCopy$default, null, true, true, 1, null);
            }
            arrayList.add(displaySelectStatsDataCopy$default);
        }
        mutableStateFlow.setValue(arrayList);
        replaceSelectedItem(newType);
    }

    public final void replaceSelectedItem(DisplayStatsType newType) {
        Object next;
        Intrinsics.checkNotNullParameter(newType, "newType");
        List<DisplaySelectStatsData> value = this._statsList.getValue();
        List<DisplaySelectStatsData> mutableList = CollectionsKt.toMutableList((Collection) this._selectedList.getValue());
        int size = mutableList.size();
        int i = this.nowSelectPos;
        if (i < 0 || i >= size) {
            return;
        }
        boolean nowSelect = mutableList.get(i).getNowSelect();
        Iterator<T> it = value.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((DisplaySelectStatsData) next).getType() == newType) {
                    break;
                }
            }
        }
        DisplaySelectStatsData displaySelectStatsData = (DisplaySelectStatsData) next;
        if (displaySelectStatsData == null) {
            return;
        }
        mutableList.set(this.nowSelectPos, DisplaySelectStatsData.copy$default(displaySelectStatsData, null, true, nowSelect, 1, null));
        this._selectedList.setValue(mutableList);
    }
}
