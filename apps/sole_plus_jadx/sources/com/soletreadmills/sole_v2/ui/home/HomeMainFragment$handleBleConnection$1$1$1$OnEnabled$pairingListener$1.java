package com.soletreadmills.sole_v2.ui.home;

import android.app.AlertDialog;
import android.view.View;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.OnPairingDialogDismissListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeMainFragment.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/soletreadmills/sole_v2/ui/home/HomeMainFragment$handleBleConnection$1$1$1$OnEnabled$pairingListener$1", "Lcom/soletreadmills/sole_v2/ui/_base/OnPairingDialogDismissListener;", "onPairingDialogDismissed", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HomeMainFragment$handleBleConnection$1$1$1$OnEnabled$pairingListener$1 implements OnPairingDialogDismissListener {
    final /* synthetic */ BleDeviceInfoData $data;
    final /* synthetic */ HomeMainFragment this$0;

    HomeMainFragment$handleBleConnection$1$1$1$OnEnabled$pairingListener$1(HomeMainFragment homeMainFragment, BleDeviceInfoData bleDeviceInfoData) {
        this.this$0 = homeMainFragment;
        this.$data = bleDeviceInfoData;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.OnPairingDialogDismissListener
    public void onPairingDialogDismissed() {
        final boolean z = this.this$0.isUserClickConnectBtn;
        View view = this.this$0.getView();
        if (view != null) {
            final HomeMainFragment homeMainFragment = this.this$0;
            final BleDeviceInfoData bleDeviceInfoData = this.$data;
            view.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.home.HomeMainFragment$handleBleConnection$1$1$1$OnEnabled$pairingListener$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    HomeMainFragment$handleBleConnection$1$1$1$OnEnabled$pairingListener$1.onPairingDialogDismissed$lambda$0(z, homeMainFragment, bleDeviceInfoData, this);
                }
            });
        }
        this.this$0.isUserClickConnectBtn = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPairingDialogDismissed$lambda$0(boolean z, HomeMainFragment this$0, BleDeviceInfoData data, HomeMainFragment$handleBleConnection$1$1$1$OnEnabled$pairingListener$1 this$1) {
        AlertDialog pairingDialog;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        if (z) {
            MainActivity mainActivity = this$0.getMainActivity();
            if (mainActivity != null && (pairingDialog = mainActivity.getPairingDialog()) != null) {
                pairingDialog.dismiss();
            }
            this$0.showConnectionFailedDialog(data, this$1);
        }
    }
}
