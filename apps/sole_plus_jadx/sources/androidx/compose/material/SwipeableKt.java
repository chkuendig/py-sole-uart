package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import com.sun.jna.platform.win32.WinError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Swipeable.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002\u001a$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00152\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0002\u001aZ\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0005\"\b\b\u0000\u0010\u0004*\u00020\u00172\u0006\u0010\u0018\u001a\u0002H\u00042\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a2#\b\u0002\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u001cH\u0007¢\u0006\u0002\u0010!\u001aI\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0005\"\b\b\u0000\u0010\u0004*\u00020\u00172\u0006\u0010#\u001a\u0002H\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020%0\u001c2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0001¢\u0006\u0002\u0010&\u001a-\u0010'\u001a\u0004\u0018\u00010\u000b\"\u0004\b\u0000\u0010\u0004*\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00040(2\u0006\u0010)\u001a\u0002H\u0004H\u0002¢\u0006\u0002\u0010*\u001a¶\u0001\u0010+\u001a\u00020,\"\u0004\b\u0000\u0010\u0004*\u00020,2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00040(2\u0006\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020 2\b\b\u0002\u00100\u001a\u00020 2\n\b\u0002\u00101\u001a\u0004\u0018\u00010228\b\u0002\u0010\u0010\u001a2\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(3\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002050\u00112\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\b\b\u0002\u0010\u0013\u001a\u000208H\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010:\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"*\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00058@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, d2 = {"SwipeableDeprecation", "", "PreUpPostDownNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/material/SwipeableState;", "getPreUpPostDownNestedScrollConnection$annotations", "(Landroidx/compose/material/SwipeableState;)V", "getPreUpPostDownNestedScrollConnection", "(Landroidx/compose/material/SwipeableState;)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "computeTarget", "", "offset", "lastValue", "anchors", "", "thresholds", "Lkotlin/Function2;", "velocity", "velocityThreshold", "findBounds", "", "rememberSwipeableState", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "rememberSwipeableStateFor", "value", "onValueChange", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "getOffset", "", ServerProtocol.DIALOG_PARAM_STATE, "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Float;", "swipeable", "Landroidx/compose/ui/Modifier;", SdkConstants.ATTR_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "from", "to", "Landroidx/compose/material/ThresholdConfig;", "resistance", "Landroidx/compose/material/ResistanceConfig;", "Landroidx/compose/ui/unit/Dp;", "swipeable-pPrIpRY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SwipeableState;Ljava/util/Map;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/ResistanceConfig;F)Landroidx/compose/ui/Modifier;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwipeableKt {
    private static final String SwipeableDeprecation = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.";

    public static final /* synthetic */ Float access$getOffset(Map map, Object obj) {
        return getOffset(map, obj);
    }

    public static /* synthetic */ void getPreUpPostDownNestedScrollConnection$annotations(SwipeableState swipeableState) {
    }

    @Deprecated(message = SwipeableDeprecation)
    public static final <T> SwipeableState<T> rememberSwipeableState(final T t, final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1237755169);
        ComposerKt.sourceInformation(composer, "C(rememberSwipeableState)P(2)479@19455L344:Swipeable.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<T, Boolean>() { // from class: androidx.compose.material.SwipeableKt.rememberSwipeableState.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T t2) {
                    return true;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                    return invoke((AnonymousClass1<T>) obj);
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1237755169, i, -1, "androidx.compose.material.rememberSwipeableState (Swipeable.kt:478)");
        }
        SwipeableState<T> swipeableState = (SwipeableState) RememberSaveableKt.m3983rememberSaveable(new Object[0], (Saver) SwipeableState.INSTANCE.Saver(animationSpec, function1), (String) null, (Function0) new Function0<SwipeableState<T>>() { // from class: androidx.compose.material.SwipeableKt.rememberSwipeableState.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SwipeableState<T> invoke() {
                return new SwipeableState<>(t, animationSpec, function1);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return swipeableState;
    }

    @Deprecated(message = SwipeableDeprecation)
    public static final <T> SwipeableState<T> rememberSwipeableStateFor(final T t, final Function1<? super T, Unit> function1, AnimationSpec<Float> animationSpec, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1156387078);
        ComposerKt.sourceInformation(composer, "C(rememberSwipeableStateFor)P(2,1)509@20656L169,516@20856L34,517@20895L162,522@21062L259:Swipeable.kt#jmzs0o");
        if ((i2 & 4) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1156387078, i, -1, "androidx.compose.material.rememberSwipeableStateFor (Swipeable.kt:508)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SwipeableState(t, animationSpec, new Function1<T, Boolean>() { // from class: androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T t2) {
                    return true;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                    return invoke((SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1<T>) obj);
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        final SwipeableState<T> swipeableState = (SwipeableState) objRememberedValue;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) objRememberedValue2;
        int i3 = i & 8;
        EffectsKt.LaunchedEffect(t, mutableState.getValue(), new C05441(t, swipeableState, null), composer, (i & 14) | i3 | 512);
        EffectsKt.DisposableEffect(swipeableState.getCurrentValue(), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material.SwipeableKt.rememberSwipeableStateFor.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                if (!Intrinsics.areEqual(t, swipeableState.getCurrentValue())) {
                    function1.invoke(swipeableState.getCurrentValue());
                    mutableState.setValue(Boolean.valueOf(!r2.getValue().booleanValue()));
                }
                return new DisposableEffectResult() { // from class: androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }
        }, composer, i3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return swipeableState;
    }

    /* compiled from: Swipeable.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$1", f = "Swipeable.kt", i = {}, l = {520}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$1, reason: invalid class name and case insensitive filesystem */
    static final class C05441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SwipeableState<T> $swipeableState;
        final /* synthetic */ T $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05441(T t, SwipeableState<T> swipeableState, Continuation<? super C05441> continuation) {
            super(2, continuation);
            this.$value = t;
            this.$swipeableState = swipeableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05441(this.$value, this.$swipeableState, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!Intrinsics.areEqual(this.$value, this.$swipeableState.getCurrentValue())) {
                    this.label = 1;
                    if (SwipeableState.animateTo$default(this.$swipeableState, this.$value, null, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.lang.Object] */
    public static final List<Float> findBounds(float f, Set<Float> set) {
        Object obj;
        Set<Float> set2 = set;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : set2) {
            if (((Number) obj2).floatValue() <= f + 0.001d) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        Float f2 = null;
        if (arrayList2.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList2.get(0);
            float fFloatValue = ((Number) obj).floatValue();
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex) {
                int i = 1;
                while (true) {
                    Object obj3 = arrayList2.get(i);
                    float fFloatValue2 = ((Number) obj3).floatValue();
                    if (Float.compare(fFloatValue, fFloatValue2) < 0) {
                        obj = obj3;
                        fFloatValue = fFloatValue2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        Float f3 = (Float) obj;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj4 : set2) {
            if (((Number) obj4).floatValue() >= f - 0.001d) {
                arrayList3.add(obj4);
            }
        }
        ArrayList arrayList4 = arrayList3;
        if (!arrayList4.isEmpty()) {
            ?? r13 = arrayList4.get(0);
            float fFloatValue3 = ((Number) r13).floatValue();
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex2) {
                int i2 = 1;
                boolean z = r13;
                while (true) {
                    Object obj5 = arrayList4.get(i2);
                    float fFloatValue4 = ((Number) obj5).floatValue();
                    r13 = z;
                    if (Float.compare(fFloatValue3, fFloatValue4) > 0) {
                        r13 = obj5;
                        fFloatValue3 = fFloatValue4;
                    }
                    if (i2 == lastIndex2) {
                        break;
                    }
                    i2++;
                    z = r13;
                }
            }
            f2 = r13;
        }
        Float f4 = f2;
        if (f3 == null) {
            return CollectionsKt.listOfNotNull(f4);
        }
        if (f4 == null) {
            return CollectionsKt.listOf(f3);
        }
        return Intrinsics.areEqual(f3, f4) ? CollectionsKt.listOf(f3) : CollectionsKt.listOf((Object[]) new Float[]{f3, f4});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
    
        if (r3 < r6.invoke(java.lang.Float.valueOf(r0), java.lang.Float.valueOf(r5)).floatValue()) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
    
        if (r3 > r6.invoke(java.lang.Float.valueOf(r5), java.lang.Float.valueOf(r0)).floatValue()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final float computeTarget(float r3, float r4, java.util.Set<java.lang.Float> r5, kotlin.jvm.functions.Function2<? super java.lang.Float, ? super java.lang.Float, java.lang.Float> r6, float r7, float r8) {
        /*
            java.util.List r5 = findBounds(r3, r5)
            int r0 = r5.size()
            if (r0 == 0) goto L6c
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L62
            java.lang.Object r0 = r5.get(r1)
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            java.lang.Object r5 = r5.get(r2)
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 > 0) goto L42
            int r4 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r4 < 0) goto L2b
            return r5
        L2b:
            java.lang.Float r4 = java.lang.Float.valueOf(r0)
            java.lang.Float r7 = java.lang.Float.valueOf(r5)
            java.lang.Object r4 = r6.invoke(r4, r7)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L5e
            goto L60
        L42:
            float r4 = -r8
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 > 0) goto L48
            return r0
        L48:
            java.lang.Float r4 = java.lang.Float.valueOf(r5)
            java.lang.Float r7 = java.lang.Float.valueOf(r0)
            java.lang.Object r4 = r6.invoke(r4, r7)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L60
        L5e:
            r4 = r5
            goto L6c
        L60:
            r4 = r0
            goto L6c
        L62:
            java.lang.Object r3 = r5.get(r1)
            java.lang.Number r3 = (java.lang.Number) r3
            float r4 = r3.floatValue()
        L6c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableKt.computeTarget(float, float, java.util.Set, kotlin.jvm.functions.Function2, float, float):float");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float getOffset(Map<Float, ? extends T> map, T t) {
        T next;
        Iterator<T> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((Map.Entry) next).getValue(), t)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (Float) entry.getKey();
        }
        return null;
    }

    public static final <T> NestedScrollConnection getPreUpPostDownNestedScrollConnection(SwipeableState<T> swipeableState) {
        return new SwipeableKt$PreUpPostDownNestedScrollConnection$1(swipeableState);
    }

    @Deprecated(message = SwipeableDeprecation)
    /* renamed from: swipeable-pPrIpRY, reason: not valid java name */
    public static final <T> Modifier m1988swipeablepPrIpRY(Modifier modifier, final SwipeableState<T> swipeableState, final Map<Float, ? extends T> map, final Orientation orientation, final boolean z, final boolean z2, final MutableInteractionSource mutableInteractionSource, final Function2<? super T, ? super T, ? extends ThresholdConfig> function2, final ResistanceConfig resistanceConfig, final float f) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("swipeable");
                inspectorInfo.getProperties().set(ServerProtocol.DIALOG_PARAM_STATE, swipeableState);
                inspectorInfo.getProperties().set("anchors", map);
                inspectorInfo.getProperties().set(SdkConstants.ATTR_ORIENTATION, orientation);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(z2));
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set("thresholds", function2);
                inspectorInfo.getProperties().set("resistance", resistanceConfig);
                inspectorInfo.getProperties().set("velocityThreshold", Dp.m7253boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.SwipeableKt$swipeable$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceableGroup(43594985);
                ComposerKt.sourceInformation(composer, "C601@25124L7,603@25166L502:Swipeable.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(43594985, i, -1, "androidx.compose.material.swipeable.<anonymous> (Swipeable.kt:595)");
                }
                if (map.isEmpty()) {
                    throw new IllegalArgumentException("You must have at least one anchor.".toString());
                }
                if (CollectionsKt.distinct(map.values()).size() != map.size()) {
                    throw new IllegalArgumentException("You cannot have two anchors mapped to the same state.".toString());
                }
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composer.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composer);
                swipeableState.ensureInit$material_release(map);
                EffectsKt.LaunchedEffect(map, swipeableState, new AnonymousClass3(swipeableState, map, resistanceConfig, (Density) objConsume, function2, f, null), composer, 520);
                Modifier.Companion companion = Modifier.INSTANCE;
                boolean zIsAnimationRunning = swipeableState.isAnimationRunning();
                DraggableState draggableState = swipeableState.getDraggableState();
                Modifier.Companion companion2 = companion;
                Orientation orientation2 = orientation;
                boolean z3 = z;
                MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                composer.startReplaceableGroup(-699667755);
                boolean zChanged = composer.changed(swipeableState);
                SwipeableState<T> swipeableState2 = swipeableState;
                SwipeableKt$swipeable$3$4$1 swipeableKt$swipeable$3$4$1RememberedValue = composer.rememberedValue();
                if (zChanged || swipeableKt$swipeable$3$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    swipeableKt$swipeable$3$4$1RememberedValue = new SwipeableKt$swipeable$3$4$1(swipeableState2, null);
                    composer.updateRememberedValue(swipeableKt$swipeable$3$4$1RememberedValue);
                }
                composer.endReplaceableGroup();
                Modifier modifierDraggable = DraggableKt.draggable(companion2, draggableState, orientation2, (188 & 4) != 0 ? true : z3, (188 & 8) != 0 ? null : mutableInteractionSource2, (188 & 16) != 0 ? false : zIsAnimationRunning, (188 & 32) != 0 ? DraggableKt.NoOpOnDragStarted : null, (188 & 64) != 0 ? DraggableKt.NoOpOnDragStopped : (Function3) swipeableKt$swipeable$3$4$1RememberedValue, (188 & 128) != 0 ? false : z2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return modifierDraggable;
            }

            /* compiled from: Swipeable.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material.SwipeableKt$swipeable$3$3", f = "Swipeable.kt", i = {}, l = {WinError.ERROR_PWD_TOO_RECENT}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material.SwipeableKt$swipeable$3$3, reason: invalid class name */
            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Map<Float, T> $anchors;
                final /* synthetic */ Density $density;
                final /* synthetic */ ResistanceConfig $resistance;
                final /* synthetic */ SwipeableState<T> $state;
                final /* synthetic */ Function2<T, T, ThresholdConfig> $thresholds;
                final /* synthetic */ float $velocityThreshold;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass3(SwipeableState<T> swipeableState, Map<Float, ? extends T> map, ResistanceConfig resistanceConfig, Density density, Function2<? super T, ? super T, ? extends ThresholdConfig> function2, float f, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.$state = swipeableState;
                    this.$anchors = map;
                    this.$resistance = resistanceConfig;
                    this.$density = density;
                    this.$thresholds = function2;
                    this.$velocityThreshold = f;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.$state, this.$anchors, this.$resistance, this.$density, this.$thresholds, this.$velocityThreshold, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Map anchors$material_release = this.$state.getAnchors$material_release();
                        this.$state.setAnchors$material_release(this.$anchors);
                        this.$state.setResistance$material_release(this.$resistance);
                        SwipeableState<T> swipeableState = this.$state;
                        final Map<Float, T> map = this.$anchors;
                        final Function2<T, T, ThresholdConfig> function2 = this.$thresholds;
                        final Density density = this.$density;
                        swipeableState.setThresholds$material_release(new Function2<Float, Float, Float>() { // from class: androidx.compose.material.SwipeableKt.swipeable.3.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Float invoke(Float f, Float f2) {
                                return invoke(f.floatValue(), f2.floatValue());
                            }

                            public final Float invoke(float f, float f2) {
                                return Float.valueOf(function2.invoke(MapsKt.getValue(map, Float.valueOf(f)), MapsKt.getValue(map, Float.valueOf(f2))).computeThreshold(density, f, f2));
                            }
                        });
                        this.$state.setVelocityThreshold$material_release(this.$density.mo677toPx0680j_4(this.$velocityThreshold));
                        this.label = 1;
                        if (this.$state.processNewAnchors$material_release(anchors$material_release, this.$anchors, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        });
    }
}
