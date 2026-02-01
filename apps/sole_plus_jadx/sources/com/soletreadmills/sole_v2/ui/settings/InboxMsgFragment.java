package com.soletreadmills.sole_v2.ui.settings;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.settings.GetMessagesApiData;
import com.soletreadmills.sole_v2._data.api.settings.PatchMessageStatusApiData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.JwtNotificationDyacoApiKt;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2.databinding.FragmentInboxMsgBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

/* compiled from: InboxMsgFragment.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/InboxMsgFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentInboxMsgBinding;", "Landroid/view/View$OnClickListener;", "()V", "isPageError", "", "settingViewModel", "Lcom/soletreadmills/sole_v2/ui/settings/SettingViewModel;", "getSettingViewModel", "()Lcom/soletreadmills/sole_v2/ui/settings/SettingViewModel;", "settingViewModel$delegate", "Lkotlin/Lazy;", "webChromeClient", "Landroid/webkit/WebChromeClient;", "webViewClient", "Landroid/webkit/WebViewClient;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", "initWebView", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "updateMessageStatus", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InboxMsgFragment extends BaseFragment<FragmentInboxMsgBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private boolean isPageError;

    /* renamed from: settingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingViewModel;
    private final WebViewClient webViewClient = new WebViewClient() { // from class: com.soletreadmills.sole_v2.ui.settings.InboxMsgFragment$webViewClient$1
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            Timber.INSTANCE.d("shouldOverrideUrlLoading url=" + url, new Object[0]);
            String str = url;
            if (!TextUtils.isEmpty(str)) {
                GetMessagesApiData.MessageData inBoxMsgData = this.this$0.getSettingViewModel().getInBoxMsgData();
                if (TextUtils.equals(inBoxMsgData != null ? inBoxMsgData.getMessage_url() : null, str)) {
                    return super.shouldOverrideUrlLoading(view, url);
                }
            }
            if (URLUtil.isNetworkUrl(url)) {
                try {
                    this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    return true;
                } catch (Exception e) {
                    Timber.INSTANCE.e(e.fillInStackTrace());
                    return super.shouldOverrideUrlLoading(view, url);
                }
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
            super.onReceivedError(view, errorCode, description, failingUrl);
            Timber.INSTANCE.d("onReceivedError errorCode=" + errorCode + " description=" + description + " failingUrl=" + failingUrl, new Object[0]);
            this.this$0.isPageError = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(error, "error");
            super.onReceivedError(view, request, error);
            Timber.INSTANCE.d("onReceivedError request=" + request + " error=" + error, new Object[0]);
            Timber.INSTANCE.d("onReceivedError error.errorCode=" + error.getErrorCode(), new Object[0]);
            if (error.getErrorCode() >= 500 && error.getErrorCode() <= 505) {
                FragmentInboxMsgBinding binding = this.this$0.getBinding();
                WebView webView = binding != null ? binding.webView : null;
                if (webView != null) {
                    webView.setVisibility(8);
                }
            }
            this.this$0.isPageError = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            super.onReceivedHttpError(view, request, errorResponse);
            Timber.INSTANCE.d("onReceivedHttpError request=" + request + " errorResponse=" + errorResponse, new Object[0]);
            Timber.INSTANCE.d("onReceivedHttpError errorResponse.statusCode=" + errorResponse.getStatusCode(), new Object[0]);
            this.this$0.isPageError = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(error, "error");
            super.onReceivedSslError(view, handler, error);
            Timber.INSTANCE.d("onReceivedSslError handler=" + handler + " error=" + error, new Object[0]);
            this.this$0.isPageError = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Timber.INSTANCE.d("onPageStarted url=$" + url, new Object[0]);
            this.this$0.isPageError = false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            WebView webView;
            super.onPageFinished(view, url);
            Timber.INSTANCE.d("onPageFinished url=" + url, new Object[0]);
            if (this.this$0.isPageError) {
                FragmentInboxMsgBinding binding = this.this$0.getBinding();
                webView = binding != null ? binding.webView : null;
                if (webView != null) {
                    webView.setVisibility(8);
                }
                InboxMsgFragment inboxMsgFragment = this.this$0;
                CustomDialogKt.showCustomDialog$default(inboxMsgFragment, inboxMsgFragment.getString(R.string.network_exception), this.this$0.getString(R.string.confirm), null, null, null, null, false, 120, null);
                return;
            }
            FragmentInboxMsgBinding binding2 = this.this$0.getBinding();
            webView = binding2 != null ? binding2.webView : null;
            if (webView == null) {
                return;
            }
            webView.setVisibility(0);
        }
    };
    private final WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.soletreadmills.sole_v2.ui.settings.InboxMsgFragment$webChromeClient$1
        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int newProgress) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onProgressChanged(view, newProgress);
            Timber.INSTANCE.d("onProgressChanged newProgress=" + newProgress, new Object[0]);
        }
    };

    public InboxMsgFragment() {
        final InboxMsgFragment inboxMsgFragment = this;
        final Function0 function0 = null;
        this.settingViewModel = FragmentViewModelLazyKt.createViewModelLazy(inboxMsgFragment, Reflection.getOrCreateKotlinClass(SettingViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.settings.InboxMsgFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = inboxMsgFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.settings.InboxMsgFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = inboxMsgFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.settings.InboxMsgFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = inboxMsgFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingViewModel getSettingViewModel() {
        return (SettingViewModel) this.settingViewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentInboxMsgBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentInboxMsgBinding fragmentInboxMsgBindingInflate = FragmentInboxMsgBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentInboxMsgBindingInflate, "inflate(...)");
        return fragmentInboxMsgBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        TextView textView;
        String message_url;
        FragmentInboxMsgBinding binding;
        WebView webView;
        String publish_date;
        ImageView imageView;
        FragmentInboxMsgBinding binding2 = getBinding();
        if (binding2 != null && (imageView = binding2.back) != null) {
            imageView.setOnClickListener(this);
        }
        GetMessagesApiData.MessageData inBoxMsgData = getSettingViewModel().getInBoxMsgData();
        String strConvertUtcToLocalDateOnly = (inBoxMsgData == null || (publish_date = inBoxMsgData.getPublish_date()) == null) ? null : TimeTools.INSTANCE.convertUtcToLocalDateOnly(publish_date);
        if (strConvertUtcToLocalDateOnly == null || strConvertUtcToLocalDateOnly.length() == 0) {
            FragmentInboxMsgBinding binding3 = getBinding();
            textView = binding3 != null ? binding3.topBarTitle : null;
            if (textView != null) {
                textView.setText(SdkConstants.RES_QUALIFIER_SEP);
            }
        } else {
            FragmentInboxMsgBinding binding4 = getBinding();
            textView = binding4 != null ? binding4.topBarTitle : null;
            if (textView != null) {
                textView.setText(strConvertUtcToLocalDateOnly);
            }
        }
        GetMessagesApiData.MessageData inBoxMsgData2 = getSettingViewModel().getInBoxMsgData();
        if (inBoxMsgData2 != null ? Intrinsics.areEqual((Object) inBoxMsgData2.is_read(), (Object) false) : false) {
            updateMessageStatus();
        }
        initWebView();
        GetMessagesApiData.MessageData inBoxMsgData3 = getSettingViewModel().getInBoxMsgData();
        if (inBoxMsgData3 == null || (message_url = inBoxMsgData3.getMessage_url()) == null || (binding = getBinding()) == null || (webView = binding.webView) == null) {
            return;
        }
        webView.loadUrl(message_url);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
        }
    }

    private final void initWebView() {
        WebView webView;
        WebSettings settings;
        WebView webView2;
        WebView webView3;
        WebView webView4;
        WebView webView5;
        WebView webView6;
        WebView webView7;
        WebView webView8;
        WebView webView9;
        WebView webView10;
        WebView webView11;
        WebView webView12;
        WebView webView13;
        WebView webView14;
        WebView webView15;
        WebView webView16;
        FragmentInboxMsgBinding binding = getBinding();
        if (binding != null && (webView16 = binding.webView) != null) {
            webView16.requestFocus();
        }
        FragmentInboxMsgBinding binding2 = getBinding();
        WebSettings settings2 = (binding2 == null || (webView15 = binding2.webView) == null) ? null : webView15.getSettings();
        if (settings2 != null) {
            settings2.setJavaScriptEnabled(true);
        }
        FragmentInboxMsgBinding binding3 = getBinding();
        WebSettings settings3 = (binding3 == null || (webView14 = binding3.webView) == null) ? null : webView14.getSettings();
        if (settings3 != null) {
            settings3.setAllowContentAccess(true);
        }
        FragmentInboxMsgBinding binding4 = getBinding();
        WebSettings settings4 = (binding4 == null || (webView13 = binding4.webView) == null) ? null : webView13.getSettings();
        if (settings4 != null) {
            settings4.setCacheMode(-1);
        }
        FragmentInboxMsgBinding binding5 = getBinding();
        WebSettings settings5 = (binding5 == null || (webView12 = binding5.webView) == null) ? null : webView12.getSettings();
        if (settings5 != null) {
            settings5.setJavaScriptCanOpenWindowsAutomatically(true);
        }
        FragmentInboxMsgBinding binding6 = getBinding();
        WebSettings settings6 = (binding6 == null || (webView11 = binding6.webView) == null) ? null : webView11.getSettings();
        if (settings6 != null) {
            settings6.setDomStorageEnabled(true);
        }
        FragmentInboxMsgBinding binding7 = getBinding();
        WebSettings settings7 = (binding7 == null || (webView10 = binding7.webView) == null) ? null : webView10.getSettings();
        if (settings7 != null) {
            settings7.setLoadsImagesAutomatically(true);
        }
        FragmentInboxMsgBinding binding8 = getBinding();
        WebSettings settings8 = (binding8 == null || (webView9 = binding8.webView) == null) ? null : webView9.getSettings();
        if (settings8 != null) {
            settings8.setAllowFileAccessFromFileURLs(true);
        }
        FragmentInboxMsgBinding binding9 = getBinding();
        WebSettings settings9 = (binding9 == null || (webView8 = binding9.webView) == null) ? null : webView8.getSettings();
        if (settings9 != null) {
            settings9.setAllowUniversalAccessFromFileURLs(true);
        }
        FragmentInboxMsgBinding binding10 = getBinding();
        WebSettings settings10 = (binding10 == null || (webView7 = binding10.webView) == null) ? null : webView7.getSettings();
        if (settings10 != null) {
            settings10.setAllowFileAccess(true);
        }
        FragmentInboxMsgBinding binding11 = getBinding();
        WebSettings settings11 = (binding11 == null || (webView6 = binding11.webView) == null) ? null : webView6.getSettings();
        if (settings11 != null) {
            settings11.setBuiltInZoomControls(true);
        }
        FragmentInboxMsgBinding binding12 = getBinding();
        WebSettings settings12 = (binding12 == null || (webView5 = binding12.webView) == null) ? null : webView5.getSettings();
        if (settings12 != null) {
            settings12.setDisplayZoomControls(false);
        }
        FragmentInboxMsgBinding binding13 = getBinding();
        WebSettings settings13 = (binding13 == null || (webView4 = binding13.webView) == null) ? null : webView4.getSettings();
        if (settings13 != null) {
            settings13.setDomStorageEnabled(true);
        }
        FragmentInboxMsgBinding binding14 = getBinding();
        WebSettings settings14 = (binding14 == null || (webView3 = binding14.webView) == null) ? null : webView3.getSettings();
        if (settings14 != null) {
            settings14.setLoadWithOverviewMode(true);
        }
        FragmentInboxMsgBinding binding15 = getBinding();
        WebSettings settings15 = (binding15 == null || (webView2 = binding15.webView) == null) ? null : webView2.getSettings();
        if (settings15 != null) {
            settings15.setUseWideViewPort(true);
        }
        FragmentInboxMsgBinding binding16 = getBinding();
        if (binding16 != null && (webView = binding16.webView) != null && (settings = webView.getSettings()) != null) {
            settings.setSupportZoom(true);
        }
        FragmentInboxMsgBinding binding17 = getBinding();
        WebView webView17 = binding17 != null ? binding17.webView : null;
        if (webView17 != null) {
            webView17.setWebViewClient(this.webViewClient);
        }
        FragmentInboxMsgBinding binding18 = getBinding();
        WebView webView18 = binding18 != null ? binding18.webView : null;
        if (webView18 == null) {
            return;
        }
        webView18.setWebChromeClient(this.webChromeClient);
    }

    /* compiled from: InboxMsgFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.InboxMsgFragment$updateMessageStatus$1", f = "InboxMsgFragment.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.InboxMsgFragment$updateMessageStatus$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $messageId;
        int label;
        final /* synthetic */ InboxMsgFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, InboxMsgFragment inboxMsgFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$messageId = str;
            this.this$0 = inboxMsgFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$messageId, this.this$0, continuation);
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
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = JwtNotificationDyacoApiKt.callPatchMessageStatus(new PatchMessageStatusApiData.RequestBody(this.$messageId), this);
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
                String message = e.getMessage();
                if (message == null) {
                    message = e.getClass().getSimpleName();
                }
                BaseFragment.handleApiError$default(this.this$0, "updateMessageStatus", message, false, 4, null);
            }
            return Unit.INSTANCE;
        }
    }

    public final void updateMessageStatus() {
        String message_id;
        GetMessagesApiData.MessageData inBoxMsgData = getSettingViewModel().getInBoxMsgData();
        if (inBoxMsgData == null || (message_id = inBoxMsgData.getMessage_id()) == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(message_id, this, null), 3, null);
    }
}
