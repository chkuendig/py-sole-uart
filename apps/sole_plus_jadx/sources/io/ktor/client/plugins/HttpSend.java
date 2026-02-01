package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpSend.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0004\u0015\u0016\u0017\u0018B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J=\u0010\u000f\u001a\u00020\u00102-\u0010\u0011\u001a)\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u0012JE\u0010\u000f\u001a\u00020\u001023\u0010\u0011\u001a/\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0014RD\u0010\u0005\u001a/\u0012+\u0012)\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\b\f0\u0006X\u0082\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lio/ktor/client/plugins/HttpSend;", "", "maxSendCount", "", "(I)V", "interceptors", "", "Lkotlin/Function3;", "Lio/ktor/client/plugins/Sender;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/coroutines/Continuation;", "Lio/ktor/client/call/HttpClientCall;", "Lkotlin/ExtensionFunctionType;", "getInterceptors$annotations", "()V", "intercept", "", "block", "(Lkotlin/jvm/functions/Function3;)V", "Lkotlin/Function4;", "(Lkotlin/jvm/functions/Function4;)V", "Config", "DefaultSender", "InterceptedSender", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpSend {

    /* renamed from: Plugin, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<HttpSend> key = new AttributeKey<>("HttpSend");
    private final List<Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object>> interceptors;
    private final int maxSendCount;

    public /* synthetic */ HttpSend(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private static /* synthetic */ void getInterceptors$annotations() {
    }

    private HttpSend(int i) {
        this.maxSendCount = i;
        this.interceptors = new ArrayList();
    }

    /* synthetic */ HttpSend(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 20 : i);
    }

    /* compiled from: HttpSend.kt */
    @KtorDsl
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/client/plugins/HttpSend$Config;", "", "()V", "maxSendCount", "", "getMaxSendCount", "()I", "setMaxSendCount", "(I)V", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Config {
        private int maxSendCount = 20;

        public final int getMaxSendCount() {
            return this.maxSendCount;
        }

        public final void setMaxSendCount(int i) {
            this.maxSendCount = i;
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This interceptors do not allow to intercept first network call. Please use another overload and replace HttpClientCall parameter using `val call = execute(request)`")
    public final void intercept(Function4<? super Sender, ? super HttpClientCall, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        throw new IllegalStateException("This interceptors do not allow to intercept original call. Please use another overload and call `this.execute(request)` manually".toString());
    }

    public final void intercept(Function3<? super Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.interceptors.add(block);
    }

    /* compiled from: HttpSend.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J!\u0010\u000e\u001a\u00020\u00032\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0002\b\u0011H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/HttpSend$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/HttpSend$Config;", "Lio/ktor/client/plugins/HttpSend;", "()V", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.HttpSend$Plugin, reason: from kotlin metadata */
    public static final class Companion implements HttpClientPlugin<Config, HttpSend> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpSend> getKey() {
            return HttpSend.key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpSend prepare(Function1<? super Config, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpSend(config.getMaxSendCount(), null);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpSend plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getSend(), new HttpSend$Plugin$install$1(plugin, scope, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpSend.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B?\u0012-\u0010\u0002\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\b\u0012\u0006\u0010\t\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR:\u0010\u0002\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\bX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/HttpSend$InterceptedSender;", "Lio/ktor/client/plugins/Sender;", "interceptor", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/coroutines/Continuation;", "Lio/ktor/client/call/HttpClientCall;", "", "Lkotlin/ExtensionFunctionType;", "nextSender", "(Lkotlin/jvm/functions/Function3;Lio/ktor/client/plugins/Sender;)V", "Lkotlin/jvm/functions/Function3;", "execute", "requestBuilder", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class InterceptedSender implements Sender {
        private final Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> interceptor;
        private final Sender nextSender;

        /* JADX WARN: Multi-variable type inference failed */
        public InterceptedSender(Function3<? super Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object> interceptor, Sender nextSender) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            Intrinsics.checkNotNullParameter(nextSender, "nextSender");
            this.interceptor = interceptor;
            this.nextSender = nextSender;
        }

        @Override // io.ktor.client.plugins.Sender
        public Object execute(HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
            return this.interceptor.invoke(this.nextSender, httpRequestBuilder, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpSend.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/HttpSend$DefaultSender;", "Lio/ktor/client/plugins/Sender;", "maxSendCount", "", "client", "Lio/ktor/client/HttpClient;", "(ILio/ktor/client/HttpClient;)V", "currentCall", "Lio/ktor/client/call/HttpClientCall;", "sentCount", "execute", "requestBuilder", "Lio/ktor/client/request/HttpRequestBuilder;", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class DefaultSender implements Sender {
        private final HttpClient client;
        private HttpClientCall currentCall;
        private final int maxSendCount;
        private int sentCount;

        public DefaultSender(int i, HttpClient client) {
            Intrinsics.checkNotNullParameter(client, "client");
            this.maxSendCount = i;
            this.client = client;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // io.ktor.client.plugins.Sender
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object execute(io.ktor.client.request.HttpRequestBuilder r6, kotlin.coroutines.Continuation<? super io.ktor.client.call.HttpClientCall> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof io.ktor.client.plugins.HttpSend$DefaultSender$execute$1
                if (r0 == 0) goto L14
                r0 = r7
                io.ktor.client.plugins.HttpSend$DefaultSender$execute$1 r0 = (io.ktor.client.plugins.HttpSend$DefaultSender$execute$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r7 = r0.label
                int r7 = r7 - r2
                r0.label = r7
                goto L19
            L14:
                io.ktor.client.plugins.HttpSend$DefaultSender$execute$1 r0 = new io.ktor.client.plugins.HttpSend$DefaultSender$execute$1
                r0.<init>(r5, r7)
            L19:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L37
                if (r2 != r4) goto L2f
                java.lang.Object r6 = r0.L$0
                io.ktor.client.plugins.HttpSend$DefaultSender r6 = (io.ktor.client.plugins.HttpSend.DefaultSender) r6
                kotlin.ResultKt.throwOnFailure(r7)
                goto L62
            L2f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L37:
                kotlin.ResultKt.throwOnFailure(r7)
                io.ktor.client.call.HttpClientCall r7 = r5.currentCall
                if (r7 == 0) goto L43
                kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
                kotlinx.coroutines.CoroutineScopeKt.cancel$default(r7, r3, r4, r3)
            L43:
                int r7 = r5.sentCount
                int r2 = r5.maxSendCount
                if (r7 >= r2) goto L87
                int r7 = r7 + r4
                r5.sentCount = r7
                io.ktor.client.HttpClient r7 = r5.client
                io.ktor.client.request.HttpSendPipeline r7 = r7.getSendPipeline()
                java.lang.Object r2 = r6.getBody()
                r0.L$0 = r5
                r0.label = r4
                java.lang.Object r7 = r7.execute(r6, r2, r0)
                if (r7 != r1) goto L61
                return r1
            L61:
                r6 = r5
            L62:
                boolean r0 = r7 instanceof io.ktor.client.call.HttpClientCall
                if (r0 == 0) goto L69
                r3 = r7
                io.ktor.client.call.HttpClientCall r3 = (io.ktor.client.call.HttpClientCall) r3
            L69:
                if (r3 == 0) goto L6e
                r6.currentCall = r3
                return r3
            L6e:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Failed to execute send pipeline. Expected [HttpClientCall], but received "
                r0.<init>(r1)
                java.lang.StringBuilder r7 = r0.append(r7)
                java.lang.String r7 = r7.toString()
                java.lang.String r7 = r7.toString()
                r6.<init>(r7)
                throw r6
            L87:
                io.ktor.client.plugins.SendCountExceedException r6 = new io.ktor.client.plugins.SendCountExceedException
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r0 = "Max send count "
                r7.<init>(r0)
                int r0 = r5.maxSendCount
                java.lang.StringBuilder r7 = r7.append(r0)
                java.lang.String r0 = " exceeded. Consider increasing the property maxSendCount if more is required."
                java.lang.StringBuilder r7 = r7.append(r0)
                java.lang.String r7 = r7.toString()
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpSend.DefaultSender.execute(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
