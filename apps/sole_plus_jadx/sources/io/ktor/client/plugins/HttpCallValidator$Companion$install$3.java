package io.ktor.client.plugins;

import androidx.core.app.NotificationCompat;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: HttpCallValidator.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$3", f = "HttpCallValidator.kt", i = {1}, l = {151, 152}, m = "invokeSuspend", n = {NotificationCompat.CATEGORY_CALL}, s = {"L$0"})
/* loaded from: classes6.dex */
final class HttpCallValidator$Companion$install$3 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ HttpCallValidator $plugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpCallValidator$Companion$install$3(HttpCallValidator httpCallValidator, Continuation<? super HttpCallValidator$Companion$install$3> continuation) {
        super(3, continuation);
        this.$plugin = httpCallValidator;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpCallValidator$Companion$install$3 httpCallValidator$Companion$install$3 = new HttpCallValidator$Companion$install$3(this.$plugin, continuation);
        httpCallValidator$Companion$install$3.L$0 = sender;
        httpCallValidator$Companion$install$3.L$1 = httpRequestBuilder;
        return httpCallValidator$Companion$install$3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = null;
            this.label = 1;
            obj = ((Sender) this.L$0).execute((HttpRequestBuilder) this.L$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                HttpClientCall httpClientCall = (HttpClientCall) this.L$0;
                ResultKt.throwOnFailure(obj);
                return httpClientCall;
            }
            ResultKt.throwOnFailure(obj);
        }
        HttpClientCall httpClientCall2 = (HttpClientCall) obj;
        this.L$0 = httpClientCall2;
        this.label = 2;
        return this.$plugin.validateResponse(httpClientCall2.getResponse(), this) == coroutine_suspended ? coroutine_suspended : httpClientCall2;
    }
}
