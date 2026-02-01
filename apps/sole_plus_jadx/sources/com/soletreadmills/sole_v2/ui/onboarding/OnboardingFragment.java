package com.soletreadmills.sole_v2.ui.onboarding;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.settings.UpdateMeasurementUnitApiData;
import com.soletreadmills.sole_v2._data.api.settings.UpdateMyUserInfoApiData;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2._type.user.GenderType;
import com.soletreadmills.sole_v2.databinding.FragmentOnboardingBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: OnboardingFragment.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/onboarding/OnboardingFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentOnboardingBinding;", "Landroid/view/View$OnClickListener;", "()V", "birthday", "", "height", "iosOnePickerBottomSheetDialog", "Lcom/soletreadmills/sole_v2/ui/_shared/IosOnePickerBottomSheetDialog;", "nowPage", "", "selectGender", "weight", "changeSelectGenderView", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "saveUserData", "setPageView", "showDatePicker", "showSelectHeightView", "updateMeasurementUnit", "units", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnboardingFragment extends BaseFragment<FragmentOnboardingBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private String birthday;
    private String height;
    private IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog;
    private int nowPage = 1;
    private String selectGender = GenderType.Male.getId();
    private String weight;

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentOnboardingBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentOnboardingBinding fragmentOnboardingBindingInflate = FragmentOnboardingBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentOnboardingBindingInflate, "inflate(...)");
        return fragmentOnboardingBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        EditText editText;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        FragmentOnboardingBinding binding = getBinding();
        if (binding != null && (textView7 = binding.tvNext) != null) {
            textView7.setOnClickListener(this);
        }
        FragmentOnboardingBinding binding2 = getBinding();
        if (binding2 != null && (textView6 = binding2.tvSkip) != null) {
            textView6.setOnClickListener(this);
        }
        FragmentOnboardingBinding binding3 = getBinding();
        if (binding3 != null && (textView5 = binding3.tvPairLater) != null) {
            textView5.setOnClickListener(this);
        }
        FragmentOnboardingBinding binding4 = getBinding();
        if (binding4 != null && (textView4 = binding4.tvNext) != null) {
            textView4.setOnClickListener(this);
        }
        FragmentOnboardingBinding binding5 = getBinding();
        if (binding5 != null && (textView3 = binding5.male) != null) {
            textView3.setOnClickListener(this);
        }
        FragmentOnboardingBinding binding6 = getBinding();
        if (binding6 != null && (textView2 = binding6.female) != null) {
            textView2.setOnClickListener(this);
        }
        FragmentOnboardingBinding binding7 = getBinding();
        if (binding7 != null && (textView = binding7.birthday) != null) {
            textView.setOnClickListener(this);
        }
        FragmentOnboardingBinding binding8 = getBinding();
        if (binding8 != null && (linearLayout2 = binding8.llPairViaCloud) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentOnboardingBinding binding9 = getBinding();
        if (binding9 != null && (linearLayout = binding9.llPairViaBluetooth) != null) {
            linearLayout.setOnClickListener(this);
        }
        setPageView();
        Timber.INSTANCE.d("Local:" + Locale.getDefault().getCountry(), new Object[0]);
        if (UnitConversion.INSTANCE.isImperialUnitByCountryCode()) {
            FragmentOnboardingBinding binding10 = getBinding();
            TextView textView8 = binding10 != null ? binding10.titleHeight : null;
            if (textView8 != null) {
                textView8.setText(getString(R.string.height_ft_setting));
            }
            FragmentOnboardingBinding binding11 = getBinding();
            TextView textView9 = binding11 != null ? binding11.titleWeight : null;
            if (textView9 != null) {
                textView9.setText(getString(R.string.weight_lb));
            }
            FragmentOnboardingBinding binding12 = getBinding();
            EditText editText2 = binding12 != null ? binding12.height : null;
            if (editText2 != null) {
                editText2.setInputType(0);
            }
            FragmentOnboardingBinding binding13 = getBinding();
            EditText editText3 = binding13 != null ? binding13.height : null;
            if (editText3 != null) {
                editText3.setKeyListener(null);
            }
            FragmentOnboardingBinding binding14 = getBinding();
            if (binding14 != null && (editText = binding14.height) != null) {
                editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.soletreadmills.sole_v2.ui.onboarding.OnboardingFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z) {
                        OnboardingFragment.initViews$lambda$0(this.f$0, view, z);
                    }
                });
            }
        }
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, new OnBackPressedCallback() { // from class: com.soletreadmills.sole_v2.ui.onboarding.OnboardingFragment.initViews.2
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (OnboardingFragment.this.nowPage > 1) {
                    OnboardingFragment onboardingFragment = OnboardingFragment.this;
                    onboardingFragment.nowPage--;
                    OnboardingFragment.this.setPageView();
                } else {
                    setEnabled(false);
                    OnboardingFragment.this.requireActivity().onBackPressed();
                }
            }
        });
        loginToken(MySharedPreferences.INSTANCE.getInstance().getSharedLoginToken(), false, new Function1<Boolean, Unit>() { // from class: com.soletreadmills.sole_v2.ui.onboarding.OnboardingFragment.initViews.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    OnboardingFragment.this.updateMeasurementUnit(UnitConversion.INSTANCE.isImperialUnitByCountryCode() ? 1 : 0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(OnboardingFragment this$0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("startDateInput focus: " + z, new Object[0]);
        if (z) {
            this$0.showSelectHeightView();
        }
        view.clearFocus();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.tv_next;
        if (numValueOf != null && numValueOf.intValue() == i) {
            int i2 = this.nowPage;
            if (i2 == 1) {
                this.nowPage = i2 + 1;
                setPageView();
                return;
            } else {
                saveUserData();
                return;
            }
        }
        int i3 = R.id.tv_skip;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            this.nowPage++;
            setPageView();
            return;
        }
        int i4 = R.id.tv_pairLater;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            BaseFragment.safeNavigateWithPopUp$default(this, R.id.homeMainFragment, R.id.onboardingFragment, true, null, 8, null);
            return;
        }
        int i5 = R.id.birthday;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            showDatePicker();
            return;
        }
        int i6 = R.id.male;
        if (numValueOf != null && numValueOf.intValue() == i6) {
            this.selectGender = GenderType.Male.getId();
            Context context = v.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            changeSelectGenderView(context);
            return;
        }
        int i7 = R.id.female;
        if (numValueOf != null && numValueOf.intValue() == i7) {
            this.selectGender = GenderType.Female.getId();
            Context context2 = v.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            changeSelectGenderView(context2);
            return;
        }
        int i8 = R.id.ll_pairViaCloud;
        if (numValueOf != null && numValueOf.intValue() == i8) {
            Bundle bundle = new Bundle();
            bundle.putString("fromPageName", "onBoarding");
            BaseFragment.safeNavigateAndClearStack$default(this, R.id.homeMainFragment, null, 2, null);
            safeNavigate(R.id.QRCodeFragment, bundle);
            return;
        }
        int i9 = R.id.ll_pairViaBluetooth;
        if (numValueOf != null && numValueOf.intValue() == i9) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("fromPageName", "onBoarding");
            BaseFragment.safeNavigateAndClearStack$default(this, R.id.homeMainFragment, null, 2, null);
            safeNavigate(R.id.pairDeviceFragment, bundle2);
        }
    }

    private final void showSelectHeightView() {
        int iIndexOf;
        EditText editText;
        Editable text;
        int i;
        Context context = getContext();
        if (context != null) {
            IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog = this.iosOnePickerBottomSheetDialog;
            if (iosOnePickerBottomSheetDialog != null) {
                iosOnePickerBottomSheetDialog.dismiss();
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 2; i2 < 9; i2++) {
                while (true) {
                    arrayList.add(i2 + "' " + i + '\"');
                    i = i != 11 ? i + 1 : 0;
                }
            }
            FragmentOnboardingBinding binding = getBinding();
            try {
                iIndexOf = CollectionsKt.indexOf((List<? extends String>) arrayList, (binding == null || (editText = binding.height) == null || (text = editText.getText()) == null) ? null : text.toString());
            } catch (Exception unused) {
                iIndexOf = 41;
            }
            int i3 = iIndexOf;
            IosOnePickerBottomSheetDialog.Listener listener = new IosOnePickerBottomSheetDialog.Listener() { // from class: com.soletreadmills.sole_v2.ui.onboarding.OnboardingFragment$showSelectHeightView$1$1
                @Override // com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog.Listener
                public void onApply(IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog2) {
                    EditText editText2;
                    Intrinsics.checkNotNullParameter(iosOnePickerBottomSheetDialog2, "iosOnePickerBottomSheetDialog");
                    String str = iosOnePickerBottomSheetDialog2.getList().get(iosOnePickerBottomSheetDialog2.getBinding().loop.getSelectedItem());
                    FragmentOnboardingBinding binding2 = this.this$0.getBinding();
                    if (binding2 != null && (editText2 = binding2.height) != null) {
                        editText2.setText(str);
                    }
                    this.this$0.height = UnitConversion.convertFtInToCm$default(UnitConversion.INSTANCE, str, 0, 2, null);
                }
            };
            String string = getString(R.string.height);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog2 = new IosOnePickerBottomSheetDialog(context, arrayList, i3, listener, string, true);
            this.iosOnePickerBottomSheetDialog = iosOnePickerBottomSheetDialog2;
            iosOnePickerBottomSheetDialog2.show();
        }
    }

    private final void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        String strConvertTimestampToStringDateISO = TimeTools.INSTANCE.convertTimestampToStringDateISO(calendar.getTimeInMillis());
        String str = this.birthday;
        if (str == null) {
            str = strConvertTimestampToStringDateISO;
        }
        Timber.INSTANCE.d("todayISO: " + strConvertTimestampToStringDateISO, new Object[0]);
        Timber.INSTANCE.d("nowSelect: " + str, new Object[0]);
        Calendar calendar2 = Calendar.getInstance();
        Long lConvertDateISOToTimestamp$default = TimeTools.convertDateISOToTimestamp$default(TimeTools.INSTANCE, str, false, 2, null);
        if (lConvertDateISOToTimestamp$default != null) {
            calendar2.setTimeInMillis(lConvertDateISOToTimestamp$default.longValue());
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: com.soletreadmills.sole_v2.ui.onboarding.OnboardingFragment$$ExternalSyntheticLambda0
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                OnboardingFragment.showDatePicker$lambda$6(this.f$0, datePicker, i, i2, i3);
            }
        }, calendar2.get(1), calendar2.get(2), calendar2.get(5));
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(11, 0);
        calendar3.set(12, 0);
        calendar3.set(13, 0);
        calendar3.set(14, 0);
        Intrinsics.checkNotNullExpressionValue(calendar3, "apply(...)");
        datePickerDialog.getDatePicker().setMaxDate(calendar3.getTimeInMillis());
        datePickerDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDatePicker$lambda$6(OnboardingFragment this$0, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        String strConvertTimestampToStringDateISO = TimeTools.INSTANCE.convertTimestampToStringDateISO(calendar.getTimeInMillis());
        String strConvertDateISOToDisplayFormat = TimeTools.INSTANCE.convertDateISOToDisplayFormat(strConvertTimestampToStringDateISO);
        this$0.birthday = strConvertTimestampToStringDateISO;
        FragmentOnboardingBinding binding = this$0.getBinding();
        TextView textView = binding != null ? binding.birthday : null;
        if (textView == null) {
            return;
        }
        textView.setText(strConvertDateISOToDisplayFormat);
    }

    private final void changeSelectGenderView(Context context) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        Timber.INSTANCE.d("changeSelectGenderView :" + context, new Object[0]);
        String str = this.selectGender;
        if (Intrinsics.areEqual(str, GenderType.Male.getId())) {
            FragmentOnboardingBinding binding = getBinding();
            TextView textView5 = binding != null ? binding.male : null;
            if (textView5 != null) {
                textView5.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner32_white));
            }
            FragmentOnboardingBinding binding2 = getBinding();
            TextView textView6 = binding2 != null ? binding2.female : null;
            if (textView6 != null) {
                textView6.setBackground(null);
            }
            FragmentOnboardingBinding binding3 = getBinding();
            if (binding3 != null && (textView4 = binding3.male) != null) {
                textView4.setTextColor(ContextCompat.getColor(context, R.color.colorPalette_red));
            }
            FragmentOnboardingBinding binding4 = getBinding();
            if (binding4 == null || (textView3 = binding4.female) == null) {
                return;
            }
            textView3.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
            return;
        }
        if (Intrinsics.areEqual(str, GenderType.Female.getId())) {
            FragmentOnboardingBinding binding5 = getBinding();
            TextView textView7 = binding5 != null ? binding5.male : null;
            if (textView7 != null) {
                textView7.setBackground(null);
            }
            FragmentOnboardingBinding binding6 = getBinding();
            TextView textView8 = binding6 != null ? binding6.female : null;
            if (textView8 != null) {
                textView8.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner32_white));
            }
            FragmentOnboardingBinding binding7 = getBinding();
            if (binding7 != null && (textView2 = binding7.male) != null) {
                textView2.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
            }
            FragmentOnboardingBinding binding8 = getBinding();
            if (binding8 == null || (textView = binding8.female) == null) {
                return;
            }
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorPalette_red));
        }
    }

    private final void saveUserData() {
        String str;
        EditText editText;
        Editable text;
        String string;
        EditText editText2;
        Editable text2;
        String string2;
        Timber.INSTANCE.d("saveUserData", new Object[0]);
        FragmentOnboardingBinding binding = getBinding();
        String string3 = (binding == null || (editText2 = binding.height) == null || (text2 = editText2.getText()) == null || (string2 = text2.toString()) == null) ? null : StringsKt.trim((CharSequence) string2).toString();
        if (UnitConversion.INSTANCE.isImperialUnitByCountryCode()) {
            string3 = this.height;
        }
        FragmentOnboardingBinding binding2 = getBinding();
        String string4 = (binding2 == null || (editText = binding2.weight) == null || (text = editText.getText()) == null || (string = text.toString()) == null) ? null : StringsKt.trim((CharSequence) string).toString();
        Timber.INSTANCE.d("height: " + string3, new Object[0]);
        Timber.INSTANCE.d("weight: " + string4, new Object[0]);
        if ((string4 != null ? StringsKt.toDoubleOrNull(string4) : null) == null) {
            string4 = null;
        }
        if ((string3 != null ? StringsKt.toDoubleOrNull(string3) : null) == null) {
            string3 = null;
        }
        String str2 = string4;
        if (str2 != null && str2.length() != 0) {
            if (UnitConversion.INSTANCE.isImperialUnitByCountryCode()) {
                if (!UnitConversion.INSTANCE.examWeightLbLimit(string4)) {
                    CustomDialogKt.showCustomDialog$default(this, "", getString(R.string.weight_lb_limit_alert), getString(R.string.confirm), null, null, null, false, 112, null);
                    return;
                }
                string4 = UnitConversion.INSTANCE.getKg(string4);
            } else if (!UnitConversion.INSTANCE.examWeightKgLimit(string4)) {
                CustomDialogKt.showCustomDialog$default(this, "", getString(R.string.weight_kg_limit_alert), getString(R.string.confirm), null, null, null, false, 112, null);
                return;
            }
        }
        if (!UnitConversion.INSTANCE.isImperialUnitByCountryCode() && (str = string3) != null && !StringsKt.isBlank(str) && !UnitConversion.INSTANCE.examHeightCmRange(string3)) {
            CustomDialogKt.showCustomDialog$default(this, "", getString(R.string.height_cm_limit_alret), getString(R.string.confirm), null, null, null, false, 112, null);
            return;
        }
        String str3 = string3;
        if (str3 == null || StringsKt.isBlank(str3)) {
            string3 = null;
        }
        String str4 = string4;
        String str5 = (str4 == null || StringsKt.isBlank(str4)) ? null : string4;
        Timber.INSTANCE.d("height: " + string3, new Object[0]);
        Timber.INSTANCE.d("weight: " + str5, new Object[0]);
        Timber.INSTANCE.d("selectGender: " + this.selectGender, new Object[0]);
        Timber.INSTANCE.d("birthday: " + this.birthday, new Object[0]);
        updateUserInfo(new UpdateMyUserInfoApiData.RequestBodyData(null, this.birthday, Integer.valueOf(Integer.parseInt(this.selectGender)), null, null, str5, string3, 25, null), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.onboarding.OnboardingFragment.saveUserData.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Timber.INSTANCE.d("update user data success", new Object[0]);
                OnboardingFragment.this.nowPage = 3;
                OnboardingFragment.this.setPageView();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPageView() {
        Context context = getContext();
        if (context != null) {
            int i = this.nowPage;
            if (i == 1) {
                FragmentOnboardingBinding binding = getBinding();
                TextView textView = binding != null ? binding.tvSkip : null;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                FragmentOnboardingBinding binding2 = getBinding();
                TextView textView2 = binding2 != null ? binding2.tvPairLater : null;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                FragmentOnboardingBinding binding3 = getBinding();
                TextView textView3 = binding3 != null ? binding3.tvNext : null;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                FragmentOnboardingBinding binding4 = getBinding();
                TextView textView4 = binding4 != null ? binding4.tvNext : null;
                if (textView4 != null) {
                    textView4.setText(getString(R.string.continue_));
                }
                FragmentOnboardingBinding binding5 = getBinding();
                LinearLayout linearLayout = binding5 != null ? binding5.layoutPage1 : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                FragmentOnboardingBinding binding6 = getBinding();
                LinearLayout linearLayout2 = binding6 != null ? binding6.layoutPage2 : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                FragmentOnboardingBinding binding7 = getBinding();
                LinearLayout linearLayout3 = binding7 != null ? binding7.layoutPage3 : null;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
                FragmentOnboardingBinding binding8 = getBinding();
                View view = binding8 != null ? binding8.view1 : null;
                if (view != null) {
                    view.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_progress_red));
                }
                FragmentOnboardingBinding binding9 = getBinding();
                View view2 = binding9 != null ? binding9.view2 : null;
                if (view2 != null) {
                    view2.setBackground(null);
                }
                FragmentOnboardingBinding binding10 = getBinding();
                View view3 = binding10 != null ? binding10.view3 : null;
                if (view3 == null) {
                    return;
                }
                view3.setBackground(null);
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                FragmentOnboardingBinding binding11 = getBinding();
                TextView textView5 = binding11 != null ? binding11.tvSkip : null;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
                FragmentOnboardingBinding binding12 = getBinding();
                TextView textView6 = binding12 != null ? binding12.tvPairLater : null;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                FragmentOnboardingBinding binding13 = getBinding();
                TextView textView7 = binding13 != null ? binding13.tvNext : null;
                if (textView7 != null) {
                    textView7.setVisibility(8);
                }
                FragmentOnboardingBinding binding14 = getBinding();
                LinearLayout linearLayout4 = binding14 != null ? binding14.layoutPage1 : null;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
                FragmentOnboardingBinding binding15 = getBinding();
                LinearLayout linearLayout5 = binding15 != null ? binding15.layoutPage2 : null;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
                }
                FragmentOnboardingBinding binding16 = getBinding();
                LinearLayout linearLayout6 = binding16 != null ? binding16.layoutPage3 : null;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(0);
                }
                FragmentOnboardingBinding binding17 = getBinding();
                View view4 = binding17 != null ? binding17.view1 : null;
                if (view4 != null) {
                    view4.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_progress_red));
                }
                FragmentOnboardingBinding binding18 = getBinding();
                View view5 = binding18 != null ? binding18.view2 : null;
                if (view5 != null) {
                    view5.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_progress_red));
                }
                FragmentOnboardingBinding binding19 = getBinding();
                View view6 = binding19 != null ? binding19.view3 : null;
                if (view6 == null) {
                    return;
                }
                view6.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_progress_red));
                return;
            }
            FragmentOnboardingBinding binding20 = getBinding();
            TextView textView8 = binding20 != null ? binding20.tvSkip : null;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            FragmentOnboardingBinding binding21 = getBinding();
            TextView textView9 = binding21 != null ? binding21.tvPairLater : null;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
            FragmentOnboardingBinding binding22 = getBinding();
            TextView textView10 = binding22 != null ? binding22.tvNext : null;
            if (textView10 != null) {
                textView10.setVisibility(0);
            }
            FragmentOnboardingBinding binding23 = getBinding();
            TextView textView11 = binding23 != null ? binding23.tvNext : null;
            if (textView11 != null) {
                textView11.setText(getString(R.string.submit));
            }
            FragmentOnboardingBinding binding24 = getBinding();
            LinearLayout linearLayout7 = binding24 != null ? binding24.layoutPage1 : null;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(8);
            }
            FragmentOnboardingBinding binding25 = getBinding();
            LinearLayout linearLayout8 = binding25 != null ? binding25.layoutPage2 : null;
            if (linearLayout8 != null) {
                linearLayout8.setVisibility(0);
            }
            FragmentOnboardingBinding binding26 = getBinding();
            LinearLayout linearLayout9 = binding26 != null ? binding26.layoutPage3 : null;
            if (linearLayout9 != null) {
                linearLayout9.setVisibility(8);
            }
            FragmentOnboardingBinding binding27 = getBinding();
            View view7 = binding27 != null ? binding27.view1 : null;
            if (view7 != null) {
                view7.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_progress_red));
            }
            FragmentOnboardingBinding binding28 = getBinding();
            View view8 = binding28 != null ? binding28.view2 : null;
            if (view8 != null) {
                view8.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_progress_red));
            }
            FragmentOnboardingBinding binding29 = getBinding();
            View view9 = binding29 != null ? binding29.view3 : null;
            if (view9 == null) {
                return;
            }
            view9.setBackground(null);
        }
    }

    /* compiled from: OnboardingFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.onboarding.OnboardingFragment$updateMeasurementUnit$1", f = "OnboardingFragment.kt", i = {}, l = {499}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.onboarding.OnboardingFragment$updateMeasurementUnit$1, reason: invalid class name and case insensitive filesystem */
    static final class C09911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $units;
        int label;
        final /* synthetic */ OnboardingFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09911(int i, OnboardingFragment onboardingFragment, Continuation<? super C09911> continuation) {
            super(2, continuation);
            this.$units = i;
            this.this$0 = onboardingFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09911(this.$units, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = DyacoApiKt.callUpdateMeasurementUnit(new UpdateMeasurementUnitApiData.RequestBodyData(this.$units), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                UpdateMeasurementUnitApiData.ResponseData responseData = (UpdateMeasurementUnitApiData.ResponseData) ((Response) obj).body();
                if (responseData != null && responseData.getSuccess()) {
                    LoginUserData loginUserData = Global.userData;
                    if (loginUserData != null) {
                        loginUserData.setMeasurementUnit(Boxing.boxInt(this.$units));
                    }
                } else {
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (!this.this$0.shouldIgnoreError(errorCode)) {
                        this.this$0.handleUndefinedError("updateMeasurementUnit2", errorCode, responseData != null ? responseData.getErrorMessage() : null, false);
                    } else {
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
                String message = e.getMessage();
                if (message == null) {
                    message = e.getClass().getSimpleName();
                }
                this.this$0.handleApiError("updateMeasurementUnit2", message, false);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMeasurementUnit(int units) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09911(units, this, null), 3, null);
    }
}
