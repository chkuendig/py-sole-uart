package com.soletreadmills.sole_v2.ui.displayMode;

import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2._data.club.DisplaySelectStatsData;
import com.soletreadmills.sole_v2._type.DisplayStatsType;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.ui._base.BaseViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: DisplayModeViewModel.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000fJ\u0016\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000fJ\u0018\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u0007J\u0006\u0010+\u001a\u00020!J\u000e\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u000fJ\u0006\u0010.\u001a\u00020!J\u0006\u0010/\u001a\u00020!J\u0016\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\u0005J\u000e\u00103\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u0017J\u000e\u00106\u001a\u00020!2\u0006\u0010-\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00067"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeViewModel;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseViewModel;", "()V", "_ftmsData", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "_isRunning", "", "_selectedList", "", "Lcom/soletreadmills/sole_v2/_data/club/DisplaySelectStatsData;", "_statsList", "currentMachineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "defaultSelectedOrder", "Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "ftmsData", "Lkotlinx/coroutines/flow/StateFlow;", "getFtmsData", "()Lkotlinx/coroutines/flow/StateFlow;", "isRunning", "lastFtmsData", "nowSelectPos", "", "getNowSelectPos", "()I", "setNowSelectPos", "(I)V", "selectedList", "getSelectedList", "statsList", "getStatsList", "clearAllStat", "", "convertUnit", "", "value", "statsType", "formatValue", "", "loadStatsForMachine", "type", "forceReload", "refreshSelectedList", "replaceSelectedItem", "newType", "resetFtmsData", "resetToDefault", "setFtmsData", "machineType", "data", "setRunning", "updateSelection", "position", "updateSelectionWithNewType", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayModeViewModel extends BaseViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<FtmsBaseData> _ftmsData;
    private final MutableStateFlow<Boolean> _isRunning;
    private final MutableStateFlow<List<DisplaySelectStatsData>> _selectedList;
    private final MutableStateFlow<List<DisplaySelectStatsData>> _statsList;
    private BleFtmsMachineType currentMachineType;
    private List<? extends DisplayStatsType> defaultSelectedOrder;
    private final StateFlow<FtmsBaseData> ftmsData;
    private final StateFlow<Boolean> isRunning;
    private FtmsBaseData lastFtmsData;
    private int nowSelectPos;
    private final StateFlow<List<DisplaySelectStatsData>> selectedList;
    private final StateFlow<List<DisplaySelectStatsData>> statsList;

    /* compiled from: DisplayModeViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
            int[] iArr2 = new int[DisplayStatsType.values().length];
            try {
                iArr2[DisplayStatsType.SPEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DisplayStatsType.DISTANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[DisplayStatsType.INCLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[DisplayStatsType.RESISTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[DisplayStatsType.OUTPUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[DisplayStatsType.CADENCE.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[DisplayStatsType.HEART_RATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final void setRunning(boolean isRunning) {
    }

    public DisplayModeViewModel() {
        MutableStateFlow<FtmsBaseData> MutableStateFlow = StateFlowKt.MutableStateFlow(new FtmsBaseData());
        this._ftmsData = MutableStateFlow;
        this.ftmsData = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(true);
        this._isRunning = MutableStateFlow2;
        this.isRunning = FlowKt.asStateFlow(MutableStateFlow2);
        this.defaultSelectedOrder = CollectionsKt.emptyList();
        MutableStateFlow<List<DisplaySelectStatsData>> MutableStateFlow3 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._statsList = MutableStateFlow3;
        this.statsList = MutableStateFlow3;
        MutableStateFlow<List<DisplaySelectStatsData>> MutableStateFlow4 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._selectedList = MutableStateFlow4;
        this.selectedList = MutableStateFlow4;
    }

    public final StateFlow<FtmsBaseData> getFtmsData() {
        return this.ftmsData;
    }

    public final StateFlow<Boolean> isRunning() {
        return this.isRunning;
    }

    public final void setFtmsData(BleFtmsMachineType machineType, FtmsBaseData data) {
        Intrinsics.checkNotNullParameter(machineType, "machineType");
        Intrinsics.checkNotNullParameter(data, "data");
        this._ftmsData.setValue(data);
    }

    public final void resetFtmsData() {
        this._ftmsData.setValue(new FtmsBaseData());
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

    public static /* synthetic */ void loadStatsForMachine$default(DisplayModeViewModel displayModeViewModel, BleFtmsMachineType bleFtmsMachineType, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        displayModeViewModel.loadStatsForMachine(bleFtmsMachineType, z);
    }

    public final void loadStatsForMachine(BleFtmsMachineType type, boolean forceReload) {
        List listListOf;
        List<? extends DisplayStatsType> listListOf2;
        Intrinsics.checkNotNullParameter(type, "type");
        boolean z = this.currentMachineType != type || forceReload;
        if (this._statsList.getValue().isEmpty() || z) {
            this.currentMachineType = type;
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.DISTANCE, DisplayStatsType.SPEED, DisplayStatsType.PACE, DisplayStatsType.AVG_PACE, DisplayStatsType.HEART_RATE, DisplayStatsType.INCLINE, DisplayStatsType.CALORIES, DisplayStatsType.METS, DisplayStatsType.ASCENT, DisplayStatsType.OUTPUT});
                listListOf2 = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.DISTANCE, DisplayStatsType.CALORIES, DisplayStatsType.PACE});
            } else if (i == 2) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.DISTANCE, DisplayStatsType.RESISTANCE, DisplayStatsType.CADENCE, DisplayStatsType.AVG_CADENCE, DisplayStatsType.HEART_RATE, DisplayStatsType.INCLINE, DisplayStatsType.STRIDES, DisplayStatsType.CALORIES, DisplayStatsType.METS, DisplayStatsType.OUTPUT});
                listListOf2 = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.DISTANCE, DisplayStatsType.CADENCE, DisplayStatsType.CALORIES});
            } else if (i == 3) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.DISTANCE, DisplayStatsType.RESISTANCE, DisplayStatsType.SPEED, DisplayStatsType.AVG_SPEED, DisplayStatsType.HEART_RATE, DisplayStatsType.CADENCE, DisplayStatsType.AVG_CADENCE, DisplayStatsType.CALORIES, DisplayStatsType.METS, DisplayStatsType.OUTPUT});
                listListOf2 = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.DISTANCE, DisplayStatsType.CADENCE, DisplayStatsType.CALORIES});
            } else if (i == 4) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.DISTANCE, DisplayStatsType.RESISTANCE, DisplayStatsType.PACE, DisplayStatsType.AVG_PACE, DisplayStatsType.HEART_RATE, DisplayStatsType.CADENCE, DisplayStatsType.STROKES, DisplayStatsType.CALORIES, DisplayStatsType.METS, DisplayStatsType.OUTPUT});
                listListOf2 = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.DISTANCE, DisplayStatsType.CALORIES, DisplayStatsType.PACE});
            } else if (i == 5) {
                listListOf = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.REMAINING_TIME, DisplayStatsType.ASCENT, DisplayStatsType.RESISTANCE, DisplayStatsType.CADENCE, DisplayStatsType.AVG_CADENCE, DisplayStatsType.HEART_RATE, DisplayStatsType.FLOORS, DisplayStatsType.STEPS, DisplayStatsType.CALORIES, DisplayStatsType.CALORIES_PER_MIN, DisplayStatsType.METS});
                listListOf2 = CollectionsKt.listOf((Object[]) new DisplayStatsType[]{DisplayStatsType.TIME, DisplayStatsType.ASCENT, DisplayStatsType.CALORIES, DisplayStatsType.STEPS});
            } else {
                listListOf = CollectionsKt.emptyList();
                listListOf2 = CollectionsKt.emptyList();
            }
            this.defaultSelectedOrder = listListOf2;
            MutableStateFlow<List<DisplaySelectStatsData>> mutableStateFlow = this._statsList;
            List<DisplayStatsType> list = listListOf;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (DisplayStatsType displayStatsType : list) {
                arrayList.add(new DisplaySelectStatsData(displayStatsType, listListOf2.contains(displayStatsType), false, 4, null));
            }
            mutableStateFlow.setValue(arrayList);
            this.nowSelectPos = 0;
            refreshSelectedList();
        }
    }

    public final void resetToDefault() {
        BleFtmsMachineType bleFtmsMachineType = this.currentMachineType;
        if (bleFtmsMachineType != null) {
            loadStatsForMachine(bleFtmsMachineType, true);
        }
    }

    public final void clearAllStat() {
        this.defaultSelectedOrder = CollectionsKt.emptyList();
        this.currentMachineType = null;
        this._statsList.setValue(CollectionsKt.emptyList());
        this._selectedList.setValue(CollectionsKt.emptyList());
        this.nowSelectPos = 0;
        this._ftmsData.setValue(new FtmsBaseData());
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
        Object next;
        List<DisplaySelectStatsData> value = this._statsList.getValue();
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (((DisplaySelectStatsData) obj).isSelect()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        List<? extends DisplayStatsType> list = this.defaultSelectedOrder;
        ArrayList arrayList3 = new ArrayList();
        for (DisplayStatsType displayStatsType : list) {
            Iterator it = arrayList2.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (((DisplaySelectStatsData) next).getType() == displayStatsType) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            DisplaySelectStatsData displaySelectStatsData = (DisplaySelectStatsData) next;
            if (displaySelectStatsData != null) {
                arrayList3.add(displaySelectStatsData);
            }
        }
        List<DisplaySelectStatsData> mutableList = CollectionsKt.toMutableList((Collection) arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (!this.defaultSelectedOrder.contains(((DisplaySelectStatsData) obj2).getType())) {
                arrayList4.add(obj2);
            }
        }
        mutableList.addAll(arrayList4);
        this._selectedList.setValue(mutableList);
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

    public final float convertUnit(float value, DisplayStatsType statsType) {
        Intrinsics.checkNotNullParameter(statsType, "statsType");
        if (!Global.INSTANCE.getUnitType()) {
            return value;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[statsType.ordinal()];
        return (i == 1 || i == 2) ? value * 0.621371f : value;
    }

    public final String formatValue(float value, DisplayStatsType statsType) {
        Intrinsics.checkNotNullParameter(statsType, "statsType");
        int i = WhenMappings.$EnumSwitchMapping$1[statsType.ordinal()];
        if (i == 1) {
            String str = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(value)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        if (i == 3) {
            String str2 = String.format(Locale.US, "%.0f", Arrays.copyOf(new Object[]{Float.valueOf(value)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            return str2;
        }
        if (i == 4) {
            String str3 = String.format(Locale.US, "%.0f", Arrays.copyOf(new Object[]{Float.valueOf(value)}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            return str3;
        }
        if (i == 5) {
            String str4 = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(value)}, 1));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            return str4;
        }
        if (i == 6) {
            String str5 = String.format(Locale.US, "%.0f", Arrays.copyOf(new Object[]{Float.valueOf(value)}, 1));
            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
            return str5;
        }
        if (i == 7) {
            String str6 = String.format(Locale.US, "%.0f", Arrays.copyOf(new Object[]{Float.valueOf(value)}, 1));
            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
            return str6;
        }
        return String.valueOf(value);
    }
}
