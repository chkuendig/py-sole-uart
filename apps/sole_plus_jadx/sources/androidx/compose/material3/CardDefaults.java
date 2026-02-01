package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.ElevatedCardTokens;
import androidx.compose.material3.tokens.FilledCardTokens;
import androidx.compose.material3.tokens.OutlinedCardTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: Card.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0014\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0015J:\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJN\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0015J:\u0010(\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010\u001cJN\u0010*\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010'J\u0017\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/H\u0007¢\u0006\u0002\u00100J\r\u00101\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0015J:\u00101\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u001cJN\u00103\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010'R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u00020\f*\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\f*\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0012\u001a\u00020\f*\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"Landroidx/compose/material3/CardDefaults;", "", "()V", "elevatedShape", "Landroidx/compose/ui/graphics/Shape;", "getElevatedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", SdkConstants.TAG_SHAPE, "getShape", "defaultCardColors", "Landroidx/compose/material3/CardColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultCardColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/CardColors;", "defaultElevatedCardColors", "getDefaultElevatedCardColors$material3_release", "defaultOutlinedCardColors", "getDefaultOutlinedCardColors$material3_release", "cardColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/CardColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "cardColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardColors;", SdkConstants.ATTR_CARD_ELEVATION, "Landroidx/compose/material3/CardElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "cardElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardElevation;", "elevatedCardColors", "elevatedCardColors-ro_MJ88", "elevatedCardElevation", "elevatedCardElevation-aqJV_2Y", "outlinedCardBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "outlinedCardColors", "outlinedCardColors-ro_MJ88", "outlinedCardElevation", "outlinedCardElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CardDefaults {
    public static final int $stable = 0;
    public static final CardDefaults INSTANCE = new CardDefaults();

    private CardDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(1266660211);
        ComposerKt.sourceInformation(composer, "C352@16204L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1266660211, i, -1, "androidx.compose.material3.CardDefaults.<get-shape> (Card.kt:352)");
        }
        Shape value = ShapesKt.getValue(FilledCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final Shape getElevatedShape(Composer composer, int i) {
        composer.startReplaceableGroup(-133496185);
        ComposerKt.sourceInformation(composer, "C355@16341L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-133496185, i, -1, "androidx.compose.material3.CardDefaults.<get-elevatedShape> (Card.kt:355)");
        }
        Shape value = ShapesKt.getValue(ElevatedCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        composer.startReplaceableGroup(1095404023);
        ComposerKt.sourceInformation(composer, "C358@16478L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1095404023, i, -1, "androidx.compose.material3.CardDefaults.<get-outlinedShape> (Card.kt:358)");
        }
        Shape value = ShapesKt.getValue(OutlinedCardTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    /* renamed from: cardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m2140cardElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-574898487);
        ComposerKt.sourceInformation(composer, "C(cardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        float fM3399getContainerElevationD9Ej5fM = (i2 & 1) != 0 ? FilledCardTokens.INSTANCE.m3399getContainerElevationD9Ej5fM() : f;
        float fM3405getPressedContainerElevationD9Ej5fM = (i2 & 2) != 0 ? FilledCardTokens.INSTANCE.m3405getPressedContainerElevationD9Ej5fM() : f2;
        float fM3402getFocusContainerElevationD9Ej5fM = (i2 & 4) != 0 ? FilledCardTokens.INSTANCE.m3402getFocusContainerElevationD9Ej5fM() : f3;
        float fM3403getHoverContainerElevationD9Ej5fM = (i2 & 8) != 0 ? FilledCardTokens.INSTANCE.m3403getHoverContainerElevationD9Ej5fM() : f4;
        float fM3401getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? FilledCardTokens.INSTANCE.m3401getDraggedContainerElevationD9Ej5fM() : f5;
        float fM3400getDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? FilledCardTokens.INSTANCE.m3400getDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-574898487, i, -1, "androidx.compose.material3.CardDefaults.cardElevation (Card.kt:378)");
        }
        CardElevation cardElevation = new CardElevation(fM3399getContainerElevationD9Ej5fM, fM3405getPressedContainerElevationD9Ej5fM, fM3402getFocusContainerElevationD9Ej5fM, fM3403getHoverContainerElevationD9Ej5fM, fM3401getDraggedContainerElevationD9Ej5fM, fM3400getDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardElevation;
    }

    /* renamed from: elevatedCardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m2142elevatedCardElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1154241939);
        ComposerKt.sourceInformation(composer, "C(elevatedCardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        float fM3315getContainerElevationD9Ej5fM = (i2 & 1) != 0 ? ElevatedCardTokens.INSTANCE.m3315getContainerElevationD9Ej5fM() : f;
        float fM3321getPressedContainerElevationD9Ej5fM = (i2 & 2) != 0 ? ElevatedCardTokens.INSTANCE.m3321getPressedContainerElevationD9Ej5fM() : f2;
        float fM3318getFocusContainerElevationD9Ej5fM = (i2 & 4) != 0 ? ElevatedCardTokens.INSTANCE.m3318getFocusContainerElevationD9Ej5fM() : f3;
        float fM3319getHoverContainerElevationD9Ej5fM = (i2 & 8) != 0 ? ElevatedCardTokens.INSTANCE.m3319getHoverContainerElevationD9Ej5fM() : f4;
        float fM3317getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? ElevatedCardTokens.INSTANCE.m3317getDraggedContainerElevationD9Ej5fM() : f5;
        float fM3316getDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? ElevatedCardTokens.INSTANCE.m3316getDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1154241939, i, -1, "androidx.compose.material3.CardDefaults.elevatedCardElevation (Card.kt:406)");
        }
        CardElevation cardElevation = new CardElevation(fM3315getContainerElevationD9Ej5fM, fM3321getPressedContainerElevationD9Ej5fM, fM3318getFocusContainerElevationD9Ej5fM, fM3319getHoverContainerElevationD9Ej5fM, fM3317getDraggedContainerElevationD9Ej5fM, fM3316getDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardElevation;
    }

    /* renamed from: outlinedCardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m2144outlinedCardElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-97678773);
        ComposerKt.sourceInformation(composer, "C(outlinedCardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        float fM3501getContainerElevationD9Ej5fM = (i2 & 1) != 0 ? OutlinedCardTokens.INSTANCE.m3501getContainerElevationD9Ej5fM() : f;
        float f7 = (i2 & 2) != 0 ? fM3501getContainerElevationD9Ej5fM : f2;
        float f8 = (i2 & 4) != 0 ? fM3501getContainerElevationD9Ej5fM : f3;
        float f9 = (i2 & 8) != 0 ? fM3501getContainerElevationD9Ej5fM : f4;
        float fM3503getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? OutlinedCardTokens.INSTANCE.m3503getDraggedContainerElevationD9Ej5fM() : f5;
        float fM3502getDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? OutlinedCardTokens.INSTANCE.m3502getDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-97678773, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardElevation (Card.kt:434)");
        }
        CardElevation cardElevation = new CardElevation(fM3501getContainerElevationD9Ej5fM, f7, f8, f9, fM3503getDraggedContainerElevationD9Ej5fM, fM3502getDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardElevation;
    }

    public final CardColors cardColors(Composer composer, int i) {
        composer.startReplaceableGroup(-1876034303);
        ComposerKt.sourceInformation(composer, "C(cardColors)448@20842L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1876034303, i, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:448)");
        }
        CardColors defaultCardColors$material3_release = getDefaultCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultCardColors$material3_release;
    }

    /* renamed from: cardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m2139cardColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1589582123);
        ComposerKt.sourceInformation(composer, "C(cardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)462@21453L31,465@21651L11:Card.kt#uh7d8r");
        long jM4574getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m4574getUnspecified0d7_KjU() : j;
        long jM2244contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m2244contentColorForek8zF_U(jM4574getUnspecified0d7_KjU, composer, i & 14) : j2;
        long jM4574getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m4574getUnspecified0d7_KjU() : j3;
        long jM4537copywmQWz5c$default = (i2 & 8) != 0 ? Color.m4537copywmQWz5c$default(jM2244contentColorForek8zF_U, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1589582123, i, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:465)");
        }
        CardColors cardColorsM2134copyjRlVdoo = getDefaultCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2134copyjRlVdoo(jM4574getUnspecified0d7_KjU, jM2244contentColorForek8zF_U, jM4574getUnspecified0d7_KjU2, jM4537copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardColorsM2134copyjRlVdoo;
    }

    public final CardColors getDefaultCardColors$material3_release(ColorScheme colorScheme) {
        CardColors defaultCardColorsCached = colorScheme.getDefaultCardColorsCached();
        if (defaultCardColorsCached != null) {
            return defaultCardColorsCached;
        }
        CardColors cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme, FilledCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m2243contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, FilledCardTokens.INSTANCE.getContainerColor())), ColorKt.m4583compositeOverOWjLjI(Color.m4537copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledCardTokens.INSTANCE.getDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.m2253surfaceColorAtElevation3ABfNKs(colorScheme, FilledCardTokens.INSTANCE.m3400getDisabledContainerElevationD9Ej5fM())), Color.m4537copywmQWz5c$default(ColorSchemeKt.m2243contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, FilledCardTokens.INSTANCE.getContainerColor())), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultCardColorsCached$material3_release(cardColors);
        return cardColors;
    }

    public final CardColors elevatedCardColors(Composer composer, int i) {
        composer.startReplaceableGroup(1610137975);
        ComposerKt.sourceInformation(composer, "C(elevatedCardColors)498@23021L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1610137975, i, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:498)");
        }
        CardColors defaultElevatedCardColors$material3_release = getDefaultElevatedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultElevatedCardColors$material3_release;
    }

    /* renamed from: elevatedCardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m2141elevatedCardColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(139558303);
        ComposerKt.sourceInformation(composer, "C(elevatedCardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)512@23689L31,515@23887L11:Card.kt#uh7d8r");
        long jM4574getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m4574getUnspecified0d7_KjU() : j;
        long jM2244contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m2244contentColorForek8zF_U(jM4574getUnspecified0d7_KjU, composer, i & 14) : j2;
        long jM4574getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m4574getUnspecified0d7_KjU() : j3;
        long jM4537copywmQWz5c$default = (i2 & 8) != 0 ? Color.m4537copywmQWz5c$default(jM2244contentColorForek8zF_U, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(139558303, i, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:515)");
        }
        CardColors cardColorsM2134copyjRlVdoo = getDefaultElevatedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2134copyjRlVdoo(jM4574getUnspecified0d7_KjU, jM2244contentColorForek8zF_U, jM4574getUnspecified0d7_KjU2, jM4537copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardColorsM2134copyjRlVdoo;
    }

    public final CardColors getDefaultElevatedCardColors$material3_release(ColorScheme colorScheme) {
        CardColors defaultElevatedCardColorsCached = colorScheme.getDefaultElevatedCardColorsCached();
        if (defaultElevatedCardColorsCached != null) {
            return defaultElevatedCardColorsCached;
        }
        CardColors cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme, ElevatedCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m2243contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, ElevatedCardTokens.INSTANCE.getContainerColor())), ColorKt.m4583compositeOverOWjLjI(Color.m4537copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ElevatedCardTokens.INSTANCE.getDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.m2253surfaceColorAtElevation3ABfNKs(colorScheme, ElevatedCardTokens.INSTANCE.m3316getDisabledContainerElevationD9Ej5fM())), Color.m4537copywmQWz5c$default(ColorSchemeKt.m2243contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, ElevatedCardTokens.INSTANCE.getContainerColor())), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultElevatedCardColorsCached$material3_release(cardColors);
        return cardColors;
    }

    public final CardColors outlinedCardColors(Composer composer, int i) {
        composer.startReplaceableGroup(-1204388929);
        ComposerKt.sourceInformation(composer, "C(outlinedCardColors)547@25299L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1204388929, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:547)");
        }
        CardColors defaultOutlinedCardColors$material3_release = getDefaultOutlinedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultOutlinedCardColors$material3_release;
    }

    /* renamed from: outlinedCardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m2143outlinedCardColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1112362409);
        ComposerKt.sourceInformation(composer, "C(outlinedCardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)561@25967L31,563@26097L31,564@26184L11:Card.kt#uh7d8r");
        long jM4574getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m4574getUnspecified0d7_KjU() : j;
        long jM2244contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m2244contentColorForek8zF_U(jM4574getUnspecified0d7_KjU, composer, i & 14) : j2;
        long jM4574getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m4574getUnspecified0d7_KjU() : j3;
        long jM4537copywmQWz5c$default = (i2 & 8) != 0 ? Color.m4537copywmQWz5c$default(ColorSchemeKt.m2244contentColorForek8zF_U(jM4574getUnspecified0d7_KjU, composer, i & 14), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1112362409, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:564)");
        }
        CardColors cardColorsM2134copyjRlVdoo = getDefaultOutlinedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2134copyjRlVdoo(jM4574getUnspecified0d7_KjU, jM2244contentColorForek8zF_U, jM4574getUnspecified0d7_KjU2, jM4537copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return cardColorsM2134copyjRlVdoo;
    }

    public final CardColors getDefaultOutlinedCardColors$material3_release(ColorScheme colorScheme) {
        CardColors defaultOutlinedCardColorsCached = colorScheme.getDefaultOutlinedCardColorsCached();
        if (defaultOutlinedCardColorsCached != null) {
            return defaultOutlinedCardColorsCached;
        }
        CardColors cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme, OutlinedCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.m2243contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, OutlinedCardTokens.INSTANCE.getContainerColor())), ColorSchemeKt.fromToken(colorScheme, OutlinedCardTokens.INSTANCE.getContainerColor()), Color.m4537copywmQWz5c$default(ColorSchemeKt.m2243contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, OutlinedCardTokens.INSTANCE.getContainerColor())), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultOutlinedCardColorsCached$material3_release(cardColors);
        return cardColors;
    }

    public final BorderStroke outlinedCardBorder(boolean z, Composer composer, int i, int i2) {
        long jM4583compositeOverOWjLjI;
        composer.startReplaceableGroup(-392936593);
        ComposerKt.sourceInformation(composer, "C(outlinedCardBorder)602@27787L72:Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-392936593, i, -1, "androidx.compose.material3.CardDefaults.outlinedCardBorder (Card.kt:590)");
        }
        if (z) {
            composer.startReplaceableGroup(-31426386);
            ComposerKt.sourceInformation(composer, "592@27395L5");
            jM4583compositeOverOWjLjI = ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getOutlineColor(), composer, 6);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-31426319);
            ComposerKt.sourceInformation(composer, "594@27470L5,597@27615L11");
            jM4583compositeOverOWjLjI = ColorKt.m4583compositeOverOWjLjI(Color.m4537copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.m2253surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composer, 6), OutlinedCardTokens.INSTANCE.m3502getDisabledContainerElevationD9Ej5fM()));
            composer.endReplaceableGroup();
        }
        composer.startReplaceableGroup(-31425948);
        ComposerKt.sourceInformation(composer, "CC(remember):Card.kt#9igjgp");
        boolean zChanged = composer.changed(jM4583compositeOverOWjLjI);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = BorderStrokeKt.m567BorderStrokecXLIe8U(OutlinedCardTokens.INSTANCE.m3507getOutlineWidthD9Ej5fM(), jM4583compositeOverOWjLjI);
            composer.updateRememberedValue(objRememberedValue);
        }
        BorderStroke borderStroke = (BorderStroke) objRememberedValue;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return borderStroke;
    }
}
