package com.soletreadmills.sole_v2.ui.forgotPassword;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.fragment.FragmentKt;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._tools.UiTool;
import com.soletreadmills.sole_v2._type.user.RegisterType;
import com.soletreadmills.sole_v2.databinding.FragmentResetPasswordBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import defpackage.isValidateEmail;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

/* compiled from: ResetPasswordFragment.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/forgotPassword/ResetPasswordFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentResetPasswordBinding;", "()V", "emailText", "", "getEmailText", "()Ljava/lang/String;", "setEmailText", "(Ljava/lang/String;)V", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "submitResetPassword", "loginName", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResetPasswordFragment extends BaseFragment<FragmentResetPasswordBinding> {
    public static final int $stable = 8;
    private String emailText = "";

    public static final /* synthetic */ FragmentResetPasswordBinding access$getBinding(ResetPasswordFragment resetPasswordFragment) {
        return resetPasswordFragment.getBinding();
    }

    public final String getEmailText() {
        return this.emailText;
    }

    public final void setEmailText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.emailText = str;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentResetPasswordBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentResetPasswordBinding fragmentResetPasswordBindingInflate = FragmentResetPasswordBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentResetPasswordBindingInflate, "inflate(...)");
        return fragmentResetPasswordBindingInflate;
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
        EditText editText;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentResetPasswordBinding binding = getBinding();
        TextView textView = binding != null ? binding.tvEmailAlertText : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        FragmentResetPasswordBinding binding2 = getBinding();
        ImageView imageView3 = binding2 != null ? binding2.imgClear : null;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        FragmentResetPasswordBinding binding3 = getBinding();
        if (binding3 != null && (editText = binding3.edtEmail) != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.forgotPassword.ResetPasswordFragment.onViewCreated.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    LinearLayout linearLayout2;
                    String string = StringsKt.trim((CharSequence) UiTool.toText$default(UiTool.INSTANCE, s, null, 2, null)).toString();
                    Timber.INSTANCE.d("new val: " + string, new Object[0]);
                    ResetPasswordFragment.this.setEmailText(string);
                    if (!Intrinsics.areEqual(string, "")) {
                        FragmentResetPasswordBinding fragmentResetPasswordBindingAccess$getBinding = ResetPasswordFragment.access$getBinding(ResetPasswordFragment.this);
                        ImageView imageView4 = fragmentResetPasswordBindingAccess$getBinding != null ? fragmentResetPasswordBindingAccess$getBinding.imgClear : null;
                        if (imageView4 != null) {
                            imageView4.setVisibility(0);
                        }
                    } else {
                        FragmentResetPasswordBinding fragmentResetPasswordBindingAccess$getBinding2 = ResetPasswordFragment.access$getBinding(ResetPasswordFragment.this);
                        ImageView imageView5 = fragmentResetPasswordBindingAccess$getBinding2 != null ? fragmentResetPasswordBindingAccess$getBinding2.imgClear : null;
                        if (imageView5 != null) {
                            imageView5.setVisibility(8);
                        }
                    }
                    FragmentResetPasswordBinding fragmentResetPasswordBindingAccess$getBinding3 = ResetPasswordFragment.access$getBinding(ResetPasswordFragment.this);
                    TextView textView2 = fragmentResetPasswordBindingAccess$getBinding3 != null ? fragmentResetPasswordBindingAccess$getBinding3.tvEmailAlertText : null;
                    if (textView2 != null) {
                        textView2.setText("");
                    }
                    FragmentResetPasswordBinding fragmentResetPasswordBindingAccess$getBinding4 = ResetPasswordFragment.access$getBinding(ResetPasswordFragment.this);
                    TextView textView3 = fragmentResetPasswordBindingAccess$getBinding4 != null ? fragmentResetPasswordBindingAccess$getBinding4.tvEmailAlertText : null;
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                    FragmentResetPasswordBinding fragmentResetPasswordBindingAccess$getBinding5 = ResetPasswordFragment.access$getBinding(ResetPasswordFragment.this);
                    if (fragmentResetPasswordBindingAccess$getBinding5 == null || (linearLayout2 = fragmentResetPasswordBindingAccess$getBinding5.llEmail) == null) {
                        return;
                    }
                    linearLayout2.setBackgroundResource(R.drawable.bg_corner32_outline);
                }
            });
        }
        FragmentResetPasswordBinding binding4 = getBinding();
        if (binding4 != null && (imageView2 = binding4.imgClear) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.forgotPassword.ResetPasswordFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ResetPasswordFragment.onViewCreated$lambda$0(this.f$0, view2);
                }
            });
        }
        FragmentResetPasswordBinding binding5 = getBinding();
        if (binding5 != null && (linearLayout = binding5.LLSend) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.forgotPassword.ResetPasswordFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ResetPasswordFragment.onViewCreated$lambda$1(this.f$0, view2);
                }
            });
        }
        FragmentResetPasswordBinding binding6 = getBinding();
        if (binding6 == null || (imageView = binding6.back) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.forgotPassword.ResetPasswordFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ResetPasswordFragment.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(ResetPasswordFragment this$0, View view) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentResetPasswordBinding binding = this$0.getBinding();
        if (binding == null || (editText = binding.edtEmail) == null) {
            return;
        }
        editText.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(ResetPasswordFragment this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideKeyboard();
        String str = this$0.emailText;
        Timber.INSTANCE.d("Submit: " + str, new Object[0]);
        if (!isValidateEmail.isValidateEmail(str)) {
            FragmentResetPasswordBinding binding = this$0.getBinding();
            TextView textView = binding != null ? binding.tvEmailAlertText : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            FragmentResetPasswordBinding binding2 = this$0.getBinding();
            if (binding2 != null && (linearLayout = binding2.llEmail) != null) {
                linearLayout.setBackgroundResource(R.drawable.bg_corner32_outline_signal);
            }
            FragmentResetPasswordBinding binding3 = this$0.getBinding();
            TextView textView2 = binding3 != null ? binding3.tvEmailAlertText : null;
            if (textView2 == null) {
                return;
            }
            textView2.setText(this$0.getString(R.string.err_email_format_error));
            return;
        }
        this$0.submitResetPassword(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(ResetPasswordFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).navigateUp();
    }

    private final void submitResetPassword(String loginName) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09611(RegisterType.Email.getId(), loginName, null), 3, null);
    }

    /* compiled from: ResetPasswordFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.forgotPassword.ResetPasswordFragment$submitResetPassword$1", f = "ResetPasswordFragment.kt", i = {}, l = {132, 172}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.forgotPassword.ResetPasswordFragment$submitResetPassword$1, reason: invalid class name and case insensitive filesystem */
    static final class C09611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $loginName;
        final /* synthetic */ int $registerType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09611(int i, String str, Continuation<? super C09611> continuation) {
            super(2, continuation);
            this.$registerType = i;
            this.$loginName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ResetPasswordFragment.this.new C09611(this.$registerType, this.$loginName, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:86:0x01cb A[Catch: all -> 0x0031, IOException -> 0x0034, TryCatch #1 {IOException -> 0x0034, blocks: (B:6:0x001c, B:53:0x0124, B:55:0x015b, B:57:0x0161, B:59:0x0172, B:64:0x017c, B:66:0x0184, B:70:0x018e, B:72:0x0196, B:74:0x019a, B:76:0x01a0, B:78:0x01a7, B:80:0x01af, B:82:0x01b7, B:84:0x01c4, B:69:0x0189, B:63:0x0179, B:86:0x01cb, B:88:0x01d2, B:90:0x01da, B:91:0x01de, B:93:0x020a, B:94:0x022a, B:96:0x0233, B:97:0x0237, B:10:0x002b, B:20:0x005d, B:22:0x0067, B:24:0x006d, B:26:0x0073, B:28:0x0079, B:50:0x010b, B:30:0x00b7, B:33:0x00bf, B:35:0x00d5, B:37:0x00dd, B:39:0x00e3, B:41:0x00eb, B:44:0x00f3, B:46:0x00f9, B:48:0x0101, B:49:0x0105, B:17:0x003a), top: B:107:0x0016, outer: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x01da A[Catch: all -> 0x0031, IOException -> 0x0034, TryCatch #1 {IOException -> 0x0034, blocks: (B:6:0x001c, B:53:0x0124, B:55:0x015b, B:57:0x0161, B:59:0x0172, B:64:0x017c, B:66:0x0184, B:70:0x018e, B:72:0x0196, B:74:0x019a, B:76:0x01a0, B:78:0x01a7, B:80:0x01af, B:82:0x01b7, B:84:0x01c4, B:69:0x0189, B:63:0x0179, B:86:0x01cb, B:88:0x01d2, B:90:0x01da, B:91:0x01de, B:93:0x020a, B:94:0x022a, B:96:0x0233, B:97:0x0237, B:10:0x002b, B:20:0x005d, B:22:0x0067, B:24:0x006d, B:26:0x0073, B:28:0x0079, B:50:0x010b, B:30:0x00b7, B:33:0x00bf, B:35:0x00d5, B:37:0x00dd, B:39:0x00e3, B:41:0x00eb, B:44:0x00f3, B:46:0x00f9, B:48:0x0101, B:49:0x0105, B:17:0x003a), top: B:107:0x0016, outer: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01de A[Catch: all -> 0x0031, IOException -> 0x0034, TryCatch #1 {IOException -> 0x0034, blocks: (B:6:0x001c, B:53:0x0124, B:55:0x015b, B:57:0x0161, B:59:0x0172, B:64:0x017c, B:66:0x0184, B:70:0x018e, B:72:0x0196, B:74:0x019a, B:76:0x01a0, B:78:0x01a7, B:80:0x01af, B:82:0x01b7, B:84:0x01c4, B:69:0x0189, B:63:0x0179, B:86:0x01cb, B:88:0x01d2, B:90:0x01da, B:91:0x01de, B:93:0x020a, B:94:0x022a, B:96:0x0233, B:97:0x0237, B:10:0x002b, B:20:0x005d, B:22:0x0067, B:24:0x006d, B:26:0x0073, B:28:0x0079, B:50:0x010b, B:30:0x00b7, B:33:0x00bf, B:35:0x00d5, B:37:0x00dd, B:39:0x00e3, B:41:0x00eb, B:44:0x00f3, B:46:0x00f9, B:48:0x0101, B:49:0x0105, B:17:0x003a), top: B:107:0x0016, outer: #0 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                Method dump skipped, instructions count: 632
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.forgotPassword.ResetPasswordFragment.C09611.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ResetPasswordFragment resetPasswordFragment) {
            FragmentResetPasswordBinding fragmentResetPasswordBindingAccess$getBinding = ResetPasswordFragment.access$getBinding(resetPasswordFragment);
            LinearLayout linearLayout = fragmentResetPasswordBindingAccess$getBinding != null ? fragmentResetPasswordBindingAccess$getBinding.LLResetLink : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        LinearLayout linearLayout;
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        FragmentResetPasswordBinding binding = getBinding();
        if (binding != null && (linearLayout = binding.LLResetLink) != null && (viewPropertyAnimatorAnimate = linearLayout.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        super.onDestroyView();
    }
}
