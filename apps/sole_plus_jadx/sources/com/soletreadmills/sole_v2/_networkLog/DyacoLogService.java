package com.soletreadmills.sole_v2._networkLog;

import com.soletreadmills.sole_v2._data.api.log.LogApiData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* compiled from: DyacoLogService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_networkLog/DyacoLogService;", "", "uploadLog", "Lretrofit2/Response;", "Lcom/soletreadmills/sole_v2/_data/api/log/LogApiData$ResponseData;", "body", "Lcom/soletreadmills/sole_v2/_data/api/log/LogApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/log/LogApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DyacoLogService {
    @POST(".")
    Object uploadLog(@Body LogApiData.RequestBodyData requestBodyData, Continuation<? super Response<LogApiData.ResponseData>> continuation);
}
