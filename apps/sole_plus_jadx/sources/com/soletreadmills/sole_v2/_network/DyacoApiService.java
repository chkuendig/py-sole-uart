package com.soletreadmills.sole_v2._network;

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
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/* compiled from: DyacoApiService.kt */
@Metadata(d1 = {"\u0000\u0092\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\n\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003H§@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\n\u001a\u00020\u001aH§@¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\n\u001a\u00020\u001eH§@¢\u0006\u0002\u0010\u001fJ\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\b\b\u0001\u0010\n\u001a\u00020\"H§@¢\u0006\u0002\u0010#J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00032\b\b\u0001\u0010\n\u001a\u00020&H§@¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00032\b\b\u0001\u0010\u0005\u001a\u00020*H§@¢\u0006\u0002\u0010+J\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00032\b\b\u0001\u0010\n\u001a\u00020.H§@¢\u0006\u0002\u0010/J\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0003H§@¢\u0006\u0002\u0010\u0017J\u0014\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0003H§@¢\u0006\u0002\u0010\u0017J\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0003H§@¢\u0006\u0002\u0010\u0017J\u001e\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00032\b\b\u0001\u0010\n\u001a\u000208H§@¢\u0006\u0002\u00109J\u001e\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00032\b\b\u0001\u0010\n\u001a\u00020<H§@¢\u0006\u0002\u0010=J\u001e\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u00032\b\b\u0001\u0010\n\u001a\u00020@H§@¢\u0006\u0002\u0010AJ\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u0003H§@¢\u0006\u0002\u0010\u0017J\u001e\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u00032\b\b\u0001\u0010\n\u001a\u00020FH§@¢\u0006\u0002\u0010GJ\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u00032\b\b\u0001\u0010\n\u001a\u00020JH§@¢\u0006\u0002\u0010KJ\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u0003H§@¢\u0006\u0002\u0010\u0017J\u001e\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u00032\b\b\u0001\u0010\n\u001a\u00020PH§@¢\u0006\u0002\u0010QJ\u001e\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u00032\b\b\u0001\u0010\n\u001a\u00020TH§@¢\u0006\u0002\u0010UJ\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u0003H§@¢\u0006\u0002\u0010\u0017J\u001e\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0\u00032\b\b\u0001\u0010\n\u001a\u00020ZH§@¢\u0006\u0002\u0010[J\u001e\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\u00032\b\b\u0001\u0010\n\u001a\u00020^H§@¢\u0006\u0002\u0010_J\u0014\u0010`\u001a\b\u0012\u0004\u0012\u00020a0\u0003H§@¢\u0006\u0002\u0010\u0017J\u0014\u0010b\u001a\b\u0012\u0004\u0012\u00020c0\u0003H§@¢\u0006\u0002\u0010\u0017J\u0014\u0010d\u001a\b\u0012\u0004\u0012\u00020e0\u0003H§@¢\u0006\u0002\u0010\u0017J\u0014\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u0003H§@¢\u0006\u0002\u0010\u0017J\u0014\u0010h\u001a\b\u0012\u0004\u0012\u00020i0\u0003H§@¢\u0006\u0002\u0010\u0017J\u001e\u0010j\u001a\b\u0012\u0004\u0012\u00020k0\u00032\b\b\u0001\u0010\n\u001a\u00020lH§@¢\u0006\u0002\u0010mJ\u001e\u0010n\u001a\b\u0012\u0004\u0012\u00020o0\u00032\b\b\u0001\u0010\n\u001a\u00020pH§@¢\u0006\u0002\u0010qJ\u001e\u0010r\u001a\b\u0012\u0004\u0012\u00020s0\u00032\b\b\u0001\u0010\n\u001a\u00020tH§@¢\u0006\u0002\u0010uJ\u001e\u0010v\u001a\b\u0012\u0004\u0012\u00020w0\u00032\b\b\u0001\u0010\n\u001a\u00020xH§@¢\u0006\u0002\u0010yJ\u0014\u0010z\u001a\b\u0012\u0004\u0012\u00020{0\u0003H§@¢\u0006\u0002\u0010\u0017J\u0014\u0010|\u001a\b\u0012\u0004\u0012\u00020}0\u0003H§@¢\u0006\u0002\u0010\u0017J \u0010~\u001a\b\u0012\u0004\u0012\u00020\u007f0\u00032\t\b\u0001\u0010\n\u001a\u00030\u0080\u0001H§@¢\u0006\u0003\u0010\u0081\u0001J\"\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030\u0084\u0001H§@¢\u0006\u0003\u0010\u0085\u0001J\"\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030\u0088\u0001H§@¢\u0006\u0003\u0010\u0089\u0001J\"\u0010\u008a\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030\u008c\u0001H§@¢\u0006\u0003\u0010\u008d\u0001J\"\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030\u0090\u0001H§@¢\u0006\u0003\u0010\u0091\u0001J\"\u0010\u0092\u0001\u001a\t\u0012\u0005\u0012\u00030\u0093\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030\u0094\u0001H§@¢\u0006\u0003\u0010\u0095\u0001J\"\u0010\u0096\u0001\u001a\t\u0012\u0005\u0012\u00030\u0097\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030\u0098\u0001H§@¢\u0006\u0003\u0010\u0099\u0001J\u0016\u0010\u009a\u0001\u001a\t\u0012\u0005\u0012\u00030\u009b\u00010\u0003H§@¢\u0006\u0002\u0010\u0017J\"\u0010\u009c\u0001\u001a\t\u0012\u0005\u0012\u00030\u009d\u00010\u00032\t\b\u0001\u0010\u0005\u001a\u00030\u009e\u0001H§@¢\u0006\u0003\u0010\u009f\u0001J\"\u0010 \u0001\u001a\t\u0012\u0005\u0012\u00030¡\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030¢\u0001H§@¢\u0006\u0003\u0010£\u0001J\"\u0010¤\u0001\u001a\t\u0012\u0005\u0012\u00030¥\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030¦\u0001H§@¢\u0006\u0003\u0010§\u0001J\"\u0010¨\u0001\u001a\t\u0012\u0005\u0012\u00030©\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030ª\u0001H§@¢\u0006\u0003\u0010«\u0001J3\u0010¬\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010\u00032\f\b\u0001\u0010®\u0001\u001a\u0005\u0018\u00010¯\u00012\f\b\u0001\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001H§@¢\u0006\u0003\u0010²\u0001J\"\u0010³\u0001\u001a\t\u0012\u0005\u0012\u00030´\u00010\u00032\t\b\u0001\u0010\u0005\u001a\u00030µ\u0001H§@¢\u0006\u0003\u0010¶\u0001J\u0016\u0010·\u0001\u001a\t\u0012\u0005\u0012\u00030¸\u00010\u0003H§@¢\u0006\u0002\u0010\u0017J\u0015\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u0002010\u0003H§@¢\u0006\u0002\u0010\u0017J\"\u0010º\u0001\u001a\t\u0012\u0005\u0012\u00030»\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030¼\u0001H§@¢\u0006\u0003\u0010½\u0001J/\u0010¾\u0001\u001a\t\u0012\u0005\u0012\u00030¿\u00010\u00032\n\b\u0001\u0010®\u0001\u001a\u00030¯\u00012\n\b\u0001\u0010À\u0001\u001a\u00030Á\u0001H§@¢\u0006\u0003\u0010Â\u0001J\"\u0010Ã\u0001\u001a\t\u0012\u0005\u0012\u00030Ä\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030Å\u0001H§@¢\u0006\u0003\u0010Æ\u0001J\"\u0010Ç\u0001\u001a\t\u0012\u0005\u0012\u00030È\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030É\u0001H§@¢\u0006\u0003\u0010Ê\u0001J\"\u0010Ë\u0001\u001a\t\u0012\u0005\u0012\u00030Ì\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030Í\u0001H§@¢\u0006\u0003\u0010Î\u0001J\"\u0010Ï\u0001\u001a\t\u0012\u0005\u0012\u00030Ð\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030Ñ\u0001H§@¢\u0006\u0003\u0010Ò\u0001J\u001c\u0010Ó\u0001\u001a\n\u0012\u0005\u0012\u00030Õ\u00010Ô\u00012\t\b\u0001\u0010\u0005\u001a\u00030Ö\u0001H'J\"\u0010×\u0001\u001a\t\u0012\u0005\u0012\u00030Ø\u00010\u00032\t\b\u0001\u0010\n\u001a\u00030Ù\u0001H§@¢\u0006\u0003\u0010Ú\u0001¨\u0006Û\u0001"}, d2 = {"Lcom/soletreadmills/sole_v2/_network/DyacoApiService;", "", "checkAppUpdate", "Lretrofit2/Response;", "Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$ResponseData;", "bodyData", "Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$Request;", "(Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmSignUp", "Lcom/soletreadmills/sole_v2/_data/api/signUp/ConfirmSignUpApiData$ResponseData;", "body", "Lcom/soletreadmills/sole_v2/_data/api/signUp/ConfirmSignUpApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/signUp/ConfirmSignUpApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createChallenge", "Lcom/soletreadmills/sole_v2/_data/api/club/CreateChallengeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/CreateChallengeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/CreateChallengeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUserGoal", "Lcom/soletreadmills/sole_v2/_data/api/goal/CreateUserGoalApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/goal/CreateUserGoalApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/goal/CreateUserGoalApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAccount", "Lcom/soletreadmills/sole_v2/_data/api/settings/DeleteAccountApiData$ResponseData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteChallenge", "Lcom/soletreadmills/sole_v2/_data/api/club/DeleteChallengeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/DeleteChallengeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/DeleteChallengeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteChallengeCoverPhoto", "Lcom/soletreadmills/sole_v2/_data/api/club/DeleteChallengeCoverPhotoApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/DeleteChallengeCoverPhotoApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/DeleteChallengeCoverPhotoApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUserGoal", "Lcom/soletreadmills/sole_v2/_data/api/goal/DeleteUserGoalApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/goal/DeleteUserGoalApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/goal/DeleteUserGoalApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWorkoutApiData", "Lcom/soletreadmills/sole_v2/_data/api/history/DeleteWorkoutApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/history/DeleteWorkoutApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/history/DeleteWorkoutApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportToStrava", "Lcom/soletreadmills/sole_v2/_data/api/history/StravaShareHistoryApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/history/StravaShareHistoryApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/history/StravaShareHistoryApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forgetPassword", "Lcom/soletreadmills/sole_v2/_data/api/forgotPassword/ForgetPasswordApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/forgotPassword/ForgetPasswordApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/forgotPassword/ForgetPasswordApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "garminRevokeUserAuth", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "garminStartUserAuth", "Lcom/soletreadmills/sole_v2/_data/api/settings/GarminStartUserAuthApiData$ResponseData;", "getAllPersonalBestDefinitionApiData", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetAllPersonalBestDefinitionApiData$ResponseData;", "getChallengeDetail", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeDetailApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeDetailApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeDetailApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChallengeMemberWorkoutList", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeMemberWorkoutListApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeMemberWorkoutListApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeMemberWorkoutListApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChallengesCreatedByMe", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConnectedExternalService", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetConnectedExternalServiceApiData$ResponseData;", "getLoginServerAddress", "Lcom/soletreadmills/sole_v2/_data/api/_global/GetLoginServerAddressApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/_global/GetLoginServerAddressApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/_global/GetLoginServerAddressApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyComingChallenges", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyComingChallengesApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyComingChallengesApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetMyComingChallengesApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyConnectedMachineList", "Lcom/soletreadmills/sole_v2/_data/api/home/GetMyConnectedMachineListApiData$ResponseData;", "getMyFinishedChallenges", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyFinishedChallengesApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyFinishedChallengesApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetMyFinishedChallengesApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyLatest3MonthWorkoutStatsApiData", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest3MonthWorkoutStatsApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest3MonthWorkoutStatsApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest3MonthWorkoutStatsApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyLatest6WeeklyActiveTimeApiData", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest6WeeklyActiveTimeApiData$ResponseData;", "getMyOnGoingChallenges", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyOnGoingChallengesWithMemberData", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyPersonalBestListApiData", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyPersonalBestListApiData$ResponseData;", "getMyUsedActivityTypes", "Lcom/soletreadmills/sole_v2/_data/api/history/GetMyUsedActivityTypesApiData$ResponseData;", "getMyUserGoalList", "Lcom/soletreadmills/sole_v2/_data/api/goal/GetMyUserGoalListApiData$ResponseData;", "getMyUserInfo", "Lcom/soletreadmills/sole_v2/_data/api/login/GetMyUserInfoApiData$ResponseData;", "getMyWorkoutStatistics", "Lcom/soletreadmills/sole_v2/_data/api/history/GetMyWorkoutStatisticsApiData$ResponseData;", "getPublicChallengesToJoin", "Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRegisterServerAddress", "Lcom/soletreadmills/sole_v2/_data/api/_global/GetRegisterServerAddressApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/_global/GetRegisterServerAddressApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/_global/GetRegisterServerAddressApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserMonthlyStatisticsApiData", "Lcom/soletreadmills/sole_v2/_data/api/history/GetUserMonthlyStatisticsApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/history/GetUserMonthlyStatisticsApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/history/GetUserMonthlyStatisticsApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserWorkoutContentApiData", "Lcom/soletreadmills/sole_v2/_data/api/history/GetUserWorkoutContentApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/history/GetUserWorkoutContentApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/history/GetUserWorkoutContentApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoRecommendations", "Lcom/soletreadmills/sole_v2/_data/api/goal/GetVideoRecommendationsApiData$ResponseData;", "getWorkoutSrchOptionsApiData", "Lcom/soletreadmills/sole_v2/_data/api/history/GetWorkoutSrchOptionsApiData$ResponseData;", "isUserExists", "Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinChallenge", "Lcom/soletreadmills/sole_v2/_data/api/club/JoinChallengeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/JoinChallengeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/JoinChallengeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "leaderQuitMemberFromChallenge", "Lcom/soletreadmills/sole_v2/_data/api/club/LeaderQuitMemberFromChallengeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/LeaderQuitMemberFromChallengeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/LeaderQuitMemberFromChallengeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginByEmail", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginByFacebook", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByFacebookApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByFacebookApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/login/LoginByFacebookApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginByGoogle", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByGoogleApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByGoogleApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/login/LoginByGoogleApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginByToken", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByTokenApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByTokenApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/login/LoginByTokenApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "Lcom/soletreadmills/sole_v2/_data/api/login/LogoutApiData$ResponseData;", "logoutMachineFromApp", "Lcom/soletreadmills/sole_v2/_data/api/LogoutMachineFromAppApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/LogoutMachineFromAppApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/LogoutMachineFromAppApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "quitChallenge", "Lcom/soletreadmills/sole_v2/_data/api/club/QuitChallengeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/QuitChallengeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/QuitChallengeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerMember", "Lcom/soletreadmills/sole_v2/_data/api/signUp/RegisterMemberApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/signUp/RegisterMemberApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/signUp/RegisterMemberApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resendConfirmSignUpCode", "Lcom/soletreadmills/sole_v2/_data/api/signUp/ResendConfirmSignUpCodeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/signUp/ResendConfirmSignUpCodeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/signUp/ResendConfirmSignUpCodeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCoverPhoto", "Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$ResponseData;", "file", "Lokhttp3/MultipartBody$Part;", "avatarId", "", "(Lokhttp3/MultipartBody$Part;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startRace4VirtualRace", "Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stravaGetAccessToken", "Lcom/soletreadmills/sole_v2/_data/api/history/StravaGetAccessTokenApiData$ResponseData;", "stravaOAuthRevoke", "updateChallenge", "Lcom/soletreadmills/sole_v2/_data/api/club/UpdateChallengeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/UpdateChallengeApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/UpdateChallengeApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateChallengeCoverPhoto", "Lcom/soletreadmills/sole_v2/_data/api/club/UpdateChallengeCoverPhotoApiData$ResponseData;", "challengeUuid", "Lokhttp3/RequestBody;", "(Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMeasurementUnit", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateMeasurementUnitApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateMeasurementUnitApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateMeasurementUnitApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMyUserInfo", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateMyUserInfoApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateMyUserInfoApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/UpdateMyUserInfoApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePreference", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdatePreferenceApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/settings/UpdatePreferenceApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/UpdatePreferenceApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserGoal", "Lcom/soletreadmills/sole_v2/_data/api/goal/UpdateUserGoalApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/goal/UpdateUserGoalApiData$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/goal/UpdateUserGoalApiData$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadWorkout", "Lretrofit2/Call;", "Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/club/UploadWorkoutApiData$RequestBodyData;", "userScanMachineQRCodeToPair", "Lcom/soletreadmills/sole_v2/_data/api/login/UserScanMachineQRCodeToPair$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/api/login/UserScanMachineQRCodeToPair$RequestBodyData;", "(Lcom/soletreadmills/sole_v2/_data/api/login/UserScanMachineQRCodeToPair$RequestBodyData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DyacoApiService {
    @POST("api/CheckAppUpdate")
    Object checkAppUpdate(@Body CheckAppUpdateApi.Request request, Continuation<? super Response<CheckAppUpdateApi.ResponseData>> continuation);

    @POST("api/ConfirmSignUp")
    Object confirmSignUp(@Body ConfirmSignUpApiData.RequestBodyData requestBodyData, Continuation<? super Response<ConfirmSignUpApiData.ResponseData>> continuation);

    @POST("api/CreateChallenge")
    Object createChallenge(@Body CreateChallengeApiData.RequestBodyData requestBodyData, Continuation<? super Response<CreateChallengeApiData.ResponseData>> continuation);

    @POST("api/CreateUserGoal")
    Object createUserGoal(@Body CreateUserGoalApiData.RequestBodyData requestBodyData, Continuation<? super Response<CreateUserGoalApiData.ResponseData>> continuation);

    @POST("api/DeleteAccount")
    Object deleteAccount(Continuation<? super Response<DeleteAccountApiData.ResponseData>> continuation);

    @POST("api/DeleteChallenge")
    Object deleteChallenge(@Body DeleteChallengeApiData.RequestBodyData requestBodyData, Continuation<? super Response<DeleteChallengeApiData.ResponseData>> continuation);

    @POST("api/DeleteChallengeCoverPhoto")
    Object deleteChallengeCoverPhoto(@Body DeleteChallengeCoverPhotoApiData.RequestBodyData requestBodyData, Continuation<? super Response<DeleteChallengeCoverPhotoApiData.ResponseData>> continuation);

    @POST("api/DeleteUserGoal")
    Object deleteUserGoal(@Body DeleteUserGoalApiData.RequestBodyData requestBodyData, Continuation<? super Response<DeleteUserGoalApiData.ResponseData>> continuation);

    @POST("api/DeleteWorkout")
    Object deleteWorkoutApiData(@Body DeleteWorkoutApiData.RequestBodyData requestBodyData, Continuation<? super Response<DeleteWorkoutApiData.ResponseData>> continuation);

    @POST("api/ExportToStrava")
    Object exportToStrava(@Body StravaShareHistoryApiData.RequestBodyData requestBodyData, Continuation<? super Response<StravaShareHistoryApiData.ResponseData>> continuation);

    @POST("api/ForgetPassword")
    Object forgetPassword(@Body ForgetPasswordApiData.RequestBodyData requestBodyData, Continuation<? super Response<ForgetPasswordApiData.ResponseData>> continuation);

    @POST("api/GarminRevokeUserAuth")
    Object garminRevokeUserAuth(Continuation<? super Response<WebApiBaseData>> continuation);

    @POST("api/GarminStartUserAuth")
    Object garminStartUserAuth(Continuation<? super Response<GarminStartUserAuthApiData.ResponseData>> continuation);

    @POST("api/GetAllPersonalBestDefinition")
    Object getAllPersonalBestDefinitionApiData(Continuation<? super Response<GetAllPersonalBestDefinitionApiData.ResponseData>> continuation);

    @POST("api/GetChallengeDetail")
    Object getChallengeDetail(@Body GetChallengeDetailApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetChallengeDetailApiData.ResponseData>> continuation);

    @POST("api/GetChallengeMemberWorkoutList")
    Object getChallengeMemberWorkoutList(@Body GetChallengeMemberWorkoutListApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetChallengeMemberWorkoutListApiData.ResponseData>> continuation);

    @POST("api/GetChallengesCreatedByMe")
    Object getChallengesCreatedByMe(@Body GetChallengesCreatedByMeApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetChallengesCreatedByMeApiData.ResponseData>> continuation);

    @POST("api/GetConnectedExternalService")
    Object getConnectedExternalService(Continuation<? super Response<GetConnectedExternalServiceApiData.ResponseData>> continuation);

    @POST("api/GetLoginServerAddress")
    Object getLoginServerAddress(@Body GetLoginServerAddressApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetLoginServerAddressApiData.ResponseData>> continuation);

    @POST("api/GetMyComingChallenges")
    Object getMyComingChallenges(@Body GetMyComingChallengesApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetMyComingChallengesApiData.ResponseData>> continuation);

    @POST("api/GetMyConnectedMachineList")
    Object getMyConnectedMachineList(Continuation<? super Response<GetMyConnectedMachineListApiData.ResponseData>> continuation);

    @POST("api/GetMyFinishedChallenges")
    Object getMyFinishedChallenges(@Body GetMyFinishedChallengesApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetMyFinishedChallengesApiData.ResponseData>> continuation);

    @POST("api/GetMyLatest3MonthWorkoutStatsByActivityType")
    Object getMyLatest3MonthWorkoutStatsApiData(@Body GetMyLatest3MonthWorkoutStatsApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetMyLatest3MonthWorkoutStatsApiData.ResponseData>> continuation);

    @POST("api/GetMyLatest6WeeklyActiveTime")
    Object getMyLatest6WeeklyActiveTimeApiData(Continuation<? super Response<GetMyLatest6WeeklyActiveTimeApiData.ResponseData>> continuation);

    @POST("api/GetMyOnGoingChallenges")
    Object getMyOnGoingChallenges(@Body GetMyOnGoingChallengesApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetMyOnGoingChallengesApiData.ResponseData>> continuation);

    @POST("api/GetMyOnGoingChallengesWithMemberData")
    Object getMyOnGoingChallengesWithMemberData(@Body GetMyOnGoingChallengesWithMemberApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetMyOnGoingChallengesWithMemberApiData.ResponseData>> continuation);

    @POST("api/GetMyPersonalBestList")
    Object getMyPersonalBestListApiData(Continuation<? super Response<GetMyPersonalBestListApiData.ResponseData>> continuation);

    @POST("api/GetMyUsedActivityTypes")
    Object getMyUsedActivityTypes(Continuation<? super Response<GetMyUsedActivityTypesApiData.ResponseData>> continuation);

    @POST("api/GetMyUserGoalList")
    Object getMyUserGoalList(Continuation<? super Response<GetMyUserGoalListApiData.ResponseData>> continuation);

    @POST("api/GetMyUserInfo")
    Object getMyUserInfo(Continuation<? super Response<GetMyUserInfoApiData.ResponseData>> continuation);

    @POST("api/GetMyWorkoutStatistics")
    Object getMyWorkoutStatistics(Continuation<? super Response<GetMyWorkoutStatisticsApiData.ResponseData>> continuation);

    @POST("api/GetPublicChallengesToJoin")
    Object getPublicChallengesToJoin(@Body GetPublicChallengesToJoinApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetPublicChallengesToJoinApiData.ResponseData>> continuation);

    @POST("api/GetRegisterServerAddress")
    Object getRegisterServerAddress(@Body GetRegisterServerAddressApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetRegisterServerAddressApiData.ResponseData>> continuation);

    @POST("api/GetUserMonthlyStatistics")
    Object getUserMonthlyStatisticsApiData(@Body GetUserMonthlyStatisticsApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetUserMonthlyStatisticsApiData.ResponseData>> continuation);

    @POST("api/GetUserWorkoutContent")
    Object getUserWorkoutContentApiData(@Body GetUserWorkoutContentApiData.RequestBodyData requestBodyData, Continuation<? super Response<GetUserWorkoutContentApiData.ResponseData>> continuation);

    @POST("api/GetVideoRecommendations")
    Object getVideoRecommendations(Continuation<? super Response<GetVideoRecommendationsApiData.ResponseData>> continuation);

    @POST("api/GetWorkoutSrchOptions")
    Object getWorkoutSrchOptionsApiData(Continuation<? super Response<GetWorkoutSrchOptionsApiData.ResponseData>> continuation);

    @POST("api/IsUserExists")
    Object isUserExists(@Body IsUserExistsApiData.RequestBodyData requestBodyData, Continuation<? super Response<IsUserExistsApiData.ResponseData>> continuation);

    @POST("api/JoinChallenge")
    Object joinChallenge(@Body JoinChallengeApiData.RequestBodyData requestBodyData, Continuation<? super Response<JoinChallengeApiData.ResponseData>> continuation);

    @POST("api/LeaderQuitMemberFromChallenge")
    Object leaderQuitMemberFromChallenge(@Body LeaderQuitMemberFromChallengeApiData.RequestBodyData requestBodyData, Continuation<? super Response<LeaderQuitMemberFromChallengeApiData.ResponseData>> continuation);

    @POST("api/LoginByEmail")
    Object loginByEmail(@Body LoginByEmailApiData.RequestBodyData requestBodyData, Continuation<? super Response<LoginByEmailApiData.ResponseData>> continuation);

    @POST("api/LoginByFacebook")
    Object loginByFacebook(@Body LoginByFacebookApiData.RequestBodyData requestBodyData, Continuation<? super Response<LoginByFacebookApiData.ResponseData>> continuation);

    @POST("api/LoginByGoogle")
    Object loginByGoogle(@Body LoginByGoogleApiData.RequestBodyData requestBodyData, Continuation<? super Response<LoginByGoogleApiData.ResponseData>> continuation);

    @POST("api/LoginByToken")
    Object loginByToken(@Body LoginByTokenApiData.RequestBodyData requestBodyData, Continuation<? super Response<LoginByTokenApiData.ResponseData>> continuation);

    @POST("api/Logout")
    Object logout(Continuation<? super Response<LogoutApiData.ResponseData>> continuation);

    @POST("api/LogoutMachineFromApp")
    Object logoutMachineFromApp(@Body LogoutMachineFromAppApiData.RequestBodyData requestBodyData, Continuation<? super Response<LogoutMachineFromAppApiData.ResponseData>> continuation);

    @POST("api/QuitChallenge")
    Object quitChallenge(@Body QuitChallengeApiData.RequestBodyData requestBodyData, Continuation<? super Response<QuitChallengeApiData.ResponseData>> continuation);

    @POST("api/RegisterMembership")
    Object registerMember(@Body RegisterMemberApiData.RequestBodyData requestBodyData, Continuation<? super Response<RegisterMemberApiData.ResponseData>> continuation);

    @POST("api/ResendConfirmSignUpCode")
    Object resendConfirmSignUpCode(@Body ResendConfirmSignUpCodeApiData.RequestBodyData requestBodyData, Continuation<? super Response<ResendConfirmSignUpCodeApiData.ResponseData>> continuation);

    @POST("api/SetCoverPhoto")
    @Multipart
    Object setCoverPhoto(@Part MultipartBody.Part part, @Part("avatarId") String str, Continuation<? super Response<SetCoverPhotoApiData.ResponseData>> continuation);

    @POST("api/StartRace4VirtualRace")
    Object startRace4VirtualRace(@Body StartRace4VirtualRaceApiData.RequestBodyData requestBodyData, Continuation<? super Response<StartRace4VirtualRaceApiData.ResponseData>> continuation);

    @POST("api/StravaGetAccessToken")
    Object stravaGetAccessToken(Continuation<? super Response<StravaGetAccessTokenApiData.ResponseData>> continuation);

    @POST("api/StravaOAuthRevoke")
    Object stravaOAuthRevoke(Continuation<? super Response<WebApiBaseData>> continuation);

    @POST("api/UpdateChallenge")
    Object updateChallenge(@Body UpdateChallengeApiData.RequestBodyData requestBodyData, Continuation<? super Response<UpdateChallengeApiData.ResponseData>> continuation);

    @POST("api/UpdateChallengeCoverPhoto")
    @Multipart
    Object updateChallengeCoverPhoto(@Part MultipartBody.Part part, @Part("challengeUuid") RequestBody requestBody, Continuation<? super Response<UpdateChallengeCoverPhotoApiData.ResponseData>> continuation);

    @POST("api/UpdateMeasurementUnit")
    Object updateMeasurementUnit(@Body UpdateMeasurementUnitApiData.RequestBodyData requestBodyData, Continuation<? super Response<UpdateMeasurementUnitApiData.ResponseData>> continuation);

    @POST("api/UpdateMyUserInfo")
    Object updateMyUserInfo(@Body UpdateMyUserInfoApiData.RequestBodyData requestBodyData, Continuation<? super Response<UpdateMyUserInfoApiData.ResponseData>> continuation);

    @POST("api/UpdatePreference")
    Object updatePreference(@Body UpdatePreferenceApiData.RequestBodyData requestBodyData, Continuation<? super Response<UpdatePreferenceApiData.ResponseData>> continuation);

    @POST("api/UpdateUserGoal")
    Object updateUserGoal(@Body UpdateUserGoalApiData.RequestBodyData requestBodyData, Continuation<? super Response<UpdateUserGoalApiData.ResponseData>> continuation);

    @POST("api/UploadWorkout")
    Call<UploadWorkoutApiData.ResponseData> uploadWorkout(@Body UploadWorkoutApiData.RequestBodyData bodyData);

    @POST("api/UserScanMachineQRCodeToPair")
    Object userScanMachineQRCodeToPair(@Body UserScanMachineQRCodeToPair.RequestBodyData requestBodyData, Continuation<? super Response<UserScanMachineQRCodeToPair.ResponseData>> continuation);
}
