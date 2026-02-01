package com.soletreadmills.sole_v2.ui.settings.subscription;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.android.SdkConstants;
import com.bumptech.glide.Glide;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import com.soletreadmills.sole_v2._data.api.JwtErrorCode;
import com.soletreadmills.sole_v2._data.api.settings.ChangeSubscriptionPlanApiData;
import com.soletreadmills.sole_v2._data.api.settings.DeleteSubscriptionMethodApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetUserSubscriptionApiData;
import com.soletreadmills.sole_v2._data.api.settings.ReSubscriptionApiData;
import com.soletreadmills.sole_v2._data.api.settings.UpdateSubscriptionPaymentLinkApiData;
import com.soletreadmills.sole_v2._data.classes.SubscriptionStatusType;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._extension.StringExtensionsKt;
import com.soletreadmills.sole_v2._network.JwtDyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentUserSubscriptionBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: UserSubscriptionFragment.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0011\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0006J\b\u0010%\u001a\u00020\fH\u0007R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006&"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/subscription/UserSubscriptionFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentUserSubscriptionBinding;", "Landroid/view/View$OnClickListener;", "()V", "userSubscriptionData", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$UserSubscriptionData;", "getUserSubscriptionData", "()Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$UserSubscriptionData;", "setUserSubscriptionData", "(Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$UserSubscriptionData;)V", "changePlan", "", "priceId", "", "deleteSubscriptionMethod", "userSubscriptionId", "getSubscription", "getUpdateSubscriptionPaymentLink", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reSubscription", "setCancelStatus", "userSubscriptionDataTemp", "setChangePlan", "setHasCard", "setPayFailed", "setView", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserSubscriptionFragment extends BaseFragment<FragmentUserSubscriptionBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private GetUserSubscriptionApiData.UserSubscriptionData userSubscriptionData;

    public final GetUserSubscriptionApiData.UserSubscriptionData getUserSubscriptionData() {
        return this.userSubscriptionData;
    }

    public final void setUserSubscriptionData(GetUserSubscriptionApiData.UserSubscriptionData userSubscriptionData) {
        this.userSubscriptionData = userSubscriptionData;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentKt.setFragmentResultListener(this, PayWallFragment.REQUEST_KEY_PAY_WEB, new Function2<String, Bundle, Unit>() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment.onCreate.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
                invoke2(str, bundle);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String requestKey, Bundle bundle) {
                Intrinsics.checkNotNullParameter(requestKey, "requestKey");
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (Intrinsics.areEqual(requestKey, PayWallFragment.REQUEST_KEY_PAY_WEB)) {
                    String string = bundle.getString(PayWallFragment.RESULT_KEY_PAY_WEB);
                    if (string == null) {
                        string = "";
                    }
                    String str = string;
                    if (StringsKt.contains$default((CharSequence) str, (CharSequence) "purchase_completed", false, 2, (Object) null)) {
                        return;
                    }
                    StringsKt.contains$default((CharSequence) str, (CharSequence) "attach_card_completed", false, 2, (Object) null);
                }
            }
        });
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentUserSubscriptionBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentUserSubscriptionBinding fragmentUserSubscriptionBindingInflate = FragmentUserSubscriptionBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentUserSubscriptionBindingInflate, "inflate(...)");
        return fragmentUserSubscriptionBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        LinearLayout linearLayout7;
        ImageView imageView;
        FragmentUserSubscriptionBinding binding = getBinding();
        if (binding != null && (imageView = binding.back) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentUserSubscriptionBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout7 = binding2.LLSeePlans) != null) {
            linearLayout7.setOnClickListener(this);
        }
        FragmentUserSubscriptionBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout6 = binding3.LLCancelSubscription) != null) {
            linearLayout6.setOnClickListener(this);
        }
        FragmentUserSubscriptionBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout5 = binding4.LLManageBilling) != null) {
            linearLayout5.setOnClickListener(this);
        }
        FragmentUserSubscriptionBinding binding5 = getBinding();
        if (binding5 != null && (linearLayout4 = binding5.LLChangeToOtherPlan) != null) {
            linearLayout4.setOnClickListener(this);
        }
        FragmentUserSubscriptionBinding binding6 = getBinding();
        if (binding6 != null && (linearLayout3 = binding6.LLRenewSubscription) != null) {
            linearLayout3.setOnClickListener(this);
        }
        FragmentUserSubscriptionBinding binding7 = getBinding();
        if (binding7 != null && (linearLayout2 = binding7.LLRemoveCard) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentUserSubscriptionBinding binding8 = getBinding();
        if (binding8 != null && (linearLayout = binding8.LLGetPremium) != null) {
            linearLayout.setOnClickListener(this);
        }
        getSubscription();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        final GetUserSubscriptionApiData.ChangePlan change_plan;
        String billing_management_link;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.LL_seePlans;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            BaseFragment.safeNavigate$default(this, R.id.payWallFragment, null, 2, null);
            return;
        }
        int i3 = R.id.LL_cancelSubscription;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            GetUserSubscriptionApiData.UserSubscriptionData userSubscriptionData = this.userSubscriptionData;
            if (userSubscriptionData == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("userSubscriptionId", userSubscriptionData.getUser_subscription_id());
            bundle.putString("userCard", userSubscriptionData.getCard_last4());
            safeNavigate(R.id.cancelSubscriptionFragment, bundle);
            return;
        }
        int i4 = R.id.LL_manageBilling;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            try {
                GetUserSubscriptionApiData.UserSubscriptionData userSubscriptionData2 = this.userSubscriptionData;
                if (userSubscriptionData2 != null && (billing_management_link = userSubscriptionData2.getBilling_management_link()) != null) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(billing_management_link)));
                    return;
                }
                return;
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
                return;
            }
        }
        int i5 = R.id.LL_changeToOtherPlan;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            GetUserSubscriptionApiData.UserSubscriptionData userSubscriptionData3 = this.userSubscriptionData;
            if (userSubscriptionData3 == null || (change_plan = userSubscriptionData3.getChange_plan()) == null) {
                return;
            }
            CustomDialogKt.showCustomDialog$default(this, change_plan.getTitle() + '?', change_plan.getCharge_desc(), getString(R.string.update_plan), getString(R.string.cancel), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment.onClick.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    UserSubscriptionFragment.this.changePlan(change_plan.getPrice_id());
                }
            }, null, false, 96, null);
            return;
        }
        int i6 = R.id.LL_renewSubscription;
        if (numValueOf != null && numValueOf.intValue() == i6) {
            final GetUserSubscriptionApiData.UserSubscriptionData userSubscriptionData4 = this.userSubscriptionData;
            if (userSubscriptionData4 == null) {
                return;
            }
            CustomDialogKt.showCustomDialog$default(this, getString(R.string.renew_subscription), userSubscriptionData4.getRenewal_desc(), getString(R.string.confirm), getString(R.string.not_now), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment.onClick.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    UserSubscriptionFragment.this.reSubscription(userSubscriptionData4.getUser_subscription_id());
                }
            }, null, false, 96, null);
            return;
        }
        int i7 = R.id.LL_removeCard;
        if (numValueOf != null && numValueOf.intValue() == i7) {
            final GetUserSubscriptionApiData.UserSubscriptionData userSubscriptionData5 = this.userSubscriptionData;
            if (userSubscriptionData5 == null) {
                return;
            }
            CustomDialogKt.showCustomDialog$default(this, getString(R.string.remove_card_hint), "", getString(R.string.remove_card), getString(R.string.cancel), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment.onClick.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    UserSubscriptionFragment.this.deleteSubscriptionMethod(userSubscriptionData5.getUser_subscription_id());
                }
            }, null, false, 96, null);
            return;
        }
        int i8 = R.id.LL_getPremium;
        if (numValueOf != null && numValueOf.intValue() == i8) {
            BaseFragment.safeNavigateWithPopUp$default(this, R.id.payWallFragment, R.id.settingsMainFragment, false, null, 8, null);
        }
    }

    public final void setView() {
        Context context;
        GetUserSubscriptionApiData.UserSubscriptionData userSubscriptionData = this.userSubscriptionData;
        if (userSubscriptionData == null || (context = getContext()) == null) {
            return;
        }
        FragmentUserSubscriptionBinding binding = getBinding();
        LinearLayout linearLayout = binding != null ? binding.LLGetPremium : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        String subscription_method = userSubscriptionData.getSubscription_method();
        if (subscription_method != null) {
            int iHashCode = subscription_method.hashCode();
            if (iHashCode != 2464) {
                if (iHashCode != 2557) {
                    if (iHashCode != 2569) {
                        if (iHashCode != 76251) {
                            if (iHashCode == 76648 && subscription_method.equals("MSN")) {
                                FragmentUserSubscriptionBinding binding2 = getBinding();
                                LinearLayout linearLayout2 = binding2 != null ? binding2.LLCard : null;
                                if (linearLayout2 != null) {
                                    linearLayout2.setVisibility(8);
                                }
                                FragmentUserSubscriptionBinding binding3 = getBinding();
                                LinearLayout linearLayout3 = binding3 != null ? binding3.LLChangePlans : null;
                                if (linearLayout3 != null) {
                                    linearLayout3.setVisibility(8);
                                }
                                FragmentUserSubscriptionBinding binding4 = getBinding();
                                TextView textView = binding4 != null ? binding4.tvFailed : null;
                                if (textView != null) {
                                    textView.setVisibility(8);
                                }
                                FragmentUserSubscriptionBinding binding5 = getBinding();
                                LinearLayout linearLayout4 = binding5 != null ? binding5.LLManageBilling : null;
                                if (linearLayout4 != null) {
                                    linearLayout4.setVisibility(8);
                                }
                                FragmentUserSubscriptionBinding binding6 = getBinding();
                                LinearLayout linearLayout5 = binding6 != null ? binding6.LLSeePlans : null;
                                if (linearLayout5 != null) {
                                    linearLayout5.setVisibility(0);
                                }
                                FragmentUserSubscriptionBinding binding7 = getBinding();
                                TextView textView2 = binding7 != null ? binding7.tvSubscriptionMethod : null;
                                if (textView2 != null) {
                                    textView2.setText(getString(R.string.sole_exclusive));
                                }
                            }
                        } else if (subscription_method.equals("MFT")) {
                            FragmentUserSubscriptionBinding binding8 = getBinding();
                            LinearLayout linearLayout6 = binding8 != null ? binding8.LLCard : null;
                            if (linearLayout6 != null) {
                                linearLayout6.setVisibility(0);
                            }
                            FragmentUserSubscriptionBinding binding9 = getBinding();
                            LinearLayout linearLayout7 = binding9 != null ? binding9.LLChangePlans : null;
                            if (linearLayout7 != null) {
                                linearLayout7.setVisibility(0);
                            }
                            FragmentUserSubscriptionBinding binding10 = getBinding();
                            TextView textView3 = binding10 != null ? binding10.tvFailed : null;
                            if (textView3 != null) {
                                textView3.setVisibility(8);
                            }
                            FragmentUserSubscriptionBinding binding11 = getBinding();
                            LinearLayout linearLayout8 = binding11 != null ? binding11.LLManageBilling : null;
                            if (linearLayout8 != null) {
                                linearLayout8.setVisibility(0);
                            }
                            FragmentUserSubscriptionBinding binding12 = getBinding();
                            LinearLayout linearLayout9 = binding12 != null ? binding12.LLSeePlans : null;
                            if (linearLayout9 != null) {
                                linearLayout9.setVisibility(8);
                            }
                            setChangePlan(userSubscriptionData);
                            setCancelStatus(userSubscriptionData);
                            setHasCard(userSubscriptionData);
                            FragmentUserSubscriptionBinding binding13 = getBinding();
                            TextView textView4 = binding13 != null ? binding13.tvSubscriptionMethod : null;
                            if (textView4 != null) {
                                textView4.setText(getString(R.string.monthly_plan));
                            }
                        }
                    } else if (subscription_method.equals("PY")) {
                        FragmentUserSubscriptionBinding binding14 = getBinding();
                        LinearLayout linearLayout10 = binding14 != null ? binding14.LLCard : null;
                        if (linearLayout10 != null) {
                            linearLayout10.setVisibility(0);
                        }
                        FragmentUserSubscriptionBinding binding15 = getBinding();
                        LinearLayout linearLayout11 = binding15 != null ? binding15.LLChangePlans : null;
                        if (linearLayout11 != null) {
                            linearLayout11.setVisibility(0);
                        }
                        FragmentUserSubscriptionBinding binding16 = getBinding();
                        LinearLayout linearLayout12 = binding16 != null ? binding16.LLManageBilling : null;
                        if (linearLayout12 != null) {
                            linearLayout12.setVisibility(0);
                        }
                        FragmentUserSubscriptionBinding binding17 = getBinding();
                        LinearLayout linearLayout13 = binding17 != null ? binding17.LLSeePlans : null;
                        if (linearLayout13 != null) {
                            linearLayout13.setVisibility(8);
                        }
                        setPayFailed(userSubscriptionData);
                        setChangePlan(userSubscriptionData);
                        setCancelStatus(userSubscriptionData);
                        setHasCard(userSubscriptionData);
                        FragmentUserSubscriptionBinding binding18 = getBinding();
                        TextView textView5 = binding18 != null ? binding18.tvSubscriptionMethod : null;
                        if (textView5 != null) {
                            textView5.setText(getString(R.string.yearly_plan));
                        }
                    }
                } else if (subscription_method.equals("PM")) {
                    FragmentUserSubscriptionBinding binding19 = getBinding();
                    LinearLayout linearLayout14 = binding19 != null ? binding19.LLCard : null;
                    if (linearLayout14 != null) {
                        linearLayout14.setVisibility(0);
                    }
                    FragmentUserSubscriptionBinding binding20 = getBinding();
                    LinearLayout linearLayout15 = binding20 != null ? binding20.LLChangePlans : null;
                    if (linearLayout15 != null) {
                        linearLayout15.setVisibility(0);
                    }
                    FragmentUserSubscriptionBinding binding21 = getBinding();
                    LinearLayout linearLayout16 = binding21 != null ? binding21.LLManageBilling : null;
                    if (linearLayout16 != null) {
                        linearLayout16.setVisibility(0);
                    }
                    FragmentUserSubscriptionBinding binding22 = getBinding();
                    LinearLayout linearLayout17 = binding22 != null ? binding22.LLSeePlans : null;
                    if (linearLayout17 != null) {
                        linearLayout17.setVisibility(8);
                    }
                    setPayFailed(userSubscriptionData);
                    setChangePlan(userSubscriptionData);
                    setCancelStatus(userSubscriptionData);
                    setHasCard(userSubscriptionData);
                    FragmentUserSubscriptionBinding binding23 = getBinding();
                    TextView textView6 = binding23 != null ? binding23.tvSubscriptionMethod : null;
                    if (textView6 != null) {
                        textView6.setText(getString(R.string.monthly_plan));
                    }
                }
            } else if (subscription_method.equals("MM")) {
                FragmentUserSubscriptionBinding binding24 = getBinding();
                LinearLayout linearLayout18 = binding24 != null ? binding24.LLCard : null;
                if (linearLayout18 != null) {
                    linearLayout18.setVisibility(8);
                }
                FragmentUserSubscriptionBinding binding25 = getBinding();
                LinearLayout linearLayout19 = binding25 != null ? binding25.LLChangePlans : null;
                if (linearLayout19 != null) {
                    linearLayout19.setVisibility(8);
                }
                FragmentUserSubscriptionBinding binding26 = getBinding();
                TextView textView7 = binding26 != null ? binding26.tvFailed : null;
                if (textView7 != null) {
                    textView7.setVisibility(8);
                }
                FragmentUserSubscriptionBinding binding27 = getBinding();
                LinearLayout linearLayout20 = binding27 != null ? binding27.LLManageBilling : null;
                if (linearLayout20 != null) {
                    linearLayout20.setVisibility(8);
                }
                FragmentUserSubscriptionBinding binding28 = getBinding();
                LinearLayout linearLayout21 = binding28 != null ? binding28.LLSeePlans : null;
                if (linearLayout21 != null) {
                    linearLayout21.setVisibility(0);
                }
                FragmentUserSubscriptionBinding binding29 = getBinding();
                TextView textView8 = binding29 != null ? binding29.tvSubscriptionMethod : null;
                if (textView8 != null) {
                    textView8.setText(getString(R.string.sole_exclusive));
                }
            }
        }
        SubscriptionStatusType subscription_status = userSubscriptionData.getSubscription_status();
        if (subscription_status == null || !SubscriptionStatusType.INSTANCE.isSubscribedOrTrial(subscription_status)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long end_time_millis = userSubscriptionData.getEnd_time_millis();
            if (jCurrentTimeMillis >= (end_time_millis != null ? end_time_millis.longValue() : 0L)) {
                FragmentUserSubscriptionBinding binding30 = getBinding();
                LinearLayout linearLayout22 = binding30 != null ? binding30.LLGetPremium : null;
                if (linearLayout22 != null) {
                    linearLayout22.setVisibility(0);
                }
                FragmentUserSubscriptionBinding binding31 = getBinding();
                LinearLayout linearLayout23 = binding31 != null ? binding31.LLManageBilling : null;
                if (linearLayout23 != null) {
                    linearLayout23.setVisibility(0);
                }
                FragmentUserSubscriptionBinding binding32 = getBinding();
                LinearLayout linearLayout24 = binding32 != null ? binding32.LLSeePlans : null;
                if (linearLayout24 != null) {
                    linearLayout24.setVisibility(8);
                }
                FragmentUserSubscriptionBinding binding33 = getBinding();
                LinearLayout linearLayout25 = binding33 != null ? binding33.LLCancelStatus : null;
                if (linearLayout25 != null) {
                    linearLayout25.setVisibility(0);
                }
            }
        }
        FragmentUserSubscriptionBinding binding34 = getBinding();
        TextView textView9 = binding34 != null ? binding34.tvDesc : null;
        if (textView9 != null) {
            textView9.setText(userSubscriptionData.getDesc());
        }
        FragmentUserSubscriptionBinding binding35 = getBinding();
        TextView textView10 = binding35 != null ? binding35.tvFee : null;
        if (textView10 != null) {
            textView10.setText(userSubscriptionData.getFee());
        }
        String card_last4 = userSubscriptionData.getCard_last4();
        String str = card_last4;
        if (str != null && str.length() != 0) {
            FragmentUserSubscriptionBinding binding36 = getBinding();
            TextView textView11 = binding36 != null ? binding36.tvCard : null;
            if (textView11 != null) {
                textView11.setText("•••• " + card_last4);
            }
            try {
                FragmentUserSubscriptionBinding binding37 = getBinding();
                if (binding37 != null) {
                    Glide.with(context).load(userSubscriptionData.getCard_brand_logo_url()).into(binding37.imgCard);
                }
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
            }
        }
        FragmentUserSubscriptionBinding binding38 = getBinding();
        LinearLayout linearLayout26 = binding38 != null ? binding38.LLALL : null;
        if (linearLayout26 == null) {
            return;
        }
        linearLayout26.setVisibility(0);
    }

    public final void setPayFailed(final GetUserSubscriptionApiData.UserSubscriptionData userSubscriptionDataTemp) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(userSubscriptionDataTemp, "userSubscriptionDataTemp");
        final Context context = getContext();
        if (context == null) {
            return;
        }
        String valid_and_sufficient_desc = userSubscriptionDataTemp.getValid_and_sufficient_desc();
        if (valid_and_sufficient_desc == null || valid_and_sufficient_desc.length() == 0) {
            FragmentUserSubscriptionBinding binding = getBinding();
            TextView textView3 = binding != null ? binding.tvFailed : null;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            FragmentUserSubscriptionBinding binding2 = getBinding();
            ImageView imageView = binding2 != null ? binding2.imgFailed : null;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        FragmentUserSubscriptionBinding binding3 = getBinding();
        TextView textView4 = binding3 != null ? binding3.tvFailed : null;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        FragmentUserSubscriptionBinding binding4 = getBinding();
        ImageView imageView2 = binding4 != null ? binding4.imgFailed : null;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        FragmentUserSubscriptionBinding binding5 = getBinding();
        TextView textView5 = binding5 != null ? binding5.tvFailed : null;
        if (textView5 != null) {
            textView5.setText(userSubscriptionDataTemp.getValid_and_sufficient_desc());
        }
        FragmentUserSubscriptionBinding binding6 = getBinding();
        if (binding6 != null && (textView2 = binding6.tvDesc) != null) {
            textView2.setTextColor(ContextCompat.getColor(context, R.color.colorGlobal_notice));
        }
        FragmentUserSubscriptionBinding binding7 = getBinding();
        if (binding7 != null && (textView = binding7.tvCard) != null) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorGlobal_notice));
        }
        FragmentUserSubscriptionBinding binding8 = getBinding();
        TextView textView6 = binding8 != null ? binding8.tvFailed : null;
        String valid_and_sufficient_desc2 = userSubscriptionDataTemp.getValid_and_sufficient_desc();
        Regex regex = new Regex("<UpdatePaymentMethod>(.*?)</UpdatePaymentMethod>");
        String str = valid_and_sufficient_desc2;
        MatchResult matchResultFind$default = Regex.find$default(regex, str, 0, 2, null);
        if (matchResultFind$default != null) {
            String str2 = matchResultFind$default.getGroupValues().get(1);
            String strReplace = regex.replace(str, str2);
            SpannableString spannableString = new SpannableString(strReplace);
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) strReplace, str2, 0, false, 6, (Object) null);
            spannableString.setSpan(new ClickableSpan() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment$setPayFailed$clickableSpan$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    this.this$0.getUpdateSubscriptionPaymentLink(userSubscriptionDataTemp.getUser_subscription_id());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    super.updateDrawState(ds);
                    ds.setColor(ContextCompat.getColor(context, R.color.colorGlobal_accent));
                    ds.setUnderlineText(true);
                }
            }, iIndexOf$default, str2.length() + iIndexOf$default, 33);
            if (textView6 != null) {
                textView6.setText(spannableString);
            }
            if (textView6 != null) {
                textView6.setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (textView6 == null) {
                return;
            }
            textView6.setHighlightColor(0);
        }
    }

    public final void setChangePlan(GetUserSubscriptionApiData.UserSubscriptionData userSubscriptionDataTemp) {
        Intrinsics.checkNotNullParameter(userSubscriptionDataTemp, "userSubscriptionDataTemp");
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (userSubscriptionDataTemp.getChange_plan() == null) {
            FragmentUserSubscriptionBinding binding = getBinding();
            LinearLayout linearLayout = binding != null ? binding.LLChangePlans : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        FragmentUserSubscriptionBinding binding2 = getBinding();
        LinearLayout linearLayout2 = binding2 != null ? binding2.LLChangePlans : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        FragmentUserSubscriptionBinding binding3 = getBinding();
        TextView textView = binding3 != null ? binding3.tvChangeTitle : null;
        if (textView != null) {
            textView.setText(userSubscriptionDataTemp.getChange_plan().getTitle());
        }
        FragmentUserSubscriptionBinding binding4 = getBinding();
        TextView textView2 = binding4 != null ? binding4.tvChangeFee : null;
        if (textView2 != null) {
            textView2.setText(userSubscriptionDataTemp.getChange_plan().getFee());
        }
        FragmentUserSubscriptionBinding binding5 = getBinding();
        TextView textView3 = binding5 != null ? binding5.tvChangeDesc : null;
        if (textView3 == null) {
            return;
        }
        String desc = userSubscriptionDataTemp.getChange_plan().getDesc();
        textView3.setText(desc != null ? StringExtensionsKt.withHighlight(desc, ContextCompat.getColor(context, R.color.colorGlobal_notice)) : null);
    }

    public final void setCancelStatus(GetUserSubscriptionApiData.UserSubscriptionData userSubscriptionDataTemp) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(userSubscriptionDataTemp, "userSubscriptionDataTemp");
        if (userSubscriptionDataTemp.getSubscription_status() == SubscriptionStatusType.CancelSubscription) {
            FragmentUserSubscriptionBinding binding = getBinding();
            LinearLayout linearLayout2 = binding != null ? binding.LLCancelStatus : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            FragmentUserSubscriptionBinding binding2 = getBinding();
            linearLayout = binding2 != null ? binding2.LLCancelSubscription : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        FragmentUserSubscriptionBinding binding3 = getBinding();
        LinearLayout linearLayout3 = binding3 != null ? binding3.LLCancelStatus : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        FragmentUserSubscriptionBinding binding4 = getBinding();
        linearLayout = binding4 != null ? binding4.LLCancelSubscription : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(0);
    }

    public final void setHasCard(GetUserSubscriptionApiData.UserSubscriptionData userSubscriptionDataTemp) {
        View view;
        Intrinsics.checkNotNullParameter(userSubscriptionDataTemp, "userSubscriptionDataTemp");
        if (userSubscriptionDataTemp.getSubscription_status() == SubscriptionStatusType.CancelSubscription) {
            if (userSubscriptionDataTemp.getCard_last4() == null) {
                FragmentUserSubscriptionBinding binding = getBinding();
                LinearLayout linearLayout = binding != null ? binding.LLCancelStatus : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            } else {
                FragmentUserSubscriptionBinding binding2 = getBinding();
                LinearLayout linearLayout2 = binding2 != null ? binding2.LLCancelStatus : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
            }
        }
        if (userSubscriptionDataTemp.getCard_last4() == null) {
            FragmentUserSubscriptionBinding binding3 = getBinding();
            LinearLayout linearLayout3 = binding3 != null ? binding3.LLCard : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            FragmentUserSubscriptionBinding binding4 = getBinding();
            view = binding4 != null ? binding4.viewManageBilling : null;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        FragmentUserSubscriptionBinding binding5 = getBinding();
        LinearLayout linearLayout4 = binding5 != null ? binding5.LLCard : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(0);
        }
        FragmentUserSubscriptionBinding binding6 = getBinding();
        view = binding6 != null ? binding6.viewManageBilling : null;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    /* compiled from: UserSubscriptionFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment$getSubscription$1", f = "UserSubscriptionFragment.kt", i = {}, l = {374, 377}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment$getSubscription$1, reason: invalid class name and case insensitive filesystem */
    static final class C10181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C10181(Continuation<? super C10181> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UserSubscriptionFragment.this.new C10181(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0074 A[Catch: all -> 0x001e, Exception -> 0x0021, TryCatch #1 {Exception -> 0x0021, blocks: (B:6:0x000e, B:23:0x0051, B:25:0x005c, B:27:0x0062, B:29:0x0068, B:31:0x0074, B:33:0x0085, B:35:0x008b, B:37:0x0091, B:39:0x0099, B:42:0x00a6, B:44:0x00ac, B:46:0x00b2, B:47:0x00b6, B:10:0x001a, B:20:0x003a, B:17:0x0027), top: B:57:0x0008, outer: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                Method dump skipped, instructions count: 242
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment.C10181.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void getSubscription() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C10181(null), 3, null);
    }

    /* compiled from: UserSubscriptionFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment$changePlan$1", f = "UserSubscriptionFragment.kt", i = {}, l = {TypedValues.CycleType.TYPE_WAVE_OFFSET}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment$changePlan$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $priceId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$priceId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UserSubscriptionFragment.this.new AnonymousClass1(this.$priceId, continuation);
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
                        UserSubscriptionFragment.this.showLoading();
                        this.label = 1;
                        obj = JwtDyacoApiKt.callChangeSubscriptionPlan(new ChangeSubscriptionPlanApiData.RequestBody(this.$priceId), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    ChangeSubscriptionPlanApiData.ResponseData responseData = (ChangeSubscriptionPlanApiData.ResponseData) ((Response) obj).body();
                    String message = null;
                    if (!Intrinsics.areEqual((responseData == null || (sysMsg3 = responseData.getSysMsg()) == null) ? null : sysMsg3.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                        String code = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                        if (UserSubscriptionFragment.this.shouldIgnoreError(code)) {
                            return Unit.INSTANCE;
                        }
                        UserSubscriptionFragment userSubscriptionFragment = UserSubscriptionFragment.this;
                        if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                            message = sysMsg.getMessage();
                        }
                        BaseFragment.handleUndefinedError$default(userSubscriptionFragment, "changePlan", code, message, false, 8, null);
                    } else {
                        UserSubscriptionFragment.this.getSubscription();
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(UserSubscriptionFragment.this, "changePlan", message2, false, 4, null);
                }
                UserSubscriptionFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                UserSubscriptionFragment.this.stopLoading();
            }
        }
    }

    public final void changePlan(String priceId) {
        if (priceId == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(priceId, null), 3, null);
    }

    /* compiled from: UserSubscriptionFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment$reSubscription$1", f = "UserSubscriptionFragment.kt", i = {}, l = {465}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment$reSubscription$1, reason: invalid class name and case insensitive filesystem */
    static final class C10221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $userSubscriptionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10221(String str, Continuation<? super C10221> continuation) {
            super(2, continuation);
            this.$userSubscriptionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UserSubscriptionFragment.this.new C10221(this.$userSubscriptionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        UserSubscriptionFragment.this.showLoading();
                        this.label = 1;
                        obj = JwtDyacoApiKt.callReSubscriptionPlan(new ReSubscriptionApiData.RequestBodyData(this.$userSubscriptionId), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    ReSubscriptionApiData.ResponseData responseData = (ReSubscriptionApiData.ResponseData) ((Response) obj).body();
                    String message = null;
                    String code = (responseData == null || (sysMsg3 = responseData.getSysMsg()) == null) ? null : sysMsg3.getCode();
                    if (!Intrinsics.areEqual(code, JwtErrorCode.JWT_SUCCESS_1.getId())) {
                        String code2 = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                        if (UserSubscriptionFragment.this.shouldIgnoreError(code2)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(JwtErrorCode.JWT_ERROR_1515.getId(), Boxing.boxInt(R.string.error_jwt_1510))).get(code);
                        if (num != null) {
                            UserSubscriptionFragment userSubscriptionFragment = UserSubscriptionFragment.this;
                            CustomDialogKt.showCustomDialog$default(userSubscriptionFragment, userSubscriptionFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                        } else {
                            UserSubscriptionFragment userSubscriptionFragment2 = UserSubscriptionFragment.this;
                            if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                                message = sysMsg.getMessage();
                            }
                            BaseFragment.handleUndefinedError$default(userSubscriptionFragment2, "reSubscription", code2, message, false, 8, null);
                        }
                    } else {
                        UserSubscriptionFragment.this.getSubscription();
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(UserSubscriptionFragment.this, "reSubscription", message2, false, 4, null);
                }
                UserSubscriptionFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                UserSubscriptionFragment.this.stopLoading();
            }
        }
    }

    public final void reSubscription(String userSubscriptionId) {
        if (userSubscriptionId == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C10221(userSubscriptionId, null), 3, null);
    }

    /* compiled from: UserSubscriptionFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment$deleteSubscriptionMethod$1", f = "UserSubscriptionFragment.kt", i = {}, l = {520}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment$deleteSubscriptionMethod$1, reason: invalid class name and case insensitive filesystem */
    static final class C10171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $userSubscriptionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10171(String str, Continuation<? super C10171> continuation) {
            super(2, continuation);
            this.$userSubscriptionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UserSubscriptionFragment.this.new C10171(this.$userSubscriptionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        UserSubscriptionFragment.this.showLoading();
                        this.label = 1;
                        obj = JwtDyacoApiKt.callDeleteSubscriptionPayment(new DeleteSubscriptionMethodApiData.RequestBodyData(this.$userSubscriptionId), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    DeleteSubscriptionMethodApiData.ResponseData responseData = (DeleteSubscriptionMethodApiData.ResponseData) ((Response) obj).body();
                    String message = null;
                    if (!Intrinsics.areEqual((responseData == null || (sysMsg3 = responseData.getSysMsg()) == null) ? null : sysMsg3.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                        String code = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                        if (UserSubscriptionFragment.this.shouldIgnoreError(code)) {
                            return Unit.INSTANCE;
                        }
                        UserSubscriptionFragment userSubscriptionFragment = UserSubscriptionFragment.this;
                        if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                            message = sysMsg.getMessage();
                        }
                        BaseFragment.handleUndefinedError$default(userSubscriptionFragment, "deleteSubscriptionMethod", code, message, false, 8, null);
                    } else {
                        UserSubscriptionFragment.this.getSubscription();
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(UserSubscriptionFragment.this, "deleteSubscriptionMethod", message2, false, 4, null);
                }
                UserSubscriptionFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                UserSubscriptionFragment.this.stopLoading();
            }
        }
    }

    public final void deleteSubscriptionMethod(String userSubscriptionId) {
        if (userSubscriptionId == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C10171(userSubscriptionId, null), 3, null);
    }

    /* compiled from: UserSubscriptionFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment$getUpdateSubscriptionPaymentLink$1", f = "UserSubscriptionFragment.kt", i = {}, l = {562}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.subscription.UserSubscriptionFragment$getUpdateSubscriptionPaymentLink$1, reason: invalid class name and case insensitive filesystem */
    static final class C10191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $userSubscriptionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10191(String str, Continuation<? super C10191> continuation) {
            super(2, continuation);
            this.$userSubscriptionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UserSubscriptionFragment.this.new C10191(this.$userSubscriptionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        UserSubscriptionFragment.this.showLoading();
                        this.label = 1;
                        obj = JwtDyacoApiKt.callGetUpdateSubscriptionPaymentLink(new UpdateSubscriptionPaymentLinkApiData.RequestBody(this.$userSubscriptionId), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    UpdateSubscriptionPaymentLinkApiData.ResponseData responseData = (UpdateSubscriptionPaymentLinkApiData.ResponseData) ((Response) obj).body();
                    if (!Intrinsics.areEqual((responseData == null || (sysMsg3 = responseData.getSysMsg()) == null) ? null : sysMsg3.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                        String code = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                        if (UserSubscriptionFragment.this.shouldIgnoreError(code)) {
                            return Unit.INSTANCE;
                        }
                        UserSubscriptionFragment userSubscriptionFragment = UserSubscriptionFragment.this;
                        if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                            message = sysMsg.getMessage();
                        }
                        BaseFragment.handleUndefinedError$default(userSubscriptionFragment, "getUpdateSubscriptionPaymentLink", code, message, false, 8, null);
                    } else {
                        UpdateSubscriptionPaymentLinkApiData.UpdateSubscriptionPaymentData sysResponseData = responseData.getSysResponseData();
                        message = sysResponseData != null ? sysResponseData.getUpdatePaymentLinkUrl() : null;
                        Bundle bundle = new Bundle();
                        bundle.putString("url", message);
                        UserSubscriptionFragment.this.safeNavigate(R.id.subscriptionPayWebFragment, bundle);
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(UserSubscriptionFragment.this, "getUpdateSubscriptionPaymentLink", message, false, 4, null);
                }
                UserSubscriptionFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                UserSubscriptionFragment.this.stopLoading();
            }
        }
    }

    public final void getUpdateSubscriptionPaymentLink(String userSubscriptionId) {
        if (userSubscriptionId == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C10191(userSubscriptionId, null), 3, null);
    }
}
