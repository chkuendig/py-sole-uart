package com.soletreadmills.sole_v2._extension;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.soletreadmills.sole_v2.MyApplication;
import com.soletreadmills.sole_v2._tools.UiTool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentExtension.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"setStatusBarHeight", "", "Landroidx/fragment/app/Fragment;", "statusBarView", "Landroid/view/View;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FragmentExtensionKt {
    public static final void setStatusBarHeight(Fragment fragment, View statusBarView) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(statusBarView, "statusBarView");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = statusBarView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "getLayoutParams(...)");
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.soletreadmills.sole_v2.MyApplication");
        MyApplication myApplication = (MyApplication) applicationContext;
        Integer statusBarHeight = myApplication.getStatusBarHeight();
        int iIntValue = statusBarHeight != null ? statusBarHeight.intValue() : 0;
        int statusBarHeight2 = UiTool.getStatusBarHeight(activity);
        if (statusBarHeight2 > iIntValue) {
            iIntValue = statusBarHeight2;
        }
        myApplication.setStatusBarHeight(Integer.valueOf(iIntValue));
        layoutParams.height = iIntValue;
        statusBarView.requestLayout();
    }
}
