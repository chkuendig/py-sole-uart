package com.soletreadmills.sole_v2._network;

import com.facebook.internal.NativeProtocol;
import com.soletreadmills.sole_v2._data.api.classes.GetClassInstructorsApiData;
import com.soletreadmills.sole_v2._data.api.settings.BluetoothSubscriptionApiData;
import com.soletreadmills.sole_v2._data.api.settings.ChangeSubscriptionPlanApiData;
import com.soletreadmills.sole_v2._data.api.settings.DeleteSubscriptionApiData;
import com.soletreadmills.sole_v2._data.api.settings.DeleteSubscriptionMethodApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetSubscriptionPaymentLinkApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetSubscriptionPlansApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetUserSubscriptionApiData;
import com.soletreadmills.sole_v2._data.api.settings.ReSubscriptionApiData;
import com.soletreadmills.sole_v2._data.api.settings.SnSubscriptionApiData;
import com.soletreadmills.sole_v2._data.api.settings.UpdateSubscriptionPaymentLinkApiData;
import com.soletreadmills.sole_v2._data.classes.CompletedClassEventRequest;
import com.soletreadmills.sole_v2._data.classes.DeleteFavoriteRequest;
import com.soletreadmills.sole_v2._data.classes.GetClassDetailApiData;
import com.soletreadmills.sole_v2._data.classes.GetClassListApiData;
import com.soletreadmills.sole_v2._data.classes.GetClassQuickPicksApiData;
import com.soletreadmills.sole_v2._data.classes.GetClassVideoDetailApiData;
import com.soletreadmills.sole_v2._data.classes.GetCollectionDetailApiData;
import com.soletreadmills.sole_v2._data.classes.GetCollectionQuickPicksApiData;
import com.soletreadmills.sole_v2._data.classes.GetCollectionsApiData;
import com.soletreadmills.sole_v2._data.classes.GetFavoritesApiData;
import com.soletreadmills.sole_v2._data.classes.GetSubscriptionStatusApiData;
import com.soletreadmills.sole_v2._data.classes.PostFavoriteParameters;
import com.soletreadmills.sole_v2._networkJwt.JwtRetrofit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: JwtDyacoApi.kt */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\u0006\u0010\u0003\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000e\u001a\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00012\u0006\u0010\u0003\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00012\u0006\u0010\u0003\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016\u001a \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0002\u0010\u001b\u001a\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0001H\u0086@¢\u0006\u0002\u0010\u001e\u001az\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020*H\u0086@¢\u0006\u0002\u0010,\u001a \u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0002\u0010\u001b\u001a\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0001H\u0086@¢\u0006\u0002\u0010\u001e\u001aV\u00102\u001a\b\u0012\u0004\u0012\u0002030\u00012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020*H\u0086@¢\u0006\u0002\u00104\u001a\u001c\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00012\u0006\u0010\f\u001a\u000207H\u0086@¢\u0006\u0002\u00108\u001a\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0001H\u0086@¢\u0006\u0002\u0010\u001e\u001a\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u00012\u0006\u0010\u0003\u001a\u00020=H\u0086@¢\u0006\u0002\u0010>\u001a\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u00012\u0006\u0010\u0003\u001a\u00020AH\u0086@¢\u0006\u0002\u0010B\u001a\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u0001H\u0086@¢\u0006\u0002\u0010\u001e\u001a\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u0001H\u0086@¢\u0006\u0002\u0010\u001e\u001a\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00012\u0006\u0010\u0003\u001a\u00020IH\u0086@¢\u0006\u0002\u0010J\u001a \u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u00012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0002\u0010\u001b\u001a$\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u00012\u0006\u0010P\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010Q\u001a$\u0010R\u001a\b\u0012\u0004\u0012\u00020O0\u00012\u0006\u0010P\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010Q\u001a$\u0010S\u001a\b\u0012\u0004\u0012\u00020O0\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020TH\u0086@¢\u0006\u0002\u0010U\u001a\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020O0\u00012\u0006\u0010\f\u001a\u00020WH\u0086@¢\u0006\u0002\u0010X\u001a\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020O0\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001b\u001a\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\u00012\u0006\u0010\u0003\u001a\u00020\\H\u0086@¢\u0006\u0002\u0010]\u001a\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\u00012\u0006\u0010\u0003\u001a\u00020`H\u0086@¢\u0006\u0002\u0010a¨\u0006b"}, d2 = {"callBluetoothSubscription", "Lretrofit2/Response;", "Lcom/soletreadmills/sole_v2/_data/api/settings/BluetoothSubscriptionApiData$ResponseData;", "requestBody", "Lcom/soletreadmills/sole_v2/_data/api/settings/BluetoothSubscriptionApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/BluetoothSubscriptionApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callChangeSubscriptionPlan", "Lcom/soletreadmills/sole_v2/_data/api/settings/ChangeSubscriptionPlanApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/ChangeSubscriptionPlanApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/ChangeSubscriptionPlanApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callDeleteFavorite", "Lcom/soletreadmills/sole_v2/_data/classes/DeleteFavoriteRequest$ResponseData;", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/soletreadmills/sole_v2/_data/classes/DeleteFavoriteRequest$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/classes/DeleteFavoriteRequest$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callDeleteSubscription", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callDeleteSubscriptionPayment", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionMethodApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionMethodApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionMethodApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetClassDetailApiData", "Lcom/soletreadmills/sole_v2/_data/classes/GetClassDetailApiData$ResponseData;", "classId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetClassInstructors", "Lcom/soletreadmills/sole_v2/_data/api/classes/GetClassInstructorsApiData$ResponseData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetClassListApiData", "Lcom/soletreadmills/sole_v2/_data/classes/GetClassListApiData$ResponseData;", "keyword", "classTypes", "difficulties", "durations", "instructorIds", "myFavorite", "", "workoutTypes", "page", "", "pageSize", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetCollectionByIdApiData", "Lcom/soletreadmills/sole_v2/_data/classes/GetCollectionDetailApiData$ResponseData;", "collectionId", "callGetCollectionQuickPick", "Lcom/soletreadmills/sole_v2/_data/classes/GetCollectionQuickPicksApiData$ResponseData;", "callGetCollectionsApiData", "Lcom/soletreadmills/sole_v2/_data/classes/GetCollectionsApiData$ResponseData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetFavorites", "Lcom/soletreadmills/sole_v2/_data/classes/GetFavoritesApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/classes/GetFavoritesApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/classes/GetFavoritesApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetSessionQuickPick", "Lcom/soletreadmills/sole_v2/_data/classes/GetClassQuickPicksApiData$ResponseData;", "callGetSubscription", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetSubscriptionPaymentLink", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPaymentLinkApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPaymentLinkApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPaymentLinkApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetSubscriptionPlans", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPlansApiData$ResponseData;", "callGetSubscriptionStatus", "Lcom/soletreadmills/sole_v2/_data/classes/GetSubscriptionStatusApiData$ResponseData;", "callGetUpdateSubscriptionPaymentLink", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateSubscriptionPaymentLinkApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateSubscriptionPaymentLinkApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateSubscriptionPaymentLinkApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetVideoDetailApiData", "Lcom/soletreadmills/sole_v2/_data/classes/GetClassVideoDetailApiData$ResponseData;", "videoId", "callPostClassClick", "", "brandCode", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callPostCollectionClick", "callPostCompletedClassEvent", "Lcom/soletreadmills/sole_v2/_data/classes/CompletedClassEventRequest$RequestBodyData;", "(Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/classes/CompletedClassEventRequest$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callPostFavorite", "Lcom/soletreadmills/sole_v2/_data/classes/PostFavoriteParameters;", "(Lcom/soletreadmills/sole_v2/_data/classes/PostFavoriteParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callPostStartClass", "callReSubscriptionPlan", "Lcom/soletreadmills/sole_v2/_data/api/settings/ReSubscriptionApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/ReSubscriptionApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/ReSubscriptionApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callSnSubscription", "Lcom/soletreadmills/sole_v2/_data/api/settings/SnSubscriptionApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/SnSubscriptionApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/SnSubscriptionApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JwtDyacoApiKt {
    public static final Object callGetClassInstructors(Continuation<? super Response<GetClassInstructorsApiData.ResponseData>> continuation) {
        Timber.INSTANCE.d("call callIsUserExists", new Object[0]);
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getClassInstructors(continuation);
    }

    public static final Object callGetClassListApiData(String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i, int i2, Continuation<? super Response<GetClassListApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getClassList(str2, str3, str4, str5, str, z, str6, i, i2, continuation);
    }

    public static final Object callGetCollectionsApiData(String str, String str2, String str3, boolean z, int i, int i2, Continuation<? super Response<GetCollectionsApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getCollections(str2, str3, str, z, i, i2, continuation);
    }

    public static /* synthetic */ Object callGetCollectionByIdApiData$default(String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return callGetCollectionByIdApiData(str, continuation);
    }

    public static final Object callGetCollectionByIdApiData(String str, Continuation<? super Response<GetCollectionDetailApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getCollectionById(str, continuation);
    }

    public static /* synthetic */ Object callGetClassDetailApiData$default(String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return callGetClassDetailApiData(str, continuation);
    }

    public static final Object callGetClassDetailApiData(String str, Continuation<? super Response<GetClassDetailApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getClassDetail(str, continuation);
    }

    public static final Object callPostClassClick(String str, String str2, Continuation<? super Response<Unit>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().classClick(str, str2, continuation);
    }

    public static final Object callPostCollectionClick(String str, String str2, Continuation<? super Response<Unit>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().collectionClick(str, str2, continuation);
    }

    public static final Object callPostFavorite(PostFavoriteParameters postFavoriteParameters, Continuation<? super Response<Unit>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().postFavorite(postFavoriteParameters, continuation);
    }

    public static final Object callDeleteFavorite(DeleteFavoriteRequest.RequestBodyData requestBodyData, Continuation<? super Response<DeleteFavoriteRequest.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().deleteFavorite(requestBodyData, continuation);
    }

    public static /* synthetic */ Object callGetVideoDetailApiData$default(String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return callGetVideoDetailApiData(str, continuation);
    }

    public static final Object callGetVideoDetailApiData(String str, Continuation<? super Response<GetClassVideoDetailApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getVideoDetail(str, continuation);
    }

    public static final Object callPostStartClass(String str, Continuation<? super Response<Unit>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().startClass(str, continuation);
    }

    public static final Object callGetSubscriptionStatus(Continuation<? super Response<GetSubscriptionStatusApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getSubscriptionStatus(continuation);
    }

    public static final Object callGetSubscriptionPlans(Continuation<? super Response<GetSubscriptionPlansApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getSubscriptionPlans(continuation);
    }

    public static final Object callGetSubscription(GetUserSubscriptionApiData.RequestBody requestBody, Continuation<? super Response<GetUserSubscriptionApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getSubscription(requestBody.getTimeZone(), continuation);
    }

    public static final Object callDeleteSubscription(DeleteSubscriptionApiData.RequestBodyData requestBodyData, Continuation<? super Response<DeleteSubscriptionApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().deleteSubscription(requestBodyData, continuation);
    }

    public static final Object callGetSubscriptionPaymentLink(GetSubscriptionPaymentLinkApiData.RequestBody requestBody, Continuation<? super Response<GetSubscriptionPaymentLinkApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getSubscriptionPaymentLink(requestBody.getPriceId(), requestBody.getEmail(), continuation);
    }

    public static final Object callGetUpdateSubscriptionPaymentLink(UpdateSubscriptionPaymentLinkApiData.RequestBody requestBody, Continuation<? super Response<UpdateSubscriptionPaymentLinkApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getUpdateSubscriptionPaymentLink(requestBody.getUser_subscription_id(), continuation);
    }

    public static final Object callChangeSubscriptionPlan(ChangeSubscriptionPlanApiData.RequestBody requestBody, Continuation<? super Response<ChangeSubscriptionPlanApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().changeSubscriptionPlan(requestBody, continuation);
    }

    public static final Object callReSubscriptionPlan(ReSubscriptionApiData.RequestBodyData requestBodyData, Continuation<? super Response<ReSubscriptionApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().reSubscriptionPlan(requestBodyData, continuation);
    }

    public static final Object callDeleteSubscriptionPayment(DeleteSubscriptionMethodApiData.RequestBodyData requestBodyData, Continuation<? super Response<DeleteSubscriptionMethodApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().deleteSubscriptionPayment(requestBodyData, continuation);
    }

    public static final Object callSnSubscription(SnSubscriptionApiData.RequestBody requestBody, Continuation<? super Response<SnSubscriptionApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().snSubscription(requestBody, continuation);
    }

    public static final Object callBluetoothSubscription(BluetoothSubscriptionApiData.RequestBody requestBody, Continuation<? super Response<BluetoothSubscriptionApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().bluetoothSubscription(requestBody, continuation);
    }

    public static final Object callPostCompletedClassEvent(String str, CompletedClassEventRequest.RequestBodyData requestBodyData, Continuation<? super Response<Unit>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().postCompletedClassEvent(str, requestBodyData, continuation);
    }

    public static final Object callGetSessionQuickPick(Continuation<? super Response<GetClassQuickPicksApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getQuickPicks(continuation);
    }

    public static final Object callGetCollectionQuickPick(Continuation<? super Response<GetCollectionQuickPicksApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getCollectionQuickPicks(continuation);
    }

    public static final Object callGetFavorites(GetFavoritesApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetFavoritesApiData.ResponseData>> continuation) {
        return JwtRetrofit.INSTANCE.getApiServiceJwt().getFavorites(requestBodyData.getObjectTypes(), continuation);
    }
}
