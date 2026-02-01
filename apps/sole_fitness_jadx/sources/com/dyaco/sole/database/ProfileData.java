package com.dyaco.sole.database;

/* loaded from: classes.dex */
public class ProfileData {
    public static final String NAME = "name";
    public static final String PROFILE = "profile";
    public static final String PROFILE_COUNT = "profile_count";
    public static final String PROFILE_ID = "profile_id";
    public static final String PROFILE_TB_NAME = "profile";
    private String profile;
    private int profileId;

    public int getProfileId() {
        return this.profileId;
    }

    public void setProfileId(int i) {
        this.profileId = i;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String str) {
        this.profile = str;
    }
}
