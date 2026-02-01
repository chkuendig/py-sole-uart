package com.soletreadmills.sole_v2.ui.signUp;

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
import com.soletreadmills.sole_v2._data.signUp.SignUpForm;
import com.soletreadmills.sole_v2._tools.UiTool;
import com.soletreadmills.sole_v2._type.user.RegisterType;
import com.soletreadmills.sole_v2.databinding.FragmentSignUpBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import defpackage.isValidateEmail;
import defpackage.isValidatePassword;
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

/* compiled from: SignUpFragment.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/signUp/SignUpFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentSignUpBinding;", "()V", "signUpViewModel", "Lcom/soletreadmills/sole_v2/ui/signUp/SignUpViewModel;", "getSignUpViewModel", "()Lcom/soletreadmills/sole_v2/ui/signUp/SignUpViewModel;", "signUpViewModel$delegate", "Lkotlin/Lazy;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "submitSignUp", "email", "", "password", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SignUpFragment extends BaseFragment<FragmentSignUpBinding> {
    public static final int $stable = 8;

    /* renamed from: signUpViewModel$delegate, reason: from kotlin metadata */
    private final Lazy signUpViewModel;

    public SignUpFragment() {
        final SignUpFragment signUpFragment = this;
        final Function0 function0 = null;
        this.signUpViewModel = FragmentViewModelLazyKt.createViewModelLazy(signUpFragment, Reflection.getOrCreateKotlinClass(SignUpViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = signUpFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = signUpFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = signUpFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentSignUpBinding access$getBinding(SignUpFragment signUpFragment) {
        return signUpFragment.getBinding();
    }

    public final SignUpViewModel getSignUpViewModel() {
        return (SignUpViewModel) this.signUpViewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentSignUpBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentSignUpBinding fragmentSignUpBindingInflate = FragmentSignUpBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentSignUpBindingInflate, "inflate(...)");
        return fragmentSignUpBindingInflate;
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
        LinearLayout linearLayout;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        EditText editText;
        EditText editText2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentSignUpBinding binding = getBinding();
        if (binding != null) {
            TextView tvTerms = binding.tvTerms;
            Intrinsics.checkNotNullExpressionValue(tvTerms, "tvTerms");
            setupTermsText(tvTerms);
        }
        FragmentSignUpBinding binding2 = getBinding();
        TextView textView = binding2 != null ? binding2.tvEmailAlertText : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        FragmentSignUpBinding binding3 = getBinding();
        ImageView imageView5 = binding3 != null ? binding3.imgEmailClear : null;
        if (imageView5 != null) {
            imageView5.setVisibility(8);
        }
        FragmentSignUpBinding binding4 = getBinding();
        if (binding4 != null && (editText2 = binding4.edtEmail) != null) {
            editText2.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment.onViewCreated.2
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
                    SignUpFragment.this.getSignUpViewModel().updateSignUpForm(new Function1<SignUpForm, SignUpForm>() { // from class: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment$onViewCreated$2$afterTextChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final SignUpForm invoke(SignUpForm it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return SignUpForm.copy$default(it, string, null, 2, null);
                        }
                    });
                    if (!Intrinsics.areEqual(string, "")) {
                        FragmentSignUpBinding fragmentSignUpBindingAccess$getBinding = SignUpFragment.access$getBinding(SignUpFragment.this);
                        ImageView imageView6 = fragmentSignUpBindingAccess$getBinding != null ? fragmentSignUpBindingAccess$getBinding.imgEmailClear : null;
                        if (imageView6 != null) {
                            imageView6.setVisibility(0);
                        }
                    } else {
                        FragmentSignUpBinding fragmentSignUpBindingAccess$getBinding2 = SignUpFragment.access$getBinding(SignUpFragment.this);
                        ImageView imageView7 = fragmentSignUpBindingAccess$getBinding2 != null ? fragmentSignUpBindingAccess$getBinding2.imgEmailClear : null;
                        if (imageView7 != null) {
                            imageView7.setVisibility(8);
                        }
                    }
                    FragmentSignUpBinding fragmentSignUpBindingAccess$getBinding3 = SignUpFragment.access$getBinding(SignUpFragment.this);
                    TextView textView2 = fragmentSignUpBindingAccess$getBinding3 != null ? fragmentSignUpBindingAccess$getBinding3.tvEmailAlertText : null;
                    if (textView2 != null) {
                        textView2.setText("");
                    }
                    FragmentSignUpBinding fragmentSignUpBindingAccess$getBinding4 = SignUpFragment.access$getBinding(SignUpFragment.this);
                    TextView textView3 = fragmentSignUpBindingAccess$getBinding4 != null ? fragmentSignUpBindingAccess$getBinding4.tvEmailAlertText : null;
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                    FragmentSignUpBinding fragmentSignUpBindingAccess$getBinding5 = SignUpFragment.access$getBinding(SignUpFragment.this);
                    if (fragmentSignUpBindingAccess$getBinding5 == null || (linearLayout2 = fragmentSignUpBindingAccess$getBinding5.LLEmail) == null) {
                        return;
                    }
                    linearLayout2.setBackgroundResource(R.drawable.bg_corner32_outline);
                }
            });
        }
        FragmentSignUpBinding binding5 = getBinding();
        TextView textView2 = binding5 != null ? binding5.tvPasswordAlertText : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        FragmentSignUpBinding binding6 = getBinding();
        ImageView imageView6 = binding6 != null ? binding6.imgPasswordClear : null;
        if (imageView6 != null) {
            imageView6.setVisibility(8);
        }
        FragmentSignUpBinding binding7 = getBinding();
        if (binding7 != null && (editText = binding7.edtPassword) != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment.onViewCreated.3
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
                    SignUpFragment.this.getSignUpViewModel().updateSignUpForm(new Function1<SignUpForm, SignUpForm>() { // from class: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment$onViewCreated$3$afterTextChanged$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final SignUpForm invoke(SignUpForm it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return SignUpForm.copy$default(it, null, string, 1, null);
                        }
                    });
                    if (!Intrinsics.areEqual(string, "")) {
                        FragmentSignUpBinding fragmentSignUpBindingAccess$getBinding = SignUpFragment.access$getBinding(SignUpFragment.this);
                        ImageView imageView7 = fragmentSignUpBindingAccess$getBinding != null ? fragmentSignUpBindingAccess$getBinding.imgPasswordClear : null;
                        if (imageView7 != null) {
                            imageView7.setVisibility(0);
                        }
                    } else {
                        FragmentSignUpBinding fragmentSignUpBindingAccess$getBinding2 = SignUpFragment.access$getBinding(SignUpFragment.this);
                        ImageView imageView8 = fragmentSignUpBindingAccess$getBinding2 != null ? fragmentSignUpBindingAccess$getBinding2.imgPasswordClear : null;
                        if (imageView8 != null) {
                            imageView8.setVisibility(8);
                        }
                    }
                    FragmentSignUpBinding fragmentSignUpBindingAccess$getBinding3 = SignUpFragment.access$getBinding(SignUpFragment.this);
                    TextView textView3 = fragmentSignUpBindingAccess$getBinding3 != null ? fragmentSignUpBindingAccess$getBinding3.tvPasswordAlertText : null;
                    if (textView3 != null) {
                        textView3.setText("");
                    }
                    FragmentSignUpBinding fragmentSignUpBindingAccess$getBinding4 = SignUpFragment.access$getBinding(SignUpFragment.this);
                    TextView textView4 = fragmentSignUpBindingAccess$getBinding4 != null ? fragmentSignUpBindingAccess$getBinding4.tvPasswordAlertText : null;
                    if (textView4 != null) {
                        textView4.setVisibility(8);
                    }
                    FragmentSignUpBinding fragmentSignUpBindingAccess$getBinding5 = SignUpFragment.access$getBinding(SignUpFragment.this);
                    if (fragmentSignUpBindingAccess$getBinding5 == null || (linearLayout2 = fragmentSignUpBindingAccess$getBinding5.LLPassword) == null) {
                        return;
                    }
                    linearLayout2.setBackgroundResource(R.drawable.bg_corner32_outline);
                }
            });
        }
        FragmentSignUpBinding binding8 = getBinding();
        if (binding8 != null && (imageView4 = binding8.imgEmailClear) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SignUpFragment.onViewCreated$lambda$1(this.f$0, view2);
                }
            });
        }
        FragmentSignUpBinding binding9 = getBinding();
        if (binding9 != null && (imageView3 = binding9.imgPasswordClear) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SignUpFragment.onViewCreated$lambda$2(this.f$0, view2);
                }
            });
        }
        FragmentSignUpBinding binding10 = getBinding();
        if (binding10 != null && (imageView2 = binding10.imgEye) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SignUpFragment.onViewCreated$lambda$4(this.f$0, view2);
                }
            });
        }
        FragmentSignUpBinding binding11 = getBinding();
        if (binding11 != null && (linearLayout = binding11.LLSignUpWithEmail) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SignUpFragment.onViewCreated$lambda$5(this.f$0, view2);
                }
            });
        }
        FragmentSignUpBinding binding12 = getBinding();
        if (binding12 == null || (imageView = binding12.back) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SignUpFragment.onViewCreated$lambda$6(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(SignUpFragment this$0, View view) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentSignUpBinding binding = this$0.getBinding();
        if (binding == null || (editText = binding.edtEmail) == null) {
            return;
        }
        editText.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(SignUpFragment this$0, View view) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentSignUpBinding binding = this$0.getBinding();
        if (binding == null || (editText = binding.edtPassword) == null) {
            return;
        }
        editText.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(SignUpFragment this$0, View view) {
        EditText editText;
        ImageView imageView;
        FragmentSignUpBinding binding;
        EditText editText2;
        EditText editText3;
        ImageView imageView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentSignUpBinding binding2 = this$0.getBinding();
        if (binding2 != null && (editText3 = binding2.edtPassword) != null && editText3.getInputType() == 144) {
            FragmentSignUpBinding binding3 = this$0.getBinding();
            editText = binding3 != null ? binding3.edtPassword : null;
            if (editText != null) {
                editText.setInputType(129);
            }
            FragmentSignUpBinding binding4 = this$0.getBinding();
            if (binding4 != null && (imageView2 = binding4.imgEye) != null) {
                imageView2.setImageResource(R.drawable.ic_m__eye_open);
            }
        } else {
            FragmentSignUpBinding binding5 = this$0.getBinding();
            editText = binding5 != null ? binding5.edtPassword : null;
            if (editText != null) {
                editText.setInputType(144);
            }
            FragmentSignUpBinding binding6 = this$0.getBinding();
            if (binding6 != null && (imageView = binding6.imgEye) != null) {
                imageView.setImageResource(R.drawable.ic_m__eye_closed);
            }
        }
        FragmentSignUpBinding binding7 = this$0.getBinding();
        if (binding7 == null || (binding = this$0.getBinding()) == null || (editText2 = binding.edtPassword) == null) {
            return;
        }
        editText2.setSelection(binding7.edtPassword.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(SignUpFragment this$0, View view) {
        TextView textView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideKeyboard();
        String email = this$0.getSignUpViewModel().getEditSignUpForm().getValue().getEmail();
        String password = this$0.getSignUpViewModel().getEditSignUpForm().getValue().getPassword();
        Timber.INSTANCE.d("Submit: " + email + " / " + password, new Object[0]);
        if (!isValidateEmail.isValidateEmail(email)) {
            FragmentSignUpBinding binding = this$0.getBinding();
            TextView textView2 = binding != null ? binding.tvEmailAlertText : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            FragmentSignUpBinding binding2 = this$0.getBinding();
            if (binding2 != null && (linearLayout2 = binding2.LLEmail) != null) {
                linearLayout2.setBackgroundResource(R.drawable.bg_corner32_outline_signal);
            }
            FragmentSignUpBinding binding3 = this$0.getBinding();
            textView = binding3 != null ? binding3.tvEmailAlertText : null;
            if (textView == null) {
                return;
            }
            textView.setText(this$0.getString(R.string.err_email_format_error));
            return;
        }
        if (!isValidatePassword.isValidatePassword(password)) {
            FragmentSignUpBinding binding4 = this$0.getBinding();
            TextView textView3 = binding4 != null ? binding4.tvPasswordAlertText : null;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            FragmentSignUpBinding binding5 = this$0.getBinding();
            if (binding5 != null && (linearLayout = binding5.LLPassword) != null) {
                linearLayout.setBackgroundResource(R.drawable.bg_corner32_outline_signal);
            }
            FragmentSignUpBinding binding6 = this$0.getBinding();
            textView = binding6 != null ? binding6.tvPasswordAlertText : null;
            if (textView == null) {
                return;
            }
            textView.setText(this$0.getString(R.string.err_password_format_error));
            return;
        }
        this$0.submitSignUp(email, password);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(SignUpFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).navigateUp();
        this$0.getSignUpViewModel().resetSignUpForm();
    }

    private final void submitSignUp(String email, String password) {
        Timber.INSTANCE.d("submitSignUp: " + email + " / " + password, new Object[0]);
        int id2 = RegisterType.Email.getId();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(id2, email, password, null), 3, null);
    }

    /* compiled from: SignUpFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.signUp.SignUpFragment$submitSignUp$1", f = "SignUpFragment.kt", i = {}, l = {192, 227, 264}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment$submitSignUp$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $email;
        final /* synthetic */ String $password;
        final /* synthetic */ int $registerType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$registerType = i;
            this.$email = str;
            this.$password = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignUpFragment.this.new AnonymousClass1(this.$registerType, this.$email, this.$password, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00b6 A[Catch: all -> 0x0045, IOException -> 0x0048, TryCatch #0 {IOException -> 0x0048, blocks: (B:7:0x0029, B:77:0x022a, B:79:0x0261, B:81:0x0268, B:83:0x0297, B:85:0x029e, B:87:0x02a6, B:88:0x02aa, B:90:0x02ff, B:91:0x031a, B:93:0x0324, B:95:0x032b, B:11:0x0038, B:54:0x014f, B:56:0x0159, B:58:0x0160, B:60:0x0166, B:62:0x016c, B:74:0x01f6, B:64:0x01aa, B:67:0x01b2, B:70:0x01ba, B:72:0x01e6, B:73:0x01ea, B:12:0x003f, B:22:0x0068, B:24:0x0086, B:26:0x008c, B:29:0x0098, B:31:0x009e, B:34:0x00ab, B:39:0x00b6, B:42:0x00be, B:44:0x00d5, B:47:0x00e1, B:50:0x0113, B:51:0x0137, B:19:0x0053), top: B:105:0x0021, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00be A[Catch: all -> 0x0045, IOException -> 0x0048, TryCatch #0 {IOException -> 0x0048, blocks: (B:7:0x0029, B:77:0x022a, B:79:0x0261, B:81:0x0268, B:83:0x0297, B:85:0x029e, B:87:0x02a6, B:88:0x02aa, B:90:0x02ff, B:91:0x031a, B:93:0x0324, B:95:0x032b, B:11:0x0038, B:54:0x014f, B:56:0x0159, B:58:0x0160, B:60:0x0166, B:62:0x016c, B:74:0x01f6, B:64:0x01aa, B:67:0x01b2, B:70:0x01ba, B:72:0x01e6, B:73:0x01ea, B:12:0x003f, B:22:0x0068, B:24:0x0086, B:26:0x008c, B:29:0x0098, B:31:0x009e, B:34:0x00ab, B:39:0x00b6, B:42:0x00be, B:44:0x00d5, B:47:0x00e1, B:50:0x0113, B:51:0x0137, B:19:0x0053), top: B:105:0x0021, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00d4  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0137 A[Catch: all -> 0x0045, IOException -> 0x0048, TryCatch #0 {IOException -> 0x0048, blocks: (B:7:0x0029, B:77:0x022a, B:79:0x0261, B:81:0x0268, B:83:0x0297, B:85:0x029e, B:87:0x02a6, B:88:0x02aa, B:90:0x02ff, B:91:0x031a, B:93:0x0324, B:95:0x032b, B:11:0x0038, B:54:0x014f, B:56:0x0159, B:58:0x0160, B:60:0x0166, B:62:0x016c, B:74:0x01f6, B:64:0x01aa, B:67:0x01b2, B:70:0x01ba, B:72:0x01e6, B:73:0x01ea, B:12:0x003f, B:22:0x0068, B:24:0x0086, B:26:0x008c, B:29:0x0098, B:31:0x009e, B:34:0x00ab, B:39:0x00b6, B:42:0x00be, B:44:0x00d5, B:47:0x00e1, B:50:0x0113, B:51:0x0137, B:19:0x0053), top: B:105:0x0021, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x01aa A[Catch: all -> 0x0045, IOException -> 0x0048, TryCatch #0 {IOException -> 0x0048, blocks: (B:7:0x0029, B:77:0x022a, B:79:0x0261, B:81:0x0268, B:83:0x0297, B:85:0x029e, B:87:0x02a6, B:88:0x02aa, B:90:0x02ff, B:91:0x031a, B:93:0x0324, B:95:0x032b, B:11:0x0038, B:54:0x014f, B:56:0x0159, B:58:0x0160, B:60:0x0166, B:62:0x016c, B:74:0x01f6, B:64:0x01aa, B:67:0x01b2, B:70:0x01ba, B:72:0x01e6, B:73:0x01ea, B:12:0x003f, B:22:0x0068, B:24:0x0086, B:26:0x008c, B:29:0x0098, B:31:0x009e, B:34:0x00ab, B:39:0x00b6, B:42:0x00be, B:44:0x00d5, B:47:0x00e1, B:50:0x0113, B:51:0x0137, B:19:0x0053), top: B:105:0x0021, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x01af  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01b2 A[Catch: all -> 0x0045, IOException -> 0x0048, TryCatch #0 {IOException -> 0x0048, blocks: (B:7:0x0029, B:77:0x022a, B:79:0x0261, B:81:0x0268, B:83:0x0297, B:85:0x029e, B:87:0x02a6, B:88:0x02aa, B:90:0x02ff, B:91:0x031a, B:93:0x0324, B:95:0x032b, B:11:0x0038, B:54:0x014f, B:56:0x0159, B:58:0x0160, B:60:0x0166, B:62:0x016c, B:74:0x01f6, B:64:0x01aa, B:67:0x01b2, B:70:0x01ba, B:72:0x01e6, B:73:0x01ea, B:12:0x003f, B:22:0x0068, B:24:0x0086, B:26:0x008c, B:29:0x0098, B:31:0x009e, B:34:0x00ab, B:39:0x00b6, B:42:0x00be, B:44:0x00d5, B:47:0x00e1, B:50:0x0113, B:51:0x0137, B:19:0x0053), top: B:105:0x0021, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x01b7  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x01ba A[Catch: all -> 0x0045, IOException -> 0x0048, TryCatch #0 {IOException -> 0x0048, blocks: (B:7:0x0029, B:77:0x022a, B:79:0x0261, B:81:0x0268, B:83:0x0297, B:85:0x029e, B:87:0x02a6, B:88:0x02aa, B:90:0x02ff, B:91:0x031a, B:93:0x0324, B:95:0x032b, B:11:0x0038, B:54:0x014f, B:56:0x0159, B:58:0x0160, B:60:0x0166, B:62:0x016c, B:74:0x01f6, B:64:0x01aa, B:67:0x01b2, B:70:0x01ba, B:72:0x01e6, B:73:0x01ea, B:12:0x003f, B:22:0x0068, B:24:0x0086, B:26:0x008c, B:29:0x0098, B:31:0x009e, B:34:0x00ab, B:39:0x00b6, B:42:0x00be, B:44:0x00d5, B:47:0x00e1, B:50:0x0113, B:51:0x0137, B:19:0x0053), top: B:105:0x0021, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0229 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0261 A[Catch: all -> 0x0045, IOException -> 0x0048, TryCatch #0 {IOException -> 0x0048, blocks: (B:7:0x0029, B:77:0x022a, B:79:0x0261, B:81:0x0268, B:83:0x0297, B:85:0x029e, B:87:0x02a6, B:88:0x02aa, B:90:0x02ff, B:91:0x031a, B:93:0x0324, B:95:0x032b, B:11:0x0038, B:54:0x014f, B:56:0x0159, B:58:0x0160, B:60:0x0166, B:62:0x016c, B:74:0x01f6, B:64:0x01aa, B:67:0x01b2, B:70:0x01ba, B:72:0x01e6, B:73:0x01ea, B:12:0x003f, B:22:0x0068, B:24:0x0086, B:26:0x008c, B:29:0x0098, B:31:0x009e, B:34:0x00ab, B:39:0x00b6, B:42:0x00be, B:44:0x00d5, B:47:0x00e1, B:50:0x0113, B:51:0x0137, B:19:0x0053), top: B:105:0x0021, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0297 A[Catch: all -> 0x0045, IOException -> 0x0048, TryCatch #0 {IOException -> 0x0048, blocks: (B:7:0x0029, B:77:0x022a, B:79:0x0261, B:81:0x0268, B:83:0x0297, B:85:0x029e, B:87:0x02a6, B:88:0x02aa, B:90:0x02ff, B:91:0x031a, B:93:0x0324, B:95:0x032b, B:11:0x0038, B:54:0x014f, B:56:0x0159, B:58:0x0160, B:60:0x0166, B:62:0x016c, B:74:0x01f6, B:64:0x01aa, B:67:0x01b2, B:70:0x01ba, B:72:0x01e6, B:73:0x01ea, B:12:0x003f, B:22:0x0068, B:24:0x0086, B:26:0x008c, B:29:0x0098, B:31:0x009e, B:34:0x00ab, B:39:0x00b6, B:42:0x00be, B:44:0x00d5, B:47:0x00e1, B:50:0x0113, B:51:0x0137, B:19:0x0053), top: B:105:0x0021, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:84:0x029d  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x02a6 A[Catch: all -> 0x0045, IOException -> 0x0048, TryCatch #0 {IOException -> 0x0048, blocks: (B:7:0x0029, B:77:0x022a, B:79:0x0261, B:81:0x0268, B:83:0x0297, B:85:0x029e, B:87:0x02a6, B:88:0x02aa, B:90:0x02ff, B:91:0x031a, B:93:0x0324, B:95:0x032b, B:11:0x0038, B:54:0x014f, B:56:0x0159, B:58:0x0160, B:60:0x0166, B:62:0x016c, B:74:0x01f6, B:64:0x01aa, B:67:0x01b2, B:70:0x01ba, B:72:0x01e6, B:73:0x01ea, B:12:0x003f, B:22:0x0068, B:24:0x0086, B:26:0x008c, B:29:0x0098, B:31:0x009e, B:34:0x00ab, B:39:0x00b6, B:42:0x00be, B:44:0x00d5, B:47:0x00e1, B:50:0x0113, B:51:0x0137, B:19:0x0053), top: B:105:0x0021, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x02aa A[Catch: all -> 0x0045, IOException -> 0x0048, TryCatch #0 {IOException -> 0x0048, blocks: (B:7:0x0029, B:77:0x022a, B:79:0x0261, B:81:0x0268, B:83:0x0297, B:85:0x029e, B:87:0x02a6, B:88:0x02aa, B:90:0x02ff, B:91:0x031a, B:93:0x0324, B:95:0x032b, B:11:0x0038, B:54:0x014f, B:56:0x0159, B:58:0x0160, B:60:0x0166, B:62:0x016c, B:74:0x01f6, B:64:0x01aa, B:67:0x01b2, B:70:0x01ba, B:72:0x01e6, B:73:0x01ea, B:12:0x003f, B:22:0x0068, B:24:0x0086, B:26:0x008c, B:29:0x0098, B:31:0x009e, B:34:0x00ab, B:39:0x00b6, B:42:0x00be, B:44:0x00d5, B:47:0x00e1, B:50:0x0113, B:51:0x0137, B:19:0x0053), top: B:105:0x0021, outer: #1 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r31) {
            /*
                Method dump skipped, instructions count: 863
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.signUp.SignUpFragment.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
