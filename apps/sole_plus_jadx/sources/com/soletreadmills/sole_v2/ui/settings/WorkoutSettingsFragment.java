package com.soletreadmills.sole_v2.ui.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2.databinding.FragmentWorkoutSettingsBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog;
import com.soletreadmills.sole_v2.ui.classes.VideoSettingsViewModel;
import com.soletreadmills.sole_v2.ui.customview.SelectLanguageCustom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* compiled from: WorkoutSettingsFragment.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/WorkoutSettingsFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentWorkoutSettingsBinding;", "Landroid/view/View$OnClickListener;", "()V", "iosOnePickerBottomSheetDialog", "Lcom/soletreadmills/sole_v2/ui/_shared/IosOnePickerBottomSheetDialog;", "viewModel", "Lcom/soletreadmills/sole_v2/ui/classes/VideoSettingsViewModel;", "getViewModel", "()Lcom/soletreadmills/sole_v2/ui/classes/VideoSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "setView", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WorkoutSettingsFragment extends BaseFragment<FragmentWorkoutSettingsBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WorkoutSettingsFragment() {
        final WorkoutSettingsFragment workoutSettingsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.soletreadmills.sole_v2.ui.settings.WorkoutSettingsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return workoutSettingsFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.soletreadmills.sole_v2.ui.settings.WorkoutSettingsFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function02 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(workoutSettingsFragment, Reflection.getOrCreateKotlinClass(VideoSettingsViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.settings.WorkoutSettingsFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.settings.WorkoutSettingsFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function03 = function02;
                if (function03 != null && (creationExtras = (CreationExtras) function03.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM7569viewModels$lambda1 = FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM7569viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM7569viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.settings.WorkoutSettingsFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM7569viewModels$lambda1 = FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM7569viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM7569viewModels$lambda1 : null;
                if (hasDefaultViewModelProviderFactory != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) != null) {
                    return defaultViewModelProviderFactory;
                }
                ViewModelProvider.Factory defaultViewModelProviderFactory2 = workoutSettingsFragment.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory2;
            }
        });
    }

    public static final /* synthetic */ FragmentWorkoutSettingsBinding access$getBinding(WorkoutSettingsFragment workoutSettingsFragment) {
        return workoutSettingsFragment.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoSettingsViewModel getViewModel() {
        return (VideoSettingsViewModel) this.viewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentWorkoutSettingsBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentWorkoutSettingsBinding fragmentWorkoutSettingsBindingInflate = FragmentWorkoutSettingsBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentWorkoutSettingsBindingInflate, "inflate(...)");
        return fragmentWorkoutSettingsBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        Switch r0;
        Switch r02;
        SeekBar seekBar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        TextView textView;
        FragmentWorkoutSettingsBinding binding = getBinding();
        if (binding != null && (textView = binding.done) != null) {
            textView.setOnClickListener(this);
        }
        FragmentWorkoutSettingsBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout5 = binding2.LLTargetTime) != null) {
            linearLayout5.setOnClickListener(this);
        }
        FragmentWorkoutSettingsBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout4 = binding3.LLMaxSpeed) != null) {
            linearLayout4.setOnClickListener(this);
        }
        FragmentWorkoutSettingsBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout3 = binding4.LLMaxResistance) != null) {
            linearLayout3.setOnClickListener(this);
        }
        FragmentWorkoutSettingsBinding binding5 = getBinding();
        if (binding5 != null && (linearLayout2 = binding5.LLRotateEvery) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentWorkoutSettingsBinding binding6 = getBinding();
        if (binding6 != null && (linearLayout = binding6.LLLanguage) != null) {
            linearLayout.setOnClickListener(this);
        }
        FragmentWorkoutSettingsBinding binding7 = getBinding();
        if (binding7 != null && (seekBar = binding7.seekBar) != null) {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.soletreadmills.sole_v2.ui.settings.WorkoutSettingsFragment.initViews.1
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar2) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar2) {
                    Number numberValueOf = seekBar2 != null ? Integer.valueOf(seekBar2.getProgress()) : Float.valueOf(0.0f);
                    FragmentWorkoutSettingsBinding fragmentWorkoutSettingsBindingAccess$getBinding = WorkoutSettingsFragment.access$getBinding(WorkoutSettingsFragment.this);
                    TextView textView2 = fragmentWorkoutSettingsBindingAccess$getBinding != null ? fragmentWorkoutSettingsBindingAccess$getBinding.volumeValue : null;
                    if (textView2 != null) {
                        textView2.setText(numberValueOf.intValue() + " %");
                    }
                    Number number = numberValueOf;
                    Timber.INSTANCE.e("value:%s", Float.valueOf(number.floatValue() / 100.0f));
                    MySharedPreferences.INSTANCE.getInstance().setMusicVolume(number.floatValue() / 100.0f);
                }
            });
        }
        FragmentWorkoutSettingsBinding binding8 = getBinding();
        if (binding8 != null && (r02 = binding8.switchAutomatically) != null) {
            r02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soletreadmills.sole_v2.ui.settings.WorkoutSettingsFragment$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    WorkoutSettingsFragment.initViews$lambda$0(this.f$0, compoundButton, z);
                }
            });
        }
        FragmentWorkoutSettingsBinding binding9 = getBinding();
        if (binding9 != null && (r0 = binding9.switchShowSubtitles) != null) {
            r0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soletreadmills.sole_v2.ui.settings.WorkoutSettingsFragment$$ExternalSyntheticLambda1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    WorkoutSettingsFragment.initViews$lambda$1(this.f$0, compoundButton, z);
                }
            });
        }
        setView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(WorkoutSettingsFragment this$0, CompoundButton compoundButton, boolean z) {
        String userUuid;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentWorkoutSettingsBinding binding = this$0.getBinding();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(WorkoutSettingsFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentWorkoutSettingsBinding binding = this$0.getBinding();
        Switch r0 = binding != null ? binding.switchShowSubtitles : null;
        if (r0 != null) {
            r0.setChecked(z);
        }
        MySharedPreferences.INSTANCE.getInstance().setShowSubtitles(z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        String userUuid;
        MainActivity mainActivity;
        int iCoerceAtLeast;
        String str;
        LoginUserData loginUserData = Global.userData;
        if (loginUserData == null || (userUuid = loginUserData.getUserUuid()) == null) {
            return;
        }
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.done;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.LL_targetTime;
        int i3 = 5;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            MainActivity mainActivity2 = getMainActivity();
            if (mainActivity2 != null) {
                IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog = this.iosOnePickerBottomSheetDialog;
                if (iosOnePickerBottomSheetDialog != null) {
                    iosOnePickerBottomSheetDialog.dismiss();
                }
                final ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                long targetTime = MySharedPreferences.INSTANCE.getInstance().getTargetTime(userUuid);
                while (i3 < 100) {
                    arrayList2.add(Integer.valueOf(i3 * 60));
                    if (i3 >= 60) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        str = String.format(Locale.US, "%d:%02d:00", Arrays.copyOf(new Object[]{Integer.valueOf(i3 / 60), Integer.valueOf(i3 % 60)}, 2));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    } else {
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        str = String.format(Locale.US, "%d:00", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    }
                    arrayList.add(str);
                    i3++;
                }
                int iCoerceAtLeast2 = RangesKt.coerceAtLeast(arrayList2.indexOf(Integer.valueOf((int) targetTime)), 0);
                IosOnePickerBottomSheetDialog.Listener listener = new IosOnePickerBottomSheetDialog.Listener() { // from class: com.soletreadmills.sole_v2.ui.settings.WorkoutSettingsFragment$onClick$1$1
                    @Override // com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog.Listener
                    public void onApply(IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog2) {
                        String userUuid2;
                        Intrinsics.checkNotNullParameter(iosOnePickerBottomSheetDialog2, "iosOnePickerBottomSheetDialog");
                        int selectedItem = iosOnePickerBottomSheetDialog2.getBinding().loop.getSelectedItem();
                        String str2 = arrayList.get(selectedItem);
                        int iIntValue = arrayList2.get(selectedItem).intValue();
                        FragmentWorkoutSettingsBinding fragmentWorkoutSettingsBindingAccess$getBinding = WorkoutSettingsFragment.access$getBinding(this);
                        TextView textView = fragmentWorkoutSettingsBindingAccess$getBinding != null ? fragmentWorkoutSettingsBindingAccess$getBinding.tvTargetTime : null;
                        if (textView != null) {
                            textView.setText(String.valueOf(str2));
                        }
                        MySharedPreferences companion = MySharedPreferences.INSTANCE.getInstance();
                        LoginUserData loginUserData2 = Global.userData;
                        if (loginUserData2 == null || (userUuid2 = loginUserData2.getUserUuid()) == null) {
                            userUuid2 = "";
                        }
                        companion.setTargetTime(userUuid2, iIntValue);
                    }
                };
                String string = getString(R.string.target_time);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog2 = new IosOnePickerBottomSheetDialog(mainActivity2, arrayList, iCoerceAtLeast2, listener, string, true);
                this.iosOnePickerBottomSheetDialog = iosOnePickerBottomSheetDialog2;
                iosOnePickerBottomSheetDialog2.show();
                return;
            }
            return;
        }
        int i4 = R.id.LL_maxSpeed;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            MainActivity mainActivity3 = getMainActivity();
            if (mainActivity3 != null) {
                final boolean unitType = Global.INSTANCE.getUnitType();
                IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog3 = this.iosOnePickerBottomSheetDialog;
                if (iosOnePickerBottomSheetDialog3 != null) {
                    iosOnePickerBottomSheetDialog3.dismiss();
                }
                final ArrayList arrayList3 = new ArrayList();
                if (unitType) {
                    float maxSpeedImperial = MySharedPreferences.INSTANCE.getInstance().getMaxSpeedImperial(userUuid);
                    for (float f = 3.0f; f <= 12.0f; f += 0.1f) {
                        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                        String str2 = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        arrayList3.add(str2);
                    }
                    iCoerceAtLeast = RangesKt.coerceAtLeast(arrayList3.indexOf(String.valueOf(maxSpeedImperial)), 0);
                } else {
                    float maxSpeedMetric = MySharedPreferences.INSTANCE.getInstance().getMaxSpeedMetric(userUuid);
                    for (float f2 = 5.0f; f2 <= 20.0f; f2 += 0.1f) {
                        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                        String str3 = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f2)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        arrayList3.add(str3);
                    }
                    iCoerceAtLeast = RangesKt.coerceAtLeast(arrayList3.indexOf(String.valueOf(maxSpeedMetric)), 0);
                }
                IosOnePickerBottomSheetDialog.Listener listener2 = new IosOnePickerBottomSheetDialog.Listener() { // from class: com.soletreadmills.sole_v2.ui.settings.WorkoutSettingsFragment$onClick$2$1
                    @Override // com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog.Listener
                    public void onApply(IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog4) {
                        String string2;
                        String userUuid2;
                        String userUuid3;
                        Intrinsics.checkNotNullParameter(iosOnePickerBottomSheetDialog4, "iosOnePickerBottomSheetDialog");
                        String str4 = arrayList3.get(iosOnePickerBottomSheetDialog4.getBinding().loop.getSelectedItem());
                        Intrinsics.checkNotNullExpressionValue(this.getString(R.string.mph), "getString(...)");
                        String str5 = "";
                        if (unitType) {
                            string2 = this.getString(R.string.mph);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            MySharedPreferences companion = MySharedPreferences.INSTANCE.getInstance();
                            LoginUserData loginUserData2 = Global.userData;
                            if (loginUserData2 != null && (userUuid3 = loginUserData2.getUserUuid()) != null) {
                                str5 = userUuid3;
                            }
                            companion.setMaxSpeedImperial(str5, Float.parseFloat(str4));
                        } else {
                            string2 = this.getString(R.string.km_h);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            MySharedPreferences companion2 = MySharedPreferences.INSTANCE.getInstance();
                            LoginUserData loginUserData3 = Global.userData;
                            if (loginUserData3 != null && (userUuid2 = loginUserData3.getUserUuid()) != null) {
                                str5 = userUuid2;
                            }
                            companion2.setMaxSpeedMetric(str5, Float.parseFloat(str4));
                        }
                        FragmentWorkoutSettingsBinding fragmentWorkoutSettingsBindingAccess$getBinding = WorkoutSettingsFragment.access$getBinding(this);
                        TextView textView = fragmentWorkoutSettingsBindingAccess$getBinding != null ? fragmentWorkoutSettingsBindingAccess$getBinding.tvMaxSpeed : null;
                        if (textView == null) {
                            return;
                        }
                        textView.setText(str4 + ' ' + string2);
                    }
                };
                String string2 = getString(R.string.max_speed);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog4 = new IosOnePickerBottomSheetDialog(mainActivity3, arrayList3, iCoerceAtLeast, listener2, string2, true);
                this.iosOnePickerBottomSheetDialog = iosOnePickerBottomSheetDialog4;
                iosOnePickerBottomSheetDialog4.show();
                return;
            }
            return;
        }
        int i5 = R.id.LL_maxResistance;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            MainActivity mainActivity4 = getMainActivity();
            if (mainActivity4 != null) {
                IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog5 = this.iosOnePickerBottomSheetDialog;
                if (iosOnePickerBottomSheetDialog5 != null) {
                    iosOnePickerBottomSheetDialog5.dismiss();
                }
                final ArrayList arrayList4 = new ArrayList();
                int maxResistance = MySharedPreferences.INSTANCE.getInstance().getMaxResistance(userUuid);
                for (int i6 = 0; i6 < 21; i6++) {
                    arrayList4.add(String.valueOf(i6));
                }
                int iCoerceAtLeast3 = RangesKt.coerceAtLeast(arrayList4.indexOf(String.valueOf(maxResistance)), 0);
                IosOnePickerBottomSheetDialog.Listener listener3 = new IosOnePickerBottomSheetDialog.Listener() { // from class: com.soletreadmills.sole_v2.ui.settings.WorkoutSettingsFragment$onClick$3$1
                    @Override // com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog.Listener
                    public void onApply(IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog6) {
                        String userUuid2;
                        Intrinsics.checkNotNullParameter(iosOnePickerBottomSheetDialog6, "iosOnePickerBottomSheetDialog");
                        String str4 = arrayList4.get(iosOnePickerBottomSheetDialog6.getBinding().loop.getSelectedItem());
                        FragmentWorkoutSettingsBinding fragmentWorkoutSettingsBindingAccess$getBinding = WorkoutSettingsFragment.access$getBinding(this);
                        TextView textView = fragmentWorkoutSettingsBindingAccess$getBinding != null ? fragmentWorkoutSettingsBindingAccess$getBinding.tvMaxResistance : null;
                        if (textView != null) {
                            textView.setText(str4);
                        }
                        MySharedPreferences companion = MySharedPreferences.INSTANCE.getInstance();
                        LoginUserData loginUserData2 = Global.userData;
                        if (loginUserData2 == null || (userUuid2 = loginUserData2.getUserUuid()) == null) {
                            userUuid2 = "";
                        }
                        companion.setMaxResistance(userUuid2, Integer.parseInt(str4));
                    }
                };
                String string3 = getString(R.string.max_resistance);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog6 = new IosOnePickerBottomSheetDialog(mainActivity4, arrayList4, iCoerceAtLeast3, listener3, string3, true);
                this.iosOnePickerBottomSheetDialog = iosOnePickerBottomSheetDialog6;
                iosOnePickerBottomSheetDialog6.show();
                return;
            }
            return;
        }
        int i7 = R.id.LL_rotateEvery;
        if (numValueOf != null && numValueOf.intValue() == i7) {
            MainActivity mainActivity5 = getMainActivity();
            if (mainActivity5 != null) {
                IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog7 = this.iosOnePickerBottomSheetDialog;
                if (iosOnePickerBottomSheetDialog7 != null) {
                    iosOnePickerBottomSheetDialog7.dismiss();
                }
                final ArrayList arrayList5 = new ArrayList();
                long rotateEvery = MySharedPreferences.INSTANCE.getInstance().getRotateEvery(userUuid);
                while (i3 < 61) {
                    arrayList5.add(String.valueOf(i3));
                    i3++;
                }
                int iCoerceAtLeast4 = RangesKt.coerceAtLeast(arrayList5.indexOf(String.valueOf(rotateEvery)), 0);
                IosOnePickerBottomSheetDialog.Listener listener4 = new IosOnePickerBottomSheetDialog.Listener() { // from class: com.soletreadmills.sole_v2.ui.settings.WorkoutSettingsFragment$onClick$4$1
                    @Override // com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog.Listener
                    public void onApply(IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog8) {
                        String userUuid2;
                        Intrinsics.checkNotNullParameter(iosOnePickerBottomSheetDialog8, "iosOnePickerBottomSheetDialog");
                        String str4 = arrayList5.get(iosOnePickerBottomSheetDialog8.getBinding().loop.getSelectedItem());
                        FragmentWorkoutSettingsBinding fragmentWorkoutSettingsBindingAccess$getBinding = WorkoutSettingsFragment.access$getBinding(this);
                        TextView textView = fragmentWorkoutSettingsBindingAccess$getBinding != null ? fragmentWorkoutSettingsBindingAccess$getBinding.tvRotateEvery : null;
                        if (textView != null) {
                            textView.setText(str4 + ' ' + this.getString(R.string.sec));
                        }
                        MySharedPreferences companion = MySharedPreferences.INSTANCE.getInstance();
                        LoginUserData loginUserData2 = Global.userData;
                        if (loginUserData2 == null || (userUuid2 = loginUserData2.getUserUuid()) == null) {
                            userUuid2 = "";
                        }
                        companion.setRotateEvery(userUuid2, Long.parseLong(str4));
                    }
                };
                String string4 = getString(R.string.rotate_every);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog8 = new IosOnePickerBottomSheetDialog(mainActivity5, arrayList5, iCoerceAtLeast4, listener4, string4, true);
                this.iosOnePickerBottomSheetDialog = iosOnePickerBottomSheetDialog8;
                iosOnePickerBottomSheetDialog8.show();
                return;
            }
            return;
        }
        int i8 = R.id.LL_language;
        if (numValueOf == null || numValueOf.intValue() != i8 || (mainActivity = getMainActivity()) == null) {
            return;
        }
        mainActivity.getChangeViewManager().changePage(new SelectLanguageCustom(mainActivity, getViewModel().getDefaultLocale(), new SelectLanguageCustom.SelectLanguageListener() { // from class: com.soletreadmills.sole_v2.ui.settings.WorkoutSettingsFragment$onClick$5$1
            @Override // com.soletreadmills.sole_v2.ui.customview.SelectLanguageCustom.SelectLanguageListener
            public void onClick(Locale selectLocale) {
                Intrinsics.checkNotNullParameter(selectLocale, "selectLocale");
                this.this$0.getViewModel().updateSubtitleLanguage(selectLocale);
                FragmentWorkoutSettingsBinding fragmentWorkoutSettingsBindingAccess$getBinding = WorkoutSettingsFragment.access$getBinding(this.this$0);
                TextView textView = fragmentWorkoutSettingsBindingAccess$getBinding != null ? fragmentWorkoutSettingsBindingAccess$getBinding.language : null;
                if (textView != null) {
                    textView.setText(this.this$0.getViewModel().getLanguage());
                }
                MainActivity mainActivity6 = this.this$0.getMainActivity();
                if (mainActivity6 != null) {
                    mainActivity6.onBackPressed();
                }
            }
        }));
    }

    public final void setView() {
        String userUuid;
        float maxSpeedMetric;
        String string;
        LoginUserData loginUserData = Global.userData;
        if (loginUserData == null || (userUuid = loginUserData.getUserUuid()) == null) {
            return;
        }
        boolean unitType = Global.INSTANCE.getUnitType();
        long targetTime = MySharedPreferences.INSTANCE.getInstance().getTargetTime(userUuid);
        if (unitType) {
            maxSpeedMetric = MySharedPreferences.INSTANCE.getInstance().getMaxSpeedImperial(userUuid);
        } else {
            maxSpeedMetric = MySharedPreferences.INSTANCE.getInstance().getMaxSpeedMetric(userUuid);
        }
        if (unitType) {
            string = getString(R.string.mph);
        } else {
            string = getString(R.string.km_h);
        }
        Intrinsics.checkNotNull(string);
        int maxResistance = MySharedPreferences.INSTANCE.getInstance().getMaxResistance(userUuid);
        boolean rotateAutomatically = MySharedPreferences.INSTANCE.getInstance().getRotateAutomatically(userUuid);
        long rotateEvery = MySharedPreferences.INSTANCE.getInstance().getRotateEvery(userUuid);
        boolean showSubtitles = MySharedPreferences.INSTANCE.getInstance().getShowSubtitles();
        int musicVolume = (int) (MySharedPreferences.INSTANCE.getInstance().getMusicVolume() * 100);
        FragmentWorkoutSettingsBinding binding = getBinding();
        TextView textView = binding != null ? binding.tvTargetTime : null;
        if (textView != null) {
            textView.setText(TimeTools.secToTime02$default(TimeTools.INSTANCE, targetTime, false, 2, null));
        }
        FragmentWorkoutSettingsBinding binding2 = getBinding();
        TextView textView2 = binding2 != null ? binding2.tvMaxSpeed : null;
        if (textView2 != null) {
            textView2.setText(maxSpeedMetric + ' ' + string);
        }
        FragmentWorkoutSettingsBinding binding3 = getBinding();
        TextView textView3 = binding3 != null ? binding3.tvMaxResistance : null;
        if (textView3 != null) {
            textView3.setText(String.valueOf(maxResistance));
        }
        FragmentWorkoutSettingsBinding binding4 = getBinding();
        Switch r2 = binding4 != null ? binding4.switchAutomatically : null;
        if (r2 != null) {
            r2.setChecked(rotateAutomatically);
        }
        FragmentWorkoutSettingsBinding binding5 = getBinding();
        TextView textView4 = binding5 != null ? binding5.tvRotateEvery : null;
        if (textView4 != null) {
            textView4.setText(rotateEvery + ' ' + getString(R.string.sec));
        }
        FragmentWorkoutSettingsBinding binding6 = getBinding();
        Switch r22 = binding6 != null ? binding6.switchShowSubtitles : null;
        if (r22 != null) {
            r22.setChecked(showSubtitles);
        }
        FragmentWorkoutSettingsBinding binding7 = getBinding();
        TextView textView5 = binding7 != null ? binding7.language : null;
        if (textView5 != null) {
            textView5.setText(getViewModel().getLanguage());
        }
        FragmentWorkoutSettingsBinding binding8 = getBinding();
        TextView textView6 = binding8 != null ? binding8.volumeValue : null;
        if (textView6 != null) {
            textView6.setText(musicVolume + " %");
        }
        FragmentWorkoutSettingsBinding binding9 = getBinding();
        SeekBar seekBar = binding9 != null ? binding9.seekBar : null;
        if (seekBar == null) {
            return;
        }
        seekBar.setProgress(musicVolume);
    }
}
