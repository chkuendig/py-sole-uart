package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.android.ddmlib.testrunner.IInstrumentationResultParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: BackHandler.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Landroidx/activity/compose/LocalOnBackPressedDispatcherOwner;", "", "()V", "LocalOnBackPressedDispatcherOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/activity/OnBackPressedDispatcherOwner;", IInstrumentationResultParser.StatusKeys.CURRENT, "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/OnBackPressedDispatcherOwner;", "provides", "Landroidx/compose/runtime/ProvidedValue;", "dispatcherOwner", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LocalOnBackPressedDispatcherOwner {
    public static final int $stable = 0;
    public static final LocalOnBackPressedDispatcherOwner INSTANCE = new LocalOnBackPressedDispatcherOwner();
    private static final ProvidableCompositionLocal<OnBackPressedDispatcherOwner> LocalOnBackPressedDispatcherOwner = CompositionLocalKt.compositionLocalOf$default(null, new Function0<OnBackPressedDispatcherOwner>() { // from class: androidx.activity.compose.LocalOnBackPressedDispatcherOwner$LocalOnBackPressedDispatcherOwner$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final OnBackPressedDispatcherOwner invoke() {
            return null;
        }
    }, 1, null);

    private LocalOnBackPressedDispatcherOwner() {
    }

    public final OnBackPressedDispatcherOwner getCurrent(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2068013981, "C(<get-current>)50@2099L7:BackHandler.kt#q1dkbc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2068013981, i, -1, "androidx.activity.compose.LocalOnBackPressedDispatcherOwner.<get-current> (BackHandler.kt:50)");
        }
        ProvidableCompositionLocal<OnBackPressedDispatcherOwner> providableCompositionLocal = LocalOnBackPressedDispatcherOwner;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) objConsume;
        if (onBackPressedDispatcherOwner == null) {
            composer.startReplaceGroup(544166745);
            ComposerKt.sourceInformation(composer, "51@2136L7");
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composer);
            onBackPressedDispatcherOwner = ViewTreeOnBackPressedDispatcherOwner.get((View) objConsume2);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(544164296);
            composer.endReplaceGroup();
        }
        if (onBackPressedDispatcherOwner == null) {
            composer.startReplaceGroup(544168748);
            ComposerKt.sourceInformation(composer, "*52@2259L7");
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composer.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Object baseContext = (Context) objConsume3;
            while (true) {
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = null;
                    break;
                }
                if (baseContext instanceof OnBackPressedDispatcherOwner) {
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
            onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) baseContext;
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(544164377);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return onBackPressedDispatcherOwner;
    }

    public final ProvidedValue<OnBackPressedDispatcherOwner> provides(OnBackPressedDispatcherOwner dispatcherOwner) {
        return LocalOnBackPressedDispatcherOwner.provides(dispatcherOwner);
    }
}
