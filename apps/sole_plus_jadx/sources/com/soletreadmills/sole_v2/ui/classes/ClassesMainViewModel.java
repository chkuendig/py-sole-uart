package com.soletreadmills.sole_v2.ui.classes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import com.soletreadmills.sole_v2._data.api.JwtErrorCode;
import com.soletreadmills.sole_v2._data.api.classes.ClassInstructorsDataBase;
import com.soletreadmills.sole_v2._data.api.classes.CollectionInstructorsData;
import com.soletreadmills.sole_v2._data.api.classes.GetClassInstructorsApiData;
import com.soletreadmills.sole_v2._data.api.classes.SessionInstructorsData;
import com.soletreadmills.sole_v2._data.classes.ActivityDataBase;
import com.soletreadmills.sole_v2._data.classes.ClassCollectionData;
import com.soletreadmills.sole_v2._data.classes.ClassesData;
import com.soletreadmills.sole_v2._data.classes.CollectionActivityData;
import com.soletreadmills.sole_v2._data.classes.DurationData;
import com.soletreadmills.sole_v2._data.classes.FitnessLevelData;
import com.soletreadmills.sole_v2._data.classes.FocusData;
import com.soletreadmills.sole_v2._data.classes.GetClassListApiData;
import com.soletreadmills.sole_v2._data.classes.GetClassQuickPicksApiData;
import com.soletreadmills.sole_v2._data.classes.GetCollectionQuickPicksApiData;
import com.soletreadmills.sole_v2._data.classes.GetCollectionsApiData;
import com.soletreadmills.sole_v2._data.classes.QuickPicksData;
import com.soletreadmills.sole_v2._data.classes.ResultsInfo;
import com.soletreadmills.sole_v2._data.classes.SessionActivityData;
import com.soletreadmills.sole_v2._network.JwtDyacoApiKt;
import com.soletreadmills.sole_v2._type.ActivityType;
import com.soletreadmills.sole_v2._type.DurationType;
import com.soletreadmills.sole_v2._type.FitnessLevelType;
import com.soletreadmills.sole_v2._type.FocusType;
import com.sun.jna.Callback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

