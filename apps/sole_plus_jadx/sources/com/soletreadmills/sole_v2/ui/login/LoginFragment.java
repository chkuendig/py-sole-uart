package com.soletreadmills.sole_v2.ui.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.login.LoginEmailForm;
import com.soletreadmills.sole_v2._tools.UiTool;
import com.soletreadmills.sole_v2._type.user.RegisterType;
import com.soletreadmills.sole_v2.databinding.FragmentLoginBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.sun.jna.platform.win32.WinError;
import defpackage.isValidateEmail;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

/* compiled from: LoginFragment.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/login/LoginFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentLoginBinding;", "()V", "loginViewModel", "Lcom/soletreadmills/sole_v2/ui/login/LoginViewModel;", "getLoginViewModel", "()Lcom/soletreadmills/sole_v2/ui/login/LoginViewModel;", "loginViewModel$delegate", "Lkotlin/Lazy;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "submitLoginByEmail", "email", "", "password", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoginFragment extends BaseFragment<FragmentLoginBinding> {
    public static final int $stable = 8;

    /* renamed from: loginViewModel$delegate, reason: from kotlin metadata */
    private final Lazy loginViewModel;

    public LoginFragment() {
        final LoginFragment loginFragment = this;
        final Function0 function0 = null;
        this.loginViewModel = FragmentViewModelLazyKt.createViewModelLazy(loginFragment, Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.login.LoginFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = loginFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.login.LoginFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = loginFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.login.LoginFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = loginFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentLoginBinding access$getBinding(LoginFragment loginFragment) {
        return loginFragment.getBinding();
    }

    public final LoginViewModel getLoginViewModel() {
        return (LoginViewModel) this.loginViewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentLoginBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentLoginBinding fragmentLoginBindingInflate = FragmentLoginBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentLoginBindingInflate, "inflate(...)");
        return fragmentLoginBindingInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        Timber.INSTANCE.d("initViews", new Object[0]);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        EditText editText;
        EditText editText2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentLoginBinding binding = getBinding();
        TextView textView2 = binding != null ? binding.tvEmailAlertText : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        FragmentLoginBinding binding2 = getBinding();
        TextView textView3 = binding2 != null ? binding2.tvPasswordAlertText : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        FragmentLoginBinding binding3 = getBinding();
        ImageView imageView5 = binding3 != null ? binding3.imgEmailClear : null;
        if (imageView5 != null) {
            imageView5.setVisibility(8);
        }
        FragmentLoginBinding binding4 = getBinding();
        if (binding4 != null && (editText2 = binding4.edtEmail) != null) {
            editText2.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.login.LoginFragment.onViewCreated.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    LinearLayout linearLayout2;
                    final String string = StringsKt.trim((CharSequence) UiTool.toText$default(UiTool.INSTANCE, s, null, 2, null)).toString();
                    Timber.INSTANCE.d("new val: " + string, new Object[0]);
                    LoginFragment.this.getLoginViewModel().updateLoginEmailForm(new Function1<LoginEmailForm, LoginEmailForm>() { // from class: com.soletreadmills.sole_v2.ui.login.LoginFragment$onViewCreated$1$afterTextChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final LoginEmailForm invoke(LoginEmailForm it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return LoginEmailForm.copy$default(it, string, null, 2, null);
                        }
                    });
                    if (!Intrinsics.areEqual(string, "")) {
                        FragmentLoginBinding fragmentLoginBindingAccess$getBinding = LoginFragment.access$getBinding(LoginFragment.this);
                        ImageView imageView6 = fragmentLoginBindingAccess$getBinding != null ? fragmentLoginBindingAccess$getBinding.imgEmailClear : null;
                        if (imageView6 != null) {
                            imageView6.setVisibility(0);
                        }
                    } else {
                        FragmentLoginBinding fragmentLoginBindingAccess$getBinding2 = LoginFragment.access$getBinding(LoginFragment.this);
                        ImageView imageView7 = fragmentLoginBindingAccess$getBinding2 != null ? fragmentLoginBindingAccess$getBinding2.imgEmailClear : null;
                        if (imageView7 != null) {
                            imageView7.setVisibility(8);
                        }
                    }
                    FragmentLoginBinding fragmentLoginBindingAccess$getBinding3 = LoginFragment.access$getBinding(LoginFragment.this);
                    TextView textView4 = fragmentLoginBindingAccess$getBinding3 != null ? fragmentLoginBindingAccess$getBinding3.tvEmailAlertText : null;
                    if (textView4 != null) {
                        textView4.setText("");
                    }
                    FragmentLoginBinding fragmentLoginBindingAccess$getBinding4 = LoginFragment.access$getBinding(LoginFragment.this);
                    TextView textView5 = fragmentLoginBindingAccess$getBinding4 != null ? fragmentLoginBindingAccess$getBinding4.tvEmailAlertText : null;
                    if (textView5 != null) {
                        textView5.setVisibility(8);
                    }
                    FragmentLoginBinding fragmentLoginBindingAccess$getBinding5 = LoginFragment.access$getBinding(LoginFragment.this);
                    if (fragmentLoginBindingAccess$getBinding5 == null || (linearLayout2 = fragmentLoginBindingAccess$getBinding5.llEmail) == null) {
                        return;
                    }
                    linearLayout2.setBackgroundResource(R.drawable.bg_corner32_outline);
                }
            });
        }
        FragmentLoginBinding binding5 = getBinding();
        ImageView imageView6 = binding5 != null ? binding5.imgPasswordClear : null;
        if (imageView6 != null) {
            imageView6.setVisibility(8);
        }
        FragmentLoginBinding binding6 = getBinding();
        if (binding6 != null && (editText = binding6.edtPassword) != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.login.LoginFragment.onViewCreated.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    ImageView imageView7;
                    final String string = StringsKt.trim((CharSequence) UiTool.toText$default(UiTool.INSTANCE, s, null, 2, null)).toString();
                    Timber.INSTANCE.d("new val: " + string, new Object[0]);
                    LoginFragment.this.getLoginViewModel().updateLoginEmailForm(new Function1<LoginEmailForm, LoginEmailForm>() { // from class: com.soletreadmills.sole_v2.ui.login.LoginFragment$onViewCreated$2$afterTextChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final LoginEmailForm invoke(LoginEmailForm it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return LoginEmailForm.copy$default(it, null, string, 1, null);
                        }
                    });
                    if (!Intrinsics.areEqual(string, "")) {
                        FragmentLoginBinding fragmentLoginBindingAccess$getBinding = LoginFragment.access$getBinding(LoginFragment.this);
                        imageView7 = fragmentLoginBindingAccess$getBinding != null ? fragmentLoginBindingAccess$getBinding.imgPasswordClear : null;
                        if (imageView7 == null) {
                            return;
                        }
                        imageView7.setVisibility(0);
                        return;
                    }
                    FragmentLoginBinding fragmentLoginBindingAccess$getBinding2 = LoginFragment.access$getBinding(LoginFragment.this);
                    imageView7 = fragmentLoginBindingAccess$getBinding2 != null ? fragmentLoginBindingAccess$getBinding2.imgPasswordClear : null;
                    if (imageView7 == null) {
                        return;
                    }
                    imageView7.setVisibility(8);
                }
            });
        }
        FragmentLoginBinding binding7 = getBinding();
        if (binding7 != null && (imageView4 = binding7.imgEmailClear) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.login.LoginFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginFragment.onViewCreated$lambda$0(this.f$0, view2);
                }
            });
        }
        FragmentLoginBinding binding8 = getBinding();
        if (binding8 != null && (imageView3 = binding8.imgPasswordClear) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.login.LoginFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginFragment.onViewCreated$lambda$1(this.f$0, view2);
                }
            });
        }
        FragmentLoginBinding binding9 = getBinding();
        if (binding9 != null && (imageView2 = binding9.imgEye) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.login.LoginFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginFragment.onViewCreated$lambda$3(this.f$0, view2);
                }
            });
        }
        FragmentLoginBinding binding10 = getBinding();
        if (binding10 != null && (linearLayout = binding10.LLLogin) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.login.LoginFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginFragment.onViewCreated$lambda$4(this.f$0, view2);
                }
            });
        }
        FragmentLoginBinding binding11 = getBinding();
        if (binding11 != null && (textView = binding11.tvForgotPassword) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.login.LoginFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginFragment.onViewCreated$lambda$6(this.f$0, view2);
                }
            });
        }
        FragmentLoginBinding binding12 = getBinding();
        if (binding12 == null || (imageView = binding12.back) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.login.LoginFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginFragment.onViewCreated$lambda$7(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(LoginFragment this$0, View view) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentLoginBinding binding = this$0.getBinding();
        if (binding == null || (editText = binding.edtEmail) == null) {
            return;
        }
        editText.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(LoginFragment this$0, View view) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentLoginBinding binding = this$0.getBinding();
        if (binding == null || (editText = binding.edtPassword) == null) {
            return;
        }
        editText.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(LoginFragment this$0, View view) {
        EditText editText;
        ImageView imageView;
        EditText editText2;
        ImageView imageView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentLoginBinding binding = this$0.getBinding();
        if (binding != null && (editText2 = binding.edtPassword) != null && editText2.getInputType() == 144) {
            FragmentLoginBinding binding2 = this$0.getBinding();
            editText = binding2 != null ? binding2.edtPassword : null;
            if (editText != null) {
                editText.setInputType(129);
            }
            FragmentLoginBinding binding3 = this$0.getBinding();
            if (binding3 != null && (imageView2 = binding3.imgEye) != null) {
                imageView2.setImageResource(R.drawable.ic_m__eye_open);
            }
        } else {
            FragmentLoginBinding binding4 = this$0.getBinding();
            editText = binding4 != null ? binding4.edtPassword : null;
            if (editText != null) {
                editText.setInputType(144);
            }
            FragmentLoginBinding binding5 = this$0.getBinding();
            if (binding5 != null && (imageView = binding5.imgEye) != null) {
                imageView.setImageResource(R.drawable.ic_m__eye_closed);
            }
        }
        FragmentLoginBinding binding6 = this$0.getBinding();
        if (binding6 != null) {
            binding6.edtPassword.setSelection(binding6.edtPassword.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(LoginFragment this$0, View view) {
        TextView textView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideKeyboard();
        String email = this$0.getLoginViewModel().getEditLoginEmailForm().getValue().getEmail();
        String password = this$0.getLoginViewModel().getEditLoginEmailForm().getValue().getPassword();
        Timber.INSTANCE.d("Login: " + email + '/' + password, new Object[0]);
        if (!isValidateEmail.isValidateEmail(email)) {
            FragmentLoginBinding binding = this$0.getBinding();
            TextView textView2 = binding != null ? binding.tvEmailAlertText : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            FragmentLoginBinding binding2 = this$0.getBinding();
            if (binding2 != null && (linearLayout2 = binding2.llEmail) != null) {
                linearLayout2.setBackgroundResource(R.drawable.bg_corner32_outline_signal);
            }
            FragmentLoginBinding binding3 = this$0.getBinding();
            textView = binding3 != null ? binding3.tvEmailAlertText : null;
            if (textView == null) {
                return;
            }
            textView.setText(this$0.getString(R.string.err_email_format_error));
            return;
        }
        if (Intrinsics.areEqual(password, "")) {
            FragmentLoginBinding binding4 = this$0.getBinding();
            TextView textView3 = binding4 != null ? binding4.tvPasswordAlertText : null;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            FragmentLoginBinding binding5 = this$0.getBinding();
            if (binding5 != null && (linearLayout = binding5.LLPassword) != null) {
                linearLayout.setBackgroundResource(R.drawable.bg_corner32_outline_signal);
            }
            FragmentLoginBinding binding6 = this$0.getBinding();
            textView = binding6 != null ? binding6.tvPasswordAlertText : null;
            if (textView == null) {
                return;
            }
            textView.setText(this$0.getString(R.string.err_password_format_error));
            return;
        }
        this$0.submitLoginByEmail(email, password);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(LoginFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String email = this$0.getLoginViewModel().getEditLoginEmailForm().getValue().getEmail();
        if (email == null) {
            email = "";
        }
        Bundle bundle = new Bundle();
        bundle.putString("email", email);
        this$0.safeNavigate(R.id.resetPasswordFragment, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(LoginFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).navigateUp();
    }

    /* compiled from: LoginFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.login.LoginFragment$submitLoginByEmail$1", f = "LoginFragment.kt", i = {}, l = {197, WinError.ERROR_VIRUS_INFECTED}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.login.LoginFragment$submitLoginByEmail$1, reason: invalid class name and case insensitive filesystem */
    static final class C09861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $email;
        final /* synthetic */ String $password;
        final /* synthetic */ int $registerType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09861(int i, String str, String str2, Continuation<? super C09861> continuation) {
            super(2, continuation);
            this.$registerType = i;
            this.$email = str;
            this.$password = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LoginFragment.this.new C09861(this.$registerType, this.$email, this.$password, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x014f A[Catch: all -> 0x0035, Exception -> 0x0038, TryCatch #1 {Exception -> 0x0038, blocks: (B:6:0x0020, B:39:0x00f7, B:41:0x0101, B:43:0x0107, B:45:0x010d, B:46:0x0111, B:66:0x01a0, B:48:0x014f, B:51:0x0157, B:53:0x016d, B:55:0x0175, B:57:0x017b, B:59:0x0183, B:60:0x0187, B:62:0x018d, B:64:0x0195, B:65:0x0199, B:10:0x002f, B:20:0x0058, B:22:0x0076, B:24:0x007c, B:27:0x0088, B:30:0x0090, B:31:0x00a4, B:33:0x00ae, B:36:0x00dd, B:17:0x003e), top: B:76:0x001a, outer: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0154  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0157 A[Catch: all -> 0x0035, Exception -> 0x0038, TryCatch #1 {Exception -> 0x0038, blocks: (B:6:0x0020, B:39:0x00f7, B:41:0x0101, B:43:0x0107, B:45:0x010d, B:46:0x0111, B:66:0x01a0, B:48:0x014f, B:51:0x0157, B:53:0x016d, B:55:0x0175, B:57:0x017b, B:59:0x0183, B:60:0x0187, B:62:0x018d, B:64:0x0195, B:65:0x0199, B:10:0x002f, B:20:0x0058, B:22:0x0076, B:24:0x007c, B:27:0x0088, B:30:0x0090, B:31:0x00a4, B:33:0x00ae, B:36:0x00dd, B:17:0x003e), top: B:76:0x001a, outer: #0 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instructions count: 513
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.login.LoginFragment.C09861.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void submitLoginByEmail(String email, String password) {
        int id2 = RegisterType.Email.getId();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09861(id2, email, password, null), 3, null);
    }
}
