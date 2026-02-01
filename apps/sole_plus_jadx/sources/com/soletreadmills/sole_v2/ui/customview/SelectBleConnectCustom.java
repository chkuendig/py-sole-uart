package com.soletreadmills.sole_v2.ui.customview;

import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.databinding.CustomSelectBleConnectBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectBleConnectCustom.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/SelectBleConnectCustom;", "Lcom/soletreadmills/sole_v2/ui/customview/BaseRelativeLayout;", "mainActivity", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "(Lcom/soletreadmills/sole_v2/ui/MainActivity;Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;)V", "binding", "Lcom/soletreadmills/sole_v2/databinding/CustomSelectBleConnectBinding;", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/CustomSelectBleConnectBinding;", "getListener", "()Lcom/soletreadmills/sole_v2/listener/OnItemClickListener;", "onBackPressed", "", SdkConstants.ATTR_ON_CLICK, "", "v", "Landroid/view/View;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectBleConnectCustom extends BaseRelativeLayout {
    public static final int $stable = 8;
    private final CustomSelectBleConnectBinding binding;
    private final OnItemClickListener listener;

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout
    public boolean onBackPressed() {
        return false;
    }

    public final OnItemClickListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectBleConnectCustom(MainActivity mainActivity, OnItemClickListener listener) {
        super(mainActivity, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(mainActivity, "mainActivity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(mainActivity), R.layout.custom_select_ble_connect, this, true);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        CustomSelectBleConnectBinding customSelectBleConnectBinding = (CustomSelectBleConnectBinding) viewDataBindingInflate;
        this.binding = customSelectBleConnectBinding;
        SelectBleConnectCustom selectBleConnectCustom = this;
        customSelectBleConnectBinding.close.setOnClickListener(selectBleConnectCustom);
        customSelectBleConnectBinding.LLBle.setOnClickListener(selectBleConnectCustom);
        customSelectBleConnectBinding.LLCloud.setOnClickListener(selectBleConnectCustom);
    }

    public final CustomSelectBleConnectBinding getBinding() {
        return this.binding;
    }

    @Override // com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout, android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 == R.id.close) {
            getMainActivity().onBackPressed();
            return;
        }
        if (id2 == R.id.LL_cloud) {
            this.listener.onClick(0);
            getMainActivity().onBackPressed();
        } else if (id2 == R.id.LL_ble) {
            this.listener.onClick(1);
            getMainActivity().onBackPressed();
        }
    }
}
