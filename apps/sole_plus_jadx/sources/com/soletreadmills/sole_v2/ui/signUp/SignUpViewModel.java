package com.soletreadmills.sole_v2.ui.signUp;

import com.soletreadmills.sole_v2._data.signUp.SignUpForm;
import com.soletreadmills.sole_v2.ui._base.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SignUpViewModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/signUp/SignUpViewModel;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseViewModel;", "()V", "_signUpForm", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/soletreadmills/sole_v2/_data/signUp/SignUpForm;", "editSignUpForm", "Lkotlinx/coroutines/flow/StateFlow;", "getEditSignUpForm", "()Lkotlinx/coroutines/flow/StateFlow;", "resetSignUpForm", "", "updateSignUpForm", "updateFunction", "Lkotlin/Function1;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SignUpViewModel extends BaseViewModel {
    public static final int $stable = 8;
    private MutableStateFlow<SignUpForm> _signUpForm;
    private final StateFlow<SignUpForm> editSignUpForm;

    public SignUpViewModel() {
        MutableStateFlow<SignUpForm> MutableStateFlow = StateFlowKt.MutableStateFlow(new SignUpForm(null, null, 3, null));
        this._signUpForm = MutableStateFlow;
        this.editSignUpForm = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<SignUpForm> getEditSignUpForm() {
        return this.editSignUpForm;
    }

    public final void updateSignUpForm(Function1<? super SignUpForm, SignUpForm> updateFunction) {
        Intrinsics.checkNotNullParameter(updateFunction, "updateFunction");
        this._signUpForm.setValue(updateFunction.invoke(this._signUpForm.getValue()));
    }

    public final void resetSignUpForm() {
        this._signUpForm.setValue(new SignUpForm(null, null, 3, null));
    }
}
