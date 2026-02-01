package com.soletreadmills.sole_v2._network;

import com.facebook.internal.NativeProtocol;
import com.soletreadmills.sole_v2._data.api.banner.BannerApiData;
import com.soletreadmills.sole_v2._data.api.banner.BannerConfigApiData;
import com.soletreadmills.sole_v2._data.api.settings.DeleteMessageApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetMessagesApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetUnReadMessagesApiData;
import com.soletreadmills.sole_v2._data.api.settings.PatchAllMessageStatusApiData;
import com.soletreadmills.sole_v2._data.api.settings.PatchMessageStatusApiData;
import com.soletreadmills.sole_v2._networkJwtNotification.JwtNotificationRetrofit;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;

/* compiled from: JwtNotificationDyacoApi.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\u0006\u0010\u0003\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\u0006\u0010\u0003\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\r\u001a\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\u0006\u0010\u0003\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00012\u0006\u0010\u0003\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00012\u0006\u0010\u0003\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019\u001a\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001H\u0086@¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"callDeleteMessage", "Lretrofit2/Response;", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteMessageApiData$ResponseData;", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteMessageApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteMessageApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetBanner", "Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetMessages", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callPatchAllMessageStatus", "Lcom/soletreadmills/sole_v2/_data/api/settings/PatchAllMessageStatusApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/PatchAllMessageStatusApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/PatchAllMessageStatusApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callPatchBannerConfig", "Lcom/soletreadmills/sole_v2/_data/api/banner/BannerConfigApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/banner/BannerConfigApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/banner/BannerConfigApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callPatchMessageStatus", "Lcom/soletreadmills/sole_v2/_data/api/settings/PatchMessageStatusApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/PatchMessageStatusApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/PatchMessageStatusApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callUnReadMessageCount", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetUnReadMessagesApiData$ResponseData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JwtNotificationDyacoApiKt {
    public static final Object callGetMessages(GetMessagesApiData.RequestBody requestBody, Continuation<? super Response<GetMessagesApiData.ResponseData>> continuation) {
        return JwtNotificationRetrofit.INSTANCE.getApiServiceJwtNotification().getMessages(requestBody.getPage(), requestBody.getPageSize(), continuation);
    }

    public static final Object callPatchMessageStatus(PatchMessageStatusApiData.RequestBody requestBody, Continuation<? super Response<PatchMessageStatusApiData.ResponseData>> continuation) {
        return JwtNotificationRetrofit.INSTANCE.getApiServiceJwtNotification().patchMessageStatus(requestBody, continuation);
    }

    public static final Object callPatchAllMessageStatus(PatchAllMessageStatusApiData.RequestBody requestBody, Continuation<? super Response<PatchAllMessageStatusApiData.ResponseData>> continuation) {
        return JwtNotificationRetrofit.INSTANCE.getApiServiceJwtNotification().patchAllMessageStatus(requestBody, continuation);
    }

    public static final Object callDeleteMessage(DeleteMessageApiData.RequestBody requestBody, Continuation<? super Response<DeleteMessageApiData.ResponseData>> continuation) {
        return JwtNotificationRetrofit.INSTANCE.getApiServiceJwtNotification().deleteMessage(requestBody, continuation);
    }

    public static final Object callUnReadMessageCount(Continuation<? super Response<GetUnReadMessagesApiData.ResponseData>> continuation) {
        return JwtNotificationRetrofit.INSTANCE.getApiServiceJwtNotification().getUnReadMessageCount(continuation);
    }

    public static final Object callGetBanner(BannerApiData.RequestBodyData requestBodyData, Continuation<? super Response<BannerApiData.ResponseData>> continuation) {
        return JwtNotificationRetrofit.INSTANCE.getApiServiceJwtNotification().getBanner(requestBodyData.getAppLaunchTime(), requestBodyData.getCountryCode(), continuation);
    }

    public static final Object callPatchBannerConfig(BannerConfigApiData.RequestBodyData requestBodyData, Continuation<? super Response<BannerConfigApiData.ResponseData>> continuation) {
        return JwtNotificationRetrofit.INSTANCE.getApiServiceJwtNotification().patchBannerConfig(requestBodyData, continuation);
    }
}
