package com.ua.sdk.user;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.ImageUrl;
import com.ua.sdk.LocalDate;
import com.ua.sdk.MeasurementSystem;
import com.ua.sdk.UaLog;
import com.ua.sdk.authentication.OAuth2Credentials;
import com.ua.sdk.authentication.OAuth2CredentialsImpl;
import com.ua.sdk.friendship.FriendshipListRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.ImageUrlImpl;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.location.Location;
import com.ua.sdk.location.LocationImpl;
import com.ua.sdk.page.follow.PageFollow;
import com.ua.sdk.page.follow.PageFollowListRef;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.privacy.PrivacyHelper;
import com.ua.sdk.user.stats.UserStatsRef;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes2.dex */
public class UserImpl extends ApiTransferObject implements User, Parcelable {
    public static Parcelable.Creator<UserImpl> CREATOR = new Parcelable.Creator<UserImpl>() { // from class: com.ua.sdk.user.UserImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserImpl createFromParcel(Parcel parcel) {
            return new UserImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserImpl[] newArray(int i) {
            return new UserImpl[i];
        }
    };
    protected static final String NAME_ACTIVITY_FEED = "activity_feed";
    protected static final String NAME_BODY_MASS = "bodymass";
    protected static final String NAME_EMAIL_SEARCH = "email_search";
    protected static final String NAME_FOOD_LOG = "food_log";
    protected static final String NAME_PROFILE = "profile";
    protected static final String NAME_ROUTE = "route";
    protected static final String NAME_SLEEP = "sleep";
    protected static final String NAME_WORKOUT = "workout";
    protected static final String REF_DEACTIVATION = "deactivation";
    protected static final String REF_DOCUMENTATION = "documentation";
    protected static final String REF_FRIENDSHIPS = "friendships";
    protected static final String REF_IMAGE = "image";
    protected static final String REF_PRIVACY = "privacy";
    protected static final String REF_STATS = "stats";
    protected static final String REF_WORKOUTS = "workouts";
    private transient Privacy activityFeedPrivacy;
    private LocalDate birthdate;
    private transient Privacy bodyMassPrivacy;
    private UserCommunication communication;
    private Date dateJoined;
    private MeasurementSystem displayMeasurementSystem;
    private String displayName;
    private String email;
    private transient Privacy emailSearchPrivacy;
    private String firstName;
    private transient EntityListRef<PageFollow> followingRef;
    private transient Privacy foodLogPrivacy;
    private transient FriendshipListRef friendships;
    private Gender gender;
    private String goalStatement;
    private Double height;
    private String hobbies;
    private String id;
    private String introduction;
    private String lastInitial;
    private Date lastLogin;
    private String lastName;
    private Location location;
    private UserObjectState myState;
    private OAuth2Credentials oAuth2Credentials;
    private transient String password;
    private transient Privacy profilePrivacy;
    private String profileStatement;
    private transient Privacy routePrivacy;
    private UserSharing sharing;
    private transient Privacy sleepPrivacy;
    private String timeZone;
    private ImageUrlImpl userProfilePhoto;
    private String username;
    private Double weight;
    private transient Privacy workoutPrivacy;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserImpl() {
        this.oAuth2Credentials = new OAuth2CredentialsImpl();
        this.goalStatement = "";
        this.communication = new UserCommunicationImpl();
        this.sharing = new UserSharingImpl();
        this.location = new LocationImpl();
        this.userProfilePhoto = new ImageUrlImpl();
        this.myState = UserObjectState.FULL;
    }

    @Override // com.ua.sdk.user.User
    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    @Override // com.ua.sdk.user.User
    public String getUsername() {
        return this.username;
    }

    @Override // com.ua.sdk.user.User
    public void setUsername(String str) {
        this.username = str;
    }

    @Override // com.ua.sdk.user.User
    public String getEmail() {
        return this.email;
    }

    @Override // com.ua.sdk.user.User
    public void setEmail(String str) {
        this.email = str;
    }

    public OAuth2Credentials getOauth2Credentials() {
        return this.oAuth2Credentials;
    }

