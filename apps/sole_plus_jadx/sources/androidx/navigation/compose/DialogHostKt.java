package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.compose.DialogNavigator;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DialogHost.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a%\u0010\u0005\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0001¢\u0006\u0002\u0010\n\u001a!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u008a\u0084\u0002²\u0006\u0010\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012X\u008a\u0084\u0002"}, d2 = {"DialogHost", "", "dialogNavigator", "Landroidx/navigation/compose/DialogNavigator;", "(Landroidx/navigation/compose/DialogNavigator;Landroidx/compose/runtime/Composer;I)V", "PopulateVisibleList", "", "Landroidx/navigation/NavBackStackEntry;", "backStack", "", "(Ljava/util/List;Ljava/util/Collection;Landroidx/compose/runtime/Composer;I)V", "rememberVisibleList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "(Ljava/util/Collection;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "navigation-compose_release", "dialogBackStack", "", "transitionInProgress", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DialogHostKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogHost$lambda$7(DialogNavigator dialogNavigator, int i, Composer composer, int i2) {
        DialogHost(dialogNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopulateVisibleList$lambda$13(List list, Collection collection, int i, Composer composer, int i2) {
        PopulateVisibleList(list, collection, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DialogHost(final DialogNavigator dialogNavigator, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(294589392);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DialogHost)41@1668L29,42@1751L16,43@1795L36,44@1853L36,46@1960L16,47@2004L52,73@3243L294,73@3188L349:DialogHost.kt#opm8kd");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(dialogNavigator) ? 4 : 2) | i : i;
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(294589392, i2, -1, "androidx.navigation.compose.DialogHost (DialogHost.kt:40)");
            }
            SaveableStateHolder saveableStateHolderRememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(composerStartRestartGroup, 0);
            Continuation continuation = null;
            boolean z = true;
            State stateCollectAsState = SnapshotStateKt.collectAsState(dialogNavigator.getBackStack$navigation_compose_release(), null, composerStartRestartGroup, 0, 1);
            SnapshotStateList<NavBackStackEntry> snapshotStateListRememberVisibleList = rememberVisibleList(DialogHost$lambda$0(stateCollectAsState), composerStartRestartGroup, 0);
            PopulateVisibleList(snapshotStateListRememberVisibleList, DialogHost$lambda$0(stateCollectAsState), composerStartRestartGroup, 0);
            State stateCollectAsState2 = SnapshotStateKt.collectAsState(dialogNavigator.getTransitionInProgress$navigation_compose_release(), null, composerStartRestartGroup, 0, 1);
            String str = "CC(remember):DialogHost.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -367421820, "CC(remember):DialogHost.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.startReplaceGroup(-367418626);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*52@2222L43,54@2331L588,51@2183L736");
            for (final NavBackStackEntry navBackStackEntry : snapshotStateListRememberVisibleList) {
                NavDestination destination = navBackStackEntry.getDestination();
                Intrinsics.checkNotNull(destination, "null cannot be cast to non-null type androidx.navigation.compose.DialogNavigator.Destination");
                DialogNavigator.Destination destination2 = (DialogNavigator.Destination) destination;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1507839234, str);
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(dialogNavigator) | composerStartRestartGroup.changedInstance(navBackStackEntry);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: androidx.navigation.compose.DialogHostKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DialogHostKt.DialogHost$lambda$5$lambda$4$lambda$3(dialogNavigator, navBackStackEntry);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidDialog_androidKt.Dialog((Function0) objRememberedValue2, destination2.getDialogProperties(), ComposableLambdaKt.rememberComposableLambda(1129586364, z, new DialogHostKt$DialogHost$1$2(navBackStackEntry, dialogNavigator, saveableStateHolderRememberSaveableStateHolder, snapshotStateList, destination2), composerStartRestartGroup, 54), composerStartRestartGroup, 384, 0);
                stateCollectAsState2 = stateCollectAsState2;
                continuation = null;
                snapshotStateList = snapshotStateList;
                str = str;
                z = z;
            }
            SnapshotStateList snapshotStateList2 = snapshotStateList;
            State state = stateCollectAsState2;
            Continuation continuation2 = continuation;
            composerStartRestartGroup.endReplaceGroup();
            Set<NavBackStackEntry> setDialogHost$lambda$1 = DialogHost$lambda$1(state);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -367381930, str);
            boolean zChanged = composerStartRestartGroup.changed(state) | composerStartRestartGroup.changedInstance(dialogNavigator);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (Function2) new DialogHostKt$DialogHost$2$1(state, dialogNavigator, snapshotStateList2, continuation2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(setDialogHost$lambda$1, snapshotStateList2, (Function2) objRememberedValue3, composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.DialogHostKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DialogHostKt.DialogHost$lambda$7(dialogNavigator, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogHost$lambda$5$lambda$4$lambda$3(DialogNavigator dialogNavigator, NavBackStackEntry navBackStackEntry) {
        dialogNavigator.dismiss$navigation_compose_release(navBackStackEntry);
        return Unit.INSTANCE;
    }

    public static final void PopulateVisibleList(final List<NavBackStackEntry> list, final Collection<NavBackStackEntry> collection, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1537894851);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PopulateVisibleList)89@3710L7,*91@3793L961,91@3759L995:DialogHost.kt#opm8kd");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(collection) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1537894851, i2, -1, "androidx.navigation.compose.PopulateVisibleList (DialogHost.kt:88)");
            }
            ProvidableCompositionLocal<Boolean> localInspectionMode = InspectionModeKt.getLocalInspectionMode();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localInspectionMode);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final boolean zBooleanValue = ((Boolean) objConsume).booleanValue();
            for (final NavBackStackEntry navBackStackEntry : collection) {
                Lifecycle lifecycle = navBackStackEntry.getLifecycle();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -869061753, "CC(remember):DialogHost.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(zBooleanValue) | composerStartRestartGroup.changedInstance(list) | composerStartRestartGroup.changedInstance(navBackStackEntry);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.navigation.compose.DialogHostKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DialogHostKt.PopulateVisibleList$lambda$12$lambda$11$lambda$10(navBackStackEntry, zBooleanValue, list, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(lifecycle, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.DialogHostKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DialogHostKt.PopulateVisibleList$lambda$13(list, collection, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult PopulateVisibleList$lambda$12$lambda$11$lambda$10(final NavBackStackEntry navBackStackEntry, final boolean z, final List list, DisposableEffectScope disposableEffectScope) {
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.navigation.compose.DialogHostKt$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                DialogHostKt.PopulateVisibleList$lambda$12$lambda$11$lambda$10$lambda$8(z, list, navBackStackEntry, lifecycleOwner, event);
            }
        };
        navBackStackEntry.getLifecycle().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: androidx.navigation.compose.DialogHostKt$PopulateVisibleList$lambda$12$lambda$11$lambda$10$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                navBackStackEntry.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PopulateVisibleList$lambda$12$lambda$11$lambda$10$lambda$8(boolean z, List list, NavBackStackEntry navBackStackEntry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (z && !list.contains(navBackStackEntry)) {
            list.add(navBackStackEntry);
        }
        if (event == Lifecycle.Event.ON_START && !list.contains(navBackStackEntry)) {
            list.add(navBackStackEntry);
        }
        if (event == Lifecycle.Event.ON_STOP) {
            list.remove(navBackStackEntry);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.runtime.snapshots.SnapshotStateList<androidx.navigation.NavBackStackEntry> rememberVisibleList(java.util.Collection<androidx.navigation.NavBackStackEntry> r5, androidx.compose.runtime.Composer r6, int r7) {
        /*
            java.lang.String r0 = "C(rememberVisibleList)121@4970L7,122@4989L399:DialogHost.kt#opm8kd"
            r1 = 467378629(0x1bdba1c5, float:3.6335052E-22)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r1, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L14
            r0 = -1
            java.lang.String r2 = "androidx.navigation.compose.rememberVisibleList (DialogHost.kt:119)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r7, r0, r2)
        L14:
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.InspectionModeKt.getLocalInspectionMode()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r1 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r1)
            java.lang.Object r7 = r6.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r0 = -1820696012(0xffffffff937a6234, float:-3.1602854E-27)
            java.lang.String r1 = "CC(remember):DialogHost.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r0, r1)
            boolean r0 = r6.changed(r5)
            java.lang.Object r1 = r6.rememberedValue()
            if (r0 != 0) goto L49
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.INSTANCE
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L89
        L49:
            androidx.compose.runtime.snapshots.SnapshotStateList r1 = androidx.compose.runtime.SnapshotStateKt.mutableStateListOf()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r5 = r5.iterator()
        L5a:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L7f
            java.lang.Object r2 = r5.next()
            r3 = r2
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            if (r7 == 0) goto L6b
            r3 = 1
            goto L79
        L6b:
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycle()
            androidx.lifecycle.Lifecycle$State r3 = r3.getState()
            androidx.lifecycle.Lifecycle$State r4 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r3 = r3.isAtLeast(r4)
        L79:
            if (r3 == 0) goto L5a
            r0.add(r2)
            goto L5a
        L7f:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            r1.addAll(r0)
            r6.updateRememberedValue(r1)
        L89:
            androidx.compose.runtime.snapshots.SnapshotStateList r1 = (androidx.compose.runtime.snapshots.SnapshotStateList) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L97
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L97:
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.DialogHostKt.rememberVisibleList(java.util.Collection, androidx.compose.runtime.Composer, int):androidx.compose.runtime.snapshots.SnapshotStateList");
    }

    private static final List<NavBackStackEntry> DialogHost$lambda$0(State<? extends List<NavBackStackEntry>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set<NavBackStackEntry> DialogHost$lambda$1(State<? extends Set<NavBackStackEntry>> state) {
        return state.getValue();
    }
}
