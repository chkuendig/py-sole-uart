package com.ua.sdk;

import android.content.Context;
import com.ua.sdk.actigraphy.ActigraphyManager;
import com.ua.sdk.activitystory.ActivityStoryManager;
import com.ua.sdk.activitytimeseries.ActivityTimeSeriesManager;
import com.ua.sdk.activitytype.ActivityTypeManager;
import com.ua.sdk.aggregate.AggregateManager;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.authentication.OAuth2Credentials;
import com.ua.sdk.bodymass.BodyMassManager;
import com.ua.sdk.concurrent.EntityEventHandler;
import com.ua.sdk.concurrent.LoginRequest;
import com.ua.sdk.friendship.FriendshipManager;
import com.ua.sdk.gear.GearManager;
import com.ua.sdk.group.GroupManager;
import com.ua.sdk.group.invite.GroupInviteManager;
import com.ua.sdk.group.leaderboard.GroupLeaderboardManager;
import com.ua.sdk.group.objective.GroupObjectiveManager;
import com.ua.sdk.group.purpose.GroupPurposeManager;
import com.ua.sdk.group.user.GroupUserManager;
import com.ua.sdk.heartrate.HeartRateZonesManager;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.UaProvider;
import com.ua.sdk.internal.UaProviderImpl;
import com.ua.sdk.moderation.ModerationManager;
import com.ua.sdk.page.PageManager;
import com.ua.sdk.page.association.PageAssociationManager;
import com.ua.sdk.recorder.RecorderManager;
import com.ua.sdk.remoteconnection.RemoteConnectionManager;
import com.ua.sdk.remoteconnection.RemoteConnectionTypeManager;
import com.ua.sdk.role.RoleSuperManager;
import com.ua.sdk.route.RouteManager;
import com.ua.sdk.sleep.SleepManager;
import com.ua.sdk.user.CurrentUserRef;
import com.ua.sdk.user.User;
import com.ua.sdk.user.UserManager;
import com.ua.sdk.user.profilephoto.UserProfilePhotoManager;
import com.ua.sdk.workout.WorkoutManager;

/* loaded from: classes2.dex */
public class Ua {
    private final String clientId;
    private final String clientSecret;
    private final Context context;
    private final UaProvider provider;

    public interface LoginCallback {
        void onLogin(User user, UaException uaException);
    }

    public interface LogoutCallback {
        void onLogout(UaException uaException);
    }

    protected Ua(Builder builder) {
        this.context = (Context) Precondition.isNotNull(builder.context, "context");
        this.clientId = (String) Precondition.isNotNull(builder.clientId, "clientId");
        this.clientSecret = (String) Precondition.isNotNull(builder.clientSecret, "clientSecret");
        this.provider = (UaProvider) Precondition.isNotNull(builder.uaProvider, "uaProvider");
        UaLog.debug("Ua created %s", this);
    }

    public UserManager getUserManager() {
        return this.provider.getUserManager();
    }

    public UserProfilePhotoManager getUserProfilePhotoManager() {
        return this.provider.getUserProfilePhotoManager();
    }

    public ActigraphyManager getActigraphyManager() {
        return this.provider.getActigraphyManager();
    }

    public FriendshipManager getFriendshipManager() {
        return this.provider.getFriendshipManager();
    }

    public RemoteConnectionTypeManager getRemoteConnectionTypeManager() {
        return this.provider.getRemoteConnectionTypeManager();
    }

    public RouteManager getRouteManager() {
        return this.provider.getRouteManager();
    }

    public PageManager getPageManager() {
        return this.provider.getPageSuperManager();
    }

    public PageAssociationManager getPageAssociationManager() {
        return this.provider.getPageAssociationManager();
    }

    public ActivityStoryManager getActivityStoryManager() {
        return this.provider.getActivityStoryManager();
    }

    public RemoteConnectionManager getRemoteConnectionManager() {
        return this.provider.getRemoteConnectionManager();
    }

    public AuthenticationManager getAuthenticationManager() {
        return this.provider.getAuthenticationManager();
    }

    public ActivityTimeSeriesManager getActivityTimeSeriesManager() {
        return this.provider.getActivityTimeSeriesManager();
    }

    public GearManager getGearManager() {
        return this.provider.getGearManager();
    }

    public SleepManager getSleepManager() {
        return this.provider.getSleepManager();
    }

    public RoleSuperManager getRolesManager() {
        return this.provider.getRolesManager();
    }

