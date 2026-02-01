package com.soletreadmills.sole_v2.ui.settings.subscription;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import com.soletreadmills.sole_v2._data.api.JwtErrorCode;
import com.soletreadmills.sole_v2._data.api.settings.DeleteSubscriptionApiData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.JwtDyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentCancelSubscriptionBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: CancelSubscriptionFragment.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/subscription/CancelSubscriptionFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentCancelSubscriptionBinding;", "Landroid/view/View$OnClickListener;", "()V", "userCard", "", "getUserCard", "()Ljava/lang/String;", "setUserCard", "(Ljava/lang/String;)V", "userSubscriptionId", "getUserSubscriptionId", "setUserSubscriptionId", "checkCancel", "", "deleteSubscription", "requestBody", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionApiData$RequestBodyData;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CancelSubscriptionFragment extends BaseFragment<FragmentCancelSubscriptionBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private String userSubscriptionId = "";
    private String userCard = "";

    public final String getUserSubscriptionId() {
        return this.userSubscriptionId;
    }

    public final void setUserSubscriptionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userSubscriptionId = str;
    }

    public final String getUserCard() {
        return this.userCard;
    }

    public final void setUserCard(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userCard = str;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentCancelSubscriptionBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentCancelSubscriptionBinding fragmentCancelSubscriptionBindingInflate = FragmentCancelSubscriptionBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentCancelSubscriptionBindingInflate, "inflate(...)");
        return fragmentCancelSubscriptionBindingInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("userSubscriptionId");
            String str = "";
            if (string == null) {
                string = "";
            } else {
                Intrinsics.checkNotNull(string);
            }
            this.userSubscriptionId = string;
            String string2 = arguments.getString("userCard");
            if (string2 != null) {
                Intrinsics.checkNotNull(string2);
                str = string2;
            }
            this.userCard = str;
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        RadioGroup radioGroup;
        LinearLayout linearLayout;
        ImageView imageView;
        FragmentCancelSubscriptionBinding binding = getBinding();
        if (binding != null && (imageView = binding.imgBack) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentCancelSubscriptionBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout = binding2.LLCancelSubscription) != null) {
            linearLayout.setOnClickListener(this);
        }
        FragmentCancelSubscriptionBinding binding3 = getBinding();
        if (binding3 == null || (radioGroup = binding3.radioGroupReasons) == null) {
            return;
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.CancelSubscriptionFragment$$ExternalSyntheticLambda0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                CancelSubscriptionFragment.initViews$lambda$1(this.f$0, radioGroup2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(CancelSubscriptionFragment this$0, RadioGroup radioGroup, int i) {
        EditText editText;
        EditText editText2;
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == R.id.rb_other) {
            FragmentCancelSubscriptionBinding binding = this$0.getBinding();
            editText = binding != null ? binding.etOtherReason : null;
            if (editText == null) {
                return;
            }
            editText.setVisibility(0);
            return;
        }
        FragmentCancelSubscriptionBinding binding2 = this$0.getBinding();
        editText = binding2 != null ? binding2.etOtherReason : null;
        if (editText != null) {
            editText.setVisibility(8);
        }
        FragmentCancelSubscriptionBinding binding3 = this$0.getBinding();
        if (binding3 == null || (editText2 = binding3.etOtherReason) == null || (text = editText2.getText()) == null) {
            return;
        }
        text.clear();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.img_back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.LL_cancelSubscription;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            checkCancel();
        }
    }

    public final void checkCancel() {
        EditText editText;
        RadioGroup radioGroup;
        View root;
        RadioGroup radioGroup2;
        FragmentCancelSubscriptionBinding binding = getBinding();
        Editable text = null;
        Integer numValueOf = (binding == null || (radioGroup2 = binding.radioGroupReasons) == null) ? null : Integer.valueOf(radioGroup2.getCheckedRadioButtonId());
        if ((numValueOf != null && numValueOf.intValue() == -1) || numValueOf == null) {
            return;
        }
        FragmentCancelSubscriptionBinding binding2 = getBinding();
        RadioButton radioButton = (binding2 == null || (root = binding2.getRoot()) == null) ? null : (RadioButton) root.findViewById(numValueOf.intValue());
        String strValueOf = String.valueOf(radioButton != null ? radioButton.getText() : null);
        FragmentCancelSubscriptionBinding binding3 = getBinding();
        Integer numValueOf2 = (binding3 == null || (radioGroup = binding3.radioGroupReasons) == null) ? null : Integer.valueOf(radioGroup.indexOfChild(radioButton));
        Timber.INSTANCE.e("CancelSubscription %s", "選擇了第 " + numValueOf2 + " 項：" + strValueOf);
        FragmentCancelSubscriptionBinding binding4 = getBinding();
        if (binding4 != null && (editText = binding4.etOtherReason) != null) {
            text = editText.getText();
        }
        String string = StringsKt.trim((CharSequence) String.valueOf(text)).toString();
        if (numValueOf.intValue() == R.id.rb_other) {
            if (string.length() == 0) {
                CustomDialogKt.showCustomDialog$default(this, "", getString(R.string.please_enter_a_reason), getString(R.string.confirm), null, null, null, false, 112, null);
                return;
            }
            Timber.INSTANCE.e("CancelSubscription %s", "其他原因: " + string);
        }
        if (numValueOf2 != null) {
            deleteSubscription(new DeleteSubscriptionApiData.RequestBodyData(Long.valueOf(System.currentTimeMillis()), string, Integer.valueOf(numValueOf2.intValue() + 1), this.userSubscriptionId));
        }
    }

    /* compiled from: CancelSubscriptionFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.subscription.CancelSubscriptionFragment$deleteSubscription$1", f = "CancelSubscriptionFragment.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.subscription.CancelSubscriptionFragment$deleteSubscription$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DeleteSubscriptionApiData.RequestBodyData $requestBody;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DeleteSubscriptionApiData.RequestBodyData requestBodyData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$requestBody = requestBodyData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CancelSubscriptionFragment.this.new AnonymousClass1(this.$requestBody, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            JwtApiBaseData.SysResponseMessage sysMsg;
            JwtApiBaseData.SysResponseMessage sysMsg2;
            JwtApiBaseData.SysResponseMessage sysMsg3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CancelSubscriptionFragment.this.showLoading();
                        this.label = 1;
                        obj = JwtDyacoApiKt.callDeleteSubscription(this.$requestBody, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    DeleteSubscriptionApiData.ResponseData responseData = (DeleteSubscriptionApiData.ResponseData) ((Response) obj).body();
                    String message = null;
                    if (!Intrinsics.areEqual((responseData == null || (sysMsg3 = responseData.getSysMsg()) == null) ? null : sysMsg3.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                        String code = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                        if (CancelSubscriptionFragment.this.shouldIgnoreError(code)) {
                            return Unit.INSTANCE;
                        }
                        CancelSubscriptionFragment cancelSubscriptionFragment = CancelSubscriptionFragment.this;
                        if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                            message = sysMsg.getMessage();
                        }
                        BaseFragment.handleUndefinedError$default(cancelSubscriptionFragment, "deleteSubscription", code, message, false, 8, null);
                    } else {
                        Global.INSTANCE.setSubscription(false);
                        if (CancelSubscriptionFragment.this.getUserCard().length() == 0) {
                            BaseFragment.safeNavigateWithPopUp$default(CancelSubscriptionFragment.this, R.id.payWallFragment, R.id.settingsMainFragment, false, null, 8, null);
                        } else {
                            BaseFragment.safeNavigateWithPopUp$default(CancelSubscriptionFragment.this, R.id.userSubscriptionFragment, R.id.settingsMainFragment, false, null, 8, null);
                        }
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(CancelSubscriptionFragment.this, "deleteSubscription", message2, false, 4, null);
                }
                CancelSubscriptionFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                CancelSubscriptionFragment.this.stopLoading();
            }
        }
    }

    public final void deleteSubscription(DeleteSubscriptionApiData.RequestBodyData requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(requestBody, null), 3, null);
    }
}
