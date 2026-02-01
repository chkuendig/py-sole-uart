package com.ua.sdk.user;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.dyaco.sole.database.UserData;
import com.ua.sdk.LocalDate;
import com.ua.sdk.MeasurementSystem;
import com.ua.sdk.cache.database.LegacyEntityDatabase;
import com.ua.sdk.cache.database.definition.BooleanColumnDefinition;
import com.ua.sdk.cache.database.definition.ColumnDefinition;
import com.ua.sdk.cache.database.definition.DateColumnDefinition;
import com.ua.sdk.cache.database.definition.DoubleColumnDefinition;
import com.ua.sdk.cache.database.definition.EnumColumnDefinition;
import com.ua.sdk.cache.database.definition.LocalDateColumnDefinition;
import com.ua.sdk.cache.database.definition.LocalIdColumnDefinition;
import com.ua.sdk.cache.database.definition.StringColumnDefinition;
import com.ua.sdk.internal.ImageUrlImpl;
import com.ua.sdk.location.LocationImpl;
import java.util.Date;

/* loaded from: classes2.dex */
public class UserDatabase extends LegacyEntityDatabase<User> {
    private static final ColumnDefinition[] ALL_COLUMNS;
    public static final ColumnDefinition<LocalDate> BIRTHDATE;
    public static final ColumnDefinition<Boolean> COMMUNICATION_NEWSLETTER;
    public static final ColumnDefinition<Boolean> COMMUNICATION_PROMOTIONS;
    public static final ColumnDefinition<Boolean> COMMUNICATION_SYSTEM_MESSAGES;
    public static final ColumnDefinition<Date> DATE_JOINED;
    public static final ColumnDefinition<MeasurementSystem> DISPLAY_MEASUREMENT_SYSTEM;
    public static final ColumnDefinition<String> DISPLAY_NAME;
    public static final ColumnDefinition<String> EMAIL;
    public static final ColumnDefinition<String> FIRST_NAME;
    public static final ColumnDefinition<Gender> GENDER;
    public static final ColumnDefinition<String> GOAL_STATEMENT;
    public static final ColumnDefinition<Double> HEIGHT;
    public static final ColumnDefinition<String> HOBBIES;
    public static final ColumnDefinition<String> ID;
    public static final ColumnDefinition<String> INTRODUCTION;
    public static final ColumnDefinition<String> LAST_INITIAL;
    public static final ColumnDefinition<Date> LAST_LOGIN;
    public static final ColumnDefinition<String> LAST_NAME;
    public static final ColumnDefinition<Long> LOCAL_ID;
    public static final ColumnDefinition<String> LOCATION_ADDRESS;
    public static final ColumnDefinition<String> LOCATION_COUNTRY;
    public static final ColumnDefinition<String> LOCATION_LOCALITY;
    public static final ColumnDefinition<String> LOCATION_REGION;
    public static final ColumnDefinition<String> PROFILE_IMAGE_LARGE;
    public static final ColumnDefinition<String> PROFILE_IMAGE_MEDIUM;
    public static final ColumnDefinition<String> PROFILE_IMAGE_SMALL;
    public static final ColumnDefinition<String> PROFILE_STATEMENT;
    public static final ColumnDefinition<Boolean> SHARING_FACEBOOK;
    public static final ColumnDefinition<Boolean> SHARING_TWITTER;
    public static final ColumnDefinition<String> TIMEZONE;
    public static final ColumnDefinition<String> USERNAME;
    private static final String USER_DATABASE_NAME = "mmdk_user";
    private static final int USER_DATABASE_VERSION = 4;
    private static final String USER_TABLE = "user";
    public static final ColumnDefinition<Double> WEIGHT;
    private static UserDatabase mInstance;

