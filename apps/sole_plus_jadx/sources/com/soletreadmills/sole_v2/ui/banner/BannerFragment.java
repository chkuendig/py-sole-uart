package com.soletreadmills.sole_v2.ui.banner;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.android.SdkConstants;
import com.bumptech.glide.Glide;
import com.soletreadmills.sole_v2.AppConfigKt;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.banner.BannerApiData;
import com.soletreadmills.sole_v2._data.api.banner.BannerConfigApiData;
import com.soletreadmills.sole_v2._network.JwtNotificationDyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentBannerBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

/* compiled from: BannerFragment.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/banner/BannerFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentBannerBinding;", "Landroid/view/View$OnClickListener;", "()V", "bannerData", "Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$BannerResult;", "getBannerData", "()Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$BannerResult;", "setBannerData", "(Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$BannerResult;)V", "countDownTime", "", "getCountDownTime", "()I", "setCountDownTime", "(I)V", "countDownTimeRunnable", "Ljava/lang/Runnable;", "bannerConfig", "", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onStart", "onStop", "setCountDownTimeToViews", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BannerFragment extends BaseFragment<FragmentBannerBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    public BannerApiData.BannerResult bannerData;
    private int countDownTime;
    private final Runnable countDownTimeRunnable = new Runnable() { // from class: com.soletreadmills.sole_v2.ui.banner.BannerFragment$countDownTimeRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            this.this$0.setCountDownTime(r0.getCountDownTime() - 1);
            this.this$0.setCountDownTimeToViews();
        }
    };

    public final BannerApiData.BannerResult getBannerData() {
        BannerApiData.BannerResult bannerResult = this.bannerData;
        if (bannerResult != null) {
            return bannerResult;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bannerData");
        return null;
    }

    public final void setBannerData(BannerApiData.BannerResult bannerResult) {
        Intrinsics.checkNotNullParameter(bannerResult, "<set-?>");
        this.bannerData = bannerResult;
    }

    public final int getCountDownTime() {
        return this.countDownTime;
    }

    public final void setCountDownTime(int i) {
        this.countDownTime = i;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentBannerBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentBannerBinding fragmentBannerBindingInflate = FragmentBannerBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentBannerBindingInflate, "inflate(...)");
        return fragmentBannerBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        View root;
        View root2;
        super.onStart();
        FragmentBannerBinding binding = getBinding();
        if (binding != null && (root2 = binding.getRoot()) != null) {
            root2.removeCallbacks(this.countDownTimeRunnable);
        }
        FragmentBannerBinding binding2 = getBinding();
        if (binding2 == null || (root = binding2.getRoot()) == null) {
            return;
        }
        root.postDelayed(this.countDownTimeRunnable, 1000L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        View root;
        super.onStop();
        FragmentBannerBinding binding = getBinding();
        if (binding == null || (root = binding.getRoot()) == null) {
            return;
        }
        root.removeCallbacks(this.countDownTimeRunnable);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        ImageView imageView;
        TextView textView;
        FragmentBannerBinding binding;
        View view;
        FragmentBannerBinding binding2;
        View view2;
        ImageView imageView2;
        CardView cardView;
        CardView cardView2;
        Button button;
        BannerApiData.BannerResult bannerData = getUiViewModel().getBannerData();
        if (bannerData == null) {
            return;
        }
        setBannerData(bannerData);
        FragmentBannerBinding binding3 = getBinding();
        if (binding3 != null && (button = binding3.btn) != null) {
            button.setOnClickListener(this);
        }
        FragmentBannerBinding binding4 = getBinding();
        if (binding4 != null && (cardView2 = binding4.dontShowAgain) != null) {
            cardView2.setOnClickListener(this);
        }
        FragmentBannerBinding binding5 = getBinding();
        if (binding5 != null && (cardView = binding5.countDownTimeLayout) != null) {
            cardView.setOnClickListener(this);
        }
        FragmentBannerBinding binding6 = getBinding();
        if (binding6 != null) {
            Glide.with(this).load(getBannerData().getCover_url()).into(binding6.bannerImg);
        }
        if (getBannerData().getDisplay_time_in_seconds() != null) {
            Integer display_time_in_seconds = getBannerData().getDisplay_time_in_seconds();
            this.countDownTime = display_time_in_seconds != null ? display_time_in_seconds.intValue() : 0;
        }
        FragmentBannerBinding binding7 = getBinding();
        if (binding7 != null && (imageView2 = binding7.bannerImg) != null) {
            imageView2.setOnClickListener(null);
        }
        Integer link_interaction = getBannerData().getLink_interaction();
        if (link_interaction != null && link_interaction.intValue() == 0) {
            FragmentBannerBinding binding8 = getBinding();
            Button button2 = binding8 != null ? binding8.btn : null;
            if (button2 != null) {
                button2.setVisibility(0);
            }
            FragmentBannerBinding binding9 = getBinding();
            Button button3 = binding9 != null ? binding9.btn : null;
            if (button3 != null) {
                button3.setText(getBannerData().getButton_text());
            }
        } else {
            FragmentBannerBinding binding10 = getBinding();
            if (binding10 != null && (imageView = binding10.bannerImg) != null) {
                imageView.setOnClickListener(this);
            }
            FragmentBannerBinding binding11 = getBinding();
            Button button4 = binding11 != null ? binding11.btn : null;
            if (button4 != null) {
                button4.setVisibility(8);
            }
        }
        if (TextUtils.isEmpty(getBannerData().getMessage())) {
            FragmentBannerBinding binding12 = getBinding();
            textView = binding12 != null ? binding12.msg : null;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            FragmentBannerBinding binding13 = getBinding();
            TextView textView2 = binding13 != null ? binding13.msg : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            FragmentBannerBinding binding14 = getBinding();
            textView = binding14 != null ? binding14.msg : null;
            if (textView != null) {
                textView.setText(getBannerData().getMessage());
            }
        }
        if (!TextUtils.isEmpty(getBannerData().getMessage_background_color()) && (binding2 = getBinding()) != null && (view2 = binding2.msgBackground) != null) {
            view2.setBackgroundColor(Color.parseColor(getBannerData().getMessage_background_color()));
        }
        if (getBannerData().getMessage_background_opacity() != null && (binding = getBinding()) != null && (view = binding.msgBackground) != null) {
            view.setAlpha((getBannerData().getMessage_background_opacity() != null ? r2.intValue() : 0) / 100.0f);
        }
        setCountDownTimeToViews();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        CardView cardView;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.countDownTimeLayout;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.btn;
        if (numValueOf == null || numValueOf.intValue() != i2) {
            int i3 = R.id.bannerImg;
            if (numValueOf == null || numValueOf.intValue() != i3) {
                int i4 = R.id.dontShowAgain;
                if (numValueOf != null && numValueOf.intValue() == i4) {
                    bannerConfig();
                    return;
                }
                return;
            }
        }
        if (URLUtil.isNetworkUrl(getBannerData().getUrl_link())) {
            FragmentBannerBinding binding = getBinding();
            if (binding != null && (cardView = binding.countDownTimeLayout) != null) {
                cardView.performClick();
            }
            String serviceLoginToken = AppConfigKt.getServiceLoginToken();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(getBannerData().getUrl_link() + "&service_login_token=" + serviceLoginToken));
            try {
                FragmentActivity activity = getActivity();
                Intrinsics.checkNotNull(activity);
                activity.startActivity(intent);
            } catch (Exception e) {
                Timber.INSTANCE.e(e.fillInStackTrace());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCountDownTimeToViews() {
        View root;
        Runnable runnable = new Runnable() { // from class: com.soletreadmills.sole_v2.ui.banner.BannerFragment$setCountDownTimeToViews$runnable$1
            @Override // java.lang.Runnable
            public void run() {
                View root2;
                TextView textView;
                View root3;
                FragmentBannerBinding binding = this.this$0.getBinding();
                if (binding != null && (root3 = binding.getRoot()) != null) {
                    root3.removeCallbacks(this.this$0.countDownTimeRunnable);
                }
                DecimalFormat decimalFormat = new DecimalFormat("00", DecimalFormatSymbols.getInstance(Locale.US));
                FragmentBannerBinding binding2 = this.this$0.getBinding();
                if (binding2 != null && (textView = binding2.countDownTime) != null) {
                    textView.setText(decimalFormat.format(this.this$0.getCountDownTime()));
                }
                if (this.this$0.getCountDownTime() <= 0) {
                    this.this$0.safeNavigateUp();
                    return;
                }
                FragmentBannerBinding binding3 = this.this$0.getBinding();
                if (binding3 == null || (root2 = binding3.getRoot()) == null) {
                    return;
                }
                root2.postDelayed(this.this$0.countDownTimeRunnable, 1000L);
            }
        };
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
            return;
        }
        FragmentBannerBinding binding = getBinding();
        if (binding == null || (root = binding.getRoot()) == null) {
            return;
        }
        root.post(runnable);
    }

    /* compiled from: BannerFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.banner.BannerFragment$bannerConfig$1", f = "BannerFragment.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.banner.BannerFragment$bannerConfig$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BannerFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        String banner_id = BannerFragment.this.getBannerData().getBanner_id();
                        if (banner_id == null) {
                            return Unit.INSTANCE;
                        }
                        this.label = 1;
                        obj = JwtNotificationDyacoApiKt.callPatchBannerConfig(new BannerConfigApiData.RequestBodyData(banner_id), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                }
                BannerFragment.this.safeNavigateUp();
                return Unit.INSTANCE;
            } finally {
                BannerFragment.this.safeNavigateUp();
            }
        }
    }

    public final void bannerConfig() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(null), 3, null);
    }
}
