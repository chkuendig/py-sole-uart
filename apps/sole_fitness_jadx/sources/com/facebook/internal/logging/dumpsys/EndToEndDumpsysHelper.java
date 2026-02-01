package com.facebook.internal.logging.dumpsys;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.logging.dumpsys.AndroidRootResolver;
import com.facebook.internal.security.CertificateUtil;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EndToEndDumpsysHelper.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001b\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002JB\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0002¢\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper;", "", "()V", "lithoViewToStringMethod", "Ljava/lang/reflect/Method;", "rootResolver", "Lcom/facebook/internal/logging/dumpsys/AndroidRootResolver;", "webViewDumpHelper", "Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper;", "dumpViewHierarchy", "", "prefix", "", "writer", "Ljava/io/PrintWriter;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "leftOffset", "", "topOffset", "withWebView", "", "withProps", "args", "", "(Ljava/lang/String;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "writeLithoViewSubHierarchy", "Api21Utils", "Api24Utils", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EndToEndDumpsysHelper {
    private static final String ALL_ROOTS_ARGUMENT = "all-roots";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String E2E_ARGUMENT = "e2e";
    private static final String LITHO_VIEW_CLASS = "com.facebook.litho.LithoView";
    private static final String LITHO_VIEW_TEST_HELPER_CLASS = "com.facebook.litho.LithoViewTestHelper";
    private static final String LITHO_VIEW_TO_STRING_METHOD = "viewToStringForE2E";
    private static final String RC_TEXT_VIEW_SIMPLE_CLASS_NAME = "RCTextView";
    private static final String TOP_ROOT_ARGUMENT = "top-root";
    private static final String WITH_PROPS_ARGUMENT = "props";
    private static final String WITH_WEBVIEW_ARGUMENT = "webview";
    private static EndToEndDumpsysHelper instance;
    private static Method rcTextViewGetTextMethod;
    private Method lithoViewToStringMethod;
    private final AndroidRootResolver rootResolver = new AndroidRootResolver();
    private final WebViewDumpHelper webViewDumpHelper = new WebViewDumpHelper();

    @JvmStatic
    public static final boolean maybeDump(String str, PrintWriter printWriter, String[] strArr) {
        return INSTANCE.maybeDump(str, printWriter, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dumpViewHierarchy(String prefix, PrintWriter writer, String[] args) {
        View view;
        writer.print(prefix);
        writer.println("Top Level Window View Hierarchy:");
        Companion companion = INSTANCE;
        boolean zHasArgument = companion.hasArgument(args, ALL_ROOTS_ARGUMENT);
        boolean zHasArgument2 = companion.hasArgument(args, TOP_ROOT_ARGUMENT);
        boolean zHasArgument3 = companion.hasArgument(args, WITH_WEBVIEW_ARGUMENT);
        boolean zHasArgument4 = companion.hasArgument(args, WITH_PROPS_ARGUMENT);
        try {
            List<AndroidRootResolver.Root> listListActiveRoots = this.rootResolver.listActiveRoots();
            if (listListActiveRoots != null && !listListActiveRoots.isEmpty()) {
                Collections.reverse(listListActiveRoots);
                WindowManager.LayoutParams layoutParams = null;
                for (AndroidRootResolver.Root root : listListActiveRoots) {
                    if (root != null && (view = root.getView()) != null && view.getVisibility() == 0) {
                        if (!zHasArgument && layoutParams != null && Math.abs(root.getParam().type - layoutParams.type) != 1) {
                            break;
                        }
                        dumpViewHierarchy(prefix + "  ", writer, root.getView(), 0, 0, zHasArgument3, zHasArgument4);
                        WindowManager.LayoutParams param = root.getParam();
                        if (zHasArgument2) {
                            break;
                        } else {
                            layoutParams = param;
                        }
                    }
                }
                this.webViewDumpHelper.dump(writer);
            }
        } catch (Exception e) {
            writer.println("Failure in view hierarchy dump: " + e.getMessage());
        }
    }

    private final void dumpViewHierarchy(String prefix, PrintWriter writer, View view, int leftOffset, int topOffset, boolean withWebView, boolean withProps) throws JSONException, Resources.NotFoundException, ClassNotFoundException {
        ViewGroup viewGroup;
        int childCount;
        writer.print(prefix);
        if (view == null) {
            writer.println("null");
            return;
        }
        writer.print(view.getClass().getName());
        writer.print("{");
        writer.print(Integer.toHexString(view.hashCode()));
        Companion companion = INSTANCE;
        companion.writeViewFlags(writer, view);
        companion.writeViewBounds(writer, view, leftOffset, topOffset);
        companion.writeViewTestId(writer, view);
        companion.writeViewText(writer, view);
        if (withProps && Build.VERSION.SDK_INT >= 21) {
            Api21Utils.INSTANCE.writeExtraProps(writer, view);
        }
        writer.println("}");
        if (companion.isExtendsLithoView(view)) {
            writeLithoViewSubHierarchy(writer, view, prefix, withProps);
        }
        if (withWebView && (view instanceof WebView)) {
            this.webViewDumpHelper.handle((WebView) view);
        }
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            String str = prefix + "  ";
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            for (int i = 0; i < childCount; i++) {
                dumpViewHierarchy(str, writer, viewGroup.getChildAt(i), iArr[0], iArr[1], withWebView, withProps);
            }
        }
    }

    private final void writeLithoViewSubHierarchy(PrintWriter writer, View view, String prefix, boolean withProps) throws ClassNotFoundException {
        try {
            if (this.lithoViewToStringMethod == null) {
                Class<?> cls = Class.forName(LITHO_VIEW_TEST_HELPER_CLASS);
                Intrinsics.checkNotNullExpressionValue(cls, "Class.forName(LITHO_VIEW_TEST_HELPER_CLASS)");
                this.lithoViewToStringMethod = cls.getDeclaredMethod(LITHO_VIEW_TO_STRING_METHOD, View.class, Integer.TYPE, Boolean.TYPE);
            }
            Method method = this.lithoViewToStringMethod;
            Object objInvoke = method != null ? method.invoke(null, view, Integer.valueOf((prefix.length() / 2) + 1), Boolean.valueOf(withProps)) : null;
            if (objInvoke == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            Intrinsics.checkNotNullExpressionValue(writer.append((CharSequence) objInvoke), "writer.append(lithoViewDump)");
        } catch (Exception e) {
            writer.append((CharSequence) prefix).append("Failed litho view sub hierarch dump: ").append((CharSequence) INSTANCE.fixString(e.getMessage(), 100)).println();
        }
    }

    /* compiled from: EndToEndDumpsysHelper.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper$Api21Utils;", "", "()V", "keyedTagsField", "Ljava/lang/reflect/Field;", "getTags", "Lorg/json/JSONObject;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "writeExtraProps", "", "writer", "Ljava/io/PrintWriter;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class Api21Utils {
        public static final Api21Utils INSTANCE = new Api21Utils();
        private static Field keyedTagsField;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mKeyedTags");
                keyedTagsField = declaredField;
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
            } catch (NoSuchFieldException unused) {
            }
        }

        private Api21Utils() {
        }

        public final void writeExtraProps(PrintWriter writer, View view) throws JSONException {
            AccessibilityNodeInfo accessibilityNodeInfoCreateNodeInfoFromView;
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(view, "view");
            if (Build.VERSION.SDK_INT >= 21 && (accessibilityNodeInfoCreateNodeInfoFromView = EndToEndDumpsysHelper.INSTANCE.createNodeInfoFromView(view)) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (view instanceof TextView) {
                        ColorStateList textColors = ((TextView) view).getTextColors();
                        Intrinsics.checkNotNullExpressionValue(textColors, "view.textColors");
                        jSONObject.put("textColor", textColors.getDefaultColor());
                        jSONObject.put("textSize", ((TextView) view).getTextSize());
                        jSONObject.put(ViewHierarchyConstants.HINT_KEY, EndToEndDumpsysHelper.INSTANCE.fixString(((TextView) view).getHint(), 100));
                    }
                    JSONObject tags = getTags(view);
                    if (tags != null) {
                        jSONObject.put("keyedTags", tags);
                    }
                    JSONArray jSONArray = new JSONArray();
                    for (AccessibilityNodeInfo.AccessibilityAction action : accessibilityNodeInfoCreateNodeInfoFromView.getActionList()) {
                        Intrinsics.checkNotNullExpressionValue(action, "action");
                        CharSequence label = action.getLabel();
                        if (label == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        String str = (String) label;
                        if (str != null) {
                            jSONArray.put(EndToEndDumpsysHelper.INSTANCE.fixString(str, 50));
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("actions", jSONArray);
                    }
                    String strFixString = EndToEndDumpsysHelper.INSTANCE.fixString(accessibilityNodeInfoCreateNodeInfoFromView.getContentDescription(), 50);
                    if (strFixString != null) {
                        if (strFixString.length() > 0) {
                            jSONObject.put("content-description", strFixString);
                        }
                    }
                    jSONObject.put("accessibility-focused", accessibilityNodeInfoCreateNodeInfoFromView.isAccessibilityFocused()).put("checkable", accessibilityNodeInfoCreateNodeInfoFromView.isCheckable()).put("checked", accessibilityNodeInfoCreateNodeInfoFromView.isChecked()).put("class-name", EndToEndDumpsysHelper.INSTANCE.fixString(accessibilityNodeInfoCreateNodeInfoFromView.getClassName(), 50)).put("clickable", accessibilityNodeInfoCreateNodeInfoFromView.isClickable()).put("content-invalid", accessibilityNodeInfoCreateNodeInfoFromView.isContentInvalid()).put("dismissable", accessibilityNodeInfoCreateNodeInfoFromView.isDismissable()).put("editable", accessibilityNodeInfoCreateNodeInfoFromView.isEditable()).put("enabled", accessibilityNodeInfoCreateNodeInfoFromView.isEnabled()).put("focusable", accessibilityNodeInfoCreateNodeInfoFromView.isFocusable()).put("focused", accessibilityNodeInfoCreateNodeInfoFromView.isFocused()).put("long-clickable", accessibilityNodeInfoCreateNodeInfoFromView.isLongClickable()).put("multiline", accessibilityNodeInfoCreateNodeInfoFromView.isMultiLine()).put("password", accessibilityNodeInfoCreateNodeInfoFromView.isPassword()).put("scrollable", accessibilityNodeInfoCreateNodeInfoFromView.isScrollable()).put("selected", accessibilityNodeInfoCreateNodeInfoFromView.isSelected()).put("visible-to-user", accessibilityNodeInfoCreateNodeInfoFromView.isVisibleToUser());
                    if (Build.VERSION.SDK_INT >= 24) {
                        Api24Utils.INSTANCE.addExtraProps(jSONObject, accessibilityNodeInfoCreateNodeInfoFromView);
                    }
                } catch (Exception e) {
                    try {
                        jSONObject.put("DUMP-ERROR", EndToEndDumpsysHelper.INSTANCE.fixString(e.getMessage(), 50));
                    } catch (JSONException unused) {
                    }
                }
                writer.append(" props=\"").append((CharSequence) jSONObject.toString()).append("\"");
            }
        }

        private final JSONObject getTags(View view) throws JSONException, NoSuchFieldException {
            try {
                if (keyedTagsField == null) {
                    Field declaredField = View.class.getDeclaredField("mKeyedTags");
                    keyedTagsField = declaredField;
                    if (declaredField != null) {
                        declaredField.setAccessible(true);
                    }
                }
                Field field = keyedTagsField;
                Object obj = field != null ? field.get(view) : null;
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.util.SparseArray<*>");
                }
                SparseArray sparseArray = (SparseArray) obj;
                if (sparseArray == null || sparseArray.size() <= 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    int size = sparseArray.size();
                    for (int i = 0; i < size; i++) {
                        try {
                            jSONObject.put(ResourcesUtil.getIdStringQuietly(view.getResources(), sparseArray.keyAt(i)), sparseArray.valueAt(i));
                        } catch (JSONException unused) {
                        }
                    }
                } catch (Exception unused2) {
                }
                return jSONObject;
            } catch (Exception unused3) {
                return null;
            }
        }
    }

    /* compiled from: EndToEndDumpsysHelper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper$Api24Utils;", "", "()V", "addExtraProps", "", EndToEndDumpsysHelper.WITH_PROPS_ARGUMENT, "Lorg/json/JSONObject;", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class Api24Utils {
        public static final Api24Utils INSTANCE = new Api24Utils();

        private Api24Utils() {
        }

        public final void addExtraProps(JSONObject props, AccessibilityNodeInfo nodeInfo) throws JSONException {
            Intrinsics.checkNotNullParameter(props, "props");
            Intrinsics.checkNotNullParameter(nodeInfo, "nodeInfo");
            if (Build.VERSION.SDK_INT < 24) {
                return;
            }
            props.put("context-clickable", nodeInfo.isContextClickable()).put("drawing-order", nodeInfo.getDrawingOrder()).put("important-for-accessibility", nodeInfo.isImportantForAccessibility());
        }
    }

    /* compiled from: EndToEndDumpsysHelper.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0003J%\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J-\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010&J\u0018\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010)\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0019H\u0002J\u0018\u0010,\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010-\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010.\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper$Companion;", "", "()V", "ALL_ROOTS_ARGUMENT", "", "E2E_ARGUMENT", "LITHO_VIEW_CLASS", "LITHO_VIEW_TEST_HELPER_CLASS", "LITHO_VIEW_TO_STRING_METHOD", "RC_TEXT_VIEW_SIMPLE_CLASS_NAME", "TOP_ROOT_ARGUMENT", "WITH_PROPS_ARGUMENT", "WITH_WEBVIEW_ARGUMENT", "instance", "Lcom/facebook/internal/logging/dumpsys/EndToEndDumpsysHelper;", "rcTextViewGetTextMethod", "Ljava/lang/reflect/Method;", "createNodeInfoFromView", "Landroid/view/accessibility/AccessibilityNodeInfo;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "fixString", "str", "", "maxLength", "", "getTextFromRcTextView", "hasArgument", "", "args", "", "argument", "([Ljava/lang/String;Ljava/lang/String;)Z", "isExtendsLithoView", "maybeDump", "prefix", "writer", "Ljava/io/PrintWriter;", "(Ljava/lang/String;Ljava/io/PrintWriter;[Ljava/lang/String;)Z", "maybeWriteViewTestIdFromTag", "", "writeViewBounds", "leftOffset", "topOffset", "writeViewFlags", "writeViewTestId", "writeViewText", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean maybeDump(String prefix, PrintWriter writer, String[] args) {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(writer, "writer");
            if (args != null) {
                if ((!(args.length == 0)) && Intrinsics.areEqual("e2e", args[0])) {
                    if (EndToEndDumpsysHelper.instance == null) {
                        EndToEndDumpsysHelper.instance = new EndToEndDumpsysHelper();
                    }
                    EndToEndDumpsysHelper endToEndDumpsysHelper = EndToEndDumpsysHelper.instance;
                    if (endToEndDumpsysHelper != null) {
                        endToEndDumpsysHelper.dumpViewHierarchy(prefix, writer, args);
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isExtendsLithoView(View view) {
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                if (Intrinsics.areEqual(superclass.getName(), EndToEndDumpsysHelper.LITHO_VIEW_CLASS)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void writeViewFlags(PrintWriter writer, View view) {
            writer.print(StringUtils.SPACE);
            int visibility = view.getVisibility();
            String str = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            if (visibility == 0) {
                writer.print(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            } else if (visibility == 4) {
                writer.print("I");
            } else if (visibility == 8) {
                writer.print("G");
            } else {
                writer.print(".");
            }
            writer.print(view.isFocusable() ? "F" : ".");
            writer.print(view.isEnabled() ? ExifInterface.LONGITUDE_EAST : ".");
            writer.print(".");
            writer.print(view.isHorizontalScrollBarEnabled() ? "H" : ".");
            if (!view.isVerticalScrollBarEnabled()) {
                str = ".";
            }
            writer.print(str);
            writer.print(view.isClickable() ? "C" : ".");
            writer.print(view.isLongClickable() ? "L" : ".");
            writer.print(StringUtils.SPACE);
            writer.print(view.isFocused() ? "F" : ".");
            writer.print(view.isSelected() ? ExifInterface.LATITUDE_SOUTH : ".");
            writer.print(view.isHovered() ? "H" : ".");
            writer.print(view.isActivated() ? ExifInterface.GPS_MEASUREMENT_IN_PROGRESS : ".");
            writer.print(view.isDirty() ? "D" : ".");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void writeViewBounds(PrintWriter writer, View view, int leftOffset, int topOffset) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            writer.print(StringUtils.SPACE);
            writer.print(iArr[0] - leftOffset);
            writer.print(",");
            writer.print(iArr[1] - topOffset);
            writer.print(HelpFormatter.DEFAULT_OPT_PREFIX);
            writer.print((iArr[0] + view.getWidth()) - leftOffset);
            writer.print(",");
            writer.print((iArr[1] + view.getHeight()) - topOffset);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void writeViewTestId(PrintWriter writer, View view) throws Resources.NotFoundException {
            String resourcePackageName;
            try {
                int id = view.getId();
                if (id == -1) {
                    Companion companion = this;
                    maybeWriteViewTestIdFromTag(writer, view);
                    return;
                }
                writer.append(" #");
                writer.append((CharSequence) Integer.toHexString(id));
                Resources resources = view.getResources();
                if (id > 0 && resources != null) {
                    int i = (-16777216) & id;
                    if (i == 16777216) {
                        resourcePackageName = Constants.PLATFORM;
                    } else if (i != 2130706432) {
                        resourcePackageName = resources.getResourcePackageName(id);
                        Intrinsics.checkNotNullExpressionValue(resourcePackageName, "resources.getResourcePackageName(id)");
                    } else {
                        resourcePackageName = "app";
                    }
                    writer.print(StringUtils.SPACE);
                    writer.print(resourcePackageName);
                    writer.print(CertificateUtil.DELIMITER);
                    writer.print(resources.getResourceTypeName(id));
                    writer.print("/");
                    writer.print(resources.getResourceEntryName(id));
                    return;
                }
                Companion companion2 = this;
                maybeWriteViewTestIdFromTag(writer, view);
            } catch (Exception unused) {
                maybeWriteViewTestIdFromTag(writer, view);
            }
        }

        private final void maybeWriteViewTestIdFromTag(PrintWriter writer, View view) {
            Object tag = view.getTag();
            if (!(tag instanceof String)) {
                tag = null;
            }
            String str = (String) tag;
            if (str != null) {
                String str2 = str;
                if (str2.length() == 0) {
                    return;
                }
                writer.print(" app:tag/");
                writer.print(fixString(str2, 60));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0049 A[Catch: Exception -> 0x00b4, TryCatch #0 {Exception -> 0x00b4, blocks: (B:3:0x0001, B:5:0x000a, B:39:0x008e, B:44:0x009b, B:6:0x0016, B:8:0x0026, B:9:0x002f, B:11:0x0035, B:13:0x003b, B:18:0x0049, B:20:0x004f, B:25:0x0063, B:32:0x0078, B:35:0x007e, B:36:0x0081), top: B:47:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void writeViewText(PrintWriter writer, View view) {
            String string;
            try {
                if (view instanceof TextView) {
                    string = ((TextView) view).getText().toString();
                } else if (Intrinsics.areEqual(view.getClass().getSimpleName(), EndToEndDumpsysHelper.RC_TEXT_VIEW_SIMPLE_CLASS_NAME)) {
                    Companion companion = this;
                    string = getTextFromRcTextView(view);
                } else {
                    CharSequence contentDescription = view.getContentDescription();
                    String string2 = contentDescription != null ? contentDescription.toString() : null;
                    if (string2 != null) {
                        if (string2.length() == 0) {
                        }
                    } else {
                        Object tag = view.getTag();
                        if (tag != null) {
                            String string3 = tag.toString();
                            int length = string3.length() - 1;
                            int i = 0;
                            boolean z = false;
                            while (i <= length) {
                                boolean z2 = Intrinsics.compare((int) string3.charAt(!z ? i : length), 32) <= 0;
                                if (z) {
                                    if (!z2) {
                                        break;
                                    } else {
                                        length--;
                                    }
                                } else if (z2) {
                                    i++;
                                } else {
                                    z = true;
                                }
                            }
                            string = string3.subSequence(i, length + 1).toString();
                        } else {
                            string = string2;
                        }
                    }
                }
                if (string != null) {
                    if (string.length() == 0) {
                        return;
                    }
                    writer.print(" text=\"");
                    Companion companion2 = this;
                    writer.print(fixString(string, 600));
                    writer.print("\"");
                }
            } catch (Exception unused) {
            }
        }

        private final String getTextFromRcTextView(View view) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            if (EndToEndDumpsysHelper.rcTextViewGetTextMethod == null) {
                EndToEndDumpsysHelper.rcTextViewGetTextMethod = view.getClass().getDeclaredMethod("getText", new Class[0]);
            }
            Method method = EndToEndDumpsysHelper.rcTextViewGetTextMethod;
            Object objInvoke = method != null ? method.invoke(view, new Object[0]) : null;
            if (objInvoke != null) {
                return objInvoke.toString();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String fixString(CharSequence str, int maxLength) {
            if (str == null) {
                return "";
            }
            if (str.length() == 0) {
                return "";
            }
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str.toString(), " \n", StringUtils.SPACE, false, 4, (Object) null), StringUtils.LF, StringUtils.SPACE, false, 4, (Object) null), "\"", "", false, 4, (Object) null);
            if (str.length() <= maxLength) {
                return strReplace$default;
            }
            StringBuilder sb = new StringBuilder();
            Objects.requireNonNull(strReplace$default, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strReplace$default.substring(0, maxLength);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(strSubstring);
            sb.append("...");
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean hasArgument(String[] args, String argument) {
            if (args == null) {
                return false;
            }
            for (String str : args) {
                if (StringsKt.equals(argument, str, true)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AccessibilityNodeInfo createNodeInfoFromView(View view) {
            if (view == null) {
                return null;
            }
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            try {
                view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
                return accessibilityNodeInfoObtain;
            } catch (NullPointerException unused) {
                if (accessibilityNodeInfoObtain != null) {
                    accessibilityNodeInfoObtain.recycle();
                }
                return null;
            }
        }
    }
}
