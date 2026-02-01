package com.soletreadmills.sole_v2.ui.settings;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.LocaleListCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.android.SdkConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.soletreadmills.sole_v2.AppConfigKt;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.JwtErrorCode;
import com.soletreadmills.sole_v2._data.api.forgotPassword.ForgetPasswordApiData;
import com.soletreadmills.sole_v2._data.api.login.LogoutApiData;
import com.soletreadmills.sole_v2._data.api.settings.DeleteAccountApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetUnReadMessagesApiData;
import com.soletreadmills.sole_v2._data.api.settings.UpdateMeasurementUnitApiData;
import com.soletreadmills.sole_v2._data.api.settings.UpdatePreferenceApiData;
import com.soletreadmills.sole_v2._data.classes.GetSubscriptionStatusApiData;
import com.soletreadmills.sole_v2._data.classes.GetSubscriptionStatusDataMap;
import com.soletreadmills.sole_v2._data.classes.SubscriptionStatusType;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._network.JwtDyacoApiKt;
import com.soletreadmills.sole_v2._network.JwtNotificationDyacoApiKt;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._type.user.RegisterType;
import com.soletreadmills.sole_v2.databinding.FragmentSettingsMainBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog;
import com.sun.jna.platform.win32.WinError;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: SettingsMainFragment.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0006\u0010\u0011\u001a\u00020\nJ\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0002J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0006\u0010!\u001a\u00020\nJ\b\u0010\"\u001a\u00020\nH\u0003J\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/SettingsMainFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentSettingsMainBinding;", "Landroid/view/View$OnClickListener;", "()V", "currentCollapseMode", "", "iosOnePickerBottomSheetDialog", "Lcom/soletreadmills/sole_v2/ui/_shared/IosOnePickerBottomSheetDialog;", "apiGetSubscriptionStatus", "", "isClickEvent", "", "callUnReadMessageCountApi", "callUpdatePreferenceApi", "changeCollapseMode", "collapseMode", "deleteAccount", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "logout", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "resetPassword", "setLanguageToView", "setView", "updateMeasurementUnit", "units", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsMainFragment extends BaseFragment<FragmentSettingsMainBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private int currentCollapseMode = 2;
    private IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog;

    public static final /* synthetic */ FragmentSettingsMainBinding access$getBinding(SettingsMainFragment settingsMainFragment) {
        return settingsMainFragment.getBinding();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentSettingsMainBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentSettingsMainBinding fragmentSettingsMainBindingInflate = FragmentSettingsMainBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentSettingsMainBindingInflate, "inflate(...)");
        return fragmentSettingsMainBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() throws PackageManager.NameNotFoundException {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        LinearLayout linearLayout7;
        LinearLayout linearLayout8;
        LinearLayout linearLayout9;
        LinearLayout linearLayout10;
        LinearLayout linearLayout11;
        LinearLayout linearLayout12;
        LinearLayout linearLayout13;
        LinearLayout linearLayout14;
        LinearLayout linearLayout15;
        ConstraintLayout constraintLayout;
        ImageView imageView;
        AppBarLayout appBarLayout;
        FragmentSettingsMainBinding binding = getBinding();
        if (binding != null && (appBarLayout = binding.appBarLayout) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$$ExternalSyntheticLambda0
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                    SettingsMainFragment.initViews$lambda$0(this.f$0, appBarLayout2, i);
                }
            });
        }
        FragmentSettingsMainBinding binding2 = getBinding();
        if (binding2 != null && (imageView = binding2.endImg) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding3 = getBinding();
        if (binding3 != null && (constraintLayout = binding3.CLProfile) != null) {
            constraintLayout.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout15 = binding4.LLResetPassword) != null) {
            linearLayout15.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding5 = getBinding();
        if (binding5 != null && (linearLayout14 = binding5.LLUnits) != null) {
            linearLayout14.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding6 = getBinding();
        if (binding6 != null && (linearLayout13 = binding6.LLLanguage) != null) {
            linearLayout13.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding7 = getBinding();
        if (binding7 != null && (linearLayout12 = binding7.LLDeleteAccount) != null) {
            linearLayout12.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding8 = getBinding();
        if (binding8 != null && (linearLayout11 = binding8.LLMyFavorites) != null) {
            linearLayout11.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding9 = getBinding();
        if (binding9 != null && (linearLayout10 = binding9.LLWorkoutSettings) != null) {
            linearLayout10.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding10 = getBinding();
        if (binding10 != null && (linearLayout9 = binding10.LLFaqSupport) != null) {
            linearLayout9.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding11 = getBinding();
        if (binding11 != null && (linearLayout8 = binding11.LLTermsOfUse) != null) {
            linearLayout8.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding12 = getBinding();
        if (binding12 != null && (linearLayout7 = binding12.LLPrivacyPolicy) != null) {
            linearLayout7.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding13 = getBinding();
        if (binding13 != null && (linearLayout6 = binding13.LLDevices) != null) {
            linearLayout6.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding14 = getBinding();
        if (binding14 != null && (linearLayout5 = binding14.LLHrm) != null) {
            linearLayout5.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding15 = getBinding();
        if (binding15 != null && (linearLayout4 = binding15.LLSubscription) != null) {
            linearLayout4.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding16 = getBinding();
        if (binding16 != null && (linearLayout3 = binding16.LLHealthApps) != null) {
            linearLayout3.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding17 = getBinding();
        if (binding17 != null && (linearLayout2 = binding17.LLNotify) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentSettingsMainBinding binding18 = getBinding();
        if (binding18 != null && (linearLayout = binding18.LLLogout) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsMainFragment.initViews$lambda$1(this.f$0, view);
                }
            });
        }
        setView();
        apiGetSubscriptionStatus(false);
        callUnReadMessageCountApi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(SettingsMainFragment this$0, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i2 = ((float) Math.abs(i)) / ((float) appBarLayout.getTotalScrollRange()) >= 0.85f ? 1 : 2;
        if (this$0.currentCollapseMode != i2) {
            this$0.changeCollapseMode(i2);
            this$0.currentCollapseMode = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(final SettingsMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CustomDialogKt.showCustomDialog$default(this$0, this$0.getString(R.string.logout), this$0.getString(R.string.ask_log_out), null, this$0.getString(R.string.cancel), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$initViews$2$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.logout();
            }
        }, null, false, 100, null);
    }

    private final void changeCollapseMode(int collapseMode) {
        TextView textView;
        Toolbar toolbar;
        FragmentSettingsMainBinding binding = getBinding();
        ViewGroup.LayoutParams layoutParams = (binding == null || (toolbar = binding.collapsingToolbar) == null) ? null : toolbar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams");
        CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) layoutParams;
        layoutParams2.setCollapseMode(collapseMode);
        FragmentSettingsMainBinding binding2 = getBinding();
        Toolbar toolbar2 = binding2 != null ? binding2.collapsingToolbar : null;
        if (toolbar2 != null) {
            toolbar2.setLayoutParams(layoutParams2);
        }
        if (collapseMode == 1) {
            FragmentSettingsMainBinding binding3 = getBinding();
            textView = binding3 != null ? binding3.title : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        FragmentSettingsMainBinding binding4 = getBinding();
        textView = binding4 != null ? binding4.title : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a7  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r19) {
        /*
            Method dump skipped, instructions count: 954
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment.onClick(android.view.View):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setView() throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment.setView():void");
    }

    private final void setLanguageToView() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        FragmentSettingsMainBinding binding = getBinding();
        TextView textView = binding != null ? binding.txtLanguage : null;
        if (textView == null) {
            return;
        }
        textView.setText(getLanguage(context));
    }

    /* compiled from: SettingsMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$logout$1", f = "SettingsMainFragment.kt", i = {}, l = {460}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$logout$1, reason: invalid class name and case insensitive filesystem */
    static final class C10111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C10111(Continuation<? super C10111> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsMainFragment.this.new C10111(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            LogoutApiData.ResponseData responseData;
            Unit unit;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Timber.INSTANCE.d("Token login", new Object[0]);
                        BleManager.getInstance().bleFtmsDisconnect();
                        SettingsMainFragment.this.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callLogout(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Response response = (Response) obj;
                    Timber.INSTANCE.d("logoutRes Body: " + response, new Object[0]);
                    SettingsMainFragment.this.stopLoading();
                    responseData = (LogoutApiData.ResponseData) response.body();
                    Timber.INSTANCE.d("Body: " + responseData, new Object[0]);
                } catch (IOException e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(SettingsMainFragment.this, "logout", message, false, 4, null);
                    BaseFragment.safeNavigateAndClearStack$default(SettingsMainFragment.this, R.id.chooseFragment, null, 2, null);
                }
                if (responseData != null && responseData.getSuccess()) {
                    BaseFragment.safeNavigateAndClearStack$default(SettingsMainFragment.this, R.id.chooseFragment, null, 2, null);
                    SettingsMainFragment.this.stopLoading();
                    MySharedPreferences.INSTANCE.getInstance().resetSharedBaseUrl();
                    SettingsMainFragment.this.resetLoginData();
                    MySharedPreferences.INSTANCE.getInstance().resetSharedLoginToken();
                    AppConfigKt.clearSessionId();
                    AppConfigKt.clearServiceLoginToken();
                    MySharedPreferences.INSTANCE.getInstance().resetConnectBleName();
                    AppCompatDelegate.setApplicationLocales(LocaleListCompat.getEmptyLocaleList());
                    return Unit.INSTANCE;
                }
                BaseFragment.safeNavigateAndClearStack$default(SettingsMainFragment.this, R.id.chooseFragment, null, 2, null);
                String errorCode = responseData != null ? responseData.getErrorCode() : null;
                if (!SettingsMainFragment.this.shouldIgnoreError(errorCode)) {
                    SettingsMainFragment.this.handleUndefinedError("logout", errorCode, responseData != null ? responseData.getErrorMessage() : null, false);
                    unit = Unit.INSTANCE;
                } else {
                    unit = Unit.INSTANCE;
                }
                return unit;
            } finally {
                SettingsMainFragment.this.stopLoading();
                MySharedPreferences.INSTANCE.getInstance().resetSharedBaseUrl();
                SettingsMainFragment.this.resetLoginData();
                MySharedPreferences.INSTANCE.getInstance().resetSharedLoginToken();
                AppConfigKt.clearSessionId();
                AppConfigKt.clearServiceLoginToken();
                MySharedPreferences.INSTANCE.getInstance().resetConnectBleName();
                AppCompatDelegate.setApplicationLocales(LocaleListCompat.getEmptyLocaleList());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logout() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10111(null), 3, null);
    }

    /* compiled from: SettingsMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$resetPassword$1", f = "SettingsMainFragment.kt", i = {}, l = {537}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$resetPassword$1, reason: invalid class name and case insensitive filesystem */
    static final class C10121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $email;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10121(String str, Continuation<? super C10121> continuation) {
            super(2, continuation);
            this.$email = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsMainFragment.this.new C10121(this.$email, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            ForgetPasswordApiData.ResponseData responseData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        SettingsMainFragment.this.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callForgetPassword(new ForgetPasswordApiData.RequestBodyData(RegisterType.Email.getId(), this.$email), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Response response = (Response) obj;
                    Timber.INSTANCE.d("forgetPasswordRes Body: " + response, new Object[0]);
                    responseData = (ForgetPasswordApiData.ResponseData) response.body();
                    Timber.INSTANCE.d("forgetPasswordRes: " + responseData, new Object[0]);
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(SettingsMainFragment.this, "resetPassword", message, false, 4, null);
                    unit = Unit.INSTANCE;
                }
                if (responseData != null && responseData.getSuccess()) {
                    Timber.INSTANCE.d("送出成功!", new Object[0]);
                    SettingsMainFragment.this.logout();
                } else {
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (SettingsMainFragment.this.shouldIgnoreError(errorCode)) {
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                    Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.USER_NOT_FOUND_1003.getId(), Boxing.boxInt(R.string.err_1003_user_not_found))).get(errorCode);
                    if (num != null) {
                        SettingsMainFragment settingsMainFragment = SettingsMainFragment.this;
                        CustomDialogKt.showCustomDialog$default(settingsMainFragment, settingsMainFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                    } else {
                        BaseFragment.handleUndefinedError$default(SettingsMainFragment.this, "resetPassword", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                }
                SettingsMainFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                SettingsMainFragment.this.stopLoading();
            }
        }
    }

    public final void resetPassword() {
        String email;
        LoginUserData loginUserData = Global.userData;
        if (loginUserData == null || (email = loginUserData.getEmail()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10121(email, null), 3, null);
    }

    /* compiled from: SettingsMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$updateMeasurementUnit$1", f = "SettingsMainFragment.kt", i = {}, l = {605}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$updateMeasurementUnit$1, reason: invalid class name and case insensitive filesystem */
    static final class C10131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $units;
        int label;
        final /* synthetic */ SettingsMainFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10131(int i, SettingsMainFragment settingsMainFragment, Continuation<? super C10131> continuation) {
            super(2, continuation);
            this.$units = i;
            this.this$0 = settingsMainFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10131(this.$units, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            UpdateMeasurementUnitApiData.ResponseData responseData;
            String string;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        UpdateMeasurementUnitApiData.RequestBodyData requestBodyData = new UpdateMeasurementUnitApiData.RequestBodyData(this.$units);
                        this.this$0.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callUpdateMeasurementUnit(requestBodyData, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    responseData = (UpdateMeasurementUnitApiData.ResponseData) ((Response) obj).body();
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(this.this$0, "updateMeasurementUnit", message, false, 4, null);
                    unit = Unit.INSTANCE;
                }
                if (responseData != null && responseData.getSuccess()) {
                    LoginUserData loginUserData = Global.userData;
                    if (loginUserData != null) {
                        loginUserData.setMeasurementUnit(Boxing.boxInt(this.$units));
                    }
                    FragmentSettingsMainBinding fragmentSettingsMainBindingAccess$getBinding = SettingsMainFragment.access$getBinding(this.this$0);
                    TextView textView = fragmentSettingsMainBindingAccess$getBinding != null ? fragmentSettingsMainBindingAccess$getBinding.txtUnits : null;
                    if (textView != null) {
                        if (this.$units == 0) {
                            string = this.this$0.getString(R.string.metric);
                        } else {
                            string = this.this$0.getString(R.string.imperial);
                        }
                        textView.setText(string);
                    }
                } else {
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (this.this$0.shouldIgnoreError(errorCode)) {
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                    Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113))).get(errorCode);
                    if (num != null) {
                        SettingsMainFragment settingsMainFragment = this.this$0;
                        CustomDialogKt.showCustomDialog$default(settingsMainFragment, settingsMainFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                    } else {
                        BaseFragment.handleUndefinedError$default(this.this$0, "updateMeasurementUnit", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                }
                this.this$0.stopLoading();
                return Unit.INSTANCE;
            } finally {
                this.this$0.stopLoading();
            }
        }
    }

    public final void updateMeasurementUnit(int units) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10131(units, this, null), 3, null);
    }

    /* compiled from: SettingsMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$deleteAccount$1", f = "SettingsMainFragment.kt", i = {}, l = {659}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$deleteAccount$1, reason: invalid class name and case insensitive filesystem */
    static final class C10101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C10101(Continuation<? super C10101> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsMainFragment.this.new C10101(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            DeleteAccountApiData.ResponseData responseData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = DyacoApiKt.callDeleteAccount(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    SettingsMainFragment.this.showLoading();
                    responseData = (DeleteAccountApiData.ResponseData) ((Response) obj).body();
                    Timber.INSTANCE.d("forgetPasswordRes: " + responseData, new Object[0]);
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(SettingsMainFragment.this, "deleteAccount", message, false, 4, null);
                    unit = Unit.INSTANCE;
                }
                if (responseData != null && responseData.getSuccess()) {
                    SettingsMainFragment.this.logout();
                } else {
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (SettingsMainFragment.this.shouldIgnoreError(errorCode)) {
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                    Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.USER_NOT_FOUND_1003.getId(), Boxing.boxInt(R.string.err_1003_user_not_found)), TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113))).get(errorCode);
                    if (num != null) {
                        SettingsMainFragment settingsMainFragment = SettingsMainFragment.this;
                        CustomDialogKt.showCustomDialog$default(settingsMainFragment, settingsMainFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                    } else {
                        BaseFragment.handleUndefinedError$default(SettingsMainFragment.this, "deleteAccount", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                }
                SettingsMainFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                SettingsMainFragment.this.stopLoading();
            }
        }
    }

    public final void deleteAccount() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C10101(null), 3, null);
    }

    /* compiled from: SettingsMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$apiGetSubscriptionStatus$1", f = "SettingsMainFragment.kt", i = {}, l = {WinError.ERROR_CHECKING_FILE_SYSTEM}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$apiGetSubscriptionStatus$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isClickEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isClickEvent = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsMainFragment.this.new AnonymousClass1(this.$isClickEvent, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: SettingsMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$apiGetSubscriptionStatus$1$1", f = "SettingsMainFragment.kt", i = {}, l = {WinError.ERROR_PREDEFINED_HANDLE}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$apiGetSubscriptionStatus$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isClickEvent;
            int label;
            final /* synthetic */ SettingsMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02651(SettingsMainFragment settingsMainFragment, boolean z, Continuation<? super C02651> continuation) {
                super(2, continuation);
                this.this$0 = settingsMainFragment;
                this.$isClickEvent = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02651(this.this$0, this.$isClickEvent, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                JwtApiBaseData.SysResponseMessage sysMsg;
                GetSubscriptionStatusDataMap dataMap;
                JwtApiBaseData.SysResponseMessage sysMsg2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = JwtDyacoApiKt.callGetSubscriptionStatus(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    GetSubscriptionStatusApiData.ResponseData responseData = (GetSubscriptionStatusApiData.ResponseData) ((Response) obj).body();
                    String message = null;
                    String code = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                    if (!Intrinsics.areEqual(code, JwtErrorCode.JWT_SUCCESS_1.getId())) {
                        if (this.this$0.shouldIgnoreError(code)) {
                            return Unit.INSTANCE;
                        }
                        SettingsMainFragment settingsMainFragment = this.this$0;
                        if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                            message = sysMsg.getMessage();
                        }
                        settingsMainFragment.handleUndefinedError("apiGetSubscriptionStatus", code, message, false);
                    } else {
                        SubscriptionStatusType subscriptionStatus = (responseData == null || (dataMap = responseData.getDataMap()) == null) ? null : dataMap.getSubscriptionStatus();
                        if (subscriptionStatus != null && SubscriptionStatusType.INSTANCE.isSubscribedOrTrial(subscriptionStatus)) {
                            Global.INSTANCE.setSubscription(true);
                            FragmentSettingsMainBinding fragmentSettingsMainBindingAccess$getBinding = SettingsMainFragment.access$getBinding(this.this$0);
                            LinearLayout linearLayout = fragmentSettingsMainBindingAccess$getBinding != null ? fragmentSettingsMainBindingAccess$getBinding.LLGetPremium : null;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                            }
                        } else {
                            Global.INSTANCE.setSubscription(false);
                            FragmentSettingsMainBinding fragmentSettingsMainBindingAccess$getBinding2 = SettingsMainFragment.access$getBinding(this.this$0);
                            LinearLayout linearLayout2 = fragmentSettingsMainBindingAccess$getBinding2 != null ? fragmentSettingsMainBindingAccess$getBinding2.LLGetPremium : null;
                            if (linearLayout2 != null) {
                                linearLayout2.setVisibility(0);
                            }
                        }
                        if (this.$isClickEvent) {
                            if (Global.INSTANCE.isSubscription()) {
                                BaseFragment.safeNavigate$default(this.this$0, R.id.userSubscriptionFragment, null, 2, null);
                            } else {
                                GetSubscriptionStatusDataMap dataMap2 = responseData.getDataMap();
                                if (dataMap2 != null ? Intrinsics.areEqual(dataMap2.getDeletedPaymentMethod(), Boxing.boxBoolean(false)) : false) {
                                    BaseFragment.safeNavigate$default(this.this$0, R.id.userSubscriptionFragment, null, 2, null);
                                } else {
                                    BaseFragment.safeNavigate$default(this.this$0, R.id.payWallFragment, null, 2, null);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(this.this$0, "apiGetSubscriptionStatus", message2, false, 4, null);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(SettingsMainFragment.this, Lifecycle.State.STARTED, new C02651(SettingsMainFragment.this, this.$isClickEvent, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void apiGetSubscriptionStatus(boolean isClickEvent) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(isClickEvent, null), 3, null);
    }

    /* compiled from: SettingsMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$callUpdatePreferenceApi$1", f = "SettingsMainFragment.kt", i = {0}, l = {WinError.ERROR_BADSTARTPOSITION}, m = "invokeSuspend", n = {"notifyChecked"}, s = {"I$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$callUpdatePreferenceApi$1, reason: invalid class name and case insensitive filesystem */
    static final class C10091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int label;

        C10091(Continuation<? super C10091> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsMainFragment.this.new C10091(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UpdatePreferenceApiData.RequestBodyData requestBodyData;
            int i;
            Switch r8;
            ArrayList arrayList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        SettingsMainFragment.this.showLoading();
                        FragmentSettingsMainBinding fragmentSettingsMainBindingAccess$getBinding = SettingsMainFragment.access$getBinding(SettingsMainFragment.this);
                        int iIsChecked = (fragmentSettingsMainBindingAccess$getBinding == null || (r8 = fragmentSettingsMainBindingAccess$getBinding.switchNotify) == null) ? 0 : r8.isChecked();
                        if (iIsChecked != 0) {
                            requestBodyData = new UpdatePreferenceApiData.RequestBodyData(null, Boxing.boxBoolean(true));
                        } else {
                            requestBodyData = new UpdatePreferenceApiData.RequestBodyData(Boxing.boxBoolean(true), null);
                        }
                        this.I$0 = iIsChecked;
                        this.label = 1;
                        Object objCallUpdatePreference = DyacoApiKt.callUpdatePreference(requestBodyData, this);
                        if (objCallUpdatePreference == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = iIsChecked;
                        obj = objCallUpdatePreference;
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i = this.I$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    UpdatePreferenceApiData.ResponseData responseData = (UpdatePreferenceApiData.ResponseData) ((Response) obj).body();
                    if (responseData != null && responseData.getSuccess()) {
                        FragmentSettingsMainBinding fragmentSettingsMainBindingAccess$getBinding2 = SettingsMainFragment.access$getBinding(SettingsMainFragment.this);
                        Switch r3 = fragmentSettingsMainBindingAccess$getBinding2 != null ? fragmentSettingsMainBindingAccess$getBinding2.switchNotify : null;
                        if (r3 != null) {
                            r3.setChecked(i == 0);
                        }
                        LoginUserData loginUserData = Global.userData;
                        if (loginUserData != null) {
                            if (i == 0) {
                                arrayList = CollectionsKt.mutableListOf(Boxing.boxInt(1));
                            } else {
                                arrayList = new ArrayList();
                            }
                            loginUserData.setEnabledPreferenceItems(arrayList);
                        }
                    } else {
                        String errorCode = responseData != null ? responseData.getErrorCode() : null;
                        if (SettingsMainFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        BaseFragment.handleUndefinedError$default(SettingsMainFragment.this, "callUpdatePreferenceApi", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(SettingsMainFragment.this, "callUpdatePreferenceApi", message, false, 4, null);
                }
                SettingsMainFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                SettingsMainFragment.this.stopLoading();
            }
        }
    }

    public final void callUpdatePreferenceApi() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C10091(null), 3, null);
    }

    /* compiled from: SettingsMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$callUnReadMessageCountApi$1", f = "SettingsMainFragment.kt", i = {}, l = {827}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingsMainFragment$callUnReadMessageCountApi$1, reason: invalid class name and case insensitive filesystem */
    static final class C10081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C10081(Continuation<? super C10081> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsMainFragment.this.new C10081(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Integer unread_count;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        SettingsMainFragment.this.showLoading();
                        this.label = 1;
                        obj = JwtNotificationDyacoApiKt.callUnReadMessageCount(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    GetUnReadMessagesApiData.ResponseData responseData = (GetUnReadMessagesApiData.ResponseData) ((Response) obj).body();
                    if (Intrinsics.areEqual(responseData != null ? responseData.getCode() : null, "200")) {
                        GetUnReadMessagesApiData.UnReadData result = responseData.getResult();
                        if (((result == null || (unread_count = result.getUnread_count()) == null) ? 0 : unread_count.intValue()) > 0) {
                            FragmentSettingsMainBinding fragmentSettingsMainBindingAccess$getBinding = SettingsMainFragment.access$getBinding(SettingsMainFragment.this);
                            ImageView imageView = fragmentSettingsMainBindingAccess$getBinding != null ? fragmentSettingsMainBindingAccess$getBinding.imgRedCircle : null;
                            if (imageView != null) {
                                imageView.setVisibility(0);
                            }
                        } else {
                            FragmentSettingsMainBinding fragmentSettingsMainBindingAccess$getBinding2 = SettingsMainFragment.access$getBinding(SettingsMainFragment.this);
                            ImageView imageView2 = fragmentSettingsMainBindingAccess$getBinding2 != null ? fragmentSettingsMainBindingAccess$getBinding2.imgRedCircle : null;
                            if (imageView2 != null) {
                                imageView2.setVisibility(8);
                            }
                        }
                    } else {
                        String code = responseData != null ? responseData.getCode() : null;
                        if (!SettingsMainFragment.this.shouldIgnoreError(code)) {
                            SettingsMainFragment.this.handleUndefinedError("callUnReadMessageCountApi", code, responseData != null ? responseData.getMessage() : null, false);
                        } else {
                            return Unit.INSTANCE;
                        }
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(SettingsMainFragment.this, "callUnReadMessageCountApi", message, false, 4, null);
                }
                SettingsMainFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                SettingsMainFragment.this.stopLoading();
            }
        }
    }

    public final void callUnReadMessageCountApi() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C10081(null), 3, null);
    }
}
