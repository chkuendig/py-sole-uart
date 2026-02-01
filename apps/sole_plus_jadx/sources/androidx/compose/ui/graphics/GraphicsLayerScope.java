package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.PlacementScopeMarker;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import com.android.SdkConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

/* compiled from: GraphicsLayerScope.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u0018\u0010\u000e\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u0018\u0010\u0011\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u0018\u0010\u0014\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u0018\u0010 \u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007R\u0018\u0010#\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007R\u0018\u0010&\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007R\u0018\u0010)\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R\u0018\u0010,\u001a\u00020-X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR\u0018\u00100\u001a\u000201X¦\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u000207X¦\u000e¢\u0006\u0012\u0012\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010@\u001a\u0004\u0018\u00010?2\b\u0010>\u001a\u0004\u0018\u00010?8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u00020E2\u0006\u0010>\u001a\u00020E8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR(\u0010L\u001a\u0004\u0018\u00010K2\b\u0010>\u001a\u0004\u0018\u00010K8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Q\u001a\u00020R2\u0006\u0010Q\u001a\u00020R8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bS\u0010H\"\u0004\bT\u0010JR\u0014\u0010U\u001a\u00020V8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006XÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Landroidx/compose/ui/unit/Density;", "scaleX", "", "getScaleX", "()F", "setScaleX", "(F)V", "scaleY", "getScaleY", "setScaleY", "alpha", "getAlpha", "setAlpha", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", SdkConstants.TAG_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "clip", "", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "_", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@PlacementScopeMarker
/* loaded from: classes2.dex */
public interface GraphicsLayerScope extends Density {
    float getAlpha();

    float getCameraDistance();

    boolean getClip();

    default ColorFilter getColorFilter() {
        return null;
    }

    default RenderEffect getRenderEffect() {
        return null;
    }

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    Shape getShape();

    /* renamed from: getTransformOrigin-SzJe1aQ, reason: not valid java name */
    long mo4735getTransformOriginSzJe1aQ();

    float getTranslationX();

    float getTranslationY();

    void setAlpha(float f);

    /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    default void mo4736setAmbientShadowColor8_81llA(long j) {
    }

    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    default void mo4737setBlendModes9anfk8(int i) {
    }

    void setCameraDistance(float f);

    void setClip(boolean z);

    default void setColorFilter(ColorFilter colorFilter) {
    }

    /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    default void mo4738setCompositingStrategyaDBOjCE(int i) {
    }

    default void setRenderEffect(RenderEffect renderEffect) {
    }

    void setRotationX(float f);

    void setRotationY(float f);

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setShadowElevation(float f);

    void setShape(Shape shape);

    /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    default void mo4739setSpotShadowColor8_81llA(long j) {
    }

    /* renamed from: setTransformOrigin-__ExYCQ, reason: not valid java name */
    void mo4740setTransformOrigin__ExYCQ(long j);

    void setTranslationX(float f);

    void setTranslationY(float f);

