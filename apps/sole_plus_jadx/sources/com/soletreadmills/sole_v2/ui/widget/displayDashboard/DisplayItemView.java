package com.soletreadmills.sole_v2.ui.widget.displayDashboard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.healthdata.HealthConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.databinding.ViewDisplayDashboardItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayItemView.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010 \u001a\u00020\u00142\b\b\u0001\u0010!\u001a\u00020\u0007J\u0010\u0010\"\u001a\u00020\u00142\b\b\u0001\u0010#\u001a\u00020\u0007J\u0010\u0010$\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010'\u001a\u00020\u00142\b\b\u0001\u0010*\u001a\u00020\u0007R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006+"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/widget/displayDashboard/DisplayItemView;", "Landroid/widget/LinearLayout;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "TAG", "", "kotlin.jvm.PlatformType", "binding", "Lcom/soletreadmills/sole_v2/databinding/ViewDisplayDashboardItemBinding;", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/ViewDisplayDashboardItemBinding;", "getDisplayUnit", "getDisplayValue", "setAttributes", "", "setDisplaySort", "show", "", "setDisplayUnit", HealthConstants.FoodIntake.UNIT, "setDisplayValue", "value", "", "setOnSortClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setSrcColor", "colorResId", "setSrcColorInt", "color", "setSrcColorStateList", "colorStateList", "Landroid/content/res/ColorStateList;", "setSrcCompat", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableResId", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DisplayItemView extends LinearLayout {
    public static final int $stable = 8;
    private final String TAG;
    private final ViewDisplayDashboardItemBinding binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DisplayItemView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DisplayItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DisplayItemView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DisplayItemView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "DisplayItemView";
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_display_dashboard_item, this, true);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        this.binding = (ViewDisplayDashboardItemBinding) viewDataBindingInflate;
        setAttributes(context, attributeSet);
    }

    public final ViewDisplayDashboardItemBinding getBinding() {
        return this.binding;
    }

    private final void setAttributes(Context context, AttributeSet attrs) {
        if (attrs == null || context == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.DisplayItemViewNew);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.DisplayItemViewNew_srcCompat);
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
            this.binding.img.setImageDrawable(drawableMutate);
        }
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.DisplayItemViewNew_srcColor);
        if (colorStateList != null) {
            ImageViewCompat.setImageTintList(this.binding.img, colorStateList);
        } else {
            ImageViewCompat.setImageTintList(this.binding.img, null);
        }
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DisplayItemViewNew_displaySort, false);
        this.binding.sortBtn.setVisibility(8);
        if (z) {
            this.binding.sortBtn.setVisibility(0);
        }
        this.binding.unitText.setText(typedArrayObtainStyledAttributes.getText(R.styleable.DisplayItemViewNew_displayUnit));
        this.binding.valueText.setText(typedArrayObtainStyledAttributes.getText(R.styleable.DisplayItemViewNew_displayValue));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void setDisplayValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.binding.valueText.setText(value);
    }

    public final void setDisplayValue(Number value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.binding.valueText.setText(value.toString());
    }

    public final void setDisplayUnit(String unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.binding.unitText.setText(unit);
    }

    public final void setSrcCompat(int drawableResId) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), drawableResId);
        this.binding.img.setImageDrawable(drawable != null ? drawable.mutate() : null);
    }

    public final void setSrcCompat(Drawable drawable) {
        this.binding.img.setImageDrawable(drawable != null ? drawable.mutate() : null);
    }

    public final void setSrcColor(int colorResId) {
        ImageViewCompat.setImageTintList(this.binding.img, ColorStateList.valueOf(ContextCompat.getColor(getContext(), colorResId)));
    }

    public final void setSrcColorInt(int color) {
        ImageViewCompat.setImageTintList(this.binding.img, ColorStateList.valueOf(color));
    }

    public final void setSrcColorStateList(ColorStateList colorStateList) {
        ImageViewCompat.setImageTintList(this.binding.img, colorStateList);
    }

    public final void setDisplaySort(boolean show) {
        this.binding.sortBtn.setVisibility(show ? 0 : 8);
    }

    public final String getDisplayValue() {
        return this.binding.valueText.getText().toString();
    }

    public final String getDisplayUnit() {
        return this.binding.unitText.getText().toString();
    }

    public final void setOnSortClickListener(View.OnClickListener listener) {
        this.binding.sortBtn.setOnClickListener(listener);
    }
}
