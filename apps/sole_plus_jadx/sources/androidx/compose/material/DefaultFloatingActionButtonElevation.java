package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import no.nordicsemi.android.ble.data.Data;

/* compiled from: FloatingActionButton.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/DefaultFloatingActionButtonElevation;", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "hoveredElevation", "focusedElevation", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "elevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "", "other", "", "hashCode", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultFloatingActionButtonElevation implements FloatingActionButtonElevation {
    private final float defaultElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ DefaultFloatingActionButtonElevation(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private DefaultFloatingActionButtonElevation(float f, float f2, float f3, float f4) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.hoveredElevation = f3;
        this.focusedElevation = f4;
    }

    @Override // androidx.compose.material.FloatingActionButtonElevation
    public State<Dp> elevation(InteractionSource interactionSource, Composer composer, int i) {
        composer.startReplaceableGroup(-478475335);
        ComposerKt.sourceInformation(composer, "C(elevation)270@11429L317,279@11756L297,288@12063L1352:FloatingActionButton.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-478475335, i, -1, "androidx.compose.material.DefaultFloatingActionButtonElevation.elevation (FloatingActionButton.kt:269)");
        }
        int i2 = i & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(interactionSource);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new FloatingActionButtonElevationAnimatable(this.defaultElevation, this.pressedElevation, this.hoveredElevation, this.focusedElevation, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable = (FloatingActionButtonElevationAnimatable) objRememberedValue;
        EffectsKt.LaunchedEffect(this, new AnonymousClass1(floatingActionButtonElevationAnimatable, this, null), composer, ((i >> 3) & 14) | 64);
        EffectsKt.LaunchedEffect(interactionSource, new AnonymousClass2(interactionSource, floatingActionButtonElevationAnimatable, null), composer, i2 | 64);
        State<Dp> stateAsState = floatingActionButtonElevationAnimatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateAsState;
    }

    /* compiled from: FloatingActionButton.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$1", f = "FloatingActionButton.kt", i = {}, l = {281}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FloatingActionButtonElevationAnimatable $animatable;
        int label;
        final /* synthetic */ DefaultFloatingActionButtonElevation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable, DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$animatable = floatingActionButtonElevationAnimatable;
            this.this$0 = defaultFloatingActionButtonElevation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$animatable, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$animatable.m1884updateElevationlDy3nrA(this.this$0.defaultElevation, this.this$0.pressedElevation, this.this$0.hoveredElevation, this.this$0.focusedElevation, this) == coroutine_suspended) {
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

    /* compiled from: FloatingActionButton.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2", f = "FloatingActionButton.kt", i = {}, l = {Data.FORMAT_SINT24_BE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FloatingActionButtonElevationAnimatable $animatable;
        final /* synthetic */ InteractionSource $interactionSource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(InteractionSource interactionSource, FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$interactionSource = interactionSource;
            this.$animatable = floatingActionButtonElevationAnimatable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$interactionSource, this.$animatable, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
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
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                final ArrayList arrayList = new ArrayList();
                Flow<Interaction> interactions = this.$interactionSource.getInteractions();
                final FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable = this.$animatable;
                this.label = 1;
                if (interactions.collect(new FlowCollector() { // from class: androidx.compose.material.DefaultFloatingActionButtonElevation.elevation.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Interaction) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
                        if (interaction instanceof HoverInteraction.Enter) {
                            arrayList.add(interaction);
                        } else if (interaction instanceof HoverInteraction.Exit) {
                            arrayList.remove(((HoverInteraction.Exit) interaction).getEnter());
                        } else if (interaction instanceof FocusInteraction.Focus) {
                            arrayList.add(interaction);
                        } else if (interaction instanceof FocusInteraction.Unfocus) {
                            arrayList.remove(((FocusInteraction.Unfocus) interaction).getFocus());
                        } else if (interaction instanceof PressInteraction.Press) {
                            arrayList.add(interaction);
                        } else if (interaction instanceof PressInteraction.Release) {
                            arrayList.remove(((PressInteraction.Release) interaction).getPress());
                        } else if (interaction instanceof PressInteraction.Cancel) {
                            arrayList.remove(((PressInteraction.Cancel) interaction).getPress());
                        }
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00771(floatingActionButtonElevationAnimatable, (Interaction) CollectionsKt.lastOrNull((List) arrayList), null), 3, null);
                        return Unit.INSTANCE;
                    }

                    /* compiled from: FloatingActionButton.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2$1$1", f = "FloatingActionButton.kt", i = {}, l = {317}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C00771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ FloatingActionButtonElevationAnimatable $animatable;
                        final /* synthetic */ Interaction $targetInteraction;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00771(FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable, Interaction interaction, Continuation<? super C00771> continuation) {
                            super(2, continuation);
                            this.$animatable = floatingActionButtonElevationAnimatable;
                            this.$targetInteraction = interaction;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C00771(this.$animatable, this.$targetInteraction, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C00771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$animatable.animateElevation(this.$targetInteraction, this) == coroutine_suspended) {
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
                }, this) == coroutine_suspended) {
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

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DefaultFloatingActionButtonElevation)) {
            return false;
        }
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = (DefaultFloatingActionButtonElevation) other;
        if (Dp.m7260equalsimpl0(this.defaultElevation, defaultFloatingActionButtonElevation.defaultElevation) && Dp.m7260equalsimpl0(this.pressedElevation, defaultFloatingActionButtonElevation.pressedElevation) && Dp.m7260equalsimpl0(this.hoveredElevation, defaultFloatingActionButtonElevation.hoveredElevation)) {
            return Dp.m7260equalsimpl0(this.focusedElevation, defaultFloatingActionButtonElevation.focusedElevation);
        }
        return false;
    }

    public int hashCode() {
        return (((((Dp.m7261hashCodeimpl(this.defaultElevation) * 31) + Dp.m7261hashCodeimpl(this.pressedElevation)) * 31) + Dp.m7261hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m7261hashCodeimpl(this.focusedElevation);
    }
}
