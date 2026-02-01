package com.soletreadmills.sole_v2.ui.pair;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.SdkConstants;
import com.google.gson.Gson;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._type.BleMachineImageType;
import com.soletreadmills.sole_v2._type.MachineType;
import com.soletreadmills.sole_v2.databinding.FragmentPairDevicePageItemBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: PairDevicePageItemFragment.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/soletreadmills/sole_v2/ui/pair/PairDevicePageItemFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentPairDevicePageItemBinding;", "Landroid/view/View$OnClickListener;", "()V", "bleDeviceData", "Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "getBleDeviceData", "()Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "setBleDeviceData", "(Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;)V", "bleMachineImageType", "Lcom/soletreadmills/sole_v2/_type/BleMachineImageType;", "getBleMachineImageType", "()Lcom/soletreadmills/sole_v2/_type/BleMachineImageType;", "setBleMachineImageType", "(Lcom/soletreadmills/sole_v2/_type/BleMachineImageType;)V", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setView", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PairDevicePageItemFragment extends BaseFragment<FragmentPairDevicePageItemBinding> implements View.OnClickListener {
    public static final String KEY_JSON_STRING = "KEY_JSON_STRING";
    private BleDeviceInfoData bleDeviceData;
    private BleMachineImageType bleMachineImageType = BleMachineImageType.OTHER;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: PairDevicePageItemFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MachineType.values().length];
            try {
                iArr[MachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MachineType.ELLIPTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MachineType.BIKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MachineType.ROWER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MachineType.STEPPER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    public final BleDeviceInfoData getBleDeviceData() {
        return this.bleDeviceData;
    }

    public final void setBleDeviceData(BleDeviceInfoData bleDeviceInfoData) {
        this.bleDeviceData = bleDeviceInfoData;
    }

    public final BleMachineImageType getBleMachineImageType() {
        return this.bleMachineImageType;
    }

    public final void setBleMachineImageType(BleMachineImageType bleMachineImageType) {
        Intrinsics.checkNotNullParameter(bleMachineImageType, "<set-?>");
        this.bleMachineImageType = bleMachineImageType;
    }

    /* compiled from: PairDevicePageItemFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/pair/PairDevicePageItemFragment$Companion;", "", "()V", PairDevicePageItemFragment.KEY_JSON_STRING, "", "newInstance", "Lcom/soletreadmills/sole_v2/ui/pair/PairDevicePageItemFragment;", "deviceBleString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PairDevicePageItemFragment newInstance(String deviceBleString) {
            Intrinsics.checkNotNullParameter(deviceBleString, "deviceBleString");
            PairDevicePageItemFragment pairDevicePageItemFragment = new PairDevicePageItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PairDevicePageItemFragment.KEY_JSON_STRING, deviceBleString);
            pairDevicePageItemFragment.setArguments(bundle);
            return pairDevicePageItemFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        BleDeviceInfoData bleDeviceInfoData;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                bleDeviceInfoData = (BleDeviceInfoData) new Gson().fromJson(arguments.getString(KEY_JSON_STRING), BleDeviceInfoData.class);
            } catch (Exception e) {
                Timber.INSTANCE.e(e.getMessage(), new Object[0]);
                bleDeviceInfoData = null;
            }
            this.bleDeviceData = bleDeviceInfoData;
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentPairDevicePageItemBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentPairDevicePageItemBinding fragmentPairDevicePageItemBindingInflate = FragmentPairDevicePageItemBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentPairDevicePageItemBindingInflate, "inflate(...)");
        return fragmentPairDevicePageItemBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        setView();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setView() {
        /*
            r3 = this;
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            com.soletreadmills.sole_v2.databinding.FragmentPairDevicePageItemBinding r0 = (com.soletreadmills.sole_v2.databinding.FragmentPairDevicePageItemBinding) r0
            r1 = 0
            if (r0 == 0) goto Lc
            android.widget.TextView r0 = r0.name
            goto Ld
        Lc:
            r0 = r1
        Ld:
            if (r0 != 0) goto L10
            goto L2b
        L10:
            com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData r2 = r3.bleDeviceData
            if (r2 == 0) goto L25
            java.lang.String r2 = r2.getName()
            if (r2 == 0) goto L25
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r2 = kotlin.text.StringsKt.trim(r2)
            java.lang.String r2 = r2.toString()
            goto L26
        L25:
            r2 = r1
        L26:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L2b:
            com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData r0 = r3.bleDeviceData     // Catch: java.lang.IllegalArgumentException -> L49
            if (r0 == 0) goto L42
            java.lang.String r0 = r0.getName()     // Catch: java.lang.IllegalArgumentException -> L49
            if (r0 == 0) goto L42
            java.util.Locale r2 = java.util.Locale.ROOT     // Catch: java.lang.IllegalArgumentException -> L49
            java.lang.String r0 = r0.toUpperCase(r2)     // Catch: java.lang.IllegalArgumentException -> L49
            java.lang.String r2 = "toUpperCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch: java.lang.IllegalArgumentException -> L49
            if (r0 != 0) goto L44
        L42:
            java.lang.String r0 = ""
        L44:
            com.soletreadmills.sole_v2._type.BleMachineImageType r0 = com.soletreadmills.sole_v2._type.BleMachineImageType.valueOf(r0)     // Catch: java.lang.IllegalArgumentException -> L49
            goto L4a
        L49:
            r0 = r1
        L4a:
            if (r0 != 0) goto L4e
            com.soletreadmills.sole_v2._type.BleMachineImageType r0 = com.soletreadmills.sole_v2._type.BleMachineImageType.OTHER
        L4e:
            r3.bleMachineImageType = r0
            com.soletreadmills.sole_v2._type.BleMachineImageType r2 = com.soletreadmills.sole_v2._type.BleMachineImageType.OTHER
            if (r0 == r2) goto L6a
            androidx.viewbinding.ViewBinding r0 = r3.getBinding()
            com.soletreadmills.sole_v2.databinding.FragmentPairDevicePageItemBinding r0 = (com.soletreadmills.sole_v2.databinding.FragmentPairDevicePageItemBinding) r0
            if (r0 == 0) goto Laf
            android.widget.ImageView r0 = r0.img
            if (r0 == 0) goto Laf
            com.soletreadmills.sole_v2._type.BleMachineImageType r1 = r3.bleMachineImageType
            int r1 = r1.getImgId()
            r0.setImageResource(r1)
            goto Laf
        L6a:
            int r0 = com.soletreadmills.sole_v2.R.drawable.treadmill_series_other
            com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData r0 = r3.bleDeviceData
            if (r0 == 0) goto L74
            com.soletreadmills.sole_v2._type.MachineType r1 = r0.getMachineType()
        L74:
            if (r1 != 0) goto L78
            r0 = -1
            goto L80
        L78:
            int[] r0 = com.soletreadmills.sole_v2.ui.pair.PairDevicePageItemFragment.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r0 = r0[r1]
        L80:
            r1 = 1
            if (r0 == r1) goto L9e
            r1 = 2
            if (r0 == r1) goto L9b
            r1 = 3
            if (r0 == r1) goto L98
            r1 = 4
            if (r0 == r1) goto L95
            r1 = 5
            if (r0 == r1) goto L92
            int r0 = com.soletreadmills.sole_v2.R.drawable.treadmill_series_other
            goto La0
        L92:
            int r0 = com.soletreadmills.sole_v2.R.drawable.stepper_series_other
            goto La0
        L95:
            int r0 = com.soletreadmills.sole_v2.R.drawable.rower_series_other
            goto La0
        L98:
            int r0 = com.soletreadmills.sole_v2.R.drawable.bikeseries_other
            goto La0
        L9b:
            int r0 = com.soletreadmills.sole_v2.R.drawable.elliptical_series_other
            goto La0
        L9e:
            int r0 = com.soletreadmills.sole_v2.R.drawable.treadmill_series_other
        La0:
            androidx.viewbinding.ViewBinding r1 = r3.getBinding()
            com.soletreadmills.sole_v2.databinding.FragmentPairDevicePageItemBinding r1 = (com.soletreadmills.sole_v2.databinding.FragmentPairDevicePageItemBinding) r1
            if (r1 == 0) goto Laf
            android.widget.ImageView r1 = r1.img
            if (r1 == 0) goto Laf
            r1.setImageResource(r0)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.pair.PairDevicePageItemFragment.setView():void");
    }
}
