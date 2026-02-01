package com.soletreadmills.sole_v2._data.classes;

import com.android.SdkConstants;
import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._type.ClassType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetFollowedCollectionApiData.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b&\b\u0087\b\u0018\u00002\u00020\u0001B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0005HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010+\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010,\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010&J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¼\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0015HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\u0011\u0010#R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\u0013\u0010#R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&¨\u0006;"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/FollowedCollectionData;", "", "backgroundUrl", "", "classTypes", "", "Lcom/soletreadmills/sole_v2/_type/ClassType;", SdkConstants.FD_CLASSES_OUTPUT, "Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", "collectionDescription", "collectionId", "collectionName", "durationMax", "durationMin", "favoriteId", "instructors", "Lcom/soletreadmills/sole_v2/_data/classes/FollowedCollectionInstructorsData;", "isFavorite", "", "isFollowed", "workoutAmount", "", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getBackgroundUrl", "()Ljava/lang/String;", "getClassTypes", "()Ljava/util/List;", "getClasses", "getCollectionDescription", "getCollectionId", "getCollectionName", "getDurationMax", "getDurationMin", "getFavoriteId", "getInstructors", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getWorkoutAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/classes/FollowedCollectionData;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FollowedCollectionData {
    public static final int $stable = 8;

    @SerializedName("background_url")
    private final String backgroundUrl;

    @SerializedName("class_types")
    private final List<ClassType> classTypes;

    @SerializedName(SdkConstants.FD_CLASSES_OUTPUT)
    private final List<ClassesData> classes;

    @SerializedName("collection_description")
    private final String collectionDescription;

    @SerializedName("collection_id")
    private final String collectionId;

    @SerializedName("collection_name")
    private final String collectionName;

    @SerializedName("duration_max")
    private final String durationMax;

    @SerializedName("duration_min")
    private final String durationMin;

    @SerializedName("favorite_id")
    private final String favoriteId;

    @SerializedName("instructors")
    private final List<FollowedCollectionInstructorsData> instructors;

    @SerializedName("is_favorite")
    private final Boolean isFavorite;

    @SerializedName("is_followed")
    private final Boolean isFollowed;

    @SerializedName("workout_amount")
    private final Integer workoutAmount;

    public FollowedCollectionData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public final List<FollowedCollectionInstructorsData> component10() {
        return this.instructors;
    }

    /* renamed from: component11, reason: from getter */
    public final Boolean getIsFavorite() {
        return this.isFavorite;
    }

    /* renamed from: component12, reason: from getter */
    public final Boolean getIsFollowed() {
        return this.isFollowed;
    }

    /* renamed from: component13, reason: from getter */
    public final Integer getWorkoutAmount() {
        return this.workoutAmount;
    }

    public final List<ClassType> component2() {
        return this.classTypes;
    }

    public final List<ClassesData> component3() {
        return this.classes;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCollectionDescription() {
        return this.collectionDescription;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCollectionId() {
        return this.collectionId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCollectionName() {
        return this.collectionName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDurationMax() {
        return this.durationMax;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDurationMin() {
        return this.durationMin;
    }

    /* renamed from: component9, reason: from getter */
    public final String getFavoriteId() {
        return this.favoriteId;
    }

    public final FollowedCollectionData copy(String backgroundUrl, List<? extends ClassType> classTypes, List<ClassesData> classes, String collectionDescription, String collectionId, String collectionName, String durationMax, String durationMin, String favoriteId, List<FollowedCollectionInstructorsData> instructors, Boolean isFavorite, Boolean isFollowed, Integer workoutAmount) {
        return new FollowedCollectionData(backgroundUrl, classTypes, classes, collectionDescription, collectionId, collectionName, durationMax, durationMin, favoriteId, instructors, isFavorite, isFollowed, workoutAmount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FollowedCollectionData)) {
            return false;
        }
        FollowedCollectionData followedCollectionData = (FollowedCollectionData) other;
        return Intrinsics.areEqual(this.backgroundUrl, followedCollectionData.backgroundUrl) && Intrinsics.areEqual(this.classTypes, followedCollectionData.classTypes) && Intrinsics.areEqual(this.classes, followedCollectionData.classes) && Intrinsics.areEqual(this.collectionDescription, followedCollectionData.collectionDescription) && Intrinsics.areEqual(this.collectionId, followedCollectionData.collectionId) && Intrinsics.areEqual(this.collectionName, followedCollectionData.collectionName) && Intrinsics.areEqual(this.durationMax, followedCollectionData.durationMax) && Intrinsics.areEqual(this.durationMin, followedCollectionData.durationMin) && Intrinsics.areEqual(this.favoriteId, followedCollectionData.favoriteId) && Intrinsics.areEqual(this.instructors, followedCollectionData.instructors) && Intrinsics.areEqual(this.isFavorite, followedCollectionData.isFavorite) && Intrinsics.areEqual(this.isFollowed, followedCollectionData.isFollowed) && Intrinsics.areEqual(this.workoutAmount, followedCollectionData.workoutAmount);
    }

    public int hashCode() {
        String str = this.backgroundUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ClassType> list = this.classTypes;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<ClassesData> list2 = this.classes;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.collectionDescription;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.collectionId;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.collectionName;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.durationMax;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.durationMin;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.favoriteId;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<FollowedCollectionInstructorsData> list3 = this.instructors;
        int iHashCode10 = (iHashCode9 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Boolean bool = this.isFavorite;
        int iHashCode11 = (iHashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isFollowed;
        int iHashCode12 = (iHashCode11 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.workoutAmount;
        return iHashCode12 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FollowedCollectionData(backgroundUrl=");
        sb.append(this.backgroundUrl).append(", classTypes=").append(this.classTypes).append(", classes=").append(this.classes).append(", collectionDescription=").append(this.collectionDescription).append(", collectionId=").append(this.collectionId).append(", collectionName=").append(this.collectionName).append(", durationMax=").append(this.durationMax).append(", durationMin=").append(this.durationMin).append(", favoriteId=").append(this.favoriteId).append(", instructors=").append(this.instructors).append(", isFavorite=").append(this.isFavorite).append(", isFollowed=");
        sb.append(this.isFollowed).append(", workoutAmount=").append(this.workoutAmount).append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FollowedCollectionData(String str, List<? extends ClassType> list, List<ClassesData> list2, String str2, String str3, String str4, String str5, String str6, String str7, List<FollowedCollectionInstructorsData> list3, Boolean bool, Boolean bool2, Integer num) {
        this.backgroundUrl = str;
        this.classTypes = list;
        this.classes = list2;
        this.collectionDescription = str2;
        this.collectionId = str3;
        this.collectionName = str4;
        this.durationMax = str5;
        this.durationMin = str6;
        this.favoriteId = str7;
        this.instructors = list3;
        this.isFavorite = bool;
        this.isFollowed = bool2;
        this.workoutAmount = num;
    }

    public /* synthetic */ FollowedCollectionData(String str, List list, List list2, String str2, String str3, String str4, String str5, String str6, String str7, List list3, Boolean bool, Boolean bool2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : list3, (i & 1024) != 0 ? null : bool, (i & 2048) != 0 ? null : bool2, (i & 4096) == 0 ? num : null);
    }

    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public final List<ClassType> getClassTypes() {
        return this.classTypes;
    }

    public final List<ClassesData> getClasses() {
        return this.classes;
    }

    public final String getCollectionDescription() {
        return this.collectionDescription;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final String getCollectionName() {
        return this.collectionName;
    }

    public final String getDurationMax() {
        return this.durationMax;
    }

    public final String getDurationMin() {
        return this.durationMin;
    }

    public final String getFavoriteId() {
        return this.favoriteId;
    }

    public final List<FollowedCollectionInstructorsData> getInstructors() {
        return this.instructors;
    }

    public final Boolean isFavorite() {
        return this.isFavorite;
    }

    public final Boolean isFollowed() {
        return this.isFollowed;
    }

    public final Integer getWorkoutAmount() {
        return this.workoutAmount;
    }
}
