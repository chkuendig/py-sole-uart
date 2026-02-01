package io.ktor.client.engine.okhttp;

import com.android.SdkConstants;
import com.sun.jna.platform.win32.WinError;
import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterScope;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import okio.BufferedSource;

/* compiled from: OkHttpEngine.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¨\u0006\u0015"}, d2 = {"mapExceptions", "", "cause", "request", "Lio/ktor/client/request/HttpRequestData;", "convertToOkHttpBody", "Lokhttp3/RequestBody;", "Lio/ktor/http/content/OutgoingContent;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "convertToOkHttpRequest", "Lokhttp3/Request;", "setupTimeoutAttributes", "Lokhttp3/OkHttpClient$Builder;", "timeoutAttributes", "Lio/ktor/client/plugins/HttpTimeout$HttpTimeoutCapabilityConfiguration;", "toChannel", "Lio/ktor/utils/io/ByteReadChannel;", "Lokio/BufferedSource;", SdkConstants.ATTR_CONTEXT, "requestData", "ktor-client-okhttp"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class OkHttpEngineKt {

    /* compiled from: OkHttpEngine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1", f = "OkHttpEngine.kt", i = {0, 0, 0, 0}, l = {165}, m = "invokeSuspend", n = {"$this$writer", "$this$use$iv", "source", "lastRead"}, s = {"L$0", "L$1", "L$4", "L$5"})
    /* renamed from: io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $context;
        final /* synthetic */ HttpRequestData $requestData;
        final /* synthetic */ BufferedSource $this_toChannel;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_toChannel = bufferedSource;
            this.$context = coroutineContext;
            this.$requestData = httpRequestData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_toChannel, this.$context, this.$requestData, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x005f A[Catch: all -> 0x009e, TryCatch #2 {all -> 0x009e, blocks: (B:23:0x0096, B:13:0x0059, B:15:0x005f, B:17:0x0065, B:19:0x0069, B:26:0x00a3), top: B:46:0x0096 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0094 -> B:46:0x0096). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 194
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpEngineKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel toChannel(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData) {
        return CoroutinesKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, false, (Function2) new AnonymousClass1(bufferedSource, coroutineContext, httpRequestData, null), 2, (Object) null).getChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable mapExceptions(Throwable th, HttpRequestData httpRequestData) {
        return th instanceof SocketTimeoutException ? HttpTimeoutKt.SocketTimeoutException(httpRequestData, th) : th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request convertToOkHttpRequest(HttpRequestData httpRequestData, CoroutineContext coroutineContext) {
        final Request.Builder builder = new Request.Builder();
        builder.url(httpRequestData.getUrl().getUrlString());
        UtilsKt.mergeHeaders(httpRequestData.getHeaders(), httpRequestData.getBody(), new Function2<String, String, Unit>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpRequest$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                invoke2(str, str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String key, String value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(key, HttpHeaders.INSTANCE.getContentLength())) {
                    return;
                }
                builder.addHeader(key, value);
            }
        });
        builder.method(httpRequestData.getMethod().getValue(), HttpMethod.permitsRequestBody(httpRequestData.getMethod().getValue()) ? convertToOkHttpBody(httpRequestData.getBody(), coroutineContext) : null);
        return builder.build();
    }

    public static final RequestBody convertToOkHttpBody(final OutgoingContent outgoingContent, final CoroutineContext callContext) {
        Intrinsics.checkNotNullParameter(outgoingContent, "<this>");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            byte[] bArrBytes = ((OutgoingContent.ByteArrayContent) outgoingContent).getBytes();
            return RequestBody.INSTANCE.create(bArrBytes, MediaType.INSTANCE.parse(String.valueOf(outgoingContent.getContentType())), 0, bArrBytes.length);
        }
        if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            return new StreamRequestBody(outgoingContent.getContentLength(), new Function0<ByteReadChannel>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt.convertToOkHttpBody.2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ByteReadChannel invoke() {
                    return ((OutgoingContent.ReadChannelContent) outgoingContent).getChannel();
                }
            });
        }
        if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
            return new StreamRequestBody(outgoingContent.getContentLength(), new Function0<ByteReadChannel>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt.convertToOkHttpBody.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* compiled from: OkHttpEngine.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$3$1", f = "OkHttpEngine.kt", i = {}, l = {WinError.ERROR_TOO_MANY_MODULES}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$3$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ OutgoingContent $this_convertToOkHttpBody;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(OutgoingContent outgoingContent, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$this_convertToOkHttpBody = outgoingContent;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_convertToOkHttpBody, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            WriterScope writerScope = (WriterScope) this.L$0;
                            this.label = 1;
                            if (((OutgoingContent.WriteChannelContent) this.$this_convertToOkHttpBody).writeTo(writerScope.getChannel(), this) == coroutine_suspended) {
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

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ByteReadChannel invoke() {
                    return CoroutinesKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, callContext, false, (Function2) new AnonymousClass1(outgoingContent, null), 2, (Object) null).getChannel();
                }
            });
        }
        if (outgoingContent instanceof OutgoingContent.NoContent) {
            return RequestBody.INSTANCE.create(new byte[0], (MediaType) null, 0, 0);
        }
        throw new UnsupportedContentTypeException(outgoingContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient.Builder setupTimeoutAttributes(OkHttpClient.Builder builder, HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
        Long connectTimeoutMillis = httpTimeoutCapabilityConfiguration.get_connectTimeoutMillis();
        if (connectTimeoutMillis != null) {
            builder.connectTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(connectTimeoutMillis.longValue()), TimeUnit.MILLISECONDS);
        }
        Long socketTimeoutMillis = httpTimeoutCapabilityConfiguration.get_socketTimeoutMillis();
        if (socketTimeoutMillis != null) {
            long jLongValue = socketTimeoutMillis.longValue();
            builder.readTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(jLongValue), TimeUnit.MILLISECONDS);
            builder.writeTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(jLongValue), TimeUnit.MILLISECONDS);
        }
        return builder;
    }
}
