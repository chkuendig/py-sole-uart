package com.ua.sdk.internal.net.v7;

import com.ua.sdk.EntityListRef;
import com.ua.sdk.Reference;
import com.ua.sdk.UaLog;
import com.ua.sdk.actigraphy.ActigraphyListRef;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.UrlBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

/* loaded from: classes2.dex */
public class UrlBuilderImpl implements UrlBuilder {
    public static final String BASE_HEART_RATE_ZONES = "/v7.0/heart_rate_zones/";
    public static final String BODYMASS_COLLECTION_URL = "/api/0.1/bodymass/";
    public static final String BODYMASS_URL = "/api/0.1/bodymass/%s/";
    public static final String CHANGE_FRIENDSHIP_URL = "/v7.0/friendship/%s/";
    public static final String CREATE_ACTIVITY_STORY_URL = "/v7.0/activity_story/";
    public static final String CREATE_ACTIVITY_TIME_SERIES_URL = "/api/0.1/activity_timeseries/";
    public static final String CREATE_FILEMOBILE_TOKEN_CREDENTIAL = "/api/0.1/filemobile_session/";
    public static final String CREATE_FRIENDSHIP_URL = "/v7.0/friendship/";
    public static final String CREATE_GROUP_INVITE_URL = "/v7.0/group_invite/";
    public static final String CREATE_GROUP_OBJECTIVE_URL = "/v7.0/group_objective/";
    public static final String CREATE_GROUP_USER_URL = "/v7.0/group_user/";
    public static final String CREATE_INTERNAL_TOKEN_CREDENTIAL = "/api/0.2/internal_token_credential/";
    public static final String CREATE_PAGE_ASSOCIATION_URL = "/v7.0/page_association/";
    public static final String CREATE_PAGE_FOLLOW_URL = "/v7.0/page_follow/";
    public static final String CREATE_REGISTRATION_LIST = "/api/0.1/notification_registration/";
    public static final String CREATE_ROUTE_URL = "/v7.0/route/";
    public static final String CREATE_USER_GEAR_URL = "/api/0.1/usergear/";
    public static final String CREATE_USER_ROLE_URL = "/v7.0/user_role/";
    public static final String CREATE_USER_URL = "/v7.0/user/";
    public static final String DELETE_PAGE_FOLLOW_URL = "/v7.0/page_follow/%s/";
    public static final String DELETE_REGISTRATION_LIST = "/api/0.1/subscription_registration/%s/";
    public static final String FILEMOBILE_BASE_URL = "http://api.filemobile.com";
    public static final String FILEMOBILE_UPLOAD_PATH = "/services/upload2?json";
    public static final String GET_ACTIGRAPHY_REORDER_PRIORITY_URL = "/api/0.1/actigraphy_recorder_priority/";
    public static final String GET_ACTIGRAPHY_SETTINGS_URL = "/api/0.1/actigraphy_settings/%s/";
    public static final String GET_ACTIGRAPHY_URL = "/api/0.1/actigraphy/%s";
    public static final String GET_ACTIVITY_FEED_URL = "/v7.0/activity_story/";
    public static final String GET_ACTIVITY_STORY_URL = "/v7.0/activity_story/%s/";
    public static final String GET_AGGREGATE_LIST_URL = "/v7.0/aggregate/";
    public static final String GET_CURRENT_USER_URL = "/v7.0/user/self/";
    public static final String GET_FRIENDS_URL = "/v7.0/friendship/";
    public static final String GET_GEAR_BRAND_URL = "/v7.0/gearbrand/";
    public static final String GET_GEAR_URL = "/api/0.1/gear/";
    public static final String GET_GROUPS_LIST_URL = "/v7.0/group/";
    public static final String GET_GROUP_INVITE_URL = "/v7.0/group_invite/";
    public static final String GET_GROUP_LEADERBOARD_LIST_URL = "/v7.0/group_leaderboard/";
    public static final String GET_GROUP_OBJECTIVE_LIST_URL = "/v7.0/group_objective/";
    public static final String GET_GROUP_OBJECTIVE_URL = "/v7.0/group_objective/%s/";
    public static final String GET_GROUP_PURPOSES = "/v7.0/group_purpose/";
    public static final String GET_GROUP_PURPOSE_CHALLENGE_URL = "/v7.0/group_purpose/challenge/";
    public static final String GET_GROUP_URL = "/v7.0/group/%s/";
    public static final String GET_GROUP_USER_URL = "/v7.0/group_user/";
    public static final String GET_HEART_RATE_ZONES = "/v7.0/heart_rate_zones/%s/";
    public static final String GET_MODERATION_ACTION_TYPE = "/v7.0/moderation_action_type/%s/";
    public static final String GET_OAUTH2_AUTHORIZATION_URL = "/v7.0/oauth2/uacf/authorize/?client_id=%s&response_type=code&redirect_uri=%s";
    public static final String GET_OAUTH2_TOKEN_URL = "/v7.0/oauth2/access_token/";
    public static final String GET_PAGES_URL = "/v7.0/page/";
    public static final String GET_PAGE_ASSOCIATIONS_URL = "/v7.0/page_association/";
    public static final String GET_PAGE_ASSOCIATION_URL = "/v7.0/page_association/%s/";
    public static final String GET_PAGE_FOLLOW_PAGE_URL = "/v7.0/page_follow/";
    public static final String GET_PAGE_FOLLOW_URL = "/v7.0/page_follow/";
    public static final String GET_PAGE_URL = "/v7.0/page/%s/";
    public static final String GET_PRIVACY_URL = "/v7.0/privacy_option/%s/";
    public static final String GET_REGISTRATION = "/api/0.1/notification_registration/%s/";
    public static final String GET_REGISTRATION_LIST = "/api/0.1/notification_registration/";
    public static final String GET_REMOTE_CONNECTIONS_URL = "/v7.0/remoteconnection/";
    public static final String GET_REMOTE_CONNECTION_TYPES_URL = "/v7.0/remoteconnectiontype/";
    public static final String GET_REMOTE_CONNECTION_TYPE_URL = "/v7.0/remoteconnectiontype/%s/";
    public static final String GET_REMOTE_CONNECTION_URL = "/v7.0/remoteconnection/%s/";
    public static final String GET_ROLE_PAGE_URL = "/v7.0/role/";
    public static final String GET_ROLE_URL = "/v7.0/role/%s/";
    public static final String GET_ROUTES_URL = "/v7.0/route/";
    public static final String GET_ROUTE_URL = "/v7.0/route/%s/";
    public static final String GET_SLEEP_PAGE_URL = "/api/0.1/sleep/";
    public static final String GET_SLEEP_URL = "/api/0.1/sleep/%s/";
    public static final String GET_SUBSCRIPTION = "/api/0.1/notification_subscription/%s/";
    public static final String GET_SUBSCRIPTION_LIST = "/api/0.1/notification_subscription/";
    public static final String GET_SUGGESTED_FRIENDS_URL = "/api/0.1/friend_suggestion/";
    public static final String GET_USER_GEAR_URL = "/api/0.1/usergear/";
    public static final String GET_USER_PERMISSIONS_PAGE_URL = "/api/0.1/user_permission/";
    public static final String GET_USER_PERMISSIONS_URL = "/api/0.1/user_permission/?resource=%s";
    public static final String GET_USER_PROFILE_PICTURE_DIRECT_URL = "http://drzetlglcbfx.cloudfront.net/profile/%s/picture?size=%s?%s";
    public static final String GET_USER_PROFILE_PICTURE_URL = "/v7.0/user_profile_photo/";
    public static final String GET_USER_ROLE_URL = "/v7.0/user_role/%s";
    public static final String GET_USER_SEARCH_URL = "/v7.0/user/";
    public static final String GET_USER_STATS_URL = "v7.0/user_stats/%s";
    public static final String GET_USER_URL = "/v7.0/user/%s/";
    public static final String GET_WORKOUTS_URL = "/v7.0/workout/";
    public static final String GET_WORKOUT_URL = "/v7.0/workout/%s/";
    public static final String IMAGE_UPLOAD_URL = "/api/0.1/image/";
    public static final String PATCH_DELETE_USER_GEAR_URL = "/api/0.1/usergear/%s/";
    public static final String PATCH_FRIENDSHIP_URL = "/v7.0/friendship/";
    public static final String PATCH_GROUP_INVITE_URL = "/v7.0/group_invite/";
    public static final String PATCH_PAGE_FOLLOW_URL = "/v7.0/page_follow/";
    public static final String PATCH_REGISTRATION_LIST = "/api/0.1/notification_registration/%s/";
    public static final String PATCH_ROUTE = "/api/0.1/route/%s/set_privacy/";
    public static final String PATCH_SUBSCRIPTION_LIST = "/api/0.1/notification_subscription/%s/";
    public static final String PATCH_WORKOUT = "/api/0.1/workout/%s/set_privacy/";
    public static final String POST_MODERATION_ACTION = "/v7.0/moderation_action/";
    public static final String ROUTE_BOOKMARK_COLLECTION_URL = "/v7.0/route_bookmark/";
    public static final String ROUTE_BOOKMARK_URL = "/v7.0/route_bookmark/%s/";
    public static final String SAVE_SLEEP_URL = "/api/0.1/sleep/";
    public static final String UPDATE_ROUTE_URL = "/v7.0/route/%s/";
    protected String baseWebUrl;
    protected String mBaseUrl;

