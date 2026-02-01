package com.soletreadmills.sole_v2.ui.goals;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.collection.SieveCacheKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.goal.CreateUserGoalApiData;
import com.soletreadmills.sole_v2._data.api.goal.UpdateUserGoalApiData;
import com.soletreadmills.sole_v2._data.goal.GoalTimeFrame;
import com.soletreadmills.sole_v2._data.goal.GoalsMachineType;
import com.soletreadmills.sole_v2._data.goal.GoalsStatsType;
import com.soletreadmills.sole_v2._data.goal.UserGoalCreateForm;
import com.soletreadmills.sole_v2._data.goal.UserGoalCreateFormToUpload;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentGoalsCreateBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.goals.GoalsEditMachineTypeAdapter;
import com.soletreadmills.sole_v2.ui.adapter.goals.GoalsEditStatsTypeAdapter;
import com.soletreadmills.sole_v2.ui.adapter.goals.GoalsEditTimeFrameAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: GoalsCreateFragment.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020\u0012H\u0002J\u0017\u0010'\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010*J\u0018\u0010+\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020)H\u0002J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0002J\u001c\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u00020/H\u0002J\u0018\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020/H\u0002J\u0017\u00107\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010*J\u0010\u00109\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0002J\u0017\u0010:\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010*J\b\u0010;\u001a\u00020\u0012H\u0002J\u0010\u0010<\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006="}, d2 = {"Lcom/soletreadmills/sole_v2/ui/goals/GoalsCreateFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentGoalsCreateBinding;", "Landroid/view/View$OnClickListener;", "()V", "adapter1", "Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsEditTimeFrameAdapter;", "adapter2", "Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsEditMachineTypeAdapter;", "adapter3", "Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsEditStatsTypeAdapter;", "goalsViewModel", "Lcom/soletreadmills/sole_v2/ui/goals/GoalsViewModel;", "getGoalsViewModel", "()Lcom/soletreadmills/sole_v2/ui/goals/GoalsViewModel;", "goalsViewModel$delegate", "Lkotlin/Lazy;", "createForm", "", "createGoals", "examineForm", "", "data", "Lcom/soletreadmills/sole_v2/_data/goal/UserGoalCreateForm;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "resetAll", "resetTargetValueInput", "setupEditMachineTypeRecyclerView", "activeId", "", "(Ljava/lang/Integer;)V", "setupEditStatsTypeRecyclerView", "timeFrameId", "setupEditTimeFrameRecyclerView", "toText", "", "text", "", "defaultText", "updateGoal", "newValue", "", "userGoalId", "updateMachineType", "machineTypeId", "updateStatsType", "updateTargetList", "updateTargetValueUnitHint", "updateTimeFrameItem", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GoalsCreateFragment extends BaseFragment<FragmentGoalsCreateBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private GoalsEditTimeFrameAdapter adapter1;
    private GoalsEditMachineTypeAdapter adapter2;
    private GoalsEditStatsTypeAdapter adapter3;

    /* renamed from: goalsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy goalsViewModel;

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    public GoalsCreateFragment() {
        final GoalsCreateFragment goalsCreateFragment = this;
        final Function0 function0 = null;
        this.goalsViewModel = FragmentViewModelLazyKt.createViewModelLazy(goalsCreateFragment, Reflection.getOrCreateKotlinClass(GoalsViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = goalsCreateFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = goalsCreateFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = goalsCreateFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentGoalsCreateBinding access$getBinding(GoalsCreateFragment goalsCreateFragment) {
        return goalsCreateFragment.getBinding();
    }

    public final GoalsViewModel getGoalsViewModel() {
        return (GoalsViewModel) this.goalsViewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentGoalsCreateBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentGoalsCreateBinding fragmentGoalsCreateBindingInflate = FragmentGoalsCreateBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentGoalsCreateBindingInflate, "inflate(...)");
        return fragmentGoalsCreateBindingInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        AppCompatButton appCompatButton;
        TextView textView;
        EditText editText;
        TextView textView2;
        getGoalsViewModel().resetGoalForm();
        UserGoalCreateForm value = getGoalsViewModel().getEditGoalForm().getValue();
        setupEditTimeFrameRecyclerView(value.getTimeFrame());
        List list = ArraysKt.toList(GoalTimeFrame.values());
        GoalsEditTimeFrameAdapter goalsEditTimeFrameAdapter = this.adapter1;
        if (goalsEditTimeFrameAdapter != null) {
            goalsEditTimeFrameAdapter.submitList(list);
        }
        setupEditMachineTypeRecyclerView(value.getMachineCategoryType());
        List list2 = ArraysKt.toList(GoalsMachineType.values());
        GoalsEditMachineTypeAdapter goalsEditMachineTypeAdapter = this.adapter2;
        if (goalsEditMachineTypeAdapter != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                if (((GoalsMachineType) obj).getShowAtForm()) {
                    arrayList.add(obj);
                }
            }
            goalsEditMachineTypeAdapter.submitList(arrayList);
        }
        setupEditStatsTypeRecyclerView(value.getStatsType(), value.getTimeFrame());
        List<GoalsStatsType> supportedGoalsStatsByMachineId = GoalsMachineType.INSTANCE.getSupportedGoalsStatsByMachineId(value.getMachineCategoryType());
        Timber.INSTANCE.d("init3:" + supportedGoalsStatsByMachineId, new Object[0]);
        GoalsEditStatsTypeAdapter goalsEditStatsTypeAdapter = this.adapter3;
        if (goalsEditStatsTypeAdapter != null) {
            goalsEditStatsTypeAdapter.submitList(supportedGoalsStatsByMachineId);
        }
        FragmentGoalsCreateBinding binding = getBinding();
        if (binding != null && (textView2 = binding.tvCancelBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GoalsCreateFragment.initViews$lambda$1(this.f$0, view);
                }
            });
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass3(null), 3, null);
        resetTargetValueInput();
        FragmentGoalsCreateBinding binding2 = getBinding();
        TextView textView3 = binding2 != null ? binding2.tvTargetScoreError : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        FragmentGoalsCreateBinding binding3 = getBinding();
        if (binding3 != null && (editText = binding3.etTargetScore) != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment.initViews.4
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    int iValueOf;
                    FragmentGoalsCreateBinding fragmentGoalsCreateBindingAccess$getBinding = GoalsCreateFragment.access$getBinding(GoalsCreateFragment.this);
                    final Integer num = null;
                    TextView textView4 = fragmentGoalsCreateBindingAccess$getBinding != null ? fragmentGoalsCreateBindingAccess$getBinding.tvTargetScoreError : null;
                    if (textView4 != null) {
                        textView4.setText("");
                    }
                    FragmentGoalsCreateBinding fragmentGoalsCreateBindingAccess$getBinding2 = GoalsCreateFragment.access$getBinding(GoalsCreateFragment.this);
                    TextView textView5 = fragmentGoalsCreateBindingAccess$getBinding2 != null ? fragmentGoalsCreateBindingAccess$getBinding2.tvTargetScoreError : null;
                    if (textView5 != null) {
                        textView5.setVisibility(8);
                    }
                    Timber.INSTANCE.d("new val: " + ((Object) s), new Object[0]);
                    try {
                        Long longOrNull = StringsKt.toLongOrNull(String.valueOf(s));
                        if (longOrNull != null) {
                            if (longOrNull.longValue() > SieveCacheKt.NodeLinkMask) {
                                iValueOf = Integer.MAX_VALUE;
                            } else if (longOrNull.longValue() >= 0) {
                                iValueOf = Integer.valueOf((int) longOrNull.longValue());
                            }
                            num = iValueOf;
                        }
                    } catch (Exception unused) {
                    }
                    Timber.INSTANCE.d("converted val: " + num, new Object[0]);
                    if (num != null) {
                        GoalsCreateFragment.this.getGoalsViewModel().updateGoalForm(new Function1<UserGoalCreateForm, UserGoalCreateForm>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$initViews$4$afterTextChanged$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final UserGoalCreateForm invoke(UserGoalCreateForm it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return UserGoalCreateForm.copy$default(it, 0, null, 0, num, 7, null);
                            }
                        });
                    } else {
                        GoalsCreateFragment.this.getGoalsViewModel().updateGoalForm(new Function1<UserGoalCreateForm, UserGoalCreateForm>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$initViews$4$afterTextChanged$2
                            @Override // kotlin.jvm.functions.Function1
                            public final UserGoalCreateForm invoke(UserGoalCreateForm it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return UserGoalCreateForm.copy$default(it, 0, null, 0, null, 7, null);
                            }
                        });
                    }
                }
            });
        }
        FragmentGoalsCreateBinding binding4 = getBinding();
        if (binding4 != null && (textView = binding4.tvCreateBtn) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GoalsCreateFragment.initViews$lambda$2(this.f$0, view);
                }
            });
        }
        FragmentGoalsCreateBinding binding5 = getBinding();
        if (binding5 == null || (appCompatButton = binding5.btnBottomSaveCreate) == null) {
            return;
        }
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoalsCreateFragment.initViews$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(GoalsCreateFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("Cancel", new Object[0]);
        this$0.resetAll();
        this$0.safeNavigateUp();
    }

    /* compiled from: GoalsCreateFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$initViews$3", f = "GoalsCreateFragment.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$initViews$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoalsCreateFragment.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: GoalsCreateFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$initViews$3$1", f = "GoalsCreateFragment.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$initViews$3$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ GoalsCreateFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(GoalsCreateFragment goalsCreateFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = goalsCreateFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
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
                    if (this.this$0.getGoalsViewModel().getEditGoalForm().collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment.initViews.3.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((UserGoalCreateForm) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(UserGoalCreateForm userGoalCreateForm, Continuation<? super Unit> continuation) {
                            Timber.INSTANCE.d("collect---" + userGoalCreateForm, new Object[0]);
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(GoalsCreateFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(GoalsCreateFragment.this, null), this) == coroutine_suspended) {
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
    public static final void initViews$lambda$2(GoalsCreateFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.createForm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$3(GoalsCreateFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.createForm();
    }

    private final void resetAll() {
        getGoalsViewModel().resetGoalForm();
    }

    static /* synthetic */ String toText$default(GoalsCreateFragment goalsCreateFragment, Object obj, String str, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = "";
        }
        return goalsCreateFragment.toText(obj, str);
    }

    private final String toText(Object text, String defaultText) {
        if (text == null || Intrinsics.areEqual(text, AbstractJsonLexerKt.NULL)) {
            return StringsKt.replace$default(StringsKt.replace$default(String.valueOf(text), "\n", "", false, 4, (Object) null), "\r", "", false, 4, (Object) null);
        }
        return StringsKt.replace$default(StringsKt.replace$default(text.toString(), "\n", "", false, 4, (Object) null), "\r", "", false, 4, (Object) null);
    }

    private final boolean examineForm(UserGoalCreateForm data) {
        TextView textView;
        int timeFrame = getGoalsViewModel().getEditGoalForm().getValue().getTimeFrame();
        Integer machineCategoryType = getGoalsViewModel().getEditGoalForm().getValue().getMachineCategoryType();
        int statsType = getGoalsViewModel().getEditGoalForm().getValue().getStatsType();
        Integer intOrNull = StringsKt.toIntOrNull(String.valueOf(data.getGoalValue()));
        int goalValueMaxLimit = getGoalsViewModel().getGoalValueMaxLimit(timeFrame, machineCategoryType, statsType);
        if (intOrNull == null) {
            FragmentGoalsCreateBinding binding = getBinding();
            TextView textView2 = binding != null ? binding.tvTargetScoreError : null;
            if (textView2 != null) {
                textView2.setText(getString(R.string.input_required));
            }
            FragmentGoalsCreateBinding binding2 = getBinding();
            textView = binding2 != null ? binding2.tvTargetScoreError : null;
            if (textView == null) {
                return false;
            }
            textView.setVisibility(0);
            return false;
        }
        Integer goalValue = data.getGoalValue();
        if (goalValue != null && goalValue.intValue() == 0) {
            FragmentGoalsCreateBinding binding3 = getBinding();
            TextView textView3 = binding3 != null ? binding3.tvTargetScoreError : null;
            if (textView3 != null) {
                textView3.setText(getString(R.string.value_zero_error));
            }
            FragmentGoalsCreateBinding binding4 = getBinding();
            textView = binding4 != null ? binding4.tvTargetScoreError : null;
            if (textView == null) {
                return false;
            }
            textView.setVisibility(0);
            return false;
        }
        Intrinsics.checkNotNull(data.getGoalValue());
        if (r8.intValue() <= goalValueMaxLimit) {
            return true;
        }
        String str = getString(R.string.amount_error) + ' ' + goalValueMaxLimit;
        FragmentGoalsCreateBinding binding5 = getBinding();
        TextView textView4 = binding5 != null ? binding5.tvTargetScoreError : null;
        if (textView4 != null) {
            textView4.setText(str);
        }
        FragmentGoalsCreateBinding binding6 = getBinding();
        textView = binding6 != null ? binding6.tvTargetScoreError : null;
        if (textView == null) {
            return false;
        }
        textView.setVisibility(0);
        return false;
    }

    private final void createForm() {
        hideKeyboard();
        UserGoalCreateForm value = getGoalsViewModel().getEditGoalForm().getValue();
        boolean zExamineForm = examineForm(value);
        Timber.INSTANCE.d("CREATE form!: " + value, new Object[0]);
        if (zExamineForm) {
            createGoals();
            return;
        }
        FragmentGoalsCreateBinding binding = getBinding();
        if (binding != null) {
            binding.tvScrollView.smoothScrollTo(0, RangesKt.coerceAtLeast(binding.llTargetScoreWrap.getTop() - (binding.tvScrollView.getHeight() / 3), 0));
        }
    }

    private final void createGoals() {
        Integer goalValue;
        UserGoalCreateForm value = getGoalsViewModel().getEditGoalForm().getValue();
        if (value == null || (goalValue = value.getGoalValue()) == null) {
            return;
        }
        int iIntValue = goalValue.intValue();
        Timber.INSTANCE.d("rawData:" + value, new Object[0]);
        showLoading();
        double transTargetValue = getGoalsViewModel().getTransTargetValue(iIntValue, value.getTimeFrame(), value.getStatsType());
        CreateUserGoalApiData.RequestBodyData requestBodyData = new CreateUserGoalApiData.RequestBodyData(new UserGoalCreateFormToUpload(value.getTimeFrame(), value.getMachineCategoryType(), value.getStatsType(), transTargetValue));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(requestBodyData, this, transTargetValue, null), 3, null);
    }

    /* compiled from: GoalsCreateFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$createGoals$1", f = "GoalsCreateFragment.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$createGoals$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $convertTargetValue;
        final /* synthetic */ CreateUserGoalApiData.RequestBodyData $requestData;
        int label;
        final /* synthetic */ GoalsCreateFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CreateUserGoalApiData.RequestBodyData requestBodyData, GoalsCreateFragment goalsCreateFragment, double d, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$requestData = requestBodyData;
            this.this$0 = goalsCreateFragment;
            this.$convertTargetValue = d;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$requestData, this.this$0, this.$convertTargetValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CreateUserGoalApiData.ResponseData responseData;
            Unit unit;
            CreateUserGoalApiData.DataMap dataMap;
            CreateUserGoalApiData.DataMap dataMap2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = DyacoApiKt.callCreateUserGoal(this.$requestData, this);
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
                    CreateUserGoalApiData.ResponseData responseData2 = (CreateUserGoalApiData.ResponseData) response.body();
                    Timber.INSTANCE.d("callCreateUserGoal: " + response, new Object[0]);
                    final String errorMessage = null;
                    String data = (responseData2 == null || (dataMap2 = responseData2.getDataMap()) == null) ? null : dataMap2.getData();
                    CreateUserGoalApiData.ResponseData responseData3 = (CreateUserGoalApiData.ResponseData) response.body();
                    String errorCode = responseData3 != null ? responseData3.getErrorCode() : null;
                    CreateUserGoalApiData.ResponseData responseData4 = (CreateUserGoalApiData.ResponseData) response.body();
                    if (responseData4 == null || !responseData4.getSuccess()) {
                        if (this.this$0.shouldIgnoreError(errorCode)) {
                            unit = Unit.INSTANCE;
                        } else if (Intrinsics.areEqual(errorCode, ErrorCode.DUPLICATE_RECORD_1065.getId())) {
                            CreateUserGoalApiData.ResponseData responseData5 = (CreateUserGoalApiData.ResponseData) response.body();
                            if (responseData5 != null && (dataMap = responseData5.getDataMap()) != null) {
                                errorMessage = dataMap.getUserGoalUuid();
                            }
                            Timber.INSTANCE.d("duplicateGoalsUuid: " + errorMessage, new Object[0]);
                            String string = this.this$0.getString(R.string.goal_already_exists);
                            String string2 = this.this$0.getString(R.string.duplicate_record_desc);
                            String string3 = this.this$0.getString(R.string.update_goal);
                            String string4 = this.this$0.getString(R.string.cancel);
                            GoalsCreateFragment goalsCreateFragment = this.this$0;
                            final GoalsCreateFragment goalsCreateFragment2 = this.this$0;
                            final double d = this.$convertTargetValue;
                            CustomDialogKt.showCustomDialog$default(goalsCreateFragment, string, string2, string3, string4, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment.createGoals.1.1
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
                                    String str = errorMessage;
                                    if (str != null) {
                                        goalsCreateFragment2.updateGoal(d, str);
                                    }
                                }
                            }, null, false, 96, null);
                            unit = Unit.INSTANCE;
                        } else {
                            GoalsCreateFragment goalsCreateFragment3 = this.this$0;
                            if (response != null && (responseData = (CreateUserGoalApiData.ResponseData) response.body()) != null) {
                                errorMessage = responseData.getErrorMessage();
                            }
                            BaseFragment.handleUndefinedError$default(goalsCreateFragment3, "createGoals", errorCode, errorMessage, false, 8, null);
                        }
                        return unit;
                    }
                    Timber.INSTANCE.d("CreateUserGoalId: " + data, new Object[0]);
                    this.this$0.safeNavigateUp();
                } catch (IOException e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(this.this$0, "createGoals", message, false, 4, null);
                }
                this.this$0.stopLoading();
                return Unit.INSTANCE;
            } finally {
                this.this$0.stopLoading();
            }
        }
    }

    /* compiled from: GoalsCreateFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$updateGoal$1", f = "GoalsCreateFragment.kt", i = {}, l = {312}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$updateGoal$1, reason: invalid class name and case insensitive filesystem */
    static final class C09631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $newValue;
        final /* synthetic */ String $userGoalId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09631(String str, double d, Continuation<? super C09631> continuation) {
            super(2, continuation);
            this.$userGoalId = str;
            this.$newValue = d;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoalsCreateFragment.this.new C09631(this.$userGoalId, this.$newValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        GoalsCreateFragment.this.showLoading();
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
                        if (GoalsCreateFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        GoalsCreateFragment goalsCreateFragment = GoalsCreateFragment.this;
                        UpdateUserGoalApiData.ResponseData responseData4 = (UpdateUserGoalApiData.ResponseData) response.body();
                        BaseFragment.handleUndefinedError$default(goalsCreateFragment, "updateGoal", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                    } else {
                        Timber.INSTANCE.d("callUpdateUserGoal: success", new Object[0]);
                        GoalsCreateFragment.this.safeNavigateUp();
                    }
                } catch (IOException e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(GoalsCreateFragment.this, "updateGoal", message, false, 4, null);
                }
                GoalsCreateFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                GoalsCreateFragment.this.stopLoading();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateGoal(double newValue, String userGoalId) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09631(userGoalId, newValue, null), 3, null);
    }

    private final void setupEditTimeFrameRecyclerView(int activeId) {
        RecyclerView recyclerView;
        GoalsEditTimeFrameAdapter goalsEditTimeFrameAdapter = this.adapter1;
        if (goalsEditTimeFrameAdapter != null) {
            if (goalsEditTimeFrameAdapter != null) {
                goalsEditTimeFrameAdapter.updateActiveId(activeId);
                return;
            }
            return;
        }
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.adapter1 = new GoalsEditTimeFrameAdapter(mainActivity, new GoalsEditTimeFrameAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$setupEditTimeFrameRecyclerView$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.goals.GoalsEditTimeFrameAdapter.OnItemClickListener
                public void onClick(int bindingAdapterPosition, GoalTimeFrame item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    Timber.INSTANCE.d("item click: " + item.getId(), new Object[0]);
                    this.this$0.updateTimeFrameItem(item.getId());
                }
            }, activeId, true);
        }
        FragmentGoalsCreateBinding binding = getBinding();
        if (binding == null || (recyclerView = binding.rvEditScoreItem) == null) {
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext());
        recyclerView.setAdapter(this.adapter1);
        recyclerView.setLayoutManager(flexboxLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTimeFrameItem(final int activeId) {
        GoalsEditTimeFrameAdapter goalsEditTimeFrameAdapter = this.adapter1;
        if (goalsEditTimeFrameAdapter != null) {
            goalsEditTimeFrameAdapter.updateActiveId(activeId);
        }
        getGoalsViewModel().updateGoalForm(new Function1<UserGoalCreateForm, UserGoalCreateForm>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment.updateTimeFrameItem.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final UserGoalCreateForm invoke(UserGoalCreateForm it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return UserGoalCreateForm.copy$default(it, activeId, null, 0, null, 14, null);
            }
        });
        updateTargetList(getGoalsViewModel().getEditGoalForm().getValue().getMachineCategoryType());
        resetTargetValueInput();
    }

    private final void setupEditMachineTypeRecyclerView(Integer activeId) {
        RecyclerView recyclerView;
        if (this.adapter2 == null) {
            MainActivity mainActivity = getMainActivity();
            if (mainActivity != null) {
                this.adapter2 = new GoalsEditMachineTypeAdapter(mainActivity, new GoalsEditMachineTypeAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$setupEditMachineTypeRecyclerView$1$1
                    @Override // com.soletreadmills.sole_v2.ui.adapter.goals.GoalsEditMachineTypeAdapter.OnItemClickListener
                    public void onClick(int bindingAdapterPosition, GoalsMachineType item) {
                        Intrinsics.checkNotNullParameter(item, "item");
                        Timber.INSTANCE.d("item machineType: " + item.getId(), new Object[0]);
                        this.this$0.updateMachineType(item.getId());
                    }
                }, null, true);
            }
            FragmentGoalsCreateBinding binding = getBinding();
            if (binding != null && (recyclerView = binding.rvEditMachineType) != null) {
                FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext());
                recyclerView.setAdapter(this.adapter2);
                recyclerView.setLayoutManager(flexboxLayoutManager);
            }
            updateMachineType(activeId);
            return;
        }
        updateMachineType(activeId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMachineType(final Integer machineTypeId) {
        Timber.INSTANCE.d("updateMachineType:" + machineTypeId, new Object[0]);
        GoalsEditMachineTypeAdapter goalsEditMachineTypeAdapter = this.adapter2;
        if (goalsEditMachineTypeAdapter != null) {
            goalsEditMachineTypeAdapter.updateActiveId(machineTypeId);
        }
        getGoalsViewModel().updateGoalForm(new Function1<UserGoalCreateForm, UserGoalCreateForm>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment.updateMachineType.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final UserGoalCreateForm invoke(UserGoalCreateForm it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return UserGoalCreateForm.copy$default(it, 0, machineTypeId, 0, null, 13, null);
            }
        });
        updateTargetList(machineTypeId);
        resetTargetValueInput();
    }

    private final void resetTargetValueInput() {
        getGoalsViewModel().getEditGoalForm().getValue().getStatsType();
        getGoalsViewModel().getEditGoalForm().getValue().getTimeFrame();
        FragmentGoalsCreateBinding binding = getBinding();
        EditText editText = binding != null ? binding.etTargetScore : null;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
        getGoalsViewModel().updateGoalForm(new Function1<UserGoalCreateForm, UserGoalCreateForm>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment.resetTargetValueInput.1
            @Override // kotlin.jvm.functions.Function1
            public final UserGoalCreateForm invoke(UserGoalCreateForm it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return UserGoalCreateForm.copy$default(it, 0, null, 0, null, 7, null);
            }
        });
        updateTargetValueUnitHint();
    }

    private final void updateTargetValueUnitHint() {
        int statsType = getGoalsViewModel().getEditGoalForm().getValue().getStatsType();
        int timeFrame = getGoalsViewModel().getEditGoalForm().getValue().getTimeFrame();
        String string = getString(R.string.target);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getMainActivity() != null ? getString(GoalsStatsType.Companion.getUnitId$default(GoalsStatsType.INSTANCE, statsType, timeFrame, 0, 4, null)) : null;
        FragmentGoalsCreateBinding binding = getBinding();
        EditText editText = binding != null ? binding.etTargetScore : null;
        if (editText == null) {
            return;
        }
        editText.setHint(string + ' ' + string2);
    }

    private final void setupEditStatsTypeRecyclerView(int activeId, int timeFrameId) {
        RecyclerView recyclerView;
        if (this.adapter3 == null) {
            MainActivity mainActivity = getMainActivity();
            if (mainActivity != null) {
                this.adapter3 = new GoalsEditStatsTypeAdapter(mainActivity, new GoalsEditStatsTypeAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment$setupEditStatsTypeRecyclerView$1$1
                    @Override // com.soletreadmills.sole_v2.ui.adapter.goals.GoalsEditStatsTypeAdapter.OnItemClickListener
                    public void onClick(int bindingAdapterPosition, GoalsStatsType item) {
                        Intrinsics.checkNotNullParameter(item, "item");
                        Timber.INSTANCE.d("item updateStatsType: " + item, new Object[0]);
                        this.this$0.updateStatsType(item.getId());
                    }
                }, Integer.valueOf(activeId), timeFrameId, true);
            }
            FragmentGoalsCreateBinding binding = getBinding();
            if (binding == null || (recyclerView = binding.rvEditRaceDistance) == null) {
                return;
            }
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext());
            recyclerView.setAdapter(this.adapter3);
            recyclerView.setLayoutManager(flexboxLayoutManager);
            return;
        }
        updateStatsType(activeId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStatsType(final int activeId) {
        GoalsEditStatsTypeAdapter goalsEditStatsTypeAdapter = this.adapter3;
        if (goalsEditStatsTypeAdapter != null) {
            goalsEditStatsTypeAdapter.updateActiveId(Integer.valueOf(activeId));
        }
        getGoalsViewModel().updateGoalForm(new Function1<UserGoalCreateForm, UserGoalCreateForm>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment.updateStatsType.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final UserGoalCreateForm invoke(UserGoalCreateForm it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return UserGoalCreateForm.copy$default(it, 0, null, activeId, null, 11, null);
            }
        });
        resetTargetValueInput();
    }

    private final void updateTargetList(Integer machineTypeId) {
        final List list = CollectionsKt.toList(GoalsMachineType.INSTANCE.getSupportedGoalsStatsByMachineId(machineTypeId));
        GoalsEditStatsTypeAdapter goalsEditStatsTypeAdapter = this.adapter3;
        if (goalsEditStatsTypeAdapter != null) {
            goalsEditStatsTypeAdapter.submitList(list);
        }
        Timber.INSTANCE.d("updateTargetList-statsTypeList:" + list, new Object[0]);
        if (!list.isEmpty()) {
            getGoalsViewModel().updateGoalForm(new Function1<UserGoalCreateForm, UserGoalCreateForm>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsCreateFragment.updateTargetList.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final UserGoalCreateForm invoke(UserGoalCreateForm it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return UserGoalCreateForm.copy$default(it, 0, null, ((GoalsStatsType) CollectionsKt.first((List) list)).getId(), null, 11, null);
                }
            });
            GoalsEditStatsTypeAdapter goalsEditStatsTypeAdapter2 = this.adapter3;
            if (goalsEditStatsTypeAdapter2 != null) {
                goalsEditStatsTypeAdapter2.updateActiveId(Integer.valueOf(((GoalsStatsType) CollectionsKt.first(list)).getId()));
            }
            Timber.INSTANCE.d("updateTargetList-first stat:" + ((GoalsStatsType) CollectionsKt.first(list)).getId(), new Object[0]);
        }
        resetTargetValueInput();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        resetAll();
    }
}
