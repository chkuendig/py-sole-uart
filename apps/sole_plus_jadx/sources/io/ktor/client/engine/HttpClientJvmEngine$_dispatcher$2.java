package io.ktor.client.engine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: HttpClientJvmEngine.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
final class HttpClientJvmEngine$_dispatcher$2 extends Lambda implements Function0<ExecutorCoroutineDispatcher> {
    final /* synthetic */ HttpClientJvmEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpClientJvmEngine$_dispatcher$2(HttpClientJvmEngine httpClientJvmEngine) {
        super(0);
        this.this$0 = httpClientJvmEngine;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ExecutorCoroutineDispatcher invoke() {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(this.this$0.getConfig().getThreadsCount(), new ThreadFactory() { // from class: io.ktor.client.engine.HttpClientJvmEngine$_dispatcher$2$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return HttpClientJvmEngine$_dispatcher$2.invoke$lambda$1(runnable);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(confi…e\n            }\n        }");
        return ExecutorsKt.from(executorServiceNewFixedThreadPool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread invoke$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }
}
