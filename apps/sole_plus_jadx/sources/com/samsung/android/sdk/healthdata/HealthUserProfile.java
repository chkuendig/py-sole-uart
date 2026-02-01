package com.samsung.android.sdk.healthdata;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.RemoteException;
import com.samsung.android.sdk.internal.healthdata.ErrorUtil;
import com.samsung.android.sdk.internal.healthdata.RemoteConnectionException;

/* loaded from: classes5.dex */
public class HealthUserProfile {
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final String USER_PROFILE_KEY_BIRTH_DATE = "birth_date";
    public static final String USER_PROFILE_KEY_GENDER = "gender";
    public static final String USER_PROFILE_KEY_HEIGHT = "height";
    public static final String USER_PROFILE_KEY_IMAGE = "image";
    public static final String USER_PROFILE_KEY_USER_ID = "user_id";
    public static final String USER_PROFILE_KEY_USER_NAME = "name";
    public static final String USER_PROFILE_KEY_WEIGHT = "weight";
    private final String a;
    private final float b;
    private final float c;
    private final String d;
    private final int e;
    private final String f;
    private final Bitmap g;

    private HealthUserProfile(String str, float f, float f2, String str2, int i, String str3, Bitmap bitmap) {
        this.a = str;
        this.b = f;
        this.c = f2;
        this.d = str2;
        this.e = i;
        this.f = str3;
        this.g = bitmap;
    }

    public static HealthUserProfile getProfile(HealthDataStore healthDataStore) {
        try {
            Bundle userProfile2 = HealthDataStore.getInterface(healthDataStore).getUserProfile2(healthDataStore.a().getPackageName());
            if (userProfile2 == null) {
                throw new IllegalStateException("profileBundle is null");
            }
            String string = userProfile2.getString(USER_PROFILE_KEY_BIRTH_DATE);
            float f = userProfile2.getFloat("height", 0.0f);
            float f2 = userProfile2.getFloat("weight", 0.0f);
            String string2 = userProfile2.getString("user_id");
            int i = userProfile2.getInt("gender", 0);
            String string3 = userProfile2.getString("name");
            byte[] byteArray = userProfile2.getByteArray("image");
            return new HealthUserProfile(string, f, f2, string2, i, string3, byteArray == null ? null : BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
        } catch (RemoteException e) {
            throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
        }
    }

    public String getBirthDate() {
        return this.a;
    }

    public int getGender() {
        return this.e;
    }

    public float getHeight() {
        return this.b;
    }

    @Deprecated
    public Bitmap getImage() {
        return this.g;
    }

    @Deprecated
    public String getUserId() {
        return this.d;
    }

    public String getUserName() {
        return this.f;
    }

    public float getWeight() {
        return this.c;
    }
}
