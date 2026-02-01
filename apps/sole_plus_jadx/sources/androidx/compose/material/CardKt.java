package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.android.SdkConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: Card.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a©\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001ac\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Card", "", SdkConstants.ATTR_ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", SdkConstants.TAG_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Card-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Card-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Card-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CardKt {
    /* renamed from: Card-F-jzlyU, reason: not valid java name */
    public static final void m1775CardFjzlyU(Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1956755640);
        ComposerKt.sourceInformation(composer, "C(Card)P(5,6,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)60@2616L6,61@2674L6,62@2716L32,67@2854L218:Card.kt#jmzs0o");
        Modifier.Companion companion = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        CornerBasedShape medium = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getMedium() : shape;
        long jM1803getSurface0d7_KjU = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1803getSurface0d7_KjU() : j;
        long jM1817contentColorForek8zF_U = (i2 & 8) != 0 ? ColorsKt.m1817contentColorForek8zF_U(jM1803getSurface0d7_KjU, composer, (i >> 6) & 14) : j2;
        BorderStroke borderStroke2 = (i2 & 16) != 0 ? null : borderStroke;
        float fM7255constructorimpl = (i2 & 32) != 0 ? Dp.m7255constructorimpl(1) : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1956755640, i, -1, "androidx.compose.material.Card (Card.kt:66)");
        }
        SurfaceKt.m1978SurfaceFjzlyU(companion, medium, jM1803getSurface0d7_KjU, jM1817contentColorForek8zF_U, borderStroke2, fM7255constructorimpl, function2, composer, i & 4194302, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* renamed from: Card-LPr_se0, reason: not valid java name */
    public static final void m1776CardLPr_se0(Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        MutableInteractionSource mutableInteractionSource2;
        composer.startReplaceableGroup(778538979);
        ComposerKt.sourceInformation(composer, "C(Card)P(8,7,5,9,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)111@4759L6,112@4817L6,113@4859L32,116@5003L39,119@5088L319:Card.kt#jmzs0o");
        Modifier.Companion companion = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        CornerBasedShape medium = (i2 & 8) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getMedium() : shape;
        long jM1803getSurface0d7_KjU = (i2 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1803getSurface0d7_KjU() : j;
        long jM1817contentColorForek8zF_U = (i2 & 32) != 0 ? ColorsKt.m1817contentColorForek8zF_U(jM1803getSurface0d7_KjU, composer, (i >> 12) & 14) : j2;
        BorderStroke borderStroke2 = (i2 & 64) != 0 ? null : borderStroke;
        float fM7255constructorimpl = (i2 & 128) != 0 ? Dp.m7255constructorimpl(1) : f;
        if ((i2 & 256) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(778538979, i, -1, "androidx.compose.material.Card (Card.kt:118)");
        }
        SurfaceKt.m1979SurfaceLPr_se0(function0, companion, z2, medium, jM1803getSurface0d7_KjU, jM1817contentColorForek8zF_U, borderStroke2, fM7255constructorimpl, mutableInteractionSource2, function2, composer, i & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Card function overload that accepts an onClick().", replaceWith = @ReplaceWith(expression = "Card(onClick, modifier, enabled, shape, backgroundColor, contentColor, border, elevation, interactionSource, content)", imports = {}))
    /* renamed from: Card-9VG74zQ, reason: not valid java name */
    public static final void m1774Card9VG74zQ(Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2, int i3) {
        MutableInteractionSource mutableInteractionSource2;
        Indication indication2;
        composer.startReplaceableGroup(1353606722);
        ComposerKt.sourceInformation(composer, "C(Card)P(9,8,12,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,7,6,5,10,11:c#ui.semantics.Role)182@7959L6,183@8017L6,184@8059L32,187@8203L39,188@8290L7,195@8465L410:Card.kt#jmzs0o");
        Modifier.Companion companion = (i3 & 2) != 0 ? Modifier.INSTANCE : modifier;
        CornerBasedShape medium = (i3 & 4) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getMedium() : shape;
        long jM1803getSurface0d7_KjU = (i3 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1803getSurface0d7_KjU() : j;
        long jM1817contentColorForek8zF_U = (i3 & 16) != 0 ? ColorsKt.m1817contentColorForek8zF_U(jM1803getSurface0d7_KjU, composer, (i >> 9) & 14) : j2;
        BorderStroke borderStroke2 = (i3 & 32) != 0 ? null : borderStroke;
        float fM7255constructorimpl = (i3 & 64) != 0 ? Dp.m7255constructorimpl(1) : f;
        if ((i3 & 128) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if ((i3 & 256) != 0) {
            ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localIndication);
            ComposerKt.sourceInformationMarkerEnd(composer);
            indication2 = (Indication) objConsume;
        } else {
            indication2 = indication;
        }
        boolean z2 = (i3 & 512) != 0 ? true : z;
        String str2 = (i3 & 1024) != 0 ? null : str;
        Role role2 = (i3 & 2048) != 0 ? null : role;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1353606722, i, i2, "androidx.compose.material.Card (Card.kt:193)");
        }
        SurfaceKt.m1977Surface9VG74zQ(function0, companion, medium, jM1803getSurface0d7_KjU, jM1817contentColorForek8zF_U, borderStroke2, fM7255constructorimpl, mutableInteractionSource2, indication2, z2, str2, role2, function2, composer, i & 2147483646, i2 & 1022, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
