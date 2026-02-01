package com.soletreadmills.sole_v2._tools;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.android.SdkConstants;
import com.blankj.utilcode.util.KeyboardUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyboardHideTool.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019¨\u0006\u001a"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/KeyboardHideTool;", "", "()V", "clearViewFocus", "", "view", "Landroid/view/View;", "closeKeyboard", "editText", "Landroid/widget/EditText;", "hideKeyboard", "activity", "Landroid/app/Activity;", "ev", "Landroid/view/MotionEvent;", "hideSoftInput", "token", "Landroid/os/IBinder;", "isShouldHideKeyboard", "", "v", "openKeyboard", "showSoftInput", "showSoftKeyboard", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KeyboardHideTool {
    public static final int $stable = 0;
    public static final KeyboardHideTool INSTANCE = new KeyboardHideTool();

    private KeyboardHideTool() {
    }

    public final void hideKeyboard(Activity activity, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 1 || ev.getAction() == 3) {
            View currentFocus = activity.getCurrentFocus();
            if (isShouldHideKeyboard(currentFocus, ev)) {
                Intrinsics.checkNotNull(currentFocus);
                hideSoftInput(activity, currentFocus.getWindowToken());
                clearViewFocus(currentFocus);
            }
        }
    }

    public final void clearViewFocus(View view) {
        if (view != null) {
            if (view instanceof EditText) {
                ((EditText) view).clearFocus();
            } else {
                view.clearFocus();
            }
        }
    }

    public final boolean isShouldHideKeyboard(View v, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (v == null || !(v instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        EditText editText = (EditText) v;
        editText.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return ev.getX() <= ((float) i) || ev.getX() >= ((float) (editText.getWidth() + i)) || ev.getY() <= ((float) i2) || ev.getY() >= ((float) (editText.getHeight() + i2));
    }

    public final void hideSoftInput(Activity activity, IBinder token) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        KeyboardUtils.hideSoftInput(activity);
    }

    public final void hideSoftInput(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        KeyboardUtils.hideSoftInput(activity);
    }

    public final void showSoftInput(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        KeyboardUtils.showSoftInput(activity);
    }

    public final void openKeyboard(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        KeyboardUtils.showSoftInput(editText);
    }

    public final void closeKeyboard(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        KeyboardUtils.hideSoftInput(editText);
    }

    public final void showSoftKeyboard(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).toggleSoftInput(0, 2);
    }
}
