package io.ktor.client.plugins;

import com.android.SdkConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;

/* compiled from: DefaultTransformersJvm.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"platformRequestDefaultTransform", "Lio/ktor/http/content/OutgoingContent;", "contentType", "Lio/ktor/http/ContentType;", SdkConstants.ATTR_CONTEXT, "Lio/ktor/client/request/HttpRequestBuilder;", "body", "", "platformResponseDefaultTransformers", "", "Lio/ktor/client/HttpClient;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DefaultTransformersJvmKt {

    /* compiled from: DefaultTransformersJvm.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<name for destructuring parameter 0>"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1", f = "DefaultTransformersJvm.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1, reason: invalid class name and case insensitive filesystem */
    static final class C10691 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        C10691(Continuation<? super C10691> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
            C10691 c10691 = new C10691(continuation);
            c10691.L$0 = pipelineContext;
            c10691.L$1 = httpResponseContainer;
            return c10691.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final PipelineContext pipelineContext = (PipelineContext) this.L$0;
                HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.L$1;
                TypeInfo expectedType = httpResponseContainer.getExpectedType();
                Object response = httpResponseContainer.getResponse();
                if (!(response instanceof ByteReadChannel)) {
                    return Unit.INSTANCE;
                }
                if (Intrinsics.areEqual(expectedType.getType(), Reflection.getOrCreateKotlinClass(InputStream.class))) {
                    final InputStream inputStream = BlockingKt.toInputStream((ByteReadChannel) response, (Job) ((HttpClientCall) pipelineContext.getContext()).getCoroutineContext().get(Job.INSTANCE));
                    this.L$0 = null;
                    this.label = 1;
                    if (pipelineContext.proceedWith(new HttpResponseContainer(expectedType, new InputStream() { // from class: io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1$response$1
                        @Override // java.io.InputStream
                        public int read() {
                            return inputStream.read();
                        }

                        @Override // java.io.InputStream
                        public int read(byte[] b, int off, int len) {
                            Intrinsics.checkNotNullParameter(b, "b");
                            return inputStream.read(b, off, len);
                        }

                        @Override // java.io.InputStream
                        public int available() {
                            return inputStream.available();
                        }

                        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                        public void close() throws IOException {
                            super.close();
                            inputStream.close();
                            HttpResponseKt.complete(pipelineContext.getContext().getResponse());
                        }
                    }), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    public static final void platformResponseDefaultTransformers(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        httpClient.getResponsePipeline().intercept(HttpResponsePipeline.INSTANCE.getParse(), new C10691(null));
    }

    public static final OutgoingContent platformRequestDefaultTransform(ContentType contentType, HttpRequestBuilder context, Object body) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(body, "body");
        if (body instanceof InputStream) {
            return new OutgoingContent.ReadChannelContent(context, contentType, body) { // from class: io.ktor.client.plugins.DefaultTransformersJvmKt.platformRequestDefaultTransform.1
                final /* synthetic */ Object $body;
                private final Long contentLength;
                private final ContentType contentType;

                {
                    this.$body = body;
                    String str = context.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
                    this.contentLength = str != null ? Long.valueOf(Long.parseLong(str)) : null;
                    this.contentType = contentType == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType;
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.contentLength;
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.contentType;
                }

                @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                /* renamed from: readFrom */
                public ByteReadChannel getChannel() {
                    return ReadingKt.toByteReadChannelWithArrayPool$default((InputStream) this.$body, null, null, 3, null);
                }
            };
        }
        return null;
    }
}
