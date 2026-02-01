package com.soletreadmills.sole_v2.ui.signUp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.signUp.SignUpForm;
import com.soletreadmills.sole_v2.databinding.FragmentVerifyEmailBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbConst;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

/* compiled from: VerifyEmailFragment.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0017H\u0002J\b\u0010!\u001a\u00020\u0014H\u0016J\u001a\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0014H\u0002J\b\u0010(\u001a\u00020\u0014H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\tH\u0002J\b\u0010+\u001a\u00020\u0014H\u0002J\b\u0010,\u001a\u00020\u0014H\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0017H\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/signUp/VerifyEmailFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentVerifyEmailBinding;", "()V", "etDigits", "", "Landroid/widget/EditText;", "[Landroid/widget/EditText;", "isLoading", "", "isTimberRunning", "signUpViewModel", "Lcom/soletreadmills/sole_v2/ui/signUp/SignUpViewModel;", "getSignUpViewModel", "()Lcom/soletreadmills/sole_v2/ui/signUp/SignUpViewModel;", "signUpViewModel$delegate", "Lkotlin/Lazy;", "timer", "Landroid/os/CountDownTimer;", "clearInput", "", "deleteDigit", "getPassCode", "", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initOtpInput", "initViews", "inputDigit", "digit", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "resentVerifyCode", "sendCodeAndStartTimer", "setCountTimerView", "isStart", "setupCustomKeyboard", "submitEventId", "submitVerifyCode", "passCode", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyEmailFragment extends BaseFragment<FragmentVerifyEmailBinding> {
    public static final int $stable = 8;
    private EditText[] etDigits;
    private boolean isLoading;
    private boolean isTimberRunning;

    /* renamed from: signUpViewModel$delegate, reason: from kotlin metadata */
    private final Lazy signUpViewModel;
    private CountDownTimer timer;

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
    }

    public VerifyEmailFragment() {
        final VerifyEmailFragment verifyEmailFragment = this;
        final Function0 function0 = null;
        this.signUpViewModel = FragmentViewModelLazyKt.createViewModelLazy(verifyEmailFragment, Reflection.getOrCreateKotlinClass(SignUpViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = verifyEmailFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = verifyEmailFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = verifyEmailFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public final SignUpViewModel getSignUpViewModel() {
        return (SignUpViewModel) this.signUpViewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentVerifyEmailBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentVerifyEmailBinding fragmentVerifyEmailBindingInflate = FragmentVerifyEmailBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentVerifyEmailBindingInflate, "inflate(...)");
        return fragmentVerifyEmailBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView imageView;
        TextView textView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initOtpInput();
        Bundle arguments = getArguments();
        final String string = arguments != null ? arguments.getString("email") : null;
        Bundle arguments2 = getArguments();
        Boolean boolValueOf = arguments2 != null ? Boolean.valueOf(arguments2.getBoolean("isNeedSendEmail")) : null;
        if (string != null) {
            FragmentVerifyEmailBinding binding = getBinding();
            TextView textView2 = binding != null ? binding.email : null;
            if (textView2 != null) {
                textView2.setText(string);
            }
            getSignUpViewModel().updateSignUpForm(new Function1<SignUpForm, SignUpForm>() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment.onViewCreated.1
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
            Timber.INSTANCE.d("signUpViewModel:" + getSignUpViewModel().getEditSignUpForm().getValue(), new Object[0]);
            if (Intrinsics.areEqual((Object) boolValueOf, (Object) true)) {
                sendCodeAndStartTimer();
            }
        } else {
            Timber.INSTANCE.e("換頁時沒有傳到email args", new Object[0]);
        }
        FragmentVerifyEmailBinding binding2 = getBinding();
        if (binding2 != null && (textView = binding2.resendCode) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    VerifyEmailFragment.onViewCreated$lambda$0(this.f$0, view2);
                }
            });
        }
        FragmentVerifyEmailBinding binding3 = getBinding();
        if (binding3 == null || (imageView = binding3.back) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VerifyEmailFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendCodeAndStartTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideKeyboard();
        this$0.safeNavigateUp();
        this$0.initOtpInput();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
        this.isTimberRunning = false;
        Timber.INSTANCE.d("Timer cancelled in onDestroyView", new Object[0]);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$sendCodeAndStartTimer$1] */
    private final void sendCodeAndStartTimer() {
        FragmentVerifyEmailBinding binding = getBinding();
        final TextView textView = binding != null ? binding.resendCodeDelayCount : null;
        if (this.isTimberRunning) {
            return;
        }
        resentVerifyCode();
        this.isTimberRunning = true;
        setCountTimerView(true);
        this.timer = new CountDownTimer() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment.sendCodeAndStartTimer.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(60000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                String str = "(" + (millisUntilFinished / 1000) + ')';
                TextView textView2 = textView;
                if (textView2 == null) {
                    return;
                }
                textView2.setText(str);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.setCountTimerView(false);
                this.isTimberRunning = false;
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCountTimerView(boolean isStart) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        if (isStart) {
            FragmentVerifyEmailBinding binding = getBinding();
            if (binding != null && (textView3 = binding.resendCode) != null) {
                textView3.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorLabel_label4));
            }
            FragmentVerifyEmailBinding binding2 = getBinding();
            textView = binding2 != null ? binding2.resendCodeDelayCount : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        FragmentVerifyEmailBinding binding3 = getBinding();
        if (binding3 != null && (textView2 = binding3.resendCode) != null) {
            textView2.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPalette_red));
        }
        FragmentVerifyEmailBinding binding4 = getBinding();
        textView = binding4 != null ? binding4.resendCodeDelayCount : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    private final void initOtpInput() {
        FragmentVerifyEmailBinding binding = getBinding();
        if (binding != null) {
            EditText edt1 = binding.edt1;
            Intrinsics.checkNotNullExpressionValue(edt1, "edt1");
            EditText edt2 = binding.edt2;
            Intrinsics.checkNotNullExpressionValue(edt2, "edt2");
            EditText edt3 = binding.edt3;
            Intrinsics.checkNotNullExpressionValue(edt3, "edt3");
            EditText edt4 = binding.edt4;
            Intrinsics.checkNotNullExpressionValue(edt4, "edt4");
            EditText edt5 = binding.edt5;
            Intrinsics.checkNotNullExpressionValue(edt5, "edt5");
            EditText edt6 = binding.edt6;
            Intrinsics.checkNotNullExpressionValue(edt6, "edt6");
            this.etDigits = new EditText[]{edt1, edt2, edt3, edt4, edt5, edt6};
        }
        EditText[] editTextArr = this.etDigits;
        EditText[] editTextArr2 = null;
        if (editTextArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
            editTextArr = null;
        }
        int length = editTextArr.length;
        int i = 0;
        final int i2 = 0;
        while (i < length) {
            final EditText editText = editTextArr[i];
            editText.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$initOtpInput$2$1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    String strValueOf = String.valueOf(s);
                    EditText[] editTextArr3 = null;
                    if (strValueOf.length() > 0) {
                        editText.setBackground(null);
                    } else {
                        editText.setBackgroundResource(R.drawable.ic_field_digit);
                    }
                    if (strValueOf.length() == 1) {
                        int i3 = i2;
                        EditText[] editTextArr4 = this.etDigits;
                        if (editTextArr4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                            editTextArr4 = null;
                        }
                        if (i3 < editTextArr4.length - 1) {
                            EditText[] editTextArr5 = this.etDigits;
                            if (editTextArr5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                            } else {
                                editTextArr3 = editTextArr5;
                            }
                            editTextArr3[i2 + 1].requestFocus();
                            return;
                        }
                        this.submitEventId();
                    }
                }
            });
            editText.setOnKeyListener(new View.OnKeyListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                    return VerifyEmailFragment.initOtpInput$lambda$6$lambda$3(editText, i2, this, view, i3, keyEvent);
                }
            });
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    VerifyEmailFragment.initOtpInput$lambda$6$lambda$4(editText, view, z);
                }
            });
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyEmailFragment.initOtpInput$lambda$6$lambda$5(editText, view);
                }
            });
            i++;
            i2++;
        }
        EditText[] editTextArr3 = this.etDigits;
        if (editTextArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
        } else {
            editTextArr2 = editTextArr3;
        }
        editTextArr2[0].requestFocus();
        setupCustomKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initOtpInput$lambda$6$lambda$3(EditText editText, int i, VerifyEmailFragment this$0, View view, int i2, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i2 != 67 || keyEvent.getAction() != 0) {
            return false;
        }
        Editable text = editText.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (text.length() != 0 || i <= 0) {
            return false;
        }
        EditText[] editTextArr = this$0.etDigits;
        EditText[] editTextArr2 = null;
        if (editTextArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
            editTextArr = null;
        }
        int i3 = i - 1;
        editTextArr[i3].requestFocus();
        EditText[] editTextArr3 = this$0.etDigits;
        if (editTextArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
        } else {
            editTextArr2 = editTextArr3;
        }
        editTextArr2[i3].setText("");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOtpInput$lambda$6$lambda$4(EditText editText, View view, boolean z) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        if (z) {
            editText.setSelection(editText.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOtpInput$lambda$6$lambda$5(EditText editText, View view) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setSelection(editText.getText().length());
    }

    private final void setupCustomKeyboard() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        FragmentVerifyEmailBinding binding = getBinding();
        if (binding != null && (textView10 = binding.number1) != null) {
            textView10.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyEmailFragment.setupCustomKeyboard$lambda$7(this.f$0, view);
                }
            });
        }
        FragmentVerifyEmailBinding binding2 = getBinding();
        if (binding2 != null && (textView9 = binding2.number2) != null) {
            textView9.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyEmailFragment.setupCustomKeyboard$lambda$8(this.f$0, view);
                }
            });
        }
        FragmentVerifyEmailBinding binding3 = getBinding();
        if (binding3 != null && (textView8 = binding3.number3) != null) {
            textView8.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyEmailFragment.setupCustomKeyboard$lambda$9(this.f$0, view);
                }
            });
        }
        FragmentVerifyEmailBinding binding4 = getBinding();
        if (binding4 != null && (textView7 = binding4.number4) != null) {
            textView7.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyEmailFragment.setupCustomKeyboard$lambda$10(this.f$0, view);
                }
            });
        }
        FragmentVerifyEmailBinding binding5 = getBinding();
        if (binding5 != null && (textView6 = binding5.number5) != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyEmailFragment.setupCustomKeyboard$lambda$11(this.f$0, view);
                }
            });
        }
        FragmentVerifyEmailBinding binding6 = getBinding();
        if (binding6 != null && (textView5 = binding6.number6) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyEmailFragment.setupCustomKeyboard$lambda$12(this.f$0, view);
                }
            });
        }
        FragmentVerifyEmailBinding binding7 = getBinding();
        if (binding7 != null && (textView4 = binding7.number7) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyEmailFragment.setupCustomKeyboard$lambda$13(this.f$0, view);
                }
            });
        }
        FragmentVerifyEmailBinding binding8 = getBinding();
        if (binding8 != null && (textView3 = binding8.number8) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyEmailFragment.setupCustomKeyboard$lambda$14(this.f$0, view);
                }
            });
        }
        FragmentVerifyEmailBinding binding9 = getBinding();
        if (binding9 != null && (textView2 = binding9.number9) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyEmailFragment.setupCustomKeyboard$lambda$15(this.f$0, view);
                }
            });
        }
        FragmentVerifyEmailBinding binding10 = getBinding();
        if (binding10 != null && (textView = binding10.number0) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyEmailFragment.setupCustomKeyboard$lambda$16(this.f$0, view);
                }
            });
        }
        FragmentVerifyEmailBinding binding11 = getBinding();
        if (binding11 != null && (linearLayout2 = binding11.delete) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyEmailFragment.setupCustomKeyboard$lambda$17(this.f$0, view);
                }
            });
        }
        FragmentVerifyEmailBinding binding12 = getBinding();
        if (binding12 == null || (linearLayout = binding12.clear) == null) {
            return;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerifyEmailFragment.setupCustomKeyboard$lambda$18(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$7(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit("1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$8(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit("2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$9(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit(ExifInterface.GPS_MEASUREMENT_3D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$10(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit(TlbConst.TYPELIB_MINOR_VERSION_WORD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$11(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit(TlbConst.TYPELIB_MINOR_VERSION_OFFICE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$12(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit("6");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$13(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit("7");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$14(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit(TlbConst.TYPELIB_MAJOR_VERSION_WORD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$15(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit("9");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$16(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.inputDigit("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$17(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.deleteDigit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCustomKeyboard$lambda$18(VerifyEmailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clearInput();
    }

    private final void inputDigit(String digit) {
        EditText[] editTextArr = this.etDigits;
        EditText[] editTextArr2 = null;
        if (editTextArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
            editTextArr = null;
        }
        int length = editTextArr.length;
        for (int i = 0; i < length; i++) {
            EditText[] editTextArr3 = this.etDigits;
            if (editTextArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                editTextArr3 = null;
            }
            if (editTextArr3[i].getText().toString().length() == 0) {
                EditText[] editTextArr4 = this.etDigits;
                if (editTextArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                    editTextArr4 = null;
                }
                editTextArr4[i].setText(digit);
                EditText[] editTextArr5 = this.etDigits;
                if (editTextArr5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                } else {
                    editTextArr2 = editTextArr5;
                }
                if (i == editTextArr2.length - 1) {
                    submitEventId();
                    return;
                }
                return;
            }
        }
    }

    private final void deleteDigit() {
        EditText[] editTextArr = this.etDigits;
        EditText[] editTextArr2 = null;
        if (editTextArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
            editTextArr = null;
        }
        int length = editTextArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            EditText[] editTextArr3 = this.etDigits;
            if (editTextArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                editTextArr3 = null;
            }
            if (editTextArr3[length].getText().toString().length() > 0) {
                EditText[] editTextArr4 = this.etDigits;
                if (editTextArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etDigits");
                } else {
                    editTextArr2 = editTextArr4;
                }
                editTextArr2[length].setText("");
                return;
            }
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void submitEventId() {
        String passCode = getPassCode();
        if (passCode.length() == 6) {
            hideKeyboard();
            if (this.isLoading) {
                return;
            }
            submitVerifyCode(passCode);
        }
    }

    private final String getPassCode() {
        EditText[] editTextArr = this.etDigits;
        if (editTextArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
            editTextArr = null;
        }
        return ArraysKt.joinToString$default(editTextArr, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<EditText, CharSequence>() { // from class: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment.getPassCode.1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(EditText it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getText().toString();
            }
        }, 30, (Object) null);
    }

    private final void clearInput() {
        EditText[] editTextArr = this.etDigits;
        EditText[] editTextArr2 = null;
        if (editTextArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
            editTextArr = null;
        }
        for (EditText editText : editTextArr) {
            editText.setText("");
        }
        EditText[] editTextArr3 = this.etDigits;
        if (editTextArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etDigits");
        } else {
            editTextArr2 = editTextArr3;
        }
        editTextArr2[0].requestFocus();
    }

    private final void resentVerifyCode() {
        Timber.INSTANCE.d("resentVerifyCode", new Object[0]);
        String email = getSignUpViewModel().getEditSignUpForm().getValue().getEmail();
        String str = email;
        if (str == null || str.length() == 0) {
            Timber.INSTANCE.d("resentVerifyCode Email not found", new Object[0]);
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C10241(email, null), 3, null);
    }

    /* compiled from: VerifyEmailFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$resentVerifyCode$1", f = "VerifyEmailFragment.kt", i = {}, l = {318, 355}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$resentVerifyCode$1, reason: invalid class name and case insensitive filesystem */
    static final class C10241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $email;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10241(String str, Continuation<? super C10241> continuation) {
            super(2, continuation);
            this.$email = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return VerifyEmailFragment.this.new C10241(this.$email, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:51:0x017f A[Catch: all -> 0x0034, IOException -> 0x0037, TryCatch #0 {IOException -> 0x0037, blocks: (B:6:0x001f, B:45:0x0110, B:47:0x0147, B:49:0x014d, B:51:0x017f, B:53:0x0186, B:55:0x018e, B:56:0x0192, B:58:0x01a8, B:59:0x01c8, B:61:0x01d2, B:62:0x01d6, B:10:0x002e, B:20:0x0059, B:22:0x0063, B:24:0x0069, B:26:0x006f, B:28:0x0075, B:42:0x00f7, B:30:0x00b3, B:33:0x00bb, B:36:0x00c3, B:38:0x00df, B:41:0x00ec, B:17:0x0042), top: B:72:0x0019, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0185  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x018e A[Catch: all -> 0x0034, IOException -> 0x0037, TryCatch #0 {IOException -> 0x0037, blocks: (B:6:0x001f, B:45:0x0110, B:47:0x0147, B:49:0x014d, B:51:0x017f, B:53:0x0186, B:55:0x018e, B:56:0x0192, B:58:0x01a8, B:59:0x01c8, B:61:0x01d2, B:62:0x01d6, B:10:0x002e, B:20:0x0059, B:22:0x0063, B:24:0x0069, B:26:0x006f, B:28:0x0075, B:42:0x00f7, B:30:0x00b3, B:33:0x00bb, B:36:0x00c3, B:38:0x00df, B:41:0x00ec, B:17:0x0042), top: B:72:0x0019, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0192 A[Catch: all -> 0x0034, IOException -> 0x0037, TryCatch #0 {IOException -> 0x0037, blocks: (B:6:0x001f, B:45:0x0110, B:47:0x0147, B:49:0x014d, B:51:0x017f, B:53:0x0186, B:55:0x018e, B:56:0x0192, B:58:0x01a8, B:59:0x01c8, B:61:0x01d2, B:62:0x01d6, B:10:0x002e, B:20:0x0059, B:22:0x0063, B:24:0x0069, B:26:0x006f, B:28:0x0075, B:42:0x00f7, B:30:0x00b3, B:33:0x00bb, B:36:0x00c3, B:38:0x00df, B:41:0x00ec, B:17:0x0042), top: B:72:0x0019, outer: #1 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                Method dump skipped, instructions count: 532
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment.C10241.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void submitVerifyCode(String passCode) {
        String email = getSignUpViewModel().getEditSignUpForm().getValue().getEmail();
        String str = email;
        if (str == null || str.length() == 0) {
            Timber.INSTANCE.d("submitVerifyCode Email not found", new Object[0]);
            return;
        }
        this.isLoading = true;
        Timber.INSTANCE.d("passCode:" + passCode, new Object[0]);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C10261(email, passCode, null), 3, null);
    }

    /* compiled from: VerifyEmailFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$submitVerifyCode$1", f = "VerifyEmailFragment.kt", i = {}, l = {436, 466}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment$submitVerifyCode$1, reason: invalid class name and case insensitive filesystem */
    static final class C10261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $email;
        final /* synthetic */ String $passCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10261(String str, String str2, Continuation<? super C10261> continuation) {
            super(2, continuation);
            this.$email = str;
            this.$passCode = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return VerifyEmailFragment.this.new C10261(this.$email, this.$passCode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10261) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x01c5 A[Catch: all -> 0x0034, IOException -> 0x0037, TryCatch #0 {IOException -> 0x0037, blocks: (B:6:0x001f, B:42:0x0117, B:44:0x0149, B:46:0x014f, B:48:0x0155, B:51:0x015d, B:53:0x01c5, B:55:0x01cc, B:57:0x01d4, B:58:0x01d8, B:60:0x01e4, B:61:0x020c, B:63:0x0218, B:64:0x0240, B:66:0x026c, B:67:0x028c, B:69:0x0296, B:70:0x029a, B:10:0x002e, B:20:0x0059, B:22:0x0063, B:24:0x0069, B:26:0x006f, B:28:0x0075, B:39:0x00fc, B:30:0x00b3, B:33:0x00bb, B:36:0x00c3, B:17:0x0042), top: B:80:0x0019, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01cb  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01d4 A[Catch: all -> 0x0034, IOException -> 0x0037, TryCatch #0 {IOException -> 0x0037, blocks: (B:6:0x001f, B:42:0x0117, B:44:0x0149, B:46:0x014f, B:48:0x0155, B:51:0x015d, B:53:0x01c5, B:55:0x01cc, B:57:0x01d4, B:58:0x01d8, B:60:0x01e4, B:61:0x020c, B:63:0x0218, B:64:0x0240, B:66:0x026c, B:67:0x028c, B:69:0x0296, B:70:0x029a, B:10:0x002e, B:20:0x0059, B:22:0x0063, B:24:0x0069, B:26:0x006f, B:28:0x0075, B:39:0x00fc, B:30:0x00b3, B:33:0x00bb, B:36:0x00c3, B:17:0x0042), top: B:80:0x0019, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x01d8 A[Catch: all -> 0x0034, IOException -> 0x0037, TryCatch #0 {IOException -> 0x0037, blocks: (B:6:0x001f, B:42:0x0117, B:44:0x0149, B:46:0x014f, B:48:0x0155, B:51:0x015d, B:53:0x01c5, B:55:0x01cc, B:57:0x01d4, B:58:0x01d8, B:60:0x01e4, B:61:0x020c, B:63:0x0218, B:64:0x0240, B:66:0x026c, B:67:0x028c, B:69:0x0296, B:70:0x029a, B:10:0x002e, B:20:0x0059, B:22:0x0063, B:24:0x0069, B:26:0x006f, B:28:0x0075, B:39:0x00fc, B:30:0x00b3, B:33:0x00bb, B:36:0x00c3, B:17:0x0042), top: B:80:0x0019, outer: #1 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) {
            /*
                Method dump skipped, instructions count: 730
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.signUp.VerifyEmailFragment.C10261.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
