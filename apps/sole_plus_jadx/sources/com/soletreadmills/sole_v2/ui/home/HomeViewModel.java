package com.soletreadmills.sole_v2.ui.home;

import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._data.classes.ClassCollectionData;
import com.soletreadmills.sole_v2._data.classes.FavoritesData;
import com.soletreadmills.sole_v2._data.home.PickedForYouData;
import com.soletreadmills.sole_v2.ui._base.BaseViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u001aJ\u0014\u0010#\u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u001aJ\u0014\u0010$\u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/home/HomeViewModel;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseViewModel;", "()V", "_collectionsList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionData;", "_favoritesList", "Lcom/soletreadmills/sole_v2/_data/classes/FavoritesData;", "_pickUpList", "Lcom/soletreadmills/sole_v2/_data/home/PickedForYouData;", "callBannerApi", "", "getCallBannerApi", "()Z", "setCallBannerApi", "(Z)V", "collectionsList", "Lkotlinx/coroutines/flow/StateFlow;", "getCollectionsList", "()Lkotlinx/coroutines/flow/StateFlow;", "favoritesList", "getFavoritesList", "pickUpList", "getPickUpList", "syncMachineList", "", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "getSyncMachineList", "()Ljava/util/List;", "setSyncMachineList", "(Ljava/util/List;)V", "updateCollectionsList", "", "datas", "updateFavoritesList", "updatePickUpList", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HomeViewModel extends BaseViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<List<ClassCollectionData>> _collectionsList;
    private final MutableStateFlow<List<FavoritesData>> _favoritesList;
    private final MutableStateFlow<List<PickedForYouData>> _pickUpList;
    private boolean callBannerApi;
    private final StateFlow<List<ClassCollectionData>> collectionsList;
    private final StateFlow<List<FavoritesData>> favoritesList;
    private final StateFlow<List<PickedForYouData>> pickUpList;
    private List<BleDeviceInfoData> syncMachineList = new ArrayList();

    public HomeViewModel() {
        MutableStateFlow<List<FavoritesData>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._favoritesList = MutableStateFlow;
        this.favoritesList = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<List<PickedForYouData>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._pickUpList = MutableStateFlow2;
        this.pickUpList = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<List<ClassCollectionData>> MutableStateFlow3 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._collectionsList = MutableStateFlow3;
        this.collectionsList = FlowKt.asStateFlow(MutableStateFlow3);
    }

    public final List<BleDeviceInfoData> getSyncMachineList() {
        return this.syncMachineList;
    }

    public final void setSyncMachineList(List<BleDeviceInfoData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.syncMachineList = list;
    }

    public final boolean getCallBannerApi() {
        return this.callBannerApi;
    }

    public final void setCallBannerApi(boolean z) {
        this.callBannerApi = z;
    }

    public final StateFlow<List<FavoritesData>> getFavoritesList() {
        return this.favoritesList;
    }

    public final void updateFavoritesList(List<FavoritesData> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        this._favoritesList.setValue(datas);
    }

    public final StateFlow<List<PickedForYouData>> getPickUpList() {
        return this.pickUpList;
    }

    public final void updatePickUpList(List<PickedForYouData> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        this._pickUpList.setValue(datas);
    }

    public final StateFlow<List<ClassCollectionData>> getCollectionsList() {
        return this.collectionsList;
    }

    public final void updateCollectionsList(List<ClassCollectionData> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        this._collectionsList.setValue(datas);
    }
}