    public UrlBuilderImpl() {
        this("https://oauth2-api.mapmyapi.com", "https://www.mapmyfitness.com");
    }

    public UrlBuilderImpl(String str, String str2) {
        setBaseUrl(str);
        setBaseWebUrl(str2);
    }

    public void setBaseUrl(String str) {
        this.mBaseUrl = (String) Precondition.isNotNull(str, "baseUrl");
    }

    public void setBaseWebUrl(String str) {
        this.baseWebUrl = (String) Precondition.isNotNull(str, "baseUrl");
    }

    protected String getBaseUrl() {
        return this.mBaseUrl;
    }

    protected String getBaseWebUrl() {
        return this.baseWebUrl;
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetAuthenticationToken() {
        return getUrl(null, this.mBaseUrl, GET_OAUTH2_TOKEN_URL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildOAuth2AuthorizationUrl(String str, String str2) {
        return getUrl(null, getBaseWebUrl(), GET_OAUTH2_AUTHORIZATION_URL, str, str2);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetCurrentUserUrl() {
        return getUrl(null, this.mBaseUrl, GET_CURRENT_USER_URL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetUserUrl(Reference reference) throws NullPointerException {
        Precondition.isNotNull(reference);
        return getUrl(reference, this.mBaseUrl, GET_USER_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetUserPageUrl(EntityListRef entityListRef) throws NullPointerException {
        Precondition.isNotNull(entityListRef);
        return getUrl(entityListRef, this.mBaseUrl, GET_USER_URL, entityListRef.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateUserUrl() {
        return getUrl(null, this.mBaseUrl, "/v7.0/user/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildSaveUserUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, GET_USER_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildResetPasswordUrl() {
        return getUrl(null, this.mBaseUrl, "/api/0.1/password_reset/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetUserProfilePhotoUrl(Reference reference) throws NullPointerException {
        Precondition.isNotNull(reference);
        return getUrl(reference, this.mBaseUrl, GET_USER_PROFILE_PICTURE_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetActigraphyUrl(ActigraphyListRef actigraphyListRef) {
        return getUrl(null, this.mBaseUrl, GET_ACTIGRAPHY_URL, actigraphyListRef.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetRemoteConnectionTypeUrl(Reference reference) {
        return (reference == null || reference.getId() == null) ? getUrl(null, this.mBaseUrl, GET_REMOTE_CONNECTION_TYPES_URL, new Object[0]) : getUrl(reference, this.mBaseUrl, GET_REMOTE_CONNECTION_TYPE_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildApproveFriendship(Reference reference) {
        return getUrl(reference, this.mBaseUrl, CHANGE_FRIENDSHIP_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildDeleteFriendshipUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, CHANGE_FRIENDSHIP_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildSendFriendshipRequest() {
        return getUrl(null, this.mBaseUrl, "/v7.0/friendship/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildPatchFriendshipRequest(Reference reference) {
        return getUrl(reference, this.mBaseUrl, "/v7.0/friendship/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetFriendsUrl(EntityListRef entityListRef) {
        return getUrl(entityListRef, this.mBaseUrl, "/v7.0/friendship/", entityListRef.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateActivityStoryUrl() {
        return getUrl(null, this.mBaseUrl, "/v7.0/activity_story/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetActivityStoryUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, GET_ACTIVITY_STORY_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetActivityFeedUrl(EntityListRef entityListRef) {
        return getUrl(entityListRef, this.mBaseUrl, "/v7.0/activity_story/", entityListRef.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetPageUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, GET_PAGE_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetSuggestedFriendsUrl(EntityListRef entityListRef) {
        return getUrl(entityListRef, this.mBaseUrl, GET_SUGGESTED_FRIENDS_URL, entityListRef.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildDeletePageFollowUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, DELETE_PAGE_FOLLOW_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetRemoteConnectionUrl(Reference reference) {
        return (reference == null || reference.getId() == null) ? getUrl(null, this.mBaseUrl, GET_REMOTE_CONNECTIONS_URL, new Object[0]) : getUrl(null, this.mBaseUrl, GET_REMOTE_CONNECTION_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildPostImageUrl() {
        return getUrl(null, this.mBaseUrl, IMAGE_UPLOAD_URL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildPostVideoUrl() {
        return getUrl(null, FILEMOBILE_BASE_URL, FILEMOBILE_UPLOAD_PATH, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetActigraphySettingsUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, GET_ACTIGRAPHY_SETTINGS_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetActigraphyRecorderPriorityUrl() {
        return getUrl(null, this.mBaseUrl, GET_ACTIGRAPHY_REORDER_PRIORITY_URL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateInternalTokenCredentialUrl() {
        return getUrl(null, this.mBaseUrl, CREATE_INTERNAL_TOKEN_CREDENTIAL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetRouteUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, reference.getHref(), reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateRouteUrl() {
        return getUrl(null, this.mBaseUrl, "/v7.0/route/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildUpdateRouteUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, "/v7.0/route/%s/", reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildDeleteRouteUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, "/v7.0/route/%s/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreatePageFollowUrl() {
        return getUrl(null, this.mBaseUrl, "/v7.0/page_follow/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetPageFollowUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, "/v7.0/page_follow/", reference.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetPageFollowPageUrl(EntityListRef entityListRef) {
        return getUrl(entityListRef, this.mBaseUrl, "/v7.0/page_follow/", entityListRef.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildPatchPageFollowUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, "/v7.0/page_follow/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetPageAssociationUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, GET_PAGE_ASSOCIATION_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetPageAssociationsUrl(EntityListRef entityListRef) {
        return getUrl(entityListRef, this.mBaseUrl, entityListRef.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreatePageAssociationUrl() {
        return getUrl(null, this.mBaseUrl, "/v7.0/page_association/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildDeletePageAssociationUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, GET_PAGE_ASSOCIATION_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetPagesUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, GET_PAGES_URL, reference.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildDeleteRemoteConnectionUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, GET_REMOTE_CONNECTION_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildRpcPatchActivityStoryUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, reference.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateActivityTimeSeriesUrl() {
        return getUrl(null, this.mBaseUrl, CREATE_ACTIVITY_TIME_SERIES_URL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetUserStatsUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, GET_USER_STATS_URL, reference.getId(), reference.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetGearUrl(EntityListRef entityListRef) {
        return getUrl(entityListRef, this.mBaseUrl, GET_GEAR_URL, entityListRef.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetGearBrandUrl(EntityListRef entityListRef) {
        return getUrl(entityListRef, this.mBaseUrl, GET_GEAR_BRAND_URL, entityListRef.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetUserGearUrl(EntityListRef entityListRef) {
        return getUrl(entityListRef, this.mBaseUrl, "/api/0.1/usergear/", entityListRef.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateUserGearUrl() {
        return getUrl(null, this.mBaseUrl, "/api/0.1/usergear/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildPatchUserGearUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, PATCH_DELETE_USER_GEAR_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildDeleteUserGearUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, PATCH_DELETE_USER_GEAR_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateFilemobileTokenCredentialUrl() {
        return getUrl(null, this.mBaseUrl, CREATE_FILEMOBILE_TOKEN_CREDENTIAL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildSaveSleepUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, "/api/0.1/sleep/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetSleepUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, GET_SLEEP_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetSleepListUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, "/api/0.1/sleep/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetRoleUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, GET_ROLE_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetRolesUrl(EntityListRef entityListRef) {
        return getUrl(null, this.mBaseUrl, GET_ROLE_PAGE_URL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetUserPermissionUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, GET_USER_PERMISSIONS_URL, reference.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetUserPermissionsUrl(EntityListRef entityListRef) {
        return getUrl(entityListRef, this.mBaseUrl, GET_USER_PERMISSIONS_PAGE_URL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetUserRoleUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, GET_USER_ROLE_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateUserRoleUrl() {
        return getUrl(null, this.mBaseUrl, CREATE_USER_ROLE_URL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetActivityTypeUrl(Reference reference) {
        return getUrl(reference);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetActivityTypeListUrl(Reference reference) {
        return getUrl(reference);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetNotificationRegistrationUrl(Reference reference) {
        return getUrl(reference, getBaseUrl(), "/api/0.1/notification_registration/%s/", reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetNotificationRegistrationPageUrl(EntityListRef entityListRef) {
        return getUrl(entityListRef, getBaseUrl(), "/api/0.1/notification_registration/", entityListRef.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateNotificationRegistrationUrl() {
        return getUrl(null, getBaseUrl(), "/api/0.1/notification_registration/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildPatchNotificationRegistrationUrl(Reference reference) {
        return getUrl(reference, getBaseUrl(), "/api/0.1/notification_registration/%s/", reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildDeleteNotificationRegistrationUrl(Reference reference) {
        return getUrl(reference, getBaseUrl(), DELETE_REGISTRATION_LIST, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetNotificationSubscriptionUrl(Reference reference) {
        return getUrl(reference, getBaseUrl(), "/api/0.1/notification_subscription/%s/", reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetNotificationSubscriptionPageUrl(Reference reference) {
        return getUrl(reference, getBaseUrl(), GET_SUBSCRIPTION_LIST, reference.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildPatchNotificationSubscriptionUrl(Reference reference) {
        return getUrl(null, getBaseUrl(), "/api/0.1/notification_subscription/%s/", reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetWorkoutsListUrl(Reference reference) {
        return getUrl(reference);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetWorkoutByIdUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, reference.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildDeleteWorkoutUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, reference.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildSaveWorkoutUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, reference.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateWorkoutUrl() {
        return getUrl(null, this.mBaseUrl, GET_WORKOUTS_URL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateModerationActionUrl() {
        return getUrl(null, this.mBaseUrl, POST_MODERATION_ACTION, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildFetchGroupListUrl(Reference reference) {
        return getUrl(reference);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildFetchGroupUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, reference.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateGroupUrl() {
        return getUrl(null, this.mBaseUrl, GET_GROUPS_LIST_URL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildPatchGroupUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, reference.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildDeleteGroupUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, reference.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildSaveGroupUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, reference.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetGroupInviteUrl(Reference reference) {
        return getUrl(reference);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateGroupInviteUrl() {
        return getUrl(null, this.mBaseUrl, "/v7.0/group_invite/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildDeleteGroupInviteUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, reference.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetGroupUserUrl(Reference reference) {
        return getUrl(reference);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateGroupUserUrl() {
        return getUrl(null, this.mBaseUrl, "/v7.0/group_user/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildDeleteGroupUserUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, reference.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetGroupPurposesUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, GET_GROUP_PURPOSES, reference.getHref());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetGroupObjectiveUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, GET_GROUP_OBJECTIVE_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildGetGroupObjectiveListUrl(Reference reference) {
        return getUrl(reference);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateGroupObjectiveUrl() {
        return getUrl(null, this.mBaseUrl, "/v7.0/group_objective/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildSaveGroupObjectiveUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, reference.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildDeleteGroupObjectiveUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, reference.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildFetchBodyMassUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, BODYMASS_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildSaveBodyMassUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, BODYMASS_COLLECTION_URL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildFetchBodyMassListUrl(Reference reference) {
        return getUrl(reference);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildFetchAggregateListUrl(Reference reference) {
        return getUrl(reference);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildFetchGroupLeaderboardListUrl(Reference reference) {
        return getUrl(reference);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildPatchGroupInviteUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, "/v7.0/group_invite/", new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateHeartRateZonesUrl() {
        return getUrl(null, this.mBaseUrl, BASE_HEART_RATE_ZONES, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildFetchHeartRateZonesUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, GET_HEART_RATE_ZONES, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildFetchHeartRateZonesListUrl(Reference reference) {
        return getUrl(reference);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildCreateRouteBookmarkUrl() {
        return getUrl(null, this.mBaseUrl, ROUTE_BOOKMARK_COLLECTION_URL, new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildFetchRouteBookmarkUrl(Reference reference) {
        return getUrl(reference, this.mBaseUrl, ROUTE_BOOKMARK_URL, reference.getId());
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildDeleteRouteBookmarkUrl(Reference reference) {
        return getUrl(null, this.mBaseUrl, reference.getHref(), new Object[0]);
    }

    @Override // com.ua.sdk.internal.net.UrlBuilder
    public URL buildFetchRouteBookmarkListUrl(EntityListRef entityListRef) {
        return getUrl(entityListRef);
    }

    protected static URL getUrl(Reference reference, String str, String str2, Object... objArr) {
        String str3;
        if (reference == null || reference.getHref() == null) {
            str3 = null;
        } else {
            str3 = str + reference.getHref();
        }
        if (str3 == null) {
            str3 = str + String.format(Locale.US, str2, objArr);
        }
        try {
            return new URL(str3);
        } catch (MalformedURLException e) {
            UaLog.error("bad url", (Throwable) e);
            throw new RuntimeException(e);
        }
    }

    private URL getUrl(Reference reference) throws NullPointerException {
        Precondition.isNotNull(reference, "ref");
        String href = reference.getHref();
        if (href != null) {
            try {
                return new URL(this.mBaseUrl + href);
            } catch (MalformedURLException e) {
                UaLog.error("Could not construct a URL from ref", (Throwable) e);
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("Ref has a null href");
    }
}
