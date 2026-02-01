package com.soletreadmills.sole_v2._data.club;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChallengeItemSimpleData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;", "", "nickName", "", "photoUrl", "avatarId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarId", "()Ljava/lang/String;", "setAvatarId", "(Ljava/lang/String;)V", "getNickName", "setNickName", "getPhotoUrl", "setPhotoUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ChallengeUserSimpleInfo {
    public static final int $stable = 8;

    @SerializedName("avatarId")
    private String avatarId;

    @SerializedName("nickName")
    private String nickName;

    @SerializedName("photoUrl")
    private String photoUrl;

    public static /* synthetic */ ChallengeUserSimpleInfo copy$default(ChallengeUserSimpleInfo challengeUserSimpleInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = challengeUserSimpleInfo.nickName;
        }
        if ((i & 2) != 0) {
            str2 = challengeUserSimpleInfo.photoUrl;
        }
        if ((i & 4) != 0) {
            str3 = challengeUserSimpleInfo.avatarId;
        }
        return challengeUserSimpleInfo.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAvatarId() {
        return this.avatarId;
    }

    public final ChallengeUserSimpleInfo copy(String nickName, String photoUrl, String avatarId) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        return new ChallengeUserSimpleInfo(nickName, photoUrl, avatarId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChallengeUserSimpleInfo)) {
            return false;
        }
        ChallengeUserSimpleInfo challengeUserSimpleInfo = (ChallengeUserSimpleInfo) other;
        return Intrinsics.areEqual(this.nickName, challengeUserSimpleInfo.nickName) && Intrinsics.areEqual(this.photoUrl, challengeUserSimpleInfo.photoUrl) && Intrinsics.areEqual(this.avatarId, challengeUserSimpleInfo.avatarId);
    }

    public int hashCode() {
        int iHashCode = this.nickName.hashCode() * 31;
        String str = this.photoUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.avatarId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ChallengeUserSimpleInfo(nickName=" + this.nickName + ", photoUrl=" + this.photoUrl + ", avatarId=" + this.avatarId + ')';
    }

    public ChallengeUserSimpleInfo(String nickName, String str, String str2) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        this.nickName = nickName;
        this.photoUrl = str;
        this.avatarId = str2;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void setNickName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickName = str;
    }

    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    public final void setPhotoUrl(String str) {
        this.photoUrl = str;
    }

    public final String getAvatarId() {
        return this.avatarId;
    }

    public final void setAvatarId(String str) {
        this.avatarId = str;
    }
}
