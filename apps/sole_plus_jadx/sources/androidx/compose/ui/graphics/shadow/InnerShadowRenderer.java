package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.CompositeShaderBrush;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.DpOffset;
import com.android.SdkConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InnerShadowPainter.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0002JQ\u0010\"\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010'\u001a\u00020(H\u0014¢\u0006\u0004\b)\u0010*J?\u0010+\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020$H\u0002¢\u0006\u0004\b0\u00101J?\u00102\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0004\b3\u00104R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u00065"}, d2 = {"Landroidx/compose/ui/graphics/shadow/InnerShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/ShadowRenderer;", "shadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "outline", "Landroidx/compose/ui/graphics/Outline;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/ui/graphics/shadow/Shadow;Landroidx/compose/ui/graphics/Outline;)V", "paint", "Landroidx/compose/ui/graphics/Paint;", "shadowMask", "Landroidx/compose/ui/graphics/ShaderBrush;", "compositeShader", "Landroidx/compose/ui/graphics/CompositeShaderBrush;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "obtainMatrix", "obtainMatrix-sQKQjiQ", "()[F", "buildShadow", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/geometry/Size;", SdkConstants.ATTR_CORNER_RADIUS, "Landroidx/compose/ui/geometry/CornerRadius;", "path", "Landroidx/compose/ui/graphics/Path;", "buildShadow-_SMYjrA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;)V", "obtainCompositeBrush", "brush", "Landroidx/compose/ui/graphics/Brush;", "onDrawShadow", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "onDrawShadow-MLmccfk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/graphics/Brush;I)V", "createInnerPathShadowBrush", "radius", "spread", "offsetX", "offsetY", "createInnerPathShadowBrush-LjSzlW0", "(JLandroidx/compose/ui/graphics/Path;FFFF)Landroidx/compose/ui/graphics/ShaderBrush;", "createInnerShadowBrush", "createInnerShadowBrush-u1Psq-8", "(JFFFFJ)Landroidx/compose/ui/graphics/ShaderBrush;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InnerShadowRenderer extends ShadowRenderer {
    private CompositeShaderBrush compositeShader;
    private float[] matrix;
    private final Paint paint;
    private final Shadow shadow;
    private ShaderBrush shadowMask;

    public InnerShadowRenderer(Shadow shadow, Outline outline) {
        super(outline);
        this.shadow = shadow;
        this.paint = AndroidPaint_androidKt.Paint();
    }

    /* renamed from: obtainMatrix-sQKQjiQ, reason: not valid java name */
    private final float[] m5259obtainMatrixsQKQjiQ() {
        float[] fArr = this.matrix;
        if (fArr != null) {
            return fArr;
        }
        float[] fArrM4780constructorimpl$default = Matrix.m4780constructorimpl$default(null, 1, null);
        this.matrix = fArrM4780constructorimpl$default;
        return fArrM4780constructorimpl$default;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* renamed from: buildShadow-_SMYjrA */
    protected void mo5255buildShadow_SMYjrA(DrawScope drawScope, long j, long j2, Path path) {
        ShaderBrush shaderBrushM5258createInnerShadowBrushu1Psq8;
        float f = drawScope.mo677toPx0680j_4(this.shadow.getRadius());
        float f2 = drawScope.mo677toPx0680j_4(this.shadow.getSpread());
        float f3 = drawScope.mo677toPx0680j_4(DpOffset.m7316getXD9Ej5fM(this.shadow.getOffset()));
        float f4 = drawScope.mo677toPx0680j_4(DpOffset.m7318getYD9Ej5fM(this.shadow.getOffset()));
        if (path != null) {
            shaderBrushM5258createInnerShadowBrushu1Psq8 = m5257createInnerPathShadowBrushLjSzlW0(j, path, f, f2, f3, f4);
        } else {
            shaderBrushM5258createInnerShadowBrushu1Psq8 = m5258createInnerShadowBrushu1Psq8(j, f, f2, f3, f4, j2);
        }
        this.shadowMask = shaderBrushM5258createInnerShadowBrushu1Psq8;
    }

    private final CompositeShaderBrush obtainCompositeBrush(ShaderBrush shadowMask, Brush brush) {
        CompositeShaderBrush compositeShaderBrush = this.compositeShader;
        if (compositeShaderBrush != null && Intrinsics.areEqual(compositeShaderBrush.getSrcBrush(), brush)) {
            return compositeShaderBrush;
        }
        CompositeShaderBrush compositeShaderBrush2 = new CompositeShaderBrush(BrushKt.toShaderBrush(shadowMask), BrushKt.toShaderBrush(brush), BlendMode.INSTANCE.m4477getSrcIn0nO6VwU(), null);
        this.compositeShader = compositeShaderBrush2;
        return compositeShaderBrush2;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* renamed from: onDrawShadow-MLmccfk */
    protected void mo5256onDrawShadowMLmccfk(DrawScope drawScope, long j, long j2, Path path, float f, ColorFilter colorFilter, Brush brush, int i) {
        CompositeShaderBrush compositeShaderBrushObtainCompositeBrush = this.shadowMask;
        if (compositeShaderBrushObtainCompositeBrush != null) {
            if (this.shadow.getBrush() instanceof ShaderBrush) {
                compositeShaderBrushObtainCompositeBrush = obtainCompositeBrush(compositeShaderBrushObtainCompositeBrush, this.shadow.getBrush());
            }
            if (path != null) {
                DrawScope.m5106drawPathGBMwjPU$default(drawScope, path, compositeShaderBrushObtainCompositeBrush, f, null, colorFilter, i, 8, null);
            } else if (CornerRadius.m4253equalsimpl0(j2, CornerRadius.INSTANCE.m4266getZerokKHJgLs())) {
                DrawScope.m5110drawRectAsUm42w$default(drawScope, compositeShaderBrushObtainCompositeBrush, 0L, 0L, f, null, colorFilter, i, 22, null);
            } else {
                DrawScope.m5112drawRoundRectZuiqVtQ$default(drawScope, compositeShaderBrushObtainCompositeBrush, 0L, 0L, j2, f, null, colorFilter, this.shadow.getBlendMode(), 38, null);
            }
        }
    }

    /* renamed from: createInnerPathShadowBrush-LjSzlW0, reason: not valid java name */
    private final ShaderBrush m5257createInnerPathShadowBrushLjSzlW0(long size, Path path, float radius, float spread, float offsetX, float offsetY) {
        ImageBitmap imageBitmapM4775ImageBitmapx__hDU$default;
        int iCeil = (int) Math.ceil(Float.intBitsToFloat((int) (size >> 32)));
        int iCeil2 = (int) Math.ceil(Float.intBitsToFloat((int) (size & 4294967295L)));
        if (spread > 0.0f) {
            Rect bounds = path.getBounds();
            float right = bounds.getRight() - bounds.getLeft();
            float bottom = bounds.getBottom() - bounds.getTop();
            imageBitmapM4775ImageBitmapx__hDU$default = ImageBitmapKt.m4775ImageBitmapx__hDU$default((int) Math.ceil(right), (int) Math.ceil(bottom), ImageBitmapConfig.INSTANCE.m4769getAlpha8_sVssgQ(), false, null, 24, null);
            Canvas Canvas = CanvasKt.Canvas(imageBitmapM4775ImageBitmapx__hDU$default);
            Canvas.drawPath(path, this.paint);
            Canvas.m4510clipRectN_I0leg$default(Canvas, 0.0f, 0.0f, right, bottom, 0, 16, null);
            Paint paintM5252configureShadowFoewPVk$default = BlurKt.m5252configureShadowFoewPVk$default(this.paint, 0L, BlendMode.INSTANCE.m4452getClear0nO6VwU(), null, PaintingStyle.INSTANCE.m4818getStrokeTiuSbCo(), 5, null);
            paintM5252configureShadowFoewPVk$default.setStrokeWidth(2.0f * spread);
            Unit unit = Unit.INSTANCE;
            Canvas.drawPath(path, paintM5252configureShadowFoewPVk$default);
        } else {
            imageBitmapM4775ImageBitmapx__hDU$default = null;
        }
        int iCeil3 = ((int) Math.ceil(radius)) * 2;
        ImageBitmap imageBitmapM4775ImageBitmapx__hDU$default2 = ImageBitmapKt.m4775ImageBitmapx__hDU$default(iCeil + iCeil3, iCeil2 + iCeil3, ImageBitmapConfig.INSTANCE.m4769getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas Canvas2 = CanvasKt.Canvas(imageBitmapM4775ImageBitmapx__hDU$default2);
        if (imageBitmapM4775ImageBitmapx__hDU$default != null) {
            Canvas2.drawRect(0.0f, 0.0f, imageBitmapM4775ImageBitmapx__hDU$default2.getWidth(), imageBitmapM4775ImageBitmapx__hDU$default2.getHeight(), BlurKt.m5252configureShadowFoewPVk$default(this.paint, 0L, 0, null, 0, 15, null));
            Canvas2.mo4392drawImaged4ec7I(imageBitmapM4775ImageBitmapx__hDU$default, Offset.m4286constructorimpl((4294967295L & Float.floatToRawIntBits(offsetY)) | (Float.floatToRawIntBits(offsetX) << 32)), BlurKt.m5252configureShadowFoewPVk$default(this.paint, 0L, BlendMode.INSTANCE.m4480getXor0nO6VwU(), radius > 0.0f ? Blur_androidKt.BlurFilter(radius) : null, 0, 9, null));
            return BrushKt.ShaderBrush(ShaderKt.m4867ImageShaderF49vj9s$default(imageBitmapM4775ImageBitmapx__hDU$default2, 0, 0, 6, null));
        }
        Canvas2.save();
        Canvas2.translate(offsetX, offsetY);
        Canvas2.drawPath(path, BlurKt.m5252configureShadowFoewPVk$default(this.paint, 0L, 0, radius > 0.0f ? Blur_androidKt.BlurFilter(radius) : null, 0, 11, null));
        Canvas2.restore();
        Canvas2.drawRect(0.0f, 0.0f, imageBitmapM4775ImageBitmapx__hDU$default2.getWidth(), imageBitmapM4775ImageBitmapx__hDU$default2.getHeight(), BlurKt.m5252configureShadowFoewPVk$default(this.paint, 0L, BlendMode.INSTANCE.m4480getXor0nO6VwU(), null, 0, 13, null));
        return BrushKt.ShaderBrush(ShaderKt.m4867ImageShaderF49vj9s$default(imageBitmapM4775ImageBitmapx__hDU$default2, 0, 0, 6, null));
    }

    /* renamed from: createInnerShadowBrush-u1Psq-8, reason: not valid java name */
    private final ShaderBrush m5258createInnerShadowBrushu1Psq8(long size, float radius, float spread, float offsetX, float offsetY, long cornerRadius) {
        int i = (int) (size >> 32);
        int i2 = (int) (size & 4294967295L);
        ImageBitmap imageBitmapM4775ImageBitmapx__hDU$default = ImageBitmapKt.m4775ImageBitmapx__hDU$default((int) Math.ceil(Float.intBitsToFloat(i)), (int) Math.ceil(Float.intBitsToFloat(i2)), ImageBitmapConfig.INSTANCE.m4769getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas Canvas = CanvasKt.Canvas(imageBitmapM4775ImageBitmapx__hDU$default);
        float f = offsetX + spread;
        float f2 = offsetY + spread;
        Canvas.drawRoundRect(f, f2, Math.max(f, (offsetX + Float.intBitsToFloat(i)) - spread), Math.max(f2, (offsetY + Float.intBitsToFloat(i2)) - spread), Float.intBitsToFloat((int) (cornerRadius >> 32)), Float.intBitsToFloat((int) (cornerRadius & 4294967295L)), BlurKt.m5252configureShadowFoewPVk$default(this.paint, 0L, 0, radius > 0.0f ? Blur_androidKt.BlurFilter(radius) : null, 0, 11, null));
        Canvas.drawRect(0.0f, 0.0f, imageBitmapM4775ImageBitmapx__hDU$default.getWidth(), imageBitmapM4775ImageBitmapx__hDU$default.getHeight(), BlurKt.m5252configureShadowFoewPVk$default(this.paint, 0L, BlendMode.INSTANCE.m4480getXor0nO6VwU(), null, 0, 13, null));
        return BrushKt.ShaderBrush(ShaderKt.m4867ImageShaderF49vj9s$default(imageBitmapM4775ImageBitmapx__hDU$default, 0, 0, 6, null));
    }
}
