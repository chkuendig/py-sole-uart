package com.soletreadmills.sole_v2.ui.customview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.sun.jna.platform.win32.COM.tlb.imp.TlbConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GoalsEditTargetView.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J~\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000bJ\b\u0010(\u001a\u00020\u000eH\u0002J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/NumberInputHandler;", "", "maxLimit", "", "(I)V", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "currentValue", "", "maxDigits", "minusButton", "Landroid/widget/ImageView;", "plusButton", "addDigit", "", "digit", "tvValue", "Landroid/widget/TextView;", "deleteDigit", "getCurrentValue", "getCurrentValueAsInt", "refreshButtonStates", "reset", "setInitialValue", "value", "setupNumberPad", "number0", "number1", "number2", "number3", "number4", "number5", "number6", "number7", "number8", "number9", "deleteBtn", "Landroid/widget/LinearLayout;", "plusBtn", "minusBtn", "updateButtonStates", "updateDisplay", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NumberInputHandler {
    public static final int $stable = 8;
    private Context context;
    private String currentValue = "";
    private final int maxDigits = 6;
    private final int maxLimit;
    private ImageView minusButton;
    private ImageView plusButton;

    public NumberInputHandler(int i) {
        this.maxLimit = i;
    }

    public final void setupNumberPad(Context context, final TextView tvValue, TextView number0, TextView number1, TextView number2, TextView number3, TextView number4, TextView number5, TextView number6, TextView number7, TextView number8, TextView number9, LinearLayout deleteBtn, ImageView plusBtn, ImageView minusBtn) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tvValue, "tvValue");
        Intrinsics.checkNotNullParameter(number0, "number0");
        Intrinsics.checkNotNullParameter(number1, "number1");
        Intrinsics.checkNotNullParameter(number2, "number2");
        Intrinsics.checkNotNullParameter(number3, "number3");
        Intrinsics.checkNotNullParameter(number4, "number4");
        Intrinsics.checkNotNullParameter(number5, "number5");
        Intrinsics.checkNotNullParameter(number6, "number6");
        Intrinsics.checkNotNullParameter(number7, "number7");
        Intrinsics.checkNotNullParameter(number8, "number8");
        Intrinsics.checkNotNullParameter(number9, "number9");
        Intrinsics.checkNotNullParameter(deleteBtn, "deleteBtn");
        Intrinsics.checkNotNullParameter(plusBtn, "plusBtn");
        Intrinsics.checkNotNullParameter(minusBtn, "minusBtn");
        this.context = context;
        this.plusButton = plusBtn;
        this.minusButton = minusBtn;
        this.currentValue = tvValue.getText().toString();
        number0.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.NumberInputHandler$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                NumberInputHandler.setupNumberPad$lambda$0(this.f$0, tvValue, view);
            }
        });
        number1.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.NumberInputHandler$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                NumberInputHandler.setupNumberPad$lambda$1(this.f$0, tvValue, view);
            }
        });
        number2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.NumberInputHandler$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                NumberInputHandler.setupNumberPad$lambda$2(this.f$0, tvValue, view);
            }
        });
        number3.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.NumberInputHandler$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                NumberInputHandler.setupNumberPad$lambda$3(this.f$0, tvValue, view);
            }
        });
        number4.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.NumberInputHandler$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                NumberInputHandler.setupNumberPad$lambda$4(this.f$0, tvValue, view);
            }
        });
        number5.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.NumberInputHandler$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                NumberInputHandler.setupNumberPad$lambda$5(this.f$0, tvValue, view);
            }
        });
        number6.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.NumberInputHandler$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                NumberInputHandler.setupNumberPad$lambda$6(this.f$0, tvValue, view);
            }
        });
        number7.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.NumberInputHandler$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                NumberInputHandler.setupNumberPad$lambda$7(this.f$0, tvValue, view);
            }
        });
        number8.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.NumberInputHandler$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                NumberInputHandler.setupNumberPad$lambda$8(this.f$0, tvValue, view);
            }
        });
        number9.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.NumberInputHandler$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                NumberInputHandler.setupNumberPad$lambda$9(this.f$0, tvValue, view);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.NumberInputHandler$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NumberInputHandler.setupNumberPad$lambda$10(this.f$0, tvValue, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNumberPad$lambda$0(NumberInputHandler this$0, TextView tvValue, View view) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tvValue, "$tvValue");
        this$0.addDigit("0", tvValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNumberPad$lambda$1(NumberInputHandler this$0, TextView tvValue, View view) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tvValue, "$tvValue");
        this$0.addDigit("1", tvValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNumberPad$lambda$2(NumberInputHandler this$0, TextView tvValue, View view) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tvValue, "$tvValue");
        this$0.addDigit("2", tvValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNumberPad$lambda$3(NumberInputHandler this$0, TextView tvValue, View view) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tvValue, "$tvValue");
        this$0.addDigit(ExifInterface.GPS_MEASUREMENT_3D, tvValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNumberPad$lambda$4(NumberInputHandler this$0, TextView tvValue, View view) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tvValue, "$tvValue");
        this$0.addDigit(TlbConst.TYPELIB_MINOR_VERSION_WORD, tvValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNumberPad$lambda$5(NumberInputHandler this$0, TextView tvValue, View view) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tvValue, "$tvValue");
        this$0.addDigit(TlbConst.TYPELIB_MINOR_VERSION_OFFICE, tvValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNumberPad$lambda$6(NumberInputHandler this$0, TextView tvValue, View view) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tvValue, "$tvValue");
        this$0.addDigit("6", tvValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNumberPad$lambda$7(NumberInputHandler this$0, TextView tvValue, View view) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tvValue, "$tvValue");
        this$0.addDigit("7", tvValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNumberPad$lambda$8(NumberInputHandler this$0, TextView tvValue, View view) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tvValue, "$tvValue");
        this$0.addDigit(TlbConst.TYPELIB_MAJOR_VERSION_WORD, tvValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNumberPad$lambda$9(NumberInputHandler this$0, TextView tvValue, View view) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tvValue, "$tvValue");
        this$0.addDigit("9", tvValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNumberPad$lambda$10(NumberInputHandler this$0, TextView tvValue, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tvValue, "$tvValue");
        this$0.deleteDigit(tvValue);
    }

    private final void addDigit(String digit, TextView tvValue) throws NumberFormatException {
        if (this.currentValue.length() >= this.maxDigits) {
            return;
        }
        if (!Intrinsics.areEqual(this.currentValue, "0") || Intrinsics.areEqual(digit, "0")) {
            if (Intrinsics.areEqual(this.currentValue, "0") && Intrinsics.areEqual(digit, "0")) {
                return;
            } else {
                digit = this.currentValue + digit;
            }
        }
        try {
            int i = Integer.parseInt(digit);
            int i2 = this.maxLimit;
            if (i > i2) {
                this.currentValue = String.valueOf(i2);
            } else {
                this.currentValue = digit;
            }
            updateDisplay(tvValue);
        } catch (NumberFormatException unused) {
        }
    }

    private final void deleteDigit(TextView tvValue) {
        if (this.currentValue.length() > 0) {
            String strDropLast = StringsKt.dropLast(this.currentValue, 1);
            this.currentValue = strDropLast;
            if (strDropLast.length() == 0) {
                this.currentValue = "0";
            }
            updateDisplay(tvValue);
        }
    }

    private final void updateDisplay(TextView tvValue) {
        tvValue.setText(this.currentValue);
        updateButtonStates();
    }

    private final void updateButtonStates() {
        int i;
        int i2;
        Context context = this.context;
        if (context != null) {
            int currentValueAsInt = getCurrentValueAsInt();
            ImageView imageView = this.plusButton;
            if (imageView != null) {
                if (currentValueAsInt >= this.maxLimit) {
                    i2 = R.color.colorStats_speed30;
                } else {
                    i2 = R.color.colorPalette_red;
                }
                imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(context, i2)));
                imageView.setEnabled(currentValueAsInt < this.maxLimit);
            }
            ImageView imageView2 = this.minusButton;
            if (imageView2 != null) {
                if (currentValueAsInt <= 1) {
                    i = R.color.colorStats_speed30;
                } else {
                    i = R.color.colorPalette_red;
                }
                imageView2.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(context, i)));
                imageView2.setEnabled(currentValueAsInt > 1);
            }
        }
    }

    public final String getCurrentValue() {
        return this.currentValue;
    }

    public final int getCurrentValueAsInt() {
        try {
            return Integer.parseInt(this.currentValue);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public final void setInitialValue(String value, TextView tvValue) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(tvValue, "tvValue");
        if (value.length() == 0) {
            value = "0";
        }
        this.currentValue = value;
        updateDisplay(tvValue);
    }

    public final void reset(TextView tvValue) {
        Intrinsics.checkNotNullParameter(tvValue, "tvValue");
        this.currentValue = "0";
        updateDisplay(tvValue);
    }

    public final void refreshButtonStates() {
        updateButtonStates();
    }
}
