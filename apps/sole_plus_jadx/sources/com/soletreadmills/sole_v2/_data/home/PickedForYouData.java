package com.soletreadmills.sole_v2._data.home;

import com.google.gson.annotations.SerializedName;
import com.sun.jna.platform.win32.WinNT;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PickedForYouData.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0014¢\u0006\u0002\u0010\u001cJ\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010-J\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010-J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0014HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u008a\u0002\u0010I\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020\u00032\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020NHÖ\u0001J\t\u0010O\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0004\u0010-R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0002\u0010-R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010 R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 ¨\u0006P"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/home/PickedForYouData;", "", "isFavorite", "", "isDone", "classId", "", "className", "classType", "classTypeName", "classTypeIconUrl", "backgroundUrl", "instructorName", "instructorAvatarUrl", "duration", "description", "favoriteId", "videoId", "difficulty", "accessories", "", "Lcom/soletreadmills/sole_v2/_data/home/PickedForYouAccessoryData;", "musicGenre", "workoutType", "publishTimeMillis", "", "collections", "Lcom/soletreadmills/sole_v2/_data/home/PickedForYouCollectionsData;", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;)V", "getAccessories", "()Ljava/util/List;", "getBackgroundUrl", "()Ljava/lang/String;", "getClassId", "getClassName", "getClassType", "getClassTypeIconUrl", "getClassTypeName", "getCollections", "getDescription", "getDifficulty", "getDuration", "getFavoriteId", "getInstructorAvatarUrl", "getInstructorName", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMusicGenre", "getPublishTimeMillis", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVideoId", "getWorkoutType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;)Lcom/soletreadmills/sole_v2/_data/home/PickedForYouData;", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PickedForYouData {
    public static final int $stable = 8;

    @SerializedName("accessories")
    private final List<PickedForYouAccessoryData> accessories;

    @SerializedName("background_url")
    private final String backgroundUrl;

    @SerializedName("class_id")
    private final String classId;

    @SerializedName("class_name")
    private final String className;

    @SerializedName("class_type")
    private final String classType;

    @SerializedName("class_type_icon_url")
    private final String classTypeIconUrl;

    @SerializedName("class_type_name")
    private final String classTypeName;

    @SerializedName("collections")
    private final List<PickedForYouCollectionsData> collections;

    @SerializedName("description")
    private final String description;

    @SerializedName("difficulty")
    private final String difficulty;

    @SerializedName("duration")
    private final String duration;

    @SerializedName("favorite_id")
    private final String favoriteId;

    @SerializedName("instructor_avatar_url")
    private final String instructorAvatarUrl;

    @SerializedName("instructor_name")
    private final String instructorName;

    @SerializedName("is_done")
    private final Boolean isDone;

    @SerializedName("is_favorite")
    private final Boolean isFavorite;

    @SerializedName("music_genre")
    private final String musicGenre;

    @SerializedName("publish_time_millis")
    private final Double publishTimeMillis;

    @SerializedName("video_id")
    private final String videoId;

    @SerializedName("workout_type")
    private final String workoutType;

    public PickedForYouData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, WinNT.NLS_VALID_LOCALE_MASK, null);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getIsFavorite() {
        return this.isFavorite;
    }

    /* renamed from: component10, reason: from getter */
    public final String getInstructorAvatarUrl() {
        return this.instructorAvatarUrl;
    }

    /* renamed from: component11, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* renamed from: component12, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component13, reason: from getter */
    public final String getFavoriteId() {
        return this.favoriteId;
    }

    /* renamed from: component14, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    /* renamed from: component15, reason: from getter */
    public final String getDifficulty() {
        return this.difficulty;
    }

    public final List<PickedForYouAccessoryData> component16() {
        return this.accessories;
    }

    /* renamed from: component17, reason: from getter */
    public final String getMusicGenre() {
        return this.musicGenre;
    }

    /* renamed from: component18, reason: from getter */
    public final String getWorkoutType() {
        return this.workoutType;
    }

    /* renamed from: component19, reason: from getter */
    public final Double getPublishTimeMillis() {
        return this.publishTimeMillis;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getIsDone() {
        return this.isDone;
    }

    public final List<PickedForYouCollectionsData> component20() {
        return this.collections;
    }

    /* renamed from: component3, reason: from getter */
    public final String getClassId() {
        return this.classId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* renamed from: component5, reason: from getter */
    public final String getClassType() {
        return this.classType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getClassTypeName() {
        return this.classTypeName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getClassTypeIconUrl() {
        return this.classTypeIconUrl;
    }

    /* renamed from: component8, reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    /* renamed from: component9, reason: from getter */
    public final String getInstructorName() {
        return this.instructorName;
    }

    public final PickedForYouData copy(Boolean isFavorite, Boolean isDone, String classId, String className, String classType, String classTypeName, String classTypeIconUrl, String backgroundUrl, String instructorName, String instructorAvatarUrl, String duration, String description, String favoriteId, String videoId, String difficulty, List<PickedForYouAccessoryData> accessories, String musicGenre, String workoutType, Double publishTimeMillis, List<PickedForYouCollectionsData> collections) {
        return new PickedForYouData(isFavorite, isDone, classId, className, classType, classTypeName, classTypeIconUrl, backgroundUrl, instructorName, instructorAvatarUrl, duration, description, favoriteId, videoId, difficulty, accessories, musicGenre, workoutType, publishTimeMillis, collections);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickedForYouData)) {
            return false;
        }
        PickedForYouData pickedForYouData = (PickedForYouData) other;
        return Intrinsics.areEqual(this.isFavorite, pickedForYouData.isFavorite) && Intrinsics.areEqual(this.isDone, pickedForYouData.isDone) && Intrinsics.areEqual(this.classId, pickedForYouData.classId) && Intrinsics.areEqual(this.className, pickedForYouData.className) && Intrinsics.areEqual(this.classType, pickedForYouData.classType) && Intrinsics.areEqual(this.classTypeName, pickedForYouData.classTypeName) && Intrinsics.areEqual(this.classTypeIconUrl, pickedForYouData.classTypeIconUrl) && Intrinsics.areEqual(this.backgroundUrl, pickedForYouData.backgroundUrl) && Intrinsics.areEqual(this.instructorName, pickedForYouData.instructorName) && Intrinsics.areEqual(this.instructorAvatarUrl, pickedForYouData.instructorAvatarUrl) && Intrinsics.areEqual(this.duration, pickedForYouData.duration) && Intrinsics.areEqual(this.description, pickedForYouData.description) && Intrinsics.areEqual(this.favoriteId, pickedForYouData.favoriteId) && Intrinsics.areEqual(this.videoId, pickedForYouData.videoId) && Intrinsics.areEqual(this.difficulty, pickedForYouData.difficulty) && Intrinsics.areEqual(this.accessories, pickedForYouData.accessories) && Intrinsics.areEqual(this.musicGenre, pickedForYouData.musicGenre) && Intrinsics.areEqual(this.workoutType, pickedForYouData.workoutType) && Intrinsics.areEqual((Object) this.publishTimeMillis, (Object) pickedForYouData.publishTimeMillis) && Intrinsics.areEqual(this.collections, pickedForYouData.collections);
    }

    public int hashCode() {
        Boolean bool = this.isFavorite;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.isDone;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.classId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.className;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.classType;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.classTypeName;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.classTypeIconUrl;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.backgroundUrl;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.instructorName;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.instructorAvatarUrl;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.duration;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.description;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.favoriteId;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.videoId;
        int iHashCode14 = (iHashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.difficulty;
        int iHashCode15 = (iHashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        List<PickedForYouAccessoryData> list = this.accessories;
        int iHashCode16 = (iHashCode15 + (list == null ? 0 : list.hashCode())) * 31;
        String str14 = this.musicGenre;
        int iHashCode17 = (iHashCode16 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.workoutType;
        int iHashCode18 = (iHashCode17 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Double d = this.publishTimeMillis;
        int iHashCode19 = (iHashCode18 + (d == null ? 0 : d.hashCode())) * 31;
        List<PickedForYouCollectionsData> list2 = this.collections;
        return iHashCode19 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PickedForYouData(isFavorite=");
        sb.append(this.isFavorite).append(", isDone=").append(this.isDone).append(", classId=").append(this.classId).append(", className=").append(this.className).append(", classType=").append(this.classType).append(", classTypeName=").append(this.classTypeName).append(", classTypeIconUrl=").append(this.classTypeIconUrl).append(", backgroundUrl=").append(this.backgroundUrl).append(", instructorName=").append(this.instructorName).append(", instructorAvatarUrl=").append(this.instructorAvatarUrl).append(", duration=").append(this.duration).append(", description=");
        sb.append(this.description).append(", favoriteId=").append(this.favoriteId).append(", videoId=").append(this.videoId).append(", difficulty=").append(this.difficulty).append(", accessories=").append(this.accessories).append(", musicGenre=").append(this.musicGenre).append(", workoutType=").append(this.workoutType).append(", publishTimeMillis=").append(this.publishTimeMillis).append(", collections=").append(this.collections).append(')');
        return sb.toString();
    }

    public PickedForYouData(Boolean bool, Boolean bool2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List<PickedForYouAccessoryData> list, String str14, String str15, Double d, List<PickedForYouCollectionsData> list2) {
        this.isFavorite = bool;
        this.isDone = bool2;
        this.classId = str;
        this.className = str2;
        this.classType = str3;
        this.classTypeName = str4;
        this.classTypeIconUrl = str5;
        this.backgroundUrl = str6;
        this.instructorName = str7;
        this.instructorAvatarUrl = str8;
        this.duration = str9;
        this.description = str10;
        this.favoriteId = str11;
        this.videoId = str12;
        this.difficulty = str13;
        this.accessories = list;
        this.musicGenre = str14;
        this.workoutType = str15;
        this.publishTimeMillis = d;
        this.collections = list2;
    }

    public /* synthetic */ PickedForYouData(Boolean bool, Boolean bool2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List list, String str14, String str15, Double d, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : str12, (i & 16384) != 0 ? null : str13, (i & 32768) != 0 ? null : list, (i & 65536) != 0 ? null : str14, (i & 131072) != 0 ? null : str15, (i & 262144) != 0 ? null : d, (i & 524288) != 0 ? null : list2);
    }

    public final Boolean isFavorite() {
        return this.isFavorite;
    }

    public final Boolean isDone() {
        return this.isDone;
    }

    public final String getClassId() {
        return this.classId;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getClassType() {
        return this.classType;
    }

    public final String getClassTypeName() {
        return this.classTypeName;
    }

    public final String getClassTypeIconUrl() {
        return this.classTypeIconUrl;
    }

    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public final String getInstructorName() {
        return this.instructorName;
    }

    public final String getInstructorAvatarUrl() {
        return this.instructorAvatarUrl;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getFavoriteId() {
        return this.favoriteId;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String getDifficulty() {
        return this.difficulty;
    }

    public final List<PickedForYouAccessoryData> getAccessories() {
        return this.accessories;
    }

    public final String getMusicGenre() {
        return this.musicGenre;
    }

    public final String getWorkoutType() {
        return this.workoutType;
    }

    public final Double getPublishTimeMillis() {
        return this.publishTimeMillis;
    }

    public final List<PickedForYouCollectionsData> getCollections() {
        return this.collections;
    }
}
