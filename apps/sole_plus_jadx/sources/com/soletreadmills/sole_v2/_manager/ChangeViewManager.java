package com.soletreadmills.sole_v2._manager;

import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.soletreadmills.sole_v2.databinding.ActivityMainBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChangeViewManager.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u0013J\u001a\u0010\u0015\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0004J\u001a\u0010\u001a\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018J\u001a\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018J\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/ChangeViewManager;", "", "()V", "childViewSize", "", "getChildViewSize", "()I", "<set-?>", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "mainActivity", "getMainActivity", "()Lcom/soletreadmills/sole_v2/ui/MainActivity;", "mainView", "Landroid/widget/RelativeLayout;", "Lcom/soletreadmills/sole_v2/ui/customview/BaseRelativeLayout;", "nowView", "getNowView", "()Lcom/soletreadmills/sole_v2/ui/customview/BaseRelativeLayout;", "changePage", "", "view", "closePage", ExifInterface.GPS_DIRECTION_TRUE, "classOfT", "Ljava/lang/Class;", "num", "findViewIndex", "isFindView", "", "setChangeViewManager", "activity", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChangeViewManager {
    private static ChangeViewManager instance;
    private MainActivity mainActivity;
    private RelativeLayout mainView;
    private BaseRelativeLayout nowView;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ ChangeViewManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ChangeViewManager() {
    }

    public final MainActivity getMainActivity() {
        return this.mainActivity;
    }

    public final BaseRelativeLayout getNowView() {
        return this.nowView;
    }

    public final int getChildViewSize() {
        RelativeLayout relativeLayout = this.mainView;
        Intrinsics.checkNotNull(relativeLayout);
        return relativeLayout.getChildCount();
    }

    /* compiled from: ChangeViewManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/ChangeViewManager$Companion;", "", "()V", "instance", "Lcom/soletreadmills/sole_v2/_manager/ChangeViewManager;", "getInstance", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final synchronized ChangeViewManager getInstance() {
            ChangeViewManager changeViewManager;
            if (ChangeViewManager.instance == null) {
                ChangeViewManager.instance = new ChangeViewManager(null);
            }
            changeViewManager = ChangeViewManager.instance;
            Intrinsics.checkNotNull(changeViewManager);
            return changeViewManager;
        }
    }

    public final void setChangeViewManager(MainActivity activity, RelativeLayout mainView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mainView, "mainView");
        this.mainActivity = activity;
        this.mainView = mainView;
    }

    public final void changePage(BaseRelativeLayout view) {
        ActivityMainBinding binding;
        Intrinsics.checkNotNullParameter(view, "view");
        this.nowView = view;
        RelativeLayout relativeLayout = this.mainView;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.addView(this.nowView);
        MainActivity mainActivity = this.mainActivity;
        RelativeLayout relativeLayout2 = (mainActivity == null || (binding = mainActivity.getBinding()) == null) ? null : binding.addViewLayout;
        if (relativeLayout2 == null) {
            return;
        }
        relativeLayout2.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void closePage() {
        /*
            r3 = this;
            android.widget.RelativeLayout r0 = r3.mainView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            android.widget.RelativeLayout r1 = r3.mainView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            android.widget.RelativeLayout r2 = r3.mainView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.getChildCount()
            int r2 = r2 + (-1)
            android.view.View r1 = r1.getChildAt(r2)
            r0.removeView(r1)
            android.widget.RelativeLayout r0 = r3.mainView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.getChildCount()
            int r0 = r0 + (-1)
            r1 = 0
            if (r0 < 0) goto L5e
            android.widget.RelativeLayout r0 = r3.mainView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            android.widget.RelativeLayout r2 = r3.mainView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.getChildCount()
            int r2 = r2 + (-1)
            android.view.View r0 = r0.getChildAt(r2)
            boolean r0 = r0 instanceof com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout
            if (r0 == 0) goto L5e
            android.widget.RelativeLayout r0 = r3.mainView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            android.widget.RelativeLayout r2 = r3.mainView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.getChildCount()
            int r2 = r2 + (-1)
            android.view.View r0 = r0.getChildAt(r2)
            java.lang.String r2 = "null cannot be cast to non-null type com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r2)
            com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout r0 = (com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout) r0
            goto L5f
        L5e:
            r0 = r1
        L5f:
            r3.nowView = r0
            if (r0 != 0) goto L77
            com.soletreadmills.sole_v2.ui.MainActivity r0 = r3.mainActivity
            if (r0 == 0) goto L6f
            com.soletreadmills.sole_v2.databinding.ActivityMainBinding r0 = r0.getBinding()
            if (r0 == 0) goto L6f
            android.widget.RelativeLayout r1 = r0.addViewLayout
        L6f:
            if (r1 != 0) goto L72
            goto L77
        L72:
            r0 = 8
            r1.setVisibility(r0)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._manager.ChangeViewManager.closePage():void");
    }

    public final void closePage(int num) {
        for (int i = 0; i < num; i++) {
            closePage();
        }
    }

    public final <T> void closePage(Class<T> classOfT) {
        Intrinsics.checkNotNullParameter(classOfT, "classOfT");
        if (isFindView(classOfT)) {
            closePage((getChildViewSize() - 1) - findViewIndex(classOfT));
        }
    }

    public final <T> int findViewIndex(Class<T> classOfT) {
        Intrinsics.checkNotNullParameter(classOfT, "classOfT");
        RelativeLayout relativeLayout = this.mainView;
        Intrinsics.checkNotNull(relativeLayout);
        int childCount = relativeLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RelativeLayout relativeLayout2 = this.mainView;
            Intrinsics.checkNotNull(relativeLayout2);
            if (classOfT.isInstance(relativeLayout2.getChildAt(i))) {
                return i;
            }
        }
        return 0;
    }

    public final <T> boolean isFindView(Class<T> classOfT) {
        Intrinsics.checkNotNullParameter(classOfT, "classOfT");
        RelativeLayout relativeLayout = this.mainView;
        Intrinsics.checkNotNull(relativeLayout);
        if (relativeLayout.getChildCount() <= 0) {
            return false;
        }
        RelativeLayout relativeLayout2 = this.mainView;
        Intrinsics.checkNotNull(relativeLayout2);
        int childCount = relativeLayout2.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RelativeLayout relativeLayout3 = this.mainView;
            Intrinsics.checkNotNull(relativeLayout3);
            if (classOfT.isInstance(relativeLayout3.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }
}
