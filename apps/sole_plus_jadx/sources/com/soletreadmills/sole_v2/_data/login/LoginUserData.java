package com.soletreadmills.sole_v2._data.login;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginUserProfile.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B«\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÔ\u0001\u0010G\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\tHÖ\u0001J\t\u0010M\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0017\"\u0004\b\u0019\u0010\u001aR \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u001aR \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u001aR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u001aR \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R\"\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u001aR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b3\u0010-R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0017R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0017\"\u0004\b6\u0010\u001a¨\u0006N"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/login/LoginUserData;", "", "globalUserUuid", "", "userUuid", "loginName", "photoFileUrl", "avatarId", "registerType", "", "email", "birthDate", "gender", "firstName", "lastName", "displayName", "weight", "measurementUnit", "height", "enabledPreferenceItems", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getAvatarId", "()Ljava/lang/String;", "getBirthDate", "setBirthDate", "(Ljava/lang/String;)V", "getDisplayName", "setDisplayName", "getEmail", "getEnabledPreferenceItems", "()Ljava/util/List;", "setEnabledPreferenceItems", "(Ljava/util/List;)V", "getFirstName", "setFirstName", "getGender", "setGender", "getGlobalUserUuid", "getHeight", "setHeight", "getLastName", "setLastName", "getLoginName", "getMeasurementUnit", "()Ljava/lang/Integer;", "setMeasurementUnit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPhotoFileUrl", "setPhotoFileUrl", "getRegisterType", "getUserUuid", "getWeight", "setWeight", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/soletreadmills/sole_v2/_data/login/LoginUserData;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LoginUserData {
    public static final int $stable = 8;

    @SerializedName("avatarId")
    private final String avatarId;

    @SerializedName("birthDate")
    private String birthDate;

    @SerializedName("displayName")
    private String displayName;

    @SerializedName("email")
    private final String email;

    @SerializedName("enabledPreferenceItems")
    private List<Integer> enabledPreferenceItems;

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("gender")
    private String gender;

    @SerializedName("globalUserUuid")
    private final String globalUserUuid;

    @SerializedName("height")
    private String height;

    @SerializedName("lastName")
    private String lastName;

    @SerializedName("loginName")
    private final String loginName;

    @SerializedName("measurementUnit")
    private Integer measurementUnit;

    @SerializedName("photoFileUrl")
    private String photoFileUrl;

    @SerializedName("registerType")
    private final Integer registerType;

    @SerializedName("userUuid")
    private final String userUuid;

    @SerializedName("weight")
    private String weight;

    /* renamed from: component1, reason: from getter */
    public final String getGlobalUserUuid() {
        return this.globalUserUuid;
    }

    /* renamed from: component10, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* renamed from: component11, reason: from getter */
    public final String getLastName() {
        return this.lastName;
    }

    /* renamed from: component12, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component13, reason: from getter */
    public final String getWeight() {
        return this.weight;
    }

    /* renamed from: component14, reason: from getter */
    public final Integer getMeasurementUnit() {
        return this.measurementUnit;
    }

    /* renamed from: component15, reason: from getter */
    public final String getHeight() {
        return this.height;
    }

    public final List<Integer> component16() {
        return this.enabledPreferenceItems;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserUuid() {
        return this.userUuid;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLoginName() {
        return this.loginName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPhotoFileUrl() {
        return this.photoFileUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAvatarId() {
        return this.avatarId;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getRegisterType() {
        return this.registerType;
    }

    /* renamed from: component7, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component8, reason: from getter */
    public final String getBirthDate() {
        return this.birthDate;
    }

    /* renamed from: component9, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    public final LoginUserData copy(String globalUserUuid, String userUuid, String loginName, String photoFileUrl, String avatarId, Integer registerType, String email, String birthDate, String gender, String firstName, String lastName, String displayName, String weight, Integer measurementUnit, String height, List<Integer> enabledPreferenceItems) {
        return new LoginUserData(globalUserUuid, userUuid, loginName, photoFileUrl, avatarId, registerType, email, birthDate, gender, firstName, lastName, displayName, weight, measurementUnit, height, enabledPreferenceItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginUserData)) {
            return false;
        }
        LoginUserData loginUserData = (LoginUserData) other;
        return Intrinsics.areEqual(this.globalUserUuid, loginUserData.globalUserUuid) && Intrinsics.areEqual(this.userUuid, loginUserData.userUuid) && Intrinsics.areEqual(this.loginName, loginUserData.loginName) && Intrinsics.areEqual(this.photoFileUrl, loginUserData.photoFileUrl) && Intrinsics.areEqual(this.avatarId, loginUserData.avatarId) && Intrinsics.areEqual(this.registerType, loginUserData.registerType) && Intrinsics.areEqual(this.email, loginUserData.email) && Intrinsics.areEqual(this.birthDate, loginUserData.birthDate) && Intrinsics.areEqual(this.gender, loginUserData.gender) && Intrinsics.areEqual(this.firstName, loginUserData.firstName) && Intrinsics.areEqual(this.lastName, loginUserData.lastName) && Intrinsics.areEqual(this.displayName, loginUserData.displayName) && Intrinsics.areEqual(this.weight, loginUserData.weight) && Intrinsics.areEqual(this.measurementUnit, loginUserData.measurementUnit) && Intrinsics.areEqual(this.height, loginUserData.height) && Intrinsics.areEqual(this.enabledPreferenceItems, loginUserData.enabledPreferenceItems);
    }

    public int hashCode() {
        String str = this.globalUserUuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userUuid;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.loginName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.photoFileUrl;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.avatarId;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.registerType;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str6 = this.email;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.birthDate;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.gender;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.firstName;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.lastName;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.displayName;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.weight;
        int iHashCode13 = (iHashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Integer num2 = this.measurementUnit;
        int iHashCode14 = (iHashCode13 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str13 = this.height;
        int iHashCode15 = (iHashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        List<Integer> list = this.enabledPreferenceItems;
        return iHashCode15 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LoginUserData(globalUserUuid=");
        sb.append(this.globalUserUuid).append(", userUuid=").append(this.userUuid).append(", loginName=").append(this.loginName).append(", photoFileUrl=").append(this.photoFileUrl).append(", avatarId=").append(this.avatarId).append(", registerType=").append(this.registerType).append(", email=").append(this.email).append(", birthDate=").append(this.birthDate).append(", gender=").append(this.gender).append(", firstName=").append(this.firstName).append(", lastName=").append(this.lastName).append(", displayName=");
        sb.append(this.displayName).append(", weight=").append(this.weight).append(", measurementUnit=").append(this.measurementUnit).append(", height=").append(this.height).append(", enabledPreferenceItems=").append(this.enabledPreferenceItems).append(')');
        return sb.toString();
    }

    public LoginUserData(String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Integer num2, String str13, List<Integer> list) {
        this.globalUserUuid = str;
        this.userUuid = str2;
        this.loginName = str3;
        this.photoFileUrl = str4;
        this.avatarId = str5;
        this.registerType = num;
        this.email = str6;
        this.birthDate = str7;
        this.gender = str8;
        this.firstName = str9;
        this.lastName = str10;
        this.displayName = str11;
        this.weight = str12;
        this.measurementUnit = num2;
        this.height = str13;
        this.enabledPreferenceItems = list;
    }

    public final String getGlobalUserUuid() {
        return this.globalUserUuid;
    }

    public final String getUserUuid() {
        return this.userUuid;
    }

    public final String getLoginName() {
        return this.loginName;
    }

    public final String getPhotoFileUrl() {
        return this.photoFileUrl;
    }

    public final void setPhotoFileUrl(String str) {
        this.photoFileUrl = str;
    }

    public final String getAvatarId() {
        return this.avatarId;
    }

    public final Integer getRegisterType() {
        return this.registerType;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getBirthDate() {
        return this.birthDate;
    }

    public final void setBirthDate(String str) {
        this.birthDate = str;
    }

    public final String getGender() {
        return this.gender;
    }

    public final void setGender(String str) {
        this.gender = str;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final void setFirstName(String str) {
        this.firstName = str;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final void setLastName(String str) {
        this.lastName = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final String getWeight() {
        return this.weight;
    }

    public final void setWeight(String str) {
        this.weight = str;
    }

    public final Integer getMeasurementUnit() {
        return this.measurementUnit;
    }

    public final void setMeasurementUnit(Integer num) {
        this.measurementUnit = num;
    }

    public final String getHeight() {
        return this.height;
    }

    public final void setHeight(String str) {
        this.height = str;
    }

    public final List<Integer> getEnabledPreferenceItems() {
        return this.enabledPreferenceItems;
    }

    public final void setEnabledPreferenceItems(List<Integer> list) {
        this.enabledPreferenceItems = list;
    }
}
