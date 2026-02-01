package com.soletreadmills.sole_v2.ui.club;

import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.club.LeaderQuitMemberFromChallengeApiData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.sun.jna.platform.win32.WinError;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: ClubScoreboardListFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$leaderDeleteMember$1$1", f = "ClubScoreboardListFragment.kt", i = {0}, l = {WinError.ERROR_PIPE_LOCAL}, m = "invokeSuspend", n = {"challengeId"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class ClubScoreboardListFragment$leaderDeleteMember$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $globalUserUuids;
    Object L$0;
    int label;
    final /* synthetic */ ClubScoreboardListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClubScoreboardListFragment$leaderDeleteMember$1$1(ClubScoreboardListFragment clubScoreboardListFragment, List<String> list, Continuation<? super ClubScoreboardListFragment$leaderDeleteMember$1$1> continuation) {
        super(2, continuation);
        this.this$0 = clubScoreboardListFragment;
        this.$globalUserUuids = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClubScoreboardListFragment$leaderDeleteMember$1$1(this.this$0, this.$globalUserUuids, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClubScoreboardListFragment$leaderDeleteMember$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Unit unit;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.showLoading();
                    String value = this.this$0.getClubViewModel().getSelectedChallengeId().getValue();
                    if (value == null) {
                        this.this$0.stopLoading();
                        BaseFragment.safeNavigate$default(this.this$0, R.id.clubMainFragment, null, 2, null);
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                    this.L$0 = value;
                    this.label = 1;
                    Object objCallLeaderQuitMemberFromChallenge = DyacoApiKt.callLeaderQuitMemberFromChallenge(new LeaderQuitMemberFromChallengeApiData.RequestBodyData(value, this.$globalUserUuids), this);
                    if (objCallLeaderQuitMemberFromChallenge == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = value;
                    obj = objCallLeaderQuitMemberFromChallenge;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Response response = (Response) obj;
                LeaderQuitMemberFromChallengeApiData.ResponseData responseData = (LeaderQuitMemberFromChallengeApiData.ResponseData) response.body();
                String errorCode = responseData != null ? responseData.getErrorCode() : null;
                LeaderQuitMemberFromChallengeApiData.ResponseData responseData2 = (LeaderQuitMemberFromChallengeApiData.ResponseData) response.body();
                if (responseData2 == null || !responseData2.getSuccess()) {
                    if (this.this$0.shouldIgnoreError(errorCode)) {
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                    Map mapMapOf = MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.CHALLENGE_NOT_EXIST_4000.getId(), Boxing.boxInt(R.string.challenge_pass_code_not_exist)), TuplesKt.to(ErrorCode.CHALLENGE_NOT_LEADER_4007.getId(), Boxing.boxInt(R.string.err_4007_not_challenge_leader)), TuplesKt.to(ErrorCode.CHALLENGE_NOT_ACTIVE_4001.getId(), Boxing.boxInt(R.string.err_4001_challenge_is_not_active)), TuplesKt.to(ErrorCode.CHALLENGE_LEADER_CAN_NOT_QUIT_4011.getId(), Boxing.boxInt(R.string.err_4011_challenge_leader_cant_quit)));
                    LeaderQuitMemberFromChallengeApiData.ResponseData responseData3 = (LeaderQuitMemberFromChallengeApiData.ResponseData) response.body();
                    Integer num = (Integer) mapMapOf.get(responseData3 != null ? responseData3.getErrorCode() : null);
                    if (num != null) {
                        ClubScoreboardListFragment clubScoreboardListFragment = this.this$0;
                        CustomDialogKt.showCustomDialog$default(clubScoreboardListFragment, null, clubScoreboardListFragment.getString(num.intValue()), this.this$0.getString(R.string.confirm), null, null, null, false, 112, null);
                    } else {
                        ClubScoreboardListFragment clubScoreboardListFragment2 = this.this$0;
                        LeaderQuitMemberFromChallengeApiData.ResponseData responseData4 = (LeaderQuitMemberFromChallengeApiData.ResponseData) response.body();
                        BaseFragment.handleUndefinedError$default(clubScoreboardListFragment2, "leaderDeleteMember", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                    }
                } else {
                    ClubScoreboardListFragment.getChallengeDetail$default(this.this$0, str, false, 2, null);
                }
            } catch (IOException e) {
                Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                String message = e.getMessage();
                if (message == null) {
                    message = e.getClass().getSimpleName();
                }
                BaseFragment.handleApiError$default(this.this$0, "leaderDeleteMember", message, false, 4, null);
            }
            this.this$0.stopLoading();
            return Unit.INSTANCE;
        } finally {
            this.this$0.stopLoading();
        }
    }
}