/* compiled from: ClassesMainViewModel.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010X\u001a\u00020YJ\u0006\u0010Z\u001a\u00020/J\u0006\u0010[\u001a\u00020YJ\u0006\u0010\\\u001a\u00020/J\u0006\u0010]\u001a\u00020/J\u0006\u0010^\u001a\u00020/J\u0006\u0010_\u001a\u00020/J\u0006\u0010`\u001a\u00020/J\u0006\u0010a\u001a\u00020/J\u0006\u0010b\u001a\u00020YJ2\u0010c\u001a\u00020Y2\b\b\u0002\u0010d\u001a\u00020\u001b2\b\b\u0002\u0010e\u001a\u00020/2\u0016\b\u0002\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020Y\u0018\u00010gJ\u0006\u0010h\u001a\u00020YJ\u0006\u0010i\u001a\u00020YJ2\u0010j\u001a\u00020Y2\b\b\u0002\u0010d\u001a\u00020\u001b2\b\b\u0002\u0010e\u001a\u00020/2\u0016\b\u0002\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020Y\u0018\u00010gJ\u0006\u0010k\u001a\u00020YR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u001a\u0010#\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001e\"\u0004\b%\u0010&R\u001d\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0017¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0017¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0019R \u00102\u001a\b\u0012\u0004\u0012\u0002030\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0013\"\u0004\b5\u0010\u0015R \u00106\u001a\b\u0012\u0004\u0012\u0002070\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0013\"\u0004\b9\u0010\u0015R \u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0013\"\u0004\b=\u0010\u0015R\u000e\u0010>\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001e\"\u0004\bA\u0010&R \u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0013\"\u0004\bE\u0010\u0015R\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0019R\u001e\u0010H\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u001eR \u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0013\"\u0004\bM\u0010\u0015R\u001a\u0010N\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001e\"\u0004\bP\u0010&R\u001d\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u0017¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0019R\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020+0*¢\u0006\b\n\u0000\u001a\u0004\bT\u0010-R\u000e\u0010U\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0017¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0019¨\u0006l"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/ClassesMainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_collectionFilterResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/soletreadmills/sole_v2/_data/classes/ResultsInfo;", "_collectionList", "", "Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionData;", "_collectionsQuickPicks", "Lcom/soletreadmills/sole_v2/_data/classes/QuickPicksData;", "_sessionFilterResult", "_sessionList", "Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", "_sessionsQuickPicks", "collectionActivityDataList", "", "Lcom/soletreadmills/sole_v2/_data/classes/CollectionActivityData;", "getCollectionActivityDataList", "()Ljava/util/List;", "setCollectionActivityDataList", "(Ljava/util/List;)V", "collectionFilterResult", "Landroidx/lifecycle/LiveData;", "getCollectionFilterResult", "()Landroidx/lifecycle/LiveData;", "<set-?>", "", "collectionHasMoreData", "getCollectionHasMoreData", "()Z", "collectionInstructorsList", "Lcom/soletreadmills/sole_v2/_data/api/classes/CollectionInstructorsData;", "getCollectionInstructorsList", "setCollectionInstructorsList", "collectionIsFavoriteSelect", "getCollectionIsFavoriteSelect", "setCollectionIsFavoriteSelect", "(Z)V", "collectionList", "getCollectionList", "collectionQuickPicksSelectedItems", "", "", "getCollectionQuickPicksSelectedItems", "()Ljava/util/Set;", "collectionsPage", "", "collectionsQuickPicks", "getCollectionsQuickPicks", "durationDataList", "Lcom/soletreadmills/sole_v2/_data/classes/DurationData;", "getDurationDataList", "setDurationDataList", "fitnessLevelDataList", "Lcom/soletreadmills/sole_v2/_data/classes/FitnessLevelData;", "getFitnessLevelDataList", "setFitnessLevelDataList", "focusDataList", "Lcom/soletreadmills/sole_v2/_data/classes/FocusData;", "getFocusDataList", "setFocusDataList", "isLoadingMoreCollections", "isLoadingMoreSessions", "isSessionsSelected", "setSessionsSelected", "sessionActivityDataList", "Lcom/soletreadmills/sole_v2/_data/classes/SessionActivityData;", "getSessionActivityDataList", "setSessionActivityDataList", "sessionFilterResult", "getSessionFilterResult", "sessionHasMoreData", "getSessionHasMoreData", "sessionInstructorsList", "Lcom/soletreadmills/sole_v2/_data/api/classes/SessionInstructorsData;", "getSessionInstructorsList", "setSessionInstructorsList", "sessionIsFavoriteSelect", "getSessionIsFavoriteSelect", "setSessionIsFavoriteSelect", "sessionList", "getSessionList", "sessionQuickPicksSelectedItems", "getSessionQuickPicksSelectedItems", "sessionsPage", "sessionsQuickPicks", "getSessionsQuickPicks", "clearAllFilters", "", "getActivityCount", "getCallGetClassInstructors", "getCollectionFilterount", "getDurationCount", "getFitnessLevelCount", "getFocusCount", "getInstructorsCount", "getSessionFilterount", "loadCollecionQuickPickData", "loadCollectionsData", "isGetMore", "page", Callback.METHOD_NAME, "Lkotlin/Function1;", "loadMoreCollectionsData", "loadMoreSessionsData", "loadSessionsData", "loadSessionsQuickPickData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesMainViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableLiveData<ResultsInfo> _collectionFilterResult;
    private final MutableLiveData<List<ClassCollectionData>> _collectionList;
    private final MutableLiveData<List<QuickPicksData>> _collectionsQuickPicks;
    private final MutableLiveData<ResultsInfo> _sessionFilterResult;
    private final MutableLiveData<List<ClassesData>> _sessionList;
    private final MutableLiveData<List<QuickPicksData>> _sessionsQuickPicks;
    private final LiveData<ResultsInfo> collectionFilterResult;
    private boolean collectionHasMoreData;
    private boolean collectionIsFavoriteSelect;
    private final LiveData<List<ClassCollectionData>> collectionList;
    private final LiveData<List<QuickPicksData>> collectionsQuickPicks;
    private boolean isLoadingMoreCollections;
    private boolean isLoadingMoreSessions;
    private final LiveData<ResultsInfo> sessionFilterResult;
    private boolean sessionHasMoreData;
    private boolean sessionIsFavoriteSelect;
    private final LiveData<List<ClassesData>> sessionList;
    private final LiveData<List<QuickPicksData>> sessionsQuickPicks;
    private boolean isSessionsSelected = true;
    private int sessionsPage = 1;
    private int collectionsPage = 1;
    private final Set<String> sessionQuickPicksSelectedItems = new LinkedHashSet();
    private final Set<String> collectionQuickPicksSelectedItems = new LinkedHashSet();
    private List<SessionInstructorsData> sessionInstructorsList = new ArrayList();
    private List<SessionActivityData> sessionActivityDataList = ActivityType.INSTANCE.getAllSessionActivityData();
    private List<CollectionInstructorsData> collectionInstructorsList = new ArrayList();
    private List<CollectionActivityData> collectionActivityDataList = ActivityType.INSTANCE.getAllCollectionActivityData();
    private List<FitnessLevelData> fitnessLevelDataList = FitnessLevelType.INSTANCE.getAllFitnessLevelData();
    private List<DurationData> durationDataList = DurationType.INSTANCE.getAllDurationData();
    private List<FocusData> focusDataList = FocusType.INSTANCE.getAllFocusData();

    public ClassesMainViewModel() {
        MutableLiveData<List<ClassesData>> mutableLiveData = new MutableLiveData<>(CollectionsKt.emptyList());
        this._sessionList = mutableLiveData;
        this.sessionList = mutableLiveData;
        MutableLiveData<List<ClassCollectionData>> mutableLiveData2 = new MutableLiveData<>(CollectionsKt.emptyList());
        this._collectionList = mutableLiveData2;
        this.collectionList = mutableLiveData2;
        MutableLiveData<List<QuickPicksData>> mutableLiveData3 = new MutableLiveData<>(CollectionsKt.emptyList());
        this._sessionsQuickPicks = mutableLiveData3;
        this.sessionsQuickPicks = mutableLiveData3;
        MutableLiveData<List<QuickPicksData>> mutableLiveData4 = new MutableLiveData<>(CollectionsKt.emptyList());
        this._collectionsQuickPicks = mutableLiveData4;
        this.collectionsQuickPicks = mutableLiveData4;
        MutableLiveData<ResultsInfo> mutableLiveData5 = new MutableLiveData<>(new ResultsInfo(0, 0));
        this._sessionFilterResult = mutableLiveData5;
        this.sessionFilterResult = mutableLiveData5;
        MutableLiveData<ResultsInfo> mutableLiveData6 = new MutableLiveData<>(new ResultsInfo(0, 0));
        this._collectionFilterResult = mutableLiveData6;
        this.collectionFilterResult = mutableLiveData6;
    }

    /* renamed from: isSessionsSelected, reason: from getter */
    public final boolean getIsSessionsSelected() {
        return this.isSessionsSelected;
    }

    public final void setSessionsSelected(boolean z) {
        this.isSessionsSelected = z;
    }

    public final boolean getSessionHasMoreData() {
        return this.sessionHasMoreData;
    }

    public final boolean getCollectionHasMoreData() {
        return this.collectionHasMoreData;
    }

    public final Set<String> getSessionQuickPicksSelectedItems() {
        return this.sessionQuickPicksSelectedItems;
    }

    public final Set<String> getCollectionQuickPicksSelectedItems() {
        return this.collectionQuickPicksSelectedItems;
    }

    public final List<SessionInstructorsData> getSessionInstructorsList() {
        return this.sessionInstructorsList;
    }

    public final void setSessionInstructorsList(List<SessionInstructorsData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sessionInstructorsList = list;
    }

    public final boolean getSessionIsFavoriteSelect() {
        return this.sessionIsFavoriteSelect;
    }

    public final void setSessionIsFavoriteSelect(boolean z) {
        this.sessionIsFavoriteSelect = z;
    }

    public final List<SessionActivityData> getSessionActivityDataList() {
        return this.sessionActivityDataList;
    }

    public final void setSessionActivityDataList(List<SessionActivityData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sessionActivityDataList = list;
    }

    public final List<CollectionInstructorsData> getCollectionInstructorsList() {
        return this.collectionInstructorsList;
    }

    public final void setCollectionInstructorsList(List<CollectionInstructorsData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.collectionInstructorsList = list;
    }

    public final boolean getCollectionIsFavoriteSelect() {
        return this.collectionIsFavoriteSelect;
    }

    public final void setCollectionIsFavoriteSelect(boolean z) {
        this.collectionIsFavoriteSelect = z;
    }

    public final List<CollectionActivityData> getCollectionActivityDataList() {
        return this.collectionActivityDataList;
    }

    public final void setCollectionActivityDataList(List<CollectionActivityData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.collectionActivityDataList = list;
    }

    public final List<FitnessLevelData> getFitnessLevelDataList() {
        return this.fitnessLevelDataList;
    }

    public final void setFitnessLevelDataList(List<FitnessLevelData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.fitnessLevelDataList = list;
    }

    public final List<DurationData> getDurationDataList() {
        return this.durationDataList;
    }

    public final void setDurationDataList(List<DurationData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.durationDataList = list;
    }

    public final List<FocusData> getFocusDataList() {
        return this.focusDataList;
    }

    public final void setFocusDataList(List<FocusData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.focusDataList = list;
    }

    public final LiveData<List<ClassesData>> getSessionList() {
        return this.sessionList;
    }

    public final LiveData<List<ClassCollectionData>> getCollectionList() {
        return this.collectionList;
    }

    public final LiveData<List<QuickPicksData>> getSessionsQuickPicks() {
        return this.sessionsQuickPicks;
    }

    public final LiveData<List<QuickPicksData>> getCollectionsQuickPicks() {
        return this.collectionsQuickPicks;
    }

    public final LiveData<ResultsInfo> getSessionFilterResult() {
        return this.sessionFilterResult;
    }

    public final LiveData<ResultsInfo> getCollectionFilterResult() {
        return this.collectionFilterResult;
    }

    public final int getSessionFilterount() {
        boolean z = this.sessionIsFavoriteSelect;
        return (z ? 1 : 0) + getActivityCount() + getInstructorsCount() + getDurationCount() + getFitnessLevelCount() + getFocusCount();
    }

    public final int getCollectionFilterount() {
        boolean z = this.collectionIsFavoriteSelect;
        return (z ? 1 : 0) + getActivityCount() + getInstructorsCount();
    }

    public final int getActivityCount() {
        Iterable iterable = this.isSessionsSelected ? this.sessionActivityDataList : this.collectionActivityDataList;
        int i = 0;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (((ActivityDataBase) it.next()).isSelect() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }

    public final int getInstructorsCount() {
        Iterable iterable = this.isSessionsSelected ? this.sessionInstructorsList : this.collectionInstructorsList;
        int i = 0;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (((ClassInstructorsDataBase) it.next()).isSelect() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }

    public final int getDurationCount() {
        List<DurationData> list = this.durationDataList;
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((DurationData) it.next()).isSelect() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }

    public final int getFitnessLevelCount() {
        List<FitnessLevelData> list = this.fitnessLevelDataList;
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((FitnessLevelData) it.next()).isSelect() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }

    public final int getFocusCount() {
        List<FocusData> list = this.focusDataList;
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((FocusData) it.next()).isSelect() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }

    public final void loadMoreSessionsData() {
        if (this.isLoadingMoreSessions || !this.sessionHasMoreData) {
            return;
        }
        this.isLoadingMoreSessions = true;
        final int i = this.sessionsPage + 1;
        loadSessionsData(true, i, new Function1<Boolean, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel.loadMoreSessionsData.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                ClassesMainViewModel.this.isLoadingMoreSessions = false;
                if (z) {
                    ClassesMainViewModel.this.sessionsPage = i;
                }
            }
        });
    }

    public final void loadMoreCollectionsData() {
        if (this.isLoadingMoreCollections || !this.collectionHasMoreData) {
            return;
        }
        this.isLoadingMoreCollections = true;
        final int i = this.collectionsPage + 1;
        loadCollectionsData(true, i, new Function1<Boolean, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel.loadMoreCollectionsData.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                ClassesMainViewModel.this.isLoadingMoreCollections = false;
                if (z) {
                    ClassesMainViewModel.this.collectionsPage = i;
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadSessionsData$default(ClassesMainViewModel classesMainViewModel, boolean z, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            i = 1;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        classesMainViewModel.loadSessionsData(z, i, function1);
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v15, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v22, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.lang.String] */
    public final void loadSessionsData(boolean isGetMore, int page, Function1<? super Boolean, Unit> callback) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
        if (getSessionFilterount() > 0) {
            List<SessionActivityData> list = this.sessionActivityDataList;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((SessionActivityData) obj).isSelect()) {
                    arrayList.add(obj);
                }
            }
            objectRef.element = CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, new Function1<SessionActivityData, CharSequence>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel.loadSessionsData.2
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(SessionActivityData it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getType().getRawValue();
                }
            }, 30, null);
            List<DurationData> list2 = this.durationDataList;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                if (((DurationData) obj2).isSelect()) {
                    arrayList2.add(obj2);
                }
            }
            objectRef2.element = CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, new Function1<DurationData, CharSequence>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel.loadSessionsData.4
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(DurationData it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getType().getRawValue();
                }
            }, 30, null);
            List<FitnessLevelData> list3 = this.fitnessLevelDataList;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : list3) {
                if (((FitnessLevelData) obj3).isSelect()) {
                    arrayList3.add(obj3);
                }
            }
            objectRef3.element = CollectionsKt.joinToString$default(arrayList3, ",", null, null, 0, null, new Function1<FitnessLevelData, CharSequence>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel.loadSessionsData.6
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(FitnessLevelData it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getType().getRawValue();
                }
            }, 30, null);
            List<SessionInstructorsData> list4 = this.sessionInstructorsList;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj4 : list4) {
                if (((SessionInstructorsData) obj4).isSelect()) {
                    arrayList4.add(obj4);
                }
            }
            ArrayList arrayList5 = new ArrayList();
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                String instructor_id = ((SessionInstructorsData) it.next()).getInstructorsData().getInstructor_id();
                if (instructor_id != null) {
                    arrayList5.add(instructor_id);
                }
            }
            objectRef4.element = CollectionsKt.joinToString$default(arrayList5, ",", null, null, 0, null, null, 62, null);
            List<FocusData> list5 = this.focusDataList;
            ArrayList arrayList6 = new ArrayList();
            for (Object obj5 : list5) {
                if (((FocusData) obj5).isSelect()) {
                    arrayList6.add(obj5);
                }
            }
            objectRef5.element = CollectionsKt.joinToString$default(arrayList6, ",", null, null, 0, null, new Function1<FocusData, CharSequence>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel.loadSessionsData.10
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(FocusData it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    return it2.getType().getRawValue();
                }
            }, 30, null);
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass11(objectRef, objectRef3, objectRef2, objectRef4, this, objectRef5, page, isGetMore, callback, null), 3, null);
    }

    /* compiled from: ClassesMainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel$loadSessionsData$11", f = "ClassesMainViewModel.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel$loadSessionsData$11, reason: invalid class name */
    static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<String> $classTypes;
        final /* synthetic */ Ref.ObjectRef<String> $difficulties;
        final /* synthetic */ Ref.ObjectRef<String> $durations;
        final /* synthetic */ Ref.ObjectRef<String> $instructorIds;
        final /* synthetic */ boolean $isGetMore;
        final /* synthetic */ int $page;
        final /* synthetic */ Ref.ObjectRef<String> $workoutTypes;
        int label;
        final /* synthetic */ ClassesMainViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass11(Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, Ref.ObjectRef<String> objectRef4, ClassesMainViewModel classesMainViewModel, Ref.ObjectRef<String> objectRef5, int i, boolean z, Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass11> continuation) {
            super(2, continuation);
            this.$classTypes = objectRef;
            this.$difficulties = objectRef2;
            this.$durations = objectRef3;
            this.$instructorIds = objectRef4;
            this.this$0 = classesMainViewModel;
            this.$workoutTypes = objectRef5;
            this.$page = i;
            this.$isGetMore = z;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass11(this.$classTypes, this.$difficulties, this.$durations, this.$instructorIds, this.this$0, this.$workoutTypes, this.$page, this.$isGetMore, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass11) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCallGetClassListApiData;
            List<ClassesData> listEmptyList;
            Integer total;
            JwtApiBaseData.SysResponseMessage sysMsg;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            String code = null;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    String str = this.$classTypes.element;
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        str = null;
                    }
                    String str3 = str;
                    String str4 = this.$difficulties.element;
                    String str5 = str4;
                    if (str5 == null || str5.length() == 0) {
                        str4 = null;
                    }
                    String str6 = str4;
                    String str7 = this.$durations.element;
                    String str8 = str7;
                    if (str8 == null || str8.length() == 0) {
                        str7 = null;
                    }
                    String str9 = str7;
                    String str10 = this.$instructorIds.element;
                    String str11 = str10;
                    if (str11 == null || str11.length() == 0) {
                        str10 = null;
                    }
                    String str12 = str10;
                    boolean sessionIsFavoriteSelect = this.this$0.getSessionIsFavoriteSelect();
                    String str13 = this.$workoutTypes.element;
                    String str14 = str13;
                    if (str14 == null || str14.length() == 0) {
                        str13 = null;
                    }
                    int i2 = this.$page;
                    this.label = 1;
                    objCallGetClassListApiData = JwtDyacoApiKt.callGetClassListApiData((126 & 1) != 0 ? null : null, (126 & 2) != 0 ? null : str3, (126 & 4) != 0 ? null : str6, (126 & 8) != 0 ? null : str9, (126 & 16) != 0 ? null : str12, (126 & 32) != 0 ? false : sessionIsFavoriteSelect, (126 & 64) != 0 ? null : str13, (126 & 128) != 0 ? 1 : i2, (126 & 256) != 0 ? 100 : 0, this);
                    if (objCallGetClassListApiData == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objCallGetClassListApiData = obj;
                }
                GetClassListApiData.ResponseData responseData = (GetClassListApiData.ResponseData) ((Response) objCallGetClassListApiData).body();
                if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                    code = sysMsg.getCode();
                }
                if (Intrinsics.areEqual(code, JwtErrorCode.JWT_SUCCESS_1.getId())) {
                    GetClassListApiData.ClassesListDataMap dataMap = responseData.getDataMap();
                    if (dataMap == null || (listEmptyList = dataMap.getData()) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    GetClassListApiData.ClassesListDataMap dataMap2 = responseData.getDataMap();
                    int iIntValue = (dataMap2 == null || (total = dataMap2.getTotal()) == null) ? 0 : total.intValue();
                    this.this$0._sessionFilterResult.setValue(new ResultsInfo(iIntValue, this.this$0.getSessionFilterount()));
                    if (this.$isGetMore) {
                        List listEmptyList2 = (List) this.this$0._sessionList.getValue();
                        if (listEmptyList2 == null) {
                            listEmptyList2 = CollectionsKt.emptyList();
                        }
                        listEmptyList = CollectionsKt.plus((Collection) listEmptyList2, (Iterable) listEmptyList);
                    }
                    this.this$0._sessionList.setValue(listEmptyList);
                    this.this$0.sessionHasMoreData = listEmptyList.size() < iIntValue;
                    Function1<Boolean, Unit> function1 = this.$callback;
                    if (function1 != null) {
                        function1.invoke(Boxing.boxBoolean(true));
                    }
                } else {
                    Function1<Boolean, Unit> function12 = this.$callback;
                    if (function12 != null) {
                        function12.invoke(Boxing.boxBoolean(false));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Function1<Boolean, Unit> function13 = this.$callback;
                if (function13 != null) {
                    function13.invoke(Boxing.boxBoolean(false));
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ClassesMainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel$loadSessionsQuickPickData$1", f = "ClassesMainViewModel.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel$loadSessionsQuickPickData$1, reason: invalid class name and case insensitive filesystem */
    static final class C08771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08771(Continuation<? super C08771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClassesMainViewModel.this.new C08771(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            JwtApiBaseData.SysResponseMessage sysMsg;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = JwtDyacoApiKt.callGetSessionQuickPick(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                GetClassQuickPicksApiData.ResponseData responseData = (GetClassQuickPicksApiData.ResponseData) ((Response) obj).body();
                if (Intrinsics.areEqual((responseData == null || (sysMsg = responseData.getSysMsg()) == null) ? null : sysMsg.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                    List<QuickPicksData> dataMap = responseData.getDataMap();
                    if (dataMap == null) {
                        dataMap = CollectionsKt.emptyList();
                    }
                    ClassesMainViewModel.this._sessionsQuickPicks.setValue(dataMap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }
    }

    public final void loadSessionsQuickPickData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C08771(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadCollectionsData$default(ClassesMainViewModel classesMainViewModel, boolean z, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            i = 1;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        classesMainViewModel.loadCollectionsData(z, i, function1);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, java.lang.String] */
    public final void loadCollectionsData(boolean isGetMore, int page, Function1<? super Boolean, Unit> callback) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        if (getCollectionFilterount() > 0) {
            List<CollectionActivityData> list = this.collectionActivityDataList;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((CollectionActivityData) obj).isSelect()) {
                    arrayList.add(obj);
                }
            }
            objectRef.element = CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, new Function1<CollectionActivityData, CharSequence>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel.loadCollectionsData.2
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(CollectionActivityData it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getType().getRawValue();
                }
            }, 30, null);
            List<CollectionInstructorsData> list2 = this.collectionInstructorsList;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                if (((CollectionInstructorsData) obj2).isSelect()) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                String instructor_id = ((CollectionInstructorsData) it.next()).getInstructorsData().getInstructor_id();
                if (instructor_id != null) {
                    arrayList3.add(instructor_id);
                }
            }
            objectRef2.element = CollectionsKt.joinToString$default(arrayList3, ",", null, null, 0, null, null, 62, null);
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass5(objectRef, objectRef2, this, page, isGetMore, callback, null), 3, null);
    }

    /* compiled from: ClassesMainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel$loadCollectionsData$5", f = "ClassesMainViewModel.kt", i = {}, l = {242}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel$loadCollectionsData$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<String> $classTypes;
        final /* synthetic */ Ref.ObjectRef<String> $instructorIds;
        final /* synthetic */ boolean $isGetMore;
        final /* synthetic */ int $page;
        int label;
        final /* synthetic */ ClassesMainViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, ClassesMainViewModel classesMainViewModel, int i, boolean z, Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$classTypes = objectRef;
            this.$instructorIds = objectRef2;
            this.this$0 = classesMainViewModel;
            this.$page = i;
            this.$isGetMore = z;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.$classTypes, this.$instructorIds, this.this$0, this.$page, this.$isGetMore, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List<ClassCollectionData> listEmptyList;
            Integer total;
            JwtApiBaseData.SysResponseMessage sysMsg;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            String code = null;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    String str = this.$classTypes.element;
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        str = null;
                    }
                    String str3 = str;
                    String str4 = this.$instructorIds.element;
                    String str5 = str4;
                    if (str5 == null || str5.length() == 0) {
                        str4 = null;
                    }
                    boolean collectionIsFavoriteSelect = this.this$0.getCollectionIsFavoriteSelect();
                    int i2 = this.$page;
                    this.label = 1;
                    obj = JwtDyacoApiKt.callGetCollectionsApiData((14 & 1) != 0 ? null : null, (14 & 2) != 0 ? null : str3, (14 & 4) != 0 ? null : str4, (14 & 8) != 0 ? false : collectionIsFavoriteSelect, (14 & 16) != 0 ? 1 : i2, (14 & 32) != 0 ? 100 : 0, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                GetCollectionsApiData.ResponseData responseData = (GetCollectionsApiData.ResponseData) ((Response) obj).body();
                if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                    code = sysMsg.getCode();
                }
                if (Intrinsics.areEqual(code, JwtErrorCode.JWT_SUCCESS_1.getId())) {
                    GetCollectionsApiData.ClassCollectionListDataMap dataMap = responseData.getDataMap();
                    if (dataMap == null || (listEmptyList = dataMap.getData()) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    GetCollectionsApiData.ClassCollectionListDataMap dataMap2 = responseData.getDataMap();
                    int iIntValue = (dataMap2 == null || (total = dataMap2.getTotal()) == null) ? 0 : total.intValue();
                    this.this$0._collectionFilterResult.setValue(new ResultsInfo(iIntValue, this.this$0.getCollectionFilterount()));
                    if (this.$isGetMore) {
                        List listEmptyList2 = (List) this.this$0._collectionList.getValue();
                        if (listEmptyList2 == null) {
                            listEmptyList2 = CollectionsKt.emptyList();
                        }
                        listEmptyList = CollectionsKt.plus((Collection) listEmptyList2, (Iterable) listEmptyList);
                    }
                    this.this$0._collectionList.setValue(listEmptyList);
                    this.this$0.collectionHasMoreData = listEmptyList.size() < iIntValue;
                    Function1<Boolean, Unit> function1 = this.$callback;
                    if (function1 != null) {
                        function1.invoke(Boxing.boxBoolean(true));
                    }
                } else {
                    Function1<Boolean, Unit> function12 = this.$callback;
                    if (function12 != null) {
                        function12.invoke(Boxing.boxBoolean(false));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Function1<Boolean, Unit> function13 = this.$callback;
                if (function13 != null) {
                    function13.invoke(Boxing.boxBoolean(false));
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ClassesMainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel$loadCollecionQuickPickData$1", f = "ClassesMainViewModel.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel$loadCollecionQuickPickData$1, reason: invalid class name and case insensitive filesystem */
    static final class C08731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08731(Continuation<? super C08731> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClassesMainViewModel.this.new C08731(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            JwtApiBaseData.SysResponseMessage sysMsg;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = JwtDyacoApiKt.callGetCollectionQuickPick(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                GetCollectionQuickPicksApiData.ResponseData responseData = (GetCollectionQuickPicksApiData.ResponseData) ((Response) obj).body();
                if (Intrinsics.areEqual((responseData == null || (sysMsg = responseData.getSysMsg()) == null) ? null : sysMsg.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                    List<QuickPicksData> dataMap = responseData.getDataMap();
                    if (dataMap == null) {
                        dataMap = CollectionsKt.emptyList();
                    }
                    ClassesMainViewModel.this._collectionsQuickPicks.setValue(dataMap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }
    }

    public final void loadCollecionQuickPickData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C08731(null), 3, null);
    }

    public final void clearAllFilters() {
        if (this.isSessionsSelected) {
            this.sessionIsFavoriteSelect = false;
            this.sessionActivityDataList = ActivityType.INSTANCE.getAllSessionActivityData();
            Iterator<T> it = this.sessionInstructorsList.iterator();
            while (it.hasNext()) {
                ((SessionInstructorsData) it.next()).setSelect(false);
            }
            this.durationDataList = DurationType.INSTANCE.getAllDurationData();
            this.fitnessLevelDataList = FitnessLevelType.INSTANCE.getAllFitnessLevelData();
            this.focusDataList = FocusType.INSTANCE.getAllFocusData();
            this.sessionQuickPicksSelectedItems.clear();
            loadSessionsData$default(this, false, 0, null, 7, null);
            return;
        }
        this.collectionIsFavoriteSelect = false;
        this.collectionActivityDataList = ActivityType.INSTANCE.getAllCollectionActivityData();
        Iterator<T> it2 = this.collectionInstructorsList.iterator();
        while (it2.hasNext()) {
            ((CollectionInstructorsData) it2.next()).setSelect(false);
        }
        this.collectionQuickPicksSelectedItems.clear();
        loadCollectionsData$default(this, false, 0, null, 7, null);
    }

    /* compiled from: ClassesMainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel$getCallGetClassInstructors$1", f = "ClassesMainViewModel.kt", i = {}, l = {327}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesMainViewModel$getCallGetClassInstructors$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClassesMainViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            JwtApiBaseData.SysResponseMessage sysMsg;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = JwtDyacoApiKt.callGetClassInstructors(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                GetClassInstructorsApiData.ResponseData responseData = (GetClassInstructorsApiData.ResponseData) ((Response) obj).body();
                if (Intrinsics.areEqual((responseData == null || (sysMsg = responseData.getSysMsg()) == null) ? null : sysMsg.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                    List<GetClassInstructorsApiData.ClassInstructorsData> dataMap = responseData.getDataMap();
                    if (dataMap == null) {
                        dataMap = CollectionsKt.emptyList();
                    }
                    ClassesMainViewModel classesMainViewModel = ClassesMainViewModel.this;
                    for (GetClassInstructorsApiData.ClassInstructorsData classInstructorsData : dataMap) {
                        classesMainViewModel.getSessionInstructorsList().add(new SessionInstructorsData(classInstructorsData, false));
                        classesMainViewModel.getCollectionInstructorsList().add(new CollectionInstructorsData(classInstructorsData, false));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (e.getMessage() == null) {
                    e.getClass().getSimpleName();
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void getCallGetClassInstructors() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }
}
