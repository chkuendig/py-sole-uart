package com.soletreadmills.sole_v2._network;

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
import com.soletreadmills.sole_v2._data.classes.FollowCollectionRequest;
import com.soletreadmills.sole_v2._data.classes.GetClassDetailApiData;
import com.soletreadmills.sole_v2._data.classes.GetClassListApiData;
import com.soletreadmills.sole_v2._data.classes.GetClassQuickPicksApiData;
import com.soletreadmills.sole_v2._data.classes.GetClassVideoDetailApiData;
import com.soletreadmills.sole_v2._data.classes.GetCollectionDetailApiData;
import com.soletreadmills.sole_v2._data.classes.GetCollectionQuickPicksApiData;
import com.soletreadmills.sole_v2._data.classes.GetCollectionsApiData;
import com.soletreadmills.sole_v2._data.classes.GetFavoritesApiData;
import com.soletreadmills.sole_v2._data.classes.GetFollowedCollectionApiData;
import com.soletreadmills.sole_v2._data.classes.GetSubscriptionStatusApiData;
import com.soletreadmills.sole_v2._data.classes.PostFavoriteParameters;
import com.soletreadmills.sole_v2._data.classes.UpdateClassProgressRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* compiled from: JwtDyacoApiService.kt */
@Metadata(d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0011J(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0013\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0016H§@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0019H§@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001dH§@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010\u0005\u001a\u00020!H§@¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0019H§@¢\u0006\u0002\u0010\u001aJ \u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000fH§@¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0003H§@¢\u0006\u0002\u0010)Jz\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00032\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010/\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u000f2\b\b\u0003\u00101\u001a\u0002022\n\b\u0003\u00103\u001a\u0004\u0018\u00010\u000f2\b\b\u0003\u00104\u001a\u0002052\b\b\u0003\u00106\u001a\u000205H§@¢\u0006\u0002\u00107J \u00108\u001a\b\u0012\u0004\u0012\u0002090\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u000fH§@¢\u0006\u0002\u0010&J\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0003H§@¢\u0006\u0002\u0010)JV\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00032\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010/\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u000f2\b\b\u0003\u00101\u001a\u0002022\b\b\u0003\u00104\u001a\u0002052\b\b\u0003\u00106\u001a\u000205H§@¢\u0006\u0002\u0010>J \u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u00032\n\b\u0003\u0010A\u001a\u0004\u0018\u00010\u000fH§@¢\u0006\u0002\u0010&J\u001e\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00032\b\b\u0001\u0010D\u001a\u00020\u000fH§@¢\u0006\u0002\u0010&J\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u0003H§@¢\u0006\u0002\u0010)J\u001e\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00032\b\b\u0001\u0010I\u001a\u00020\u000fH§@¢\u0006\u0002\u0010&J*\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00032\b\b\u0001\u0010L\u001a\u00020\u000f2\n\b\u0001\u0010M\u001a\u0004\u0018\u00010\u000fH§@¢\u0006\u0002\u0010\u0011J\u0014\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u0003H§@¢\u0006\u0002\u0010)J\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u0003H§@¢\u0006\u0002\u0010)J\u001e\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u00032\b\b\u0001\u0010T\u001a\u00020\u000fH§@¢\u0006\u0002\u0010&J \u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u00032\n\b\u0003\u0010W\u001a\u0004\u0018\u00010\u000fH§@¢\u0006\u0002\u0010&J(\u0010X\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0005\u001a\u00020YH§@¢\u0006\u0002\u0010ZJ\u001e\u0010[\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\\H§@¢\u0006\u0002\u0010]J\u001e\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\u00032\b\b\u0001\u0010\u0005\u001a\u00020`H§@¢\u0006\u0002\u0010aJ\u001e\u0010b\u001a\b\u0012\u0004\u0012\u00020c0\u00032\b\b\u0001\u0010\u0005\u001a\u00020dH§@¢\u0006\u0002\u0010eJ\u001e\u0010f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u000fH§@¢\u0006\u0002\u0010&J(\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0005\u001a\u00020hH§@¢\u0006\u0002\u0010i¨\u0006j"}, d2 = {"Lcom/soletreadmills/sole_v2/_network/JwtDyacoApiService;", "", "bluetoothSubscription", "Lretrofit2/Response;", "Lcom/soletreadmills/sole_v2/_data/api/settings/BluetoothSubscriptionApiData$ResponseData;", "body", "Lcom/soletreadmills/sole_v2/_data/api/settings/BluetoothSubscriptionApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/BluetoothSubscriptionApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeSubscriptionPlan", "Lcom/soletreadmills/sole_v2/_data/api/settings/ChangeSubscriptionPlanApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/ChangeSubscriptionPlanApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/ChangeSubscriptionPlanApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "classClick", "", "brandCode", "", "classId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectionClick", "collectionId", "deleteFavorite", "Lcom/soletreadmills/sole_v2/_data/classes/DeleteFavoriteRequest$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/classes/DeleteFavoriteRequest$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/classes/DeleteFavoriteRequest$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFollowCollection", "Lcom/soletreadmills/sole_v2/_data/classes/FollowCollectionRequest$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/classes/FollowCollectionRequest$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSubscription", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSubscriptionPayment", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionMethodApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionMethodApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteSubscriptionMethodApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "followCollection", "getClassDetail", "Lcom/soletreadmills/sole_v2/_data/classes/GetClassDetailApiData$ResponseData;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassInstructors", "Lcom/soletreadmills/sole_v2/_data/api/classes/GetClassInstructorsApiData$ResponseData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassList", "Lcom/soletreadmills/sole_v2/_data/classes/GetClassListApiData$ResponseData;", "classTypes", "difficulties", "durations", "instructorIds", "keyword", "myFavorite", "", "workoutTypes", "page", "", "pageSize", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCollectionById", "Lcom/soletreadmills/sole_v2/_data/classes/GetCollectionDetailApiData$ResponseData;", "getCollectionQuickPicks", "Lcom/soletreadmills/sole_v2/_data/classes/GetCollectionQuickPicksApiData$ResponseData;", "getCollections", "Lcom/soletreadmills/sole_v2/_data/classes/GetCollectionsApiData$ResponseData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavorites", "Lcom/soletreadmills/sole_v2/_data/classes/GetFavoritesApiData$ResponseData;", "objectTypes", "getFollowedCollection", "Lcom/soletreadmills/sole_v2/_data/classes/GetFollowedCollectionApiData$ResponseData;", "status", "getQuickPicks", "Lcom/soletreadmills/sole_v2/_data/classes/GetClassQuickPicksApiData$ResponseData;", "getSubscription", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetUserSubscriptionApiData$ResponseData;", "timeZone", "getSubscriptionPaymentLink", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPaymentLinkApiData$ResponseData;", "price_id", "email", "getSubscriptionPlans", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPlansApiData$ResponseData;", "getSubscriptionStatus", "Lcom/soletreadmills/sole_v2/_data/classes/GetSubscriptionStatusApiData$ResponseData;", "getUpdateSubscriptionPaymentLink", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateSubscriptionPaymentLinkApiData$ResponseData;", "user_subscription_id", "getVideoDetail", "Lcom/soletreadmills/sole_v2/_data/classes/GetClassVideoDetailApiData$ResponseData;", "videoId", "postCompletedClassEvent", "Lcom/soletreadmills/sole_v2/_data/classes/CompletedClassEventRequest$RequestBodyData;", "(Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/classes/CompletedClassEventRequest$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postFavorite", "Lcom/soletreadmills/sole_v2/_data/classes/PostFavoriteParameters;", "(Lcom/soletreadmills/sole_v2/_data/classes/PostFavoriteParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reSubscriptionPlan", "Lcom/soletreadmills/sole_v2/_data/api/settings/ReSubscriptionApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/ReSubscriptionApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/ReSubscriptionApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snSubscription", "Lcom/soletreadmills/sole_v2/_data/api/settings/SnSubscriptionApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/SnSubscriptionApiData$RequestBody;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/SnSubscriptionApiData$RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startClass", "updateClassProgresses", "Lcom/soletreadmills/sole_v2/_data/classes/UpdateClassProgressRequest$RequestBodyData;", "(Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/classes/UpdateClassProgressRequest$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface JwtDyacoApiService {
    @POST("app/v2/api/me/subscription/bluetooth")
    Object bluetoothSubscription(@Body BluetoothSubscriptionApiData.RequestBody requestBody, Continuation<? super Response<BluetoothSubscriptionApiData.ResponseData>> continuation);

    @PATCH("app/v2/api/me/subscription/plan")
    Object changeSubscriptionPlan(@Body ChangeSubscriptionPlanApiData.RequestBody requestBody, Continuation<? super Response<ChangeSubscriptionPlanApiData.ResponseData>> continuation);

    @POST("api/brands/{brandCode}/classes/{classId}/click")
    Object classClick(@Path("brandCode") String str, @Path("classId") String str2, Continuation<? super Response<Unit>> continuation);

    @POST("api/brands/{brandCode}/collections/{collectionId}/click")
    Object collectionClick(@Path("brandCode") String str, @Path("collectionId") String str2, Continuation<? super Response<Unit>> continuation);

    @HTTP(hasBody = true, method = "DELETE", path = "app/v2/api/me/favorites")
    Object deleteFavorite(@Body DeleteFavoriteRequest.RequestBodyData requestBodyData, Continuation<? super Response<DeleteFavoriteRequest.ResponseData>> continuation);

    @HTTP(hasBody = true, method = "DELETE", path = "app/v2/api/me/followed-collections")
    Object deleteFollowCollection(@Body FollowCollectionRequest.RequestBodyData requestBodyData, Continuation<? super Response<Unit>> continuation);

    @HTTP(hasBody = true, method = "DELETE", path = "app/v2/api/me/subscription")
    Object deleteSubscription(@Body DeleteSubscriptionApiData.RequestBodyData requestBodyData, Continuation<? super Response<DeleteSubscriptionApiData.ResponseData>> continuation);

    @HTTP(hasBody = true, method = "DELETE", path = "app/v2/api/me/subscription/payment-methods")
    Object deleteSubscriptionPayment(@Body DeleteSubscriptionMethodApiData.RequestBodyData requestBodyData, Continuation<? super Response<DeleteSubscriptionMethodApiData.ResponseData>> continuation);

    @POST("app/v2/api/me/followed-collections")
    Object followCollection(@Body FollowCollectionRequest.RequestBodyData requestBodyData, Continuation<? super Response<Unit>> continuation);

    @GET("app/v2/api/classes/{classId}")
    Object getClassDetail(@Path("classId") String str, Continuation<? super Response<GetClassDetailApiData.ResponseData>> continuation);

    @GET("app/v2/api/class-instructors")
    Object getClassInstructors(Continuation<? super Response<GetClassInstructorsApiData.ResponseData>> continuation);

    @GET("app/v2/api/classes")
    Object getClassList(@Query("class_types") String str, @Query("difficulties") String str2, @Query("durations") String str3, @Query("instructor_ids") String str4, @Query("keyword") String str5, @Query("my_favorite") boolean z, @Query("workout_types") String str6, @Query("page") int i, @Query("page_size") int i2, Continuation<? super Response<GetClassListApiData.ResponseData>> continuation);

    @GET("app/v2/api/collections/{collectionId}")
    Object getCollectionById(@Path("collectionId") String str, Continuation<? super Response<GetCollectionDetailApiData.ResponseData>> continuation);

    @GET("app/v2/api/collection-quick-picks")
    Object getCollectionQuickPicks(Continuation<? super Response<GetCollectionQuickPicksApiData.ResponseData>> continuation);

    @GET("app/v2/api/collection-summaries")
    Object getCollections(@Query("class_types") String str, @Query("instructor_ids") String str2, @Query("keyword") String str3, @Query("my_favorite") boolean z, @Query("page") int i, @Query("page_size") int i2, Continuation<? super Response<GetCollectionsApiData.ResponseData>> continuation);

    @GET("app/v2/api/me/favorites")
    Object getFavorites(@Query("object_types") String str, Continuation<? super Response<GetFavoritesApiData.ResponseData>> continuation);

    @GET("app/v2/api/me/followed-collection")
    Object getFollowedCollection(@Query("status") String str, Continuation<? super Response<GetFollowedCollectionApiData.ResponseData>> continuation);

    @GET("app/v2/api/class-quick-picks")
    Object getQuickPicks(Continuation<? super Response<GetClassQuickPicksApiData.ResponseData>> continuation);

    @GET("app/v2/api/me/subscription")
    Object getSubscription(@Query("time_zone") String str, Continuation<? super Response<GetUserSubscriptionApiData.ResponseData>> continuation);

    @GET("app/v2/api/subscription/payment-link")
    Object getSubscriptionPaymentLink(@Query("price_id") String str, @Query("email") String str2, Continuation<? super Response<GetSubscriptionPaymentLinkApiData.ResponseData>> continuation);

    @GET("app/v2/api/me/subscription-plans")
    Object getSubscriptionPlans(Continuation<? super Response<GetSubscriptionPlansApiData.ResponseData>> continuation);

    @GET("app/v2/api/me/subscription-status")
    Object getSubscriptionStatus(Continuation<? super Response<GetSubscriptionStatusApiData.ResponseData>> continuation);

    @GET("app/v2/api/me/subscription/update-payment-link")
    Object getUpdateSubscriptionPaymentLink(@Query("user_subscription_id") String str, Continuation<? super Response<UpdateSubscriptionPaymentLinkApiData.ResponseData>> continuation);

    @GET("app/v2/api/class-videos/{videoId}")
    Object getVideoDetail(@Path("videoId") String str, Continuation<? super Response<GetClassVideoDetailApiData.ResponseData>> continuation);

    @POST("app/v2/api/classes/{classId}/completed")
    Object postCompletedClassEvent(@Path("classId") String str, @Body CompletedClassEventRequest.RequestBodyData requestBodyData, Continuation<? super Response<Unit>> continuation);

    @POST("app/v2/api/me/favorites")
    Object postFavorite(@Body PostFavoriteParameters postFavoriteParameters, Continuation<? super Response<Unit>> continuation);

    @PATCH("app/v2/api/me/subscription")
    Object reSubscriptionPlan(@Body ReSubscriptionApiData.RequestBodyData requestBodyData, Continuation<? super Response<ReSubscriptionApiData.ResponseData>> continuation);

    @POST("app/v2/api/me/subscription/sn")
    Object snSubscription(@Body SnSubscriptionApiData.RequestBody requestBody, Continuation<? super Response<SnSubscriptionApiData.ResponseData>> continuation);

    @POST("app/v2/api/classes/{classId}/start")
    Object startClass(@Path("classId") String str, Continuation<? super Response<Unit>> continuation);

    @PATCH("app/v2/api/class-progresses/{classId}")
    Object updateClassProgresses(@Path("classId") String str, @Body UpdateClassProgressRequest.RequestBodyData requestBodyData, Continuation<? super Response<Unit>> continuation);

    /* compiled from: JwtDyacoApiService.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getVideoDetail$default(JwtDyacoApiService jwtDyacoApiService, String str, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVideoDetail");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            return jwtDyacoApiService.getVideoDetail(str, continuation);
        }

        public static /* synthetic */ Object getClassList$default(JwtDyacoApiService jwtDyacoApiService, String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return jwtDyacoApiService.getClassList((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? false : z, (i3 & 64) != 0 ? null : str6, (i3 & 128) != 0 ? 1 : i, (i3 & 256) != 0 ? 100 : i2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getClassList");
        }

        public static /* synthetic */ Object getClassDetail$default(JwtDyacoApiService jwtDyacoApiService, String str, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getClassDetail");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            return jwtDyacoApiService.getClassDetail(str, continuation);
        }

        public static /* synthetic */ Object getCollections$default(JwtDyacoApiService jwtDyacoApiService, String str, String str2, String str3, boolean z, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return jwtDyacoApiService.getCollections((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? 1 : i, (i3 & 32) != 0 ? 12 : i2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCollections");
        }

        public static /* synthetic */ Object getCollectionById$default(JwtDyacoApiService jwtDyacoApiService, String str, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCollectionById");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            return jwtDyacoApiService.getCollectionById(str, continuation);
        }

        public static /* synthetic */ Object getFavorites$default(JwtDyacoApiService jwtDyacoApiService, String str, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFavorites");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            return jwtDyacoApiService.getFavorites(str, continuation);
        }
    }
}
