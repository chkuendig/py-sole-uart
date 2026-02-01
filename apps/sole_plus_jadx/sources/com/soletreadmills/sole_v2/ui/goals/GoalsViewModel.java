package com.soletreadmills.sole_v2.ui.goals;

import androidx.camera.video.AudioStats;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2._data.goal.GoalTimeFrame;
import com.soletreadmills.sole_v2._data.goal.GoalsMachineType;
import com.soletreadmills.sole_v2._data.goal.GoalsStatsType;
import com.soletreadmills.sole_v2._data.goal.UserGoalCreateForm;
import com.soletreadmills.sole_v2._data.goal.UserGoalData;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2._type.CategoryType;
import com.soletreadmills.sole_v2.ui._base.BaseViewModel;
import com.sun.jna.platform.win32.WinError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.objectweb.asm.Opcodes;
import timber.log.Timber;

/* compiled from: GoalsViewModel.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0005H\u0002J\u001e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\bJ\u001a\u0010#\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050%J\u0014\u0010&\u001a\u00020 2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0(R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006*"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/goals/GoalsViewModel;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseViewModel;", "()V", "_goalForm", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/soletreadmills/sole_v2/_data/goal/UserGoalCreateForm;", "_goalsList", "", "Lcom/soletreadmills/sole_v2/_data/goal/UserGoalData;", "_selectedGoal", "editGoalForm", "Lkotlinx/coroutines/flow/StateFlow;", "getEditGoalForm", "()Lkotlinx/coroutines/flow/StateFlow;", "goalsList", "getGoalsList", "selectedGoal", "getSelectedGoal", "deleteGoalFromGoalsList", "", "userGoalUuid", "", "getGoalValueMaxLimit", "", "goalTimeFrameType", "machineType", "statsType", "(ILjava/lang/Integer;I)I", "getInitGoalForm", "getTransTargetValue", "targetVal", "resetGoalForm", "", "setSelectedGoal", "data", "updateGoalForm", "updateFunction", "Lkotlin/Function1;", "updateGoalList", "datas", "", "GoalCalculator", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GoalsViewModel extends BaseViewModel {
    public static final int $stable = 8;
    private MutableStateFlow<UserGoalCreateForm> _goalForm;
    private final MutableStateFlow<List<UserGoalData>> _goalsList;
    private final MutableStateFlow<UserGoalData> _selectedGoal;
    private final StateFlow<UserGoalCreateForm> editGoalForm;
    private final StateFlow<List<UserGoalData>> goalsList;
    private final StateFlow<UserGoalData> selectedGoal;

    public GoalsViewModel() {
        MutableStateFlow<List<UserGoalData>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._goalsList = MutableStateFlow;
        this.goalsList = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<UserGoalData> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new UserGoalData(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null));
        this._selectedGoal = MutableStateFlow2;
        this.selectedGoal = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<UserGoalCreateForm> MutableStateFlow3 = StateFlowKt.MutableStateFlow(getInitGoalForm());
        this._goalForm = MutableStateFlow3;
        this.editGoalForm = FlowKt.asStateFlow(MutableStateFlow3);
    }

    public final StateFlow<List<UserGoalData>> getGoalsList() {
        return this.goalsList;
    }

    public final void updateGoalList(List<UserGoalData> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        this._goalsList.setValue(datas);
    }

    public final boolean deleteGoalFromGoalsList(String userGoalUuid) {
        Intrinsics.checkNotNullParameter(userGoalUuid, "userGoalUuid");
        List mutableList = CollectionsKt.toMutableList((Collection) this._goalsList.getValue());
        int size = mutableList.size();
        ArrayList arrayList = new ArrayList();
        for (Object obj : mutableList) {
            if (!Intrinsics.areEqual(((UserGoalData) obj).getUserGoalUuid(), userGoalUuid)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        this._goalsList.setValue(arrayList2);
        return arrayList2.size() < size;
    }

    public final StateFlow<UserGoalData> getSelectedGoal() {
        return this.selectedGoal;
    }

    public final void setSelectedGoal(UserGoalData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this._selectedGoal.setValue(data);
    }

    public final StateFlow<UserGoalCreateForm> getEditGoalForm() {
        return this.editGoalForm;
    }

    public final void updateGoalForm(Function1<? super UserGoalCreateForm, UserGoalCreateForm> updateFunction) {
        Intrinsics.checkNotNullParameter(updateFunction, "updateFunction");
        this._goalForm.setValue(updateFunction.invoke(this._goalForm.getValue()));
    }

    private final UserGoalCreateForm getInitGoalForm() {
        return new UserGoalCreateForm(GoalTimeFrame.Weekly.getId(), Integer.valueOf(CategoryType.TREADMILL.getCode()), GoalsStatsType.TotalDistance.getId(), 0);
    }

    public final void resetGoalForm() {
        this._goalForm.setValue(getInitGoalForm());
    }

    /* compiled from: GoalsViewModel.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/goals/GoalsViewModel$GoalCalculator;", "", "goalValue", "", "currentValue", "statsType", "", "timeFrame", "completeRate", "(Ljava/lang/Double;Ljava/lang/Double;III)V", "Ljava/lang/Double;", "getConvertedValue", "value", "(Ljava/lang/Double;)Ljava/lang/Double;", "getCurrentValue", "", "getGoalValue", "getToGainValue", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GoalCalculator {
        public static final int $stable = 0;
        private final int completeRate;
        private final Double currentValue;
        private final Double goalValue;
        private final int statsType;
        private final int timeFrame;

        public GoalCalculator(Double d, Double d2, int i, int i2, int i3) {
            this.goalValue = d;
            this.currentValue = d2;
            this.statsType = i;
            this.timeFrame = i2;
            this.completeRate = i3;
        }

        public final String getToGainValue() {
            int iRoundToInt;
            Double convertedValue = getConvertedValue(this.goalValue);
            if (convertedValue != null) {
                double dDoubleValue = convertedValue.doubleValue();
                Double convertedValue2 = getConvertedValue(this.currentValue);
                if (convertedValue2 != null) {
                    double dDoubleValue2 = convertedValue2.doubleValue();
                    if (this.statsType == GoalsStatsType.TotalDistance.getId()) {
                        int i = this.completeRate;
                        return i == 0 ? String.valueOf(MathKt.roundToInt(dDoubleValue2)) : (i != 100 && (iRoundToInt = MathKt.roundToInt(dDoubleValue) - ((int) dDoubleValue2)) > 0) ? String.valueOf(iRoundToInt) : "0";
                    }
                    int i2 = ((int) dDoubleValue) - ((int) dDoubleValue2);
                    return i2 <= 0 ? "0" : String.valueOf(i2);
                }
            }
            return "";
        }

        public final String getCurrentValue() {
            Double convertedValue = getConvertedValue(this.currentValue);
            if (convertedValue == null) {
                return "";
            }
            return String.valueOf((int) convertedValue.doubleValue());
        }

        public final String getGoalValue() {
            Double convertedValue = getConvertedValue(this.goalValue);
            if (convertedValue == null) {
                return "";
            }
            double dDoubleValue = convertedValue.doubleValue();
            if (this.statsType == GoalsStatsType.TotalDistance.getId()) {
                return String.valueOf(MathKt.roundToInt(dDoubleValue));
            }
            return String.valueOf((int) dDoubleValue);
        }

        private final Double getConvertedValue(Double value) {
            int i = this.statsType;
            if (i == GoalsStatsType.TotalDistance.getId()) {
                if (value != null) {
                    return Global.INSTANCE.getUnitType() ? StringsKt.toDoubleOrNull(UnitConversion.INSTANCE.getMi(String.valueOf(value.doubleValue()), 7)) : value;
                }
            } else {
                if (i != GoalsStatsType.ActiveMinutes.getId()) {
                    return value;
                }
                int i2 = this.timeFrame;
                if (i2 != GoalTimeFrame.Weekly.getId() && i2 != GoalTimeFrame.Monthly.getId()) {
                    return value;
                }
                if (value != null) {
                    return Double.valueOf(value.doubleValue() / 60.0d);
                }
            }
            return null;
        }
    }

    public final int getTransTargetValue(int targetVal, int goalTimeFrameType, int statsType) {
        if (statsType == GoalsStatsType.TotalDistance.getId()) {
            if (!Global.INSTANCE.getUnitType()) {
                return targetVal;
            }
            Double doubleOrNull = StringsKt.toDoubleOrNull(UnitConversion.INSTANCE.getKm(String.valueOf(targetVal), 7));
            return MathKt.roundToInt(doubleOrNull != null ? doubleOrNull.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        if (statsType == GoalsStatsType.ActiveMinutes.getId()) {
            if (goalTimeFrameType == GoalTimeFrame.Daily.getId()) {
                return targetVal;
            }
            if (goalTimeFrameType == GoalTimeFrame.Weekly.getId() || goalTimeFrameType == GoalTimeFrame.Monthly.getId()) {
                return targetVal * 60;
            }
            return 0;
        }
        if (statsType == GoalsStatsType.WorkoutCounts.getId() || statsType == GoalsStatsType.TotalCalories.getId() || statsType == GoalsStatsType.TotalSteps.getId() || statsType == GoalsStatsType.TotalStrokes.getId() || statsType == GoalsStatsType.SRVOReps.getId() || statsType == GoalsStatsType.SRVOSets.getId()) {
            return targetVal;
        }
        GoalsStatsType.SRVOPounds.getId();
        return targetVal;
    }

    public final int getGoalValueMaxLimit(int goalTimeFrameType, Integer machineType, int statsType) {
        if (statsType == GoalsStatsType.TotalDistance.getId()) {
            if (Intrinsics.areEqual(machineType, GoalsMachineType.STEPPER.getId())) {
                if (goalTimeFrameType == GoalTimeFrame.Daily.getId()) {
                    return Global.INSTANCE.getUnitType() ? 9000 : 3000;
                }
                if (goalTimeFrameType == GoalTimeFrame.Weekly.getId()) {
                    return Global.INSTANCE.getUnitType() ? 90000 : 30000;
                }
                if (goalTimeFrameType == GoalTimeFrame.Monthly.getId()) {
                    return Global.INSTANCE.getUnitType() ? 300000 : 100000;
                }
            } else {
                if (goalTimeFrameType == GoalTimeFrame.Daily.getId()) {
                    return Global.INSTANCE.getUnitType() ? 1000 : 1600;
                }
                if (goalTimeFrameType == GoalTimeFrame.Weekly.getId()) {
                    return Global.INSTANCE.getUnitType() ? 10000 : 16000;
                }
                if (goalTimeFrameType == GoalTimeFrame.Monthly.getId()) {
                    return Global.INSTANCE.getUnitType() ? 50000 : 80000;
                }
            }
        } else if (statsType == GoalsStatsType.ActiveMinutes.getId()) {
            if (goalTimeFrameType == GoalTimeFrame.Daily.getId()) {
                return WinError.ERROR_SCREEN_ALREADY_LOCKED;
            }
            if (goalTimeFrameType == GoalTimeFrame.Weekly.getId()) {
                return Opcodes.JSR;
            }
            if (goalTimeFrameType == GoalTimeFrame.Monthly.getId()) {
                return WinError.ERROR_RXACT_COMMITTED;
            }
        } else if (statsType == GoalsStatsType.WorkoutCounts.getId()) {
            if (goalTimeFrameType == GoalTimeFrame.Daily.getId()) {
                return 999;
            }
            if (goalTimeFrameType == GoalTimeFrame.Weekly.getId()) {
                return 9999;
            }
            if (goalTimeFrameType == GoalTimeFrame.Monthly.getId()) {
                return 99999;
            }
        } else if (statsType == GoalsStatsType.TotalCalories.getId()) {
            if (goalTimeFrameType == GoalTimeFrame.Daily.getId()) {
                return 9999;
            }
            if (goalTimeFrameType == GoalTimeFrame.Weekly.getId()) {
                return 99999;
            }
            if (goalTimeFrameType == GoalTimeFrame.Monthly.getId()) {
                return 999999;
            }
        } else if (statsType == GoalsStatsType.TotalSteps.getId()) {
            if (goalTimeFrameType == GoalTimeFrame.Daily.getId()) {
                return 99999;
            }
            if (goalTimeFrameType == GoalTimeFrame.Weekly.getId()) {
                return 999999;
            }
            if (goalTimeFrameType == GoalTimeFrame.Monthly.getId()) {
                return 9999999;
            }
        } else if (statsType == GoalsStatsType.TotalStrokes.getId()) {
            if (goalTimeFrameType == GoalTimeFrame.Daily.getId()) {
                return 99999;
            }
            if (goalTimeFrameType == GoalTimeFrame.Weekly.getId()) {
                return 999999;
            }
            if (goalTimeFrameType == GoalTimeFrame.Monthly.getId()) {
                return 9999999;
            }
        } else if (statsType == GoalsStatsType.SRVOReps.getId()) {
            if (goalTimeFrameType == GoalTimeFrame.Daily.getId()) {
                return 3000;
            }
            if (goalTimeFrameType == GoalTimeFrame.Weekly.getId()) {
                return 10000;
            }
            if (goalTimeFrameType == GoalTimeFrame.Monthly.getId()) {
                return 100000;
            }
        } else if (statsType == GoalsStatsType.SRVOSets.getId()) {
            if (goalTimeFrameType == GoalTimeFrame.Daily.getId()) {
                return 100;
            }
            if (goalTimeFrameType == GoalTimeFrame.Weekly.getId()) {
                return 1000;
            }
            if (goalTimeFrameType == GoalTimeFrame.Monthly.getId()) {
                return 5000;
            }
        } else if (statsType == GoalsStatsType.SRVOPounds.getId()) {
            if (goalTimeFrameType == GoalTimeFrame.Daily.getId()) {
                return 100;
            }
            if (goalTimeFrameType == GoalTimeFrame.Weekly.getId()) {
                return 1000;
            }
            if (goalTimeFrameType == GoalTimeFrame.Monthly.getId()) {
                return 5000;
            }
        }
        Timber.INSTANCE.e("err:未找到對應的最大值 goalTimeFrameType:" + goalTimeFrameType + ", machineType:" + machineType + ", statsType:" + statsType, new Object[0]);
        return 9999999;
    }
}
