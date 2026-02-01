package com.soletreadmills.sole_v2.ui.displayMode;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2.databinding.FragmentDisplaySettingsBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplaySettingsFragment.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/displayMode/DisplaySettingsFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentDisplaySettingsBinding;", "Landroid/view/View$OnClickListener;", "()V", "iosOnePickerBottomSheetDialog", "Lcom/soletreadmills/sole_v2/ui/_shared/IosOnePickerBottomSheetDialog;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "setView", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplaySettingsFragment extends BaseFragment<FragmentDisplaySettingsBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog;

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentDisplaySettingsBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentDisplaySettingsBinding fragmentDisplaySettingsBindingInflate = FragmentDisplaySettingsBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentDisplaySettingsBindingInflate, "inflate(...)");
        return fragmentDisplaySettingsBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        Switch r0;
        LinearLayout linearLayout;
        TextView textView;
        FragmentDisplaySettingsBinding binding = getBinding();
        if (binding != null && (textView = binding.done) != null) {
            textView.setOnClickListener(this);
        }
        FragmentDisplaySettingsBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout = binding2.LLRotateEvery) != null) {
            linearLayout.setOnClickListener(this);
        }
        FragmentDisplaySettingsBinding binding3 = getBinding();
        if (binding3 != null && (r0 = binding3.switchAutomatically) != null) {
            r0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplaySettingsFragment$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    DisplaySettingsFragment.initViews$lambda$0(this.f$0, compoundButton, z);
                }
            });
        }
        setView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(DisplaySettingsFragment this$0, CompoundButton compoundButton, boolean z) {
        String userUuid;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentDisplaySettingsBinding binding = this$0.getBinding();
        Switch r0 = binding != null ? binding.switchAutomatically : null;
        if (r0 != null) {
            r0.setChecked(z);
        }
        MySharedPreferences companion = MySharedPreferences.INSTANCE.getInstance();
        LoginUserData loginUserData = Global.userData;
        if (loginUserData == null || (userUuid = loginUserData.getUserUuid()) == null) {
            userUuid = "";
        }
        companion.setRotateAutomatically(userUuid, z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        MainActivity mainActivity;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.done;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.LL_rotateEvery;
        if (numValueOf == null || numValueOf.intValue() != i2 || (mainActivity = getMainActivity()) == null) {
            return;
        }
        IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog = this.iosOnePickerBottomSheetDialog;
        if (iosOnePickerBottomSheetDialog != null) {
            iosOnePickerBottomSheetDialog.dismiss();
        }
        final ArrayList arrayList = new ArrayList();
        for (int i3 = 5; i3 < 61; i3++) {
            arrayList.add(String.valueOf(i3));
        }
        IosOnePickerBottomSheetDialog.Listener listener = new IosOnePickerBottomSheetDialog.Listener() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplaySettingsFragment$onClick$1$1
            @Override // com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog.Listener
            public void onApply(IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog2) {
                String userUuid;
                Intrinsics.checkNotNullParameter(iosOnePickerBottomSheetDialog2, "iosOnePickerBottomSheetDialog");
                String str = arrayList.get(iosOnePickerBottomSheetDialog2.getBinding().loop.getSelectedItem());
                FragmentDisplaySettingsBinding binding = this.getBinding();
                TextView textView = binding != null ? binding.tvRotateEvery : null;
                if (textView != null) {
                    textView.setText(str + ' ' + this.getString(R.string.sec));
                }
                MySharedPreferences companion = MySharedPreferences.INSTANCE.getInstance();
                LoginUserData loginUserData = Global.userData;
                if (loginUserData == null || (userUuid = loginUserData.getUserUuid()) == null) {
                    userUuid = "";
                }
                companion.setRotateEvery(userUuid, Long.parseLong(str));
            }
        };
        String string = getString(R.string.rotate_every);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog2 = new IosOnePickerBottomSheetDialog(mainActivity, arrayList, 0, listener, string, true);
        this.iosOnePickerBottomSheetDialog = iosOnePickerBottomSheetDialog2;
        iosOnePickerBottomSheetDialog2.show();
    }

    public final void setView() {
        String userUuid;
        LoginUserData loginUserData = Global.userData;
        if (loginUserData == null || (userUuid = loginUserData.getUserUuid()) == null) {
            return;
        }
        boolean rotateAutomatically = MySharedPreferences.INSTANCE.getInstance().getRotateAutomatically(userUuid);
        long rotateEvery = MySharedPreferences.INSTANCE.getInstance().getRotateEvery(userUuid);
        FragmentDisplaySettingsBinding binding = getBinding();
        Switch r0 = binding != null ? binding.switchAutomatically : null;
        if (r0 != null) {
            r0.setChecked(rotateAutomatically);
        }
        FragmentDisplaySettingsBinding binding2 = getBinding();
        TextView textView = binding2 != null ? binding2.tvRotateEvery : null;
        if (textView == null) {
            return;
        }
        textView.setText(rotateEvery + ' ' + getString(R.string.sec));
    }
}
