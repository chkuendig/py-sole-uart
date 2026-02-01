package com.soletreadmills.sole_v2.ui._shared;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.soletreadmills.sole_v2._data.api.banner.BannerApiData;
import kotlin.Metadata;

/* compiled from: UiStateViewModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_shared/UiStateViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "bannerData", "Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$BannerResult;", "getBannerData", "()Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$BannerResult;", "setBannerData", "(Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$BannerResult;)V", "errorMessage", "Landroidx/lifecycle/MutableLiveData;", "", "getErrorMessage", "()Landroidx/lifecycle/MutableLiveData;", "loadingState", "", "getLoadingState", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UiStateViewModel extends ViewModel {
    public static final int $stable = 8;
    private BannerApiData.BannerResult bannerData;
    private final MutableLiveData<Boolean> loadingState = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public final MutableLiveData<Boolean> getLoadingState() {
        return this.loadingState;
    }

    public final MutableLiveData<String> getErrorMessage() {
        return this.errorMessage;
    }

    public final BannerApiData.BannerResult getBannerData() {
        return this.bannerData;
    }

    public final void setBannerData(BannerApiData.BannerResult bannerResult) {
        this.bannerData = bannerResult;
    }
}
