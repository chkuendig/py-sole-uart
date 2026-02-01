package com.soletreadmills.sole_v2.ui.settings;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._tools.UiTool;
import com.soletreadmills.sole_v2.databinding.FragmentGarminConnectBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: GarminConnectFragment.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0006J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u000eH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/GarminConnectFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentGarminConnectBinding;", "Landroid/view/View$OnClickListener;", "()V", "KEY_GARMIN_URL", "", "getKEY_GARMIN_URL", "()Ljava/lang/String;", "garminUrl", "getGarminUrl", "setGarminUrl", "(Ljava/lang/String;)V", "clearCacheAndCookies", "", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "newInstance", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "onDestroyView", "onPause", "onResume", "onStart", "setWebView", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GarminConnectFragment extends BaseFragment<FragmentGarminConnectBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private final String KEY_GARMIN_URL = "KEY_GARMIN_URL";
    private String garminUrl = "";

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    public final String getKEY_GARMIN_URL() {
        return this.KEY_GARMIN_URL;
    }

    public final String getGarminUrl() {
        return this.garminUrl;
    }

    public final void setGarminUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.garminUrl = str;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentGarminConnectBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentGarminConnectBinding fragmentGarminConnectBindingInflate = FragmentGarminConnectBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentGarminConnectBindingInflate, "inflate(...)");
        return fragmentGarminConnectBindingInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Bundle arguments = getArguments();
            if (arguments != null) {
                String string = arguments.getString(this.KEY_GARMIN_URL, "");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.garminUrl = string;
            }
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        WebView webView;
        super.onResume();
        FragmentGarminConnectBinding binding = getBinding();
        if (binding == null || (webView = binding.webView) == null) {
            return;
        }
        webView.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        WebView webView;
        super.onPause();
        FragmentGarminConnectBinding binding = getBinding();
        if (binding == null || (webView = binding.webView) == null) {
            return;
        }
        webView.onPause();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        WebView webView;
        FragmentGarminConnectBinding binding = getBinding();
        if (binding != null && (webView = binding.webView) != null) {
            webView.stopLoading();
            webView.loadUrl("about:blank");
            webView.onPause();
            webView.removeAllViews();
            webView.destroy();
        }
        super.onDestroyView();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        FragmentGarminConnectBinding binding = getBinding();
        if (binding != null) {
            View statusBarHeight = binding.statusBarHeight;
            Intrinsics.checkNotNullExpressionValue(statusBarHeight, "statusBarHeight");
            setStatusBarViewHeight(statusBarHeight);
            MainActivity mainActivity = getMainActivity();
            if (mainActivity != null) {
                binding.navigationBarHeight.getLayoutParams().height = UiTool.INSTANCE.getNavigationBarHeight(mainActivity);
                binding.navigationBarHeight.requestLayout();
            }
            UiTool uiTool = UiTool.INSTANCE;
            View root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            WebView webView = binding.webView;
            Intrinsics.checkNotNullExpressionValue(webView, "webView");
            uiTool.adjustResizeOnGlobalLayoutForWebView(root, webView);
        }
        setWebView();
    }

    private final void setWebView() {
        FragmentGarminConnectBinding binding;
        View root;
        Runnable runnable = new Runnable() { // from class: com.soletreadmills.sole_v2.ui.settings.GarminConnectFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GarminConnectFragment.setWebView$lambda$4(this.f$0);
            }
        };
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            if (getBinding() == null || (binding = getBinding()) == null || (root = binding.getRoot()) == null) {
                return;
            }
            root.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setWebView$lambda$4(final GarminConnectFragment this$0) {
        WebView webView;
        WebView webView2;
        WebSettings settings;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentGarminConnectBinding binding = this$0.getBinding();
        if (binding != null && (webView2 = binding.webView) != null && (settings = webView2.getSettings()) != null) {
            settings.setJavaScriptEnabled(true);
            settings.setAllowContentAccess(true);
            settings.setCacheMode(-1);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
            settings.setAllowFileAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setSupportZoom(true);
        }
        FragmentGarminConnectBinding binding2 = this$0.getBinding();
        WebView webView3 = binding2 != null ? binding2.webView : null;
        if (webView3 != null) {
            webView3.setWebChromeClient(new WebChromeClient() { // from class: com.soletreadmills.sole_v2.ui.settings.GarminConnectFragment$setWebView$runnable$1$2
                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView view, int newProgress) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Timber.INSTANCE.d("onProgressChanged newProgress=" + newProgress, new Object[0]);
                    super.onProgressChanged(view, newProgress);
                }
            });
        }
        FragmentGarminConnectBinding binding3 = this$0.getBinding();
        WebView webView4 = binding3 != null ? binding3.webView : null;
        if (webView4 != null) {
            webView4.setWebViewClient(new WebViewClient() { // from class: com.soletreadmills.sole_v2.ui.settings.GarminConnectFragment$setWebView$runnable$1$3
                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    Uri uri;
                    WebView webView5;
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(url, "url");
                    Timber.INSTANCE.d("shouldOverrideUrlLoading url=" + url, new Object[0]);
                    if (URLUtil.isNetworkUrl(url)) {
                        try {
                            uri = Uri.parse(url);
                        } catch (Exception e) {
                            Timber.INSTANCE.e(e);
                            uri = null;
                        }
                        if (uri != null) {
                            Timber.INSTANCE.d("shouldOverrideUrlLoading uri getScheme=" + uri.getScheme(), new Object[0]);
                            Timber.INSTANCE.d("shouldOverrideUrlLoading uri getHost=" + uri.getHost(), new Object[0]);
                            Timber.INSTANCE.d("shouldOverrideUrlLoading uri getPath=" + uri.getPath(), new Object[0]);
                            Timber.INSTANCE.d("shouldOverrideUrlLoading uri getQueryParameter success=" + uri.getQueryParameter("success"), new Object[0]);
                            if (this.this$0.getContext() != null && TextUtils.equals(uri.getPath(), "/garminConnect")) {
                                if (uri.getBooleanQueryParameter("success", false)) {
                                    this.this$0.safeNavigateUp();
                                } else {
                                    GarminConnectFragment garminConnectFragment = this.this$0;
                                    String string = garminConnectFragment.getString(R.string.update_failed);
                                    String string2 = this.this$0.getString(R.string.confirm);
                                    final GarminConnectFragment garminConnectFragment2 = this.this$0;
                                    CustomDialogKt.showCustomDialog$default(garminConnectFragment, null, string, string2, null, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.settings.GarminConnectFragment$setWebView$runnable$1$3$shouldOverrideUrlLoading$1
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
                                            garminConnectFragment2.safeNavigateUp();
                                        }
                                    }, null, false, 96, null);
                                }
                                return true;
                            }
                        }
                    }
                    FragmentGarminConnectBinding binding4 = this.this$0.getBinding();
                    if (binding4 != null && (webView5 = binding4.webView) != null) {
                        webView5.loadUrl(url);
                    }
                    return true;
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(request, "request");
                    Timber.INSTANCE.d("shouldOverrideUrlLoading request=" + request.getUrl(), new Object[0]);
                    return super.shouldOverrideUrlLoading(view, request);
                }

                @Override // android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(request, "request");
                    Timber.INSTANCE.d("shouldInterceptRequest request=" + request.getUrl(), new Object[0]);
                    return super.shouldInterceptRequest(view, request);
                }

                @Override // android.webkit.WebViewClient
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    Timber.INSTANCE.d("onPageStarted url=" + url, new Object[0]);
                    super.onPageStarted(view, url, favicon);
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView view, String url) {
                    Timber.INSTANCE.d("onPageFinished url=" + url, new Object[0]);
                    super.onPageFinished(view, url);
                }
            });
        }
        this$0.clearCacheAndCookies();
        FragmentGarminConnectBinding binding4 = this$0.getBinding();
        if (binding4 == null || (webView = binding4.webView) == null) {
            return;
        }
        webView.loadUrl(this$0.garminUrl);
    }

    public final GarminConnectFragment newInstance(String garminUrl) {
        Intrinsics.checkNotNullParameter(garminUrl, "garminUrl");
        GarminConnectFragment garminConnectFragment = new GarminConnectFragment();
        Bundle bundle = new Bundle();
        bundle.putString(this.KEY_GARMIN_URL, garminUrl);
        garminConnectFragment.setArguments(bundle);
        return garminConnectFragment;
    }

    private final void clearCacheAndCookies() {
        WebView webView;
        WebView webView2;
        try {
            FragmentGarminConnectBinding binding = getBinding();
            if (binding != null && (webView2 = binding.webView) != null) {
                webView2.clearCache(true);
            }
            FragmentGarminConnectBinding binding2 = getBinding();
            if (binding2 != null && (webView = binding2.webView) != null) {
                webView.clearHistory();
            }
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
            Timber.INSTANCE.d("Cache and cookies cleared successfully", new Object[0]);
        } catch (Exception e) {
            Timber.INSTANCE.e(e, "Error clearing cache and cookies", new Object[0]);
        }
    }
}
