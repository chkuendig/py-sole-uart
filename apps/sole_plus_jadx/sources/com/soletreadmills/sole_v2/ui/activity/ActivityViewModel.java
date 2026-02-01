package com.soletreadmills.sole_v2.ui.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.soletreadmills.sole_v2._data.UserPersonalBestVoData;
import com.soletreadmills.sole_v2._data.UserWorkout12WeeklyStatsVoData;
import com.soletreadmills.sole_v2._data.WorkoutViewVo;
import com.soletreadmills.sole_v2._data.api.history.HistoryListData;
import com.soletreadmills.sole_v2._type.HistoryActivityType;
import com.soletreadmills.sole_v2._type.TrendsType;
import com.soletreadmills.sole_v2.ui._base.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityViewModel.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0016\u0010-\u001a\u00020+2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001f\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006/"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/activity/ActivityViewModel;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseViewModel;", "()V", "_userPersonalBestVoData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/soletreadmills/sole_v2/_data/UserPersonalBestVoData;", "historyList", "", "Lcom/soletreadmills/sole_v2/_data/api/history/HistoryListData;", "getHistoryList", "()Ljava/util/List;", "setHistoryList", "(Ljava/util/List;)V", "selectActivityType", "", "getSelectActivityType", "()I", "setSelectActivityType", "(I)V", "trendData", "Lcom/soletreadmills/sole_v2/_data/UserWorkout12WeeklyStatsVoData;", "getTrendData", "()Lcom/soletreadmills/sole_v2/_data/UserWorkout12WeeklyStatsVoData;", "setTrendData", "(Lcom/soletreadmills/sole_v2/_data/UserWorkout12WeeklyStatsVoData;)V", "trendsType", "Lcom/soletreadmills/sole_v2/_type/TrendsType;", "getTrendsType", "()Lcom/soletreadmills/sole_v2/_type/TrendsType;", "setTrendsType", "(Lcom/soletreadmills/sole_v2/_type/TrendsType;)V", "userPersonalBestVoData", "Landroidx/lifecycle/LiveData;", "getUserPersonalBestVoData", "()Landroidx/lifecycle/LiveData;", "workoutData", "Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "getWorkoutData", "()Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "setWorkoutData", "(Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;)V", "clearUserPersonalBestVoData", "", "getUserPersonalBestVoDataValue", "setUserPersonalBestVoData", "data", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityViewModel extends BaseViewModel {
    public static final int $stable = 8;
    private final MutableLiveData<List<UserPersonalBestVoData>> _userPersonalBestVoData;
    private List<HistoryListData> historyList = CollectionsKt.emptyList();
    private int selectActivityType = HistoryActivityType.ALL.getCode();
    private UserWorkout12WeeklyStatsVoData trendData;
    private TrendsType trendsType;
    private final LiveData<List<UserPersonalBestVoData>> userPersonalBestVoData;
    private WorkoutViewVo workoutData;

    public ActivityViewModel() {
        MutableLiveData<List<UserPersonalBestVoData>> mutableLiveData = new MutableLiveData<>();
        this._userPersonalBestVoData = mutableLiveData;
        this.userPersonalBestVoData = mutableLiveData;
    }

    public final List<HistoryListData> getHistoryList() {
        return this.historyList;
    }

    public final void setHistoryList(List<HistoryListData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.historyList = list;
    }

    public final int getSelectActivityType() {
        return this.selectActivityType;
    }

    public final void setSelectActivityType(int i) {
        this.selectActivityType = i;
    }

    public final UserWorkout12WeeklyStatsVoData getTrendData() {
        return this.trendData;
    }

    public final void setTrendData(UserWorkout12WeeklyStatsVoData userWorkout12WeeklyStatsVoData) {
        this.trendData = userWorkout12WeeklyStatsVoData;
    }

    public final TrendsType getTrendsType() {
        return this.trendsType;
    }

    public final void setTrendsType(TrendsType trendsType) {
        this.trendsType = trendsType;
    }

    public final WorkoutViewVo getWorkoutData() {
        return this.workoutData;
    }

    public final void setWorkoutData(WorkoutViewVo workoutViewVo) {
        this.workoutData = workoutViewVo;
    }

    public final LiveData<List<UserPersonalBestVoData>> getUserPersonalBestVoData() {
        return this.userPersonalBestVoData;
    }

    public final void setUserPersonalBestVoData(List<UserPersonalBestVoData> data) {
        this._userPersonalBestVoData.setValue(data);
    }

    public final List<UserPersonalBestVoData> getUserPersonalBestVoDataValue() {
        return this._userPersonalBestVoData.getValue();
    }

    public final void clearUserPersonalBestVoData() {
        this._userPersonalBestVoData.setValue(null);
    }
}
