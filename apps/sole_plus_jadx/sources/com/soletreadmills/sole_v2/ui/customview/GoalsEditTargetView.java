package com.soletreadmills.sole_v2.ui.customview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.goal.GetMyUserGoalListApiData;
import com.soletreadmills.sole_v2._data.api.goal.UpdateUserGoalApiData;
import com.soletreadmills.sole_v2._data.goal.GoalTimeFrame;
import com.soletreadmills.sole_v2._data.goal.GoalsStatsType;
import com.soletreadmills.sole_v2._data.goal.UserGoalData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.databinding.BottomSheetGoalsEditTargetBinding;
import com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment;
import com.soletreadmills.sole_v2.ui.goals.GoalsViewModel;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: GoalsEditTargetView.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0014J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u001a\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/GoalsEditTargetView;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseBottomSheetDialogFragment;", "Lcom/soletreadmills/sole_v2/databinding/BottomSheetGoalsEditTargetBinding;", "()V", "goalsViewModel", "Lcom/soletreadmills/sole_v2/ui/goals/GoalsViewModel;", "calculateMaxLimit", "", "decreaseValue", "", "getGoalsData", "updatedGoalId", "", "getViewBinding", "increaseValue", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "setupNumberPad", "setupViews", "updateGoal", "newValue", "", "userGoalId", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GoalsEditTargetView extends BaseBottomSheetDialogFragment<BottomSheetGoalsEditTargetBinding> {
    private static final int DEFAULT_MAX_LIMIT = 999999;
    private static final int MIN_ALLOWED_LIMIT = 1;
    private static boolean isShowingEdit;
    private static NumberInputHandler numberInputHandler;
    private GoalsViewModel goalsViewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment
    public void initViews() {
    }

    /* compiled from: GoalsEditTargetView.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/customview/GoalsEditTargetView$Companion;", "", "()V", "DEFAULT_MAX_LIMIT", "", "MIN_ALLOWED_LIMIT", "isShowingEdit", "", "numberInputHandler", "Lcom/soletreadmills/sole_v2/ui/customview/NumberInputHandler;", "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            if (!GoalsEditTargetView.isShowingEdit) {
                GoalsEditTargetView.isShowingEdit = true;
                new GoalsEditTargetView().show(fragmentManager, "CustomGoalsEditTarget");
            } else {
                Timber.INSTANCE.d("CustomGoalsEditTarget is already showing, ignoring request", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment
    public BottomSheetGoalsEditTargetBinding getViewBinding() {
        BottomSheetGoalsEditTargetBinding bottomSheetGoalsEditTargetBindingInflate = BottomSheetGoalsEditTargetBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(bottomSheetGoalsEditTargetBindingInflate, "inflate(...)");
        return bottomSheetGoalsEditTargetBindingInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        this.goalsViewModel = (GoalsViewModel) new ViewModelProvider(fragmentActivityRequireActivity).get(GoalsViewModel.class);
        numberInputHandler = new NumberInputHandler(calculateMaxLimit());
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupViews();
        setupNumberPad();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.soletreadmills.sole_v2.ui.customview.GoalsEditTargetView$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    GoalsEditTargetView.onViewCreated$lambda$1(dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(DialogInterface dialogInterface) {
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        View viewFindViewById = ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet);
        if (viewFindViewById != null) {
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(viewFindViewById);
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
            bottomSheetBehaviorFrom.setState(3);
            bottomSheetBehaviorFrom.setSkipCollapsed(true);
        }
    }

    private final int calculateMaxLimit() {
        GoalsViewModel goalsViewModel = this.goalsViewModel;
        GoalsViewModel goalsViewModel2 = null;
        if (goalsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goalsViewModel");
            goalsViewModel = null;
        }
        UserGoalData value = goalsViewModel.getSelectedGoal().getValue();
        if ((value != null ? value.getTimeFrame() : null) == null || value.getStatsType() == null) {
            Timber.INSTANCE.w("Goal data incomplete - timeFrame: " + (value != null ? value.getTimeFrame() : null) + ", statsType: " + (value != null ? value.getStatsType() : null), new Object[0]);
            return DEFAULT_MAX_LIMIT;
        }
        GoalsViewModel goalsViewModel3 = this.goalsViewModel;
        if (goalsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goalsViewModel");
        } else {
            goalsViewModel2 = goalsViewModel3;
        }
        Integer timeFrame = value.getTimeFrame();
        Intrinsics.checkNotNull(timeFrame);
        int iIntValue = timeFrame.intValue();
        Integer machineCategoryType = value.getMachineCategoryType();
        Integer statsType = value.getStatsType();
        Intrinsics.checkNotNull(statsType);
        int goalValueMaxLimit = goalsViewModel2.getGoalValueMaxLimit(iIntValue, machineCategoryType, statsType.intValue());
        Timber.INSTANCE.d("Calculated maxLimit: " + goalValueMaxLimit + " for timeFrame: " + value.getTimeFrame() + ", statsType: " + value.getStatsType(), new Object[0]);
        return Math.max(goalValueMaxLimit, 1);
    }

    private final void setupViews() {
        getBinding().tvCancel.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.GoalsEditTargetView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoalsEditTargetView.setupViews$lambda$2(this.f$0, view);
            }
        });
        if (getContext() != null) {
            GoalsViewModel goalsViewModel = this.goalsViewModel;
            if (goalsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goalsViewModel");
                goalsViewModel = null;
            }
            UserGoalData value = goalsViewModel.getSelectedGoal().getValue();
            Timber.INSTANCE.d("Now data: " + value, new Object[0]);
            UserGoalData userGoalData = (value.getStatsType() == null || value.getTimeFrame() == null) ? null : value;
            if (userGoalData != null) {
                GoalTimeFrame.Companion companion = GoalTimeFrame.INSTANCE;
                Integer timeFrame = userGoalData.getTimeFrame();
                Intrinsics.checkNotNull(timeFrame);
                String string = getString(GoalTimeFrame.Companion.getTitleId$default(companion, timeFrame.intValue(), 0, 2, null));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                GoalsStatsType.Companion companion2 = GoalsStatsType.INSTANCE;
                Integer statsType = userGoalData.getStatsType();
                Intrinsics.checkNotNull(statsType);
                int iIntValue = statsType.intValue();
                Integer timeFrame2 = userGoalData.getTimeFrame();
                Intrinsics.checkNotNull(timeFrame2);
                String string2 = getString(GoalsStatsType.Companion.getUnitId$default(companion2, iIntValue, timeFrame2.intValue(), 0, 4, null));
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                getBinding().tvPeriodAndUnit.setText(string + ' ' + string2);
                Double goalValue = value.getGoalValue();
                Integer statsType2 = userGoalData.getStatsType();
                Intrinsics.checkNotNull(statsType2);
                int iIntValue2 = statsType2.intValue();
                boolean unitType = Global.INSTANCE.getUnitType();
                Integer timeFrame3 = userGoalData.getTimeFrame();
                Intrinsics.checkNotNull(timeFrame3);
                getBinding().tvValue.setText(GoalsDetailViewKt.getFormattedGoalsValue(goalValue, iIntValue2, unitType, timeFrame3.intValue()));
            }
        }
        getBinding().tvDone.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.GoalsEditTargetView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoalsEditTargetView.setupViews$lambda$7(this.f$0, view);
            }
        });
        getBinding().tvMinusBtn.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.GoalsEditTargetView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoalsEditTargetView.setupViews$lambda$8(this.f$0, view);
            }
        });
        getBinding().tvPlusBtn.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.customview.GoalsEditTargetView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoalsEditTargetView.setupViews$lambda$9(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$2(GoalsEditTargetView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$7(GoalsEditTargetView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NumberInputHandler numberInputHandler2 = numberInputHandler;
        GoalsViewModel goalsViewModel = null;
        if (numberInputHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numberInputHandler");
            numberInputHandler2 = null;
        }
        int currentValueAsInt = numberInputHandler2.getCurrentValueAsInt();
        Timber.INSTANCE.d("Final value: " + currentValueAsInt, new Object[0]);
        if (currentValueAsInt == 0) {
            CustomDialogKt.showCustomDialog$default(this$0, null, this$0.getString(com.soletreadmills.sole_v2.R.string.value_zero_error), this$0.getString(com.soletreadmills.sole_v2.R.string.confirm), null, null, null, false, 112, null);
            return;
        }
        GoalsViewModel goalsViewModel2 = this$0.goalsViewModel;
        if (goalsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goalsViewModel");
            goalsViewModel2 = null;
        }
        UserGoalData value = goalsViewModel2.getSelectedGoal().getValue();
        Integer timeFrame = value.getTimeFrame();
        if (timeFrame != null) {
            int iIntValue = timeFrame.intValue();
            Integer statsType = value.getStatsType();
            if (statsType != null) {
                int iIntValue2 = statsType.intValue();
                GoalsViewModel goalsViewModel3 = this$0.goalsViewModel;
                if (goalsViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goalsViewModel");
                    goalsViewModel3 = null;
                }
                double transTargetValue = goalsViewModel3.getTransTargetValue(currentValueAsInt, iIntValue, iIntValue2);
                GoalsViewModel goalsViewModel4 = this$0.goalsViewModel;
                if (goalsViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goalsViewModel");
                } else {
                    goalsViewModel = goalsViewModel4;
                }
                String userGoalUuid = goalsViewModel.getSelectedGoal().getValue().getUserGoalUuid();
                if (userGoalUuid != null) {
                    this$0.updateGoal(transTargetValue, userGoalUuid);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$8(GoalsEditTargetView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.decreaseValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$9(GoalsEditTargetView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.increaseValue();
    }

    private final void setupNumberPad() {
        Context context = getContext();
        if (context != null) {
            NumberInputHandler numberInputHandler2 = numberInputHandler;
            if (numberInputHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numberInputHandler");
                numberInputHandler2 = null;
            }
            TextView tvValue = getBinding().tvValue;
            Intrinsics.checkNotNullExpressionValue(tvValue, "tvValue");
            TextView number0 = getBinding().number0;
            Intrinsics.checkNotNullExpressionValue(number0, "number0");
            TextView number1 = getBinding().number1;
            Intrinsics.checkNotNullExpressionValue(number1, "number1");
            TextView number2 = getBinding().number2;
            Intrinsics.checkNotNullExpressionValue(number2, "number2");
            TextView number3 = getBinding().number3;
            Intrinsics.checkNotNullExpressionValue(number3, "number3");
            TextView number4 = getBinding().number4;
            Intrinsics.checkNotNullExpressionValue(number4, "number4");
            TextView number5 = getBinding().number5;
            Intrinsics.checkNotNullExpressionValue(number5, "number5");
            TextView number6 = getBinding().number6;
            Intrinsics.checkNotNullExpressionValue(number6, "number6");
            TextView number7 = getBinding().number7;
            Intrinsics.checkNotNullExpressionValue(number7, "number7");
            TextView number8 = getBinding().number8;
            Intrinsics.checkNotNullExpressionValue(number8, "number8");
            TextView number9 = getBinding().number9;
            Intrinsics.checkNotNullExpressionValue(number9, "number9");
            LinearLayout delete = getBinding().delete;
            Intrinsics.checkNotNullExpressionValue(delete, "delete");
            ImageView tvPlusBtnImg = getBinding().tvPlusBtnImg;
            Intrinsics.checkNotNullExpressionValue(tvPlusBtnImg, "tvPlusBtnImg");
            ImageView tvMinusBtnImg = getBinding().tvMinusBtnImg;
            Intrinsics.checkNotNullExpressionValue(tvMinusBtnImg, "tvMinusBtnImg");
            numberInputHandler2.setupNumberPad(context, tvValue, number0, number1, number2, number3, number4, number5, number6, number7, number8, number9, delete, tvPlusBtnImg, tvMinusBtnImg);
            String string = getBinding().tvValue.getText().toString();
            NumberInputHandler numberInputHandler3 = numberInputHandler;
            if (numberInputHandler3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numberInputHandler");
                numberInputHandler3 = null;
            }
            TextView tvValue2 = getBinding().tvValue;
            Intrinsics.checkNotNullExpressionValue(tvValue2, "tvValue");
            numberInputHandler3.setInitialValue(string, tvValue2);
        }
    }

    private final void decreaseValue() {
        NumberInputHandler numberInputHandler2 = numberInputHandler;
        NumberInputHandler numberInputHandler3 = null;
        if (numberInputHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numberInputHandler");
            numberInputHandler2 = null;
        }
        int currentValueAsInt = numberInputHandler2.getCurrentValueAsInt();
        if (currentValueAsInt > 1) {
            String strValueOf = String.valueOf(currentValueAsInt - 1);
            NumberInputHandler numberInputHandler4 = numberInputHandler;
            if (numberInputHandler4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numberInputHandler");
            } else {
                numberInputHandler3 = numberInputHandler4;
            }
            TextView tvValue = getBinding().tvValue;
            Intrinsics.checkNotNullExpressionValue(tvValue, "tvValue");
            numberInputHandler3.setInitialValue(strValueOf, tvValue);
        }
    }

    private final void increaseValue() {
        NumberInputHandler numberInputHandler2 = numberInputHandler;
        NumberInputHandler numberInputHandler3 = null;
        if (numberInputHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("numberInputHandler");
            numberInputHandler2 = null;
        }
        int currentValueAsInt = numberInputHandler2.getCurrentValueAsInt();
        if (currentValueAsInt < calculateMaxLimit()) {
            String strValueOf = String.valueOf(currentValueAsInt + 1);
            NumberInputHandler numberInputHandler4 = numberInputHandler;
            if (numberInputHandler4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numberInputHandler");
            } else {
                numberInputHandler3 = numberInputHandler4;
            }
            TextView tvValue = getBinding().tvValue;
            Intrinsics.checkNotNullExpressionValue(tvValue, "tvValue");
            numberInputHandler3.setInitialValue(strValueOf, tvValue);
        }
    }

    /* compiled from: GoalsEditTargetView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.customview.GoalsEditTargetView$updateGoal$1", f = "GoalsEditTargetView.kt", i = {}, l = {258}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.customview.GoalsEditTargetView$updateGoal$1, reason: invalid class name and case insensitive filesystem */
    static final class C09591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $newValue;
        final /* synthetic */ String $userGoalId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09591(String str, double d, Continuation<? super C09591> continuation) {
            super(2, continuation);
            this.$userGoalId = str;
            this.$newValue = d;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoalsEditTargetView.this.new C09591(this.$userGoalId, this.$newValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UpdateUserGoalApiData.DataMap dataMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        GoalsEditTargetView.this.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callUpdateUserGoal(new UpdateUserGoalApiData.RequestBodyData(this.$userGoalId, this.$newValue), this);
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
                    UpdateUserGoalApiData.ResponseData responseData = (UpdateUserGoalApiData.ResponseData) response.body();
                    String data = (responseData == null || (dataMap = responseData.getDataMap()) == null) ? null : dataMap.getData();
                    UpdateUserGoalApiData.ResponseData responseData2 = (UpdateUserGoalApiData.ResponseData) response.body();
                    String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                    Timber.INSTANCE.d("callUpdateUserGoal: " + data, new Object[0]);
                    UpdateUserGoalApiData.ResponseData responseData3 = (UpdateUserGoalApiData.ResponseData) response.body();
                    if (responseData3 == null || !responseData3.getSuccess()) {
                        if (GoalsEditTargetView.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(com.soletreadmills.sole_v2.R.string.login_required))).get(errorCode);
                        if (num != null) {
                            GoalsEditTargetView goalsEditTargetView = GoalsEditTargetView.this;
                            CustomDialogKt.showCustomDialog$default(goalsEditTargetView, null, goalsEditTargetView.getString(num.intValue()), GoalsEditTargetView.this.getString(com.soletreadmills.sole_v2.R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            GoalsEditTargetView goalsEditTargetView2 = GoalsEditTargetView.this;
                            UpdateUserGoalApiData.ResponseData responseData4 = (UpdateUserGoalApiData.ResponseData) response.body();
                            BaseBottomSheetDialogFragment.handleUndefinedError$default(goalsEditTargetView2, "updateGoal", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                        }
                    } else {
                        Timber.INSTANCE.d("callUpdateUserGoal: success", new Object[0]);
                        if (data != null) {
                            GoalsEditTargetView.this.getGoalsData(data);
                        }
                    }
                } catch (IOException e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseBottomSheetDialogFragment.handleApiError$default(GoalsEditTargetView.this, "updateGoal", message, false, 4, null);
                }
                GoalsEditTargetView.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                GoalsEditTargetView.this.stopLoading();
            }
        }
    }

    private final void updateGoal(double newValue, String userGoalId) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09591(userGoalId, newValue, null), 3, null);
    }

    /* compiled from: GoalsEditTargetView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.customview.GoalsEditTargetView$getGoalsData$1", f = "GoalsEditTargetView.kt", i = {}, l = {318}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.customview.GoalsEditTargetView$getGoalsData$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $updatedGoalId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$updatedGoalId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoalsEditTargetView.this.new AnonymousClass1(this.$updatedGoalId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object next;
            GetMyUserGoalListApiData.DataMap dataMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = DyacoApiKt.callGetMyUserGoalList(this);
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
                    GetMyUserGoalListApiData.ResponseData responseData = (GetMyUserGoalListApiData.ResponseData) response.body();
                    GoalsViewModel goalsViewModel = null;
                    List<UserGoalData> data = (responseData == null || (dataMap = responseData.getDataMap()) == null) ? null : dataMap.getData();
                    GetMyUserGoalListApiData.ResponseData responseData2 = (GetMyUserGoalListApiData.ResponseData) response.body();
                    String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                    Timber.INSTANCE.d("callGetMyUserGoalList: " + data, new Object[0]);
                    GetMyUserGoalListApiData.ResponseData responseData3 = (GetMyUserGoalListApiData.ResponseData) response.body();
                    if (responseData3 != null && responseData3.getSuccess() && data != null) {
                        Timber.INSTANCE.d("callGetMyUserGoalList: success", new Object[0]);
                        GoalsViewModel goalsViewModel2 = GoalsEditTargetView.this.goalsViewModel;
                        if (goalsViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("goalsViewModel");
                            goalsViewModel2 = null;
                        }
                        goalsViewModel2.updateGoalList(data);
                        String str = this.$updatedGoalId;
                        Iterator<T> it = data.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            if (Intrinsics.areEqual(((UserGoalData) next).getUserGoalUuid(), str)) {
                                break;
                            }
                        }
                        UserGoalData userGoalData = (UserGoalData) next;
                        if (userGoalData != null) {
                            GoalsViewModel goalsViewModel3 = GoalsEditTargetView.this.goalsViewModel;
                            if (goalsViewModel3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("goalsViewModel");
                            } else {
                                goalsViewModel = goalsViewModel3;
                            }
                            goalsViewModel.setSelectedGoal(userGoalData);
                        }
                    } else {
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(com.soletreadmills.sole_v2.R.string.login_required))).get(errorCode);
                        if (num != null) {
                            GoalsEditTargetView goalsEditTargetView = GoalsEditTargetView.this;
                            CustomDialogKt.showCustomDialog$default(goalsEditTargetView, null, goalsEditTargetView.getString(num.intValue()), GoalsEditTargetView.this.getString(com.soletreadmills.sole_v2.R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            GoalsEditTargetView goalsEditTargetView2 = GoalsEditTargetView.this;
                            GetMyUserGoalListApiData.ResponseData responseData4 = (GetMyUserGoalListApiData.ResponseData) response.body();
                            BaseBottomSheetDialogFragment.handleUndefinedError$default(goalsEditTargetView2, "getGoalsData", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                        }
                    }
                } catch (IOException e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseBottomSheetDialogFragment.handleApiError$default(GoalsEditTargetView.this, "getGoalsData", message, false, 4, null);
                }
                GoalsEditTargetView.this.dismiss();
                GoalsEditTargetView.this.stopLoading();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                GoalsEditTargetView.this.dismiss();
                GoalsEditTargetView.this.stopLoading();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getGoalsData(String updatedGoalId) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(updatedGoalId, null), 3, null);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        isShowingEdit = false;
    }
}
