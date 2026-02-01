package com.google.ai.client.generativeai;

import android.graphics.Bitmap;
import com.android.SdkConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.ai.client.generativeai.type.BlobPart;
import com.google.ai.client.generativeai.type.Candidate;
import com.google.ai.client.generativeai.type.Content;
import com.google.ai.client.generativeai.type.ContentKt;
import com.google.ai.client.generativeai.type.GenerateContentResponse;
import com.google.ai.client.generativeai.type.ImagePart;
import com.google.ai.client.generativeai.type.InvalidStateException;
import com.google.ai.client.generativeai.type.Part;
import com.google.ai.client.generativeai.type.TextPart;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: Chat.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00172\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00172\u0006\u0010\u0010\u001a\u00020\u0006J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00172\u0006\u0010\u0010\u001a\u00020\u0014J\f\u0010\u0018\u001a\u00020\r*\u00020\u0006H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/google/ai/client/generativeai/Chat;", "", DeviceRequestsHelper.DEVICE_INFO_MODEL, "Lcom/google/ai/client/generativeai/GenerativeModel;", "history", "", "Lcom/google/ai/client/generativeai/type/Content;", "(Lcom/google/ai/client/generativeai/GenerativeModel;Ljava/util/List;)V", "getHistory", "()Ljava/util/List;", "lock", "Ljava/util/concurrent/Semaphore;", "attemptLock", "", "sendMessage", "Lcom/google/ai/client/generativeai/type/GenerateContentResponse;", SdkConstants.ATTR_PROMPT, "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/google/ai/client/generativeai/type/Content;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessageStream", "Lkotlinx/coroutines/flow/Flow;", "assertComesFromUser", "generativeai_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Chat {
    private final List<Content> history;
    private Semaphore lock;
    private final GenerativeModel model;

    /* compiled from: Chat.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.ai.client.generativeai.Chat", f = "Chat.kt", i = {0, 0}, l = {60}, m = "sendMessage", n = {"this", SdkConstants.ATTR_PROMPT}, s = {"L$0", "L$1"})
    /* renamed from: com.google.ai.client.generativeai.Chat$sendMessage$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Chat.this.sendMessage((Content) null, this);
        }
    }

    public Chat(GenerativeModel model, List<Content> history) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(history, "history");
        this.model = model;
        this.history = history;
        this.lock = new Semaphore(1);
    }

    public /* synthetic */ Chat(GenerativeModel generativeModel, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(generativeModel, (i & 2) != 0 ? new ArrayList() : arrayList);
    }

    public final List<Content> getHistory() {
        return this.history;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendMessage(com.google.ai.client.generativeai.type.Content r7, kotlin.coroutines.Continuation<? super com.google.ai.client.generativeai.type.GenerateContentResponse> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.google.ai.client.generativeai.Chat.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            com.google.ai.client.generativeai.Chat$sendMessage$1 r0 = (com.google.ai.client.generativeai.Chat.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.google.ai.client.generativeai.Chat$sendMessage$1 r0 = new com.google.ai.client.generativeai.Chat$sendMessage$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            com.google.ai.client.generativeai.type.Content r7 = (com.google.ai.client.generativeai.type.Content) r7
            java.lang.Object r0 = r0.L$0
            com.google.ai.client.generativeai.Chat r0 = (com.google.ai.client.generativeai.Chat) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L32
            goto L78
        L32:
            r7 = move-exception
            goto L9a
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.ResultKt.throwOnFailure(r8)
            r6.assertComesFromUser(r7)
            r6.attemptLock()
            com.google.ai.client.generativeai.GenerativeModel r8 = r6.model     // Catch: java.lang.Throwable -> L98
            kotlin.jvm.internal.SpreadBuilder r2 = new kotlin.jvm.internal.SpreadBuilder     // Catch: java.lang.Throwable -> L98
            r4 = 2
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L98
            java.util.List<com.google.ai.client.generativeai.type.Content> r4 = r6.history     // Catch: java.lang.Throwable -> L98
            java.util.Collection r4 = (java.util.Collection) r4     // Catch: java.lang.Throwable -> L98
            r5 = 0
            com.google.ai.client.generativeai.type.Content[] r5 = new com.google.ai.client.generativeai.type.Content[r5]     // Catch: java.lang.Throwable -> L98
            java.lang.Object[] r4 = r4.toArray(r5)     // Catch: java.lang.Throwable -> L98
            r2.addSpread(r4)     // Catch: java.lang.Throwable -> L98
            r2.add(r7)     // Catch: java.lang.Throwable -> L98
            int r4 = r2.size()     // Catch: java.lang.Throwable -> L98
            com.google.ai.client.generativeai.type.Content[] r4 = new com.google.ai.client.generativeai.type.Content[r4]     // Catch: java.lang.Throwable -> L98
            java.lang.Object[] r2 = r2.toArray(r4)     // Catch: java.lang.Throwable -> L98
            com.google.ai.client.generativeai.type.Content[] r2 = (com.google.ai.client.generativeai.type.Content[]) r2     // Catch: java.lang.Throwable -> L98
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L98
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L98
            r0.label = r3     // Catch: java.lang.Throwable -> L98
            java.lang.Object r8 = r8.generateContent(r2, r0)     // Catch: java.lang.Throwable -> L98
            if (r8 != r1) goto L77
            return r1
        L77:
            r0 = r6
        L78:
            com.google.ai.client.generativeai.type.GenerateContentResponse r8 = (com.google.ai.client.generativeai.type.GenerateContentResponse) r8     // Catch: java.lang.Throwable -> L32
            java.util.List<com.google.ai.client.generativeai.type.Content> r1 = r0.history     // Catch: java.lang.Throwable -> L32
            r1.add(r7)     // Catch: java.lang.Throwable -> L32
            java.util.List<com.google.ai.client.generativeai.type.Content> r7 = r0.history     // Catch: java.lang.Throwable -> L32
            java.util.List r1 = r8.getCandidates()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = kotlin.collections.CollectionsKt.first(r1)     // Catch: java.lang.Throwable -> L32
            com.google.ai.client.generativeai.type.Candidate r1 = (com.google.ai.client.generativeai.type.Candidate) r1     // Catch: java.lang.Throwable -> L32
            com.google.ai.client.generativeai.type.Content r1 = r1.getContent()     // Catch: java.lang.Throwable -> L32
            r7.add(r1)     // Catch: java.lang.Throwable -> L32
            java.util.concurrent.Semaphore r7 = r0.lock
            r7.release()
            return r8
        L98:
            r7 = move-exception
            r0 = r6
        L9a:
            java.util.concurrent.Semaphore r8 = r0.lock
            r8.release()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ai.client.generativeai.Chat.sendMessage(com.google.ai.client.generativeai.type.Content, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object sendMessage(final String str, Continuation<? super GenerateContentResponse> continuation) {
        return sendMessage(ContentKt.content$default(null, new Function1<Content.Builder, Unit>() { // from class: com.google.ai.client.generativeai.Chat$sendMessage$content$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Content.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Content.Builder content) {
                Intrinsics.checkNotNullParameter(content, "$this$content");
                content.addText(str);
            }
        }, 1, null), continuation);
    }

    public final Object sendMessage(final Bitmap bitmap, Continuation<? super GenerateContentResponse> continuation) {
        return sendMessage(ContentKt.content$default(null, new Function1<Content.Builder, Unit>() { // from class: com.google.ai.client.generativeai.Chat$sendMessage$content$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Content.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Content.Builder content) {
                Intrinsics.checkNotNullParameter(content, "$this$content");
                content.addImage(bitmap);
            }
        }, 1, null), continuation);
    }

    public final Flow<GenerateContentResponse> sendMessageStream(Content prompt) {
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        assertComesFromUser(prompt);
        attemptLock();
        GenerativeModel generativeModel = this.model;
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.addSpread(this.history.toArray(new Content[0]));
        spreadBuilder.add(prompt);
        Flow<GenerateContentResponse> flowGenerateContentStream = generativeModel.generateContentStream((Content[]) spreadBuilder.toArray(new Content[spreadBuilder.size()]));
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        StringBuilder sb = new StringBuilder();
        return FlowKt.onCompletion(FlowKt.onEach(flowGenerateContentStream, new C08211(sb, linkedList, linkedList2, null)), new AnonymousClass2(prompt, linkedList, linkedList2, sb, null));
    }

    /* compiled from: Chat.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/google/ai/client/generativeai/type/GenerateContentResponse;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.ai.client.generativeai.Chat$sendMessageStream$1", f = "Chat.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.google.ai.client.generativeai.Chat$sendMessageStream$1, reason: invalid class name and case insensitive filesystem */
    static final class C08211 extends SuspendLambda implements Function2<GenerateContentResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ LinkedList<Bitmap> $bitmaps;
        final /* synthetic */ LinkedList<BlobPart> $blobs;
        final /* synthetic */ StringBuilder $text;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08211(StringBuilder sb, LinkedList<Bitmap> linkedList, LinkedList<BlobPart> linkedList2, Continuation<? super C08211> continuation) {
            super(2, continuation);
            this.$text = sb;
            this.$bitmaps = linkedList;
            this.$blobs = linkedList2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08211 c08211 = new C08211(this.$text, this.$bitmaps, this.$blobs, continuation);
            c08211.L$0 = obj;
            return c08211;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(GenerateContentResponse generateContentResponse, Continuation<? super Unit> continuation) {
            return ((C08211) create(generateContentResponse, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            for (Part part : ((Candidate) CollectionsKt.first((List) ((GenerateContentResponse) this.L$0).getCandidates())).getContent().getParts()) {
                if (part instanceof TextPart) {
                    this.$text.append(((TextPart) part).getText());
                } else if (part instanceof ImagePart) {
                    this.$bitmaps.add(((ImagePart) part).getImage());
                } else if (part instanceof BlobPart) {
                    this.$blobs.add(part);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: Chat.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/google/ai/client/generativeai/type/GenerateContentResponse;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.ai.client.generativeai.Chat$sendMessageStream$2", f = "Chat.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.google.ai.client.generativeai.Chat$sendMessageStream$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super GenerateContentResponse>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ LinkedList<Bitmap> $bitmaps;
        final /* synthetic */ LinkedList<BlobPart> $blobs;
        final /* synthetic */ Content $prompt;
        final /* synthetic */ StringBuilder $text;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Content content, LinkedList<Bitmap> linkedList, LinkedList<BlobPart> linkedList2, StringBuilder sb, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$prompt = content;
            this.$bitmaps = linkedList;
            this.$blobs = linkedList2;
            this.$text = sb;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super GenerateContentResponse> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = Chat.this.new AnonymousClass2(this.$prompt, this.$bitmaps, this.$blobs, this.$text, continuation);
            anonymousClass2.L$0 = th;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Throwable th = (Throwable) this.L$0;
                Chat.this.lock.release();
                if (th == null) {
                    final LinkedList<Bitmap> linkedList = this.$bitmaps;
                    final LinkedList<BlobPart> linkedList2 = this.$blobs;
                    final StringBuilder sb = this.$text;
                    Content content = ContentKt.content(DeviceRequestsHelper.DEVICE_INFO_MODEL, new Function1<Content.Builder, Unit>() { // from class: com.google.ai.client.generativeai.Chat$sendMessageStream$2$content$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Content.Builder builder) {
                            invoke2(builder);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Content.Builder content2) {
                            Intrinsics.checkNotNullParameter(content2, "$this$content");
                            Iterator<Bitmap> it = linkedList.iterator();
                            while (it.hasNext()) {
                                Bitmap bitmap = it.next();
                                Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                                content2.addImage(bitmap);
                            }
                            Iterator<BlobPart> it2 = linkedList2.iterator();
                            while (it2.hasNext()) {
                                BlobPart next = it2.next();
                                content2.addBlob(next.getMimeType(), next.getBlob());
                            }
                            if (StringsKt.isBlank(sb)) {
                                return;
                            }
                            String string = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "text.toString()");
                            content2.addText(string);
                        }
                    });
                    Chat.this.getHistory().add(this.$prompt);
                    Chat.this.getHistory().add(content);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Flow<GenerateContentResponse> sendMessageStream(final String prompt) {
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        return sendMessageStream(ContentKt.content$default(null, new Function1<Content.Builder, Unit>() { // from class: com.google.ai.client.generativeai.Chat$sendMessageStream$content$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Content.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Content.Builder content) {
                Intrinsics.checkNotNullParameter(content, "$this$content");
                content.addText(prompt);
            }
        }, 1, null));
    }

    public final Flow<GenerateContentResponse> sendMessageStream(final Bitmap prompt) {
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        return sendMessageStream(ContentKt.content$default(null, new Function1<Content.Builder, Unit>() { // from class: com.google.ai.client.generativeai.Chat$sendMessageStream$content$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Content.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Content.Builder content) {
                Intrinsics.checkNotNullParameter(content, "$this$content");
                content.addImage(prompt);
            }
        }, 1, null));
    }

    private final void assertComesFromUser(Content content) {
        if (!CollectionsKt.contains(CollectionsKt.listOf((Object[]) new String[]{"user", "function"}), content.getRole())) {
            throw new InvalidStateException("Chat prompts should come from the 'user' or 'function' role.", null, 2, null);
        }
    }

    private final void attemptLock() {
        if (!this.lock.tryAcquire()) {
            throw new InvalidStateException("This chat instance currently has an ongoing request, please wait for it to complete before sending more messages", null, 2, null);
        }
    }
}