    /* compiled from: GraphicsLayerScope.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getClip$annotations() {
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m4746roundToPxR2X_6o(GraphicsLayerScope graphicsLayerScope, long j) {
            return GraphicsLayerScope.super.mo670roundToPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4747roundToPx0680j_4(GraphicsLayerScope graphicsLayerScope, float f) {
            return GraphicsLayerScope.super.mo671roundToPx0680j_4(f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4752toDpGaN1DYA(GraphicsLayerScope graphicsLayerScope, long j) {
            return GraphicsLayerScope.super.mo672toDpGaN1DYA(j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4753toDpu2uoSUM(GraphicsLayerScope graphicsLayerScope, float f) {
            return GraphicsLayerScope.super.mo673toDpu2uoSUM(f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4754toDpu2uoSUM(GraphicsLayerScope graphicsLayerScope, int i) {
            return GraphicsLayerScope.super.mo674toDpu2uoSUM(i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4755toDpSizekrfVVM(GraphicsLayerScope graphicsLayerScope, long j) {
            return GraphicsLayerScope.super.mo675toDpSizekrfVVM(j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4756toPxR2X_6o(GraphicsLayerScope graphicsLayerScope, long j) {
            return GraphicsLayerScope.super.mo676toPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4757toPx0680j_4(GraphicsLayerScope graphicsLayerScope, float f) {
            return GraphicsLayerScope.super.mo677toPx0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(GraphicsLayerScope graphicsLayerScope, DpRect dpRect) {
            return GraphicsLayerScope.super.toRect(dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m4758toSizeXkaWNTQ(GraphicsLayerScope graphicsLayerScope, long j) {
            return GraphicsLayerScope.super.mo678toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4759toSp0xMU5do(GraphicsLayerScope graphicsLayerScope, float f) {
            return GraphicsLayerScope.super.mo679toSp0xMU5do(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4760toSpkPz2Gy4(GraphicsLayerScope graphicsLayerScope, float f) {
            return GraphicsLayerScope.super.mo680toSpkPz2Gy4(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4761toSpkPz2Gy4(GraphicsLayerScope graphicsLayerScope, int i) {
            return GraphicsLayerScope.super.mo681toSpkPz2Gy4(i);
        }

        @Deprecated
        /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
        public static long m4741getAmbientShadowColor0d7_KjU(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.mo4730getAmbientShadowColor0d7_KjU();
        }

        @Deprecated
        /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
        public static void m4748setAmbientShadowColor8_81llA(GraphicsLayerScope graphicsLayerScope, long j) {
            GraphicsLayerScope.super.mo4736setAmbientShadowColor8_81llA(j);
        }

        @Deprecated
        /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
        public static long m4745getSpotShadowColor0d7_KjU(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.mo4734getSpotShadowColor0d7_KjU();
        }

        @Deprecated
        /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
        public static void m4751setSpotShadowColor8_81llA(GraphicsLayerScope graphicsLayerScope, long j) {
            GraphicsLayerScope.super.mo4739setSpotShadowColor8_81llA(j);
        }

        @Deprecated
        public static RenderEffect getRenderEffect(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.getRenderEffect();
        }

        @Deprecated
        public static void setRenderEffect(GraphicsLayerScope graphicsLayerScope, RenderEffect renderEffect) {
            GraphicsLayerScope.super.setRenderEffect(renderEffect);
        }

        @Deprecated
        /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
        public static int m4742getBlendMode0nO6VwU(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.mo4731getBlendMode0nO6VwU();
        }

        @Deprecated
        /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
        public static void m4749setBlendModes9anfk8(GraphicsLayerScope graphicsLayerScope, int i) {
            GraphicsLayerScope.super.mo4737setBlendModes9anfk8(i);
        }

        @Deprecated
        public static ColorFilter getColorFilter(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.getColorFilter();
        }

        @Deprecated
        public static void setColorFilter(GraphicsLayerScope graphicsLayerScope, ColorFilter colorFilter) {
            GraphicsLayerScope.super.setColorFilter(colorFilter);
        }

        @Deprecated
        /* renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
        public static int m4743getCompositingStrategyNrFUSI(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.mo4732getCompositingStrategyNrFUSI();
        }

        @Deprecated
        /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
        public static void m4750setCompositingStrategyaDBOjCE(GraphicsLayerScope graphicsLayerScope, int i) {
            GraphicsLayerScope.super.mo4738setCompositingStrategyaDBOjCE(i);
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m4744getSizeNHjbRc(GraphicsLayerScope graphicsLayerScope) {
            return GraphicsLayerScope.super.mo4733getSizeNHjbRc();
        }
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    default long mo4730getAmbientShadowColor0d7_KjU() {
        return GraphicsLayerScopeKt.getDefaultShadowColor();
    }

    /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    default long mo4734getSpotShadowColor0d7_KjU() {
        return GraphicsLayerScopeKt.getDefaultShadowColor();
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    default int mo4731getBlendMode0nO6VwU() {
        return BlendMode.INSTANCE.m4479getSrcOver0nO6VwU();
    }

    /* renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    default int mo4732getCompositingStrategyNrFUSI() {
        return CompositingStrategy.INSTANCE.m4628getAutoNrFUSI();
    }

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    default long mo4733getSizeNHjbRc() {
        return Size.INSTANCE.m4371getUnspecifiedNHjbRc();
    }
}
