package com.soletreadmills.sole_v2._data.api.signUp;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegisterMemberApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/signUp/RegisterMemberApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegisterMemberApiData {
    public static final int $stable = 0;

    /* compiled from: RegisterMemberApiData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b(\b\u0007\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fR \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\"\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010\u0013¨\u0006-"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/signUp/RegisterMemberApiData$RequestBodyData;", "", "registerType", "", "loginName", "", "loginPassword", "firstName", "lastName", "displayName", "email", "birthDate", "gender", "weight", "height", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getBirthDate", "()Ljava/lang/String;", "setBirthDate", "(Ljava/lang/String;)V", "getDisplayName", "setDisplayName", "getEmail", "setEmail", "getFirstName", "setFirstName", "getGender", "()Ljava/lang/Integer;", "setGender", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHeight", "setHeight", "getLastName", "setLastName", "getLoginName", "setLoginName", "getLoginPassword", "setLoginPassword", "getRegisterType", "()I", "setRegisterType", "(I)V", "getWeight", "setWeight", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("birthDate")
        private String birthDate;

        @SerializedName("displayName")
        private String displayName;

        @SerializedName("email")
        private String email;

        @SerializedName("firstName")
        private String firstName;

        @SerializedName("gender")
        private Integer gender;

        @SerializedName("height")
        private String height;

        @SerializedName("lastName")
        private String lastName;

        @SerializedName("loginName")
        private String loginName;

        @SerializedName("loginPassword")
        private String loginPassword;

        @SerializedName("registerType")
        private int registerType;

        @SerializedName("weight")
        private String weight;

        public RequestBodyData(int i, String loginName, String loginPassword, String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7) {
            Intrinsics.checkNotNullParameter(loginName, "loginName");
            Intrinsics.checkNotNullParameter(loginPassword, "loginPassword");
            this.registerType = i;
            this.loginName = loginName;
            this.loginPassword = loginPassword;
            this.firstName = str;
            this.lastName = str2;
            this.displayName = str3;
            this.email = str4;
            this.birthDate = str5;
            this.gender = num;
            this.weight = str6;
            this.height = str7;
        }

        public /* synthetic */ RequestBodyData(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, String str8, String str9, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? null : num, (i2 & 512) != 0 ? null : str8, (i2 & 1024) != 0 ? null : str9);
        }

        public final int getRegisterType() {
            return this.registerType;
        }

        public final void setRegisterType(int i) {
            this.registerType = i;
        }

        public final String getLoginName() {
            return this.loginName;
        }

        public final void setLoginName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.loginName = str;
        }

        public final String getLoginPassword() {
            return this.loginPassword;
        }

        public final void setLoginPassword(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.loginPassword = str;
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

        public final String getEmail() {
            return this.email;
        }

        public final void setEmail(String str) {
            this.email = str;
        }

        public final String getBirthDate() {
            return this.birthDate;
        }

        public final void setBirthDate(String str) {
            this.birthDate = str;
        }

        public final Integer getGender() {
            return this.gender;
        }

        public final void setGender(Integer num) {
            this.gender = num;
        }

        public final String getWeight() {
            return this.weight;
        }

        public final void setWeight(String str) {
            this.weight = str;
        }

        public final String getHeight() {
            return this.height;
        }

        public final void setHeight(String str) {
            this.height = str;
        }
    }

    /* compiled from: RegisterMemberApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/signUp/RegisterMemberApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/signUp/RegisterMemberApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/signUp/RegisterMemberApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/signUp/RegisterMemberApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 8;

        @SerializedName("dataMap")
        private DataMap dataMap;

        public final DataMap getDataMap() {
            return this.dataMap;
        }

        public final void setDataMap(DataMap dataMap) {
            this.dataMap = dataMap;
        }
    }

    /* compiled from: RegisterMemberApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/signUp/RegisterMemberApiData$DataMap;", "", "loginToken", "", "(Ljava/lang/String;)V", "getLoginToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 0;

        @SerializedName("loginToken")
        private final String loginToken;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dataMap.loginToken;
            }
            return dataMap.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLoginToken() {
            return this.loginToken;
        }

        public final DataMap copy(String loginToken) {
            return new DataMap(loginToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.loginToken, ((DataMap) other).loginToken);
        }

        public int hashCode() {
            String str = this.loginToken;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "DataMap(loginToken=" + this.loginToken + ')';
        }

        public DataMap(String str) {
            this.loginToken = str;
        }

        public /* synthetic */ DataMap(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getLoginToken() {
            return this.loginToken;
        }
    }
}
