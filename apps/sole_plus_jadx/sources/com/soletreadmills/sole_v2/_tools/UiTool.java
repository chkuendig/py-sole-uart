package com.soletreadmills.sole_v2._tools;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import com.android.SdkConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import timber.log.Timber;

/* compiled from: UiTool.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0016\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010$\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010%\u001a\u00020!¨\u0006&"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/UiTool;", "", "()V", "adjustFontScale", "", "activity", "Landroid/app/Activity;", "configuration", "Landroid/content/res/Configuration;", "adjustResizeOnGlobalLayoutForWebView", "rootView", "Landroid/view/View;", "webView", "Landroid/webkit/WebView;", "convertDpToPixel", "", SdkConstants.UNIT_DP, SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "convertPixelToDp", SdkConstants.UNIT_PX, "getDensity", "getDisplaySize", "Landroid/util/DisplayMetrics;", "getNavigationBarHeight", "", "getStatusBarHeight", "getTextHeight", "textView", "Landroid/widget/TextView;", "text", "", "getTextWidth", "", "isZh", "", "toText", "defaultText", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UiTool {
    public static final int $stable = 0;
    public static final UiTool INSTANCE = new UiTool();

    private UiTool() {
    }

    public final synchronized void adjustFontScale(Activity activity, Configuration configuration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        configuration.fontScale = 1.0f;
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        Object systemService = activity.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        displayMetrics.scaledDensity = configuration.fontScale * displayMetrics.density;
        activity.getBaseContext().getResources().updateConfiguration(configuration, displayMetrics);
    }

    public final synchronized float convertDpToPixel(float dp, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return dp * getDensity(context);
    }

    public final synchronized float convertPixelToDp(float px, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return px / getDensity(context);
    }

    public final synchronized float getDensity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDisplayMetrics().density;
    }

    public final synchronized DisplayMetrics getDisplaySize(Context context) {
        DisplayMetrics displayMetrics;
        Intrinsics.checkNotNullParameter(context, "context");
        displayMetrics = context.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "getDisplayMetrics(...)");
        return displayMetrics;
    }

    public final synchronized int getNavigationBarHeight(Context context) {
        int dimensionPixelSize;
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", SdkConstants.TAG_DIMEN, "android"));
        Timber.INSTANCE.v("getNavigationBarHeight height=" + dimensionPixelSize, new Object[0]);
        return dimensionPixelSize;
    }

    public final synchronized void adjustResizeOnGlobalLayoutForWebView(final View rootView, final WebView webView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(webView, "webView");
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.soletreadmills.sole_v2._tools.UiTool$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                UiTool.adjustResizeOnGlobalLayoutForWebView$lambda$0(rootView, webView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void adjustResizeOnGlobalLayoutForWebView$lambda$0(View rootView, WebView webView) {
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        Intrinsics.checkNotNullParameter(webView, "$webView");
        DisplayMetrics displayMetrics = rootView.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rootView.getWindowVisibleDisplayFrame(rect);
        int i = displayMetrics.heightPixels - rect.bottom;
        if (rootView.getPaddingBottom() != i) {
            rootView.setPadding(rootView.getPaddingLeft(), rootView.getPaddingTop(), rootView.getPaddingRight(), i);
        } else if (i != 0) {
            webView.evaluateJavascript("if (document.activeElement) { document.activeElement.scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"}); }", null);
        }
    }

    @JvmStatic
    public static final synchronized int getStatusBarHeight(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect rect = new Rect();
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        Timber.INSTANCE.i("StatusBar Height= " + i + " , TitleBar Height = " + (window.findViewById(R.id.content).getTop() - i), new Object[0]);
        Resources resources = activity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", SdkConstants.TAG_DIMEN, "android"));
        Timber.INSTANCE.d("getStatusBarHeight height=" + dimensionPixelSize, new Object[0]);
        if (i > 0 && dimensionPixelSize > 0) {
            if (i <= dimensionPixelSize) {
                i = dimensionPixelSize;
            }
            return i;
        }
        if (i > 0) {
            return i;
        }
        if (dimensionPixelSize > 0) {
            return dimensionPixelSize;
        }
        return resources.getDimensionPixelSize(com.soletreadmills.sole_v2.R.dimen.status_bar_height);
    }

    public final synchronized int getTextWidth(TextView textView, String text) {
        Rect rect;
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(text, "text");
        rect = new Rect();
        TextPaint paint = textView.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "getPaint(...)");
        paint.getTextBounds(text, 0, text.length(), rect);
        rect.height();
        return rect.width();
    }

    public final synchronized int getTextWidth(TextView textView, CharSequence text) {
        Rect rect;
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(text, "text");
        rect = new Rect();
        TextPaint paint = textView.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "getPaint(...)");
        paint.getTextBounds(text, 0, text.length(), rect);
        rect.height();
        return rect.width();
    }

    public final synchronized int getTextHeight(TextView textView, CharSequence text) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(text, "text");
        textView.setText(text, TextView.BufferType.SPANNABLE);
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.measure(View.MeasureSpec.makeMeasureSpec(getDisplaySize(context).widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return textView.getMeasuredHeight();
    }

    public final synchronized boolean isZh(Context context) {
        Locale locale;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            locale = context.getResources().getConfiguration().getLocales().get(0);
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            locale = null;
        }
        if (locale == null) {
            return false;
        }
        String language = locale.getLanguage();
        Timber.INSTANCE.d("isZh language=" + language, new Object[0]);
        Intrinsics.checkNotNull(language);
        return StringsKt.endsWith$default(language, "zh", false, 2, (Object) null);
    }

    public static /* synthetic */ String toText$default(UiTool uiTool, Object obj, String str, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = "";
        }
        return uiTool.toText(obj, str);
    }

    public final String toText(Object text, String defaultText) {
        Intrinsics.checkNotNullParameter(defaultText, "defaultText");
        if (text == null || Intrinsics.areEqual(text, AbstractJsonLexerKt.NULL)) {
            return StringsKt.replace$default(StringsKt.replace$default(String.valueOf(text), "\n", "", false, 4, (Object) null), "\r", "", false, 4, (Object) null);
        }
        return StringsKt.replace$default(StringsKt.replace$default(text.toString(), "\n", "", false, 4, (Object) null), "\r", "", false, 4, (Object) null);
    }
}
