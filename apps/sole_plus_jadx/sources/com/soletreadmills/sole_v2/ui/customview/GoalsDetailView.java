package com.soletreadmills.sole_v2.ui.customview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import com.android.SdkConstants;
import com.facebook.internal.AnalyticsEvents;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.goal.DeleteUserGoalApiData;
import com.soletreadmills.sole_v2._data.goal.GoalTimeFrame;
import com.soletreadmills.sole_v2._data.goal.GoalsStatsType;
import com.soletreadmills.sole_v2._data.goal.UserGoalData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._type.CategoryType;
import com.soletreadmills.sole_v2.databinding.BottomSheetGoalsDetailBinding;
import com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment;
import com.soletreadmills.sole_v2.ui.adapter.goals.GoalsAdapterKt;
import com.soletreadmills.sole_v2.ui.customview.GoalsEditTargetView;
import com.soletreadmills.sole_v2.ui.goals.GoalsViewModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: GoalsDetailView.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0016J(\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u001a\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J:\u0010!\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00142\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%H\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/GoalsDetailView;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseBottomSheetDialogFragment;", "Lcom/soletreadmills/sole_v2/databinding/BottomSheetGoalsDetailBinding;", "()V", "goalsViewModel", "Lcom/soletreadmills/sole_v2/ui/goals/GoalsViewModel;", "deleteGoal", "", "userGoalId", "", "getViewBinding", "initViews", "loadPieChartData", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "pieChart", "Lcom/github/mikephil/charting/charts/PieChart;", "userGoalData", "Lcom/soletreadmills/sole_v2/_data/goal/UserGoalData;", "completeRate", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "setupPieChart", "setupViews", "data", "showDeleteConfirmation", "updatePieChart", "value", "total", "colorIds", "Lkotlin/Triple;", "", "updateViews", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GoalsDetailView extends BaseBottomSheetDialogFragment<BottomSheetGoalsDetailBinding> {
    private static boolean isShowing;
    private GoalsViewModel goalsViewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment
    public void initViews() {
    }

    /* compiled from: GoalsDetailView.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/GoalsDetailView$Companion;", "", "()V", "isShowing", "", "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            if (!GoalsDetailView.isShowing) {
                GoalsDetailView.isShowing = true;
                new GoalsDetailView().show(fragmentManager, "GoalsDetail");
            } else {
                Timber.INSTANCE.d("BottomSheet is already showing, ignoring request", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment
    public BottomSheetGoalsDetailBinding getViewBinding() {
        BottomSheetGoalsDetailBinding bottomSheetGoalsDetailBindingInflate = BottomSheetGoalsDetailBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(bottomSheetGoalsDetailBindingInflate, "inflate(...)");
        return bottomSheetGoalsDetailBindingInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        this.goalsViewModel = (GoalsViewModel) new ViewModelProvider(fragmentActivityRequireActivity).get(GoalsViewModel.class);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        GoalsViewModel goalsViewModel = this.goalsViewModel;
        if (goalsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goalsViewModel");
            goalsViewModel = null;
        }
        setupViews(goalsViewModel.getSelectedGoal().getValue());
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09571(null), 3, null);
    }

    /* compiled from: GoalsDetailView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.customview.GoalsDetailView$onViewCreated$1", f = "GoalsDetailView.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.customview.GoalsDetailView$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    static final class C09571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09571(Continuation<? super C09571> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoalsDetailView.this.new C09571(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: GoalsDetailView.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.customview.GoalsDetailView$onViewCreated$1$1", f = "GoalsDetailView.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.customview.GoalsDetailView$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ GoalsDetailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02371(GoalsDetailView goalsDetailView, Continuation<? super C02371> continuation) {
                super(2, continuation);
                this.this$0 = goalsDetailView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02371(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    GoalsViewModel goalsViewModel = this.this$0.goalsViewModel;
                    if (goalsViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("goalsViewModel");
                        goalsViewModel = null;
                    }
                    StateFlow<UserGoalData> selectedGoal = goalsViewModel.getSelectedGoal();
                    final GoalsDetailView goalsDetailView = this.this$0;
                    this.label = 1;
                    if (selectedGoal.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.customview.GoalsDetailView.onViewCreated.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((UserGoalData) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(UserGoalData userGoalData, Continuation<? super Unit> continuation) throws NumberFormatException {
                            goalsDetailView.updateViews(userGoalData);
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
                throw new KotlinNothingValueException();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(GoalsDetailView.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new C02371(GoalsDetailView.this, null), this) == coroutine_suspended) {
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

    private final void setupViews(UserGoalData data) throws NumberFormatException {
        getBinding().close.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.GoalsDetailView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoalsDetailView.setupViews$lambda$0(this.f$0, view);
            }
        });
        getBinding().editButton.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.GoalsDetailView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoalsDetailView.setupViews$lambda$1(this.f$0, view);
            }
        });
        updateViews(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$0(GoalsDetailView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$1(GoalsDetailView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("Edit!!", new Object[0]);
        GoalsEditTargetView.Companion companion = GoalsEditTargetView.INSTANCE;
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        companion.show(parentFragmentManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateViews(final UserGoalData data) throws NumberFormatException {
        boolean z;
        String string;
        Integer completeRate;
        Context context = getContext();
        if (context != null) {
            Timber.INSTANCE.d("Now data: " + data, new Object[0]);
            Triple<Integer, Integer, Integer> goalsColors = GoalsAdapterKt.getGoalsColors(context, data.getStatsType());
            getBinding().tvCurrentValue.setTextColor(goalsColors.getFirst().intValue());
            getBinding().tvCurrentUnit.setTextColor(goalsColors.getFirst().intValue());
            getBinding().tvGoalValue.setTextColor(goalsColors.getFirst().intValue());
            getBinding().tvGoalUnit.setTextColor(goalsColors.getFirst().intValue());
            UserGoalData userGoalData = (data.getStatsType() == null || data.getTimeFrame() == null) ? null : data;
            if (userGoalData != null) {
                Integer statsType = data.getStatsType();
                if (statsType == null) {
                    return;
                }
                int iIntValue = statsType.intValue();
                Integer timeFrame = data.getTimeFrame();
                if (timeFrame == null) {
                    return;
                }
                int iIntValue2 = timeFrame.intValue();
                Integer completeRate2 = data.getCompleteRate();
                if (completeRate2 == null) {
                    return;
                }
                int iIntValue3 = completeRate2.intValue();
                String string2 = getString(GoalTimeFrame.Companion.getTitleId$default(GoalTimeFrame.INSTANCE, iIntValue2, 0, 2, null));
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String string3 = getString(GoalsStatsType.Companion.getTitleUnitId$default(GoalsStatsType.INSTANCE, iIntValue, iIntValue2, 0, 4, null));
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                getBinding().tvCurrentUnit.setText(getString(GoalsStatsType.Companion.getUnitId$default(GoalsStatsType.INSTANCE, iIntValue, iIntValue2, 0, 4, null)));
                getBinding().tvGoalUnit.setText(getString(GoalsStatsType.Companion.getUnitId$default(GoalsStatsType.INSTANCE, iIntValue, iIntValue2, 0, 4, null)));
                getBinding().tvTitle.setText(string2 + ' ' + string3);
                GoalsViewModel.GoalCalculator goalCalculator = new GoalsViewModel.GoalCalculator(data.getGoalValue(), data.getCurrentValue(), iIntValue, iIntValue2, iIntValue3);
                String currentValue = goalCalculator.getCurrentValue();
                getBinding().tvCurrentValue.setText(currentValue);
                String goalValue = goalCalculator.getGoalValue();
                getBinding().tvGoalValue.setText(goalValue);
                getBinding().tvStatusRateValue.setText(String.valueOf(data.getCompleteRate()));
                if (data.getGoalValue() != null && data.getCurrentValue() != null) {
                    Double.parseDouble(goalValue);
                    Double.parseDouble(currentValue);
                    getBinding().tvToGainValue.setText(goalCalculator.getToGainValue());
                }
                getBinding().tvToGainUnit.setText(getString(GoalsStatsType.Companion.getUnitId$default(GoalsStatsType.INSTANCE, iIntValue, iIntValue2, 0, 4, null)));
                getBinding().tvLeftValue.setText(String.valueOf(data.getTimeRemained()));
                Integer timeRemained = userGoalData.getTimeRemained();
                Intrinsics.checkNotNull(timeRemained);
                z = true;
                String string4 = getString(GoalsDetailViewKt.getGoalsTimeLeftUnit(iIntValue2, timeRemained.intValue() > 1));
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                getBinding().tvLeftUnit.setText(string4);
            } else {
                z = true;
            }
            Integer streak = data.getStreak();
            int iIntValue4 = streak != null ? streak.intValue() : 0;
            getBinding().tvStreakValue.setText(String.valueOf(iIntValue4));
            TextView textView = getBinding().tvStreakUnit;
            Integer timeFrame2 = data.getTimeFrame();
            if (timeFrame2 != null) {
                string = getString(Integer.valueOf(GoalTimeFrame.Companion.getUnitId$default(GoalTimeFrame.INSTANCE, timeFrame2.intValue(), iIntValue4 > 0 ? z : false, 0, 4, null)).intValue());
            } else {
                string = null;
            }
            textView.setText(string);
            PieChart pieChart = getBinding().pieChart;
            Intrinsics.checkNotNullExpressionValue(pieChart, "pieChart");
            setupPieChart(pieChart);
            if (data.getCurrentValue() != null && data.getGoalValue() != null && (completeRate = data.getCompleteRate()) != null) {
                int iIntValue5 = completeRate.intValue();
                PieChart pieChart2 = getBinding().pieChart;
                Intrinsics.checkNotNullExpressionValue(pieChart2, "pieChart");
                loadPieChartData(context, pieChart2, data, iIntValue5);
            }
            String string5 = getString(R.string.any_activity);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            Integer machineCategoryType = data.getMachineCategoryType();
            int code = CategoryType.TREADMILL.getCode();
            if (machineCategoryType != null && machineCategoryType.intValue() == code) {
                string5 = getString(R.string.treadmill_activity);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            } else {
                int code2 = CategoryType.BIKE.getCode();
                if (machineCategoryType != null && machineCategoryType.intValue() == code2) {
                    string5 = getString(R.string.bike_activity);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                } else {
                    int code3 = CategoryType.ELLIPTICAL.getCode();
                    if (machineCategoryType != null && machineCategoryType.intValue() == code3) {
                        string5 = getString(R.string.elliptical_activity);
                        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    } else {
                        int code4 = CategoryType.STEPPER.getCode();
                        if (machineCategoryType != null && machineCategoryType.intValue() == code4) {
                            string5 = getString(R.string.stepper_activity);
                            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                        } else {
                            int code5 = CategoryType.ROWER.getCode();
                            if (machineCategoryType != null && machineCategoryType.intValue() == code5) {
                                string5 = getString(R.string.rower_activity);
                                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                            } else {
                                Timber.INSTANCE.e("未定義的機型:" + data.getMachineCategoryType(), new Object[0]);
                            }
                        }
                    }
                }
            }
            getBinding().tvSubTitle.setText(string5);
            getBinding().deleteButton.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.GoalsDetailView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GoalsDetailView.updateViews$lambda$9$lambda$8(data, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateViews$lambda$9$lambda$8(UserGoalData data, GoalsDetailView this$0, View view) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String userGoalUuid = data.getUserGoalUuid();
        if (userGoalUuid != null) {
            this$0.showDeleteConfirmation(userGoalUuid);
        }
    }

    private final void showDeleteConfirmation(final String userGoalId) {
        CustomDialogKt.showCustomDialog$default(this, getString(R.string.delete_goal_title), getString(R.string.delete_goal_desc), getString(R.string.delete), getString(R.string.cancel), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.customview.GoalsDetailView.showDeleteConfirmation.1
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
                Timber.INSTANCE.d("Delete!! :" + userGoalId, new Object[0]);
                this.deleteGoal(userGoalId);
            }
        }, null, false, 96, null);
    }

    private final void setupPieChart(PieChart pieChart) {
        pieChart.setUsePercentValues(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setCenterText(null);
        pieChart.setDrawEntryLabels(false);
        pieChart.getLegend().setEnabled(false);
        pieChart.setRotationEnabled(false);
        pieChart.setTouchEnabled(false);
    }

    private final void loadPieChartData(Context context, PieChart pieChart, UserGoalData userGoalData, float completeRate) {
        Triple<Integer, Integer, Integer> goalsColors = GoalsAdapterKt.getGoalsColors(context, userGoalData.getStatsType());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PieEntry(completeRate, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED));
        arrayList.add(new PieEntry(100.0f - completeRate, "Remaining"));
        List<Integer> listListOf = CollectionsKt.listOf((Object[]) new Integer[]{goalsColors.getFirst(), goalsColors.getSecond()});
        PieDataSet pieDataSet = new PieDataSet(arrayList, "");
        pieDataSet.setColors(listListOf);
        pieDataSet.setSliceSpace(0.0f);
        pieDataSet.setSelectionShift(5.0f);
        pieDataSet.setDrawValues(false);
        pieChart.setData(new PieData(pieDataSet));
        pieChart.invalidate();
        pieChart.animateY(1000, Easing.EaseInOutQuad);
    }

    private final void updatePieChart(PieChart pieChart, float value, float total, Triple<Integer, Integer, Integer> colorIds) {
        PieDataSet pieDataSet = new PieDataSet(CollectionsKt.listOf((Object[]) new PieEntry[]{new PieEntry(value, ""), new PieEntry(total - value, "")}), "");
        pieDataSet.setColors(CollectionsKt.listOf((Object[]) new Integer[]{colorIds.getFirst(), colorIds.getSecond()}));
        pieDataSet.setDrawValues(false);
        pieChart.setData(new PieData(pieDataSet));
        pieChart.invalidate();
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

    /* compiled from: GoalsDetailView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.customview.GoalsDetailView$deleteGoal$1", f = "GoalsDetailView.kt", i = {}, l = {334}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.customview.GoalsDetailView$deleteGoal$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $userGoalId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$userGoalId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoalsDetailView.this.new AnonymousClass1(this.$userGoalId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: GoalsDetailView.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.customview.GoalsDetailView$deleteGoal$1$1", f = "GoalsDetailView.kt", i = {}, l = {337}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.customview.GoalsDetailView$deleteGoal$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $userGoalId;
            int label;
            final /* synthetic */ GoalsDetailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02361(GoalsDetailView goalsDetailView, String str, Continuation<? super C02361> continuation) {
                super(2, continuation);
                this.this$0 = goalsDetailView;
                this.$userGoalId = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02361(this.this$0, this.$userGoalId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                DeleteUserGoalApiData.DataMap dataMap;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.this$0.showLoading();
                            this.label = 1;
                            obj = DyacoApiKt.callDeleteUserGoal(new DeleteUserGoalApiData.RequestBodyData(this.$userGoalId), this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Response response = (Response) obj;
                        DeleteUserGoalApiData.ResponseData responseData = (DeleteUserGoalApiData.ResponseData) response.body();
                        GoalsViewModel goalsViewModel = null;
                        List<UserGoalData> data = (responseData == null || (dataMap = responseData.getDataMap()) == null) ? null : dataMap.getData();
                        DeleteUserGoalApiData.ResponseData responseData2 = (DeleteUserGoalApiData.ResponseData) response.body();
                        String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                        Timber.INSTANCE.d("callDeleteUserGoal: " + data, new Object[0]);
                        DeleteUserGoalApiData.ResponseData responseData3 = (DeleteUserGoalApiData.ResponseData) response.body();
                        if (responseData3 != null && responseData3.getSuccess()) {
                            Timber.INSTANCE.d("callDeleteUserGoal: success", new Object[0]);
                            GoalsViewModel goalsViewModel2 = this.this$0.goalsViewModel;
                            if (goalsViewModel2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("goalsViewModel");
                            } else {
                                goalsViewModel = goalsViewModel2;
                            }
                            goalsViewModel.deleteGoalFromGoalsList(this.$userGoalId);
                            this.this$0.dismiss();
                        } else {
                            Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.DATA_NOT_FOUND_108.getId(), Boxing.boxInt(R.string.err_108_data_not_found)), TuplesKt.to(ErrorCode.NOT_OWNER_1022.getId(), Boxing.boxInt(R.string.err_1022_operation_requires_resource_ownership))).get(errorCode);
                            if (num != null) {
                                GoalsDetailView goalsDetailView = this.this$0;
                                CustomDialogKt.showCustomDialog$default(goalsDetailView, null, goalsDetailView.getString(num.intValue()), this.this$0.getString(R.string.confirm), null, null, null, false, 112, null);
                            } else {
                                GoalsDetailView goalsDetailView2 = this.this$0;
                                DeleteUserGoalApiData.ResponseData responseData4 = (DeleteUserGoalApiData.ResponseData) response.body();
                                BaseBottomSheetDialogFragment.handleUndefinedError$default(goalsDetailView2, "deleteGoal", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                            }
                        }
                    } catch (IOException e) {
                        String message = e.getMessage();
                        if (message == null) {
                            message = e.getClass().getSimpleName();
                        }
                        BaseBottomSheetDialogFragment.handleApiError$default(this.this$0, "deleteGoal", message, false, 4, null);
                    }
                    this.this$0.stopLoading();
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    this.this$0.stopLoading();
                    throw th;
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(GoalsDetailView.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new C02361(GoalsDetailView.this, this.$userGoalId, null), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteGoal(String userGoalId) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(userGoalId, null), 3, null);
    }
}