    public void setOauth2Credentials(OAuth2Credentials oAuth2Credentials) {
        this.oAuth2Credentials = oAuth2Credentials;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    @Override // com.ua.sdk.user.User
    public String getFirstName() {
        return this.firstName;
    }

    @Override // com.ua.sdk.user.User
    public void setFirstName(String str) {
        this.firstName = str;
    }

    @Override // com.ua.sdk.user.User
    public String getLastName() {
        return this.lastName;
    }

    @Override // com.ua.sdk.user.User
    public void setLastName(String str) {
        this.lastName = str;
    }

    @Override // com.ua.sdk.user.User
    public String getLastInitial() {
        return this.lastInitial;
    }

    @Override // com.ua.sdk.user.User
    public void setLastInitial(String str) {
        this.lastInitial = str;
    }

    @Override // com.ua.sdk.user.User
    public String getDisplayName() {
        return this.displayName;
    }

    @Override // com.ua.sdk.user.User
    public void setDisplayName(String str) {
        this.displayName = str;
    }

    @Override // com.ua.sdk.user.User
    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    @Override // com.ua.sdk.user.User
    public void setBirthdate(LocalDate localDate) {
        this.birthdate = localDate;
    }

    @Override // com.ua.sdk.user.User
    public Gender getGender() {
        return this.gender;
    }

    @Override // com.ua.sdk.user.User
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override // com.ua.sdk.user.User
    public Double getHeight() {
        return this.height;
    }

    @Override // com.ua.sdk.user.User
    public void setHeight(Double d) {
        this.height = d;
    }

    @Override // com.ua.sdk.user.User
    public Double getWeight() {
        return this.weight;
    }

    @Override // com.ua.sdk.user.User
    public void setWeight(Double d) {
        this.weight = d;
    }

    @Override // com.ua.sdk.user.User
    public String getTimeZone() {
        return this.timeZone;
    }

    @Override // com.ua.sdk.user.User
    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    @Override // com.ua.sdk.user.User
    public Date getDateJoined() {
        return this.dateJoined;
    }

    @Override // com.ua.sdk.user.User
    public void setDateJoined(Date date) {
        this.dateJoined = date;
    }

    @Override // com.ua.sdk.user.User
    public Date getLastLogin() {
        return this.lastLogin;
    }

    @Override // com.ua.sdk.user.User
    public void setLastLogin(Date date) {
        this.lastLogin = date;
    }

    @Override // com.ua.sdk.user.User
    public MeasurementSystem getDisplayMeasurementSystem() {
        return this.displayMeasurementSystem;
    }

    @Override // com.ua.sdk.user.User
    public void setDisplayMeasurementSystem(MeasurementSystem measurementSystem) {
        this.displayMeasurementSystem = measurementSystem;
    }

    @Override // com.ua.sdk.user.User
    public UserCommunication getCommunication() {
        return this.communication;
    }

    @Override // com.ua.sdk.user.User
    public void setCommunication(UserCommunication userCommunication) {
        this.communication = userCommunication;
    }

    @Override // com.ua.sdk.user.User
    public UserSharing getSharing() {
        return this.sharing;
    }

    @Override // com.ua.sdk.user.User
    public void setSharing(UserSharing userSharing) {
        this.sharing = userSharing;
    }

    @Override // com.ua.sdk.user.User
    public Location getLocation() {
        return this.location;
    }

    @Override // com.ua.sdk.user.User
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override // com.ua.sdk.user.User
    public void setProfilePrivacy(Privacy.Level level) {
        this.profilePrivacy = PrivacyHelper.getPrivacy(level);
        updatePrivacyLink("profile", level);
    }

    @Override // com.ua.sdk.user.User
    public void setWorkoutPrivacy(Privacy.Level level) {
        this.workoutPrivacy = PrivacyHelper.getPrivacy(level);
        updatePrivacyLink("workout", level);
    }

    @Override // com.ua.sdk.user.User
    public void setActivityFeedPrivacy(Privacy.Level level) {
        this.activityFeedPrivacy = PrivacyHelper.getPrivacy(level);
        updatePrivacyLink(NAME_ACTIVITY_FEED, level);
    }

    @Override // com.ua.sdk.user.User
    public void setFoodLogPrivacy(Privacy.Level level) {
        this.foodLogPrivacy = PrivacyHelper.getPrivacy(level);
        updatePrivacyLink(NAME_FOOD_LOG, level);
    }

    @Override // com.ua.sdk.user.User
    public void setEmailSearchPrivacy(Privacy.Level level) {
        this.emailSearchPrivacy = PrivacyHelper.getPrivacy(level);
        updatePrivacyLink(NAME_EMAIL_SEARCH, level);
    }

    @Override // com.ua.sdk.user.User
    public void setRoutePrivacy(Privacy.Level level) {
        this.routePrivacy = PrivacyHelper.getPrivacy(level);
        updatePrivacyLink(NAME_ROUTE, level);
    }

    @Override // com.ua.sdk.user.User
    public void setSleepPrivacy(Privacy.Level level) {
        this.sleepPrivacy = PrivacyHelper.getPrivacy(level);
        updatePrivacyLink(NAME_SLEEP, level);
    }

    @Override // com.ua.sdk.user.User
    public void setBodyMassPrivacy(Privacy.Level level) {
        this.bodyMassPrivacy = PrivacyHelper.getPrivacy(level);
        updatePrivacyLink(NAME_BODY_MASS, level);
    }

    @Override // com.ua.sdk.user.User
    public String getIntroduction() {
        return this.introduction;
    }

    @Override // com.ua.sdk.user.User
    public void setIntroduction(String str) {
        this.introduction = str;
    }

    @Override // com.ua.sdk.user.User
    public String getHobbies() {
        return this.hobbies;
    }

    @Override // com.ua.sdk.user.User
    public void setHobbies(String str) {
        this.hobbies = str;
    }

    @Override // com.ua.sdk.user.User
    public String getGoalStatement() {
        return this.goalStatement;
    }

    @Override // com.ua.sdk.user.User
    public void setGoalStatement(String str) {
        this.goalStatement = str;
    }

    @Override // com.ua.sdk.user.User
    public String getProfileStatement() {
        return this.profileStatement;
    }

    @Override // com.ua.sdk.user.User
    public void setProfileStatement(String str) {
        this.profileStatement = str;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef getRef() {
        return new LinkEntityRef(this.id, this.mLocalId, getHref());
    }

    @Override // com.ua.sdk.user.User
    public ImageUrlImpl getUserProfilePhoto() {
        return this.userProfilePhoto;
    }

    @Override // com.ua.sdk.user.User
    public void setUserProfilePhoto(ImageUrl imageUrl) {
        this.userProfilePhoto = (ImageUrlImpl) imageUrl;
    }

    @Override // com.ua.sdk.user.User
    public FriendshipListRef getFriendships() {
        return FriendshipListRef.getBuilder().setHref(getLink("friendships").getHref()).build();
    }

    @Override // com.ua.sdk.user.User
    public UserStatsRef getStatsByDay() {
        return UserStatsRef.getBuilder().setUser(getRef()).setAggregatePeriodUserStats(UserStatsRef.AggregatePeriodUserStats.DAY).build();
    }

    @Override // com.ua.sdk.user.User
    public UserStatsRef getStatsByWeek() {
        return UserStatsRef.getBuilder().setUser(getRef()).setAggregatePeriodUserStats(UserStatsRef.AggregatePeriodUserStats.WEEK).build();
    }

    @Override // com.ua.sdk.user.User
    public UserStatsRef getStatsByMonth() {
        return UserStatsRef.getBuilder().setUser(getRef()).setAggregatePeriodUserStats(UserStatsRef.AggregatePeriodUserStats.MONTH).build();
    }

    @Override // com.ua.sdk.user.User
    public UserStatsRef getStatsByYear() {
        return UserStatsRef.getBuilder().setUser(getRef()).setAggregatePeriodUserStats(UserStatsRef.AggregatePeriodUserStats.YEAR).build();
    }

    @Override // com.ua.sdk.user.User
    public UserStatsRef getStatsByLifetime() {
        return UserStatsRef.getBuilder().setUser(getRef()).setAggregatePeriodUserStats(UserStatsRef.AggregatePeriodUserStats.DAY).build();
    }

    private Privacy getPrivacy(String str) {
        Link link = getLink("privacy", str);
        if (link == null) {
            return null;
        }
        try {
            return PrivacyHelper.getPrivacyFromId(Integer.parseInt(link.getId()));
        } catch (NumberFormatException e) {
            UaLog.error("Unable to get privacy.", (Throwable) e);
            return null;
        }
    }

    private void updatePrivacyLink(String str, Privacy.Level level) {
        ArrayList<Link> links = getLinks("privacy");
        if (links != null) {
            Link link = PrivacyHelper.toLink(level, str);
            boolean z = true;
            for (int i = 0; i < links.size(); i++) {
                if (links.get(i).getName().equals(str)) {
                    links.set(i, link);
                    z = false;
                }
            }
            if (z) {
                links.add(link);
            }
        }
    }

    @Override // com.ua.sdk.user.User
    public Privacy getProfilePrivacy() {
        if (this.profilePrivacy == null) {
            this.profilePrivacy = getPrivacy("profile");
        }
        return this.profilePrivacy;
    }

    @Override // com.ua.sdk.user.User
    public Privacy getWorkoutPrivacy() {
        if (this.workoutPrivacy == null) {
            this.workoutPrivacy = getPrivacy("workout");
        }
        return this.workoutPrivacy;
    }

    @Override // com.ua.sdk.user.User
    public Privacy getActivityFeedPrivacy() {
        if (this.activityFeedPrivacy == null) {
            this.activityFeedPrivacy = getPrivacy(NAME_ACTIVITY_FEED);
        }
        return this.activityFeedPrivacy;
    }

    @Override // com.ua.sdk.user.User
    public Privacy getFoodLogPrivacy() {
        if (this.foodLogPrivacy == null) {
            this.foodLogPrivacy = getPrivacy(NAME_FOOD_LOG);
        }
        return this.foodLogPrivacy;
    }

    @Override // com.ua.sdk.user.User
    public Privacy getEmailSearchPrivacy() {
        if (this.emailSearchPrivacy == null) {
            this.emailSearchPrivacy = getPrivacy(NAME_EMAIL_SEARCH);
        }
        return this.emailSearchPrivacy;
    }

    @Override // com.ua.sdk.user.User
    public Privacy getRoutePrivacy() {
        if (this.routePrivacy == null) {
            this.routePrivacy = getPrivacy(NAME_ROUTE);
        }
        return this.routePrivacy;
    }

    @Override // com.ua.sdk.user.User
    public Privacy getBodyMassPrivacy() {
        if (this.bodyMassPrivacy == null) {
            this.bodyMassPrivacy = getPrivacy(NAME_BODY_MASS);
        }
        return this.bodyMassPrivacy;
    }

    @Override // com.ua.sdk.user.User
    public Privacy getSleepPrivacy() {
        if (this.sleepPrivacy == null) {
            this.sleepPrivacy = getPrivacy(NAME_SLEEP);
        }
        return this.sleepPrivacy;
    }

    @Override // com.ua.sdk.user.User
    public EntityListRef<PageFollow> getFollowingRef() {
        if (this.followingRef == null) {
            this.followingRef = PageFollowListRef.getBuilder().setUserId(this.id).build();
        }
        return this.followingRef;
    }

    public UserObjectState getObjectState() {
        return this.myState;
    }

    public void setObjectState(UserObjectState userObjectState) {
        this.myState = userObjectState;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.id);
        parcel.writeString(this.username);
        parcel.writeString(this.email);
        parcel.writeParcelable(this.oAuth2Credentials, 0);
        parcel.writeString(this.password);
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.lastInitial);
        parcel.writeString(this.displayName);
        parcel.writeString(this.introduction);
        parcel.writeString(this.hobbies);
        parcel.writeString(this.goalStatement);
        parcel.writeString(this.profileStatement);
        parcel.writeParcelable(this.birthdate, 0);
        Gender gender = this.gender;
        parcel.writeInt(gender == null ? -1 : gender.ordinal());
        parcel.writeValue(this.height);
        parcel.writeValue(this.weight);
        parcel.writeString(this.timeZone);
        Date date = this.dateJoined;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        Date date2 = this.lastLogin;
        parcel.writeLong(date2 != null ? date2.getTime() : -1L);
        MeasurementSystem measurementSystem = this.displayMeasurementSystem;
        parcel.writeInt(measurementSystem == null ? -1 : measurementSystem.ordinal());
        parcel.writeParcelable(this.communication, 0);
        parcel.writeParcelable(this.sharing, 0);
        parcel.writeParcelable(this.location, 0);
        parcel.writeParcelable(this.userProfilePhoto, 0);
        parcel.writeParcelable(this.profilePrivacy, i);
        parcel.writeParcelable(this.workoutPrivacy, i);
        parcel.writeParcelable(this.activityFeedPrivacy, i);
        parcel.writeParcelable(this.foodLogPrivacy, i);
        parcel.writeParcelable(this.emailSearchPrivacy, i);
        parcel.writeParcelable(this.routePrivacy, i);
        parcel.writeParcelable(this.sleepPrivacy, i);
        parcel.writeParcelable(this.bodyMassPrivacy, i);
        parcel.writeParcelable(this.friendships, 0);
        UserObjectState userObjectState = this.myState;
        parcel.writeInt(userObjectState != null ? userObjectState.ordinal() : -1);
    }

