package com.soletreadmills.sole_v2.ui.club;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.club.GetPublicChallengesToJoinApiData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentClubSearchEventBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter;
import java.io.IOException;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: ClubSearchEventFragment.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u000256B\u0005¢\u0006\u0002\u0010\u0004J&\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u0012H\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0002J\u001a\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\"H\u0016J\b\u0010.\u001a\u00020\"H\u0002J\u0012\u0010/\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\"H\u0016J\b\u00103\u001a\u00020\"H\u0002J\b\u00104\u001a\u00020\"H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00067"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubSearchEventFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentClubSearchEventBinding;", "Landroid/view/View$OnClickListener;", "()V", "challengeListAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubSearchItemAdapter;", "clubViewModel", "Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "getClubViewModel", "()Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "clubViewModel$delegate", "Lkotlin/Lazy;", "hasMoreListData", "", "isListEnd", "isListLoading", "listCurrentPage", "", "listScrollListener", "Lcom/soletreadmills/sole_v2/ui/club/ClubSearchEventFragment$PaginationScrollVerticalListener;", "searchText", "", "getSearchText", "()Ljava/lang/String;", "setSearchText", "(Ljava/lang/String;)V", "totalCount", "getTotalCount", "()Ljava/lang/Integer;", "setTotalCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPublicChallengesList", "", "isReset", "pageSize", "handleChallengeCardClick", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "loadMoreListData", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onDestroyView", "resetPaginationAndSearch", "setupChallengeListRecyclerView", "Companion", "PaginationScrollVerticalListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubSearchEventFragment extends BaseFragment<FragmentClubSearchEventBinding> implements View.OnClickListener {
    private ClubSearchItemAdapter challengeListAdapter;

    /* renamed from: clubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy clubViewModel;
    private boolean isListEnd;
    private boolean isListLoading;
    private PaginationScrollVerticalListener listScrollListener;
    private Integer totalCount;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private int listCurrentPage = 1;
    private boolean hasMoreListData = true;
    private String searchText = "";

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    public ClubSearchEventFragment() {
        final ClubSearchEventFragment clubSearchEventFragment = this;
        final Function0 function0 = null;
        this.clubViewModel = FragmentViewModelLazyKt.createViewModelLazy(clubSearchEventFragment, Reflection.getOrCreateKotlinClass(ClubViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = clubSearchEventFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = clubSearchEventFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = clubSearchEventFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentClubSearchEventBinding access$getBinding(ClubSearchEventFragment clubSearchEventFragment) {
        return clubSearchEventFragment.getBinding();
    }

    /* compiled from: ClubSearchEventFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubSearchEventFragment$Companion;", "", "()V", "newInstance", "Lcom/soletreadmills/sole_v2/ui/club/ClubSearchEventFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClubSearchEventFragment newInstance() {
            return new ClubSearchEventFragment();
        }
    }

    public final ClubViewModel getClubViewModel() {
        return (ClubViewModel) this.clubViewModel.getValue();
    }

    public final String getSearchText() {
        return this.searchText;
    }

    public final void setSearchText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchText = str;
    }

    public final Integer getTotalCount() {
        return this.totalCount;
    }

    public final void setTotalCount(Integer num) {
        this.totalCount = num;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentClubSearchEventBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentClubSearchEventBinding fragmentClubSearchEventBindingInflate = FragmentClubSearchEventBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentClubSearchEventBindingInflate, "inflate(...)");
        return fragmentClubSearchEventBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        ImageView imageView;
        AppCompatEditText appCompatEditText;
        ImageView imageView2;
        AppCompatEditText appCompatEditText2;
        AppCompatEditText appCompatEditText3;
        RecyclerView recyclerView;
        setupChallengeListRecyclerView();
        if (this.totalCount != null) {
            FragmentClubSearchEventBinding binding = getBinding();
            TextView textView = binding != null ? binding.tvTotalCount : null;
            if (textView != null) {
                textView.setText(String.valueOf(this.totalCount));
            }
            FragmentClubSearchEventBinding binding2 = getBinding();
            LinearLayout linearLayout = binding2 != null ? binding2.llTotalCountWrap : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            FragmentClubSearchEventBinding binding3 = getBinding();
            LinearLayout linearLayout2 = binding3 != null ? binding3.llTotalCountWrap : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09561(null), 3, null);
        FragmentClubSearchEventBinding binding4 = getBinding();
        if (binding4 != null && (recyclerView = binding4.rvSearchList) != null) {
            recyclerView.smoothScrollToPosition(0);
        }
        FragmentClubSearchEventBinding binding5 = getBinding();
        if (binding5 != null && (appCompatEditText3 = binding5.editEventName) != null) {
            appCompatEditText3.requestFocus();
        }
        Object systemService = requireContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        FragmentClubSearchEventBinding binding6 = getBinding();
        inputMethodManager.showSoftInput(binding6 != null ? binding6.editEventName : null, 1);
        FragmentClubSearchEventBinding binding7 = getBinding();
        ImageView imageView3 = binding7 != null ? binding7.clearButton : null;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        FragmentClubSearchEventBinding binding8 = getBinding();
        if (binding8 != null && (appCompatEditText2 = binding8.editEventName) != null) {
            appCompatEditText2.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment.initViews.2
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    FragmentClubSearchEventBinding fragmentClubSearchEventBindingAccess$getBinding = ClubSearchEventFragment.access$getBinding(ClubSearchEventFragment.this);
                    ImageView imageView4 = fragmentClubSearchEventBindingAccess$getBinding != null ? fragmentClubSearchEventBindingAccess$getBinding.clearButton : null;
                    if (imageView4 != null) {
                        imageView4.setVisibility(s == null || s.length() == 0 ? 8 : 0);
                    }
                    ClubSearchEventFragment.this.setSearchText(String.valueOf(s));
                }
            });
        }
        FragmentClubSearchEventBinding binding9 = getBinding();
        if (binding9 != null && (imageView2 = binding9.clearButton) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubSearchEventFragment.initViews$lambda$0(this.f$0, view);
                }
            });
        }
        FragmentClubSearchEventBinding binding10 = getBinding();
        if (binding10 != null && (appCompatEditText = binding10.editEventName) != null) {
            appCompatEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment$$ExternalSyntheticLambda1
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                    return ClubSearchEventFragment.initViews$lambda$1(this.f$0, textView2, i, keyEvent);
                }
            });
        }
        FragmentClubSearchEventBinding binding11 = getBinding();
        if (binding11 == null || (imageView = binding11.imgCancel) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClubSearchEventFragment.initViews$lambda$2(this.f$0, view);
            }
        });
    }

    /* compiled from: ClubSearchEventFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment$initViews$1", f = "ClubSearchEventFragment.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment$initViews$1, reason: invalid class name and case insensitive filesystem */
    static final class C09561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09561(Continuation<? super C09561> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubSearchEventFragment.this.new C09561(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ClubSearchEventFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment$initViews$1$1", f = "ClubSearchEventFragment.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment$initViews$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ClubSearchEventFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02341(ClubSearchEventFragment clubSearchEventFragment, Continuation<? super C02341> continuation) {
                super(2, continuation);
                this.this$0 = clubSearchEventFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02341(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow<List<ChallengeItemSimpleData>> searchChallengeList = this.this$0.getClubViewModel().getSearchChallengeList();
                    final ClubSearchEventFragment clubSearchEventFragment = this.this$0;
                    this.label = 1;
                    if (searchChallengeList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment.initViews.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<ChallengeItemSimpleData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<ChallengeItemSimpleData> list, Continuation<? super Unit> continuation) {
                            LinearLayout linearLayout;
                            Timber.INSTANCE.d("NEW_DATA:" + list.size(), new Object[0]);
                            ClubSearchItemAdapter clubSearchItemAdapter = clubSearchEventFragment.challengeListAdapter;
                            if (clubSearchItemAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("challengeListAdapter");
                                clubSearchItemAdapter = null;
                            }
                            clubSearchItemAdapter.submitList(list);
                            if (list.isEmpty()) {
                                FragmentClubSearchEventBinding fragmentClubSearchEventBindingAccess$getBinding = ClubSearchEventFragment.access$getBinding(clubSearchEventFragment);
                                linearLayout = fragmentClubSearchEventBindingAccess$getBinding != null ? fragmentClubSearchEventBindingAccess$getBinding.LLEventsEmpty : null;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(0);
                                }
                            } else {
                                FragmentClubSearchEventBinding fragmentClubSearchEventBindingAccess$getBinding2 = ClubSearchEventFragment.access$getBinding(clubSearchEventFragment);
                                linearLayout = fragmentClubSearchEventBindingAccess$getBinding2 != null ? fragmentClubSearchEventBindingAccess$getBinding2.LLEventsEmpty : null;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(8);
                                }
                            }
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(ClubSearchEventFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new C02341(ClubSearchEventFragment.this, null), this) == coroutine_suspended) {
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
    public static final void initViews$lambda$0(ClubSearchEventFragment this$0, View view) {
        AppCompatEditText appCompatEditText;
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentClubSearchEventBinding binding = this$0.getBinding();
        if (binding == null || (appCompatEditText = binding.editEventName) == null || (text = appCompatEditText.getText()) == null) {
            return;
        }
        text.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initViews$lambda$1(ClubSearchEventFragment this$0, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == 6) {
            this$0.resetPaginationAndSearch();
            return true;
        }
        if (keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0) {
            return false;
        }
        this$0.resetPaginationAndSearch();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2(ClubSearchEventFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClubViewModel().resetSearchChallengesList();
        this$0.safeNavigateUp();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    private final void resetPaginationAndSearch() {
        RecyclerView recyclerView;
        hideKeyboard();
        this.listCurrentPage = 1;
        this.hasMoreListData = true;
        this.isListEnd = false;
        this.isListLoading = false;
        PaginationScrollVerticalListener paginationScrollVerticalListener = this.listScrollListener;
        if (paginationScrollVerticalListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listScrollListener");
            paginationScrollVerticalListener = null;
        }
        paginationScrollVerticalListener.reset();
        getPublicChallengesList$default(this, this.searchText, true, 0, 4, null);
        FragmentClubSearchEventBinding binding = getBinding();
        if (binding == null || (recyclerView = binding.rvSearchList) == null) {
            return;
        }
        recyclerView.smoothScrollToPosition(0);
    }

    static /* synthetic */ void getPublicChallengesList$default(ClubSearchEventFragment clubSearchEventFragment, String str, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            i = 100;
        }
        clubSearchEventFragment.getPublicChallengesList(str, z, i);
    }

    /* compiled from: ClubSearchEventFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment$getPublicChallengesList$1", f = "ClubSearchEventFragment.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment$getPublicChallengesList$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isReset;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ String $searchText;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, int i, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$searchText = str;
            this.$pageSize = i;
            this.$isReset = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubSearchEventFragment.this.new AnonymousClass1(this.$searchText, this.$pageSize, this.$isReset, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCallGetPublicChallengesToJoin;
            Unit unit;
            Response response;
            GetPublicChallengesToJoinApiData.ResponseData responseData;
            PaginationScrollVerticalListener paginationScrollVerticalListener;
            GetPublicChallengesToJoinApiData.DataMap sysResponseData;
            GetPublicChallengesToJoinApiData.DataMap sysResponseData2;
            GetPublicChallengesToJoinApiData.ResponseData responseData2;
            GetPublicChallengesToJoinApiData.DataMap sysResponseData3;
            GetPublicChallengesToJoinApiData.DataMap sysResponseData4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        if (ClubSearchEventFragment.this.isListLoading) {
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                        ClubSearchEventFragment.this.showLoading();
                        ClubSearchEventFragment.this.isListLoading = true;
                        Timber.INSTANCE.d("GetPublicChallengesToJoin (Search):" + ClubSearchEventFragment.this.listCurrentPage, new Object[0]);
                        int i2 = ClubSearchEventFragment.this.listCurrentPage;
                        this.label = 1;
                        objCallGetPublicChallengesToJoin = DyacoApiKt.callGetPublicChallengesToJoin(new GetPublicChallengesToJoinApiData.RequestBodyData(null, this.$searchText, Boxing.boxInt(i2), Boxing.boxInt(this.$pageSize), null, null, null, 113, null), this);
                        if (objCallGetPublicChallengesToJoin == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallGetPublicChallengesToJoin = obj;
                    }
                    response = (Response) objCallGetPublicChallengesToJoin;
                    ClubSearchEventFragment.this.stopLoading();
                    responseData = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    Timber.INSTANCE.d("callGetPublicChallengesToJoin: " + response, new Object[0]);
                    paginationScrollVerticalListener = null;
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubSearchEventFragment.this, "getPublicChallengesList", message, false, 4, null);
                }
                if (responseData != null && responseData.getSuccess()) {
                    GetPublicChallengesToJoinApiData.ResponseData responseData3 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    Integer totalCount = (responseData3 == null || (sysResponseData4 = responseData3.getSysResponseData()) == null) ? null : sysResponseData4.getTotalCount();
                    if (totalCount != null) {
                        ClubSearchEventFragment.this.setTotalCount(totalCount);
                        FragmentClubSearchEventBinding fragmentClubSearchEventBindingAccess$getBinding = ClubSearchEventFragment.access$getBinding(ClubSearchEventFragment.this);
                        TextView textView = fragmentClubSearchEventBindingAccess$getBinding != null ? fragmentClubSearchEventBindingAccess$getBinding.tvTotalCount : null;
                        if (textView != null) {
                            textView.setText(String.valueOf(ClubSearchEventFragment.this.getTotalCount()));
                        }
                        FragmentClubSearchEventBinding fragmentClubSearchEventBindingAccess$getBinding2 = ClubSearchEventFragment.access$getBinding(ClubSearchEventFragment.this);
                        LinearLayout linearLayout = fragmentClubSearchEventBindingAccess$getBinding2 != null ? fragmentClubSearchEventBindingAccess$getBinding2.llTotalCountWrap : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(0);
                        }
                    } else {
                        FragmentClubSearchEventBinding fragmentClubSearchEventBindingAccess$getBinding3 = ClubSearchEventFragment.access$getBinding(ClubSearchEventFragment.this);
                        LinearLayout linearLayout2 = fragmentClubSearchEventBindingAccess$getBinding3 != null ? fragmentClubSearchEventBindingAccess$getBinding3.llTotalCountWrap : null;
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(8);
                        }
                    }
                    GetPublicChallengesToJoinApiData.ResponseData responseData4 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    List<ChallengeItemSimpleData> data = (responseData4 == null || (sysResponseData3 = responseData4.getSysResponseData()) == null) ? null : sysResponseData3.getData();
                    Timber.INSTANCE.d("data totalCount:" + ClubSearchEventFragment.this.getTotalCount(), new Object[0]);
                    Timber.INSTANCE.d("data :ccccccccccc" + data, new Object[0]);
                    GetPublicChallengesToJoinApiData.ResponseData responseData5 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    if (responseData5 != null) {
                        responseData5.getErrorCode();
                    }
                    GetPublicChallengesToJoinApiData.ResponseData responseData6 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    if (responseData6 != null && responseData6.getSuccess() && data != null) {
                        if (this.$isReset) {
                            ClubSearchEventFragment.this.getClubViewModel().updateSearchChallengesList(data);
                        } else {
                            ClubSearchEventFragment.this.getClubViewModel().addToSearchChallengesList(data);
                        }
                        if (data.isEmpty() || data.size() < this.$pageSize) {
                            ClubSearchEventFragment.this.isListEnd = true;
                            ClubSearchEventFragment.this.hasMoreListData = false;
                        }
                    } else {
                        String errorCode = responseData != null ? responseData.getErrorCode() : null;
                        if (ClubSearchEventFragment.this.shouldIgnoreError(errorCode)) {
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required))).get(errorCode);
                        if (num != null) {
                            ClubSearchEventFragment clubSearchEventFragment = ClubSearchEventFragment.this;
                            CustomDialogKt.showCustomDialog$default(clubSearchEventFragment, null, clubSearchEventFragment.getString(num.intValue()), ClubSearchEventFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            BaseFragment.handleUndefinedError$default(ClubSearchEventFragment.this, "getPublicChallengesList", errorCode, (response == null || (responseData2 = (GetPublicChallengesToJoinApiData.ResponseData) response.body()) == null) ? null : responseData2.getErrorMessage(), false, 8, null);
                        }
                    }
                    ClubSearchEventFragment.this.isListLoading = false;
                    PaginationScrollVerticalListener paginationScrollVerticalListener2 = ClubSearchEventFragment.this.listScrollListener;
                    if (paginationScrollVerticalListener2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listScrollListener");
                    } else {
                        paginationScrollVerticalListener = paginationScrollVerticalListener2;
                    }
                    paginationScrollVerticalListener.setLoading(false);
                    ClubSearchEventFragment.this.stopLoading();
                    return Unit.INSTANCE;
                }
                GetPublicChallengesToJoinApiData.ResponseData responseData7 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                Integer totalCount2 = (responseData7 == null || (sysResponseData2 = responseData7.getSysResponseData()) == null) ? null : sysResponseData2.getTotalCount();
                if (totalCount2 != null) {
                    ClubSearchEventFragment.this.setTotalCount(totalCount2);
                    FragmentClubSearchEventBinding fragmentClubSearchEventBindingAccess$getBinding4 = ClubSearchEventFragment.access$getBinding(ClubSearchEventFragment.this);
                    TextView textView2 = fragmentClubSearchEventBindingAccess$getBinding4 != null ? fragmentClubSearchEventBindingAccess$getBinding4.tvTotalCount : null;
                    if (textView2 != null) {
                        textView2.setText(String.valueOf(ClubSearchEventFragment.this.getTotalCount()));
                    }
                    FragmentClubSearchEventBinding fragmentClubSearchEventBindingAccess$getBinding5 = ClubSearchEventFragment.access$getBinding(ClubSearchEventFragment.this);
                    LinearLayout linearLayout3 = fragmentClubSearchEventBindingAccess$getBinding5 != null ? fragmentClubSearchEventBindingAccess$getBinding5.llTotalCountWrap : null;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(0);
                    }
                } else {
                    FragmentClubSearchEventBinding fragmentClubSearchEventBindingAccess$getBinding6 = ClubSearchEventFragment.access$getBinding(ClubSearchEventFragment.this);
                    LinearLayout linearLayout4 = fragmentClubSearchEventBindingAccess$getBinding6 != null ? fragmentClubSearchEventBindingAccess$getBinding6.llTotalCountWrap : null;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(8);
                    }
                }
                GetPublicChallengesToJoinApiData.ResponseData responseData8 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                List<ChallengeItemSimpleData> data2 = (responseData8 == null || (sysResponseData = responseData8.getSysResponseData()) == null) ? null : sysResponseData.getData();
                Timber.INSTANCE.d("data totalCount:" + ClubSearchEventFragment.this.getTotalCount(), new Object[0]);
                Timber.INSTANCE.d("data :ccccccccccc" + data2, new Object[0]);
                GetPublicChallengesToJoinApiData.ResponseData responseData9 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                String errorCode2 = responseData9 != null ? responseData9.getErrorCode() : null;
                GetPublicChallengesToJoinApiData.ResponseData responseData10 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                if (responseData10 == null || !responseData10.getSuccess() || data2 == null) {
                    if (ClubSearchEventFragment.this.shouldIgnoreError(errorCode2)) {
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                    Integer num2 = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required))).get(errorCode2);
                    if (num2 != null) {
                        ClubSearchEventFragment clubSearchEventFragment2 = ClubSearchEventFragment.this;
                        CustomDialogKt.showCustomDialog$default(clubSearchEventFragment2, null, clubSearchEventFragment2.getString(num2.intValue()), ClubSearchEventFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                    } else {
                        ClubSearchEventFragment clubSearchEventFragment3 = ClubSearchEventFragment.this;
                        GetPublicChallengesToJoinApiData.ResponseData responseData11 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                        BaseFragment.handleUndefinedError$default(clubSearchEventFragment3, "getPublicChallengesList", errorCode2, responseData11 != null ? responseData11.getErrorMessage() : null, false, 8, null);
                    }
                } else {
                    if (this.$isReset) {
                        ClubSearchEventFragment.this.getClubViewModel().updateSearchChallengesList(data2);
                    } else {
                        ClubSearchEventFragment.this.getClubViewModel().addToSearchChallengesList(data2);
                    }
                    if (data2.isEmpty() || data2.size() < this.$pageSize) {
                        ClubSearchEventFragment.this.isListEnd = true;
                        ClubSearchEventFragment.this.hasMoreListData = false;
                    }
                }
                ClubSearchEventFragment.this.isListLoading = false;
                PaginationScrollVerticalListener paginationScrollVerticalListener3 = ClubSearchEventFragment.this.listScrollListener;
                if (paginationScrollVerticalListener3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listScrollListener");
                } else {
                    paginationScrollVerticalListener = paginationScrollVerticalListener3;
                }
                paginationScrollVerticalListener.setLoading(false);
                ClubSearchEventFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ClubSearchEventFragment.this.stopLoading();
            }
        }
    }

    private final void getPublicChallengesList(String searchText, boolean isReset, int pageSize) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(searchText, pageSize, isReset, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMoreListData() {
        Timber.INSTANCE.d("===== loadMore...", new Object[0]);
        if (this.isListLoading || !this.hasMoreListData || this.isListEnd) {
            return;
        }
        this.listCurrentPage++;
        getPublicChallengesList$default(this, this.searchText, false, 0, 4, null);
    }

    private final void setupChallengeListRecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.challengeListAdapter = new ClubSearchItemAdapter(mainActivity, new ClubSearchItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment$setupChallengeListRecyclerView$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.OnItemClickListener
                public void onDeleteClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                }

                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.OnItemClickListener
                public void onQuitClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                }

                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.OnItemClickListener
                public void onClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.handleChallengeCardClick(item);
                }
            }, true, false, 8, null);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        FragmentClubSearchEventBinding binding = getBinding();
        PaginationScrollVerticalListener paginationScrollVerticalListener = null;
        if (binding != null && (recyclerView2 = binding.rvSearchList) != null) {
            ClubSearchItemAdapter clubSearchItemAdapter = this.challengeListAdapter;
            if (clubSearchItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("challengeListAdapter");
                clubSearchItemAdapter = null;
            }
            recyclerView2.setAdapter(clubSearchItemAdapter);
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        this.listScrollListener = new PaginationScrollVerticalListener(linearLayoutManager, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubSearchEventFragment.setupChallengeListRecyclerView.3
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
                ClubSearchEventFragment.this.loadMoreListData();
            }
        });
        FragmentClubSearchEventBinding binding2 = getBinding();
        if (binding2 == null || (recyclerView = binding2.rvSearchList) == null) {
            return;
        }
        PaginationScrollVerticalListener paginationScrollVerticalListener2 = this.listScrollListener;
        if (paginationScrollVerticalListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listScrollListener");
        } else {
            paginationScrollVerticalListener = paginationScrollVerticalListener2;
        }
        recyclerView.addOnScrollListener(paginationScrollVerticalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleChallengeCardClick(ChallengeItemSimpleData item) {
        getClubViewModel().setSelectChallengeId(item.getChallengeUuid());
        BaseFragment.safeNavigate$default(this, R.id.clubEventDetailFragment, null, 2, null);
    }

    /* compiled from: ClubSearchEventFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J \u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubSearchEventFragment$PaginationScrollVerticalListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", SdkConstants.ATTR_LAYOUT_MANAGER, "Landroidx/recyclerview/widget/LinearLayoutManager;", "onLoadMore", "Lkotlin/Function0;", "", "(Landroidx/recyclerview/widget/LinearLayoutManager;Lkotlin/jvm/functions/Function0;)V", "loading", "", "previousTotal", "", "visibleThreshold", "onScrolled", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "reset", "setLoading", "isLoading", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PaginationScrollVerticalListener extends RecyclerView.OnScrollListener {
        public static final int $stable = 8;
        private final LinearLayoutManager layoutManager;
        private boolean loading;
        private final Function0<Unit> onLoadMore;
        private int previousTotal;
        private final int visibleThreshold;

        public PaginationScrollVerticalListener(LinearLayoutManager layoutManager, Function0<Unit> onLoadMore) {
            Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
            Intrinsics.checkNotNullParameter(onLoadMore, "onLoadMore");
            this.layoutManager = layoutManager;
            this.onLoadMore = onLoadMore;
            this.visibleThreshold = 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            if (dy <= 0) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int itemCount = this.layoutManager.getItemCount();
            int iFindFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
            int iFindLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
            Timber.INSTANCE.d("Scroll info: visibleItemCount=" + childCount + ", totalItemCount=" + itemCount + ", firstVisibleItem=" + iFindFirstVisibleItemPosition + ", loading=" + this.loading + ", previousTotal=" + this.previousTotal, new Object[0]);
            if (this.loading && itemCount > this.previousTotal) {
                this.loading = false;
                this.previousTotal = itemCount;
            }
            if (this.loading || this.visibleThreshold + iFindLastVisibleItemPosition < itemCount) {
                return;
            }
            Timber.INSTANCE.d("Triggering load more... lastVisibleItem=" + iFindLastVisibleItemPosition + ", threshold=" + this.visibleThreshold + ", totalItemCount=" + itemCount, new Object[0]);
            this.loading = true;
            this.onLoadMore.invoke();
        }

        public final void setLoading(boolean isLoading) {
            this.loading = isLoading;
            Timber.INSTANCE.d("ScrollListener setLoading: " + isLoading, new Object[0]);
        }

        public final void reset() {
            this.loading = false;
            this.previousTotal = 0;
            Timber.INSTANCE.d("ScrollListener reset", new Object[0]);
        }
    }
}
