package com.soletreadmills.sole_v2._network;

import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._data.api.LogoutMachineFromAppApiData;
import com.soletreadmills.sole_v2._data.api._global.CheckAppUpdateApi;
import com.soletreadmills.sole_v2._data.api._global.GetLoginServerAddressApiData;
import com.soletreadmills.sole_v2._data.api._global.GetRegisterServerAddressApiData;
import com.soletreadmills.sole_v2._data.api._global.IsUserExistsApiData;
import com.soletreadmills.sole_v2._data.api.activity.GetAllPersonalBestDefinitionApiData;
import com.soletreadmills.sole_v2._data.api.activity.GetMyLatest3MonthWorkoutStatsApiData;
import com.soletreadmills.sole_v2._data.api.activity.GetMyLatest6WeeklyActiveTimeApiData;
import com.soletreadmills.sole_v2._data.api.activity.GetMyPersonalBestListApiData;
import com.soletreadmills.sole_v2._data.api.club.CreateChallengeApiData;
import com.soletreadmills.sole_v2._data.api.club.DeleteChallengeApiData;
import com.soletreadmills.sole_v2._data.api.club.DeleteChallengeCoverPhotoApiData;
import com.soletreadmills.sole_v2._data.api.club.GetChallengeDetailApiData;
import com.soletreadmills.sole_v2._data.api.club.GetChallengeMemberWorkoutListApiData;
import com.soletreadmills.sole_v2._data.api.club.GetChallengesCreatedByMeApiData;
import com.soletreadmills.sole_v2._data.api.club.GetMyComingChallengesApiData;
import com.soletreadmills.sole_v2._data.api.club.GetMyFinishedChallengesApiData;
import com.soletreadmills.sole_v2._data.api.club.GetMyOnGoingChallengesApiData;
import com.soletreadmills.sole_v2._data.api.club.GetMyOnGoingChallengesWithMemberApiData;
import com.soletreadmills.sole_v2._data.api.club.GetPublicChallengesToJoinApiData;
import com.soletreadmills.sole_v2._data.api.club.JoinChallengeApiData;
import com.soletreadmills.sole_v2._data.api.club.LeaderQuitMemberFromChallengeApiData;
import com.soletreadmills.sole_v2._data.api.club.QuitChallengeApiData;
import com.soletreadmills.sole_v2._data.api.club.StartRace4VirtualRaceApiData;
import com.soletreadmills.sole_v2._data.api.club.UpdateChallengeApiData;
import com.soletreadmills.sole_v2._data.api.club.UpdateChallengeCoverPhotoApiData;
import com.soletreadmills.sole_v2._data.api.club.UploadWorkoutApiData;
import com.soletreadmills.sole_v2._data.api.forgotPassword.ForgetPasswordApiData;
import com.soletreadmills.sole_v2._data.api.goal.CreateUserGoalApiData;
import com.soletreadmills.sole_v2._data.api.goal.DeleteUserGoalApiData;
import com.soletreadmills.sole_v2._data.api.goal.GetMyUserGoalListApiData;
import com.soletreadmills.sole_v2._data.api.goal.GetVideoRecommendationsApiData;
import com.soletreadmills.sole_v2._data.api.goal.UpdateUserGoalApiData;
import com.soletreadmills.sole_v2._data.api.history.DeleteWorkoutApiData;
import com.soletreadmills.sole_v2._data.api.history.GetMyUsedActivityTypesApiData;
import com.soletreadmills.sole_v2._data.api.history.GetMyWorkoutStatisticsApiData;
import com.soletreadmills.sole_v2._data.api.history.GetUserMonthlyStatisticsApiData;
import com.soletreadmills.sole_v2._data.api.history.GetUserWorkoutContentApiData;
import com.soletreadmills.sole_v2._data.api.history.GetWorkoutSrchOptionsApiData;
import com.soletreadmills.sole_v2._data.api.history.StravaGetAccessTokenApiData;
import com.soletreadmills.sole_v2._data.api.history.StravaShareHistoryApiData;
import com.soletreadmills.sole_v2._data.api.home.GetMyConnectedMachineListApiData;
import com.soletreadmills.sole_v2._data.api.login.GetMyUserInfoApiData;
import com.soletreadmills.sole_v2._data.api.login.LoginByEmailApiData;
import com.soletreadmills.sole_v2._data.api.login.LoginByFacebookApiData;
import com.soletreadmills.sole_v2._data.api.login.LoginByGoogleApiData;
import com.soletreadmills.sole_v2._data.api.login.LoginByTokenApiData;
import com.soletreadmills.sole_v2._data.api.login.LogoutApiData;
import com.soletreadmills.sole_v2._data.api.login.UserScanMachineQRCodeToPair;
import com.soletreadmills.sole_v2._data.api.settings.DeleteAccountApiData;
import com.soletreadmills.sole_v2._data.api.settings.GarminStartUserAuthApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetConnectedExternalServiceApiData;
import com.soletreadmills.sole_v2._data.api.settings.SetCoverPhotoApiData;
import com.soletreadmills.sole_v2._data.api.settings.UpdateMeasurementUnitApiData;
import com.soletreadmills.sole_v2._data.api.settings.UpdateMyUserInfoApiData;
import com.soletreadmills.sole_v2._data.api.settings.UpdatePreferenceApiData;
import com.soletreadmills.sole_v2._data.api.signUp.ConfirmSignUpApiData;
import com.soletreadmills.sole_v2._data.api.signUp.RegisterMemberApiData;
import com.soletreadmills.sole_v2._data.api.signUp.ResendConfirmSignUpCodeApiData;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.sun.jna.Callback;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: DyacoApi.kt */
@Metadata(d1 = {"\u0000\u0098\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\u0006\u0010\u0003\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000e\u001a\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00012\u0006\u0010\f\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012\u001a\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00012\u0006\u0010\f\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00012\u0006\u0010\f\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00012\u0006\u0010\f\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!\u001a\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00012\u0006\u0010\u0003\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%\u001a\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00012\u0006\u0010\f\u001a\u00020(H\u0086@¢\u0006\u0002\u0010)\u001a\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00012\u0006\u0010\u0003\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-\u001a\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0014\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u001c\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00012\u0006\u0010\f\u001a\u000206H\u0086@¢\u0006\u0002\u00107\u001a\u001c\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00012\u0006\u0010\f\u001a\u00020:H\u0086@¢\u0006\u0002\u0010;\u001a\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00012\u0006\u0010\f\u001a\u00020>H\u0086@¢\u0006\u0002\u0010?\u001a\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00012\u0006\u0010\u0003\u001a\u00020DH\u0086@¢\u0006\u0002\u0010E\u001a\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00012\u0006\u0010\f\u001a\u00020HH\u0086@¢\u0006\u0002\u0010I\u001a\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u00012\u0006\u0010\f\u001a\u00020NH\u0086@¢\u0006\u0002\u0010O\u001a\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u00012\u0006\u0010R\u001a\u00020SH\u0086@¢\u0006\u0002\u0010T\u001a\u0014\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020X0\u00012\u0006\u0010\f\u001a\u00020YH\u0086@¢\u0006\u0002\u0010Z\u001a\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0\u00012\u0006\u0010\f\u001a\u00020]H\u0086@¢\u0006\u0002\u0010^\u001a\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020`0\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020b0\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0014\u0010c\u001a\b\u0012\u0004\u0012\u00020d0\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0014\u0010e\u001a\b\u0012\u0004\u0012\u00020f0\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0014\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010i\u001a\b\u0012\u0004\u0012\u00020j0\u00012\u0006\u0010\f\u001a\u00020kH\u0086@¢\u0006\u0002\u0010l\u001a\u001c\u0010m\u001a\b\u0012\u0004\u0012\u00020n0\u00012\u0006\u0010\u0003\u001a\u00020oH\u0086@¢\u0006\u0002\u0010p\u001a\u001c\u0010q\u001a\b\u0012\u0004\u0012\u00020r0\u00012\u0006\u0010\u0003\u001a\u00020sH\u0086@¢\u0006\u0002\u0010t\u001a\u001c\u0010u\u001a\b\u0012\u0004\u0012\u00020v0\u00012\u0006\u0010\u0003\u001a\u00020wH\u0086@¢\u0006\u0002\u0010x\u001a\u0014\u0010y\u001a\b\u0012\u0004\u0012\u00020z0\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0014\u0010{\u001a\b\u0012\u0004\u0012\u00020|0\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u001d\u0010}\u001a\b\u0012\u0004\u0012\u00020~0\u00012\u0006\u0010\u0003\u001a\u00020\u007fH\u0086@¢\u0006\u0003\u0010\u0080\u0001\u001a \u0010\u0081\u0001\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010\u00012\u0007\u0010\f\u001a\u00030\u0083\u0001H\u0086@¢\u0006\u0003\u0010\u0084\u0001\u001a \u0010\u0085\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010\u00012\u0007\u0010\f\u001a\u00030\u0087\u0001H\u0086@¢\u0006\u0003\u0010\u0088\u0001\u001a \u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010\u00012\u0007\u0010\u0003\u001a\u00030\u008b\u0001H\u0086@¢\u0006\u0003\u0010\u008c\u0001\u001a \u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010\u00012\u0007\u0010\u0003\u001a\u00030\u008f\u0001H\u0086@¢\u0006\u0003\u0010\u0090\u0001\u001a \u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u0092\u00010\u00012\u0007\u0010\u0003\u001a\u00030\u0093\u0001H\u0086@¢\u0006\u0003\u0010\u0094\u0001\u001a \u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u00012\u0007\u0010\u0003\u001a\u00030\u0097\u0001H\u0086@¢\u0006\u0003\u0010\u0098\u0001\u001a\u0016\u0010\u0099\u0001\u001a\t\u0012\u0005\u0012\u00030\u009a\u00010\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a \u0010\u009b\u0001\u001a\t\u0012\u0005\u0012\u00030\u009c\u00010\u00012\u0007\u0010\f\u001a\u00030\u009d\u0001H\u0086@¢\u0006\u0003\u0010\u009e\u0001\u001a \u0010\u009f\u0001\u001a\t\u0012\u0005\u0012\u00030 \u00010\u00012\u0007\u0010\f\u001a\u00030¡\u0001H\u0086@¢\u0006\u0003\u0010¢\u0001\u001a \u0010£\u0001\u001a\t\u0012\u0005\u0012\u00030¤\u00010\u00012\u0007\u0010\u0003\u001a\u00030¥\u0001H\u0086@¢\u0006\u0003\u0010¦\u0001\u001a \u0010§\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010\u00012\u0007\u0010\u0003\u001a\u00030©\u0001H\u0086@¢\u0006\u0003\u0010ª\u0001\u001a \u0010«\u0001\u001a\t\u0012\u0005\u0012\u00030¬\u00010\u00012\u0007\u0010R\u001a\u00030\u00ad\u0001H\u0086@¢\u0006\u0003\u0010®\u0001\u001a \u0010¯\u0001\u001a\t\u0012\u0005\u0012\u00030°\u00010\u00012\u0007\u0010\f\u001a\u00030±\u0001H\u0086@¢\u0006\u0003\u0010²\u0001\u001a\u0016\u0010³\u0001\u001a\t\u0012\u0005\u0012\u00030´\u00010\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020/0\u0001H\u0086@¢\u0006\u0002\u0010\u0015\u001a \u0010¶\u0001\u001a\t\u0012\u0005\u0012\u00030·\u00010\u00012\u0007\u0010\f\u001a\u00030¸\u0001H\u0086@¢\u0006\u0003\u0010¹\u0001\u001a+\u0010º\u0001\u001a\t\u0012\u0005\u0012\u00030»\u00010\u00012\b\u0010¼\u0001\u001a\u00030½\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0086@¢\u0006\u0003\u0010À\u0001\u001a \u0010Á\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010\u00012\u0007\u0010\u0003\u001a\u00030Ã\u0001H\u0086@¢\u0006\u0003\u0010Ä\u0001\u001a \u0010Å\u0001\u001a\t\u0012\u0005\u0012\u00030Æ\u00010\u00012\u0007\u0010\u0003\u001a\u00030Ç\u0001H\u0086@¢\u0006\u0003\u0010È\u0001\u001a \u0010É\u0001\u001a\t\u0012\u0005\u0012\u00030Ê\u00010\u00012\u0007\u0010\u0003\u001a\u00030Ë\u0001H\u0086@¢\u0006\u0003\u0010Ì\u0001\u001a \u0010Í\u0001\u001a\t\u0012\u0005\u0012\u00030Î\u00010\u00012\u0007\u0010\f\u001a\u00030Ï\u0001H\u0086@¢\u0006\u0003\u0010Ð\u0001\u001a \u0010Ñ\u0001\u001a\t\u0012\u0005\u0012\u00030Ò\u00010\u00012\u0007\u0010\u0003\u001a\u00030Ó\u0001H\u0086@¢\u0006\u0003\u0010Ô\u0001\u001a\n\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0002\u001a\n\u0010×\u0001\u001a\u00030¿\u0001H\u0002\u001a+\u0010Ø\u0001\u001a\n\u0012\u0005\u0012\u00030Ú\u00010Ù\u00012\u0007\u0010\f\u001a\u00030Û\u00012\u0011\u0010Ü\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Ú\u00010Ý\u0001¨\u0006Þ\u0001"}, d2 = {"callCheckAppUpdate", "Lretrofit2/Response;", "Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$ResponseData;", "obj", "Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$Request;", "(Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callConfirmSignUp", "Lcom/soletreadmills/sole_v2/_data/api/signUp/ConfirmSignUpApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/signUp/ConfirmSignUpApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/signUp/ConfirmSignUpApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callCreateChallenge", "Lcom/soletreadmills/sole_v2/_data/api/club/CreateChallengeApiData$ResponseData;", "requestBodyData", "Lcom/soletreadmills/sole_v2/_data/api/club/CreateChallengeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/CreateChallengeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callCreateUserGoal", "Lcom/soletreadmills/sole_v2/_data/api/goal/CreateUserGoalApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/goal/CreateUserGoalApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/goal/CreateUserGoalApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callDeleteAccount", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteAccountApiData$ResponseData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callDeleteChallenge", "Lcom/soletreadmills/sole_v2/_data/api/club/DeleteChallengeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/DeleteChallengeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/DeleteChallengeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callDeleteChallengeCoverPhoto", "Lcom/soletreadmills/sole_v2/_data/api/club/DeleteChallengeCoverPhotoApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/DeleteChallengeCoverPhotoApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/DeleteChallengeCoverPhotoApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callDeleteUserGoal", "Lcom/soletreadmills/sole_v2/_data/api/goal/DeleteUserGoalApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/goal/DeleteUserGoalApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/goal/DeleteUserGoalApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callDeleteWorkoutApiData", "Lcom/soletreadmills/sole_v2/_data/api/history/DeleteWorkoutApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/history/DeleteWorkoutApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/history/DeleteWorkoutApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callExportToStrava", "Lcom/soletreadmills/sole_v2/_data/api/history/StravaShareHistoryApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/history/StravaShareHistoryApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/history/StravaShareHistoryApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callForgetPassword", "Lcom/soletreadmills/sole_v2/_data/api/forgotPassword/ForgetPasswordApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/forgotPassword/ForgetPasswordApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/forgotPassword/ForgetPasswordApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGarminRevokeUserAuth", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "callGarminStartUserAuth", "Lcom/soletreadmills/sole_v2/_data/api/settings/GarminStartUserAuthApiData$ResponseData;", "callGetAllPersonalBestDefinitionApiData", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetAllPersonalBestDefinitionApiData$ResponseData;", "callGetChallengeDetail", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeDetailApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeDetailApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeDetailApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetChallengeMemberWorkoutList", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeMemberWorkoutListApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeMemberWorkoutListApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeMemberWorkoutListApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetChallengesCreatedByMe", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetConnectedExternalService", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetConnectedExternalServiceApiData$ResponseData;", "callGetLoginServerAddress", "Lcom/soletreadmills/sole_v2/_data/api/_global/GetLoginServerAddressApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/_global/GetLoginServerAddressApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/_global/GetLoginServerAddressApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetMyComingChallenges", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyComingChallengesApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyComingChallengesApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetMyComingChallengesApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetMyConnectedMachineList", "Lcom/soletreadmills/sole_v2/_data/api/home/GetMyConnectedMachineListApiData$ResponseData;", "callGetMyFinishedChallenges", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyFinishedChallengesApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyFinishedChallengesApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetMyFinishedChallengesApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetMyLatest3MonthWorkoutStatsApiData", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest3MonthWorkoutStatsApiData$ResponseData;", "requestBody", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest3MonthWorkoutStatsApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest3MonthWorkoutStatsApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetMyLatest6WeeklyActiveTimeApiData", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest6WeeklyActiveTimeApiData$ResponseData;", "callGetMyOnGoingChallenges", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetMyOnGoingChallengesWithMember", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetMyPersonalBestListApiData", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyPersonalBestListApiData$ResponseData;", "callGetMyUsedActivityTypes", "Lcom/soletreadmills/sole_v2/_data/api/history/GetMyUsedActivityTypesApiData$ResponseData;", "callGetMyUserGoalList", "Lcom/soletreadmills/sole_v2/_data/api/goal/GetMyUserGoalListApiData$ResponseData;", "callGetMyUserInfo", "Lcom/soletreadmills/sole_v2/_data/api/login/GetMyUserInfoApiData$ResponseData;", "callGetMyWorkoutStatistics", "Lcom/soletreadmills/sole_v2/_data/api/history/GetMyWorkoutStatisticsApiData$ResponseData;", "callGetPublicChallengesToJoin", "Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetRegisterServerAddress", "Lcom/soletreadmills/sole_v2/_data/api/_global/GetRegisterServerAddressApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/_global/GetRegisterServerAddressApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/_global/GetRegisterServerAddressApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetUserMonthlyStatisticsApiData", "Lcom/soletreadmills/sole_v2/_data/api/history/GetUserMonthlyStatisticsApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/history/GetUserMonthlyStatisticsApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/history/GetUserMonthlyStatisticsApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetUserWorkoutContentApiData", "Lcom/soletreadmills/sole_v2/_data/api/history/GetUserWorkoutContentApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/history/GetUserWorkoutContentApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/history/GetUserWorkoutContentApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callGetVideoRecommendations", "Lcom/soletreadmills/sole_v2/_data/api/goal/GetVideoRecommendationsApiData$ResponseData;", "callGetWorkoutSrchOptionsApiData", "Lcom/soletreadmills/sole_v2/_data/api/history/GetWorkoutSrchOptionsApiData$ResponseData;", "callIsUserExists", "Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callJoinChallenge", "Lcom/soletreadmills/sole_v2/_data/api/club/JoinChallengeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/JoinChallengeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/JoinChallengeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callLeaderQuitMemberFromChallenge", "Lcom/soletreadmills/sole_v2/_data/api/club/LeaderQuitMemberFromChallengeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/LeaderQuitMemberFromChallengeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/LeaderQuitMemberFromChallengeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callLoginByEmail", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callLoginByFacebook", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByFacebookApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByFacebookApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/login/LoginByFacebookApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callLoginByGoogle", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByGoogleApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByGoogleApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/login/LoginByGoogleApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callLoginByToken", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByTokenApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByTokenApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/login/LoginByTokenApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callLogout", "Lcom/soletreadmills/sole_v2/_data/api/login/LogoutApiData$ResponseData;", "callLogoutMachineFromApp", "Lcom/soletreadmills/sole_v2/_data/api/LogoutMachineFromAppApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/LogoutMachineFromAppApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/LogoutMachineFromAppApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callQuitChallenge", "Lcom/soletreadmills/sole_v2/_data/api/club/QuitChallengeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/QuitChallengeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/QuitChallengeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callRegisterMembership", "Lcom/soletreadmills/sole_v2/_data/api/signUp/RegisterMemberApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/signUp/RegisterMemberApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/signUp/RegisterMemberApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callResendConfirmSignUpCode", "Lcom/soletreadmills/sole_v2/_data/api/signUp/ResendConfirmSignUpCodeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/signUp/ResendConfirmSignUpCodeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/signUp/ResendConfirmSignUpCodeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callSetCoverPhoto", "Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callStartRace4VirtualRace", "Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callStravaGetAccessToken", "Lcom/soletreadmills/sole_v2/_data/api/history/StravaGetAccessTokenApiData$ResponseData;", "callStravaOAuthRevoke", "callUpdateChallenge", "Lcom/soletreadmills/sole_v2/_data/api/club/UpdateChallengeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/UpdateChallengeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/UpdateChallengeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callUpdateChallengeCoverPhoto", "Lcom/soletreadmills/sole_v2/_data/api/club/UpdateChallengeCoverPhotoApiData$ResponseData;", "filePart", "Lokhttp3/MultipartBody$Part;", "challengeUuid", "", "(Lokhttp3/MultipartBody$Part;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callUpdateMeasurementUnit", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateMeasurementUnitApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateMeasurementUnitApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateMeasurementUnitApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callUpdateMyUserInfo", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateMyUserInfoApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateMyUserInfoApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateMyUserInfoApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callUpdatePreference", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdatePreferenceApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdatePreferenceApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/UpdatePreferenceApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callUpdateUserGoal", "Lcom/soletreadmills/sole_v2/_data/api/goal/UpdateUserGoalApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/goal/UpdateUserGoalApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/goal/UpdateUserGoalApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callUserScanMachineQRCodeToPair", "Lcom/soletreadmills/sole_v2/_data/api/login/UserScanMachineQRCodeToPair$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/login/UserScanMachineQRCodeToPair$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/login/UserScanMachineQRCodeToPair$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getApiServer2", "", "getBaseUrlFromStore", "uploadWorkout", "Lretrofit2/Call;", "Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$RequestBodyData;", Callback.METHOD_NAME, "Lretrofit2/Callback;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DyacoApiKt {
    public static final Object callIsUserExists(IsUserExistsApiData.RequestBodyData requestBodyData, Continuation<? super Response<IsUserExistsApiData.ResponseData>> continuation) {
        Timber.INSTANCE.d("call callIsUserExists", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService().isUserExists(requestBodyData, continuation);
    }

    public static final Object callGetLoginServerAddress(GetLoginServerAddressApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetLoginServerAddressApiData.ResponseData>> continuation) {
        Timber.INSTANCE.d("call callGetLoginServerAddress", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService().getLoginServerAddress(requestBodyData, continuation);
    }

    public static final Object callGetRegisterServerAddress(GetRegisterServerAddressApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetRegisterServerAddressApiData.ResponseData>> continuation) {
        Timber.INSTANCE.d("call callGetRegisterServerAddress", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService().getRegisterServerAddress(requestBodyData, continuation);
    }

    public static final Object callCheckAppUpdate(CheckAppUpdateApi.Request request, Continuation<? super Response<CheckAppUpdateApi.ResponseData>> continuation) {
        Timber.INSTANCE.d("call callCheckAppUpdate", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService().checkAppUpdate(request, continuation);
    }

    public static final Object callLoginByEmail(LoginByEmailApiData.RequestBodyData requestBodyData, Continuation<? super Response<LoginByEmailApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callLoginByEmail", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().loginByEmail(requestBodyData, continuation);
    }

    public static final Object callLoginByFacebook(LoginByFacebookApiData.RequestBodyData requestBodyData, Continuation<? super Response<LoginByFacebookApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callLoginByFacebook", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().loginByFacebook(requestBodyData, continuation);
    }

    public static final Object callLoginByGoogle(LoginByGoogleApiData.RequestBodyData requestBodyData, Continuation<? super Response<LoginByGoogleApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callLoginByGoogle", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().loginByGoogle(requestBodyData, continuation);
    }

    public static final Object callLoginByToken(LoginByTokenApiData.RequestBodyData requestBodyData, Continuation<? super Response<LoginByTokenApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callLoginByEmail", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().loginByToken(requestBodyData, continuation);
    }

    public static final Object callLogout(Continuation<? super Response<LogoutApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callLogout", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().logout(continuation);
    }

    public static final Object callRegisterMembership(RegisterMemberApiData.RequestBodyData requestBodyData, Continuation<? super Response<RegisterMemberApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callRegisterMembership", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().registerMember(requestBodyData, continuation);
    }

    public static final Object callConfirmSignUp(ConfirmSignUpApiData.RequestBodyData requestBodyData, Continuation<? super Response<ConfirmSignUpApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callConfirmSignUp", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().confirmSignUp(requestBodyData, continuation);
    }

    public static final Object callResendConfirmSignUpCode(ResendConfirmSignUpCodeApiData.RequestBodyData requestBodyData, Continuation<? super Response<ResendConfirmSignUpCodeApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callResendConfirmSignUpCode", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().resendConfirmSignUpCode(requestBodyData, continuation);
    }

    public static final Object callForgetPassword(ForgetPasswordApiData.RequestBodyData requestBodyData, Continuation<? super Response<ForgetPasswordApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callForgetPassword", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().forgetPassword(requestBodyData, continuation);
    }

    public static final Object callUpdateMeasurementUnit(UpdateMeasurementUnitApiData.RequestBodyData requestBodyData, Continuation<? super Response<UpdateMeasurementUnitApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callUpdateMeasurementUnit", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().updateMeasurementUnit(requestBodyData, continuation);
    }

    public static final Object callUpdateMyUserInfo(UpdateMyUserInfoApiData.RequestBodyData requestBodyData, Continuation<? super Response<UpdateMyUserInfoApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callUpdateMyUserInfo", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().updateMyUserInfo(requestBodyData, continuation);
    }

    public static final Object callGetMyUserInfo(Continuation<? super Response<GetMyUserInfoApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetMyUserInfo", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().getMyUserInfo(continuation);
    }

    public static final Object callDeleteAccount(Continuation<? super Response<DeleteAccountApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetMyUserInfo", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().deleteAccount(continuation);
    }

    public static final Object callUpdatePreference(UpdatePreferenceApiData.RequestBodyData requestBodyData, Continuation<? super Response<UpdatePreferenceApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callUpdatePreference", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().updatePreference(requestBodyData, continuation);
    }

    public static final Object callUserScanMachineQRCodeToPair(UserScanMachineQRCodeToPair.RequestBodyData requestBodyData, Continuation<? super Response<UserScanMachineQRCodeToPair.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callUserScanMachineQRCodeToPair", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().userScanMachineQRCodeToPair(requestBodyData, continuation);
    }

    public static final Object callGetMyWorkoutStatistics(Continuation<? super Response<GetMyWorkoutStatisticsApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetMyWorkoutStatistics", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().getMyWorkoutStatistics(continuation);
    }

    public static final Object callGetWorkoutSrchOptionsApiData(Continuation<? super Response<GetWorkoutSrchOptionsApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetWorkoutSrchOptionsApiData", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().getWorkoutSrchOptionsApiData(continuation);
    }

    public static final Object callGetMyLatest3MonthWorkoutStatsApiData(GetMyLatest3MonthWorkoutStatsApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetMyLatest3MonthWorkoutStatsApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetMyLatest3MonthWorkoutStatsApiData", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().getMyLatest3MonthWorkoutStatsApiData(requestBodyData, continuation);
    }

    public static final Object callGetMyLatest6WeeklyActiveTimeApiData(Continuation<? super Response<GetMyLatest6WeeklyActiveTimeApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetMyLatest6WeeklyActiveTimeApiData", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().getMyLatest6WeeklyActiveTimeApiData(continuation);
    }

    public static final Object callGetAllPersonalBestDefinitionApiData(Continuation<? super Response<GetAllPersonalBestDefinitionApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetAllPersonalBestDefinitionApiData", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().getAllPersonalBestDefinitionApiData(continuation);
    }

    public static final Object callGetMyPersonalBestListApiData(Continuation<? super Response<GetMyPersonalBestListApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetMyPersonalBestListApiData", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().getMyPersonalBestListApiData(continuation);
    }

    public static final Object callGetUserMonthlyStatisticsApiData(GetUserMonthlyStatisticsApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetUserMonthlyStatisticsApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetUserMonthlyStatisticsApiData", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().getUserMonthlyStatisticsApiData(requestBodyData, continuation);
    }

    public static final Object callDeleteWorkoutApiData(DeleteWorkoutApiData.RequestBodyData requestBodyData, Continuation<? super Response<DeleteWorkoutApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callDeleteWorkoutApiData", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().deleteWorkoutApiData(requestBodyData, continuation);
    }

    public static final Object callGetUserWorkoutContentApiData(GetUserWorkoutContentApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetUserWorkoutContentApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetUserWorkoutContentApiData", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().getUserWorkoutContentApiData(requestBodyData, continuation);
    }

    public static final Object callSetCoverPhoto(SetCoverPhotoApiData.RequestBodyData requestBodyData, Continuation<? super Response<SetCoverPhotoApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callSetCoverPhoto", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().setCoverPhoto(MultipartBody.Part.INSTANCE.createFormData("file", requestBodyData.getFile().getName(), RequestBody.INSTANCE.create(requestBodyData.getFile(), MediaType.INSTANCE.parse("image/jpeg"))), requestBodyData.getAvatarId(), continuation);
    }

    public static final Object callGetMyUsedActivityTypes(Continuation<? super Response<GetMyUsedActivityTypesApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetMyUsedActivityTypes", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().getMyUsedActivityTypes(continuation);
    }

    public static final Object callGetConnectedExternalService(Continuation<? super Response<GetConnectedExternalServiceApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetConnectedExternalService", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().getConnectedExternalService(continuation);
    }

    public static final Object callGarminStartUserAuth(Continuation<? super Response<GarminStartUserAuthApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGarminStartUserAuth", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().garminStartUserAuth(continuation);
    }

    public static final Object callGarminRevokeUserAuth(Continuation<? super Response<WebApiBaseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGarminRevokeUserAuth", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().garminRevokeUserAuth(continuation);
    }

    public static final Object callGetVideoRecommendations(Continuation<? super Response<GetVideoRecommendationsApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetVideoRecommendations", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().getVideoRecommendations(continuation);
    }

    public static final Object callGetMyUserGoalList(Continuation<? super Response<GetMyUserGoalListApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callGetMyUserGoalList", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().getMyUserGoalList(continuation);
    }

    public static final Object callCreateUserGoal(CreateUserGoalApiData.RequestBodyData requestBodyData, Continuation<? super Response<CreateUserGoalApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callCreateUserGoal", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().createUserGoal(requestBodyData, continuation);
    }

    public static final Object callUpdateUserGoal(UpdateUserGoalApiData.RequestBodyData requestBodyData, Continuation<? super Response<UpdateUserGoalApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callUpdateUserGoal", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().updateUserGoal(requestBodyData, continuation);
    }

    public static final Object callDeleteUserGoal(DeleteUserGoalApiData.RequestBodyData requestBodyData, Continuation<? super Response<DeleteUserGoalApiData.ResponseData>> continuation) {
        getApiServer2();
        Timber.INSTANCE.d("call callDeleteUserGoal", new Object[0]);
        return MainRetrofit.INSTANCE.getApiService2().deleteUserGoal(requestBodyData, continuation);
    }

    public static final Object callGetMyOnGoingChallengesWithMember(GetMyOnGoingChallengesWithMemberApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetMyOnGoingChallengesWithMemberApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().getMyOnGoingChallengesWithMemberData(requestBodyData, continuation);
    }

    public static final Object callUpdateChallengeCoverPhoto(MultipartBody.Part part, String str, Continuation<? super Response<UpdateChallengeCoverPhotoApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().updateChallengeCoverPhoto(part, RequestBody.INSTANCE.create(str, MediaType.INSTANCE.parse("text/plain")), continuation);
    }

    public static final Object callCreateChallenge(CreateChallengeApiData.RequestBodyData requestBodyData, Continuation<? super Response<CreateChallengeApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().createChallenge(requestBodyData, continuation);
    }

    public static final Object callGetChallengeDetail(GetChallengeDetailApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetChallengeDetailApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().getChallengeDetail(requestBodyData, continuation);
    }

    public static final Object callJoinChallenge(JoinChallengeApiData.RequestBodyData requestBodyData, Continuation<? super Response<JoinChallengeApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().joinChallenge(requestBodyData, continuation);
    }

    public static final Object callUpdateChallenge(UpdateChallengeApiData.RequestBodyData requestBodyData, Continuation<? super Response<UpdateChallengeApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().updateChallenge(requestBodyData, continuation);
    }

    public static final Object callLeaderQuitMemberFromChallenge(LeaderQuitMemberFromChallengeApiData.RequestBodyData requestBodyData, Continuation<? super Response<LeaderQuitMemberFromChallengeApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().leaderQuitMemberFromChallenge(requestBodyData, continuation);
    }

    public static final Object callQuitChallenge(QuitChallengeApiData.RequestBodyData requestBodyData, Continuation<? super Response<QuitChallengeApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().quitChallenge(requestBodyData, continuation);
    }

    public static final Object callDeleteChallenge(DeleteChallengeApiData.RequestBodyData requestBodyData, Continuation<? super Response<DeleteChallengeApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().deleteChallenge(requestBodyData, continuation);
    }

    public static final Object callDeleteChallengeCoverPhoto(DeleteChallengeCoverPhotoApiData.RequestBodyData requestBodyData, Continuation<? super Response<DeleteChallengeCoverPhotoApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().deleteChallengeCoverPhoto(requestBodyData, continuation);
    }

    public static final Object callGetPublicChallengesToJoin(GetPublicChallengesToJoinApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetPublicChallengesToJoinApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().getPublicChallengesToJoin(requestBodyData, continuation);
    }

    public static final Object callGetMyComingChallenges(GetMyComingChallengesApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetMyComingChallengesApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().getMyComingChallenges(requestBodyData, continuation);
    }

    public static final Object callGetMyOnGoingChallenges(GetMyOnGoingChallengesApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetMyOnGoingChallengesApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().getMyOnGoingChallenges(requestBodyData, continuation);
    }

    public static final Object callGetMyFinishedChallenges(GetMyFinishedChallengesApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetMyFinishedChallengesApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().getMyFinishedChallenges(requestBodyData, continuation);
    }

    public static final Object callGetChallengesCreatedByMe(GetChallengesCreatedByMeApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetChallengesCreatedByMeApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().getChallengesCreatedByMe(requestBodyData, continuation);
    }

    public static final Object callGetChallengeMemberWorkoutList(GetChallengeMemberWorkoutListApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetChallengeMemberWorkoutListApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().getChallengeMemberWorkoutList(requestBodyData, continuation);
    }

    public static final Object callStartRace4VirtualRace(StartRace4VirtualRaceApiData.RequestBodyData requestBodyData, Continuation<? super Response<StartRace4VirtualRaceApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().startRace4VirtualRace(requestBodyData, continuation);
    }

    public static final Call<UploadWorkoutApiData.ResponseData> uploadWorkout(UploadWorkoutApiData.RequestBodyData requestBodyData, retrofit2.Callback<UploadWorkoutApiData.ResponseData> callback) {
        Intrinsics.checkNotNullParameter(requestBodyData, "requestBodyData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Call<UploadWorkoutApiData.ResponseData> callUploadWorkout = MainRetrofit.INSTANCE.getApiService2().uploadWorkout(requestBodyData);
        callUploadWorkout.enqueue(callback);
        return callUploadWorkout;
    }

    public static final Object callGetMyConnectedMachineList(Continuation<? super Response<GetMyConnectedMachineListApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().getMyConnectedMachineList(continuation);
    }

    public static final Object callLogoutMachineFromApp(LogoutMachineFromAppApiData.RequestBodyData requestBodyData, Continuation<? super Response<LogoutMachineFromAppApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().logoutMachineFromApp(requestBodyData, continuation);
    }

    public static final Object callStravaGetAccessToken(Continuation<? super Response<StravaGetAccessTokenApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().stravaGetAccessToken(continuation);
    }

    public static final Object callStravaOAuthRevoke(Continuation<? super Response<WebApiBaseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().stravaOAuthRevoke(continuation);
    }

    public static final Object callExportToStrava(StravaShareHistoryApiData.RequestBodyData requestBodyData, Continuation<? super Response<StravaShareHistoryApiData.ResponseData>> continuation) {
        return MainRetrofit.INSTANCE.getApiService2().exportToStrava(requestBodyData, continuation);
    }

    private static final String getBaseUrlFromStore() {
        String sharedBaseUrl = MySharedPreferences.INSTANCE.getInstance().getSharedBaseUrl();
        String string = sharedBaseUrl != null ? StringsKt.trim((CharSequence) sharedBaseUrl).toString() : null;
        if (Intrinsics.areEqual(string, "") || string == null) {
            string = AppConfig.INSTANCE.getBASE_URL_WHEN_NULL();
        }
        if (!StringsKt.endsWith$default((CharSequence) string, '/', false, 2, (Object) null)) {
            string = string + '/';
        }
        Timber.INSTANCE.d("baseUrl: " + string, new Object[0]);
        return string;
    }

    private static final void getApiServer2() {
        MainRetrofit.INSTANCE.createApiService2(getBaseUrlFromStore());
    }
}