    public ActivityTypeManager getActivityTypeManager() {
        return this.provider.getActivityTypeManager();
    }

    public WorkoutManager getWorkoutManager() {
        return this.provider.getWorkoutManager();
    }

    public ModerationManager getModerationManager() {
        return this.provider.getModerationManager();
    }

    public GroupManager getGroupManager() {
        return this.provider.getGroupManager();
    }

    public GroupInviteManager getGroupInviteManager() {
        return this.provider.getGroupInviteManager();
    }

    public GroupUserManager getGroupUserManager() {
        return this.provider.getGroupUserManager();
    }

    public RecorderManager getRecorderManager() {
        return this.provider.getRecorderManager();
    }

    public GroupObjectiveManager getGroupObjectiveManager() {
        return this.provider.getGroupObjectiveManager();
    }

    public GroupLeaderboardManager getGroupLeaderboardManager() {
        return this.provider.getGroupLeaderboardManager();
    }

    public GroupPurposeManager getGroupPurposeManager() {
        return this.provider.getGroupPurposeManager();
    }

    public AggregateManager getAggregateManager() {
        return this.provider.getAggregateManager();
    }

    public BodyMassManager getBodyMassManager() {
        return this.provider.getBodyMassManager();
    }

    public Context getContext() {
        return this.context;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientSecret() {
        return this.clientSecret;
    }

    public MetabolicEnergyCalculator getMetabolicEnergyCalculator() {
        return this.provider.getMetabolicEnergyCalculator();
    }

    public HeartRateZonesManager getHeartRateZonesManager() {
        return this.provider.getHeartRateZonesManager();
    }

    @Deprecated
    public OAuth2Credentials getOAuth2Token() {
        return this.provider.getAuthenticationManager().getOAuth2Credentials();
    }

    public void requestUserAuthorization(String str) {
        this.provider.getAuthenticationManager().requestUserAuthorization(str);
    }

    public String getUserAuthorizationUrl(String str) {
        return this.provider.getAuthenticationManager().getUserAuthorizationUrl(str);
    }

    public Request login(final String str, LoginCallback loginCallback) {
        final LoginRequest loginRequest = new LoginRequest(loginCallback);
        loginRequest.setFuture(this.provider.getExecutionService().submit(new Runnable() { // from class: com.ua.sdk.Ua.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Ua.this.provider.getAuthenticationManager().login(str);
                    loginRequest.done(Ua.this.provider.getUserManager().fetchUser(new CurrentUserRef()), null);
                } catch (UaException e) {
                    Ua.this.onLogout();
                    UaLog.error("Failed to log in with authorization code.", (Throwable) e);
                    loginRequest.done(null, e);
                }
            }
        }));
        return loginRequest;
    }

    public void logout(final LogoutCallback logoutCallback) {
        this.provider.getExecutionService().submit(new Runnable() { // from class: com.ua.sdk.Ua.2
            @Override // java.lang.Runnable
            public void run() {
                UaException uaException;
                try {
                    Ua.this.onLogout();
                    uaException = null;
                } catch (Exception e) {
                    uaException = new UaException("Error logging out.", e);
                }
                EntityEventHandler.callOnLogout(uaException, logoutCallback);
            }
        });
    }

    protected void onLogout() {
        this.provider.getAuthenticationManager().onLogout();
        this.provider.getUserManager().onLogout();
    }

    public boolean isAuthenticated() {
        return this.provider.getAuthenticationManager().isAuthenticated();
    }

    public boolean isCurrentUserId(String str) {
        EntityRef<User> currentUserRef = getUserManager().getCurrentUserRef();
        if (currentUserRef == null) {
            return false;
        }
        return currentUserRef.getId().equals(str);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String clientId;
        protected String clientSecret;
        protected Context context;
        protected boolean debug = false;
        protected UaProvider uaProvider;

        protected Builder() {
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setClientId(String str) {
            this.clientId = str;
            return this;
        }

        public Builder setClientSecret(String str) {
            this.clientSecret = str;
            return this;
        }

        public Builder setProvider(UaProvider uaProvider) {
            this.uaProvider = uaProvider;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Ua build() {
            Ua ua;
            synchronized (Ua.class) {
                if (this.uaProvider == null) {
                    this.uaProvider = new UaProviderImpl(this.clientId, this.clientSecret, this.context, this.debug);
                }
                ua = new Ua(this);
            }
            return ua;
        }
    }
}
