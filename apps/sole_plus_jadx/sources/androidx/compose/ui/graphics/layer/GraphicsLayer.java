package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.RectF;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import io.ktor.http.ContentDisposition;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGraphicsLayer.android.kt */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 »\u00012\u00020\u0001:\u0002»\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010w\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\bx\u0010yJ>\u0010z\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020:2\u0017\u0010{\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0004\b|\u0010}J\b\u0010~\u001a\u00020\u000fH\u0002J\f\u0010\u007f\u001a\u00020\u000f*\u00020\u000eH\u0002J\u0012\u0010\u0080\u0001\u001a\u00020\u000f2\u0007\u0010\u0081\u0001\u001a\u00020\u0000H\u0002J\u0013\u0010\u0082\u0001\u001a\u00020\u000f2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\u0019\u0010\u0085\u0001\u001a\u00020\u000f2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0000¢\u0006\u0003\b\u0088\u0001J\t\u0010\u0089\u0001\u001a\u00020\u000fH\u0002J$\u0010\u008a\u0001\u001a\u00020\u000f2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0003\b\u008c\u0001J\t\u0010\u008d\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u008e\u0001\u001a\u00020\u000fH\u0002J\n\u0010\u0091\u0001\u001a\u00030\u0090\u0001H\u0002J\t\u0010\u0092\u0001\u001a\u00020\u000fH\u0002J4\u0010\u0093\u0001\u001a\u0003H\u0094\u0001\"\u0005\b\u0000\u0010\u0094\u00012\u001a\u0010{\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001a\u0012\u0005\u0012\u0003H\u0094\u00010\u0095\u0001H\u0082\b¢\u0006\u0003\u0010\u0096\u0001J\u0014\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00132\u0007\u0010\u0098\u0001\u001a\u00020 H\u0002J\t\u0010\u0099\u0001\u001a\u00020\u0013H\u0002J\u000f\u0010\u009a\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u009b\u0001J\t\u0010\u009c\u0001\u001a\u00020\u000fH\u0002J\u000f\u0010\u009d\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u009e\u0001J\u000f\u0010\u009f\u0001\u001a\u00020\u000fH\u0001¢\u0006\u0003\b \u0001J\t\u0010©\u0001\u001a\u00020\u000fH\u0002J\u0010\u0010ª\u0001\u001a\u00020\u000f2\u0007\u0010\u0098\u0001\u001a\u00020 J/\u0010«\u0001\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u00172\b\b\u0002\u0010;\u001a\u00020\u001a2\t\b\u0002\u0010¬\u0001\u001a\u00020\u001c¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J#\u0010¯\u0001\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u00172\b\b\u0002\u0010;\u001a\u00020\u001a¢\u0006\u0005\b°\u0001\u0010yJ\u0011\u0010¸\u0001\u001a\u00030¹\u0001H\u0086@¢\u0006\u0003\u0010º\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R$\u0010/\u001a\u00020.2\u0006\u0010+\u001a\u00020.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R&\u00105\u001a\u0002042\u0006\u0010+\u001a\u000204@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b6\u00107\"\u0004\b8\u00109R&\u0010;\u001a\u00020:2\u0006\u0010+\u001a\u00020:@BX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b<\u00107\"\u0004\b=\u00109R$\u0010>\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001a\u00020C2\u0006\u0010+\u001a\u00020C8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u00101\"\u0004\bF\u00103R(\u0010H\u001a\u0004\u0018\u00010G2\b\u0010+\u001a\u0004\u0018\u00010G8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR&\u0010M\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0017@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\bN\u00107\"\u0004\bO\u00109R$\u0010P\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010@\"\u0004\bR\u0010BR$\u0010S\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010@\"\u0004\bU\u0010BR$\u0010V\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010@\"\u0004\bX\u0010BR$\u0010Y\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010@\"\u0004\b[\u0010BR$\u0010\\\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010@\"\u0004\b^\u0010BR$\u0010_\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u0010@\"\u0004\ba\u0010BR$\u0010b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010@\"\u0004\bd\u0010BR$\u0010e\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bf\u0010@\"\u0004\bg\u0010BR$\u0010h\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010@\"\u0004\bj\u0010BR*\u0010k\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0015@FX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bl\u0010m\u001a\u0004\bn\u0010-\"\u0004\bo\u0010pR(\u0010r\u001a\u0004\u0018\u00010q2\b\u0010+\u001a\u0004\u0018\u00010q8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0012\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010¡\u0001\u001a\u00030¢\u00018F¢\u0006\u0007\u001a\u0005\b£\u0001\u00107R\u0014\u0010¤\u0001\u001a\u00030¢\u00018F¢\u0006\u0007\u001a\u0005\b¥\u0001\u00107R\u0014\u0010¦\u0001\u001a\u00020\u001e8F¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001R)\u0010²\u0001\u001a\u00030±\u00012\u0007\u0010+\u001a\u00030±\u00018F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b³\u0001\u00107\"\u0005\b´\u0001\u00109R)\u0010µ\u0001\u001a\u00030±\u00012\u0007\u0010+\u001a\u00030±\u00018F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¶\u0001\u00107\"\u0005\b·\u0001\u00109¨\u0006¼\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "", "impl", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;)V", "getImpl$ui_graphics_release", "()Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "clipDrawBlock", "androidOutline", "Landroid/graphics/Outline;", "outlineDirty", "", "roundRectOutlineTopLeft", "Landroidx/compose/ui/geometry/Offset;", "J", "roundRectOutlineSize", "Landroidx/compose/ui/geometry/Size;", "roundRectCornerRadius", "", "internalOutline", "Landroidx/compose/ui/graphics/Outline;", "outlinePath", "Landroidx/compose/ui/graphics/Path;", "roundRectClipPath", "usePathForClip", "softwareDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "parentLayerUsages", "", "childDependenciesTracker", "Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "value", "isReleased", "()Z", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "()I", "setCompositingStrategy-Wpw9cng", "(I)V", "Landroidx/compose/ui/unit/IntOffset;", "topLeft", "getTopLeft-nOcc-ac", "()J", "setTopLeft--gyyYBs", "(J)V", "Landroidx/compose/ui/unit/IntSize;", ContentDisposition.Parameters.Size, "getSize-YbymL2g", "setSize-ozmzZPI", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "getClip$annotations", "()V", "getClip", "setClip", "(Z)V", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "setPosition", "setPosition-VbeCjmY", "(JJ)V", "record", "block", "record-mL-hObY", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLkotlin/jvm/functions/Function1;)V", "recordInternal", "drawWithChildTracking", "addSubLayer", "graphicsLayer", "transformCanvas", "androidCanvas", "Landroid/graphics/Canvas;", "drawForPersistence", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "drawForPersistence$ui_graphics_release", "recreateDisplayListIfNeeded", "draw", "parentLayer", "draw$ui_graphics_release", "onAddedToParentLayer", "onRemovedFromParentLayer", "pathBounds", "Landroid/graphics/RectF;", "obtainPathBounds", "configureOutlineAndClip", "resolveOutlinePosition", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "updatePathOutline", "path", "obtainAndroidOutline", "release", "release$ui_graphics_release", "discardContentIfReleasedAndHaveNoParentLayerUsages", "discardDisplayList", "discardDisplayList$ui_graphics_release", "emulateTrimMemory", "emulateTrimMemory$ui_graphics_release", "layerId", "", "getLayerId", "ownerViewId", "getOwnerViewId", "outline", "getOutline", "()Landroidx/compose/ui/graphics/Outline;", "resetOutlineParams", "setPathOutline", "setRoundRectOutline", SdkConstants.ATTR_CORNER_RADIUS, "setRoundRectOutline-TNW_H78", "(JJF)V", "setRectOutline", "setRectOutline-tz77jQw", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "toImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GraphicsLayer {
    private static final LayerSnapshotImpl SnapshotImpl;
    private static final boolean isRobolectric;
    private Outline androidOutline;
    private boolean clip;
    private final GraphicsLayerImpl impl;
    private androidx.compose.ui.graphics.Outline internalOutline;
    private boolean isReleased;
    private Path outlinePath;
    private int parentLayerUsages;
    private RectF pathBounds;
    private long pivotOffset;
    private Path roundRectClipPath;
    private float roundRectCornerRadius;
    private long size;
    private CanvasDrawScope softwareDrawScope;
    private Paint softwareLayerPaint;
    private long topLeft;
    private boolean usePathForClip;
    private Density density = DrawContextKt.getDefaultDensity();
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private Function1<? super DrawScope, Unit> drawBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$drawBlock$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DrawScope drawScope) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return Unit.INSTANCE;
        }
    };
    private final Function1<DrawScope, Unit> clipDrawBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$clipDrawBlock$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DrawScope drawScope) {
            Path path = this.this$0.outlinePath;
            if (!this.this$0.usePathForClip || !this.this$0.getClip() || path == null) {
                this.this$0.drawWithChildTracking(drawScope);
                return;
            }
            GraphicsLayer graphicsLayer = this.this$0;
            int iM4527getIntersectrtfAjoo = ClipOp.INSTANCE.m4527getIntersectrtfAjoo();
            DrawContext drawContext = drawScope.getDrawContext();
            long jMo5038getSizeNHjbRc = drawContext.mo5038getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo5040clipPathmtrdDE(path, iM4527getIntersectrtfAjoo);
                graphicsLayer.drawWithChildTracking(drawScope);
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo5039setSizeuvyYCjk(jMo5038getSizeNHjbRc);
            }
        }
    };
    private boolean outlineDirty = true;
    private long roundRectOutlineTopLeft = Offset.INSTANCE.m4310getZeroF1C5BW0();
    private long roundRectOutlineSize = Size.INSTANCE.m4371getUnspecifiedNHjbRc();
    private final ChildLayerDependenciesTracker childDependenciesTracker = new ChildLayerDependenciesTracker();

    /* compiled from: AndroidGraphicsLayer.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.graphics.layer.GraphicsLayer", f = "AndroidGraphicsLayer.android.kt", i = {}, l = {869}, m = "toImageBitmap", n = {}, s = {})
    /* renamed from: androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GraphicsLayer.this.toImageBitmap(this);
        }
    }

    public static /* synthetic */ void getClip$annotations() {
    }

    public GraphicsLayer(GraphicsLayerImpl graphicsLayerImpl) {
        this.impl = graphicsLayerImpl;
        graphicsLayerImpl.setClip(false);
        this.topLeft = IntOffset.INSTANCE.m7394getZeronOccac();
        this.size = IntSize.INSTANCE.m7431getZeroYbymL2g();
        this.pivotOffset = Offset.INSTANCE.m4309getUnspecifiedF1C5BW0();
    }

    /* renamed from: getImpl$ui_graphics_release, reason: from getter */
    public final GraphicsLayerImpl getImpl() {
        return this.impl;
    }

    /* renamed from: isReleased, reason: from getter */
    public final boolean getIsReleased() {
        return this.isReleased;
    }

    /* renamed from: getCompositingStrategy-ke2Ky5w, reason: not valid java name */
    public final int m5206getCompositingStrategyke2Ky5w() {
        return this.impl.getCompositingStrategy();
    }

    /* renamed from: setCompositingStrategy-Wpw9cng, reason: not valid java name */
    public final void m5214setCompositingStrategyWpw9cng(int i) {
        if (CompositingStrategy.m5193equalsimpl0(this.impl.getCompositingStrategy(), i)) {
            return;
        }
        this.impl.mo5227setCompositingStrategyWpw9cng(i);
    }

    /* renamed from: getTopLeft-nOcc-ac, reason: not valid java name and from getter */
    public final long getTopLeft() {
        return this.topLeft;
    }

    /* renamed from: setTopLeft--gyyYBs, reason: not valid java name */
    public final void m5219setTopLeftgyyYBs(long j) {
        if (IntOffset.m7382equalsimpl0(this.topLeft, j)) {
            return;
        }
        this.topLeft = j;
        m5200setPositionVbeCjmY(j, this.size);
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: setSize-ozmzZPI, reason: not valid java name */
    private final void m5203setSizeozmzZPI(long j) {
        if (IntSize.m7424equalsimpl0(this.size, j)) {
            return;
        }
        this.size = j;
        m5200setPositionVbeCjmY(this.topLeft, j);
        if (this.roundRectOutlineSize == InlineClassHelperKt.UnspecifiedPackedFloats) {
            this.outlineDirty = true;
            configureOutlineAndClip();
        }
    }

    public final float getAlpha() {
        return this.impl.getAlpha();
    }

    public final void setAlpha(float f) {
        if (this.impl.getAlpha() == f) {
            return;
        }
        this.impl.setAlpha(f);
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m5205getBlendMode0nO6VwU() {
        return this.impl.getBlendMode();
    }

    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m5213setBlendModes9anfk8(int i) {
        if (BlendMode.m4448equalsimpl0(this.impl.getBlendMode(), i)) {
            return;
        }
        this.impl.mo5226setBlendModes9anfk8(i);
    }

    public final ColorFilter getColorFilter() {
        return this.impl.getColorFilter();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (Intrinsics.areEqual(this.impl.getColorFilter(), colorFilter)) {
            return;
        }
        this.impl.setColorFilter(colorFilter);
    }

    /* renamed from: getPivotOffset-F1C5BW0, reason: not valid java name and from getter */
    public final long getPivotOffset() {
        return this.pivotOffset;
    }

    /* renamed from: setPivotOffset-k-4lQ0M, reason: not valid java name */
    public final void m5215setPivotOffsetk4lQ0M(long j) {
        if (Offset.m4291equalsimpl0(this.pivotOffset, j)) {
            return;
        }
        this.pivotOffset = j;
        this.impl.mo5229setPivotOffsetk4lQ0M(j);
    }

    public final float getScaleX() {
        return this.impl.getScaleX();
    }

    public final void setScaleX(float f) {
        if (this.impl.getScaleX() == f) {
            return;
        }
        this.impl.setScaleX(f);
    }

    public final float getScaleY() {
        return this.impl.getScaleY();
    }

    public final void setScaleY(float f) {
        if (this.impl.getScaleY() == f) {
            return;
        }
        this.impl.setScaleY(f);
    }

    public final float getTranslationX() {
        return this.impl.getTranslationX();
    }

    public final void setTranslationX(float f) {
        if (this.impl.getTranslationX() == f) {
            return;
        }
        this.impl.setTranslationX(f);
    }

    public final float getTranslationY() {
        return this.impl.getTranslationY();
    }

    public final void setTranslationY(float f) {
        if (this.impl.getTranslationY() == f) {
            return;
        }
        this.impl.setTranslationY(f);
    }

    public final float getShadowElevation() {
        return this.impl.getShadowElevation();
    }

    public final void setShadowElevation(float f) {
        if (this.impl.getShadowElevation() == f) {
            return;
        }
        this.impl.setShadowElevation(f);
        this.outlineDirty = true;
        configureOutlineAndClip();
    }

    public final float getRotationX() {
        return this.impl.getRotationX();
    }

    public final void setRotationX(float f) {
        if (this.impl.getRotationX() == f) {
            return;
        }
        this.impl.setRotationX(f);
    }

    public final float getRotationY() {
        return this.impl.getRotationY();
    }

    /* renamed from: setRoundRectOutline-TNW_H78$default, reason: not valid java name */
    public static /* synthetic */ void m5202setRoundRectOutlineTNW_H78$default(GraphicsLayer graphicsLayer, long j, long j2, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Offset.INSTANCE.m4310getZeroF1C5BW0();
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = Size.INSTANCE.m4371getUnspecifiedNHjbRc();
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        graphicsLayer.m5217setRoundRectOutlineTNW_H78(j3, j4, f);
    }

    public final void setRotationY(float f) {
        if (this.impl.getRotationY() == f) {
            return;
        }
        this.impl.setRotationY(f);
    }

    public final float getRotationZ() {
        return this.impl.getRotationZ();
    }

    public final void setRotationZ(float f) {
        if (this.impl.getRotationZ() == f) {
            return;
        }
        this.impl.setRotationZ(f);
    }

    /* renamed from: setRectOutline-tz77jQw$default, reason: not valid java name */
    public static /* synthetic */ void m5201setRectOutlinetz77jQw$default(GraphicsLayer graphicsLayer, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Offset.INSTANCE.m4310getZeroF1C5BW0();
        }
        if ((i & 2) != 0) {
            j2 = Size.INSTANCE.m4371getUnspecifiedNHjbRc();
        }
        graphicsLayer.m5216setRectOutlinetz77jQw(j, j2);
    }

    public final float getCameraDistance() {
        return this.impl.getCameraDistance();
    }

    public final void setCameraDistance(float f) {
        if (this.impl.getCameraDistance() == f) {
            return;
        }
        this.impl.setCameraDistance(f);
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final void setClip(boolean z) {
        if (this.clip != z) {
            this.clip = z;
            this.outlineDirty = true;
            configureOutlineAndClip();
        }
    }

    public final RenderEffect getRenderEffect() {
        return this.impl.getRenderEffect();
    }

    public final void setRenderEffect(RenderEffect renderEffect) {
        if (Intrinsics.areEqual(this.impl.getRenderEffect(), renderEffect)) {
            return;
        }
        this.impl.setRenderEffect(renderEffect);
    }

    /* renamed from: setPosition-VbeCjmY, reason: not valid java name */
    private final void m5200setPositionVbeCjmY(long topLeft, long size) {
        this.impl.mo5230setPositionH0pRuoY(IntOffset.m7383getXimpl(topLeft), IntOffset.m7384getYimpl(topLeft), size);
    }

    /* renamed from: record-mL-hObY, reason: not valid java name */
    public final void m5211recordmLhObY(Density density, LayoutDirection layoutDirection, long size, Function1<? super DrawScope, Unit> block) {
        m5203setSizeozmzZPI(size);
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = block;
        this.impl.setInvalidated(true);
        recordInternal();
    }

    private final void recordInternal() {
        this.impl.record(this.density, this.layoutDirection, this, this.clipDrawBlock);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawWithChildTracking(androidx.compose.ui.graphics.drawscope.DrawScope r15) {
        /*
            r14 = this;
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker r0 = r14.childDependenciesTracker
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependency$p(r0)
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setOldDependency$p(r0, r1)
            androidx.collection.MutableScatterSet r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependenciesSet$p(r0)
            if (r1 == 0) goto L2b
            boolean r2 = r1.isNotEmpty()
            if (r2 == 0) goto L2b
            androidx.collection.MutableScatterSet r2 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(r0)
            if (r2 != 0) goto L22
            androidx.collection.MutableScatterSet r2 = androidx.collection.ScatterSetKt.mutableScatterSetOf()
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setOldDependenciesSet$p(r0, r2)
        L22:
            r3 = r1
            androidx.collection.ScatterSet r3 = (androidx.collection.ScatterSet) r3
            r2.addAll(r3)
            r1.clear()
        L2b:
            r1 = 1
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setTrackingInProgress$p(r0, r1)
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, kotlin.Unit> r1 = r14.drawBlock
            r1.invoke(r15)
            r15 = 0
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setTrackingInProgress$p(r0, r15)
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getOldDependency$p(r0)
            if (r1 == 0) goto L41
            r1.onRemovedFromParentLayer()
        L41:
            androidx.collection.MutableScatterSet r0 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getOldDependenciesSet$p(r0)
            if (r0 == 0) goto L97
            boolean r1 = r0.isNotEmpty()
            if (r1 == 0) goto L97
            r1 = r0
            androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
            java.lang.Object[] r2 = r1.elements
            long[] r1 = r1.metadata
            int r3 = r1.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L94
            r4 = r15
        L5a:
            r5 = r1[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L8f
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r15
        L74:
            if (r9 >= r7) goto L8d
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L89
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r2[r10]
            androidx.compose.ui.graphics.layer.GraphicsLayer r10 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r10
            r10.onRemovedFromParentLayer()
        L89:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L74
        L8d:
            if (r7 != r8) goto L94
        L8f:
            if (r4 == r3) goto L94
            int r4 = r4 + 1
            goto L5a
        L94:
            r0.clear()
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.drawWithChildTracking(androidx.compose.ui.graphics.drawscope.DrawScope):void");
    }

    private final void addSubLayer(GraphicsLayer graphicsLayer) {
        if (this.childDependenciesTracker.onDependencyAdded(graphicsLayer)) {
            graphicsLayer.onAddedToParentLayer();
        }
    }

    private final void transformCanvas(Canvas androidCanvas) {
        float fM7383getXimpl = IntOffset.m7383getXimpl(this.topLeft);
        float fM7384getYimpl = IntOffset.m7384getYimpl(this.topLeft);
        float fM7383getXimpl2 = IntOffset.m7383getXimpl(this.topLeft) + ((int) (this.size >> 32));
        float fM7384getYimpl2 = IntOffset.m7384getYimpl(this.topLeft) + ((int) (this.size & 4294967295L));
        float alpha = getAlpha();
        ColorFilter colorFilter = getColorFilter();
        int iM5205getBlendMode0nO6VwU = m5205getBlendMode0nO6VwU();
        if (alpha < 1.0f || !BlendMode.m4448equalsimpl0(iM5205getBlendMode0nO6VwU, BlendMode.INSTANCE.m4479getSrcOver0nO6VwU()) || colorFilter != null || CompositingStrategy.m5193equalsimpl0(m5206getCompositingStrategyke2Ky5w(), CompositingStrategy.INSTANCE.m5199getOffscreenke2Ky5w())) {
            Paint Paint = this.softwareLayerPaint;
            if (Paint == null) {
                Paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = Paint;
            }
            Paint.setAlpha(alpha);
            Paint.mo4414setBlendModes9anfk8(iM5205getBlendMode0nO6VwU);
            Paint.setColorFilter(colorFilter);
            androidCanvas.saveLayer(fM7383getXimpl, fM7384getYimpl, fM7383getXimpl2, fM7384getYimpl2, Paint.getInternalPaint());
        } else {
            androidCanvas.save();
        }
        androidCanvas.translate(fM7383getXimpl, fM7384getYimpl);
        androidCanvas.concat(this.impl.calculateMatrix());
    }

    public final void drawForPersistence$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas) {
        if (AndroidCanvas_androidKt.getNativeCanvas(canvas).isHardwareAccelerated() || this.impl.getSupportsSoftwareRendering()) {
            recreateDisplayListIfNeeded();
            this.impl.draw(canvas);
        }
    }

    private final void recreateDisplayListIfNeeded() {
        if (this.impl.getHasDisplayList()) {
            return;
        }
        try {
            recordInternal();
        } catch (Throwable unused) {
        }
    }

    public final void draw$ui_graphics_release(androidx.compose.ui.graphics.Canvas canvas, GraphicsLayer parentLayer) {
        Canvas canvas2;
        boolean z;
        if (this.isReleased) {
            return;
        }
        configureOutlineAndClip();
        recreateDisplayListIfNeeded();
        boolean z2 = getShadowElevation() > 0.0f;
        if (z2) {
            canvas.enableZ();
        }
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        boolean zIsHardwareAccelerated = nativeCanvas.isHardwareAccelerated();
        if (!zIsHardwareAccelerated) {
            transformCanvas(nativeCanvas);
        }
        boolean z3 = !zIsHardwareAccelerated && this.clip;
        if (z3) {
            canvas.save();
            androidx.compose.ui.graphics.Outline outline = getOutline();
            if (outline instanceof Outline.Rectangle) {
                androidx.compose.ui.graphics.Canvas.m4511clipRectmtrdDE$default(canvas, ((Outline.Rectangle) outline).getRect(), 0, 2, null);
            } else if (outline instanceof Outline.Rounded) {
                Path Path = this.roundRectClipPath;
                if (Path != null) {
                    Path.rewind();
                } else {
                    Path = AndroidPath_androidKt.Path();
                    this.roundRectClipPath = Path;
                }
                Path.addRoundRect$default(Path, ((Outline.Rounded) outline).getRoundRect(), null, 2, null);
                androidx.compose.ui.graphics.Canvas.m4509clipPathmtrdDE$default(canvas, Path, 0, 2, null);
            } else {
                if (!(outline instanceof Outline.Generic)) {
                    throw new NoWhenBranchMatchedException();
                }
                androidx.compose.ui.graphics.Canvas.m4509clipPathmtrdDE$default(canvas, ((Outline.Generic) outline).getPath(), 0, 2, null);
            }
        }
        if (parentLayer != null) {
            parentLayer.addSubLayer(this);
        }
        if (AndroidCanvas_androidKt.getNativeCanvas(canvas).isHardwareAccelerated() || this.impl.getSupportsSoftwareRendering()) {
            canvas2 = nativeCanvas;
            z = zIsHardwareAccelerated;
            this.impl.draw(canvas);
        } else {
            CanvasDrawScope canvasDrawScope = this.softwareDrawScope;
            if (canvasDrawScope == null) {
                canvasDrawScope = new CanvasDrawScope();
                this.softwareDrawScope = canvasDrawScope;
            }
            CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
            Density density = this.density;
            LayoutDirection layoutDirection = this.layoutDirection;
            long jM7438toSizeozmzZPI = IntSizeKt.m7438toSizeozmzZPI(this.size);
            Density density2 = canvasDrawScope2.getDrawContext().getDensity();
            LayoutDirection layoutDirection2 = canvasDrawScope2.getDrawContext().getLayoutDirection();
            androidx.compose.ui.graphics.Canvas canvas3 = canvasDrawScope2.getDrawContext().getCanvas();
            long jMo5038getSizeNHjbRc = canvasDrawScope2.getDrawContext().mo5038getSizeNHjbRc();
            canvas2 = nativeCanvas;
            GraphicsLayer graphicsLayer = canvasDrawScope2.getDrawContext().getGraphicsLayer();
            z = zIsHardwareAccelerated;
            DrawContext drawContext = canvasDrawScope2.getDrawContext();
            drawContext.setDensity(density);
            drawContext.setLayoutDirection(layoutDirection);
            drawContext.setCanvas(canvas);
            drawContext.mo5039setSizeuvyYCjk(jM7438toSizeozmzZPI);
            drawContext.setGraphicsLayer(this);
            canvas.save();
            try {
                drawWithChildTracking(canvasDrawScope2);
            } finally {
                canvas.restore();
                DrawContext drawContext2 = canvasDrawScope2.getDrawContext();
                drawContext2.setDensity(density2);
                drawContext2.setLayoutDirection(layoutDirection2);
                drawContext2.setCanvas(canvas3);
                drawContext2.mo5039setSizeuvyYCjk(jMo5038getSizeNHjbRc);
                drawContext2.setGraphicsLayer(graphicsLayer);
            }
        }
        if (z3) {
            canvas.restore();
        }
        if (z2) {
            canvas.disableZ();
        }
        if (z) {
            return;
        }
        canvas2.restore();
    }

    private final void onAddedToParentLayer() {
        this.parentLayerUsages++;
    }

    private final void onRemovedFromParentLayer() {
        this.parentLayerUsages--;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final RectF obtainPathBounds() {
        RectF rectF = this.pathBounds;
        if (rectF != null) {
            return rectF;
        }
        RectF rectF2 = new RectF();
        this.pathBounds = rectF2;
        return rectF2;
    }

    private final void configureOutlineAndClip() {
        if (this.outlineDirty) {
            android.graphics.Outline outline = null;
            if (!this.clip && getShadowElevation() <= 0.0f) {
                this.impl.setClip(false);
                this.impl.mo5228setOutlineO0kMr_c(null, IntSize.INSTANCE.m7431getZeroYbymL2g());
            } else {
                Path path = this.outlinePath;
                if (path != null) {
                    RectF rectFObtainPathBounds = obtainPathBounds();
                    if (path instanceof AndroidPath) {
                        ((AndroidPath) path).getInternalPath().computeBounds(rectFObtainPathBounds, false);
                        android.graphics.Outline outlineUpdatePathOutline = updatePathOutline(path);
                        if (outlineUpdatePathOutline != null) {
                            outlineUpdatePathOutline.setAlpha(getAlpha());
                            outline = outlineUpdatePathOutline;
                        }
                        this.impl.mo5228setOutlineO0kMr_c(outline, IntSize.m7421constructorimpl((4294967295L & Math.round(rectFObtainPathBounds.height())) | (Math.round(rectFObtainPathBounds.width()) << 32)));
                        if (this.usePathForClip && this.clip) {
                            this.impl.setClip(false);
                            this.impl.discardDisplayList();
                        } else {
                            this.impl.setClip(this.clip);
                        }
                    } else {
                        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                    }
                } else {
                    this.impl.setClip(this.clip);
                    Size.INSTANCE.m4372getZeroNHjbRc();
                    android.graphics.Outline outlineObtainAndroidOutline = obtainAndroidOutline();
                    long jM7438toSizeozmzZPI = IntSizeKt.m7438toSizeozmzZPI(this.size);
                    long j = this.roundRectOutlineTopLeft;
                    long j2 = this.roundRectOutlineSize;
                    long j3 = j2 == InlineClassHelperKt.UnspecifiedPackedFloats ? jM7438toSizeozmzZPI : j2;
                    int i = (int) (j >> 32);
                    int i2 = (int) (j & 4294967295L);
                    outlineObtainAndroidOutline.setRoundRect(Math.round(Float.intBitsToFloat(i)), Math.round(Float.intBitsToFloat(i2)), Math.round(Float.intBitsToFloat(i) + Float.intBitsToFloat((int) (j3 >> 32))), Math.round(Float.intBitsToFloat(i2) + Float.intBitsToFloat((int) (4294967295L & j3))), this.roundRectCornerRadius);
                    outlineObtainAndroidOutline.setAlpha(getAlpha());
                    this.impl.mo5228setOutlineO0kMr_c(outlineObtainAndroidOutline, IntSizeKt.m7434roundToIntSizeuvyYCjk(j3));
                }
            }
        }
        this.outlineDirty = false;
    }

    private final <T> T resolveOutlinePosition(Function2<? super Offset, ? super Size, ? extends T> block) {
        long jM7438toSizeozmzZPI = IntSizeKt.m7438toSizeozmzZPI(this.size);
        long j = this.roundRectOutlineTopLeft;
        long j2 = this.roundRectOutlineSize;
        if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
            jM7438toSizeozmzZPI = j2;
        }
        return block.invoke(Offset.m4283boximpl(j), Size.m4351boximpl(jM7438toSizeozmzZPI));
    }

    private final android.graphics.Outline updatePathOutline(Path path) {
        android.graphics.Outline outlineObtainAndroidOutline;
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            outlineObtainAndroidOutline = obtainAndroidOutline();
            if (Build.VERSION.SDK_INT >= 30) {
                OutlineVerificationHelper.INSTANCE.setPath(outlineObtainAndroidOutline, path);
            } else if (path instanceof AndroidPath) {
                outlineObtainAndroidOutline.setConvexPath(((AndroidPath) path).getInternalPath());
            } else {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            this.usePathForClip = !outlineObtainAndroidOutline.canClip();
        } else {
            android.graphics.Outline outline = this.androidOutline;
            if (outline != null) {
                outline.setEmpty();
            }
            this.usePathForClip = true;
            this.impl.setInvalidated(true);
            outlineObtainAndroidOutline = null;
        }
        this.outlinePath = path;
        return outlineObtainAndroidOutline;
    }

    private final android.graphics.Outline obtainAndroidOutline() {
        android.graphics.Outline outline = this.androidOutline;
        if (outline != null) {
            return outline;
        }
        android.graphics.Outline outline2 = new android.graphics.Outline();
        this.androidOutline = outline2;
        return outline2;
    }

    public final void release$ui_graphics_release() {
        if (this.isReleased) {
            return;
        }
        this.isReleased = true;
        discardContentIfReleasedAndHaveNoParentLayerUsages();
    }

    private final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        if (this.isReleased && this.parentLayerUsages == 0) {
            discardDisplayList$ui_graphics_release();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void discardDisplayList$ui_graphics_release() {
        /*
            r15 = this;
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker r0 = r15.childDependenciesTracker
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependency$p(r0)
            if (r1 == 0) goto Lf
            r1.onRemovedFromParentLayer()
            r1 = 0
            androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$setDependency$p(r0, r1)
        Lf:
            androidx.collection.MutableScatterSet r0 = androidx.compose.ui.graphics.layer.ChildLayerDependenciesTracker.access$getDependenciesSet$p(r0)
            if (r0 == 0) goto L60
            r1 = r0
            androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
            java.lang.Object[] r2 = r1.elements
            long[] r1 = r1.metadata
            int r3 = r1.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L5d
            r4 = 0
            r5 = r4
        L23:
            r6 = r1[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L58
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L3d:
            if (r10 >= r8) goto L56
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L52
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r2[r11]
            androidx.compose.ui.graphics.layer.GraphicsLayer r11 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r11
            r11.onRemovedFromParentLayer()
        L52:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L3d
        L56:
            if (r8 != r9) goto L5d
        L58:
            if (r5 == r3) goto L5d
            int r5 = r5 + 1
            goto L23
        L5d:
            r0.clear()
        L60:
            androidx.compose.ui.graphics.layer.GraphicsLayerImpl r0 = r15.impl
            r0.discardDisplayList()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.discardDisplayList$ui_graphics_release():void");
    }

    public final void emulateTrimMemory$ui_graphics_release() {
        this.impl.discardDisplayList();
    }

    public final long getLayerId() {
        return this.impl.getLayerId();
    }

    public final long getOwnerViewId() {
        return this.impl.getOwnerId();
    }

    public final androidx.compose.ui.graphics.Outline getOutline() {
        androidx.compose.ui.graphics.Outline rectangle;
        androidx.compose.ui.graphics.Outline outline = this.internalOutline;
        Path path = this.outlinePath;
        if (outline != null) {
            return outline;
        }
        if (path != null) {
            Outline.Generic generic = new Outline.Generic(path);
            this.internalOutline = generic;
            return generic;
        }
        long jM7438toSizeozmzZPI = IntSizeKt.m7438toSizeozmzZPI(this.size);
        long j = this.roundRectOutlineTopLeft;
        long j2 = this.roundRectOutlineSize;
        if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
            jM7438toSizeozmzZPI = j2;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jM7438toSizeozmzZPI >> 32)) + fIntBitsToFloat;
        float fIntBitsToFloat4 = fIntBitsToFloat2 + Float.intBitsToFloat((int) (jM7438toSizeozmzZPI & 4294967295L));
        if (this.roundRectCornerRadius <= 0.0f) {
            rectangle = new Outline.Rectangle(new Rect(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4));
        } else {
            rectangle = new Outline.Rounded(RoundRectKt.m4348RoundRectgG7oq9Y(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4, CornerRadius.m4248constructorimpl((Float.floatToRawIntBits(r0) << 32) | (4294967295L & Float.floatToRawIntBits(r0)))));
        }
        this.internalOutline = rectangle;
        return rectangle;
    }

    private final void resetOutlineParams() {
        this.internalOutline = null;
        this.outlinePath = null;
        this.roundRectOutlineSize = Size.INSTANCE.m4371getUnspecifiedNHjbRc();
        this.roundRectOutlineTopLeft = Offset.INSTANCE.m4310getZeroF1C5BW0();
        this.roundRectCornerRadius = 0.0f;
        this.outlineDirty = true;
        this.usePathForClip = false;
    }

    public final void setPathOutline(Path path) {
        resetOutlineParams();
        this.outlinePath = path;
        configureOutlineAndClip();
    }

    /* renamed from: setRoundRectOutline-TNW_H78, reason: not valid java name */
    public final void m5217setRoundRectOutlineTNW_H78(long topLeft, long size, float cornerRadius) {
        if (Offset.m4291equalsimpl0(this.roundRectOutlineTopLeft, topLeft) && Size.m4359equalsimpl0(this.roundRectOutlineSize, size) && this.roundRectCornerRadius == cornerRadius && this.outlinePath == null) {
            return;
        }
        resetOutlineParams();
        this.roundRectOutlineTopLeft = topLeft;
        this.roundRectOutlineSize = size;
        this.roundRectCornerRadius = cornerRadius;
        configureOutlineAndClip();
    }

    /* renamed from: setRectOutline-tz77jQw, reason: not valid java name */
    public final void m5216setRectOutlinetz77jQw(long topLeft, long size) {
        m5217setRoundRectOutlineTNW_H78(topLeft, size, 0.0f);
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    public final long m5204getAmbientShadowColor0d7_KjU() {
        return this.impl.getAmbientShadowColor();
    }

    /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    public final void m5212setAmbientShadowColor8_81llA(long j) {
        if (Color.m4539equalsimpl0(j, this.impl.getAmbientShadowColor())) {
            return;
        }
        this.impl.mo5225setAmbientShadowColor8_81llA(j);
    }

    /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    public final long m5209getSpotShadowColor0d7_KjU() {
        return this.impl.getSpotShadowColor();
    }

    /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    public final void m5218setSpotShadowColor8_81llA(long j) {
        if (Color.m4539equalsimpl0(j, this.impl.getSpotShadowColor())) {
            return;
        }
        this.impl.mo5231setSpotShadowColor8_81llA(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object toImageBitmap(kotlin.coroutines.Continuation<? super androidx.compose.ui.graphics.ImageBitmap> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.ui.graphics.layer.GraphicsLayer.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r5
            androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1 r0 = (androidx.compose.ui.graphics.layer.GraphicsLayer.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1 r0 = new androidx.compose.ui.graphics.layer.GraphicsLayer$toImageBitmap$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L40
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.compose.ui.graphics.layer.LayerSnapshotImpl r5 = androidx.compose.ui.graphics.layer.GraphicsLayer.SnapshotImpl
            r0.label = r3
            java.lang.Object r5 = r5.toBitmap(r4, r0)
            if (r5 != r1) goto L40
            return r1
        L40:
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            androidx.compose.ui.graphics.ImageBitmap r5 = androidx.compose.ui.graphics.AndroidImageBitmap_androidKt.asImageBitmap(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.GraphicsLayer.toImageBitmap(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static {
        LayerSnapshotV21 layerSnapshotV21;
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        boolean zAreEqual = Intrinsics.areEqual(lowerCase, "robolectric");
        isRobolectric = zAreEqual;
        if (zAreEqual) {
            layerSnapshotV21 = LayerSnapshotV21.INSTANCE;
        } else if (Build.VERSION.SDK_INT >= 28) {
            layerSnapshotV21 = LayerSnapshotV28.INSTANCE;
        } else if (SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable()) {
            layerSnapshotV21 = LayerSnapshotV22.INSTANCE;
        } else {
            layerSnapshotV21 = LayerSnapshotV21.INSTANCE;
        }
        SnapshotImpl = layerSnapshotV21;
    }
}
