package io.ktor.client.plugins.cookies;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HttpCookies.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies$initializer$1", f = "HttpCookies.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HttpCookies$initializer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ HttpCookies this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpCookies$initializer$1(HttpCookies httpCookies, Continuation<? super HttpCookies$initializer$1> continuation) {
        super(2, continuation);
        this.this$0 = httpCookies;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HttpCookies$initializer$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HttpCookies$initializer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpCookies httpCookies;
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List list = this.this$0.defaults;
            httpCookies = this.this$0;
            it = list.iterator();
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$1;
            httpCookies = (HttpCookies) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            Function2 function2 = (Function2) it.next();
            CookiesStorage cookiesStorage = httpCookies.storage;
            this.L$0 = httpCookies;
            this.L$1 = it;
            this.label = 1;
            if (function2.invoke(cookiesStorage, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
