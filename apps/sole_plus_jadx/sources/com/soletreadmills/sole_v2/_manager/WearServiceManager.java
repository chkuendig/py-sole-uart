package com.soletreadmills.sole_v2._manager;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.listener.WearHRListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WearServiceManager.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/WearServiceManager;", "", "()V", "listenerArray", "", "Lcom/soletreadmills/sole_v2/listener/WearHRListener;", "getListenerArray", "()Ljava/util/List;", "setListenerArray", "(Ljava/util/List;)V", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WearServiceManager {
    public static final int $stable = 8;
    private List<WearHRListener> listenerArray = new ArrayList();

    public final List<WearHRListener> getListenerArray() {
        return this.listenerArray;
    }

    public final void setListenerArray(List<WearHRListener> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.listenerArray = list;
    }

    public final void addListener(WearHRListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listenerArray.add(listener);
    }

    public final void removeListener(WearHRListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listenerArray.remove(listener);
    }
}
