package com.soletreadmills.sole_v2.ui.settings;

import com.soletreadmills.sole_v2.ui._base.BaseViewModel;
import kotlin.Metadata;

/* compiled from: MyFavoritesViewModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/MyFavoritesViewModel;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseViewModel;", "()V", "selectClasses", "", "getSelectClasses", "()Z", "setSelectClasses", "(Z)V", "selectCollections", "getSelectCollections", "setSelectCollections", "selectPrograms", "getSelectPrograms", "setSelectPrograms", "reset", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyFavoritesViewModel extends BaseViewModel {
    public static final int $stable = 8;
    private boolean selectClasses;
    private boolean selectCollections;
    private boolean selectPrograms;

    public final boolean getSelectClasses() {
        return this.selectClasses;
    }

    public final void setSelectClasses(boolean z) {
        this.selectClasses = z;
    }

    public final boolean getSelectCollections() {
        return this.selectCollections;
    }

    public final void setSelectCollections(boolean z) {
        this.selectCollections = z;
    }

    public final boolean getSelectPrograms() {
        return this.selectPrograms;
    }

    public final void setSelectPrograms(boolean z) {
        this.selectPrograms = z;
    }

    public final void reset() {
        this.selectClasses = false;
        this.selectCollections = false;
        this.selectPrograms = false;
    }
}
