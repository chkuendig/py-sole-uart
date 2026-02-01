package com.soletreadmills.sole_v2.ui.settings;

import android.app.DatePickerDialog;
import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.settings.UpdateMyUserInfoApiData;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._tools.ConvertUtils;
import com.soletreadmills.sole_v2._tools.KeyboardHideTool;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2._type.user.GenderType;
import com.soletreadmills.sole_v2.databinding.FragmentEditProfileBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

/* compiled from: EditProfileFragment.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u00020\rH\u0007J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/EditProfileFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentEditProfileBinding;", "Landroid/view/View$OnClickListener;", "()V", "birthday", "", "height", "iosOnePickerBottomSheetDialog", "Lcom/soletreadmills/sole_v2/ui/_shared/IosOnePickerBottomSheetDialog;", "selectGender", "weight", "changeSelectGenderView", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "saveUserData", "setView", "showDatePicker", "showSelectHeightView", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EditProfileFragment extends BaseFragment<FragmentEditProfileBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private String birthday;
    private String height;
    private IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog;
    private String selectGender = GenderType.Male.getId();
    private String weight;

    /* compiled from: EditProfileFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GenderType.values().length];
            try {
                iArr[GenderType.Male.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GenderType.Female.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentEditProfileBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentEditProfileBinding fragmentEditProfileBindingInflate = FragmentEditProfileBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentEditProfileBindingInflate, "inflate(...)");
        return fragmentEditProfileBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        FragmentEditProfileBinding binding;
        EditText editText;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        FragmentEditProfileBinding binding2 = getBinding();
        if (binding2 != null && (textView5 = binding2.male) != null) {
            textView5.setOnClickListener(this);
        }
        FragmentEditProfileBinding binding3 = getBinding();
        if (binding3 != null && (textView4 = binding3.female) != null) {
            textView4.setOnClickListener(this);
        }
        FragmentEditProfileBinding binding4 = getBinding();
        if (binding4 != null && (textView3 = binding4.birthday) != null) {
            textView3.setOnClickListener(this);
        }
        FragmentEditProfileBinding binding5 = getBinding();
        if (binding5 != null && (textView2 = binding5.cancel) != null) {
            textView2.setOnClickListener(this);
        }
        FragmentEditProfileBinding binding6 = getBinding();
        if (binding6 != null && (textView = binding6.save) != null) {
            textView.setOnClickListener(this);
        }
        if (Global.INSTANCE.getUnitType() && (binding = getBinding()) != null && (editText = binding.height) != null) {
            editText.setOnTouchListener(new View.OnTouchListener() { // from class: com.soletreadmills.sole_v2.ui.settings.EditProfileFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return EditProfileFragment.initViews$lambda$0(this.f$0, view, motionEvent);
                }
            });
        }
        setView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initViews$lambda$0(EditProfileFragment this$0, View view, MotionEvent motionEvent) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!Global.INSTANCE.getUnitType()) {
            return false;
        }
        FragmentEditProfileBinding binding = this$0.getBinding();
        if (binding != null && (editText = binding.height) != null) {
            editText.requestFocus();
        }
        KeyboardHideTool keyboardHideTool = KeyboardHideTool.INSTANCE;
        MainActivity mainActivity = this$0.getMainActivity();
        Intrinsics.checkNotNull(mainActivity);
        keyboardHideTool.hideSoftInput(mainActivity);
        if (motionEvent.getAction() != 1) {
            return true;
        }
        this$0.showSelectHeightView();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.cancel;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.male;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            this.selectGender = GenderType.Male.getId();
            Context context = v.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            changeSelectGenderView(context);
            return;
        }
        int i3 = R.id.female;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            this.selectGender = GenderType.Female.getId();
            Context context2 = v.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            changeSelectGenderView(context2);
            return;
        }
        int i4 = R.id.birthday;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            showDatePicker();
            return;
        }
        int i5 = R.id.save;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            saveUserData();
        }
    }

    public final void setView() {
        Context context;
        EditText editText;
        EditText editText2;
        Object objM9087constructorimpl;
        Object objM9087constructorimpl2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        LoginUserData loginUserData = Global.userData;
        if (loginUserData == null || (context = getContext()) == null) {
            return;
        }
        FragmentEditProfileBinding binding = getBinding();
        if (binding != null && (editText5 = binding.name) != null) {
            editText5.setText(loginUserData.getDisplayName());
        }
        FragmentEditProfileBinding binding2 = getBinding();
        TextView textView = binding2 != null ? binding2.birthday : null;
        if (textView != null) {
            textView.setText(TimeTools.INSTANCE.formatToTime05(loginUserData.getBirthDate()));
        }
        this.height = loginUserData.getHeight();
        int i = WhenMappings.$EnumSwitchMapping$0[Global.INSTANCE.getSex().ordinal()];
        if (i == 1) {
            this.selectGender = "1";
            changeSelectGenderView(context);
        } else if (i == 2) {
            this.selectGender = "0";
            changeSelectGenderView(context);
        }
        if (Global.INSTANCE.getUnitType()) {
            String ft = UnitConversion.INSTANCE.getFt(loginUserData.getHeight());
            String heightIn = UnitConversion.INSTANCE.getHeightIn(loginUserData.getHeight());
            try {
                Result.Companion companion = Result.INSTANCE;
                EditProfileFragment editProfileFragment = this;
                objM9087constructorimpl = Result.m9087constructorimpl(Float.valueOf(Float.parseFloat(ft)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM9087constructorimpl = Result.m9087constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9090exceptionOrNullimpl(objM9087constructorimpl) != null) {
                objM9087constructorimpl = Float.valueOf(0.0f);
            }
            float fFloatValue = ((Number) objM9087constructorimpl).floatValue();
            try {
                Result.Companion companion3 = Result.INSTANCE;
                EditProfileFragment editProfileFragment2 = this;
                objM9087constructorimpl2 = Result.m9087constructorimpl(Float.valueOf(Float.parseFloat(heightIn)));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM9087constructorimpl2 = Result.m9087constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m9090exceptionOrNullimpl(objM9087constructorimpl2) != null) {
                objM9087constructorimpl2 = Float.valueOf(0.0f);
            }
            float fFloatValue2 = ((Number) objM9087constructorimpl2).floatValue();
            DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.US);
            DecimalFormat decimalFormat = new DecimalFormat("#0", decimalFormatSymbols);
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            DecimalFormat decimalFormat2 = new DecimalFormat("#0", decimalFormatSymbols);
            decimalFormat2.setRoundingMode(RoundingMode.DOWN);
            FragmentEditProfileBinding binding3 = getBinding();
            if (binding3 != null && (editText4 = binding3.height) != null) {
                editText4.setText(decimalFormat2.format(Float.valueOf(fFloatValue)) + "' " + decimalFormat.format(Float.valueOf(fFloatValue2)) + '\"');
            }
            String toOneDecimal$default = ConvertUtils.formatToOneDecimal$default(ConvertUtils.INSTANCE, UnitConversion.INSTANCE.getLb(loginUserData.getWeight()), null, 2, null);
            FragmentEditProfileBinding binding4 = getBinding();
            if (binding4 != null && (editText3 = binding4.weight) != null) {
                editText3.setText(toOneDecimal$default);
            }
            FragmentEditProfileBinding binding5 = getBinding();
            TextView textView2 = binding5 != null ? binding5.titleHeight : null;
            if (textView2 != null) {
                textView2.setText(getString(R.string.height_ft_setting));
            }
            FragmentEditProfileBinding binding6 = getBinding();
            TextView textView3 = binding6 != null ? binding6.titleWeight : null;
            if (textView3 == null) {
                return;
            }
            textView3.setText(getString(R.string.weight_lb));
            return;
        }
        FragmentEditProfileBinding binding7 = getBinding();
        if (binding7 != null && (editText2 = binding7.height) != null) {
            editText2.setText(loginUserData.getHeight());
        }
        FragmentEditProfileBinding binding8 = getBinding();
        if (binding8 == null || (editText = binding8.weight) == null) {
            return;
        }
        editText.setText(ConvertUtils.formatToOneDecimal$default(ConvertUtils.INSTANCE, loginUserData.getWeight(), null, 2, null));
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
            FragmentEditProfileBinding binding = getBinding();
            try {
                iIndexOf = CollectionsKt.indexOf((List<? extends String>) arrayList, (binding == null || (editText = binding.height) == null || (text = editText.getText()) == null) ? null : text.toString());
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
                iIndexOf = 41;
            }
            int i3 = iIndexOf;
            IosOnePickerBottomSheetDialog.Listener listener = new IosOnePickerBottomSheetDialog.Listener() { // from class: com.soletreadmills.sole_v2.ui.settings.EditProfileFragment$showSelectHeightView$1$1
                @Override // com.soletreadmills.sole_v2.ui._shared.IosOnePickerBottomSheetDialog.Listener
                public void onApply(IosOnePickerBottomSheetDialog iosOnePickerBottomSheetDialog2) {
                    EditText editText2;
                    Intrinsics.checkNotNullParameter(iosOnePickerBottomSheetDialog2, "iosOnePickerBottomSheetDialog");
                    String str = iosOnePickerBottomSheetDialog2.getList().get(iosOnePickerBottomSheetDialog2.getBinding().loop.getSelectedItem());
                    FragmentEditProfileBinding binding2 = this.this$0.getBinding();
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
        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: com.soletreadmills.sole_v2.ui.settings.EditProfileFragment$$ExternalSyntheticLambda0
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                EditProfileFragment.showDatePicker$lambda$10(this.f$0, datePicker, i, i2, i3);
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
    public static final void showDatePicker$lambda$10(EditProfileFragment this$0, DatePicker datePicker, int i, int i2, int i3) {
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
        FragmentEditProfileBinding binding = this$0.getBinding();
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
            FragmentEditProfileBinding binding = getBinding();
            TextView textView5 = binding != null ? binding.male : null;
            if (textView5 != null) {
                textView5.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner32_white));
            }
            FragmentEditProfileBinding binding2 = getBinding();
            TextView textView6 = binding2 != null ? binding2.female : null;
            if (textView6 != null) {
                textView6.setBackground(null);
            }
            FragmentEditProfileBinding binding3 = getBinding();
            if (binding3 != null && (textView4 = binding3.male) != null) {
                textView4.setTextColor(ContextCompat.getColor(context, R.color.colorPalette_red));
            }
            FragmentEditProfileBinding binding4 = getBinding();
            if (binding4 == null || (textView3 = binding4.female) == null) {
                return;
            }
            textView3.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
            return;
        }
        if (Intrinsics.areEqual(str, GenderType.Female.getId())) {
            FragmentEditProfileBinding binding5 = getBinding();
            TextView textView7 = binding5 != null ? binding5.male : null;
            if (textView7 != null) {
                textView7.setBackground(null);
            }
            FragmentEditProfileBinding binding6 = getBinding();
            TextView textView8 = binding6 != null ? binding6.female : null;
            if (textView8 != null) {
                textView8.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner32_white));
            }
            FragmentEditProfileBinding binding7 = getBinding();
            if (binding7 != null && (textView2 = binding7.male) != null) {
                textView2.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label3));
            }
            FragmentEditProfileBinding binding8 = getBinding();
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
        EditText editText3;
        Editable text3;
        String string3;
        Timber.INSTANCE.d("saveUserData", new Object[0]);
        FragmentEditProfileBinding binding = getBinding();
        String str2 = null;
        String string4 = (binding == null || (editText3 = binding.name) == null || (text3 = editText3.getText()) == null || (string3 = text3.toString()) == null) ? null : StringsKt.trim((CharSequence) string3).toString();
        FragmentEditProfileBinding binding2 = getBinding();
        String string5 = (binding2 == null || (editText2 = binding2.height) == null || (text2 = editText2.getText()) == null || (string2 = text2.toString()) == null) ? null : StringsKt.trim((CharSequence) string2).toString();
        boolean unitType = Global.INSTANCE.getUnitType();
        if (unitType) {
            string5 = this.height;
        }
        FragmentEditProfileBinding binding3 = getBinding();
        String string6 = (binding3 == null || (editText = binding3.weight) == null || (text = editText.getText()) == null || (string = text.toString()) == null) ? null : StringsKt.trim((CharSequence) string).toString();
        Timber.INSTANCE.d("height: " + string5, new Object[0]);
        Timber.INSTANCE.d("weight: " + string6, new Object[0]);
        String str3 = string4;
        if (str3 == null || str3.length() == 0) {
            CustomDialogKt.showCustomDialog$default(this, "", getString(R.string.username_empty), getString(R.string.confirm), null, null, null, false, 112, null);
            return;
        }
        if ((string6 != null ? StringsKt.toDoubleOrNull(string6) : null) == null) {
            string6 = null;
        }
        if ((string5 != null ? StringsKt.toDoubleOrNull(string5) : null) == null) {
            string5 = null;
        }
        String str4 = string6;
        if (str4 != null && str4.length() != 0) {
            if (unitType) {
                if (!UnitConversion.INSTANCE.examWeightLbLimit(string6)) {
                    CustomDialogKt.showCustomDialog$default(this, "", getString(R.string.weight_lb_limit_alert), getString(R.string.confirm), null, null, null, false, 112, null);
                    return;
                }
                string6 = UnitConversion.INSTANCE.getKg(string6);
            } else if (!UnitConversion.INSTANCE.examWeightKgLimit(string6)) {
                CustomDialogKt.showCustomDialog$default(this, "", getString(R.string.weight_kg_limit_alert), getString(R.string.confirm), null, null, null, false, 112, null);
                return;
            }
        }
        if (!unitType && (str = string5) != null && !StringsKt.isBlank(str) && !UnitConversion.INSTANCE.examHeightCmRange(string5)) {
            CustomDialogKt.showCustomDialog$default(this, "", getString(R.string.height_cm_limit_alret), getString(R.string.confirm), null, null, null, false, 112, null);
            return;
        }
        String str5 = string5;
        String str6 = (str5 == null || StringsKt.isBlank(str5)) ? null : string5;
        String str7 = string6;
        if (str7 != null && !StringsKt.isBlank(str7)) {
            str2 = string6;
        }
        Timber.INSTANCE.d("height: " + str6, new Object[0]);
        Timber.INSTANCE.d("weight: " + str2, new Object[0]);
        Timber.INSTANCE.d("selectGender: " + this.selectGender, new Object[0]);
        Timber.INSTANCE.d("birthday: " + this.birthday, new Object[0]);
        updateUserInfo(new UpdateMyUserInfoApiData.RequestBodyData(string4, this.birthday, Integer.valueOf(Integer.parseInt(this.selectGender)), null, null, str2, str6, 24, null), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.settings.EditProfileFragment.saveUserData.1
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
                EditProfileFragment.this.safeNavigateUp();
            }
        });
    }
}
