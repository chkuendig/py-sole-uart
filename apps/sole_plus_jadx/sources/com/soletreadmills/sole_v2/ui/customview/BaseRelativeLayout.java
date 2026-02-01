package com.soletreadmills.sole_v2.ui.customview;

import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.ui.MainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseRelativeLayout.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u000eH\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/BaseRelativeLayout;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "mainActivity", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Lcom/soletreadmills/sole_v2/ui/MainActivity;Landroid/util/AttributeSet;II)V", "getMainActivity", "()Lcom/soletreadmills/sole_v2/ui/MainActivity;", "onAttachedToWindow", "", "onBackPressed", "", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onDetachedFromWindow", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseRelativeLayout extends RelativeLayout implements View.OnClickListener {
    public static final int $stable = 8;
    private final MainActivity mainActivity;

    public abstract boolean onBackPressed();

    @Override // android.view.View.OnClickListener
    public abstract void onClick(View v);

    public /* synthetic */ BaseRelativeLayout(MainActivity mainActivity, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(mainActivity, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final MainActivity getMainActivity() {
        return this.mainActivity;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseRelativeLayout(MainActivity mainActivity, AttributeSet attributeSet, int i, int i2) {
        super(mainActivity, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(mainActivity, "mainActivity");
        this.mainActivity = mainActivity;
        setOnClickListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
