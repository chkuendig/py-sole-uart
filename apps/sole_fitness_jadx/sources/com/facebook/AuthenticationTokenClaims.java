package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.dyaco.sole.R2;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthenticationTokenClaims.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 M2\u00020\u0001:\u0001MB\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0085\u0002\b\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001eB\u000f\b\u0010\u0012\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!J\b\u0010;\u001a\u00020\u0019H\u0016J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0096\u0002J\b\u0010@\u001a\u00020\u0019H\u0016J\u0018\u0010A\u001a\u00020=2\u0006\u0010B\u001a\u00020C2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010D\u001a\u00020\u0003H\u0007J\r\u0010E\u001a\u00020CH\u0001¢\u0006\u0002\bFJ\b\u0010G\u001a\u00020\u0003H\u0016J\u0018\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020 2\u0006\u0010K\u001a\u00020\u0019H\u0016J\u0016\u0010L\u001a\u0004\u0018\u00010\u0003*\u00020C2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u001f\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u000104¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010#R\u001f\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b8\u00102R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010#R\u001f\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b:\u00102¨\u0006N"}, d2 = {"Lcom/facebook/AuthenticationTokenClaims;", "Landroid/os/Parcelable;", "encodedClaims", "", "expectedNonce", "(Ljava/lang/String;Ljava/lang/String;)V", "jti", "iss", "aud", ServerProtocol.DIALOG_PARAM_NONCE, "exp", "", "iat", "sub", "name", "givenName", "middleName", "familyName", "email", "picture", "userFriends", "", "userBirthday", "userAgeRange", "", "", "userHometown", "userLocation", "userGender", "userLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAud", "()Ljava/lang/String;", "getEmail", "getExp", "()J", "getFamilyName", "getGivenName", "getIat", "getIss", "getJti", "getMiddleName", "getName", "getNonce", "getPicture", "getSub", "getUserAgeRange", "()Ljava/util/Map;", "getUserBirthday", "", "getUserFriends", "()Ljava/util/Set;", "getUserGender", "getUserHometown", "getUserLink", "getUserLocation", "describeContents", "equals", "", "other", "", "hashCode", "isValidClaims", "claimsJson", "Lorg/json/JSONObject;", "toEnCodedString", "toJSONObject", "toJSONObject$facebook_core_release", "toString", "writeToParcel", "", "dest", "flags", "getNullableString", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AuthenticationTokenClaims implements Parcelable {
    public static final long MAX_TIME_SINCE_TOKEN_ISSUED = 600000;
    private final String aud;
    private final String email;
    private final long exp;
    private final String familyName;
    private final String givenName;
    private final long iat;
    private final String iss;
    private final String jti;
    private final String middleName;
    private final String name;
    private final String nonce;
    private final String picture;
    private final String sub;
    private final Map<String, Integer> userAgeRange;
    private final String userBirthday;
    private final Set<String> userFriends;
    private final String userGender;
    private final Map<String, String> userHometown;
    private final String userLink;
    private final Map<String, String> userLocation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<AuthenticationTokenClaims> CREATOR = new Parcelable.Creator<AuthenticationTokenClaims>() { // from class: com.facebook.AuthenticationTokenClaims$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthenticationTokenClaims createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new AuthenticationTokenClaims(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthenticationTokenClaims[] newArray(int size) {
            return new AuthenticationTokenClaims[size];
        }
    };

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5) {
        this(str, str2, str3, str4, j, j2, str5, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048448, null);
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6) {
        this(str, str2, str3, str4, j, j2, str5, str6, null, null, null, null, null, null, null, null, null, null, null, null, 1048320, null);
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, null, null, null, null, null, null, null, null, null, null, null, 1048064, null);
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, str8, null, null, null, null, null, null, null, null, null, null, 1047552, null);
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, str8, str9, null, null, null, null, null, null, null, null, null, 1046528, null);
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9, String str10) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, str8, str9, str10, null, null, null, null, null, null, null, null, 1044480, null);
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, str8, str9, str10, str11, null, null, null, null, null, null, null, 1040384, null);
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Collection<String> collection) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, str8, str9, str10, str11, collection, null, null, null, null, null, null, 1032192, null);
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Collection<String> collection, String str12) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, str8, str9, str10, str11, collection, str12, null, null, null, null, null, 1015808, null);
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Collection<String> collection, String str12, Map<String, Integer> map) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, str8, str9, str10, str11, collection, str12, map, null, null, null, null, 983040, null);
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Collection<String> collection, String str12, Map<String, Integer> map, Map<String, String> map2) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, str8, str9, str10, str11, collection, str12, map, map2, null, null, null, 917504, null);
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Collection<String> collection, String str12, Map<String, Integer> map, Map<String, String> map2, Map<String, String> map3) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, str8, str9, str10, str11, collection, str12, map, map2, map3, null, null, 786432, null);
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Collection<String> collection, String str12, Map<String, Integer> map, Map<String, String> map2, Map<String, String> map3, String str13) {
        this(str, str2, str3, str4, j, j2, str5, str6, str7, str8, str9, str10, str11, collection, str12, map, map2, map3, str13, null, 524288, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getJti() {
        return this.jti;
    }

    public final String getIss() {
        return this.iss;
    }

    public final String getAud() {
        return this.aud;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final long getExp() {
        return this.exp;
    }

    public final long getIat() {
        return this.iat;
    }

    public final String getSub() {
        return this.sub;
    }

    public final String getName() {
        return this.name;
    }

    public final String getGivenName() {
        return this.givenName;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final String getFamilyName() {
        return this.familyName;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final Set<String> getUserFriends() {
        return this.userFriends;
    }

    public final String getUserBirthday() {
        return this.userBirthday;
    }

    public final Map<String, Integer> getUserAgeRange() {
        return this.userAgeRange;
    }

    public final Map<String, String> getUserHometown() {
        return this.userHometown;
    }

    public final Map<String, String> getUserLocation() {
        return this.userLocation;
    }

    public final String getUserGender() {
        return this.userGender;
    }

    public final String getUserLink() {
        return this.userLink;
    }

    public AuthenticationTokenClaims(String encodedClaims, String expectedNonce) throws JSONException {
        Intrinsics.checkNotNullParameter(encodedClaims, "encodedClaims");
        Intrinsics.checkNotNullParameter(expectedNonce, "expectedNonce");
        Validate.notEmpty(encodedClaims, "encodedClaims");
        byte[] decodedBytes = Base64.decode(encodedClaims, 0);
        Intrinsics.checkNotNullExpressionValue(decodedBytes, "decodedBytes");
        JSONObject jSONObject = new JSONObject(new String(decodedBytes, Charsets.UTF_8));
        if (!isValidClaims(jSONObject, expectedNonce)) {
            throw new IllegalArgumentException("Invalid claims".toString());
        }
        String string = jSONObject.getString("jti");
        Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(\"jti\")");
        this.jti = string;
        String string2 = jSONObject.getString("iss");
        Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getString(\"iss\")");
        this.iss = string2;
        String string3 = jSONObject.getString("aud");
        Intrinsics.checkNotNullExpressionValue(string3, "jsonObj.getString(\"aud\")");
        this.aud = string3;
        String string4 = jSONObject.getString(ServerProtocol.DIALOG_PARAM_NONCE);
        Intrinsics.checkNotNullExpressionValue(string4, "jsonObj.getString(\"nonce\")");
        this.nonce = string4;
        this.exp = jSONObject.getLong("exp");
        this.iat = jSONObject.getLong("iat");
        String string5 = jSONObject.getString("sub");
        Intrinsics.checkNotNullExpressionValue(string5, "jsonObj.getString(\"sub\")");
        this.sub = string5;
        this.name = getNullableString(jSONObject, "name");
        this.givenName = getNullableString(jSONObject, "givenName");
        this.middleName = getNullableString(jSONObject, "middleName");
        this.familyName = getNullableString(jSONObject, "familyName");
        this.email = getNullableString(jSONObject, "email");
        this.picture = getNullableString(jSONObject, "picture");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("userFriends");
        this.userFriends = jSONArrayOptJSONArray == null ? null : Collections.unmodifiableSet(Utility.jsonArrayToSet(jSONArrayOptJSONArray));
        this.userBirthday = getNullableString(jSONObject, "userBirthday");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("userAgeRange");
        this.userAgeRange = jSONObjectOptJSONObject == null ? null : Collections.unmodifiableMap(Utility.convertJSONObjectToHashMap(jSONObjectOptJSONObject));
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("userHometown");
        this.userHometown = jSONObjectOptJSONObject2 == null ? null : Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(jSONObjectOptJSONObject2));
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("userLocation");
        this.userLocation = jSONObjectOptJSONObject3 != null ? Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(jSONObjectOptJSONObject3)) : null;
        this.userGender = getNullableString(jSONObject, "userGender");
        this.userLink = getNullableString(jSONObject, "userLink");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Collection collection, String str12, Map map, Map map2, Map map3, String str13, String str14, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        Collection collection2;
        String str21;
        Map map4;
        Map map5;
        Map map6;
        String str22;
        String str23;
        if ((i & 128) != 0) {
            str15 = null;
        } else {
            str15 = str6;
        }
        if ((i & 256) != 0) {
            str16 = null;
        } else {
            str16 = str7;
        }
        if ((i & 512) != 0) {
            str17 = null;
        } else {
            str17 = str8;
        }
        if ((i & 1024) != 0) {
            str18 = null;
        } else {
            str18 = str9;
        }
        if ((i & 2048) != 0) {
            str19 = null;
        } else {
            str19 = str10;
        }
        if ((i & 4096) != 0) {
            str20 = null;
        } else {
            str20 = str11;
        }
        if ((i & 8192) != 0) {
            collection2 = null;
        } else {
            collection2 = collection;
        }
        if ((i & 16384) != 0) {
            str21 = null;
        } else {
            str21 = str12;
        }
        if ((32768 & i) != 0) {
            map4 = null;
        } else {
            map4 = map;
        }
        if ((65536 & i) != 0) {
            map5 = null;
        } else {
            map5 = map2;
        }
        if ((131072 & i) != 0) {
            map6 = null;
        } else {
            map6 = map3;
        }
        if ((262144 & i) != 0) {
            str22 = null;
        } else {
            str22 = str13;
        }
        if ((i & 524288) != 0) {
            str23 = null;
        } else {
            str23 = str14;
        }
        this(str, str2, str3, str4, j, j2, str5, str15, str16, str17, str18, str19, str20, collection2, str21, map4, map5, map6, str22, str23);
    }

    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j, long j2, String sub, String str, String str2, String str3, String str4, String str5, String str6, Collection<String> collection, String str7, Map<String, Integer> map, Map<String, String> map2, Map<String, String> map3, String str8, String str9) {
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
        Validate.notEmpty(jti, "jti");
        Validate.notEmpty(iss, "iss");
        Validate.notEmpty(aud, "aud");
        Validate.notEmpty(nonce, ServerProtocol.DIALOG_PARAM_NONCE);
        Validate.notEmpty(sub, "sub");
        this.jti = jti;
        this.iss = iss;
        this.aud = aud;
        this.nonce = nonce;
        this.exp = j;
        this.iat = j2;
        this.sub = sub;
        this.name = str;
        this.givenName = str2;
        this.middleName = str3;
        this.familyName = str4;
        this.email = str5;
        this.picture = str6;
        this.userFriends = collection != null ? Collections.unmodifiableSet(new HashSet(collection)) : null;
        this.userBirthday = str7;
        this.userAgeRange = map != null ? Collections.unmodifiableMap(new HashMap(map)) : null;
        this.userHometown = map2 != null ? Collections.unmodifiableMap(new HashMap(map2)) : null;
        this.userLocation = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
        this.userGender = str8;
        this.userLink = str9;
    }

    public AuthenticationTokenClaims(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        Validate.notNullOrEmpty(string, "jti");
        if (string != null) {
            this.jti = string;
            String string2 = parcel.readString();
            Validate.notNullOrEmpty(string2, "iss");
            if (string2 != null) {
                this.iss = string2;
                String string3 = parcel.readString();
                Validate.notNullOrEmpty(string3, "aud");
                if (string3 != null) {
                    this.aud = string3;
                    String string4 = parcel.readString();
                    Validate.notNullOrEmpty(string4, ServerProtocol.DIALOG_PARAM_NONCE);
                    if (string4 != null) {
                        this.nonce = string4;
                        this.exp = parcel.readLong();
                        this.iat = parcel.readLong();
                        String string5 = parcel.readString();
                        Validate.notNullOrEmpty(string5, "sub");
                        if (string5 != null) {
                            this.sub = string5;
                            this.name = parcel.readString();
                            this.givenName = parcel.readString();
                            this.middleName = parcel.readString();
                            this.familyName = parcel.readString();
                            this.email = parcel.readString();
                            this.picture = parcel.readString();
                            ArrayList arrayList = new ArrayList();
                            parcel.readStringList(arrayList);
                            this.userFriends = Collections.unmodifiableSet(new HashSet(arrayList));
                            this.userBirthday = parcel.readString();
                            HashMap hashMap = parcel.readHashMap(IntCompanionObject.INSTANCE.getClass().getClassLoader());
                            this.userAgeRange = Collections.unmodifiableMap(hashMap instanceof HashMap ? hashMap : null);
                            HashMap hashMap2 = parcel.readHashMap(StringCompanionObject.INSTANCE.getClass().getClassLoader());
                            this.userHometown = Collections.unmodifiableMap(hashMap2 instanceof HashMap ? hashMap2 : null);
                            HashMap hashMap3 = parcel.readHashMap(StringCompanionObject.INSTANCE.getClass().getClassLoader());
                            this.userLocation = Collections.unmodifiableMap(hashMap3 instanceof HashMap ? hashMap3 : null);
                            this.userGender = parcel.readString();
                            this.userLink = parcel.readString();
                            return;
                        }
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.jti);
        dest.writeString(this.iss);
        dest.writeString(this.aud);
        dest.writeString(this.nonce);
        dest.writeLong(this.exp);
        dest.writeLong(this.iat);
        dest.writeString(this.sub);
        dest.writeString(this.name);
        dest.writeString(this.givenName);
        dest.writeString(this.middleName);
        dest.writeString(this.familyName);
        dest.writeString(this.email);
        dest.writeString(this.picture);
        if (this.userFriends == null) {
            dest.writeStringList(null);
        } else {
            dest.writeStringList(new ArrayList(this.userFriends));
        }
        dest.writeString(this.userBirthday);
        dest.writeMap(this.userAgeRange);
        dest.writeMap(this.userHometown);
        dest.writeMap(this.userLocation);
        dest.writeString(this.userGender);
        dest.writeString(this.userLink);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthenticationTokenClaims)) {
            return false;
        }
        AuthenticationTokenClaims authenticationTokenClaims = (AuthenticationTokenClaims) other;
        return Intrinsics.areEqual(this.jti, authenticationTokenClaims.jti) && Intrinsics.areEqual(this.iss, authenticationTokenClaims.iss) && Intrinsics.areEqual(this.aud, authenticationTokenClaims.aud) && Intrinsics.areEqual(this.nonce, authenticationTokenClaims.nonce) && this.exp == authenticationTokenClaims.exp && this.iat == authenticationTokenClaims.iat && Intrinsics.areEqual(this.sub, authenticationTokenClaims.sub) && Intrinsics.areEqual(this.name, authenticationTokenClaims.name) && Intrinsics.areEqual(this.givenName, authenticationTokenClaims.givenName) && Intrinsics.areEqual(this.middleName, authenticationTokenClaims.middleName) && Intrinsics.areEqual(this.familyName, authenticationTokenClaims.familyName) && Intrinsics.areEqual(this.email, authenticationTokenClaims.email) && Intrinsics.areEqual(this.picture, authenticationTokenClaims.picture) && Intrinsics.areEqual(this.userFriends, authenticationTokenClaims.userFriends) && Intrinsics.areEqual(this.userBirthday, authenticationTokenClaims.userBirthday) && Intrinsics.areEqual(this.userAgeRange, authenticationTokenClaims.userAgeRange) && Intrinsics.areEqual(this.userHometown, authenticationTokenClaims.userHometown) && Intrinsics.areEqual(this.userLocation, authenticationTokenClaims.userLocation) && Intrinsics.areEqual(this.userGender, authenticationTokenClaims.userGender) && Intrinsics.areEqual(this.userLink, authenticationTokenClaims.userLink);
    }

    public int hashCode() {
        int iHashCode = (((((((((((((R2.attr.quantizeMotionSteps + this.jti.hashCode()) * 31) + this.iss.hashCode()) * 31) + this.aud.hashCode()) * 31) + this.nonce.hashCode()) * 31) + Long.valueOf(this.exp).hashCode()) * 31) + Long.valueOf(this.iat).hashCode()) * 31) + this.sub.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.givenName;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.middleName;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.familyName;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.email;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.picture;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Set<String> set = this.userFriends;
        int iHashCode8 = (iHashCode7 + (set != null ? set.hashCode() : 0)) * 31;
        String str7 = this.userBirthday;
        int iHashCode9 = (iHashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Map<String, Integer> map = this.userAgeRange;
        int iHashCode10 = (iHashCode9 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, String> map2 = this.userHometown;
        int iHashCode11 = (iHashCode10 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<String, String> map3 = this.userLocation;
        int iHashCode12 = (iHashCode11 + (map3 != null ? map3.hashCode() : 0)) * 31;
        String str8 = this.userGender;
        int iHashCode13 = (iHashCode12 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.userLink;
        return iHashCode13 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        String string = toJSONObject$facebook_core_release().toString();
        Intrinsics.checkNotNullExpressionValue(string, "claimsJsonObject.toString()");
        return string;
    }

    private final boolean isValidClaims(JSONObject claimsJson, String expectedNonce) {
        if (claimsJson == null) {
            return false;
        }
        String jti = claimsJson.optString("jti");
        Intrinsics.checkNotNullExpressionValue(jti, "jti");
        if (jti.length() == 0) {
            return false;
        }
        try {
            String iss = claimsJson.optString("iss");
            Intrinsics.checkNotNullExpressionValue(iss, "iss");
            if (!(iss.length() == 0)) {
                if (!(!Intrinsics.areEqual(new URL(iss).getHost(), FacebookSdk.FACEBOOK_COM))) {
                    String aud = claimsJson.optString("aud");
                    Intrinsics.checkNotNullExpressionValue(aud, "aud");
                    if (!(aud.length() == 0) && !(!Intrinsics.areEqual(aud, FacebookSdk.getApplicationId()))) {
                        long j = 1000;
                        if (new Date().after(new Date(claimsJson.optLong("exp") * j))) {
                            return false;
                        }
                        if (new Date().after(new Date((claimsJson.optLong("iat") * j) + MAX_TIME_SINCE_TOKEN_ISSUED))) {
                            return false;
                        }
                        String sub = claimsJson.optString("sub");
                        Intrinsics.checkNotNullExpressionValue(sub, "sub");
                        if (sub.length() == 0) {
                            return false;
                        }
                        String nonce = claimsJson.optString(ServerProtocol.DIALOG_PARAM_NONCE);
                        Intrinsics.checkNotNullExpressionValue(nonce, "nonce");
                        if (!(nonce.length() == 0) && !(!Intrinsics.areEqual(nonce, expectedNonce))) {
                            return true;
                        }
                    }
                }
            }
        } catch (MalformedURLException unused) {
        }
        return false;
    }

    public final String toEnCodedString() {
        String string = toString();
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = string.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 0);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "Base64.encodeToString(cl…eArray(), Base64.DEFAULT)");
        return strEncodeToString;
    }

    public final JSONObject toJSONObject$facebook_core_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("jti", this.jti);
        jSONObject.put("iss", this.iss);
        jSONObject.put("aud", this.aud);
        jSONObject.put(ServerProtocol.DIALOG_PARAM_NONCE, this.nonce);
        jSONObject.put("exp", this.exp);
        jSONObject.put("iat", this.iat);
        String str = this.sub;
        if (str != null) {
            jSONObject.put("sub", str);
        }
        String str2 = this.name;
        if (str2 != null) {
            jSONObject.put("name", str2);
        }
        String str3 = this.givenName;
        if (str3 != null) {
            jSONObject.put("givenName", str3);
        }
        String str4 = this.middleName;
        if (str4 != null) {
            jSONObject.put("middleName", str4);
        }
        String str5 = this.familyName;
        if (str5 != null) {
            jSONObject.put("familyName", str5);
        }
        String str6 = this.email;
        if (str6 != null) {
            jSONObject.put("email", str6);
        }
        String str7 = this.picture;
        if (str7 != null) {
            jSONObject.put("picture", str7);
        }
        if (this.userFriends != null && (!r1.isEmpty())) {
            jSONObject.put("userFriends", new JSONArray((Collection) this.userFriends));
        }
        String str8 = this.userBirthday;
        if (str8 != null) {
            jSONObject.put("userBirthday", str8);
        }
        if (this.userAgeRange != null && (!r1.isEmpty())) {
            jSONObject.put("userAgeRange", new JSONObject(this.userAgeRange));
        }
        if (this.userHometown != null && (!r1.isEmpty())) {
            jSONObject.put("userHometown", new JSONObject(this.userHometown));
        }
        if (this.userLocation != null && (!r1.isEmpty())) {
            jSONObject.put("userLocation", new JSONObject(this.userLocation));
        }
        String str9 = this.userGender;
        if (str9 != null) {
            jSONObject.put("userGender", str9);
        }
        String str10 = this.userLink;
        if (str10 != null) {
            jSONObject.put("userLink", str10);
        }
        return jSONObject;
    }

    private final String getNullableString(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return jSONObject.getString(str);
        }
        return null;
    }

    /* compiled from: AuthenticationTokenClaims.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/AuthenticationTokenClaims$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AuthenticationTokenClaims;", "MAX_TIME_SINCE_TOKEN_ISSUED", "", "createFromJSONObject", "jsonObject", "Lorg/json/JSONObject;", "createFromJSONObject$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AuthenticationTokenClaims createFromJSONObject$facebook_core_release(JSONObject jsonObject) throws JSONException {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            String jti = jsonObject.getString("jti");
            String iss = jsonObject.getString("iss");
            String aud = jsonObject.getString("aud");
            String nonce = jsonObject.getString(ServerProtocol.DIALOG_PARAM_NONCE);
            long j = jsonObject.getLong("exp");
            long j2 = jsonObject.getLong("iat");
            String sub = jsonObject.getString("sub");
            String strOptString = jsonObject.optString("name");
            String strOptString2 = jsonObject.optString("givenName");
            String strOptString3 = jsonObject.optString("middleName");
            String strOptString4 = jsonObject.optString("familyName");
            String strOptString5 = jsonObject.optString("email");
            String strOptString6 = jsonObject.optString("picture");
            JSONArray jSONArrayOptJSONArray = jsonObject.optJSONArray("userFriends");
            String strOptString7 = jsonObject.optString("userBirthday");
            JSONObject jSONObjectOptJSONObject = jsonObject.optJSONObject("userAgeRange");
            JSONObject jSONObjectOptJSONObject2 = jsonObject.optJSONObject("userHometown");
            JSONObject jSONObjectOptJSONObject3 = jsonObject.optJSONObject("userLocation");
            String strOptString8 = jsonObject.optString("userGender");
            String strOptString9 = jsonObject.optString("userLink");
            Intrinsics.checkNotNullExpressionValue(jti, "jti");
            Intrinsics.checkNotNullExpressionValue(iss, "iss");
            Intrinsics.checkNotNullExpressionValue(aud, "aud");
            Intrinsics.checkNotNullExpressionValue(nonce, "nonce");
            Intrinsics.checkNotNullExpressionValue(sub, "sub");
            String str = strOptString;
            if (str == null || str.length() == 0) {
                strOptString = null;
            }
            String str2 = strOptString2;
            String str3 = str2 == null || str2.length() == 0 ? null : strOptString2;
            String str4 = strOptString3;
            String str5 = str4 == null || str4.length() == 0 ? null : strOptString3;
            String str6 = strOptString4;
            String str7 = str6 == null || str6.length() == 0 ? null : strOptString4;
            String str8 = strOptString5;
            if (str8 == null || str8.length() == 0) {
                strOptString5 = null;
            }
            String str9 = strOptString6;
            if (str9 == null || str9.length() == 0) {
                strOptString6 = null;
            }
            List<String> listJsonArrayToStringList = jSONArrayOptJSONArray == null ? null : Utility.jsonArrayToStringList(jSONArrayOptJSONArray);
            String str10 = strOptString7;
            if (str10 == null || str10.length() == 0) {
                strOptString7 = null;
            }
            Map<String, Object> mapConvertJSONObjectToHashMap = jSONObjectOptJSONObject == null ? null : Utility.convertJSONObjectToHashMap(jSONObjectOptJSONObject);
            Map<String, String> mapConvertJSONObjectToStringMap = jSONObjectOptJSONObject2 == null ? null : Utility.convertJSONObjectToStringMap(jSONObjectOptJSONObject2);
            Map<String, String> mapConvertJSONObjectToStringMap2 = jSONObjectOptJSONObject3 == null ? null : Utility.convertJSONObjectToStringMap(jSONObjectOptJSONObject3);
            String str11 = strOptString8;
            if (str11 == null || str11.length() == 0) {
                strOptString8 = null;
            }
            String str12 = strOptString9;
            if (str12 == null || str12.length() == 0) {
                strOptString9 = null;
            }
            return new AuthenticationTokenClaims(jti, iss, aud, nonce, j, j2, sub, strOptString, str3, str5, str7, strOptString5, strOptString6, listJsonArrayToStringList, strOptString7, mapConvertJSONObjectToHashMap, mapConvertJSONObjectToStringMap, mapConvertJSONObjectToStringMap2, strOptString8, strOptString9);
        }
    }
}
