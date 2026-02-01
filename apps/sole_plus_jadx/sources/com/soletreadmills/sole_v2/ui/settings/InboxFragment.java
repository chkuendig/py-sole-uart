package com.soletreadmills.sole_v2.ui.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.settings.DeleteMessageApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetMessagesApiData;
import com.soletreadmills.sole_v2._data.api.settings.PatchAllMessageStatusApiData;
import com.soletreadmills.sole_v2._network.JwtNotificationDyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentInboxBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.settings.InboxAdapter;
import com.sun.jna.platform.win32.WinError;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: InboxFragment.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\u0011J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\u0012\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0016\u0010 \u001a\u00020\u00112\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"J\u0006\u0010$\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/InboxFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentInboxBinding;", "Landroid/view/View$OnClickListener;", "()V", "isLastPage", "", "isLoadingMore", "page", "", "settingViewModel", "Lcom/soletreadmills/sole_v2/ui/settings/SettingViewModel;", "getSettingViewModel", "()Lcom/soletreadmills/sole_v2/ui/settings/SettingViewModel;", "settingViewModel$delegate", "Lkotlin/Lazy;", "deleteMessage", "", "messageId", "", "getInboxMessage", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initScrollListener", "initViews", "loadNextPage", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "setRecyclerView", "list", "", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$MessageData;", "updateMessageStatus", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InboxFragment extends BaseFragment<FragmentInboxBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private boolean isLastPage;
    private boolean isLoadingMore;
    private int page = 1;

    /* renamed from: settingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingViewModel;

    public InboxFragment() {
        final InboxFragment inboxFragment = this;
        final Function0 function0 = null;
        this.settingViewModel = FragmentViewModelLazyKt.createViewModelLazy(inboxFragment, Reflection.getOrCreateKotlinClass(SettingViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.settings.InboxFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = inboxFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.settings.InboxFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = inboxFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.settings.InboxFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = inboxFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentInboxBinding access$getBinding(InboxFragment inboxFragment) {
        return inboxFragment.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingViewModel getSettingViewModel() {
        return (SettingViewModel) this.settingViewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentInboxBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentInboxBinding fragmentInboxBindingInflate = FragmentInboxBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentInboxBindingInflate, "inflate(...)");
        return fragmentInboxBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        LinearLayout linearLayout;
        ImageView imageView;
        FragmentInboxBinding binding = getBinding();
        if (binding != null && (imageView = binding.back) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentInboxBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout = binding2.LLMarkAllRead) != null) {
            linearLayout.setOnClickListener(this);
        }
        getInboxMessage();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.LL_markAllRead;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            updateMessageStatus();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setRecyclerView(java.util.List<com.soletreadmills.sole_v2._data.api.settings.GetMessagesApiData.MessageData> r15) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.settings.InboxFragment.setRecyclerView(java.util.List):void");
    }

    private final void initScrollListener() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        FragmentInboxBinding binding = getBinding();
        if (binding != null && (recyclerView2 = binding.rv) != null) {
            recyclerView2.clearOnScrollListeners();
        }
        FragmentInboxBinding binding2 = getBinding();
        if (binding2 == null || (recyclerView = binding2.rv) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soletreadmills.sole_v2.ui.settings.InboxFragment.initScrollListener.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView3, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView3, "recyclerView");
                super.onScrolled(recyclerView3, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView3.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                int itemCount = linearLayoutManager.getItemCount();
                if (InboxFragment.this.isLoadingMore || InboxFragment.this.isLastPage || iFindLastVisibleItemPosition != itemCount - 1) {
                    return;
                }
                InboxFragment.this.loadNextPage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadNextPage() {
        this.isLoadingMore = true;
        this.page++;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09971(null), 3, null);
    }

    /* compiled from: InboxFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.InboxFragment$loadNextPage$1", f = "InboxFragment.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.InboxFragment$loadNextPage$1, reason: invalid class name and case insensitive filesystem */
    static final class C09971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09971(Continuation<? super C09971> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InboxFragment.this.new C09971(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            GetMessagesApiData.ResponseData responseData;
            InboxAdapter inboxAdapter;
            RecyclerView recyclerView;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = JwtNotificationDyacoApiKt.callGetMessages(new GetMessagesApiData.RequestBody(InboxFragment.this.page), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    responseData = (GetMessagesApiData.ResponseData) ((Response) obj).body();
                    FragmentInboxBinding fragmentInboxBindingAccess$getBinding = InboxFragment.access$getBinding(InboxFragment.this);
                    RecyclerView.Adapter adapter = (fragmentInboxBindingAccess$getBinding == null || (recyclerView = fragmentInboxBindingAccess$getBinding.rv) == null) ? null : recyclerView.getAdapter();
                    inboxAdapter = adapter instanceof InboxAdapter ? (InboxAdapter) adapter : null;
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(InboxFragment.this, "loadNextPage", message, false, 4, null);
                }
                if (inboxAdapter == null) {
                    return Unit.INSTANCE;
                }
                List<GetMessagesApiData.MessageData> result = responseData != null ? responseData.getResult() : null;
                List<GetMessagesApiData.MessageData> list = result;
                if (list == null || list.isEmpty()) {
                    InboxFragment.this.isLastPage = true;
                    inboxAdapter.setShowFooter(true);
                } else {
                    List<GetMessagesApiData.MessageData> currentList = inboxAdapter.getCurrentList();
                    Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                    List mutableList = CollectionsKt.toMutableList((Collection) currentList);
                    mutableList.addAll(result);
                    inboxAdapter.setShowFooter(false);
                    inboxAdapter.submitList(mutableList);
                }
                InboxFragment.this.isLoadingMore = false;
                return Unit.INSTANCE;
            } finally {
                InboxFragment.this.isLoadingMore = false;
            }
        }
    }

    /* compiled from: InboxFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.InboxFragment$getInboxMessage$1", f = "InboxFragment.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.InboxFragment$getInboxMessage$1, reason: invalid class name and case insensitive filesystem */
    static final class C09951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09951(Continuation<? super C09951> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InboxFragment.this.new C09951(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x007d A[Catch: all -> 0x000f, Exception -> 0x0012, TryCatch #0 {Exception -> 0x0012, blocks: (B:5:0x000b, B:17:0x0047, B:19:0x0052, B:21:0x0058, B:23:0x0060, B:25:0x0066, B:29:0x0081, B:28:0x007d, B:31:0x0089, B:33:0x0090, B:35:0x0098, B:38:0x00a0, B:40:0x00a8, B:41:0x00ac, B:14:0x0020), top: B:51:0x0007, outer: #1 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                Method dump skipped, instructions count: 234
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.settings.InboxFragment.C09951.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void getInboxMessage() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09951(null), 3, null);
    }

    /* compiled from: InboxFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.InboxFragment$deleteMessage$1", f = "InboxFragment.kt", i = {}, l = {WinError.ERROR_BAD_PIPE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.InboxFragment$deleteMessage$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $messageId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$messageId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InboxFragment.this.new AnonymousClass1(this.$messageId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        InboxFragment.this.showLoading();
                        this.label = 1;
                        obj = JwtNotificationDyacoApiKt.callDeleteMessage(new DeleteMessageApiData.RequestBody(this.$messageId), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    DeleteMessageApiData.ResponseData responseData = (DeleteMessageApiData.ResponseData) ((Response) obj).body();
                    if (Intrinsics.areEqual(responseData != null ? responseData.getCode() : null, "200")) {
                        InboxFragment.this.getInboxMessage();
                    } else {
                        String code = responseData != null ? responseData.getCode() : null;
                        if (InboxFragment.this.shouldIgnoreError(code)) {
                            return Unit.INSTANCE;
                        }
                        BaseFragment.handleUndefinedError$default(InboxFragment.this, "deleteMessage", code, responseData != null ? responseData.getMessage() : null, false, 8, null);
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(InboxFragment.this, "deleteMessage", message, false, 4, null);
                }
                InboxFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                InboxFragment.this.stopLoading();
            }
        }
    }

    public final void deleteMessage(String messageId) {
        if (messageId == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(messageId, null), 3, null);
    }

    /* compiled from: InboxFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.InboxFragment$updateMessageStatus$1", f = "InboxFragment.kt", i = {}, l = {270}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.InboxFragment$updateMessageStatus$1, reason: invalid class name and case insensitive filesystem */
    static final class C09981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09981(Continuation<? super C09981> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InboxFragment.this.new C09981(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09981) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = JwtNotificationDyacoApiKt.callPatchAllMessageStatus(new PatchAllMessageStatusApiData.RequestBody(), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                PatchAllMessageStatusApiData.ResponseData responseData = (PatchAllMessageStatusApiData.ResponseData) ((Response) obj).body();
                if (Intrinsics.areEqual(responseData != null ? responseData.getCode() : null, "200")) {
                    InboxFragment.this.getInboxMessage();
                } else {
                    String code = responseData != null ? responseData.getCode() : null;
                    if (InboxFragment.this.shouldIgnoreError(code)) {
                        return Unit.INSTANCE;
                    }
                    BaseFragment.handleUndefinedError$default(InboxFragment.this, "updateMessageStatus", code, responseData != null ? responseData.getMessage() : null, false, 8, null);
                }
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
                String message = e.getMessage();
                if (message == null) {
                    message = e.getClass().getSimpleName();
                }
                BaseFragment.handleApiError$default(InboxFragment.this, "updateMessageStatus", message, false, 4, null);
            }
            return Unit.INSTANCE;
        }
    }

    public final void updateMessageStatus() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09981(null), 3, null);
    }
}
