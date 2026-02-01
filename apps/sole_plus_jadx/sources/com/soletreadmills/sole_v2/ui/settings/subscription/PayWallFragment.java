package com.soletreadmills.sole_v2.ui.settings.subscription;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import com.soletreadmills.sole_v2._data.api.JwtErrorCode;
import com.soletreadmills.sole_v2._data.api.settings.GetSubscriptionPaymentLinkApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetSubscriptionPlansApiData;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._network.JwtDyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentPaywallBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.settings.PayWallAdapter;
import com.soletreadmills.sole_v2.ui.settings.SettingViewModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: PayWallFragment.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001!B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\fJ\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u001e\u001a\u00020\f2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010 R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\""}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/subscription/PayWallFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentPaywallBinding;", "Landroid/view/View$OnClickListener;", "()V", "settingViewModel", "Lcom/soletreadmills/sole_v2/ui/settings/SettingViewModel;", "getSettingViewModel", "()Lcom/soletreadmills/sole_v2/ui/settings/SettingViewModel;", "settingViewModel$delegate", "Lkotlin/Lazy;", "getSubscriptionMessage", "", "data", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPlansApiData$SubscriptionPlansData;", "getSubscriptionPaymentLink", "getSubscriptionPlans", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setButton", "setRecyclerView", "list", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PayWallFragment extends BaseFragment<FragmentPaywallBinding> implements View.OnClickListener {
    public static final String REQUEST_KEY_PAY_WEB = "REQUEST_KEY_PAY_WEB";
    public static final String RESULT_KEY_PAY_WEB = "RESULT_KEY_PAY_WEB";

    /* renamed from: settingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingViewModel;
    public static final int $stable = 8;

    public PayWallFragment() {
        final PayWallFragment payWallFragment = this;
        final Function0 function0 = null;
        this.settingViewModel = FragmentViewModelLazyKt.createViewModelLazy(payWallFragment, Reflection.getOrCreateKotlinClass(SettingViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.PayWallFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = payWallFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.PayWallFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = payWallFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.PayWallFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = payWallFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    private final SettingViewModel getSettingViewModel() {
        return (SettingViewModel) this.settingViewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentPaywallBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentPaywallBinding fragmentPaywallBindingInflate = FragmentPaywallBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentPaywallBindingInflate, "inflate(...)");
        return fragmentPaywallBindingInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentKt.setFragmentResultListener(this, REQUEST_KEY_PAY_WEB, new Function2<String, Bundle, Unit>() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.PayWallFragment.onCreate.1
            {
                super(2);
            }

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
                        Global.INSTANCE.setSubscription(true);
                        PayWallFragment.this.safeNavigateUp();
                        BaseFragment.safeNavigate$default(PayWallFragment.this, R.id.userSubscriptionFragment, null, 2, null);
                    } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "attach_card_completed", false, 2, (Object) null)) {
                        Global.INSTANCE.setSubscription(true);
                        PayWallFragment.this.safeNavigateUp();
                        BaseFragment.safeNavigate$default(PayWallFragment.this, R.id.userSubscriptionFragment, null, 2, null);
                    }
                }
            }
        });
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ImageView imageView;
        FragmentPaywallBinding binding = getBinding();
        if (binding != null && (imageView = binding.back) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentPaywallBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout2 = binding2.LLActivate) != null) {
            linearLayout2.setOnClickListener(this);
        }
        if (Global.INSTANCE.isSubscription()) {
            FragmentPaywallBinding binding3 = getBinding();
            linearLayout = binding3 != null ? binding3.LLBottom : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else {
            FragmentPaywallBinding binding4 = getBinding();
            linearLayout = binding4 != null ? binding4.LLBottom : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        }
        getSubscriptionPlans();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Object next;
        List<String> subscription_methods;
        RecyclerView recyclerView;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.LL_activate;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            FragmentPaywallBinding binding = getBinding();
            RecyclerView.Adapter adapter = (binding == null || (recyclerView = binding.rvPlans) == null) ? null : recyclerView.getAdapter();
            if (adapter instanceof PayWallAdapter) {
                List<GetSubscriptionPlansApiData.SubscriptionPlansData> currentList = ((PayWallAdapter) adapter).getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                Iterator it = CollectionsKt.toMutableList((Collection) currentList).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (((GetSubscriptionPlansApiData.SubscriptionPlansData) next).isSelect()) {
                            break;
                        }
                    }
                }
                GetSubscriptionPlansApiData.SubscriptionPlansData subscriptionPlansData = (GetSubscriptionPlansApiData.SubscriptionPlansData) next;
                if (subscriptionPlansData != null) {
                    getSettingViewModel().setSubscriptionPlansData(subscriptionPlansData);
                    List<String> subscription_methods2 = subscriptionPlansData.getSubscription_methods();
                    if ((subscription_methods2 != null && subscription_methods2.contains("PM")) || ((subscription_methods = subscriptionPlansData.getSubscription_methods()) != null && subscription_methods.contains("PY"))) {
                        getSubscriptionPaymentLink(subscriptionPlansData);
                    } else {
                        BaseFragment.safeNavigate$default(this, R.id.subscriptionBluetoothFragment, null, 2, null);
                    }
                }
            }
        }
    }

    public final void setRecyclerView(List<GetSubscriptionPlansApiData.SubscriptionPlansData> list) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Context context = getContext();
        if (context == null) {
            return;
        }
        FragmentPaywallBinding binding = getBinding();
        RecyclerView.Adapter adapter = null;
        if (!(((binding == null || (recyclerView3 = binding.rvPlans) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
            FragmentPaywallBinding binding2 = getBinding();
            RecyclerView recyclerView4 = binding2 != null ? binding2.rvPlans : null;
            if (recyclerView4 != null) {
                recyclerView4.setLayoutManager(new LinearLayoutManager(context));
            }
        }
        FragmentPaywallBinding binding3 = getBinding();
        if (!(((binding3 == null || (recyclerView2 = binding3.rvPlans) == null) ? null : recyclerView2.getAdapter()) instanceof PayWallAdapter)) {
            PayWallAdapter payWallAdapter = new PayWallAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.PayWallFragment$setRecyclerView$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                    RecyclerView recyclerView5;
                    FragmentPaywallBinding binding4 = this.this$0.getBinding();
                    RecyclerView.Adapter adapter2 = (binding4 == null || (recyclerView5 = binding4.rvPlans) == null) ? null : recyclerView5.getAdapter();
                    if (adapter2 instanceof PayWallAdapter) {
                        PayWallAdapter payWallAdapter2 = (PayWallAdapter) adapter2;
                        List<GetSubscriptionPlansApiData.SubscriptionPlansData> currentList = payWallAdapter2.getCurrentList();
                        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                        List mutableList = CollectionsKt.toMutableList((Collection) currentList);
                        GetSubscriptionPlansApiData.SubscriptionPlansData subscriptionPlansData = (GetSubscriptionPlansApiData.SubscriptionPlansData) mutableList.get(pos);
                        int i = 0;
                        for (Object obj : mutableList) {
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            GetSubscriptionPlansApiData.SubscriptionPlansData subscriptionPlansData2 = (GetSubscriptionPlansApiData.SubscriptionPlansData) obj;
                            Intrinsics.checkNotNull(subscriptionPlansData2);
                            mutableList.set(i, subscriptionPlansData2.copy((511 & 1) != 0 ? subscriptionPlansData2.desc : null, (511 & 2) != 0 ? subscriptionPlansData2.fee : null, (511 & 4) != 0 ? subscriptionPlansData2.free_trial_days : null, (511 & 8) != 0 ? subscriptionPlansData2.has_free_trial : null, (511 & 16) != 0 ? subscriptionPlansData2.plan_id : null, (511 & 32) != 0 ? subscriptionPlansData2.price_id : null, (511 & 64) != 0 ? subscriptionPlansData2.subscription_methods : null, (511 & 128) != 0 ? subscriptionPlansData2.title : null, (511 & 256) != 0 ? subscriptionPlansData2.isSelect : i == pos));
                            i = i2;
                        }
                        payWallAdapter2.submitList(mutableList);
                        PayWallFragment payWallFragment = this.this$0;
                        Intrinsics.checkNotNull(subscriptionPlansData);
                        payWallFragment.setButton(subscriptionPlansData);
                        this.this$0.getSubscriptionMessage(subscriptionPlansData);
                    }
                }
            });
            FragmentPaywallBinding binding4 = getBinding();
            RecyclerView recyclerView5 = binding4 != null ? binding4.rvPlans : null;
            if (recyclerView5 != null) {
                recyclerView5.setAdapter(payWallAdapter);
            }
        }
        ArrayList arrayList = new ArrayList();
        List<GetSubscriptionPlansApiData.SubscriptionPlansData> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            for (GetSubscriptionPlansApiData.SubscriptionPlansData subscriptionPlansData : list) {
                arrayList.add(subscriptionPlansData.copy((511 & 1) != 0 ? subscriptionPlansData.desc : null, (511 & 2) != 0 ? subscriptionPlansData.fee : null, (511 & 4) != 0 ? subscriptionPlansData.free_trial_days : null, (511 & 8) != 0 ? subscriptionPlansData.has_free_trial : null, (511 & 16) != 0 ? subscriptionPlansData.plan_id : null, (511 & 32) != 0 ? subscriptionPlansData.price_id : null, (511 & 64) != 0 ? subscriptionPlansData.subscription_methods : null, (511 & 128) != 0 ? subscriptionPlansData.title : null, (511 & 256) != 0 ? subscriptionPlansData.isSelect : false));
            }
            if (!Global.INSTANCE.isSubscription()) {
                ((GetSubscriptionPlansApiData.SubscriptionPlansData) arrayList.get(0)).setSelect(true);
                FragmentPaywallBinding binding5 = getBinding();
                TextView textView = binding5 != null ? binding5.tvHint : null;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            }
        }
        FragmentPaywallBinding binding6 = getBinding();
        if (binding6 != null && (recyclerView = binding6.rvPlans) != null) {
            adapter = recyclerView.getAdapter();
        }
        if (adapter instanceof PayWallAdapter) {
            ((PayWallAdapter) adapter).submitList(arrayList);
        }
    }

    public final void setButton(final GetSubscriptionPlansApiData.SubscriptionPlansData data) {
        View root;
        Intrinsics.checkNotNullParameter(data, "data");
        FragmentPaywallBinding binding = getBinding();
        if (binding == null || (root = binding.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.PayWallFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PayWallFragment.setButton$lambda$2(this.f$0, data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setButton$lambda$2(PayWallFragment this$0, GetSubscriptionPlansApiData.SubscriptionPlansData data) {
        List<String> subscription_methods;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        FragmentPaywallBinding binding = this$0.getBinding();
        TextView textView = binding != null ? binding.tvActivate : null;
        if (textView == null) {
            return;
        }
        List<String> subscription_methods2 = data.getSubscription_methods();
        if ((subscription_methods2 != null && subscription_methods2.contains("MM")) || ((subscription_methods = data.getSubscription_methods()) != null && subscription_methods.contains("MSN"))) {
            string2 = this$0.getString(R.string.activate);
        } else {
            if (Intrinsics.areEqual((Object) data.getHas_free_trial(), (Object) true)) {
                string = this$0.getString(R.string.start_free_trial, String.valueOf(data.getFree_trial_days()));
            } else {
                string = this$0.getString(R.string.start_plan, data.getTitle());
            }
            string2 = string;
        }
        textView.setText(string2);
    }

    public final void getSubscriptionMessage(GetSubscriptionPlansApiData.SubscriptionPlansData data) {
        List<String> subscription_methods;
        TextView textView;
        Intrinsics.checkNotNullParameter(data, "data");
        List<String> subscription_methods2 = data.getSubscription_methods();
        if ((subscription_methods2 != null && subscription_methods2.contains("MM")) || ((subscription_methods = data.getSubscription_methods()) != null && subscription_methods.contains("MSN"))) {
            FragmentPaywallBinding binding = getBinding();
            textView = binding != null ? binding.tvHint : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        FragmentPaywallBinding binding2 = getBinding();
        TextView textView2 = binding2 != null ? binding2.tvHint : null;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        if (Intrinsics.areEqual((Object) data.getHas_free_trial(), (Object) true)) {
            String str = LocalDate.now().plusDays(data.getFree_trial_days() != null ? r10.intValue() : 0L).format(DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.getDefault()));
            String string = getString(R.string.subscription_charged_on, str);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String str2 = string;
            SpannableString spannableString = new SpannableString(str2);
            Intrinsics.checkNotNull(str);
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str2, str, 0, false, 6, (Object) null);
            if (iIndexOf$default >= 0) {
                spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.colorGlobal_accent)), iIndexOf$default, str.length() + iIndexOf$default, 33);
            }
            FragmentPaywallBinding binding3 = getBinding();
            textView = binding3 != null ? binding3.tvHint : null;
            if (textView == null) {
                return;
            }
            textView.setText(spannableString);
            return;
        }
        FragmentPaywallBinding binding4 = getBinding();
        textView = binding4 != null ? binding4.tvHint : null;
        if (textView == null) {
            return;
        }
        textView.setText(getString(R.string.subscription_charged_immediately));
    }

    /* compiled from: PayWallFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.subscription.PayWallFragment$getSubscriptionPlans$1", f = "PayWallFragment.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.subscription.PayWallFragment$getSubscriptionPlans$1, reason: invalid class name and case insensitive filesystem */
    static final class C10141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C10141(Continuation<? super C10141> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PayWallFragment.this.new C10141(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        PayWallFragment.this.showLoading();
                        this.label = 1;
                        obj = JwtDyacoApiKt.callGetSubscriptionPlans(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    GetSubscriptionPlansApiData.ResponseData responseData = (GetSubscriptionPlansApiData.ResponseData) ((Response) obj).body();
                    String message = null;
                    message = null;
                    if (!Intrinsics.areEqual((responseData == null || (sysMsg3 = responseData.getSysMsg()) == null) ? null : sysMsg3.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                        String code = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                        if (PayWallFragment.this.shouldIgnoreError(code)) {
                            PayWallFragment.this.safeNavigateUp();
                            return Unit.INSTANCE;
                        }
                        PayWallFragment payWallFragment = PayWallFragment.this;
                        if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                            message = sysMsg.getMessage();
                        }
                        payWallFragment.handleUndefinedError("getSubscriptionPlans", code, message, false);
                        PayWallFragment.this.safeNavigateUp();
                    } else {
                        PayWallFragment.this.setRecyclerView(responseData != null ? responseData.getSysResponseData() : null);
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(PayWallFragment.this, "getSubscriptionPlans", message2, false, 4, null);
                }
                PayWallFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                PayWallFragment.this.stopLoading();
            }
        }
    }

    public final void getSubscriptionPlans() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C10141(null), 3, null);
    }

    /* compiled from: PayWallFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.subscription.PayWallFragment$getSubscriptionPaymentLink$1", f = "PayWallFragment.kt", i = {}, l = {295}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.subscription.PayWallFragment$getSubscriptionPaymentLink$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GetSubscriptionPlansApiData.SubscriptionPlansData $data;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GetSubscriptionPlansApiData.SubscriptionPlansData subscriptionPlansData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$data = subscriptionPlansData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PayWallFragment.this.new AnonymousClass1(this.$data, continuation);
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
                        PayWallFragment.this.showLoading();
                        String price_id = this.$data.getPrice_id();
                        if (price_id == null) {
                            price_id = "";
                        }
                        LoginUserData loginUserData = Global.userData;
                        String email = loginUserData != null ? loginUserData.getEmail() : null;
                        this.label = 1;
                        obj = JwtDyacoApiKt.callGetSubscriptionPaymentLink(new GetSubscriptionPaymentLinkApiData.RequestBody(price_id, email), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    GetSubscriptionPaymentLinkApiData.ResponseData responseData = (GetSubscriptionPaymentLinkApiData.ResponseData) ((Response) obj).body();
                    if (!Intrinsics.areEqual((responseData == null || (sysMsg3 = responseData.getSysMsg()) == null) ? null : sysMsg3.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                        String code = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                        if (PayWallFragment.this.shouldIgnoreError(code)) {
                            return Unit.INSTANCE;
                        }
                        PayWallFragment payWallFragment = PayWallFragment.this;
                        if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                            message = sysMsg.getMessage();
                        }
                        BaseFragment.handleUndefinedError$default(payWallFragment, "getSubscriptionPaymentLink", code, message, false, 8, null);
                    } else {
                        GetSubscriptionPaymentLinkApiData.GetSubscriptionPaymentData sysResponseData = responseData.getSysResponseData();
                        message = sysResponseData != null ? sysResponseData.getPaymentLinkUrl() : null;
                        Bundle bundle = new Bundle();
                        bundle.putString("url", message);
                        PayWallFragment.this.safeNavigate(R.id.subscriptionPayWebFragment, bundle);
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(PayWallFragment.this, "getSubscriptionPaymentLink", message, false, 4, null);
                }
                PayWallFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                PayWallFragment.this.stopLoading();
            }
        }
    }

    public final void getSubscriptionPaymentLink(GetSubscriptionPlansApiData.SubscriptionPlansData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(data, null), 3, null);
    }
}
