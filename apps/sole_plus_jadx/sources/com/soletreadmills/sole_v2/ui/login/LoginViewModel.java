package com.soletreadmills.sole_v2.ui.login;

import com.soletreadmills.sole_v2._data.login.LoginEmailForm;
import com.soletreadmills.sole_v2.ui._base.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: LoginViewModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/login/LoginViewModel;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseViewModel;", "()V", "_loginEmailForm", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/soletreadmills/sole_v2/_data/login/LoginEmailForm;", "editLoginEmailForm", "Lkotlinx/coroutines/flow/StateFlow;", "getEditLoginEmailForm", "()Lkotlinx/coroutines/flow/StateFlow;", "resetLoginEmailForm", "", "updateLoginEmailForm", "updateFunction", "Lkotlin/Function1;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoginViewModel extends BaseViewModel {
    public static final int $stable = 8;
    private MutableStateFlow<LoginEmailForm> _loginEmailForm;
    private final StateFlow<LoginEmailForm> editLoginEmailForm;

    public LoginViewModel() {
        MutableStateFlow<LoginEmailForm> MutableStateFlow = StateFlowKt.MutableStateFlow(new LoginEmailForm(null, null, 3, null));
        this._loginEmailForm = MutableStateFlow;
        this.editLoginEmailForm = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<LoginEmailForm> getEditLoginEmailForm() {
        return this.editLoginEmailForm;
    }

    public final void updateLoginEmailForm(Function1<? super LoginEmailForm, LoginEmailForm> updateFunction) {
        Intrinsics.checkNotNullParameter(updateFunction, "updateFunction");
        this._loginEmailForm.setValue(updateFunction.invoke(this._loginEmailForm.getValue()));
    }

    public final void resetLoginEmailForm() {
        this._loginEmailForm.setValue(new LoginEmailForm(null, null, 3, null));
    }
}
