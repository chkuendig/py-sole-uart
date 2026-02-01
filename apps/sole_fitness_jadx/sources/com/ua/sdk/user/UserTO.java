package com.ua.sdk.user;

import com.dyaco.sole.database.UserData;
import com.facebook.AccessToken;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.LocalDate;
import com.ua.sdk.MeasurementSystem;
import com.ua.sdk.authentication.OAuth2Credentials;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.location.LocationImpl;
import java.util.Date;

/* loaded from: classes2.dex */
public class UserTO extends ApiTransferObject {

    @SerializedName("access_token")
    String accessToken;

    @SerializedName("birthdate")
    LocalDate birthdate;

    @SerializedName("communication")
    UserCommunicationImpl communication;

    @SerializedName("date_joined")
    Date dateJoined;

    @SerializedName("display_measurement_system")
    MeasurementSystem displayMeasurementSystem;

    @SerializedName("display_name")
    String displayName;

    @SerializedName("email")
    String email;

    @SerializedName(AccessToken.EXPIRES_IN_KEY)
    Long expiresIn;

    @SerializedName("first_name")
    String firstName;

    @SerializedName(UserData.GENDER)
    Gender gender;

    @SerializedName("goal_statement")
    String goalStatement;

    @SerializedName("height")
    Double height;

    @SerializedName("hobbies")
    String hobbies;

    @SerializedName("id")
    String id;

    @SerializedName("introduction")
    String introduction;

    @SerializedName("last_initial")
    String lastInitial;

    @SerializedName("last_login")
    Date lastLogin;

    @SerializedName("last_name")
    String lastName;

    @SerializedName("location")
    LocationImpl location;

    @SerializedName("password")
    String password;

    @SerializedName("profile_statement")
    String profileStatment;

    @SerializedName("refresh_token")
    String refreshToken;

    @SerializedName("sharing")
    UserSharingImpl sharing;

    @SerializedName("time_zone")
    String timeZone;

    @SerializedName("username")
    String username;

    @SerializedName(UserData.WEIGHT)
    Double weight;

    public static UserTO toTransferObject(User user) {
        if (user == null) {
            return null;
        }
        UserImpl userImpl = (UserImpl) user;
        UserTO userTO = new UserTO();
        userTO.id = user.getId();
        userTO.username = user.getUsername();
        userTO.email = user.getEmail();
        userTO.password = userImpl.getPassword();
        userTO.firstName = user.getFirstName();
        userTO.lastName = user.getLastName();
        userTO.lastInitial = user.getLastInitial();
        userTO.displayName = user.getDisplayName();
        userTO.introduction = user.getIntroduction();
        userTO.hobbies = user.getHobbies();
        userTO.goalStatement = user.getGoalStatement();
        userTO.profileStatment = user.getProfileStatement();
        userTO.birthdate = user.getBirthdate();
        userTO.gender = user.getGender();
        userTO.height = user.getHeight();
        userTO.weight = user.getWeight();
        userTO.timeZone = user.getTimeZone();
        userTO.dateJoined = user.getDateJoined();
        userTO.lastLogin = user.getLastLogin();
        userTO.displayMeasurementSystem = user.getDisplayMeasurementSystem();
        userTO.communication = (UserCommunicationImpl) userImpl.getCommunication();
        userTO.sharing = (UserSharingImpl) userImpl.getSharing();
        userTO.location = (LocationImpl) userImpl.getLocation();
        userTO.setLinkMap(userImpl.getLinkMap());
        return userTO;
    }

    public static UserImpl fromTransferObject(UserTO userTO) {
        if (userTO == null) {
            return null;
        }
        UserImpl userImpl = new UserImpl();
        userImpl.setId(userTO.id);
        userImpl.setUsername(userTO.username);
        userImpl.setEmail(userTO.email);
        OAuth2Credentials oauth2Credentials = userImpl.getOauth2Credentials();
        oauth2Credentials.setAccessToken(userTO.accessToken);
        oauth2Credentials.setExpiresAt(userTO.expiresIn != null ? Long.valueOf(System.currentTimeMillis() + (userTO.expiresIn.longValue() * 1000)) : null);
        oauth2Credentials.setRefreshToken(userTO.refreshToken);
        userImpl.setFirstName(userTO.firstName);
        userImpl.setLastName(userTO.lastName);
        userImpl.setLastInitial(userTO.lastInitial);
        userImpl.setDisplayName(userTO.displayName);
        userImpl.setIntroduction(userTO.introduction);
        userImpl.setHobbies(userTO.hobbies);
        userImpl.setGoalStatement(userTO.goalStatement);
        userImpl.setProfileStatement(userTO.profileStatment);
        userImpl.setBirthdate(userTO.birthdate);
        userImpl.setGender(userTO.gender);
        userImpl.setHeight(userTO.height);
        userImpl.setWeight(userTO.weight);
        userImpl.setTimeZone(userTO.timeZone);
        userImpl.setDateJoined(userTO.dateJoined);
        userImpl.setLastLogin(userTO.lastLogin);
        userImpl.setDisplayMeasurementSystem(userTO.displayMeasurementSystem);
        userImpl.setCommunication(userTO.communication);
        userImpl.setSharing(userTO.sharing);
        userImpl.setLocation(userTO.location);
        for (String str : userTO.getLinkKeys()) {
            userImpl.setLinksForRelation(str, userTO.getLinks(str));
        }
        return userImpl;
    }
}
