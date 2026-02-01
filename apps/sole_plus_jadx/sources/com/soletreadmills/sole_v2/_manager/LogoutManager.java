package com.soletreadmills.sole_v2._manager;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import timber.log.Timber;

/* compiled from: LogoutManager.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/LogoutManager;", "", "()V", "_logoutEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "isNavigatingToLogin", "Ljava/util/concurrent/atomic/AtomicBoolean;", "logoutEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getLogoutEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "onNavigatedToLogin", "triggerLogout", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LogoutManager {
    public static final int $stable;
    public static final LogoutManager INSTANCE = new LogoutManager();
    private static final MutableSharedFlow<Unit> _logoutEvent;
    private static final AtomicBoolean isNavigatingToLogin;
    private static final SharedFlow<Unit> logoutEvent;

    private LogoutManager() {
    }

    static {
        MutableSharedFlow<Unit> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST);
        _logoutEvent = MutableSharedFlow;
        logoutEvent = FlowKt.asSharedFlow(MutableSharedFlow);
        isNavigatingToLogin = new AtomicBoolean(false);
        $stable = 8;
    }

    public final SharedFlow<Unit> getLogoutEvent() {
        return logoutEvent;
    }

    public final void triggerLogout() {
        if (isNavigatingToLogin.compareAndSet(false, true)) {
            Timber.INSTANCE.d("AuthManager: 觸發登出事件", new Object[0]);
            _logoutEvent.tryEmit(Unit.INSTANCE);
        } else {
            Timber.INSTANCE.d("AuthManager: 已在導航至登入頁，忽略重複觸發", new Object[0]);
        }
    }

    public final void onNavigatedToLogin() {
        isNavigatingToLogin.set(false);
        Timber.INSTANCE.d("AuthManager: 已導航至登入頁，重置標記", new Object[0]);
    }
}