    static {
        LocalIdColumnDefinition localIdColumnDefinition = new LocalIdColumnDefinition(0, "_id");
        LOCAL_ID = localIdColumnDefinition;
        StringColumnDefinition stringColumnDefinition = new StringColumnDefinition(1, "id");
        ID = stringColumnDefinition;
        StringColumnDefinition stringColumnDefinition2 = new StringColumnDefinition(2, "username");
        USERNAME = stringColumnDefinition2;
        StringColumnDefinition stringColumnDefinition3 = new StringColumnDefinition(3, "email");
        EMAIL = stringColumnDefinition3;
        StringColumnDefinition stringColumnDefinition4 = new StringColumnDefinition(4, "first_name");
        FIRST_NAME = stringColumnDefinition4;
        StringColumnDefinition stringColumnDefinition5 = new StringColumnDefinition(5, "last_name");
        LAST_NAME = stringColumnDefinition5;
        StringColumnDefinition stringColumnDefinition6 = new StringColumnDefinition(6, "last_initial");
        LAST_INITIAL = stringColumnDefinition6;
        StringColumnDefinition stringColumnDefinition7 = new StringColumnDefinition(7, "display_name");
        DISPLAY_NAME = stringColumnDefinition7;
        StringColumnDefinition stringColumnDefinition8 = new StringColumnDefinition(8, "introduction");
        INTRODUCTION = stringColumnDefinition8;
        StringColumnDefinition stringColumnDefinition9 = new StringColumnDefinition(9, "hobbies");
        HOBBIES = stringColumnDefinition9;
        StringColumnDefinition stringColumnDefinition10 = new StringColumnDefinition(10, "goal_statement");
        GOAL_STATEMENT = stringColumnDefinition10;
        StringColumnDefinition stringColumnDefinition11 = new StringColumnDefinition(11, "profile_statement");
        PROFILE_STATEMENT = stringColumnDefinition11;
        LocalDateColumnDefinition localDateColumnDefinition = new LocalDateColumnDefinition(12, "birthdate");
        BIRTHDATE = localDateColumnDefinition;
        EnumColumnDefinition enumColumnDefinition = new EnumColumnDefinition(13, UserData.GENDER, Gender.class);
        GENDER = enumColumnDefinition;
        DoubleColumnDefinition doubleColumnDefinition = new DoubleColumnDefinition(14, "height");
        HEIGHT = doubleColumnDefinition;
        DoubleColumnDefinition doubleColumnDefinition2 = new DoubleColumnDefinition(15, UserData.WEIGHT);
        WEIGHT = doubleColumnDefinition2;
        StringColumnDefinition stringColumnDefinition12 = new StringColumnDefinition(16, "timezone");
        TIMEZONE = stringColumnDefinition12;
        DateColumnDefinition dateColumnDefinition = new DateColumnDefinition(17, "date_joined");
        DATE_JOINED = dateColumnDefinition;
        DateColumnDefinition dateColumnDefinition2 = new DateColumnDefinition(18, "last_login");
        LAST_LOGIN = dateColumnDefinition2;
        EnumColumnDefinition enumColumnDefinition2 = new EnumColumnDefinition(19, "display_measurement_system", MeasurementSystem.class);
        DISPLAY_MEASUREMENT_SYSTEM = enumColumnDefinition2;
        BooleanColumnDefinition booleanColumnDefinition = new BooleanColumnDefinition(20, "communication_promotions");
        COMMUNICATION_PROMOTIONS = booleanColumnDefinition;
        BooleanColumnDefinition booleanColumnDefinition2 = new BooleanColumnDefinition(22, "communication_newsletter");
        COMMUNICATION_NEWSLETTER = booleanColumnDefinition2;
        BooleanColumnDefinition booleanColumnDefinition3 = new BooleanColumnDefinition(22, "communication_system_messages");
        COMMUNICATION_SYSTEM_MESSAGES = booleanColumnDefinition3;
        BooleanColumnDefinition booleanColumnDefinition4 = new BooleanColumnDefinition(23, "sharing_twitter");
        SHARING_TWITTER = booleanColumnDefinition4;
        BooleanColumnDefinition booleanColumnDefinition5 = new BooleanColumnDefinition(24, "sharing_facebook");
        SHARING_FACEBOOK = booleanColumnDefinition5;
        StringColumnDefinition stringColumnDefinition13 = new StringColumnDefinition(25, "location_country");
        LOCATION_COUNTRY = stringColumnDefinition13;
        StringColumnDefinition stringColumnDefinition14 = new StringColumnDefinition(26, "location_region");
        LOCATION_REGION = stringColumnDefinition14;
        StringColumnDefinition stringColumnDefinition15 = new StringColumnDefinition(27, "location_locality");
        LOCATION_LOCALITY = stringColumnDefinition15;
        StringColumnDefinition stringColumnDefinition16 = new StringColumnDefinition(28, "location_address");
        LOCATION_ADDRESS = stringColumnDefinition16;
        StringColumnDefinition stringColumnDefinition17 = new StringColumnDefinition(29, "profile_image_small");
        PROFILE_IMAGE_SMALL = stringColumnDefinition17;
        StringColumnDefinition stringColumnDefinition18 = new StringColumnDefinition(30, "profile_image_medium");
        PROFILE_IMAGE_MEDIUM = stringColumnDefinition18;
        StringColumnDefinition stringColumnDefinition19 = new StringColumnDefinition(31, "profile_image_large");
        PROFILE_IMAGE_LARGE = stringColumnDefinition19;
        ALL_COLUMNS = new ColumnDefinition[]{localIdColumnDefinition, stringColumnDefinition, stringColumnDefinition2, stringColumnDefinition3, stringColumnDefinition4, stringColumnDefinition5, stringColumnDefinition6, stringColumnDefinition7, stringColumnDefinition8, stringColumnDefinition9, stringColumnDefinition10, stringColumnDefinition11, localDateColumnDefinition, enumColumnDefinition, doubleColumnDefinition, doubleColumnDefinition2, stringColumnDefinition12, dateColumnDefinition, dateColumnDefinition2, enumColumnDefinition2, booleanColumnDefinition, booleanColumnDefinition2, booleanColumnDefinition3, booleanColumnDefinition4, booleanColumnDefinition5, stringColumnDefinition13, stringColumnDefinition14, stringColumnDefinition15, stringColumnDefinition16, stringColumnDefinition17, stringColumnDefinition18, stringColumnDefinition19};
    }

