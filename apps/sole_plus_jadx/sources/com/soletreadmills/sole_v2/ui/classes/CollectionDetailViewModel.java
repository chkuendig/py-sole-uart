package com.soletreadmills.sole_v2.ui.classes;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.lifecycle.ViewModel;
import com.soletreadmills.sole_v2._data.classes.CollectionDetailData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: CollectionDetailViewModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u000e\u0010\u001a\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u000e\u0010\u001b\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/CollectionDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "collectionId", "", "getCollectionId", "()Ljava/lang/String;", "setCollectionId", "(Ljava/lang/String;)V", "<set-?>", "Lcom/soletreadmills/sole_v2/_data/classes/CollectionDetailData;", "data", "getData", "()Lcom/soletreadmills/sole_v2/_data/classes/CollectionDetailData;", "setData", "(Lcom/soletreadmills/sole_v2/_data/classes/CollectionDetailData;)V", "data$delegate", "Landroidx/compose/runtime/MutableState;", "errorData", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getErrorData", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "apiDeleteFavorite", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apiGetCollectionDetail", "apiPostCollectionClick", "apiPostFavorite", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CollectionDetailViewModel extends ViewModel {
    public static final int $stable = 8;

    /* renamed from: data$delegate, reason: from kotlin metadata */
    private final MutableState data = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    private String collectionId = "";
    private final MutableSharedFlow<String> errorData = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);

    /* compiled from: CollectionDetailViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel", f = "CollectionDetailViewModel.kt", i = {0}, l = {88, 90}, m = "apiDeleteFavorite", n = {"this"}, s = {"L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel$apiDeleteFavorite$1, reason: invalid class name */
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
            return CollectionDetailViewModel.this.apiDeleteFavorite(this);
        }
    }

    /* compiled from: CollectionDetailViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel", f = "CollectionDetailViewModel.kt", i = {0}, l = {42, 49}, m = "apiGetCollectionDetail", n = {"this"}, s = {"L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel$apiGetCollectionDetail$1, reason: invalid class name and case insensitive filesystem */
    static final class C08901 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08901(Continuation<? super C08901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionDetailViewModel.this.apiGetCollectionDetail(this);
        }
    }

    /* compiled from: CollectionDetailViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel", f = "CollectionDetailViewModel.kt", i = {0, 0, 1}, l = {28, 33, 36}, m = "apiPostCollectionClick", n = {"this", "$this$apiPostCollectionClick_u24lambda_u240", "this"}, s = {"L$0", "L$1", "L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel$apiPostCollectionClick$1, reason: invalid class name and case insensitive filesystem */
    static final class C08911 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C08911(Continuation<? super C08911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionDetailViewModel.this.apiPostCollectionClick(this);
        }
    }

    /* compiled from: CollectionDetailViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel", f = "CollectionDetailViewModel.kt", i = {0}, l = {71, 73}, m = "apiPostFavorite", n = {"this"}, s = {"L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel$apiPostFavorite$1, reason: invalid class name and case insensitive filesystem */
    static final class C08921 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08921(Continuation<? super C08921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionDetailViewModel.this.apiPostFavorite(this);
        }
    }

    private final void setData(CollectionDetailData collectionDetailData) {
        this.data.setValue(collectionDetailData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CollectionDetailData getData() {
        return (CollectionDetailData) this.data.getValue();
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final void setCollectionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.collectionId = str;
    }

    public final MutableSharedFlow<String> getErrorData() {
        return this.errorData;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiPostCollectionClick(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "網路異常 ("
            boolean r1 = r10 instanceof com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel.C08911
            if (r1 == 0) goto L16
            r1 = r10
            com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel$apiPostCollectionClick$1 r1 = (com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel.C08911) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r10 = r1.label
            int r10 = r10 - r3
            r1.label = r10
            goto L1b
        L16:
            com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel$apiPostCollectionClick$1 r1 = new com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel$apiPostCollectionClick$1
            r1.<init>(r10)
        L1b:
            java.lang.Object r10 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 3
            r6 = 2
            r7 = 1
            if (r3 == 0) goto L57
            if (r3 == r7) goto L48
            if (r3 == r6) goto L3e
            if (r3 != r5) goto L36
            java.lang.Object r0 = r1.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lcb
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3e:
            java.lang.Object r0 = r1.L$0
            com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel r0 = (com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L46
            goto La1
        L46:
            r10 = move-exception
            goto Laa
        L48:
            java.lang.Object r3 = r1.L$1
            com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel r3 = (com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel) r3
            java.lang.Object r7 = r1.L$0
            com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel r7 = (com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel) r7
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L54
            goto L72
        L54:
            r10 = move-exception
            r0 = r7
            goto Laa
        L57:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result$Companion r10 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> La8
            r10 = r9
            com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel r10 = (com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel) r10     // Catch: java.lang.Throwable -> La8
            java.lang.String r10 = "sole"
            java.lang.String r3 = r9.collectionId     // Catch: java.lang.Throwable -> La8
            r1.L$0 = r9     // Catch: java.lang.Throwable -> La8
            r1.L$1 = r9     // Catch: java.lang.Throwable -> La8
            r1.label = r7     // Catch: java.lang.Throwable -> La8
            java.lang.Object r10 = com.soletreadmills.sole_v2._network.JwtDyacoApiKt.callPostCollectionClick(r10, r3, r1)     // Catch: java.lang.Throwable -> La8
            if (r10 != r2) goto L70
            return r2
        L70:
            r3 = r9
            r7 = r3
        L72:
            retrofit2.Response r10 = (retrofit2.Response) r10     // Catch: java.lang.Throwable -> L54
            boolean r8 = r10.isSuccessful()     // Catch: java.lang.Throwable -> L54
            if (r8 != 0) goto La0
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> r3 = r3.errorData     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L54
            int r10 = r10.code()     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r10 = r8.append(r10)     // Catch: java.lang.Throwable -> L54
            r0 = 41
            java.lang.StringBuilder r10 = r10.append(r0)     // Catch: java.lang.Throwable -> L54
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L54
            r1.L$0 = r7     // Catch: java.lang.Throwable -> L54
            r1.L$1 = r4     // Catch: java.lang.Throwable -> L54
            r1.label = r6     // Catch: java.lang.Throwable -> L54
            java.lang.Object r10 = r3.emit(r10, r1)     // Catch: java.lang.Throwable -> L54
            if (r10 != r2) goto La0
            return r2
        La0:
            r0 = r7
        La1:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L46
            java.lang.Object r10 = kotlin.Result.m9087constructorimpl(r10)     // Catch: java.lang.Throwable -> L46
            goto Lb4
        La8:
            r10 = move-exception
            r0 = r9
        Laa:
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m9087constructorimpl(r10)
        Lb4:
            java.lang.Throwable r3 = kotlin.Result.m9090exceptionOrNullimpl(r10)
            if (r3 == 0) goto Lcb
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> r0 = r0.errorData
            r1.L$0 = r10
            r1.L$1 = r4
            r1.label = r5
            java.lang.String r10 = "服務暫時不可用"
            java.lang.Object r10 = r0.emit(r10, r1)
            if (r10 != r2) goto Lcb
            return r2
        Lcb:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel.apiPostCollectionClick(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiGetCollectionDetail(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel.C08901
            if (r0 == 0) goto L14
            r0 = r8
            com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel$apiGetCollectionDetail$1 r0 = (com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel.C08901) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel$apiGetCollectionDetail$1 r0 = new com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel$apiGetCollectionDetail$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L2d
            goto L8f
        L2d:
            r8 = move-exception
            goto L8c
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L37:
            java.lang.Object r2 = r0.L$0
            com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel r2 = (com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L2d
            goto L50
        L3f:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = r7.collectionId     // Catch: java.lang.Exception -> L2d
            r0.L$0 = r7     // Catch: java.lang.Exception -> L2d
            r0.label = r4     // Catch: java.lang.Exception -> L2d
            java.lang.Object r8 = com.soletreadmills.sole_v2._network.JwtDyacoApiKt.callGetCollectionByIdApiData(r8, r0)     // Catch: java.lang.Exception -> L2d
            if (r8 != r1) goto L4f
            return r1
        L4f:
            r2 = r7
        L50:
            retrofit2.Response r8 = (retrofit2.Response) r8     // Catch: java.lang.Exception -> L2d
            java.lang.Object r8 = r8.body()     // Catch: java.lang.Exception -> L2d
            com.soletreadmills.sole_v2._data.classes.GetCollectionDetailApiData$ResponseData r8 = (com.soletreadmills.sole_v2._data.classes.GetCollectionDetailApiData.ResponseData) r8     // Catch: java.lang.Exception -> L2d
            r4 = 0
            if (r8 == 0) goto L66
            com.soletreadmills.sole_v2._data._base.JwtApiBaseData$SysResponseMessage r5 = r8.getSysMsg()     // Catch: java.lang.Exception -> L2d
            if (r5 == 0) goto L66
            java.lang.String r5 = r5.getCode()     // Catch: java.lang.Exception -> L2d
            goto L67
        L66:
            r5 = r4
        L67:
            com.soletreadmills.sole_v2._data.api.JwtErrorCode r6 = com.soletreadmills.sole_v2._data.api.JwtErrorCode.JWT_SUCCESS_1     // Catch: java.lang.Exception -> L2d
            java.lang.String r6 = r6.getId()     // Catch: java.lang.Exception -> L2d
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)     // Catch: java.lang.Exception -> L2d
            if (r6 == 0) goto L7b
            com.soletreadmills.sole_v2._data.classes.CollectionDetailData r8 = r8.getDataMap()     // Catch: java.lang.Exception -> L2d
            r2.setData(r8)     // Catch: java.lang.Exception -> L2d
            goto L8f
        L7b:
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> r8 = r2.errorData     // Catch: java.lang.Exception -> L2d
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> L2d
            r0.L$0 = r4     // Catch: java.lang.Exception -> L2d
            r0.label = r3     // Catch: java.lang.Exception -> L2d
            java.lang.Object r8 = r8.emit(r2, r0)     // Catch: java.lang.Exception -> L2d
            if (r8 != r1) goto L8f
            return r1
        L8c:
            r8.printStackTrace()
        L8f:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel.apiGetCollectionDetail(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiPostFavorite(kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel.apiPostFavorite(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiDeleteFavorite(kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            java.lang.String r2 = "網路異常 ("
            boolean r3 = r0 instanceof com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel.AnonymousClass1
            if (r3 == 0) goto L1a
            r3 = r0
            com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel$apiDeleteFavorite$1 r3 = (com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel.AnonymousClass1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L1a
            int r0 = r3.label
            int r0 = r0 - r5
            r3.label = r0
            goto L1f
        L1a:
            com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel$apiDeleteFavorite$1 r3 = new com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel$apiDeleteFavorite$1
            r3.<init>(r0)
        L1f:
            java.lang.Object r0 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L47
            if (r5 == r7) goto L3f
            if (r5 != r6) goto L37
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Exception -> L34
            goto Lc3
        L34:
            r0 = move-exception
            goto Lc0
        L37:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L3f:
            java.lang.Object r5 = r3.L$0
            com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel r5 = (com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel) r5
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Exception -> L34
            goto L6d
        L47:
            kotlin.ResultKt.throwOnFailure(r0)
            com.soletreadmills.sole_v2._data.classes.CollectionDetailData r0 = r22.getData()     // Catch: java.lang.Exception -> L34
            if (r0 == 0) goto L56
            java.lang.String r0 = r0.getFavorite_id()     // Catch: java.lang.Exception -> L34
            if (r0 != 0) goto L58
        L56:
            java.lang.String r0 = ""
        L58:
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)     // Catch: java.lang.Exception -> L34
            com.soletreadmills.sole_v2._data.classes.DeleteFavoriteRequest$RequestBodyData r5 = new com.soletreadmills.sole_v2._data.classes.DeleteFavoriteRequest$RequestBodyData     // Catch: java.lang.Exception -> L34
            r5.<init>(r0)     // Catch: java.lang.Exception -> L34
            r3.L$0 = r1     // Catch: java.lang.Exception -> L34
            r3.label = r7     // Catch: java.lang.Exception -> L34
            java.lang.Object r0 = com.soletreadmills.sole_v2._network.JwtDyacoApiKt.callDeleteFavorite(r5, r3)     // Catch: java.lang.Exception -> L34
            if (r0 != r4) goto L6c
            return r4
        L6c:
            r5 = r1
        L6d:
            retrofit2.Response r0 = (retrofit2.Response) r0     // Catch: java.lang.Exception -> L34
            boolean r7 = r0.isSuccessful()     // Catch: java.lang.Exception -> L34
            r8 = 0
            if (r7 != 0) goto L9a
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> r5 = r5.errorData     // Catch: java.lang.Exception -> L34
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L34
            r7.<init>(r2)     // Catch: java.lang.Exception -> L34
            int r0 = r0.code()     // Catch: java.lang.Exception -> L34
            java.lang.StringBuilder r0 = r7.append(r0)     // Catch: java.lang.Exception -> L34
            r2 = 41
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Exception -> L34
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L34
            r3.L$0 = r8     // Catch: java.lang.Exception -> L34
            r3.label = r6     // Catch: java.lang.Exception -> L34
            java.lang.Object r0 = r5.emit(r0, r3)     // Catch: java.lang.Exception -> L34
            if (r0 != r4) goto Lc3
            return r4
        L9a:
            com.soletreadmills.sole_v2._data.classes.CollectionDetailData r6 = r5.getData()     // Catch: java.lang.Exception -> L34
            if (r6 == 0) goto Lbc
            r0 = 0
            java.lang.Boolean r17 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch: java.lang.Exception -> L34
            r20 = 7167(0x1bff, float:1.0043E-41)
            r21 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            com.soletreadmills.sole_v2._data.classes.CollectionDetailData r8 = com.soletreadmills.sole_v2._data.classes.CollectionDetailData.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch: java.lang.Exception -> L34
        Lbc:
            r5.setData(r8)     // Catch: java.lang.Exception -> L34
            goto Lc3
        Lc0:
            r0.printStackTrace()
        Lc3:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.CollectionDetailViewModel.apiDeleteFavorite(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
