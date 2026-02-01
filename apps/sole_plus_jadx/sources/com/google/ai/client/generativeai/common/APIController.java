package com.google.ai.client.generativeai.common;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.ai.client.generativeai.common.util.UtilKt;
import com.sun.jna.platform.win32.WinError;
import com.sun.jna.platform.win32.WinUser;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.client.engine.okhttp.OkHttp;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import io.ktor.util.reflect.TypeInfoJvmKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: APIController.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B3\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0006\u0010\u0012\u001a\u00020\u0017J\u0014\u0010\u001b\u001a\u00020\u001c*\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u001eH\u0002J\u0015\u0010\u001f\u001a\u00020\u001c*\u00020\u001dH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 JB\u0010!\u001a\b\u0012\u0004\u0012\u0002H\"0\u001a\"\n\b\u0000\u0010\"\u0018\u0001*\u00020#*\u00020\u000f2\u0006\u0010$\u001a\u00020\u00032\u0019\b\u0006\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001c0&¢\u0006\u0002\b'H\u0082\bR\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/google/ai/client/generativeai/common/APIController;", "", "key", "", DeviceRequestsHelper.DEVICE_INFO_MODEL, "requestOptions", "Lcom/google/ai/client/generativeai/common/RequestOptions;", "apiClient", "headerProvider", "Lcom/google/ai/client/generativeai/common/HeaderProvider;", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/ai/client/generativeai/common/RequestOptions;Ljava/lang/String;Lcom/google/ai/client/generativeai/common/HeaderProvider;)V", "httpEngine", "Lio/ktor/client/engine/HttpClientEngine;", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/ai/client/generativeai/common/RequestOptions;Lio/ktor/client/engine/HttpClientEngine;Ljava/lang/String;Lcom/google/ai/client/generativeai/common/HeaderProvider;)V", "client", "Lio/ktor/client/HttpClient;", "countTokens", "Lcom/google/ai/client/generativeai/common/CountTokensResponse;", "request", "Lcom/google/ai/client/generativeai/common/CountTokensRequest;", "(Lcom/google/ai/client/generativeai/common/CountTokensRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateContent", "Lcom/google/ai/client/generativeai/common/GenerateContentResponse;", "Lcom/google/ai/client/generativeai/common/GenerateContentRequest;", "(Lcom/google/ai/client/generativeai/common/GenerateContentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateContentStream", "Lkotlinx/coroutines/flow/Flow;", "applyCommonConfiguration", "", "Lio/ktor/client/request/HttpRequestBuilder;", "Lcom/google/ai/client/generativeai/common/Request;", "applyHeaderProvider", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postStream", "R", "Lcom/google/ai/client/generativeai/common/Response;", "url", "config", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Companion", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class APIController {
    private static final String TAG = "APIController";
    private final String apiClient;
    private final HttpClient client;
    private final HeaderProvider headerProvider;
    private final String key;
    private final String model;
    private final RequestOptions requestOptions;

    /* compiled from: APIController.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.ai.client.generativeai.common.APIController", f = "APIController.kt", i = {}, l = {149}, m = "applyHeaderProvider", n = {}, s = {})
    /* renamed from: com.google.ai.client.generativeai.common.APIController$applyHeaderProvider$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return APIController.this.applyHeaderProvider(null, this);
        }
    }

    /* compiled from: APIController.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.ai.client.generativeai.common.APIController", f = "APIController.kt", i = {}, l = {128, 259, 130, WinUser.WM_SYSKEYUP}, m = "countTokens", n = {}, s = {})
    /* renamed from: com.google.ai.client.generativeai.common.APIController$countTokens$1, reason: invalid class name and case insensitive filesystem */
    static final class C08271 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C08271(Continuation<? super C08271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return APIController.this.countTokens(null, this);
        }
    }

    /* compiled from: APIController.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.ai.client.generativeai.common.APIController", f = "APIController.kt", i = {}, l = {104, 259, 106, WinUser.WM_SYSKEYUP}, m = "generateContent", n = {}, s = {})
    /* renamed from: com.google.ai.client.generativeai.common.APIController$generateContent$1, reason: invalid class name and case insensitive filesystem */
    static final class C08281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C08281(Continuation<? super C08281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return APIController.this.generateContent(null, this);
        }
    }

    public APIController(String key, String model, RequestOptions requestOptions, HttpClientEngine httpEngine, String apiClient, HeaderProvider headerProvider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(requestOptions, "requestOptions");
        Intrinsics.checkNotNullParameter(httpEngine, "httpEngine");
        Intrinsics.checkNotNullParameter(apiClient, "apiClient");
        this.key = key;
        this.requestOptions = requestOptions;
        this.apiClient = apiClient;
        this.headerProvider = headerProvider;
        this.model = UtilKt.fullModelName(model);
        this.client = HttpClientKt.HttpClient(httpEngine, new Function1<HttpClientConfig<?>, Unit>() { // from class: com.google.ai.client.generativeai.common.APIController$client$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> httpClientConfig) {
                invoke2(httpClientConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpClientConfig<?> HttpClient) {
                Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
                HttpTimeout.Companion companion = HttpTimeout.INSTANCE;
                final APIController aPIController = this.this$0;
                HttpClient.install(companion, new Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit>() { // from class: com.google.ai.client.generativeai.common.APIController$client$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
                        invoke2(httpTimeoutCapabilityConfiguration);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(HttpTimeout.HttpTimeoutCapabilityConfiguration install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        install.setRequestTimeoutMillis(Long.valueOf(Duration.m10431getInWholeMillisecondsimpl(aPIController.requestOptions.getTimeout())));
                        install.setSocketTimeoutMillis(80000L);
                    }
                });
                HttpClient.install(ContentNegotiation.INSTANCE, new Function1<ContentNegotiation.Config, Unit>() { // from class: com.google.ai.client.generativeai.common.APIController$client$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ContentNegotiation.Config config) {
                        invoke2(config);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ContentNegotiation.Config install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        JsonSupportKt.json$default(install, APIControllerKt.getJSON(), null, 2, null);
                    }
                });
            }
        });
    }

    public /* synthetic */ APIController(String str, String str2, RequestOptions requestOptions, String str3, HeaderProvider headerProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, requestOptions, str3, (i & 16) != 0 ? null : headerProvider);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public APIController(String key, String model, RequestOptions requestOptions, String apiClient, HeaderProvider headerProvider) {
        this(key, model, requestOptions, HttpClientEngineFactory.DefaultImpls.create$default(OkHttp.INSTANCE, null, 1, null), apiClient, headerProvider);
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(requestOptions, "requestOptions");
        Intrinsics.checkNotNullParameter(apiClient, "apiClient");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fa A[Catch: all -> 0x010a, TryCatch #0 {all -> 0x010a, blocks: (B:14:0x0032, B:41:0x00fa, B:43:0x0101, B:44:0x0109, B:19:0x0041, B:37:0x00d3, B:20:0x0046, B:33:0x00c4, B:23:0x0053, B:30:0x00a9, B:26:0x005a), top: B:48:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0101 A[Catch: all -> 0x010a, TryCatch #0 {all -> 0x010a, blocks: (B:14:0x0032, B:41:0x00fa, B:43:0x0101, B:44:0x0109, B:19:0x0041, B:37:0x00d3, B:20:0x0046, B:33:0x00c4, B:23:0x0053, B:30:0x00a9, B:26:0x005a), top: B:48:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object generateContent(com.google.ai.client.generativeai.common.GenerateContentRequest r13, kotlin.coroutines.Continuation<? super com.google.ai.client.generativeai.common.GenerateContentResponse> r14) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ai.client.generativeai.common.APIController.generateContent(com.google.ai.client.generativeai.common.GenerateContentRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow<GenerateContentResponse> generateContentStream(GenerateContentRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        final Flow flowChannelFlow = FlowKt.channelFlow(new APIController$generateContentStream$$inlined$postStream$1(this.client, this.requestOptions.getEndpoint() + "/" + this.requestOptions.getApiVersion() + "/" + this.model + ":streamGenerateContent?alt=sse", this, null, this, request));
        return FlowKt.m10619catch(new Flow<GenerateContentResponse>() { // from class: com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$map$1$2", f = "APIController.kt", i = {}, l = {WinError.ERROR_FILE_TOO_LARGE}, m = "emit", n = {}, s = {})
                /* renamed from: com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$map$1$2$1 r0 = (com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 - r2
                        r0.label = r6
                        goto L19
                    L14:
                        com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$map$1$2$1 r0 = new com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        com.google.ai.client.generativeai.common.GenerateContentResponse r5 = (com.google.ai.client.generativeai.common.GenerateContentResponse) r5
                        com.google.ai.client.generativeai.common.GenerateContentResponse r5 = com.google.ai.client.generativeai.common.APIControllerKt.access$validate(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.ai.client.generativeai.common.APIController$generateContentStream$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super GenerateContentResponse> flowCollector, Continuation continuation) {
                Object objCollect = flowChannelFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AnonymousClass3(null));
    }

    /* compiled from: APIController.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/google/ai/client/generativeai/common/GenerateContentResponse;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.ai.client.generativeai.common.APIController$generateContentStream$3", f = "APIController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.google.ai.client.generativeai.common.APIController$generateContentStream$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super GenerateContentResponse>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super GenerateContentResponse> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = th;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw GoogleGenerativeAIException.INSTANCE.from((Throwable) this.L$0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fa A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:14:0x0032, B:41:0x00fa, B:43:0x00fd, B:44:0x0105, B:19:0x0041, B:37:0x00d3, B:20:0x0046, B:33:0x00c4, B:23:0x0053, B:30:0x00a9, B:26:0x005a), top: B:48:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:14:0x0032, B:41:0x00fa, B:43:0x00fd, B:44:0x0105, B:19:0x0041, B:37:0x00d3, B:20:0x0046, B:33:0x00c4, B:23:0x0053, B:30:0x00a9, B:26:0x005a), top: B:48:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object countTokens(com.google.ai.client.generativeai.common.CountTokensRequest r13, kotlin.coroutines.Continuation<? super com.google.ai.client.generativeai.common.CountTokensResponse> r14) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ai.client.generativeai.common.APIController.countTokens(com.google.ai.client.generativeai.common.CountTokensRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyCommonConfiguration(HttpRequestBuilder httpRequestBuilder, Request request) {
        if (request instanceof GenerateContentRequest) {
            if (request == null) {
                httpRequestBuilder.setBody(NullBody.INSTANCE);
                KType kTypeTypeOf = Reflection.typeOf(GenerateContentRequest.class);
                httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf), Reflection.getOrCreateKotlinClass(GenerateContentRequest.class), kTypeTypeOf));
            } else if (request instanceof OutgoingContent) {
                httpRequestBuilder.setBody(request);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(request);
                KType kTypeTypeOf2 = Reflection.typeOf(GenerateContentRequest.class);
                httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf2), Reflection.getOrCreateKotlinClass(GenerateContentRequest.class), kTypeTypeOf2));
            }
        } else if (request instanceof CountTokensRequest) {
            if (request == null) {
                httpRequestBuilder.setBody(NullBody.INSTANCE);
                KType kTypeTypeOf3 = Reflection.typeOf(CountTokensRequest.class);
                httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf3), Reflection.getOrCreateKotlinClass(CountTokensRequest.class), kTypeTypeOf3));
            } else if (request instanceof OutgoingContent) {
                httpRequestBuilder.setBody(request);
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.setBody(request);
                KType kTypeTypeOf4 = Reflection.typeOf(CountTokensRequest.class);
                httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf4), Reflection.getOrCreateKotlinClass(CountTokensRequest.class), kTypeTypeOf4));
            }
        }
        HttpRequestBuilder httpRequestBuilder2 = httpRequestBuilder;
        HttpMessagePropertiesKt.contentType(httpRequestBuilder2, ContentType.Application.INSTANCE.getJson());
        UtilsKt.header(httpRequestBuilder2, "x-goog-api-key", this.key);
        UtilsKt.header(httpRequestBuilder2, "x-goog-api-client", this.apiClient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object applyHeaderProvider(io.ktor.client.request.HttpRequestBuilder r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.google.ai.client.generativeai.common.APIController.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            com.google.ai.client.generativeai.common.APIController$applyHeaderProvider$1 r0 = (com.google.ai.client.generativeai.common.APIController.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.google.ai.client.generativeai.common.APIController$applyHeaderProvider$1 r0 = new com.google.ai.client.generativeai.common.APIController$applyHeaderProvider$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L4e
            goto L55
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            com.google.ai.client.generativeai.common.HeaderProvider r8 = r6.headerProvider
            if (r8 == 0) goto L55
            long r4 = r8.m8242getTimeoutUwyO8pc()     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L4e
            com.google.ai.client.generativeai.common.APIController$applyHeaderProvider$2 r8 = new com.google.ai.client.generativeai.common.APIController$applyHeaderProvider$2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L4e
            r2 = 0
            r8.<init>(r7, r2)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L4e
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L4e
            r0.label = r3     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L4e
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.m10587withTimeoutKLykuaI(r4, r8, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L4e
            if (r7 != r1) goto L55
            return r1
        L4e:
            java.lang.String r7 = com.google.ai.client.generativeai.common.APIController.TAG
            java.lang.String r8 = "HeaderProvided timed out without generating headers, ignoring"
            android.util.Log.w(r7, r8)
        L55:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ai.client.generativeai.common.APIController.applyHeaderProvider(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: APIController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.ai.client.generativeai.common.APIController$applyHeaderProvider$2", f = "APIController.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.google.ai.client.generativeai.common.APIController$applyHeaderProvider$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HttpRequestBuilder $this_applyHeaderProvider;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HttpRequestBuilder httpRequestBuilder, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_applyHeaderProvider = httpRequestBuilder;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return APIController.this.new AnonymousClass2(this.$this_applyHeaderProvider, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = APIController.this.headerProvider.generateHeaders(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                UtilsKt.header(this.$this_applyHeaderProvider, (String) entry.getKey(), (String) entry.getValue());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: APIController.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lcom/google/ai/client/generativeai/common/Response;", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.ai.client.generativeai.common.APIController$postStream$2", f = "APIController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.google.ai.client.generativeai.common.APIController$postStream$2, reason: invalid class name and case insensitive filesystem */
    public static final class C08302<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<HttpRequestBuilder, Unit> $config;
        final /* synthetic */ HttpClient $this_postStream;
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ APIController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08302(HttpClient httpClient, String str, APIController aPIController, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super C08302> continuation) {
            super(2, continuation);
            this.$this_postStream = httpClient;
            this.$url = str;
            this.this$0 = aPIController;
            this.$config = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.needClassReification();
            C08302 c08302 = new C08302(this.$this_postStream, this.$url, this.this$0, this.$config, continuation);
            c08302.L$0 = obj;
            return c08302;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
            return ((C08302) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: APIController.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lcom/google/ai/client/generativeai/common/Response;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.google.ai.client.generativeai.common.APIController$postStream$2$1", f = "APIController.kt", i = {0}, l = {193, 196}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240"}, s = {"L$3"})
        /* renamed from: com.google.ai.client.generativeai.common.APIController$postStream$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProducerScope<R> $$this$channelFlow;
            final /* synthetic */ Function1<HttpRequestBuilder, Unit> $config;
            final /* synthetic */ HttpClient $this_postStream;
            final /* synthetic */ String $url;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            final /* synthetic */ APIController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(HttpClient httpClient, String str, APIController aPIController, Function1<? super HttpRequestBuilder, Unit> function1, ProducerScope<? super R> producerScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$this_postStream = httpClient;
                this.$url = str;
                this.this$0 = aPIController;
                this.$config = function1;
                this.$$this$channelFlow = producerScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$this_postStream, this.$url, this.this$0, this.$config, this.$$this$channelFlow, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                HttpClient httpClient;
                Function1<HttpRequestBuilder, Unit> function1;
                HttpRequestBuilder httpRequestBuilder;
                HttpRequestBuilder httpRequestBuilder2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    httpClient = this.$this_postStream;
                    String str = this.$url;
                    APIController aPIController = this.this$0;
                    function1 = this.$config;
                    HttpRequestBuilder httpRequestBuilder3 = new HttpRequestBuilder();
                    HttpRequestKt.url(httpRequestBuilder3, str);
                    this.L$0 = function1;
                    this.L$1 = httpClient;
                    this.L$2 = httpRequestBuilder3;
                    this.L$3 = httpRequestBuilder3;
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
                    httpRequestBuilder = (HttpRequestBuilder) this.L$3;
                    httpRequestBuilder2 = (HttpRequestBuilder) this.L$2;
                    httpClient = (HttpClient) this.L$1;
                    function1 = (Function1) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                function1.invoke(httpRequestBuilder);
                httpRequestBuilder2.setMethod(HttpMethod.INSTANCE.getPost());
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder2, httpClient);
                Intrinsics.needClassReification();
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 2;
                if (httpStatement.execute(new C01662(this.$$this$channelFlow, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }

            public final Object invokeSuspend$$forInline(Object obj) throws Throwable {
                HttpClient httpClient = this.$this_postStream;
                String str = this.$url;
                APIController aPIController = this.this$0;
                Function1<HttpRequestBuilder, Unit> function1 = this.$config;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, str);
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                aPIController.applyHeaderProvider(httpRequestBuilder, null);
                InlineMarker.mark(1);
                function1.invoke(httpRequestBuilder);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
                httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                Intrinsics.needClassReification();
                InlineMarker.mark(0);
                httpStatement.execute(new C01662(this.$$this$channelFlow, null), this);
                InlineMarker.mark(1);
                return Unit.INSTANCE;
            }

            /* compiled from: APIController.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lcom/google/ai/client/generativeai/common/Response;", "it", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.google.ai.client.generativeai.common.APIController$postStream$2$1$2", f = "APIController.kt", i = {0}, l = {197, 199, 202}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
            /* renamed from: com.google.ai.client.generativeai.common.APIController$postStream$2$1$2, reason: invalid class name and collision with other inner class name */
            public static final class C01662 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
                final /* synthetic */ ProducerScope<R> $$this$channelFlow;
                /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C01662(ProducerScope<? super R> producerScope, Continuation<? super C01662> continuation) {
                    super(2, continuation);
                    this.$$this$channelFlow = producerScope;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01662 c01662 = new C01662(this.$$this$channelFlow, continuation);
                    c01662.L$0 = obj;
                    return c01662;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
                    return ((C01662) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:20:0x0076 A[RETURN] */
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
                        goto L77
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
                        kotlin.jvm.internal.Intrinsics.needClassReification()
                        com.google.ai.client.generativeai.common.APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1 r4 = new com.google.ai.client.generativeai.common.APIController$postStream$2$1$2$invokeSuspend$$inlined$decodeToFlow$1
                        r4.<init>(r7, r1, r2)
                        kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                        kotlinx.coroutines.flow.Flow r7 = kotlinx.coroutines.flow.FlowKt.channelFlow(r4)
                        com.google.ai.client.generativeai.common.APIController$postStream$2$1$2$1 r1 = new com.google.ai.client.generativeai.common.APIController$postStream$2$1$2$1
                        kotlinx.coroutines.channels.ProducerScope<R> r2 = r6.$$this$channelFlow
                        r1.<init>()
                        kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                        r2 = r6
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        r6.label = r3
                        java.lang.Object r7 = r7.collect(r1, r2)
                        if (r7 != r0) goto L77
                        return r0
                    L77:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.ai.client.generativeai.common.APIController.C08302.AnonymousClass1.C01662.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                CoroutineName coroutineName = new CoroutineName("postStream");
                Intrinsics.needClassReification();
                BuildersKt__Builders_commonKt.launch$default(producerScope, coroutineName, null, new AnonymousClass1(this.$this_postStream, this.$url, this.this$0, this.$config, producerScope, null), 2, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            ProducerScope producerScope = (ProducerScope) this.L$0;
            CoroutineName coroutineName = new CoroutineName("postStream");
            Intrinsics.needClassReification();
            BuildersKt__Builders_commonKt.launch$default(producerScope, coroutineName, null, new AnonymousClass1(this.$this_postStream, this.$url, this.this$0, this.$config, producerScope, null), 2, null);
            return Unit.INSTANCE;
        }
    }

    static /* synthetic */ Flow postStream$default(APIController aPIController, HttpClient httpClient, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: com.google.ai.client.generativeai.common.APIController.postStream.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.needClassReification();
        return FlowKt.channelFlow(new C08302(httpClient, str, aPIController, function1, null));
    }

    private final /* synthetic */ <R extends Response> Flow<R> postStream(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1) {
        Intrinsics.needClassReification();
        return FlowKt.channelFlow(new C08302(httpClient, str, this, function1, null));
    }
}