    public static UserDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new UserDatabase(context.getApplicationContext());
        }
        return mInstance;
    }

    protected UserDatabase(Context context) {
        super(context, USER_DATABASE_NAME, "user", buildColumnNames(ALL_COLUMNS), ID.getColumnName(), 4);
    }

    @Override // com.ua.sdk.cache.database.LegacyEntityDatabase
    public void createEntityTable(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(buildCreateStatement("user", ALL_COLUMNS));
    }

    @Override // com.ua.sdk.cache.database.LegacyEntityDatabase
    public void onEntityUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
        createEntityTable(sQLiteDatabase);
    }

    /* renamed from: com.ua.sdk.user.UserDatabase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$user$UserObjectState;

        static {
            int[] iArr = new int[UserObjectState.values().length];
            $SwitchMap$com$ua$sdk$user$UserObjectState = iArr;
            try {
                iArr[UserObjectState.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$user$UserObjectState[UserObjectState.FRIENDS_WITH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.cache.database.LegacyEntityDatabase
    public ContentValues getContentValuesFromEntity(User user) {
        if (user instanceof UserImpl) {
            int i = AnonymousClass1.$SwitchMap$com$ua$sdk$user$UserObjectState[((UserImpl) user).getObjectState().ordinal()];
            if (i == 1) {
                return getFullContentValues(user);
            }
            if (i == 2) {
                return getFriendsWithContent(user);
            }
            return getFullContentValues(user);
        }
        return getFullContentValues(user);
    }

    private ContentValues getFullContentValues(User user) {
        ContentValues contentValues = new ContentValues();
        ID.write(user.getId(), contentValues);
        USERNAME.write(user.getUsername(), contentValues);
        EMAIL.write(user.getEmail(), contentValues);
        FIRST_NAME.write(user.getFirstName(), contentValues);
        LAST_NAME.write(user.getLastName(), contentValues);
        LAST_INITIAL.write(user.getLastInitial(), contentValues);
        DISPLAY_NAME.write(user.getDisplayName(), contentValues);
        INTRODUCTION.write(user.getIntroduction(), contentValues);
        HOBBIES.write(user.getHobbies(), contentValues);
        GOAL_STATEMENT.write(user.getGoalStatement(), contentValues);
        PROFILE_STATEMENT.write(user.getProfileStatement(), contentValues);
        BIRTHDATE.write(user.getBirthdate(), contentValues);
        GENDER.write(user.getGender(), contentValues);
        HEIGHT.write(user.getHeight(), contentValues);
        WEIGHT.write(user.getWeight(), contentValues);
        TIMEZONE.write(user.getTimeZone(), contentValues);
        DATE_JOINED.write(user.getDateJoined(), contentValues);
        LAST_LOGIN.write(user.getLastLogin(), contentValues);
        DISPLAY_MEASUREMENT_SYSTEM.write(user.getDisplayMeasurementSystem(), contentValues);
        COMMUNICATION_PROMOTIONS.write(user.getCommunication() != null ? user.getCommunication().getPromotions() : null, contentValues);
        COMMUNICATION_NEWSLETTER.write(user.getCommunication() != null ? user.getCommunication().getNewsletter() : null, contentValues);
        COMMUNICATION_SYSTEM_MESSAGES.write(user.getCommunication() != null ? user.getCommunication().getSystemMessages() : null, contentValues);
        SHARING_TWITTER.write(user.getSharing() != null ? user.getSharing().getTwitter() : null, contentValues);
        SHARING_FACEBOOK.write(user.getSharing() != null ? user.getSharing().getFacebook() : null, contentValues);
        LOCATION_COUNTRY.write(user.getLocation() != null ? user.getLocation().getCountry() : null, contentValues);
        LOCATION_REGION.write(user.getLocation() != null ? user.getLocation().getRegion() : null, contentValues);
        LOCATION_LOCALITY.write(user.getLocation() != null ? user.getLocation().getLocality() : null, contentValues);
        LOCATION_ADDRESS.write(user.getLocation() != null ? user.getLocation().getAddress() : null, contentValues);
        PROFILE_IMAGE_SMALL.write(user.getUserProfilePhoto() != null ? user.getUserProfilePhoto().getSmall() : null, contentValues);
        PROFILE_IMAGE_MEDIUM.write(user.getUserProfilePhoto() != null ? user.getUserProfilePhoto().getMedium() : null, contentValues);
        PROFILE_IMAGE_LARGE.write(user.getUserProfilePhoto() != null ? user.getUserProfilePhoto().getLarge() : null, contentValues);
        return contentValues;
    }

    private ContentValues getFriendsWithContent(User user) {
        ContentValues contentValues = new ContentValues();
        ID.write(user.getId(), contentValues);
        USERNAME.write(user.getUsername(), contentValues);
        FIRST_NAME.write(user.getFirstName(), contentValues);
        LAST_INITIAL.write(user.getLastInitial(), contentValues);
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.cache.database.LegacyEntityDatabase
    public UserImpl getEntityFromCursor(Cursor cursor) {
        UserImpl userImpl = new UserImpl();
        userImpl.setLocalId(LOCAL_ID.read(cursor).longValue());
        userImpl.setId(ID.read(cursor));
        userImpl.setUsername(USERNAME.read(cursor));
        userImpl.setEmail(EMAIL.read(cursor));
        userImpl.setFirstName(FIRST_NAME.read(cursor));
        userImpl.setLastName(LAST_NAME.read(cursor));
        userImpl.setLastInitial(LAST_INITIAL.read(cursor));
        userImpl.setDisplayName(DISPLAY_NAME.read(cursor));
        userImpl.setIntroduction(INTRODUCTION.read(cursor));
        userImpl.setHobbies(HOBBIES.read(cursor));
        userImpl.setGoalStatement(GOAL_STATEMENT.read(cursor));
        userImpl.setProfileStatement(PROFILE_STATEMENT.read(cursor));
        userImpl.setBirthdate(BIRTHDATE.read(cursor));
        userImpl.setGender(GENDER.read(cursor));
        userImpl.setHeight(HEIGHT.read(cursor));
        userImpl.setWeight(WEIGHT.read(cursor));
        userImpl.setTimeZone(TIMEZONE.read(cursor));
        userImpl.setDateJoined(DATE_JOINED.read(cursor));
        userImpl.setLastLogin(LAST_LOGIN.read(cursor));
        userImpl.setDisplayMeasurementSystem(DISPLAY_MEASUREMENT_SYSTEM.read(cursor));
        userImpl.setCommunication(UserCommunicationImpl.getBuilder().setPromotions(COMMUNICATION_PROMOTIONS.read(cursor)).setNewletters(COMMUNICATION_NEWSLETTER.read(cursor)).setSystemMessages(COMMUNICATION_SYSTEM_MESSAGES.read(cursor)).build());
        userImpl.setSharing(UserSharingImpl.getBuilder().setTwitter(SHARING_TWITTER.read(cursor)).setFacebook(SHARING_FACEBOOK.read(cursor)).build());
        LocationImpl locationImpl = new LocationImpl();
        locationImpl.setCountry(LOCATION_COUNTRY.read(cursor));
        locationImpl.setRegion(LOCATION_REGION.read(cursor));
        locationImpl.setLocality(LOCATION_LOCALITY.read(cursor));
        locationImpl.setAddress(LOCATION_ADDRESS.read(cursor));
        userImpl.setLocation(locationImpl);
        userImpl.setUserProfilePhoto(ImageUrlImpl.getBuilder().setSmall(PROFILE_IMAGE_SMALL.read(cursor)).setMedium(PROFILE_IMAGE_MEDIUM.read(cursor)).setLarge(PROFILE_IMAGE_LARGE.read(cursor)).build());
        return userImpl;
    }
}
