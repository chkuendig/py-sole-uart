package com.soletreadmills.sole_v2.ui.classes;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;

/* compiled from: VideoModeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$1$1", f = "VideoModeFragment.kt", i = {}, l = {Opcodes.INVOKEINTERFACE, 188, 191, 196, 202}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class VideoModeFragment$onCreateView$1$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VideoModeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoModeFragment$onCreateView$1$1$2$1$1(VideoModeFragment videoModeFragment, Continuation<? super VideoModeFragment$onCreateView$1$1$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = videoModeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoModeFragment$onCreateView$1$1$2$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoModeFragment$onCreateView$1$1$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 0
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r1 == 0) goto L39
            if (r1 == r7) goto L33
            if (r1 == r6) goto L2f
            if (r1 == r5) goto L2b
            if (r1 == r4) goto L26
            if (r1 != r3) goto L1e
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lca
        L1e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L26:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L37
            goto Lca
        L2b:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L37
            goto L80
        L2f:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L37
            goto L72
        L33:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L37
            goto L60
        L37:
            r11 = move-exception
            goto La4
        L39:
            kotlin.ResultKt.throwOnFailure(r11)
            timber.log.Timber$Forest r11 = timber.log.Timber.INSTANCE     // Catch: java.lang.Exception -> L37
            java.lang.String r1 = "=== Dialog Positive Button Clicked ==="
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch: java.lang.Exception -> L37
            r11.d(r1, r9)     // Catch: java.lang.Exception -> L37
            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r11 = r10.this$0     // Catch: java.lang.Exception -> L37
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r11 = com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.access$getViewModel(r11)     // Catch: java.lang.Exception -> L37
            r11.stopTimer()     // Catch: java.lang.Exception -> L37
            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r11 = r10.this$0     // Catch: java.lang.Exception -> L37
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r11 = com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.access$getViewModel(r11)     // Catch: java.lang.Exception -> L37
            r1 = r10
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Exception -> L37
            r10.label = r7     // Catch: java.lang.Exception -> L37
            java.lang.Object r11 = r11.onTapFinish(r1)     // Catch: java.lang.Exception -> L37
            if (r11 != r0) goto L60
            return r0
        L60:
            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r11 = r10.this$0     // Catch: java.lang.Exception -> L37
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r11 = com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.access$getViewModel(r11)     // Catch: java.lang.Exception -> L37
            r1 = r10
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Exception -> L37
            r10.label = r6     // Catch: java.lang.Exception -> L37
            java.lang.Object r11 = r11.apiPostCompletedClassEvent(r1)     // Catch: java.lang.Exception -> L37
            if (r11 != r0) goto L72
            return r0
        L72:
            r11 = r10
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch: java.lang.Exception -> L37
            r10.label = r5     // Catch: java.lang.Exception -> L37
            r5 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r5, r11)     // Catch: java.lang.Exception -> L37
            if (r11 != r0) goto L80
            return r0
        L80:
            timber.log.Timber$Forest r11 = timber.log.Timber.INSTANCE     // Catch: java.lang.Exception -> L37
            java.lang.String r1 = "=== All tasks completed, navigating back ==="
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch: java.lang.Exception -> L37
            r11.d(r1, r5)     // Catch: java.lang.Exception -> L37
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L37
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11     // Catch: java.lang.Exception -> L37
            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$1$1$1 r1 = new com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$1$1$1     // Catch: java.lang.Exception -> L37
            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r5 = r10.this$0     // Catch: java.lang.Exception -> L37
            r1.<init>(r5, r2)     // Catch: java.lang.Exception -> L37
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1     // Catch: java.lang.Exception -> L37
            r5 = r10
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Exception -> L37
            r10.label = r4     // Catch: java.lang.Exception -> L37
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r1, r5)     // Catch: java.lang.Exception -> L37
            if (r11 != r0) goto Lca
            return r0
        La4:
            timber.log.Timber$Forest r1 = timber.log.Timber.INSTANCE
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            java.lang.String r4 = "Error in posListener"
            java.lang.Object[] r5 = new java.lang.Object[r8]
            r1.e(r11, r4, r5)
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$1$1$2 r1 = new com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$1$1$2
            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r4 = r10.this$0
            r1.<init>(r4, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = r10
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r10.label = r3
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r1, r2)
            if (r11 != r0) goto Lca
            return r0
        Lca:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: VideoModeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$1$1$1", f = "VideoModeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ VideoModeFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(VideoModeFragment videoModeFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = videoModeFragment;
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.requireActivity().getOnBackPressedDispatcher().onBackPressed();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VideoModeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$1$1$2", f = "VideoModeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$1$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ VideoModeFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(VideoModeFragment videoModeFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = videoModeFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.requireActivity().getOnBackPressedDispatcher().onBackPressed();
            return Unit.INSTANCE;
        }
    }
}
