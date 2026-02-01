package com.soletreadmills.sole_v2.ui.customview;

import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.databinding.CustomBottomDialogBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomDialogCustom.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/BottomDialogCustom;", "Lcom/soletreadmills/sole_v2/ui/customview/BaseRelativeLayout;", "mainActivity", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "title", "", "msg", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/ui/customview/BottomDialogCustom$BottomDialogCustomListener;", "email", "doneText", "(Lcom/soletreadmills/sole_v2/ui/MainActivity;Ljava/lang/String;Ljava/lang/String;Lcom/soletreadmills/sole_v2/ui/customview/BottomDialogCustom$BottomDialogCustomListener;Ljava/lang/String;Ljava/lang/String;)V", "binding", "Lcom/soletreadmills/sole_v2/databinding/CustomBottomDialogBinding;", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/CustomBottomDialogBinding;", "getListener", "()Lcom/soletreadmills/sole_v2/ui/customview/BottomDialogCustom$BottomDialogCustomListener;", "onBackPressed", "", SdkConstants.ATTR_ON_CLICK, "", "v", "Landroid/view/View;", "BottomDialogCustomListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomDialogCustom extends BaseRelativeLayout {
    public static final int $stable = 8;
    private final CustomBottomDialogBinding binding;
    private final BottomDialogCustomListener listener;

    /* compiled from: BottomDialogCustom.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/BottomDialogCustom$BottomDialogCustomListener;", "", SdkConstants.ATTR_ON_CLICK, "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface BottomDialogCustomListener {
        void onClick();
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout
    public boolean onBackPressed() {
        return false;
    }

    public /* synthetic */ BottomDialogCustom(MainActivity mainActivity, String str, String str2, BottomDialogCustomListener bottomDialogCustomListener, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mainActivity, str, str2, bottomDialogCustomListener, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
    }

    public final BottomDialogCustomListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomDialogCustom(MainActivity mainActivity, String title, String msg, BottomDialogCustomListener listener, String str, String str2) {
        super(mainActivity, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(mainActivity, "mainActivity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(mainActivity), R.layout.custom_bottom_dialog, this, true);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        CustomBottomDialogBinding customBottomDialogBinding = (CustomBottomDialogBinding) viewDataBindingInflate;
        this.binding = customBottomDialogBinding;
        BottomDialogCustom bottomDialogCustom = this;
        customBottomDialogBinding.close.setOnClickListener(bottomDialogCustom);
        customBottomDialogBinding.LLDone.setOnClickListener(bottomDialogCustom);
        customBottomDialogBinding.title.setText(title);
        customBottomDialogBinding.msg.setText(msg);
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            customBottomDialogBinding.email.setVisibility(8);
        } else {
            customBottomDialogBinding.email.setText(str3);
            customBottomDialogBinding.email.setVisibility(0);
        }
        String str4 = str2;
        if (str4 == null || str4.length() == 0) {
            return;
        }
        customBottomDialogBinding.done.setText(str4);
    }

    public final CustomBottomDialogBinding getBinding() {
        return this.binding;
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout, android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 == R.id.close) {
            getMainActivity().onBackPressed();
        } else if (id2 == R.id.LL_done) {
            this.listener.onClick();
        }
    }
}
