package com.soletreadmills.sole_v2._network;

import com.soletreadmills.sole_v2._data.api.banner.BannerApiData;
import com.soletreadmills.sole_v2._data.api.banner.BannerConfigApiData;
import com.soletreadmills.sole_v2._data.api.settings.DeleteMessageApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetMessagesApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetUnReadMessagesApiData;
import com.soletreadmills.sole_v2._data.api.settings.PatchAllMessageStatusApiData;
import com.soletreadmills.sole_v2._data.api.settings.PatchMessageStatusApiData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.PATCH;
import retrofit2.http.Query;

/* compiled from: JwtNotificationDyacoApiService.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003H§@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0019H§@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001dH§@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010\u0005\u001a\u00020!H§@¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"Lcom/soletreadmills/sole_v2/_network/JwtNotificationDyacoApiService;", "", "deleteMessage", "Lretrofit2/Response;", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteMessageApiData$ResponseData;", "body", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteMessageApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteMessageApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBanner", "Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$ResponseData;", "app_launch_time", "", "country_code", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessages", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$ResponseData;", "page", "", "pageSize", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUnReadMessageCount", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetUnReadMessagesApiData$ResponseData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "patchAllMessageStatus", "Lcom/soletreadmills/sole_v2/_data/api/settings/PatchAllMessageStatusApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/PatchAllMessageStatusApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/PatchAllMessageStatusApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "patchBannerConfig", "Lcom/soletreadmills/sole_v2/_data/api/banner/BannerConfigApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/banner/BannerConfigApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/banner/BannerConfigApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "patchMessageStatus", "Lcom/soletreadmills/sole_v2/_data/api/settings/PatchMessageStatusApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/PatchMessageStatusApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/PatchMessageStatusApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface JwtNotificationDyacoApiService {
    @HTTP(hasBody = true, method = "DELETE", path = "app/api/message")
    Object deleteMessage(@Body DeleteMessageApiData.RequestBody requestBody, Continuation<? super Response<DeleteMessageApiData.ResponseData>> continuation);

    @GET("app/api/banner")
    Object getBanner(@Query("app_launch_time") String str, @Query("country_code") String str2, Continuation<? super Response<BannerApiData.ResponseData>> continuation);

    @GET("app/api/messages")
    Object getMessages(@Query("page") int i, @Query("pageSize") int i2, Continuation<? super Response<GetMessagesApiData.ResponseData>> continuation);

    @GET("app/api/message/unread-message-count")
    Object getUnReadMessageCount(Continuation<? super Response<GetUnReadMessagesApiData.ResponseData>> continuation);

    @PATCH("app/api/messages/read-status")
    Object patchAllMessageStatus(@Body PatchAllMessageStatusApiData.RequestBody requestBody, Continuation<? super Response<PatchAllMessageStatusApiData.ResponseData>> continuation);

    @PATCH("app/api/config")
    Object patchBannerConfig(@Body BannerConfigApiData.RequestBodyData requestBodyData, Continuation<? super Response<BannerConfigApiData.ResponseData>> continuation);

    @PATCH("app/api/message/read-status")
    Object patchMessageStatus(@Body PatchMessageStatusApiData.RequestBody requestBody, Continuation<? super Response<PatchMessageStatusApiData.ResponseData>> continuation);
}
