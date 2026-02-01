package com.google.ai.client.generativeai.common;

import androidx.exifinterface.media.ExifInterface;
import com.google.ai.client.generativeai.common.util.KtorKt;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.serialization.json.Json;

/* compiled from: APIController.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@¨\u0006\u0005"}, d2 = {"<anonymous>", "", "R", "Lcom/google/ai/client/generativeai/common/Response;", "Lkotlinx/coroutines/channels/ProducerScope;", "com/google/ai/client/generativeai/common/APIController$postStream$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$postStream$1", f = "APIController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class APIController$generateContentStream$$inlined$postStream$1 extends SuspendLambda implements Function2<ProducerScope<? super GenerateContentResponse>, Continuation<? super Unit>, Object> {
    final /* synthetic */ GenerateContentRequest $request$inlined;
    final /* synthetic */ HttpClient $this_postStream;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ APIController this$0;
    final /* synthetic */ APIController this$0$inline_fun;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APIController$generateContentStream$$inlined$postStream$1(HttpClient httpClient, String str, APIController aPIController, Continuation continuation, APIController aPIController2, GenerateContentRequest generateContentRequest) {
        super(2, continuation);
        this.$this_postStream = httpClient;
        this.$url = str;
        this.this$0$inline_fun = aPIController;
        this.this$0 = aPIController2;
        this.$request$inlined = generateContentRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        APIController$generateContentStream$$inlined$postStream$1 aPIController$generateContentStream$$inlined$postStream$1 = new APIController$generateContentStream$$inlined$postStream$1(this.$this_postStream, this.$url, this.this$0$inline_fun, continuation, this.this$0, this.$request$inlined);
        aPIController$generateContentStream$$inlined$postStream$1.L$0 = obj;
        return aPIController$generateContentStream$$inlined$postStream$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super GenerateContentResponse> producerScope, Continuation<? super Unit> continuation) {
        return ((APIController$generateContentStream$$inlined$postStream$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: APIController.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u008a@¨\u0006\u0005"}, d2 = {"<anonymous>", "", "R", "Lcom/google/ai/client/generativeai/common/Response;", "Lkotlinx/coroutines/CoroutineScope;", "com/google/ai/client/generativeai/common/APIController$postStream$2$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$postStream$1$1", f = "APIController.kt", i = {0}, l = {193, 196}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240"}, s = {"L$2"})
    /* renamed from: com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$postStream$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProducerScope<GenerateContentResponse> $$this$channelFlow;
        final /* synthetic */ GenerateContentRequest $request$inlined;
        final /* synthetic */ HttpClient $this_postStream;
        final /* synthetic */ String $url;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ APIController this$0;
        final /* synthetic */ APIController this$0$inline_fun;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HttpClient httpClient, String str, APIController aPIController, ProducerScope producerScope, Continuation continuation, APIController aPIController2, GenerateContentRequest generateContentRequest) {
            super(2, continuation);
            this.$this_postStream = httpClient;
            this.$url = str;
            this.this$0$inline_fun = aPIController;
            this.this$0 = aPIController2;
            this.$request$inlined = generateContentRequest;
            this.$$this$channelFlow = producerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_postStream, this.$url, this.this$0$inline_fun, this.$$this$channelFlow, continuation, this.this$0, this.$request$inlined);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: APIController.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", "R", "Lcom/google/ai/client/generativeai/common/Response;", "it", "Lio/ktor/client/statement/HttpResponse;", "com/google/ai/client/generativeai/common/APIController$postStream$2$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.google.ai.client.generativeai.common.APIController$postStream$2$1$2", f = "APIController.kt", i = {0}, l = {197, 199, 202}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
        /* renamed from: com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$postStream$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01631 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProducerScope<GenerateContentResponse> $$this$channelFlow;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01631(ProducerScope producerScope, Continuation continuation) {
                super(2, continuation);
                this.$$this$channelFlow = producerScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01631 c01631 = new C01631(this.$$this$channelFlow, continuation);
                c01631.L$0 = obj;
                return c01631;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
                return ((C01631) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* compiled from: ktor.kt */
            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¨\u0006\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ProducerScope;", "com/google/ai/client/generativeai/common/util/KtorKt$decodeToFlow$1", "com/google/ai/client/generativeai/common/APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.google.ai.client.generativeai.common.util.KtorKt$decodeToFlow$1", f = "ktor.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$postStream$1$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01641 extends SuspendLambda implements Function2<ProducerScope<? super GenerateContentResponse>, Continuation<? super Unit>, Object> {
                final /* synthetic */ ByteReadChannel $channel;
                final /* synthetic */ Json $this_decodeToFlow;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01641(ByteReadChannel byteReadChannel, Json json, Continuation continuation) {
                    super(2, continuation);
                    this.$channel = byteReadChannel;
                    this.$this_decodeToFlow = json;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01641 c01641 = new C01641(this.$channel, this.$this_decodeToFlow, continuation);
                    c01641.L$0 = obj;
                    return c01641;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(ProducerScope<? super GenerateContentResponse> producerScope, Continuation<? super Unit> continuation) {
                    return ((C01641) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* compiled from: ktor.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "", "com/google/ai/client/generativeai/common/util/KtorKt$decodeToFlow$1$1", "com/google/ai/client/generativeai/common/APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.google.ai.client.generativeai.common.util.KtorKt$decodeToFlow$1$1", f = "ktor.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$postStream$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
                public static final class C01651 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ProducerScope<GenerateContentResponse> $$this$channelFlow;
                    final /* synthetic */ Json $this_decodeToFlow;
                    /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C01651(ProducerScope producerScope, Json json, Continuation continuation) {
                        super(2, continuation);
                        this.$this_decodeToFlow = json;
                        this.$$this$channelFlow = producerScope;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C01651 c01651 = new C01651(this.$$this$channelFlow, this.$this_decodeToFlow, continuation);
                        c01651.L$0 = obj;
                        return c01651;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(String str, Continuation<? super Unit> continuation) {
                        return ((C01651) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            String strRemovePrefix = StringsKt.removePrefix((String) this.L$0, (CharSequence) "data:");
                            SendChannel sendChannel = this.$$this$channelFlow;
                            Json json = this.$this_decodeToFlow;
                            json.getSerializersModule();
                            this.label = 1;
                            if (sendChannel.send(json.decodeFromString(GenerateContentResponse.INSTANCE.serializer(), strRemovePrefix), this) == coroutine_suspended) {
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

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ProducerScope producerScope = (ProducerScope) this.L$0;
                        this.label = 1;
                        if (KtorKt.onEachLine(this.$channel, new C01651(producerScope, this.$this_decodeToFlow, null), this) == coroutine_suspended) {
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

            /* JADX WARN: Removed duplicated region for block: B:20:0x0073 A[RETURN] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r6.label
                    r2 = 0
                    r3 = 3
                    r4 = 2
                    r5 = 1
                    if (r1 == 0) goto L2a
                    if (r1 == r5) goto L22
                    if (r1 == r4) goto L1e
                    if (r1 != r3) goto L16
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L74
                L16:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L1e:
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L4e
                L22:
                    java.lang.Object r1 = r6.L$0
                    io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L40
                L2a:
                    kotlin.ResultKt.throwOnFailure(r7)
                    java.lang.Object r7 = r6.L$0
                    r1 = r7
                    io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
                    r7 = r6
                    kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                    r6.L$0 = r1
                    r6.label = r5
                    java.lang.Object r7 = com.google.ai.client.generativeai.common.APIControllerKt.access$validateResponse(r1, r7)
                    if (r7 != r0) goto L40
                    return r0
                L40:
                    r7 = r6
                    kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                    r6.L$0 = r2
                    r6.label = r4
                    java.lang.Object r7 = io.ktor.client.statement.HttpResponseKt.bodyAsChannel(r1, r7)
                    if (r7 != r0) goto L4e
                    return r0
                L4e:
                    io.ktor.utils.io.ByteReadChannel r7 = (io.ktor.utils.io.ByteReadChannel) r7
                    kotlinx.serialization.json.Json r1 = com.google.ai.client.generativeai.common.APIControllerKt.getJSON()
                    com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$postStream$1$1$1$1 r4 = new com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$postStream$1$1$1$1
                    r4.<init>(r7, r1, r2)
                    kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                    kotlinx.coroutines.flow.Flow r7 = kotlinx.coroutines.flow.FlowKt.channelFlow(r4)
                    com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$postStream$1$1$1$2 r1 = new com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$postStream$1$1$1$2
                    kotlinx.coroutines.channels.ProducerScope<com.google.ai.client.generativeai.common.GenerateContentResponse> r2 = r6.$$this$channelFlow
                    r1.<init>()
                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                    r2 = r6
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    r6.label = r3
                    java.lang.Object r7 = r7.collect(r1, r2)
                    if (r7 != r0) goto L74
                    return r0
                L74:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$postStream$1.AnonymousClass1.C01631.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            HttpClient httpClient;
            HttpRequestBuilder httpRequestBuilder;
            HttpRequestBuilder httpRequestBuilder2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                httpClient = this.$this_postStream;
                String str = this.$url;
                APIController aPIController = this.this$0$inline_fun;
                HttpRequestBuilder httpRequestBuilder3 = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder3, str);
                this.L$0 = httpClient;
                this.L$1 = httpRequestBuilder3;
                this.L$2 = httpRequestBuilder3;
                this.label = 1;
                if (aPIController.applyHeaderProvider(httpRequestBuilder3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                httpRequestBuilder = httpRequestBuilder3;
                httpRequestBuilder2 = httpRequestBuilder;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                httpRequestBuilder = (HttpRequestBuilder) this.L$2;
                httpRequestBuilder2 = (HttpRequestBuilder) this.L$1;
                httpClient = (HttpClient) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.applyCommonConfiguration(httpRequestBuilder, this.$request$inlined);
            httpRequestBuilder2.setMethod(HttpMethod.INSTANCE.getPost());
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (new HttpStatement(httpRequestBuilder2, httpClient).execute(new C01631(this.$$this$channelFlow, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            BuildersKt__Builders_commonKt.launch$default(producerScope, new CoroutineName("postStream"), null, new AnonymousClass1(this.$this_postStream, this.$url, this.this$0$inline_fun, producerScope, null, this.this$0, this.$request$inlined), 2, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
