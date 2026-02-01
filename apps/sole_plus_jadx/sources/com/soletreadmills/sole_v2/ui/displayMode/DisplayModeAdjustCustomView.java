package com.soletreadmills.sole_v2.ui.displayMode;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import com.android.SdkConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._extension.ContextExtensionKt;
import com.soletreadmills.sole_v2.ble.cmd.FitnessMachineControlHelper;
import com.soletreadmills.sole_v2.ble.data.CrossTrainerData;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.IndoorBikeData;
import com.soletreadmills.sole_v2.ble.data.RowerData;
import com.soletreadmills.sole_v2.ble.data.StepClimberData;
import com.soletreadmills.sole_v2.ble.data.TreadmillData;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.databinding.BottomSheetDisplayModeAdjustBinding;
import com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import timber.log.Timber;

/* compiled from: DisplayModeAdjustCustomView.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u001fH\u0016J\u001a\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010(\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeAdjustCustomView;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseBottomSheetDialogFragment;", "Lcom/soletreadmills/sole_v2/databinding/BottomSheetDisplayModeAdjustBinding;", "()V", "config", "Lcom/soletreadmills/sole_v2/ble/cmd/FitnessMachineControlHelper$AdjustConfig;", "isMetric", "", "()Z", "setMetric", "(Z)V", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "getMachineType", "()Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "setMachineType", "(Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;)V", DisplayModeAdjustCustomView.ARG_POSITION, "Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeAdjustCustomView$Position;", "getPosition", "()Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeAdjustCustomView$Position;", "setPosition", "(Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeAdjustCustomView$Position;)V", "viewModel", "Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeViewModel;", "getCurrentValue", "", "ftmsData", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "getViewBinding", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "setupQuickButtons", "setupViews", "Companion", "Position", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisplayModeAdjustCustomView extends BaseBottomSheetDialogFragment<BottomSheetDisplayModeAdjustBinding> {
    private static final String ARG_IS_METRIC = "is_metric";
    private static final String ARG_MACHINE_TYPE = "machine_type";
    private static final String ARG_POSITION = "position";
    private static boolean isShowing;
    private FitnessMachineControlHelper.AdjustConfig config;
    private boolean isMetric;
    private BleFtmsMachineType machineType = BleFtmsMachineType.TREADMILL;
    private Position position = Position.LEFT;
    private DisplayModeViewModel viewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DisplayModeAdjustCustomView.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BleFtmsMachineType.values().length];
            try {
                iArr[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BleFtmsMachineType.BIKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BleFtmsMachineType.STEPPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BleFtmsMachineType.ROWER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment
    public void initViews() {
    }

    public static final /* synthetic */ BottomSheetDisplayModeAdjustBinding access$getBinding(DisplayModeAdjustCustomView displayModeAdjustCustomView) {
        return displayModeAdjustCustomView.getBinding();
    }

    public final BleFtmsMachineType getMachineType() {
        return this.machineType;
    }

    public final void setMachineType(BleFtmsMachineType bleFtmsMachineType) {
        Intrinsics.checkNotNullParameter(bleFtmsMachineType, "<set-?>");
        this.machineType = bleFtmsMachineType;
    }

    public final Position getPosition() {
        return this.position;
    }

    public final void setPosition(Position position) {
        Intrinsics.checkNotNullParameter(position, "<set-?>");
        this.position = position;
    }

    /* renamed from: isMetric, reason: from getter */
    public final boolean getIsMetric() {
        return this.isMetric;
    }

    public final void setMetric(boolean z) {
        this.isMetric = z;
    }

    /* compiled from: DisplayModeAdjustCustomView.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeAdjustCustomView$Companion;", "", "()V", "ARG_IS_METRIC", "", "ARG_MACHINE_TYPE", "ARG_POSITION", "isShowing", "", "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "machineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "isMetric", DisplayModeAdjustCustomView.ARG_POSITION, "Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeAdjustCustomView$Position;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, BleFtmsMachineType bleFtmsMachineType, boolean z, Position position, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            companion.show(fragmentManager, bleFtmsMachineType, z, position);
        }

        public final void show(FragmentManager fragmentManager, BleFtmsMachineType machineType, boolean isMetric, Position position) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(machineType, "machineType");
            Intrinsics.checkNotNullParameter(position, "position");
            if (!DisplayModeAdjustCustomView.isShowing) {
                DisplayModeAdjustCustomView.isShowing = true;
                DisplayModeAdjustCustomView displayModeAdjustCustomView = new DisplayModeAdjustCustomView();
                Bundle bundle = new Bundle();
                bundle.putString(DisplayModeAdjustCustomView.ARG_MACHINE_TYPE, machineType.name());
                bundle.putBoolean(DisplayModeAdjustCustomView.ARG_IS_METRIC, isMetric);
                bundle.putString(DisplayModeAdjustCustomView.ARG_POSITION, position.name());
                displayModeAdjustCustomView.setArguments(bundle);
                displayModeAdjustCustomView.show(fragmentManager, "DisplayModeDetail");
                return;
            }
            Timber.INSTANCE.d("BottomSheet is already showing, ignoring request", new Object[0]);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DisplayModeAdjustCustomView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/displayMode/DisplayModeAdjustCustomView$Position;", "", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Position {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Position[] $VALUES;
        public static final Position LEFT = new Position("LEFT", 0);
        public static final Position RIGHT = new Position("RIGHT", 1);

        private static final /* synthetic */ Position[] $values() {
            return new Position[]{LEFT, RIGHT};
        }

        public static EnumEntries<Position> getEntries() {
            return $ENTRIES;
        }

        public static Position valueOf(String str) {
            return (Position) Enum.valueOf(Position.class, str);
        }

        public static Position[] values() {
            return (Position[]) $VALUES.clone();
        }

        private Position(String str, int i) {
        }

        static {
            Position[] positionArr$values = $values();
            $VALUES = positionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(positionArr$values);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment
    public BottomSheetDisplayModeAdjustBinding getViewBinding() {
        BottomSheetDisplayModeAdjustBinding bottomSheetDisplayModeAdjustBindingInflate = BottomSheetDisplayModeAdjustBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(bottomSheetDisplayModeAdjustBindingInflate, "inflate(...)");
        return bottomSheetDisplayModeAdjustBindingInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        String string2;
        super.onCreate(savedInstanceState);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        this.viewModel = (DisplayModeViewModel) new ViewModelProvider(fragmentActivityRequireActivity).get(DisplayModeViewModel.class);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_MACHINE_TYPE)) == null) {
            string = "TREADMILL";
        }
        this.machineType = BleFtmsMachineType.valueOf(string);
        Bundle arguments2 = getArguments();
        this.isMetric = arguments2 != null ? arguments2.getBoolean(ARG_IS_METRIC, true) : true;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (string2 = arguments3.getString(ARG_POSITION)) == null) {
            string2 = "LEFT";
        }
        this.position = Position.valueOf(string2);
        this.config = FitnessMachineControlHelper.INSTANCE.getConfig(this.machineType, this.isMetric, this.position);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FitnessMachineControlHelper.AdjustConfig adjustConfig = this.config;
        if (adjustConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            adjustConfig = null;
        }
        if (!adjustConfig.isVisible()) {
            dismiss();
            return;
        }
        setupViews();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(null), 3, null);
    }

    /* compiled from: DisplayModeAdjustCustomView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView$onViewCreated$1", f = "DisplayModeAdjustCustomView.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView$onViewCreated$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DisplayModeAdjustCustomView.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: DisplayModeAdjustCustomView.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView$onViewCreated$1$1", f = "DisplayModeAdjustCustomView.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DisplayModeAdjustCustomView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02441(DisplayModeAdjustCustomView displayModeAdjustCustomView, Continuation<? super C02441> continuation) {
                super(2, continuation);
                this.this$0 = displayModeAdjustCustomView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02441(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DisplayModeViewModel displayModeViewModel = this.this$0.viewModel;
                    if (displayModeViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        displayModeViewModel = null;
                    }
                    Flow flowM10619catch = FlowKt.m10619catch(FlowKt.sample(displayModeViewModel.getFtmsData(), 200L), new C02451(null));
                    final DisplayModeAdjustCustomView displayModeAdjustCustomView = this.this$0;
                    this.label = 1;
                    if (flowM10619catch.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView.onViewCreated.1.1.2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((FtmsBaseData) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(FtmsBaseData ftmsBaseData, Continuation<? super Unit> continuation) {
                            TextView textView = DisplayModeAdjustCustomView.access$getBinding(displayModeAdjustCustomView).tvValue;
                            DisplayModeAdjustCustomView displayModeAdjustCustomView2 = displayModeAdjustCustomView;
                            textView.setText(displayModeAdjustCustomView2.getCurrentValue(displayModeAdjustCustomView2.getMachineType(), ftmsBaseData, displayModeAdjustCustomView.getPosition()));
                            return Unit.INSTANCE;
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

            /* compiled from: DisplayModeAdjustCustomView.kt */
            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "e", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView$onViewCreated$1$1$1", f = "DisplayModeAdjustCustomView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView$onViewCreated$1$1$1, reason: invalid class name and collision with other inner class name */
            static final class C02451 extends SuspendLambda implements Function3<FlowCollector<? super FtmsBaseData>, Throwable, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;

                C02451(Continuation<? super C02451> continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(FlowCollector<? super FtmsBaseData> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                    C02451 c02451 = new C02451(continuation);
                    c02451.L$0 = th;
                    return c02451.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    Timber.INSTANCE.e((Throwable) this.L$0, "ftmsData collect error", new Object[0]);
                    return Unit.INSTANCE;
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(DisplayModeAdjustCustomView.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new C02441(DisplayModeAdjustCustomView.this, null), this) == coroutine_suspended) {
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

    private final void setupViews() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    DisplayModeAdjustCustomView.setupViews$lambda$1(dialogInterface);
                }
            });
        }
        TextView textView = getBinding().tvTitle;
        FitnessMachineControlHelper.AdjustConfig adjustConfig = this.config;
        FitnessMachineControlHelper.AdjustConfig adjustConfig2 = null;
        if (adjustConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            adjustConfig = null;
        }
        textView.setText(adjustConfig.getTitle());
        TextView textView2 = getBinding().tvUnit;
        FitnessMachineControlHelper.AdjustConfig adjustConfig3 = this.config;
        if (adjustConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            adjustConfig3 = null;
        }
        textView2.setText(adjustConfig3.getUnit());
        getBinding().tvValue.setText(SdkConstants.RES_QUALIFIER_SEP);
        LinearLayout tvPlusBtn = getBinding().tvPlusBtn;
        Intrinsics.checkNotNullExpressionValue(tvPlusBtn, "tvPlusBtn");
        ContextExtensionKt.setOnClickListenerWithDebounce$default(tvPlusBtn, 0L, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView.setupViews.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() throws NumberFormatException {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() throws NumberFormatException {
                DisplayModeAdjustCustomView displayModeAdjustCustomView = DisplayModeAdjustCustomView.this;
                BleFtmsMachineType machineType = displayModeAdjustCustomView.getMachineType();
                DisplayModeViewModel displayModeViewModel = DisplayModeAdjustCustomView.this.viewModel;
                FitnessMachineControlHelper.AdjustConfig adjustConfig4 = null;
                if (displayModeViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    displayModeViewModel = null;
                }
                String currentValue = displayModeAdjustCustomView.getCurrentValue(machineType, displayModeViewModel.getFtmsData().getValue(), DisplayModeAdjustCustomView.this.getPosition());
                Timber.INSTANCE.d("Plus - currentVal: " + currentValue, new Object[0]);
                FitnessMachineControlHelper fitnessMachineControlHelper = FitnessMachineControlHelper.INSTANCE;
                FitnessMachineControlHelper.AdjustConfig adjustConfig5 = DisplayModeAdjustCustomView.this.config;
                if (adjustConfig5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("config");
                } else {
                    adjustConfig4 = adjustConfig5;
                }
                FitnessMachineControlHelper.ControlType controlType = adjustConfig4.getControlType();
                Float floatOrNull = StringsKt.toFloatOrNull(currentValue);
                fitnessMachineControlHelper.plus(controlType, floatOrNull != null ? floatOrNull.floatValue() : 0.0f, DisplayModeAdjustCustomView.this.getIsMetric());
            }
        }, 1, null);
        LinearLayout tvMinusBtn = getBinding().tvMinusBtn;
        Intrinsics.checkNotNullExpressionValue(tvMinusBtn, "tvMinusBtn");
        ContextExtensionKt.setOnClickListenerWithDebounce$default(tvMinusBtn, 0L, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView.setupViews.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() throws NumberFormatException {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() throws NumberFormatException {
                DisplayModeAdjustCustomView displayModeAdjustCustomView = DisplayModeAdjustCustomView.this;
                BleFtmsMachineType machineType = displayModeAdjustCustomView.getMachineType();
                DisplayModeViewModel displayModeViewModel = DisplayModeAdjustCustomView.this.viewModel;
                FitnessMachineControlHelper.AdjustConfig adjustConfig4 = null;
                if (displayModeViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    displayModeViewModel = null;
                }
                String currentValue = displayModeAdjustCustomView.getCurrentValue(machineType, displayModeViewModel.getFtmsData().getValue(), DisplayModeAdjustCustomView.this.getPosition());
                Timber.INSTANCE.d("Minus - currentVal: " + currentValue, new Object[0]);
                FitnessMachineControlHelper fitnessMachineControlHelper = FitnessMachineControlHelper.INSTANCE;
                FitnessMachineControlHelper.AdjustConfig adjustConfig5 = DisplayModeAdjustCustomView.this.config;
                if (adjustConfig5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("config");
                } else {
                    adjustConfig4 = adjustConfig5;
                }
                FitnessMachineControlHelper.ControlType controlType = adjustConfig4.getControlType();
                Float floatOrNull = StringsKt.toFloatOrNull(currentValue);
                fitnessMachineControlHelper.minus(controlType, floatOrNull != null ? floatOrNull.floatValue() : 0.0f, DisplayModeAdjustCustomView.this.getIsMetric());
            }
        }, 1, null);
        getBinding().tvDone.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DisplayModeAdjustCustomView.setupViews$lambda$2(this.f$0, view);
            }
        });
        setupQuickButtons();
        FitnessMachineControlHelper.AdjustConfig adjustConfig4 = this.config;
        if (adjustConfig4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            adjustConfig4 = null;
        }
        if (adjustConfig4.getControlType() != FitnessMachineControlHelper.ControlType.SPEED) {
            FitnessMachineControlHelper.AdjustConfig adjustConfig5 = this.config;
            if (adjustConfig5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
            } else {
                adjustConfig2 = adjustConfig5;
            }
            if (adjustConfig2.getControlType() != FitnessMachineControlHelper.ControlType.RESISTANCE) {
                return;
            }
        }
        Context context = getContext();
        if (context != null) {
            getBinding().llWrap.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPalette_red));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$1(DialogInterface dialogInterface) {
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        View viewFindViewById = ((BottomSheetDialog) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
        if (viewFindViewById != null) {
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(viewFindViewById);
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
            bottomSheetBehaviorFrom.setState(3);
            bottomSheetBehaviorFrom.setSkipCollapsed(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$2(DisplayModeAdjustCustomView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        isShowing = false;
    }

    private final void setupQuickButtons() {
        FitnessMachineControlHelper.AdjustConfig adjustConfig;
        List listListOf = CollectionsKt.listOf((Object[]) new TextView[]{getBinding().number1, getBinding().number2, getBinding().number3, getBinding().number4, getBinding().number6, getBinding().number8, getBinding().number10, getBinding().number12, getBinding().number14, getBinding().number16, getBinding().number18, getBinding().number20});
        Iterator it = listListOf.iterator();
        while (true) {
            adjustConfig = null;
            if (!it.hasNext()) {
                break;
            }
            TextView textView = (TextView) it.next();
            textView.setVisibility(8);
            textView.setOnClickListener(null);
        }
        FitnessMachineControlHelper.AdjustConfig adjustConfig2 = this.config;
        if (adjustConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        } else {
            adjustConfig = adjustConfig2;
        }
        int i = 0;
        for (Object obj : adjustConfig.getQuickButtons()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final int iIntValue = ((Number) obj).intValue();
            if (i < listListOf.size()) {
                TextView textView2 = (TextView) listListOf.get(i);
                textView2.setVisibility(0);
                textView2.setText(String.valueOf(iIntValue));
                Intrinsics.checkNotNull(textView2);
                ContextExtensionKt.setOnClickListenerWithDebounce(textView2, 200L, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.displayMode.DisplayModeAdjustCustomView$setupQuickButtons$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Timber.INSTANCE.d("Quick button clicked: " + iIntValue, new Object[0]);
                        FitnessMachineControlHelper fitnessMachineControlHelper = FitnessMachineControlHelper.INSTANCE;
                        FitnessMachineControlHelper.AdjustConfig adjustConfig3 = this.config;
                        if (adjustConfig3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("config");
                            adjustConfig3 = null;
                        }
                        fitnessMachineControlHelper.setValue(adjustConfig3.getControlType(), iIntValue, this.getIsMetric());
                    }
                });
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCurrentValue(BleFtmsMachineType machineType, FtmsBaseData ftmsData, Position position) {
        int i = WhenMappings.$EnumSwitchMapping$0[machineType.ordinal()];
        if (i == 1) {
            TreadmillData treadmillData = ftmsData instanceof TreadmillData ? (TreadmillData) ftmsData : null;
            if (treadmillData == null) {
                return "";
            }
            if (position == Position.LEFT) {
                return String.valueOf(treadmillData.getInstantaneousSpeed());
            }
            return String.valueOf(treadmillData.getInclination());
        }
        if (i == 2) {
            CrossTrainerData crossTrainerData = ftmsData instanceof CrossTrainerData ? (CrossTrainerData) ftmsData : null;
            if (crossTrainerData == null) {
                return "";
            }
            if (position == Position.LEFT) {
                return String.valueOf(crossTrainerData.getResistanceLevel());
            }
            return String.valueOf(crossTrainerData.getInclination());
        }
        if (i == 3) {
            IndoorBikeData indoorBikeData = ftmsData instanceof IndoorBikeData ? (IndoorBikeData) ftmsData : null;
            if (indoorBikeData == null) {
                return "";
            }
            if (position == Position.LEFT) {
                return String.valueOf(indoorBikeData.getResistanceLevel());
            }
            return String.valueOf(indoorBikeData.getInclination());
        }
        if (i == 4) {
            StepClimberData stepClimberData = ftmsData instanceof StepClimberData ? (StepClimberData) ftmsData : null;
            return stepClimberData == null ? "" : String.valueOf(stepClimberData.getResistanceLevel());
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        RowerData rowerData = ftmsData instanceof RowerData ? (RowerData) ftmsData : null;
        return rowerData == null ? "" : String.valueOf(rowerData.getResistanceLevel());
    }
}
