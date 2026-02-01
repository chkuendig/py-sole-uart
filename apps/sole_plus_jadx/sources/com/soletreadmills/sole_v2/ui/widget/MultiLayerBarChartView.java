package com.soletreadmills.sole_v2.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiLayerBarChartView.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J$\u0010'\u001a\u00020$2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u000bJ\f\u0010*\u001a\u00020\b*\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u000e\u0010\"\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/widget/MultiLayerBarChartView;", "Landroid/view/View;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "barCount", "", "barWidth", "layer2Heights", "", "layer3Heights", "margin", "maxValueLayer2", "getMaxValueLayer2", "()I", "setMaxValueLayer2", "(I)V", "maxValueLayer3", "getMaxValueLayer3", "setMaxValueLayer3", "paintLayer1", "Landroid/graphics/Paint;", "getPaintLayer1", "()Landroid/graphics/Paint;", "setPaintLayer1", "(Landroid/graphics/Paint;)V", "paintLayer2", "getPaintLayer2", "setPaintLayer2", "paintLayer3", "getPaintLayer3", "setPaintLayer3", "space", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setData", "layer2", "layer3", "dpToPx", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MultiLayerBarChartView extends View {
    public static final int $stable = 8;
    private int barCount;
    private int barWidth;
    private List<Integer> layer2Heights;
    private List<Integer> layer3Heights;
    private final int margin;
    private int maxValueLayer2;
    private int maxValueLayer3;
    private Paint paintLayer1;
    private Paint paintLayer2;
    private Paint paintLayer3;
    private final int space;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MultiLayerBarChartView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MultiLayerBarChartView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiLayerBarChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.margin = dpToPx(20);
        this.space = dpToPx(3);
        this.maxValueLayer2 = 100;
        this.maxValueLayer3 = 100;
        this.layer2Heights = CollectionsKt.emptyList();
        this.layer3Heights = CollectionsKt.emptyList();
        Paint paint = new Paint(1);
        paint.setColor(ContextCompat.getColor(context, R.color.colorBackground_raised));
        this.paintLayer1 = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(ContextCompat.getColor(context, R.color.colorGlobal_accent));
        this.paintLayer2 = paint2;
        Paint paint3 = new Paint(1);
        paint3.setColor(ContextCompat.getColor(context, R.color.colorPalette_olive));
        this.paintLayer3 = paint3;
    }

    public final int getMaxValueLayer2() {
        return this.maxValueLayer2;
    }

    public final void setMaxValueLayer2(int i) {
        this.maxValueLayer2 = i;
    }

    public final int getMaxValueLayer3() {
        return this.maxValueLayer3;
    }

    public final void setMaxValueLayer3(int i) {
        this.maxValueLayer3 = i;
    }

    public final Paint getPaintLayer1() {
        return this.paintLayer1;
    }

    public final void setPaintLayer1(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.paintLayer1 = paint;
    }

    public final Paint getPaintLayer2() {
        return this.paintLayer2;
    }

    public final void setPaintLayer2(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.paintLayer2 = paint;
    }

    public final Paint getPaintLayer3() {
        return this.paintLayer3;
    }

    public final void setPaintLayer3(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.paintLayer3 = paint;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.barCount == 0) {
            return;
        }
        float height = getHeight();
        int width = getWidth() - (this.margin * 2);
        int i = this.barCount;
        this.barWidth = (width - ((i - 1) * this.space)) / i;
        float f = height / this.maxValueLayer2;
        float f2 = height / this.maxValueLayer3;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.margin;
            int i4 = this.barWidth;
            int i5 = i3 + ((this.space + i4) * i2);
            int i6 = i4 + i5;
            float height2 = getHeight();
            float f3 = i5;
            float f4 = i6;
            canvas.drawRect(f3, 0.0f, f4, height2, this.paintLayer1);
            canvas.drawRect(f3, height2 - (this.layer2Heights.get(i2).floatValue() * f), f4, height2, this.paintLayer2);
            if (!this.layer3Heights.isEmpty()) {
                canvas.drawRect(f3, height2 - (this.layer3Heights.get(i2).floatValue() * f2), f4, height2, this.paintLayer3);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setData$default(MultiLayerBarChartView multiLayerBarChartView, List list, List list2, int i, Object obj) {
        if ((i & 2) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        multiLayerBarChartView.setData(list, list2);
    }

    public final void setData(List<Integer> layer2, List<Integer> layer3) {
        Intrinsics.checkNotNullParameter(layer2, "layer2");
        Intrinsics.checkNotNullParameter(layer3, "layer3");
        if (!layer3.isEmpty() && layer3.size() != layer2.size()) {
            throw new IllegalArgumentException("layer3 若有資料，長度必須與 layer2 相同".toString());
        }
        this.layer2Heights = layer2;
        this.layer3Heights = layer3;
        this.barCount = layer2.size();
        invalidate();
    }

    private final int dpToPx(int i) {
        return (int) (i * getContext().getResources().getDisplayMetrics().density);
    }
}
