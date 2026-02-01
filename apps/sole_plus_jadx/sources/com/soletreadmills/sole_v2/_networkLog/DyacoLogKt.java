package com.soletreadmills.sole_v2._networkLog;

import com.soletreadmills.sole_v2._data.api.log.LogApiData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;

/* compiled from: DyacoLog.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"callLogApi", "Lretrofit2/Response;", "Lcom/soletreadmills/sole_v2/_data/api/log/LogApiData$ResponseData;", "requestBodyData", "Lcom/soletreadmills/sole_v2/_data/api/log/LogApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/log/LogApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DyacoLogKt {
    public static final Object callLogApi(LogApiData.RequestBodyData requestBodyData, Continuation<? super Response<LogApiData.ResponseData>> continuation) {
        return LogRetrofit.INSTANCE.getApiServiceLog().uploadLog(requestBodyData, continuation);
    }
}
