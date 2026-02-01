package io.ktor.client;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: HttpClient.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0007\u001aA\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\u001f\b\u0002\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0007¨\u0006\r"}, d2 = {"HttpClient", "Lio/ktor/client/HttpClient;", "engine", "Lio/ktor/client/engine/HttpClientEngine;", "block", "Lkotlin/Function1;", "Lio/ktor/client/HttpClientConfig;", "", "Lkotlin/ExtensionFunctionType;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/engine/HttpClientEngineConfig;", "engineFactory", "Lio/ktor/client/engine/HttpClientEngineFactory;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpClientKt {
    public static /* synthetic */ HttpClient HttpClient$default(HttpClientEngineFactory httpClientEngineFactory, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpClientConfig<T>, Unit>() { // from class: io.ktor.client.HttpClientKt.HttpClient.1
                public final void invoke(HttpClientConfig<T> httpClientConfig) {
                    Intrinsics.checkNotNullParameter(httpClientConfig, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                    invoke((HttpClientConfig) obj2);
                    return Unit.INSTANCE;
                }
            };
        }
        return HttpClient(httpClientEngineFactory, function1);
    }

    @KtorDsl
    public static final <T extends HttpClientEngineConfig> HttpClient HttpClient(HttpClientEngineFactory<? extends T> engineFactory, Function1<? super HttpClientConfig<T>, Unit> block) {
        Intrinsics.checkNotNullParameter(engineFactory, "engineFactory");
        Intrinsics.checkNotNullParameter(block, "block");
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        block.invoke(httpClientConfig);
        final HttpClientEngine httpClientEngineCreate = engineFactory.create(httpClientConfig.getEngineConfig$ktor_client_core());
        HttpClient httpClient = new HttpClient(httpClientEngineCreate, httpClientConfig, true);
        CoroutineContext.Element element = httpClient.getCoroutineContext().get(Job.INSTANCE);
        Intrinsics.checkNotNull(element);
        ((Job) element).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.HttpClientKt.HttpClient.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                httpClientEngineCreate.close();
            }
        });
        return httpClient;
    }

    @KtorDsl
    public static final HttpClient HttpClient(HttpClientEngine engine, Function1<? super HttpClientConfig<?>, Unit> block) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(block, "block");
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        block.invoke(httpClientConfig);
        return new HttpClient(engine, httpClientConfig, false);
    }
}
