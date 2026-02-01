package com.soletreadmills.sole_v2.ui.classes;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.soletreadmills.sole_v2._data.classes.ClassCollectionData;
import com.soletreadmills.sole_v2._data.classes.ClassesData;
import com.sun.jna.platform.win32.WinError;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;
import org.objectweb.asm.Opcodes;
import timber.log.Timber;

/* compiled from: ClassesSearchViewModel.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002&'B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010\u001eJ\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\u0006\u0010\"\u001a\u00020\u001dJ\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u00060\u0012R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0016\u001a\u00060\u0017R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/ClassesSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "classesType", "Lcom/soletreadmills/sole_v2/ui/classes/ClassesType;", "getClassesType", "()Lcom/soletreadmills/sole_v2/ui/classes/ClassesType;", "setClassesType", "(Lcom/soletreadmills/sole_v2/ui/classes/ClassesType;)V", "currentPage", "", "hasMoreData", "", "getHasMoreData", "()Z", "setHasMoreData", "(Z)V", "input", "Lcom/soletreadmills/sole_v2/ui/classes/ClassesSearchViewModel$Input;", "getInput", "()Lcom/soletreadmills/sole_v2/ui/classes/ClassesSearchViewModel$Input;", "isGetMore", "output", "Lcom/soletreadmills/sole_v2/ui/classes/ClassesSearchViewModel$Output;", "getOutput", "()Lcom/soletreadmills/sole_v2/ui/classes/ClassesSearchViewModel$Output;", "searchJob", "Lkotlinx/coroutines/Job;", "API_GetClassList", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "API_GetCollections", "clearResults", "fetchData", "getMoreData", "handleSearch", "text", "", "Input", "Output", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesSearchViewModel extends ViewModel {
    public static final int $stable = 8;
    private boolean hasMoreData;
    private boolean isGetMore;
    private Job searchJob;
    private ClassesType classesType = ClassesType.SESSION;
    private int currentPage = 1;
    private final Input input = new Input();
    private final Output output = new Output();

    /* compiled from: ClassesSearchViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesSearchViewModel", f = "ClassesSearchViewModel.kt", i = {0, 1}, l = {146, Opcodes.ARETURN}, m = "API_GetClassList", n = {"this", "this"}, s = {"L$0", "L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesSearchViewModel$API_GetClassList$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClassesSearchViewModel.this.API_GetClassList(this);
        }
    }

    /* compiled from: ClassesSearchViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesSearchViewModel", f = "ClassesSearchViewModel.kt", i = {0, 1}, l = {188, WinError.ERROR_EXE_CANNOT_MODIFY_STRONG_SIGNED_BINARY}, m = "API_GetCollections", n = {"this", "this"}, s = {"L$0", "L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesSearchViewModel$API_GetCollections$1, reason: invalid class name and case insensitive filesystem */
    static final class C08841 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08841(Continuation<? super C08841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClassesSearchViewModel.this.API_GetCollections(this);
        }
    }

    /* compiled from: ClassesSearchViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClassesType.values().length];
            try {
                iArr[ClassesType.SESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClassesType.COLLECTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final ClassesType getClassesType() {
        return this.classesType;
    }

    public final void setClassesType(ClassesType classesType) {
        Intrinsics.checkNotNullParameter(classesType, "<set-?>");
        this.classesType = classesType;
    }

    public final boolean getHasMoreData() {
        return this.hasMoreData;
    }

    public final void setHasMoreData(boolean z) {
        this.hasMoreData = z;
    }

    public final Input getInput() {
        return this.input;
    }

    /* compiled from: ClassesSearchViewModel.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/ClassesSearchViewModel$Input;", "", "(Lcom/soletreadmills/sole_v2/ui/classes/ClassesSearchViewModel;)V", "searchData", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getSearchData", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setSearchText", "", "text", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class Input {
        private final MutableStateFlow<String> searchData = StateFlowKt.MutableStateFlow("");

        public Input() {
        }

        public final MutableStateFlow<String> getSearchData() {
            return this.searchData;
        }

        public final void setSearchText(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.searchData.setValue(text);
            ClassesSearchViewModel.this.handleSearch(text);
        }
    }

    public final Output getOutput() {
        return this.output;
    }

    /* compiled from: ClassesSearchViewModel.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/ClassesSearchViewModel$Output;", "", "(Lcom/soletreadmills/sole_v2/ui/classes/ClassesSearchViewModel;)V", "collectionsResults", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionData;", "getCollectionsResults", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "errorData", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getErrorData", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "hasReachedEnd", "", "getHasReachedEnd", "isLoading", "sessionResults", "Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", "getSessionResults", "totalCount", "", "getTotalCount", "setTotalCount", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class Output {
        private final MutableStateFlow<List<ClassesData>> sessionResults = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        private final MutableStateFlow<List<ClassCollectionData>> collectionsResults = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        private final MutableSharedFlow<String> errorData = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        private MutableStateFlow<Integer> totalCount = StateFlowKt.MutableStateFlow(0);
        private final MutableStateFlow<Boolean> isLoading = StateFlowKt.MutableStateFlow(false);
        private final MutableStateFlow<Boolean> hasReachedEnd = StateFlowKt.MutableStateFlow(false);

        public Output() {
        }

        public final MutableStateFlow<List<ClassesData>> getSessionResults() {
            return this.sessionResults;
        }

        public final MutableStateFlow<List<ClassCollectionData>> getCollectionsResults() {
            return this.collectionsResults;
        }

        public final MutableSharedFlow<String> getErrorData() {
            return this.errorData;
        }

        public final MutableStateFlow<Integer> getTotalCount() {
            return this.totalCount;
        }

        public final void setTotalCount(MutableStateFlow<Integer> mutableStateFlow) {
            Intrinsics.checkNotNullParameter(mutableStateFlow, "<set-?>");
            this.totalCount = mutableStateFlow;
        }

        public final MutableStateFlow<Boolean> isLoading() {
            return this.isLoading;
        }

        public final MutableStateFlow<Boolean> getHasReachedEnd() {
            return this.hasReachedEnd;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSearch(String text) {
        Job job = this.searchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.searchJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C08861(text, null), 3, null);
    }

    /* compiled from: ClassesSearchViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesSearchViewModel$handleSearch$1", f = "ClassesSearchViewModel.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesSearchViewModel$handleSearch$1, reason: invalid class name and case insensitive filesystem */
    static final class C08861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $text;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08861(String str, Continuation<? super C08861> continuation) {
            super(2, continuation);
            this.$text = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClassesSearchViewModel.this.new C08861(this.$text, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(300L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ClassesSearchViewModel.this.isGetMore = false;
            ClassesSearchViewModel.this.currentPage = 1;
            ClassesSearchViewModel.this.setHasMoreData(false);
            ClassesSearchViewModel.this.getOutput().getHasReachedEnd().setValue(Boxing.boxBoolean(false));
            if (StringsKt.isBlank(this.$text)) {
                ClassesSearchViewModel.this.clearResults();
            } else {
                ClassesSearchViewModel.this.fetchData();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearResults() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.classesType.ordinal()];
        if (i == 1) {
            this.output.getSessionResults().setValue(CollectionsKt.emptyList());
        } else if (i == 2) {
            this.output.getCollectionsResults().setValue(CollectionsKt.emptyList());
        }
        this.hasMoreData = false;
        this.output.getHasReachedEnd().setValue(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchData() {
        if (!this.output.isLoading().getValue().booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C08851(null), 3, null);
        } else {
            Timber.INSTANCE.w("⚠️ 正在加載中，跳過", new Object[0]);
        }
    }

    /* compiled from: ClassesSearchViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesSearchViewModel$fetchData$1", f = "ClassesSearchViewModel.kt", i = {}, l = {110, 111, 115}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesSearchViewModel$fetchData$1, reason: invalid class name and case insensitive filesystem */
    static final class C08851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* compiled from: ClassesSearchViewModel.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesSearchViewModel$fetchData$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ClassesType.values().length];
                try {
                    iArr[ClassesType.SESSION.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ClassesType.COLLECTION.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        C08851(Continuation<? super C08851> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClassesSearchViewModel.this.new C08851(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0093 -> B:40:0x0096). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                } catch (Exception e) {
                    Timber.INSTANCE.e(e, "❌ 加載失敗", new Object[0]);
                    MutableSharedFlow<String> errorData = ClassesSearchViewModel.this.getOutput().getErrorData();
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "Unknown error";
                    }
                    this.label = 3;
                    if (errorData.emit(localizedMessage, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ClassesSearchViewModel.this.getOutput().isLoading().setValue(Boxing.boxBoolean(true));
                    int i2 = WhenMappings.$EnumSwitchMapping$0[ClassesSearchViewModel.this.getClassesType().ordinal()];
                    if (i2 == 1) {
                        this.label = 1;
                        if (ClassesSearchViewModel.this.API_GetClassList(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i2 == 2) {
                        this.label = 2;
                        if (ClassesSearchViewModel.this.API_GetCollections(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        ClassesSearchViewModel.this.getOutput().isLoading().setValue(Boxing.boxBoolean(false));
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ClassesSearchViewModel.this.getOutput().isLoading().setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            } catch (Throwable th) {
                ClassesSearchViewModel.this.getOutput().isLoading().setValue(Boxing.boxBoolean(false));
                throw th;
            }
        }
    }

    public final void getMoreData() {
        if (this.output.isLoading().getValue().booleanValue()) {
            Timber.INSTANCE.w("⚠️ 正在加載中，跳過", new Object[0]);
            return;
        }
        if (!this.hasMoreData) {
            Timber.INSTANCE.w("⚠️ 沒有更多資料了", new Object[0]);
            this.output.getHasReachedEnd().setValue(true);
        } else {
            Timber.INSTANCE.d("📥 開始加載更多資料... (page: " + (this.currentPage + 1) + ')', new Object[0]);
            this.currentPage++;
            this.isGetMore = true;
            fetchData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6 A[Catch: Exception -> 0x0172, TryCatch #5 {Exception -> 0x0172, blocks: (B:32:0x0094, B:34:0x009e, B:36:0x00a4, B:38:0x00aa, B:40:0x00b6, B:42:0x00bc, B:45:0x00c6, B:47:0x00cc, B:49:0x00d2, B:51:0x00d8, B:53:0x00e9, B:54:0x00fb, B:58:0x010e, B:60:0x0112, B:61:0x011f, B:44:0x00c2), top: B:94:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0143 A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:67:0x0163, B:69:0x0167, B:63:0x013d, B:64:0x0143), top: B:85:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0167 A[Catch: Exception -> 0x0170, TRY_LEAVE, TryCatch #0 {Exception -> 0x0170, blocks: (B:67:0x0163, B:69:0x0167, B:63:0x013d, B:64:0x0143), top: B:85:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x018d  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.soletreadmills.sole_v2.ui.classes.ClassesSearchViewModel] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [com.soletreadmills.sole_v2.ui.classes.ClassesSearchViewModel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object API_GetClassList(kotlin.coroutines.Continuation<? super kotlin.Unit> r21) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.ClassesSearchViewModel.API_GetClassList(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa A[Catch: Exception -> 0x0165, TryCatch #3 {Exception -> 0x0165, blocks: (B:32:0x0088, B:34:0x0092, B:36:0x0098, B:38:0x009e, B:40:0x00aa, B:42:0x00b0, B:45:0x00ba, B:47:0x00c0, B:49:0x00c6, B:51:0x00cc, B:53:0x00dd, B:54:0x00ef, B:58:0x0102, B:60:0x0106, B:61:0x0113, B:44:0x00b6, B:62:0x0136), top: B:90:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0136 A[Catch: Exception -> 0x0165, TRY_LEAVE, TryCatch #3 {Exception -> 0x0165, blocks: (B:32:0x0088, B:34:0x0092, B:36:0x0098, B:38:0x009e, B:40:0x00aa, B:42:0x00b0, B:45:0x00ba, B:47:0x00c0, B:49:0x00c6, B:51:0x00cc, B:53:0x00dd, B:54:0x00ef, B:58:0x0102, B:60:0x0106, B:61:0x0113, B:44:0x00b6, B:62:0x0136), top: B:90:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015a A[Catch: Exception -> 0x0163, TRY_LEAVE, TryCatch #5 {Exception -> 0x0163, blocks: (B:66:0x0156, B:68:0x015a), top: B:93:0x0156 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object API_GetCollections(kotlin.coroutines.Continuation<? super kotlin.Unit> r19) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.ClassesSearchViewModel.API_GetCollections(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
