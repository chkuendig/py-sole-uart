package com.soletreadmills.sole_v2.ui.logo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.agesignals.AgeSignalsManager;
import com.google.android.play.agesignals.AgeSignalsManagerFactory;
import com.google.android.play.agesignals.AgeSignalsRequest;
import com.google.android.play.agesignals.AgeSignalsResult;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api._global.GetLoginServerAddressApiData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._type.user.RegisterType;
import com.soletreadmills.sole_v2.databinding.FragmentLogoBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.sun.jna.platform.win32.WinError;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: LogoFragment.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u001a\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\u001e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/logo/LogoFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentLogoBinding;", "()V", "isAgeChecked", "", "navigationJob", "Lkotlinx/coroutines/Job;", "checkAgeRequirement", "", "goNextPage", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "navigateToAgeInput", "onDestroyView", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "proceedNextStep", "showAgeDeniedDialog", "showPendingApprovalDialog", "tryToGetLoginAddressByOldAccount", "token", "", "oldType", "oldAccount", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LogoFragment extends BaseFragment<FragmentLogoBinding> {
    public static final int $stable = 8;
    private boolean isAgeChecked;
    private Job navigationJob;

    private final void navigateToAgeInput() {
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentLogoBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentLogoBinding fragmentLogoBindingInflate = FragmentLogoBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentLogoBindingInflate, "inflate(...)");
        return fragmentLogoBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        checkAgeRequirement();
    }

    private final void checkAgeRequirement() {
        Context context;
        if (this.isAgeChecked || (context = getContext()) == null) {
            return;
        }
        Timber.INSTANCE.d("開始 AgeSignals 檢查", new Object[0]);
        AgeSignalsManager ageSignalsManagerCreate = AgeSignalsManagerFactory.create(context);
        Intrinsics.checkNotNull(ageSignalsManagerCreate);
        Task<AgeSignalsResult> taskCheckAgeSignals = ageSignalsManagerCreate.checkAgeSignals(AgeSignalsRequest.builder().build());
        final Function1<AgeSignalsResult, Unit> function1 = new Function1<AgeSignalsResult, Unit>() { // from class: com.soletreadmills.sole_v2.ui.logo.LogoFragment.checkAgeRequirement.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AgeSignalsResult ageSignalsResult) {
                invoke2(ageSignalsResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AgeSignalsResult ageSignalsResult) {
                Integer numUserStatus = ageSignalsResult.userStatus();
                Timber.INSTANCE.d("Fake AgeSignals 結果 = " + numUserStatus, new Object[0]);
                if ((numUserStatus != null && numUserStatus.intValue() == 0) || (numUserStatus != null && numUserStatus.intValue() == 1)) {
                    LogoFragment.this.isAgeChecked = true;
                    Timber.INSTANCE.d("年齡合格，繼續流程", new Object[0]);
                    LogoFragment.this.proceedNextStep();
                    return;
                }
                if (numUserStatus != null && numUserStatus.intValue() == 3) {
                    Timber.INSTANCE.e("家長拒絕，禁止使用", new Object[0]);
                    LogoFragment.this.showAgeDeniedDialog();
                } else if (numUserStatus != null && numUserStatus.intValue() == 2) {
                    Timber.INSTANCE.e("需要家長批准（Fake）", new Object[0]);
                    LogoFragment.this.showPendingApprovalDialog();
                } else if (numUserStatus != null && numUserStatus.intValue() == 4) {
                    Timber.INSTANCE.e("無法取得年齡資訊（Fake）", new Object[0]);
                    LogoFragment.this.proceedNextStep();
                }
            }
        };
        taskCheckAgeSignals.addOnSuccessListener(new OnSuccessListener() { // from class: com.soletreadmills.sole_v2.ui.logo.LogoFragment$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                LogoFragment.checkAgeRequirement$lambda$1(function1, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.soletreadmills.sole_v2.ui.logo.LogoFragment$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                LogoFragment.checkAgeRequirement$lambda$2(this.f$0, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAgeRequirement$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAgeRequirement$lambda$2(LogoFragment this$0, Exception e) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(e, "e");
        Timber.INSTANCE.e(e, "Fake AgeSignals 執行失敗", new Object[0]);
        this$0.proceedNextStep();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void proceedNextStep() {
        String oldLoginToken = MySharedPreferences.INSTANCE.getInstance().getOldLoginToken();
        String oldType = MySharedPreferences.INSTANCE.getInstance().getOldType();
        String oldAccount = MySharedPreferences.INSTANCE.getInstance().getOldAccount();
        if (oldAccount == null) {
            oldAccount = "";
        }
        String str = oldLoginToken;
        if (str == null || str.length() == 0) {
            String sharedLoginToken = MySharedPreferences.INSTANCE.getInstance().getSharedLoginToken();
            if (sharedLoginToken.length() > 0) {
                Timber.INSTANCE.d("自動登入 Token: " + sharedLoginToken, new Object[0]);
                BaseFragment.loginToken$default(this, sharedLoginToken, false, null, 6, null);
                return;
            } else {
                goNextPage();
                return;
            }
        }
        MySharedPreferences.INSTANCE.getInstance().setSharedLoginToken(oldLoginToken);
        if (str.length() == 0 || oldType.length() == 0 || oldAccount.length() == 0) {
            goNextPage();
        } else {
            tryToGetLoginAddressByOldAccount(oldLoginToken, oldType, oldAccount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPendingApprovalDialog() {
        CustomDialogKt.showCustomDialog$default(this, getString(R.string.pendingApporveTitle), getString(R.string.pendingApporveMsg), null, null, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.logo.LogoFragment.showPendingApprovalDialog.1
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
                LogoFragment.this.requireActivity().finish();
            }
        }, null, false, 108, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAgeDeniedDialog() {
        CustomDialogKt.showCustomDialog$default(this, getString(R.string.app_name), getString(R.string.pendingApporveAlert), null, null, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.logo.LogoFragment.showAgeDeniedDialog.1
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
                LogoFragment.this.requireActivity().finish();
            }
        }, null, false, 108, null);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Job job = this.navigationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.navigationJob = null;
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goNextPage() {
        Job job = this.navigationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.navigationJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09871(null), 3, null);
    }

    /* compiled from: LogoFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.logo.LogoFragment$goNextPage$1", f = "LogoFragment.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.logo.LogoFragment$goNextPage$1, reason: invalid class name and case insensitive filesystem */
    static final class C09871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09871(Continuation<? super C09871> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LogoFragment.this.new C09871(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(3000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!LogoFragment.this.isAdded() || LogoFragment.this.getView() == null || LogoFragment.this.isDetached() || LogoFragment.this.isRemoving()) {
                return Unit.INSTANCE;
            }
            BaseFragment.safeNavigateAndClearStack$default(LogoFragment.this, R.id.chooseFragment, null, 2, null);
            return Unit.INSTANCE;
        }
    }

    public final void tryToGetLoginAddressByOldAccount(String token, String oldType, String oldAccount) {
        int id2;
        int i;
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(oldType, "oldType");
        Intrinsics.checkNotNullParameter(oldAccount, "oldAccount");
        int iHashCode = oldType.hashCode();
        if (iHashCode == -1986416409) {
            if (oldType.equals("NORMAL")) {
                id2 = RegisterType.Email.getId();
                i = id2;
            }
            i = -1;
        } else if (iHashCode != 1279756998) {
            if (iHashCode == 2108052025 && oldType.equals("GOOGLE")) {
                id2 = RegisterType.GOOGLE.getId();
                i = id2;
            }
            i = -1;
        } else {
            if (oldType.equals("FACEBOOK")) {
                id2 = RegisterType.FACEBOOK.getId();
                i = id2;
            }
            i = -1;
        }
        if (i == -1) {
            goNextPage();
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09901(i, oldAccount, token, null), 3, null);
    }

    /* compiled from: LogoFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.logo.LogoFragment$tryToGetLoginAddressByOldAccount$1", f = "LogoFragment.kt", i = {}, l = {WinError.ERROR_FILE_CHECKED_OUT}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.logo.LogoFragment$tryToGetLoginAddressByOldAccount$1, reason: invalid class name and case insensitive filesystem */
    static final class C09901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $oldAccount;
        final /* synthetic */ String $token;
        final /* synthetic */ int $typeId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09901(int i, String str, String str2, Continuation<? super C09901> continuation) {
            super(2, continuation);
            this.$typeId = i;
            this.$oldAccount = str;
            this.$token = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LogoFragment.this.new C09901(this.$typeId, this.$oldAccount, this.$token, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!LogoFragment.this.isAdded() || LogoFragment.this.getView() == null || LogoFragment.this.isDetached() || LogoFragment.this.isRemoving()) {
                        return Unit.INSTANCE;
                    }
                    this.label = 1;
                    obj = DyacoApiKt.callGetLoginServerAddress(new GetLoginServerAddressApiData.RequestBodyData(this.$typeId, this.$oldAccount), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                GetLoginServerAddressApiData.ResponseData responseData = (GetLoginServerAddressApiData.ResponseData) ((Response) obj).body();
                if (responseData != null && responseData.getSuccess()) {
                    GetLoginServerAddressApiData.DataMap dataMap = responseData.getDataMap();
                    String data = dataMap != null ? dataMap.getData() : null;
                    Timber.INSTANCE.d("Logo loginServerAddress: " + data, new Object[0]);
                    MySharedPreferences.INSTANCE.getInstance().setSharedBaseUrl(data);
                    Timber.INSTANCE.d("Logo now SharedBaseUrl " + MySharedPreferences.INSTANCE.getInstance().getSharedBaseUrl(), new Object[0]);
                    BaseFragment.loginToken$default(LogoFragment.this, this.$token, false, null, 6, null);
                } else {
                    Timber.INSTANCE.e("loginServerAddressRes:error", new Object[0]);
                    LogoFragment.this.goNextPage();
                }
            } catch (Exception e) {
                LogoFragment.this.goNextPage();
                Timber.INSTANCE.e("用舊token登入:error", new Object[0]);
                Timber.INSTANCE.e(e);
            }
            return Unit.INSTANCE;
        }
    }
}
