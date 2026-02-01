package coil.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.size.SizeResolver;
import com.android.SdkConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.sun.jna.platform.win32.Winspool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* compiled from: SubcomposeAsyncImage.kt */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a»\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a¯\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2&\b\u0002\u0010\u001e\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010!\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010#\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a\u0095\u0001\u0010*\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010\u001e\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010!\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010#\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003¢\u0006\u0002\u0010+\u001a[\u0010,\u001a\u00020\u0001*\u00020\u00192\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010/\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"SubcomposeAsyncImage", "", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", SdkConstants.ATTR_CONTENT_DESCRIPTION, "", "imageLoader", "Lcoil/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "content", "Lcoil/compose/SubcomposeAsyncImageScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "SubcomposeAsyncImage-sKDTAoQ", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "loading", "Lkotlin/Function2;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "success", "Lcoil/compose/AsyncImagePainter$State$Success;", "error", "Lcoil/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "SubcomposeAsyncImage-Q4Kwu38", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "contentOf", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function3;", "SubcomposeAsyncImageContent", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcoil/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "coil-compose-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SubcomposeAsyncImageKt {
    /* renamed from: SubcomposeAsyncImage-Q4Kwu38, reason: not valid java name */
    public static final void m7981SubcomposeAsyncImageQ4Kwu38(final Object obj, final String str, final ImageLoader imageLoader, Modifier modifier, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, final int i2, final int i3, final int i4) {
        int iM5120getDefaultFilterQualityfv9h1I;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(934816934);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeAsyncImage)P(9,3,7,10,8,14,5,12,13,11!1,4!,6:c#ui.graphics.FilterQuality)");
        final Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function44 = (i4 & 16) != 0 ? null : function4;
        final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function45 = (i4 & 32) != 0 ? null : function42;
        final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function46 = (i4 & 64) != 0 ? null : function43;
        final Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i4 & 128) != 0 ? null : function1;
        final Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i4 & 256) != 0 ? null : function12;
        final Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i4 & 512) != 0 ? null : function13;
        final Alignment center = (i4 & 1024) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        final ContentScale fit = (i4 & 2048) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        final float f2 = (i4 & 4096) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 8192) != 0 ? null : colorFilter;
        if ((i4 & 16384) != 0) {
            i5 = i3 & (-57345);
            iM5120getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m5120getDefaultFilterQualityfv9h1I();
        } else {
            iM5120getDefaultFilterQualityfv9h1I = i;
            i5 = i3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(934816934, i2, i5, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:49)");
        }
        int i6 = i5 << 18;
        m7982SubcomposeAsyncImagesKDTAoQ(obj, str, imageLoader, modifier2, null, UtilsKt.onStateOf(function14, function15, function16), center, fit, f2, colorFilter2, iM5120getDefaultFilterQualityfv9h1I, contentOf(function44, function45, function46), composerStartRestartGroup, (i2 & 112) | 520 | (i2 & 7168) | (i6 & 3670016) | (i6 & 29360128) | (i6 & 234881024) | (i6 & Winspool.PRINTER_CHANGE_PRINTER_DRIVER), (i5 >> 12) & 14, 16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final ColorFilter colorFilter3 = colorFilter2;
        final int i7 = iM5120getDefaultFilterQualityfv9h1I;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i8) {
                SubcomposeAsyncImageKt.m7981SubcomposeAsyncImageQ4Kwu38(obj, str, imageLoader, modifier2, function44, function45, function46, function14, function15, function16, center, fit, f2, colorFilter3, i7, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
            }
        });
    }

    /* renamed from: SubcomposeAsyncImage-sKDTAoQ, reason: not valid java name */
    public static final void m7982SubcomposeAsyncImagesKDTAoQ(final Object obj, final String str, final ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, final Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3, final int i4) {
        int iM5120getDefaultFilterQualityfv9h1I;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(10937794);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeAsyncImage)P(8,4,7,9,11,10!1,5!2,6:c#ui.graphics.FilterQuality)");
        Modifier modifier2 = (i4 & 8) != 0 ? Modifier.INSTANCE : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function13 = (i4 & 32) != 0 ? null : function12;
        Alignment center = (i4 & 64) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i4 & 128) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        float f2 = (i4 & 256) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 512) != 0 ? null : colorFilter;
        if ((i4 & 1024) != 0) {
            iM5120getDefaultFilterQualityfv9h1I = DrawScope.INSTANCE.m5120getDefaultFilterQualityfv9h1I();
            i5 = i3 & (-15);
        } else {
            iM5120getDefaultFilterQualityfv9h1I = i;
            i5 = i3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(10937794, i2, i5, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:104)");
        }
        ImageRequest imageRequestUpdateRequest = AsyncImageKt.updateRequest(UtilsKt.requestOf(obj, composerStartRestartGroup, 8), fit, composerStartRestartGroup, 8 | ((i2 >> 18) & 112));
        int i6 = i2 >> 6;
        int i7 = i2 >> 9;
        final int i8 = i5;
        final ContentScale contentScale2 = fit;
        final Alignment alignment2 = center;
        final AsyncImagePainter asyncImagePainterM7957rememberAsyncImagePainter5jETZwI = AsyncImagePainterKt.m7957rememberAsyncImagePainter5jETZwI(imageRequestUpdateRequest, imageLoader, defaultTransform, function13, fit, iM5120getDefaultFilterQualityfv9h1I, composerStartRestartGroup, (i6 & 7168) | (i6 & 896) | 72 | (i7 & 57344) | ((i5 << 15) & 458752), 0);
        final SizeResolver sizeResolver = imageRequestUpdateRequest.getSizeResolver();
        if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
            composerStartRestartGroup.startReplaceableGroup(-247979203);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(alignment2, true, composerStartRestartGroup, (((((i7 & 14) | 384) | ((i2 >> 15) & 112)) >> 3) & 14) | 48);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifier2);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM3857constructorimpl = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m3864setimpl(composerM3857constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m3864setimpl(composerM3857constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m3827boximpl(SkippableUpdater.m3828constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            function3.invoke(new RealSubcomposeAsyncImageScope(BoxScopeInstance.INSTANCE, asyncImagePainterM7957rememberAsyncImagePainter5jETZwI, str, alignment2, contentScale2, f2, colorFilter2), composerStartRestartGroup, Integer.valueOf(i8 & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-247978567);
            final float f3 = f2;
            final ColorFilter colorFilter3 = colorFilter2;
            BoxWithConstraintsKt.BoxWithConstraints(modifier2, alignment2, true, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1964284792, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                    invoke(boxWithConstraintsScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i9) {
                    int i10;
                    if ((i9 & 14) == 0) {
                        i10 = (composer2.changed(boxWithConstraintsScope) ? 4 : 2) | i9;
                    } else {
                        i10 = i9;
                    }
                    if ((i10 & 91) != 18 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1964284792, i9, -1, "coil.compose.SubcomposeAsyncImage.<anonymous> (SubcomposeAsyncImage.kt:150)");
                        }
                        ((ConstraintsSizeResolver) sizeResolver).m7961setConstraintsBRTryo0(boxWithConstraintsScope.mo892getConstraintsmsEJaDk());
                        function3.invoke(new RealSubcomposeAsyncImageScope(boxWithConstraintsScope, asyncImagePainterM7957rememberAsyncImagePainter5jETZwI, str, alignment2, contentScale2, f3, colorFilter3), composer2, Integer.valueOf(i8 & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), composerStartRestartGroup, (i7 & 14) | 3456 | ((i2 >> 15) & 112), 0);
            composerStartRestartGroup.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function14 = defaultTransform;
        final Function1<? super AsyncImagePainter.State, Unit> function15 = function13;
        final float f4 = f2;
        final ColorFilter colorFilter4 = colorFilter2;
        final int i9 = iM5120getDefaultFilterQualityfv9h1I;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i10) {
                SubcomposeAsyncImageKt.m7982SubcomposeAsyncImagesKDTAoQ(obj, str, imageLoader, modifier3, function14, function15, alignment2, contentScale2, f4, colorFilter4, i9, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SubcomposeAsyncImageContent(final coil.compose.SubcomposeAsyncImageScope r21, androidx.compose.ui.Modifier r22, androidx.compose.ui.graphics.painter.Painter r23, java.lang.String r24, androidx.compose.ui.Alignment r25, androidx.compose.ui.layout.ContentScale r26, float r27, androidx.compose.ui.graphics.ColorFilter r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.compose.SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(coil.compose.SubcomposeAsyncImageScope, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.painter.Painter, java.lang.String, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf(final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43) {
        return (function4 == null && function42 == null && function43 == null) ? ComposableSingletons$SubcomposeAsyncImageKt.INSTANCE.m7960getLambda1$coil_compose_base_release() : ComposableLambdaKt.composableLambdaInstance(-1302781228, true, new Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt.contentOf.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, Integer num) {
                invoke(subcomposeAsyncImageScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:46:0x00b8  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x00ce  */
            /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(coil.compose.SubcomposeAsyncImageScope r12, androidx.compose.runtime.Composer r13, int r14) {
                /*
                    r11 = this;
                    r1 = r14 & 14
                    if (r1 != 0) goto Lf
                    boolean r1 = r13.changed(r12)
                    if (r1 == 0) goto Lc
                    r1 = 4
                    goto Ld
                Lc:
                    r1 = 2
                Ld:
                    r1 = r1 | r14
                    goto L10
                Lf:
                    r1 = r14
                L10:
                    r2 = r1 & 91
                    r3 = 18
                    if (r2 != r3) goto L22
                    boolean r2 = r13.getSkipping()
                    if (r2 != 0) goto L1d
                    goto L22
                L1d:
                    r13.skipToGroupEnd()
                    goto Ld1
                L22:
                    boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r2 == 0) goto L31
                    r2 = -1
                    java.lang.String r3 = "coil.compose.contentOf.<anonymous> (SubcomposeAsyncImage.kt:227)"
                    r4 = -1302781228(0xffffffffb25922d4, float:-1.2638981E-8)
                    androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
                L31:
                    coil.compose.AsyncImagePainter r2 = r12.getPainter()
                    coil.compose.AsyncImagePainter$State r2 = r2.getState()
                    boolean r3 = r2 instanceof coil.compose.AsyncImagePainter.State.Loading
                    r4 = 0
                    r5 = 1
                    if (r3 == 0) goto L5d
                    r3 = -418307549(0xffffffffe7112223, float:-6.8537285E23)
                    r13.startReplaceableGroup(r3)
                    kotlin.jvm.functions.Function4<coil.compose.SubcomposeAsyncImageScope, coil.compose.AsyncImagePainter$State$Loading, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r1
                    if (r3 == 0) goto L57
                    r5 = r1 & 14
                    r5 = r5 | 64
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                    r3.invoke(r12, r2, r13, r5)
                    kotlin.Unit r2 = kotlin.Unit.INSTANCE
                    goto L58
                L57:
                    r4 = r5
                L58:
                    r13.endReplaceableGroup()
                L5b:
                    r5 = r4
                    goto Lb6
                L5d:
                    boolean r3 = r2 instanceof coil.compose.AsyncImagePainter.State.Success
                    if (r3 == 0) goto L7e
                    r3 = -418307455(0xffffffffe7112281, float:-6.853796E23)
                    r13.startReplaceableGroup(r3)
                    kotlin.jvm.functions.Function4<coil.compose.SubcomposeAsyncImageScope, coil.compose.AsyncImagePainter$State$Success, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r2
                    if (r3 == 0) goto L79
                    r5 = r1 & 14
                    r5 = r5 | 64
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                    r3.invoke(r12, r2, r13, r5)
                    kotlin.Unit r2 = kotlin.Unit.INSTANCE
                    goto L7a
                L79:
                    r4 = r5
                L7a:
                    r13.endReplaceableGroup()
                    goto L5b
                L7e:
                    boolean r3 = r2 instanceof coil.compose.AsyncImagePainter.State.Error
                    if (r3 == 0) goto L9f
                    r3 = -418307363(0xffffffffe71122dd, float:-6.8538625E23)
                    r13.startReplaceableGroup(r3)
                    kotlin.jvm.functions.Function4<coil.compose.SubcomposeAsyncImageScope, coil.compose.AsyncImagePainter$State$Error, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r3
                    if (r3 == 0) goto L9a
                    r5 = r1 & 14
                    r5 = r5 | 64
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                    r3.invoke(r12, r2, r13, r5)
                    kotlin.Unit r2 = kotlin.Unit.INSTANCE
                    goto L9b
                L9a:
                    r4 = r5
                L9b:
                    r13.endReplaceableGroup()
                    goto L5b
                L9f:
                    boolean r2 = r2 instanceof coil.compose.AsyncImagePainter.State.Empty
                    if (r2 == 0) goto Lad
                    r2 = -418307275(0xffffffffe7112335, float:-6.853926E23)
                    r13.startReplaceableGroup(r2)
                    r13.endReplaceableGroup()
                    goto Lb6
                Lad:
                    r2 = -418307215(0xffffffffe7112371, float:-6.853969E23)
                    r13.startReplaceableGroup(r2)
                    r13.endReplaceableGroup()
                Lb6:
                    if (r5 == 0) goto Lc8
                    r9 = r1 & 14
                    r10 = 127(0x7f, float:1.78E-43)
                    r1 = 0
                    r2 = 0
                    r3 = 0
                    r4 = 0
                    r5 = 0
                    r6 = 0
                    r7 = 0
                    r0 = r12
                    r8 = r13
                    coil.compose.SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                Lc8:
                    boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r0 == 0) goto Ld1
                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                Ld1:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: coil.compose.SubcomposeAsyncImageKt.C08111.invoke(coil.compose.SubcomposeAsyncImageScope, androidx.compose.runtime.Composer, int):void");
            }
        });
    }
}
