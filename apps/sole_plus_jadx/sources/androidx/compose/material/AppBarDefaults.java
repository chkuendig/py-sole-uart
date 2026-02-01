package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/AppBarDefaults;", "", "()V", "BottomAppBarElevation", "Landroidx/compose/ui/unit/Dp;", "getBottomAppBarElevation-D9Ej5fM", "()F", "F", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "TopAppBarElevation", "getTopAppBarElevation-D9Ej5fM", "bottomAppBarWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getBottomAppBarWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "topAppBarWindowInsets", "getTopAppBarWindowInsets", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppBarDefaults {
    public static final int $stable = 0;
    public static final AppBarDefaults INSTANCE = new AppBarDefaults();
    private static final float TopAppBarElevation = Dp.m7255constructorimpl(4);
    private static final float BottomAppBarElevation = Dp.m7255constructorimpl(8);
    private static final PaddingValues ContentPadding = PaddingKt.m982PaddingValuesa9UjIt4$default(AppBarKt.AppBarHorizontalPadding, 0.0f, AppBarKt.AppBarHorizontalPadding, 0.0f, 10, null);

    private AppBarDefaults() {
    }

    /* renamed from: getTopAppBarElevation-D9Ej5fM, reason: not valid java name */
    public final float m1722getTopAppBarElevationD9Ej5fM() {
        return TopAppBarElevation;
    }

    /* renamed from: getBottomAppBarElevation-D9Ej5fM, reason: not valid java name */
    public final float m1721getBottomAppBarElevationD9Ej5fM() {
        return BottomAppBarElevation;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final WindowInsets getTopAppBarWindowInsets(Composer composer, int i) {
        composer.startReplaceableGroup(-427176825);
        ComposerKt.sourceInformation(composer, "C457@20017L29:AppBar.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-427176825, i, -1, "androidx.compose.material.AppBarDefaults.<get-topAppBarWindowInsets> (AppBar.kt:457)");
        }
        WindowInsets windowInsetsM1056onlybOOhFvg = WindowInsetsKt.m1056onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 8), WindowInsetsSides.m1068plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1078getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m1082getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return windowInsetsM1056onlybOOhFvg;
    }

    public final WindowInsets getBottomAppBarWindowInsets(Composer composer, int i) {
        composer.startReplaceableGroup(1469837023);
        ComposerKt.sourceInformation(composer, "C466@20324L29:AppBar.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1469837023, i, -1, "androidx.compose.material.AppBarDefaults.<get-bottomAppBarWindowInsets> (AppBar.kt:465)");
        }
        WindowInsets windowInsetsM1056onlybOOhFvg = WindowInsetsKt.m1056onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 8), WindowInsetsSides.m1068plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1078getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m1076getBottomJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return windowInsetsM1056onlybOOhFvg;
    }
}
