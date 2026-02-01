package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Button.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017¢\u0006\u0002\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/compose/material/DefaultButtonElevation;", "Landroidx/compose/material/ButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "disabledElevation", "hoveredElevation", "focusedElevation", "(FFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "elevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultButtonElevation implements ButtonElevation {
    private final float defaultElevation;
    private final float disabledElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ DefaultButtonElevation(float f, float f2, float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5);
    }

    private DefaultButtonElevation(float f, float f2, float f3, float f4, float f5) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.disabledElevation = f3;
        this.hoveredElevation = f4;
        this.focusedElevation = f5;
    }

    @Override // androidx.compose.material.ButtonElevation
    public State<Dp> elevation(boolean z, InteractionSource interactionSource, Composer composer, int i) {
        float f;
        composer.startReplaceableGroup(-1588756907);
        ComposerKt.sourceInformation(composer, "C(elevation)505@20585L46,506@20640L1111,547@22200L51,549@22261L842:Button.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1588756907, i, -1, "androidx.compose.material.DefaultButtonElevation.elevation (Button.kt:504)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.mutableStateListOf();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
        composer.startReplaceableGroup(1621959150);
        boolean zChanged = composer.changed(interactionSource) | composer.changed(snapshotStateList);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new DefaultButtonElevation$elevation$1$1(interactionSource, snapshotStateList, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, ((i >> 3) & 14) | 64);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull((List) snapshotStateList);
        if (!z) {
            f = this.disabledElevation;
        } else if (interaction instanceof PressInteraction.Press) {
            f = this.pressedElevation;
        } else if (interaction instanceof HoverInteraction.Enter) {
            f = this.hoveredElevation;
        } else {
            f = interaction instanceof FocusInteraction.Focus ? this.focusedElevation : this.defaultElevation;
        }
        float f2 = f;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Animatable(Dp.m7253boximpl(f2), VectorConvertersKt.getVectorConverter(Dp.INSTANCE), null, null, 12, null);
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceableGroup();
        Animatable animatable = (Animatable) objRememberedValue3;
        EffectsKt.LaunchedEffect(Dp.m7253boximpl(f2), new AnonymousClass2(animatable, f2, z, this, interaction, null), composer, 64);
        State<Dp> stateAsState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateAsState;
    }

    /* compiled from: Button.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.DefaultButtonElevation$elevation$2", f = "Button.kt", i = {}, l = {554, 562}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.DefaultButtonElevation$elevation$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Interaction $interaction;
        final /* synthetic */ float $target;
        int label;
        final /* synthetic */ DefaultButtonElevation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Animatable<Dp, AnimationVector1D> animatable, float f, boolean z, DefaultButtonElevation defaultButtonElevation, Interaction interaction, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$animatable = animatable;
            this.$target = f;
            this.$enabled = z;
            this.this$0 = defaultButtonElevation;
            this.$interaction = interaction;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$animatable, this.$target, this.$enabled, this.this$0, this.$interaction, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!Dp.m7260equalsimpl0(this.$animatable.getTargetValue().m7269unboximpl(), this.$target)) {
                    if (!this.$enabled) {
                        this.label = 1;
                        if (this.$animatable.snapTo(Dp.m7253boximpl(this.$target), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        float fM7269unboximpl = this.$animatable.getTargetValue().m7269unboximpl();
                        FocusInteraction.Focus focus = null;
                        if (Dp.m7260equalsimpl0(fM7269unboximpl, this.this$0.pressedElevation)) {
                            focus = new PressInteraction.Press(Offset.INSTANCE.m4310getZeroF1C5BW0(), null);
                        } else if (Dp.m7260equalsimpl0(fM7269unboximpl, this.this$0.hoveredElevation)) {
                            focus = new HoverInteraction.Enter();
                        } else if (Dp.m7260equalsimpl0(fM7269unboximpl, this.this$0.focusedElevation)) {
                            focus = new FocusInteraction.Focus();
                        }
                        this.label = 2;
                        if (ElevationKt.m1861animateElevationrAjV9yQ(this.$animatable, this.$target, focus, this.$interaction, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