    private UserImpl(Parcel parcel) {
        super(parcel);
        this.oAuth2Credentials = new OAuth2CredentialsImpl();
        this.goalStatement = "";
        this.communication = new UserCommunicationImpl();
        this.sharing = new UserSharingImpl();
        this.location = new LocationImpl();
        this.userProfilePhoto = new ImageUrlImpl();
        this.myState = UserObjectState.FULL;
        this.id = parcel.readString();
        this.username = parcel.readString();
        this.email = parcel.readString();
        this.oAuth2Credentials = (OAuth2Credentials) parcel.readParcelable(OAuth2Credentials.class.getClassLoader());
        this.password = parcel.readString();
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
        this.lastInitial = parcel.readString();
        this.displayName = parcel.readString();
        this.introduction = parcel.readString();
        this.hobbies = parcel.readString();
        this.goalStatement = parcel.readString();
        this.profileStatement = parcel.readString();
        this.birthdate = (LocalDate) parcel.readParcelable(LocalDate.class.getClassLoader());
        int i = parcel.readInt();
        this.gender = i == -1 ? null : Gender.values()[i];
        this.height = (Double) parcel.readValue(Double.class.getClassLoader());
        this.weight = (Double) parcel.readValue(Double.class.getClassLoader());
        this.timeZone = parcel.readString();
        long j = parcel.readLong();
        this.dateJoined = j == -1 ? null : new Date(j);
        long j2 = parcel.readLong();
        this.lastLogin = j2 == -1 ? null : new Date(j2);
        int i2 = parcel.readInt();
        this.displayMeasurementSystem = i2 == -1 ? null : MeasurementSystem.values()[i2];
        this.communication = (UserCommunication) parcel.readParcelable(UserCommunication.class.getClassLoader());
        this.sharing = (UserSharing) parcel.readParcelable(UserSharing.class.getClassLoader());
        this.location = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.userProfilePhoto = (ImageUrlImpl) parcel.readParcelable(ImageUrl.class.getClassLoader());
        this.profilePrivacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.workoutPrivacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.activityFeedPrivacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.foodLogPrivacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.emailSearchPrivacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.routePrivacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.sleepPrivacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.bodyMassPrivacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
        this.friendships = (FriendshipListRef) parcel.readParcelable(FriendshipListRef.class.getClassLoader());
        int i3 = parcel.readInt();
        this.myState = i3 != -1 ? UserObjectState.values()[i3] : null;
    }
}
