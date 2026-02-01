package com.soletreadmills.sole_v2.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.android.SdkConstants;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: AssetImageView.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/widget/AssetImageView;", "Landroid/view/View;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", SdkConstants.TAG_BITMAP, "Landroid/graphics/Bitmap;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AssetImageView extends View {
    public static final int $stable = 8;
    private Bitmap bitmap;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AssetImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AssetImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AssetImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetImageView(Context context, AttributeSet attributeSet, int i) throws IOException {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        if (isInEditMode()) {
            return;
        }
        InputStream inputStreamOpen = context.getAssets().open("distance_5k.png");
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        this.bitmap = BitmapFactory.decodeStream(inputStreamOpen);
        inputStreamOpen.close();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Unit unit;
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            setMeasuredDimension(bitmap.getWidth(), bitmap.getHeight());
            Timber.INSTANCE.e("width:%s", Integer.valueOf(bitmap.getWidth()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            setMeasuredDimension(0, 0);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }
}
