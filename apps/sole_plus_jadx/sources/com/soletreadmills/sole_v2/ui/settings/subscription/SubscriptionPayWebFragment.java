package com.soletreadmills.sole_v2.ui.settings.subscription;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.fragment.app.FragmentKt;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.databinding.FragmentSubscriptionPayWebBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

/* compiled from: SubscriptionPayWebFragment.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0003J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/subscription/SubscriptionPayWebFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentSubscriptionPayWebBinding;", "Landroid/view/View$OnClickListener;", "()V", "url", "", "webChromeClient", "Landroid/webkit/WebChromeClient;", "webViewClient", "Landroid/webkit/WebViewClient;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", "initWebView", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionPayWebFragment extends BaseFragment<FragmentSubscriptionPayWebBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private String url;
    private final WebViewClient webViewClient = new WebViewClient() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionPayWebFragment$webViewClient$1
        @Override // android.webkit.WebViewClient
        @Deprecated(message = "Deprecated in Java")
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            Timber.INSTANCE.d("shouldOverrideUrlLoading url=" + url, new Object[0]);
            if (StringsKt.contains$default((CharSequence) url, (CharSequence) "app.dyaco.com", false, 2, (Object) null)) {
                Bundle bundle = new Bundle();
                bundle.putString(PayWallFragment.RESULT_KEY_PAY_WEB, url);
                FragmentKt.setFragmentResult(this.this$0, PayWallFragment.REQUEST_KEY_PAY_WEB, bundle);
                Global.INSTANCE.setSubscription(true);
                BaseFragment.safeNavigateWithPopUp$default(this.this$0, R.id.userSubscriptionFragment, R.id.settingsMainFragment, false, null, 8, null);
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override // android.webkit.WebViewClient
        @Deprecated(message = "Deprecated in Java")
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
            super.onReceivedError(view, errorCode, description, failingUrl);
            Timber.INSTANCE.d("onReceivedError errorCode=" + errorCode + " description=" + description + " failingUrl=" + failingUrl, new Object[0]);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(error, "error");
            super.onReceivedError(view, request, error);
            Timber.INSTANCE.d("onReceivedError request=" + request + " error=" + error, new Object[0]);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            super.onReceivedHttpError(view, request, errorResponse);
            Timber.INSTANCE.d("onReceivedHttpError request=" + request + " errorResponse=" + errorResponse, new Object[0]);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(error, "error");
            super.onReceivedSslError(view, handler, error);
            Timber.INSTANCE.d("onReceivedSslError handler=" + handler + " error=" + error, new Object[0]);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageStarted(view, url, favicon);
            Timber.INSTANCE.d("onPageStarted url=$" + url, new Object[0]);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            Timber.INSTANCE.d("onPageFinished url=" + url, new Object[0]);
        }
    };
    private final WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionPayWebFragment$webChromeClient$1
        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int newProgress) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onProgressChanged(view, newProgress);
            Timber.INSTANCE.d("onProgressChanged newProgress=" + newProgress, new Object[0]);
        }
    };

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentSubscriptionPayWebBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentSubscriptionPayWebBinding fragmentSubscriptionPayWebBindingInflate = FragmentSubscriptionPayWebBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentSubscriptionPayWebBindingInflate, "inflate(...)");
        return fragmentSubscriptionPayWebBindingInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("url", "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.url = string;
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        WebView webView;
        ImageView imageView;
        FragmentSubscriptionPayWebBinding binding = getBinding();
        if (binding != null && (imageView = binding.back) != null) {
            imageView.setOnClickListener(this);
        }
        initWebView();
        FragmentSubscriptionPayWebBinding binding2 = getBinding();
        if (binding2 == null || (webView = binding2.webView) == null) {
            return;
        }
        String str = this.url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
            str = null;
        }
        webView.loadUrl(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
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
        FragmentSubscriptionPayWebBinding binding = getBinding();
        WebSettings settings2 = (binding == null || (webView15 = binding.webView) == null) ? null : webView15.getSettings();
        if (settings2 != null) {
            settings2.setJavaScriptEnabled(true);
        }
        FragmentSubscriptionPayWebBinding binding2 = getBinding();
        WebSettings settings3 = (binding2 == null || (webView14 = binding2.webView) == null) ? null : webView14.getSettings();
        if (settings3 != null) {
            settings3.setAllowContentAccess(true);
        }
        FragmentSubscriptionPayWebBinding binding3 = getBinding();
        WebSettings settings4 = (binding3 == null || (webView13 = binding3.webView) == null) ? null : webView13.getSettings();
        if (settings4 != null) {
            settings4.setCacheMode(2);
        }
        FragmentSubscriptionPayWebBinding binding4 = getBinding();
        WebSettings settings5 = (binding4 == null || (webView12 = binding4.webView) == null) ? null : webView12.getSettings();
        if (settings5 != null) {
            settings5.setJavaScriptCanOpenWindowsAutomatically(true);
        }
        FragmentSubscriptionPayWebBinding binding5 = getBinding();
        WebSettings settings6 = (binding5 == null || (webView11 = binding5.webView) == null) ? null : webView11.getSettings();
        if (settings6 != null) {
            settings6.setDomStorageEnabled(true);
        }
        FragmentSubscriptionPayWebBinding binding6 = getBinding();
        WebSettings settings7 = (binding6 == null || (webView10 = binding6.webView) == null) ? null : webView10.getSettings();
        if (settings7 != null) {
            settings7.setLoadsImagesAutomatically(true);
        }
        FragmentSubscriptionPayWebBinding binding7 = getBinding();
        WebSettings settings8 = (binding7 == null || (webView9 = binding7.webView) == null) ? null : webView9.getSettings();
        if (settings8 != null) {
            settings8.setAllowFileAccessFromFileURLs(true);
        }
        FragmentSubscriptionPayWebBinding binding8 = getBinding();
        WebSettings settings9 = (binding8 == null || (webView8 = binding8.webView) == null) ? null : webView8.getSettings();
        if (settings9 != null) {
            settings9.setAllowUniversalAccessFromFileURLs(true);
        }
        FragmentSubscriptionPayWebBinding binding9 = getBinding();
        WebSettings settings10 = (binding9 == null || (webView7 = binding9.webView) == null) ? null : webView7.getSettings();
        if (settings10 != null) {
            settings10.setAllowFileAccess(true);
        }
        FragmentSubscriptionPayWebBinding binding10 = getBinding();
        WebSettings settings11 = (binding10 == null || (webView6 = binding10.webView) == null) ? null : webView6.getSettings();
        if (settings11 != null) {
            settings11.setBuiltInZoomControls(false);
        }
        FragmentSubscriptionPayWebBinding binding11 = getBinding();
        WebSettings settings12 = (binding11 == null || (webView5 = binding11.webView) == null) ? null : webView5.getSettings();
        if (settings12 != null) {
            settings12.setDisplayZoomControls(false);
        }
        FragmentSubscriptionPayWebBinding binding12 = getBinding();
        WebSettings settings13 = (binding12 == null || (webView4 = binding12.webView) == null) ? null : webView4.getSettings();
        if (settings13 != null) {
            settings13.setDomStorageEnabled(true);
        }
        FragmentSubscriptionPayWebBinding binding13 = getBinding();
        WebSettings settings14 = (binding13 == null || (webView3 = binding13.webView) == null) ? null : webView3.getSettings();
        if (settings14 != null) {
            settings14.setLoadWithOverviewMode(true);
        }
        FragmentSubscriptionPayWebBinding binding14 = getBinding();
        WebSettings settings15 = (binding14 == null || (webView2 = binding14.webView) == null) ? null : webView2.getSettings();
        if (settings15 != null) {
            settings15.setUseWideViewPort(true);
        }
        FragmentSubscriptionPayWebBinding binding15 = getBinding();
        if (binding15 != null && (webView = binding15.webView) != null && (settings = webView.getSettings()) != null) {
            settings.setSupportZoom(false);
        }
        FragmentSubscriptionPayWebBinding binding16 = getBinding();
        WebView webView16 = binding16 != null ? binding16.webView : null;
        if (webView16 != null) {
            webView16.setWebViewClient(this.webViewClient);
        }
        FragmentSubscriptionPayWebBinding binding17 = getBinding();
        WebView webView17 = binding17 != null ? binding17.webView : null;
        if (webView17 == null) {
            return;
        }
        webView17.setWebChromeClient(this.webChromeClient);
    }
}
