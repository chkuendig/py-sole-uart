package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.internal.WeakReference;
import androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: NavBackStackEntryProvider.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001a$\u0010\t\u001a\u00020\u0001*\u00020\u00042\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"LocalOwnersProvider", "", "Landroidx/navigation/NavBackStackEntry;", "saveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/navigation/NavBackStackEntry;Landroidx/compose/runtime/saveable/SaveableStateHolder;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SaveableStateProvider", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "navigation-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavBackStackEntryProviderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LocalOwnersProvider$lambda$0(NavBackStackEntry navBackStackEntry, SaveableStateHolder saveableStateHolder, Function2 function2, int i, Composer composer, int i2) {
        LocalOwnersProvider(navBackStackEntry, saveableStateHolder, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveableStateProvider$lambda$3(SaveableStateHolder saveableStateHolder, Function2 function2, int i, Composer composer, int i2) {
        SaveableStateProvider(saveableStateHolder, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void LocalOwnersProvider(final NavBackStackEntry navBackStackEntry, final SaveableStateHolder saveableStateHolder, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(233973821);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LocalOwnersProvider)P(1)54@2248L66,50@2074L240:NavBackStackEntryProvider.kt#opm8kd");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(navBackStackEntry) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(saveableStateHolder) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(233973821, i2, -1, "androidx.navigation.compose.LocalOwnersProvider (NavBackStackEntryProvider.kt:49)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalViewModelStoreOwner.INSTANCE.provides(navBackStackEntry), LocalLifecycleOwnerKt.getLocalLifecycleOwner().provides(navBackStackEntry), LocalSavedStateRegistryOwnerKt.getLocalSavedStateRegistryOwner().provides(navBackStackEntry)}, ComposableLambdaKt.rememberComposableLambda(1808964477, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavBackStackEntryProviderKt.LocalOwnersProvider.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C55@2278L30:NavBackStackEntryProvider.kt#opm8kd");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1808964477, i3, -1, "androidx.navigation.compose.LocalOwnersProvider.<anonymous> (NavBackStackEntryProvider.kt:55)");
                    }
                    NavBackStackEntryProviderKt.SaveableStateProvider(saveableStateHolder, function2, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavBackStackEntryProviderKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavBackStackEntryProviderKt.LocalOwnersProvider$lambda$0(navBackStackEntry, saveableStateHolder, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SaveableStateProvider(final SaveableStateHolder saveableStateHolder, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Composer composerStartRestartGroup = composer.startRestartGroup(832919318);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SaveableStateProvider)61@2449L55,61@2439L65,68@2979L44:NavBackStackEntryProvider.kt#opm8kd");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(saveableStateHolder) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(832919318, i3, -1, "androidx.navigation.compose.SaveableStateProvider (NavBackStackEntryProvider.kt:60)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1571551789, "CC(remember):NavBackStackEntryProvider.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.navigation.compose.NavBackStackEntryProviderKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavBackStackEntryProviderKt.SaveableStateProvider$lambda$2$lambda$1((CreationExtras) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 419377738, "CC(viewModel)P(2,1)127@5933L7,133@6121L328:ViewModel.kt#3tja67");
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BackStackEntryIdViewModel.class);
            InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
            initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(BackStackEntryIdViewModel.class), function1);
            ViewModelProvider.Factory factoryBuild = initializerViewModelFactoryBuilder.build();
            if (current instanceof HasDefaultViewModelProviderFactory) {
                defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
            } else {
                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) orCreateKotlinClass, current, (String) null, factoryBuild, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackStackEntryIdViewModel backStackEntryIdViewModel = (BackStackEntryIdViewModel) viewModel;
            backStackEntryIdViewModel.setSaveableStateHolderRef(new WeakReference<>(saveableStateHolder));
            saveableStateHolder.SaveableStateProvider(backStackEntryIdViewModel.getId(), function2, composerStartRestartGroup, (i3 & 112) | ((i3 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.navigation.compose.NavBackStackEntryProviderKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavBackStackEntryProviderKt.SaveableStateProvider$lambda$3(saveableStateHolder, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackStackEntryIdViewModel SaveableStateProvider$lambda$2$lambda$1(CreationExtras creationExtras) {
        return new BackStackEntryIdViewModel(SavedStateHandleSupport.createSavedStateHandle(creationExtras));
    }
}
