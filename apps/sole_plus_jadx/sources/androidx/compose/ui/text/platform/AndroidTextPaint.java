package androidx.compose.ui.text.platform;

import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import com.android.SdkConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidTextPaint.android.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u00104\u001a\u0002052\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u00106\u001a\u0002052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0015\u00107\u001a\u0002052\u0006\u00108\u001a\u00020\u001b¢\u0006\u0004\b9\u0010:J)\u0010;\u001a\u0002052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010<\u001a\u00020,2\b\b\u0002\u0010=\u001a\u00020\u0005¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u0002052\b\u00102\u001a\u0004\u0018\u000103J\b\u0010G\u001a\u000205H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R$\u0010\u0012\u001a\u00020\u00138\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R*\u0010#\u001a\u0012\u0012\f\u0012\n\u0018\u00010%j\u0004\u0018\u0001`&\u0018\u00010$X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R&\u0010+\u001a\u0004\u0018\u00010,8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010B\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006H"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", SdkConstants.CONSTRUCTOR_NAME, "(IF)V", "backingComposePaint", "Landroidx/compose/ui/graphics/Paint;", "composePaint", "getComposePaint", "()Landroidx/compose/ui/graphics/Paint;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "backingBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "I", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "getShadow$ui_text$annotations", "()V", "getShadow$ui_text", "()Landroidx/compose/ui/graphics/Shadow;", "setShadow$ui_text", "(Landroidx/compose/ui/graphics/Shadow;)V", "lastColor", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush$ui_text$annotations", "getBrush$ui_text", "()Landroidx/compose/ui/graphics/Brush;", "setBrush$ui_text", "(Landroidx/compose/ui/graphics/Brush;)V", "shaderState", "Landroidx/compose/runtime/State;", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "getShaderState$ui_text", "()Landroidx/compose/runtime/State;", "setShaderState$ui_text", "(Landroidx/compose/runtime/State;)V", "brushSize", "Landroidx/compose/ui/geometry/Size;", "getBrushSize-VsRJwc0$ui_text$annotations", "getBrushSize-VsRJwc0$ui_text", "()Landroidx/compose/ui/geometry/Size;", "setBrushSize-iaC8Vc4$ui_text", "(Landroidx/compose/ui/geometry/Size;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "setTextDecoration", "", "setShadow", "setColor", "color", "setColor-8_81llA", "(J)V", "setBrush", ContentDisposition.Parameters.Size, "alpha", "setBrush-12SF9DM", "(Landroidx/compose/ui/graphics/Brush;JF)V", "setDrawStyle", "value", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "clearShader", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidTextPaint extends TextPaint {
    public static final int $stable = 8;
    private int backingBlendMode;
    private Paint backingComposePaint;
    private Brush brush;
    private Size brushSize;
    private DrawStyle drawStyle;
    private Color lastColor;
    private State<? extends Shader> shaderState;
    private Shadow shadow;
    private TextDecoration textDecoration;

    public static /* synthetic */ void getBrush$ui_text$annotations() {
    }

    /* renamed from: getBrushSize-VsRJwc0$ui_text$annotations, reason: not valid java name */
    public static /* synthetic */ void m6982getBrushSizeVsRJwc0$ui_text$annotations() {
    }

    public static /* synthetic */ void getShadow$ui_text$annotations() {
    }

    public AndroidTextPaint(int i, float f) {
        super(i);
        this.density = f;
        this.textDecoration = TextDecoration.INSTANCE.getNone();
        this.backingBlendMode = DrawScope.INSTANCE.m5119getDefaultBlendMode0nO6VwU();
        this.shadow = Shadow.INSTANCE.getNone();
    }

    private final Paint getComposePaint() {
        Paint paint = this.backingComposePaint;
        if (paint != null) {
            return paint;
        }
        Paint paintAsComposePaint = AndroidPaint_androidKt.asComposePaint(this);
        this.backingComposePaint = paintAsComposePaint;
        return paintAsComposePaint;
    }

    /* renamed from: getShadow$ui_text, reason: from getter */
    public final Shadow getShadow() {
        return this.shadow;
    }

    public final void setShadow$ui_text(Shadow shadow) {
        this.shadow = shadow;
    }

    /* renamed from: getBrush$ui_text, reason: from getter */
    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush$ui_text(Brush brush) {
        this.brush = brush;
    }

    public final State<Shader> getShaderState$ui_text() {
        return this.shaderState;
    }

    public final void setShaderState$ui_text(State<? extends Shader> state) {
        this.shaderState = state;
    }

    /* renamed from: getBrushSize-VsRJwc0$ui_text, reason: not valid java name and from getter */
    public final Size getBrushSize() {
        return this.brushSize;
    }

    /* renamed from: setBrushSize-iaC8Vc4$ui_text, reason: not valid java name */
    public final void m6988setBrushSizeiaC8Vc4$ui_text(Size size) {
        this.brushSize = size;
    }

    public final void setTextDecoration(TextDecoration textDecoration) {
        if (textDecoration == null || Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            return;
        }
        this.textDecoration = textDecoration;
        setUnderlineText(textDecoration.contains(TextDecoration.INSTANCE.getUnderline()));
        setStrikeThruText(this.textDecoration.contains(TextDecoration.INSTANCE.getLineThrough()));
    }

    public final void setShadow(Shadow shadow) {
        if (shadow == null || Intrinsics.areEqual(this.shadow, shadow)) {
            return;
        }
        this.shadow = shadow;
        if (Intrinsics.areEqual(shadow, Shadow.INSTANCE.getNone())) {
            clearShadowLayer();
        } else {
            setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Float.intBitsToFloat((int) (this.shadow.getOffset() >> 32)), Float.intBitsToFloat((int) (this.shadow.getOffset() & 4294967295L)), ColorKt.m4592toArgb8_81llA(this.shadow.getColor()));
        }
    }

    /* renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m6989setColor8_81llA(long color) {
        Color color2 = this.lastColor;
        if (color2 == null ? false : Color.m4539equalsimpl0(color2.m4548unboximpl(), color)) {
            return;
        }
        if (color != 16) {
            this.lastColor = Color.m4528boximpl(color);
            setColor(ColorKt.m4592toArgb8_81llA(color));
            clearShader();
        }
    }

    /* renamed from: setBrush-12SF9DM$default, reason: not valid java name */
    public static /* synthetic */ void m6983setBrush12SF9DM$default(AndroidTextPaint androidTextPaint, Brush brush, long j, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Float.NaN;
        }
        androidTextPaint.m6987setBrush12SF9DM(brush, j, f);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* renamed from: setBrush-12SF9DM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m6987setBrush12SF9DM(final androidx.compose.ui.graphics.Brush r3, final long r4, float r6) {
        /*
            r2 = this;
            if (r3 != 0) goto L6
            r2.clearShader()
            goto L6c
        L6:
            boolean r0 = r3 instanceof androidx.compose.ui.graphics.SolidColor
            if (r0 == 0) goto L18
            androidx.compose.ui.graphics.SolidColor r3 = (androidx.compose.ui.graphics.SolidColor) r3
            long r3 = r3.getValue()
            long r3 = androidx.compose.ui.text.style.TextDrawStyleKt.m7159modulateDxMtmZc(r3, r6)
            r2.m6989setColor8_81llA(r3)
            goto L6c
        L18:
            boolean r0 = r3 instanceof androidx.compose.ui.graphics.ShaderBrush
            if (r0 == 0) goto L6d
            androidx.compose.ui.graphics.Brush r0 = r2.brush
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r0 == 0) goto L34
            androidx.compose.ui.geometry.Size r0 = r2.brushSize
            if (r0 != 0) goto L2a
            r0 = 0
            goto L32
        L2a:
            long r0 = r0.m4368unboximpl()
            boolean r0 = androidx.compose.ui.geometry.Size.m4359equalsimpl0(r0, r4)
        L32:
            if (r0 != 0) goto L50
        L34:
            r0 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 == 0) goto L50
            r2.brush = r3
            androidx.compose.ui.geometry.Size r0 = androidx.compose.ui.geometry.Size.m4351boximpl(r4)
            r2.brushSize = r0
            androidx.compose.ui.text.platform.AndroidTextPaint$$ExternalSyntheticLambda0 r0 = new androidx.compose.ui.text.platform.AndroidTextPaint$$ExternalSyntheticLambda0
            r0.<init>()
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r0)
            r2.shaderState = r3
        L50:
            androidx.compose.ui.graphics.Paint r3 = r2.getComposePaint()
            androidx.compose.runtime.State<? extends android.graphics.Shader> r4 = r2.shaderState
            r5 = 0
            if (r4 == 0) goto L60
            java.lang.Object r4 = r4.getValue()
            android.graphics.Shader r4 = (android.graphics.Shader) r4
            goto L61
        L60:
            r4 = r5
        L61:
            r3.setShader(r4)
            r2.lastColor = r5
            r3 = r2
            android.text.TextPaint r3 = (android.text.TextPaint) r3
            androidx.compose.ui.text.platform.AndroidTextPaint_androidKt.setAlpha(r3, r6)
        L6c:
            return
        L6d:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidTextPaint.m6987setBrush12SF9DM(androidx.compose.ui.graphics.Brush, long, float):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Shader setBrush_12SF9DM$lambda$1(Brush brush, long j) {
        return ((ShaderBrush) brush).mo4507createShaderuvyYCjk(j);
    }

    public final void setDrawStyle(DrawStyle drawStyle) {
        if (drawStyle == null || Intrinsics.areEqual(this.drawStyle, drawStyle)) {
            return;
        }
        this.drawStyle = drawStyle;
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            setStyle(Paint.Style.FILL);
            return;
        }
        if (!(drawStyle instanceof Stroke)) {
            throw new NoWhenBranchMatchedException();
        }
        getComposePaint().mo4419setStylek9PVt8s(PaintingStyle.INSTANCE.m4818getStrokeTiuSbCo());
        Stroke stroke = (Stroke) drawStyle;
        getComposePaint().setStrokeWidth(stroke.getWidth());
        getComposePaint().setStrokeMiterLimit(stroke.getMiter());
        getComposePaint().mo4418setStrokeJoinWw9F2mQ(stroke.getJoin());
        getComposePaint().mo4417setStrokeCapBeK7IIE(stroke.getCap());
        getComposePaint().setPathEffect(stroke.getPathEffect());
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name and from getter */
    public final int getBackingBlendMode() {
        return this.backingBlendMode;
    }

    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m6986setBlendModes9anfk8(int i) {
        if (BlendMode.m4448equalsimpl0(i, this.backingBlendMode)) {
            return;
        }
        getComposePaint().mo4414setBlendModes9anfk8(i);
        this.backingBlendMode = i;
    }

    private final void clearShader() {
        this.shaderState = null;
        this.brush = null;
        this.brushSize = null;
        setShader(null);
    }
}
